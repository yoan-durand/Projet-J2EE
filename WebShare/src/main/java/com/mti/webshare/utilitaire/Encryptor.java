/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mti.webshare.utilitaire;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author yoan
 * EPITA MTI 2013
 *
 */


public class Encryptor 
{
    /*
  	 * Encode la chaine passé en paramètre avec l'algorithme MD5
  	 * 
  	 * @param key : la chaine à encoder
  	 * 
  	 * @return la valeur (string) hexadécimale sur 32 bits
  	 */
    public static String getEncodedPassword(String key) 
    {
        byte[] uniqueKey = key.getBytes();
        byte[] hash = null;
        try
        {
            hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
        } 
        catch (NoSuchAlgorithmException e) 
        {
            throw new Error("no MD5 support in this VM");
        }
        StringBuffer hashString = new StringBuffer();
        for ( int i = 0; i < hash.length; ++i ) {
            String hex = Integer.toHexString(hash[i]);
            if ( hex.length() == 1 ) 
            {
                hashString.append('0');
                hashString.append(hex.charAt(hex.length()-1));
            } 
            else
            {
                hashString.append(hex.substring(hex.length()-2));
            }
        }
    return hashString.toString();
    }
}
