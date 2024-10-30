package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCell;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;

public class CTTableCellImpl extends XmlComplexContentImpl implements CTTableCell {
  private static final b TXBODY$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "txBody");
  
  private static final b TCPR$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tcPr");
  
  private static final b EXTLST$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  private static final b ROWSPAN$6 = new b("", "rowSpan");
  
  private static final b GRIDSPAN$8 = new b("", "gridSpan");
  
  private static final b HMERGE$10 = new b("", "hMerge");
  
  private static final b VMERGE$12 = new b("", "vMerge");
  
  public CTTableCellImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTextBody getTxBody() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBody cTTextBody = null;
      cTTextBody = (CTTextBody)get_store().find_element_user(TXBODY$0, 0);
      if (cTTextBody == null)
        return null; 
      return cTTextBody;
    } 
  }
  
  public boolean isSetTxBody() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TXBODY$0) != 0);
    } 
  }
  
  public void setTxBody(CTTextBody paramCTTextBody) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBody cTTextBody = null;
      cTTextBody = (CTTextBody)get_store().find_element_user(TXBODY$0, 0);
      if (cTTextBody == null)
        cTTextBody = (CTTextBody)get_store().add_element_user(TXBODY$0); 
      cTTextBody.set((XmlObject)paramCTTextBody);
    } 
  }
  
  public CTTextBody addNewTxBody() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextBody cTTextBody = null;
      cTTextBody = (CTTextBody)get_store().add_element_user(TXBODY$0);
      return cTTextBody;
    } 
  }
  
  public void unsetTxBody() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TXBODY$0, 0);
    } 
  }
  
  public CTTableCellProperties getTcPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableCellProperties cTTableCellProperties = null;
      cTTableCellProperties = (CTTableCellProperties)get_store().find_element_user(TCPR$2, 0);
      if (cTTableCellProperties == null)
        return null; 
      return cTTableCellProperties;
    } 
  }
  
  public boolean isSetTcPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TCPR$2) != 0);
    } 
  }
  
  public void setTcPr(CTTableCellProperties paramCTTableCellProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableCellProperties cTTableCellProperties = null;
      cTTableCellProperties = (CTTableCellProperties)get_store().find_element_user(TCPR$2, 0);
      if (cTTableCellProperties == null)
        cTTableCellProperties = (CTTableCellProperties)get_store().add_element_user(TCPR$2); 
      cTTableCellProperties.set((XmlObject)paramCTTableCellProperties);
    } 
  }
  
  public CTTableCellProperties addNewTcPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableCellProperties cTTableCellProperties = null;
      cTTableCellProperties = (CTTableCellProperties)get_store().add_element_user(TCPR$2);
      return cTTableCellProperties;
    } 
  }
  
  public void unsetTcPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TCPR$2, 0);
    } 
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$4, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$4) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$4, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$4); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$4);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$4, 0);
    } 
  }
  
  public int getRowSpan() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ROWSPAN$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ROWSPAN$6); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetRowSpan() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(ROWSPAN$6);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_default_attribute_value(ROWSPAN$6); 
      return xmlInt;
    } 
  }
  
  public boolean isSetRowSpan() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ROWSPAN$6) != null);
    } 
  }
  
  public void setRowSpan(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ROWSPAN$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ROWSPAN$6); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetRowSpan(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(ROWSPAN$6);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_attribute_user(ROWSPAN$6); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetRowSpan() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ROWSPAN$6);
    } 
  }
  
  public int getGridSpan() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(GRIDSPAN$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(GRIDSPAN$8); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetGridSpan() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(GRIDSPAN$8);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_default_attribute_value(GRIDSPAN$8); 
      return xmlInt;
    } 
  }
  
  public boolean isSetGridSpan() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(GRIDSPAN$8) != null);
    } 
  }
  
  public void setGridSpan(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(GRIDSPAN$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(GRIDSPAN$8); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetGridSpan(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(GRIDSPAN$8);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_attribute_user(GRIDSPAN$8); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetGridSpan() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(GRIDSPAN$8);
    } 
  }
  
  public boolean getHMerge() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HMERGE$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(HMERGE$10); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetHMerge() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HMERGE$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(HMERGE$10); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetHMerge() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HMERGE$10) != null);
    } 
  }
  
  public void setHMerge(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HMERGE$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HMERGE$10); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetHMerge(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HMERGE$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(HMERGE$10); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetHMerge() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HMERGE$10);
    } 
  }
  
  public boolean getVMerge() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VMERGE$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(VMERGE$12); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetVMerge() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(VMERGE$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(VMERGE$12); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetVMerge() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VMERGE$12) != null);
    } 
  }
  
  public void setVMerge(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VMERGE$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VMERGE$12); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetVMerge(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(VMERGE$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(VMERGE$12); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetVMerge() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VMERGE$12);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTableCellImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */