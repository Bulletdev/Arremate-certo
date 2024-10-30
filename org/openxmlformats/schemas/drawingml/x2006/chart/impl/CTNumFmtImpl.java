package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt;
import org.openxmlformats.schemas.drawingml.x2006.chart.STXstring;

public class CTNumFmtImpl extends XmlComplexContentImpl implements CTNumFmt {
  private static final b FORMATCODE$0 = new b("", "formatCode");
  
  private static final b SOURCELINKED$2 = new b("", "sourceLinked");
  
  public CTNumFmtImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getFormatCode() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORMATCODE$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetFormatCode() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(FORMATCODE$0);
      return sTXstring;
    } 
  }
  
  public void setFormatCode(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORMATCODE$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FORMATCODE$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetFormatCode(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(FORMATCODE$0);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(FORMATCODE$0); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public boolean getSourceLinked() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SOURCELINKED$2);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetSourceLinked() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SOURCELINKED$2);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetSourceLinked() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SOURCELINKED$2) != null);
    } 
  }
  
  public void setSourceLinked(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SOURCELINKED$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SOURCELINKED$2); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetSourceLinked(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SOURCELINKED$2);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SOURCELINKED$2); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetSourceLinked() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SOURCELINKED$2);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTNumFmtImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */