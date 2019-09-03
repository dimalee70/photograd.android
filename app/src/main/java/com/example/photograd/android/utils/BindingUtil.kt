package com.example.photograd.android.utils

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.photograd.android.BR
import com.example.photograd.android.R
import com.example.photograd.android.custom.RoundedCornersTransformation
import com.google.android.material.shape.RoundedCornerTreatment

/**
 * Created by wokrey@gmail.com on 8/16/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
object BindingUtil {

    @JvmStatic
    @BindingAdapter("invisible")
    fun makeInvisible(view: View, invisible: Boolean) {
        view.visibility = if (invisible) View.INVISIBLE else View.VISIBLE
    }

    @JvmStatic
    @BindingAdapter("gone")
    fun makeGone(view: View, gone: Boolean) {
        view.visibility = if (gone) View.GONE else View.VISIBLE
    }

    @JvmStatic
    @BindingAdapter("offerImg")
    fun loadOfferImg(view: ImageView, url: String?) {
        val circularProgressDrawable = CircularProgressDrawable(view.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        val corners = RoundedCornersTransformation(radius = 14f, cornerType = RoundedCornersTransformation.CornerType.TOP)
        Glide
            .with(view.context)
            .load(url)
            .transform(corners)
            .placeholder(circularProgressDrawable)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("img")
    fun loadImg(view: ImageView, url: String?) {
        val circularProgressDrawable = CircularProgressDrawable(view.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        Glide
            .with(view.context)
            .load(url)
            .transform(RoundedCorners(14))
            .placeholder(circularProgressDrawable)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("userImg")
    fun loadUserImg(view: ImageView, url: String?) {
        val circularProgressDrawable = CircularProgressDrawable(view.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        Glide
            .with(view.context)
            .load("https://sun9-2.userapi.com/c847220/v847220070/1e2b5d/lI4r08edp3E.jpg")
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .transform(RoundedCorners(14))
            .placeholder(circularProgressDrawable)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("testImg")
    fun loadTestImg(view: ImageView, url: String?) {
        val circularProgressDrawable = CircularProgressDrawable(view.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        Glide
            .with(view.context)
            .load("https://sun9-2.userapi.com/c847220/v847220070/1e2b5d/lI4r08edp3E.jpg")
            .transform(RoundedCorners(14))
            .placeholder(circularProgressDrawable)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("roundImg")
    fun loadRoundImg(view: ImageView, url: String?) {
        val circularProgressDrawable = CircularProgressDrawable(view.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        Glide
            .with(view.context)
            .load("https://sun9-42.userapi.com/c840632/v840632864/80350/U1zUNCI95ZQ.jpg")
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .transform(RoundedCorners(14))
            .placeholder(circularProgressDrawable)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("gameImg")
    fun loadGameImg(view: ImageView, url: String?) {
        val circularProgressDrawable = CircularProgressDrawable(view.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        Glide
            .with(view.context)
            .load(url)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .transform(RoundedCorners(14))
            .placeholder(circularProgressDrawable)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("entries", "layout")
    fun <T> setEntries(
        viewGroup: ViewGroup,
        entries: List<T>?, layoutId: Int
    ) {
        viewGroup.removeAllViews()
        if (entries != null) {
            val inflater = viewGroup.context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            for (i in entries.indices) {
                val entry = entries[i]
                val binding = DataBindingUtil.inflate<ViewDataBinding>(inflater, layoutId, viewGroup, true)
                binding.setVariable(BR.data, entry)
            }
        }
    }

    @JvmStatic
    @BindingAdapter("stars")
     fun LinearLayout.setStars(count: Int){
        val params =
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT)
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            params.rightMargin = 4
        } else {
            params.marginEnd = 4
        }

        for (i in 0 until count) {
            val image = ImageView(context).apply {
                setImageResource(R.drawable.ic_star)
            }
            addView(image, params)
        }

        for (i in count until 5) {
            val image = ImageView(context).apply {
                setImageResource(R.drawable.ic_empty_star)
            }
            addView(image, params)
        }
    }
}