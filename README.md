# Web Tic Tac Toe  [![Build Status](https://travis-ci.org/kyle-annen/webtictactoe.svg?branch=master)](https://travis-ci.org/kyle-annen/webtictactoe)

Web tic tac toe is a TicTacToe game that is 100% free of HTML.  It is built upon a HTTP Server built in Java (also by this github account) and using an interface with a Scala TicTacToe library (also by this github account).

The Java Server and Scala TicTacToe are hosted at Clojars.org.

Enjoy!

# Playing the game

The game server is started in the terminal, and played in the internet browser of your choice.

### Requirements

* Scala 2.12
* SBT

### Instructions

Clone this repository.

``` bash
git clone https://github.com/kyle-annen/webtictactoe
```

Change to the cloned directory.

```
cd webtictactoe
```

Run the game.

```
sbt run
```

### Heroku Deploy

```bash
sbt assembly deployHeroku
```

