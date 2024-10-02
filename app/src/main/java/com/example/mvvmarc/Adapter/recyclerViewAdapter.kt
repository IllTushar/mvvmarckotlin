package com.example.mvvmarc.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmarc.Model.Data
import com.example.mvvmarc.Model.DataResponse
import com.example.mvvmarc.databinding.ItemUserBinding


class recyclerViewAdapter : RecyclerView.Adapter<recyclerViewAdapter.UserViewHolder>() {
    private val user = mutableListOf<Data>()

    class UserViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            binding.name.text = "${data.first_name} & ${data.last_name}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return user.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(user[position])
    }

    // Update the RecyclerView's data
    fun submitList(newUsers: List<Data>) {
        user.clear()
        user.addAll(newUsers)
        notifyDataSetChanged()  // Notify the adapter to update the RecyclerView
    }
}