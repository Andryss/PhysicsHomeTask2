package components

interface Variable<out E : Factor> {
    val label : String
    val factors: List<E>
}