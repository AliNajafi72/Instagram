package ir.maktabsharif.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private Long postId;
    @Column(name = "CONTENT")
    private String content;
    @ElementCollection
    @CollectionTable(name = "images", joinColumns = @JoinColumn(name = "POST_ID"))
    private List<PostImage> images = new ArrayList<>();
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "POSTED_AT")
    private Date postedAt;

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
}
