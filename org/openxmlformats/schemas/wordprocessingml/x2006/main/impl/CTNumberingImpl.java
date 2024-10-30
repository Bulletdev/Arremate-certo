package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPicBullet;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering;

public class CTNumberingImpl extends XmlComplexContentImpl implements CTNumbering {
  private static final b NUMPICBULLET$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numPicBullet");
  
  private static final b ABSTRACTNUM$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "abstractNum");
  
  private static final b NUM$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "num");
  
  private static final b NUMIDMACATCLEANUP$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numIdMacAtCleanup");
  
  public CTNumberingImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTNumPicBullet> getNumPicBulletList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTNumPicBullet>)new NumPicBulletList(this);
    } 
  }
  
  public CTNumPicBullet[] getNumPicBulletArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(NUMPICBULLET$0, arrayList);
      CTNumPicBullet[] arrayOfCTNumPicBullet = new CTNumPicBullet[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTNumPicBullet);
      return arrayOfCTNumPicBullet;
    } 
  }
  
  public CTNumPicBullet getNumPicBulletArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumPicBullet cTNumPicBullet = null;
      cTNumPicBullet = (CTNumPicBullet)get_store().find_element_user(NUMPICBULLET$0, paramInt);
      if (cTNumPicBullet == null)
        throw new IndexOutOfBoundsException(); 
      return cTNumPicBullet;
    } 
  }
  
  public int sizeOfNumPicBulletArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(NUMPICBULLET$0);
    } 
  }
  
  public void setNumPicBulletArray(CTNumPicBullet[] paramArrayOfCTNumPicBullet) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTNumPicBullet, NUMPICBULLET$0);
    } 
  }
  
  public void setNumPicBulletArray(int paramInt, CTNumPicBullet paramCTNumPicBullet) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumPicBullet cTNumPicBullet = null;
      cTNumPicBullet = (CTNumPicBullet)get_store().find_element_user(NUMPICBULLET$0, paramInt);
      if (cTNumPicBullet == null)
        throw new IndexOutOfBoundsException(); 
      cTNumPicBullet.set((XmlObject)paramCTNumPicBullet);
    } 
  }
  
  public CTNumPicBullet insertNewNumPicBullet(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTNumPicBullet cTNumPicBullet = null;
      cTNumPicBullet = (CTNumPicBullet)get_store().insert_element_user(NUMPICBULLET$0, paramInt);
      return cTNumPicBullet;
    } 
  }
  
  public CTNumPicBullet addNewNumPicBullet() {
    synchronized (monitor()) {
      check_orphaned();
      CTNumPicBullet cTNumPicBullet = null;
      cTNumPicBullet = (CTNumPicBullet)get_store().add_element_user(NUMPICBULLET$0);
      return cTNumPicBullet;
    } 
  }
  
  public void removeNumPicBullet(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NUMPICBULLET$0, paramInt);
    } 
  }
  
  public List<CTAbstractNum> getAbstractNumList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTAbstractNum>)new AbstractNumList(this);
    } 
  }
  
  public CTAbstractNum[] getAbstractNumArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ABSTRACTNUM$2, arrayList);
      CTAbstractNum[] arrayOfCTAbstractNum = new CTAbstractNum[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTAbstractNum);
      return arrayOfCTAbstractNum;
    } 
  }
  
  public CTAbstractNum getAbstractNumArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAbstractNum cTAbstractNum = null;
      cTAbstractNum = (CTAbstractNum)get_store().find_element_user(ABSTRACTNUM$2, paramInt);
      if (cTAbstractNum == null)
        throw new IndexOutOfBoundsException(); 
      return cTAbstractNum;
    } 
  }
  
  public int sizeOfAbstractNumArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ABSTRACTNUM$2);
    } 
  }
  
  public void setAbstractNumArray(CTAbstractNum[] paramArrayOfCTAbstractNum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTAbstractNum, ABSTRACTNUM$2);
    } 
  }
  
  public void setAbstractNumArray(int paramInt, CTAbstractNum paramCTAbstractNum) {
    synchronized (monitor()) {
      check_orphaned();
      CTAbstractNum cTAbstractNum = null;
      cTAbstractNum = (CTAbstractNum)get_store().find_element_user(ABSTRACTNUM$2, paramInt);
      if (cTAbstractNum == null)
        throw new IndexOutOfBoundsException(); 
      cTAbstractNum.set((XmlObject)paramCTAbstractNum);
    } 
  }
  
  public CTAbstractNum insertNewAbstractNum(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAbstractNum cTAbstractNum = null;
      cTAbstractNum = (CTAbstractNum)get_store().insert_element_user(ABSTRACTNUM$2, paramInt);
      return cTAbstractNum;
    } 
  }
  
  public CTAbstractNum addNewAbstractNum() {
    synchronized (monitor()) {
      check_orphaned();
      CTAbstractNum cTAbstractNum = null;
      cTAbstractNum = (CTAbstractNum)get_store().add_element_user(ABSTRACTNUM$2);
      return cTAbstractNum;
    } 
  }
  
  public void removeAbstractNum(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ABSTRACTNUM$2, paramInt);
    } 
  }
  
  public List<CTNum> getNumList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTNum>)new NumList(this);
    } 
  }
  
  public CTNum[] getNumArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(NUM$4, arrayList);
      CTNum[] arrayOfCTNum = new CTNum[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTNum);
      return arrayOfCTNum;
    } 
  }
  
  public CTNum getNumArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTNum cTNum = null;
      cTNum = (CTNum)get_store().find_element_user(NUM$4, paramInt);
      if (cTNum == null)
        throw new IndexOutOfBoundsException(); 
      return cTNum;
    } 
  }
  
  public int sizeOfNumArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(NUM$4);
    } 
  }
  
  public void setNumArray(CTNum[] paramArrayOfCTNum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTNum, NUM$4);
    } 
  }
  
  public void setNumArray(int paramInt, CTNum paramCTNum) {
    synchronized (monitor()) {
      check_orphaned();
      CTNum cTNum = null;
      cTNum = (CTNum)get_store().find_element_user(NUM$4, paramInt);
      if (cTNum == null)
        throw new IndexOutOfBoundsException(); 
      cTNum.set((XmlObject)paramCTNum);
    } 
  }
  
  public CTNum insertNewNum(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTNum cTNum = null;
      cTNum = (CTNum)get_store().insert_element_user(NUM$4, paramInt);
      return cTNum;
    } 
  }
  
  public CTNum addNewNum() {
    synchronized (monitor()) {
      check_orphaned();
      CTNum cTNum = null;
      cTNum = (CTNum)get_store().add_element_user(NUM$4);
      return cTNum;
    } 
  }
  
  public void removeNum(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NUM$4, paramInt);
    } 
  }
  
  public CTDecimalNumber getNumIdMacAtCleanup() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(NUMIDMACATCLEANUP$6, 0);
      if (cTDecimalNumber == null)
        return null; 
      return cTDecimalNumber;
    } 
  }
  
  public boolean isSetNumIdMacAtCleanup() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NUMIDMACATCLEANUP$6) != 0);
    } 
  }
  
  public void setNumIdMacAtCleanup(CTDecimalNumber paramCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(NUMIDMACATCLEANUP$6, 0);
      if (cTDecimalNumber == null)
        cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(NUMIDMACATCLEANUP$6); 
      cTDecimalNumber.set((XmlObject)paramCTDecimalNumber);
    } 
  }
  
  public CTDecimalNumber addNewNumIdMacAtCleanup() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(NUMIDMACATCLEANUP$6);
      return cTDecimalNumber;
    } 
  }
  
  public void unsetNumIdMacAtCleanup() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NUMIDMACATCLEANUP$6, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTNumberingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */