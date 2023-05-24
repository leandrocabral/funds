package br.com.leandroid.funds.presentation.funds

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.leandroid.core.Resource
import br.com.leandroid.domain.model.FundsDomain
import br.com.leandroid.domain.usecase.IFundsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class FundsViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var fundsUseCase: IFundsUseCase

    private lateinit var viewModel: FundsViewModel
    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        MockitoAnnotations.initMocks(this)
        viewModel = FundsViewModel(fundsUseCase)
    }

    @After
    fun cleanup() {
        Dispatchers.resetMain()
        testScope.cleanupTestCoroutines()
    }

    @Test
    fun `getFunds should return success`() = testScope.runBlockingTest {
        // Arrange
        val fundsList = listOf(
            FundsDomain(
                fullName = "Fundo Completo1",
                name = "Fundo1",
                description = "description",
                quotationDays = "quotationDays",
                minimumApplication = "minimumApplication",
                strategy = "strategy",
                type = "type1"
            ),
            FundsDomain(
                fullName = "Fundo Completo2",
                name = "Fundo2",
                description = "description",
                quotationDays = "quotationDays",
                minimumApplication = "minimumApplication",
                strategy = "strategy",
                type = "type1"
            )
        )
        Mockito.`when`(fundsUseCase.getFunds()).thenReturn(fundsList)

        val observer = Mockito.mock(Observer::class.java) as Observer<Resource<List<FundsDomain>>>
        viewModel.fundsList.observeForever(observer)

        // Act
        viewModel.getFunds()

        // Assert
        Mockito.verify(observer).onChanged(Resource.loading(true))
        Mockito.verify(observer).onChanged(Resource.success(fundsList))
        Mockito.verify(observer).onChanged(Resource.loading(false))
        Mockito.verifyNoMoreInteractions(observer)
    }
}