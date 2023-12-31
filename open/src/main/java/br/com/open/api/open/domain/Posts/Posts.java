package br.com.open.api.open.domain.Posts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "userId",
        "title",
        "body"
})
public class Posts {

    @JsonProperty("id")
    private long id;

    @JsonProperty("userId")
    private long userId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("body")
    private String body;

    @JsonProperty("id")
    public long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty("userId")
    public long getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(long userId) {
        this.userId = userId;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
    }
}


