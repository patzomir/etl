package com.linkedpipes.plugin.loader.lodCloud;

import com.linkedpipes.etl.executor.api.v1.rdf.RdfToPojo;

import java.util.Collection;
import java.util.LinkedList;

@RdfToPojo.Type(iri = LodCloudConfigVocabulary.CONFIG_CLASS)
public class LodCloudConfiguration {

    public Topics getTopic() {
        return topic;
    }

    public void setTopic(Topics topic) {
        this.topic = topic;
    }

    public boolean isLimitedSparql() {
        return limitedSparql;
    }

    public void setLimitedSparql(boolean limitedSparql) {
        this.limitedSparql = limitedSparql;
    }

    public boolean isLodcloudNolinks() {
        return lodcloudNolinks;
    }

    public void setLodcloudNolinks(boolean lodcloudNolinks) {
        this.lodcloudNolinks = lodcloudNolinks;
    }

    public boolean isLodcloudUnconnected() {
        return lodcloudUnconnected;
    }

    public void setLodcloudUnconnected(boolean lodcloudUnconnected) {
        this.lodcloudUnconnected = lodcloudUnconnected;
    }

    public boolean isLodcloudNeedsInfo() {
        return lodcloudNeedsInfo;
    }

    public void setLodcloudNeedsInfo(boolean lodcloudNeedsInfo) {
        this.lodcloudNeedsInfo = lodcloudNeedsInfo;
    }

    public boolean isLodcloudNeedsFixing() {
        return lodcloudNeedsFixing;
    }

    public void setLodcloudNeedsFixing(boolean lodcloudNeedsFixing) {
        this.lodcloudNeedsFixing = lodcloudNeedsFixing;
    }

    public boolean isVersionGenerated() {
        return versionGenerated;
    }

    public void setVersionGenerated(boolean versionGenerated) {
        this.versionGenerated = versionGenerated;
    }

    public LicenseMetadataTags getLicenseMetadataTag() {
        return licenseMetadataTag;
    }

    public void setLicenseMetadataTag(LicenseMetadataTags licenseMetadataTag) {
        this.licenseMetadataTag = licenseMetadataTag;
    }

    public ProvenanceMetadataTags getProvenanceMetadataTag() {
        return provenanceMetadataTag;
    }

    public void setProvenanceMetadataTag(ProvenanceMetadataTags provenanceMetadataTag) {
        this.provenanceMetadataTag = provenanceMetadataTag;
    }

    public PublishedTags getPublishedTag() {
        return publishedTag;
    }

    public void setPublishedTag(PublishedTags publishedTag) {
        this.publishedTag = publishedTag;
    }

    public VocabMappingsTags getVocabMappingTag() {
        return vocabMappingTag;
    }

    public void setVocabMappingTag(VocabMappingsTags vocabMappingTag) {
        this.vocabMappingTag = vocabMappingTag;
    }

    public VocabTags getVocabTag() {
        return vocabTag;
    }

    public void setVocabTag(VocabTags vocabTag) {
        this.vocabTag = vocabTag;
    }

