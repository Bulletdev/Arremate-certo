package org.apache.xmlbeans.impl.jam;

public interface JamService {
  JamClassLoader getClassLoader();
  
  String[] getClassNames();
  
  JamClassIterator getClasses();
  
  JClass[] getAllClasses();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\JamService.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */