package net.cobaltonline.encodedchat.codecs;

import java.util.Base64;

public class Base64Codec implements Codec {

    public static final String id = "base64";

    @Override
    public String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }

    @Override
    public String decode(String message) {
        return new String(Base64.getDecoder().decode(message.getBytes()));
    }
}
