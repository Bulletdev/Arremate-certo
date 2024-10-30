package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharBullet;

public class CTTextCharBulletImpl extends XmlComplexContentImpl implements CTTextCharBullet {
  private static final b CHAR$0 = new b("", "char");
  
  public CTTextCharBulletImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getChar() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CHAR$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetChar() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(CHAR$0);
      return xmlString;
    } 
  }
  
  public void setChar(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CHAR$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CHAR$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetChar(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(CHAR$0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(CHAR$0); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTextCharBulletImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */