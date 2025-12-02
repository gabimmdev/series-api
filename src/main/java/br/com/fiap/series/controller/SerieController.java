package br.com.fiap.series.controller;

import br.com.fiap.series.model.Serie;
import br.com.fiap.series.service.SerieService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/series")
public class SerieController {
    @Autowired
    private SerieService service;

    // LISTAR COM PAGINAÇÃO
    @GetMapping
    public Page<Serie> listar(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size) {
        return service.listar(PageRequest.of(page, size));
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Serie> buscar(@PathVariable Long id) {
        Optional<Serie> serie = service.buscarPorId(id);
        return serie.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    // ADICIONAR
    @PostMapping
    public ResponseEntity<Serie> adicionar(@Valid @RequestBody Serie serie) {
        Serie salva = service.adicionar(serie);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @Valid @RequestBody Serie serie) {
        Optional<Serie> atualizada = service.atualizar(id, serie);
        return atualizada
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // REMOVER
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        boolean removido = service.remover(id);
        return removido ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}
