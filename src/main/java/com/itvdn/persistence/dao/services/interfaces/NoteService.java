package com.itvdn.persistence.dao.services.interfaces;

import com.itvdn.persistence.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {

    List<Note> findAll();

    Note addNote(Note note);

    void removeById(long id);

    void listAllNotes();
}
