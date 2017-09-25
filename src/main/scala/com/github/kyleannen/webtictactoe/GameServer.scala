package com.github.kyleannen.webtictactoe

import com.github.kyleannen.javaserver.{ConfigureServer, Router}

object GameServer {
  def start(): Unit = {
    val router = new Router()
    router.addRoute("GET", "/tictactoe", new ControllerTicTacToe)
    val args: Array[String] = Array("-p", "3333")
    val gameServer = new ConfigureServer().configure(args, router)
    gameServer.run()
  }

  def main(args: Array[String]): Unit = {
    start()
  }
}
