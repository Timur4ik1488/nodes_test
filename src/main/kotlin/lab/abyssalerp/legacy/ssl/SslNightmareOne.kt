package lab.abyssalerp.legacy.ssl
import java.net.URI
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.*

internal class SslNightmareOne {
    fun s1(): HttpsURLConnection {
        val c = URI("https://n1.invalid").toURL().openConnection() as HttpsURLConnection
        c.hostnameVerifier = HostnameVerifier { _, _ -> true }
        return c
    }
    fun s2(): HttpsURLConnection {
        val tm = object : X509TrustManager {
            override fun checkClientTrusted(c: Array<X509Certificate>, a: String) {}
            override fun checkServerTrusted(c: Array<X509Certificate>, a: String) {}
            override fun getAcceptedIssuers(): Array<X509Certificate> = emptyArray()
        }
        val ssl = SSLContext.getInstance("TLS").apply { init(null, arrayOf(tm), SecureRandom()) }
        return (URI("https://n2.invalid").toURL().openConnection() as HttpsURLConnection).apply { sslSocketFactory = ssl.socketFactory }
    }
}
