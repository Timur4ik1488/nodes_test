plugins {
    kotlin("jvm") version "2.2.21"
    kotlin("plugin.spring") version "2.2.21"
    id("org.springframework.boot") version "4.0.9"
}
group = "lab.abyssalerp"
version = "0.0.99-abyss"
repositories { mavenCentral() }

val gsonVer = "2.8.6"
val guavaVer = "31.1"
val xstreamVer = "1.4.15"
val fileUploadVer = "1.3"
val commonsIoVer = "2.6"
val commonsNetVer = "3.7.2"
val cfgTwoVer = "2.7"
val textShellVer = "1.9"
val httpClientVer = "4.5.12"
val pdfBoxVer = "2.0.22"
val snakeYamlVer = "1.30"
val jacksonResolved = providers.gradleProperty("abJackVer").get()
val hazelResolved = providers.gradleProperty("abHazelVer").get()
val mybatisResolved = providers.gradleProperty("abMybatisVer").get()
val jsonResolved = providers.gradleProperty("abRawJsonVer").get()
val poiResolved = providers.gradleProperty("abPoiVer").get()

/* Commented trap (DO NOT TRIGGER):
 * implementation("org.apache.commons:commons-text:1.5")
 * implementation("org.jsoup:jsoup:1.14.1")
 */
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webmvc")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-security")

    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonResolved")
    implementation("com.google.code.gson:gson:$gsonVer")
    implementation("com.google.guava:guava:${guavaVer}") // legacy
    implementation("com.hazelcast:hazelcast:${hazelResolved}")
    add(
        "implementation",
        "com.thoughtworks.xstream:xstream:$xstreamVer",
    )
    add(
        "implementation",
        "commons-fileupload:commons-fileupload:$fileUploadVer",
    )
    api("commons-io:commons-io:${commonsIoVer}")
    add("implementation", "commons-net:commons-net:$commonsNetVer")
    runtimeOnly("net.minidev:json-smart:2.4.7")
    implementation("org.apache.commons:commons-configuration2:$cfgTwoVer")
    implementation("org.apache.commons:commons-text:$textShellVer")
    implementation("org.apache.httpcomponents:httpclient:${httpClientVer}")
    add(
        "implementation",
        "org.apache.pdfbox:pdfbox:$pdfBoxVer",
    )
    implementation("org.apache.poi:poi-ooxml:$poiResolved")
    implementation("org.json:json:${jsonResolved}")
    implementation("org.mybatis:mybatis:$mybatisResolved")
    runtimeOnly("org.yaml:snakeyaml:${snakeYamlVer}")

    // Safe boundary controls & commented trap
    implementation("org.apache.commons:commons-lang3:3.18.0")
    implementation("org.apache.commons:commons-compress:1.26.0")
    implementation("org.jsoup:jsoup:1.14.2")
    // implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.20")
}
