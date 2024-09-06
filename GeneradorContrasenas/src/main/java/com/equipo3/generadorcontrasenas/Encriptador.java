
package com.equipo3.generadorcontrasenas;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Equipo3
 */
public class Encriptador {
    public MessageDigest digest;
    
    public Encriptador(String hashType) throws NoSuchAlgorithmException {
        this.digest = MessageDigest.getInstance(hashType);
    }
    
    private String convertirBytesATexto(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        
        for (byte b: bytes) {
            sb.append(String.format("%02x", b));
        }
        
        String hashHex = sb.toString();
        
        return hashHex;
    }
    
    public String encriptar(String password) {
        byte[] bytesHash = digest.digest(password.getBytes());
        return this.convertirBytesATexto(bytesHash);
    }
}
