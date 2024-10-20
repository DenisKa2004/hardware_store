package com.example.test_application

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(var items: List<Item>, var context: Context): RecyclerView.Adapter<ItemsAdapter.MyViewHolder>() {
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imag: ImageView = view.findViewById(R.id.imageView)
        val title: TextView = view.findViewById(R.id.item_title)
        val desc: TextView = view.findViewById(R.id.desc)
        val price: TextView = view.findViewById(R.id.price)
        val btn: Button = view.findViewById(R.id.button)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itam_in_list, parent,false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return  items.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.desc.text = items[position].desc
        holder.title.text = items[position].title
        holder.price.text = items[position].price.toString() + " руб."

        val imageId = context.resources.getIdentifier(
            items[position].image,
            "drawable",
            context.packageName
        )
        holder.imag.setImageResource(imageId)

        holder.btn.setOnClickListener{
            val intent = Intent(context, ItemActivity::class.java)
            intent.putExtra("itemTitle", items[position].title)
            intent.putExtra("itemText", items[position].text)
            context.startActivity(intent)
        }

    }
}