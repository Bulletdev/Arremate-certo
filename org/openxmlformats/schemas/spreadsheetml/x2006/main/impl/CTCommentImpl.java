package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STGuid;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STRef;

public class CTCommentImpl extends XmlComplexContentImpl implements CTComment {
  private static final b TEXT$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "text");
  
  private static final b REF$2 = new b("", "ref");
  
  private static final b AUTHORID$4 = new b("", "authorId");
  
  private static final b GUID$6 = new b("", "guid");
  
  public CTCommentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTRst getText() {
    synchronized (monitor()) {
      check_orphaned();
      CTRst cTRst = null;
      cTRst = (CTRst)get_store().find_element_user(TEXT$0, 0);
      if (cTRst == null)
        return null; 
      return cTRst;
    } 
  }
  
  public void setText(CTRst paramCTRst) {
    synchronized (monitor()) {
      check_orphaned();
      CTRst cTRst = null;
      cTRst = (CTRst)get_store().find_element_user(TEXT$0, 0);
      if (cTRst == null)
        cTRst = (CTRst)get_store().add_element_user(TEXT$0); 
      cTRst.set((XmlObject)paramCTRst);
    } 
  }
  
  public CTRst addNewText() {
    synchronized (monitor()) {
      check_orphaned();
      CTRst cTRst = null;
      cTRst = (CTRst)get_store().add_element_user(TEXT$0);
      return cTRst;
    } 
  }
  
  public String getRef() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REF$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STRef xgetRef() {
    synchronized (monitor()) {
      check_orphaned();
      STRef sTRef = null;
      sTRef = (STRef)get_store().find_attribute_user(REF$2);
      return sTRef;
    } 
  }
  
  public void setRef(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REF$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(REF$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetRef(STRef paramSTRef) {
    synchronized (monitor()) {
      check_orphaned();
      STRef sTRef = null;
      sTRef = (STRef)get_store().find_attribute_user(REF$2);
      if (sTRef == null)
        sTRef = (STRef)get_store().add_attribute_user(REF$2); 
      sTRef.set((XmlObject)paramSTRef);
    } 
  }
  
  public long getAuthorId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTHORID$4);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetAuthorId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(AUTHORID$4);
      return xmlUnsignedInt;
    } 
  }
  
  public void setAuthorId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTHORID$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(AUTHORID$4); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetAuthorId(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(AUTHORID$4);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(AUTHORID$4); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public String getGuid() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(GUID$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STGuid xgetGuid() {
    synchronized (monitor()) {
      check_orphaned();
      STGuid sTGuid = null;
      sTGuid = (STGuid)get_store().find_attribute_user(GUID$6);
      return sTGuid;
    } 
  }
  
  public boolean isSetGuid() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(GUID$6) != null);
    } 
  }
  
  public void setGuid(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(GUID$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(GUID$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetGuid(STGuid paramSTGuid) {
    synchronized (monitor()) {
      check_orphaned();
      STGuid sTGuid = null;
      sTGuid = (STGuid)get_store().find_attribute_user(GUID$6);
      if (sTGuid == null)
        sTGuid = (STGuid)get_store().add_attribute_user(GUID$6); 
      sTGuid.set((XmlObject)paramSTGuid);
    } 
  }
  
  public void unsetGuid() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(GUID$6);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTCommentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */