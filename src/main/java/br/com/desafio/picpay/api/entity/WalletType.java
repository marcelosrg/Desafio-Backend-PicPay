package br.com.desafio.picpay.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_wallet_type")
public class WalletType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Version
    private Integer version; // Controle de versão para evitar conflitos de concorrência

    public WalletType() {}

    public WalletType(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    // Métodos públicos (Getter e Setter)
    public Long getId() {
        return id; // Confirma que este método agora está acessível
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Enum {
        USER(1L, "user"),
        MERCHANT(2L, "merchant");

        private final Long id;
        private final String description;

        Enum(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        public WalletType get() {
            return new WalletType(id, description);
        }
    }
}
