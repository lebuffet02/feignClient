package br.com.open.api.open.client;

import br.com.open.api.open.config.OpenInitialize;
import br.com.open.api.open.domain.comments.Comments;
import br.com.open.api.open.domain.users.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "users", url = "${users.url}", configuration = OpenInitialize.class)
public interface UsersClient {

    @GetMapping
    Optional<List<UserResponse>> getAllUsers();

    @GetMapping(path = "/{id}")
    Optional<UserResponse> getAllUsersId(@PathVariable("id") long id);
}
