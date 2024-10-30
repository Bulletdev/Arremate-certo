package org.apache.xmlbeans.impl.jam.mutable;

import org.apache.xmlbeans.impl.jam.JAnnotatedElement;

public interface MAnnotatedElement extends JAnnotatedElement, MElement {
  MAnnotation findOrCreateAnnotation(String paramString);
  
  MAnnotation[] getMutableAnnotations();
  
  MAnnotation getMutableAnnotation(String paramString);
  
  MAnnotation addLiteralAnnotation(String paramString);
  
  MComment getMutableComment();
  
  MComment createComment();
  
  void removeComment();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\mutable\MAnnotatedElement.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */