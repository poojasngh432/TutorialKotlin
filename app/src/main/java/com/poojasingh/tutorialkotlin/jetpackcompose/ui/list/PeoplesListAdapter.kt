package com.poojasingh.tutorialkotlin.jetpackcompose.ui.list

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poojasingh.tutorialkotlin.databinding.LayoutListItemBinding
import com.poojasingh.tutorialkotlin.jetpackcompose.data.model.People

class PeoplesListAdapter(private val items: List<People>, private val clickListener: OnItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(people: People, itemView: View)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = LayoutListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    /**
     * Binds view with item info
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(items[position], clickListener)
    }

    /**
     * Returns the size to item list
     */
    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * View for item, sets item info and click events
     */
    class ViewHolder(val itemBinding: LayoutListItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        lateinit var binding: LayoutListItemBinding

        fun bind(people: People, listener: OnItemClickListener) = with(itemView) {
            itemBinding.textViewName.text = people.name
            itemBinding.textViewMet.text = people.metAt
            itemBinding.buttonContact.text = people.contact
            itemBinding.buttonContact.setOnClickListener {
                // Dial contact number
                val dialIntent = Intent(Intent.ACTION_DIAL)
                dialIntent.data = Uri.parse("tel:${people.contact}")
                itemView.context.startActivity(dialIntent)
            }

            // RecyclerView on item click
            setOnClickListener {
                listener.onItemClick(people, it)
            }
        }

    }

}