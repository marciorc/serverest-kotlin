package tests.commons

import config.Urls
import data.login.Login
import data.user.AddUser
import io.qameta.allure.restassured.AllureRestAssured
import io.restassured.module.kotlin.extensions.Given
import io.restassured.response.Response

class RequestFactory {

    fun postCreateUserServerest(payload: AddUser?): Response {
        return Given {
            filter(AllureRestAssured())
            baseUri(Urls.BASEURL)
            contentType("application/json")
            body(payload).log().all()
        }
            .post(Urls.USERPATH)
            .thenReturn()
    }

    fun postLoginServerest(payload: Login?): Response {
        return Given {
            filter(AllureRestAssured())
            baseUri(Urls.BASEURL)
            contentType("application/json")
            body(payload).log().all()
        }
            .post(Urls.LOGINPATH)
            .thenReturn()
    }
}