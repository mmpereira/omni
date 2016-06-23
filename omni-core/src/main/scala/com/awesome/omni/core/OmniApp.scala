package main.scala.com.awesome.omni.core

import com.awesome.omni.core.actor.Master

import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Props
import com.awesome.omni.core.actor.Reporter
import com.awesome.omni.core.actor.TaskScheduler
import com.awesome.omni.core.actor.ScheduleMsg
import com.awesome.omni.core.actor.TaskMsg

object OmniApp extends App {

  val system = ActorSystem("omni")

  val reporter = system.actorOf(Props[Reporter], "reporter")
  val master = system.actorOf(Props(new Master(reporter)), "master")
  val scheduler = system.actorOf(Props(new TaskScheduler(master)), "scheduler")
  
  scheduler ! ScheduleMsg("truc")

  master.tell(TaskMsg("git"), ActorRef.noSender)

}