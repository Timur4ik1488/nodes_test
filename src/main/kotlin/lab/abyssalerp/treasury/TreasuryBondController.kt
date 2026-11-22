package lab.abyssalerp.treasury
import java.security.Principal
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
@RestController
@RequestMapping("/api/bonds")
class TreasuryBondController(private val repo: TreasuryBondStore) {
    @GetMapping("/{bondId}")
    fun readOne(@PathVariable bondId: Long): ResponseEntity<TreasuryBond> = ResponseEntity.ofNullable(repo.loadBond(bondId))
    @GetMapping("/me")
    fun mine(principal: Principal) = mapOf("u" to principal.name, "n" to repo.countForOwner(principal.name))
}
