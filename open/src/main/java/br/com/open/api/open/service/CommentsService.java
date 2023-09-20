package br.com.open.api.open.service;

import br.com.open.api.open.DTO.CommentsDTO;
import br.com.open.api.open.client.CommentsClient;
import br.com.open.api.open.domain.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsService {

    @Autowired
    CommentsClient commentsClient;

    public Optional<List<Comments>> getAllComments() {
        if (commentsClient.getAllComments().isPresent()) {
            return Optional.of(commentsClient.getAllComments().get());
        }
        return Optional.empty();
    }

    public Comments getAllCommentsById(long id) {
        return commentsClient.getAllCommentsId(id);
    }

    public Optional<Comments> create(CommentsDTO commentsDTO) {
        if(!ObjectUtils.isEmpty(commentsDTO)) {
            Comments comments = new Comments();
            comments.setPostId(commentsDTO.id());
            comments.setName(commentsDTO.name());
            comments.setEmail(commentsDTO.email());
            comments.setBody(commentsDTO.body());
            return commentsClient.create(comments);
        }
        return Optional.empty();
    }
}


