package com.example.demo.user.service;

import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

@Service
public class DESCryptographyImpl implements DESCryptography {
    private final static String ENCODE="GBK";
    @Override
    public String encrypt(String data,String key) throws Exception {
        byte[] bt=encrypt(data.getBytes(ENCODE),key.getBytes(ENCODE));
        String strs=new BASE64Encoder().encode(bt);
        return strs;
    }

    @Override
    public String decrypt(String data,String key) throws Exception {
        if(data==null)
            return null;
        BASE64Decoder decoder=new BASE64Decoder();
        byte[] buf=decoder.decodeBuffer(data);
        byte[] bt=decrypt(buf,key.getBytes());
        return new String(bt,ENCODE);
    }

    @Override
    public byte[] encrypt(byte[] content, byte[] keyBytes) {
        try{
            DESKeySpec keySpec=new DESKeySpec(keyBytes);
            SecretKeyFactory keyFactory=SecretKeyFactory.getInstance("DES");
            SecretKey key=keyFactory.generateSecret(keySpec);

            Cipher cipher=Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,key,new IvParameterSpec(keySpec.getKey()));
            byte[] result=cipher.doFinal(content);
            return result;
        }catch(Exception e){
            System.out.println("exception:"+e.toString());
        }
        return null;
    }

    @Override
    public byte[] decrypt(byte[] content, byte[] keyBytes) {
        try{
            DESKeySpec keySpec=new DESKeySpec(keyBytes);
            SecretKeyFactory keyFactory=SecretKeyFactory.getInstance("DES");
            SecretKey key=keyFactory.generateSecret(keySpec);

            Cipher cipher=Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,key,new IvParameterSpec(keyBytes));
            byte[] result=cipher.doFinal(content);
            return result;
        }catch(Exception e){
            System.out.println("exception:"+e.toString());
        }
        return null;
    }

//    @Override
//    public String byteToHexString(byte[] bytes) {
//        StringBuffer sb=new StringBuffer(bytes.length);
//        String sTemp;
//        for(int i=0;i<bytes.length;i++){
//            sTemp=Integer.toHexString(0xFF&bytes[i]);
//            if(sTemp.length()<2)
//                sb.append(0);
//            sb.append(sTemp.toUpperCase());
//        }
//        return sb.toString();
//    }
}
