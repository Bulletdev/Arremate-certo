package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAbsoluteAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTOneCellAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor;

public class CTDrawingImpl extends XmlComplexContentImpl implements CTDrawing {
  private static final b TWOCELLANCHOR$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "twoCellAnchor");
  
  private static final b ONECELLANCHOR$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "oneCellAnchor");
  
  private static final b ABSOLUTEANCHOR$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "absoluteAnchor");
  
  public CTDrawingImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTTwoCellAnchor> getTwoCellAnchorList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTwoCellAnchor>)new TwoCellAnchorList(this);
    } 
  }
  
  public CTTwoCellAnchor[] getTwoCellAnchorArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TWOCELLANCHOR$0, arrayList);
      CTTwoCellAnchor[] arrayOfCTTwoCellAnchor = new CTTwoCellAnchor[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTwoCellAnchor);
      return arrayOfCTTwoCellAnchor;
    } 
  }
  
  public CTTwoCellAnchor getTwoCellAnchorArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTwoCellAnchor cTTwoCellAnchor = null;
      cTTwoCellAnchor = (CTTwoCellAnchor)get_store().find_element_user(TWOCELLANCHOR$0, paramInt);
      if (cTTwoCellAnchor == null)
        throw new IndexOutOfBoundsException(); 
      return cTTwoCellAnchor;
    } 
  }
  
  public int sizeOfTwoCellAnchorArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TWOCELLANCHOR$0);
    } 
  }
  
  public void setTwoCellAnchorArray(CTTwoCellAnchor[] paramArrayOfCTTwoCellAnchor) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTwoCellAnchor, TWOCELLANCHOR$0);
    } 
  }
  
  public void setTwoCellAnchorArray(int paramInt, CTTwoCellAnchor paramCTTwoCellAnchor) {
    synchronized (monitor()) {
      check_orphaned();
      CTTwoCellAnchor cTTwoCellAnchor = null;
      cTTwoCellAnchor = (CTTwoCellAnchor)get_store().find_element_user(TWOCELLANCHOR$0, paramInt);
      if (cTTwoCellAnchor == null)
        throw new IndexOutOfBoundsException(); 
      cTTwoCellAnchor.set((XmlObject)paramCTTwoCellAnchor);
    } 
  }
  
  public CTTwoCellAnchor insertNewTwoCellAnchor(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTwoCellAnchor cTTwoCellAnchor = null;
      cTTwoCellAnchor = (CTTwoCellAnchor)get_store().insert_element_user(TWOCELLANCHOR$0, paramInt);
      return cTTwoCellAnchor;
    } 
  }
  
  public CTTwoCellAnchor addNewTwoCellAnchor() {
    synchronized (monitor()) {
      check_orphaned();
      CTTwoCellAnchor cTTwoCellAnchor = null;
      cTTwoCellAnchor = (CTTwoCellAnchor)get_store().add_element_user(TWOCELLANCHOR$0);
      return cTTwoCellAnchor;
    } 
  }
  
  public void removeTwoCellAnchor(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TWOCELLANCHOR$0, paramInt);
    } 
  }
  
  public List<CTOneCellAnchor> getOneCellAnchorList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTOneCellAnchor>)new OneCellAnchorList(this);
    } 
  }
  
  public CTOneCellAnchor[] getOneCellAnchorArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ONECELLANCHOR$2, arrayList);
      CTOneCellAnchor[] arrayOfCTOneCellAnchor = new CTOneCellAnchor[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTOneCellAnchor);
      return arrayOfCTOneCellAnchor;
    } 
  }
  
  public CTOneCellAnchor getOneCellAnchorArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOneCellAnchor cTOneCellAnchor = null;
      cTOneCellAnchor = (CTOneCellAnchor)get_store().find_element_user(ONECELLANCHOR$2, paramInt);
      if (cTOneCellAnchor == null)
        throw new IndexOutOfBoundsException(); 
      return cTOneCellAnchor;
    } 
  }
  
  public int sizeOfOneCellAnchorArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ONECELLANCHOR$2);
    } 
  }
  
  public void setOneCellAnchorArray(CTOneCellAnchor[] paramArrayOfCTOneCellAnchor) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTOneCellAnchor, ONECELLANCHOR$2);
    } 
  }
  
  public void setOneCellAnchorArray(int paramInt, CTOneCellAnchor paramCTOneCellAnchor) {
    synchronized (monitor()) {
      check_orphaned();
      CTOneCellAnchor cTOneCellAnchor = null;
      cTOneCellAnchor = (CTOneCellAnchor)get_store().find_element_user(ONECELLANCHOR$2, paramInt);
      if (cTOneCellAnchor == null)
        throw new IndexOutOfBoundsException(); 
      cTOneCellAnchor.set((XmlObject)paramCTOneCellAnchor);
    } 
  }
  
  public CTOneCellAnchor insertNewOneCellAnchor(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOneCellAnchor cTOneCellAnchor = null;
      cTOneCellAnchor = (CTOneCellAnchor)get_store().insert_element_user(ONECELLANCHOR$2, paramInt);
      return cTOneCellAnchor;
    } 
  }
  
  public CTOneCellAnchor addNewOneCellAnchor() {
    synchronized (monitor()) {
      check_orphaned();
      CTOneCellAnchor cTOneCellAnchor = null;
      cTOneCellAnchor = (CTOneCellAnchor)get_store().add_element_user(ONECELLANCHOR$2);
      return cTOneCellAnchor;
    } 
  }
  
  public void removeOneCellAnchor(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ONECELLANCHOR$2, paramInt);
    } 
  }
  
  public List<CTAbsoluteAnchor> getAbsoluteAnchorList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTAbsoluteAnchor>)new AbsoluteAnchorList(this);
    } 
  }
  
  public CTAbsoluteAnchor[] getAbsoluteAnchorArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ABSOLUTEANCHOR$4, arrayList);
      CTAbsoluteAnchor[] arrayOfCTAbsoluteAnchor = new CTAbsoluteAnchor[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTAbsoluteAnchor);
      return arrayOfCTAbsoluteAnchor;
    } 
  }
  
  public CTAbsoluteAnchor getAbsoluteAnchorArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAbsoluteAnchor cTAbsoluteAnchor = null;
      cTAbsoluteAnchor = (CTAbsoluteAnchor)get_store().find_element_user(ABSOLUTEANCHOR$4, paramInt);
      if (cTAbsoluteAnchor == null)
        throw new IndexOutOfBoundsException(); 
      return cTAbsoluteAnchor;
    } 
  }
  
  public int sizeOfAbsoluteAnchorArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ABSOLUTEANCHOR$4);
    } 
  }
  
  public void setAbsoluteAnchorArray(CTAbsoluteAnchor[] paramArrayOfCTAbsoluteAnchor) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTAbsoluteAnchor, ABSOLUTEANCHOR$4);
    } 
  }
  
  public void setAbsoluteAnchorArray(int paramInt, CTAbsoluteAnchor paramCTAbsoluteAnchor) {
    synchronized (monitor()) {
      check_orphaned();
      CTAbsoluteAnchor cTAbsoluteAnchor = null;
      cTAbsoluteAnchor = (CTAbsoluteAnchor)get_store().find_element_user(ABSOLUTEANCHOR$4, paramInt);
      if (cTAbsoluteAnchor == null)
        throw new IndexOutOfBoundsException(); 
      cTAbsoluteAnchor.set((XmlObject)paramCTAbsoluteAnchor);
    } 
  }
  
  public CTAbsoluteAnchor insertNewAbsoluteAnchor(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAbsoluteAnchor cTAbsoluteAnchor = null;
      cTAbsoluteAnchor = (CTAbsoluteAnchor)get_store().insert_element_user(ABSOLUTEANCHOR$4, paramInt);
      return cTAbsoluteAnchor;
    } 
  }
  
  public CTAbsoluteAnchor addNewAbsoluteAnchor() {
    synchronized (monitor()) {
      check_orphaned();
      CTAbsoluteAnchor cTAbsoluteAnchor = null;
      cTAbsoluteAnchor = (CTAbsoluteAnchor)get_store().add_element_user(ABSOLUTEANCHOR$4);
      return cTAbsoluteAnchor;
    } 
  }
  
  public void removeAbsoluteAnchor(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ABSOLUTEANCHOR$4, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\spreadsheetDrawing\impl\CTDrawingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */