package br.com.springboot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Destino {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String nome;
private String valor;
private String localidade;
private String proprietario;


public Destino(String nome, String valor,String localidade, String proprietario) {
	super();
	this.nome = nome;
	this.valor = valor;
	this.localidade = localidade;
	this.proprietario = proprietario;
	}


public long getId() {
	return id;
}


public void setId(long id) {
	this.id = id;
}


public String getNome() {
	return nome;
}


public void setNome(String nome) {
	this.nome = nome;
}


public String getValor() {
	return valor;
}


public void setValor(String valor) {
	this.valor = valor;
}


public String getLocalidade() {
	return localidade;
}


public void setLocalidade(String localidade) {
	this.localidade = localidade;
}


public String getProprietario() {
	return proprietario;
}


public void setProprietario(String proprietario) {
	this.proprietario = proprietario;
}


}

