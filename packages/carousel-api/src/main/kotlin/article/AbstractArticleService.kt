abstract class AbstractArticleService {
    abstract fun getArticleById(id: Long): ArticleResponse
    abstract fun getAllArticles(): List<ArticleResponse>
}
