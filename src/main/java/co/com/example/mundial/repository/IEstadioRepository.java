package co.com.example.mundial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.example.mundial.entities.Estadio;

public interface IEstadioRepository extends JpaRepository<Estadio, Integer> {

}
