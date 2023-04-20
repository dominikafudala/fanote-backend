package com.example.favnote.repository.type;

import com.example.favnote.entity.type.VNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VNoteRepository extends JpaRepository<VNote, Integer> {
}
