package co.miniforge.noto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.miniforge.noto.data.Note
import java.time.LocalDateTime

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
    }
}