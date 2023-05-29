package co.com.example.mundial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.example.mundial.entities.Seleccion;

public interface ISeleccionRepository extends JpaRepository<Seleccion, Integer> {
	
	public List<Seleccion>findByGrupo(String grupo);

}
