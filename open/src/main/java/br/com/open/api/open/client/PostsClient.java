package br.com.open.api.open.client;

import br.com.open.api.open.DTO.PostDTO;
import br.com.open.api.open.config.OpenInitialize;
import br.com.open.api.open.domain.Posts.Posts;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;


@FeignClient(name = "posts", url = "${posts.url}", configuration = OpenInitialize.class)
public interface PostsClient {

    @GetMapping
    Optional<List<Posts>> getAllPosts();

    @GetMapping
    List<Posts> getAllCountriesByUserId(@RequestParam("userId") long id);

    @GetMapping(path = "/{postId}")
    Optional<Posts> getPostId(@PathVariable("postId") long postId);

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Optional<Posts> create(Posts post);
}

