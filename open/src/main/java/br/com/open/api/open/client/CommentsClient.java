package br.com.open.api.open.client;

import br.com.open.api.open.config.OpenInitialize;
import br.com.open.api.open.domain.comments.Comments;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@FeignClient(name = "comments", url = "${comments.url}", configuration = OpenInitialize.class)
public interface CommentsClient {

    @GetMapping
    Optional<List<Comments>> getAllComments();

    @GetMapping(path = "/{id}")
    Optional<Comments> getAllCommentsId(@PathVariable("id") long id);

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Optional<Comments> create(Comments comments);

}
