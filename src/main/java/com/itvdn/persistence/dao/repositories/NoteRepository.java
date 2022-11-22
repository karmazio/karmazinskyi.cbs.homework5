package com.itvdn.persistence.dao.repositories;

import com.itvdn.persistence.model.Note;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface NoteRepository extends CrudRepository<Note, Long> {

    void deleteNoteById(Long id);

    @Query(value = "update note set date = :date, note = :note where id = :id"
            , nativeQuery = true)
    void updateNoteById(@Param("id") Long id, @Param("date") String date, @Param("note") String note);

    Note findNoteByDate(String date);
}
