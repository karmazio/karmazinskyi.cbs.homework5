package com.itvdn.persistence.dao.services.implementations;

import com.google.common.collect.Lists;
import com.itvdn.persistence.dao.repositories.NoteRepository;
import com.itvdn.persistence.dao.services.interfaces.NoteService;
import com.itvdn.persistence.model.Note;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> findAll() {
        return Lists.newArrayList(noteRepository.findAll());
    }

    @Override
    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void removeById(long id) {
        noteRepository.deleteNoteById(id);
    }

    @Override
    public void listAllNotes() {
        noteRepository.findAll().forEach(System.out::println);
    }

    public void updateNote(long id, String date, String note) {
        noteRepository.updateNoteById(id, date, note);
    }
}
