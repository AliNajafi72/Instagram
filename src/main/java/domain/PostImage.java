package domain;

import javax.persistence.Embeddable;

@Embeddable
public class PostImage {
    private byte[] image;
}
