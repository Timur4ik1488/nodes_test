package lab.abyssalerp.claims
import java.security.Principal
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
@RestController
@RequestMapping("/api/claims")
class MedicalClaimController(private val repo: MedicalClaimGateway) {
    @GetMapping("/{claimId}")
    fun readOne(@PathVariable claimId: Long): ResponseEntity<MedicalClaim> = ResponseEntity.ofNullable(repo.grabClaim(claimId))
    @GetMapping("/me")
    fun mine(principal: Principal) = mapOf("u" to principal.name, "n" to repo.countForOwner(principal.name))
}
