package co.miniforge.noto.notes.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import co.miniforge.noto.R

import kotlinx.android.synthetic.main.activity_note.*

class NoteActivity : AppCompatActivity() {
    private var activeFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_note)

        showNotePreview()
    }

    private fun showNotePreview() {
        activeFragment = ViewNoteFragment()
        supportFragmentManager.beginTransaction()
            .replace(contentContainer.id, activeFragment!!)
            .commitNow()
    }

    private fun showNoteEdit() {
        activeFragment = EditNoteFragment()
        supportFragmentManager.beginTransaction()
            .replace(contentContainer.id, activeFragment!!)
            .commitNow()
    }
}