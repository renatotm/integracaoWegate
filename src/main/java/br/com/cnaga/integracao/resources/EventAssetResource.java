package br.com.cnaga.integracao.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cnaga.integracao.dto.EventAssetDTO;
import br.com.cnaga.integracao.services.EventAssetService;

@RestController
@RequestMapping(value = "/assets")
public class EventAssetResource {

	@Autowired
	private EventAssetService service;
	
	@GetMapping
	public ResponseEntity<List<EventAssetDTO>> findAll() {
		List<EventAssetDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<EventAssetDTO> findById(@PathVariable Long id) {
		EventAssetDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}	
	
	@PostMapping
	public ResponseEntity<EventAssetDTO> insert(@RequestBody EventAssetDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EventAssetDTO> update(@PathVariable Long id, @RequestBody EventAssetDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<EventAssetDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}	
	
}
