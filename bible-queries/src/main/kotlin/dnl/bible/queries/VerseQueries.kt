package dnl.bible.queries

import dnl.bible.api.Verse
import dnl.bible.api.lastHebCharToFinal

object VerseQueries {

    fun verseForNameStartAndEnd(name: String, verseIterator: Iterator<Verse>): GroupedByBookVerseResults {
        val nameWithFinalLastChar = name.lastHebCharToFinal()

        val visitor = GenericVerseVisitorWithResults { verse: Verse ->
            val text = verse.getText()
            text.first() == nameWithFinalLastChar.first() &&
                    text.last() == nameWithFinalLastChar.last()
        }

        VerseTraversal(verseIterator).traverse(visitor)
        return visitor.getGroupedResults()
    }
}