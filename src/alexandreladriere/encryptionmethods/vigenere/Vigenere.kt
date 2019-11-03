package alexandreladriere.encryptionmethods.vigenere

import alexandreladriere.encryptionmethods.utils.flattenToAscii

/**
 * This function encodes the given message with the given key
 * @param txt Text to be encrypted
 * @param key Encryption key
 */
fun encodeMessage_Vigenere(txt: String, key: String): String {
    var txtEncoded = ""
    val keyLength: Int = key.length
    val txtFlattened = flattenToAscii(txt)
    for (i in txtFlattened.indices) {
        val x = (VIGENERE_ARRAY.indexOf(txtFlattened[i].toUpperCase()) + VIGENERE_ARRAY.indexOf(key[i.rem(keyLength)].toUpperCase())).rem(
            VIGENERE_ARRAY.size)
        txtEncoded += VIGENERE_ARRAY[x]
    }
    return txtEncoded
}

/**
 * This function decodes the given message with the given key
 * @param txt Text to be decoded
 * @param key Encryption key
 */
fun decodeMessage_Vigenere(txt: String, key: String): String {
    var txtDecoded = ""
    val keyLength: Int = key.length
    for (i in txt.indices) {
        val x = (VIGENERE_ARRAY.indexOf(txt[i].toUpperCase()) - VIGENERE_ARRAY.indexOf(key[i.rem(keyLength)].toUpperCase()) + VIGENERE_ARRAY.size).rem(
            VIGENERE_ARRAY.size)
        txtDecoded += VIGENERE_ARRAY[x]
    }
    return txtDecoded
}