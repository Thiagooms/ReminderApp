package br.com.reminder.reminder.service;

import java.util.Optional;

import br.com.reminder.reminder.exception.LembreteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reminder.reminder.entity.Lembrete;
import br.com.reminder.reminder.repository.ILembreteRepository;


@Service
public class LembreteService {
    
    private final ILembreteRepository repository;

    public LembreteService(ILembreteRepository repository) {
        this.repository = repository;
    }

    public Lembrete create(Lembrete obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Lembrete getId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new LembreteNotFoundException(id));
    }

    public Lembrete update(Lembrete obj) {
        return repository.findById(obj.getId())
                .map(existingLembrete -> {
                    updateLembrete(existingLembrete, obj);
                    return repository.save(existingLembrete);
                })
                .orElseThrow(() -> new LembreteNotFoundException(obj.getId()));
    }

    public void updateLembrete(Lembrete newObj, Lembrete obj) {
        newObj.setNome(obj.getNome());
        newObj.setDescricao(obj.getDescricao());
        newObj.setDataHora(obj.getDataHora());
    }

}
