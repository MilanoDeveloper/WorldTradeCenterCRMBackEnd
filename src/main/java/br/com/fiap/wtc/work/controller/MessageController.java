package br.com.fiap.wtc.work.controller;

import br.com.fiap.wtc.work.entity.Message;
import br.com.fiap.wtc.work.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService service;

    @PostMapping
    public Message send(
            @RequestBody Message request
    ) {

        return service.sendMessage(
                request.getSenderId(),
                request.getReceiverId(),
                request.getContent()
        );
    }

    @GetMapping
    public List<Message> conversation(
            @RequestParam String user1,
            @RequestParam String user2
    ) {

        return service.getConversation(
                user1,
                user2
        );
    }
}
