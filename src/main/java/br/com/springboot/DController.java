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
	@RequestMapping("/destino")
	public class DController {
	    


	@Autowired
	private DRepository dRepository;

	//Pegar todos os Clientes
	@GetMapping("/destinos")
	public List<Destino> getAllDestinos() {
	return dRepository.findAll();
	}
	//@GetMapping("/list")
	//public List<Cliente> list() {
	//   return this.userRepository.findAll();
	//}


	//Pegar um funcionario usando seu ID
	@GetMapping("/destinos/{id}")
	public ResponseEntity<Destino> getDestinoById(@PathVariable Long id) {
		Destino destino = dRepository.findById(id).orElseThrow(() -> new
	ResourceNotFoundException("Destino nao existe com o id : " + id));
	return ResponseEntity.ok(destino);
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
	@PostMapping("/destinos")
	public Destino destinoCliente(@RequestBody Destino destino) {
	return dRepository.save(destino);
	}
	//@PostMapping("/")
	//public Cliente user(@RequestBody Cliente user){
	   // return this.userRepository.save(user);
	    
	//}


	//Alterar um Cliente
	@PutMapping("/destinos/{id}")
	public ResponseEntity<Destino> updateDestino(@PathVariable Long id, @RequestBody Destino destinoDetails) {
		Destino destino = dRepository.findById(id).orElseThrow(() -> new
	ResourceNotFoundException("Destino nao existe com id :" + id));
		destino.setNome(destinoDetails.getNome());
		destino.setValor(destinoDetails.getValor());
		destino.setLocalidade(destinoDetails.getLocalidade());
		destino.setProprietario(destinoDetails.getProprietario());
		Destino updatedDestino = dRepository.save(destino);
	return ResponseEntity.ok(updatedDestino);
	}


	//Deletar um Cliente
	@DeleteMapping("/destinos/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDestino(@PathVariable Long id) {
		Destino destino = dRepository.findById(id).orElseThrow(() -> new
	ResourceNotFoundException("Destino nao existe com id :" + id));
		dRepository.delete(destino);
	Map<String, Boolean> response = new HashMap<>();
	response.put("deletado", Boolean.TRUE);
	return ResponseEntity.ok(response);
	}


	}
