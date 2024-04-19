package com.example.feature_main.data.network

import com.example.feature_main.domain.mapper.main_model.CountryMusicDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {

    /**

        Приходит ошибка с сервера, вот ошибка:
        FATAL EXCEPTION: main
        Process: com.example.testappeffectivemobile, PID: 6112
        java.net.SocketTimeoutException: failed to connect to drive.google.com/2a00:1450:400c:c1d::c2 (port 443) from /fec0::282c:ac28:e05c:714 (port 34208) after 10000ms
        at libcore.io.IoBridge.connectErrno(IoBridge.java:190)
        at libcore.io.IoBridge.connect(IoBridge.java:134)

     */
    @GET("uc")
    suspend fun getOfferList(
        @Query("export") export : String = "download",
        @Query("id") id : String = "1o1nX3uFISrG1gR-jr_03Qlu4_KEZWhav"
    ) : CountryMusicDto



}