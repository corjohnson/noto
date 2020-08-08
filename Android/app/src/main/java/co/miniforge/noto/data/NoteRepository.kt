package co.miniforge.noto.data

interface NoteRepository {
    suspend fun getAllNotes(): List<Note>
    suspend fun searchForNote(text: String): List<Note>
    suspend fun saveNoteToDisk(note: Note): Result<Boolean>
    suspend fun syncNotesToCloud(): Result<Boolean>
}