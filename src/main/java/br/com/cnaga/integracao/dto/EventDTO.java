package br.com.cnaga.integracao.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import br.com.cnaga.integracao.entities.Event;
import br.com.cnaga.integracao.entities.EventAsset;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Date finish;
	private Integer gateId;
	private Date start;
	private String status;
	private String uuid;
	private Integer way;
	private Date dateCreation;
	private Integer integracaoStatus;
	private Date integracaoData;	
	
	private List<EventAssetDTO> assets = new ArrayList<>();
	
	
	public EventDTO(Event entity) {
		this.id 			  = entity.getId();
		this.finish 		  = entity.getFinish();
		this.gateId           = entity.getGateId();
		this.start            = entity.getStart();
		this.status           = entity.getStatus();
		this.uuid             = entity.getUuid();
		this.way              = entity.getWay();
		this.dateCreation     = entity.getDateCreation();
		this.integracaoStatus = entity.getIntegracaoStatus();
	 	this.integracaoData	  = entity.getIntegracaoData();
	}
	
	public EventDTO(Event entity, Set<EventAsset> assets) {
		this(entity);
		assets.forEach(asset -> this.assets.add(new EventAssetDTO(asset)));
	}

}
