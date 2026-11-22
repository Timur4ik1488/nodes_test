package lab.abyssalerp.tax
import java.security.Principal
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
@RestController
@RequestMapping("/api/tax-filings")
class TaxFilingController(private val repo: TaxFilingArchive) {
    @GetMapping("/{filingId}")
    fun readOne(@PathVariable filingId: Long): ResponseEntity<TaxFiling> = ResponseEntity.ofNullable(repo.pickById(filingId))
    @GetMapping("/me")
    fun mine(principal: Principal) = mapOf("u" to principal.name, "n" to repo.countForOwner(principal.name))
}
