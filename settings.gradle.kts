pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "SampleApp"
include(":app")

include(":primary")
project(":primary").projectDir = File(rootDir, "source/primary")

include(":secondary")
project(":secondary").projectDir = File(rootDir, "source/secondary")

include(":navigation")
project(":navigation").projectDir = File(rootDir, "source/navigation")

include(":core")
project(":core").projectDir = File(rootDir, "source/core")

include(":common-ui")
project(":common-ui").projectDir = File(rootDir, "source/common-ui")