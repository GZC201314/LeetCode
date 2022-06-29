package org.gzc.leetcode.model;

import java.util.Base64;

/**
 * @author GZC
 * @create 2022-06-29 21:45
 * @desc
 */
public class TinyURL {

    /**
     * Encodes a URL to a shortened URL.
     */
    public String encode(String longUrl) {
        int index = longUrl.indexOf('/',3);
        String url1 = longUrl.substring(0,index+1);
        String url2 = longUrl.substring(index+1);
        Base64.Encoder encoder = Base64.getEncoder();
        return url1+encoder.encodeToString(url2.getBytes());

    }

    /**
     * Decodes a shortened URL to its original URL.
     */
    public String decode(String shortUrl) {
        int index = shortUrl.indexOf('/',3);
        String url1 = shortUrl.substring(0,index+1);
        String url2 = shortUrl.substring(index+1);
        Base64.Decoder decoder = Base64.getDecoder();
        return url1+new String(decoder.decode(url2));
    }

}
