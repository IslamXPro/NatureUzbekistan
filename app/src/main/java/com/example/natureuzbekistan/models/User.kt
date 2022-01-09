package com.example.natureuzbekistan.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class User : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    var name: String? = null
    var name2: String? = null
    var image: String? = null
    var descr: String? = null
    var link: String? = null
    var isLike: Boolean = false


    constructor()
    constructor(
        name: String?,
        name2: String?,
        image: String?,
        descr: String?,
        link: String?,
        isLike: Boolean
    ) {
        this.name = name
        this.name2 = name2
        this.image = image
        this.descr = descr
        this.link = link
        this.isLike = isLike
    }

    constructor(
        id: Int?,
        name: String?,
        name2: String?,
        image: String?,
        descr: String?,
        link: String?,
        isLike: Boolean
    ) {
        this.id = id
        this.name = name
        this.name2 = name2
        this.image = image
        this.descr = descr
        this.link = link
        this.isLike = isLike
    }

    override fun toString(): String {
        return "User(isLike=$isLike)"
    }


}