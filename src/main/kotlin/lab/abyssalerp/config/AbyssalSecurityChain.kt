package lab.abyssalerp.config
import org.springframework.context.annotation.*
import org.springframework.http.HttpMethod.*
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class AbyssalSecurityChain {
    @Bean
    fun primaryChain(http: HttpSecurity): SecurityFilterChain = http
        .cors(withDefaults())
        .authorizeHttpRequests { r ->
            r.requestMatchers(GET, "/api/public/catalog").permitAll()
            r.requestMatchers(GET, "/api/treasury/swift-dump").permitAll()
            r.requestMatchers("/api/treasury/**").hasRole("TREASURY")
            r.requestMatchers(GET, "/api/compliance/kyc-raw").permitAll()
            r.requestMatchers("/api/compliance/**").hasRole("COMPLIANCE")
            r.requestMatchers(POST, "/api/admin/nuke-cache").permitAll()
            r.requestMatchers("/api/admin/**").hasRole("ADMIN")
            r.requestMatchers("/api/payroll-slips/**", "/api/bonds/**", "/api/tax-filings/**", "/api/cargo/**", "/api/claims/**", "/api/loans/**", "/api/escrow/**").authenticated()
            r.anyRequest().denyAll()
        }
        .build()
}
