package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;
import org.openxmlformats.schemas.drawingml.x2006.chart.STXstring;

public class CTNumDataImpl extends XmlComplexContentImpl implements CTNumData {
  private static final b FORMATCODE$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "formatCode");
  
  private static final b PTCOUNT$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "ptCount");
  
  private static final b PT$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "pt");
  
  private static final b EXTLST$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");
  
  public CTNumDataImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getFormatCode() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FORMATCODE$0, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetFormatCode() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(FORMATCODE$0, 0);
      return sTXstring;
    } 
  }
  
  public boolean isSetFormatCode() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FORMATCODE$0) != 0);
    } 
  }
  
  public void setFormatCode(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FORMATCODE$0, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(FORMATCODE$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetFormatCode(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_element_user(FORMATCODE$0, 0);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_element_user(FORMATCODE$0); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetFormatCode() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FORMATCODE$0, 0);
    } 
  }
  
  public CTUnsignedInt getPtCount() {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().find_element_user(PTCOUNT$2, 0);
      if (cTUnsignedInt == null)
        return null; 
      return cTUnsignedInt;
    } 
  }
  
  public boolean isSetPtCount() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PTCOUNT$2) != 0);
    } 
  }
  
  public void setPtCount(CTUnsignedInt paramCTUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().find_element_user(PTCOUNT$2, 0);
      if (cTUnsignedInt == null)
        cTUnsignedInt = (CTUnsignedInt)get_store().add_element_user(PTCOUNT$2); 
      cTUnsignedInt.set((XmlObject)paramCTUnsignedInt);
    } 
  }
  
  public CTUnsignedInt addNewPtCount() {
    synchronized (monitor()) {
      check_orphaned();
      CTUnsignedInt cTUnsignedInt = null;
      cTUnsignedInt = (CTUnsignedInt)get_store().add_element_user(PTCOUNT$2);
      return cTUnsignedInt;
    } 
  }
  
  public void unsetPtCount() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PTCOUNT$2, 0);
    } 
  }
  
  public List<CTNumVal> getPtList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTNumVal>)new PtList(this);
    } 
  }
  
  public CTNumVal[] getPtArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PT$4, arrayList);
      CTNumVal[] arrayOfCTNumVal = new CTNumVal[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTNumVal);
      return arrayOfCTNumVal;
    } 
  }
  
  public CTNumVal getPtArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumVal cTNumVal = null;
      cTNumVal = (CTNumVal)get_store().find_element_user(PT$4, paramInt);
      if (cTNumVal == null)
        throw new IndexOutOfBoundsException(); 
      return cTNumVal;
    } 
  }
  
  public int sizeOfPtArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PT$4);
    } 
  }
  
  public void setPtArray(CTNumVal[] paramArrayOfCTNumVal) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTNumVal, PT$4);
    } 
  }
  
  public void setPtArray(int paramInt, CTNumVal paramCTNumVal) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumVal cTNumVal = null;
      cTNumVal = (CTNumVal)get_store().find_element_user(PT$4, paramInt);
      if (cTNumVal == null)
        throw new IndexOutOfBoundsException(); 
      cTNumVal.set((XmlObject)paramCTNumVal);
    } 
  }
  
  public CTNumVal insertNewPt(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumVal cTNumVal = null;
      cTNumVal = (CTNumVal)get_store().insert_element_user(PT$4, paramInt);
      return cTNumVal;
    } 
  }
  
  public CTNumVal addNewPt() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumVal cTNumVal = null;
      cTNumVal = (CTNumVal)get_store().add_element_user(PT$4);
      return cTNumVal;
    } 
  }
  
  public void removePt(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PT$4, paramInt);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$6, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$6) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$6, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$6); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$6);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$6, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTNumDataImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */