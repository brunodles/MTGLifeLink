package com.brunodles.mtglifelink

import android.databinding.ObservableInt
import android.os.Parcel
import android.os.Parcelable

class LifeCounter() : Parcelable {

    var life: ObservableInt = ObservableInt(20)

    fun plus() {
        life.set(life.get() + 1)
    }

    fun minus() {
        life.set(life.get() - 1)
    }

    constructor(parcel: Parcel) : this() {
        life = ObservableInt(parcel.readInt())
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(life.get())
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LifeCounter> {
        override fun createFromParcel(parcel: Parcel): LifeCounter {
            return LifeCounter(parcel)
        }

        override fun newArray(size: Int): Array<LifeCounter?> {
            return arrayOfNulls(size)
        }
    }
}