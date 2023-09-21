package br.com.open.api.open.controller;

import br.com.open.api.open.DTO.PostDTO;
import br.com.open.api.open.domain.Posts.Posts;
import br.com.open.api.open.external.ResponseExternal;
import br.com.open.api.open.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/posts")
public class PostsController {

    @Autowired
    PostsService service;

    @GetMapping(path = "/all")
    public ResponseExternal<Optional<List<Posts>>> getAllPosts() {
            return new ResponseExternal<>(service.getAllPosts());
    }

    @GetMapping(path = "/{id}")
    public ResponseExternal<Optional<Posts>> posts(@PathVariable("id") long id) {
        return new ResponseExternal<>(service.getPostId(id));
    }

    @PostMapping(path = "/create")
    public ResponseExternal<Optional<Posts>> create(@Validated @RequestBody PostDTO postDTO) {
        return new ResponseExternal<>(service.create(postDTO));
    }
}
