package br.com.expertclub.event.event.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateRequestDTO {

    private String name;
    private Integer quantity;
    private Long price;
}