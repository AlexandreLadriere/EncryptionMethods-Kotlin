package alexandreladriere.encryptionmethods.vigenere

import alexandreladriere.encryptionmethods.utils.flattenToAscii

/**
 * This function extends the key in a cyclic manner until its length matches the text length
 * @param txt Text to be encrypted
 * @param key Encryption key
 */
private fun extendKey(txt: String, key: String): String {
    val txtLength: Int = txt.length
    val keyLength: Int = key.length
    var keyExtended = ""
    for (i in 0 until txtLength) {
        keyExtended += key[i.rem(keyLength)]
    }
    return keyExtended
}

/**
 * This function encodes the given message with the given key
 * @param txt Text to be encrypted
 * @param key Encryption key
 */
fun encodeMessage_Vigenere(txt: String, key: String): String {
    var txtEncoded = ""
    val keyExtended = extendKey(txt, key)
    val txtFlattened = flattenToAscii(txt)
    for (i in txtFlattened.indices) {
        val x = (VIGENERE_ARRAY.indexOf(txtFlattened[i].toUpperCase()) + VIGENERE_ARRAY.indexOf(keyExtended[i].toUpperCase())).rem(
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
    val keyExtended = extendKey(txt, key)
    for (i in txt.indices) {
        val x = (VIGENERE_ARRAY.indexOf(txt[i].toUpperCase()) - VIGENERE_ARRAY.indexOf(keyExtended[i].toUpperCase()) + VIGENERE_ARRAY.size).rem(
            VIGENERE_ARRAY.size)
        txtDecoded += VIGENERE_ARRAY[x]
    }
    return txtDecoded
}