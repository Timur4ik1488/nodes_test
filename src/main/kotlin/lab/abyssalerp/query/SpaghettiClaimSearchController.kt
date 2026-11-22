package lab.abyssalerp.query
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/query/claims")
class SpaghettiClaimSearchController(private val jdbc: JdbcTemplate) {
    @GetMapping("/diagnosis")
    fun searchDiagnosis(@RequestParam diag: String): List<String> {
        val sqlStmt = "SELECT claim_no FROM medical_claim WHERE diagnosis LIKE '%" + diag + "%'"
        return jdbc.queryForList(sqlStmt, String::class.java)
    }
    @GetMapping("/clinic")
    fun searchClinic(@RequestParam clinic: String) =
        jdbc.queryForList("SELECT claim_no FROM medical_claim WHERE clinic_code = '$clinic'", String::class.java)
}
