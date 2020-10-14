package com.ericknavarro.restaurantapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ericknavarro.restaurantapp.R
import com.ericknavarro.restaurantapp.model.Card


class RecyclerAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<RecyclerAdapter.CardViewHolder>() {

    companion object{
        const val RECYCLER_ADAPTER_REQUEST = 2
        const val ID_NOTE = "idNote"
    }

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var cards = emptyList<Card>().toMutableList()// Cached copy of words
    private val context: Context = context

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val context: Context = itemView.context
        val titleCard: TextView = itemView.findViewById(R.id.titleCard)
        val imageCard: ImageView = itemView.findViewById(R.id.imagePost)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val itemView = inflater.inflate(R.layout.card_adapter, parent, false)
        return CardViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val current = cards[position]

        holder.titleCard.text = current.title
        holder.imageCard.setImageResource(current.image)

    }

    fun getItem(position: Int) = cards[position]

    override fun getItemCount() = cards.size

    fun removeAt(position: Int) {
        cards.removeAt(position)
        notifyItemRemoved(position)
    }

    internal fun setCards(card: List<Card>) {
        this.cards = card.toMutableList()
        notifyDataSetChanged()
    }

}