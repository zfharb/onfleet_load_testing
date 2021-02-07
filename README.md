-This is a simple load test using gatling and scala.
It has 3 get requests and 1 post request. I have used this website https://reqres.in
which is a dummy APIs site to use for testing purposes.

-Assumption: This will be run on a window machine. therefore,
the gradle commands will start with : gradle
if used with mac, then start the commands with ./gradlew

-To run these tests, execute the following commands:

###this will get the dependencies. <br />
gradle                                         

###this will run the post load simulation. <br />
gradle gatlingRun-PostSimulation      

###this will add a certain amount of concurrent users per second simulation. <br />
gradle gatlingRun-GetRampUpUsersSimulation    

###this will run a certain amount of concurrent users for a specific period of time. <br />
gradle gatlingRun-GetConstantUsersSimulation   

###this will hit the system with a certain amount of concurrent users for one time. <br />
gradle gatlingRun-GetAtOnceSimulation         