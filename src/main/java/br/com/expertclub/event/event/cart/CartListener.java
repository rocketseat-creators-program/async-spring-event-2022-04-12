package br.com.expertclub.event.event.cart;

import br.com.expertclub.event.event.product.Product;
import br.com.expertclub.event.event.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class CartListener {

    private final ProductService productService;

    // When you confirmed the cart, you must decrease the quantity of products in the cart
    @EventListener(CartConfirmEvent.class)
    public void decreaseProductCount(CartConfirmEvent event) {
        var products = productService.decreaseCounts(event.getProductIds());
        log.info(
                "Product counts decreased with names: {}, new quantities: {}",
                products.stream().map(Product::getName).collect(Collectors.toList()),
                products.stream().map(Product::getQuantity).collect(Collectors.toList()));
    }

    // Simulate E-mail
    @EventListener(CartConfirmEvent.class)
    public void handle(CartConfirmEvent event) {
        var productNames =
                productService.findAllByIdIn(event.getProductIds()).stream()
                        .map(Product::getName)
                        .collect(Collectors.toList());
        log.info("E-mail: Your cart confirmed with products: {}", productNames);
    }
}
