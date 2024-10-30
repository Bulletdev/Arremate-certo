package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumRef;

public class CTNumRefImpl extends XmlComplexContentImpl implements CTNumRef {
  private static final b F$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "f");
  
  private static final b NUMCACHE$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "numCache");
  
  private static final b EXTLST$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");
  
  public CTNumRefImpl(SchemaType paramSchemaType) {
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
  
  public CTNumData getNumCache() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumData cTNumData = null;
      cTNumData = (CTNumData)get_store().find_element_user(NUMCACHE$2, 0);
      if (cTNumData == null)
        return null; 
      return cTNumData;
    } 
  }
  
  public boolean isSetNumCache() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NUMCACHE$2) != 0);
    } 
  }
  
  public void setNumCache(CTNumData paramCTNumData) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumData cTNumData = null;
      cTNumData = (CTNumData)get_store().find_element_user(NUMCACHE$2, 0);
      if (cTNumData == null)
        cTNumData = (CTNumData)get_store().add_element_user(NUMCACHE$2); 
      cTNumData.set((XmlObject)paramCTNumData);
    } 
  }
  
  public CTNumData addNewNumCache() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumData cTNumData = null;
      cTNumData = (CTNumData)get_store().add_element_user(NUMCACHE$2);
      return cTNumData;
    } 
  }
  
  public void unsetNumCache() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NUMCACHE$2, 0);
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTNumRefImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */