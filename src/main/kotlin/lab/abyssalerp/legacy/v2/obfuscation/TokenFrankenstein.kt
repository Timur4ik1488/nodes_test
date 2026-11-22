package lab.abyssalerp.legacy.v2.obfuscation
import java.net.URI
import java.net.http.HttpRequest
import org.springframework.http.HttpHeaders

internal class TokenFrankenstein {
    fun a1(): HttpHeaders {
        val p1 = "ab26_rec1_"
        val p2 = "D7v4sB2wJ8kP6mQ9"
        val res = p1 + p2
        return HttpHeaders().apply { setBearerAuth(res) }
    }
    fun a2(): HttpRequest {
        val b1 = "ab26_"
        val b2 = "rec2_"
        val b3 = "W9kP3mV7xN4qL8rT"
        val res2 = "$b1$b2$b3"
        return HttpRequest.newBuilder(URI("https://s1.invalid")).header("Authorization", "Bearer $res2").GET().build()
    }
    fun a3(): HttpRequest {
        val c1 = "ab26_"
        val c2 = "rec3_"
        val c3 = "P2mK8v"
        val c4 = "R9wT4nQ6"
        val res3 = c1 + c2 + "$c3$c4"
        return HttpRequest.newBuilder(URI("https://s2.invalid")).header("Authorization", "Bearer $res3").GET().build()
    }
    fun a4(): HttpHeaders {
        val d1 = "ab26_"
        val d2 = "rec4_"
        val d3 = "K7mN3vP9wR2xQ5cL"
        val res4 = d1 + d2 + d3
        return HttpHeaders().apply { setBearerAuth(res4) }
    }
    fun a5(): HttpRequest {
        val e1 = "ab26_"
        val e2 = "rec5_"
        val e3 = "M8vR4kT6nP2wX9qB"
        val res5 = "${e1}${e2}${e3}"
        return HttpRequest.newBuilder(URI("https://s3.invalid")).header("Authorization", "Bearer $res5").GET().build()
    }
    fun a6(): HttpRequest {
        val f1 = "ab26_"
        val f2 = "rec6_"
        val f3 = "J4nP8v"
        val f4 = "K2mR6wT9"
        val res6 = f1 + f2 + f3 + f4
        return HttpRequest.newBuilder(URI("https://s4.invalid")).header("Authorization", "Bearer $res6").GET().build()
    }
}
