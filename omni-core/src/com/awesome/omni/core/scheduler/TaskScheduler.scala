package com.awesome.omni.core.scheduler

import akka.actor.Actor

case class ScheduleMsg(task: String)

class TaskScheduler extends Actor {
  
  
  def receive: Actor.Receive = {
    case ScheduleMsg(task) => println(s"scheduling task: $task")
  }
}