package org.apache.xmlbeans.impl.jam.mutable;

import org.apache.xmlbeans.impl.jam.JElement;
import org.apache.xmlbeans.impl.jam.JamClassLoader;
import org.apache.xmlbeans.impl.jam.visitor.MVisitor;

public interface MElement extends JElement {
  JamClassLoader getClassLoader();
  
  void setSimpleName(String paramString);
  
  MSourcePosition createSourcePosition();
  
  void removeSourcePosition();
  
  MSourcePosition getMutableSourcePosition();
  
  void accept(MVisitor paramMVisitor);
  
  void setArtifact(Object paramObject);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\mutable\MElement.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */