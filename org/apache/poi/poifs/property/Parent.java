package org.apache.poi.poifs.property;

import java.io.IOException;
import java.util.Iterator;

public interface Parent extends Child {
  Iterator getChildren();
  
  void addChild(Property paramProperty) throws IOException;
  
  void setPreviousChild(Child paramChild);
  
  void setNextChild(Child paramChild);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\property\Parent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */