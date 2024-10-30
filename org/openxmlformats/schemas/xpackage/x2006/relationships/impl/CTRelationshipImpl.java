package org.openxmlformats.schemas.xpackage.x2006.relationships.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaStringHolderEx;
import org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship;
import org.openxmlformats.schemas.xpackage.x2006.relationships.STTargetMode;

public class CTRelationshipImpl extends JavaStringHolderEx implements CTRelationship {
  private static final b TARGETMODE$0 = new b("", "TargetMode");
  
  private static final b TARGET$2 = new b("", "Target");
  
  private static final b TYPE$4 = new b("", "Type");
  
  private static final b ID$6 = new b("", "Id");
  
  public CTRelationshipImpl(SchemaType paramSchemaType) {
    super(paramSchemaType, true);
  }
  
  protected CTRelationshipImpl(SchemaType paramSchemaType, boolean paramBoolean) {
    super(paramSchemaType, paramBoolean);
  }
  
  public STTargetMode.Enum getTargetMode() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TARGETMODE$0);
      if (simpleValue == null)
        return null; 
      return (STTargetMode.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTargetMode xgetTargetMode() {
    synchronized (monitor()) {
      check_orphaned();
      STTargetMode sTTargetMode = null;
      sTTargetMode = (STTargetMode)get_store().find_attribute_user(TARGETMODE$0);
      return sTTargetMode;
    } 
  }
  
  public boolean isSetTargetMode() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TARGETMODE$0) != null);
    } 
  }
  
  public void setTargetMode(STTargetMode.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TARGETMODE$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TARGETMODE$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetTargetMode(STTargetMode paramSTTargetMode) {
    synchronized (monitor()) {
      check_orphaned();
      STTargetMode sTTargetMode = null;
      sTTargetMode = (STTargetMode)get_store().find_attribute_user(TARGETMODE$0);
      if (sTTargetMode == null)
        sTTargetMode = (STTargetMode)get_store().add_attribute_user(TARGETMODE$0); 
      sTTargetMode.set((XmlObject)paramSTTargetMode);
    } 
  }
  
  public void unsetTargetMode() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TARGETMODE$0);
    } 
  }
  
  public String getTarget() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TARGET$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlAnyURI xgetTarget() {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(TARGET$2);
      return xmlAnyURI;
    } 
  }
  
  public void setTarget(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TARGET$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TARGET$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTarget(XmlAnyURI paramXmlAnyURI) {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(TARGET$2);
      if (xmlAnyURI == null)
        xmlAnyURI = (XmlAnyURI)get_store().add_attribute_user(TARGET$2); 
      xmlAnyURI.set((XmlObject)paramXmlAnyURI);
    } 
  }
  
  public String getType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlAnyURI xgetType() {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(TYPE$4);
      return xmlAnyURI;
    } 
  }
  
  public void setType(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TYPE$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetType(XmlAnyURI paramXmlAnyURI) {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(TYPE$4);
      if (xmlAnyURI == null)
        xmlAnyURI = (XmlAnyURI)get_store().add_attribute_user(TYPE$4); 
      xmlAnyURI.set((XmlObject)paramXmlAnyURI);
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
  
  public XmlID xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlID xmlID = null;
      xmlID = (XmlID)get_store().find_attribute_user(ID$6);
      return xmlID;
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
  
  public void xsetId(XmlID paramXmlID) {
    synchronized (monitor()) {
      check_orphaned();
      XmlID xmlID = null;
      xmlID = (XmlID)get_store().find_attribute_user(ID$6);
      if (xmlID == null)
        xmlID = (XmlID)get_store().add_attribute_user(ID$6); 
      xmlID.set((XmlObject)paramXmlID);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\xpackage\x2006\relationships\impl\CTRelationshipImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */