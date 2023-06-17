package br.com.cnaga.integracao.resources;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cnaga.integracao.dto.NewTransactionDTO;
import br.com.cnaga.integracao.services.NewTransactionService;

@RestController
@RequestMapping(value = "/newTransaction")
public class NewTransactionResource {

	@Autowired
	private NewTransactionService service;
		
	
	@PostMapping
	public ResponseEntity<Object> insert(@RequestBody NewTransactionDTO dto) {
		dto = service.insert(dto);
		//return ResponseEntity.ok().header("status", "ok").body("ok");
		return ResponseEntity.ok().body(Collections.singletonMap("status", "ok"));
	}	
	
}
