package br.com.cnaga.integracao.dto;

import java.io.Serializable;
import java.util.List;

import br.com.cnaga.integracao.entities.Plate;
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

public class PlateDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String plate;
	private String camera;
	private String probability;
	private List<String> images;
	
	public PlateDTO(Plate entity) {
		this.plate       = entity.getPlate();              
		this.camera      = entity.getCamera();       
		this.probability = entity.getProbability();           
		this.images      = entity.getImages();
	}		
}
