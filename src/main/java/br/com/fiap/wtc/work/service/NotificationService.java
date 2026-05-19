package br.com.fiap.wtc.work.service;

import br.com.fiap.wtc.work.UserRole;
import br.com.fiap.wtc.work.entity.Notification;
import br.com.fiap.wtc.work.entity.User;
import br.com.fiap.wtc.work.repository.NotificationRepository;
import br.com.fiap.wtc.work.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    public void createCampaignNotification(String campaignTitle, String campaignDescription) {

        List<User> clients = userRepository.findByRole(UserRole.CLIENT);

        System.out.println("CLIENTES ENCONTRADOS:");
        clients.forEach(c -> System.out.println(c.getId()));

        List<Notification> notifications = clients.stream()
                .map(user -> Notification.builder()
                        .title(campaignTitle)
                        .message(campaignDescription)
                        .userId(user.getId())
                        .read(false)
                        .createdAt(LocalDateTime.now())
                        .build())
                .toList();

        System.out.println("NOTIFICACOES:");
        notifications.forEach(n -> System.out.println(n.getUserId()));

        notificationRepository.saveAll(notifications);
    }

    public List<Notification> getUserNotifications(String userId) {
        return notificationRepository
                .findByUserIdOrderByCreatedAtDesc(userId);
    }

    public long getUnreadCount(String userId) {
        return notificationRepository
                .countByUserIdAndReadFalse(userId);
    }

    public void markAsRead(String id) {

        Notification notification = notificationRepository
                .findById(id)
                .orElseThrow();

        notification.setRead(true);

        notificationRepository.save(notification);
    }
}