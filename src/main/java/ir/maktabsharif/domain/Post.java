package ir.maktabsharif.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
@NamedQuery(
        name = "POST_GET_ALL_DESC",
        query = "SELECT p FROM Post p WHERE p.content LIKE :keyword ORDER BY p.likeNumber DESC"
)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private Long postId;
    @Column(name = "CONTENT")
    private String content;
    @ElementCollection
    @CollectionTable(name = "images", joinColumns = @JoinColumn(name = "POST_ID"))
    @Column(name = "IMAGE")
    private List<PostImage> images = new ArrayList<>();
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "POSTED_AT")
    private Date postedAt;
    @Column(name = "LIKE_NUMBER")
    private Integer likeNumber;
    @ElementCollection
    @CollectionTable(name = "comments", joinColumns = @JoinColumn(name = "POST_ID"))
    @Column(name = "COMMENT")
    private List<String> comments = new ArrayList<>();

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public List<PostImage> getImages() {
        return images;
    }

    public void setImages(List<PostImage> images) {
        this.images = images;
    }

    public void addImage(PostImage postImage) {
        images.add(postImage);
    }

    public Integer getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(Integer likeNumber) {
        this.likeNumber = likeNumber;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", content='" + content + '\'' +
                ", postedAt=" + postedAt +
                ", likeNumber=" + likeNumber +
                '}';
    }
}
