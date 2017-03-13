package au.com.auspost.deliveryocr.web.controller.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SolrResult {
    private SolrResponseHeader responseHeader;
    private SolrResponse response;

    public SolrResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(SolrResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public SolrResponse getResponse() {
        return response;
    }

    public void setResponse(SolrResponse response) {
        this.response = response;
    }


}
