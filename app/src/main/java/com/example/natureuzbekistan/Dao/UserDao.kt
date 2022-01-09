package com.example.passregistr.Dao

import androidx.room.*
import com.example.natureuzbekistan.models.User

@Dao
interface UserDao {
    @Query("select * from user")
    fun getAllUser(): List<User>

    @Query("select * from user")
    fun getAllUserLike(): List<User>

    @Insert
    fun addUser(user: User)

    @Insert
    fun addUserLike(user: User)

    @Delete
    fun deleteUser(user: User)

    @Delete
    fun deleteUserLike(user: User)

    @Update
    fun updateUser(user: User)

    @Query("select * from user where id=:id")
    fun getUserById(id: Int): User

    @Query("select * from user where isLike=:like")
    fun getUserByIdLike(like: Boolean): User

}
