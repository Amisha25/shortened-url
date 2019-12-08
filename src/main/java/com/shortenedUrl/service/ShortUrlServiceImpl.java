package com.shortenedUrl.service;

import com.shortenedUrl.dao.ShortUrlRepository;
import com.shortenedUrl.model.ShortUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Amisha Patel
 */
@Transactional
@Service
public class ShortUrlServiceImpl implements ShortUrlService {

    @Value("${base.url}")
    private String BASE_URL;

    @Value("${short.url.prefix}")
    private String SHORT_URL_PREFIX;

    @Autowired
    private ShortUrlRepository shortUrlRepository;

    @Autowired
    private IdConverterService idConverterService;

    @Override
    public String shortUrl(String longUrl) {
        return BASE_URL.concat(SHORT_URL_PREFIX)
                .concat(shortUrlRepository.findByLongUrl(longUrl).orElseGet(() -> saveAndShort(longUrl)).getShortKey());
    }

    private ShortUrl saveAndShort(String longUrl) {
        ShortUrl url = shortUrlRepository.save(new ShortUrl(longUrl));
        String shortKey = idConverterService.encode(url.getId());

        url.setShortKey(shortKey);

        return url;
    }

    @Override
    public Optional<ShortUrl> getShortUrl(String shortKey) {
        return shortUrlRepository.findById(idConverterService.decode(shortKey));
    }
}
