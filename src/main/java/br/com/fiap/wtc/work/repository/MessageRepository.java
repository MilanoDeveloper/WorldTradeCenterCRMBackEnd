package br.com.fiap.wtc.work.repository;

import br.com.fiap.wtc.work.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository
        extends MongoRepository<Message, String> {

    List<Message> findBySenderIdAndReceiverIdOrReceiverIdAndSenderIdOrderByCreatedAtAsc(
            String sender1,
            String receiver1,
            String sender2,
            String receiver2
    );
}