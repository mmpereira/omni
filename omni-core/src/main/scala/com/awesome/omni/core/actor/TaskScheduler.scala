package com.awesome.omni.core.actor

import akka.actor.Actor
import akka.actor.Scheduler
import akka.actor.Scheduler
import java.util.concurrent.TimeUnit
import scala.concurrent.duration._
import akka.actor.ActorRef
import org.quartz.impl.StdSchedulerFactory
import org.quartz.TriggerBuilder
import org.quartz.CronScheduleBuilder
import org.quartz.JobBuilder
import java.util.UUID
import com.awesome.omni.core.task.TaskTrigger
import org.quartz.JobExecutionContext
import java.util.Properties
import com.awesome.omni.core.task.TaskExecutionListener
import org.quartz.TriggerKey
import org.quartz.JobDataMap

case class ScheduleMsg(task: String)
case class UnscheduleMsg(id: String)

class TaskScheduler(val master: ActorRef) extends Actor {
  
  val TRIGGER_PREFFIX = "trigger-"

  val props = new Properties()
  props.put("org.quartz.scheduler.instanceName", "TaskScheduler");
  props.put("org.quartz.threadPool.threadCount", "3");
  
  val factory: StdSchedulerFactory = new StdSchedulerFactory(props)
  val scheduler = factory.getScheduler
  scheduler.getListenerManager.addJobListener(TaskExecutionListener)
  
  
  
  def receive: Actor.Receive = {
    case ScheduleMsg(task) => schedule(task)

    case UnscheduleMsg(id) => unschedule(id)
  }

  def schedule(task: String) = {
    val id = UUID.randomUUID()
    
    val jobDataMap = new JobDataMap
    jobDataMap.put("master", master)
    
    val jobDetailBuilder = JobBuilder.newJob(classOf[TaskTrigger]).withIdentity("job-" + id)
    val jobDetail = jobDetailBuilder.build()
    
    val triggerBuilder = TriggerBuilder.newTrigger().withIdentity(TRIGGER_PREFFIX + id).startNow()
    triggerBuilder.withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(17, 52))
    
    
    val trigger = triggerBuilder.build()
    
    scheduler.scheduleJob(jobDetail, trigger)
    
    scheduler.start()
    
  }
  
  def unschedule(id: String) = {
    scheduler.unscheduleJob(new TriggerKey(TRIGGER_PREFFIX + id))
  }
  
}