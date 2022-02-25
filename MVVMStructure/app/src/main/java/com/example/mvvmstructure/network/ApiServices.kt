package com.netset.counterbook.network

import com.google.gson.JsonElement
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
import java.lang.StringBuilder

interface ApiServices {

    @POST("/api/login/")
    fun apiLogin(@Body requestBody: RequestBody): Call<JsonElement>

    @POST("/api/forgot-password/")
    fun apiForgotPassword(@Body requestBody: RequestBody): Call<JsonElement>

    @POST("/api/generate-otp/")
    fun apigenerateOtp(@Body requestBody: RequestBody): Call<JsonElement>

    @POST("/api/verify-otp/")
    fun apiVerifyOtp(@Body requestBody: RequestBody): Call<JsonElement>

    @Multipart
    @POST("/api/create-user/")
    fun apiCreateUser(@Part("members") members: List<Int>, @PartMap partMap: HashMap<String, RequestBody>): Call<JsonElement>

    @Multipart
    @PATCH("/api/update-user/{id}/")
    fun apiUpdateProfileImage(@Path("id") id: String, @PartMap partMap: HashMap<String, RequestBody>) : Call<JsonElement>

    @PATCH("/api/update-user/{id}/")
    fun apiEditProfile(@Path("id") id: String, @Body requestBody: RequestBody): Call<JsonElement>

    @GET("/api/user/{id}/")
    fun apiGetUserDetail(@Path("id") id: String): Call<JsonElement>

    @POST("/api/add-user/{id}/")
    fun apiAddUser(@Path("id") id: String, @Body requestBody: RequestBody): Call<JsonElement>

    @POST("/api/remove-user/{id}/")
    fun apiRemoveUser(@Path("id") id: String, @Body requestBody: RequestBody): Call<JsonElement>

    @POST("/api/complete-profile/")
    fun apiCompleteProfile(@Body requestBody: RequestBody): Call<JsonElement>

    @GET("/api/order-filter")
    fun apiGetOrdersList(@Query("status") id: String): Call<JsonElement>

    @GET("/api/delivery-filter")
    fun apiGetDeliveryList(@Query("status") id: String): Call<JsonElement>

    @POST("/api/jobs/")
    fun apiCreateNewOrder(@Body requestBody: RequestBody) : Call<JsonElement>

    @POST("/api/deliveries/")
    fun apiCreateNewDelivery(@Body requestBody: RequestBody) : Call<JsonElement>

    @POST("/api/comments/")
    fun apiAddComment(@Body requestBody: RequestBody) : Call<JsonElement>

    @POST("/api/change-password/")
    fun apiChangePassword(@Body requestBody: RequestBody) : Call<JsonElement>

    @GET("/api/driver-list/")
    fun apiGetDriverList(): Call<JsonElement>

    @GET("/api/get_order/{id}/")
    fun apiGetOrderDetail(@Path("id") id: String) : Call<JsonElement>

    @Multipart
    @POST("/api/order_upload/{id}/")
    fun apiUploadOrderAttachment(@Path("id") id: String, @PartMap partMap: HashMap<String, RequestBody>) : Call<JsonElement>

    @Multipart
    @POST("/api/delivery_upload/{id}/")
    fun apiUploadDeliveryAttachment(@Path("id") id: String, @PartMap partMap: HashMap<String, RequestBody>) : Call<JsonElement>

    @POST("/api/comments/")
    fun apiUploadComment(@Body requestBody: RequestBody) : Call<JsonElement>

    @GET("/api/user/{id}/")
    fun apiGetUserProfile(@Path("id") id: String) : Call<JsonElement>

    @PATCH("/api/order/{id}/delete/")
    fun apiMoveOrderToTrash(@Path("id") id: StringBuilder) : Call<JsonElement>

    @PATCH("/api/order-undo/{id}/delete/")
    fun undoDeletedOrder(@Path("id") id: StringBuilder) : Call<JsonElement>

    @GET("/api/get_trashed_orders/")
    fun apiGetDeletedOrders() : Call<JsonElement>

    @GET("/api/get_trashed_deliveries/")
    fun apiGetDeletedDeliveries() : Call<JsonElement>

    @PATCH("/api/jobs/{id}/")
    fun apiEditOrder(@Path("id") id: String, @Body requestBody: RequestBody) : Call<JsonElement>

    // order status change apis.....
    @PATCH("/api/order/{id}/complete/")
    fun apiMarkAsComplete(@Path("id") id: StringBuilder) : Call<JsonElement>

    @PATCH("/api/order/{id}/pending/")
    fun apiMarkAsPending(@Path("id") id: StringBuilder) : Call<JsonElement>

