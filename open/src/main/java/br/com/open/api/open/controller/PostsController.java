package br.com.open.api.open.controller;

import br.com.open.api.open.DTO.CommentsDTO;
import br.com.open.api.open.DTO.PostDTO;
import br.com.open.api.open.client.CommentsClient;
import br.com.open.api.open.client.PostsClient;
import br.com.open.api.open.external.ResponseExternal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

//    @GetMapping(path = "/all-posts")
//    public ResponseDTO<Optional<List<PostDTO>>> getAllPosts() {
//        if (postsClient.getAllPosts().isPresent()) {
//            //return ResponseEntity.of(Optional.of(postsClient.getAllPosts()));
//            return new ResponseDTO<>(Optional.of(postsClient.getAllPosts().get()));
//        }
//        return new ResponseDTO<>();
//    }

    @GetMapping(path = "/all-post")
    public ResponseExternal getAllPosths() {
        return new ResponseExternal<>(new String("1"));
    }

    @GetMapping(path = "/{id}")
    public PostDTO posts(@PathVariable("id") Integer id) {
        return postsClient.getPostByPostId(id);
    }

    @GetMapping(path = "a/{id}")
    public List<PostDTO> postsd(@PathVariable("id") long id) {
        return postsClient.getAllCountriesByUserId(id);
    }


}
