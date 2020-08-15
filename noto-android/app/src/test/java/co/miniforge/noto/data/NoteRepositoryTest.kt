package co.miniforge.noto.data

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Test

@ExperimentalCoroutinesApi
class NoteRepositoryTest {
    @Test
    fun getAll_returns_all_notes() {
        runBlockingTest {
            val noteRepo = TestNoteRepositoryImpl()
            val result = noteRepo.getAllNotes()
            val expected = listOf(note1, note2, note3)
            assertTrue(result.containsAll(expected))
        }
    }

    @Test
    fun searchForNote_returns_list_of_notes() {
        runBlockingTest {
            val noteRepo = TestNoteRepositoryImpl()
            val result = noteRepo.searchForNote("Search string")
            val expected = listOf(note1, note2)
            assertTrue(result.containsAll(expected))
        }
    }

    @Test
    fun saveNoteToDisk_does_not_throw_exception() {
        runBlockingTest {
            val noteRepo = TestNoteRepositoryImpl()
            noteRepo.saveNoteToDisk(note1.copy(id = 8))
        }
    }

    @Test
    fun syncNotesToCloud_does_not_throw_exception() {
        runBlockingTest {
            val noteRepo = TestNoteRepositoryImpl()
            noteRepo.syncNotesToCloud()
        }
    }
}