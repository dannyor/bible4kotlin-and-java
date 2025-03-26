package dnl.bible.json

import dnl.bible.api.*


class ToraImpl(private val bible: Bible) : Tora {
    override fun getHumash(humash: HumashEnum): Book {
        return bible.getBook(humash.bibleBook)
    }

    override fun getParasha(parasha: ParashaEnum): Parasha {
        val book = bible.getBook(parasha.range.start.book)
        val verses = book.getVerseRange(parasha.range).asSequence().toList()
        return ParashaImpl(parasha, verses)
    }
}

data class ParashaImpl(
    val parashaEnum: ParashaEnum,
    private val verses: List<Verse>
) : Parasha {
    override val name = parashaEnum.englishName

    override fun getVerses(): List<Verse> {
        return verses
    }
}
