package com.example.example

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity // пакеты внешние(созданые разрабами)
import android.os.Bundle // пакеты вместе с ос(из коробки)
import android.widget.Toast
import com.example.example.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {  // : это наследование
    // контроллер Activity
    private lateinit var binding: ActivityMainBinding
    private var successes:Int = 0
    private var fails : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) { // входной аргумент - данные которые можно сохранить между пересозданием окон(название класса Bundle)
        super.onCreate(savedInstanceState)
        // Устанавливает макет для этого окна
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        newGame()
    }
    private fun newGame(){

        binding.editText.text?.clear()

        val word = getWord()

        val mixed = word.toCharArray().let{
            it.shuffle()
            it.concatToString()
        }

        binding.mixedView.text = mixed
        binding.button.setOnClickListener{
            val userWord = binding.editText.text.toString() ?: ""

            if(userWord.equals(word)){
                Toast.makeText(this,"Right!",Toast.LENGTH_SHORT).show()
                successes++
                binding.successes.text = successes.toString()
                newGame()
            }else{
                Toast.makeText(this,"Wrong! Try again!",Toast.LENGTH_SHORT).show()
                fails++
                binding.fails.text = fails.toString()
                binding.editText.text?.clear()
            }
        }


    }

    private fun getWord():String{
        val words = resources.getStringArray(R.array.words)
        return words[Random.nextInt(words.size)]
    }
}