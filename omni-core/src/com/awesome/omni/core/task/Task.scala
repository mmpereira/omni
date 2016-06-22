package com.awesome.omni.core.task

import akka.actor.ActorRef

trait Task {

  def run
  
  def report: String
}

object Task {
  
  def apply(s: String): Task = {
    if(s == "hello") new HelloWorld(s, null)
    else new Ping
  }
}