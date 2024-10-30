package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STUnsignedShortHex;

public class CTSheetProtectionImpl extends XmlComplexContentImpl implements CTSheetProtection {
  private static final b PASSWORD$0 = new b("", "password");
  
  private static final b SHEET$2 = new b("", "sheet");
  
  private static final b OBJECTS$4 = new b("", "objects");
  
  private static final b SCENARIOS$6 = new b("", "scenarios");
  
  private static final b FORMATCELLS$8 = new b("", "formatCells");
  
  private static final b FORMATCOLUMNS$10 = new b("", "formatColumns");
  
  private static final b FORMATROWS$12 = new b("", "formatRows");
  
  private static final b INSERTCOLUMNS$14 = new b("", "insertColumns");
  
  private static final b INSERTROWS$16 = new b("", "insertRows");
  
  private static final b INSERTHYPERLINKS$18 = new b("", "insertHyperlinks");
  
  private static final b DELETECOLUMNS$20 = new b("", "deleteColumns");
  
  private static final b DELETEROWS$22 = new b("", "deleteRows");
  
  private static final b SELECTLOCKEDCELLS$24 = new b("", "selectLockedCells");
  
  private static final b SORT$26 = new b("", "sort");
  
  private static final b AUTOFILTER$28 = new b("", "autoFilter");
  
  private static final b PIVOTTABLES$30 = new b("", "pivotTables");
  
  private static final b SELECTUNLOCKEDCELLS$32 = new b("", "selectUnlockedCells");
  
  public CTSheetProtectionImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public byte[] getPassword() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PASSWORD$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public STUnsignedShortHex xgetPassword() {
    synchronized (monitor()) {
      check_orphaned();
      STUnsignedShortHex sTUnsignedShortHex = null;
      sTUnsignedShortHex = (STUnsignedShortHex)get_store().find_attribute_user(PASSWORD$0);
      return sTUnsignedShortHex;
    } 
  }
  
