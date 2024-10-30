package org.apache.xmlbeans;

public interface SchemaLocalAttribute extends SchemaAnnotated, SchemaField {
  public static final int PROHIBITED = 1;
  
  public static final int OPTIONAL = 2;
  
  public static final int REQUIRED = 3;
  
  int getUse();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\SchemaLocalAttribute.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */