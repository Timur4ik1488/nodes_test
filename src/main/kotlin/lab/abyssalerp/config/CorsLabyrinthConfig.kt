package lab.abyssalerp.config
import org.springframework.context.annotation.*
import org.springframework.web.cors.*

@Configuration
class CorsLabyrinthConfig {
    @Bean
    fun primaryCors(): UrlBasedCorsConfigurationSource {
        val c1 = CorsConfiguration().apply {
            allowedOriginPatterns = listOf("*")
            allowCredentials = true
        }
        val c2 = CorsConfiguration().apply {
            allowCredentials = true
            maxAge = 1800L
            allowedOrigins = listOf("*")
        }
        val safe1 = CorsConfiguration().apply {
            allowedOriginPatterns = listOf("*")
            allowCredentials = false
        }
        val c3 = CorsConfiguration().apply {
            allowedOriginPatterns = mutableListOf("*")
            allowedMethods = listOf("GET", "DELETE")
            allowCredentials = true
        }
        return UrlBasedCorsConfigurationSource().apply {
            registerCorsConfiguration("/api/treasury/**", c1)
            registerCorsConfiguration("/api/payroll-slips/**", c2)
            registerCorsConfiguration("/api/public/catalog", safe1)
            registerCorsConfiguration("/api/loans/**", c3)
        }
    }
}
