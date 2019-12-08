package com.shortenedUrl.controller;

import com.shortenedUrl.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Amisha Patel
 */

@Controller
@RequestMapping("/short")
public class UrlRedirectController {

    @Autowired
    private ShortUrlService urlService;

    @GetMapping("/{shortStr}")
    public ModelAndView redirectToLongUrl(@PathVariable("shortStr") String shortStr) {
        return urlService.getShortUrl(shortStr).map(shortUrl -> new ModelAndView("redirect:" + shortUrl.getLongUrl()))
                .orElseGet(() -> new ModelAndView("short_not_found"));
    }
}
