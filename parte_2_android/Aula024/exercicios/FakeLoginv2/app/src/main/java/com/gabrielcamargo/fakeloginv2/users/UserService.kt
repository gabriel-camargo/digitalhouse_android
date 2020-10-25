package com.gabrielcamargo.fakeloginv2.users

import java.lang.Exception

class UserService {
    companion object {

        private val users = arrayListOf<UserModel>()

        /**
         * Realiza login
         */
        fun logIn(username: String, password: String): UserModel? {
            return users.find {
                it.username == username.toLowerCase().trim() && it.password == password
            }
        }

        /**
         * Registra um usuário
         */
        fun register(username: String, password: String, confirmPassword: String) {

            // verifica se um dos campos está vazio
            if(username.isEmpty()) {
                throw Exception("Preencha o campo username!")
            }

            if(password.isEmpty()) {
                throw Exception("Preencha o campo de senha!")
            }

            //verifica se a senha e a confirmação de senha são iguais
            if(password != confirmPassword) {
                throw Exception("As senhas não correspondem!")
            }

            // Verifica se já existe usuário com email cadastrado
            val user = users.find {
                it.username == username.toLowerCase().trim()
            }

            if (user != null) {
                throw Exception("Username já cadastrado!")
            }

            users.add(UserModel(username.toLowerCase().trim(), password))
        }
    }
}