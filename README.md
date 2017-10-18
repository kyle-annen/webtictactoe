
# Web Tic Tac Toe  
[![Build Status](https://travis-ci.org/kyle-annen/webtictactoe.svg?branch=master)](https://travis-ci.org/kyle-annen/webtictactoe)
[![Coverage Status](https://coveralls.io/repos/github/kyle-annen/webtictactoe/badge.svg?branch=codacy)](https://coveralls.io/github/kyle-annen/webtictactoe?branch=codacy)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/42297307cdec4a7b833aa75b96aa40bd)](https://www.codacy.com/app/kyle-annen/webtictactoe?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=kyle-annen/webtictactoe&amp;utm_campaign=Badge_Grade)

Web tic tac toe is a TicTacToe game that is 100% free of Javascript.  It is built upon a HTTP Server built in Java (also by this github account) and using an interface with a Scala TicTacToe library (also by this github account).

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

