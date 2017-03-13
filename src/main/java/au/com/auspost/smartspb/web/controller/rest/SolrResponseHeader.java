package au.com.auspost.smartspb.web.controller.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SolrResponseHeader {
    private SolrParams params;

    public SolrParams getParams() {
        return params;
    }

    public void setParams(SolrParams params) {
        this.params = params;
    }
}
