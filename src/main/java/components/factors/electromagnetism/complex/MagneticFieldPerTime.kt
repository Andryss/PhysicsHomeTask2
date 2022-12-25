package components.factors.electromagnetism.complex

import components.Factor

/*
Магнитная индукция в секунду ?
 */
enum class MagneticFieldPerTime(override val label: String, override val factor: Double) : Factor {
    TESLA_PER_SECOND("Тл/с", 1e0);

    open class Variable : components.Variable<MagneticFieldPerTime> {
        constructor() { label = "ΔB" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = MagneticFieldPerTime.values().toList()
    }

    abstract class Answer : Variable, components.Answer<MagneticFieldPerTime> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = Variable()
    }
}