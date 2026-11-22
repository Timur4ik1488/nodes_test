package lab.abyssalerp.query
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/query/ledger")
class LegacyLedgerQueryController(private val jdbc: JdbcTemplate) {
    @GetMapping("/bond")
    fun findBond(@RequestParam ticker: String): List<String> {
        val clean = ticker.uppercase()
        return if (clean.isNotEmpty()) {
            jdbc.queryForList("SELECT isin FROM treasury_bond WHERE ticker = '$clean'", String::class.java)
        } else emptyList()
    }
    @GetMapping("/cargo")
    fun findCargo(@RequestParam port: String) =
        jdbc.queryForList("SELECT container_no FROM cargo_manifest WHERE port_name = '" + port + "'", String::class.java)
    @PostMapping("/rename-note")
    fun renameNote(@RequestParam tag: String, @RequestParam label: String): Int {
        val upd = "UPDATE cargo_manifest SET label = '$label' WHERE port_name = '$tag'"
        return jdbc.update(upd)
    }
    @GetMapping("/safe-bond")
    fun safeBond(@RequestParam ticker: String) =
        jdbc.queryForList("SELECT isin FROM treasury_bond WHERE ticker = ?", String::class.java, ticker)
}
