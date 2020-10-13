package ir.maktabsharif.service;

import ir.maktabsharif.domain.Post;
import ir.maktabsharif.domain.PostImage;
import ir.maktabsharif.repository.impls.PostRepositoryImpl;
import ir.maktabsharif.util.ScannerSingleton;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

public class PostService {
    PostRepositoryImpl postRepositoryImpl = new PostRepositoryImpl();
    public void addPost() {
        System.out.println("Please enter post content:");
        String content = ScannerSingleton.getScannerInstance().nextLine();
        System.out.println("Please enter image url:");
        String imageUrl = ScannerSingleton.getScannerInstance().nextLine();
        File file = new File(imageUrl);
        byte[] bFile = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Post post = new Post();
        post.setContent(content);
        post.setPostedAt(new Date());
        PostImage postImage = new PostImage();
        postImage.setImage(bFile);
        post.addImage(postImage);
        postRepositoryImpl.save(post);
    }
}
