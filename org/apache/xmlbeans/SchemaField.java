package org.apache.xmlbeans;

import java.math.BigInteger;
import javax.xml.namespace.b;

public interface SchemaField {
  b getName();
  
  boolean isAttribute();
  
  boolean isNillable();
  
  SchemaType getType();
  
  BigInteger getMinOccurs();
  
  BigInteger getMaxOccurs();
  
  String getDefaultText();
  
  XmlAnySimpleType getDefaultValue();
  
  boolean isDefault();
  
  boolean isFixed();
  
  Object getUserData();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\SchemaField.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */