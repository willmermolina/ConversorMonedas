package com.willmer.convertidor.calculos;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class EncoderUri {
    public static String encodeUri(String givenUri){
        String encodeUri = givenUri;
        try {
            encodeUri = URLEncoder.encode(givenUri, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeUri;
    }
}
