package ru.lemaitre.products.mvp.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.lemaitre.products.R

class ProductsAdapter(private val onItemClick: (ProductUiModel) -> Unit) :
    ListAdapter<ProductUiModel, ProductsAdapter.ProductViewHolder>(DiffUtilProductUi) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ProductViewHolder(
        private val binding: View,
        private val onItemClick: (ProductUiModel) -> Unit
        ) : RecyclerView.ViewHolder(binding) {
        fun bind(item: ProductUiModel) {
            binding.findViewById<ImageView>(R.id.icon).setImageResource(item.icon)
            binding.findViewById<TextView>(R.id.amount).text = item.amount
            binding.findViewById<TextView>(R.id.number).text = item.number
            binding.setOnClickListener {
                onItemClick(item)
            }
        }

    }
}

object DiffUtilProductUi : DiffUtil.ItemCallback<ProductUiModel>() {
    override fun areItemsTheSame(oldItem: ProductUiModel, newItem: ProductUiModel): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ProductUiModel, newItem: ProductUiModel): Boolean =
        oldItem == newItem
}