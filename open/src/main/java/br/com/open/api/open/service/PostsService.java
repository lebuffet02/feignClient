package br.com.open.api.open.service;

import br.com.open.api.open.client.PostsClient;
import br.com.open.api.open.domain.Posts.Posts;
import br.com.open.api.open.domain.comments.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostsService {

    @Autowired
    PostsClient postsClient;

    public Optional<List<Posts>> getAllPosts() {
        if (postsClient.getAllPosts().isPresent()) {
            return Optional.of(postsClient.getAllPosts().get());
        }
        return Optional.empty();
    }

    public Optional<Posts> getPostId(long id) {
            if(postsClient.getPostId(id).isPresent()) {
                return Optional.of(postsClient.getPostId(id).get());
            }
            return Optional.empty();
    }
}
