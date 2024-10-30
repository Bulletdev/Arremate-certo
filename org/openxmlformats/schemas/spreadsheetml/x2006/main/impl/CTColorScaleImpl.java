package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfvo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale;

public class CTColorScaleImpl extends XmlComplexContentImpl implements CTColorScale {
  private static final b CFVO$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cfvo");
  
  private static final b COLOR$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "color");
  
  public CTColorScaleImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTCfvo> getCfvoList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTCfvo>)new CfvoList(this);
    } 
  }
  
  public CTCfvo[] getCfvoArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CFVO$0, arrayList);
      CTCfvo[] arrayOfCTCfvo = new CTCfvo[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTCfvo);
      return arrayOfCTCfvo;
    } 
  }
  
  public CTCfvo getCfvoArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCfvo cTCfvo = null;
      cTCfvo = (CTCfvo)get_store().find_element_user(CFVO$0, paramInt);
      if (cTCfvo == null)
        throw new IndexOutOfBoundsException(); 
      return cTCfvo;
    } 
  }
  
  public int sizeOfCfvoArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CFVO$0);
    } 
  }
  
  public void setCfvoArray(CTCfvo[] paramArrayOfCTCfvo) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTCfvo, CFVO$0);
    } 
  }
  
  public void setCfvoArray(int paramInt, CTCfvo paramCTCfvo) {
    synchronized (monitor()) {
      check_orphaned();
      CTCfvo cTCfvo = null;
      cTCfvo = (CTCfvo)get_store().find_element_user(CFVO$0, paramInt);
      if (cTCfvo == null)
        throw new IndexOutOfBoundsException(); 
      cTCfvo.set((XmlObject)paramCTCfvo);
    } 
  }
  
  public CTCfvo insertNewCfvo(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCfvo cTCfvo = null;
      cTCfvo = (CTCfvo)get_store().insert_element_user(CFVO$0, paramInt);
      return cTCfvo;
    } 
  }
  
  public CTCfvo addNewCfvo() {
    synchronized (monitor()) {
      check_orphaned();
      CTCfvo cTCfvo = null;
      cTCfvo = (CTCfvo)get_store().add_element_user(CFVO$0);
      return cTCfvo;
    } 
  }
  
  public void removeCfvo(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CFVO$0, paramInt);
    } 
  }
  
  public List<CTColor> getColorList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTColor>)new ColorList(this);
    } 
  }
  
  public CTColor[] getColorArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(COLOR$2, arrayList);
      CTColor[] arrayOfCTColor = new CTColor[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTColor);
      return arrayOfCTColor;
    } 
  }
  
  public CTColor getColorArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(COLOR$2, paramInt);
      if (cTColor == null)
        throw new IndexOutOfBoundsException(); 
      return cTColor;
    } 
  }
  
  public int sizeOfColorArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(COLOR$2);
    } 
  }
  
  public void setColorArray(CTColor[] paramArrayOfCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTColor, COLOR$2);
    } 
  }
  
  public void setColorArray(int paramInt, CTColor paramCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(COLOR$2, paramInt);
      if (cTColor == null)
        throw new IndexOutOfBoundsException(); 
      cTColor.set((XmlObject)paramCTColor);
    } 
  }
  
  public CTColor insertNewColor(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().insert_element_user(COLOR$2, paramInt);
      return cTColor;
    } 
  }
  
  public CTColor addNewColor() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().add_element_user(COLOR$2);
      return cTColor;
    } 
  }
  
  public void removeColor(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COLOR$2, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTColorScaleImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */