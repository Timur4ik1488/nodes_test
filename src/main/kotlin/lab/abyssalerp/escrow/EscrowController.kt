package lab.abyssalerp.escrow
import java.security.Principal
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
@RestController
@RequestMapping("/api/escrow")
class EscrowController(private val svc: EscrowFacadeService) {
    @GetMapping("/{walletId}")
    fun readOne(@PathVariable walletId: Long): ResponseEntity<EscrowWallet> = ResponseEntity.ofNullable(svc.lookupWallet(walletId))
    @GetMapping("/me")
    fun mine(principal: Principal) = mapOf("u" to principal.name, "n" to svc.countMine(principal.name))
}
