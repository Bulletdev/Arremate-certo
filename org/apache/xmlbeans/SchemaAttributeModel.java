package org.apache.xmlbeans;

import javax.xml.namespace.b;

public interface SchemaAttributeModel {
  public static final int NONE = 0;
  
  public static final int STRICT = 1;
  
  public static final int LAX = 2;
  
  public static final int SKIP = 3;
  
  SchemaLocalAttribute[] getAttributes();
  
  SchemaLocalAttribute getAttribute(b paramb);
  
  QNameSet getWildcardSet();
  
  int getWildcardProcess();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\SchemaAttributeModel.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */