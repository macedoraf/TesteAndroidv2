package br.com.rafael.main.ui.login

import br.com.rafael.main.model.User

class LoginModel {

    class LoginViewModel

    class LoginResponse(val user:User)

    class LoginRequest(val login:String, val password:String)


}