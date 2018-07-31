package model;

public class Grupo {

    private String nomeGrupo;
    private String nomeCoordenador;
    private String nomeGerente;
    private String nomeSuperintendente;

    public Grupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public String getNomeGrupo() {
        return this.nomeGrupo;
    }

    public String getNomeCoordenador() {
        return this.nomeCoordenador;
    }

    public String getNomeGerente() {
        return this.nomeGerente;
    }

    public String getNomeSuperintendente() {
        return this.nomeSuperintendente;
    }

    public void validaGrupo() {
        switch (this.nomeGrupo) {
            case "":
                this.nomeCoordenador = "";
                this.nomeGerente = "";
                this.nomeSuperintendente = "";
                break;
            default:
                this.nomeCoordenador = "Verificar a hierarquia no Maximo";
                this.nomeGerente = "Verificar a hierarquia no Maximo";
                this.nomeSuperintendente = "Verificar a hierarquia no Maximo";
        }
    }
}
