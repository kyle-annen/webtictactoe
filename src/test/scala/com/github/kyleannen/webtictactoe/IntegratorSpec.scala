package com.github.kyleannen.webtictactoe

import org.scalatest.FunSpec
import org.clojars.kyleannen.tictactoe.Board

class IntegratorSpec extends FunSpec{

  describe("submitRound") {
    it("returns an empty board if the params is empty") {
      val testParam = ""
      val result = Integrator.submitRound(testParam)
      assert(result.contains("board=1,2,3,4,5,6,7,8,9"))
    }

    it("returns a board with the human move and a computer move is params are valid") {
      val testParam = "board=1,2,3,4,5,6,7,8,9&move=1"
      val result = Integrator.submitRound(testParam)
      assert(result.contains("X"))
      assert(result.contains("O"))
    }
    it("offers to restart the game is over") {
      val testParam = "board=X,X,3,O,O,6,7,8,9&move=3"
      val result = Integrator.submitRound(testParam)
      assert(result.contains("Restart Game"))
    }
  }

  describe("validateParamValue") {
    it("returns error if the key is not in paramMap") {
      val testParamMap = Integrator.parseInput("board=test&move=3")
      assert(Integrator.validateParamValue("test", testParamMap) == "Error")
    }

    it("returns the parameter value if the key is in the paramMap") {
      val testParamMap = Integrator.parseInput("board=test&this=that")
      assert(Integrator.validateParamValue("board", testParamMap) =="test")
    }
  }

  describe("parseInput") {
    it("returns a map of the url parameters supplied") {
      val testUrlParams = "board=1,2,3,4,5,6,7,8,9&move=1&lang=EN"
      val paramMap = Integrator.parseInput(testUrlParams)
      assert(paramMap.contains("board"))
      assert(paramMap.contains("move"))
      assert(paramMap.contains("lang"))
      assert(paramMap("board") == "1,2,3,4,5,6,7,8,9")
      assert(paramMap("move") == "1")
      assert(paramMap("lang") == "EN")
    }
  }

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
