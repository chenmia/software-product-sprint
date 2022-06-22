package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
    String[] quotes = {"You know more than you think you know, just as you know less than you want to know.", 
                        "One day I will find the right words, and they all will be simple.",
                        "I assure you that the world is not so amusing as something we imagined."};

    String json = convertToJson(quotes);

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

  /**
   * Converts a ServerStats instance into a JSON string using manual String concatentation.
   */
  private String convertToJson(String[] quotes) {
    String json = "{";
    json += "\"quotes\": ";
    json += "[";
    for(int i = 0; i < quotes.length; i++) {
        json += "\"" + quotes[i] + "\"";
        if(i != quotes.length - 1) {json += ", ";}
    }
    json += "]";
    json += "}";
    return json;
  }
}
