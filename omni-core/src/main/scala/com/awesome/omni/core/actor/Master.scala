package com.awesome.omni.core.actor

import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.actorRef2Scala
import com.awesome.omni.task.Task
import com.awesome.omni.core.task.TaskFactory
import com.awesome.omni.core.task.TaskExecutor
import com.awesome.omni.core.task.TaskExecutor
import com.awesome.omni.core.task.TaskExecutor
import akka.actor.Props
import com.awesome.omni.core.task.ExecuteTask

case class TaskMsg(name: String)


class Master(val reporter: ActorRef) extends Actor {
  
  type T <: Task
  
  val factory = TaskFactory;
  
  
  def receive: Actor.Receive = {
    case TaskMsg(name) => {
      val t:Task = TaskFactory(name)
      
      val executor = context.actorOf(TaskExecutor.props(reporter), "task")
      
      executor ! ExecuteTask(t)
    }
  }
  
  def shutdown = context.system.terminate()
  
}