import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class PostSimulation extends Simulation {

  val httpConf = http.baseUrl("https://reqres.in")

  val scn = scenario("create a user")
    .exec(http("create a user")
      .post("/api/users")
      .body(StringBody("""{"email": "eve.holt@reqres.in","password": "pistol"}""")).asJson
      .check(status.is(201)))

  setUp(
    scn.inject(atOnceUsers(100))
  ).assertions(global.responseTime.max.lt(30000))
    .protocols(httpConf)

}
