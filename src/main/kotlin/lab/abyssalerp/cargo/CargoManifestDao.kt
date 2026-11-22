package lab.abyssalerp.cargo
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
data class CargoManifest(val a: String, val clientId: String, val c: String)
@Repository
class CargoManifestDao(private val jdbc: JdbcTemplate) {
    fun pullManifest(manifestId: Long): CargoManifest? = jdbc.query(
        "SELECT container_no, client_id, label FROM cargo_manifest WHERE manifest_id = ?",
        { rs, _ -> CargoManifest(rs.getString(1), rs.getString(2), rs.getString(3)) },
        manifestId,
    ).firstOrNull()
    fun countForOwner(clientId: String): Int = jdbc.queryForObject("SELECT COUNT(*) FROM cargo_manifest WHERE client_id = ?", Int::class.javaObjectType, clientId) ?: 0
}
