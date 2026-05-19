package br.com.fiap.wtc.work.config;

import br.com.fiap.wtc.work.UserRole;
import br.com.fiap.wtc.work.entity.Campaign;
import br.com.fiap.wtc.work.entity.User;
import br.com.fiap.wtc.work.repository.CampaignRepository;
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
    private final CampaignRepository campaignRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        seedUsers();
        seedCampaigns();
    }

    private void seedUsers() {
        if (userRepository.count() == 0) {
            User admin = User.builder()
                    .id("ID_OPERADOR")
                    .name("Operador WTC")
                    .email("admin@wtc.com")
                    .password(passwordEncoder.encode("123123"))
                    .role(UserRole.OPERATOR)
                    .build();

            User client1 = User.builder()
                    .id("ID_JOAO")
                    .name("João Silva")
                    .email("joao@email.com")
                    .password(passwordEncoder.encode("123123"))
                    .role(UserRole.CLIENT)
                    .build();

            User client2 = User.builder()
                    .id("ID_MARIA")
                    .name("Maria Oliveira")
                    .email("maria@consultoria.com")
                    .password(passwordEncoder.encode("123123"))
                    .role(UserRole.CLIENT)
                    .build();

            userRepository.saveAll(List.of(admin, client1, client2));
            System.out.println("Users seeded with fixed IDs.");
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
