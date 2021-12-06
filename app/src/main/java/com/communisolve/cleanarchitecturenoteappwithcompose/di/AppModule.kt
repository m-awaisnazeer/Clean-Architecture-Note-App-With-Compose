package com.communisolve.cleanarchitecturenoteappwithcompose.di

import android.app.Application
import androidx.room.Room
import com.communisolve.cleanarchitecturenoteappwithcompose.feature_note.data.data_source.NoteDatabase
import com.communisolve.cleanarchitecturenoteappwithcompose.feature_note.data.data_source.NoteDatabase.Companion.DATABASE_NAME
import com.communisolve.cleanarchitecturenoteappwithcompose.feature_note.data.repository.NoteRepositoryImp
import com.communisolve.cleanarchitecturenoteappwithcompose.feature_note.domain.repository.NoteRepository
import com.communisolve.cleanarchitecturenoteappwithcompose.feature_note.domain.use_case.AddNoteUseCase
import com.communisolve.cleanarchitecturenoteappwithcompose.feature_note.domain.use_case.DeleteNoteUseCase
import com.communisolve.cleanarchitecturenoteappwithcompose.feature_note.domain.use_case.GetNotesUseCase
import com.communisolve.cleanarchitecturenoteappwithcompose.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(database: NoteDatabase): NoteRepository {
        return NoteRepositoryImp(database.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            GetNotesUseCase(repository),
            DeleteNoteUseCase(repository),
            AddNoteUseCase(repository)
        )
    }


}