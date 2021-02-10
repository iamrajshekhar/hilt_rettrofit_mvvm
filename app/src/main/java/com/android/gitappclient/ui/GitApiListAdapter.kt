package com.android.gitappclient.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.gitappclient.data.GitRepoModel
import com.android.gitappclient.databinding.ItemGitRepoBinding
import com.bumptech.glide.Glide


class GitApiListAdapter : ListAdapter<GitRepoModel, GitApiListAdapter.ItemHolder>(DiffCallBack()) {


    inner class ItemHolder(private  val binding: ItemGitRepoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(currentItem: GitRepoModel?) {
           binding .apply {
               Glide.with(binding.root).load(currentItem?.owner?.avatarUrl).into(avatarImage)
               ownerNameTv.text=currentItem?.name
           }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = ItemGitRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

 class DiffCallBack: DiffUtil.ItemCallback<GitRepoModel>(){
    override fun areItemsTheSame(oldItem: GitRepoModel, newItem: GitRepoModel): Boolean {
     return   oldItem.id == newItem.id

    }

    override fun areContentsTheSame(oldItem: GitRepoModel, newItem: GitRepoModel): Boolean {
        return   oldItem == newItem
    }
}
}