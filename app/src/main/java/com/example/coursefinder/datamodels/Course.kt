package com.example.coursefinder.datamodels

import android.os.Parcel
import android.os.Parcelable

data class Course(
    val courseCode: String,
    val courseName: String,
    val instructor: String,
    val credits: Int,
    val description: String,
    val imagePic: Int,


) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!! ,
        parcel.readInt(),
        ) {}
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(courseCode)
        parcel.writeString(courseName)
        parcel.writeString(instructor)
        parcel.writeInt(credits)
        parcel.writeString(description)
    }

    override fun describeContents(): Int { return 0
    }
    companion object CREATOR : Parcelable.Creator<Course> { override fun createFromParcel(parcel: Parcel): Course {
            return Course(parcel)
        }

        override fun newArray(size: Int): Array<Course?> {
            return arrayOfNulls(size)
        } } }
