package dnl.bible.api

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class HebrewStringUtilsTest {

    @Test
    fun testToFinalChars(){
        assertEquals("םןץףך", "מנצפכ".toFinalChars())
        assertEquals("אבג", "אבג".toFinalChars())
        assertEquals("אםבץגך", "אמבצגכ".toFinalChars())
    }

    @Test
    fun testToNonFinalChars(){
        assertEquals("מנצפכ", "םןץףך".toNonFinalChars())
        assertEquals("אבג", "אבג".toNonFinalChars())
        assertEquals("אמבצגכ", "אםבץגך".toNonFinalChars())
    }

    @Test
    fun testLastCharToFinal(){
        assertEquals("דן", "דנ".toFinalChars())
    }

    @Test
    fun testHasHebFinalChars(){
        assertTrue("דן".hasHebFinalChars())
        assertFalse("דנ".hasHebFinalChars())
    }
    @Test
    fun testHaveHebMNZPH(){
        assertTrue("אמבצגכ".haveHebMNZPH())
        assertFalse("אבג".haveHebMNZPH())
    }
}