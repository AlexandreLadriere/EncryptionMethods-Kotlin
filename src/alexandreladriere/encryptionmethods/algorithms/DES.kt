package alexandreladriere.encryptionmethods.algorithms

import alexandreladriere.encryptionmethods.utils.flattenToAscii

class DES(var txt: String, var key: String) {
    // Not for the key. The key Must be of 64 (56) bytes
    // private lateinit var keyBlocks56bits: Array<ByteArray>
    private lateinit var key56bits: ByteArray

    /**
     * This function transforms the 64bits key to a 56bits key
     */
    private fun initKey(): Unit {
        val tmpKey = flattenToAscii(key)
        val charset = Charsets.US_ASCII
        val key64bits = tmpKey.toByteArray(charset).toMutableList()
        for (i in 0 until key64bits.size) {
        }
        key56bits = key64bits.toByteArray()
    }
    // Faire un shift left de 1 sur le premier, puis un shift right de 7, puis faire un or
}