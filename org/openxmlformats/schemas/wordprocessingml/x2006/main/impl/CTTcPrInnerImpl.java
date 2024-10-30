package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCellMergeTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrInner;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

public class CTTcPrInnerImpl extends CTTcPrBaseImpl implements CTTcPrInner {
  private static final b CELLINS$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cellIns");
  
  private static final b CELLDEL$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cellDel");
  
  private static final b CELLMERGE$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cellMerge");
  
  public CTTcPrInnerImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTrackChange getCellIns() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(CELLINS$0, 0);
      if (cTTrackChange == null)
        return null; 
      return cTTrackChange;
    } 
  }
  
  public boolean isSetCellIns() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CELLINS$0) != 0);
    } 
  }
  
  public void setCellIns(CTTrackChange paramCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(CELLINS$0, 0);
      if (cTTrackChange == null)
        cTTrackChange = (CTTrackChange)get_store().add_element_user(CELLINS$0); 
      cTTrackChange.set((XmlObject)paramCTTrackChange);
    } 
  }
  
  public CTTrackChange addNewCellIns() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().add_element_user(CELLINS$0);
      return cTTrackChange;
    } 
  }
  
  public void unsetCellIns() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CELLINS$0, 0);
    } 
  }
  
  public CTTrackChange getCellDel() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(CELLDEL$2, 0);
      if (cTTrackChange == null)
        return null; 
      return cTTrackChange;
    } 
  }
  
  public boolean isSetCellDel() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CELLDEL$2) != 0);
    } 
  }
  
  public void setCellDel(CTTrackChange paramCTTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().find_element_user(CELLDEL$2, 0);
      if (cTTrackChange == null)
        cTTrackChange = (CTTrackChange)get_store().add_element_user(CELLDEL$2); 
      cTTrackChange.set((XmlObject)paramCTTrackChange);
    } 
  }
  
  public CTTrackChange addNewCellDel() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrackChange cTTrackChange = null;
      cTTrackChange = (CTTrackChange)get_store().add_element_user(CELLDEL$2);
      return cTTrackChange;
    } 
  }
  
  public void unsetCellDel() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CELLDEL$2, 0);
    } 
  }
  
  public CTCellMergeTrackChange getCellMerge() {
    synchronized (monitor()) {
      check_orphaned();
      CTCellMergeTrackChange cTCellMergeTrackChange = null;
      cTCellMergeTrackChange = (CTCellMergeTrackChange)get_store().find_element_user(CELLMERGE$4, 0);
      if (cTCellMergeTrackChange == null)
        return null; 
      return cTCellMergeTrackChange;
    } 
  }
  
  public boolean isSetCellMerge() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CELLMERGE$4) != 0);
    } 
  }
  
  public void setCellMerge(CTCellMergeTrackChange paramCTCellMergeTrackChange) {
    synchronized (monitor()) {
      check_orphaned();
      CTCellMergeTrackChange cTCellMergeTrackChange = null;
      cTCellMergeTrackChange = (CTCellMergeTrackChange)get_store().find_element_user(CELLMERGE$4, 0);
      if (cTCellMergeTrackChange == null)
        cTCellMergeTrackChange = (CTCellMergeTrackChange)get_store().add_element_user(CELLMERGE$4); 
      cTCellMergeTrackChange.set((XmlObject)paramCTCellMergeTrackChange);
    } 
  }
  
  public CTCellMergeTrackChange addNewCellMerge() {
    synchronized (monitor()) {
      check_orphaned();
      CTCellMergeTrackChange cTCellMergeTrackChange = null;
      cTCellMergeTrackChange = (CTCellMergeTrackChange)get_store().add_element_user(CELLMERGE$4);
      return cTCellMergeTrackChange;
    } 
  }
  
  public void unsetCellMerge() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CELLMERGE$4, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTTcPrInnerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */