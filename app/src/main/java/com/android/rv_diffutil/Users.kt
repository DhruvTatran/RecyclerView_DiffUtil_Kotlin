package com.android.rv_diffutil

data class Users(
    var user_id : Int?,
    var first_name : String?,
    var last_name : String?,
    var gender : String?


) {
    override fun equals(other: Any?): Boolean {
        if(javaClass != other?.javaClass) return false

        other as Users

        if(user_id != other.user_id) return false
        if(first_name != other.first_name) return false
        if(last_name != other.last_name) return false
        if(gender != other.gender) return false

        return true

    }
}