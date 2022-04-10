package br.com.expertclub.event.event.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductListener {

    // Simulate E-mail
    @EventListener(ProductUpdatedEvent.class)
    public void handle(ProductUpdatedEvent event) {
        log.info(
                "E-mail: The price of {} has been changed, new price is {}.",
                event.getProduct().getName(),
                event.getProduct().getPrice());
    }
}