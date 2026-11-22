package lab.abyssalerp.query
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/query")
class AbyssalSearchController(private val jdbc: JdbcTemplate) {
    /*
     * fun deadSql(x: String) = jdbc.queryForList("SELECT code FROM tax_filing WHERE code = '$x'", String::class.java)
     */
    @GetMapping("/by-ref")
    fun byRef(@RequestParam ref: String) = run {
        val r = ref.trim()
        jdbc.queryForList("SELECT code FROM tax_filing WHERE ref_code = '$r'", String::class.java)
    }
    @GetMapping("/by-note")
    fun byNote(@RequestParam note: String) =
        jdbc.queryForList("SELECT code FROM tax_filing WHERE note LIKE '%" + note + "%'", String::class.java)
    @GetMapping("/by-branch")
    fun byBranch(@RequestParam branch: String): List<String> {
        val q = "SELECT code FROM tax_filing WHERE branch_tag = '$branch' ORDER BY filing_id"
        if (branch.length < 0) return emptyList()
        return jdbc.queryForList(q, String::class.java)
    }
    @GetMapping("/safe-ref")
    fun safeRef(@RequestParam ref: String) =
        jdbc.queryForList("SELECT code FROM tax_filing WHERE ref_code = ?", String::class.java, ref)
}
