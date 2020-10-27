package com.yj.common.utils;

import static org.junit.Assert.*;

public class RsaUtilsTest {

    private String privateFilePath = "E:\\SourceCode\\JavaDemo\\SpringSecurity\\container\\private_rsa";
    private String publicFilePath = "E:\\SourceCode\\JavaDemo\\SpringSecurity\\container\\public_rsa";

    @org.junit.Test
    public void getPublicKey() {
        try {
            System.err.println(RsaUtils.getPublicKey(publicFilePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void getPrivateKey() throws Exception {
        System.err.println(RsaUtils.getPrivateKey(privateFilePath));
    }

    @org.junit.Test
    public void generateKey() {
        try {
            RsaUtils.generateKey(publicFilePath,privateFilePath,"yangjian",2048);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}