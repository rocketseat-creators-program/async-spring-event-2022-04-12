package br.com.expertclub.event.event.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartAddProductRequestDTO {

    @NotNull
    private Long productId;
}