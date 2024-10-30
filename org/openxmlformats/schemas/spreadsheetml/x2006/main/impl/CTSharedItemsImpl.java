package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBoolean;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDateTime;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTError;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMissing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumber;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTString;

public class CTSharedItemsImpl extends XmlComplexContentImpl implements CTSharedItems {
  private static final b M$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "m");
  
  private static final b N$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "n");
  
  private static final b B$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "b");
  
  private static final b E$6 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "e");
  
  private static final b S$8 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "s");
  
  private static final b D$10 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "d");
  
  private static final b CONTAINSSEMIMIXEDTYPES$12 = new b("", "containsSemiMixedTypes");
  
  private static final b CONTAINSNONDATE$14 = new b("", "containsNonDate");
  
  private static final b CONTAINSDATE$16 = new b("", "containsDate");
  
  private static final b CONTAINSSTRING$18 = new b("", "containsString");
  
  private static final b CONTAINSBLANK$20 = new b("", "containsBlank");
  
  private static final b CONTAINSMIXEDTYPES$22 = new b("", "containsMixedTypes");
  
  private static final b CONTAINSNUMBER$24 = new b("", "containsNumber");
  
  private static final b CONTAINSINTEGER$26 = new b("", "containsInteger");
  
  private static final b MINVALUE$28 = new b("", "minValue");
  
  private static final b MAXVALUE$30 = new b("", "maxValue");
  
  private static final b MINDATE$32 = new b("", "minDate");
  
  private static final b MAXDATE$34 = new b("", "maxDate");
  
  private static final b COUNT$36 = new b("", "count");
  
  private static final b LONGTEXT$38 = new b("", "longText");
  
  public CTSharedItemsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTMissing> getMList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTMissing>)new MList(this);
    } 
  }
  
  public CTMissing[] getMArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(M$0, arrayList);
      CTMissing[] arrayOfCTMissing = new CTMissing[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTMissing);
      return arrayOfCTMissing;
    } 
  }
  
  public CTMissing getMArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMissing cTMissing = null;
      cTMissing = (CTMissing)get_store().find_element_user(M$0, paramInt);
      if (cTMissing == null)
        throw new IndexOutOfBoundsException(); 
      return cTMissing;
    } 
  }
  
  public int sizeOfMArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(M$0);
    } 
  }
  
  public void setMArray(CTMissing[] paramArrayOfCTMissing) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTMissing, M$0);
    } 
  }
  
  public void setMArray(int paramInt, CTMissing paramCTMissing) {
    synchronized (monitor()) {
      check_orphaned();
      CTMissing cTMissing = null;
      cTMissing = (CTMissing)get_store().find_element_user(M$0, paramInt);
      if (cTMissing == null)
        throw new IndexOutOfBoundsException(); 
      cTMissing.set((XmlObject)paramCTMissing);
    } 
  }
  
  public CTMissing insertNewM(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTMissing cTMissing = null;
      cTMissing = (CTMissing)get_store().insert_element_user(M$0, paramInt);
      return cTMissing;
    } 
  }
  
  public CTMissing addNewM() {
    synchronized (monitor()) {
      check_orphaned();
      CTMissing cTMissing = null;
      cTMissing = (CTMissing)get_store().add_element_user(M$0);
      return cTMissing;
    } 
  }
  
  public void removeM(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(M$0, paramInt);
    } 
  }
  
  public List<CTNumber> getNList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTNumber>)new NList(this);
    } 
  }
  
  public CTNumber[] getNArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(N$2, arrayList);
      CTNumber[] arrayOfCTNumber = new CTNumber[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTNumber);
      return arrayOfCTNumber;
    } 
  }
  
  public CTNumber getNArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumber cTNumber = null;
      cTNumber = (CTNumber)get_store().find_element_user(N$2, paramInt);
      if (cTNumber == null)
        throw new IndexOutOfBoundsException(); 
      return cTNumber;
    } 
  }
  
  public int sizeOfNArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(N$2);
    } 
  }
  
  public void setNArray(CTNumber[] paramArrayOfCTNumber) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTNumber, N$2);
    } 
  }
  
  public void setNArray(int paramInt, CTNumber paramCTNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumber cTNumber = null;
      cTNumber = (CTNumber)get_store().find_element_user(N$2, paramInt);
      if (cTNumber == null)
        throw new IndexOutOfBoundsException(); 
      cTNumber.set((XmlObject)paramCTNumber);
    } 
  }
  
  public CTNumber insertNewN(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumber cTNumber = null;
      cTNumber = (CTNumber)get_store().insert_element_user(N$2, paramInt);
      return cTNumber;
    } 
  }
  
  public CTNumber addNewN() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumber cTNumber = null;
      cTNumber = (CTNumber)get_store().add_element_user(N$2);
      return cTNumber;
    } 
  }
  
  public void removeN(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(N$2, paramInt);
    } 
  }
  
  public List<CTBoolean> getBList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBoolean>)new BList(this);
    } 
  }
  
  public CTBoolean[] getBArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(B$4, arrayList);
      CTBoolean[] arrayOfCTBoolean = new CTBoolean[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBoolean);
      return arrayOfCTBoolean;
    } 
  }
  
  public CTBoolean getBArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(B$4, paramInt);
      if (cTBoolean == null)
        throw new IndexOutOfBoundsException(); 
      return cTBoolean;
    } 
  }
  
  public int sizeOfBArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(B$4);
    } 
  }
  
  public void setBArray(CTBoolean[] paramArrayOfCTBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBoolean, B$4);
    } 
  }
  
  public void setBArray(int paramInt, CTBoolean paramCTBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().find_element_user(B$4, paramInt);
      if (cTBoolean == null)
        throw new IndexOutOfBoundsException(); 
      cTBoolean.set((XmlObject)paramCTBoolean);
    } 
  }
  
  public CTBoolean insertNewB(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().insert_element_user(B$4, paramInt);
      return cTBoolean;
    } 
  }
  
  public CTBoolean addNewB() {
    synchronized (monitor()) {
      check_orphaned();
      CTBoolean cTBoolean = null;
      cTBoolean = (CTBoolean)get_store().add_element_user(B$4);
      return cTBoolean;
    } 
  }
  
  public void removeB(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(B$4, paramInt);
    } 
  }
  
  public List<CTError> getEList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTError>)new EList(this);
    } 
  }
  
  public CTError[] getEArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(E$6, arrayList);
      CTError[] arrayOfCTError = new CTError[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTError);
      return arrayOfCTError;
    } 
  }
  
  public CTError getEArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTError cTError = null;
      cTError = (CTError)get_store().find_element_user(E$6, paramInt);
      if (cTError == null)
        throw new IndexOutOfBoundsException(); 
      return cTError;
    } 
  }
  
  public int sizeOfEArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(E$6);
    } 
  }
  
  public void setEArray(CTError[] paramArrayOfCTError) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTError, E$6);
    } 
  }
  
  public void setEArray(int paramInt, CTError paramCTError) {
    synchronized (monitor()) {
      check_orphaned();
      CTError cTError = null;
      cTError = (CTError)get_store().find_element_user(E$6, paramInt);
      if (cTError == null)
        throw new IndexOutOfBoundsException(); 
      cTError.set((XmlObject)paramCTError);
    } 
  }
  
  public CTError insertNewE(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTError cTError = null;
      cTError = (CTError)get_store().insert_element_user(E$6, paramInt);
      return cTError;
    } 
  }
  
  public CTError addNewE() {
    synchronized (monitor()) {
      check_orphaned();
      CTError cTError = null;
      cTError = (CTError)get_store().add_element_user(E$6);
      return cTError;
    } 
  }
  
  public void removeE(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(E$6, paramInt);
    } 
  }
  
  public List<CTString> getSList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTString>)new SList(this);
    } 
  }
  
  public CTString[] getSArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(S$8, arrayList);
      CTString[] arrayOfCTString = new CTString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTString);
      return arrayOfCTString;
    } 
  }
  
  public CTString getSArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(S$8, paramInt);
      if (cTString == null)
        throw new IndexOutOfBoundsException(); 
      return cTString;
    } 
  }
  
  public int sizeOfSArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(S$8);
    } 
  }
  
  public void setSArray(CTString[] paramArrayOfCTString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTString, S$8);
    } 
  }
  
  public void setSArray(int paramInt, CTString paramCTString) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(S$8, paramInt);
      if (cTString == null)
        throw new IndexOutOfBoundsException(); 
      cTString.set((XmlObject)paramCTString);
    } 
  }
  
  public CTString insertNewS(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().insert_element_user(S$8, paramInt);
      return cTString;
    } 
  }
  
  public CTString addNewS() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().add_element_user(S$8);
      return cTString;
    } 
  }
  
  public void removeS(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(S$8, paramInt);
    } 
  }
  
  public List<CTDateTime> getDList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTDateTime>)new DList(this);
    } 
  }
  
  public CTDateTime[] getDArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(D$10, arrayList);
      CTDateTime[] arrayOfCTDateTime = new CTDateTime[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTDateTime);
      return arrayOfCTDateTime;
    } 
  }
  
  public CTDateTime getDArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDateTime cTDateTime = null;
      cTDateTime = (CTDateTime)get_store().find_element_user(D$10, paramInt);
      if (cTDateTime == null)
        throw new IndexOutOfBoundsException(); 
      return cTDateTime;
    } 
  }
  
  public int sizeOfDArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(D$10);
    } 
  }
  
  public void setDArray(CTDateTime[] paramArrayOfCTDateTime) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTDateTime, D$10);
    } 
  }
  
  public void setDArray(int paramInt, CTDateTime paramCTDateTime) {
    synchronized (monitor()) {
      check_orphaned();
      CTDateTime cTDateTime = null;
      cTDateTime = (CTDateTime)get_store().find_element_user(D$10, paramInt);
      if (cTDateTime == null)
        throw new IndexOutOfBoundsException(); 
      cTDateTime.set((XmlObject)paramCTDateTime);
    } 
  }
  
  public CTDateTime insertNewD(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDateTime cTDateTime = null;
      cTDateTime = (CTDateTime)get_store().insert_element_user(D$10, paramInt);
      return cTDateTime;
    } 
  }
  
  public CTDateTime addNewD() {
    synchronized (monitor()) {
      check_orphaned();
      CTDateTime cTDateTime = null;
      cTDateTime = (CTDateTime)get_store().add_element_user(D$10);
      return cTDateTime;
    } 
  }
  
  public void removeD(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(D$10, paramInt);
    } 
  }
  
  public boolean getContainsSemiMixedTypes() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONTAINSSEMIMIXEDTYPES$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CONTAINSSEMIMIXEDTYPES$12); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetContainsSemiMixedTypes() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CONTAINSSEMIMIXEDTYPES$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(CONTAINSSEMIMIXEDTYPES$12); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetContainsSemiMixedTypes() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CONTAINSSEMIMIXEDTYPES$12) != null);
    } 
  }
  
  public void setContainsSemiMixedTypes(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONTAINSSEMIMIXEDTYPES$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CONTAINSSEMIMIXEDTYPES$12); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetContainsSemiMixedTypes(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CONTAINSSEMIMIXEDTYPES$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(CONTAINSSEMIMIXEDTYPES$12); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetContainsSemiMixedTypes() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CONTAINSSEMIMIXEDTYPES$12);
    } 
  }
  
  public boolean getContainsNonDate() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONTAINSNONDATE$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CONTAINSNONDATE$14); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetContainsNonDate() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CONTAINSNONDATE$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(CONTAINSNONDATE$14); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetContainsNonDate() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CONTAINSNONDATE$14) != null);
    } 
  }
  
  public void setContainsNonDate(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONTAINSNONDATE$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CONTAINSNONDATE$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetContainsNonDate(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CONTAINSNONDATE$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(CONTAINSNONDATE$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetContainsNonDate() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CONTAINSNONDATE$14);
    } 
  }
  
  public boolean getContainsDate() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONTAINSDATE$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CONTAINSDATE$16); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetContainsDate() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CONTAINSDATE$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(CONTAINSDATE$16); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetContainsDate() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CONTAINSDATE$16) != null);
    } 
  }
  
  public void setContainsDate(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONTAINSDATE$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CONTAINSDATE$16); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetContainsDate(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CONTAINSDATE$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(CONTAINSDATE$16); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetContainsDate() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CONTAINSDATE$16);
    } 
  }
  
  public boolean getContainsString() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONTAINSSTRING$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CONTAINSSTRING$18); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetContainsString() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CONTAINSSTRING$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(CONTAINSSTRING$18); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetContainsString() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CONTAINSSTRING$18) != null);
    } 
  }
  
  public void setContainsString(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONTAINSSTRING$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CONTAINSSTRING$18); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetContainsString(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CONTAINSSTRING$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(CONTAINSSTRING$18); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetContainsString() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CONTAINSSTRING$18);
    } 
  }
  
  public boolean getContainsBlank() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONTAINSBLANK$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CONTAINSBLANK$20); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetContainsBlank() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CONTAINSBLANK$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(CONTAINSBLANK$20); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetContainsBlank() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CONTAINSBLANK$20) != null);
    } 
  }
  
  public void setContainsBlank(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONTAINSBLANK$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CONTAINSBLANK$20); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetContainsBlank(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CONTAINSBLANK$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(CONTAINSBLANK$20); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetContainsBlank() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CONTAINSBLANK$20);
    } 
  }
  
  public boolean getContainsMixedTypes() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONTAINSMIXEDTYPES$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CONTAINSMIXEDTYPES$22); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetContainsMixedTypes() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CONTAINSMIXEDTYPES$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(CONTAINSMIXEDTYPES$22); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetContainsMixedTypes() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CONTAINSMIXEDTYPES$22) != null);
    } 
  }
  
  public void setContainsMixedTypes(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONTAINSMIXEDTYPES$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CONTAINSMIXEDTYPES$22); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetContainsMixedTypes(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CONTAINSMIXEDTYPES$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(CONTAINSMIXEDTYPES$22); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetContainsMixedTypes() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CONTAINSMIXEDTYPES$22);
    } 
  }
  
  public boolean getContainsNumber() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONTAINSNUMBER$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CONTAINSNUMBER$24); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetContainsNumber() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CONTAINSNUMBER$24);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(CONTAINSNUMBER$24); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetContainsNumber() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CONTAINSNUMBER$24) != null);
    } 
  }
  
  public void setContainsNumber(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONTAINSNUMBER$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CONTAINSNUMBER$24); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetContainsNumber(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CONTAINSNUMBER$24);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(CONTAINSNUMBER$24); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetContainsNumber() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CONTAINSNUMBER$24);
    } 
  }
  
  public boolean getContainsInteger() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONTAINSINTEGER$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CONTAINSINTEGER$26); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetContainsInteger() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CONTAINSINTEGER$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(CONTAINSINTEGER$26); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetContainsInteger() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CONTAINSINTEGER$26) != null);
    } 
  }
  
  public void setContainsInteger(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONTAINSINTEGER$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CONTAINSINTEGER$26); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetContainsInteger(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CONTAINSINTEGER$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(CONTAINSINTEGER$26); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetContainsInteger() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CONTAINSINTEGER$26);
    } 
  }
  
  public double getMinValue() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MINVALUE$28);
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetMinValue() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(MINVALUE$28);
      return xmlDouble;
    } 
  }
  
  public boolean isSetMinValue() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MINVALUE$28) != null);
    } 
  }
  
  public void setMinValue(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MINVALUE$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MINVALUE$28); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetMinValue(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(MINVALUE$28);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(MINVALUE$28); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public void unsetMinValue() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MINVALUE$28);
    } 
  }
  
  public double getMaxValue() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MAXVALUE$30);
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetMaxValue() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(MAXVALUE$30);
      return xmlDouble;
    } 
  }
  
  public boolean isSetMaxValue() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MAXVALUE$30) != null);
    } 
  }
  
  public void setMaxValue(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MAXVALUE$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MAXVALUE$30); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetMaxValue(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(MAXVALUE$30);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(MAXVALUE$30); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public void unsetMaxValue() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MAXVALUE$30);
    } 
  }
  
  public Calendar getMinDate() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MINDATE$32);
      if (simpleValue == null)
        return null; 
      return simpleValue.getCalendarValue();
    } 
  }
  
  public XmlDateTime xgetMinDate() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().find_attribute_user(MINDATE$32);
      return xmlDateTime;
    } 
  }
  
  public boolean isSetMinDate() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MINDATE$32) != null);
    } 
  }
  
  public void setMinDate(Calendar paramCalendar) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MINDATE$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MINDATE$32); 
      simpleValue.setCalendarValue(paramCalendar);
    } 
  }
  
  public void xsetMinDate(XmlDateTime paramXmlDateTime) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().find_attribute_user(MINDATE$32);
      if (xmlDateTime == null)
        xmlDateTime = (XmlDateTime)get_store().add_attribute_user(MINDATE$32); 
      xmlDateTime.set((XmlObject)paramXmlDateTime);
    } 
  }
  
  public void unsetMinDate() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MINDATE$32);
    } 
  }
  
  public Calendar getMaxDate() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MAXDATE$34);
      if (simpleValue == null)
        return null; 
      return simpleValue.getCalendarValue();
    } 
  }
  
  public XmlDateTime xgetMaxDate() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().find_attribute_user(MAXDATE$34);
      return xmlDateTime;
    } 
  }
  
  public boolean isSetMaxDate() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MAXDATE$34) != null);
    } 
  }
  
  public void setMaxDate(Calendar paramCalendar) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MAXDATE$34);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MAXDATE$34); 
      simpleValue.setCalendarValue(paramCalendar);
    } 
  }
  
  public void xsetMaxDate(XmlDateTime paramXmlDateTime) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().find_attribute_user(MAXDATE$34);
      if (xmlDateTime == null)
        xmlDateTime = (XmlDateTime)get_store().add_attribute_user(MAXDATE$34); 
      xmlDateTime.set((XmlObject)paramXmlDateTime);
    } 
  }
  
  public void unsetMaxDate() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MAXDATE$34);
    } 
  }
  
  public long getCount() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COUNT$36);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetCount() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(COUNT$36);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetCount() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COUNT$36) != null);
    } 
  }
  
  public void setCount(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COUNT$36);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COUNT$36); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetCount(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(COUNT$36);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(COUNT$36); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetCount() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COUNT$36);
    } 
  }
  
  public boolean getLongText() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LONGTEXT$38);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(LONGTEXT$38); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetLongText() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(LONGTEXT$38);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(LONGTEXT$38); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetLongText() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LONGTEXT$38) != null);
    } 
  }
  
  public void setLongText(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LONGTEXT$38);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LONGTEXT$38); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetLongText(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(LONGTEXT$38);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(LONGTEXT$38); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetLongText() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LONGTEXT$38);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTSharedItemsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */