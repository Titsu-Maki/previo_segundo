package co.com.example.mundial.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.example.mundial.entities.Resultado;
import co.com.example.mundial.repository.IResultadoRepository;

@RestController
@RequestMapping("/resultados")
@CrossOrigin
public class ResultadoController {

		@Autowired
		IResultadoRepository resultadoRepository;
		
		
		@GetMapping
		public List<Resultado>lista(){
			return resultadoRepository.findAll();
		}
		
		@PostMapping
		public Resultado postResultado(@RequestBody Resultado resultado) {
			resultadoRepository.save(resultado);
			return resultado;
			
		}
		@PutMapping("/{id}")
		public Resultado putResultado(@PathVariable Integer id ,@RequestBody Resultado resultado) {
			Optional<Resultado>resultadoCurrent=resultadoRepository.findById(id);
			if(resultadoCurrent.isPresent()) {
				Resultado resultadoReturn=resultadoCurrent.get();
				resultadoReturn.setPartido(resultado.getPartido());
				resultadoReturn.setSeleccionId(resultado.getSeleccionId());
				resultadoReturn.setGoles(resultado.getGoles());
				resultadoReturn.setRojas(resultado.getRojas());
				resultadoReturn.setAmarillas(resultado.getAmarillas());
				resultadoRepository.save(resultadoReturn);
				return resultadoReturn;
			}
			return null;
		}
}
