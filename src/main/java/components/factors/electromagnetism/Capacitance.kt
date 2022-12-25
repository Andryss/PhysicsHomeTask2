package components.factors.electromagnetism

import components.Factor

/*
Электроемкость
 */
enum class Capacitance(override val label: String, override val factor: Double) : Factor {
    FARAD("Ф", 1e0),
    MILLIFARAD("мФ", 1e-3),
    MICROFARAD("мкФ", 1e-6);

    open class Variable : components.Variable<Capacitance> {
        constructor() { label = "C" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = Capacitance.values().toList()
    }

    abstract class Answer : Variable, components.Answer<Capacitance> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = Variable()
    }
}