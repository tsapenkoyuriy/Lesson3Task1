package com.android.ytsapenko.recyclerex2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.send_button as sendButton
import kotlinx.android.synthetic.main.activity_main.messageEditText as messageEdit

class MainActivity : AppCompatActivity() {
private val LEFT_MESSAGE:Int = 1
private val RIGHT_MESSAGE:Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        var radioStrategy:Int = RIGHT_MESSAGE
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView:RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        //handling of radiogroup buttons pressing
        val radioGroup = findViewById<RadioGroup>(R.id.leftRightRadioGroup)
        radioGroup.setOnCheckedChangeListener{radioGroup,i->
            when(i){
                R.id.left_sender->{
                    Toast.makeText(this,"Left sender has been choosen", Toast.LENGTH_SHORT).show()
                    radioStrategy=LEFT_MESSAGE
                }
                R.id.right_sender->{
                    Toast.makeText(this,"Right sender has been choosen", Toast.LENGTH_SHORT).show()
                    radioStrategy=RIGHT_MESSAGE
                }
            }
        }

        val messages:MutableList<Any> = mutableListOf()

        //handling of button click
        sendButton.setOnClickListener {
            when(radioStrategy){
                LEFT_MESSAGE->{
                    messages.add(LeftMessage("Ivan",messageEdit.text.toString()))
                }
                RIGHT_MESSAGE->{
                    messages.add(RightMessage("Petro",messageEdit.text.toString()))
                }
            }
            messageEdit.text.clear()
            recyclerView.adapter = MessageAdapter(messages)
        }
        recyclerView.adapter = MessageAdapter(messages)

    }


}
