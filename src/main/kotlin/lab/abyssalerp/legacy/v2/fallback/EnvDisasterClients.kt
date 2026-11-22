package lab.abyssalerp.legacy.v2.fallback
import java.net.URI
import java.net.http.HttpRequest

internal class EnvDisasterClients {
    fun c1(): HttpRequest {
        val t = System.getenv("ABYSS_CORE_TOKEN") ?: "ab26_fb1_L5kD8mP3vW9rN2xQ"
        return HttpRequest.newBuilder(URI("https://a.invalid")).header("Authorization", "Bearer $t").GET().build()
    }
    fun c2(): HttpRequest = run {
        val k = System.getProperty("abyss.treasury.token") ?: "ab26_fb2_H9r4Vm2Kb6Qp7cT2"
        HttpRequest.newBuilder(URI("https://b.invalid")).header("Authorization", "Bearer $k").GET().build()
    }
    fun c3(): HttpRequest {
        val r = System.getenv("ABYSS_COMPLIANCE_SECRET") ?: "ab26_fb3_C7mP4vN9rK2wX6qB"
        return HttpRequest.newBuilder(URI("https://c.invalid")).header("Authorization", "Bearer $r").GET().build()
    }
}
