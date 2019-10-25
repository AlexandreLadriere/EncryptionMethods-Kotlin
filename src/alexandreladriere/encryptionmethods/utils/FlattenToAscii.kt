package alexandreladriere.encryptionmethods.utils

import java.text.Normalizer

/**
 * This function get rid of all accents and special letters (e.g.: é will became e). See https://stackoverflow.com/a/15191508
 * @param txt Text to be flattened
 */
fun flattenToAscii(txt: String): String {
    var string = txt
    val out = CharArray(string.length)
    string = Normalizer.normalize(string, Normalizer.Form.NFD)
    var j = 0
    var i = 0
    val n = string.length
    while (i < n) {
        val c = string[i]
        if (c <= '\u007F') out[j++] = c
        ++i
    }
    return String(out)
}