package com.github.helloiampau.biblio;

import com.github.helloiampau.biblio.exception.FieldValidationException;
import com.github.helloiampau.biblio.model.Book;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * biblio
 * Created by Pasquale Boemio <boemianrapsodi@gmail.com>
 * <p/>
 * 13 October 2014.
 */
public class BookResource extends Controller {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    try {
      Book theBook = Book.validate(Book.class, request.getParameter("id"));
      if(theBook == null)
        throw new FieldValidationException();

      PrintWriter writer = response.getWriter();
      writer.println(theBook.toJson());
    } catch (FieldValidationException e) {
      e.printStackTrace();
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    try {
      String json = this.readBody(request.getReader());
      Book newBook = Book.fromJson(Book.class, json);
      System.out.println(newBook.toJson());
      newBook.save();

      PrintWriter writer = response.getWriter();
      writer.println(newBook.toJson());
    } catch(FieldValidationException e) {
      e.printStackTrace();
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
  }

  @Override
  public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
    try {
      String json = this.readBody(request.getReader());
      Book newBook = Book.fromJson(Book.class, json);
      newBook.update();

      PrintWriter writer = response.getWriter();
      writer.println(newBook.toJson());
    } catch(FieldValidationException e) {
      e.printStackTrace();
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
  }

  @Override
  public void doDelete(HttpServletRequest request, HttpServletResponse response) {
    try {
      Book theBook = Book.validate(Book.class, request.getParameter("id"));
      theBook.delete();
    } catch (FieldValidationException e) {
      e.printStackTrace();
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
  }



}
