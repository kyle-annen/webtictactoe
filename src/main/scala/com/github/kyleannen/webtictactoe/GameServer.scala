package com.github.kyleannen.webtictactoe

import org.clojars.kyleannen.javaserver.{ConfigureServer, Router}

object GameServer {
  def start(): Unit = {
    val router = new Router()
    router.addRoute("GET", "/", new ControllerTicTacToe)
    router.disableDirectoryRouting()
    router.disableFileRouting()
    val args: Array[String] = Array("-p", "3333")
    val gameServer = new ConfigureServer().configure(args, router)
    gameServer.run()
  }

  def main(args: Array[String]): Unit = {
    start()
  }
}
