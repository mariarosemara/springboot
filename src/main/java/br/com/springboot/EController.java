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
@RequestMapping("/empresa")
public class EController {
    


@Autowired
private ERepository eRepository;

//Pegar todos os Clientes
@GetMapping("/empresas")
public List<Empresa> getAllEmpresas() {
return eRepository.findAll();
}
//@GetMapping("/list")
//public List<Cliente> list() {
//   return this.userRepository.findAll();
//}


//Pegar um funcionario usando seu ID
@GetMapping("/empresas/{id}")
public ResponseEntity<Empresa> getEmpresaById(@PathVariable Long id) {
	Empresa empresa = eRepository.findById(id).orElseThrow(() -> new
ResourceNotFoundException("Empresa nao existe com o id : " + id));
return ResponseEntity.ok(empresa);
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
@PostMapping("/empresas")
public Empresa createEmpresa(@RequestBody Empresa empresa) {
return eRepository.save(empresa);
}
//@PostMapping("/")
//public Cliente user(@RequestBody Cliente user){
   // return this.userRepository.save(user);
    
//}


//Alterar um Cliente
@PutMapping("/empresas/{id}")
public ResponseEntity<Empresa> updatEempresa(@PathVariable Long id, @RequestBody Empresa empresaDetails) {
	Empresa empresa = eRepository.findById(id).orElseThrow(() -> new
ResourceNotFoundException("Empresa nao existe com id :" + id));
	
	empresa.setCnpj(empresaDetails.getCnpj());
	empresa.setLocalidade(empresaDetails.getLocalidade());
	empresa.setProprietario(empresaDetails.getProprietario());
	empresa.setLogin(empresaDetails.getLogin());
	empresa.setSenha(empresaDetails.getSenha());
	Empresa updatedEmpresa = eRepository.save(empresa);
return ResponseEntity.ok(updatedEmpresa);
}


//Deletar um Cliente
@DeleteMapping("/empresas/{id}")
public ResponseEntity<Map<String, Boolean>> deleteEmpresa (@PathVariable Long id) {
	Empresa empresa = eRepository.findById(id).orElseThrow(() -> new
ResourceNotFoundException("Empresa nao existe com id :" + id));
	eRepository.delete(empresa);
Map<String, Boolean> response = new HashMap<>();
response.put("deletado", Boolean.TRUE);
return ResponseEntity.ok(response);
}


}
