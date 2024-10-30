package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFieldGroup;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTX;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STNumFmtId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTCacheFieldImpl extends XmlComplexContentImpl implements CTCacheField {
  private static final b SHAREDITEMS$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sharedItems");
  
  private static final b FIELDGROUP$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "fieldGroup");
  
  private static final b MPMAP$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "mpMap");
  
  private static final b EXTLST$6 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  private static final b NAME$8 = new b("", "name");
  
  private static final b CAPTION$10 = new b("", "caption");
  
  private static final b PROPERTYNAME$12 = new b("", "propertyName");
  
  private static final b SERVERFIELD$14 = new b("", "serverField");
  
  private static final b UNIQUELIST$16 = new b("", "uniqueList");
  
  private static final b NUMFMTID$18 = new b("", "numFmtId");
  
  private static final b FORMULA$20 = new b("", "formula");
  
  private static final b SQLTYPE$22 = new b("", "sqlType");
  
  private static final b HIERARCHY$24 = new b("", "hierarchy");
  
  private static final b LEVEL$26 = new b("", "level");
  
  private static final b DATABASEFIELD$28 = new b("", "databaseField");
  
  private static final b MAPPINGCOUNT$30 = new b("", "mappingCount");
  
  private static final b MEMBERPROPERTYFIELD$32 = new b("", "memberPropertyField");
  
  public CTCacheFieldImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTSharedItems getSharedItems() {
    synchronized (monitor()) {
      check_orphaned();
      CTSharedItems cTSharedItems = null;
      cTSharedItems = (CTSharedItems)get_store().find_element_user(SHAREDITEMS$0, 0);
      if (cTSharedItems == null)
        return null; 
      return cTSharedItems;
    } 
  }
  
  public boolean isSetSharedItems() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHAREDITEMS$0) != 0);
    } 
  }
  
  public void setSharedItems(CTSharedItems paramCTSharedItems) {
    synchronized (monitor()) {
      check_orphaned();
      CTSharedItems cTSharedItems = null;
      cTSharedItems = (CTSharedItems)get_store().find_element_user(SHAREDITEMS$0, 0);
      if (cTSharedItems == null)
        cTSharedItems = (CTSharedItems)get_store().add_element_user(SHAREDITEMS$0); 
      cTSharedItems.set((XmlObject)paramCTSharedItems);
    } 
  }
  
  public CTSharedItems addNewSharedItems() {
    synchronized (monitor()) {
      check_orphaned();
      CTSharedItems cTSharedItems = null;
      cTSharedItems = (CTSharedItems)get_store().add_element_user(SHAREDITEMS$0);
      return cTSharedItems;
    } 
  }
  
  public void unsetSharedItems() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHAREDITEMS$0, 0);
    } 
  }
  
  public CTFieldGroup getFieldGroup() {
    synchronized (monitor()) {
      check_orphaned();
      CTFieldGroup cTFieldGroup = null;
      cTFieldGroup = (CTFieldGroup)get_store().find_element_user(FIELDGROUP$2, 0);
      if (cTFieldGroup == null)
        return null; 
      return cTFieldGroup;
    } 
  }
  
  public boolean isSetFieldGroup() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FIELDGROUP$2) != 0);
    } 
  }
  
  public void setFieldGroup(CTFieldGroup paramCTFieldGroup) {
    synchronized (monitor()) {
      check_orphaned();
      CTFieldGroup cTFieldGroup = null;
      cTFieldGroup = (CTFieldGroup)get_store().find_element_user(FIELDGROUP$2, 0);
      if (cTFieldGroup == null)
        cTFieldGroup = (CTFieldGroup)get_store().add_element_user(FIELDGROUP$2); 
      cTFieldGroup.set((XmlObject)paramCTFieldGroup);
    } 
  }
  
  public CTFieldGroup addNewFieldGroup() {
    synchronized (monitor()) {
      check_orphaned();
      CTFieldGroup cTFieldGroup = null;
      cTFieldGroup = (CTFieldGroup)get_store().add_element_user(FIELDGROUP$2);
      return cTFieldGroup;
    } 
  }
  
  public void unsetFieldGroup() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FIELDGROUP$2, 0);
    } 
  }
  
  public List<CTX> getMpMapList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTX>)new MpMapList(this);
    } 
  }
  
  public CTX[] getMpMapArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(MPMAP$4, arrayList);
      CTX[] arrayOfCTX = new CTX[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTX);
      return arrayOfCTX;
    } 
  }
  
  public CTX getMpMapArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTX cTX = null;
      cTX = (CTX)get_store().find_element_user(MPMAP$4, paramInt);
      if (cTX == null)
        throw new IndexOutOfBoundsException(); 
      return cTX;
    } 
  }
  
  public int sizeOfMpMapArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MPMAP$4);
    } 
  }
  
  public void setMpMapArray(CTX[] paramArrayOfCTX) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTX, MPMAP$4);
    } 
  }
  
  public void setMpMapArray(int paramInt, CTX paramCTX) {
    synchronized (monitor()) {
      check_orphaned();
      CTX cTX = null;
      cTX = (CTX)get_store().find_element_user(MPMAP$4, paramInt);
      if (cTX == null)
        throw new IndexOutOfBoundsException(); 
      cTX.set((XmlObject)paramCTX);
    } 
  }
  
  public CTX insertNewMpMap(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTX cTX = null;
      cTX = (CTX)get_store().insert_element_user(MPMAP$4, paramInt);
      return cTX;
    } 
  }
  
  public CTX addNewMpMap() {
    synchronized (monitor()) {
      check_orphaned();
      CTX cTX = null;
      cTX = (CTX)get_store().add_element_user(MPMAP$4);
      return cTX;
    } 
  }
  
  public void removeMpMap(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MPMAP$4, paramInt);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$6, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$6) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$6, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$6); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$6);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$6, 0);
    } 
  }
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$8);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(NAME$8);
      return sTXstring;
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$8); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(NAME$8);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(NAME$8); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public String getCaption() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CAPTION$10);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetCaption() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(CAPTION$10);
      return sTXstring;
    } 
  }
  
  public boolean isSetCaption() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CAPTION$10) != null);
    } 
  }
  
  public void setCaption(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CAPTION$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CAPTION$10); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetCaption(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(CAPTION$10);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(CAPTION$10); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetCaption() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CAPTION$10);
    } 
  }
  
  public String getPropertyName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PROPERTYNAME$12);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetPropertyName() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(PROPERTYNAME$12);
      return sTXstring;
    } 
  }
  
  public boolean isSetPropertyName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PROPERTYNAME$12) != null);
    } 
  }
  
  public void setPropertyName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PROPERTYNAME$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PROPERTYNAME$12); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetPropertyName(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(PROPERTYNAME$12);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(PROPERTYNAME$12); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetPropertyName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PROPERTYNAME$12);
    } 
  }
  
  public boolean getServerField() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SERVERFIELD$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SERVERFIELD$14); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetServerField() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SERVERFIELD$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SERVERFIELD$14); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetServerField() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SERVERFIELD$14) != null);
    } 
  }
  
  public void setServerField(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SERVERFIELD$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SERVERFIELD$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetServerField(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SERVERFIELD$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SERVERFIELD$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetServerField() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SERVERFIELD$14);
    } 
  }
  
  public boolean getUniqueList() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UNIQUELIST$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(UNIQUELIST$16); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetUniqueList() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(UNIQUELIST$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(UNIQUELIST$16); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetUniqueList() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(UNIQUELIST$16) != null);
    } 
  }
  
  public void setUniqueList(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UNIQUELIST$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(UNIQUELIST$16); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetUniqueList(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(UNIQUELIST$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(UNIQUELIST$16); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetUniqueList() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(UNIQUELIST$16);
    } 
  }
  
  public long getNumFmtId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NUMFMTID$18);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STNumFmtId xgetNumFmtId() {
    synchronized (monitor()) {
      check_orphaned();
      STNumFmtId sTNumFmtId = null;
      sTNumFmtId = (STNumFmtId)get_store().find_attribute_user(NUMFMTID$18);
      return sTNumFmtId;
    } 
  }
  
  public boolean isSetNumFmtId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NUMFMTID$18) != null);
    } 
  }
  
  public void setNumFmtId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NUMFMTID$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NUMFMTID$18); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetNumFmtId(STNumFmtId paramSTNumFmtId) {
    synchronized (monitor()) {
      check_orphaned();
      STNumFmtId sTNumFmtId = null;
      sTNumFmtId = (STNumFmtId)get_store().find_attribute_user(NUMFMTID$18);
      if (sTNumFmtId == null)
        sTNumFmtId = (STNumFmtId)get_store().add_attribute_user(NUMFMTID$18); 
      sTNumFmtId.set((XmlObject)paramSTNumFmtId);
    } 
  }
  
  public void unsetNumFmtId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NUMFMTID$18);
    } 
  }
  
  public String getFormula() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORMULA$20);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetFormula() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(FORMULA$20);
      return sTXstring;
    } 
  }
  
  public boolean isSetFormula() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FORMULA$20) != null);
    } 
  }
  
  public void setFormula(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORMULA$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FORMULA$20); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetFormula(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(FORMULA$20);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(FORMULA$20); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetFormula() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FORMULA$20);
    } 
  }
  
  public int getSqlType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SQLTYPE$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SQLTYPE$22); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetSqlType() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(SQLTYPE$22);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_default_attribute_value(SQLTYPE$22); 
      return xmlInt;
    } 
  }
  
  public boolean isSetSqlType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SQLTYPE$22) != null);
    } 
  }
  
  public void setSqlType(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SQLTYPE$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SQLTYPE$22); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetSqlType(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(SQLTYPE$22);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_attribute_user(SQLTYPE$22); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetSqlType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SQLTYPE$22);
    } 
  }
  
  public int getHierarchy() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIERARCHY$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(HIERARCHY$24); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetHierarchy() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(HIERARCHY$24);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_default_attribute_value(HIERARCHY$24); 
      return xmlInt;
    } 
  }
  
  public boolean isSetHierarchy() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HIERARCHY$24) != null);
    } 
  }
  
  public void setHierarchy(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIERARCHY$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HIERARCHY$24); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetHierarchy(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(HIERARCHY$24);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_attribute_user(HIERARCHY$24); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetHierarchy() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HIERARCHY$24);
    } 
  }
  
  public long getLevel() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LEVEL$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(LEVEL$26); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetLevel() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(LEVEL$26);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(LEVEL$26); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetLevel() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LEVEL$26) != null);
    } 
  }
  
  public void setLevel(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LEVEL$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LEVEL$26); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetLevel(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(LEVEL$26);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(LEVEL$26); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetLevel() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LEVEL$26);
    } 
  }
  
  public boolean getDatabaseField() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATABASEFIELD$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DATABASEFIELD$28); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDatabaseField() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DATABASEFIELD$28);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DATABASEFIELD$28); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDatabaseField() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DATABASEFIELD$28) != null);
    } 
  }
  
  public void setDatabaseField(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATABASEFIELD$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DATABASEFIELD$28); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDatabaseField(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DATABASEFIELD$28);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DATABASEFIELD$28); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDatabaseField() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DATABASEFIELD$28);
    } 
  }
  
  public long getMappingCount() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MAPPINGCOUNT$30);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetMappingCount() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MAPPINGCOUNT$30);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetMappingCount() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MAPPINGCOUNT$30) != null);
    } 
  }
  
  public void setMappingCount(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MAPPINGCOUNT$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MAPPINGCOUNT$30); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetMappingCount(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MAPPINGCOUNT$30);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(MAPPINGCOUNT$30); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetMappingCount() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MAPPINGCOUNT$30);
    } 
  }
  
  public boolean getMemberPropertyField() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MEMBERPROPERTYFIELD$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(MEMBERPROPERTYFIELD$32); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetMemberPropertyField() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MEMBERPROPERTYFIELD$32);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(MEMBERPROPERTYFIELD$32); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetMemberPropertyField() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MEMBERPROPERTYFIELD$32) != null);
    } 
  }
  
  public void setMemberPropertyField(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MEMBERPROPERTYFIELD$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MEMBERPROPERTYFIELD$32); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetMemberPropertyField(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MEMBERPROPERTYFIELD$32);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(MEMBERPROPERTYFIELD$32); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetMemberPropertyField() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MEMBERPROPERTYFIELD$32);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTCacheFieldImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */