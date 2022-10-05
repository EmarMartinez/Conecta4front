package com.bosonit.frontapp.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartidaNoIdDto {
    String host_name;
    String host_ip;
    String guest_name;
    String guest_ip;
    String tablero;
    String turno;
    Boolean existe_ganador;
    String ganador;
}
