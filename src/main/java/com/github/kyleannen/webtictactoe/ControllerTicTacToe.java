package com.github.kyleannen.webtictactoe;

import org.clojars.kyleannen.javaserver.ControllerInterface;
import org.clojars.kyleannen.javaserver.RequestParameters;
import org.clojars.kyleannen.javaserver.ResponseParameters;

import java.io.IOException;

public class ControllerTicTacToe implements ControllerInterface {
  @Override
  public ResponseParameters getResponse(RequestParameters requestParameters) throws IOException {
    String gameResponse = Integrator.submitRound(requestParameters.params);

    return new ResponseParameters.ResponseBuilder(200)
            .setBodyContent(gameResponse)
            .setBodyType(gameResponse)
            .setContentDisposition("tictactoe.html")
            .setContentLength(gameResponse)
            .setContentType(gameResponse)
            .setDate()
            .build();
  }
}
