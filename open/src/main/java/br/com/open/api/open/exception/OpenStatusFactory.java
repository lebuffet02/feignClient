package br.com.open.api.open.exception;

import br.com.open.api.open.external.ResponseStatus;

public class OpenStatusFactory {

    private String detalhe;
    private String mensagem;
    private ResponseStatus status;

    public OpenStatusFactory(String mensagem) {
        this.mensagem = mensagem;
    }

    public void internalErrorUnauthorized(String mensagem) {
        this.status = ResponseStatus.UNAUTHORIZED;
        mensagem.concat(this.status.getDescription());
    }

    public void internalErrorUnauthorized(String mensagem, Throwable ex) {
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
