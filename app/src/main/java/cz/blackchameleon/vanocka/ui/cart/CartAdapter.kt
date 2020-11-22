package cz.blackchameleon.vanocka.ui.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import cz.blackchameleon.domain.Product
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cz.blackchameleon.vanocka.R

/**
 * @author Karolina Klepackova on 22.11.2020.
 */

class CartAdapter(
    private val clickListener: (Product) -> Unit
) : ListAdapter<Product, CartAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product) = oldItem == newItem

        override fun areContentsTheSame(oldItem: Product, newItem: Product) = oldItem == newItem
    }) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_cart, parent, false)
        )
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: Product) {

        }
    }
}