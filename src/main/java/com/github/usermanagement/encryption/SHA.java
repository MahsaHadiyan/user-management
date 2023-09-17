package com.github.usermanagement.encryption;

import java.security.MessageDigest;

/**
 * Created by Amirsam on 9/21/2016.
 */
public class SHA {
    public static String getSHA256(String text) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(text.getBytes());
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    public static String getSHA512(String text) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(text.getBytes());
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();

    }
    private SHA()
    {

    }
}
