package br.com.fiap.wtc.work.service;

import br.com.fiap.wtc.work.MessageStatus;
import br.com.fiap.wtc.work.entity.Message;
import br.com.fiap.wtc.work.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {

    private final MessageRepository repository;

    public Message sendMessage(
            String senderId,
            String receiverId,
            String content
    ) {
        log.info("Enviando mensagem de {} para {}: {}", senderId, receiverId, content);

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
        log.info("Buscando conversa entre {} e {}", user1, user2);

        List<Message> messages = repository.findConversation(
                user1, 
                user2, 
                Sort.by(Sort.Direction.ASC, "createdAt")
        );

        log.info("Total de mensagens encontradas: {}", messages.size());
        return messages;
    }
}
