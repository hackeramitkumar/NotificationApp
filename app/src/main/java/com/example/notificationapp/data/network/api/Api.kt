package com.example.notificationapp.data.network.api

import com.example.notificationapp.data.network.*
import retrofit2.Call
import retrofit2.http.*

interface Api {
    @POST("/user")
    fun saveUser(@Header("Authorization") auth: String?, @Body userModel: UserModel?): Call<UserResponse?>

    @GET("/user")
    fun getUserData(@Header("Authorization") auth: String?): Call<UserResponse?>

    @POST("/user/avatar")
    fun updateProfilePic(@Header("Authorization") auth: String?, @Body avatar: ProfilePicResponse): Call<ProfilePicResponse?>

    @POST("/user/fcmtoken")
    fun setFCMToken(@Header("Authorization") auth: String?, @Body token: FCMToken): Call<FCMToken?>

    @GET("/user/{email}")
    fun getUserDetails(
        @Header("Authorization") auth: String?,
        @Path("email") email: String,
    ): Call<UserDetailResponse?>

    @PUT("/user/subscribe")
    fun subscribeToClub(
        @Header("Authorization") auth: String?,
        @Body club: ClubSubscriptionModel
    ): Call<ClubSubscriptionModel?>

    @PUT("/user/unsubscribe")
    fun unsubscribeToClub(
        @Header("Authorization") auth: String?,
        @Body club: ClubSubscriptionModel
    ): Call<ClubSubscriptionModel?>

    @GET("/clubs")
    fun getClubs(@Header("Authorization") auth: String?): Call<List<ClubModel>?>

    @GET("/posts/{club}")
    fun getClubPosts(
        @Header("Authorization") auth: String?,
        @Path("club") clubID: String,
    ): Call<List<PostResponse>?>

    @POST("/posts/{club}")
    fun sendPost(
        @Header("Authorization") auth: String?,
        @Path("club") clubID: String?,
        @Body postModel: PostModel
    ): Call<PostResponse?>
}
