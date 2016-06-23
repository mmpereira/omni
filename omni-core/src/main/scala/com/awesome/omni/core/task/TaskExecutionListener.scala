package com.awesome.omni.core.task

import org.quartz.JobListener
import org.quartz.JobExecutionContext
import org.quartz.JobExecutionException

object TaskExecutionListener extends JobListener {
  def getName = "Task Execution Listener"

  def jobExecutionVetoed(context: JobExecutionContext): Unit = {
    ???
  }

  def jobToBeExecuted(context: JobExecutionContext): Unit = {
    println(context.getJobDetail.getKey.getName + "to be executed")
  }

  def jobWasExecuted(context: JobExecutionContext, ex: JobExecutionException): Unit = {
    println(context.getJobDetail.getKey.getName + " executed")
  }
}