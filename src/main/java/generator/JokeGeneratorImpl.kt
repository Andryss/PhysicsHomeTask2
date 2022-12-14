package generator

class JokeGeneratorImpl : JokeGenerator {

    override fun generate(): String {
        val joke = jokesTmp.removeLastOrNull()
        if (joke != null) return joke
        jokesTmp = shuffleJokes()
        return jokesTmp.removeLast()
    }

    private val jokes = listOf(
        """
            После каждого неудачного испытания большого адронного коллайдера количество физиков, верящих в Бога, увеличивается в два раза.
        """.trimIndent(),
        """
            За что я люблю физику? Никто не может нарушить ее законы. Даже за деньги.
        """.trimIndent(),
        """
            Как в постоянно расширяющейся вселенной найти суженую?
        """.trimIndent(),
        """
            - Подумать только! И как люди смогли построить эти огромные пирамиды?!
            - Их строили задолго до того как Ньютон открыл закон всемирного тяготения, так что проблем с весом камней тогда не наблюдалось.
        """.trimIndent(),
        """
            Солнечные лучи пролетают миллионы километров, чтобы высушить твои трусы на балконе.
            Подумай над этим…
        """.trimIndent(),
        """
            Незнание законов физики не освобождает вас от их соблюдения.
        """.trimIndent(),
        """
            - Эффект Доплера: длина волны света, исходящего от приближающегося объекта кажется короче, чем от удаляющегося.
            - Как это можно пронаблюдать?
            - Когда поедете вечером на машине, заметьте, что от машин, приближающихся к вам, идет белый свет, а от удаляющихся - красный.
        """.trimIndent(),
        """
            - Расскажите-ка нам отличие волновой от корпускулярной теории света.
            - Я не Света, я Наташа.
        """.trimIndent(),
        """
            - Чем ты занимаешься?
            - Преобразованием потенциальной энергии в кинетическую!
            - Это как?
            - Лежу на диване, дергаю ножкой.
        """.trimIndent(),
        """
            - Люблю жопастых!
            - Господин Ньютон, мы не можем так записать.
            - Ханжи чертовы…. ладно, пишите: чем больше масса, тем больше сила притяжения.
        """.trimIndent(),
        """
            - Эта… А чо такое сила тока?
            - Это когда ума нет, а есть тока сила.
        """.trimIndent(),
        """
            Если бы Эдисон не изобрел электричество - до сих пор бы смотрели телевизор при свечах.
        """.trimIndent(),
        """
            Иван так быстро надевал свой шерстяной свитер, что его убило током.
        """.trimIndent(),
        """
            Фут-фетиш - любовь к неметрической системе мер.
        """.trimIndent(),
        """
            Из французской Палаты мер и весов похищен эталон гектара.
        """.trimIndent(),
        """
            Бриллиант - это всего-лишь кусок угля, которому давление и стресс пошли на пользу.
        """.trimIndent(),
        """
            Ньютон сидит около яблони. С яблони падает на землю яблоко. Вдруг из под земли вылазит жопа проглатывает яблоко и залазит обратно. Ньютон в шоке:
            - Что это было?!
            Жопа снова вылазит и отвечает:
            - Антоновка.
        """.trimIndent(),
        """
            Заходит как-то давление в один бар в один бар…
        """.trimIndent(),
        """
            - Пап, а пространство бесконечно?
            - Конечно, сынок.
        """.trimIndent(),
        """
            Сидят две блондинки и обсуждают теоpию относительности атомных частиц втоpого поpядка. Подходит к ним физик. Одна блондинка - дpугой:
            - Шухеp, говоpим пpо сеpиалы...
        """.trimIndent(),
        """
            Когда я сказал, что Е равно МС в квадрате, учитель физики чуть кадило в купель от смеха не уронил.
        """.trimIndent(),
        """
            На вопрос, почему отопление дали на 10 дней позже, министр энергетики заявил: "Стыдно не знать физику! Вода при нагревании расширяется и плохо пролазит в трубы".
        """.trimIndent(),
        """
            - Если черный кот дважды пересек вам дорогу, он отменил неприятности или удвоил?
            - Если кот векторный, то отменил, а если скалярный, то удвоил.
        """.trimIndent(),
        """
            Скорость звука - довольно странная штука. Родители что-то говорят тебе в двадцать лет, а доходит только в сорок...
        """.trimIndent(),
        """
            Радиопередача заканчивается: "Уважаемые радиослушатели, вы только что прослушали передачу о том, что приближающаяся к Солнечной системе черная дыра не представляет никакой опасности. Московское время - по-прежнему 16:51, и почему-то оно не изменялось на протяжении последнего получаса...".
        """.trimIndent(),
        """
            ._.
        """.trimIndent()
    )

    private var jokesTmp = shuffleJokes()

    private fun shuffleJokes() : ArrayDeque<String> {
        val list = ArrayDeque<String>(jokes.size)
        list.addAll(jokes.shuffled())
        return list
    }
}