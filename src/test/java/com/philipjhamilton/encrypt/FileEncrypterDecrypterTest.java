package com.philipjhamilton.encrypt;

import org.junit.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FileEncrypterDecrypterTest {

    @Test
    public void whenEncryptingINtoFile_andDecryptingFileAgain_thenOriginalStringIsReturned(){
        String originalContent = "This is a TEST!";

        try {
            SecretKey secKey = KeyGenerator.getInstance("AES").generateKey();

            FileEncrypterDecrypter fileEncDec = new FileEncrypterDecrypter(secKey, "AES/CBC/PKCS5Padding");

            fileEncDec.encrypt(originalContent, "baz.enc");

            String decryptedOutput = fileEncDec.decrypt("baz.enc");

            assertThat(decryptedOutput, is(originalContent));


        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }


    }

}
