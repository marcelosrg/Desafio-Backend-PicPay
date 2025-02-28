package br.com.desafio.picpay.api.repository;

import br.com.desafio.picpay.api.entity.WalletType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {
}
