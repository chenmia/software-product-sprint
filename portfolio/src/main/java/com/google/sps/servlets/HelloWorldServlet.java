package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;


/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
    String[] quotes = {"You know more than you think you know, just as you know less than you want to know.", 
                        "One day I will find the right words, and they all will be simple.",
                        "I assure you that the world is not so amusing as something we imagined."};

    

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String randomQuote = getRandomQuote(quotes);
    Gson gson = new Gson();

    response.setContentType("application/json;");
    response.getWriter().println(gson.toJson(randomQuote));
  }

  
  /**
   * Returns a random quote from an String array of quotes
   */
  private String getRandomQuote(String[] quotes) {
    int randomIndex = (int)(Math.floor(Math.random() * quotes.length));
    String randomQuote = quotes[randomIndex];
    return randomQuote;
  }

}


