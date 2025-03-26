package dnl.bible.queries

import dnl.bible.api.verseIterator
import dnl.bible.json.bible
import kotlin.test.Test
import kotlin.test.assertEquals

class VerseQueriesTest {

    @Test
    fun testVerseForNameStartAndEnd(){
        val results1 = VerseQueries.verseForNameStartAndEnd("דן", bible.verseIterator())
        val results2 = VerseQueries.verseForNameStartAndEnd("דנ", bible.verseIterator())
        assertEquals(results1.totalNumOfResults, results2.totalNumOfResults)

    }
}