package com.linkedpipes.etl.storage.template;

import com.linkedpipes.etl.storage.rdf.PojoLoader;
import org.openrdf.model.IRI;
import org.openrdf.model.Value;
import org.openrdf.model.impl.SimpleValueFactory;

/**
 * Represent a thin template that can modify basic component
 * properties and configuration.
 *
 * @author Petr Škoda
 */
class ReferenceTemplate extends BaseTemplate implements PojoLoader.Loadable {

    public static final IRI TYPE;

    static {
        TYPE = SimpleValueFactory.getInstance().createIRI(
                "http://linkedpipes.com/ontology/Template");
    }

    private String template;

    public ReferenceTemplate() {
    }

    @Override
    public void loadIri(String iri) {
        this.iri = iri;
    }

    @Override
    public PojoLoader.Loadable load(String predicate, Value value)
            throws PojoLoader.CantLoadException {
        switch (predicate) {
            case "http://linkedpipes.com/ontology/template":
                template = value.stringValue();
                break;
        }
        return null;
    }

    @Override
    public String getIri() {
        return iri;
    }

}