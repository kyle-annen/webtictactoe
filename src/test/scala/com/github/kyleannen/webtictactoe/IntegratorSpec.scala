package com.github.kyleannen.webtictactoe

import org.scalatest.FunSpec
import org.clojars.kyleannen.tictactoe.{ Board }

class IntegratorSpec extends FunSpec{


  describe()

  describe("generateGameState") {
    it("returns an invalid game submission if the board is not 9 long") {
      val testBoard = Board.initBoard(10)
      val testGameState = Integrator.generateGameState(testBoard, "3")
      assert(testGameState.validSubmission == false)
    }

    it("returns an invalid game submission if the submitted move is out of board size") {
      val testBoard = Board.initBoard(9)
      val testGameState = Integrator.generateGameState(testBoard, "11")
      assert(testGameState.validSubmission == false)
    }
    it("returns a valid game submission if the board and the move are valid") {
      val testBoard = Board.initBoard(9)
      val testGameState = Integrator.generateGameState(testBoard, "1")
      assert(testGameState.validSubmission == true)
    }
  }

  describe("formatHTML") {
    it("formats the board html") {
      val testBoard = Board.initBoard(9)
      val testMessage = "This is a test message."
      val testMessages = List(testMessage)
      val resultHTML= Integrator.formatHTML(testBoard, testMessages)
      val expectedMessage = "<h1 style='text-align: center'>" + testMessage + "</h1>"
      assert(resultHTML.contains(expectedMessage))
      for (space <- testBoard) {
        assert(resultHTML.contains(space))
      }
    }
  }


}
