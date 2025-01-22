package miyucomics.hexcellular

import kotlin.random.Random

private val consonants = charArrayOf('j', 'k', 'l', 'm', 'n', 'p', 's', 't', 'w')
private val vowels = charArrayOf('a', 'e', 'i', 'o', 'u')
private val bannedSyllables = listOf("ji", "ti", "wo", "wu")

private val weights = listOf(5, 4, 2)
private val scanned = weights.runningFold(0) { sum, weight -> sum + weight }.drop(1)
private val peak = scanned.last()

fun generatePropertyName(): String {
	val word = StringBuilder()
	if (Random.nextBoolean())
		word.append(vowels.random())

	val numberOfSyllables = generateNumberOfSyllables()
	var wasNasal = false
	repeat(numberOfSyllables) {
		val syllable = generateSyllable(wasNasal)
		word.append(syllable)
		wasNasal = syllable.endsWith('n')
	}

	return word.toString()
}

private fun generateNumberOfSyllables(): Int {
	val index = Random.nextInt(1, peak + 1)
	return scanned.indexOfFirst { index <= it } + 1
}

private fun generateSyllable(wasNasal: Boolean): String {
	var consonant  = consonants.random()
	var vowel  = vowels.random()
	var syllable = "$consonant$vowel"
	while (wasNasal && (consonant == 'm' || consonant == 'n') || syllable in bannedSyllables) {
		consonant  = consonants.random()
		vowel  = vowels.random()
		syllable = "$consonant$vowel"
	}
	if (Random.nextBoolean() && !syllable.startsWith('n'))
		syllable += 'n'
	return syllable
}