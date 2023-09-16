package edu.java.journal.basic.rsa;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;

public class RSA_Read_Write_Key {

	static String plainText = "Plain text which need to be encrypted by Java RSA Encryption in ECB Mode";

	public static String decrypt(byte[] cipherTextArray, String fileName)
			throws Exception {
		Key privateKey = readKeyFromFile("private.key");

		// Get Cipher Instance
		Cipher cipher = Cipher
				.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING");

		// Initialize Cipher for DECRYPT_MODE
		cipher.init(Cipher.DECRYPT_MODE, privateKey);

		// Perform Decryption
		byte[] decryptedTextArray = cipher.doFinal(cipherTextArray);

		return new String(decryptedTextArray);
	}

	public static byte[] encrypt(String plainText, String fileName)
			throws Exception {
		Key publicKey = readKeyFromFile("public.key");

		// Get Cipher Instance
		Cipher cipher = Cipher
				.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING");

		// Initialize Cipher for ENCRYPT_MODE
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);

		// Perform Encryption
		byte[] cipherText = cipher.doFinal(plainText.getBytes());

		return cipherText;
	}

	public static void main(String[] args) throws Exception {
		// Get an instance of the RSA key generator
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(4096);

		// Generate the KeyPair
		KeyPair keyPair = keyPairGenerator.generateKeyPair();

		// Get the public and private key
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();

		// Get the RSAPublicKeySpec and RSAPrivateKeySpec
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		RSAPublicKeySpec publicKeySpec = keyFactory.getKeySpec(publicKey,
				RSAPublicKeySpec.class);
		RSAPrivateKeySpec privateKeySpec = keyFactory.getKeySpec(privateKey,
				RSAPrivateKeySpec.class);

		// Saving the Key to the file
		saveKeyToFile("public.key", publicKeySpec.getModulus(),
				publicKeySpec.getPublicExponent());
		saveKeyToFile("private.key", privateKeySpec.getModulus(),
				privateKeySpec.getPrivateExponent());

		System.out.println("Original Text  : " + plainText);

		// Encryption
		byte[] cipherTextArray = encrypt(plainText, "public.key");
		String encryptedText = Base64.getEncoder()
				.encodeToString(cipherTextArray);
		System.out.println("Encrypted Text : " + encryptedText);

		writeFile("encrypted3.alm", encryptedText);
		/*
		 * FileOutputStream fos = new FileOutputStream("encrypted2.alm");
		 * BufferedOutputStream bos = new BufferedOutputStream(fos);
		 * bos.write(encryptedText.getBytes()); bos.flush();
		 */

		// Decryption
		// String decryptedText = decrypt(cipherTextArray, "private.key");
		// System.out.println("DeCrypted Text : " + decryptedText);

		System.out.println("read from file encrypted");
		String enContent = readFile("encrypted3.alm");
		System.out.println(enContent);
		System.out.println(decrypt(enContent.getBytes(), "private.key"));

		/*
		 * FileInputStream fis = new FileInputStream("encrypted2.alm");
		 * BufferedInputStream bis= new BufferedInputStream(fis); byte[] bytes =
		 * new byte[fis.available()]; fis.read(bytes);
		 * System.out.println("read from file encrypted");
		 * System.out.println(decrypt(bytes, "private.key"));
		 */
	}

	public static String readFile(String filepath) {
		String data = null;
		try {
			File myObj = new File(filepath);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				data = myReader.nextLine();
				// System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return data;
	}

	public static Key readKeyFromFile(String keyFileName) throws IOException {
		Key key = null;
		InputStream inputStream = new FileInputStream(keyFileName);
		try (ObjectInputStream objectInputStream = new ObjectInputStream(
				new BufferedInputStream(inputStream))) {
			BigInteger modulus = (BigInteger) objectInputStream.readObject();
			BigInteger exponent = (BigInteger) objectInputStream.readObject();
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			if (keyFileName.startsWith("public")) {
				key = keyFactory.generatePublic(
						new RSAPublicKeySpec(modulus, exponent));
			} else {
				key = keyFactory.generatePrivate(
						new RSAPrivateKeySpec(modulus, exponent));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;
	}

	public static void saveKeyToFile(String fileName, BigInteger modulus,
			BigInteger exponent) throws IOException {
		try (ObjectOutputStream ObjOutputStream = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(fileName)))) {
			ObjOutputStream.writeObject(modulus);
			ObjOutputStream.writeObject(exponent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeFile(String filepath, String content) {
		try {
			FileWriter myWriter = new FileWriter(filepath);
			myWriter.write(content);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
