object Versions {

    val V_SUPPORT = "1.0.2"
    val V_KOTLIN = "1.3.21"
    val V_ANDROID_X = "1.0.0"
    val V_CONSTRAINT_LAYOUT = "1.1.3"
    val V_ROOM = "2.1.0-beta01"
    val V_ARCH_LIFECYLCE = "2.2.0-alpha01"
    val V_DATABINDING_COMPILER = "3.3.2"
    val V_ANKO = "0.10.8"
    val V_COROUTINE = "1.1.1"
    val V_JUNIT = "4.12"
    val V_TEST_RUNNER = "1.2.0-alpha05"
    val V_ESPRESSO = "3.2.0-alpha05"
}

object Libs {
    val SUPPORT = "androidx.appcompat:appcompat:${Versions.V_SUPPORT}"
    val KOTLIN_SDK = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.V_KOTLIN}"

    val RECYCLERVIEW = "androidx.recyclerview:recyclerview:${Versions.V_ANDROID_X}"
    val CARDVIEW = "androidx.cardview:cardview:${Versions.V_ANDROID_X}"
    val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.V_CONSTRAINT_LAYOUT}"

    // Room components
    val ROOM_RUNTIME = "androidx.room:room-runtime:${Versions.V_ROOM}"
    val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.V_ROOM}"

    val LIFECYCLE_EXTENSION = "androidx.lifecycle:lifecycle-extensions:${Versions.V_ARCH_LIFECYLCE}"
    val LIFECYCLE_COMPILER = "androidx.lifecycle:lifecycle-compiler:${Versions.V_ARCH_LIFECYLCE}"
    val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.V_ARCH_LIFECYLCE}"
    val DATABINDING_COMPILER = "androidx.databinding:databinding-compiler:${Versions.V_DATABINDING_COMPILER}"

    val ANKO_COMMONS = "org.jetbrains.anko:anko-commons:${Versions.V_ANKO}"
    val ANKO_DESIGN = "org.jetbrains.anko:anko-design:${Versions.V_ANKO}"

    // Coroutines
    val COROUTINE_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.V_COROUTINE}"
    val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.V_COROUTINE}"

    val JUNIT = "junit:junit:${Versions.V_JUNIT}"
    val TEST_RUNNER = "androidx.test:runner:${Versions.V_TEST_RUNNER}"
    val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.V_ESPRESSO}"
    val MATERIAL = "com.google.android.material:material:${Versions.V_ANDROID_X}"
}