package org.apache.xmlbeans.impl.jam;

public interface JAnnotatedElement extends JElement {
  JAnnotation[] getAnnotations();
  
  JAnnotation getAnnotation(Class paramClass);
  
  Object getAnnotationProxy(Class paramClass);
  
  JAnnotation getAnnotation(String paramString);
  
  JAnnotationValue getAnnotationValue(String paramString);
  
  JComment getComment();
  
  JAnnotation[] getAllJavadocTags();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\JAnnotatedElement.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */