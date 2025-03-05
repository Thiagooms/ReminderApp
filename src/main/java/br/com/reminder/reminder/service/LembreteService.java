package br.com.reminder.reminder.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reminder.reminder.entity.Lembrete;
import br.com.reminder.reminder.repository.ILembreteRepository;

@Service
public class LembreteService {
    
    @Autowired
    private ILembreteRepository repository;

    public Lembrete create(Lembrete obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Lembrete getId(Long id) {
        Optional<Lembrete> obj = repository.findById(id);
        return obj.get();
    }

    public Lembrete update(Lembrete obj) {
        Optional<Lembrete> newObj = repository.findById(obj.getId());
    
        if (newObj.isPresent()) {
            updateLembrete(newObj.get(), obj);
            return repository.save(newObj.get());
        } else {
            throw new RuntimeException("Lembrete não encontrado com o ID: " + obj.getId());
        }
    }

    public void updateLembrete(Lembrete newObj, Lembrete obj) {
        newObj.setNome(obj.getNome());
        newObj.setDescricao(obj.getDescricao());
        newObj.setDataHora(obj.getDataHora());
    }

}
