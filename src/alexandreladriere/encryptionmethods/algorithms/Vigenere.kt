package alexandreladriere.encryptionmethods.algorithms

import alexandreladriere.encryptionmethods.utils.VIGENERE_ARRAY
import alexandreladriere.encryptionmethods.utils.flattenToAscii

class Vigenere(var txt: String, var key: String) {

    /**
     * This function encodes the given message with the given key og the Vigenere object
     */
    fun encodeMessage(): String {
        var txtEncoded = ""
        val keyLength: Int = key.length
        val txtFlattened = flattenToAscii(txt)
        for (i in txtFlattened.indices) {
            val x =
                (VIGENERE_ARRAY.indexOf(txtFlattened[i].toUpperCase()) + VIGENERE_ARRAY.indexOf(key[i.rem(keyLength)].toUpperCase())).rem(
                    VIGENERE_ARRAY.size
                )
            txtEncoded += VIGENERE_ARRAY[x]
        }
        return txtEncoded
    }

    /**
     * This function decodes the given message with the given key of the Vigenere object
     */
    fun decodeMessage(): String {
        var txtDecoded = ""
        val keyLength: Int = key.length
        for (i in txt.indices) {
            val x =
                (VIGENERE_ARRAY.indexOf(txt[i].toUpperCase()) - VIGENERE_ARRAY.indexOf(key[i.rem(keyLength)].toUpperCase()) + VIGENERE_ARRAY.size).rem(
                    VIGENERE_ARRAY.size
                )
            txtDecoded += VIGENERE_ARRAY[x]
        }
        return txtDecoded
    }
}