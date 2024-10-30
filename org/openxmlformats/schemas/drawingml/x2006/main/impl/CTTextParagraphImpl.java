package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextField;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

public class CTTextParagraphImpl extends XmlComplexContentImpl implements CTTextParagraph {
  private static final b PPR$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "pPr");
  
  private static final b R$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "r");
  
  private static final b BR$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "br");
  
  private static final b FLD$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "fld");
  
  private static final b ENDPARARPR$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "endParaRPr");
  
  public CTTextParagraphImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTextParagraphProperties getPPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(PPR$0, 0);
      if (cTTextParagraphProperties == null)
        return null; 
      return cTTextParagraphProperties;
    } 
  }
  
  public boolean isSetPPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PPR$0) != 0);
    } 
  }
  
  public void setPPr(CTTextParagraphProperties paramCTTextParagraphProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(PPR$0, 0);
      if (cTTextParagraphProperties == null)
        cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(PPR$0); 
      cTTextParagraphProperties.set((XmlObject)paramCTTextParagraphProperties);
    } 
  }
  
  public CTTextParagraphProperties addNewPPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(PPR$0);
      return cTTextParagraphProperties;
    } 
  }
  
  public void unsetPPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PPR$0, 0);
    } 
  }
  
  public List<CTRegularTextRun> getRList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTRegularTextRun>)new RList(this);
    } 
  }
  
  public CTRegularTextRun[] getRArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(R$2, arrayList);
      CTRegularTextRun[] arrayOfCTRegularTextRun = new CTRegularTextRun[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTRegularTextRun);
      return arrayOfCTRegularTextRun;
    } 
  }
  
  public CTRegularTextRun getRArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRegularTextRun cTRegularTextRun = null;
      cTRegularTextRun = (CTRegularTextRun)get_store().find_element_user(R$2, paramInt);
      if (cTRegularTextRun == null)
        throw new IndexOutOfBoundsException(); 
      return cTRegularTextRun;
    } 
  }
  
  public int sizeOfRArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(R$2);
    } 
  }
  
  public void setRArray(CTRegularTextRun[] paramArrayOfCTRegularTextRun) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTRegularTextRun, R$2);
    } 
  }
  
  public void setRArray(int paramInt, CTRegularTextRun paramCTRegularTextRun) {
    synchronized (monitor()) {
      check_orphaned();
      CTRegularTextRun cTRegularTextRun = null;
      cTRegularTextRun = (CTRegularTextRun)get_store().find_element_user(R$2, paramInt);
      if (cTRegularTextRun == null)
        throw new IndexOutOfBoundsException(); 
      cTRegularTextRun.set((XmlObject)paramCTRegularTextRun);
    } 
  }
  
  public CTRegularTextRun insertNewR(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRegularTextRun cTRegularTextRun = null;
      cTRegularTextRun = (CTRegularTextRun)get_store().insert_element_user(R$2, paramInt);
      return cTRegularTextRun;
    } 
  }
  
  public CTRegularTextRun addNewR() {
    synchronized (monitor()) {
      check_orphaned();
      CTRegularTextRun cTRegularTextRun = null;
      cTRegularTextRun = (CTRegularTextRun)get_store().add_element_user(R$2);
      return cTRegularTextRun;
    } 
  }
  
  public void removeR(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(R$2, paramInt);
    } 
  }
  
  public List<CTTextLineBreak> getBrList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTextLineBreak>)new BrList(this);
    } 
  }
  
  public CTTextLineBreak[] getBrArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BR$4, arrayList);
      CTTextLineBreak[] arrayOfCTTextLineBreak = new CTTextLineBreak[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTextLineBreak);
      return arrayOfCTTextLineBreak;
    } 
  }
  
  public CTTextLineBreak getBrArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextLineBreak cTTextLineBreak = null;
      cTTextLineBreak = (CTTextLineBreak)get_store().find_element_user(BR$4, paramInt);
      if (cTTextLineBreak == null)
        throw new IndexOutOfBoundsException(); 
      return cTTextLineBreak;
    } 
  }
  
  public int sizeOfBrArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BR$4);
    } 
  }
  
  public void setBrArray(CTTextLineBreak[] paramArrayOfCTTextLineBreak) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTextLineBreak, BR$4);
    } 
  }
  
  public void setBrArray(int paramInt, CTTextLineBreak paramCTTextLineBreak) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextLineBreak cTTextLineBreak = null;
      cTTextLineBreak = (CTTextLineBreak)get_store().find_element_user(BR$4, paramInt);
      if (cTTextLineBreak == null)
        throw new IndexOutOfBoundsException(); 
      cTTextLineBreak.set((XmlObject)paramCTTextLineBreak);
    } 
  }
  
  public CTTextLineBreak insertNewBr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextLineBreak cTTextLineBreak = null;
      cTTextLineBreak = (CTTextLineBreak)get_store().insert_element_user(BR$4, paramInt);
      return cTTextLineBreak;
    } 
  }
  
  public CTTextLineBreak addNewBr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextLineBreak cTTextLineBreak = null;
      cTTextLineBreak = (CTTextLineBreak)get_store().add_element_user(BR$4);
      return cTTextLineBreak;
    } 
  }
  
  public void removeBr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BR$4, paramInt);
    } 
  }
  
  public List<CTTextField> getFldList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTextField>)new FldList(this);
    } 
  }
  
  public CTTextField[] getFldArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FLD$6, arrayList);
      CTTextField[] arrayOfCTTextField = new CTTextField[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTextField);
      return arrayOfCTTextField;
    } 
  }
  
  public CTTextField getFldArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextField cTTextField = null;
      cTTextField = (CTTextField)get_store().find_element_user(FLD$6, paramInt);
      if (cTTextField == null)
        throw new IndexOutOfBoundsException(); 
      return cTTextField;
    } 
  }
  
  public int sizeOfFldArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FLD$6);
    } 
  }
  
  public void setFldArray(CTTextField[] paramArrayOfCTTextField) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTextField, FLD$6);
    } 
  }
  
  public void setFldArray(int paramInt, CTTextField paramCTTextField) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextField cTTextField = null;
      cTTextField = (CTTextField)get_store().find_element_user(FLD$6, paramInt);
      if (cTTextField == null)
        throw new IndexOutOfBoundsException(); 
      cTTextField.set((XmlObject)paramCTTextField);
    } 
  }
  
  public CTTextField insertNewFld(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextField cTTextField = null;
      cTTextField = (CTTextField)get_store().insert_element_user(FLD$6, paramInt);
      return cTTextField;
    } 
  }
  
  public CTTextField addNewFld() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextField cTTextField = null;
      cTTextField = (CTTextField)get_store().add_element_user(FLD$6);
      return cTTextField;
    } 
  }
  
  public void removeFld(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FLD$6, paramInt);
    } 
  }
  
  public CTTextCharacterProperties getEndParaRPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextCharacterProperties cTTextCharacterProperties = null;
      cTTextCharacterProperties = (CTTextCharacterProperties)get_store().find_element_user(ENDPARARPR$8, 0);
      if (cTTextCharacterProperties == null)
        return null; 
      return cTTextCharacterProperties;
    } 
  }
  
  public boolean isSetEndParaRPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ENDPARARPR$8) != 0);
    } 
  }
  
  public void setEndParaRPr(CTTextCharacterProperties paramCTTextCharacterProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextCharacterProperties cTTextCharacterProperties = null;
      cTTextCharacterProperties = (CTTextCharacterProperties)get_store().find_element_user(ENDPARARPR$8, 0);
      if (cTTextCharacterProperties == null)
        cTTextCharacterProperties = (CTTextCharacterProperties)get_store().add_element_user(ENDPARARPR$8); 
      cTTextCharacterProperties.set((XmlObject)paramCTTextCharacterProperties);
    } 
  }
  
  public CTTextCharacterProperties addNewEndParaRPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextCharacterProperties cTTextCharacterProperties = null;
      cTTextCharacterProperties = (CTTextCharacterProperties)get_store().add_element_user(ENDPARARPR$8);
      return cTTextCharacterProperties;
    } 
  }
  
  public void unsetEndParaRPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ENDPARARPR$8, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTextParagraphImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */