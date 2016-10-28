package projetoES.model.enums;

public enum TipoDepartamento {
    CiC("Ciência da Computação"), EnC("Engenharia da Computação"), Mat("Matemática"), Med("Medicia"), Dir("Direito");

    private String descricao;

    TipoDepartamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
