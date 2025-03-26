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

### Locations
Class ```VerseLocation``` is a convenient way of serializing (storing or communicating) 
the location of a specific verse. 
```kotlin
// getting the location of a verse
val verse = bible.getBook(BibleBook.GENESIS)[1][3]
val location = verse.getLocation()

// using a location to access a Verse
val sameVerse = bible.getVerse(VerseLocation(BibleBook.GENESIS, 1, 3))
```

### Ranges
A ```VerseRange``` points to a range of verses that may span several verses
chapters and even books.
Good example of this is the notion of a 'parasha' that usually 
spans several chapters and commonly starting and ending in between.
```kotlin
val parashatBereshit = VerseRangeFactory.newVerseRange("Genesis 1:1–6:8")
```

### Iterators
The way to work and process a bulk of verses is using
```kotlin
// iterating a whole book
val verseIterator = bible.getBook(BibleBook.DANIEL).verseIterator()

// iterating a range
val range = VerseRangeFactory.newVerseRange("Genesis 1:1–6:8")
val iteratorFromRange = VerseRangeIterator(range)

// performing the iteration
verseIterator.forEach {
    println("at verse: $it")
}
```

# bible-queries
This project provides:
- Means to traverse verses or words
- Implementations of common or interesting queries

```kotlin
// Get all verses in the bible starting with the letter 'ל'
val visitor = GenericVerseVisitorWithResults { verse: Verse ->
    val text = verse.getText()
    text.startsWith('ל')
}

VerseTraversal(bible.verseIterator()).traverse(visitor)
val results = visitor.getGroupedResults()
```





