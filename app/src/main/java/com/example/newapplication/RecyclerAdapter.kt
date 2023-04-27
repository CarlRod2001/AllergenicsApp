package com.example.newapplication


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_holder.*

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    /*
    var entriesTop = arrayOf<CharSequence>()
    var entriesRight = arrayOf<CharSequence>()
    var entriesBottom = arrayOf<CharSequence>()*/



    var TOP = arrayOf("Bareburger",
        "Kung Fu Tea", "Muteki Ramen", "Blue Eyes",
        "O'Bagel", "Karma Kafe")


    var RIGHT = arrayOf("0.1 mi", "0.1 mi",
        "0.1 mi","0.1 mi", "0.2 mi", "0.3 mi")

    var BOTTOM = arrayOf("Eggs, Dairy",
        "Peanuts, Eggs, Dairy",
        "Peanuts, Shellfish, Soy, Eggs, Dairy, Fish",
        "Peanuts, Shellfish, Eggs, Dairy, Fish",
        "Eggs, Dairy, Fish",
        "Peanuts, Shellfish, Dairy, Fish")


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemTOP: TextView
        var itemRIGHT: TextView
        var itemBOTTOM: TextView

        init {
            itemTOP = itemView.findViewById(R.id.topText)
            itemRIGHT = itemView.findViewById(R.id.rightText)
            itemBOTTOM = itemView.findViewById(R.id.bottomText)

            /*
            itemView.setOnClickListener {
                var position: Int = getAdapterPosition()
                val context = itemView.context
                val intent = Intent(context, Call.Details::class.java).apply {
                    putExtra("NUMBER", position)
                    putExtra("CODE", itemTOP.text)
                    putExtra("CATEGORY", itemRIGHT.text)
                    putExtra("CONTENT", itemBOTTOM.text)
                }
                context.startActivity(intent)
            }
             */
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_holder, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, pos: Int) {
        viewHolder.itemTOP.text = TOP[pos]
        viewHolder.itemRIGHT.text = RIGHT[pos]
        viewHolder.itemBOTTOM.text = BOTTOM[pos]
    }

    override fun getItemCount(): Int {
        return TOP.size
    }

}
