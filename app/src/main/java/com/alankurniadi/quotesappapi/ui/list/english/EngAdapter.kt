package com.alankurniadi.quotesappapi.ui.list.english

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alankurniadi.quotesappapi.R
import com.alankurniadi.quotesappapi.model.ListEnglish
import kotlinx.android.synthetic.main.item_quotes.view.*

class EngAdapter: RecyclerView.Adapter<EngAdapter.EngViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    private val data = ArrayList<ListEnglish>()

    fun setData(items: List<ListEnglish>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EngViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.item_quotes, parent, false)
        return EngViewHolder(mView)
    }

    override fun onBindViewHolder(holder: EngViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class EngViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(engQuotes: ListEnglish) {
            with(itemView) {
                tv_quotes_item.text = engQuotes.en
                tv_author_item.text = engQuotes.author

                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(engQuotes) }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ListEnglish)
    }
}