  public boolean isSetPassword() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PASSWORD$0) != null);
    } 
  }
  
  public void setPassword(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PASSWORD$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PASSWORD$0); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetPassword(STUnsignedShortHex paramSTUnsignedShortHex) {
    synchronized (monitor()) {
      check_orphaned();
      STUnsignedShortHex sTUnsignedShortHex = null;
      sTUnsignedShortHex = (STUnsignedShortHex)get_store().find_attribute_user(PASSWORD$0);
      if (sTUnsignedShortHex == null)
        sTUnsignedShortHex = (STUnsignedShortHex)get_store().add_attribute_user(PASSWORD$0); 
      sTUnsignedShortHex.set((XmlObject)paramSTUnsignedShortHex);
    } 
  }
  
  public void unsetPassword() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PASSWORD$0);
    } 
  }
  
  public boolean getSheet() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHEET$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHEET$2); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetSheet() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHEET$2);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHEET$2); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetSheet() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHEET$2) != null);
    } 
  }
  
  public void setSheet(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHEET$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHEET$2); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetSheet(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHEET$2);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHEET$2); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetSheet() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHEET$2);
    } 
  }
  
  public boolean getObjects() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OBJECTS$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(OBJECTS$4); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetObjects() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(OBJECTS$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(OBJECTS$4); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetObjects() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(OBJECTS$4) != null);
    } 
  }
  
  public void setObjects(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OBJECTS$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(OBJECTS$4); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetObjects(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(OBJECTS$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(OBJECTS$4); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetObjects() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(OBJECTS$4);
    } 
  }
  
  public boolean getScenarios() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SCENARIOS$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SCENARIOS$6); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetScenarios() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SCENARIOS$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SCENARIOS$6); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetScenarios() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SCENARIOS$6) != null);
    } 
  }
  
  public void setScenarios(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SCENARIOS$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SCENARIOS$6); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetScenarios(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SCENARIOS$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SCENARIOS$6); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetScenarios() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SCENARIOS$6);
    } 
  }
  
  public boolean getFormatCells() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORMATCELLS$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FORMATCELLS$8); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFormatCells() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FORMATCELLS$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FORMATCELLS$8); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFormatCells() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FORMATCELLS$8) != null);
    } 
  }
  
  public void setFormatCells(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORMATCELLS$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FORMATCELLS$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFormatCells(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FORMATCELLS$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FORMATCELLS$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFormatCells() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FORMATCELLS$8);
    } 
  }
  
  public boolean getFormatColumns() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORMATCOLUMNS$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FORMATCOLUMNS$10); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFormatColumns() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FORMATCOLUMNS$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FORMATCOLUMNS$10); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFormatColumns() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FORMATCOLUMNS$10) != null);
    } 
  }
  
  public void setFormatColumns(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORMATCOLUMNS$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FORMATCOLUMNS$10); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFormatColumns(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FORMATCOLUMNS$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FORMATCOLUMNS$10); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFormatColumns() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FORMATCOLUMNS$10);
    } 
  }
  
  public boolean getFormatRows() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORMATROWS$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FORMATROWS$12); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFormatRows() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FORMATROWS$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FORMATROWS$12); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFormatRows() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FORMATROWS$12) != null);
    } 
  }
  
  public void setFormatRows(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORMATROWS$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FORMATROWS$12); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFormatRows(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FORMATROWS$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FORMATROWS$12); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFormatRows() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FORMATROWS$12);
    } 
  }
  
  public boolean getInsertColumns() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSERTCOLUMNS$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(INSERTCOLUMNS$14); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetInsertColumns() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(INSERTCOLUMNS$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(INSERTCOLUMNS$14); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetInsertColumns() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(INSERTCOLUMNS$14) != null);
    } 
  }
  
  public void setInsertColumns(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSERTCOLUMNS$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INSERTCOLUMNS$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetInsertColumns(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(INSERTCOLUMNS$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(INSERTCOLUMNS$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetInsertColumns() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(INSERTCOLUMNS$14);
    } 
  }
  
  public boolean getInsertRows() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSERTROWS$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(INSERTROWS$16); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetInsertRows() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(INSERTROWS$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(INSERTROWS$16); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetInsertRows() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(INSERTROWS$16) != null);
    } 
  }
  
  public void setInsertRows(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSERTROWS$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INSERTROWS$16); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetInsertRows(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(INSERTROWS$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(INSERTROWS$16); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetInsertRows() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(INSERTROWS$16);
    } 
  }
  
  public boolean getInsertHyperlinks() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSERTHYPERLINKS$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(INSERTHYPERLINKS$18); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetInsertHyperlinks() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(INSERTHYPERLINKS$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(INSERTHYPERLINKS$18); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetInsertHyperlinks() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(INSERTHYPERLINKS$18) != null);
    } 
  }
  
  public void setInsertHyperlinks(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSERTHYPERLINKS$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INSERTHYPERLINKS$18); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetInsertHyperlinks(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(INSERTHYPERLINKS$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(INSERTHYPERLINKS$18); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetInsertHyperlinks() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(INSERTHYPERLINKS$18);
    } 
  }
  
  public boolean getDeleteColumns() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DELETECOLUMNS$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DELETECOLUMNS$20); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDeleteColumns() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DELETECOLUMNS$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DELETECOLUMNS$20); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDeleteColumns() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DELETECOLUMNS$20) != null);
    } 
  }
  
  public void setDeleteColumns(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DELETECOLUMNS$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DELETECOLUMNS$20); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDeleteColumns(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DELETECOLUMNS$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DELETECOLUMNS$20); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDeleteColumns() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DELETECOLUMNS$20);
    } 
  }
  
  public boolean getDeleteRows() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DELETEROWS$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DELETEROWS$22); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDeleteRows() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DELETEROWS$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DELETEROWS$22); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDeleteRows() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DELETEROWS$22) != null);
    } 
  }
  
  public void setDeleteRows(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DELETEROWS$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DELETEROWS$22); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDeleteRows(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DELETEROWS$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DELETEROWS$22); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDeleteRows() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DELETEROWS$22);
    } 
  }
  
  public boolean getSelectLockedCells() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SELECTLOCKEDCELLS$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SELECTLOCKEDCELLS$24); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetSelectLockedCells() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SELECTLOCKEDCELLS$24);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SELECTLOCKEDCELLS$24); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetSelectLockedCells() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SELECTLOCKEDCELLS$24) != null);
    } 
  }
  
  public void setSelectLockedCells(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SELECTLOCKEDCELLS$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SELECTLOCKEDCELLS$24); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetSelectLockedCells(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SELECTLOCKEDCELLS$24);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SELECTLOCKEDCELLS$24); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetSelectLockedCells() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SELECTLOCKEDCELLS$24);
    } 
  }
  
  public boolean getSort() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SORT$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SORT$26); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetSort() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SORT$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SORT$26); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetSort() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SORT$26) != null);
    } 
  }
  
  public void setSort(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SORT$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SORT$26); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetSort(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SORT$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SORT$26); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetSort() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SORT$26);
    } 
  }
  
  public boolean getAutoFilter() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTOFILTER$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(AUTOFILTER$28); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetAutoFilter() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(AUTOFILTER$28);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(AUTOFILTER$28); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetAutoFilter() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(AUTOFILTER$28) != null);
    } 
  }
  
  public void setAutoFilter(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTOFILTER$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(AUTOFILTER$28); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetAutoFilter(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(AUTOFILTER$28);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(AUTOFILTER$28); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetAutoFilter() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(AUTOFILTER$28);
    } 
  }
  
  public boolean getPivotTables() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PIVOTTABLES$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PIVOTTABLES$30); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetPivotTables() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PIVOTTABLES$30);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(PIVOTTABLES$30); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetPivotTables() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PIVOTTABLES$30) != null);
    } 
  }
  
  public void setPivotTables(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PIVOTTABLES$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PIVOTTABLES$30); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetPivotTables(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PIVOTTABLES$30);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PIVOTTABLES$30); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetPivotTables() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PIVOTTABLES$30);
    } 
  }
  
  public boolean getSelectUnlockedCells() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SELECTUNLOCKEDCELLS$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SELECTUNLOCKEDCELLS$32); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetSelectUnlockedCells() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SELECTUNLOCKEDCELLS$32);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SELECTUNLOCKEDCELLS$32); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetSelectUnlockedCells() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SELECTUNLOCKEDCELLS$32) != null);
    } 
  }
  
  public void setSelectUnlockedCells(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SELECTUNLOCKEDCELLS$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SELECTUNLOCKEDCELLS$32); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetSelectUnlockedCells(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SELECTUNLOCKEDCELLS$32);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SELECTUNLOCKEDCELLS$32); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetSelectUnlockedCells() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SELECTUNLOCKEDCELLS$32);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTSheetProtectionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */