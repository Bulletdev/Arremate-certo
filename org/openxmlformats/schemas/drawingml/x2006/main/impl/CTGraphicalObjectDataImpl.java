package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;

public class CTGraphicalObjectDataImpl extends XmlComplexContentImpl implements CTGraphicalObjectData {
  private static final b URI$0 = new b("", "uri");
  
  public CTGraphicalObjectDataImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getUri() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(URI$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlToken xgetUri() {
    synchronized (monitor()) {
      check_orphaned();
      XmlToken xmlToken = null;
      xmlToken = (XmlToken)get_store().find_attribute_user(URI$0);
      return xmlToken;
    } 
  }
  
  public boolean isSetUri() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(URI$0) != null);
    } 
  }
  
  public void setUri(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(URI$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(URI$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetUri(XmlToken paramXmlToken) {
    synchronized (monitor()) {
      check_orphaned();
      XmlToken xmlToken = null;
      xmlToken = (XmlToken)get_store().find_attribute_user(URI$0);
      if (xmlToken == null)
        xmlToken = (XmlToken)get_store().add_attribute_user(URI$0); 
      xmlToken.set((XmlObject)paramXmlToken);
    } 
  }
  
  public void unsetUri() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(URI$0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTGraphicalObjectDataImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */