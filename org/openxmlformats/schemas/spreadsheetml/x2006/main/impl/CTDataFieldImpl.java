package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataConsolidateFunction;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STNumFmtId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STShowDataAs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTDataFieldImpl extends XmlComplexContentImpl implements CTDataField {
  private static final b EXTLST$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  private static final b NAME$2 = new b("", "name");
  
  private static final b FLD$4 = new b("", "fld");
  
  private static final b SUBTOTAL$6 = new b("", "subtotal");
  
  private static final b SHOWDATAAS$8 = new b("", "showDataAs");
  
  private static final b BASEFIELD$10 = new b("", "baseField");
  
  private static final b BASEITEM$12 = new b("", "baseItem");
  
  private static final b NUMFMTID$14 = new b("", "numFmtId");
  
  public CTDataFieldImpl(SchemaType paramSchemaType) {
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
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(NAME$2);
      return sTXstring;
    } 
  }
  
  public boolean isSetName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NAME$2) != null);
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(NAME$2);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(NAME$2); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NAME$2);
    } 
  }
  
  public long getFld() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FLD$4);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetFld() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(FLD$4);
      return xmlUnsignedInt;
    } 
  }
  
  public void setFld(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FLD$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FLD$4); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetFld(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(FLD$4);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(FLD$4); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public STDataConsolidateFunction.Enum getSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SUBTOTAL$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SUBTOTAL$6); 
      if (simpleValue == null)
        return null; 
      return (STDataConsolidateFunction.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STDataConsolidateFunction xgetSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      STDataConsolidateFunction sTDataConsolidateFunction = null;
      sTDataConsolidateFunction = (STDataConsolidateFunction)get_store().find_attribute_user(SUBTOTAL$6);
      if (sTDataConsolidateFunction == null)
        sTDataConsolidateFunction = (STDataConsolidateFunction)get_default_attribute_value(SUBTOTAL$6); 
      return sTDataConsolidateFunction;
    } 
  }
  
  public boolean isSetSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SUBTOTAL$6) != null);
    } 
  }
  
  public void setSubtotal(STDataConsolidateFunction.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SUBTOTAL$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SUBTOTAL$6); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetSubtotal(STDataConsolidateFunction paramSTDataConsolidateFunction) {
    synchronized (monitor()) {
      check_orphaned();
      STDataConsolidateFunction sTDataConsolidateFunction = null;
      sTDataConsolidateFunction = (STDataConsolidateFunction)get_store().find_attribute_user(SUBTOTAL$6);
      if (sTDataConsolidateFunction == null)
        sTDataConsolidateFunction = (STDataConsolidateFunction)get_store().add_attribute_user(SUBTOTAL$6); 
      sTDataConsolidateFunction.set((XmlObject)paramSTDataConsolidateFunction);
    } 
  }
  
  public void unsetSubtotal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SUBTOTAL$6);
    } 
  }
  
  public STShowDataAs.Enum getShowDataAs() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWDATAAS$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWDATAAS$8); 
      if (simpleValue == null)
        return null; 
      return (STShowDataAs.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STShowDataAs xgetShowDataAs() {
    synchronized (monitor()) {
      check_orphaned();
      STShowDataAs sTShowDataAs = null;
      sTShowDataAs = (STShowDataAs)get_store().find_attribute_user(SHOWDATAAS$8);
      if (sTShowDataAs == null)
        sTShowDataAs = (STShowDataAs)get_default_attribute_value(SHOWDATAAS$8); 
      return sTShowDataAs;
    } 
  }
  
  public boolean isSetShowDataAs() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWDATAAS$8) != null);
    } 
  }
  
  public void setShowDataAs(STShowDataAs.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWDATAAS$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWDATAAS$8); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetShowDataAs(STShowDataAs paramSTShowDataAs) {
    synchronized (monitor()) {
      check_orphaned();
      STShowDataAs sTShowDataAs = null;
      sTShowDataAs = (STShowDataAs)get_store().find_attribute_user(SHOWDATAAS$8);
      if (sTShowDataAs == null)
        sTShowDataAs = (STShowDataAs)get_store().add_attribute_user(SHOWDATAAS$8); 
      sTShowDataAs.set((XmlObject)paramSTShowDataAs);
    } 
  }
  
  public void unsetShowDataAs() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWDATAAS$8);
    } 
  }
  
  public int getBaseField() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BASEFIELD$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(BASEFIELD$10); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetBaseField() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(BASEFIELD$10);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_default_attribute_value(BASEFIELD$10); 
      return xmlInt;
    } 
  }
  
  public boolean isSetBaseField() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BASEFIELD$10) != null);
    } 
  }
  
  public void setBaseField(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BASEFIELD$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BASEFIELD$10); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetBaseField(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(BASEFIELD$10);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_attribute_user(BASEFIELD$10); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetBaseField() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BASEFIELD$10);
    } 
  }
  
  public long getBaseItem() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BASEITEM$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(BASEITEM$12); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetBaseItem() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(BASEITEM$12);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(BASEITEM$12); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetBaseItem() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BASEITEM$12) != null);
    } 
  }
  
  public void setBaseItem(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BASEITEM$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BASEITEM$12); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetBaseItem(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(BASEITEM$12);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(BASEITEM$12); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetBaseItem() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BASEITEM$12);
    } 
  }
  
  public long getNumFmtId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NUMFMTID$14);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STNumFmtId xgetNumFmtId() {
    synchronized (monitor()) {
      check_orphaned();
      STNumFmtId sTNumFmtId = null;
      sTNumFmtId = (STNumFmtId)get_store().find_attribute_user(NUMFMTID$14);
      return sTNumFmtId;
    } 
  }
  
  public boolean isSetNumFmtId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NUMFMTID$14) != null);
    } 
  }
  
  public void setNumFmtId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NUMFMTID$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NUMFMTID$14); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetNumFmtId(STNumFmtId paramSTNumFmtId) {
    synchronized (monitor()) {
      check_orphaned();
      STNumFmtId sTNumFmtId = null;
      sTNumFmtId = (STNumFmtId)get_store().find_attribute_user(NUMFMTID$14);
      if (sTNumFmtId == null)
        sTNumFmtId = (STNumFmtId)get_store().add_attribute_user(NUMFMTID$14); 
      sTNumFmtId.set((XmlObject)paramSTNumFmtId);
    } 
  }
  
  public void unsetNumFmtId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NUMFMTID$14);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTDataFieldImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */