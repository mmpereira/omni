package com.awesome.omni.core.actor

import akka.actor.Actor
import com.awesome.omni.task.ExecutionReport

case class ReportMsg(report: ExecutionReport)

class Reporter extends Actor {
  
  
  def receive: Actor.Receive = {
    case ReportMsg(report) => {
      val content = report.content
      println(s"reporting $content")
    }
  }
}