package com.example.lab2_2
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ExerciseAllActivity : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var answerTextView: TextView
    private lateinit var resultTextView: TextView

    private var totalQuestions = 20
    private var correctAnswers = 0
    private var currentQuestion = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_all)

        questionTextView = findViewById(R.id.question_text_view1)
        answerTextView = findViewById(R.id.answer_text_view1)
        resultTextView = findViewById(R.id.result_text_view1)

        generateQuestion()

        answerTextView.setOnEditorActionListener { _, _, _ ->
            checkAnswer()
            true
        }
    }

    private fun generateQuestion() {
        val firstNumber = (2..9).random()
        val secondNumber = (2..9).random()

        questionTextView.text = "$firstNumber x $secondNumber = "
        answerTextView.text = ""
    }

    private fun checkAnswer() {
        val userAnswer = answerTextView.text.toString().trim()

        if (userAnswer.isNotEmpty()) {

            val aaa = (questionTextView.text.toString()).substring(0,1).trim().toBigInteger()
            val bbb = (questionTextView.text.toString()).substring(4,5).trim().toBigInteger()
            val currentAnswer = (aaa * bbb).toString()
            if (userAnswer == currentAnswer) {
                correctAnswers++
                resultTextView.text = "Правильный ответ"
            } else {
                resultTextView.text = "Неверный ответ"
            }
            currentQuestion++
            if (currentQuestion <= totalQuestions) {
                generateQuestion()
            } else {
                val percentage = (correctAnswers.toDouble() / totalQuestions.toDouble()) * 100
                resultTextView.text = "Тест завершен. Процент правильных ответов: %.2f%%".format(percentage)
                answerTextView.isEnabled = false
            }
        }
    }
}
