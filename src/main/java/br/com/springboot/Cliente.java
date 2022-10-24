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
public class Cliente {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String nome;
private String cpf;
private String login;
private String senha;


public Cliente(String nome, String cpf, String login, String senha) {
super();
this.nome = nome;
this.cpf = cpf;
this.login = login;
this.senha = senha;
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
public String getCpf() {
return cpf;
}
public void setCpf(String cpf) {
this.cpf = cpf;
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

