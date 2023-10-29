package com.ninjatech.fcmnotify.fcm

import android.content.Context
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging


class FcmTokenHelper (private val context: Context) {


    fun getFcmToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                //Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result.toString()

            println("=====getToken=====$token")
            // Log and toast
            //val msg = context.getString(R.string.msg_token_fmt, token)
            //Log.d(TAG, msg)
            //Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        })
    }

    interface FcmToken {
        fun tokenReceived(token: String)
    }
}