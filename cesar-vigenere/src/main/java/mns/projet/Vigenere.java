package mns.projet;

public class Vigenere {

    public static String encrypt(String plaintext, String key) {
        plaintext = plaintext.toLowerCase().replaceAll("\\s", "");
        key = key.toLowerCase();
        StringBuilder ciphertext = new StringBuilder();
        String adjustedKey = adjustKey(plaintext, key);

        for (int i = 0; i < plaintext.length(); i++) {
            char plainChar = plaintext.charAt(i);
            char keyChar = adjustedKey.charAt(i);

            if (Character.isLetter(plainChar)) {
                char encryptedChar = (char) ((plainChar + keyChar - 2 * 'a') % 26 + 'a');
                ciphertext.append(encryptedChar);
            }
        }

        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, String key) {
        ciphertext = ciphertext.toLowerCase();
        key = key.toLowerCase();
        StringBuilder plaintext = new StringBuilder();
        String adjustedKey = adjustKey(ciphertext, key);

        for (int i = 0; i < ciphertext.length(); i++) {
            char cipherChar = ciphertext.charAt(i);
            char keyChar = adjustedKey.charAt(i);

            if (Character.isLetter(cipherChar)) {
                char decryptedChar = (char) ((cipherChar - keyChar + 26) % 26 + 'a');
                plaintext.append(decryptedChar);
            }
        }

        return plaintext.toString();
    }

    private static String adjustKey(String text, String key) {
        StringBuilder adjustedKey = new StringBuilder();
        int keyIndex = 0;

        for (int i = 0; i < text.length(); i++) {
            char textChar = text.charAt(i);
            if (Character.isLetter(textChar)) {
                adjustedKey.append(key.charAt(keyIndex % key.length()));
                keyIndex++;
            }
        }

        return adjustedKey.toString();
    }

}
