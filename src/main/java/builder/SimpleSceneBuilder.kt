package builder

import javafx.scene.Scene
import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import problems.*

class SimpleSceneBuilder : SceneBuilder {

    private val builder = TabBuilder.instance

    private val problems = ProblemHolder.problems

    override fun getScene(): Scene = Scene(
        TabPane(
            *(
                problems.mapValues {
                    it.value.map { problem -> builder.buildTab(problem) }
                }.mapValues {
                    TabPane(*it.value.toTypedArray()).apply { prefWidth = 800.0; prefHeight = 800.0 }
                }.map {
                    Tab(it.key.toString(), it.value).apply { isClosable = false }
                }.toTypedArray()
            )
        )
    )

}