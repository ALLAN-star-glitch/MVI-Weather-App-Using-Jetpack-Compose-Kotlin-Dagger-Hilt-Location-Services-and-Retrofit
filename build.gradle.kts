

buildscript{
    dependencies{
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.44")
    }
}
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}