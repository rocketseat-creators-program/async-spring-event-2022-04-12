package br.com.expertclub.event.event.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ProductController.ENDPOINT)
@RequiredArgsConstructor
public class ProductController {

    public static final String ENDPOINT = "product";

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody @Validated ProductCreateRequestDTO product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Product> update(
            @PathVariable("id") Long id, @RequestBody @Validated ProductUpdateRequestDTO request) {
        return new ResponseEntity<>(productService.update(id, request), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> get() {
        return ResponseEntity.ok(productService.getAll());
    }
}