package co.miniforge.noto.data

import android.os.Bundle
import java.time.LocalDateTime

private const val BUNDLE_NOTE_ID = "note_id"
private const val BUNDLE_NOTE_TITLE = "note_title"
private const val BUNDLE_NOTE_CONTENT = "note_content"
private const val BUNDLE_NOTE_TIMESTAMP = "note_timestamp"

fun Note.asBundle(): Bundle {
    return Bundle().apply {
        putLong(BUNDLE_NOTE_ID, id)
        putString(BUNDLE_NOTE_TITLE, title)
        putString(BUNDLE_NOTE_CONTENT, content)
        putString(BUNDLE_NOTE_TIMESTAMP, lastModified.toString())
    }
}

fun Bundle.parseNote(): Note {
    val id = getLong(BUNDLE_NOTE_ID)
    val title = getString(BUNDLE_NOTE_TITLE, "")
    val content = getString(BUNDLE_NOTE_CONTENT, "")
    val timestamp = LocalDateTime.parse(getString(BUNDLE_NOTE_TIMESTAMP, ""))

    return Note(id, title, content, timestamp)
}