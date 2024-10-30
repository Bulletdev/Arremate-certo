package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXmlCellPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXmlPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTXmlCellPrImpl extends XmlComplexContentImpl implements CTXmlCellPr {
  private static final b XMLPR$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "xmlPr");
  
  private static final b EXTLST$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  private static final b ID$4 = new b("", "id");
  
  private static final b UNIQUENAME$6 = new b("", "uniqueName");
  
  public CTXmlCellPrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTXmlPr getXmlPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTXmlPr cTXmlPr = null;
      cTXmlPr = (CTXmlPr)get_store().find_element_user(XMLPR$0, 0);
      if (cTXmlPr == null)
        return null; 
      return cTXmlPr;
    } 
  }
  
  public void setXmlPr(CTXmlPr paramCTXmlPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTXmlPr cTXmlPr = null;
      cTXmlPr = (CTXmlPr)get_store().find_element_user(XMLPR$0, 0);
      if (cTXmlPr == null)
        cTXmlPr = (CTXmlPr)get_store().add_element_user(XMLPR$0); 
      cTXmlPr.set((XmlObject)paramCTXmlPr);
    } 
  }
  
  public CTXmlPr addNewXmlPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTXmlPr cTXmlPr = null;
      cTXmlPr = (CTXmlPr)get_store().add_element_user(XMLPR$0);
      return cTXmlPr;
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$2, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$2) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$2, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$2); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$2);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$2, 0);
    } 
  }
  
  public long getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$4);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ID$4);
      return xmlUnsignedInt;
    } 
  }
  
  public void setId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$4); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetId(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ID$4);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(ID$4); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public String getUniqueName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UNIQUENAME$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetUniqueName() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(UNIQUENAME$6);
      return sTXstring;
    } 
  }
  
  public boolean isSetUniqueName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(UNIQUENAME$6) != null);
    } 
  }
  
  public void setUniqueName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UNIQUENAME$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(UNIQUENAME$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetUniqueName(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(UNIQUENAME$6);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(UNIQUENAME$6); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetUniqueName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(UNIQUENAME$6);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTXmlCellPrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */