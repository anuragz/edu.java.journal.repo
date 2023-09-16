package edu.java.journal.basic.rsa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.xml.bind.DatatypeConverter;

public class Asymmetric {

	private static final String RSA = "RSA";

	private static Scanner sc;

	public static String do_RSADecryption(byte[] cipherText,
			PublicKey publicKey) throws Exception {
		Cipher cipher = Cipher.getInstance(RSA);
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		byte[] result = cipher.doFinal(cipherText);
		return new String(result);
	}

	public static byte[] do_RSAEncryption(String plainText,
			PrivateKey privateKey) throws Exception {
		Cipher cipher = Cipher.getInstance(RSA);
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		return cipher.doFinal(plainText.getBytes());
	}

	public static KeyPair generateRSAKkeyPair() throws Exception {
		SecureRandom secureRandom = new SecureRandom();
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
		keyPairGenerator.initialize(2048, secureRandom);
		return keyPairGenerator.generateKeyPair();
	}

	public static void main(String arg[]) throws Exception {
		KeyPair keypair = generateRSAKkeyPair();
		String plainText = "This is the PlainText "
				+ "I want to Encrypt using RSA.";
		byte[] cipherText = do_RSAEncryption(plainText, keypair.getPrivate());
		System.out.println("The Public Key is: " + DatatypeConverter
				.printHexBinary(keypair.getPublic().getEncoded()));
		System.out.println("The Private Key is: " + DatatypeConverter
				.printHexBinary(keypair.getPrivate().getEncoded()));

		System.out.println("The Plain Text is: " + plainText);
		System.out.println("The Encrypted Text is: ");
		System.out.println(DatatypeConverter.printHexBinary(cipherText));
		String decryptedText = do_RSADecryption(cipherText,
				keypair.getPublic());
		System.out.println("The decrypted text is: " + decryptedText);

		// write the encrypted text to file
		try {
			FileWriter myWriter = new FileWriter(
					System.getProperty("java.io.tmpdir") + "\\license.alm");
			myWriter.write(DatatypeConverter.printHexBinary(cipherText));
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		// read and convert encrypted text from file
		try {
			File myObj = new File(
					System.getProperty("java.io.tmpdir") + "\\license.alm");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);

				String decryptedText2 = do_RSADecryption(cipherText,
						keypair.getPublic());
				System.out.println("*The decrypted text is: " + decryptedText2);

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

}
