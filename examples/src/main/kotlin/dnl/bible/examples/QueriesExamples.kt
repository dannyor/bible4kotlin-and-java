@file:Suppress("unused", "UNUSED_VARIABLE")

package dnl.bible.examples

import dnl.bible.api.Verse
import dnl.bible.api.verseIterator
import dnl.bible.json.bible
import dnl.bible.queries.GenericVerseVisitorWithResults
import dnl.bible.queries.VerseTraversal

fun queryForAllVersesStartingWithLamed() {
    // Get all verses in the bible starting with the letter 'ל'
    val visitor = GenericVerseVisitorWithResults { verse: Verse ->
        val text = verse.getText()
        text.startsWith('ל')
    }

    VerseTraversal(bible.verseIterator()).traverse(visitor)
    val results = visitor.getGroupedResults()
}