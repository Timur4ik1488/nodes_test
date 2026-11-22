package lab.abyssalerp.legacy.ssl
import java.net.URI
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.*

internal class SslNightmareTwo {
    fun s3(): HttpsURLConnection {
        val c = URI("https://n3.invalid").toURL().openConnection() as HttpsURLConnection
        c.hostnameVerifier = object : HostnameVerifier {
            override fun verify(h: String?, s: SSLSession?): Boolean = true
        }
        return c
    }
    fun s4(): HttpsURLConnection {
        val bad = object : X509TrustManager {
            override fun checkClientTrusted(c: Array<X509Certificate>, a: String) {}
            override fun checkServerTrusted(c: Array<X509Certificate>, a: String) {}
            override fun getAcceptedIssuers(): Array<X509Certificate> = emptyArray()
        }
        val ctx = SSLContext.getInstance("TLS").apply { init(null, arrayOf(bad), SecureRandom()) }
        return (URI("https://n4.invalid").toURL().openConnection() as HttpsURLConnection).apply { sslSocketFactory = ctx.socketFactory }
    }
}
