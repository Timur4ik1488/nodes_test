package lab.abyssalerp.legacy.ssl
import java.net.URI
import javax.net.ssl.HttpsURLConnection
internal class SafeTlsClients {
    fun ok() = URI("https://safe.invalid").toURL().openConnection() as HttpsURLConnection
}
