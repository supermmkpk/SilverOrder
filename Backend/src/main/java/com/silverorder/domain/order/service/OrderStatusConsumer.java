package com.silverorder.domain.order.service;

import com.silverorder.global.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusConsumer {

    @RabbitListener(queues = RabbitMQConfig.ORDER_QUEUE)
    public void receive(String message) {
        System.out.println("OrderStatusConsumer: " + message);
    }
}
