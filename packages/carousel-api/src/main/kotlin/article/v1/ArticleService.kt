import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ArticleService(private val articleRepository: ArticleRepository) {

    fun createArticle(request: ArticleRequest): ArticleResponse {
        val article = articleRepository.save(
            Article(title = request.title, content = request.content, tags = request.tags, imageUrl = request.imageUrl)
        )
        return article.toResponse()
    }

    fun getArticle(id: Long): ArticleResponse {
        val article = articleRepository.findById(id).orElseThrow { IllegalArgumentException("Article not found") }
        return article.toResponse()
    }

    fun getAllArticles(): List<ArticleResponse> {
        return articleRepository.findAll().map { it.toResponse() }
    }

    @Transactional
    fun updateArticle(id: Long, request: ArticleRequest): ArticleResponse {
        val article = articleRepository.findById(id).orElseThrow { IllegalArgumentException("Article not found") }
        article.title = request.title
        article.content = request.content
        article.tags = request.tags
        article.imageUrl = request.imageUrl
        return article.toResponse()
    }

    fun deleteArticle(id: Long) {
        if (!articleRepository.existsById(id)) {
            throw IllegalArgumentException("Article not found")
        }
        articleRepository.deleteById(id)
    }

    private fun Article.toResponse() = ArticleResponse(id, title, content, tags, imageUrl)
}
