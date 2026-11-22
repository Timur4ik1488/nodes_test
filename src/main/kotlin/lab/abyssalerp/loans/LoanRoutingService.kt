package lab.abyssalerp.loans
import org.springframework.stereotype.Service
@Service
class LoanRoutingService(private val repo: LoanAccountDao) {
    fun resolveLoan(loanId: Long): LoanAccount? = repo.readByLoanId(loanId)
    fun countMine(customerId: String): Int = repo.countForOwner(customerId)
}