    public String getApiUri() {
        return apiUri;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Licenses getLicense_id() {
        return license_id;
    }

    public void setLicense_id(Licenses license_id) {
        this.license_id = license_id;
    }

    public String getOrgID() {
        return orgID;
    }

    public void setOrgID(String orgID) {
        this.orgID = orgID;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getSparql_graph_name() {
        return sparql_graph_name;
    }

    public void setSparql_graph_name(String sparql_graph_name) {
        this.sparql_graph_name = sparql_graph_name;
    }

    public Collection<String> getVocabularies() {
        return vocabularies;
    }

    public void setVocabularies(Collection<String> vocabularies) {
        this.vocabularies = vocabularies;
    }

    public Collection<String> getAdditionalTags() {
        return additionalTags;
    }

    public void setAdditionalTags(Collection<String> additionalTags) {
        this.additionalTags = additionalTags;
    }

    public Collection<LinkCount> getLinks() {
        return links;
    }

    public void setLinks(Collection<LinkCount> links) {
        this.links = links;
    }

    public Collection<MappingFile> getMappingFiles() {
        return mappingFiles;
    }

    public void setMappingFiles(Collection<MappingFile> mappingFiles) {
        this.mappingFiles = mappingFiles;
    }

    public String getSparqlEndpointName() {
        return sparqlEndpointName;
    }

    public void setSparqlEndpointName(String sparqlEndpointName) {
        this.sparqlEndpointName = sparqlEndpointName;
    }

    public String getSparqlEndpointDescription() {
        return sparqlEndpointDescription;
    }

    public void setSparqlEndpointDescription(String sparqlEndpointDescription) {
        this.sparqlEndpointDescription = sparqlEndpointDescription;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getDatasetID() {
        return datasetID;
    }

    public void setDatasetID(String datasetID) {
        this.datasetID = datasetID;
    }

    public static class LinkCount {
        private String targetDataset;
        private Long linkCount;
        public LinkCount() {
            targetDataset = "";
            linkCount = new Long(0);
        }
        public LinkCount(String s, Long count) {
            targetDataset = s;
            linkCount = new Long(count);
        }
        public String getTargetDataset() {
            return targetDataset;
        }
        public void setTargetDataset(String targetDataset) {
            this.targetDataset = targetDataset;
        }
        public Long getLinkCount() {
            return linkCount;
        }
        public void setLinkCount(Long linkCount) {
            this.linkCount = linkCount;
        }
    }

    public static class MappingFile {
        private MappingFormats mappingFormat;
        private String mappingFile;
        public MappingFile() {
            setMappingFormat(MappingFormats.OWL);
            setMappingFile("");
        }
        public MappingFile(MappingFormats format, String file) {
            setMappingFormat(format);
            setMappingFile(file);
        }
        public String getMappingFile() {
            return mappingFile;
        }
        public void setMappingFile(String mappingFile) {
            this.mappingFile = mappingFile;
        }
        public MappingFormats getMappingFormat() {
            return mappingFormat;
        }
        public void setMappingFormat(MappingFormats mappingFormat) {
            this.mappingFormat = mappingFormat;
        }
    }

    public enum MappingFormats {
        RDFS, OWL, SKOS, R2R, RIF
    }

    public enum VocabTags {
        NoProprietaryVocab {
            public String toString() {
                return "no-proprietary-vocab";
            }
        },
        DerefVocab {
            public String toString() {
                return "deref-vocab";
            }
        },
        NoDerefVocab {
            public String toString() {
                return "no-deref-vocab";
            }
        }
    }

    public enum VocabMappingsTags {
        VocabMappings {
            public String toString() {
                return "vocab-mappings";
            }
        },
        NoVocabMappings {
            public String toString() {
                return "no-vocab-mappings";
            }
        }
    }

    public enum ProvenanceMetadataTags {
        ProvenanceMetadata {
            public String toString() {
                return "provenance-metadata";
            }
        },
        NoProvenanceMetadata {
            public String toString() {
                return "no-provenance-metadata";
            }
        }
    }

    public enum LicenseMetadataTags {
        LicenseMetadata {
            public String toString() {
                return "license-metadata";
            }
        },
        NoLicenseMetadata {
            public String toString() {
                return "no-license-metadata";
            }
        }
    }

    public enum PublishedTags {
        PublishedByProducer {
            public String toString() {
                return "published-by-producer";
            }
        },
        PublishedByThirdParty {
            public String toString() {
                return "published-by-third-party";
            }
        }
    }

    public enum Topics {media, geographic, lifesciences, publications, government, ecommerce, socialweb, usergeneratedcontent, schemata, crossdomain } ;

    public enum Licenses {
        pddl {
            //Open Data Commons Public Domain Dedication and License (PDDL)
            //http://opendefinition.org/licenses/odc-pddl
            public String toString() {
                return "odc-pddl" ;
            }
        },
        ccby {
            //Creative Commons Attribution
            //http://opendefinition.org/licenses/cc-by
            public String toString() {
                return "cc-by" ;
            }
        },
        ccbysa {
            //Creative Commons Attribution Share-Alike
            //http://opendefinition.org/licenses/cc-by-sa
            public String toString() {
                return "cc-by-sa" ;
            }
        },
        cczero {
            //Creative Commons CCZero
            //http://opendefinition.org/licenses/cc-zero
            public String toString() {
                return "cc-zero" ;
            }
        },
        ccnc {
            //Creative Commons Non-Commercial (Any)
            public String toString() {
                return "cc-nc" ;
            }
        },
        gfdl {
            //GNU Free Documentation License
            public String toString() {
                return "cc-nc" ;
            }
        },
        notspecified {
            //License Not Specified
            public String toString() {
                return "cc-nc" ;
            }
        },
        odcby {
            //Open Data Commons Attribution License
            //http://opendefinition.org/licenses/odc-by
            public String toString() {
                return "odc-by" ;
            }
        },
        odcodbl {
            //Open Data Commons Open Database License (ODbL)
            //http://www.opendefinition.org/licenses/odc-odbl
            public String toString() {
                return "odc-odbl" ;
            }
        },
        otherat {
            //Other (Attribution)
            public String toString() {
                return "other-at" ;
            }
        },
        othernc {
            //Other (Non-Commercial)
            public String toString() {
                return "other-nc" ;
            }
        },
        otherclosed {
            //Other (Not Open)
            public String toString() {
                return "other-closed" ;
            }
        },
        otheropen {
            //Other (Open)
            public String toString() {
                return "other-open" ;
            }
        },
        otherpd {
            //Other (Public Domain)
            public String toString() {
                return "other-pd" ;
            }
        },
        ukogl {
            //UK Open Government Licence (OGL)
            //http://reference.data.gov.uk/id/open-government-licence
            public String toString() {
                return "uk-ogl" ;
            }
        }
    }

    private Topics topic;

    private boolean limitedSparql;

    private boolean lodcloudNolinks;

    private boolean lodcloudUnconnected ;

    private boolean lodcloudNeedsInfo;

    private boolean lodcloudNeedsFixing;

    private boolean versionGenerated;

    private LicenseMetadataTags licenseMetadataTag ;

    private ProvenanceMetadataTags provenanceMetadataTag;

    private PublishedTags publishedTag;

    private VocabMappingsTags vocabMappingTag;

    private VocabTags vocabTag;

    private final String apiUri = "https://datahub.io/api/3/action";

    private String version ;

    private Licenses license_id ;

    private String orgID ;

    private String shortname ;

    private String namespace ;

    private String sparql_graph_name ;

    private Collection<String> vocabularies = new LinkedList<>();

    private Collection<String> additionalTags = new LinkedList<>();

    private Collection<LinkCount> links = new LinkedList<>();

    private Collection<MappingFile> mappingFiles = new LinkedList<>();

    private String sparqlEndpointName ;

    private String sparqlEndpointDescription ;

    @RdfToPojo.Property(iri = LodCloudConfigVocabulary.API_KEY)
    private String apiKey;

    @RdfToPojo.Property(iri = LodCloudConfigVocabulary.DATASET_ID)
    private String datasetID;

    public LodCloudConfiguration() {
    }

}
