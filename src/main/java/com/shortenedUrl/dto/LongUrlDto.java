package com.shortenedUrl.dto;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;

/**
 * @author Amisha Patel
 */
public class LongUrlDto {

    @NotEmpty(message = "{val.err.long.url.not.empty.or.null}")
    @URL(message = "{val.err.long.url.invalid}")
    private String longUrl;

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
}
