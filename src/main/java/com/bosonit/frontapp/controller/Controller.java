package com.bosonit.frontapp.controller;


import com.bosonit.frontapp.application.PartidaService;
import com.bosonit.frontapp.controller.dto.PartidaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@org.springframework.stereotype.Controller
@RequestMapping("partidas")
public class Controller {

    @Autowired
    PartidaService partidaService;

    @GetMapping
    @ResponseBody
    public Flux<PartidaDto> listaPartidas() {
        return partidaService.listaPartidas();
    }

    @PostMapping("/newgame")
    public Mono<PartidaDto> nuevaPartida(@RequestParam String nombre, ServerHttpRequest request) {
        return partidaService.crearPartida(nombre, request);
    }

//
//    @PostMapping("/newgame")
//    public Mono<PartidaDto> nuevaPartida() {
//        return partidaService.crearPartida();
//
//    }

}
