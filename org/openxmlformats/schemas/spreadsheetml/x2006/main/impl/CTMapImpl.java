package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBinding;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMap;

public class CTMapImpl extends XmlComplexContentImpl implements CTMap {
  private static final b DATABINDING$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "DataBinding");
  
  private static final b ID$2 = new b("", "ID");
  
  private static final b NAME$4 = new b("", "Name");
  
  private static final b ROOTELEMENT$6 = new b("", "RootElement");
  
  private static final b SCHEMAID$8 = new b("", "SchemaID");
  
  private static final b SHOWIMPORTEXPORTVALIDATIONERRORS$10 = new b("", "ShowImportExportValidationErrors");
  
  private static final b AUTOFIT$12 = new b("", "AutoFit");
  
  private static final b APPEND$14 = new b("", "Append");
  
  private static final b PRESERVESORTAFLAYOUT$16 = new b("", "PreserveSortAFLayout");
  
  private static final b PRESERVEFORMAT$18 = new b("", "PreserveFormat");
  
  public CTMapImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTDataBinding getDataBinding() {
    synchronized (monitor()) {
      check_orphaned();
      CTDataBinding cTDataBinding = null;
      cTDataBinding = (CTDataBinding)get_store().find_element_user(DATABINDING$0, 0);
      if (cTDataBinding == null)
        return null; 
      return cTDataBinding;
    } 
  }
  
  public boolean isSetDataBinding() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DATABINDING$0) != 0);
    } 
  }
  
  public void setDataBinding(CTDataBinding paramCTDataBinding) {
    synchronized (monitor()) {
      check_orphaned();
      CTDataBinding cTDataBinding = null;
      cTDataBinding = (CTDataBinding)get_store().find_element_user(DATABINDING$0, 0);
      if (cTDataBinding == null)
        cTDataBinding = (CTDataBinding)get_store().add_element_user(DATABINDING$0); 
      cTDataBinding.set((XmlObject)paramCTDataBinding);
    } 
  }
  
  public CTDataBinding addNewDataBinding() {
    synchronized (monitor()) {
      check_orphaned();
      CTDataBinding cTDataBinding = null;
      cTDataBinding = (CTDataBinding)get_store().add_element_user(DATABINDING$0);
      return cTDataBinding;
    } 
  }
  
  public void unsetDataBinding() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DATABINDING$0, 0);
    } 
  }
  
  public long getID() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$2);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetID() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ID$2);
      return xmlUnsignedInt;
    } 
  }
  
  public void setID(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$2); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetID(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ID$2);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(ID$2); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$4);
      return xmlString;
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$4);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(NAME$4); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public String getRootElement() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ROOTELEMENT$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetRootElement() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ROOTELEMENT$6);
      return xmlString;
    } 
  }
  
  public void setRootElement(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ROOTELEMENT$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ROOTELEMENT$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetRootElement(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ROOTELEMENT$6);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(ROOTELEMENT$6); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public String getSchemaID() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SCHEMAID$8);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetSchemaID() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(SCHEMAID$8);
      return xmlString;
    } 
  }
  
  public void setSchemaID(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SCHEMAID$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SCHEMAID$8); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetSchemaID(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(SCHEMAID$8);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(SCHEMAID$8); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public boolean getShowImportExportValidationErrors() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWIMPORTEXPORTVALIDATIONERRORS$10);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowImportExportValidationErrors() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWIMPORTEXPORTVALIDATIONERRORS$10);
      return xmlBoolean;
    } 
  }
  
  public void setShowImportExportValidationErrors(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWIMPORTEXPORTVALIDATIONERRORS$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWIMPORTEXPORTVALIDATIONERRORS$10); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowImportExportValidationErrors(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWIMPORTEXPORTVALIDATIONERRORS$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWIMPORTEXPORTVALIDATIONERRORS$10); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public boolean getAutoFit() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTOFIT$12);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetAutoFit() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(AUTOFIT$12);
      return xmlBoolean;
    } 
  }
  
  public void setAutoFit(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTOFIT$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(AUTOFIT$12); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetAutoFit(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(AUTOFIT$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(AUTOFIT$12); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public boolean getAppend() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPEND$14);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetAppend() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPEND$14);
      return xmlBoolean;
    } 
  }
  
  public void setAppend(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPEND$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(APPEND$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetAppend(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPEND$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(APPEND$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public boolean getPreserveSortAFLayout() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PRESERVESORTAFLAYOUT$16);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetPreserveSortAFLayout() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PRESERVESORTAFLAYOUT$16);
      return xmlBoolean;
    } 
  }
  
  public void setPreserveSortAFLayout(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PRESERVESORTAFLAYOUT$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PRESERVESORTAFLAYOUT$16); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetPreserveSortAFLayout(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PRESERVESORTAFLAYOUT$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PRESERVESORTAFLAYOUT$16); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public boolean getPreserveFormat() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PRESERVEFORMAT$18);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetPreserveFormat() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PRESERVEFORMAT$18);
      return xmlBoolean;
    } 
  }
  
  public void setPreserveFormat(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PRESERVEFORMAT$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PRESERVEFORMAT$18); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetPreserveFormat(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PRESERVEFORMAT$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PRESERVEFORMAT$18); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTMapImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */