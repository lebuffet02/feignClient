package br.com.open.api.open.controller;

import br.com.open.api.open.domain.users.UserResponse;
import br.com.open.api.open.external.ResponseExternal;
import br.com.open.api.open.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping
    public ResponseExternal<List<UserResponse>> getAllUsers() {
        return new ResponseExternal<>(usersService.getAllUsers());
    }

    @GetMapping(path = "/{id}")
    public ResponseExternal<Optional<UserResponse>> getAllCommentsById(
            @PathVariable(name = "id") long id) {
        return new ResponseExternal<>(usersService.getAllUsersId(id));
    }
}
