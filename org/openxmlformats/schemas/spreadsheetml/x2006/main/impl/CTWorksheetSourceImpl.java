package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheetSource;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STRef;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTWorksheetSourceImpl extends XmlComplexContentImpl implements CTWorksheetSource {
  private static final b REF$0 = new b("", "ref");
  
  private static final b NAME$2 = new b("", "name");
  
  private static final b SHEET$4 = new b("", "sheet");
  
  private static final b ID$6 = new b("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "id");
  
  public CTWorksheetSourceImpl(SchemaType paramSchemaType) {
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
  
  public boolean isSetRef() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(REF$0) != null);
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
  
  public void unsetRef() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(REF$0);
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
  
  public String getSheet() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHEET$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetSheet() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(SHEET$4);
      return sTXstring;
    } 
  }
  
  public boolean isSetSheet() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHEET$4) != null);
    } 
  }
  
  public void setSheet(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHEET$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHEET$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetSheet(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(SHEET$4);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(SHEET$4); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetSheet() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHEET$4);
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
  
  public boolean isSetId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ID$6) != null);
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
  
  public void unsetId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ID$6);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTWorksheetSourceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */