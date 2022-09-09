package com.example.puredriveapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MessageRecyclerAdapter (private val messageList: ArrayList<Message>): RecyclerView.Adapter<MessageRecyclerAdapter.ViewHolder>() {

    /*
    private var titles = arrayOf("Eunice", "Yassi", "Brian")

    private var details = arrayOf("Sample Message", "Sample Message", "Sample Message")

    private var images = intArrayOf(R.drawable.bitmap_ek1, R.drawable.bitmap_ek2, R.drawable.bitmap_ek3)


     */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = messageList[position]
        holder.itemTitle.text = currentItem.title
        holder.itemDetail.text = currentItem.detail
        holder.itemImage.setImageResource(currentItem.image)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /*
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)

            itemView.setOnClickListener{
                val position: Int = adapterPosition

                Toast.makeText(itemView.context, "you clicked on ${titles[position]}", Toast.LENGTH_LONG).show()
            }
        }

         */
        val itemImage: ImageView = itemView.findViewById(R.id.item_image)
        val itemTitle: TextView = itemView.findViewById(R.id.item_title)
        val itemDetail: TextView = itemView.findViewById(R.id.item_detail)
    }

}