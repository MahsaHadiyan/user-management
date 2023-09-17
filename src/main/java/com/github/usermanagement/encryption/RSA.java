package com.github.usermanagement.encryption;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;

/**
 * Created by Amirsam on 9/21/2016.
 */
public class RSA {

    public static HashMap getRSAKeys() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair kp = keyGen.genKeyPair();
        PublicKey publicKey = kp.getPublic();
        PrivateKey privateKey = kp.getPrivate();
        HashMap keys = new HashMap();
        keys.put("PublicKey", publicKey);
        keys.put("PrivateKey", privateKey);
        return keys;
    }

    public static byte[] getRSAEncrypt(PublicKey publicKey, String clearText) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(clearText.getBytes());
    }

    public static String getRSADecrypt(PrivateKey privateKey, byte[] encrypt) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(encrypt));
    }

    private RSA()
    {

    }

}
