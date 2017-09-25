package com.github.kyleannen.webtictactoe
import com.github.kyleannen.tictactoe.{GameState, TicTacToeAPI}

object Integrator {

  def submitRound(params: String): String = {
    val paramMap: Map[String, String] = parseInput(params)
    val boardString = validateParamValue("board", paramMap)
    val board = boardString.split(',').toList
    val humanMove = validateParamValue("move", paramMap)
    val updatedGameState =
      if (boardString == "Error" || humanMove == "Error" ) {
        TicTacToeAPI.startGame()
      } else {
        TicTacToeAPI.playRound(generateGameState(board, humanMove))
      }
    val messages = if(updatedGameState.gameOver == true) {
      "<a href='/tictactoe'>Restart Game</a>" :: updatedGameState.messages
    } else {
      updatedGameState.messages
    }
    formatHTML(updatedGameState.board, messages)
  }

  def validateParamValue(parameter: String, paramMap: Map[String, String]): String = {
    if(paramMap.keySet.contains(parameter)) paramMap(parameter) else "Error"
  }

  def parseInput(params: String): Map[String, String] = {
    val paramArray: Array[String] = params.split('&')
    val paramMap: Map[String, String] =
      paramArray
        .map( paramKeyValue => paramKeyValue.split('='))
        .toList
        .flatten
        .grouped(2)
        .collect {
          case List(key, value) => key -> value
        }.toMap
    paramMap
  }

  def generateGameState(board: List[String], humanMove: String): GameState = {
    val validSubmission =
      humanMove.toInt > 0 &&
        humanMove.toInt < 10 &&
        board.length == 9
    new GameState(
      board = board,
      gameOver = false,
      messages = List(),
      humanMove = humanMove.toInt,
      computerMove = -1,
      humanToken = "X",
      computerToken = "O",
      gameOutcome = "none",
      gameWinner = "none",
      validSubmission = validSubmission,
      language = "EN")
  }

  def formatHTML(board: List[String], messages: List[String]): String = {
    val headerHtml = "<!DOCTYPE html>\n<html>\n<head>\n<link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n<meta charset=\"UTF-8\">\n<title>Title of the document</title>\n</head>\n\n<body><div class='row'><div class='container'>"
    val footerHtml = "</div></div></body>\n\n</html>"
    val boardString = board.mkString(",")
    val boardHtml = board.map(
      cell => "<div class='col-md-4' style='font-size: 130px; border: 10px solid black; text-align: center;'>" +
        (if(cell == "X" || cell =="O") {
          cell
        } else {
          "<a href=/tictactoe?board=" + boardString + "&move=" + cell + ">" +
            cell +
            "</a>"
        }) +  "</div>")
      .mkString("")
    val messagesHtml = messages.map( message => "<h1 style='text-align: center'>" + message + "</h1>" ).mkString("")
    headerHtml + boardHtml + "<br/><br/>" + messagesHtml + footerHtml
  }


}


