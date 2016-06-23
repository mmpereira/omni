package com.awesome.omni.core.task

import org.quartz.Job
import org.quartz.JobExecutionContext
import akka.actor.ActorRef
import com.awesome.omni.core.actor.TaskMsg

class TaskTrigger extends Job {

  override def execute(context: JobExecutionContext): Unit = {
    
    val map = context.getJobDetail.getJobDataMap
    
    val task = Option(map.get("task"))
    val master = Option(map.get("master"))
    
    println(s"here: $task")
    
    
    (master, task) match {
      case (Some(m: ActorRef), Some(t: String)) => m ! TaskMsg(t)
      case (_, _) => println("pouet") 
    }
  }
}