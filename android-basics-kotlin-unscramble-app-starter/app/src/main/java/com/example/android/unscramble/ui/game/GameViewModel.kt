package com.example.android.unscramble.ui.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * ViewModel to store data, and changed the data
 */

class GameViewModel : ViewModel() {
    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    private val _score = MutableLiveData(0)
    val score: LiveData<Int>
        get() = _score

    private val _currentWordCount = MutableLiveData(0)
    val currentWordCount: LiveData<Int>
        get() = _currentWordCount

    private val _currentScrambledWord = MutableLiveData<String>()
    val currentScrambledWord: LiveData<String>
        get() = _currentScrambledWord

    init {
        getNextWord()
    }

    fun nextWord(): Boolean {
        return if (currentWordCount.value!! < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }

    fun isUserWordCorrect(playerWord: String): Boolean {
        return if (playerWord.equals(currentWord, true)) {
            increaseScore()
            true
        } else false
    }

    fun reinitializeData() {
        _score.value = 0
        _currentWordCount.value = 0
        wordsList.clear()
        getNextWord()
    }

    /*
    * HELPER FUNCTION
    * */

    private fun getNextWord() {
        var tempWord = allWordsList.random()

        while (wordsList.contains(tempWord)) {
            tempWord = allWordsList.random()
        }

        currentWord = tempWord
        val tempScramble = currentWord.toCharArray()

        while (String(tempScramble).equals(currentWord, false)) {
            tempScramble.shuffle()
        }

        _currentScrambledWord.value = String(tempScramble)
        _currentWordCount.value = _currentWordCount.value?.inc()
        wordsList.add(currentWord)
    }

    private fun increaseScore() {
        _score.value = _score.value?.plus(SCORE_INCREASE)
    }
}