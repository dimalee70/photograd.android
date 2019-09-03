package photograd.kz.photograd.api


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface ApiManager {

   /* @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("user_login")
    fun userLogin(@Body loginBody: LoginRequestModel): Observable<LoginModel>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("user_auth")
    fun userAuth(@Body loginBody: LoginRequestModel): Observable<LoginModel>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @GET("get_games_data")
    fun getGamesData(@Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<GamesResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("get_current_games")
    fun getCurrentGamesData(@Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<CurrentGamesResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("get_missions_data")
    fun getMissionsData(@Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<MissionsResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("get_friends")
    fun getFriends(@Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<FriendsResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @GET("get_data")
    fun getData(@Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<GamesResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("get_user_statistics")
    fun getStatisticsData(@Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<StatisticsResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("get_top_rating")
    fun getTopRating(@Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<RatingsResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("get_friends_rating")
    fun getFriendsRating(@Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<RatingsResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("get_offers")
    fun getCategoryOffers(@Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<PartnerOffersResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("get_game")
    fun getGame(@Body gameRequestModel: GetGameRequestModel, @Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<GameResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("get_categories")
    fun getCategories(@Body getCategoriesRequestModel: GetCategoriesRequestModel, @Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<CategoriesResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("select_category")
    fun selectCategory(@Body selectCategoryRequestModel: SelectCategoryRequestModel, @Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<SelectCategoryResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("submit_answers")
    fun submitAnswers(@Body submitAnswersRequestModel: SubmitAnswersRequestModel, @Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<SubmitAnswersResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("challenge_random_user")
    fun challengeRandomUser(@Body model: ChallengeRandomUserRequestModel, @Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<GameResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("get_partner_mission_rating")
    fun getPartnerMissionRating(@Body model: PartnerMissionRatingRequestModel, @Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<PartnerMissionRatingResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("play_partner_mission")
    fun playPartnerMission(@Body model: PartnerMissionPlayRequestModel, @Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<GameResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("play_mission")
    fun playMission(@Body model: MissionPlayRequestModel, @Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<GameResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("give_up_mission")
    fun giveUpMission(@Body model: MissionPlayRequestModel? = null, @Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<NotificationsDataResponse>


    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("find_players")
    fun findPlayers(@Body model: FindPlayersRequestModel, @Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<PlayersResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("friendship_request")
    fun friendshipRequest(@Body model: FriendshipRequestModel, @Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<FriendResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("decline_friendship")
    fun declineFriendship(@Body model: FriendshipRequestModel, @Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<DeclinedFriendshipResponse>


    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("accept_game")
    fun acceptGame(@Body model: GetGameRequestModel, @Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<GameResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("decline_game")
    fun declineGame(@Body model: GetGameRequestModel, @Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<GameResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("give_up_game")
    fun giveUpGame(@Body model: GetGameRequestModel, @Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<NotificationsDataResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("challenge_user")
    fun challengeUser(@Body model: FriendshipRequestModel, @Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<GameResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @GET("check_notifications")
    fun checkNotifications(@Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<NotificationsResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("confirm_notifications")
    fun confirmNotifications(@Body model: ConfirmNotificationsRequestModel, @Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<ConfirmNotificationsResponse>

    @POST("registration")
    fun register(@Body model: RegistrationRequestModel): Observable<LoginModel>

    @POST("social_user_login")
    fun socialAuth(@Body model: SocialLoginRequestModel): Observable<LoginModel>

    @Headers("Content-Type:multipart/form-data", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("upload_image")
    fun uploadImage(@Body model: ImageUploadRequestModel, @Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<ImageUploadResponse> //MultipartBody.Part)

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("update_profile")
    fun updateProfileImage(@Body model: UpdateProfileRequestModel, @Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<LoginModel>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @GET("get_user")
    fun getUser(@Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<LoginModel>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("update_profile")
    fun updateProfileName(@Body model: UpdateProfileNameRequestModel, @Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<LoginModel>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("get_purchases")
    fun getPurchases(@Header("X-SESSION-ID") sessionId: String = DataHolder.sessionid!!): Observable<PurchasesResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("purchase_offer")
    fun purchaseOffer(@Body model: PurchaseRequestModel, @Header("X-SESSION-ID") sessionId: String? = DataHolder.sessionid): Observable<PurchaseResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("activate_purchase")
    fun activatePurchase(@Body model: ActivatePurchaseRequestModel, @Header("X-SESSION-ID") sessionId: String? = DataHolder.sessionid): Observable<PurchaseResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("activate_reward")
    fun activateReward(@Body model: ActivateRewardRequestModel, @Header("X-SESSION-ID") sessionId: String? = DataHolder.sessionid): Observable<ActivateRewardResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("reset_password")
    fun resetPassword(@Body model: ResetPasswordRequestModel): Observable<RestorePasswordResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("user_logout")
    fun logout(@Header("X-SESSION-ID") sessionId: String? = DataHolder.sessionid): Observable<LogoutResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("resend_confirmation_email")
    fun resendConfirmationEmail(@Header("X-SESSION-ID") sessionId: String? = DataHolder.sessionid): Observable<LogoutResponse>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("update_profile")
    fun updateProfile(@Body model: UpdateProfileDataRequestModel, @Header("X-SESSION-ID") sessionId: String? = DataHolder.sessionid): Observable<LoginModel>

    @Headers("Content-Type:application/json", "X-ACCEPT-VERSION:${Constants.version}")
    @POST("create_question")
    fun createQuestion(@Body model: QuestionRequestModel, @Header("X-SESSION-ID") sessionId: String? = DataHolder.sessionid): Observable<QuestionResponseModel>

    companion object {
        private val httpClient = OkHttpClient.Builder()
            .connectTimeout(Constants.connectTimeout, TimeUnit.SECONDS)
            .writeTimeout(Constants.writeTimeout, TimeUnit.SECONDS)
            .readTimeout(Constants.readTimeout, TimeUnit.SECONDS)
            .build()

        val client = Retrofit.Builder()
            .baseUrl(Constants.apiEndpoint)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
            .create(ApiManager::class.java)!!

    }*/

}