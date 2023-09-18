package br.com.open.api.open.client;

import br.com.open.api.open.DTO.CommentsDTO;
import br.com.open.api.open.DTO.PostDTO;
import br.com.open.api.open.config.OpenApiConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "comments", url = "${comments.url}", configuration = OpenApiConfig.class)
public interface CommentsClient {

    @GetMapping
    Optional<List<CommentsDTO>> getAllComments();

    @GetMapping(path = "/{id}")
    CommentsDTO getAllCommentsId(@PathVariable("id") long id);
}
