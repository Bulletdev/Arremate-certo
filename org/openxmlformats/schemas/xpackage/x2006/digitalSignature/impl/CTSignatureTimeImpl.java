package org.openxmlformats.schemas.xpackage.x2006.digitalSignature.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.STFormat;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.STValue;

public class CTSignatureTimeImpl extends XmlComplexContentImpl implements CTSignatureTime {
  private static final b FORMAT$0 = new b("http://schemas.openxmlformats.org/package/2006/digital-signature", "Format");
  
  private static final b VALUE$2 = new b("http://schemas.openxmlformats.org/package/2006/digital-signature", "Value");
  
  public CTSignatureTimeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getFormat() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FORMAT$0, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STFormat xgetFormat() {
    synchronized (monitor()) {
      check_orphaned();
      STFormat sTFormat = null;
      sTFormat = (STFormat)get_store().find_element_user(FORMAT$0, 0);
      return sTFormat;
    } 
  }
  
  public void setFormat(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FORMAT$0, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(FORMAT$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetFormat(STFormat paramSTFormat) {
    synchronized (monitor()) {
      check_orphaned();
      STFormat sTFormat = null;
      sTFormat = (STFormat)get_store().find_element_user(FORMAT$0, 0);
      if (sTFormat == null)
        sTFormat = (STFormat)get_store().add_element_user(FORMAT$0); 
      sTFormat.set((XmlObject)paramSTFormat);
    } 
  }
  
  public String getValue() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(VALUE$2, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STValue xgetValue() {
    synchronized (monitor()) {
      check_orphaned();
      STValue sTValue = null;
      sTValue = (STValue)get_store().find_element_user(VALUE$2, 0);
      return sTValue;
    } 
  }
  
  public void setValue(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(VALUE$2, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(VALUE$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetValue(STValue paramSTValue) {
    synchronized (monitor()) {
      check_orphaned();
      STValue sTValue = null;
      sTValue = (STValue)get_store().find_element_user(VALUE$2, 0);
      if (sTValue == null)
        sTValue = (STValue)get_store().add_element_user(VALUE$2); 
      sTValue.set((XmlObject)paramSTValue);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\xpackage\x2006\digitalSignature\impl\CTSignatureTimeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */