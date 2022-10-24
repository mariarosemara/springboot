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
public class Empresa {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String cnpj;
private String localidade;
private String proprietario;
private String login;
private String senha;


public Empresa(String cnpj,String localidade, String proprietario, String login, String senha) {
	super();
	this.cnpj = cnpj;
	this.localidade = localidade;
	this.proprietario = proprietario;
    this.login = login;
    this.senha = senha;
}


public long getId() {
	return id;
}


public void setId(long id) {
	this.id = id;
}


public String getCnpj() {
	return cnpj;
}


public void setCnpj(String cnpj) {
	this.cnpj = cnpj;
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


public String getLogin() {
	return login;
}


public void setLogin(String login) {
	this.login = login;
}


public String getSenha() {
	return senha;
}


public void setSenha(String senha) {
	this.senha = senha;
}


}

