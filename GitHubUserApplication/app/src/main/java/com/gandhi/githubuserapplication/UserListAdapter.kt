package com.gandhi.githubuserapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gandhi.githubuserapplication.databinding.ItemRowUserBinding

class UserListAdapter (private var listUser: ArrayList<User>) : RecyclerView.Adapter<UserListAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallBack: OnItemClickCallback

    fun setOnItemClickCallBack(onItemCallback: OnItemClickCallback) {
        this.onItemClickCallBack = onItemCallback
    }

    class ListViewHolder (var binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowUserBinding.inflate(LayoutInflater.from(parent.context), parent , false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (username, name , avatar) = listUser[position]
        Glide.with(holder.itemView.context)
            .load(avatar)
            .circleCrop()
            .into(holder.binding.imgItemUser)
        holder.binding.tvItemNameList.text = name
        holder.binding.tvItemUsernameList.text = username
        holder.itemView.setOnClickListener { onItemClickCallBack.onItemClicked(listUser[holder.adapterPosition]) }

    }

    override fun getItemCount(): Int = listUser.size

    interface  OnItemClickCallback {
        fun onItemClicked(data: User)
    }


}