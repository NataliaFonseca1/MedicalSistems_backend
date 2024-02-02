package com.example.Clinica;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class CPFEncryption {
    private static final String ALGORITHM = "AES";
    private static SecretKey secretKey;

    public static void generateKey() throws Exception {

        secretKey = KeyGenerator.getInstance(ALGORITHM).generateKey();
    }
public static byte[] encrypt(String data) throws Exception {
    Cipher cipher = Cipher.getInstance(ALGORITHM);
    cipher.init(Cipher.ENCRYPT_MODE, secretKey);
    return cipher.doFinal(data.getBytes());
}

public static String decrypt(byte[] encryptedData) throws Exception {
    Cipher cipher = Cipher.getInstance(ALGORITHM);
    cipher.init(Cipher.DECRYPT_MODE, secretKey);
    return new String(cipher.doFinal(encryptedData));
}
}