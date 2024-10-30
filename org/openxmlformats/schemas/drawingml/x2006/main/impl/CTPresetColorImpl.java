package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAngle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTComplementTransform;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFixedPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGammaTransform;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGrayscaleTransform;
import org.openxmlformats.schemas.drawingml.x2006.main.CTInverseGammaTransform;
import org.openxmlformats.schemas.drawingml.x2006.main.CTInverseTransform;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveFixedAngle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveFixedPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositivePercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor;
import org.openxmlformats.schemas.drawingml.x2006.main.STPresetColorVal;

public class CTPresetColorImpl extends XmlComplexContentImpl implements CTPresetColor {
  private static final b TINT$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tint");
  
  private static final b SHADE$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "shade");
  
  private static final b COMP$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "comp");
  
  private static final b INV$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "inv");
  
  private static final b GRAY$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "gray");
  
  private static final b ALPHA$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "alpha");
  
  private static final b ALPHAOFF$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaOff");
  
  private static final b ALPHAMOD$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaMod");
  
  private static final b HUE$16 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "hue");
  
  private static final b HUEOFF$18 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "hueOff");
  
  private static final b HUEMOD$20 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "hueMod");
  
  private static final b SAT$22 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "sat");
  
  private static final b SATOFF$24 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "satOff");
  
  private static final b SATMOD$26 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "satMod");
  
  private static final b LUM$28 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lum");
  
  private static final b LUMOFF$30 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lumOff");
  
  private static final b LUMMOD$32 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lumMod");
  
  private static final b RED$34 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "red");
  
  private static final b REDOFF$36 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "redOff");
  
  private static final b REDMOD$38 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "redMod");
  
  private static final b GREEN$40 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "green");
  
  private static final b GREENOFF$42 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "greenOff");
  
  private static final b GREENMOD$44 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "greenMod");
  
  private static final b BLUE$46 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "blue");
  
  private static final b BLUEOFF$48 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "blueOff");
  
  private static final b BLUEMOD$50 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "blueMod");
  
  private static final b GAMMA$52 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "gamma");
  
  private static final b INVGAMMA$54 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "invGamma");
  
  private static final b VAL$56 = new b("", "val");
  
  public CTPresetColorImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTPositiveFixedPercentage> getTintList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPositiveFixedPercentage>)new TintList(this);
    } 
  }
  
  public CTPositiveFixedPercentage[] getTintArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TINT$0, arrayList);
      CTPositiveFixedPercentage[] arrayOfCTPositiveFixedPercentage = new CTPositiveFixedPercentage[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPositiveFixedPercentage);
      return arrayOfCTPositiveFixedPercentage;
    } 
  }
  
  public CTPositiveFixedPercentage getTintArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveFixedPercentage cTPositiveFixedPercentage = null;
      cTPositiveFixedPercentage = (CTPositiveFixedPercentage)get_store().find_element_user(TINT$0, paramInt);
      if (cTPositiveFixedPercentage == null)
        throw new IndexOutOfBoundsException(); 
      return cTPositiveFixedPercentage;
    } 
  }
  
  public int sizeOfTintArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TINT$0);
    } 
  }
  
  public void setTintArray(CTPositiveFixedPercentage[] paramArrayOfCTPositiveFixedPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPositiveFixedPercentage, TINT$0);
    } 
  }
  
  public void setTintArray(int paramInt, CTPositiveFixedPercentage paramCTPositiveFixedPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveFixedPercentage cTPositiveFixedPercentage = null;
      cTPositiveFixedPercentage = (CTPositiveFixedPercentage)get_store().find_element_user(TINT$0, paramInt);
      if (cTPositiveFixedPercentage == null)
        throw new IndexOutOfBoundsException(); 
      cTPositiveFixedPercentage.set((XmlObject)paramCTPositiveFixedPercentage);
    } 
  }
  
  public CTPositiveFixedPercentage insertNewTint(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveFixedPercentage cTPositiveFixedPercentage = null;
      cTPositiveFixedPercentage = (CTPositiveFixedPercentage)get_store().insert_element_user(TINT$0, paramInt);
      return cTPositiveFixedPercentage;
    } 
  }
  
  public CTPositiveFixedPercentage addNewTint() {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveFixedPercentage cTPositiveFixedPercentage = null;
      cTPositiveFixedPercentage = (CTPositiveFixedPercentage)get_store().add_element_user(TINT$0);
      return cTPositiveFixedPercentage;
    } 
  }
  
  public void removeTint(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TINT$0, paramInt);
    } 
  }
  
  public List<CTPositiveFixedPercentage> getShadeList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPositiveFixedPercentage>)new ShadeList(this);
    } 
  }
  
  public CTPositiveFixedPercentage[] getShadeArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SHADE$2, arrayList);
      CTPositiveFixedPercentage[] arrayOfCTPositiveFixedPercentage = new CTPositiveFixedPercentage[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPositiveFixedPercentage);
      return arrayOfCTPositiveFixedPercentage;
    } 
  }
  
  public CTPositiveFixedPercentage getShadeArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveFixedPercentage cTPositiveFixedPercentage = null;
      cTPositiveFixedPercentage = (CTPositiveFixedPercentage)get_store().find_element_user(SHADE$2, paramInt);
      if (cTPositiveFixedPercentage == null)
        throw new IndexOutOfBoundsException(); 
      return cTPositiveFixedPercentage;
    } 
  }
  
  public int sizeOfShadeArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SHADE$2);
    } 
  }
  
  public void setShadeArray(CTPositiveFixedPercentage[] paramArrayOfCTPositiveFixedPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPositiveFixedPercentage, SHADE$2);
    } 
  }
  
  public void setShadeArray(int paramInt, CTPositiveFixedPercentage paramCTPositiveFixedPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveFixedPercentage cTPositiveFixedPercentage = null;
      cTPositiveFixedPercentage = (CTPositiveFixedPercentage)get_store().find_element_user(SHADE$2, paramInt);
      if (cTPositiveFixedPercentage == null)
        throw new IndexOutOfBoundsException(); 
      cTPositiveFixedPercentage.set((XmlObject)paramCTPositiveFixedPercentage);
    } 
  }
  
  public CTPositiveFixedPercentage insertNewShade(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveFixedPercentage cTPositiveFixedPercentage = null;
      cTPositiveFixedPercentage = (CTPositiveFixedPercentage)get_store().insert_element_user(SHADE$2, paramInt);
      return cTPositiveFixedPercentage;
    } 
  }
  
  public CTPositiveFixedPercentage addNewShade() {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveFixedPercentage cTPositiveFixedPercentage = null;
      cTPositiveFixedPercentage = (CTPositiveFixedPercentage)get_store().add_element_user(SHADE$2);
      return cTPositiveFixedPercentage;
    } 
  }
  
  public void removeShade(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHADE$2, paramInt);
    } 
  }
  
  public List<CTComplementTransform> getCompList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTComplementTransform>)new CompList(this);
    } 
  }
  
  public CTComplementTransform[] getCompArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(COMP$4, arrayList);
      CTComplementTransform[] arrayOfCTComplementTransform = new CTComplementTransform[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTComplementTransform);
      return arrayOfCTComplementTransform;
    } 
  }
  
  public CTComplementTransform getCompArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTComplementTransform cTComplementTransform = null;
      cTComplementTransform = (CTComplementTransform)get_store().find_element_user(COMP$4, paramInt);
      if (cTComplementTransform == null)
        throw new IndexOutOfBoundsException(); 
      return cTComplementTransform;
    } 
  }
  
  public int sizeOfCompArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(COMP$4);
    } 
  }
  
  public void setCompArray(CTComplementTransform[] paramArrayOfCTComplementTransform) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTComplementTransform, COMP$4);
    } 
  }
  
  public void setCompArray(int paramInt, CTComplementTransform paramCTComplementTransform) {
    synchronized (monitor()) {
      check_orphaned();
      CTComplementTransform cTComplementTransform = null;
      cTComplementTransform = (CTComplementTransform)get_store().find_element_user(COMP$4, paramInt);
      if (cTComplementTransform == null)
        throw new IndexOutOfBoundsException(); 
      cTComplementTransform.set((XmlObject)paramCTComplementTransform);
    } 
  }
  
  public CTComplementTransform insertNewComp(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTComplementTransform cTComplementTransform = null;
      cTComplementTransform = (CTComplementTransform)get_store().insert_element_user(COMP$4, paramInt);
      return cTComplementTransform;
    } 
  }
  
  public CTComplementTransform addNewComp() {
    synchronized (monitor()) {
      check_orphaned();
      CTComplementTransform cTComplementTransform = null;
      cTComplementTransform = (CTComplementTransform)get_store().add_element_user(COMP$4);
      return cTComplementTransform;
    } 
  }
  
  public void removeComp(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COMP$4, paramInt);
    } 
  }
  
  public List<CTInverseTransform> getInvList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTInverseTransform>)new InvList(this);
    } 
  }
  
  public CTInverseTransform[] getInvArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(INV$6, arrayList);
      CTInverseTransform[] arrayOfCTInverseTransform = new CTInverseTransform[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTInverseTransform);
      return arrayOfCTInverseTransform;
    } 
  }
  
  public CTInverseTransform getInvArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTInverseTransform cTInverseTransform = null;
      cTInverseTransform = (CTInverseTransform)get_store().find_element_user(INV$6, paramInt);
      if (cTInverseTransform == null)
        throw new IndexOutOfBoundsException(); 
      return cTInverseTransform;
    } 
  }
  
  public int sizeOfInvArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(INV$6);
    } 
  }
  
  public void setInvArray(CTInverseTransform[] paramArrayOfCTInverseTransform) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTInverseTransform, INV$6);
    } 
  }
  
  public void setInvArray(int paramInt, CTInverseTransform paramCTInverseTransform) {
    synchronized (monitor()) {
      check_orphaned();
      CTInverseTransform cTInverseTransform = null;
      cTInverseTransform = (CTInverseTransform)get_store().find_element_user(INV$6, paramInt);
      if (cTInverseTransform == null)
        throw new IndexOutOfBoundsException(); 
      cTInverseTransform.set((XmlObject)paramCTInverseTransform);
    } 
  }
  
  public CTInverseTransform insertNewInv(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTInverseTransform cTInverseTransform = null;
      cTInverseTransform = (CTInverseTransform)get_store().insert_element_user(INV$6, paramInt);
      return cTInverseTransform;
    } 
  }
  
  public CTInverseTransform addNewInv() {
    synchronized (monitor()) {
      check_orphaned();
      CTInverseTransform cTInverseTransform = null;
      cTInverseTransform = (CTInverseTransform)get_store().add_element_user(INV$6);
      return cTInverseTransform;
    } 
  }
  
  public void removeInv(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(INV$6, paramInt);
    } 
  }
  
  public List<CTGrayscaleTransform> getGrayList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTGrayscaleTransform>)new GrayList(this);
    } 
  }
  
  public CTGrayscaleTransform[] getGrayArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(GRAY$8, arrayList);
      CTGrayscaleTransform[] arrayOfCTGrayscaleTransform = new CTGrayscaleTransform[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTGrayscaleTransform);
      return arrayOfCTGrayscaleTransform;
    } 
  }
  
  public CTGrayscaleTransform getGrayArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTGrayscaleTransform cTGrayscaleTransform = null;
      cTGrayscaleTransform = (CTGrayscaleTransform)get_store().find_element_user(GRAY$8, paramInt);
      if (cTGrayscaleTransform == null)
        throw new IndexOutOfBoundsException(); 
      return cTGrayscaleTransform;
    } 
  }
  
  public int sizeOfGrayArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(GRAY$8);
    } 
  }
  
  public void setGrayArray(CTGrayscaleTransform[] paramArrayOfCTGrayscaleTransform) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTGrayscaleTransform, GRAY$8);
    } 
  }
  
  public void setGrayArray(int paramInt, CTGrayscaleTransform paramCTGrayscaleTransform) {
    synchronized (monitor()) {
      check_orphaned();
      CTGrayscaleTransform cTGrayscaleTransform = null;
      cTGrayscaleTransform = (CTGrayscaleTransform)get_store().find_element_user(GRAY$8, paramInt);
      if (cTGrayscaleTransform == null)
        throw new IndexOutOfBoundsException(); 
      cTGrayscaleTransform.set((XmlObject)paramCTGrayscaleTransform);
    } 
  }
  
  public CTGrayscaleTransform insertNewGray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTGrayscaleTransform cTGrayscaleTransform = null;
      cTGrayscaleTransform = (CTGrayscaleTransform)get_store().insert_element_user(GRAY$8, paramInt);
      return cTGrayscaleTransform;
    } 
  }
  
  public CTGrayscaleTransform addNewGray() {
    synchronized (monitor()) {
      check_orphaned();
      CTGrayscaleTransform cTGrayscaleTransform = null;
      cTGrayscaleTransform = (CTGrayscaleTransform)get_store().add_element_user(GRAY$8);
      return cTGrayscaleTransform;
    } 
  }
  
  public void removeGray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRAY$8, paramInt);
    } 
  }
  
  public List<CTPositiveFixedPercentage> getAlphaList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPositiveFixedPercentage>)new AlphaList(this);
    } 
  }
  
  public CTPositiveFixedPercentage[] getAlphaArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ALPHA$10, arrayList);
      CTPositiveFixedPercentage[] arrayOfCTPositiveFixedPercentage = new CTPositiveFixedPercentage[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPositiveFixedPercentage);
      return arrayOfCTPositiveFixedPercentage;
    } 
  }
  
  public CTPositiveFixedPercentage getAlphaArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveFixedPercentage cTPositiveFixedPercentage = null;
      cTPositiveFixedPercentage = (CTPositiveFixedPercentage)get_store().find_element_user(ALPHA$10, paramInt);
      if (cTPositiveFixedPercentage == null)
        throw new IndexOutOfBoundsException(); 
      return cTPositiveFixedPercentage;
    } 
  }
  
  public int sizeOfAlphaArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ALPHA$10);
    } 
  }
  
  public void setAlphaArray(CTPositiveFixedPercentage[] paramArrayOfCTPositiveFixedPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPositiveFixedPercentage, ALPHA$10);
    } 
  }
  
  public void setAlphaArray(int paramInt, CTPositiveFixedPercentage paramCTPositiveFixedPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveFixedPercentage cTPositiveFixedPercentage = null;
      cTPositiveFixedPercentage = (CTPositiveFixedPercentage)get_store().find_element_user(ALPHA$10, paramInt);
      if (cTPositiveFixedPercentage == null)
        throw new IndexOutOfBoundsException(); 
      cTPositiveFixedPercentage.set((XmlObject)paramCTPositiveFixedPercentage);
    } 
  }
  
  public CTPositiveFixedPercentage insertNewAlpha(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveFixedPercentage cTPositiveFixedPercentage = null;
      cTPositiveFixedPercentage = (CTPositiveFixedPercentage)get_store().insert_element_user(ALPHA$10, paramInt);
      return cTPositiveFixedPercentage;
    } 
  }
  
  public CTPositiveFixedPercentage addNewAlpha() {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveFixedPercentage cTPositiveFixedPercentage = null;
      cTPositiveFixedPercentage = (CTPositiveFixedPercentage)get_store().add_element_user(ALPHA$10);
      return cTPositiveFixedPercentage;
    } 
  }
  
  public void removeAlpha(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ALPHA$10, paramInt);
    } 
  }
  
  public List<CTFixedPercentage> getAlphaOffList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTFixedPercentage>)new AlphaOffList(this);
    } 
  }
  
  public CTFixedPercentage[] getAlphaOffArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ALPHAOFF$12, arrayList);
      CTFixedPercentage[] arrayOfCTFixedPercentage = new CTFixedPercentage[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTFixedPercentage);
      return arrayOfCTFixedPercentage;
    } 
  }
  
  public CTFixedPercentage getAlphaOffArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFixedPercentage cTFixedPercentage = null;
      cTFixedPercentage = (CTFixedPercentage)get_store().find_element_user(ALPHAOFF$12, paramInt);
      if (cTFixedPercentage == null)
        throw new IndexOutOfBoundsException(); 
      return cTFixedPercentage;
    } 
  }
  
  public int sizeOfAlphaOffArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ALPHAOFF$12);
    } 
  }
  
  public void setAlphaOffArray(CTFixedPercentage[] paramArrayOfCTFixedPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTFixedPercentage, ALPHAOFF$12);
    } 
  }
  
  public void setAlphaOffArray(int paramInt, CTFixedPercentage paramCTFixedPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      CTFixedPercentage cTFixedPercentage = null;
      cTFixedPercentage = (CTFixedPercentage)get_store().find_element_user(ALPHAOFF$12, paramInt);
      if (cTFixedPercentage == null)
        throw new IndexOutOfBoundsException(); 
      cTFixedPercentage.set((XmlObject)paramCTFixedPercentage);
    } 
  }
  
  public CTFixedPercentage insertNewAlphaOff(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFixedPercentage cTFixedPercentage = null;
      cTFixedPercentage = (CTFixedPercentage)get_store().insert_element_user(ALPHAOFF$12, paramInt);
      return cTFixedPercentage;
    } 
  }
  
  public CTFixedPercentage addNewAlphaOff() {
    synchronized (monitor()) {
      check_orphaned();
      CTFixedPercentage cTFixedPercentage = null;
      cTFixedPercentage = (CTFixedPercentage)get_store().add_element_user(ALPHAOFF$12);
      return cTFixedPercentage;
    } 
  }
  
  public void removeAlphaOff(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ALPHAOFF$12, paramInt);
    } 
  }
  
  public List<CTPositivePercentage> getAlphaModList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPositivePercentage>)new AlphaModList(this);
    } 
  }
  
  public CTPositivePercentage[] getAlphaModArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ALPHAMOD$14, arrayList);
      CTPositivePercentage[] arrayOfCTPositivePercentage = new CTPositivePercentage[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPositivePercentage);
      return arrayOfCTPositivePercentage;
    } 
  }
  
  public CTPositivePercentage getAlphaModArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositivePercentage cTPositivePercentage = null;
      cTPositivePercentage = (CTPositivePercentage)get_store().find_element_user(ALPHAMOD$14, paramInt);
      if (cTPositivePercentage == null)
        throw new IndexOutOfBoundsException(); 
      return cTPositivePercentage;
    } 
  }
  
  public int sizeOfAlphaModArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ALPHAMOD$14);
    } 
  }
  
  public void setAlphaModArray(CTPositivePercentage[] paramArrayOfCTPositivePercentage) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPositivePercentage, ALPHAMOD$14);
    } 
  }
  
  public void setAlphaModArray(int paramInt, CTPositivePercentage paramCTPositivePercentage) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositivePercentage cTPositivePercentage = null;
      cTPositivePercentage = (CTPositivePercentage)get_store().find_element_user(ALPHAMOD$14, paramInt);
      if (cTPositivePercentage == null)
        throw new IndexOutOfBoundsException(); 
      cTPositivePercentage.set((XmlObject)paramCTPositivePercentage);
    } 
  }
  
  public CTPositivePercentage insertNewAlphaMod(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositivePercentage cTPositivePercentage = null;
      cTPositivePercentage = (CTPositivePercentage)get_store().insert_element_user(ALPHAMOD$14, paramInt);
      return cTPositivePercentage;
    } 
  }
  
  public CTPositivePercentage addNewAlphaMod() {
    synchronized (monitor()) {
      check_orphaned();
      CTPositivePercentage cTPositivePercentage = null;
      cTPositivePercentage = (CTPositivePercentage)get_store().add_element_user(ALPHAMOD$14);
      return cTPositivePercentage;
    } 
  }
  
  public void removeAlphaMod(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ALPHAMOD$14, paramInt);
    } 
  }
  
  public List<CTPositiveFixedAngle> getHueList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPositiveFixedAngle>)new HueList(this);
    } 
  }
  
  public CTPositiveFixedAngle[] getHueArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(HUE$16, arrayList);
      CTPositiveFixedAngle[] arrayOfCTPositiveFixedAngle = new CTPositiveFixedAngle[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPositiveFixedAngle);
      return arrayOfCTPositiveFixedAngle;
    } 
  }
  
  public CTPositiveFixedAngle getHueArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveFixedAngle cTPositiveFixedAngle = null;
      cTPositiveFixedAngle = (CTPositiveFixedAngle)get_store().find_element_user(HUE$16, paramInt);
      if (cTPositiveFixedAngle == null)
        throw new IndexOutOfBoundsException(); 
      return cTPositiveFixedAngle;
    } 
  }
  
  public int sizeOfHueArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(HUE$16);
    } 
  }
  
  public void setHueArray(CTPositiveFixedAngle[] paramArrayOfCTPositiveFixedAngle) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPositiveFixedAngle, HUE$16);
    } 
  }
  
  public void setHueArray(int paramInt, CTPositiveFixedAngle paramCTPositiveFixedAngle) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveFixedAngle cTPositiveFixedAngle = null;
      cTPositiveFixedAngle = (CTPositiveFixedAngle)get_store().find_element_user(HUE$16, paramInt);
      if (cTPositiveFixedAngle == null)
        throw new IndexOutOfBoundsException(); 
      cTPositiveFixedAngle.set((XmlObject)paramCTPositiveFixedAngle);
    } 
  }
  
  public CTPositiveFixedAngle insertNewHue(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveFixedAngle cTPositiveFixedAngle = null;
      cTPositiveFixedAngle = (CTPositiveFixedAngle)get_store().insert_element_user(HUE$16, paramInt);
      return cTPositiveFixedAngle;
    } 
  }
  
  public CTPositiveFixedAngle addNewHue() {
    synchronized (monitor()) {
      check_orphaned();
      CTPositiveFixedAngle cTPositiveFixedAngle = null;
      cTPositiveFixedAngle = (CTPositiveFixedAngle)get_store().add_element_user(HUE$16);
      return cTPositiveFixedAngle;
    } 
  }
  
  public void removeHue(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HUE$16, paramInt);
    } 
  }
  
  public List<CTAngle> getHueOffList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTAngle>)new HueOffList(this);
    } 
  }
  
  public CTAngle[] getHueOffArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(HUEOFF$18, arrayList);
      CTAngle[] arrayOfCTAngle = new CTAngle[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTAngle);
      return arrayOfCTAngle;
    } 
  }
  
  public CTAngle getHueOffArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAngle cTAngle = null;
      cTAngle = (CTAngle)get_store().find_element_user(HUEOFF$18, paramInt);
      if (cTAngle == null)
        throw new IndexOutOfBoundsException(); 
      return cTAngle;
    } 
  }
  
  public int sizeOfHueOffArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(HUEOFF$18);
    } 
  }
  
  public void setHueOffArray(CTAngle[] paramArrayOfCTAngle) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTAngle, HUEOFF$18);
    } 
  }
  
  public void setHueOffArray(int paramInt, CTAngle paramCTAngle) {
    synchronized (monitor()) {
      check_orphaned();
      CTAngle cTAngle = null;
      cTAngle = (CTAngle)get_store().find_element_user(HUEOFF$18, paramInt);
      if (cTAngle == null)
        throw new IndexOutOfBoundsException(); 
      cTAngle.set((XmlObject)paramCTAngle);
    } 
  }
  
  public CTAngle insertNewHueOff(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAngle cTAngle = null;
      cTAngle = (CTAngle)get_store().insert_element_user(HUEOFF$18, paramInt);
      return cTAngle;
    } 
  }
  
  public CTAngle addNewHueOff() {
    synchronized (monitor()) {
      check_orphaned();
      CTAngle cTAngle = null;
      cTAngle = (CTAngle)get_store().add_element_user(HUEOFF$18);
      return cTAngle;
    } 
  }
  
  public void removeHueOff(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HUEOFF$18, paramInt);
    } 
  }
  
  public List<CTPositivePercentage> getHueModList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPositivePercentage>)new HueModList(this);
    } 
  }
  
  public CTPositivePercentage[] getHueModArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(HUEMOD$20, arrayList);
      CTPositivePercentage[] arrayOfCTPositivePercentage = new CTPositivePercentage[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPositivePercentage);
      return arrayOfCTPositivePercentage;
    } 
  }
  
  public CTPositivePercentage getHueModArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositivePercentage cTPositivePercentage = null;
      cTPositivePercentage = (CTPositivePercentage)get_store().find_element_user(HUEMOD$20, paramInt);
      if (cTPositivePercentage == null)
        throw new IndexOutOfBoundsException(); 
      return cTPositivePercentage;
    } 
  }
  
  public int sizeOfHueModArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(HUEMOD$20);
    } 
  }
  
  public void setHueModArray(CTPositivePercentage[] paramArrayOfCTPositivePercentage) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPositivePercentage, HUEMOD$20);
    } 
  }
  
  public void setHueModArray(int paramInt, CTPositivePercentage paramCTPositivePercentage) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositivePercentage cTPositivePercentage = null;
      cTPositivePercentage = (CTPositivePercentage)get_store().find_element_user(HUEMOD$20, paramInt);
      if (cTPositivePercentage == null)
        throw new IndexOutOfBoundsException(); 
      cTPositivePercentage.set((XmlObject)paramCTPositivePercentage);
    } 
  }
  
  public CTPositivePercentage insertNewHueMod(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPositivePercentage cTPositivePercentage = null;
      cTPositivePercentage = (CTPositivePercentage)get_store().insert_element_user(HUEMOD$20, paramInt);
      return cTPositivePercentage;
    } 
  }
  
  public CTPositivePercentage addNewHueMod() {
    synchronized (monitor()) {
      check_orphaned();
      CTPositivePercentage cTPositivePercentage = null;
      cTPositivePercentage = (CTPositivePercentage)get_store().add_element_user(HUEMOD$20);
      return cTPositivePercentage;
    } 
  }
  
  public void removeHueMod(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HUEMOD$20, paramInt);
    } 
  }
  
  public List<CTPercentage> getSatList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPercentage>)new SatList(this);
    } 
  }
  
  public CTPercentage[] getSatArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SAT$22, arrayList);
      CTPercentage[] arrayOfCTPercentage = new CTPercentage[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPercentage);
      return arrayOfCTPercentage;
    } 
  }
  
  public CTPercentage getSatArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(SAT$22, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      return cTPercentage;
    } 
  }
  
  public int sizeOfSatArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SAT$22);
    } 
  }
  
  public void setSatArray(CTPercentage[] paramArrayOfCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPercentage, SAT$22);
    } 
  }
  
  public void setSatArray(int paramInt, CTPercentage paramCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(SAT$22, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      cTPercentage.set((XmlObject)paramCTPercentage);
    } 
  }
  
  public CTPercentage insertNewSat(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().insert_element_user(SAT$22, paramInt);
      return cTPercentage;
    } 
  }
  
  public CTPercentage addNewSat() {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().add_element_user(SAT$22);
      return cTPercentage;
    } 
  }
  
  public void removeSat(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SAT$22, paramInt);
    } 
  }
  
  public List<CTPercentage> getSatOffList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPercentage>)new SatOffList(this);
    } 
  }
  
  public CTPercentage[] getSatOffArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SATOFF$24, arrayList);
      CTPercentage[] arrayOfCTPercentage = new CTPercentage[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPercentage);
      return arrayOfCTPercentage;
    } 
  }
  
  public CTPercentage getSatOffArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(SATOFF$24, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      return cTPercentage;
    } 
  }
  
  public int sizeOfSatOffArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SATOFF$24);
    } 
  }
  
  public void setSatOffArray(CTPercentage[] paramArrayOfCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPercentage, SATOFF$24);
    } 
  }
  
  public void setSatOffArray(int paramInt, CTPercentage paramCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(SATOFF$24, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      cTPercentage.set((XmlObject)paramCTPercentage);
    } 
  }
  
  public CTPercentage insertNewSatOff(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().insert_element_user(SATOFF$24, paramInt);
      return cTPercentage;
    } 
  }
  
  public CTPercentage addNewSatOff() {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().add_element_user(SATOFF$24);
      return cTPercentage;
    } 
  }
  
  public void removeSatOff(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SATOFF$24, paramInt);
    } 
  }
  
  public List<CTPercentage> getSatModList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPercentage>)new SatModList(this);
    } 
  }
  
  public CTPercentage[] getSatModArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SATMOD$26, arrayList);
      CTPercentage[] arrayOfCTPercentage = new CTPercentage[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPercentage);
      return arrayOfCTPercentage;
    } 
  }
  
  public CTPercentage getSatModArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(SATMOD$26, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      return cTPercentage;
    } 
  }
  
  public int sizeOfSatModArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SATMOD$26);
    } 
  }
  
  public void setSatModArray(CTPercentage[] paramArrayOfCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPercentage, SATMOD$26);
    } 
  }
  
  public void setSatModArray(int paramInt, CTPercentage paramCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(SATMOD$26, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      cTPercentage.set((XmlObject)paramCTPercentage);
    } 
  }
  
  public CTPercentage insertNewSatMod(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().insert_element_user(SATMOD$26, paramInt);
      return cTPercentage;
    } 
  }
  
  public CTPercentage addNewSatMod() {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().add_element_user(SATMOD$26);
      return cTPercentage;
    } 
  }
  
  public void removeSatMod(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SATMOD$26, paramInt);
    } 
  }
  
  public List<CTPercentage> getLumList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPercentage>)new LumList(this);
    } 
  }
  
  public CTPercentage[] getLumArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LUM$28, arrayList);
      CTPercentage[] arrayOfCTPercentage = new CTPercentage[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPercentage);
      return arrayOfCTPercentage;
    } 
  }
  
  public CTPercentage getLumArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(LUM$28, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      return cTPercentage;
    } 
  }
  
  public int sizeOfLumArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LUM$28);
    } 
  }
  
  public void setLumArray(CTPercentage[] paramArrayOfCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPercentage, LUM$28);
    } 
  }
  
  public void setLumArray(int paramInt, CTPercentage paramCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(LUM$28, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      cTPercentage.set((XmlObject)paramCTPercentage);
    } 
  }
  
  public CTPercentage insertNewLum(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().insert_element_user(LUM$28, paramInt);
      return cTPercentage;
    } 
  }
  
  public CTPercentage addNewLum() {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().add_element_user(LUM$28);
      return cTPercentage;
    } 
  }
  
  public void removeLum(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LUM$28, paramInt);
    } 
  }
  
  public List<CTPercentage> getLumOffList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPercentage>)new LumOffList(this);
    } 
  }
  
  public CTPercentage[] getLumOffArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LUMOFF$30, arrayList);
      CTPercentage[] arrayOfCTPercentage = new CTPercentage[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPercentage);
      return arrayOfCTPercentage;
    } 
  }
  
  public CTPercentage getLumOffArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(LUMOFF$30, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      return cTPercentage;
    } 
  }
  
  public int sizeOfLumOffArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LUMOFF$30);
    } 
  }
  
  public void setLumOffArray(CTPercentage[] paramArrayOfCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPercentage, LUMOFF$30);
    } 
  }
  
  public void setLumOffArray(int paramInt, CTPercentage paramCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(LUMOFF$30, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      cTPercentage.set((XmlObject)paramCTPercentage);
    } 
  }
  
  public CTPercentage insertNewLumOff(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().insert_element_user(LUMOFF$30, paramInt);
      return cTPercentage;
    } 
  }
  
  public CTPercentage addNewLumOff() {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().add_element_user(LUMOFF$30);
      return cTPercentage;
    } 
  }
  
  public void removeLumOff(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LUMOFF$30, paramInt);
    } 
  }
  
  public List<CTPercentage> getLumModList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPercentage>)new LumModList(this);
    } 
  }
  
  public CTPercentage[] getLumModArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LUMMOD$32, arrayList);
      CTPercentage[] arrayOfCTPercentage = new CTPercentage[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPercentage);
      return arrayOfCTPercentage;
    } 
  }
  
  public CTPercentage getLumModArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(LUMMOD$32, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      return cTPercentage;
    } 
  }
  
  public int sizeOfLumModArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LUMMOD$32);
    } 
  }
  
  public void setLumModArray(CTPercentage[] paramArrayOfCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPercentage, LUMMOD$32);
    } 
  }
  
  public void setLumModArray(int paramInt, CTPercentage paramCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(LUMMOD$32, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      cTPercentage.set((XmlObject)paramCTPercentage);
    } 
  }
  
  public CTPercentage insertNewLumMod(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().insert_element_user(LUMMOD$32, paramInt);
      return cTPercentage;
    } 
  }
  
  public CTPercentage addNewLumMod() {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().add_element_user(LUMMOD$32);
      return cTPercentage;
    } 
  }
  
  public void removeLumMod(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LUMMOD$32, paramInt);
    } 
  }
  
  public List<CTPercentage> getRedList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPercentage>)new RedList(this);
    } 
  }
  
  public CTPercentage[] getRedArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(RED$34, arrayList);
      CTPercentage[] arrayOfCTPercentage = new CTPercentage[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPercentage);
      return arrayOfCTPercentage;
    } 
  }
  
  public CTPercentage getRedArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(RED$34, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      return cTPercentage;
    } 
  }
  
  public int sizeOfRedArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(RED$34);
    } 
  }
  
  public void setRedArray(CTPercentage[] paramArrayOfCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPercentage, RED$34);
    } 
  }
  
  public void setRedArray(int paramInt, CTPercentage paramCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(RED$34, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      cTPercentage.set((XmlObject)paramCTPercentage);
    } 
  }
  
  public CTPercentage insertNewRed(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().insert_element_user(RED$34, paramInt);
      return cTPercentage;
    } 
  }
  
  public CTPercentage addNewRed() {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().add_element_user(RED$34);
      return cTPercentage;
    } 
  }
  
  public void removeRed(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RED$34, paramInt);
    } 
  }
  
  public List<CTPercentage> getRedOffList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPercentage>)new RedOffList(this);
    } 
  }
  
  public CTPercentage[] getRedOffArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(REDOFF$36, arrayList);
      CTPercentage[] arrayOfCTPercentage = new CTPercentage[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPercentage);
      return arrayOfCTPercentage;
    } 
  }
  
  public CTPercentage getRedOffArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(REDOFF$36, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      return cTPercentage;
    } 
  }
  
  public int sizeOfRedOffArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(REDOFF$36);
    } 
  }
  
  public void setRedOffArray(CTPercentage[] paramArrayOfCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPercentage, REDOFF$36);
    } 
  }
  
  public void setRedOffArray(int paramInt, CTPercentage paramCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(REDOFF$36, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      cTPercentage.set((XmlObject)paramCTPercentage);
    } 
  }
  
  public CTPercentage insertNewRedOff(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().insert_element_user(REDOFF$36, paramInt);
      return cTPercentage;
    } 
  }
  
  public CTPercentage addNewRedOff() {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().add_element_user(REDOFF$36);
      return cTPercentage;
    } 
  }
  
  public void removeRedOff(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(REDOFF$36, paramInt);
    } 
  }
  
  public List<CTPercentage> getRedModList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPercentage>)new RedModList(this);
    } 
  }
  
  public CTPercentage[] getRedModArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(REDMOD$38, arrayList);
      CTPercentage[] arrayOfCTPercentage = new CTPercentage[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPercentage);
      return arrayOfCTPercentage;
    } 
  }
  
  public CTPercentage getRedModArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(REDMOD$38, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      return cTPercentage;
    } 
  }
  
  public int sizeOfRedModArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(REDMOD$38);
    } 
  }
  
  public void setRedModArray(CTPercentage[] paramArrayOfCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPercentage, REDMOD$38);
    } 
  }
  
  public void setRedModArray(int paramInt, CTPercentage paramCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(REDMOD$38, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      cTPercentage.set((XmlObject)paramCTPercentage);
    } 
  }
  
  public CTPercentage insertNewRedMod(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().insert_element_user(REDMOD$38, paramInt);
      return cTPercentage;
    } 
  }
  
  public CTPercentage addNewRedMod() {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().add_element_user(REDMOD$38);
      return cTPercentage;
    } 
  }
  
  public void removeRedMod(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(REDMOD$38, paramInt);
    } 
  }
  
  public List<CTPercentage> getGreenList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPercentage>)new GreenList(this);
    } 
  }
  
  public CTPercentage[] getGreenArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(GREEN$40, arrayList);
      CTPercentage[] arrayOfCTPercentage = new CTPercentage[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPercentage);
      return arrayOfCTPercentage;
    } 
  }
  
  public CTPercentage getGreenArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(GREEN$40, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      return cTPercentage;
    } 
  }
  
  public int sizeOfGreenArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(GREEN$40);
    } 
  }
  
  public void setGreenArray(CTPercentage[] paramArrayOfCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPercentage, GREEN$40);
    } 
  }
  
  public void setGreenArray(int paramInt, CTPercentage paramCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(GREEN$40, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      cTPercentage.set((XmlObject)paramCTPercentage);
    } 
  }
  
  public CTPercentage insertNewGreen(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().insert_element_user(GREEN$40, paramInt);
      return cTPercentage;
    } 
  }
  
  public CTPercentage addNewGreen() {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().add_element_user(GREEN$40);
      return cTPercentage;
    } 
  }
  
  public void removeGreen(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GREEN$40, paramInt);
    } 
  }
  
  public List<CTPercentage> getGreenOffList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPercentage>)new GreenOffList(this);
    } 
  }
  
  public CTPercentage[] getGreenOffArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(GREENOFF$42, arrayList);
      CTPercentage[] arrayOfCTPercentage = new CTPercentage[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPercentage);
      return arrayOfCTPercentage;
    } 
  }
  
  public CTPercentage getGreenOffArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(GREENOFF$42, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      return cTPercentage;
    } 
  }
  
  public int sizeOfGreenOffArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(GREENOFF$42);
    } 
  }
  
  public void setGreenOffArray(CTPercentage[] paramArrayOfCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPercentage, GREENOFF$42);
    } 
  }
  
  public void setGreenOffArray(int paramInt, CTPercentage paramCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(GREENOFF$42, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      cTPercentage.set((XmlObject)paramCTPercentage);
    } 
  }
  
  public CTPercentage insertNewGreenOff(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().insert_element_user(GREENOFF$42, paramInt);
      return cTPercentage;
    } 
  }
  
  public CTPercentage addNewGreenOff() {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().add_element_user(GREENOFF$42);
      return cTPercentage;
    } 
  }
  
  public void removeGreenOff(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GREENOFF$42, paramInt);
    } 
  }
  
  public List<CTPercentage> getGreenModList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPercentage>)new GreenModList(this);
    } 
  }
  
  public CTPercentage[] getGreenModArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(GREENMOD$44, arrayList);
      CTPercentage[] arrayOfCTPercentage = new CTPercentage[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPercentage);
      return arrayOfCTPercentage;
    } 
  }
  
  public CTPercentage getGreenModArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(GREENMOD$44, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      return cTPercentage;
    } 
  }
  
  public int sizeOfGreenModArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(GREENMOD$44);
    } 
  }
  
  public void setGreenModArray(CTPercentage[] paramArrayOfCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPercentage, GREENMOD$44);
    } 
  }
  
  public void setGreenModArray(int paramInt, CTPercentage paramCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(GREENMOD$44, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      cTPercentage.set((XmlObject)paramCTPercentage);
    } 
  }
  
  public CTPercentage insertNewGreenMod(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().insert_element_user(GREENMOD$44, paramInt);
      return cTPercentage;
    } 
  }
  
  public CTPercentage addNewGreenMod() {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().add_element_user(GREENMOD$44);
      return cTPercentage;
    } 
  }
  
  public void removeGreenMod(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GREENMOD$44, paramInt);
    } 
  }
  
  public List<CTPercentage> getBlueList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPercentage>)new BlueList(this);
    } 
  }
  
  public CTPercentage[] getBlueArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BLUE$46, arrayList);
      CTPercentage[] arrayOfCTPercentage = new CTPercentage[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPercentage);
      return arrayOfCTPercentage;
    } 
  }
  
  public CTPercentage getBlueArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(BLUE$46, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      return cTPercentage;
    } 
  }
  
  public int sizeOfBlueArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BLUE$46);
    } 
  }
  
  public void setBlueArray(CTPercentage[] paramArrayOfCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPercentage, BLUE$46);
    } 
  }
  
  public void setBlueArray(int paramInt, CTPercentage paramCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(BLUE$46, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      cTPercentage.set((XmlObject)paramCTPercentage);
    } 
  }
  
  public CTPercentage insertNewBlue(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().insert_element_user(BLUE$46, paramInt);
      return cTPercentage;
    } 
  }
  
  public CTPercentage addNewBlue() {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().add_element_user(BLUE$46);
      return cTPercentage;
    } 
  }
  
  public void removeBlue(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BLUE$46, paramInt);
    } 
  }
  
  public List<CTPercentage> getBlueOffList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPercentage>)new BlueOffList(this);
    } 
  }
  
  public CTPercentage[] getBlueOffArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BLUEOFF$48, arrayList);
      CTPercentage[] arrayOfCTPercentage = new CTPercentage[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPercentage);
      return arrayOfCTPercentage;
    } 
  }
  
  public CTPercentage getBlueOffArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(BLUEOFF$48, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      return cTPercentage;
    } 
  }
  
  public int sizeOfBlueOffArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BLUEOFF$48);
    } 
  }
  
  public void setBlueOffArray(CTPercentage[] paramArrayOfCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPercentage, BLUEOFF$48);
    } 
  }
  
  public void setBlueOffArray(int paramInt, CTPercentage paramCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(BLUEOFF$48, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      cTPercentage.set((XmlObject)paramCTPercentage);
    } 
  }
  
  public CTPercentage insertNewBlueOff(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().insert_element_user(BLUEOFF$48, paramInt);
      return cTPercentage;
    } 
  }
  
  public CTPercentage addNewBlueOff() {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().add_element_user(BLUEOFF$48);
      return cTPercentage;
    } 
  }
  
  public void removeBlueOff(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BLUEOFF$48, paramInt);
    } 
  }
  
  public List<CTPercentage> getBlueModList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPercentage>)new BlueModList(this);
    } 
  }
  
  public CTPercentage[] getBlueModArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BLUEMOD$50, arrayList);
      CTPercentage[] arrayOfCTPercentage = new CTPercentage[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPercentage);
      return arrayOfCTPercentage;
    } 
  }
  
  public CTPercentage getBlueModArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(BLUEMOD$50, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      return cTPercentage;
    } 
  }
  
  public int sizeOfBlueModArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BLUEMOD$50);
    } 
  }
  
  public void setBlueModArray(CTPercentage[] paramArrayOfCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPercentage, BLUEMOD$50);
    } 
  }
  
  public void setBlueModArray(int paramInt, CTPercentage paramCTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().find_element_user(BLUEMOD$50, paramInt);
      if (cTPercentage == null)
        throw new IndexOutOfBoundsException(); 
      cTPercentage.set((XmlObject)paramCTPercentage);
    } 
  }
  
  public CTPercentage insertNewBlueMod(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().insert_element_user(BLUEMOD$50, paramInt);
      return cTPercentage;
    } 
  }
  
  public CTPercentage addNewBlueMod() {
    synchronized (monitor()) {
      check_orphaned();
      CTPercentage cTPercentage = null;
      cTPercentage = (CTPercentage)get_store().add_element_user(BLUEMOD$50);
      return cTPercentage;
    } 
  }
  
  public void removeBlueMod(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BLUEMOD$50, paramInt);
    } 
  }
  
  public List<CTGammaTransform> getGammaList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTGammaTransform>)new GammaList(this);
    } 
  }
  
  public CTGammaTransform[] getGammaArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(GAMMA$52, arrayList);
      CTGammaTransform[] arrayOfCTGammaTransform = new CTGammaTransform[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTGammaTransform);
      return arrayOfCTGammaTransform;
    } 
  }
  
  public CTGammaTransform getGammaArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTGammaTransform cTGammaTransform = null;
      cTGammaTransform = (CTGammaTransform)get_store().find_element_user(GAMMA$52, paramInt);
      if (cTGammaTransform == null)
        throw new IndexOutOfBoundsException(); 
      return cTGammaTransform;
    } 
  }
  
  public int sizeOfGammaArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(GAMMA$52);
    } 
  }
  
  public void setGammaArray(CTGammaTransform[] paramArrayOfCTGammaTransform) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTGammaTransform, GAMMA$52);
    } 
  }
  
  public void setGammaArray(int paramInt, CTGammaTransform paramCTGammaTransform) {
    synchronized (monitor()) {
      check_orphaned();
      CTGammaTransform cTGammaTransform = null;
      cTGammaTransform = (CTGammaTransform)get_store().find_element_user(GAMMA$52, paramInt);
      if (cTGammaTransform == null)
        throw new IndexOutOfBoundsException(); 
      cTGammaTransform.set((XmlObject)paramCTGammaTransform);
    } 
  }
  
  public CTGammaTransform insertNewGamma(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTGammaTransform cTGammaTransform = null;
      cTGammaTransform = (CTGammaTransform)get_store().insert_element_user(GAMMA$52, paramInt);
      return cTGammaTransform;
    } 
  }
  
  public CTGammaTransform addNewGamma() {
    synchronized (monitor()) {
      check_orphaned();
      CTGammaTransform cTGammaTransform = null;
      cTGammaTransform = (CTGammaTransform)get_store().add_element_user(GAMMA$52);
      return cTGammaTransform;
    } 
  }
  
  public void removeGamma(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GAMMA$52, paramInt);
    } 
  }
  
  public List<CTInverseGammaTransform> getInvGammaList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTInverseGammaTransform>)new InvGammaList(this);
    } 
  }
  
  public CTInverseGammaTransform[] getInvGammaArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(INVGAMMA$54, arrayList);
      CTInverseGammaTransform[] arrayOfCTInverseGammaTransform = new CTInverseGammaTransform[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTInverseGammaTransform);
      return arrayOfCTInverseGammaTransform;
    } 
  }
  
  public CTInverseGammaTransform getInvGammaArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTInverseGammaTransform cTInverseGammaTransform = null;
      cTInverseGammaTransform = (CTInverseGammaTransform)get_store().find_element_user(INVGAMMA$54, paramInt);
      if (cTInverseGammaTransform == null)
        throw new IndexOutOfBoundsException(); 
      return cTInverseGammaTransform;
    } 
  }
  
  public int sizeOfInvGammaArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(INVGAMMA$54);
    } 
  }
  
  public void setInvGammaArray(CTInverseGammaTransform[] paramArrayOfCTInverseGammaTransform) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTInverseGammaTransform, INVGAMMA$54);
    } 
  }
  
  public void setInvGammaArray(int paramInt, CTInverseGammaTransform paramCTInverseGammaTransform) {
    synchronized (monitor()) {
      check_orphaned();
      CTInverseGammaTransform cTInverseGammaTransform = null;
      cTInverseGammaTransform = (CTInverseGammaTransform)get_store().find_element_user(INVGAMMA$54, paramInt);
      if (cTInverseGammaTransform == null)
        throw new IndexOutOfBoundsException(); 
      cTInverseGammaTransform.set((XmlObject)paramCTInverseGammaTransform);
    } 
  }
  
  public CTInverseGammaTransform insertNewInvGamma(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTInverseGammaTransform cTInverseGammaTransform = null;
      cTInverseGammaTransform = (CTInverseGammaTransform)get_store().insert_element_user(INVGAMMA$54, paramInt);
      return cTInverseGammaTransform;
    } 
  }
  
  public CTInverseGammaTransform addNewInvGamma() {
    synchronized (monitor()) {
      check_orphaned();
      CTInverseGammaTransform cTInverseGammaTransform = null;
      cTInverseGammaTransform = (CTInverseGammaTransform)get_store().add_element_user(INVGAMMA$54);
      return cTInverseGammaTransform;
    } 
  }
  
  public void removeInvGamma(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(INVGAMMA$54, paramInt);
    } 
  }
  
  public STPresetColorVal.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$56);
      if (simpleValue == null)
        return null; 
      return (STPresetColorVal.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STPresetColorVal xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STPresetColorVal sTPresetColorVal = null;
      sTPresetColorVal = (STPresetColorVal)get_store().find_attribute_user(VAL$56);
      return sTPresetColorVal;
    } 
  }
  
  public boolean isSetVal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VAL$56) != null);
    } 
  }
  
  public void setVal(STPresetColorVal.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$56);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$56); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STPresetColorVal paramSTPresetColorVal) {
    synchronized (monitor()) {
      check_orphaned();
      STPresetColorVal sTPresetColorVal = null;
      sTPresetColorVal = (STPresetColorVal)get_store().find_attribute_user(VAL$56);
      if (sTPresetColorVal == null)
        sTPresetColorVal = (STPresetColorVal)get_store().add_attribute_user(VAL$56); 
      sTPresetColorVal.set((XmlObject)paramSTPresetColorVal);
    } 
  }
  
  public void unsetVal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VAL$56);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTPresetColorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */