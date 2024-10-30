package org.openxmlformats.schemas.officeDocument.x2006.customProperties.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.PropertiesDocument;

public class PropertiesDocumentImpl extends XmlComplexContentImpl implements PropertiesDocument {
  private static final b PROPERTIES$0 = new b("http://schemas.openxmlformats.org/officeDocument/2006/custom-properties", "Properties");
  
  public PropertiesDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTProperties getProperties() {
    synchronized (monitor()) {
      check_orphaned();
      CTProperties cTProperties = null;
      cTProperties = (CTProperties)get_store().find_element_user(PROPERTIES$0, 0);
      if (cTProperties == null)
        return null; 
      return cTProperties;
    } 
  }
  
  public void setProperties(CTProperties paramCTProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTProperties cTProperties = null;
      cTProperties = (CTProperties)get_store().find_element_user(PROPERTIES$0, 0);
      if (cTProperties == null)
        cTProperties = (CTProperties)get_store().add_element_user(PROPERTIES$0); 
      cTProperties.set((XmlObject)paramCTProperties);
    } 
  }
  
  public CTProperties addNewProperties() {
    synchronized (monitor()) {
      check_orphaned();
      CTProperties cTProperties = null;
      cTProperties = (CTProperties)get_store().add_element_user(PROPERTIES$0);
      return cTProperties;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\officeDocument\x2006\customProperties\impl\PropertiesDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */