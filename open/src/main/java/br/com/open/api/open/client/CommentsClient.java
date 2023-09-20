package br.com.open.api.open.client;

import br.com.open.api.open.config.OpenApiConfig;
import br.com.open.api.open.domain.Comments;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@FeignClient(name = "comments", url = "${comments.url}", configuration = OpenApiConfig.class)
public interface CommentsClient {

    @GetMapping
    Optional<List<Comments>> getAllComments();

    @GetMapping(path = "/{id}")
    Comments getAllCommentsId(@PathVariable("id") long id);

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Optional<Comments> create(Comments comments);

}
