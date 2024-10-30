package org.slf4j;

import java.io.Serializable;
import java.util.Iterator;

public interface Marker extends Serializable {
  public static final String ANY_MARKER = "*";
  
  public static final String ANY_NON_NULL_MARKER = "+";
  
  String getName();
  
  void add(Marker paramMarker);
  
  boolean remove(Marker paramMarker);
  
  boolean hasChildren();
  
  boolean hasReferences();
  
  Iterator<Marker> iterator();
  
  boolean contains(Marker paramMarker);
  
  boolean contains(String paramString);
  
  boolean equals(Object paramObject);
  
  int hashCode();
}


/* Location:              C:\Arremate\Arremate.jar!\org\slf4j\Marker.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */