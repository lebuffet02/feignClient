package br.com.open.api.open.service;

import br.com.open.api.open.DTO.CommentsDTO;
import br.com.open.api.open.client.CommentsClient;
import br.com.open.api.open.domain.comments.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;

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

    public Optional<Comments> getAllCommentsById(long id) {
        try {
            if(commentsClient.getAllCommentsId(id).isPresent()) {
                return Optional.of(commentsClient.getAllCommentsId(id).get());
            }
            return Optional.empty();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public Optional<Comments> create(CommentsDTO commentsDTO) {
        if(!ObjectUtils.isEmpty(commentsDTO)) {
            Comments comments = new Comments();
            comments.setPostId(commentsDTO.postId());
            comments.setName(commentsDTO.name());
            comments.setEmail(commentsDTO.email());
            comments.setBody(commentsDTO.body());
            return commentsClient.create(comments);
        }
        return Optional.empty();
    }
}


