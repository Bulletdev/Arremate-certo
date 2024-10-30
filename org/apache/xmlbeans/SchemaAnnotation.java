package org.apache.xmlbeans;

import javax.xml.namespace.b;

public interface SchemaAnnotation extends SchemaComponent {
  XmlObject[] getApplicationInformation();
  
  XmlObject[] getUserInformation();
  
  Attribute[] getAttributes();
  
  public static interface Attribute {
    b getName();
    
    String getValue();
    
    String getValueUri();
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\SchemaAnnotation.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */