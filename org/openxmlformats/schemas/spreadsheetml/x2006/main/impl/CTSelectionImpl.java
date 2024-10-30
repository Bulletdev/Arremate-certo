package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellRef;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPane;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSqref;

public class CTSelectionImpl extends XmlComplexContentImpl implements CTSelection {
  private static final b PANE$0 = new b("", "pane");
  
  private static final b ACTIVECELL$2 = new b("", "activeCell");
  
  private static final b ACTIVECELLID$4 = new b("", "activeCellId");
  
  private static final b SQREF$6 = new b("", "sqref");
  
  public CTSelectionImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STPane.Enum getPane() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PANE$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PANE$0); 
      if (simpleValue == null)
        return null; 
      return (STPane.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STPane xgetPane() {
    synchronized (monitor()) {
      check_orphaned();
      STPane sTPane = null;
      sTPane = (STPane)get_store().find_attribute_user(PANE$0);
      if (sTPane == null)
        sTPane = (STPane)get_default_attribute_value(PANE$0); 
      return sTPane;
    } 
  }
  
  public boolean isSetPane() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PANE$0) != null);
    } 
  }
  
  public void setPane(STPane.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PANE$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PANE$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetPane(STPane paramSTPane) {
    synchronized (monitor()) {
      check_orphaned();
      STPane sTPane = null;
      sTPane = (STPane)get_store().find_attribute_user(PANE$0);
      if (sTPane == null)
        sTPane = (STPane)get_store().add_attribute_user(PANE$0); 
      sTPane.set((XmlObject)paramSTPane);
    } 
  }
  
  public void unsetPane() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PANE$0);
    } 
  }
  
  public String getActiveCell() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACTIVECELL$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STCellRef xgetActiveCell() {
    synchronized (monitor()) {
      check_orphaned();
      STCellRef sTCellRef = null;
      sTCellRef = (STCellRef)get_store().find_attribute_user(ACTIVECELL$2);
      return sTCellRef;
    } 
  }
  
  public boolean isSetActiveCell() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ACTIVECELL$2) != null);
    } 
  }
  
  public void setActiveCell(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACTIVECELL$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ACTIVECELL$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetActiveCell(STCellRef paramSTCellRef) {
    synchronized (monitor()) {
      check_orphaned();
      STCellRef sTCellRef = null;
      sTCellRef = (STCellRef)get_store().find_attribute_user(ACTIVECELL$2);
      if (sTCellRef == null)
        sTCellRef = (STCellRef)get_store().add_attribute_user(ACTIVECELL$2); 
      sTCellRef.set((XmlObject)paramSTCellRef);
    } 
  }
  
  public void unsetActiveCell() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ACTIVECELL$2);
    } 
  }
  
  public long getActiveCellId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACTIVECELLID$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ACTIVECELLID$4); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetActiveCellId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ACTIVECELLID$4);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(ACTIVECELLID$4); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetActiveCellId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ACTIVECELLID$4) != null);
    } 
  }
  
  public void setActiveCellId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACTIVECELLID$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ACTIVECELLID$4); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetActiveCellId(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ACTIVECELLID$4);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(ACTIVECELLID$4); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetActiveCellId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ACTIVECELLID$4);
    } 
  }
  
  public List getSqref() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SQREF$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SQREF$6); 
      if (simpleValue == null)
        return null; 
      return simpleValue.getListValue();
    } 
  }
  
  public STSqref xgetSqref() {
    synchronized (monitor()) {
      check_orphaned();
      STSqref sTSqref = null;
      sTSqref = (STSqref)get_store().find_attribute_user(SQREF$6);
      if (sTSqref == null)
        sTSqref = (STSqref)get_default_attribute_value(SQREF$6); 
      return sTSqref;
    } 
  }
  
  public boolean isSetSqref() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SQREF$6) != null);
    } 
  }
  
  public void setSqref(List paramList) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SQREF$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SQREF$6); 
      simpleValue.setListValue(paramList);
    } 
  }
  
  public void xsetSqref(STSqref paramSTSqref) {
    synchronized (monitor()) {
      check_orphaned();
      STSqref sTSqref = null;
      sTSqref = (STSqref)get_store().find_attribute_user(SQREF$6);
      if (sTSqref == null)
        sTSqref = (STSqref)get_store().add_attribute_user(SQREF$6); 
      sTSqref.set((XmlObject)paramSTSqref);
    } 
  }
  
  public void unsetSqref() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SQREF$6);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTSelectionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */