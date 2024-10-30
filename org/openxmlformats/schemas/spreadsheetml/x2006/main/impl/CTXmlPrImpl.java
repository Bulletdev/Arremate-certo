package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXmlPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXmlDataType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTXmlPrImpl extends XmlComplexContentImpl implements CTXmlPr {
  private static final b EXTLST$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  private static final b MAPID$2 = new b("", "mapId");
  
  private static final b XPATH$4 = new b("", "xpath");
  
  private static final b XMLDATATYPE$6 = new b("", "xmlDataType");
  
  public CTXmlPrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$0, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$0) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$0, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$0); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$0);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$0, 0);
    } 
  }
  
  public long getMapId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MAPID$2);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetMapId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MAPID$2);
      return xmlUnsignedInt;
    } 
  }
  
  public void setMapId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MAPID$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MAPID$2); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetMapId(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MAPID$2);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(MAPID$2); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public String getXpath() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(XPATH$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetXpath() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(XPATH$4);
      return sTXstring;
    } 
  }
  
  public void setXpath(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(XPATH$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(XPATH$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetXpath(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(XPATH$4);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(XPATH$4); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public STXmlDataType.Enum getXmlDataType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(XMLDATATYPE$6);
      if (simpleValue == null)
        return null; 
      return (STXmlDataType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STXmlDataType xgetXmlDataType() {
    synchronized (monitor()) {
      check_orphaned();
      STXmlDataType sTXmlDataType = null;
      sTXmlDataType = (STXmlDataType)get_store().find_attribute_user(XMLDATATYPE$6);
      return sTXmlDataType;
    } 
  }
  
  public void setXmlDataType(STXmlDataType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(XMLDATATYPE$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(XMLDATATYPE$6); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetXmlDataType(STXmlDataType paramSTXmlDataType) {
    synchronized (monitor()) {
      check_orphaned();
      STXmlDataType sTXmlDataType = null;
      sTXmlDataType = (STXmlDataType)get_store().find_attribute_user(XMLDATATYPE$6);
      if (sTXmlDataType == null)
        sTXmlDataType = (STXmlDataType)get_store().add_attribute_user(XMLDATATYPE$6); 
      sTXmlDataType.set((XmlObject)paramSTXmlDataType);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTXmlPrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */