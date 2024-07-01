package com.example.plantdelivery


import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException

class SharedPrefenceHelper(context : Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE)

    fun saveUserInfo(user: User) {
        sharedPreferences.edit().putString(user.email, Gson().toJson(user)).apply()
    }

    fun getUserInfo(email: String): User? {
        val userInfoString = sharedPreferences.getString(email, null)
        return try {
            Gson().fromJson(userInfoString, User::class.java)
        } catch (e: JsonSyntaxException) {
            null
        }
    }
}

data class User(
    val name: String,
    val email: String,
    val phoneNumber: String,
    val password: String
)