    @PATCH("/api/order/{id}/active/")
    fun apiMarkAsActive(@Path("id") id: StringBuilder) : Call<JsonElement>

    @PATCH("/api/order/{id}/pending_pickup/")
    fun apiMarkAsPendingPickup(@Path("id") id: StringBuilder) : Call<JsonElement>

    @PATCH("/api/deliveries/{id}/")
    fun apiEditDelivery(@Path("id") id: String, @Body requestBody: RequestBody) : Call<JsonElement>

    @PATCH("/api/delivery/{id}/complete/")
    fun apiDeliveryMarkAsComplete(@Path("id") id: StringBuilder) : Call<JsonElement>

    @PATCH("/api/delivery/{id}/active/")
    fun apiDeliveryMarkAsActive(@Path("id") id: StringBuilder) : Call<JsonElement>

    @PATCH("/api/delivery/{id}/delete/")
    fun apiMoveDeliveryToTrash(@Path("id") id: StringBuilder) : Call<JsonElement>

    @PATCH("/api/delivery-undo/{id}/delete/")
    fun undoDeletedDelivery(@Path("id") id: StringBuilder) : Call<JsonElement>

    @DELETE("/api/delete_comment/{id}/")
    fun apiDeleteComment(@Path("id") id: String) : Call<JsonElement>

    @PATCH("/api/update_comment/{id}/")
    fun apiEditComment(@Path("id") id: String, @Body requestBody: RequestBody) : Call<JsonElement>

    @DELETE("/api/order/{id}/permanent_delete/")
    fun apiOrderTrashDeletePermanent(@Path("id") id: StringBuilder): Call<JsonElement>

    @DELETE("/api/delivery/{id}/permanent_delete/")
    fun apiDeliveryTrashDeletePermanent(@Path("id") id: StringBuilder) : Call<JsonElement>

    @GET("/api/notification/")
    fun apiGetNotification(): Call<JsonElement>

    @PATCH("/api/read_notification/{id}/")
    fun apiNotificatioMarkAsRead(@Path("id") id: String) : Call<JsonElement>

    @GET("/api/order-filter")
    fun apiGetOrderSearch(@QueryMap options : Map<String, String>): Call<JsonElement>

    @GET("/api/delivery-filter")
    fun apiGetDeliverySearch(@QueryMap options : Map<String, String>) : Call<JsonElement>

    @GET("/api/logout/")
    fun apiLogout() : Call<JsonElement>

    @GET("/api/{jobs}/{id}/")
    fun apiGetJobData(@Path("jobs") job: String, @Path("id") id: String) : Call<JsonElement>

    @POST("/api/generate_label/")
    fun apiGeneratelabel(@Body requestBody: RequestBody) : Call<JsonElement>

    @DELETE("/api/delete_attachment/{id}/")
    fun apiDeleteAttachment(@Path("id") id: String) : Call<JsonElement>

    @PATCH("/api/update-user/{id}/")
    fun apiMakeUserActiveForDelivery(@Path("id") id: String, @Body requestBody: RequestBody) : Call<JsonElement>

    @POST("/api/add_manual_driver/{delivery_id}/")
    fun apiAssignDriverManually(@Path("delivery_id") order_id : String, @Body requestBody: RequestBody) : Call<JsonElement>

    @GET("/api/filter")
    fun apiGetFilteredJob(@QueryMap options : Map<String, String>) : Call<JsonElement>

    @PATCH("/api/order_action/{order_id}/")
    fun apiUpdateOrder(@Path("order_id") order_id : StringBuilder, @Body requestBody: RequestBody) : Call<JsonElement>

    @GET("/api/check_date")
    fun apiCheckDate(@Query("date") date : String) : Call<JsonElement>

    @GET(" /api/admin-users/")
    fun apiGetAdminList() : Call<JsonElement>

    @GET(" /api/staff-users/")
    fun apiGetStaffList() : Call<JsonElement>

    @PATCH("/api/user_delete/{user_id}/")
    fun apiMakeUserDisable(@Path("user_id") user_id : String, @Body requestBody: RequestBody) : Call<JsonElement>

    @PATCH("/api/activated_user/{user_id}/")
    fun apiMakeUserEnable(@Path("user_id") user_id : String, @Body requestBody: RequestBody) : Call<JsonElement>

    @GET("/api/inactive_users/")
    fun apiCallInactiveUsers() : Call<JsonElement>

    @POST("/api/send_receipt/")
    fun apiSendReceipt(@Body requestBody: RequestBody) : Call<JsonElement>
}