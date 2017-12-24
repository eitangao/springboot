package com.example.demo.user.service;

import java.io.IOException;

public interface DESCryptography {
    String encrypt(String data,String key)throws Exception;
    String decrypt(String data,String key)throws IOException,Exception;
    public  byte[] encrypt(byte[] content,byte[] keyBytes);
    public byte[] decrypt(byte[] content,byte[] keyBytes);
}
