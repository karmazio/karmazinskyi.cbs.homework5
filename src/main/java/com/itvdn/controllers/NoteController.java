package com.itvdn.controllers;

import com.itvdn.persistence.dao.services.implementations.NoteServiceImpl;
import com.itvdn.persistence.dao.services.interfaces.NoteService;
import com.itvdn.persistence.model.Note;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class NoteController {

    private static final Log LOG = LogFactory.getLog(NoteController.class);
    @Autowired
    private NoteServiceImpl noteService;

    @GetMapping(value = "/all")
    public ModelAndView showAllNotes(ModelAndView modelAndView) {
        noteService.listAllNotes();
        modelAndView.addObject("notes", noteService.findAll());
        modelAndView.setViewName("index.jsp");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public String addNewNote(HttpServletRequest request) {
        Note note = new Note();
        note.setDate(request.getParameter("date"));
        note.setNote(request.getParameter("note"));
        LOG.info("New note with id " + noteService.addNote(note).getId() + " was added");
        return "redirect:/all";
    }

    @PostMapping(value = "/delete")
    public ModelAndView deleteNote(HttpServletRequest request, ModelAndView modelAndView) {
        long idToDelete = Integer.parseInt(request.getParameter("idToDelete"));
        noteService.removeById(idToDelete);
        modelAndView.addObject("notes", noteService.findAll());
        modelAndView.setViewName("redirect:/all");
        return modelAndView;
    }

    @PostMapping(value = "/update")
    public String updateNote(HttpServletRequest request) {
        noteService.updateNote(Long.parseLong(request.getParameter("idToUpdate")),
                request.getParameter("dateToUpdate"),
                request.getParameter("noteToUpdate"));
//        modelAndView.addObject("notes", noteService.findAll());
        return "redirect:/all";
    }
}
