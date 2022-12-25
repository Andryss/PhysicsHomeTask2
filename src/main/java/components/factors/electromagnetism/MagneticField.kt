package components.factors.electromagnetism

import components.Factor

/*
Магнитная индукция
 */
enum class MagneticField(override val label: String, override val factor: Double): Factor {
    TESLA("Тл", 1e0);

    open class Variable : components.Variable<MagneticField> {
        constructor() { label = "B" }
        constructor(l: String) { label = l }

        final override val label: String
        final override val factors = MagneticField.values().toList()
    }

    abstract class Answer : Variable, components.Answer<MagneticField> {
        constructor() : super()
        constructor(l: String) : super(l)
    }

    companion object {
        val simpleVariable = Variable()
    }
}