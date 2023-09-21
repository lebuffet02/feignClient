package br.com.open.api.open.service;

import br.com.open.api.open.client.UsersClient;
import br.com.open.api.open.domain.users.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    UsersClient usersClient;

    public List<UserResponse> getAllUsers() {
        List<UserResponse> commentsList = new ArrayList<>();
        if(usersClient.getAllUsers().isPresent()) {
            commentsList.addAll(usersClient.getAllUsers().get());
            return commentsList;
        }
        return commentsList;
    }

    public Optional<UserResponse> getAllUsersId(long id) {
            if(usersClient.getAllUsersId(id).isPresent()) {
                return Optional.of(usersClient.getAllUsersId(id).get());
            }
            return Optional.empty();
    }
}
