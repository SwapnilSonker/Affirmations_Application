package com.example.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.Dataset
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //to load affirmation data from the Datasource and store it in a variable for
        //further use.
        val myDataset = Datasource().LoadAffirmations()

        /* to find a reference to the recycler view within the layout. */
        val recyclerview = findViewById<RecyclerView>(R.id.recycler_view)

        //assigning ItemAdapter instance to the adapter property of the recycler view.
        recyclerview.adapter = ItemAdapter(this , myDataset)


        /* Since the layout size of your RecyclerView is fixed in the activity layout,
        you can set the setHasFixedSize parameter of the RecyclerView to true.
        This setting is only needed to  improve performance. Use this setting if you
        know that changes in content do not change the layout size of the RecyclerView. */
        recyclerview.setHasFixedSize(true)


        //an id is added to refer to the textView
        //val textView : TextView = findViewById(R.id.textview)

        //an editable text is added to load the information in string format.
        //textView.text = Datasource().LoadAffirmations().size.toString()
    }
}