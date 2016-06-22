package com.awesome.omni.core

import com.awesome.omni.core.actor.Master

import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Props
import com.awesome.omni.core.actor.Reporter
import com.awesome.omni.core.actor.TaskMsg
import com.awesome.omni.core.scheduler.TaskScheduler
import com.awesome.omni.core.scheduler.ScheduleMsg

object OmniApp extends App {
  
  
  val system = ActorSystem("omni")
  
  val scheduler = system.actorOf(Props[TaskScheduler], "scheduler")
  val reporter = system.actorOf(Props[Reporter], "reporter")
  val master = system.actorOf(Props(new Master(reporter)), "master")
  
  
  scheduler ! ScheduleMsg("truc")
  
  master.tell(TaskMsg("git"), ActorRef.noSender)
  
}