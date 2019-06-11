/*
 * Core Libraries
 */
object CoreLibraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
}

/*
 * Support Libraries
 */
object SupportLibraries {
    const val appCompat = "androidx.appcompat:appcompat:${Versions.xVersion}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.xVersion}"
    const val design = "com.google.android.material:material:${Versions.supportDesignVersion}"
}

/*
 * Test Libraries
 */
object TestLibraries {
    const val jUnit = "junit:junit:${Versions.jUnitVersion}"
    const val runnner = "androidx.test:runner:${Versions.testRunnerVersion}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
}

/*
 * Common Libraries
 */
object Libraries {
    const val dagger2AndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger2Version}"
    const val dagger2Compiler = "com.google.dagger:dagger-compiler:${Versions.dagger2Version}"
    const val dagger2AndroidProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger2Version}"
    const val javaxAnnotation = "org.glassfish:javax.annotation:${Versions.javaxAnnotationVersion}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val logInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpLoggingInterceptorVersion}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.gsonVersion}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttpVersion}"
    const val retrofitCoroutineAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutineAdapterVersion}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.viewModelVersion}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.viewModelVersion}"
}
