package com.example.lab2_2

import android.os.Bundle
import android.content.Intent
import android.widget.EditText
import android.view.View
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab2_2.ui.theme.Lab2_2Theme
class MainActivity : AppCompatActivity() {

    private lateinit var exerciseTypeAllBtn: Button
    private lateinit var exerciseTypeSelectedBtn: Button
    private lateinit var numberInputEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        exerciseTypeAllBtn = findViewById(R.id.exercise_type_all_btn)
        exerciseTypeSelectedBtn = findViewById(R.id.exercise_type_selected_btn)
        numberInputEditText = findViewById(R.id.number_input_edit_text)

        exerciseTypeAllBtn.setOnClickListener {
            val intent = Intent(this, ExerciseAllActivity::class.java)
            startActivity(intent)
        }

        exerciseTypeSelectedBtn.setOnClickListener {
            val selectedNumberText = numberInputEditText.text.toString()
            val selectedNumber = if (selectedNumberText.isNotEmpty() && selectedNumberText.toIntOrNull() in 2..9) {
                selectedNumberText.toInt()
            } else {
                2
            }
            val intent = Intent(this, ExerciseSelectedActivity::class.java)
            intent.putExtra("selectedNumber", selectedNumber)
            startActivity(intent)
        }
    }
}
