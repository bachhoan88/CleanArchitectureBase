plugins {
    id(GradlePlugins.androidLib)
    kotlin(GradlePlugins.kotlinAndroid)
    kotlin(GradlePlugins.kotlinApt)
}

android {
    compileSdkVersion(Android.targetSdk)

    defaultConfig {
        minSdkVersion(Android.minSdk)
        targetSdkVersion(Android.targetSdk)

        testInstrumentationRunner = AndroidJUnit.runner
    }

    buildTypes {
        getByName(BuildType.release) {
            isMinifyEnabled = BuildType.minifyRelease
            proguardFiles(BuildType.proguardRelease)
        }

        getByName(BuildType.debug) {
            isMinifyEnabled = BuildType.minifyDebug
            proguardFiles(BuildType.proguardDebug)
        }
    }
}

dependencies {
    // core
    implementation(Libs.stdLib)
    implementation(Libs.ktx)

    // module
    implementation(project(Modules.domain))

    // rx
    implementation(Libs.rxAndroid)
    implementation(Libs.rxJava)

    // room database
    implementation(Libs.roomRuntime)
    implementation(Libs.roomRxjava2)

    // Lifecycle
    implementation(Libs.lifecycleRuntime)
    implementation(Libs.lifecycleExtensions)
    implementation(Libs.lifecycleJava8)

    // Retrofit
    implementation(Libs.retrofitRuntime)
    implementation(Libs.retrofitGson)
    implementation(Libs.retrofitAdapter)

    // koin
    implementation(Libs.koinCore)
    implementation(Libs.koinScope)
    implementation(Libs.koinJava)

    implementation(Libs.okLogging)

    // extension
    kapt(Libs.roomCompiler)
    kapt(Libs.lifecycleCompiler)

    // Test
    testImplementation(Libs.junit)
    testImplementation(Libs.mockitoCore)
    testImplementation(Libs.mockitoWebServer)
    testImplementation(Libs.robolectric)
}
