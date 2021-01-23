package com.example.getjob

import android.os.Parcelable
import android.provider.ContactsContract
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.nio.channels.spi.AbstractSelectionKey

@Parcelize
data class Worker(
    var name :String,
    var talent :String,
    var description: String,
    var photo: String,
): Parcelable