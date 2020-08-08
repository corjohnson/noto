package co.miniforge.noto.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.FragmentActivity
import co.miniforge.noto.R

class NoteActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_note)
    }
}