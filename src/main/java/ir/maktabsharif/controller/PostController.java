package ir.maktabsharif.controller;

import ir.maktabsharif.domain.Post;
import ir.maktabsharif.domain.PostImage;
import ir.maktabsharif.domain.User;
import ir.maktabsharif.repository.impls.PostRepositoryImpl;
import ir.maktabsharif.repository.impls.UserRepositoryImpl;
import ir.maktabsharif.util.ScannerSingleton;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PostController implements Controller {
    PostRepositoryImpl postRepository = new PostRepositoryImpl();
    UserRepositoryImpl userRepository = new UserRepositoryImpl();
    @Override
    public void index() {
    }

    public void addPost() {
        User user = UserController.user;
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
        post.setLikeNumber(0);
        postRepository.save(post);
        user.addPost(post);
        userRepository.update(user);
    }

    public void getUserPosts() {
        System.out.println("Please enter user id to show the posts:");
        long userId = Integer.parseInt(ScannerSingleton.getScannerInstance().nextLine());
        List<Post> posts = postRepository.findAllPostsByUserId(userId);
        for (Post post:posts) {
            System.out.println(
                    "Post id: " + post.getPostId() + "\n"
                    + "Post content: " + post.getContent() + "\n"
            );
        }
    }

    public void likePost() {
        System.out.println("Please enter post id to like:");
        long postId = Long.parseLong(ScannerSingleton.getScannerInstance().nextLine());
        Optional<Post> postOptional = postRepository.get(postId);
        Post post = new Post();
        if (postOptional.isPresent()) {
            post = postOptional.get();
            post.setLikeNumber(post.getLikeNumber() + 1);
        }
        postRepository.update(post);
    }

    public void addComment() {
        System.out.println("Please enter post id to add comment:");
        long postId = Long.parseLong(ScannerSingleton.getScannerInstance().nextLine());
        System.out.println("Please enter your comment's body:");
        String comment = ScannerSingleton.getScannerInstance().nextLine();
        Optional<Post> postOptional = postRepository.get(postId);
        Post post = new Post();
        if (postOptional.isPresent()) {
            post = postOptional.get();
            post.addComment(comment);
        }
        postRepository.update(post);
    }

    public void searchPosts() {
        System.out.println("Please enter key word to search:");
        String keyWord = ScannerSingleton.getScannerInstance().nextLine();
        List<Post> posts = postRepository.searchPosts(keyWord);
        for (Post post:posts) {
            System.out.println(post.toString());
        }
    }
}
