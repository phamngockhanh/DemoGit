/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Admin
 */
public class MD5 {

    public String getMd5(String input) {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
 public String MD5ToString(String plain) {
    try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.reset();
        md.update(plain.getBytes());
        byte[] digest = md.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        String hashtext = bigInt.toString(16);
        // Now we need to zero pad it if you actually want the full 32 chars.
        while(hashtext.length() < 32 ){
            hashtext = "0"+hashtext;
        }
        return plain;
    } catch (Exception e) {
        System.out.println("Cannot encrypt String to Hash");
        e.printStackTrace();
    }
    return null;
}
 public static String encrypt(String source) {
   String md5 = null;
   try {
         MessageDigest mdEnc = MessageDigest.getInstance("MD5"); //Encryption algorithm
         mdEnc.update(source.getBytes(), 0, source.length());
         md5 = new BigInteger(1, mdEnc.digest()).toString(16); // Encrypted string
        } 
    catch (Exception ex) {
         return null;
    }
    return md5;
}
    
}
