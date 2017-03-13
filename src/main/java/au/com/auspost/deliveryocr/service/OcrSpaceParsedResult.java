package au.com.auspost.deliveryocr.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OcrSpaceParsedResult {
    @JsonProperty("FileParseExtCode")
    private Integer fileParseExtCode;
    @JsonProperty("ParsedText")
    private String parsedText;
    @JsonProperty("ErrorMessage")
    private String errorMessage;
    @JsonProperty("ErrorDetails")
    private String errorDetails;

    public Integer getFileParseExtCode() {
        return fileParseExtCode;
    }

    public void setFileParseExtCode(Integer fileParseExtCode) {
        this.fileParseExtCode = fileParseExtCode;
    }

    public String getParsedText() {
        return parsedText;
    }

    public void setParsedText(String parsedText) {
        this.parsedText = parsedText;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }
}
