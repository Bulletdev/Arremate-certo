package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnection;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnectorLocking;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;

public class CTNonVisualConnectorPropertiesImpl extends XmlComplexContentImpl implements CTNonVisualConnectorProperties {
  private static final b CXNSPLOCKS$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "cxnSpLocks");
  
  private static final b STCXN$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "stCxn");
  
  private static final b ENDCXN$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "endCxn");
  
  private static final b EXTLST$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  public CTNonVisualConnectorPropertiesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTConnectorLocking getCxnSpLocks() {
    synchronized (monitor()) {
      check_orphaned();
      CTConnectorLocking cTConnectorLocking = null;
      cTConnectorLocking = (CTConnectorLocking)get_store().find_element_user(CXNSPLOCKS$0, 0);
      if (cTConnectorLocking == null)
        return null; 
      return cTConnectorLocking;
    } 
  }
  
  public boolean isSetCxnSpLocks() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CXNSPLOCKS$0) != 0);
    } 
  }
  
  public void setCxnSpLocks(CTConnectorLocking paramCTConnectorLocking) {
    synchronized (monitor()) {
      check_orphaned();
      CTConnectorLocking cTConnectorLocking = null;
      cTConnectorLocking = (CTConnectorLocking)get_store().find_element_user(CXNSPLOCKS$0, 0);
      if (cTConnectorLocking == null)
        cTConnectorLocking = (CTConnectorLocking)get_store().add_element_user(CXNSPLOCKS$0); 
      cTConnectorLocking.set((XmlObject)paramCTConnectorLocking);
    } 
  }
  
  public CTConnectorLocking addNewCxnSpLocks() {
    synchronized (monitor()) {
      check_orphaned();
      CTConnectorLocking cTConnectorLocking = null;
      cTConnectorLocking = (CTConnectorLocking)get_store().add_element_user(CXNSPLOCKS$0);
      return cTConnectorLocking;
    } 
  }
  
  public void unsetCxnSpLocks() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CXNSPLOCKS$0, 0);
    } 
  }
  
  public CTConnection getStCxn() {
    synchronized (monitor()) {
      check_orphaned();
      CTConnection cTConnection = null;
      cTConnection = (CTConnection)get_store().find_element_user(STCXN$2, 0);
      if (cTConnection == null)
        return null; 
      return cTConnection;
    } 
  }
  
  public boolean isSetStCxn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(STCXN$2) != 0);
    } 
  }
  
  public void setStCxn(CTConnection paramCTConnection) {
    synchronized (monitor()) {
      check_orphaned();
      CTConnection cTConnection = null;
      cTConnection = (CTConnection)get_store().find_element_user(STCXN$2, 0);
      if (cTConnection == null)
        cTConnection = (CTConnection)get_store().add_element_user(STCXN$2); 
      cTConnection.set((XmlObject)paramCTConnection);
    } 
  }
  
  public CTConnection addNewStCxn() {
    synchronized (monitor()) {
      check_orphaned();
      CTConnection cTConnection = null;
      cTConnection = (CTConnection)get_store().add_element_user(STCXN$2);
      return cTConnection;
    } 
  }
  
  public void unsetStCxn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STCXN$2, 0);
    } 
  }
  
  public CTConnection getEndCxn() {
    synchronized (monitor()) {
      check_orphaned();
      CTConnection cTConnection = null;
      cTConnection = (CTConnection)get_store().find_element_user(ENDCXN$4, 0);
      if (cTConnection == null)
        return null; 
      return cTConnection;
    } 
  }
  
  public boolean isSetEndCxn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ENDCXN$4) != 0);
    } 
  }
  
  public void setEndCxn(CTConnection paramCTConnection) {
    synchronized (monitor()) {
      check_orphaned();
      CTConnection cTConnection = null;
      cTConnection = (CTConnection)get_store().find_element_user(ENDCXN$4, 0);
      if (cTConnection == null)
        cTConnection = (CTConnection)get_store().add_element_user(ENDCXN$4); 
      cTConnection.set((XmlObject)paramCTConnection);
    } 
  }
  
  public CTConnection addNewEndCxn() {
    synchronized (monitor()) {
      check_orphaned();
      CTConnection cTConnection = null;
      cTConnection = (CTConnection)get_store().add_element_user(ENDCXN$4);
      return cTConnection;
    } 
  }
  
  public void unsetEndCxn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ENDCXN$4, 0);
    } 
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$6, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$6) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$6, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$6); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$6);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$6, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTNonVisualConnectorPropertiesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */