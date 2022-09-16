package builder

import javafx.scene.Scene
import javafx.scene.control.TabPane
import problems.*

class SimpleSceneBuilder : SceneBuilder {

    private val builder = TabBuilder.instance

    private val problems = ProblemHolder.problems

    override fun getScene(): Scene = Scene(
        TabPane(
            *(problems.map { builder.buildTab(it) }.toTypedArray())
        ).apply {
            prefWidth = 800.0
            prefHeight = 800.0
        }
    )

}