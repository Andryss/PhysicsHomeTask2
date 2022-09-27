package components

interface Problem {
    val id: Int // homework id (1,2,3...)
    val label: String
    val svgPath: String // some picture on canvas 200x200
    val text: String
    val variables: List<Variable<Factor>>
    val answers: List<Answer<Factor>>
}