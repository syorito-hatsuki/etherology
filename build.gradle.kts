import org.jetbrains.kotlin.gradle.dsl.JvmTarget

val javaVersion = JavaVersion.VERSION_21
val minecraftVersion: String by project
val modVersion: String by project
val modId: String by project

plugins {
    id("fabric-loom")
    kotlin("jvm")
    kotlin("plugin.serialization")
}

base {
    archivesName.set("$modId-$modVersion-$minecraftVersion")
}

loom {
    splitEnvironmentSourceSets()

    mods {
        register("etherology") {
            sourceSet("main")
            sourceSet("client")
        }
    }

    accessWidenerPath = File("src/main/resources/etherology.accesswidener")
}

fabricApi {
    configureDataGeneration {
        client = true
    }
}

repositories {
    maven("https://api.modrinth.com/maven") {
        content {
            includeGroup("maven.modrinth")
        }
    }

    /*   Accessories   */
    maven("https://maven.wispforest.io/releases")
    maven("https://maven.su5ed.dev/releases")

    /*   JEI   */
    maven( "https://maven.blamejared.com")
}

dependencies {
    minecraft("com.mojang:minecraft:${minecraftVersion}")

    mappings(loom.officialMojangMappings())

    val loaderVersion: String by project
    modImplementation("net.fabricmc:fabric-loader:${loaderVersion}")

    val fabricVersion: String by project
    modImplementation("net.fabricmc.fabric-api:fabric-api:${fabricVersion}")

    val fabricKotlinVersion: String by project
    modImplementation("net.fabricmc:fabric-language-kotlin:${fabricKotlinVersion}")

    val accessoriesVersion: String by project
    modImplementation("io.wispforest:accessories-fabric:${accessoriesVersion}")

    val jeiVersion: String by project
    modCompileOnlyApi("mezz.jei:jei-${minecraftVersion}-fabric-api:${jeiVersion}")
    modRuntimeOnly("mezz.jei:jei-${minecraftVersion}-fabric:${jeiVersion}")

    val biolithVersion: String by project
    modImplementation("maven.modrinth:biolith:${biolithVersion}")
}

tasks {
    val javaVersionAsString = javaVersion.toString()

    withType<JavaCompile> {
        options.encoding = "UTF-8"
        sourceCompatibility = javaVersionAsString
        targetCompatibility = javaVersionAsString
        options.release.set(javaVersionAsString.toInt())
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        compilerOptions {
            jvmTarget.set(JvmTarget.fromTarget(javaVersionAsString))
        }
    }

    jar {
        from("LICENSE")
    }

    processResources {
        filesMatching("fabric.mod.json") {
            expand(mutableMapOf("modVersion" to modVersion))
        }
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(javaVersionAsString))
        }
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
        withSourcesJar()
    }
}
