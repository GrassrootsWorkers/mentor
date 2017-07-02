package com.dream.mentor.common;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

public class AesCiperTokenUtil {
	
	private static final Logger LOG = Logger.getLogger(AesCiperTokenUtil.class);
	
	// AESkey   
	private static final String KEY_AES = "AES";
	
	// AES算法 
	private static final String ALGORITHM_AES = "AES/CBC/PKCS5Padding";
	
	// 16 位字符串
	private static final String IV_PARAM_AES = "EJK89&*^QD78#!39";
	
	private static AlgorithmParameterSpec paramSpec = new IvParameterSpec(IV_PARAM_AES.getBytes());
	
	private static Cipher ecipher;
	private static Key k;
	
	static {
		try {
			ecipher = Cipher.getInstance(ALGORITHM_AES);
			k = toKey(generateAESKey(128, "AEDIEWWOD(#$)**#$EDIDNKA*&)##)("), KEY_AES);
		} catch (Exception e) {
			LOG.error("error: " + e.getMessage());
		}
	}
	
	
	/** 
	 * 生成AESkey 
	 * @param keySize key的位数 
	 * @param seed 随机种子 
	 * @return 返回base64编码后的key信息 
	 */
	public static String generateAESKey(int keySize, String seed) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance(KEY_AES);
			SecureRandom random=SecureRandom.getInstance("SHA1PRNG");
			random.setSeed(seed.getBytes());
			kgen.init(keySize, random);
			SecretKey key = kgen.generateKey();
			return TranscodeUtil.byteArrayToBase64Str(key.getEncoded());
		} catch (NoSuchAlgorithmException e) {
			LOG.error("error: " + e.getMessage());
		}
		return null;
	}
	
	/** 
	 * AES加密 
	 * @param data 要加密的数据
	 * @return 返回加密数据 
	 */
	public static String aesEncrypt(String data) {
		return Base64Encoder.encode(aesCipher(data, Cipher.ENCRYPT_MODE).getBytes());
	}
	
	/** 
	 * AES解密 
	 * @param data 要解密的数据
	 * @return 返回解密数据 
	 */
	public static String aesDecrypt(String data) {
		return aesCipher(new String(Base64Decoder.decode(data)), Cipher.DECRYPT_MODE);
	}
	
	/** 
	 * 实现AES加密解密 
	 * @param data 要加密或解密的数据
	 * @param mode 加密或解密 
	 * @return 返回加密或解密的数据 
	 */
	private static String aesCipher(String data, int mode) {
		try {
			// 算法参数使用固定的一个字符串，方便手动生成加密后字符串与解密
			ecipher.init(mode, k, paramSpec);
			return mode == Cipher.DECRYPT_MODE ? new String(ecipher.doFinal(TranscodeUtil.base64StrToByteArray(data))) : TranscodeUtil.byteArrayToBase64Str(ecipher.doFinal(data.getBytes()));
		} catch (Exception e) {
		}
		return "";
	}
	
	/** 
	 * 将base64编码后的密钥字符串转换成密钥对象 
	 * @param key 密钥字符串 
	 * @param algorithm 加密算法 
	 * @return 返回密钥对象 
	 */
	private static Key toKey(String key, String algorithm) {
		SecretKey secretKey = new SecretKeySpec(TranscodeUtil.base64StrToByteArray(key), algorithm);
		return secretKey;
	}
	
	public static void main(String[] args) {
		String key = "";
		String source="web";
		Long userId = 1L;
		String password ;
		long time = System.currentTimeMillis();
		String data = userId+":"+time+":"+source;
		password = aesEncrypt(data);
		System.out.println(password);
		password = aesDecrypt(password);
		System.out.println(password);

	}
}
