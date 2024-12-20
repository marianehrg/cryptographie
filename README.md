# cryptographie
Ce projet implémente le chiffrement AES (Advanced Encryption Standard) en utilisant l'algorithme de chiffrement symétrique. Cette classe AesCipher contient les opérations de base nécessaires pour effectuer un chiffrement AES sur un bloc de données de 128 bits à l'aide d'une clé de 128 bits (16 octets).

## Prérequis
Java version 8 ou supérieure.
Un IDE de développement Java (comme IntelliJ IDEA, Eclipse, ou simplement le JDK pour exécuter le projet en ligne de commande).

## Installation

### Clonage

git clone git@github.com:marianehrg/cryptographie.git

### Compiler le projet :
javac mns/projet/AesCipher.java
### Exécuter le programme :
Pour exécuter le programme, utilisez la commande suivante :

java mns.projet.AesCipher

## Explication du code : AesCipher.class
### Déclaration des constantes
Nb = 4 : Le nombre de colonnes dans l'état AES (une matrice de 4x4 pour un bloc de 128 bits).
Nk = 4 : Le nombre de mots dans la clé de chiffrement (pour une clé de 128 bits, nous avons 4 mots).
Nr = 10 : Le nombre de rondes pour le chiffrement AES avec une clé de 128 bits.
S_BOX[] : Tableau qui contient la table de substitution utilisée dans le chiffrement AES.

### Fonction gmul(int a, int b)
Cette fonction effectue une multiplication de Galois entre deux entiers a et b, utilisée dans le processus de mixage des colonnes.

### Fonction rc(int value)
Cette fonction retourne le facteur de ronde pour le chiffrement. Il utilise la fonction gmul pour appliquer un décalage multiplicatif dans le champ de Galois.

### Fonction srd(int index)
Retourne une valeur de la S-Box pour l'indice donné. La S-Box est utilisée pour la substitution des octets dans l'état AES.

### Fonction keyExpansion(int[] hexa)
La fonction keyExpansion génère les clés de ronde à partir de la clé de chiffrement initiale. Elle utilise la S-Box et le facteur de ronde pour transformer la clé initiale en une série de clés de ronde utilisées dans les différentes étapes du chiffrement.

### Fonction rijndael(int[] state, int[] cipherKey)
C'est la fonction principale de chiffrement AES. Elle prend en entrée un tableau state de 16 entiers représentant l'état à chiffrer et une clé de chiffrement cipherKey de 16 entiers. Elle passe par les différentes étapes de chiffrement AES :

Ajout de la clé de ronde.
Substitution des octets (subBytes).
Décalage des lignes (shiftRows).
Mélange des colonnes (mixColumns).
Ajout de la clé de ronde à chaque étape.
Fonction addRoundKey(int[] state, int[][] roundKey, int round)
Effectue une opération XOR entre l'état et la clé de ronde correspondante.

### Fonction subBytes(int[] state)
Effectue la substitution des octets dans l'état en utilisant la S-Box.

### Fonction round(int[] state, int[][] roundKey, int round)
Effectue une ronde complète avec substitution (subBytes), décalage des lignes (shiftRows), mélange des colonnes (mixColumns), et ajout de la clé de ronde.

### Fonction finalRound(int[] state, int[][] roundKey)
Effectue la dernière ronde de chiffrement sans appliquer le mélange des colonnes, mais en effectuant la substitution des octets, le décalage des lignes et l'ajout de la clé de ronde finale.

### Fonction shiftRows(int[] state)
Effectue le décalage circulaire des lignes de l'état. Cette opération est spécifique à AES et est effectuée après la substitution des octets.

### Fonction mixColumns(int[] state)
Effectue l'opération de mélange des colonnes de l'état. Cette étape est importante pour diffuser les valeurs dans l'état et rendre le chiffrement plus sécurisé.

## Conclusion
Ce code implémente l'algorithme AES avec une clé de 128 bits et peut être utilisé pour chiffrer des blocs de données en utilisant les méthodes décrites ci-dessus. Vous pouvez l'adapter pour gérer des entrées et sorties spécifiques selon vos besoins.