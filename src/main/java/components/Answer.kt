package components

interface Answer<out E : Factor> : Variable<E> {
    fun calculate(vars: List<Double>) : Double
}