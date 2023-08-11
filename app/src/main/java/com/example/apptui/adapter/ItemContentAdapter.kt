package com.example.apptui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.apptui.ListContentIdolActivity
import com.example.apptui.ListContentWifeActivity
import com.example.apptui.R
import com.example.apptui.data.ContentData

class ItemContentAdapter: RecyclerView.Adapter<ItemContentAdapter.ItemContentViewHolder>() {
    private val list: List<String> = ContentData().loadContentData()

    class ItemContentViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val buttonContent: Button = view.findViewById(R.id.button_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemContentViewHolder {
        val adapterLayout =LayoutInflater.from(parent.context).inflate(R.layout.item_content,parent,false)
        return ItemContentViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemContentViewHolder, position: Int) {
        val item = list[position]
        holder.buttonContent.text = item.toString()
        holder.buttonContent.setOnClickListener{
            val context = holder.itemView.context
            val targetActivity: Class<*> = when (holder.buttonContent.text) {
                "My Idol" -> ListContentIdolActivity::class.java
                else -> ListContentWifeActivity::class.java
            }
            val intent = Intent(context, targetActivity)
//            intent.putExtra(ListContentActivity.TitleContent, holder.buttonView.text.toString())
            context.startActivity(intent)
        }
    }
}