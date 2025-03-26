@file:Suppress("unused", "UNUSED_VARIABLE")

package dnl.bible.examples

import dnl.bible.api.*
import dnl.bible.json.bible

fun accessingElements() {
    val seferBereshit = bible.getBook(BibleBook.GENESIS)
    // or by hebrew name
    val bereshit = bible.getBook(BibleBook.byHebrewName("בראשית"))

    val bereshit1stChapter = bereshit.getChapter(1)// 1 based
    // or by operator
    val bereshit1stChapterAgain = bereshit[1]

    val firstVerseOfFirstChapter = bereshit1stChapter.getVerse(1)
    // or by operators
    val firstOfFirstAgain = bereshit[1][1]
}

fun locations() {
    // getting the location of a verse
    val verse = bible.getBook(BibleBook.GENESIS)[1][3]
    val location = verse.getLocation()

    // using a location to access a Verse
    val sameVerse = bible.getVerse(VerseLocation(BibleBook.GENESIS, 1, 3))
}

fun ranges() {
    val parashatBereshit = VerseRangeFactory.newVerseRange("Genesis 1:1–6:8")
}
fun iterators() {
    // iterating a whole book
    val verseIterator = bible.getBook(BibleBook.DANIEL).verseIterator()

    // iterating a range
    val range = VerseRangeFactory.newVerseRange("Genesis 1:1–6:8")
    val iteratorFromRange =VerseRangeIterator(range)

    // performing the iteration
    verseIterator.forEach {
        println("at verse: $it")
    }
}