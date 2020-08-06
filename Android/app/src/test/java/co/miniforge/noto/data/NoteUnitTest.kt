package co.miniforge.noto.data

import org.junit.Test

import org.junit.Assert.*
import java.time.LocalDateTime

class NoteUnitTest {
    private val note = Note(
        id = 0,
        title = "Test Note",
        content = "This is a note!",
        lastModified = LocalDateTime.now()
    )

    @Test
    fun classIsCreated() {
        assertTrue(note.content == "This is a note!")
    }
}