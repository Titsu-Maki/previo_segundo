package co.com.example.mundial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.example.mundial.entities.Partido;

public interface IPartidoRepository  extends JpaRepository<Partido, Integer>{
	

}
