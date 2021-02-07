import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class GetConstantUsersSimulation extends Simulation {

  val httpConf = http.baseUrl("https://reqres.in")
    .header("Accept", "application/json")

  val scn = scenario("get users")
    .exec(http("Get").get("/api/users?page=2").check(status.is(200)))

  setUp(scn.inject(constantUsersPerSec(1000).during(15.seconds)))
    .assertions(global.responseTime.max.lt(100000))
    .protocols(httpConf)

}
