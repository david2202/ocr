package au.com.auspost.smartspb.web.controller.rest;

import au.com.auspost.smartspb.service.OcrSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(path = "/rest")
public class AddressRestController {

    @Autowired
    private OcrSpaceService ocrService;

    @Value("${deliveryocr.solr.url}")
    private String solrURL;

    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public SearchResult search(@RequestParam(value = "roundId", required = false) Integer roundId,
                               @RequestParam(value = "imageBase64", required = false) String imageBase64,
                               @RequestParam(value = "query", required = false) String query,
                               HttpServletResponse response) throws IOException {
        String lookupValue;
        boolean ocr = false;

        if (imageBase64 != null) {
            lookupValue = ocrImage(imageBase64);
            ocr = true;
        } else if (query != null) {
            lookupValue = query;
        } else {
            // Illegal operation
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().append("Must pass imageBase64 or query parameter");
            return null;
        }

        SolrResult result = lookupAddress(lookupValue, roundId);
        return new SearchResult(result, ocr);
    }

    private String ocrImage(String imageBase64) {
        //TODO Check for errors or no result
        return ocrService.ocr(imageBase64);
    }

    private SolrResult lookupAddress(String lookupValue, Integer roundId) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(solrURL)
                .queryParam("defType", "edismax")
                .queryParam("fl", "*,score") // Field list
                .queryParam("indent", "on")
                .queryParam("q", lookupValue) // query
                .queryParam("qf", "address^10.0 addressPhonetic^5.0") // query fields
                .queryParam("pf","address^10.0")
                .queryParam("ps", 1) // phrase slop
                .queryParam("start", 0)
                .queryParam("rows", 10)
                .queryParam("wt", "json");
        if (roundId != null) {
            builder.queryParam("fq", "roundid:" + roundId);
        }
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(builder.buildAndExpand(builder.build().toUri()).toUri(),  SolrResult.class);
    }
}
