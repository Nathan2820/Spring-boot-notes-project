package com.qa.notes.repo;

import com.qa.notes.domain.NoteBook;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface NoteBookRepository extends JpaRepository<NoteBook, Long> {
}
