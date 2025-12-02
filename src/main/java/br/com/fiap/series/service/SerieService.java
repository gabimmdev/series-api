package br.com.fiap.series.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import br.com.fiap.series.model.Serie;
import br.com.fiap.series.repository.SerieRepository;

import java.util.Optional;

@Service
public class SerieService {
    @Autowired
    private SerieRepository repository;

    public Page<Serie> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<Serie> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Serie adicionar(Serie serie) {
        return repository.save(serie);
    }

    public Optional<Serie> atualizar(Long id, Serie serieAtualizada) {
        return repository.findById(id).map(serie -> {
            serie.setNome(serieAtualizada.getNome());
            serie.setGenero(serieAtualizada.getGenero());
            serie.setAnoLancamento(serieAtualizada.getAnoLancamento());
            serie.setTemporadas(serieAtualizada.getTemporadas());
            serie.setClassificacao(serieAtualizada.getClassificacao());
            return repository.save(serie);
        });
    }

    public boolean remover(Long id) {
        return repository.findById(id).map(serie -> {
            repository.delete(serie);
            return true;
        }).orElse(false);
    }
}
