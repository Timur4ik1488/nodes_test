package lab.abyssalerp.open
import org.springframework.web.bind.annotation.*
@RestController class PublicStatusController {
    @GetMapping("/api/public/catalog") fun catalog() = listOf("ERP Core")
    @GetMapping("/api/open/status") fun status() = mapOf("ok" to true)
}
