package br.com.cnaga.integracao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cnaga.integracao.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
