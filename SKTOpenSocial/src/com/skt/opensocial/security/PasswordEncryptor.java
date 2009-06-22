package com.skt.opensocial.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import sun.misc.BASE64Encoder;

public final class PasswordEncryptor {
	static Logger logger = Logger.getLogger(PasswordEncryptor.class);
	
	private static PasswordEncryptor encryptor;
	
	private PasswordEncryptor(){
		
	}

	public static synchronized PasswordEncryptor getInstance() {
		if(encryptor == null) {
			encryptor = new PasswordEncryptor();
		}
		return encryptor;
	}
	
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
