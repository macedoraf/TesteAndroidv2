package br.com.rafael.main.base

import android.content.Intent
import br.com.rafael.main.extension.isNotNull
import java.io.Serializable

abstract class BaseRouter {

    protected val TAG: String = this.javaClass.simpleName

    protected fun <T: Serializable> passDataToNextScreen(intent: Intent, anyObject:T?, key:String): Intent {
        if(anyObject.isNotNull() && key.isNotNull())
            intent.putExtra(key,anyObject)
        return intent
    }

}
