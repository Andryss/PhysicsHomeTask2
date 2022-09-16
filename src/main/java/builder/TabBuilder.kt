package builder

import components.Problem
import javafx.scene.control.Tab

interface TabBuilder {
    companion object {
        var instance: TabBuilder = SimpleTabBuilder()
    }

    fun buildTab(problem: Problem) : Tab

}