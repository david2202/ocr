package au.com.auspost.deliveryocr.web.controller.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SolrResponse {
    private Integer numFound;
    private Integer start;
    private BigDecimal maxScore;
    private List<SolrDocs> docs = new ArrayList<>();

    public Integer getNumFound() {
        return numFound;
    }

    public void setNumFound(Integer numFound) {
        this.numFound = numFound;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public BigDecimal getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(BigDecimal maxScore) {
        this.maxScore = maxScore;
    }

    public List<SolrDocs> getDocs() {
        return docs;
    }

    public void setDocs(List<SolrDocs> docs) {
        this.docs = docs;
    }
}