package br.com.fiap.wtc.work.controller;

import br.com.fiap.wtc.work.entity.Notification;
import br.com.fiap.wtc.work.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/{userId}")
    public List<Notification> getNotifications(
            @PathVariable String userId
    ) {
        return notificationService.getUserNotifications(userId);
    }

    @GetMapping("/{userId}/count")
    public long getUnreadCount(
            @PathVariable String userId
    ) {
        return notificationService.getUnreadCount(userId);
    }

    @PatchMapping("/{id}/read")
    public void markAsRead(
            @PathVariable String id
    ) {
        notificationService.markAsRead(id);
    }
}