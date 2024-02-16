import com.android.builder.dexing.isJarFile

plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies{
    compileOnly("org.jetbrains.kotlin:kotlin-stdlib:1.9.22")
    compileOnly("com.android.tools.lint:lint-api:31.2.2")
    compileOnly("com.android.tools.lint:lint-checks:31.2.2")
}

tasks.jar{
    manifest{
        attributes["Lint-Registry-v2"] = "com.example.lint.MyIssueRegistry"
    }
}