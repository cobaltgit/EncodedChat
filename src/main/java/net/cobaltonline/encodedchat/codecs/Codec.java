package net.cobaltonline.encodedchat.codecs;

public interface Codec {
    public static final String id = null;
    public String encode(String message);
    public String decode(String message);
}
