package br.com.expertclub.event.event.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CartController.ENDPOINT)
@RequiredArgsConstructor
public class CartController {

    public static final String ENDPOINT = "cart";

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<Cart> save(@RequestBody CartCreateRequestDTO requestBody) {
        return new ResponseEntity<>(cartService.save(requestBody), HttpStatus.CREATED);
    }

    @PostMapping("{id}")
    public ResponseEntity<Cart> save(
            @PathVariable("id") Long id, @RequestBody @Validated CartAddProductRequestDTO requestBody) {
        return ResponseEntity.ok(cartService.addProduct(id, requestBody.getProductId()));
    }

    @PostMapping("{id}/confirm")
    public ResponseEntity<Cart> confirm(@PathVariable("id") Long id) {
        return ResponseEntity.ok(cartService.confirm(id));
    }

    @GetMapping
    public ResponseEntity<List<Cart>> get() {
        return ResponseEntity.ok(cartService.getAll());
    }
}