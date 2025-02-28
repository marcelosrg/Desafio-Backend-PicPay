package br.com.desafio.picpay.api.config;

import br.com.desafio.picpay.api.entity.WalletType;
import br.com.desafio.picpay.api.repository.WalletRepository;
import br.com.desafio.picpay.api.repository.WalletTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final WalletTypeRepository walletTypeRepository;

    public DataLoader(WalletRepository walletRepository, WalletTypeRepository walletTypeRepository) {
        this.walletTypeRepository = walletTypeRepository;
    }

    @Transactional // Garante que todas as operações sejam executadas em uma única transação
    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(WalletType.Enum.values())
                .forEach(walletType -> {
                    WalletType existingWalletType = walletTypeRepository.findById(walletType.get().getId()).orElse(null);
                    if (existingWalletType == null) {
                        walletTypeRepository.save(walletType.get());
                    }
                });
    }
}
