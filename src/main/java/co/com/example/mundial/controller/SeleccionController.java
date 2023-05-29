package co.com.example.mundial.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.example.mundial.entities.Seleccion;
import co.com.example.mundial.repository.ISeleccionRepository;

@RestController
@RequestMapping("/selecciones")
@CrossOrigin
public class SeleccionController {
	@Autowired
	ISeleccionRepository seleccionRepository;
	
	@GetMapping
	public List<Seleccion> lista(){
		return seleccionRepository.findAll();
	}
	@GetMapping("/{id}")
	public Optional<Seleccion> findSeleccionById(@PathVariable Integer id){
		Optional<Seleccion>seleccion=seleccionRepository.findById(id);
		if(seleccion.isPresent()) {
			return seleccion;
		}
		return null;
		
	}
	@GetMapping("/grupo/{grupo}")
	public List<Seleccion> seleccionByGrupo(@PathVariable String grupo){
		
		return seleccionRepository.findByGrupo(grupo);
	}
	
	@PostMapping
	public Seleccion postSeleccion(@RequestBody Seleccion seleccion) {
		seleccionRepository.save(seleccion);
		return seleccion;
	}
	
	
	@PutMapping
	public Seleccion putSeleccion(@PathVariable Integer id,@RequestBody Seleccion seleccion) {
		Optional<Seleccion>seleccionCurrent=seleccionRepository.findById(id);
		if(seleccionCurrent.isPresent()) {
			Seleccion seleccionReturn =seleccionCurrent.get();
			seleccionReturn.setNombre(seleccion.getNombre());
			seleccionReturn.setContinente(seleccion.getContinente());
			seleccionReturn.setGrupo(seleccion.getGrupo());
			seleccionRepository.save(seleccionReturn);
			return seleccionReturn;
		}
		return null;
	}
	@DeleteMapping("/{id}")
	public Seleccion deleteSeleccion(@PathVariable Integer id ) {
		Optional<Seleccion>seleccion=seleccionRepository.findById(id);
		if(seleccion.isPresent()) {
			seleccionRepository.deleteById(id);
			return seleccion.get();
		}
		return null;
	}

}
