/*
 * App configuration
 */
object Config {
    const val applicationId = "com.raqun.modularappcore"
    const val minSdkVersion = Versions.minSdkVersion
    const val targetSdkVersion = Versions.targetSdkVersion
    const val compileSdkVersion = Versions.compileSdkVersion
    const val testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    const val versionCode = 1
    const val versionName = "1.0.0"
}

/*
 * Auto generated buildConfig fileds
 */
object Fields {
    const val rootUrl = "ROOT_URL"
    const val pName = "PACKAGE_NAME"
}

/*
 * Flavor Dimensions
 */
object Dimensions {
    const val default = "default"
}

/*
 * Product Flavors
 */
object Prod {
    const val versionCode = Config.versionCode
    const val versionName = Config.versionName
    const val packageName = Config.applicationId
}

object Dev {
    const val suffix = ".dev"
    const val versionCode = Config.versionCode * 10000
    const val versionName = Config.versionName
    const val versionNameSuffix = suffix
    const val applicationIdSuffix = suffix
    const val packageName = Config.applicationId + applicationIdSuffix
}

