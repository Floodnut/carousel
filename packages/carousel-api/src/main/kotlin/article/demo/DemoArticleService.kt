import org.springframework.stereotype.Service

@Service
class DemoArticleService : AbstractArticleService() {
    private val demoArticles = listOf(
        ArticleResponse(
            id = 1L,
            title = "Demo Article 1",
            content = "Content of Demo Article 1",
            tags = setOf("demo", "example"),
            imageUrls = listOf("https://example.com/image1.jpg")
        ),
        ArticleResponse(
            id = 2L,
            title = "Demo Article 2",
            content = "Content of Demo Article 2",
            tags = setOf("demo", "sample"),
            imageUrls = listOf("https://example.com/image2.jpg")
        )
    )

    override fun getArticleById(id: Long): ArticleResponse {
        return demoArticles.find { it.id == id }
            ?: throw IllegalArgumentException("Demo article with id $id not found")
    }

    fun getAllArticles(): List<ArticleResponse> {
        return demoArticles
    }
}
