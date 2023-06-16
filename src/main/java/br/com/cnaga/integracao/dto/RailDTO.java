package br.com.cnaga.integracao.dto;

import java.io.Serializable;
import java.util.List;

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

public class RailDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String text;
	private String camera;
	private String probability;
	private List<String> images;	
	
	public RailDTO(Rail entity) {
		this.text        = entity.getText();              
		this.camera      = entity.getCamera();       
		this.probability = entity.getProbability();           
		this.images      = entity.getImages();
	}			
}
