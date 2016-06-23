package com.awesome.omni.core.task

import com.awesome.omni.task.Ping
import com.awesome.omni.task.Task

object TaskFactory {
  
  def apply(s: String): Task = {
    new Ping
  }
}