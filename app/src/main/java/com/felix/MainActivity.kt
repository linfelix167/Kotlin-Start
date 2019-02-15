package com.felix

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.row_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listview)

        listView.adapter = MyCustomAdaptor()
    }

    private class MyCustomAdaptor: BaseAdapter() {

        private val names = arrayListOf(
            "Donald Trump", "Steve Jobs", "Tim Cook", "Mark Zuckerberg", "Barack Obama",
            "Donald Trump", "Steve Jobs", "Tim Cook", "Mark Zuckerberg", "Barack Obama",
            "Donald Trump", "Steve Jobs", "Tim Cook", "Mark Zuckerberg", "Barack Obama",
            "Donald Trump", "Steve Jobs", "Tim Cook", "Mark Zuckerberg", "Barack Obama"
        )

        // Render each row
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {

            val rowMain: View

            // checking if convertView is null, have to inflate a new row
            if (convertView == null) {
                val layoutInflater = LayoutInflater.from(viewGroup!!.context)
                rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)

                Log.v("getView", "calling findViewById which is expensive")
                val nameTextView = rowMain.name_textview
                val positionTextView = rowMain.position_textview
                val viewHolder = ViewHolder(nameTextView, positionTextView)
                rowMain.tag = viewHolder

            } else {
                rowMain = convertView
            }

            val viewHolder = rowMain.tag as ViewHolder
            viewHolder.nameTextView.text = names.get(position)
            viewHolder.positionTextView.text = "Row Number: $position"

            return rowMain
        }

        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        // Number of row
        override fun getCount(): Int {
            return names.size
        }

        private class ViewHolder(val nameTextView: TextView, val positionTextView: TextView)
    }
}
