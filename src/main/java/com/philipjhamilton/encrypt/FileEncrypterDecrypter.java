package com.philipjhamilton.encrypt;

import javax.crypto.SecretKey;

public class FileEncrypterDecrypter {

    private SecretKey secretKey;
    private String transformation;

    public FileEncrypterDecrypter(SecretKey secKey, String transformation) {
        this.secretKey = secKey;
        this.transformation = transformation;
    }

    public void encrypt(String originalContent, String s) {
    }

    public String decrypt(String s) {
    }
}
