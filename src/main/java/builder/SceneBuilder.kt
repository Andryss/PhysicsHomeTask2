package builder

import javafx.scene.Scene

interface SceneBuilder {
    companion object {
        val instance = SimpleSceneBuilder()
    }

    fun getScene() : Scene

}