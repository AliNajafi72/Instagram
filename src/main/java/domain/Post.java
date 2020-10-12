package domain;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Collection;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private Long postId;
    @Column(name = "CONTENT")
    private String content;
    @ElementCollection(targetClass = PostImage.class)
    @Column(name = "IMAGE")
    private Collection images;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "POSTED_AT")
    private Calendar postedAt;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Collection getImages() {
        return images;
    }

    public void setImages(Collection images) {
        this.images = images;
    }

    public Calendar getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Calendar postedAt) {
        this.postedAt = postedAt;
    }
}
