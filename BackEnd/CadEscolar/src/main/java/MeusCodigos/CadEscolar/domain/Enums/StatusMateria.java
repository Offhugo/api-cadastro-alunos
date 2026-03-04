package MeusCodigos.CadEscolar.domain.Enums;

import java.util.Arrays;

public enum StatusMateria {

    EM_ANDAMENTO("Em andamento"),
    APROVADO("Aprovado"),
    REPROVADO("Reprovado"),
    TRANCADO("Trancado");

    private final String descricao;

    StatusMateria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusMateria fromDescricao(String descricao) {
        return Arrays.stream(StatusMateria.values())
                .filter(status -> status.descricao.equalsIgnoreCase(descricao))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Status inválido: " + descricao));
    }
}
