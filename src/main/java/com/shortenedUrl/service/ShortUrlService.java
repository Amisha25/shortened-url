package com.shortenedUrl.service;

import com.shortenedUrl.model.ShortUrl;

import java.util.Optional;

/**
 * @author Amisha Patel
 */
public interface ShortUrlService {

    String shortUrl(String longUrl);

    Optional<ShortUrl> getShortUrl(String shortKey);
}
