import java.net.URI

buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(kotlin(module = "gradle-plugin", version = Versions.kotlin))
        classpath(BuildPlugins.androidPlugin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven {
            url = URI.create("https://jitpack.io")
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
