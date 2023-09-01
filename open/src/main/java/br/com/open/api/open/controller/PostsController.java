package br.com.open.api.open.controller;

import br.com.open.api.open.DTO.PostDTO;
import br.com.open.api.open.client.PostsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/posts")
public class PostsController {

    @Autowired
    PostsClient postsClient;

    @PostMapping
    public PostDTO create(
            @RequestBody PostDTO postDTO) {
        return postsClient.create(postDTO);
    }

    @GetMapping(path = "/a")
    public List<PostDTO> getAllPosts() {
        return postsClient.getAllPosts();
    }
}
