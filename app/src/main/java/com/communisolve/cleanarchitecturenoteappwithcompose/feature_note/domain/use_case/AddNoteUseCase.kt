package com.communisolve.cleanarchitecturenoteappwithcompose.feature_note.domain.use_case

import com.communisolve.cleanarchitecturenoteappwithcompose.feature_note.domain.model.InValidNoteException
import com.communisolve.cleanarchitecturenoteappwithcompose.feature_note.domain.model.Note
import com.communisolve.cleanarchitecturenoteappwithcompose.feature_note.domain.repository.NoteRepository

class AddNoteUseCase(
    private val repository: NoteRepository
) {

    @Throws(InValidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()){
            throw InValidNoteException("The title of the note can't be empty.")
        }

        if (note.content.isBlank()){
            throw InValidNoteException("The content of the note can't be empty.")
        }
        repository.insertNote(note)
    }
}