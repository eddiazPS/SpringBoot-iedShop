package co.com.ied.shop.iedshop.models.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InventarioDTO {
    @NotNull(message = "cardId no puede ser nulo")
    private Long cantidad;

    public InventarioDTO() {
    }

    public InventarioDTO(Long cantidad) {
        this.cantidad = cantidad;
    }

    public @NotNull(message = "cardId no puede ser nulo") Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(@NotNull(message = "cardId no puede ser nulo") Long cantidad) {
        this.cantidad = cantidad;
    }
}
