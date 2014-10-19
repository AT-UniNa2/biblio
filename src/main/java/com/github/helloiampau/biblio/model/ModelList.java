package com.github.helloiampau.biblio.model;

import java.util.List;

/**
 * biblio
 * Created by Pasquale Boemio <boemianrapsodi@gmail.com>
 * <p/>
 * 19 October 2014.
 */
public class ModelList<Child extends Model> extends JsonArray<Child> {

  public ModelList(List<Child> list) {
    super(list);
  }

}
