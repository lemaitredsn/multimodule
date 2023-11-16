package lemaitre.simplepay.api

import android.content.Context
import com.example.accounts.api.AccountLoader
import ru.lemaitre.common.utils.Dependencies
import ru.lemaitre.common.utils.ResourceManager

interface SimplePayDeps: Dependencies {
    val simpleDepsProvider: SimpleDepsProvider
}

interface SimpleDepsProvider {
    val accountLoader: AccountLoader
    val context: Context
    val resourceManager: ResourceManager
}