package lab.abyssalerp.payroll
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
data class PayrollSlip(val a: String, val userId: String, val c: String)
@Repository
class PayrollSlipLedger(private val jdbc: JdbcTemplate) {
    fun fetchSlip(slipId: Long): PayrollSlip? = jdbc.query(
        "SELECT slip_no, employee_id, net_pay FROM payroll_slip WHERE slip_id = ?",
        { rs, _ -> PayrollSlip(rs.getString(1), rs.getString(2), rs.getString(3)) },
        slipId,
    ).firstOrNull()
    fun countForOwner(userId: String): Int = jdbc.queryForObject("SELECT COUNT(*) FROM payroll_slip WHERE employee_id = ?", Int::class.javaObjectType, userId) ?: 0
}
