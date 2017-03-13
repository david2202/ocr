package au.com.auspost.deliveryocr.web.controller.rest;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchResult {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Ocr ocr;

    private List<Address> addresses = new ArrayList<>();

    public SearchResult(SolrResult solrResult, boolean ocr) {
        if (ocr) {
            this.ocr = new Ocr(solrResult.getResponseHeader().getParams().getQ());
        }
        buildAddresses(solrResult);
    }

    private void buildAddresses(SolrResult solrResult) {
        solrResult.getResponse().getDocs().forEach(doc -> {
            Address a = new Address();
            a.setDpid(doc.getDpid());
            a.setText(doc.getAddress());
            a.setRound(doc.getRoundid());
            a.setSectionSequenceNumber(doc.getSectionnum());
            a.setDpidSequenceNumber(doc.getSequence());
            a.setStem(doc.getVsrtFrameLabelNum());
            a.setGeo(new Geo(doc.getLatitude(), doc.getLongitude()));
            addresses.add(a);
        });
    }

    public Ocr getOcr() {
        return ocr;
    }

    public void setOcr(Ocr ocr) {
        this.ocr = ocr;
    }

    public List<Address> getAddresses() {
        return Collections.unmodifiableList(addresses);
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public class Ocr {
        private String text;

        public Ocr(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public class Address {
        private String text;
        private Integer dpid;
        private Integer round;
        private Integer sectionSequenceNumber;
        private Integer dpidSequenceNumber;
        private Integer stem;
        private Geo geo;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Integer getDpid() {
            return dpid;
        }

        public void setDpid(Integer dpid) {
            this.dpid = dpid;
        }

        public Integer getRound() {
            return round;
        }

        public void setRound(Integer round) {
            this.round = round;
        }

        public Integer getSectionSequenceNumber() {
            return sectionSequenceNumber;
        }

        public void setSectionSequenceNumber(Integer sectionSequenceNumber) {
            this.sectionSequenceNumber = sectionSequenceNumber;
        }

        public Integer getDpidSequenceNumber() {
            return dpidSequenceNumber;
        }

        public void setDpidSequenceNumber(Integer dpidSequenceNumber) {
            this.dpidSequenceNumber = dpidSequenceNumber;
        }

        public Integer getStem() {
            return stem;
        }

        public void setStem(Integer stem) {
            this.stem = stem;
        }

        public Geo getGeo() {
            return geo;
        }

        public void setGeo(Geo geo) {
            this.geo = geo;
        }
    }

    public class Geo {
        private BigDecimal latitude;
        private BigDecimal longitude;

        public Geo(BigDecimal latitude, BigDecimal longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public BigDecimal getLatitude() {
            return latitude;
        }

        public void setLatitude(BigDecimal latitude) {
            this.latitude = latitude;
        }

        public BigDecimal getLongitude() {
            return longitude;
        }

        public void setLongitude(BigDecimal longitude) {
            this.longitude = longitude;
        }
    }
}
