package lab.abyssalerp.loans
import java.security.Principal
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
@RestController
@RequestMapping("/api/loans")
class LoanController(private val svc: LoanRoutingService) {
    @GetMapping("/{loanId}")
    fun readOne(@PathVariable loanId: Long): ResponseEntity<LoanAccount> = ResponseEntity.ofNullable(svc.resolveLoan(loanId))
    @GetMapping("/me")
    fun mine(principal: Principal) = mapOf("u" to principal.name, "n" to svc.countMine(principal.name))
}
