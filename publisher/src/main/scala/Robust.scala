import akka.actor._
import akka.util.duration._

object Robust extends App {

  val system = ActorSystem("publisher")

  val target1 = system.actorFor("akka://receiver@localhost:3000/user/test1")

  println("press enter to stop")

  var count = 0
  system.scheduler.schedule(1 second, 1 seconds) {
    count += 1
    target1 ! Map("Hello" -> count, "World" -> "cruel")
  }

  Console.readLine()

  system.shutdown()

}
