package br.com.open.api.open.external;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseExternal<T> {

    @Schema(
         description = "Indica se a resposta foi um sucesso ou não")
    private String status;

    @Schema(
            description = "Conteúdo da resposta")
    private ResponseEntity<T> body;

    public ResponseExternal() {
        setStatus(getFormat());
    }

    public ResponseExternal(@Nullable T body) {
        setStatus(getFormat());
        this.body = ResponseEntity.ofNullable(body);
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResponseEntity<T> getBody() {
        return this.body;
    }

    public void setBody(ResponseEntity<T> body) {
        this.body = body;
    }

    private String getFormat() {
        return String.format("Retorno da API ".concat(" - ").concat(ResponseStatus.SUCESS.getStatus().toString())
                .concat(" - ").concat(ResponseStatus.SUCESS.getDescription()));
    }
}
