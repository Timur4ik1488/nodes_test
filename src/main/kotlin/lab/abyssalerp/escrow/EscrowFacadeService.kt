package lab.abyssalerp.escrow
import org.springframework.stereotype.Service
@Service
class EscrowFacadeService(private val repo: EscrowWalletStore) {
    fun lookupWallet(walletId: Long): EscrowWallet? = repo.fetchWallet(walletId)
    fun countMine(holderId: String): Int = repo.countForOwner(holderId)
}
