package com.github.kyleannen.webtictactoe;

import org.clojars.kyleannen.javaserver.ResponseParameters;
import org.clojars.kyleannen.javaserver.RequestParameters;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControllerTicTacToeTest {
  @Test
  public void getResponseReturnsNewBoardOnNoParamSubmission() throws IOException {
    ArrayList<String> httpMessage = new ArrayList<>();
    httpMessage.add("GET / HTTP/1.1\r\n\r\n");
    RequestParameters requestParameters =
            new RequestParameters.RequestBuilder("/")
                    .setRequestPath(httpMessage)
                    .setHttpVerb(httpMessage)
                    .setBodyContent(httpMessage)
                    .build();
    ResponseParameters responseParameters = new ControllerTicTacToe().getResponse(requestParameters);
    List<String> openSpaces = Arrays.asList("1","2","3","4","5","6","7","8","9");
    for(String space : openSpaces) {
      assert(responseParameters.getBodyContent().contains(space));
    }
  }

  @Test
  public void getResponseReturnsBoardWithMoveAndComputerMove() throws IOException {
    ArrayList<String> httpMessage = new ArrayList<>();
    httpMessage.add("GET /?board=1,2,3,4,5,6,7,8,9&move=1 HTTP/1.1\r\n\r\n");
    RequestParameters requestParameters =
            new RequestParameters.RequestBuilder("/")
                    .setRequestPath(httpMessage)
                    .setHttpVerb(httpMessage)
                    .setBodyContent(httpMessage)
                    .build();
    ResponseParameters responseParameters = new ControllerTicTacToe().getResponse(requestParameters);
    String responseHTML = responseParameters.getBodyContent();
    assert(responseHTML.contains("X") && responseHTML.contains("O"));
  }

  @Test
  public void getResponseReturnsRestartOptionOnGameOver() throws IOException{
    ArrayList<String> httpMessage = new ArrayList<>();
    httpMessage.add("GET /?board=X,X,3,O,O,6,7,8,9&move=3 HTTP/1.1\r\n\r\n");
    RequestParameters requestParameters =
            new RequestParameters.RequestBuilder("/")
                    .setRequestPath(httpMessage)
                    .setHttpVerb(httpMessage)
                    .setBodyContent(httpMessage)
                    .build();
    ResponseParameters responseParameters = new ControllerTicTacToe().getResponse(requestParameters);
    String responseHTML = responseParameters.getBodyContent();
    assert(responseHTML.contains("Restart Game"));
  }
}