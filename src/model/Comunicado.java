package model;

public class Comunicado {

    private String itemSelecionado;
    private String tipoComunicacao;
    private String modeloComunicacao;
    private String acaoEfetuada;

    public Comunicado(String itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }

    public String getItemSelecionado() {
        return this.itemSelecionado;
    }

    public void setItemSelecionado(String itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }

    public String getTipoComunicacao() {
        return this.tipoComunicacao;
    }

    public void setTipoComunicacao(String tipoComunicacao) {
        this.tipoComunicacao = tipoComunicacao;
    }

    public String getModeloComunicacao() {
        return this.modeloComunicacao;
    }

    public void setModeloComunicacao(String modeloComunicacao) {
        this.modeloComunicacao = modeloComunicacao;
    }

    public String getAcaoEfetuada() {
        return this.acaoEfetuada;
    }

    public void setAcaoEfetuada(String acaoEfetuada) {
        this.acaoEfetuada = acaoEfetuada;
    }

    public void definirComunicado() {
        switch (this.itemSelecionado) {
            case "Nenhum":
                this.tipoComunicacao = "1ª Cobrança";
                this.modeloComunicacao = "COBSTATUSATA1";
                this.acaoEfetuada = "Enviar e-mail para os ANALISTAS da fila de atendimento.";
                break;
            case "Priorização":
                this.tipoComunicacao = "1ª Cobrança";
                this.modeloComunicacao = "COBSTATUSATA1";
                this.acaoEfetuada = "Enviar e-mail para os ANALISTAS da fila de atendimento.";
                break;
            case "1ª Cobrança":
                this.tipoComunicacao = "2ª Cobrança";
                this.modeloComunicacao = "COBSTATUSATA2";
                this.acaoEfetuada = "Enviar e-mail para o COORDENADOR.\nOs ANALISTAS da fila de atendimento passarão a estar em cópia.";
                break;
            case "2ª Cobrança":
                this.tipoComunicacao = "3ª Cobrança";
                this.modeloComunicacao = "COBSTATUSATA2";
                this.acaoEfetuada = "Enviar e-mail para o GERENTE.\nCOORDENADOR e os ANALISTAS da fila de atendimento passarão a estar em cópia";
                break;
            case "3ª Cobrança":
                this.tipoComunicacao = "4ª Cobrança";
                this.modeloComunicacao = "COBSTATUSATA2";
                this.acaoEfetuada = "Enviar e-mail para o SUPERINTENDENTE.\nGERENTE, COORDENADOR e os ANALISTAS da fila de atendimento passarão a estar em cópia";
                break;
            default:
                this.tipoComunicacao = "5ª Cobrança ou mais";
                this.modeloComunicacao = "COBSTATUSATA2";
                this.acaoEfetuada = "Enviar e-mail para o SUPERINTENDENTE.\nGERENTE, COORDENADOR e os ANALISTAS da fila de atendimento passarão a estar em cópia";
        }
    }
}
