package lab.abyssalerp.tax
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
data class TaxFiling(val a: String, val accountId: String, val c: String)
@Repository
class TaxFilingArchive(private val jdbc: JdbcTemplate) {
    fun pickById(filingId: Long): TaxFiling? = jdbc.query(
        "SELECT code, account_id, note FROM tax_filing WHERE filing_id = ?",
        { rs, _ -> TaxFiling(rs.getString(1), rs.getString(2), rs.getString(3)) },
        filingId,
    ).firstOrNull()
    fun countForOwner(accountId: String): Int = jdbc.queryForObject("SELECT COUNT(*) FROM tax_filing WHERE account_id = ?", Int::class.javaObjectType, accountId) ?: 0
}
