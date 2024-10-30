package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBooleanProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontScheme;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontSize;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIntProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTUnderlineProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTVerticalAlignFontProperty;

public class CTFontImpl extends XmlComplexContentImpl implements CTFont {
  private static final b NAME$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "name");
  
  private static final b CHARSET$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "charset");
  
  private static final b FAMILY$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "family");
  
  private static final b B$6 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "b");
  
  private static final b I$8 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "i");
  
  private static final b STRIKE$10 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "strike");
  
  private static final b OUTLINE$12 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "outline");
  
  private static final b SHADOW$14 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "shadow");
  
  private static final b CONDENSE$16 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "condense");
  
  private static final b EXTEND$18 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extend");
  
  private static final b COLOR$20 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "color");
  
  private static final b SZ$22 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sz");
  
  private static final b U$24 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "u");
  
  private static final b VERTALIGN$26 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "vertAlign");
  
  private static final b SCHEME$28 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "scheme");
  
  public CTFontImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTFontName> getNameList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTFontName>)new NameList(this);
    } 
  }
  
  public CTFontName[] getNameArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(NAME$0, arrayList);
      CTFontName[] arrayOfCTFontName = new CTFontName[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTFontName);
      return arrayOfCTFontName;
    } 
  }
  
  public CTFontName getNameArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFontName cTFontName = null;
      cTFontName = (CTFontName)get_store().find_element_user(NAME$0, paramInt);
      if (cTFontName == null)
        throw new IndexOutOfBoundsException(); 
      return cTFontName;
    } 
  }
  
  public int sizeOfNameArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(NAME$0);
    } 
  }
  
  public void setNameArray(CTFontName[] paramArrayOfCTFontName) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTFontName, NAME$0);
    } 
  }
  
  public void setNameArray(int paramInt, CTFontName paramCTFontName) {
    synchronized (monitor()) {
      check_orphaned();
      CTFontName cTFontName = null;
      cTFontName = (CTFontName)get_store().find_element_user(NAME$0, paramInt);
      if (cTFontName == null)
        throw new IndexOutOfBoundsException(); 
      cTFontName.set((XmlObject)paramCTFontName);
    } 
  }
  
  public CTFontName insertNewName(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFontName cTFontName = null;
      cTFontName = (CTFontName)get_store().insert_element_user(NAME$0, paramInt);
      return cTFontName;
    } 
  }
  
  public CTFontName addNewName() {
    synchronized (monitor()) {
      check_orphaned();
      CTFontName cTFontName = null;
      cTFontName = (CTFontName)get_store().add_element_user(NAME$0);
      return cTFontName;
    } 
  }
  
  public void removeName(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NAME$0, paramInt);
    } 
  }
  
  public List<CTIntProperty> getCharsetList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTIntProperty>)new CharsetList(this);
    } 
  }
  
  public CTIntProperty[] getCharsetArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CHARSET$2, arrayList);
      CTIntProperty[] arrayOfCTIntProperty = new CTIntProperty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTIntProperty);
      return arrayOfCTIntProperty;
    } 
  }
  
  public CTIntProperty getCharsetArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTIntProperty cTIntProperty = null;
      cTIntProperty = (CTIntProperty)get_store().find_element_user(CHARSET$2, paramInt);
      if (cTIntProperty == null)
        throw new IndexOutOfBoundsException(); 
      return cTIntProperty;
    } 
  }
  
  public int sizeOfCharsetArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CHARSET$2);
    } 
  }
  
  public void setCharsetArray(CTIntProperty[] paramArrayOfCTIntProperty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTIntProperty, CHARSET$2);
    } 
  }
  
  public void setCharsetArray(int paramInt, CTIntProperty paramCTIntProperty) {
    synchronized (monitor()) {
      check_orphaned();
      CTIntProperty cTIntProperty = null;
      cTIntProperty = (CTIntProperty)get_store().find_element_user(CHARSET$2, paramInt);
      if (cTIntProperty == null)
        throw new IndexOutOfBoundsException(); 
      cTIntProperty.set((XmlObject)paramCTIntProperty);
    } 
  }
  
  public CTIntProperty insertNewCharset(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTIntProperty cTIntProperty = null;
      cTIntProperty = (CTIntProperty)get_store().insert_element_user(CHARSET$2, paramInt);
      return cTIntProperty;
    } 
  }
  
  public CTIntProperty addNewCharset() {
    synchronized (monitor()) {
      check_orphaned();
      CTIntProperty cTIntProperty = null;
      cTIntProperty = (CTIntProperty)get_store().add_element_user(CHARSET$2);
      return cTIntProperty;
    } 
  }
  
  public void removeCharset(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CHARSET$2, paramInt);
    } 
  }
  
  public List<CTIntProperty> getFamilyList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTIntProperty>)new FamilyList(this);
    } 
  }
  
  public CTIntProperty[] getFamilyArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FAMILY$4, arrayList);
      CTIntProperty[] arrayOfCTIntProperty = new CTIntProperty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTIntProperty);
      return arrayOfCTIntProperty;
    } 
  }
  
  public CTIntProperty getFamilyArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTIntProperty cTIntProperty = null;
      cTIntProperty = (CTIntProperty)get_store().find_element_user(FAMILY$4, paramInt);
      if (cTIntProperty == null)
        throw new IndexOutOfBoundsException(); 
      return cTIntProperty;
    } 
  }
  
  public int sizeOfFamilyArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FAMILY$4);
    } 
  }
  
  public void setFamilyArray(CTIntProperty[] paramArrayOfCTIntProperty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTIntProperty, FAMILY$4);
    } 
  }
  
  public void setFamilyArray(int paramInt, CTIntProperty paramCTIntProperty) {
    synchronized (monitor()) {
      check_orphaned();
      CTIntProperty cTIntProperty = null;
      cTIntProperty = (CTIntProperty)get_store().find_element_user(FAMILY$4, paramInt);
      if (cTIntProperty == null)
        throw new IndexOutOfBoundsException(); 
      cTIntProperty.set((XmlObject)paramCTIntProperty);
    } 
  }
  
  public CTIntProperty insertNewFamily(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTIntProperty cTIntProperty = null;
      cTIntProperty = (CTIntProperty)get_store().insert_element_user(FAMILY$4, paramInt);
      return cTIntProperty;
    } 
  }
  
  public CTIntProperty addNewFamily() {
    synchronized (monitor()) {
      check_orphaned();
      CTIntProperty cTIntProperty = null;
      cTIntProperty = (CTIntProperty)get_store().add_element_user(FAMILY$4);
      return cTIntProperty;
    } 
  }
  
  public void removeFamily(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FAMILY$4, paramInt);
    } 
  }
  
  public List<CTBooleanProperty> getBList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBooleanProperty>)new BList(this);
    } 
  }
  
  public CTBooleanProperty[] getBArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(B$6, arrayList);
      CTBooleanProperty[] arrayOfCTBooleanProperty = new CTBooleanProperty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBooleanProperty);
      return arrayOfCTBooleanProperty;
    } 
  }
  
  public CTBooleanProperty getBArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().find_element_user(B$6, paramInt);
      if (cTBooleanProperty == null)
        throw new IndexOutOfBoundsException(); 
      return cTBooleanProperty;
    } 
  }
  
  public int sizeOfBArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(B$6);
    } 
  }
  
  public void setBArray(CTBooleanProperty[] paramArrayOfCTBooleanProperty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBooleanProperty, B$6);
    } 
  }
  
  public void setBArray(int paramInt, CTBooleanProperty paramCTBooleanProperty) {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().find_element_user(B$6, paramInt);
      if (cTBooleanProperty == null)
        throw new IndexOutOfBoundsException(); 
      cTBooleanProperty.set((XmlObject)paramCTBooleanProperty);
    } 
  }
  
  public CTBooleanProperty insertNewB(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().insert_element_user(B$6, paramInt);
      return cTBooleanProperty;
    } 
  }
  
  public CTBooleanProperty addNewB() {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().add_element_user(B$6);
      return cTBooleanProperty;
    } 
  }
  
  public void removeB(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(B$6, paramInt);
    } 
  }
  
  public List<CTBooleanProperty> getIList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBooleanProperty>)new IList(this);
    } 
  }
  
  public CTBooleanProperty[] getIArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(I$8, arrayList);
      CTBooleanProperty[] arrayOfCTBooleanProperty = new CTBooleanProperty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBooleanProperty);
      return arrayOfCTBooleanProperty;
    } 
  }
  
  public CTBooleanProperty getIArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().find_element_user(I$8, paramInt);
      if (cTBooleanProperty == null)
        throw new IndexOutOfBoundsException(); 
      return cTBooleanProperty;
    } 
  }
  
  public int sizeOfIArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(I$8);
    } 
  }
  
  public void setIArray(CTBooleanProperty[] paramArrayOfCTBooleanProperty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBooleanProperty, I$8);
    } 
  }
  
  public void setIArray(int paramInt, CTBooleanProperty paramCTBooleanProperty) {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().find_element_user(I$8, paramInt);
      if (cTBooleanProperty == null)
        throw new IndexOutOfBoundsException(); 
      cTBooleanProperty.set((XmlObject)paramCTBooleanProperty);
    } 
  }
  
  public CTBooleanProperty insertNewI(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().insert_element_user(I$8, paramInt);
      return cTBooleanProperty;
    } 
  }
  
  public CTBooleanProperty addNewI() {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().add_element_user(I$8);
      return cTBooleanProperty;
    } 
  }
  
  public void removeI(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(I$8, paramInt);
    } 
  }
  
  public List<CTBooleanProperty> getStrikeList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBooleanProperty>)new StrikeList(this);
    } 
  }
  
  public CTBooleanProperty[] getStrikeArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(STRIKE$10, arrayList);
      CTBooleanProperty[] arrayOfCTBooleanProperty = new CTBooleanProperty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBooleanProperty);
      return arrayOfCTBooleanProperty;
    } 
  }
  
  public CTBooleanProperty getStrikeArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().find_element_user(STRIKE$10, paramInt);
      if (cTBooleanProperty == null)
        throw new IndexOutOfBoundsException(); 
      return cTBooleanProperty;
    } 
  }
  
  public int sizeOfStrikeArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(STRIKE$10);
    } 
  }
  
  public void setStrikeArray(CTBooleanProperty[] paramArrayOfCTBooleanProperty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBooleanProperty, STRIKE$10);
    } 
  }
  
  public void setStrikeArray(int paramInt, CTBooleanProperty paramCTBooleanProperty) {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().find_element_user(STRIKE$10, paramInt);
      if (cTBooleanProperty == null)
        throw new IndexOutOfBoundsException(); 
      cTBooleanProperty.set((XmlObject)paramCTBooleanProperty);
    } 
  }
  
  public CTBooleanProperty insertNewStrike(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().insert_element_user(STRIKE$10, paramInt);
      return cTBooleanProperty;
    } 
  }
  
  public CTBooleanProperty addNewStrike() {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().add_element_user(STRIKE$10);
      return cTBooleanProperty;
    } 
  }
  
  public void removeStrike(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STRIKE$10, paramInt);
    } 
  }
  
  public List<CTBooleanProperty> getOutlineList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBooleanProperty>)new OutlineList(this);
    } 
  }
  
  public CTBooleanProperty[] getOutlineArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(OUTLINE$12, arrayList);
      CTBooleanProperty[] arrayOfCTBooleanProperty = new CTBooleanProperty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBooleanProperty);
      return arrayOfCTBooleanProperty;
    } 
  }
  
  public CTBooleanProperty getOutlineArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().find_element_user(OUTLINE$12, paramInt);
      if (cTBooleanProperty == null)
        throw new IndexOutOfBoundsException(); 
      return cTBooleanProperty;
    } 
  }
  
  public int sizeOfOutlineArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(OUTLINE$12);
    } 
  }
  
  public void setOutlineArray(CTBooleanProperty[] paramArrayOfCTBooleanProperty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBooleanProperty, OUTLINE$12);
    } 
  }
  
  public void setOutlineArray(int paramInt, CTBooleanProperty paramCTBooleanProperty) {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().find_element_user(OUTLINE$12, paramInt);
      if (cTBooleanProperty == null)
        throw new IndexOutOfBoundsException(); 
      cTBooleanProperty.set((XmlObject)paramCTBooleanProperty);
    } 
  }
  
  public CTBooleanProperty insertNewOutline(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().insert_element_user(OUTLINE$12, paramInt);
      return cTBooleanProperty;
    } 
  }
  
  public CTBooleanProperty addNewOutline() {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().add_element_user(OUTLINE$12);
      return cTBooleanProperty;
    } 
  }
  
  public void removeOutline(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OUTLINE$12, paramInt);
    } 
  }
  
  public List<CTBooleanProperty> getShadowList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBooleanProperty>)new ShadowList(this);
    } 
  }
  
  public CTBooleanProperty[] getShadowArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SHADOW$14, arrayList);
      CTBooleanProperty[] arrayOfCTBooleanProperty = new CTBooleanProperty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBooleanProperty);
      return arrayOfCTBooleanProperty;
    } 
  }
  
  public CTBooleanProperty getShadowArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().find_element_user(SHADOW$14, paramInt);
      if (cTBooleanProperty == null)
        throw new IndexOutOfBoundsException(); 
      return cTBooleanProperty;
    } 
  }
  
  public int sizeOfShadowArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SHADOW$14);
    } 
  }
  
  public void setShadowArray(CTBooleanProperty[] paramArrayOfCTBooleanProperty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBooleanProperty, SHADOW$14);
    } 
  }
  
  public void setShadowArray(int paramInt, CTBooleanProperty paramCTBooleanProperty) {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().find_element_user(SHADOW$14, paramInt);
      if (cTBooleanProperty == null)
        throw new IndexOutOfBoundsException(); 
      cTBooleanProperty.set((XmlObject)paramCTBooleanProperty);
    } 
  }
  
  public CTBooleanProperty insertNewShadow(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().insert_element_user(SHADOW$14, paramInt);
      return cTBooleanProperty;
    } 
  }
  
  public CTBooleanProperty addNewShadow() {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().add_element_user(SHADOW$14);
      return cTBooleanProperty;
    } 
  }
  
  public void removeShadow(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHADOW$14, paramInt);
    } 
  }
  
  public List<CTBooleanProperty> getCondenseList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBooleanProperty>)new CondenseList(this);
    } 
  }
  
  public CTBooleanProperty[] getCondenseArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CONDENSE$16, arrayList);
      CTBooleanProperty[] arrayOfCTBooleanProperty = new CTBooleanProperty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBooleanProperty);
      return arrayOfCTBooleanProperty;
    } 
  }
  
  public CTBooleanProperty getCondenseArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().find_element_user(CONDENSE$16, paramInt);
      if (cTBooleanProperty == null)
        throw new IndexOutOfBoundsException(); 
      return cTBooleanProperty;
    } 
  }
  
  public int sizeOfCondenseArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CONDENSE$16);
    } 
  }
  
  public void setCondenseArray(CTBooleanProperty[] paramArrayOfCTBooleanProperty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBooleanProperty, CONDENSE$16);
    } 
  }
  
  public void setCondenseArray(int paramInt, CTBooleanProperty paramCTBooleanProperty) {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().find_element_user(CONDENSE$16, paramInt);
      if (cTBooleanProperty == null)
        throw new IndexOutOfBoundsException(); 
      cTBooleanProperty.set((XmlObject)paramCTBooleanProperty);
    } 
  }
  
  public CTBooleanProperty insertNewCondense(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().insert_element_user(CONDENSE$16, paramInt);
      return cTBooleanProperty;
    } 
  }
  
  public CTBooleanProperty addNewCondense() {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().add_element_user(CONDENSE$16);
      return cTBooleanProperty;
    } 
  }
  
  public void removeCondense(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CONDENSE$16, paramInt);
    } 
  }
  
  public List<CTBooleanProperty> getExtendList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBooleanProperty>)new ExtendList(this);
    } 
  }
  
  public CTBooleanProperty[] getExtendArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(EXTEND$18, arrayList);
      CTBooleanProperty[] arrayOfCTBooleanProperty = new CTBooleanProperty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBooleanProperty);
      return arrayOfCTBooleanProperty;
    } 
  }
  
  public CTBooleanProperty getExtendArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().find_element_user(EXTEND$18, paramInt);
      if (cTBooleanProperty == null)
        throw new IndexOutOfBoundsException(); 
      return cTBooleanProperty;
    } 
  }
  
  public int sizeOfExtendArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(EXTEND$18);
    } 
  }
  
  public void setExtendArray(CTBooleanProperty[] paramArrayOfCTBooleanProperty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBooleanProperty, EXTEND$18);
    } 
  }
  
  public void setExtendArray(int paramInt, CTBooleanProperty paramCTBooleanProperty) {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().find_element_user(EXTEND$18, paramInt);
      if (cTBooleanProperty == null)
        throw new IndexOutOfBoundsException(); 
      cTBooleanProperty.set((XmlObject)paramCTBooleanProperty);
    } 
  }
  
  public CTBooleanProperty insertNewExtend(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().insert_element_user(EXTEND$18, paramInt);
      return cTBooleanProperty;
    } 
  }
  
  public CTBooleanProperty addNewExtend() {
    synchronized (monitor()) {
      check_orphaned();
      CTBooleanProperty cTBooleanProperty = null;
      cTBooleanProperty = (CTBooleanProperty)get_store().add_element_user(EXTEND$18);
      return cTBooleanProperty;
    } 
  }
  
  public void removeExtend(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTEND$18, paramInt);
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
      get_store().find_all_element_users(COLOR$20, arrayList);
      CTColor[] arrayOfCTColor = new CTColor[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTColor);
      return arrayOfCTColor;
    } 
  }
  
  public CTColor getColorArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(COLOR$20, paramInt);
      if (cTColor == null)
        throw new IndexOutOfBoundsException(); 
      return cTColor;
    } 
  }
  
  public int sizeOfColorArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(COLOR$20);
    } 
  }
  
  public void setColorArray(CTColor[] paramArrayOfCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTColor, COLOR$20);
    } 
  }
  
  public void setColorArray(int paramInt, CTColor paramCTColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().find_element_user(COLOR$20, paramInt);
      if (cTColor == null)
        throw new IndexOutOfBoundsException(); 
      cTColor.set((XmlObject)paramCTColor);
    } 
  }
  
  public CTColor insertNewColor(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().insert_element_user(COLOR$20, paramInt);
      return cTColor;
    } 
  }
  
  public CTColor addNewColor() {
    synchronized (monitor()) {
      check_orphaned();
      CTColor cTColor = null;
      cTColor = (CTColor)get_store().add_element_user(COLOR$20);
      return cTColor;
    } 
  }
  
  public void removeColor(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COLOR$20, paramInt);
    } 
  }
  
  public List<CTFontSize> getSzList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTFontSize>)new SzList(this);
    } 
  }
  
  public CTFontSize[] getSzArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SZ$22, arrayList);
      CTFontSize[] arrayOfCTFontSize = new CTFontSize[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTFontSize);
      return arrayOfCTFontSize;
    } 
  }
  
  public CTFontSize getSzArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFontSize cTFontSize = null;
      cTFontSize = (CTFontSize)get_store().find_element_user(SZ$22, paramInt);
      if (cTFontSize == null)
        throw new IndexOutOfBoundsException(); 
      return cTFontSize;
    } 
  }
  
  public int sizeOfSzArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SZ$22);
    } 
  }
  
  public void setSzArray(CTFontSize[] paramArrayOfCTFontSize) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTFontSize, SZ$22);
    } 
  }
  
  public void setSzArray(int paramInt, CTFontSize paramCTFontSize) {
    synchronized (monitor()) {
      check_orphaned();
      CTFontSize cTFontSize = null;
      cTFontSize = (CTFontSize)get_store().find_element_user(SZ$22, paramInt);
      if (cTFontSize == null)
        throw new IndexOutOfBoundsException(); 
      cTFontSize.set((XmlObject)paramCTFontSize);
    } 
  }
  
  public CTFontSize insertNewSz(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFontSize cTFontSize = null;
      cTFontSize = (CTFontSize)get_store().insert_element_user(SZ$22, paramInt);
      return cTFontSize;
    } 
  }
  
  public CTFontSize addNewSz() {
    synchronized (monitor()) {
      check_orphaned();
      CTFontSize cTFontSize = null;
      cTFontSize = (CTFontSize)get_store().add_element_user(SZ$22);
      return cTFontSize;
    } 
  }
  
  public void removeSz(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SZ$22, paramInt);
    } 
  }
  
  public List<CTUnderlineProperty> getUList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTUnderlineProperty>)new UList(this);
    } 
  }
  
  public CTUnderlineProperty[] getUArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(U$24, arrayList);
      CTUnderlineProperty[] arrayOfCTUnderlineProperty = new CTUnderlineProperty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTUnderlineProperty);
      return arrayOfCTUnderlineProperty;
    } 
  }
  
  public CTUnderlineProperty getUArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTUnderlineProperty cTUnderlineProperty = null;
      cTUnderlineProperty = (CTUnderlineProperty)get_store().find_element_user(U$24, paramInt);
      if (cTUnderlineProperty == null)
        throw new IndexOutOfBoundsException(); 
      return cTUnderlineProperty;
    } 
  }
  
  public int sizeOfUArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(U$24);
    } 
  }
  
  public void setUArray(CTUnderlineProperty[] paramArrayOfCTUnderlineProperty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTUnderlineProperty, U$24);
    } 
  }
  
  public void setUArray(int paramInt, CTUnderlineProperty paramCTUnderlineProperty) {
    synchronized (monitor()) {
      check_orphaned();
      CTUnderlineProperty cTUnderlineProperty = null;
      cTUnderlineProperty = (CTUnderlineProperty)get_store().find_element_user(U$24, paramInt);
      if (cTUnderlineProperty == null)
        throw new IndexOutOfBoundsException(); 
      cTUnderlineProperty.set((XmlObject)paramCTUnderlineProperty);
    } 
  }
  
  public CTUnderlineProperty insertNewU(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTUnderlineProperty cTUnderlineProperty = null;
      cTUnderlineProperty = (CTUnderlineProperty)get_store().insert_element_user(U$24, paramInt);
      return cTUnderlineProperty;
    } 
  }
  
  public CTUnderlineProperty addNewU() {
    synchronized (monitor()) {
      check_orphaned();
      CTUnderlineProperty cTUnderlineProperty = null;
      cTUnderlineProperty = (CTUnderlineProperty)get_store().add_element_user(U$24);
      return cTUnderlineProperty;
    } 
  }
  
  public void removeU(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(U$24, paramInt);
    } 
  }
  
  public List<CTVerticalAlignFontProperty> getVertAlignList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTVerticalAlignFontProperty>)new VertAlignList(this);
    } 
  }
  
  public CTVerticalAlignFontProperty[] getVertAlignArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(VERTALIGN$26, arrayList);
      CTVerticalAlignFontProperty[] arrayOfCTVerticalAlignFontProperty = new CTVerticalAlignFontProperty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTVerticalAlignFontProperty);
      return arrayOfCTVerticalAlignFontProperty;
    } 
  }
  
  public CTVerticalAlignFontProperty getVertAlignArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTVerticalAlignFontProperty cTVerticalAlignFontProperty = null;
      cTVerticalAlignFontProperty = (CTVerticalAlignFontProperty)get_store().find_element_user(VERTALIGN$26, paramInt);
      if (cTVerticalAlignFontProperty == null)
        throw new IndexOutOfBoundsException(); 
      return cTVerticalAlignFontProperty;
    } 
  }
  
  public int sizeOfVertAlignArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(VERTALIGN$26);
    } 
  }
  
  public void setVertAlignArray(CTVerticalAlignFontProperty[] paramArrayOfCTVerticalAlignFontProperty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTVerticalAlignFontProperty, VERTALIGN$26);
    } 
  }
  
  public void setVertAlignArray(int paramInt, CTVerticalAlignFontProperty paramCTVerticalAlignFontProperty) {
    synchronized (monitor()) {
      check_orphaned();
      CTVerticalAlignFontProperty cTVerticalAlignFontProperty = null;
      cTVerticalAlignFontProperty = (CTVerticalAlignFontProperty)get_store().find_element_user(VERTALIGN$26, paramInt);
      if (cTVerticalAlignFontProperty == null)
        throw new IndexOutOfBoundsException(); 
      cTVerticalAlignFontProperty.set((XmlObject)paramCTVerticalAlignFontProperty);
    } 
  }
  
  public CTVerticalAlignFontProperty insertNewVertAlign(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTVerticalAlignFontProperty cTVerticalAlignFontProperty = null;
      cTVerticalAlignFontProperty = (CTVerticalAlignFontProperty)get_store().insert_element_user(VERTALIGN$26, paramInt);
      return cTVerticalAlignFontProperty;
    } 
  }
  
  public CTVerticalAlignFontProperty addNewVertAlign() {
    synchronized (monitor()) {
      check_orphaned();
      CTVerticalAlignFontProperty cTVerticalAlignFontProperty = null;
      cTVerticalAlignFontProperty = (CTVerticalAlignFontProperty)get_store().add_element_user(VERTALIGN$26);
      return cTVerticalAlignFontProperty;
    } 
  }
  
  public void removeVertAlign(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VERTALIGN$26, paramInt);
    } 
  }
  
  public List<CTFontScheme> getSchemeList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTFontScheme>)new SchemeList(this);
    } 
  }
  
  public CTFontScheme[] getSchemeArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SCHEME$28, arrayList);
      CTFontScheme[] arrayOfCTFontScheme = new CTFontScheme[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTFontScheme);
      return arrayOfCTFontScheme;
    } 
  }
  
  public CTFontScheme getSchemeArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFontScheme cTFontScheme = null;
      cTFontScheme = (CTFontScheme)get_store().find_element_user(SCHEME$28, paramInt);
      if (cTFontScheme == null)
        throw new IndexOutOfBoundsException(); 
      return cTFontScheme;
    } 
  }
  
  public int sizeOfSchemeArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SCHEME$28);
    } 
  }
  
  public void setSchemeArray(CTFontScheme[] paramArrayOfCTFontScheme) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTFontScheme, SCHEME$28);
    } 
  }
  
  public void setSchemeArray(int paramInt, CTFontScheme paramCTFontScheme) {
    synchronized (monitor()) {
      check_orphaned();
      CTFontScheme cTFontScheme = null;
      cTFontScheme = (CTFontScheme)get_store().find_element_user(SCHEME$28, paramInt);
      if (cTFontScheme == null)
        throw new IndexOutOfBoundsException(); 
      cTFontScheme.set((XmlObject)paramCTFontScheme);
    } 
  }
  
  public CTFontScheme insertNewScheme(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFontScheme cTFontScheme = null;
      cTFontScheme = (CTFontScheme)get_store().insert_element_user(SCHEME$28, paramInt);
      return cTFontScheme;
    } 
  }
  
  public CTFontScheme addNewScheme() {
    synchronized (monitor()) {
      check_orphaned();
      CTFontScheme cTFontScheme = null;
      cTFontScheme = (CTFontScheme)get_store().add_element_user(SCHEME$28);
      return cTFontScheme;
    } 
  }
  
  public void removeScheme(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SCHEME$28, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTFontImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */