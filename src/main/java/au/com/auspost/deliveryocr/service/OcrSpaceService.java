package au.com.auspost.deliveryocr.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class OcrSpaceService {
    @Value("${deliveryocr.ocrspace.url}")
    private String ocrSpaceUrl;

    public String ocr(String base64Image) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("apikey", "72fbaecdea88957");

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("language", "eng");
        map.add("isOverlayRequired", "false");
        map.add("base64Image", base64Image);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        OcrSpaceResponse response = restTemplate.postForObject(ocrSpaceUrl, request, OcrSpaceResponse.class);

        return response.getParsedResults().get(0).getParsedText();
    }
}
