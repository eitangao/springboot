package com.example.demo.user.service;

public interface DESCryptography {
    public  byte[] encrypt(byte[] content,byte[] keyBytes);
    public byte[] decrypt(byte[] content,byte[] keyBytes);
    public String byteToHexString(byte[] bytes);
}
