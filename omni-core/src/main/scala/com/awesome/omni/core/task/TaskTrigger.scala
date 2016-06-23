package com.awesome.omni.core.task

import org.quartz.Job
import org.quartz.JobExecutionContext
import akka.actor.ActorRef
import com.awesome.omni.core.actor.TaskMsg

class TaskTrigger extends Job {

  override def execute(context: JobExecutionContext): Unit = {
    
//    (task: String, master: ActorRef)
    val map = context.getJobDetail.getJobDataMap
    
    val task = Option(map.get("task"))
    val master = Option(map.get("master"))
    
    
    println("TaskTrigger execute")
    
    
    if(task.isDefined && master.isDefined)
      master.asInstanceOf[ActorRef] ! TaskMsg(task.asInstanceOf[String])
  }
}