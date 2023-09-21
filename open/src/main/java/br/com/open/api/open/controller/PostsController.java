package br.com.open.api.open.controller;

import br.com.open.api.open.DTO.PostDTO;
import br.com.open.api.open.client.PostsClient;
import br.com.open.api.open.domain.Posts.Posts;
import br.com.open.api.open.external.ResponseExternal;
import br.com.open.api.open.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/posts")
public class PostsController {

    @Autowired
    PostsClient postsClient;
    @Autowired
    PostsService postsService;

    @GetMapping(path = "/all")
    public ResponseExternal<Optional<List<Posts>>> getAllPosts() {
            return new ResponseExternal<>(postsService.getAllPosts());
    }

    @GetMapping(path = "/{id}")
    public ResponseExternal<Optional<Posts>> posts(@PathVariable("id") long id) {
        return new ResponseExternal<>(postsService.getPostId(id));
    }

//    @PostMapping
//    public PostDTO create(@RequestBody PostDTO postDTO) {
//        return postsClient.create(postDTO);
//    }
}
