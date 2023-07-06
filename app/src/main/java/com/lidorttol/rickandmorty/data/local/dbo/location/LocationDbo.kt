package com.lidorttol.rickandmorty.data.local.dbo.location

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.lidorttol.rickandmorty.data.DATABASE_NAME

@Entity(tableName = "location")
data class LocationDbo (
  @PrimaryKey
  @SerializedName("id")
  val locationId: Int,
  val name: String,
  val type: String? = null,
  val dimension: String? = null,
  val created: String? = null
)