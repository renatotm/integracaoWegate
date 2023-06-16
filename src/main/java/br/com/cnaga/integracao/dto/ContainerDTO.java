package br.com.cnaga.integracao.dto;

import java.io.Serializable;
import java.util.List;

import br.com.cnaga.integracao.entities.Container;
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

public class ContainerDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String container;
	private String camera;
	private String probability;
	private List<String> images;
	
	public ContainerDTO(Container entity) {
		this.container   = entity.getContainer();              
		this.camera      = entity.getCamera();       
		this.probability = entity.getProbability();           
		this.images      = entity.getImages();
	}	
}
