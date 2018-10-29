package br.com.rafael.main.ui.login

import br.com.rafael.main.model.ErrorService
import br.com.rafael.main.model.User
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class LoginModel {

    class LoginViewModel(val name:String, val bankAccount:String, val agency:String, val balance:Float, val id:Long):Serializable

    class LoginResponse(@SerializedName(value = "userAccount")val user:User, @SerializedName(value = "error")val error:ErrorService)
    {
        fun toLoginViewModel():LoginViewModel = LoginViewModel(user.name,user.bankAccount,user.agency,user.balance,user.id)
    }

    class LoginRequest(val login:String, val password:String)


}