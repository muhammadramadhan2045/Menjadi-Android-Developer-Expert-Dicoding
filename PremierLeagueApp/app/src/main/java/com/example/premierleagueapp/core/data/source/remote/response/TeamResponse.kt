package com.example.premierleagueapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TeamResponse(
    @field:SerializedName("idTeam")
    val idTeam: String,

    @field:SerializedName("strLeague")
    val strLeague: String,

    @field:SerializedName("strTeam")
    val strTeam: String,

    @field:SerializedName("strTeamShort")
    val strTeamShort: String,

    @field:SerializedName("strAlternate")
    val strAlternate: String,

    @field:SerializedName("strKeywords")
    val strKeywords: String,

    @field:SerializedName("strStadium")
    val strStadium: String,

    @field:SerializedName("strStadiumLocation")
    val strStadiumLocation: String,

    @field:SerializedName("strStadiumThumb")
    val strStadiumThumb: String,

    @field:SerializedName("strStadiumDescription")
    val strStadiumDescription: String,

    @field:SerializedName("intStadiumCapacity")
    val intStadiumCapacity: String,

    @field:SerializedName("strDescriptionEN")
    val strDescriptionEN: String,


    @field:SerializedName("strTeamBadge")
    val strTeamBadge: String,

    @field:SerializedName("intFormedYear")
    val intFormedYear: String,


    @field:SerializedName("strKitColour1")
    val strKitColour1: String,

    @field:SerializedName("strKitColour2")
    val strKitColour2: String,

    @field:SerializedName("strKitColour3")
    val strKitColour3: String,

    )
