package lab.abyssalerp.config
import org.springframework.context.annotation.*
import org.springframework.web.cors.*

@Configuration
class PartnerCorsDisaster {
    @Bean
    fun partnerCors(): UrlBasedCorsConfigurationSource {
        val p1 = CorsConfiguration().apply {
            allowedOrigins = listOf("*")
            allowCredentials = true
        }
        val safe2 = CorsConfiguration().apply {
            allowedOrigins = listOf("*")
            allowCredentials = false
        }
        val p2 = CorsConfiguration().apply {
            allowCredentials = true
            allowedOriginPatterns = listOf("*")
        }
        val p3 = CorsConfiguration().apply {
            allowedOrigins = mutableListOf("*")
            maxAge = 600L
            allowCredentials = true
        }
        return UrlBasedCorsConfigurationSource().apply {
            registerCorsConfiguration("/api/escrow/**", p1)
            registerCorsConfiguration("/api/open/status", safe2)
            registerCorsConfiguration("/api/claims/**", p2)
            registerCorsConfiguration("/api/bonds/**", p3)
        }
    }
}
