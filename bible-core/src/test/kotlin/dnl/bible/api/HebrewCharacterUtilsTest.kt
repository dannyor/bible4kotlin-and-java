package dnl.bible.api

import kotlin.test.Test
import kotlin.test.assertTrue

class HebrewCharacterUtilsTest {

    @Test
    fun test() {
        assertTrue('\u0591'.isHebrewChar())
    }
}