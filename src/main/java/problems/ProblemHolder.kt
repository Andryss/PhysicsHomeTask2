package problems

import components.Problem
import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.util.jar.JarFile
import java.util.stream.Collectors

class ProblemHolder {

    companion object {
        val problems = readProblems()

        private fun readProblems() : Array<Problem> =
            try {
                // Try if we are in JAR file
                JarFile(File(ProblemHolder::class.java.protectionDomain.codeSource.location.toURI().path)).stream()
                    .map { it.toString() }
                    .filter { it.startsWith("problems/") && it.endsWith(".class") }
                    .map { it.substring(0, it.length - 6).replace("/".toRegex(), ".") }
                    .collect(Collectors.toList())
            } catch (e: IOException) {
                // But maybe we are in .class file
                val path: Path = File(ProblemHolder::class.java.protectionDomain.codeSource.location.toURI().path).toPath()
                Files.walk(File("$path\\problems\\").toPath())
                    .map { it.toString() }
                    .filter { it.endsWith(".class") }
                    .map { it.substring(path.toString().length + 1, it.length - 6).replace("\\\\".toRegex(), ".") }
                    .collect(Collectors.toList())
            }
                .map { Class.forName(it) }
                .filter { it.interfaces.contains(Problem::class.java) }
                .map { it.getConstructor().newInstance() as Problem }
                .toTypedArray()
    }

}