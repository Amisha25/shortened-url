package com.shortenedUrl.service;

/**
 * @author Amisha Patel
 */
public interface IdConverterService {

    String encode(long num);

    long decode(String shortKey);
}
