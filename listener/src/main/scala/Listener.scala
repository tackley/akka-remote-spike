import akka.actor.{Props, Actor, ActorSystem}
import akka.util.duration._

class ListenerActor extends Actor {
  protected def receive = {
    case s => println("received " + s)
  }
}

object Listener extends App {
  val system = ActorSystem("receiver")

  val theListener = system.actorOf(Props[ListenerActor], "test1")

  println("press enter to stop")

  Console.readLine()

  system.shutdown()

}
