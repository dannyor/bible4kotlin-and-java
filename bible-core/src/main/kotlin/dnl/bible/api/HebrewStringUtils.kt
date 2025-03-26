package dnl.bible.api


fun String.toFinalChars(): String {
    if (!this.haveHebMNZPH()) return this
    val sb = StringBuilder()
    this.forEach { if (it.isMNZPH()) sb.append(it.toHebFinal()) else sb.append(it) }
    return sb.toString()
}

fun String.lastHebCharToFinal(): String {
    if (last().isHebFinalLetter()) return this
    return substring(0, lastIndex) + last().toHebFinal()
}

fun String.hasHebFinalChars(): Boolean {
    this.forEach { if (it.isHebFinalLetter()) return true }
    return false
}

fun String.haveHebMNZPH(): Boolean {
    this.forEach { if (it.isMNZPH()) return true }
    return false
}

fun String.toNonFinalChars(): String {
    val sb = StringBuilder()
    this.forEach { if (it.isHebFinalLetter()) sb.append(it.toNonFinal()) else sb.append(it) }
    return sb.toString()
}