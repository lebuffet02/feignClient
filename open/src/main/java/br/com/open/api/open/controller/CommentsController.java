package br.com.open.api.open.controller;

import br.com.open.api.open.DTO.CommentsDTO;
import br.com.open.api.open.domain.comments.Comments;
import br.com.open.api.open.external.ResponseExternal;
import br.com.open.api.open.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/comments")
public class CommentsController {

    @Autowired
    CommentsService service;

    @GetMapping(path = "/all")
    public ResponseExternal<Optional<List<Comments>>> getAllComments() {
       return new ResponseExternal<>(service.getAllComments());
    }

    @GetMapping(path = "/{id}")
    public ResponseExternal<Optional<Comments>> getAllCommentsById(
            @PathVariable(name = "id") long id) {
        return new ResponseExternal<>(service.getAllCommentsById(id));
    }

    @PostMapping(path = "/create")
    public ResponseExternal<Optional<Comments>> create(
            @Validated @RequestBody CommentsDTO commentsDTO) {
        return new ResponseExternal<>(service.create(commentsDTO));
    }
}
