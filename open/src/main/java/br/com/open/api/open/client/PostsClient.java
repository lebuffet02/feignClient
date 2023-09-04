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
import java.util.Optional;


@FeignClient(name = "${spring.application.name}", url = "${posts.url}", configuration = OpenApiConfig.class)
public interface PostsClient {

    @GetMapping
    Optional<List<PostDTO>> getAllPosts();

    @GetMapping
    List<PostDTO> getAllCountriesByUserId(@RequestParam("userId") long id);

    @GetMapping(path = "/{postId}")
    PostDTO getPostByPostId(@PathVariable("postId") long postId);

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    PostDTO create(PostDTO post);
}

