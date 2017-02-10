package com.linkedpipes.etl.executor.component;

import com.linkedpipes.etl.executor.ExecutorException;
import com.linkedpipes.etl.executor.api.v1.LpException;
import com.linkedpipes.etl.executor.api.v1.component.ManageableComponent;
import com.linkedpipes.etl.executor.api.v1.component.SequentialExecution;
import com.linkedpipes.etl.executor.api.v1.dataunit.DataUnit;
import com.linkedpipes.etl.executor.component.configuration.Configuration;
import com.linkedpipes.etl.executor.dataunit.DataUnitManager;
import com.linkedpipes.etl.executor.execution.Execution;
import com.linkedpipes.etl.executor.logging.LoggerFacade;
import com.linkedpipes.etl.executor.pipeline.Pipeline;
import com.linkedpipes.etl.executor.pipeline.PipelineModel;
import com.linkedpipes.etl.rdf.utils.RdfSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.Map;

/**
 * The component is initialized with data units and configuration in
 * the initialization phase.
 *
 * In the execution phase the execution interface is detected and
 * component is executed.
 */
class ExecuteComponent implements ComponentExecutor {

    private static final Logger LOG =
            LoggerFactory.getLogger(ExecuteComponent.class);

    private final Pipeline pipeline;

    private final PipelineModel.Component pplComponent;

    private final Execution.Component execComponent;

    private final ManageableComponent instance;

    private final ExecutionContext context;

    private final Execution execution;

    public ExecuteComponent(
            Pipeline pipeline,
            Execution execution,
            PipelineModel.Component component,
            ManageableComponent instance) {
        this.pipeline = pipeline;
        this.pplComponent = component;
        this.execComponent = execution.getComponent(component);
        this.instance = instance;
        this.execution = execution;
        //
        context = new ExecutionContext(execution,
                execution.getComponent(component));
    }

    @Override
    public boolean execute(DataUnitManager dataUnitManager) {
        try {
            execution.onComponentInitialize(execComponent);
            MDC.remove(LoggerFacade.SYSTEM_MDC);
            final Map<String, DataUnit> dataUnits =
                    dataUnitManager.onComponentWillExecute(execComponent);
            initialize(dataUnits);
            MDC.put(LoggerFacade.SYSTEM_MDC, null);
            execution.onComponentBegin(execComponent);
            MDC.remove(LoggerFacade.SYSTEM_MDC);
            execute();
            MDC.put(LoggerFacade.SYSTEM_MDC, null);
        } catch (ExecutorException ex) {
            try {
                dataUnitManager.onComponentDidExecute(execComponent);
            } catch (ExecutorException e) {
                LOG.error("Can't save data unit after component failed.", e);
            }
            execution.onComponentFailed(execComponent, ex);
            return false;
        }
        execution.onComponentEnd(execComponent);
        try {
            dataUnitManager.onComponentDidExecute(execComponent);
        } catch (ExecutorException ex) {
            execution.onCantSaveDataUnits(execComponent, ex);
            return false;
        }
        return true;
    }

    @Override
    public void cancel() {
        context.cancel();
    }

    public void initialize(Map<String, DataUnit> dataUnits)
            throws ExecutorException {
        if (instance == null) {
            throw new ExecutorException("The component instance is null: {}",
                    pplComponent.getIri());
        }
        try {
            instance.initialize(dataUnits, context);
        } catch (LpException ex) {
            throw new ExecutorException("Can't bindToPipeline component.", ex);
        }
        configureComponent();
    }

    private void execute() throws ExecutorException {
        if (instance instanceof SequentialExecution) {
            final SequentialExecution executable =
                    (SequentialExecution) instance;
            try {
                executable.execute();
            } catch (LpException ex) {
                throw new ExecutorException("Component execution failed.", ex);
            }
        } else {

            throw new ExecutorException("Unknown execution interface.");
        }
    }

    /**
     * Prepare configuration for this component and load the configuration
     * into the component.
     */
    private void configureComponent() throws ExecutorException {
        final ManageableComponent.RuntimeConfiguration runtimeConfig;
        try {
            runtimeConfig = instance.getRuntimeConfiguration();
        } catch (LpException ex) {
            throw new ExecutorException("Can't get runtime configuration.", ex);
        }
        final String configGraph =
                pplComponent.getIri() + "/configuration/effective";
        final RdfSource.TypedTripleWriter writer = pipeline.setConfiguration(
                pplComponent, configGraph);
        if (runtimeConfig == null) {
            Configuration.prepareConfiguration(configGraph,
                    pplComponent, null, null, writer, pipeline);
        } else {
            Configuration.prepareConfiguration(configGraph, pplComponent,
                    runtimeConfig.getSource(), runtimeConfig.getGraph(),
                    writer, pipeline);
        }
        try {
            instance.loadConfiguration(configGraph, pipeline.getSource());
        } catch (LpException ex) {
            throw new ExecutorException(
                    "Can't load component configuration", ex);
        }
    }

}
