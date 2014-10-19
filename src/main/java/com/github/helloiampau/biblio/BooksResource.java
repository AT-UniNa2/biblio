package com.github.helloiampau.biblio;

import com.github.helloiampau.biblio.exception.FieldValidationException;
import com.github.helloiampau.biblio.model.Book;
import com.github.helloiampau.biblio.model.ModelList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


/**
 * biblio
 * Created by Pasquale Boemio <boemianrapsodi@gmail.com>
 * <p/>
 * 16 October 2014.
 */
public class BooksResource extends Controller {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    ModelList books;
    Map parameters = request.getParameterMap();
    try {
      if (parameters.size() == 0)
        books = Book.all(Book.class);
      else {
        ArrayList<String> keys = new ArrayList<String>();
        ArrayList<Object> values = new ArrayList<Object>();
        Enumeration<String> keysEnum = request.getParameterNames();

        while (keysEnum.hasMoreElements()) {
          String key = keysEnum.nextElement();
          keys.add(key);
          values.add(this.getValue(Book.class, key, request));
        }

        books = Book.where(Book.class, keys, values, null, null);
      }

      PrintWriter writer = response.getWriter();
      writer.println(books.toJson());
    } catch (FieldValidationException e) {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
  }

}
