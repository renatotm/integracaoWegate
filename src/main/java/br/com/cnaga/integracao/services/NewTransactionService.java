package br.com.cnaga.integracao.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cnaga.integracao.dto.ContainerDTO;
import br.com.cnaga.integracao.dto.NewTransactionDTO;
import br.com.cnaga.integracao.dto.PlateDTO;
import br.com.cnaga.integracao.dto.RailDTO;
import br.com.cnaga.integracao.entities.Event;
import br.com.cnaga.integracao.entities.EventAsset;
import br.com.cnaga.integracao.repositories.EventRepository;
import br.com.cnaga.integracao.services.exceptions.ConversionException;

@Service
public class NewTransactionService {

	@Autowired
	private EventRepository repository;
	
	//@Autowired
	//private EventAssetRepository assetRepository;	
	
	@Transactional
	public NewTransactionDTO insert(NewTransactionDTO dto) {
		//NewTransaction entity = new NewTransaction();
		
	    Event entity = new Event();
		
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return dto;//new NewTransactionDTO(entity);
	}
	
	private void copyDtoToEntity(NewTransactionDTO dto, Event entity) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		entity.setId(dto.getNumber());
		try {
			entity.setDateCreation(format.parse(dto.getDatetime()));
			entity.setIntegracaoData(format.parse(dto.getDatetime()));
			entity.setStart(format.parse(dto.getDatetime()));
			entity.setFinish(format.parse(dto.getDatetime()));			
		} catch (ParseException e) {
			throw new ConversionException("Error converting String to Date");
		}

		entity.setStatus("CRIADO_WEGATE");
		entity.setGateId(dto.getGateId());
		entity.setUuid(UUID.randomUUID().toString());
		entity.setWay(converteSentido(dto.getDirection()));
		
		entity.getAssets().clear();
		for (PlateDTO plateDto : dto.getPlates()) {
			for (String imagem : plateDto.getImages()) {
				EventAsset asset =  new EventAsset();//assetRepository.getReferenceById(plateDto.getCamera());
				populaAsset(entity, asset, imagem, plateDto.getPlate(), "VEICULO");
				entity.getAssets().add(asset);				
			}
		}
		for (ContainerDTO conteinerDto : dto.getContainers()) {
			for (String imagem : conteinerDto.getImages()) {
				EventAsset asset =  new EventAsset();//assetRepository.getReferenceById(entity.getId());
				populaAsset(entity, asset, imagem, conteinerDto.getContainer(), "CONTEINER");
				entity.getAssets().add(asset);				
			}
		}	
		for (RailDTO railDto : dto.getRails()) {
			for (String imagem : railDto.getImages()) {
				EventAsset asset =  new EventAsset();//assetRepository.getReferenceById(entity.getId());
				populaAsset(entity, asset, imagem, railDto.getText(), "VAGAO");
				entity.getAssets().add(asset);				
			}
		}		
	}	
	
	private void populaAsset(Event entity, EventAsset asset, String imagem, String itemReconhecido, String tipo) {
		asset.setImagePath(converteImagem(imagem));
		asset.setIntegracaoData(entity.getDateCreation());
		asset.setIntegracaoStatus(0);
		asset.setType(tipo);
		asset.setType2(null);
		asset.setUuid(UUID.randomUUID().toString());
		asset.setValue(itemReconhecido);
		asset.setValueConfirmed(itemReconhecido);
		asset.setWeight(null);
		
	}	
	
	private Integer converteSentido(String direction) {
		if (direction.equals("in")) {
			return 1;
		} else {
			return 2;
		}
	}
	
	private String converteImagem(String img) {
		img = img.replace("\u003d", "=");
		img = img.replace("\u0026", "&");
		return img;
	}
}
