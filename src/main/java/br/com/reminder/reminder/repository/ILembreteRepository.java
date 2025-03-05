package br.com.reminder.reminder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.reminder.reminder.entity.Lembrete;

@Repository
public interface ILembreteRepository extends JpaRepository<Lembrete, Long> {
    
}
