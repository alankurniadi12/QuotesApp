package com.alankurniadi.quotesappapi.ui.list.bosnia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alankurniadi.quotesappapi.R
import com.alankurniadi.quotesappapi.model.ListBosnia
import com.alankurniadi.quotesappapi.model.ListEnglish
import kotlinx.android.synthetic.main.item_quotes.view.*

class BosAdapter: RecyclerView.Adapter<BosAdapter.BosViewHolder>() {

    private var onItemClickCallback: OnIItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnIItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    private val data = ArrayList<ListBosnia>()

    fun setData(items: List<ListBosnia>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BosViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.item_quotes, parent, false)
        return BosViewHolder(mView)
    }

    override fun onBindViewHolder(holder: BosViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class BosViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(bosQuotes: ListBosnia) {
            with(itemView) {
                tv_quotes_item.text = bosQuotes.sr
                tv_author_item.text = bosQuotes.author

                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(bosQuotes) }
            }
        }
    }

    interface OnIItemClickCallback {
        fun onItemClicked(data: ListBosnia)
    }
}