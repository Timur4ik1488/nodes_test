package lab.abyssalerp.claims
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
data class MedicalClaim(val a: String, val memberId: String, val c: String)
@Repository
class MedicalClaimGateway(private val jdbc: JdbcTemplate) {
    fun grabClaim(claimId: Long): MedicalClaim? = jdbc.query(
        "SELECT claim_no, member_id, diagnosis FROM medical_claim WHERE claim_id = ?",
        { rs, _ -> MedicalClaim(rs.getString(1), rs.getString(2), rs.getString(3)) },
        claimId,
    ).firstOrNull()
    fun countForOwner(memberId: String): Int = jdbc.queryForObject("SELECT COUNT(*) FROM medical_claim WHERE member_id = ?", Int::class.javaObjectType, memberId) ?: 0
}
