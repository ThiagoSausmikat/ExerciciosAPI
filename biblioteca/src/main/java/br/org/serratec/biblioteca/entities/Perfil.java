package br.org.serratec.biblioteca.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/*
 CREATE TABLE public.perfil (
	perfil_id serial NOT NULL,
	nome varchar(100) NOT NULL,
	descricao varchar(200) NOT NULL,
	PRIMARY KEY (perfil_id)
);
 */


//com a nanotação abaixa acaba com a recursividade infinita
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "perfilId",
		scope = Perfil.class
)


//Esta classe é uma entidade, que representa na API a tabela perfil

//logo abaixo serve para dizer que essa classe é uma entidade
@Entity
//logo abaixo serve para criar uma tabela
@Table(name = "perfil")
public class Perfil {
	//ele diz que o atributo perfilId é a chave primaria e precisa fazer o import
	@Id
	
	//aqui eu deixo o banco responsavel pela estrategia de geração da chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	// quando for serial é Integer e @ para criar uma coluna
	@Column(name = "perfilId")
	private Integer perfilId;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;
	
	//quando for um para muitos (OneToMany) deve ter a List
	//dentro de mappedBy = "" dentro das apas é preciso botar o nome da instancia la no usuario Perfil perfil
	@OneToMany(mappedBy = "perfil")
	private List<Usuario> usuario;

	public Integer getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(Integer perfilId) {
		this.perfilId = perfilId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
	
	
	
	

}
