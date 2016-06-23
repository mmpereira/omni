package com.awesome.omni.task

import scalaj.http.Http

class Ping extends Task {
  
  def execute: Unit = {
    
    println("PING")
    
    val response = Http("http://google.com/").asString
    
    println(response.code)
  }

  def report: ExecutionReport = {
    ???
  }

}