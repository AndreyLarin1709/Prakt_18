package com.example.pr18

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import org.w3c.dom.Text
import java.text.FieldPosition

class MainActivity3 : AppCompatActivity() {
    private var selectedItem=""
    private var addedItems=""
    override fun onCreate(savedInstanceState: Bundle?){
    super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val items = resources.getStringArray(R.array.list_items)
        val spinner = findViewById<Spinner>(R.id.spin)
        val addedItemsTextView = findViewById<TextView>(R.id.added_items)
        val selectedItemTextView = findViewById<TextView>(R.id.selected_item)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,items)
        val btnSubmit = findViewById<Button>(R.id.btn_submit)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int,id: Long) {
                selectedItem=items[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                //Ничего не делать
            }
        }
        btnSubmit.setOnClickListener {
            selectedItemTextView.text = "Selected item: $selectedItem"
            addedItems += "$selectedItem\n"
            addedItemsTextView.text = "Added items: \n$addedItems"
        }
    }
}