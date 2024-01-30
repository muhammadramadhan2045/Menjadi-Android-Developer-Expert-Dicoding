package com.example.premierleagueapp.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "team")
data class TeamEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idTeam")
    var idTeam: String,

    @ColumnInfo(name = "strTeam")
    var strTeam: String,

    @ColumnInfo(name = "strTeamBadge")
    var strTeamBadge: String,

    @ColumnInfo(name = "intFormedYear")
    var intFormedYear: String,

    @ColumnInfo(name = "strStadium")
    var strStadium: String,

    @ColumnInfo(name = "strStadiumThumb")
    var strStadiumThumb: String,

    @ColumnInfo(name = "strStadiumDescription")
    var strStadiumDescription: String,

    @ColumnInfo(name = "strStadiumLocation")
    var strStadiumLocation: String,

    @ColumnInfo(name = "intStadiumCapacity")
    var intStadiumCapacity: String,

    @ColumnInfo(name = "strDescriptionEN")
    var strDescriptionEN: String,

    @ColumnInfo(name = "strLeague")
    var strLeague: String,

    @ColumnInfo(name = "strTeamShort")
    var strTeamShort: String,

    @ColumnInfo(name = "strAlternate")
    var strAlternate: String,

    @ColumnInfo(name = "strKeywords")
    var strKeywords: String,

    @ColumnInfo(name = "strKitColour1")
    var strKitColour1: String,

    @ColumnInfo(name = "strKitColour2")
    var strKitColour2: String,

    @ColumnInfo(name = "strKitColour3")
    var strKitColour3: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false


)

