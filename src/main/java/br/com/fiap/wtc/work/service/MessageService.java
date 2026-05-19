package br.com.fiap.wtc.work.service;

import br.com.fiap.wtc.work.MessageStatus;
import br.com.fiap.wtc.work.entity.Message;
import br.com.fiap.wtc.work.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository repository;

    public Message sendMessage(
            String senderId,
            String receiverId,
            String content
    ) {

        Message message = Message.builder()
                .senderId(senderId)
                .receiverId(receiverId)
                .content(content)
                .status(MessageStatus.SENT)
                .createdAt(LocalDateTime.now())
                .build();

        return repository.save(message);
    }

    public List<Message> getConversation(
            String user1,
            String user2
    ) {

        return repository
                .findBySenderIdAndReceiverIdOrReceiverIdAndSenderIdOrderByCreatedAtAsc(
                        user1,
                        user2,
                        user2,
                        user1
                );
    }
}
