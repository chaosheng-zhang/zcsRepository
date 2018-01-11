package com.company.project.common;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author: zhangcs
 * @Description: SHA256withRSA
 * @date: 2018年1月11日 下午2:30:15
 * 
 */
public class RSA {
	
	public static final String KEY_ALGORITHM = "RSA";  
    public static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";  
    public static final String PUBLIC_KEY = "publicKey";  
    public static final String PRIVATE_KEY = "privateKey";  
    public static final int KEY_SIZE = 2048;  
    
    public static final String SIGNATURE_ALGORITHM = "SHA256withRSA";  
    public static final String ENCODE_ALGORITHM = "SHA-256";  
    public static final String PLAIN_TEXT = "test string"; 
    
    public static void main(String[] args) {  
        // 公私钥对  
        Map<String, byte[]> keyMap = generateKeyBytes();  
        PublicKey publicKey = restorePublicKey(keyMap.get(PUBLIC_KEY));  
        PrivateKey privateKey = restorePrivateKey(keyMap.get(PRIVATE_KEY));  
        // 签名  
        byte[] sing_byte = sign(privateKey, PLAIN_TEXT);  
        // 验签  
        verifySign(publicKey, PLAIN_TEXT, sing_byte);  
    }
    
    /** 
     * 签名 
     *  
     * @param privateKey 
     *            私钥 
     * @param plain_text 
     *            明文 
     * @return 
     */  
    public static byte[] sign(PrivateKey privateKey, String plain_text) {  
        MessageDigest messageDigest;  
        byte[] signed = null;  
        try {  
            messageDigest = MessageDigest.getInstance(ENCODE_ALGORITHM);  
            messageDigest.update(plain_text.getBytes());  
            byte[] outputDigest_sign = messageDigest.digest();  
            System.out.println("SHA-256加密后-----》" +bytesToHexString(outputDigest_sign));  
            Signature Sign = Signature.getInstance(SIGNATURE_ALGORITHM);  
            Sign.initSign(privateKey);  
            Sign.update(outputDigest_sign);  
            signed = Sign.sign();  
            System.out.println("SHA256withRSA签名后-----》" + bytesToHexString(signed));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return signed;  
    }  
  
    /** 
     * 验签 
     *  
     * @param publicKey 
     *            公钥 
     * @param plain_text 
     *            明文 
     * @param signed 
     *            签名 
     */  
    public static boolean verifySign(PublicKey publicKey, String plain_text, byte[] signed) {  
  
        MessageDigest messageDigest;  
        boolean SignedSuccess=false;  
        try {  
            messageDigest = MessageDigest.getInstance(ENCODE_ALGORITHM);  
            messageDigest.update(plain_text.getBytes());  
            byte[] outputDigest_verify = messageDigest.digest();  
            //System.out.println("SHA-256加密后-----》" +bytesToHexString(outputDigest_verify));  
            Signature verifySign = Signature.getInstance(SIGNATURE_ALGORITHM);  
            verifySign.initVerify(publicKey);  
            verifySign.update(outputDigest_verify);  
            SignedSuccess = verifySign.verify(signed);  
            System.out.println("验证成功？---" + SignedSuccess);  
              
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return SignedSuccess;  
    }  
  
    /** 
     * bytes[]换成16进制字符串 
     *  
     * @param src 
     * @return 
     */  
    public static String bytesToHexString(byte[] src) {  
        StringBuilder stringBuilder = new StringBuilder("");  
        if (src == null || src.length <= 0) {  
            return null;  
        }  
        for (int i = 0; i < src.length; i++) {  
            int v = src[i] & 0xFF;  
            String hv = Integer.toHexString(v);  
            if (hv.length() < 2) {  
                stringBuilder.append(0);  
            }  
            stringBuilder.append(hv);  
        }  
        return stringBuilder.toString();  
    } 
    /** 
     * 生成密钥对 
     *  
     * @return 
     */  
    public static Map<String, byte[]> generateKeyBytes() {  
  
        try {  
            KeyPairGenerator keyPairGenerator = KeyPairGenerator  
                    .getInstance(KEY_ALGORITHM);  
            keyPairGenerator.initialize(KEY_SIZE);  
            KeyPair keyPair = keyPairGenerator.generateKeyPair();  
            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();  
            Map<String, byte[]> keyMap = new HashMap<String, byte[]>();  
            keyMap.put(PUBLIC_KEY, publicKey.getEncoded());  
            keyMap.put(PRIVATE_KEY, privateKey.getEncoded());  
            return keyMap;  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
  
    /** 
     * 还原公钥 
     *  
     * @param keyBytes 
     * @return 
     */  
    public static PublicKey restorePublicKey(byte[] keyBytes) {  
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);  
        try {  
            KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);  
            PublicKey publicKey = factory.generatePublic(x509EncodedKeySpec);  
            return publicKey;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
  
    /** 
     * 还原私钥 
     *  
     * @param keyBytes 
     * @return 
     */  
    public static PrivateKey restorePrivateKey(byte[] keyBytes) {  
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(  
                keyBytes);  
        try {  
            KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);  
            PrivateKey privateKey = factory  
                    .generatePrivate(pkcs8EncodedKeySpec);  
            return privateKey;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }

}
