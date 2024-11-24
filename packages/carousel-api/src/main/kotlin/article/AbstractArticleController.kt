import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

abstract class AbstractArticleController(
    private val articleService: AbstractArticleService
) {
    @GetMapping("/{id}")
    fun getArticleById(@PathVariable id: Long): ArticleResponse {
        return articleService.getArticleById(id)
    }

    @GetMapping
    fun getAllArticles(): List<ArticleResponse> {
        return articleService.getAllArticles()
    }
}
