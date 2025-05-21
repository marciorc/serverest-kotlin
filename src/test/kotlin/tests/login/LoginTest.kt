package tests.login

import com.google.gson.Gson
import data.login.Login
import io.qameta.allure.Description
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import io.restassured.module.kotlin.extensions.Then
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import tests.commons.RequestFactory
import java.io.File
import kotlin.test.Test

class LoginTest {

    val pathProject = System.getProperty("user.dir")

    val payloadLogin = File("${pathProject}/src/test/resources/payloads/login.json").readText(Charsets.UTF_8)

    var loginBody: Login? = null

    @BeforeEach
    fun setUp(){
        loginBody = Gson().fromJson(payloadLogin, Login::class.java)

        loginBody?.email = "john_doe@qa.com"
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Login at Serverest")
    @Description("Send the user and password to Serverest")
    @Severity(SeverityLevel.CRITICAL)
    fun `Login at Serverest`() {
        RequestFactory().postLoginServerest(loginBody)
            .Then {
                statusCode(201)

            }
    }
}