package mns.projet;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        // VIGENERE
//        String plaintext = "Je suis mariane";
//        String key = "CLE";
//        System.out.println("Texte : " + plaintext);
//
//        String ciphertext = Vigenere.encrypt(plaintext, key);
//        System.out.println("Texte chiffré : " + ciphertext);
//
//        String decryptedText = Vigenere.decrypt(ciphertext, key);
//        System.out.println("Texte déchiffré : " + decryptedText);

        //----------------------------------------------------------------------------
        //EXO AES
        int[] key = {0x2b,0x7e,0x15,0x16,0x28,0xae,0xd2,0xa6,0xab,0xf7,0x15,0x88,0x09,0xcf,0x4f,0x3c};
        int[] plaintext = {0x32,0x43,0xf6,0xa8,0x88,0x5a,0x30,0x8d,0x31,0x31,0x98,0xa2,0xe0,0x37,0x07,0x34};

        int[] ciphertext = AesCipher.rijndael(plaintext, key);

        System.out.print("Ciphertext: ");
        for (int b : ciphertext) {
            System.out.printf("%02x", b);
        }
    }
}
