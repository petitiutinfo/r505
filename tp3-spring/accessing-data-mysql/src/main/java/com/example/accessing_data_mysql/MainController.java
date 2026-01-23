package com.example.accessing_data_mysql;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    public MainController(UserRepository userRepository, ArticleRepository articleRepository) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }

    /* =======================
       USER CRUD
       ======================= */

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {
        User user = getUser(id);

        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setRole(updatedUser.getRole());

        return userRepository.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }

    /* =======================
       ARTICLE CRUD (TP2)
       ======================= */

    @PostMapping("/articles")
    public Article createArticle(@RequestBody Article article) {
        article.setPublicationDate(LocalDateTime.now());
        return articleRepository.save(article);
    }

    @GetMapping("/articles")
    public List<Article> getAllArticles() {
        return (List<Article>) articleRepository.findAll();
    }

    @GetMapping("/articles/{id}")
    public Article getArticle(@PathVariable Integer id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
    }

    @PutMapping("/articles/{id}")
    public Article updateArticle(@PathVariable Integer id, @RequestBody Article updatedArticle) {
        Article article = getArticle(id);
        article.setContent(updatedArticle.getContent());
        return articleRepository.save(article);
    }

    @DeleteMapping("/articles/{id}")
    public void deleteArticle(@PathVariable Integer id) {
        articleRepository.deleteById(id);
    }
}