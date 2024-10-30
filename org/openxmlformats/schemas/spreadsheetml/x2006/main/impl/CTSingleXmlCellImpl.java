package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXmlCellPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellRef;

public class CTSingleXmlCellImpl extends XmlComplexContentImpl implements CTSingleXmlCell {
  private static final b XMLCELLPR$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "xmlCellPr");
  
  private static final b EXTLST$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  private static final b ID$4 = new b("", "id");
  
  private static final b R$6 = new b("", "r");
  
  private static final b CONNECTIONID$8 = new b("", "connectionId");
  
  public CTSingleXmlCellImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTXmlCellPr getXmlCellPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTXmlCellPr cTXmlCellPr = null;
      cTXmlCellPr = (CTXmlCellPr)get_store().find_element_user(XMLCELLPR$0, 0);
      if (cTXmlCellPr == null)
        return null; 
      return cTXmlCellPr;
    } 
  }
  
  public void setXmlCellPr(CTXmlCellPr paramCTXmlCellPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTXmlCellPr cTXmlCellPr = null;
      cTXmlCellPr = (CTXmlCellPr)get_store().find_element_user(XMLCELLPR$0, 0);
      if (cTXmlCellPr == null)
        cTXmlCellPr = (CTXmlCellPr)get_store().add_element_user(XMLCELLPR$0); 
      cTXmlCellPr.set((XmlObject)paramCTXmlCellPr);
    } 
  }
  
  public CTXmlCellPr addNewXmlCellPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTXmlCellPr cTXmlCellPr = null;
      cTXmlCellPr = (CTXmlCellPr)get_store().add_element_user(XMLCELLPR$0);
      return cTXmlCellPr;
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
  
  public String getR() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(R$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STCellRef xgetR() {
    synchronized (monitor()) {
      check_orphaned();
      STCellRef sTCellRef = null;
      sTCellRef = (STCellRef)get_store().find_attribute_user(R$6);
      return sTCellRef;
    } 
  }
  
  public void setR(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(R$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(R$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetR(STCellRef paramSTCellRef) {
    synchronized (monitor()) {
      check_orphaned();
      STCellRef sTCellRef = null;
      sTCellRef = (STCellRef)get_store().find_attribute_user(R$6);
      if (sTCellRef == null)
        sTCellRef = (STCellRef)get_store().add_attribute_user(R$6); 
      sTCellRef.set((XmlObject)paramSTCellRef);
    } 
  }
  
  public long getConnectionId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONNECTIONID$8);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetConnectionId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(CONNECTIONID$8);
      return xmlUnsignedInt;
    } 
  }
  
  public void setConnectionId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONNECTIONID$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CONNECTIONID$8); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetConnectionId(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(CONNECTIONID$8);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(CONNECTIONID$8); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTSingleXmlCellImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */