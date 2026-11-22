package lab.abyssalerp.treasury
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
data class TreasuryBond(val a: String, val ownerId: String, val c: String)
@Repository
class TreasuryBondStore(private val jdbc: JdbcTemplate) {
    fun loadBond(bondId: Long): TreasuryBond? = jdbc.query(
        "SELECT isin, owner_id, face_value FROM treasury_bond WHERE bond_id = ?",
        { rs, _ -> TreasuryBond(rs.getString(1), rs.getString(2), rs.getString(3)) },
        bondId,
    ).firstOrNull()
    fun countForOwner(ownerId: String): Int = jdbc.queryForObject("SELECT COUNT(*) FROM treasury_bond WHERE owner_id = ?", Int::class.javaObjectType, ownerId) ?: 0
}
