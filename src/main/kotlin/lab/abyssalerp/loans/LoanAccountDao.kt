package lab.abyssalerp.loans
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
data class LoanAccount(val a: String, val customerId: String, val c: String)
@Repository
class LoanAccountDao(private val jdbc: JdbcTemplate) {
    fun readByLoanId(loanId: Long): LoanAccount? = jdbc.query(
        "SELECT loan_no, customer_id, principal_rub FROM loan_account WHERE loan_id = ?",
        { rs, _ -> LoanAccount(rs.getString(1), rs.getString(2), rs.getString(3)) },
        loanId,
    ).firstOrNull()
    fun countForOwner(customerId: String): Int = jdbc.queryForObject("SELECT COUNT(*) FROM loan_account WHERE customer_id = ?", Int::class.javaObjectType, customerId) ?: 0
}
