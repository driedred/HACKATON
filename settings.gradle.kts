pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()  // Важно для поиска плагинов
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io") // для JitPack, если необходимо
    }
}

rootProject.name = "app2"
include(":app")

 