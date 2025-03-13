package br.com.reminder.reminder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import br.com.reminder.reminder.entity.Lembrete;
import br.com.reminder.reminder.service.LembreteService;

@Controller
public class LembreteController {

    @Autowired
    private LembreteService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("lembrete", new Lembrete());
        return "home";
    }

    @PostMapping("/")
    public String create(@ModelAttribute Lembrete lembrete) {
        System.out.println("Recebendo lembrete: " + lembrete.getNome() + " - " + lembrete.getDescricao());
        service.create(lembrete);
        return "redirect:/";
    }

    // @DeleteMapping(value = "/{id}")
    // public ResponseEntity <Void> delete(@PathVariable Long id) {
    //     service.delete(id);
    //     return ResponseEntity.noContent().build();
    // }

    // @GetMapping(value = "/{id}")
    // public ResponseEntity<Lembrete> getId(@PathVariable Long id) {
    //     Lembrete lembrete = service.getId(id);
    //     return ResponseEntity.ok().body(lembrete);
    // }

    // @PutMapping (value = "/{id}")
    // public ResponseEntity<Lembrete> update(@PathVariable Long id, @RequestBody Lembrete obj){
    //     obj.setId(id);
    //     return ResponseEntity.ok().body(service.update(obj));

    // }
    
}
