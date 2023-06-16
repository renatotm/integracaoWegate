package br.com.cnaga.integracao.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name="INTGR_EVENT")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	@Column(name="FINISH")
	private Date finish;
	@Column(name="GATE_ID")
	private Integer gateId;
	@Column(name="START")
	private Date start;
	@Column(name="STATUS")
	private String status;
	@Column(name="UUID")
	private String uuid;
	@Column(name="WAY")
	private Integer way;
	@Column(name="DATE_CREATION")
	private Date dateCreation;
	@Column(name="integracao_status")
	private Integer integracaoStatus;
	@Column(name="integracao_data")
	private Date integracaoData;	

	@OneToMany(mappedBy = "event", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<EventAsset> assets = new HashSet<>();
			
}
