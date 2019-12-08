package com.shortenedUrl.controller;

import com.shortenedUrl.dto.LongUrlDto;
import com.shortenedUrl.dto.ShortUrlDto;
import com.shortenedUrl.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Amisha Patel
 */

@RestController
@RequestMapping("/api/v1/url")
public class UrlShortController {

    @Autowired
    private ShortUrlService urlService;

    @PostMapping("/short")
    public ResponseEntity<ShortUrlDto> shortUrl(@Validated @RequestBody LongUrlDto longUrlDto) {
        return ResponseEntity.ok(new ShortUrlDto(urlService.shortUrl(longUrlDto.getLongUrl())));
    }

}
