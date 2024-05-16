package br.org.serratec.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.biblioteca.entities.Perfil;

public interface PerfilRepository 
	extends JpaRepository<Perfil, Integer> {

}
