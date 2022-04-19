package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.libs.json.Json
import play.api.test._
import play.api.test.Helpers._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 *
 * For more information, see https://www.playframework.com/documentation/latest/ScalaTestingWithScalaTest
 */
class HelloControllerSpec extends PlaySpec with GuiceOneAppPerTest {
  "HelloController GET" must {
    "/helloにGETメソッドでアクセス" in {
      val request = FakeRequest(GET, "/hello")
      val response = route(app, request).get

      status(response) mustBe OK
    }
  }

  "HelloController POST" must {
    "/helloにPOSTメソッドでアクセスするとJsonが返却される" in {
      val request = FakeRequest(POST, "/hello")
      val response = route(app, request).get

      status(response) mustBe OK
      contentType(response) mustBe Some("application/json")
      contentAsJson(response) mustBe Json.obj(
        "hello" -> "world",
        "language" -> "scala",
      )
    }
  }
}