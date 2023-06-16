package br.com.cnaga.integracao.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name="INTGR_ASSET")
public class EventAsset implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	@Column(name="IMAGE_PATH")
	private String imagePath;
	@Column(name="TYPE2")
	private Integer type2;
	@Column(name="UUID")
	private String uuid;
	@Column(name="VALUE")
	private String value;
	@Column(name="VALUE_CONFIRMED")
	private String valueConfirmed;
	@Column(name="WEIGHT")
	private Long weight; 
	@Column(name="integracao_status")
	private Integer integracaoStatus;
	@Column(name="integracao_data")
	private Date integracaoData;
	@Column(name="TYPE")
	private String type;

	@ManyToOne
	@JoinColumn(name = "INTEGRATION_EVENT_ID")
	private Event event;
	//private Long integrationEventId;	
	
}
