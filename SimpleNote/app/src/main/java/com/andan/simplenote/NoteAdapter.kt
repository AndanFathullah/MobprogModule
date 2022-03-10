package com.andan.simplenote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andan.simplenote.databinding.ActivityMainBinding
import com.andan.simplenote.databinding.ListNoteBinding

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private var stdList: ArrayList<NoteModel> = ArrayList()
    private var onClickItem: ((NoteModel) -> Unit)? = null
    private var onDeleteItem: ((NoteModel) -> Unit)? = null

    fun addItems(items: ArrayList<NoteModel>){
        this.stdList = items
        notifyDataSetChanged()
    }

    fun setOnClickItem(callback: (NoteModel) -> Unit){
        this.onClickItem = callback
    }

    fun setOnDeleteItem(callback: (NoteModel) -> Unit){
        this.onDeleteItem = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ListNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteAdapter.NoteViewHolder, position: Int) {
        val (id, title, text) = stdList[position]
        holder.binding.id.text = id.toString()
        holder.binding.title.text = title
        holder.binding.text.text = text

        holder.itemView.setOnClickListener{
            onClickItem?.invoke(stdList[position])
        }

        holder.binding.deleteButton.setOnClickListener{
            onDeleteItem?.invoke(stdList[position])
        }
    }

    override fun getItemCount(): Int {
        return stdList.size
    }

    class NoteViewHolder(var binding: ListNoteBinding): RecyclerView.ViewHolder(binding.root)
}