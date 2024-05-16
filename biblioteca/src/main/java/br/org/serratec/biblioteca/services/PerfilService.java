package br.org.serratec.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.biblioteca.entities.Perfil;
import br.org.serratec.biblioteca.repository.PerfilRepository;

@Service
public class PerfilService {
	
	@Autowired
	PerfilRepository perfilRepository;
	
	//serve para buscar uma lista na tabela
	public List<Perfil> findAll() {
		return perfilRepository.findAll();
	}
	
	//serve para buscar um id na tabela
	public Perfil findById(Integer id) {
		return perfilRepository.findById(id).get();
		
	}
	
	//serve para salvar
	public Perfil save(Perfil perfil) {
		return perfilRepository.save(perfil);
	}
	
	//serve para atualizar
	public Perfil update(Perfil perfil) {
		return perfilRepository.save(perfil);
	}
	
	public Perfil delete(Perfil perfil) {
		Perfil perfilExcluido = perfilRepository.findById(perfil.getUserId()).orElse(null);
		try {
			perfilRepository.delete(perfilExcluido);
			if(perfilExcluido != null) {
				return perfilExcluido;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return perfilExcluido;
	}
	
	public Perfil deleteById(Integer id) {
		Perfil perfilExcluido = perfilRepository.findById(id).orElse(null);
		try {
			perfilRepository.delete(perfilExcluido);
			if(perfilExcluido != null) {
				return perfilExcluido;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return perfilExcluido;
	}
	
	
	//serve para retornar a quantidade de registro que tem na tabela.
	public long count() {
		return perfilRepository.count();
		}

	
	
	
	
}
