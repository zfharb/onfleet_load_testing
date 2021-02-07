import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class GetAtOnceSimulation extends Simulation {

  val httpConf = http.baseUrl("https://reqres.in")
    .header("Accept", "application/json")

  val scn = scenario("get users")
    .exec(http("Get").get("/api/users?page=2").check(status.is(200)))

  setUp(
    scn.inject(atOnceUsers(1002))
  ).assertions(global.responseTime.max.lt(30000)).protocols(httpConf)

}
