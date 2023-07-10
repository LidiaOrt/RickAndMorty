package com.lidorttol.rickandmorty.data.local.dbo.location

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "location")
data class LocationDbo (
  @PrimaryKey
  val locationId: Long,
  val name: String,
  val type: String? = null,
  val dimension: String? = null,
  val url: String,
  val created: String? = null
)