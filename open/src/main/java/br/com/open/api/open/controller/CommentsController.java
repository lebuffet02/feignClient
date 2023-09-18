package br.com.open.api.open.controller;

import br.com.open.api.open.DTO.CommentsDTO;
import br.com.open.api.open.external.ResponseExternal;
import br.com.open.api.open.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/comments")
public class CommentsController {

    @Autowired
    CommentsService service;

    @GetMapping(path = "/getAll")
    public ResponseExternal<Optional<List<CommentsDTO>>> getAllComments() {
       return new ResponseExternal<>(service.getAllComments());
    }

    @GetMapping(path = "/{getAll-id}")
    public ResponseExternal<CommentsDTO> getAllCommentsById(
            @PathVariable(value = "id") long id
    ) {
        return new ResponseExternal<>(service.getAllCommentsById(id));
    }
}
