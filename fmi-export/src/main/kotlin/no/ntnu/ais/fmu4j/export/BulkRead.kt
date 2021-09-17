package no.ntnu.ais.fmu4j.export

class BulkRead(
    val intValues: IntArray,
    val realValues: DoubleArray,
    val boolValues: BooleanArray,
    val strValues: Array<String>
) {
    override fun toString(): String {
        return "BulkRead(intValues=${intValues.contentToString()}, realValues=${realValues.contentToString()}, boolValues=${boolValues.contentToString()}, strValues=${strValues.contentToString()})"
    }
}
