package com.qa.notes.service;

import com.qa.notes.domain.Note;
import com.qa.notes.domain.NoteBook;
import com.qa.notes.exceptions.NoteBookNotFoundException;
import com.qa.notes.exceptions.NoteNotFoundException;
import com.qa.notes.repo.NoteBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteBookService {

    private final NoteBookRepository repo;

    @Autowired
    public NoteBookService(NoteBookRepository repo) {
        this.repo = repo;
    }

    public List<NoteBook> readAllNoteBooks() {
        return this.repo.findAll();
    }

    public NoteBook createNote(NoteBook notebook) {
        return this.repo.save(notebook);
    }

    public NoteBook findNoteBookById(Long id) {
        return this.repo.findById(id).orElseThrow(NoteBookNotFoundException::new);
    }

    public NoteBook updateNoteBook(Long id, NoteBook notebook) {
        NoteBook update = findNoteBookById(id);
        update.setName(notebook.getName());
        return this.repo.save(update);
    }

    public Boolean deleteNoteBookById(Long id){
        if(!this.repo.existsById(id)){
            throw new NoteBookNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}
