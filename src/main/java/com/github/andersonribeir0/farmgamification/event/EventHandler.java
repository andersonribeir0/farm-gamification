package com.github.andersonribeir0.farmgamification.event;

import com.github.andersonribeir0.farmgamification.domain.LeaderBoardRow;
import com.github.andersonribeir0.farmgamification.repository.LeaderBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.support.RabbitExceptionTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Date;

@Slf4j
@Component
public class EventHandler {

    private LeaderBoardRepository leaderBoardRepository;

    @Autowired
    public EventHandler(LeaderBoardRepository leaderBoardRepository) {
        this.leaderBoardRepository = leaderBoardRepository;
    }

    @RabbitListener(queues = "${milk-production.queue}")
    public void handleMilkProductionCreated(final MilkProductionCreatedEvent event) {
        try{
            log.info("Milk Production Created Event received: {}", event.toString());
            Mono<LeaderBoardRow> mono = Mono.just(
                    new LeaderBoardRow(
                        event.getCaddleId(),
                        event.getQuantity(),
                        new Date()
                ));
            leaderBoardRepository.insert(mono).subscribe().dispose();
        } catch(final Exception e) {
            log.error("Error when trying to process MilkProductionCreatedEvent", e);
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
