package com.awesome.omni.core.actor

import akka.actor.Actor
import com.awesome.omni.core.task.HelloWorld
import akka.actor.ActorRef
import com.awesome.omni.core.task.Task

case class TaskMsg(name: String)

class Master(val reporter: ActorRef) extends Actor {
  
  type T <: Task
  
  val factory = Task;
  
  
  def receive: Actor.Receive = {
    case TaskMsg(name) => {
      val t:Task = Task(name)
      t.run
      reporter ! ReportMsg(t.report)
    }
  }
  
  def shutdown = context.system.terminate()
  
}