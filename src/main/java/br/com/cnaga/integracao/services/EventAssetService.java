package br.com.cnaga.integracao.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cnaga.integracao.dto.EventAssetDTO;
import br.com.cnaga.integracao.entities.EventAsset;
import br.com.cnaga.integracao.repositories.EventAssetRepository;
import br.com.cnaga.integracao.services.exceptions.DatabaseException;
import br.com.cnaga.integracao.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EventAssetService {
	
	@Autowired
	private EventAssetRepository repository;
	
	@Transactional(readOnly = true)
	public List<EventAssetDTO> findAll() {
		List<EventAsset> list = repository.findAll();
		return list.stream().map(x -> new EventAssetDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public EventAssetDTO findById(Long id) {
		Optional<EventAsset> obj =  repository.findById(id);
		EventAsset entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new EventAssetDTO(entity);
	}

	@Transactional
	public EventAssetDTO insert(EventAssetDTO dto) {
		EventAsset entity = new EventAsset();
		entity.setImagePath(dto.getImagePath());
		entity.setIntegracaoData(dto.getIntegracaoData());
		entity.setIntegracaoStatus(dto.getIntegracaoStatus());
		entity.setType(dto.getType());
		entity.setType2(dto.getType2());
		entity.setUuid(dto.getUuid());
		entity.setValue(dto.getValue());
		entity.setValueConfirmed(dto.getValueConfirmed());
		entity.setWeight(dto.getWeight());
		entity = repository.save(entity);
		return new EventAssetDTO(entity);
	}

	@Transactional
	public EventAssetDTO update(Long id, EventAssetDTO dto) {
		try {
			EventAsset entity = repository.getReferenceById(id);
		
			entity.setImagePath(dto.getImagePath());
			entity.setIntegracaoData(dto.getIntegracaoData());
			entity.setIntegracaoStatus(dto.getIntegracaoStatus());
			entity.setType(dto.getType());
			entity.setType2(dto.getType2());
			entity.setUuid(dto.getUuid());
			entity.setValue(dto.getValue());
			entity.setValueConfirmed(dto.getValueConfirmed());
			entity.setWeight(dto.getWeight());
		
			entity = repository.save(entity);
			return new EventAssetDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) { 
			throw new ResourceNotFoundException("Id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
}
