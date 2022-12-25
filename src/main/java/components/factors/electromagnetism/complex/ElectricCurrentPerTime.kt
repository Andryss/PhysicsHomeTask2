package components.factors.electromagnetism.complex

import components.Factor

/*
Сила тока в секунду ?
 */
enum class ElectricCurrentPerTime(override val label: String, override val factor: Double) : Factor {
    AMPERE_PER_SECOND("А/с", 1e0);

    open class Variable : components.Variable<ElectricCurrentPerTime> {
        constructor() { label = "ΔI" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = ElectricCurrentPerTime.values().toList()
    }

    abstract class Answer : Variable, components.Answer<ElectricCurrentPerTime> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = Variable()
    }
}