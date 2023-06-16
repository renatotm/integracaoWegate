package br.com.cnaga.integracao.entities;

import java.io.Serializable;
import java.util.List;

import org.apache.catalina.Container;

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

public class NewTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long number; //ID
	private String datetime; //DATE_CREATION / START / FINISH
	private String direction; //WAY
	private Integer gateId; //GATE_ID
	
	// STATUS / UUID / INTEGRACAO_STATUS / INTEGRACAO_DATA
	
	private List<Plate> plates;
	private List<Container> containers;
	private List<Rail> rails;	
	
}

/*
 * dbo.INTGR_EVENT
 * ID		FINISH					GATE_ID	START					STATUS			UUID									WAY	DATE_CREATION			integracao_status	integracao_data
   1605757	2023-06-01 17:45:03.000	2		2023-06-01 17:45:00.000	CRIADO_EASYGATE	031c893f-7a90-447b-9378-874366edb951	1	2023-06-01 17:44:28.597	0					NULL
 *
 *  dbo.INTGR_ASSET
 * 	ID		IMAGE_PATH																					TYPE2	UUID									VALUE	VALUE_CONFIRMED	WEIGHT	INTEGRATION_EVENT_ID	integracao_status	integracao_data	TYPE
	2141010	2023/06/01/031c893f-7a90-447b-9378-874366edb951/86e53aed-2cba-3f2b-81aa-02d4e43a38a0.jpg	NULL	86e53aed-2cba-3f2b-81aa-02d4e43a38a0	ELN5218	ELN5218			0		1605757					0					NULL			CAVALO
	2141011	2023/06/01/031c893f-7a90-447b-9378-874366edb951/577543bf-db79-36e1-85f7-243ce58bde97.jpg	NULL	577543bf-db79-36e1-85f7-243ce58bde97	ELN5218	ELN5218			0		1605757					0					NULL			CARRETA
	
	dbo.CNT
	id	bic			integracao_status	integracao_data
	95	AMFU3163561	0					2014-06-25 11:36:38.250
	
 * */