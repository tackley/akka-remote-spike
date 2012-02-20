import akka.actor.ActorSystem
import akka.util.duration._

object Publisher extends App {
  val system = ActorSystem("publisher")

  val remoteActor = system.actorFor("akka://receiever@localhost:3000/user/test1")

  var count = 0

  println("press enter to stop")

  system.scheduler.schedule(1 second, 5 seconds) {
    count += 1
    remoteActor ! ("Hello " + count)
  }
  
  Console.readLine()

  system.shutdown()

}
