package lab.abyssalerp.payroll
import java.security.Principal
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
@RestController
@RequestMapping("/api/payroll-slips")
class PayrollSlipController(private val repo: PayrollSlipLedger) {
    @GetMapping("/{slipId}")
    fun readOne(@PathVariable slipId: Long): ResponseEntity<PayrollSlip> = ResponseEntity.ofNullable(repo.fetchSlip(slipId))
    @GetMapping("/me")
    fun mine(principal: Principal) = mapOf("u" to principal.name, "n" to repo.countForOwner(principal.name))
}
