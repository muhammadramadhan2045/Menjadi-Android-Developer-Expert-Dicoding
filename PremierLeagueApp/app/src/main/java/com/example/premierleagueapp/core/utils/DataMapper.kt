package com.example.premierleagueapp.core.utils

import com.example.premierleagueapp.core.data.source.local.entity.TeamEntity
import com.example.premierleagueapp.core.data.source.remote.response.TeamResponse
import com.example.premierleagueapp.core.domain.model.Team

object DataMapper {
    fun mapResponseToEntities(input : List<TeamResponse>): List<TeamEntity>{
        val teamList = ArrayList<TeamEntity>()
        input.map{
            val team=TeamEntity(
                idTeam = it.idTeam,
                strTeam = it.strTeam,
                strTeamBadge = it.strTeamBadge,
                intFormedYear = it.intFormedYear,
                strStadium = it.strStadium,
                strStadiumThumb = it.strStadiumThumb,
                strStadiumDescription = it.strStadiumDescription,
                strStadiumLocation = it.strStadiumLocation,
                intStadiumCapacity = it.intStadiumCapacity,
                strDescriptionEN = it.strDescriptionEN,
                strLeague = it.strLeague,
                strTeamShort = it.strTeamShort,
                strAlternate = it.strAlternate,
                strKeywords = it.strKeywords,
                strKitColour1 = it.strKitColour1,
                strKitColour2 = it.strKitColour2,
                strKitColour3 = it.strKitColour3,
                isFavorite = false,
            )
            teamList.add(team)
        }
        return teamList
    }

    fun mapEntitiesToDomain(input: List<TeamEntity>):List<Team>{
        return input.map{
            Team(
                idTeam = it.idTeam,
                strTeam = it.strTeam,
                strTeamBadge = it.strTeamBadge,
                intFormedYear = it.intFormedYear,
                strStadium = it.strStadium,
                strStadiumThumb = it.strStadiumThumb,
                strStadiumDescription = it.strStadiumDescription,
                strStadiumLocation = it.strStadiumLocation,
                intStadiumCapacity = it.intStadiumCapacity,
                strDescriptionEN = it.strDescriptionEN,
                strLeague = it.strLeague,
                strTeamShort = it.strTeamShort,
                strAlternate = it.strAlternate,
                strKeywords = it.strKeywords,
                strKitColour1 = it.strKitColour1,
                strKitColour2 = it.strKitColour2,
                strKitColour3 = it.strKitColour3,
                isFavorite = it.isFavorite,
            )
        }
    }

    fun mapDomainToEntity(input :Team)=TeamEntity(
        idTeam = input.idTeam,
        strTeam = input.strTeam,
        strTeamBadge = input.strTeamBadge,
        intFormedYear = input.intFormedYear,
        strStadium = input.strStadium,
        strStadiumThumb = input.strStadiumThumb,
        strStadiumDescription = input.strStadiumDescription,
        strStadiumLocation = input.strStadiumLocation,
        intStadiumCapacity = input.intStadiumCapacity,
        strDescriptionEN = input.strDescriptionEN,
        strLeague = input.strLeague,
        strTeamShort = input.strTeamShort,
        strAlternate = input.strAlternate,
        strKeywords = input.strKeywords,
        strKitColour1 = input.strKitColour1,
        strKitColour2 = input.strKitColour2,
        strKitColour3 = input.strKitColour3,
        isFavorite = input.isFavorite,
    )
}