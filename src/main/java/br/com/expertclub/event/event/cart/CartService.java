package br.com.expertclub.event.event.cart;

import br.com.expertclub.event.event.product.Product;
import br.com.expertclub.event.event.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CartService {

    private final ProductService productService;
    private final CartRepository cartRepository;
    private final ApplicationEventMulticaster applicationEventMulticaster;

    public Cart save(CartCreateRequestDTO request) {
        var cart = new Cart();
        var products = productService.findAllByIdIn(request.getProductIds());
        cart.setProducts(products);
        return cartRepository.save(cart);
    }

    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    public Cart addProduct(Long id, Long productId) {
        var product = productService.findById(productId);
        var cart = this.findById(id);
        cart.getProducts().add(product);
        return cartRepository.save(cart);
    }

    public Cart confirm(Long id) {
        var cart = findById(id);
        var productIds = cart.getProducts().stream().map(Product::getId).collect(Collectors.toList());
        applicationEventMulticaster.multicastEvent(new CartConfirmEvent(this, id, productIds));
        return cart;
    }

    private Cart findById(Long id) {
        return cartRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found with given id: " + id));
    }
}