package com.dicoding.tourismapp.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.tourismapp.core.domain.usecase.TourismUseCase
import com.dicoding.tourismapp.detail.DetailTourismViewModel
import com.dicoding.tourismapp.di.AppScope
import com.dicoding.tourismapp.favorite.FavoriteViewModel
import com.dicoding.tourismapp.home.HomeViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject
import javax.inject.Provider

@AppScope
class ViewModelFactory @Inject constructor(private val creators : Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>)  :
    ViewModelProvider.NewInstanceFactory() {

//    companion object {
//        @Volatile
//        private var instance: ViewModelFactory? = null
//
//        fun getInstance(context: Context): ViewModelFactory =
//            instance
//                ?: synchronized(this) {
//                instance
//                    ?: ViewModelFactory(
//                        Injection.provideTourismUseCase(
//                            context
//                        )
//                    )
//            }
//    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {


        //metode baru dengan dagger
        val creator= creators[modelClass]?: creators.entries.firstOrNull{
            modelClass.isAssignableFrom(it.key)
        }?.value ?:throw IllegalArgumentException("unknown model class $modelClass")
        return creator.get() as T


        //metode lama tanpa dagger
//        when {
////            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
////                HomeViewModel(tourismUseCase) as T
////            }
////            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
////                FavoriteViewModel(tourismUseCase) as T
////            }
////            modelClass.isAssignableFrom(DetailTourismViewModel::class.java) -> {
////                DetailTourismViewModel(tourismUseCase) as T
////            }
////            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
////        }
//
//    }


    }
}