package com.itvdn.controllers;

import com.itvdn.persistence.dao.repositories.NoteRepository;
import com.itvdn.persistence.dao.services.implementations.NoteServiceImpl;
import com.itvdn.persistence.model.Note;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

public class DaoTest {

    @Mock
    NoteRepository noteRepository;


    @InjectMocks
    NoteServiceImpl noteService;

    static List<Note> noteList = new ArrayList<>();

    static {
        noteList.add(new Note("21 nov", "hello"));
        noteList.add(new Note("22 nov", "bye"));
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void test1() throws InterruptedException {
        when(noteRepository.findAll()).thenReturn(noteList);
        Assert.assertEquals(noteList, noteService.findAll());
    }

    @Test
    public void test2() {
        when(noteRepository.findNoteByDate("21 nov"))
                .thenReturn(noteList.stream().filter(elem -> elem.getDate().equals("21 nov"))
                        .findFirst().get());
        System.out.println(noteRepository.findNoteByDate("21 nov"));
    }

    @Test(expected = NullPointerException.class)
    public void test6() {
        Assert.assertNull(noteRepository.findNoteByDate("3 sep").getNote());
    }
}
