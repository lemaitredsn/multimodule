package lemaitre.simplepay.api

import android.content.Context
import com.example.accounts.api.AccountLoader
import ru.lemaitre.common.utils.Dependencies
import ru.lemaitre.common.utils.ResourceManager

interface SimplePayDeps: Dependencies {
    val resourceManager: ResourceManager
    val context: Context
    val _accountLoader: AccountLoader
}