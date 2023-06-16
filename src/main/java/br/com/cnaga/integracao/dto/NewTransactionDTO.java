package br.com.cnaga.integracao.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import br.com.cnaga.integracao.entities.Container;
import br.com.cnaga.integracao.entities.NewTransaction;
import br.com.cnaga.integracao.entities.Plate;
import br.com.cnaga.integracao.entities.Rail;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class NewTransactionDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long number; //ID
	private String datetime; //DATE_CREATION / START / FINISH
	private String direction; //WAY
	private Integer gateId; //GATE_ID
 
	private List<PlateDTO> plates;
	private List<ContainerDTO> containers;
	private List<RailDTO> rails;	
	
	public NewTransactionDTO(NewTransaction entity) {
		this.number 		  = entity.getNumber();
		this.datetime 		  = entity.getDatetime();
		this.gateId           = entity.getGateId();
		this.direction        = entity.getDirection();
	}
	
	public NewTransactionDTO(NewTransaction entity, Set<Plate> plates, Set<Container> containers, Set<Rail> rails) {
		this(entity);
		plates.forEach(plate -> this.plates.add(new PlateDTO(plate)));
		containers.forEach(container -> this.containers.add(new ContainerDTO(container)));
		rails.forEach(rail -> this.rails.add(new RailDTO(rail)));
	}	
	
}