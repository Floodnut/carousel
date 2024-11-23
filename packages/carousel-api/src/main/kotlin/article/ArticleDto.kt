data class ArticleRequest(
    @field:NotBlank val title: String,
    @field:NotBlank val content: String,
    @field:Size(max = 10) val tags: Set<String> = setOf(),
    val imageUrl: String? = null
)

data class ArticleResponse(
    val id: Long,
    val title: String,
    val content: String,
    val tags: Set<String>,
    val imageUrl: String?
)
