package com.android.rv_diffutil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.rv_diffutil.databinding.ItemListViewBinding
import kotlinx.android.synthetic.main.item_list_view.view.*

class MainRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<Users> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MainViewHolder(ItemListViewBinding.inflate(LayoutInflater.from(parent.context)).root)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MainViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MainViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: Users) {
            with(itemView) {
                tv_fn.text = user.first_name
                tv_ln.text = user.last_name
                tv_gender.text = user.gender
            }
        }
    }

    fun submitList(list: List<Users>) {
        val oldList = items
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(
            UsersItemDiffCallback(
                oldList, list
            )
        )
        items.clear()
        items.addAll(list)
        diffResult.dispatchUpdatesTo(this)
    }

    class UsersItemDiffCallback
        (var oldList: List<Users>, var newList: List<Users>) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].user_id == newList[newItemPosition].user_id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

    }

}