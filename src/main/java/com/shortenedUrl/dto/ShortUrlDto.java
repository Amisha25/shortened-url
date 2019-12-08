package com.shortenedUrl.dto;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;

/**
 * @author Amisha Patel
 */
public class ShortUrlDto {

    @NotEmpty(message = "{val.err.short.url.not.empty.or.null}")
    @URL(message = "{val.err.short.url.invalid}")
    private String shortUrl;

    public ShortUrlDto() {
    }

    public ShortUrlDto(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
