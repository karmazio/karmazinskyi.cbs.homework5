package com.itvdn.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
//@Table(name = "Note", schema = "diary")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String date;
    private String note;

    @Override
    public String toString() {
        return "Note #" + id + " : " + note + " - " + date;
    }

    public Note() {
    }

    public Note(String date, String note) {
        this.date = date;
        this.note = note;
    }
}
