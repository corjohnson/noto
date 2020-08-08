package co.miniforge.noto.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import java.time.LocalDateTime
import kotlin.coroutines.suspendCoroutine

val note1 = Note(
    id = 0,
    title = "My Note 1",
    content = "This is my note",
    lastModified = LocalDateTime.now().minusDays(8)
)

val note2 = Note(
    id = 1,
    title = "My Note 2",
    content = "This is my note",
    lastModified = LocalDateTime.now().minusDays(6)
)

val note3 = Note(
    id = 2,
    title = "My Note 3",
    content = "This is my note",
    lastModified = LocalDateTime.now().minusDays(2)
)

class TestNoteRepositoryImpl : NoteRepository {
    override suspend fun getAllNotes(): List<Note> =
        listOf(note1, note2, note3)

    override suspend fun searchForNote(text: String): List<Note> =
        listOf(note1, note2)

    override suspend fun saveNoteToDisk(note: Note): Result<Boolean> {
        delay(1000)
        return Result.success(true)
    }

    override suspend fun syncNotesToCloud(): Result<Boolean> {
        delay(1000)
        return Result.success(true)
    }
}