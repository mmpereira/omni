package com.awesome.omni.core.task

import akka.actor.ActorRef
import com.awesome.omni.core.actor.ReportMsg

class HelloWorld(val name: String, val reporter: ActorRef) extends Task {
  
  
  def run: Unit = {
    println(s"hello world $name")
  }

  def report: String = {
    "finished hello world!"
  }
}