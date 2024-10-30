package org.apache.xmlbeans;

public interface PrePostExtension {
  public static final int OPERATION_SET = 1;
  
  public static final int OPERATION_INSERT = 2;
  
  public static final int OPERATION_REMOVE = 3;
  
  String getStaticHandler();
  
  boolean hasPreCall();
  
  boolean hasPostCall();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\PrePostExtension.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */