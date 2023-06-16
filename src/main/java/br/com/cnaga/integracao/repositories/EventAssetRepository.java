package br.com.cnaga.integracao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cnaga.integracao.entities.EventAsset;

@Repository	
public interface EventAssetRepository extends JpaRepository<EventAsset, Long> {

}
