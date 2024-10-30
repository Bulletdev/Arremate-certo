package org.apache.xmlbeans.impl.jam;

public interface JAnnotation extends JElement {
  public static final String SINGLE_VALUE_NAME = "value";
  
  String getSimpleName();
  
  Object getProxy();
  
  JAnnotationValue[] getValues();
  
  JAnnotationValue getValue(String paramString);
  
  Object getAnnotationInstance();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\JAnnotation.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */