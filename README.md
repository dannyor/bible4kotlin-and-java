# bible4kotlin-and-java
A Bible API for JVM languages

## bible-core
Automatically loads a json bible. ([json-hebrew-bible](https://github.com/dannyor/json-hebrew-bible))

Provides basic API for accessing bible books, chapters, verses and the words in verses.

### Getting a bible instance:
There is a global val holding a bible instance surprisingly named 'bible'

### Getting elements:
```kotlin
val seferBereshit = bible.getBook(BibleBook.GENESIS)// 'bible' is global
// or by hebrew name
val bereshit = bible.getBook(BibleBook.byHebrewName("בראשית"))

val bereshit1stChapter = bereshit.getChapter(1)// 1 based
// or by operator
val bereshit1stChapterAgain = bereshit[1]

val firstVerseOfFirstChapter = bereshit1stChapter.getVerse(1)
// or by operators
val firstOfFirstAgain = bereshit[1][1]
```
