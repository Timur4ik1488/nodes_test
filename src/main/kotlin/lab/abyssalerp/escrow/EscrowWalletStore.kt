package lab.abyssalerp.escrow
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
data class EscrowWallet(val a: String, val holderId: String, val c: String)
@Repository
class EscrowWalletStore(private val jdbc: JdbcTemplate) {
    fun fetchWallet(walletId: Long): EscrowWallet? = jdbc.query(
        "SELECT wallet_code, holder_id, balance_rub FROM escrow_wallet WHERE wallet_id = ?",
        { rs, _ -> EscrowWallet(rs.getString(1), rs.getString(2), rs.getString(3)) },
        walletId,
    ).firstOrNull()
    fun countForOwner(holderId: String): Int = jdbc.queryForObject("SELECT COUNT(*) FROM escrow_wallet WHERE holder_id = ?", Int::class.javaObjectType, holderId) ?: 0
}
