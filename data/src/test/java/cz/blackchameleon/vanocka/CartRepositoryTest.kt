import cz.blackchameleon.data.LocalResult
import cz.blackchameleon.data.local.LocalCartSource
import cz.blackchameleon.data.remote.RemoteCartSource
import cz.blackchameleon.data.repository.CartRepository
import cz.blackchameleon.domain.CartItem
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

/**
 * @author Karolina Klepackova on 26.11.2020.
 */

@RunWith(MockitoJUnitRunner::class)
class CartRepositoryTest {
    @Mock
    lateinit var localCartSource: LocalCartSource

    @Mock
    lateinit var remoteCartSource: RemoteCartSource

    lateinit var cartRepository: CartRepository

    val firstCartItem = CartItem(
        id = "firstItem",
        name = "Rohlik",
        title = "Brambory Brambory Brambory Brambory Brambory",
        image = "https://www.rohlik.cz/cdn-cgi/image/f=auto,w=300,h=300/https://cdn.rohlik.cz/images/grocery/products/1326173/1326173-1528784439.jpg",
        amount = 15f,
        price = 21.3f,
        unit = "ks"
    )

    val secondCartItem = CartItem(
        id = "secondItem",
        name = "Brambory",
        title = "Rohlik Rohlik Rohlik Rohlik Rohlik Rohlik",
        image = "https://www.rohlik.cz/cdn-cgi/image/f=auto,w=300,h=300/https://cdn.rohlik.cz/images/grocery/products/1326173/1326173-1528784439.jpg",
        amount = 15f,
        price = 21.3f,
        unit = "ks"
    )

    @Before
    fun setup() {
        cartRepository = CartRepository(localCartSource, remoteCartSource)
    }

    @Test
    fun `pass when local source is cleaned`() {
        runBlocking {
            cartRepository.clean()
            verify(localCartSource, times(1)).clean()
        }
    }

    @Test
    fun `pass when cart item is saved`() {
        runBlocking {
            cartRepository.saveCartItem(firstCartItem)
            verify(localCartSource, times(1)).saveCartItem(firstCartItem)
        }
    }

    @Test
    fun `pass when cart items are saved`() {
        runBlocking {
            cartRepository.saveCartItem(firstCartItem)
            verify(localCartSource, times(1)).saveCartItem(firstCartItem)
        }
    }

    @Test
    fun `pass when cart items are loaded from database`() {
        runBlocking {
            `when`(localCartSource.getCartItems()).thenReturn(listOf(firstCartItem, secondCartItem))

            val cartItems = cartRepository.getCartItems()
            assert(
                cartItems is LocalResult.Success && cartItems.data == listOf(
                    firstCartItem,
                    secondCartItem
                )
            )
        }
    }

}