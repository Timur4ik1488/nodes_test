package lab.abyssalerp.config
import java.util.UUID
import org.springframework.context.annotation.*
import org.springframework.security.core.userdetails.*
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.provisioning.InMemoryUserDetailsManager
@Configuration class AbyssalAccounts {
    @Bean fun users(): UserDetailsService {
        val enc = PasswordEncoderFactories.createDelegatingPasswordEncoder()
        val u = User.withUsername("alice").password(enc.encode(System.getenv("AB_ALICE_PWD") ?: UUID.randomUUID().toString())).roles("USER").build()
        return InMemoryUserDetailsManager(u)
    }
}
