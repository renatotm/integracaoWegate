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
import br.com.cnaga.integracao.dto.EventDTO;
import br.com.cnaga.integracao.entities.Event;
import br.com.cnaga.integracao.entities.EventAsset;
import br.com.cnaga.integracao.repositories.EventAssetRepository;
import br.com.cnaga.integracao.repositories.EventRepository;
import br.com.cnaga.integracao.services.exceptions.DatabaseException;
import br.com.cnaga.integracao.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EventService {
	
	@Autowired
	private EventRepository repository;
	
	@Autowired
	private EventAssetRepository assetRepository;
	
	@Transactional(readOnly = true)
	public List<EventDTO> findAll() {
		List<Event> list = repository.findAll();
		return list.stream().map(x -> new EventDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public EventDTO findById(Long id) {
		Optional<Event> obj =  repository.findById(id);
		Event entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new EventDTO(entity, entity.getAssets());
	}

	@Transactional
	public EventDTO insert(EventDTO dto) {
		Event entity = new Event();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new EventDTO(entity);
	}

	@Transactional
	public EventDTO update(Long id, EventDTO dto) {
		try {
			Event entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new EventDTO(entity);
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
	
	private void copyDtoToEntity(EventDTO dto, Event entity) {
		entity.setDateCreation(dto.getDateCreation());
		entity.setIntegracaoData(dto.getIntegracaoData());
		entity.setIntegracaoStatus(dto.getIntegracaoStatus());
		entity.setFinish(dto.getFinish());
		entity.setGateId(dto.getGateId());
		entity.setUuid(dto.getUuid());
		entity.setStart(dto.getStart());
		entity.setStatus(dto.getStatus());
		entity.setWay(dto.getWay());
		
		entity.getAssets().clear();
		for (EventAssetDTO assetDto : dto.getAssets()) {
			EventAsset asset =  assetRepository.getReferenceById(assetDto.getId());
			entity.getAssets().add(asset);
		}
	}		
}
