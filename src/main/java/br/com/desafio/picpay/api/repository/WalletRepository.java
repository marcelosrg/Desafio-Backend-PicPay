package br.com.desafio.picpay.api.repository;

import br.com.desafio.picpay.api.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
