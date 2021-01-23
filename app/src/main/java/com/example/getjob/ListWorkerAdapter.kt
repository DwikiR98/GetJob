package com.example.getjob

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_row.view.*

class ListWorkerAdapter(private val listWorker: ArrayList<Worker>)  : RecyclerView.Adapter<ListWorkerAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(worker: Worker){
            with(itemView){
                Glide.with(itemView.context)
                        .load(worker.photo)
                        .apply(RequestOptions().override(55,55))
                        .into(image_view)
                tv1.text = worker.name
                tv2.text = worker.talent
                tv3.text = worker.description
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i : Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row, viewGroup,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listWorker[position])
    }

    override fun getItemCount(): Int = listWorker.size
}