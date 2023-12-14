package com.example.data.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import com.example.domain.util.AirplaneModeChangeProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class AirplaneModeChangeProviderImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : AirplaneModeChangeProvider {
    override fun isChanged(): Flow<Boolean> = callbackFlow {
        val receiver = object : BroadcastReceiver() {
            override fun onReceive(p0: Context?, p1: Intent?) {
                p1?.let {
                    val enabled = p1.getBooleanExtra("state", false)
                    channel.trySend(enabled)
                }
            }
        }

        context.registerReceiver(receiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))

        awaitClose { context.unregisterReceiver(receiver) }
    }
}