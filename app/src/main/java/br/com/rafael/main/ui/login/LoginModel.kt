package br.com.rafael.main.ui.login

import br.com.rafael.main.model.User
import com.google.gson.annotations.SerializedName

class LoginModel {

    class LoginViewModel

    class LoginResponse(@SerializedName(value = "userAccount")val user:User, error:String)

    class LoginRequest(val login:String, val password:String)


}