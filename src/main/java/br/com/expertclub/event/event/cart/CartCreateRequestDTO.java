package br.com.expertclub.event.event.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartCreateRequestDTO {

    private List<Long> productIds;
}