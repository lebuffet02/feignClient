package br.com.open.api.open.service;

import br.com.open.api.open.DTO.CommentsDTO;
import br.com.open.api.open.client.CommentsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CommentsService {

    @Autowired
    CommentsClient commentsClient;

    public Optional<List<CommentsDTO>> getAllComments() {
        if (commentsClient.getAllComments().isPresent()) {
            return Optional.of(commentsClient.getAllComments().get());
        }
        return Optional.empty();
    }

    public CommentsDTO getAllCommentsById(long id) {
        return commentsClient.getAllCommentsId(id);
    }
}


