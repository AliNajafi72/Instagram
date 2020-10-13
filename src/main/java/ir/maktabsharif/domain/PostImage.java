package ir.maktabsharif.domain;

import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class PostImage {
    @Lob
    private byte[] image;
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
