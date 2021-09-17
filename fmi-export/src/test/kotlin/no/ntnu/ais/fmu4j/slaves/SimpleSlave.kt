package no.ntnu.ais.fmu4j.slaves

import no.ntnu.ais.fmu4j.export.fmi2.Fmi2Slave
import no.ntnu.ais.fmu4j.export.fmi2.ScalarVariable

open class SimpleSlave(
    args: Map<String, Any>
) : Fmi2Slave(args) {

    @ScalarVariable
    private val myVar: Int = 99

    override fun doStep(currentTime: Double, dt: Double) {}

}

class SimpleSlaveChild(
    args: Map<String, Any>
) : SimpleSlave(args)
