package dnl.bible.json

import dnl.bible.api.ParashaEnum
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ToraApiTest {
    val tora = ToraImpl(bible)

    @Test
    fun testParasha() {
        var parasha = tora.getParasha(ParashaEnum.BALAK)
        var verses = parasha.getVerses()
        assertEquals(104, verses.size)

        parasha = tora.getParasha(ParashaEnum.BEREISHIS)
        verses = parasha.getVerses()
        assertEquals(146, verses.size)

    }

}