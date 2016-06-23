package com.awesome.omni.core.task

import akka.actor.Actor
import com.awesome.omni.task.Task
import com.awesome.omni.core.actor.ReportMsg
import akka.actor.ActorRef
import akka.actor.Props

object TaskExecutor {
  def props(reporter: ActorRef): Props = Props(new TaskExecutor(reporter))
}

case class ExecuteTask(task: Task)

class TaskExecutor(reporter: ActorRef) extends Actor {
  
  def receive: Actor.Receive = {
    case ExecuteTask(task) => {
      task.execute
      reporter ! ReportMsg(task.report)
    }
    
  }
}