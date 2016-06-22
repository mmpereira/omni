package com.awesome.omni.core.actor

import akka.actor.Actor

case class ReportMsg(content: String)

class Reporter extends Actor {
  
  
  def receive: Actor.Receive = {
    case ReportMsg(content) => println(s"reporting $content")
  }
}