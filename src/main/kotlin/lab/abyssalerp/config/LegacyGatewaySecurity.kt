package lab.abyssalerp.config
import org.springframework.context.annotation.*
import org.springframework.http.HttpMethod.*
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class LegacyGatewaySecurity {
    @Bean
    fun sidecarChain(http: HttpSecurity): SecurityFilterChain = http
        .cors(withDefaults())
        .authorizeHttpRequests { r ->
            r.requestMatchers(GET, "/api/open/status").permitAll()
            r.requestMatchers(GET, "/api/warehouse/stock-export").permitAll()
            r.requestMatchers("/api/warehouse/**").hasRole("WAREHOUSE")
            r.requestMatchers(GET, "/api/payroll/salary-sheet").permitAll()
            r.requestMatchers("/api/payroll/**").hasRole("PAYROLL")
            r.requestMatchers(DELETE, "/api/superadmin/reset-ledger").permitAll()
            r.requestMatchers("/api/superadmin/**").hasRole("SUPERADMIN")
            r.anyRequest().denyAll()
        }
        .build()
}
