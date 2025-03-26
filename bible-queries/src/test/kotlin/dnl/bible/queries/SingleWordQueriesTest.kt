package dnl.bible.queries

import dnl.bible.api.verseIterator
import dnl.bible.json.bible
import kotlin.test.Test
import kotlin.test.assertEquals

class SingleWordQueriesTest {

    @Test
    fun testWordGimatria(){
        val groupedWordResults = SingleWordQueries().queryForSameGimatria(bible.verseIterator(), "שלום")
        //println(json.encodeToString(groupedWordResults))
        assertEquals(698, groupedWordResults.totalNumOfResults)
    }
}