package components.factors.electromagnetism.complex

import components.Factor

/*
Поверхностная плотность заряда
 */
enum class SurfaceChargeDensity(override val factor: Double, override val label: String) : Factor {
    COULOMBS_PER_SQUARE_METER(1e0, "К/м²"),
    MILLICOULOMB_PER_SQUARE_METER(1e-3, "мК/м²");

    open class Variable : components.Variable<SurfaceChargeDensity> {
        constructor() { label = "σ" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = SurfaceChargeDensity.values().toList()
    }

    abstract class Answer : Variable, components.Answer<SurfaceChargeDensity> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = Variable()
    }
}