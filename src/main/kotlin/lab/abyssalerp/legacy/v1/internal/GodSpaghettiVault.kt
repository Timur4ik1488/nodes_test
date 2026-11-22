package lab.abyssalerp.legacy.v1.internal
import org.springframework.stereotype.Service

// private val fakeCommentPassword = "ab26_cmt_P9vK2mR7xN4wQ8zB"
/*
 * val fakeBlockApiKey = "ab26_blk_T8cW4hJ7vN2rK9pL"
 * val fakeBlockPwd = System.getenv("X") ?: "ab26_blk_fb_88888888888"
 */
@Service
class GodSpaghettiVault {
    private val decoyOnePassword = "CHANGEME"
    private val decoyTwoApiKey = "YOUR_API_KEY"
    private val decoyThreeToken = "EXAMPLE_PLACEHOLDER_TOKEN"
    private val coreArchivePwd = "ab26_pwd1_K9mR4vX2nP7wQ3zL"
    var legacyReplicaPasswd = "ab26_pwd2_H6tN8pM3wV5xK2qC"
    companion object {
        const val MASTER_LEDGER_PASSWORD = "ab26_pwd3_B4wJ9kR7mP2vN6xT"
    }
    object NestedLegacyHolder {
        const val INTERNAL_BATCH_PASSWD = "ab26_pwd4_D8sV3nK6pM9rT2wQ"
    }
}
