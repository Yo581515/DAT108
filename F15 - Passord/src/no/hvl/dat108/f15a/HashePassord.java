package no.hvl.dat108.f15a;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.xml.bind.DatatypeConverter;

public class HashePassord {

	public static void main(String[] args) 
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		
		String[] noenPassord = {"Hei", "Hallaien", "pwd123", "Peace&Love", "4everSecure"};
		
		for (String passord : noenPassord) {
			
			byte[] passordSomBytes = passord.getBytes("UTF-8");
			
			System.out.println();
			System.out.println(passord);
			System.out.println(Arrays.toString(passordSomBytes));
			
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] digest = md.digest(passordSomBytes);
			System.out.println(Arrays.toString(digest));
			System.out.println(digest.length +" bytes, "+ (8* digest.length)+ " bits");
			
			String base64Digest = Base64.getEncoder().encodeToString(digest);
			System.out.println(base64Digest);
			System.out.println(base64Digest.length());
			System.out.println("64 tegn, "+ "(0 - 9), (26+26)= 64 alfabeter  + skrå strek og plus tegn");
			
			String hexDigest = DatatypeConverter.printHexBinary(digest);
			System.out.println(hexDigest);
			System.out.println("16 bits 4 tegn? ( 256 / 4  = 64) ,  "+"hexDigest.length() = "+hexDigest.length());
			
		}

	}

}
