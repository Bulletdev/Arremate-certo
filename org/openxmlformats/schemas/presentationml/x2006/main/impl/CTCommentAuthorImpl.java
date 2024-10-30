package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthor;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.presentationml.x2006.main.STName;

public class CTCommentAuthorImpl extends XmlComplexContentImpl implements CTCommentAuthor {
  private static final b EXTLST$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
  
  private static final b ID$2 = new b("", "id");
  
  private static final b NAME$4 = new b("", "name");
  
  private static final b INITIALS$6 = new b("", "initials");
  
  private static final b LASTIDX$8 = new b("", "lastIdx");
  
  private static final b CLRIDX$10 = new b("", "clrIdx");
  
  public CTCommentAuthorImpl(SchemaType paramSchemaType) {
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
  
  public long getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$2);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ID$2);
      return xmlUnsignedInt;
    } 
  }
  
  public void setId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$2); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetId(XmlUnsignedInt paramXmlUnsignedInt) {
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
  
  public STName xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      STName sTName = null;
      sTName = (STName)get_store().find_attribute_user(NAME$4);
      return sTName;
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
  
  public void xsetName(STName paramSTName) {
    synchronized (monitor()) {
      check_orphaned();
      STName sTName = null;
      sTName = (STName)get_store().find_attribute_user(NAME$4);
      if (sTName == null)
        sTName = (STName)get_store().add_attribute_user(NAME$4); 
      sTName.set((XmlObject)paramSTName);
    } 
  }
  
  public String getInitials() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INITIALS$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STName xgetInitials() {
    synchronized (monitor()) {
      check_orphaned();
      STName sTName = null;
      sTName = (STName)get_store().find_attribute_user(INITIALS$6);
      return sTName;
    } 
  }
  
  public void setInitials(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INITIALS$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INITIALS$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetInitials(STName paramSTName) {
    synchronized (monitor()) {
      check_orphaned();
      STName sTName = null;
      sTName = (STName)get_store().find_attribute_user(INITIALS$6);
      if (sTName == null)
        sTName = (STName)get_store().add_attribute_user(INITIALS$6); 
      sTName.set((XmlObject)paramSTName);
    } 
  }
  
  public long getLastIdx() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LASTIDX$8);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetLastIdx() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(LASTIDX$8);
      return xmlUnsignedInt;
    } 
  }
  
  public void setLastIdx(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LASTIDX$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LASTIDX$8); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetLastIdx(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(LASTIDX$8);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(LASTIDX$8); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public long getClrIdx() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CLRIDX$10);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetClrIdx() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(CLRIDX$10);
      return xmlUnsignedInt;
    } 
  }
  
  public void setClrIdx(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CLRIDX$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CLRIDX$10); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetClrIdx(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(CLRIDX$10);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(CLRIDX$10); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTCommentAuthorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */