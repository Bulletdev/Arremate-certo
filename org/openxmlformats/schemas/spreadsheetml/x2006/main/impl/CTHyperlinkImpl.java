package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STRef;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTHyperlinkImpl extends XmlComplexContentImpl implements CTHyperlink {
  private static final b REF$0 = new b("", "ref");
  
  private static final b ID$2 = new b("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "id");
  
  private static final b LOCATION$4 = new b("", "location");
  
  private static final b TOOLTIP$6 = new b("", "tooltip");
  
  private static final b DISPLAY$8 = new b("", "display");
  
  public CTHyperlinkImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getRef() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REF$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STRef xgetRef() {
    synchronized (monitor()) {
      check_orphaned();
      STRef sTRef = null;
      sTRef = (STRef)get_store().find_attribute_user(REF$0);
      return sTRef;
    } 
  }
  
  public void setRef(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REF$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(REF$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetRef(STRef paramSTRef) {
    synchronized (monitor()) {
      check_orphaned();
      STRef sTRef = null;
      sTRef = (STRef)get_store().find_attribute_user(REF$0);
      if (sTRef == null)
        sTRef = (STRef)get_store().add_attribute_user(REF$0); 
      sTRef.set((XmlObject)paramSTRef);
    } 
  }
  
  public String getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STRelationshipId xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(ID$2);
      return sTRelationshipId;
    } 
  }
  
  public boolean isSetId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ID$2) != null);
    } 
  }
  
  public void setId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetId(STRelationshipId paramSTRelationshipId) {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(ID$2);
      if (sTRelationshipId == null)
        sTRelationshipId = (STRelationshipId)get_store().add_attribute_user(ID$2); 
      sTRelationshipId.set((XmlObject)paramSTRelationshipId);
    } 
  }
  
  public void unsetId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ID$2);
    } 
  }
  
  public String getLocation() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LOCATION$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetLocation() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(LOCATION$4);
      return sTXstring;
    } 
  }
  
  public boolean isSetLocation() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LOCATION$4) != null);
    } 
  }
  
  public void setLocation(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LOCATION$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LOCATION$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetLocation(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(LOCATION$4);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(LOCATION$4); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetLocation() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LOCATION$4);
    } 
  }
  
  public String getTooltip() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOOLTIP$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetTooltip() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(TOOLTIP$6);
      return sTXstring;
    } 
  }
  
  public boolean isSetTooltip() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TOOLTIP$6) != null);
    } 
  }
  
  public void setTooltip(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOOLTIP$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TOOLTIP$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTooltip(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(TOOLTIP$6);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(TOOLTIP$6); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetTooltip() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TOOLTIP$6);
    } 
  }
  
  public String getDisplay() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISPLAY$8);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetDisplay() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(DISPLAY$8);
      return sTXstring;
    } 
  }
  
  public boolean isSetDisplay() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DISPLAY$8) != null);
    } 
  }
  
  public void setDisplay(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DISPLAY$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DISPLAY$8); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetDisplay(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(DISPLAY$8);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(DISPLAY$8); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetDisplay() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DISPLAY$8);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTHyperlinkImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */