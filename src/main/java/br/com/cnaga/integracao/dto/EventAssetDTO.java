package br.com.cnaga.integracao.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.cnaga.integracao.entities.EventAsset;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EventAssetDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String imagePath;
	private Integer type2;
	private String uuid;
	private String value;
	private String valueConfirmed;
	private Long weight; 
	private Integer integracaoStatus;
	private Date integracaoData;
	private String type;
	
	public EventAssetDTO(EventAsset entity) {
		this.id               = entity.getId();              
		this.imagePath        = entity.getImagePath();       
		this.type2            = entity.getType2();           
		this.uuid             = entity.getUuid();            
		this.value            = entity.getValue();           
		this.valueConfirmed   = entity.getValueConfirmed();  
		this.weight           = entity.getWeight();          
		this.integracaoStatus = entity.getIntegracaoStatus(); 
		this.integracaoData   = entity.getIntegracaoData();  
		this.type	          = entity.getType();		
	}
	
	
}
