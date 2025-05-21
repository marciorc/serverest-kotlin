package tests.login

import com.google.gson.Gson
import data.user.AddUser
import io.qameta.allure.Description
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import io.restassured.module.kotlin.extensions.Then
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import tests.commons.RequestFactory
import java.io.File

class AddUserTest {
    val pathProject = System.getProperty("user.dir")

    val payloadAddUser = File("${pathProject}/src/test/resources/payloads/addUser.json").readText(Charsets.UTF_8)

    var addUserBody: AddUser? = null

    @BeforeEach
    fun setUp(){
        addUserBody = Gson().fromJson(payloadAddUser, AddUser::class.java)

        addUserBody?.nome = "John Doe"
        addUserBody?.email = "john_doe@qa.com"
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Create new user at Serverest")
    @Description("Send the user and password to Serverest")
    @Severity(SeverityLevel.CRITICAL)
    fun `Login at Serverest`() {
        RequestFactory().postCreateUserServerest(addUserBody)
            .Then {
                statusCode(201)
            }
    }
}