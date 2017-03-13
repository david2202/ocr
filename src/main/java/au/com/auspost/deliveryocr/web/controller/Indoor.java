package au.com.auspost.deliveryocr.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Indoor {

    @RequestMapping(path = "/indoor", method = RequestMethod.GET)
    public String get() {
        return "indoor";
    }
}
