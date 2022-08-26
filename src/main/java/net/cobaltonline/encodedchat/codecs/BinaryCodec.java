package net.cobaltonline.encodedchat.codecs;

public class BinaryCodec implements Codec {

    public static final String id = "binary";

    @Override
    public String encode(String message) {
        StringBuilder sb = new StringBuilder();
        char[] chars = message.toCharArray();
        for (char c : chars) {
            String formattedBinary = String.format("%8s", Integer.toBinaryString(c));
            sb.append(formattedBinary.replaceAll(" ", "0") + " ");
        }
        return sb.toString();
    }

    @Override
    public String decode(String message) {
        StringBuilder sb = new StringBuilder();
        for (String part : message.split(" ")) {
            int code = Integer.parseInt(part, 2);
            sb.append(Character.toString(code));
        }
        return sb.toString();
    }
}
