package br.com.fiap.series.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.series.model.Serie;


public interface SerieRepository extends JpaRepository<Serie, Long> {}