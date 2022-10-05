package com.bosonit.frontapp.application;
import com.bosonit.frontapp.controller.dto.PartidaDto;

import com.bosonit.frontapp.controller.dto.PartidaNoIdDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PartidaService {


    WebClient webClient = WebClient
            .builder()
            .baseUrl("http://localhost:8080/partidas")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();



    public Flux<PartidaDto> listaPartidas() {
        return webClient.get().uri("").retrieve().bodyToFlux(PartidaDto.class);
    }

    public Mono<PartidaDto> crearPartida(String nombre, ServerHttpRequest request) {
        PartidaNoIdDto partidaDto = new PartidaNoIdDto();
        partidaDto.setHost_name(nombre);
        partidaDto.setHost_ip(request.getLocalAddress().toString());
        System.out.println(partidaDto);
//        Mono<PartidaNoIdDto> outputDto = Mono.just(partidaDto);
        return webClient
                .post()
                .uri("")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(partidaDto)
                .retrieve()
                .bodyToMono(PartidaDto.class);
    }


//    public Mono<PartidaDto> crearPartida() {
//        PartidaNoIdDto partidaDto = new PartidaNoIdDto();
//        partidaDto.setHost_name("Emar");
//        partidaDto.setHost_ip("por implementar");
//        return webClient.post().uri("").bodyValue(partidaDto).retrieve().bodyToMono(PartidaDto.class);
//    }


}
