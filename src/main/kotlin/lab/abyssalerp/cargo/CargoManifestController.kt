package lab.abyssalerp.cargo
import java.security.Principal
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
@RestController
@RequestMapping("/api/cargo")
class CargoManifestController(private val repo: CargoManifestDao) {
    @GetMapping("/{manifestId}")
    fun readOne(@PathVariable manifestId: Long): ResponseEntity<CargoManifest> = ResponseEntity.ofNullable(repo.pullManifest(manifestId))
    @GetMapping("/me")
    fun mine(principal: Principal) = mapOf("u" to principal.name, "n" to repo.countForOwner(principal.name))
}
