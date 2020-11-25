package cz.blackchameleon.vanocka.ui.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cz.blackchameleon.domain.CartItem
import cz.blackchameleon.vanocka.R
import cz.blackchameleon.vanocka.extensions.setImage
import kotlinx.android.synthetic.main.item_cart.view.*

/**
 * @author Karolina Klepackova on 22.11.2020.
 */

class CartAdapter : ListAdapter<CartItem, CartAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<CartItem>() {
        override fun areItemsTheSame(oldItem: CartItem, newItem: CartItem) = oldItem == newItem

        override fun areContentsTheSame(oldItem: CartItem, newItem: CartItem) = oldItem == newItem
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
        fun bind(item: CartItem) {
            itemView.apply {
                product_image.setImage(item.image)
                product_name.text = item.name
                product_title.text = item.title
                product_title.viewTreeObserver.apply {
                    addOnGlobalLayoutListener {
                        itemView.product_title?.let {
                            it.maxLines = it.height / it.lineHeight
                        }
                    }
                    removeOnGlobalLayoutListener {}
                }
                product_amount.text = "${item.amount}"
                product_price.text = "${item.price} CZK"
                product_unit.text = resources.getString(R.string.product_unit, item.unit)
                amount_arrow_up.setOnClickListener {
                    product_amount.text = "${item.amount + 1}"
                    item.amount.inc()
                }
                amount_arrow_down.setOnClickListener {
                    if ((item.amount - 1) <= 0) {
                        product_amount.text = "0"
                        item.amount = 0f
                    } else {
                        product_amount.text = "${item.amount - 1}"
                        item.amount.dec()
                    }
                }
            }
        }
    }
}