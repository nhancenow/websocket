package com.nhance.websocket.WebSocketApp.server;

import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Base64;

public class CryptUtil {
	public static String encrypt(String text, String seed) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
        byte[] key = seed.getBytes();
        byte[] tBytes = text.getBytes();
        BufferedBlockCipher bbCipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESEngine()));
        bbCipher.init(true, new KeyParameter(key));
        byte[] cipherBytes = new byte[bbCipher.getOutputSize(tBytes.length)];
        int len = bbCipher.processBytes(tBytes, 0, tBytes.length, cipherBytes, 0);
        bbCipher.doFinal(cipherBytes, len);
        return new String(Base64.encode(cipherBytes));
    }
	
	 public static String decrypt(String text, String seed) throws 
	 								DataLengthException, IllegalStateException, 
	 								InvalidCipherTextException, IllegalArgumentException {
	        byte[] cipherBytes = Base64.decode(text.getBytes());
	        byte[] key = seed.getBytes();
	        BufferedBlockCipher bbCipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESEngine()));
	        bbCipher.init(false, new KeyParameter(key));
	        byte[] rv = new byte[bbCipher.getOutputSize(cipherBytes.length)];
	        int len = bbCipher.processBytes(cipherBytes, 0, cipherBytes.length, rv, 0);
	        bbCipher.doFinal(rv, len);
	        return new String(rv).trim();
	    }
}
