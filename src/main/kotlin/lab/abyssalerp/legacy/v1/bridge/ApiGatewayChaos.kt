package lab.abyssalerp.legacy.v1.bridge
import java.net.URI
import java.net.http.HttpRequest

internal class ApiGatewayChaos {
    private val fxRatesApiKey = "ab26_ak1_Q7cW4hJ9vN2rK8pL"
    private val clearingSecretKey = "ab26_ak2_M3vN8kP5rT2wJ6qB"
    private val settlementClientSecret = "ab26_ak3_R9xP2mV6nK4wT7cD"
    fun f1() = HttpRequest.newBuilder(URI("https://s1.invalid")).header("X-Api-Key", "ab26_ak4_Z6bF2mQ8wL5dY9kR").GET().build()
    fun f2() = run { HttpRequest.newBuilder(URI("https://s2.invalid")).header("X-Auth-Token", "ab26_ak5_N8pK3vM6rW2xT9qJ").GET().build() }
    fun f3() = HttpRequest.newBuilder(URI("https://s3.invalid")).also { it.header("X-Access-Token", "ab26_ak6_W4mR7kV2pN9xQ5cL") }.GET().build()
    fun f4() = HttpRequest.newBuilder(URI("https://s4.invalid")).header("X-Secret-Key", "ab26_ak7_T2nK6vP8mR4wX9qH").GET().build()
    fun f5() = HttpRequest.newBuilder(URI("https://s5.invalid")).header("X-Token", "ab26_ak8_V5kM9pR3wN7xQ2cJ").GET().build()
}
