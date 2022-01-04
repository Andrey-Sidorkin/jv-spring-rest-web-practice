package mate.academy.spring.service.dto.mapping.impl.response;

import java.util.stream.Collectors;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseMapper implements
        DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> {

    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart cart) {
        ShoppingCartResponseDto dto = new ShoppingCartResponseDto();
        dto.setTicketIds(cart.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        dto.setCartAndUserId(cart.getId());
        return dto;
    }
}