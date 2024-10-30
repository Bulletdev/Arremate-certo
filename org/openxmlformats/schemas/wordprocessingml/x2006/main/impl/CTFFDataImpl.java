package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFDDList;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFHelpText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFName;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFStatusText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFTextInput;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMacroName;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;

public class CTFFDataImpl extends XmlComplexContentImpl implements CTFFData {
  private static final b NAME$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "name");
  
  private static final b ENABLED$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "enabled");
  
  private static final b CALCONEXIT$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "calcOnExit");
  
  private static final b ENTRYMACRO$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "entryMacro");
  
  private static final b EXITMACRO$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "exitMacro");
  
  private static final b HELPTEXT$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "helpText");
  
  private static final b STATUSTEXT$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "statusText");
  
  private static final b CHECKBOX$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "checkBox");
  
  private static final b DDLIST$16 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ddList");
  
  private static final b TEXTINPUT$18 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "textInput");
  
  public CTFFDataImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTFFName> getNameList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTFFName>)new NameList(this);
    } 
  }
  
  public CTFFName[] getNameArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(NAME$0, arrayList);
      CTFFName[] arrayOfCTFFName = new CTFFName[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTFFName);
      return arrayOfCTFFName;
    } 
  }
  
  public CTFFName getNameArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFFName cTFFName = null;
      cTFFName = (CTFFName)get_store().find_element_user(NAME$0, paramInt);
      if (cTFFName == null)
        throw new IndexOutOfBoundsException(); 
      return cTFFName;
    } 
  }
  
  public int sizeOfNameArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(NAME$0);
    } 
  }
  
  public void setNameArray(CTFFName[] paramArrayOfCTFFName) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTFFName, NAME$0);
    } 
  }
  
  public void setNameArray(int paramInt, CTFFName paramCTFFName) {
    synchronized (monitor()) {
      check_orphaned();
      CTFFName cTFFName = null;
      cTFFName = (CTFFName)get_store().find_element_user(NAME$0, paramInt);
      if (cTFFName == null)
        throw new IndexOutOfBoundsException(); 
      cTFFName.set((XmlObject)paramCTFFName);
    } 
  }
  
  public CTFFName insertNewName(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFFName cTFFName = null;
      cTFFName = (CTFFName)get_store().insert_element_user(NAME$0, paramInt);
      return cTFFName;
    } 
  }
  
  public CTFFName addNewName() {
    synchronized (monitor()) {
      check_orphaned();
      CTFFName cTFFName = null;
      cTFFName = (CTFFName)get_store().add_element_user(NAME$0);
      return cTFFName;
    } 
  }
  
  public void removeName(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NAME$0, paramInt);
    } 
  }
  
  public List<CTOnOff> getEnabledList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTOnOff>)new EnabledList(this);
    } 
  }
  
  public CTOnOff[] getEnabledArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ENABLED$2, arrayList);
      CTOnOff[] arrayOfCTOnOff = new CTOnOff[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTOnOff);
      return arrayOfCTOnOff;
    } 
  }
  
  public CTOnOff getEnabledArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(ENABLED$2, paramInt);
      if (cTOnOff == null)
        throw new IndexOutOfBoundsException(); 
      return cTOnOff;
    } 
  }
  
  public int sizeOfEnabledArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ENABLED$2);
    } 
  }
  
  public void setEnabledArray(CTOnOff[] paramArrayOfCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTOnOff, ENABLED$2);
    } 
  }
  
  public void setEnabledArray(int paramInt, CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(ENABLED$2, paramInt);
      if (cTOnOff == null)
        throw new IndexOutOfBoundsException(); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff insertNewEnabled(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().insert_element_user(ENABLED$2, paramInt);
      return cTOnOff;
    } 
  }
  
  public CTOnOff addNewEnabled() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(ENABLED$2);
      return cTOnOff;
    } 
  }
  
  public void removeEnabled(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ENABLED$2, paramInt);
    } 
  }
  
  public List<CTOnOff> getCalcOnExitList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTOnOff>)new CalcOnExitList(this);
    } 
  }
  
  public CTOnOff[] getCalcOnExitArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CALCONEXIT$4, arrayList);
      CTOnOff[] arrayOfCTOnOff = new CTOnOff[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTOnOff);
      return arrayOfCTOnOff;
    } 
  }
  
  public CTOnOff getCalcOnExitArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(CALCONEXIT$4, paramInt);
      if (cTOnOff == null)
        throw new IndexOutOfBoundsException(); 
      return cTOnOff;
    } 
  }
  
  public int sizeOfCalcOnExitArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CALCONEXIT$4);
    } 
  }
  
  public void setCalcOnExitArray(CTOnOff[] paramArrayOfCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTOnOff, CALCONEXIT$4);
    } 
  }
  
  public void setCalcOnExitArray(int paramInt, CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(CALCONEXIT$4, paramInt);
      if (cTOnOff == null)
        throw new IndexOutOfBoundsException(); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff insertNewCalcOnExit(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().insert_element_user(CALCONEXIT$4, paramInt);
      return cTOnOff;
    } 
  }
  
  public CTOnOff addNewCalcOnExit() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(CALCONEXIT$4);
      return cTOnOff;
    } 
  }
  
  public void removeCalcOnExit(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CALCONEXIT$4, paramInt);
    } 
  }
  
  public List<CTMacroName> getEntryMacroList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTMacroName>)new EntryMacroList(this);
    } 
  }
  
  public CTMacroName[] getEntryMacroArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ENTRYMACRO$6, arrayList);
      CTMacroName[] arrayOfCTMacroName = new CTMacroName[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMacroName);
      return arrayOfCTMacroName;
    } 
  }
  
  public CTMacroName getEntryMacroArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMacroName cTMacroName = null;
      cTMacroName = (CTMacroName)get_store().find_element_user(ENTRYMACRO$6, paramInt);
      if (cTMacroName == null)
        throw new IndexOutOfBoundsException(); 
      return cTMacroName;
    } 
  }
  
  public int sizeOfEntryMacroArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ENTRYMACRO$6);
    } 
  }
  
  public void setEntryMacroArray(CTMacroName[] paramArrayOfCTMacroName) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMacroName, ENTRYMACRO$6);
    } 
  }
  
  public void setEntryMacroArray(int paramInt, CTMacroName paramCTMacroName) {
    synchronized (monitor()) {
      check_orphaned();
      CTMacroName cTMacroName = null;
      cTMacroName = (CTMacroName)get_store().find_element_user(ENTRYMACRO$6, paramInt);
      if (cTMacroName == null)
        throw new IndexOutOfBoundsException(); 
      cTMacroName.set((XmlObject)paramCTMacroName);
    } 
  }
  
  public CTMacroName insertNewEntryMacro(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMacroName cTMacroName = null;
      cTMacroName = (CTMacroName)get_store().insert_element_user(ENTRYMACRO$6, paramInt);
      return cTMacroName;
    } 
  }
  
  public CTMacroName addNewEntryMacro() {
    synchronized (monitor()) {
      check_orphaned();
      CTMacroName cTMacroName = null;
      cTMacroName = (CTMacroName)get_store().add_element_user(ENTRYMACRO$6);
      return cTMacroName;
    } 
  }
  
  public void removeEntryMacro(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ENTRYMACRO$6, paramInt);
    } 
  }
  
  public List<CTMacroName> getExitMacroList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTMacroName>)new ExitMacroList(this);
    } 
  }
  
  public CTMacroName[] getExitMacroArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(EXITMACRO$8, arrayList);
      CTMacroName[] arrayOfCTMacroName = new CTMacroName[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMacroName);
      return arrayOfCTMacroName;
    } 
  }
  
  public CTMacroName getExitMacroArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMacroName cTMacroName = null;
      cTMacroName = (CTMacroName)get_store().find_element_user(EXITMACRO$8, paramInt);
      if (cTMacroName == null)
        throw new IndexOutOfBoundsException(); 
      return cTMacroName;
    } 
  }
  
  public int sizeOfExitMacroArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(EXITMACRO$8);
    } 
  }
  
  public void setExitMacroArray(CTMacroName[] paramArrayOfCTMacroName) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMacroName, EXITMACRO$8);
    } 
  }
  
  public void setExitMacroArray(int paramInt, CTMacroName paramCTMacroName) {
    synchronized (monitor()) {
      check_orphaned();
      CTMacroName cTMacroName = null;
      cTMacroName = (CTMacroName)get_store().find_element_user(EXITMACRO$8, paramInt);
      if (cTMacroName == null)
        throw new IndexOutOfBoundsException(); 
      cTMacroName.set((XmlObject)paramCTMacroName);
    } 
  }
  
  public CTMacroName insertNewExitMacro(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMacroName cTMacroName = null;
      cTMacroName = (CTMacroName)get_store().insert_element_user(EXITMACRO$8, paramInt);
      return cTMacroName;
    } 
  }
  
  public CTMacroName addNewExitMacro() {
    synchronized (monitor()) {
      check_orphaned();
      CTMacroName cTMacroName = null;
      cTMacroName = (CTMacroName)get_store().add_element_user(EXITMACRO$8);
      return cTMacroName;
    } 
  }
  
  public void removeExitMacro(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXITMACRO$8, paramInt);
    } 
  }
  
  public List<CTFFHelpText> getHelpTextList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTFFHelpText>)new HelpTextList(this);
    } 
  }
  
  public CTFFHelpText[] getHelpTextArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(HELPTEXT$10, arrayList);
      CTFFHelpText[] arrayOfCTFFHelpText = new CTFFHelpText[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTFFHelpText);
      return arrayOfCTFFHelpText;
    } 
  }
  
  public CTFFHelpText getHelpTextArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFFHelpText cTFFHelpText = null;
      cTFFHelpText = (CTFFHelpText)get_store().find_element_user(HELPTEXT$10, paramInt);
      if (cTFFHelpText == null)
        throw new IndexOutOfBoundsException(); 
      return cTFFHelpText;
    } 
  }
  
  public int sizeOfHelpTextArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(HELPTEXT$10);
    } 
  }
  
  public void setHelpTextArray(CTFFHelpText[] paramArrayOfCTFFHelpText) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTFFHelpText, HELPTEXT$10);
    } 
  }
  
  public void setHelpTextArray(int paramInt, CTFFHelpText paramCTFFHelpText) {
    synchronized (monitor()) {
      check_orphaned();
      CTFFHelpText cTFFHelpText = null;
      cTFFHelpText = (CTFFHelpText)get_store().find_element_user(HELPTEXT$10, paramInt);
      if (cTFFHelpText == null)
        throw new IndexOutOfBoundsException(); 
      cTFFHelpText.set((XmlObject)paramCTFFHelpText);
    } 
  }
  
  public CTFFHelpText insertNewHelpText(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFFHelpText cTFFHelpText = null;
      cTFFHelpText = (CTFFHelpText)get_store().insert_element_user(HELPTEXT$10, paramInt);
      return cTFFHelpText;
    } 
  }
  
  public CTFFHelpText addNewHelpText() {
    synchronized (monitor()) {
      check_orphaned();
      CTFFHelpText cTFFHelpText = null;
      cTFFHelpText = (CTFFHelpText)get_store().add_element_user(HELPTEXT$10);
      return cTFFHelpText;
    } 
  }
  
  public void removeHelpText(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HELPTEXT$10, paramInt);
    } 
  }
  
  public List<CTFFStatusText> getStatusTextList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTFFStatusText>)new StatusTextList(this);
    } 
  }
  
  public CTFFStatusText[] getStatusTextArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(STATUSTEXT$12, arrayList);
      CTFFStatusText[] arrayOfCTFFStatusText = new CTFFStatusText[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTFFStatusText);
      return arrayOfCTFFStatusText;
    } 
  }
  
  public CTFFStatusText getStatusTextArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFFStatusText cTFFStatusText = null;
      cTFFStatusText = (CTFFStatusText)get_store().find_element_user(STATUSTEXT$12, paramInt);
      if (cTFFStatusText == null)
        throw new IndexOutOfBoundsException(); 
      return cTFFStatusText;
    } 
  }
  
  public int sizeOfStatusTextArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(STATUSTEXT$12);
    } 
  }
  
  public void setStatusTextArray(CTFFStatusText[] paramArrayOfCTFFStatusText) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTFFStatusText, STATUSTEXT$12);
    } 
  }
  
  public void setStatusTextArray(int paramInt, CTFFStatusText paramCTFFStatusText) {
    synchronized (monitor()) {
      check_orphaned();
      CTFFStatusText cTFFStatusText = null;
      cTFFStatusText = (CTFFStatusText)get_store().find_element_user(STATUSTEXT$12, paramInt);
      if (cTFFStatusText == null)
        throw new IndexOutOfBoundsException(); 
      cTFFStatusText.set((XmlObject)paramCTFFStatusText);
    } 
  }
  
  public CTFFStatusText insertNewStatusText(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFFStatusText cTFFStatusText = null;
      cTFFStatusText = (CTFFStatusText)get_store().insert_element_user(STATUSTEXT$12, paramInt);
      return cTFFStatusText;
    } 
  }
  
  public CTFFStatusText addNewStatusText() {
    synchronized (monitor()) {
      check_orphaned();
      CTFFStatusText cTFFStatusText = null;
      cTFFStatusText = (CTFFStatusText)get_store().add_element_user(STATUSTEXT$12);
      return cTFFStatusText;
    } 
  }
  
  public void removeStatusText(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STATUSTEXT$12, paramInt);
    } 
  }
  
  public List<CTFFCheckBox> getCheckBoxList() {
    synchronized (monitor()) {
      check_orphaned();
      final class CheckBoxList extends AbstractList<CTFFCheckBox> {
        public CTFFCheckBox get(int param1Int) {
          return CTFFDataImpl.this.getCheckBoxArray(param1Int);
        }
        
        public CTFFCheckBox set(int param1Int, CTFFCheckBox param1CTFFCheckBox) {
          CTFFCheckBox cTFFCheckBox = CTFFDataImpl.this.getCheckBoxArray(param1Int);
          CTFFDataImpl.this.setCheckBoxArray(param1Int, param1CTFFCheckBox);
          return cTFFCheckBox;
        }
        
        public void add(int param1Int, CTFFCheckBox param1CTFFCheckBox) {
          CTFFDataImpl.this.insertNewCheckBox(param1Int).set((XmlObject)param1CTFFCheckBox);
        }
        
        public CTFFCheckBox remove(int param1Int) {
          CTFFCheckBox cTFFCheckBox = CTFFDataImpl.this.getCheckBoxArray(param1Int);
          CTFFDataImpl.this.removeCheckBox(param1Int);
          return cTFFCheckBox;
        }
        
        public int size() {
          return CTFFDataImpl.this.sizeOfCheckBoxArray();
        }
      };
      return new CheckBoxList();
    } 
  }
  
  public CTFFCheckBox[] getCheckBoxArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CHECKBOX$14, arrayList);
      CTFFCheckBox[] arrayOfCTFFCheckBox = new CTFFCheckBox[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTFFCheckBox);
      return arrayOfCTFFCheckBox;
    } 
  }
  
  public CTFFCheckBox getCheckBoxArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFFCheckBox cTFFCheckBox = null;
      cTFFCheckBox = (CTFFCheckBox)get_store().find_element_user(CHECKBOX$14, paramInt);
      if (cTFFCheckBox == null)
        throw new IndexOutOfBoundsException(); 
      return cTFFCheckBox;
    } 
  }
  
  public int sizeOfCheckBoxArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CHECKBOX$14);
    } 
  }
  
  public void setCheckBoxArray(CTFFCheckBox[] paramArrayOfCTFFCheckBox) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTFFCheckBox, CHECKBOX$14);
    } 
  }
  
  public void setCheckBoxArray(int paramInt, CTFFCheckBox paramCTFFCheckBox) {
    synchronized (monitor()) {
      check_orphaned();
      CTFFCheckBox cTFFCheckBox = null;
      cTFFCheckBox = (CTFFCheckBox)get_store().find_element_user(CHECKBOX$14, paramInt);
      if (cTFFCheckBox == null)
        throw new IndexOutOfBoundsException(); 
      cTFFCheckBox.set((XmlObject)paramCTFFCheckBox);
    } 
  }
  
  public CTFFCheckBox insertNewCheckBox(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFFCheckBox cTFFCheckBox = null;
      cTFFCheckBox = (CTFFCheckBox)get_store().insert_element_user(CHECKBOX$14, paramInt);
      return cTFFCheckBox;
    } 
  }
  
  public CTFFCheckBox addNewCheckBox() {
    synchronized (monitor()) {
      check_orphaned();
      CTFFCheckBox cTFFCheckBox = null;
      cTFFCheckBox = (CTFFCheckBox)get_store().add_element_user(CHECKBOX$14);
      return cTFFCheckBox;
    } 
  }
  
  public void removeCheckBox(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CHECKBOX$14, paramInt);
    } 
  }
  
  public List<CTFFDDList> getDdListList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTFFDDList>)new DdListList(this);
    } 
  }
  
  public CTFFDDList[] getDdListArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DDLIST$16, arrayList);
      CTFFDDList[] arrayOfCTFFDDList = new CTFFDDList[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTFFDDList);
      return arrayOfCTFFDDList;
    } 
  }
  
  public CTFFDDList getDdListArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFFDDList cTFFDDList = null;
      cTFFDDList = (CTFFDDList)get_store().find_element_user(DDLIST$16, paramInt);
      if (cTFFDDList == null)
        throw new IndexOutOfBoundsException(); 
      return cTFFDDList;
    } 
  }
  
  public int sizeOfDdListArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DDLIST$16);
    } 
  }
  
  public void setDdListArray(CTFFDDList[] paramArrayOfCTFFDDList) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTFFDDList, DDLIST$16);
    } 
  }
  
  public void setDdListArray(int paramInt, CTFFDDList paramCTFFDDList) {
    synchronized (monitor()) {
      check_orphaned();
      CTFFDDList cTFFDDList = null;
      cTFFDDList = (CTFFDDList)get_store().find_element_user(DDLIST$16, paramInt);
      if (cTFFDDList == null)
        throw new IndexOutOfBoundsException(); 
      cTFFDDList.set((XmlObject)paramCTFFDDList);
    } 
  }
  
  public CTFFDDList insertNewDdList(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFFDDList cTFFDDList = null;
      cTFFDDList = (CTFFDDList)get_store().insert_element_user(DDLIST$16, paramInt);
      return cTFFDDList;
    } 
  }
  
  public CTFFDDList addNewDdList() {
    synchronized (monitor()) {
      check_orphaned();
      CTFFDDList cTFFDDList = null;
      cTFFDDList = (CTFFDDList)get_store().add_element_user(DDLIST$16);
      return cTFFDDList;
    } 
  }
  
  public void removeDdList(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DDLIST$16, paramInt);
    } 
  }
  
  public List<CTFFTextInput> getTextInputList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTFFTextInput>)new TextInputList(this);
    } 
  }
  
  public CTFFTextInput[] getTextInputArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TEXTINPUT$18, arrayList);
      CTFFTextInput[] arrayOfCTFFTextInput = new CTFFTextInput[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTFFTextInput);
      return arrayOfCTFFTextInput;
    } 
  }
  
  public CTFFTextInput getTextInputArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFFTextInput cTFFTextInput = null;
      cTFFTextInput = (CTFFTextInput)get_store().find_element_user(TEXTINPUT$18, paramInt);
      if (cTFFTextInput == null)
        throw new IndexOutOfBoundsException(); 
      return cTFFTextInput;
    } 
  }
  
  public int sizeOfTextInputArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TEXTINPUT$18);
    } 
  }
  
  public void setTextInputArray(CTFFTextInput[] paramArrayOfCTFFTextInput) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTFFTextInput, TEXTINPUT$18);
    } 
  }
  
  public void setTextInputArray(int paramInt, CTFFTextInput paramCTFFTextInput) {
    synchronized (monitor()) {
      check_orphaned();
      CTFFTextInput cTFFTextInput = null;
      cTFFTextInput = (CTFFTextInput)get_store().find_element_user(TEXTINPUT$18, paramInt);
      if (cTFFTextInput == null)
        throw new IndexOutOfBoundsException(); 
      cTFFTextInput.set((XmlObject)paramCTFFTextInput);
    } 
  }
  
  public CTFFTextInput insertNewTextInput(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFFTextInput cTFFTextInput = null;
      cTFFTextInput = (CTFFTextInput)get_store().insert_element_user(TEXTINPUT$18, paramInt);
      return cTFFTextInput;
    } 
  }
  
  public CTFFTextInput addNewTextInput() {
    synchronized (monitor()) {
      check_orphaned();
      CTFFTextInput cTFFTextInput = null;
      cTFFTextInput = (CTFFTextInput)get_store().add_element_user(TEXTINPUT$18);
      return cTFFTextInput;
    } 
  }
  
  public void removeTextInput(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TEXTINPUT$18, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTFFDataImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */