package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;
import org.openxmlformats.schemas.presentationml.x2006.main.STDirection;
import org.openxmlformats.schemas.presentationml.x2006.main.STPlaceholderSize;
import org.openxmlformats.schemas.presentationml.x2006.main.STPlaceholderType;

public class CTPlaceholderImpl extends XmlComplexContentImpl implements CTPlaceholder {
  private static final b EXTLST$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
  
  private static final b TYPE$2 = new b("", "type");
  
  private static final b ORIENT$4 = new b("", "orient");
  
  private static final b SZ$6 = new b("", "sz");
  
  private static final b IDX$8 = new b("", "idx");
  
  private static final b HASCUSTOMPROMPT$10 = new b("", "hasCustomPrompt");
  
  public CTPlaceholderImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTExtensionListModify getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().find_element_user(EXTLST$0, 0);
      if (cTExtensionListModify == null)
        return null; 
      return cTExtensionListModify;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$0) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionListModify paramCTExtensionListModify) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().find_element_user(EXTLST$0, 0);
      if (cTExtensionListModify == null)
        cTExtensionListModify = (CTExtensionListModify)get_store().add_element_user(EXTLST$0); 
      cTExtensionListModify.set((XmlObject)paramCTExtensionListModify);
    } 
  }
  
  public CTExtensionListModify addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().add_element_user(EXTLST$0);
      return cTExtensionListModify;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$0, 0);
    } 
  }
  
  public STPlaceholderType.Enum getType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(TYPE$2); 
      if (simpleValue == null)
        return null; 
      return (STPlaceholderType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STPlaceholderType xgetType() {
    synchronized (monitor()) {
      check_orphaned();
      STPlaceholderType sTPlaceholderType = null;
      sTPlaceholderType = (STPlaceholderType)get_store().find_attribute_user(TYPE$2);
      if (sTPlaceholderType == null)
        sTPlaceholderType = (STPlaceholderType)get_default_attribute_value(TYPE$2); 
      return sTPlaceholderType;
    } 
  }
  
  public boolean isSetType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TYPE$2) != null);
    } 
  }
  
  public void setType(STPlaceholderType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TYPE$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetType(STPlaceholderType paramSTPlaceholderType) {
    synchronized (monitor()) {
      check_orphaned();
      STPlaceholderType sTPlaceholderType = null;
      sTPlaceholderType = (STPlaceholderType)get_store().find_attribute_user(TYPE$2);
      if (sTPlaceholderType == null)
        sTPlaceholderType = (STPlaceholderType)get_store().add_attribute_user(TYPE$2); 
      sTPlaceholderType.set((XmlObject)paramSTPlaceholderType);
    } 
  }
  
  public void unsetType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TYPE$2);
    } 
  }
  
  public STDirection.Enum getOrient() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ORIENT$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ORIENT$4); 
      if (simpleValue == null)
        return null; 
      return (STDirection.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STDirection xgetOrient() {
    synchronized (monitor()) {
      check_orphaned();
      STDirection sTDirection = null;
      sTDirection = (STDirection)get_store().find_attribute_user(ORIENT$4);
      if (sTDirection == null)
        sTDirection = (STDirection)get_default_attribute_value(ORIENT$4); 
      return sTDirection;
    } 
  }
  
  public boolean isSetOrient() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ORIENT$4) != null);
    } 
  }
  
  public void setOrient(STDirection.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ORIENT$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ORIENT$4); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetOrient(STDirection paramSTDirection) {
    synchronized (monitor()) {
      check_orphaned();
      STDirection sTDirection = null;
      sTDirection = (STDirection)get_store().find_attribute_user(ORIENT$4);
      if (sTDirection == null)
        sTDirection = (STDirection)get_store().add_attribute_user(ORIENT$4); 
      sTDirection.set((XmlObject)paramSTDirection);
    } 
  }
  
  public void unsetOrient() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ORIENT$4);
    } 
  }
  
  public STPlaceholderSize.Enum getSz() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SZ$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SZ$6); 
      if (simpleValue == null)
        return null; 
      return (STPlaceholderSize.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STPlaceholderSize xgetSz() {
    synchronized (monitor()) {
      check_orphaned();
      STPlaceholderSize sTPlaceholderSize = null;
      sTPlaceholderSize = (STPlaceholderSize)get_store().find_attribute_user(SZ$6);
      if (sTPlaceholderSize == null)
        sTPlaceholderSize = (STPlaceholderSize)get_default_attribute_value(SZ$6); 
      return sTPlaceholderSize;
    } 
  }
  
  public boolean isSetSz() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SZ$6) != null);
    } 
  }
  
  public void setSz(STPlaceholderSize.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SZ$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SZ$6); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetSz(STPlaceholderSize paramSTPlaceholderSize) {
    synchronized (monitor()) {
      check_orphaned();
      STPlaceholderSize sTPlaceholderSize = null;
      sTPlaceholderSize = (STPlaceholderSize)get_store().find_attribute_user(SZ$6);
      if (sTPlaceholderSize == null)
        sTPlaceholderSize = (STPlaceholderSize)get_store().add_attribute_user(SZ$6); 
      sTPlaceholderSize.set((XmlObject)paramSTPlaceholderSize);
    } 
  }
  
  public void unsetSz() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SZ$6);
    } 
  }
  
  public long getIdx() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(IDX$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(IDX$8); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetIdx() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(IDX$8);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(IDX$8); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetIdx() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(IDX$8) != null);
    } 
  }
  
  public void setIdx(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(IDX$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(IDX$8); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetIdx(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(IDX$8);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(IDX$8); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetIdx() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(IDX$8);
    } 
  }
  
  public boolean getHasCustomPrompt() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HASCUSTOMPROMPT$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(HASCUSTOMPROMPT$10); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetHasCustomPrompt() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HASCUSTOMPROMPT$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(HASCUSTOMPROMPT$10); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetHasCustomPrompt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HASCUSTOMPROMPT$10) != null);
    } 
  }
  
  public void setHasCustomPrompt(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HASCUSTOMPROMPT$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HASCUSTOMPROMPT$10); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetHasCustomPrompt(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HASCUSTOMPROMPT$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(HASCUSTOMPROMPT$10); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetHasCustomPrompt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HASCUSTOMPROMPT$10);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTPlaceholderImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */