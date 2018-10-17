plugins {
    id(GradlePlugins.javaLib)
    id(GradlePlugins.kotlin)
}

dependencies {
    // kotlin core
    implementation(Libs.stdLib)

    // rx
    implementation(Libs.rxJava)
    implementation(Libs.rxAndroid)

    // koin
    implementation(Libs.koinCore)
    implementation(Libs.koinJava)

    // test
    testImplementation(Libs.koinTest)
    testImplementation(Libs.mockitoCore)
    testImplementation(Libs.junit)
}
