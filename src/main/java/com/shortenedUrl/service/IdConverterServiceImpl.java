package com.shortenedUrl.service;

import org.springframework.stereotype.Service;

/**
 * @author Amisha Patel
 */
@Service
public class IdConverterServiceImpl implements IdConverterService {

    private static final String POSSIBLE_ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final long BASE = POSSIBLE_ALPHABET.length();

    /**
     * Function to generate a shortKey from integer ID
     */
    @Override
    public String encode(long id) {
        StringBuilder shortKey = new StringBuilder();
        while (id > 0) {
            shortKey.insert(0, POSSIBLE_ALPHABET.charAt((int) (id % BASE)));
            id = id / BASE;
        }
        return shortKey.toString();
    }

    /**
     * Function to get integer ID back from a shortKey
     */
    @Override
    public long decode(String shortKey) {
        long num = 0;
        for (int i = 0; i < shortKey.length(); i++) {
            num = num * BASE + POSSIBLE_ALPHABET.indexOf(shortKey.charAt(i));
        }
        return num;
    }
}
