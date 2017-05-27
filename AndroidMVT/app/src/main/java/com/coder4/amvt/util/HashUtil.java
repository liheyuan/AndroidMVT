package com.coder4.amvt.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by coder4 on 2017/5/27.
 */

public class HashUtil {

    public static String bin2hex(byte [] data) {
        if (data == null) {
            return "";
        }
        return String.format( "%0" + (data.length * 2) + "X", new BigInteger(1, data)).toLowerCase();
    }

    public static String sha256(String str) {
        MessageDigest digest = null ;
        try {
            digest = MessageDigest. getInstance( "SHA-256");
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }
        digest.reset();
        return bin2hex(digest.digest(str.getBytes()));
    }
}
