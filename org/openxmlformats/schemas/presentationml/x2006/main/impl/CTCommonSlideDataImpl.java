package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackground;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTControlList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;

public class CTCommonSlideDataImpl extends XmlComplexContentImpl implements CTCommonSlideData {
  private static final b BG$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "bg");
  
  private static final b SPTREE$2 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "spTree");
  
  private static final b CUSTDATALST$4 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "custDataLst");
  
  private static final b CONTROLS$6 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "controls");
  
  private static final b EXTLST$8 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
  
  private static final b NAME$10 = new b("", "name");
  
  public CTCommonSlideDataImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTBackground getBg() {
    synchronized (monitor()) {
      check_orphaned();
      CTBackground cTBackground = null;
      cTBackground = (CTBackground)get_store().find_element_user(BG$0, 0);
      if (cTBackground == null)
        return null; 
      return cTBackground;
    } 
  }
  
  public boolean isSetBg() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BG$0) != 0);
    } 
  }
  
  public void setBg(CTBackground paramCTBackground) {
    synchronized (monitor()) {
      check_orphaned();
      CTBackground cTBackground = null;
      cTBackground = (CTBackground)get_store().find_element_user(BG$0, 0);
      if (cTBackground == null)
        cTBackground = (CTBackground)get_store().add_element_user(BG$0); 
      cTBackground.set((XmlObject)paramCTBackground);
    } 
  }
  
  public CTBackground addNewBg() {
    synchronized (monitor()) {
      check_orphaned();
      CTBackground cTBackground = null;
      cTBackground = (CTBackground)get_store().add_element_user(BG$0);
      return cTBackground;
    } 
  }
  
  public void unsetBg() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BG$0, 0);
    } 
  }
  
  public CTGroupShape getSpTree() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupShape cTGroupShape = null;
      cTGroupShape = (CTGroupShape)get_store().find_element_user(SPTREE$2, 0);
      if (cTGroupShape == null)
        return null; 
      return cTGroupShape;
    } 
  }
  
  public void setSpTree(CTGroupShape paramCTGroupShape) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupShape cTGroupShape = null;
      cTGroupShape = (CTGroupShape)get_store().find_element_user(SPTREE$2, 0);
      if (cTGroupShape == null)
        cTGroupShape = (CTGroupShape)get_store().add_element_user(SPTREE$2); 
      cTGroupShape.set((XmlObject)paramCTGroupShape);
    } 
  }
  
  public CTGroupShape addNewSpTree() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupShape cTGroupShape = null;
      cTGroupShape = (CTGroupShape)get_store().add_element_user(SPTREE$2);
      return cTGroupShape;
    } 
  }
  
  public CTCustomerDataList getCustDataLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomerDataList cTCustomerDataList = null;
      cTCustomerDataList = (CTCustomerDataList)get_store().find_element_user(CUSTDATALST$4, 0);
      if (cTCustomerDataList == null)
        return null; 
      return cTCustomerDataList;
    } 
  }
  
  public boolean isSetCustDataLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CUSTDATALST$4) != 0);
    } 
  }
  
  public void setCustDataLst(CTCustomerDataList paramCTCustomerDataList) {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomerDataList cTCustomerDataList = null;
      cTCustomerDataList = (CTCustomerDataList)get_store().find_element_user(CUSTDATALST$4, 0);
      if (cTCustomerDataList == null)
        cTCustomerDataList = (CTCustomerDataList)get_store().add_element_user(CUSTDATALST$4); 
      cTCustomerDataList.set((XmlObject)paramCTCustomerDataList);
    } 
  }
  
  public CTCustomerDataList addNewCustDataLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomerDataList cTCustomerDataList = null;
      cTCustomerDataList = (CTCustomerDataList)get_store().add_element_user(CUSTDATALST$4);
      return cTCustomerDataList;
    } 
  }
  
  public void unsetCustDataLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTDATALST$4, 0);
    } 
  }
  
  public CTControlList getControls() {
    synchronized (monitor()) {
      check_orphaned();
      CTControlList cTControlList = null;
      cTControlList = (CTControlList)get_store().find_element_user(CONTROLS$6, 0);
      if (cTControlList == null)
        return null; 
      return cTControlList;
    } 
  }
  
  public boolean isSetControls() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CONTROLS$6) != 0);
    } 
  }
  
  public void setControls(CTControlList paramCTControlList) {
    synchronized (monitor()) {
      check_orphaned();
      CTControlList cTControlList = null;
      cTControlList = (CTControlList)get_store().find_element_user(CONTROLS$6, 0);
      if (cTControlList == null)
        cTControlList = (CTControlList)get_store().add_element_user(CONTROLS$6); 
      cTControlList.set((XmlObject)paramCTControlList);
    } 
  }
  
  public CTControlList addNewControls() {
    synchronized (monitor()) {
      check_orphaned();
      CTControlList cTControlList = null;
      cTControlList = (CTControlList)get_store().add_element_user(CONTROLS$6);
      return cTControlList;
    } 
  }
  
  public void unsetControls() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CONTROLS$6, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$8, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$8) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$8, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$8); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$8);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$8, 0);
    } 
  }
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(NAME$10); 
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$10);
      if (xmlString == null)
        xmlString = (XmlString)get_default_attribute_value(NAME$10); 
      return xmlString;
    } 
  }
  
  public boolean isSetName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NAME$10) != null);
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$10); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$10);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(NAME$10); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NAME$10);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTCommonSlideDataImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */