package com.mix.avion.service;

import com.mix.avion.model.Administrateur;
import com.mix.avion.model.Token;

import java.security.MessageDigest;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Formatter;

public class TokenService {
    private static String encrypt1(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    public String encryptage(String st) throws Exception {
        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.reset();
        crypt.update(st.getBytes("UTF-8"));
        return encrypt1(crypt.digest());
    }
    public String generateToken(String mess) throws Exception
    {
        String token = null;
        Date timest = Date.valueOf(LocalDate.now());
        String timestamp = String.valueOf(timest);
        String plus = "aeroflow";
        token = encryptage(timestamp + plus + mess);
        return token;
    }
    public Token createToken(Administrateur admin) throws Exception {
        int idadmin = Integer.valueOf(admin.getId());
        String token = generateToken(String.valueOf(admin.getId()));
        LocalDate creation = LocalDate.now();
        LocalDate expiration = LocalDate.now().plusDays(1);
        return new Token(admin,token,creation,expiration);
    }
}
