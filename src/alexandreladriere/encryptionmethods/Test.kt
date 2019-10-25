package alexandreladriere.encryptionmethods

import alexandreladriere.encryptionmethods.vigenere.decodeMessage_Vigenere
import alexandreladriere.encryptionmethods.vigenere.encodeMessage_Vigenere

fun main() {
    val txtDecrypted = "Toutes les grandes personnes ont d'abord été des enfants, mais peu d'entre elles s'en souviennent."
    val txtEncrypted = "-@MPXMW5M%3PKX1`7YD59GVMMVC4#SW.)`2@6(6G67JVP096VRWO?M\$!PNXMQ5Y#3ZG,MZVY{C"
    val key = "25octobre"
    println("Text to be encoded: $txtDecrypted")
    println("Text to be decrypted: $txtEncrypted")
    println("Encryption key: $key")
    println("\n********** Vigenere cipher **********")
    println("Encrypted text: " + encodeMessage_Vigenere(txtDecrypted, key))
    println("Decrypted text: " + decodeMessage_Vigenere(txtEncrypted, key))
}