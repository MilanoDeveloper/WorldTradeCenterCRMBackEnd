package br.com.fiap.wtc.work.config;

import br.com.fiap.wtc.work.UserRole;
import br.com.fiap.wtc.work.entity.Campaign;
import br.com.fiap.wtc.work.entity.Client;
import br.com.fiap.wtc.work.entity.User;
import br.com.fiap.wtc.work.repository.CampaignRepository;
import br.com.fiap.wtc.work.repository.ClientRepository;
import br.com.fiap.wtc.work.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ClientRepository clientRepository;
    private final CampaignRepository campaignRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        seedUsers();
        seedClients();
        seedCampaigns();
    }

    private void seedUsers() {
        if (userRepository.count() == 0) {
            User admin = User.builder()
                    .name("Operador WTC")
                    .email("admin@wtc.com")
                    .password(passwordEncoder.encode("123123"))
                    .role(UserRole.OPERATOR)
                    .build();

            User clientUser = User.builder()
                    .name("Cliente VIP")
                    .email("client@wtc.com")
                    .password(passwordEncoder.encode("123123"))
                    .role(UserRole.CLIENT)
                    .build();

            userRepository.saveAll(List.of(admin, clientUser));
            System.out.println("Users seeded successfully.");
        }
    }

    private void seedClients() {
        if (clientRepository.count() == 0) {
            Client c1 = Client.builder()
                    .name("João Silva")
                    .email("joao.silva@email.com")
                    .phone("11999999999")
                    .company("Tech Solutions")
                    .segment("Tecnologia")
                    .build();

            Client c2 = Client.builder()
                    .name("Maria Oliveira")
                    .email("maria@consultoria.com")
                    .phone("11888888888")
                    .company("Oliveira Consult")
                    .segment("Serviços")
                    .build();

            clientRepository.saveAll(List.of(c1, c2));
            System.out.println("Clients seeded successfully.");
        }
    }

    private void seedCampaigns() {
        if (campaignRepository.count() == 0) {
            Campaign camp1 = Campaign.builder()
                    .title("Expansão Global 2026")
                    .description("Campanha para novos membros do WTC")
                    .status("Ativa")
                    .startDate("2026-01-01")
                    .endDate("2026-12-31")
                    .build();

            campaignRepository.save(camp1);
            System.out.println("Campaigns seeded successfully.");
        }
    }
}
