package com.example.photograd.android.utils

import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.photograd.android.BR
import com.example.photograd.android.R
import com.example.photograd.android.custom.PlaysProgress
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
//            .load("https://sun9-2.userapi.com/c847220/v847220070/1e2b5d/lI4r08edp3E.jpg")
            .load(url)
            .error(R.drawable.ic_empty_star)
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
            .load(url)
            .fitCenter()
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .transform(RoundedCorners(14))
            .placeholder(circularProgressDrawable)
            .into(view)
//        "https://www.pond5.com/images/images_db/vlp/image-hero-poster.jpg"
//        "https://sun9-42.userapi.com/c840632/v840632864/80350/U1zUNCI95ZQ.jpg"
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
    @BindingAdapter("setRating")
    fun setRating(view: TextView, rating: Int){
        view.text = rating.toString()
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

    @JvmStatic
    @BindingAdapter("scoreColor")
    fun setScoreColor(view: TextView, score: String?) {
        score ?: return

        val userScore = score[0].toInt()
        val opponentScore = score[2].toInt()

        val scoreColor = when {
            userScore > opponentScore -> R.color.color_winning_score
            userScore < opponentScore -> R.color.color_loosing_score
            else -> R.color.color_draw_score
        }

        view.setTextColor(ContextCompat.getColor(view.context, scoreColor))
    }

    @JvmStatic
    @BindingAdapter("turn")
    fun setTurnStyle(view: TextView, isUserTurn: Boolean?) {
        isUserTurn ?: return
        if(isUserTurn){
            view.setTextColor(ContextCompat.getColor(view.context, R.color.color_your_turn))
            view.text = view.context.getString(R.string.current_games_your_turn)
            view.typeface = Typeface.DEFAULT
        }
    }

    @JvmStatic
    @BindingAdapter(value = ["threshold", "gameamount"], requireAll = false)
    fun TextView.setWinsPlyed(threshold: Int, gameamount: Int){
        text = threshold.toString() + " " + context.resources.getString(R.string.from) + " " + gameamount.toString()
    }

    @JvmStatic
    @BindingAdapter("played")
    fun TextView.setPlayed(played: Int){
        text = context.resources.getString(R.string.played) + " " + played.toString()
    }

    @JvmStatic
    @BindingAdapter("wins")
    fun TextView.setWins(wins: Int){
        text = context.resources.getString(R.string.wins) + " " + wins.toString()
    }

    @JvmStatic
    @BindingAdapter("reward")
    fun TextView.setReward(reward: Int){
        text = reward.toString()
    }

//    @JvmStatic
//    @BindingAdapter(value = ["thresholdProgress", "gameamountProgresss"])
//    fun PlaysProgress.setPlayProgress(thresholdProgress: Int, gameamountProgresss: Int){
//        if(thresholdProgress != null && gameamountProgresss != null){
//            var percentage: Float = ((gameamountProgresss * 100)/ thresholdProgress).toFloat()/100
//            setRatio(percentage)
//        }
//    }

    @JvmStatic
    @BindingAdapter("percentageText")
    fun PlaysProgress.setPercentBackground(percentage: Float?){
        if(percentage != null){
            setRatio(percentage)
        }
    }
}