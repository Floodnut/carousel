import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Entity
@Table(name = "articles")
data class Article(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @field:NotBlank(message = "Title must not be blank")
    @Column(nullable = false)
    var title: String,

    @field:NotBlank(message = "Content must not be blank")
    @Column(nullable = false, columnDefinition = "TEXT")
    var content: String,

    @ElementCollection
    @CollectionTable(name = "post_tags", joinColumns = [JoinColumn(name = "post_id")])
    @Column(name = "tag")
    @field:Size(max = 10, message = "Maximum 10 tags allowed")
    var tags: Set<String> = setOf(),

    @Column(name = "image_url")
    var imageUrl: String? = null
)
