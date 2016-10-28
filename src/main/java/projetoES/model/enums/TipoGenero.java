package projetoES.model.enums;

public enum TipoGenero {
    M("Masculino"), F("Feminino");

    private String descricao;

    TipoGenero(String descricao) {
        this.descricao = descricao;
    }
}
