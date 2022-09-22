package com.bignerdranch.android.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel : ViewModel() {

    var currentIndex = 0
    var isCheater = false

    private val questionBank = listOf(
        Question(R.string.question_apple, false),
        Question(R.string.question_muddy, false),
        Question(R.string.question_peanuts, true),
        Question(R.string.question_sleep, false),
        Question(R.string.question_copyright, true),
        Question(R.string.question_emus, true),
    )

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }
    fun moveBack() {
        if(currentIndex != 0) {
            currentIndex = (currentIndex - 1) % questionBank.size
        }
    }
}