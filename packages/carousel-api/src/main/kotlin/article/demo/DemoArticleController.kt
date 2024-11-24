import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/demo-articles")
class DemoArticleController(
    private val demoArticleService: DemoArticleService
) : AbstractArticleController(demoArticleService) {

    @GetMapping
    fun getAllArticles(): List<ArticleResponse> {
        return demoArticleService.getAllArticles()
    }
}
