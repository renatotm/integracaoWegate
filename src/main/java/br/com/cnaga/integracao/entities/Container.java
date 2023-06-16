package br.com.cnaga.integracao.entities;

import java.io.Serializable;
import java.util.List;

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

public class Container implements Serializable {
	private static final long serialVersionUID = 1L;

	private String container;
	private String camera;
	private String probability;
	private List<String> images;
	
}
