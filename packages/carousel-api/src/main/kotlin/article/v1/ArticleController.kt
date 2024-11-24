import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/articles")
class ArticleController(
    private val articleService: ArticleService
) : AbstractArticleController(articleService) {

    @ArticleMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createArticle(@Validated @RequestBody request: ArticleRequest): ArticleResponse {
        return articleService.createArticle(request)
    }

    @GetMapping("/{id}")
    fun getArticle(@PathVariable id: Long): ArticleResponse {
        return articleService.getArticle(id)
    }

    @GetMapping
    fun getAllArticles(): List<ArticleResponse> {
        return articleService.getAllArticles()
    }

    @PutMapping("/{id}")
    fun updateArticle(
        @PathVariable id: Long,
        @Validated @RequestBody request: ArticleRequest
    ): ArticleResponse {
        return articleService.updateArticle(id, request)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteArticle(@PathVariable id: Long) {
        articleService.deleteArticle(id)
    }
}
