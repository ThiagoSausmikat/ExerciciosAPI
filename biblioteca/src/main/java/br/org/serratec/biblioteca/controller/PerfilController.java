package br.org.serratec.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.biblioteca.entities.Perfil;
import br.org.serratec.biblioteca.services.PerfilService;

@RestController
@RequestMapping("/perfis")
public class PerfilController {

	@Autowired
	PerfilService perfilServece;
	
	@GetMapping
	public ResponseEntity<List<Perfil>> findAll() {
		return new ResponseEntity<>(perfilServece.findAll(), HttpStatus.OK);
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<Perfil> findById(@PathVariable Integer id) {
		Perfil perfil = perfilServece.findById(id);
		
		if(perfil == null)
			return new ResponseEntity<>(perfil, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(perfil, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Perfil> save(@RequestBody Perfil perfil) {
		return new ResponseEntity<>(perfilServece.save(perfil), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Perfil> update(@RequestBody Perfil perfil) {
		return new ResponseEntity<>(perfilServece.update(perfil), HttpStatus.OK);
	}

	
	
	@DeleteMapping
	public ResponseEntity<Object> delete(@RequestBody Perfil perfil){
		if (perfilServece.findById(perfil.getUserId()) != null) {
			return ResponseEntity.status(HttpStatus.OK).body(perfilServece.delete(perfil));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'Error': 'Usuario não encontrado'}");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Integer id){
		if (perfilServece.findById(id) != null) {
			return ResponseEntity.status(HttpStatus.OK).body(perfilServece.deleteById(id));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'Error': 'Usuario não encontrado'}");
	}
	
	


}
