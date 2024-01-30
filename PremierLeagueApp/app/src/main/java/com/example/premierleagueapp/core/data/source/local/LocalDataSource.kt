package com.example.premierleagueapp.core.data.source.local

import androidx.lifecycle.LiveData
import com.example.premierleagueapp.core.data.source.local.entity.TeamEntity
import com.example.premierleagueapp.core.data.source.local.room.TeamDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource private constructor(private val teamDao: TeamDao){

    companion object{
        private var instance: LocalDataSource? = null

        fun getInstance(teamDao: TeamDao): LocalDataSource =
            instance ?: synchronized(this){
                instance ?: LocalDataSource(teamDao)
            }
    }


    fun getAllTeam(): Flow<List<TeamEntity>> =teamDao.getAllTeam()

    fun getFavoriteTeam(): Flow<List<TeamEntity>> =teamDao.getFavoriteTeam()

    suspend fun insertTeam(teamList: List<TeamEntity>) = teamDao.insertTeam(teamList)

    fun setFavoriteTeam(team: TeamEntity, newState: Boolean){
        team.isFavorite = newState
        teamDao.updateFavoriteTeam(team)
    }
}