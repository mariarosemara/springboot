package br.com.springboot;

import java.util.HashMap;
import java.util.Map;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/cliente")
public class ClienteController {
    


@Autowired
private ClienteRepository clienteRepository;

//Pegar todos os Clientes
@GetMapping("/clientes")
public List<Cliente> getAllClientes() {
return clienteRepository.findAll();
}
//@GetMapping("/list")
//public List<Cliente> list() {
//   return this.userRepository.findAll();
//}


//Pegar um funcionario usando seu ID
@GetMapping("/clientes/{id}")
public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
	Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new
ResourceNotFoundException("Cliente nao existe com o id : " + id));
return ResponseEntity.ok(cliente);
}
//@GetMapping("/{id}")
//public Cliente user(@PathVariable("id") Long id) {
   //Optional<Cliente> userFind = this.userRepository.findById(id);
 //if(userFind.isPresent()){
 //   return userFind.get();
 //}
  //  return null; 
//}


//Criar um novo Cliente
@PostMapping("/clientes")
public Cliente createCliente(@RequestBody Cliente cliente) {
return clienteRepository.save(cliente);
}
//@PostMapping("/")
//public Cliente user(@RequestBody Cliente user){
   // return this.userRepository.save(user);
    
//}


//Alterar um Cliente
@PutMapping("/clientes/{id}")
public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteDetails) {
	Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new
ResourceNotFoundException("Cliente nao existe com id :" + id));
	cliente.setNome(clienteDetails.getNome());
	cliente.setCpf(clienteDetails.getCpf());
	cliente.setLogin(clienteDetails.getLogin());
	cliente.setSenha(clienteDetails.getSenha());
	Cliente updatedCliente = clienteRepository.save(cliente);
return ResponseEntity.ok(updatedCliente);
}


//Deletar um Cliente
@DeleteMapping("/clientes/{id}")
public ResponseEntity<Map<String, Boolean>> deleteCliente (@PathVariable Long id) {
	Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new
ResourceNotFoundException("Cliente nao existe com id :" + id));
	clienteRepository.delete(cliente);
Map<String, Boolean> response = new HashMap<>();
response.put("deletado", Boolean.TRUE);
return ResponseEntity.ok(response);
}


}
