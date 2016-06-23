package com.awesome.omni.core

import com.awesome.omni.core.actor.Master
import com.awesome.omni.core.actor.Reporter
import com.awesome.omni.core.actor.ScheduleMsg
import com.awesome.omni.core.actor.TaskMsg
import com.awesome.omni.core.actor.TaskScheduler

import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.actorRef2Scala

object OmniApp extends App {

  val system = ActorSystem("omni")

  val reporter = system.actorOf(Props[Reporter], "reporter")
  val master = system.actorOf(Props(new Master(reporter)), "master")
  val scheduler = system.actorOf(Props(new TaskScheduler(master)), "scheduler")
  
  scheduler ! ScheduleMsg("truc", (0, 9))

}