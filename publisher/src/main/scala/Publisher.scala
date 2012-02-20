import akka.actor._
import akka.routing.{FromConfig, BroadcastRouter}
import akka.util.duration._

class ListenerActor extends Actor {
  protected def receive = {
    case s => println("local received " + s)
  }
}

class DummyActor extends Actor {
  protected def receive = {
    case s => println("dummy receieved " + s)
  }
}

object Publisher extends App {
  val system = ActorSystem("publisher")

  val bcActor = system.actorOf(Props.empty.withRouter(FromConfig()), name = "broadcast")

  var count = 0

  println("press enter to stop")

  system.scheduler.schedule(1 second, 1 seconds) {
    count += 1
    bcActor ! Map("Hello" -> count, "World" -> "cruel")
  }
  
  Console.readLine()

  system.shutdown()

}
