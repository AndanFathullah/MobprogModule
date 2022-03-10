package com.andan.recyclerdemo

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andan.recyclerdemo.databinding.ViewListBinding

class ListAdapter: RecyclerView.Adapter<ListAdapter.UserViewHolder>(){

    private var listUser = arrayListOf<UserData>()

    fun submitList(userList: ArrayList<UserData>){
        listUser = userList
    }

    class UserViewHolder(private val binding: ViewListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(user: UserData){
            with(binding){
                name.text = user.username
                userCompany.text = user.company
                userLocation.text = user.location
                userPhoto.setImageResource(user.photo)
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, UserDetail::class.java)
                    intent.putExtra(UserDetail.EXTRA_USER, user)
                    itemView.context.startActivities(arrayOf(intent))
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.UserViewHolder {
        val listUserBinding = ViewListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  UserViewHolder(listUserBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = listUser[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int = listUser.size

}