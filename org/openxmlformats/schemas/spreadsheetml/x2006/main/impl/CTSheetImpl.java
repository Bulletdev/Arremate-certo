package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSheetState;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTSheetImpl extends XmlComplexContentImpl implements CTSheet {
  private static final b NAME$0 = new b("", "name");
  
  private static final b SHEETID$2 = new b("", "sheetId");
  
  private static final b STATE$4 = new b("", "state");
  
  private static final b ID$6 = new b("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "id");
  
  public CTSheetImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(NAME$0);
      return sTXstring;
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(NAME$0);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(NAME$0); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public long getSheetId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHEETID$2);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetSheetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(SHEETID$2);
      return xmlUnsignedInt;
    } 
  }
  
  public void setSheetId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHEETID$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHEETID$2); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetSheetId(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(SHEETID$2);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(SHEETID$2); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public STSheetState.Enum getState() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STATE$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(STATE$4); 
      if (simpleValue == null)
        return null; 
      return (STSheetState.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STSheetState xgetState() {
    synchronized (monitor()) {
      check_orphaned();
      STSheetState sTSheetState = null;
      sTSheetState = (STSheetState)get_store().find_attribute_user(STATE$4);
      if (sTSheetState == null)
        sTSheetState = (STSheetState)get_default_attribute_value(STATE$4); 
      return sTSheetState;
    } 
  }
  
  public boolean isSetState() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STATE$4) != null);
    } 
  }
  
  public void setState(STSheetState.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STATE$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STATE$4); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetState(STSheetState paramSTSheetState) {
    synchronized (monitor()) {
      check_orphaned();
      STSheetState sTSheetState = null;
      sTSheetState = (STSheetState)get_store().find_attribute_user(STATE$4);
      if (sTSheetState == null)
        sTSheetState = (STSheetState)get_store().add_attribute_user(STATE$4); 
      sTSheetState.set((XmlObject)paramSTSheetState);
    } 
  }
  
  public void unsetState() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STATE$4);
    } 
  }
  
  public String getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STRelationshipId xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(ID$6);
      return sTRelationshipId;
    } 
  }
  
  public void setId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetId(STRelationshipId paramSTRelationshipId) {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(ID$6);
      if (sTRelationshipId == null)
        sTRelationshipId = (STRelationshipId)get_store().add_attribute_user(ID$6); 
      sTRelationshipId.set((XmlObject)paramSTRelationshipId);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTSheetImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */