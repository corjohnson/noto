package co.miniforge.noto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.miniforge.noto.data.Note
import co.miniforge.noto.data.asBundle
import co.miniforge.noto.util.Toaster
import co.miniforge.noto.view.ViewNoteFragment
import java.time.LocalDateTime

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val noteToView = Note(
        id = 0,
        title = "This is my note!",
        content = "This is the content of my note!",
        lastModified = LocalDateTime.now()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchBtn.setOnClickListener {
            val searchText = searchEditText.text.toString()
            if (searchText.isBlank()) {
                Toaster.showMessage(this, "Please enter something you'd like to search for")
            } else {
                searchForNote(searchText)
            }
        }
    }

    private fun searchForNote(text: String) {
        GlobalScope.launch {
            val note = async {
                noteToView
            }

            val noteBundle = note.await().asBundle()

            launch(Dispatchers.Main) {
                val fragment = ViewNoteFragment()
                fragment.arguments = noteBundle
                supportFragmentManager.beginTransaction()
                    .add(fragment, "Note")
                    .commitNow()
            }
        }
    }
}