package com.example.springsecurityjwt.utils;


import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: RsaUtils
 * Author:   YJ
 * Date:     2020/11/27 16:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/11/27 16:53        1.0              描述
 */
public class RsaUtils {
    private static final String SRC = "123456";

    public static void main(String[] args) throws Exception {
        RsaKeyPair keyPair = generatorKey();
        System.out.println("公钥：" + keyPair.getPublicKey());
        System.out.println("私钥：" + keyPair.getPrivateKey());
        System.out.println("\n");
        test1(keyPair);
        System.out.println("\n");
        test2(keyPair);
        System.out.println("\n");
        try {
            test3(keyPair);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("\n");
        try {
            test4(keyPair);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("\n");
    }

    /**
     * 公钥加密私钥解密
     */
    private static void test1(RsaKeyPair keyPair) throws Exception {
        System.err.println("**********公钥加密私钥解密开始***************");
        System.err.println("加密前：" + SRC);
        String text1 = encryptByPublicKey(keyPair.getPublicKey(), SRC);
        System.err.println("加密后：" + text1);
        String text2 = decryptByPrivateKey(keyPair.getPrivateKey(), text1);
        System.err.println("解密后：" + text2);
        if (RsaUtils.SRC.equals(text2)) {
            System.out.println("解密字符串和原始字符串一致，解密成功");
        } else {
            System.out.println("解密字符串和原始字符串不一致，解密失败");
        }
        System.err.println("**********公钥加密私钥解密结束***************");
    }


    /**
     * 私钥加密公钥解密
     */
    private static void test2(RsaKeyPair keyPair) throws Exception {
        System.err.println("**********私钥加密公钥解密开始***************");
        String text1 = encryptByPrivateKey(keyPair.getPrivateKey(), SRC);
        String text2 = decryptByPublicKey(keyPair.getPublicKey(), text1);
        System.err.println("加密前：" + SRC);
        System.err.println("加密后：" + text1);
        System.err.println("解密后：" + text2);
        if (RsaUtils.SRC.equals(text2)) {
            System.out.println("解密字符串和原始字符串一致，解密成功");
        } else {
            System.out.println("解密字符串和原始字符串不一致，解密失败");
        }
        System.err.println("**********私钥加密公钥解密结束***************");
    }


    /**
     * 公钥加密公钥解密
     */
    private static void test3(RsaKeyPair keyPair) throws Exception {
        System.err.println("**********公钥加密公钥解密开始***************");
        String text1 = encryptByPublicKey(keyPair.getPublicKey(), SRC);
        String text2 = decryptByPublicKey(keyPair.getPublicKey(), text1);
        System.err.println("加密前：" + SRC);
        System.err.println("加密后：" + text1);
        System.err.println("解密后：" + text2);
        if (RsaUtils.SRC.equals(text2)) {
            System.out.println("解密字符串和原始字符串一致，解密成功");
        } else {
            System.out.println("解密字符串和原始字符串不一致，解密失败");
        }
        System.err.println("**********公钥加密公钥解密结束***************");
    }


    /**
     * 私钥加密私钥解密
     */
    private static void test4(RsaKeyPair keyPair) throws Exception {
        System.err.println("**********私钥加密私钥解密***************");
        String text1 = encryptByPrivateKey(keyPair.getPrivateKey(), SRC);
        String text2 = decryptByPrivateKey(keyPair.getPrivateKey(), text1);
        System.err.println("加密前：" + SRC);
        System.err.println("加密后：" + text1);
        System.err.println("解密后：" + text2);
        if (RsaUtils.SRC.equals(text2)) {
            System.out.println("解密字符串和原始字符串一致，解密成功");
        } else {
            System.out.println("解密字符串和原始字符串不一致，解密失败");
        }
        System.err.println("**********私钥加密私钥解密***************");
    }


    public static RsaKeyPair generatorKey() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048, new SecureRandom("yangjian".getBytes()));

        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        String publicKeyString = Base64.encodeBase64String(publicKey.getEncoded());
        String privateKeyString = Base64.encodeBase64String(privateKey.getEncoded());
        return new RsaKeyPair(publicKeyString, privateKeyString);
    }


    /**
     * 公钥加密
     *
     * @param publicKeyText
     * @param text
     * @return
     * @throws Exception
     */
    public static String encryptByPublicKey(String publicKeyText, String text) throws Exception {
        X509EncodedKeySpec spec = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyText));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(spec);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] bytes = cipher.doFinal(text.getBytes());
        return Base64.encodeBase64String(bytes);
    }

    /**
     * 公钥解密
     *
     * @param publicKeyText
     * @param text
     * @return
     * @throws Exception
     */
    public static String decryptByPublicKey(String publicKeyText, String text) throws Exception {
        X509EncodedKeySpec spec = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyText));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(spec);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        byte[] bytes = cipher.doFinal(Base64.decodeBase64(text));

        return new String(bytes);
    }


    /**
     * 私钥加密
     *
     * @param privateKeyText
     * @param text
     * @return
     * @throws Exception
     */
    public static String encryptByPrivateKey(String privateKeyText, String text) throws Exception {
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyText));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(spec);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        byte[] bytes = cipher.doFinal(text.getBytes());
        return Base64.encodeBase64String(bytes);
    }

    /**
     * 私钥解密
     *
     * @param privateKeyText
     * @param text
     * @return
     * @throws Exception
     */
    public static String decryptByPrivateKey(String privateKeyText, String text) throws Exception {
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyText));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(spec);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] bytes = cipher.doFinal(Base64.decodeBase64(text));

        return new String(bytes);
    }


    public static class RsaKeyPair {
        private final String publicKey;
        private final String privateKey;

        public RsaKeyPair(String publicKey, String privateKey) {
            this.publicKey = publicKey;
            this.privateKey = privateKey;
        }

        public String getPublicKey() {
            return publicKey;
        }

        public String getPrivateKey() {
            return privateKey;
        }
    }

}
