package com.yj.common.utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: RsaUtils
 * Author:   yangjian
 * Date:     2020/10/27 23:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/10/27 23:45        1.0              描述
 */
public class RsaUtils {
    private static final int DEFAULT_KEY_SIZE = 2048;

    public static PublicKey getPublicKey(String fileName) throws Exception {
        byte[] bytes = readFile(fileName);
        return getPublicKey(bytes);
    }

    private static PublicKey getPublicKey(byte[] bytes) throws Exception {
        bytes = Base64.getDecoder().decode(bytes);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePublic(spec);
    }

    public static PrivateKey getPrivateKey(String fileName) throws Exception {
        byte[] bytes = readFile(fileName);
        return getPrivateKey(bytes);
    }

    private static PrivateKey getPrivateKey(byte[] bytes) throws Exception {
        bytes = Base64.getDecoder().decode(bytes);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePrivate(spec);
    }

    public static void generateKey(String publicKeyFileName, String privateKeyFileName, String secret, int keySize) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom random = new SecureRandom(secret.getBytes());

        keyPairGenerator.initialize(Math.max(keySize, DEFAULT_KEY_SIZE), random);
        KeyPair keyPair = keyPairGenerator.genKeyPair();

        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        publicKeyBytes = Base64.getEncoder().encode(publicKeyBytes);

        writeFile(publicKeyFileName, publicKeyBytes);

        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        privateKeyBytes = Base64.getEncoder().encode(privateKeyBytes);
        writeFile(privateKeyFileName, privateKeyBytes);
    }

    private static byte[] readFile(String fileName) throws Exception {
        return Files.readAllBytes(new File(fileName).toPath());
    }

    private static void writeFile(String destPath, byte[] bytes) throws Exception {
        File dest = new File(destPath);
        if (!dest.exists()) {
            dest.createNewFile();
        }
        Files.write(dest.toPath(), bytes, StandardOpenOption.CREATE);
    }


}
