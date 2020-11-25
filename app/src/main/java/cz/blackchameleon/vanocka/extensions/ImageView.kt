package cz.blackchameleon.vanocka.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import cz.blackchameleon.vanocka.R

/**
 * @author Karolina Klepackova on 23.11.2020.
 */

fun ImageView.setImage(imagePath: String?, placeholder: Int = R.color.background_placeholder) {
    Glide.with(context)
        .asBitmap()
        .load(imagePath)
        .fitCenter()
        .placeholder(placeholder)
        .into(this)
}