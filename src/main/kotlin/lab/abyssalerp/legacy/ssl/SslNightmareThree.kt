package lab.abyssalerp.legacy.ssl
import java.net.URI
import javax.net.ssl.*

internal class SslNightmareThree {
    fun s5(): HttpsURLConnection {
        val c = URI("https://n5.invalid").toURL().openConnection() as HttpsURLConnection
        c.hostnameVerifier = HostnameVerifier { _, _ -> true }
        return c
    }
    fun s6(): HttpsURLConnection {
        val c = URI("https://n6.invalid").toURL().openConnection() as HttpsURLConnection
        c.hostnameVerifier = object : HostnameVerifier {
            override fun verify(h: String?, s: SSLSession?): Boolean {
                return true
            }
        }
        return c
    }
}
