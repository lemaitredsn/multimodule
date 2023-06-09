package ru.lemaitre.account_details.mvp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.lemaitre.account_details.databinding.ItemHistoryBinding

class HistoryAdapter : ListAdapter<HistoryUiModel, HistoryAdapter.HistoryViewHolder>(ItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HistoryViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: HistoryUiModel) {
            with(binding) {
                icon.setImageResource(item.icon)
                amount.text = item.amount
                operation.text = item.title
            }
        }
    }
}

object ItemCallback : DiffUtil.ItemCallback<HistoryUiModel>() {
    override fun areItemsTheSame(oldItem: HistoryUiModel, newItem: HistoryUiModel): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: HistoryUiModel, newItem: HistoryUiModel): Boolean =
        oldItem == newItem
}