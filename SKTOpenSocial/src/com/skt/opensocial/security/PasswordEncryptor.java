package com.skt.opensocial.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import sun.misc.BASE64Encoder;

/**
 * 사용자의 패스워드를 암호화하고 복호화하기 위한 클래스
 * @author Ernest Lee
 *
 */
public final class PasswordEncryptor {
	static Logger logger = Logger.getLogger(PasswordEncryptor.class);
	
	private static PasswordEncryptor encryptor;
	
	private PasswordEncryptor(){
		
	}

	/**
	 * PasswordEncryptor 오브젝트를 생성해주기 위한 싱글톤 메소드이다
	 * @return PasswordEncryptor 오브젝트
	 */
	public static synchronized PasswordEncryptor getInstance() {
		if(encryptor == null) {
			encryptor = new PasswordEncryptor();
		}
		return encryptor;
	}
	
	/**
	 * 암호화(실은, 해싱)을 수행하는 메소드
	 * @param plainString 평문 암호
	 * @return 암호의 해쉬 문자열
	 */
	public synchronized String encrypt(String plainString){
		MessageDigest md = null;
		
		try {
	      md = MessageDigest.getInstance("SHA-1");
	      md.reset();
	    } catch(NoSuchAlgorithmException e){
	    	System.out.println("An excpetion occurred: " + e.getMessage());
	    }
	    
	    try {
	    	byte[] bytes = plainString.getBytes("UTF-8");
	    	md.update(bytes);
	    	
	    	//md.update(plainString.getBytes("ISO-8859-1"));
	    	//md.update(plainString.getBytes(""));
	    	
	    } catch(UnsupportedEncodingException e){
	    	System.out.println("An excpetion occurred: " + e.getMessage());
	    }
	    
	    byte[] raw = md.digest();
	    String hash = (new BASE64Encoder()).encode(raw);
	    return hash;
	}
	
	/**
	 * 평문과 해쉬값을 전달하여 일치하는지를 확인한다
	 * @param plain 평문
	 * @param hash 해쉬 문자열
	 * @return true 또는 false
	 */
	public static boolean isMatch(String plain, String hash){
		PasswordEncryptor pe = getInstance();
		boolean match = false;
		try {
			match = hash.equals(pe.encrypt(plain));
		} catch(Exception e){
			System.out.println("Error occurred while encrypting: " + e.getMessage());
		}
		if(!match){
			logger.log(Level.INFO, "Password mismatch");
			logger.log(Level.INFO, "src=" + pe.encrypt(plain) + ", tgt=" + hash);
		}
		return match;
	}
}
