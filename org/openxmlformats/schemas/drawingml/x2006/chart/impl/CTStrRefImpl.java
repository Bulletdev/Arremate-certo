package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrRef;

public class CTStrRefImpl extends XmlComplexContentImpl implements CTStrRef {
  private static final b F$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "f");
  
  private static final b STRCACHE$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "strCache");
  
  private static final b EXTLST$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");
  
  public CTStrRefImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getF() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(F$0, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetF() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(F$0, 0);
      return xmlString;
    } 
  }
  
  public void setF(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(F$0, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(F$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetF(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(F$0, 0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_element_user(F$0); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public CTStrData getStrCache() {
    synchronized (monitor()) {
      check_orphaned();
      CTStrData cTStrData = null;
      cTStrData = (CTStrData)get_store().find_element_user(STRCACHE$2, 0);
      if (cTStrData == null)
        return null; 
      return cTStrData;
    } 
  }
  
  public boolean isSetStrCache() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(STRCACHE$2) != 0);
    } 
  }
  
  public void setStrCache(CTStrData paramCTStrData) {
    synchronized (monitor()) {
      check_orphaned();
      CTStrData cTStrData = null;
      cTStrData = (CTStrData)get_store().find_element_user(STRCACHE$2, 0);
      if (cTStrData == null)
        cTStrData = (CTStrData)get_store().add_element_user(STRCACHE$2); 
      cTStrData.set((XmlObject)paramCTStrData);
    } 
  }
  
  public CTStrData addNewStrCache() {
    synchronized (monitor()) {
      check_orphaned();
      CTStrData cTStrData = null;
      cTStrData = (CTStrData)get_store().add_element_user(STRCACHE$2);
      return cTStrData;
    } 
  }
  
  public void unsetStrCache() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STRCACHE$2, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$4, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$4) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$4, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$4); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$4);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$4, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTStrRefImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */