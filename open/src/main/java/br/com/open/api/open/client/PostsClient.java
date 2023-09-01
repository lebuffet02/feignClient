package br.com.open.api.open.client;

import br.com.open.api.open.DTO.PostDTO;
import br.com.open.api.open.config.OpenApiConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "posts-clients", url = "https://jsonplaceholder.typicode.com/posts", configuration = OpenApiConfig.class)
public interface PostsClient {

    @GetMapping
    List<PostDTO> getAllPosts();

    @GetMapping
    List<PostDTO> getAllCountriesByUserId(
            @RequestParam("userId") int id);

    @GetMapping(path = "/{postId}")
    PostDTO getPostByPostId(
            @PathVariable("postId") Integer postId);

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    PostDTO create(PostDTO post);
}

