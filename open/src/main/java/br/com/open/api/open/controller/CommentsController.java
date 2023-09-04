package br.com.open.api.open.controller;

import br.com.open.api.open.DTO.CommentsDTO;
import br.com.open.api.open.client.CommentsClient;
import br.com.open.api.open.external.ResponseExternal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/comments")
public class CommentsController {

    @Autowired
    CommentsClient commentsClient;

    @GetMapping(path = "/all-comments")
    public ResponseExternal<Optional<List<CommentsDTO>>> getAllComments() {
        if (commentsClient.getAllPosts().isPresent()) {
            return new ResponseExternal<>(commentsClient.getAllPosts());
        }
        return new ResponseExternal<>();
    }

    @GetMapping("/a")
    public String f() {
        return "asda";
    }
}
