package co.miniforge.noto.data

import java.time.LocalDateTime

data class Note(val id: Long,
                val title: String,
                val content: String,
                val lastModified: LocalDateTime)