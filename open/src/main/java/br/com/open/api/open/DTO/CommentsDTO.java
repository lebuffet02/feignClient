package br.com.open.api.open.DTO;

public record CommentsDTO(long postId, long id, String name, String email, String body) {
}