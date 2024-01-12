import com.dicoding.mysimplelogin.UserRepository
import com.dicoding.mysimplelogin.storageModule
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.koin.core.context.loadKoinModules
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class MainActivityTest :KoinTest{
    private val userRepository: UserRepository by inject()
    private val username ="rama"

    @Before
    fun before(){
        loadKoinModules(storageModule)
        userRepository.loginUser(username)
    }

    @After
    fun after(){
        stopKoin()
    }

    @Test
    fun getUserNameFromRepository(){
        val requestedUserName= userRepository.getUser()
        assertEquals(username,requestedUserName)
    }
}