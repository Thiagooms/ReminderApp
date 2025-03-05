package br.com.reminder.reminder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.reminder.reminder.entity.Lembrete;
import br.com.reminder.reminder.service.LembreteService;

@RestController
@RequestMapping (value = "/lembrete")
public class LembreteController {

    @Autowired
    private LembreteService service;

    @PostMapping
    public ResponseEntity<Lembrete> create(@RequestBody Lembrete obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity <Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Lembrete> getId(@PathVariable Long id) {
        Lembrete lembrete = service.getId(id);
        return ResponseEntity.ok().body(lembrete);
    }

    @PutMapping (value = "/{id}")
    public ResponseEntity<Lembrete> update(@PathVariable Long id, @RequestBody Lembrete obj){
        obj.setId(id);
        return ResponseEntity.ok().body(service.update(obj));

    }
    
}
