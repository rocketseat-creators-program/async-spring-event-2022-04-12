package br.com.expertclub.event.event.cart;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.Collection;

@Getter
public class CartConfirmEvent extends ApplicationEvent {

    private final Long id;
    private final Collection<Long> productIds;

    public CartConfirmEvent(Object source, Long id, Collection<Long> productIds) {
        super(source);
        this.id = id;
        this.productIds = productIds;
    }
}
