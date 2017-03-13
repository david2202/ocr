package au.com.auspost.smartspb.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OcrSpaceResponse {
    @JsonProperty("ParsedResults")
    private List<OcrSpaceParsedResult> parsedResults = new ArrayList<>();

    @JsonProperty("OCRExitCode")
    private String ocrExitCode;

    @JsonProperty("IsErroredOnProcessing")
    private Boolean isErroredOnProcessing;

    @JsonProperty("ErrorMessage")
    private List<String> errorMessages = new ArrayList<>();

    @JsonProperty("ErrorDetails")
    private String errorDetails;

    @JsonProperty("ProcessingTimeInMilliseconds")
    private String processingTimeInMilliseconds;

    public List<OcrSpaceParsedResult> getParsedResults() {
        return parsedResults;
    }

    public void setParsedResults(List<OcrSpaceParsedResult> parsedResults) {
        this.parsedResults = parsedResults;
    }

    public String getOcrExitCode() {
        return ocrExitCode;
    }

    public void setOcrExitCode(String ocrExitCode) {
        this.ocrExitCode = ocrExitCode;
    }

    public Boolean getErroredOnProcessing() {
        return isErroredOnProcessing;
    }

    public void setErroredOnProcessing(Boolean erroredOnProcessing) {
        isErroredOnProcessing = erroredOnProcessing;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }

    public String getProcessingTimeInMilliseconds() {
        return processingTimeInMilliseconds;
    }

    public void setProcessingTimeInMilliseconds(String processingTimeInMilliseconds) {
        this.processingTimeInMilliseconds = processingTimeInMilliseconds;
    }
}
