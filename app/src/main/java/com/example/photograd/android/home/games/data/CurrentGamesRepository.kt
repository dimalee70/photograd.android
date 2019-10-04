package com.example.photograd.android.home.games.data

import com.example.photograd.android.home.games.data.model.CurrentGamesData
import io.reactivex.Single

/**
 * Created by wokrey@gmail.com on 8/26/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
interface CurrentGamesRepository {

    fun getCurrentGames(): Single<CurrentGamesData>
}