package br.com.reminder.reminder.exception;

public class LembreteNotFoundException extends RuntimeException {
    public LembreteNotFoundException(Long id) {
        super("Lembrete não encontrado com o ID: " + id);
    }
}