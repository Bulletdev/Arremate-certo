package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingShapeProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeLocking;

public class CTNonVisualDrawingShapePropsImpl extends XmlComplexContentImpl implements CTNonVisualDrawingShapeProps {
  private static final b SPLOCKS$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "spLocks");
  
  private static final b EXTLST$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  private static final b TXBOX$4 = new b("", "txBox");
  
  public CTNonVisualDrawingShapePropsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTShapeLocking getSpLocks() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeLocking cTShapeLocking = null;
      cTShapeLocking = (CTShapeLocking)get_store().find_element_user(SPLOCKS$0, 0);
      if (cTShapeLocking == null)
        return null; 
      return cTShapeLocking;
    } 
  }
  
  public boolean isSetSpLocks() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SPLOCKS$0) != 0);
    } 
  }
  
  public void setSpLocks(CTShapeLocking paramCTShapeLocking) {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeLocking cTShapeLocking = null;
      cTShapeLocking = (CTShapeLocking)get_store().find_element_user(SPLOCKS$0, 0);
      if (cTShapeLocking == null)
        cTShapeLocking = (CTShapeLocking)get_store().add_element_user(SPLOCKS$0); 
      cTShapeLocking.set((XmlObject)paramCTShapeLocking);
    } 
  }
  
  public CTShapeLocking addNewSpLocks() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapeLocking cTShapeLocking = null;
      cTShapeLocking = (CTShapeLocking)get_store().add_element_user(SPLOCKS$0);
      return cTShapeLocking;
    } 
  }
  
  public void unsetSpLocks() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SPLOCKS$0, 0);
    } 
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$2, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$2) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$2, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$2); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$2);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$2, 0);
    } 
  }
  
  public boolean getTxBox() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TXBOX$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(TXBOX$4); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetTxBox() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(TXBOX$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(TXBOX$4); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetTxBox() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TXBOX$4) != null);
    } 
  }
  
  public void setTxBox(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TXBOX$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TXBOX$4); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetTxBox(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(TXBOX$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(TXBOX$4); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetTxBox() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TXBOX$4);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTNonVisualDrawingShapePropsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */