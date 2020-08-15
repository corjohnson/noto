package co.miniforge.noto.notes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.miniforge.noto.R
import co.miniforge.noto.data.Note
import co.miniforge.noto.data.parseNote

import kotlinx.android.synthetic.main.view_note.*
import java.time.format.DateTimeFormatter

class ViewNoteFragment: Fragment() {
    private lateinit var noteToView: Note

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.view_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteToView = arguments!!.parseNote()
        displayNote()
    }

    fun displayNote() {
        noteTitle.text = noteToView.title
        noteContent.text = noteToView.content
        noteTimestamp.text = noteToView.lastModified.format(DateTimeFormatter.BASIC_ISO_DATE)
    }
}