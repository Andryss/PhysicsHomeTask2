package generator

interface JokeGenerator {
    companion object{
        val instance = JokeGeneratorImpl()
    }

    fun generate() : String

}