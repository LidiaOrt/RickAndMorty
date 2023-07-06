package com.lidorttol.rickandmorty.data.local.dbo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "origin")
data class OriginDbo (
  @PrimaryKey
  @SerializedName("name")
  val name: String,
  val url: String? = null
)