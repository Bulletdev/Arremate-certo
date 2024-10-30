package org.apache.xmlbeans.impl.jam.internal.classrefs;

import org.apache.xmlbeans.impl.jam.JamClassLoader;

public interface JClassRefContext {
  String getPackageName();
  
  String[] getImportSpecs();
  
  JamClassLoader getClassLoader();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\classrefs\JClassRefContext.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */