package org.apache.xmlbeans;

public interface InterfaceExtension {
  String getInterface();
  
  String getStaticHandler();
  
  MethodSignature[] getMethods();
  
  public static interface MethodSignature {
    String getName();
    
    String getReturnType();
    
    String[] getParameterTypes();
    
    String[] getExceptionTypes();
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\InterfaceExtension.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */