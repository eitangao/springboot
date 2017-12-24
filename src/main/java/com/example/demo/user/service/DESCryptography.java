package com.example.demo.user.service;



public interface DESCryptography {
    String encrypt(String data,String key)throws Exception;
    String decrypt(String data,String key)throws Exception;
    public  byte[] encrypt(byte[] content,byte[] keyBytes);
    public byte[] decrypt(byte[] content,byte[] keyBytes);
}
