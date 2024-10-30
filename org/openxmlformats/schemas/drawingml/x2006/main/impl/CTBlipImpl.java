package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaBiLevelEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaCeilingEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaFloorEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaInverseEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaModulateEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaModulateFixedEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaReplaceEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBiLevelEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlurEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorChangeEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorReplaceEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTDuotoneEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFillOverlayEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGrayscaleEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHSLEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLuminanceEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTintEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.STBlipCompression;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;

public class CTBlipImpl extends XmlComplexContentImpl implements CTBlip {
  private static final b ALPHABILEVEL$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaBiLevel");
  
  private static final b ALPHACEILING$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaCeiling");
  
  private static final b ALPHAFLOOR$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaFloor");
  
  private static final b ALPHAINV$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaInv");
  
  private static final b ALPHAMOD$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaMod");
  
  private static final b ALPHAMODFIX$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaModFix");
  
  private static final b ALPHAREPL$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaRepl");
  
  private static final b BILEVEL$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "biLevel");
  
  private static final b BLUR$16 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "blur");
  
  private static final b CLRCHANGE$18 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "clrChange");
  
  private static final b CLRREPL$20 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "clrRepl");
  
  private static final b DUOTONE$22 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "duotone");
  
  private static final b FILLOVERLAY$24 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "fillOverlay");
  
  private static final b GRAYSCL$26 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "grayscl");
  
  private static final b HSL$28 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "hsl");
  
  private static final b LUM$30 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lum");
  
  private static final b TINT$32 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tint");
  
  private static final b EXTLST$34 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  private static final b EMBED$36 = new b("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "embed");
  
  private static final b LINK$38 = new b("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "link");
  
  private static final b CSTATE$40 = new b("", "cstate");
  
  public CTBlipImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTAlphaBiLevelEffect> getAlphaBiLevelList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTAlphaBiLevelEffect>)new AlphaBiLevelList(this);
    } 
  }
  
  public CTAlphaBiLevelEffect[] getAlphaBiLevelArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ALPHABILEVEL$0, arrayList);
      CTAlphaBiLevelEffect[] arrayOfCTAlphaBiLevelEffect = new CTAlphaBiLevelEffect[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTAlphaBiLevelEffect);
      return arrayOfCTAlphaBiLevelEffect;
    } 
  }
  
  public CTAlphaBiLevelEffect getAlphaBiLevelArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaBiLevelEffect cTAlphaBiLevelEffect = null;
      cTAlphaBiLevelEffect = (CTAlphaBiLevelEffect)get_store().find_element_user(ALPHABILEVEL$0, paramInt);
      if (cTAlphaBiLevelEffect == null)
        throw new IndexOutOfBoundsException(); 
      return cTAlphaBiLevelEffect;
    } 
  }
  
  public int sizeOfAlphaBiLevelArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ALPHABILEVEL$0);
    } 
  }
  
  public void setAlphaBiLevelArray(CTAlphaBiLevelEffect[] paramArrayOfCTAlphaBiLevelEffect) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTAlphaBiLevelEffect, ALPHABILEVEL$0);
    } 
  }
  
  public void setAlphaBiLevelArray(int paramInt, CTAlphaBiLevelEffect paramCTAlphaBiLevelEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaBiLevelEffect cTAlphaBiLevelEffect = null;
      cTAlphaBiLevelEffect = (CTAlphaBiLevelEffect)get_store().find_element_user(ALPHABILEVEL$0, paramInt);
      if (cTAlphaBiLevelEffect == null)
        throw new IndexOutOfBoundsException(); 
      cTAlphaBiLevelEffect.set((XmlObject)paramCTAlphaBiLevelEffect);
    } 
  }
  
  public CTAlphaBiLevelEffect insertNewAlphaBiLevel(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaBiLevelEffect cTAlphaBiLevelEffect = null;
      cTAlphaBiLevelEffect = (CTAlphaBiLevelEffect)get_store().insert_element_user(ALPHABILEVEL$0, paramInt);
      return cTAlphaBiLevelEffect;
    } 
  }
  
  public CTAlphaBiLevelEffect addNewAlphaBiLevel() {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaBiLevelEffect cTAlphaBiLevelEffect = null;
      cTAlphaBiLevelEffect = (CTAlphaBiLevelEffect)get_store().add_element_user(ALPHABILEVEL$0);
      return cTAlphaBiLevelEffect;
    } 
  }
  
  public void removeAlphaBiLevel(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ALPHABILEVEL$0, paramInt);
    } 
  }
  
  public List<CTAlphaCeilingEffect> getAlphaCeilingList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTAlphaCeilingEffect>)new AlphaCeilingList(this);
    } 
  }
  
  public CTAlphaCeilingEffect[] getAlphaCeilingArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ALPHACEILING$2, arrayList);
      CTAlphaCeilingEffect[] arrayOfCTAlphaCeilingEffect = new CTAlphaCeilingEffect[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTAlphaCeilingEffect);
      return arrayOfCTAlphaCeilingEffect;
    } 
  }
  
  public CTAlphaCeilingEffect getAlphaCeilingArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaCeilingEffect cTAlphaCeilingEffect = null;
      cTAlphaCeilingEffect = (CTAlphaCeilingEffect)get_store().find_element_user(ALPHACEILING$2, paramInt);
      if (cTAlphaCeilingEffect == null)
        throw new IndexOutOfBoundsException(); 
      return cTAlphaCeilingEffect;
    } 
  }
  
  public int sizeOfAlphaCeilingArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ALPHACEILING$2);
    } 
  }
  
  public void setAlphaCeilingArray(CTAlphaCeilingEffect[] paramArrayOfCTAlphaCeilingEffect) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTAlphaCeilingEffect, ALPHACEILING$2);
    } 
  }
  
  public void setAlphaCeilingArray(int paramInt, CTAlphaCeilingEffect paramCTAlphaCeilingEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaCeilingEffect cTAlphaCeilingEffect = null;
      cTAlphaCeilingEffect = (CTAlphaCeilingEffect)get_store().find_element_user(ALPHACEILING$2, paramInt);
      if (cTAlphaCeilingEffect == null)
        throw new IndexOutOfBoundsException(); 
      cTAlphaCeilingEffect.set((XmlObject)paramCTAlphaCeilingEffect);
    } 
  }
  
  public CTAlphaCeilingEffect insertNewAlphaCeiling(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaCeilingEffect cTAlphaCeilingEffect = null;
      cTAlphaCeilingEffect = (CTAlphaCeilingEffect)get_store().insert_element_user(ALPHACEILING$2, paramInt);
      return cTAlphaCeilingEffect;
    } 
  }
  
  public CTAlphaCeilingEffect addNewAlphaCeiling() {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaCeilingEffect cTAlphaCeilingEffect = null;
      cTAlphaCeilingEffect = (CTAlphaCeilingEffect)get_store().add_element_user(ALPHACEILING$2);
      return cTAlphaCeilingEffect;
    } 
  }
  
  public void removeAlphaCeiling(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ALPHACEILING$2, paramInt);
    } 
  }
  
  public List<CTAlphaFloorEffect> getAlphaFloorList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTAlphaFloorEffect>)new AlphaFloorList(this);
    } 
  }
  
  public CTAlphaFloorEffect[] getAlphaFloorArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ALPHAFLOOR$4, arrayList);
      CTAlphaFloorEffect[] arrayOfCTAlphaFloorEffect = new CTAlphaFloorEffect[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTAlphaFloorEffect);
      return arrayOfCTAlphaFloorEffect;
    } 
  }
  
  public CTAlphaFloorEffect getAlphaFloorArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaFloorEffect cTAlphaFloorEffect = null;
      cTAlphaFloorEffect = (CTAlphaFloorEffect)get_store().find_element_user(ALPHAFLOOR$4, paramInt);
      if (cTAlphaFloorEffect == null)
        throw new IndexOutOfBoundsException(); 
      return cTAlphaFloorEffect;
    } 
  }
  
  public int sizeOfAlphaFloorArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ALPHAFLOOR$4);
    } 
  }
  
  public void setAlphaFloorArray(CTAlphaFloorEffect[] paramArrayOfCTAlphaFloorEffect) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTAlphaFloorEffect, ALPHAFLOOR$4);
    } 
  }
  
  public void setAlphaFloorArray(int paramInt, CTAlphaFloorEffect paramCTAlphaFloorEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaFloorEffect cTAlphaFloorEffect = null;
      cTAlphaFloorEffect = (CTAlphaFloorEffect)get_store().find_element_user(ALPHAFLOOR$4, paramInt);
      if (cTAlphaFloorEffect == null)
        throw new IndexOutOfBoundsException(); 
      cTAlphaFloorEffect.set((XmlObject)paramCTAlphaFloorEffect);
    } 
  }
  
  public CTAlphaFloorEffect insertNewAlphaFloor(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaFloorEffect cTAlphaFloorEffect = null;
      cTAlphaFloorEffect = (CTAlphaFloorEffect)get_store().insert_element_user(ALPHAFLOOR$4, paramInt);
      return cTAlphaFloorEffect;
    } 
  }
  
  public CTAlphaFloorEffect addNewAlphaFloor() {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaFloorEffect cTAlphaFloorEffect = null;
      cTAlphaFloorEffect = (CTAlphaFloorEffect)get_store().add_element_user(ALPHAFLOOR$4);
      return cTAlphaFloorEffect;
    } 
  }
  
  public void removeAlphaFloor(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ALPHAFLOOR$4, paramInt);
    } 
  }
  
  public List<CTAlphaInverseEffect> getAlphaInvList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTAlphaInverseEffect>)new AlphaInvList(this);
    } 
  }
  
  public CTAlphaInverseEffect[] getAlphaInvArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ALPHAINV$6, arrayList);
      CTAlphaInverseEffect[] arrayOfCTAlphaInverseEffect = new CTAlphaInverseEffect[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTAlphaInverseEffect);
      return arrayOfCTAlphaInverseEffect;
    } 
  }
  
  public CTAlphaInverseEffect getAlphaInvArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaInverseEffect cTAlphaInverseEffect = null;
      cTAlphaInverseEffect = (CTAlphaInverseEffect)get_store().find_element_user(ALPHAINV$6, paramInt);
      if (cTAlphaInverseEffect == null)
        throw new IndexOutOfBoundsException(); 
      return cTAlphaInverseEffect;
    } 
  }
  
  public int sizeOfAlphaInvArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ALPHAINV$6);
    } 
  }
  
  public void setAlphaInvArray(CTAlphaInverseEffect[] paramArrayOfCTAlphaInverseEffect) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTAlphaInverseEffect, ALPHAINV$6);
    } 
  }
  
  public void setAlphaInvArray(int paramInt, CTAlphaInverseEffect paramCTAlphaInverseEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaInverseEffect cTAlphaInverseEffect = null;
      cTAlphaInverseEffect = (CTAlphaInverseEffect)get_store().find_element_user(ALPHAINV$6, paramInt);
      if (cTAlphaInverseEffect == null)
        throw new IndexOutOfBoundsException(); 
      cTAlphaInverseEffect.set((XmlObject)paramCTAlphaInverseEffect);
    } 
  }
  
  public CTAlphaInverseEffect insertNewAlphaInv(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaInverseEffect cTAlphaInverseEffect = null;
      cTAlphaInverseEffect = (CTAlphaInverseEffect)get_store().insert_element_user(ALPHAINV$6, paramInt);
      return cTAlphaInverseEffect;
    } 
  }
  
  public CTAlphaInverseEffect addNewAlphaInv() {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaInverseEffect cTAlphaInverseEffect = null;
      cTAlphaInverseEffect = (CTAlphaInverseEffect)get_store().add_element_user(ALPHAINV$6);
      return cTAlphaInverseEffect;
    } 
  }
  
  public void removeAlphaInv(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ALPHAINV$6, paramInt);
    } 
  }
  
  public List<CTAlphaModulateEffect> getAlphaModList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTAlphaModulateEffect>)new AlphaModList(this);
    } 
  }
  
  public CTAlphaModulateEffect[] getAlphaModArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ALPHAMOD$8, arrayList);
      CTAlphaModulateEffect[] arrayOfCTAlphaModulateEffect = new CTAlphaModulateEffect[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTAlphaModulateEffect);
      return arrayOfCTAlphaModulateEffect;
    } 
  }
  
  public CTAlphaModulateEffect getAlphaModArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaModulateEffect cTAlphaModulateEffect = null;
      cTAlphaModulateEffect = (CTAlphaModulateEffect)get_store().find_element_user(ALPHAMOD$8, paramInt);
      if (cTAlphaModulateEffect == null)
        throw new IndexOutOfBoundsException(); 
      return cTAlphaModulateEffect;
    } 
  }
  
  public int sizeOfAlphaModArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ALPHAMOD$8);
    } 
  }
  
  public void setAlphaModArray(CTAlphaModulateEffect[] paramArrayOfCTAlphaModulateEffect) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTAlphaModulateEffect, ALPHAMOD$8);
    } 
  }
  
  public void setAlphaModArray(int paramInt, CTAlphaModulateEffect paramCTAlphaModulateEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaModulateEffect cTAlphaModulateEffect = null;
      cTAlphaModulateEffect = (CTAlphaModulateEffect)get_store().find_element_user(ALPHAMOD$8, paramInt);
      if (cTAlphaModulateEffect == null)
        throw new IndexOutOfBoundsException(); 
      cTAlphaModulateEffect.set((XmlObject)paramCTAlphaModulateEffect);
    } 
  }
  
  public CTAlphaModulateEffect insertNewAlphaMod(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaModulateEffect cTAlphaModulateEffect = null;
      cTAlphaModulateEffect = (CTAlphaModulateEffect)get_store().insert_element_user(ALPHAMOD$8, paramInt);
      return cTAlphaModulateEffect;
    } 
  }
  
  public CTAlphaModulateEffect addNewAlphaMod() {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaModulateEffect cTAlphaModulateEffect = null;
      cTAlphaModulateEffect = (CTAlphaModulateEffect)get_store().add_element_user(ALPHAMOD$8);
      return cTAlphaModulateEffect;
    } 
  }
  
  public void removeAlphaMod(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ALPHAMOD$8, paramInt);
    } 
  }
  
  public List<CTAlphaModulateFixedEffect> getAlphaModFixList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTAlphaModulateFixedEffect>)new AlphaModFixList(this);
    } 
  }
  
  public CTAlphaModulateFixedEffect[] getAlphaModFixArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ALPHAMODFIX$10, arrayList);
      CTAlphaModulateFixedEffect[] arrayOfCTAlphaModulateFixedEffect = new CTAlphaModulateFixedEffect[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTAlphaModulateFixedEffect);
      return arrayOfCTAlphaModulateFixedEffect;
    } 
  }
  
  public CTAlphaModulateFixedEffect getAlphaModFixArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect = null;
      cTAlphaModulateFixedEffect = (CTAlphaModulateFixedEffect)get_store().find_element_user(ALPHAMODFIX$10, paramInt);
      if (cTAlphaModulateFixedEffect == null)
        throw new IndexOutOfBoundsException(); 
      return cTAlphaModulateFixedEffect;
    } 
  }
  
  public int sizeOfAlphaModFixArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ALPHAMODFIX$10);
    } 
  }
  
  public void setAlphaModFixArray(CTAlphaModulateFixedEffect[] paramArrayOfCTAlphaModulateFixedEffect) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTAlphaModulateFixedEffect, ALPHAMODFIX$10);
    } 
  }
  
  public void setAlphaModFixArray(int paramInt, CTAlphaModulateFixedEffect paramCTAlphaModulateFixedEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect = null;
      cTAlphaModulateFixedEffect = (CTAlphaModulateFixedEffect)get_store().find_element_user(ALPHAMODFIX$10, paramInt);
      if (cTAlphaModulateFixedEffect == null)
        throw new IndexOutOfBoundsException(); 
      cTAlphaModulateFixedEffect.set((XmlObject)paramCTAlphaModulateFixedEffect);
    } 
  }
  
  public CTAlphaModulateFixedEffect insertNewAlphaModFix(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect = null;
      cTAlphaModulateFixedEffect = (CTAlphaModulateFixedEffect)get_store().insert_element_user(ALPHAMODFIX$10, paramInt);
      return cTAlphaModulateFixedEffect;
    } 
  }
  
  public CTAlphaModulateFixedEffect addNewAlphaModFix() {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect = null;
      cTAlphaModulateFixedEffect = (CTAlphaModulateFixedEffect)get_store().add_element_user(ALPHAMODFIX$10);
      return cTAlphaModulateFixedEffect;
    } 
  }
  
  public void removeAlphaModFix(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ALPHAMODFIX$10, paramInt);
    } 
  }
  
  public List<CTAlphaReplaceEffect> getAlphaReplList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTAlphaReplaceEffect>)new AlphaReplList(this);
    } 
  }
  
  public CTAlphaReplaceEffect[] getAlphaReplArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ALPHAREPL$12, arrayList);
      CTAlphaReplaceEffect[] arrayOfCTAlphaReplaceEffect = new CTAlphaReplaceEffect[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTAlphaReplaceEffect);
      return arrayOfCTAlphaReplaceEffect;
    } 
  }
  
  public CTAlphaReplaceEffect getAlphaReplArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaReplaceEffect cTAlphaReplaceEffect = null;
      cTAlphaReplaceEffect = (CTAlphaReplaceEffect)get_store().find_element_user(ALPHAREPL$12, paramInt);
      if (cTAlphaReplaceEffect == null)
        throw new IndexOutOfBoundsException(); 
      return cTAlphaReplaceEffect;
    } 
  }
  
  public int sizeOfAlphaReplArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ALPHAREPL$12);
    } 
  }
  
  public void setAlphaReplArray(CTAlphaReplaceEffect[] paramArrayOfCTAlphaReplaceEffect) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTAlphaReplaceEffect, ALPHAREPL$12);
    } 
  }
  
  public void setAlphaReplArray(int paramInt, CTAlphaReplaceEffect paramCTAlphaReplaceEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaReplaceEffect cTAlphaReplaceEffect = null;
      cTAlphaReplaceEffect = (CTAlphaReplaceEffect)get_store().find_element_user(ALPHAREPL$12, paramInt);
      if (cTAlphaReplaceEffect == null)
        throw new IndexOutOfBoundsException(); 
      cTAlphaReplaceEffect.set((XmlObject)paramCTAlphaReplaceEffect);
    } 
  }
  
  public CTAlphaReplaceEffect insertNewAlphaRepl(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaReplaceEffect cTAlphaReplaceEffect = null;
      cTAlphaReplaceEffect = (CTAlphaReplaceEffect)get_store().insert_element_user(ALPHAREPL$12, paramInt);
      return cTAlphaReplaceEffect;
    } 
  }
  
  public CTAlphaReplaceEffect addNewAlphaRepl() {
    synchronized (monitor()) {
      check_orphaned();
      CTAlphaReplaceEffect cTAlphaReplaceEffect = null;
      cTAlphaReplaceEffect = (CTAlphaReplaceEffect)get_store().add_element_user(ALPHAREPL$12);
      return cTAlphaReplaceEffect;
    } 
  }
  
  public void removeAlphaRepl(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ALPHAREPL$12, paramInt);
    } 
  }
  
  public List<CTBiLevelEffect> getBiLevelList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBiLevelEffect>)new BiLevelList(this);
    } 
  }
  
  public CTBiLevelEffect[] getBiLevelArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BILEVEL$14, arrayList);
      CTBiLevelEffect[] arrayOfCTBiLevelEffect = new CTBiLevelEffect[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBiLevelEffect);
      return arrayOfCTBiLevelEffect;
    } 
  }
  
  public CTBiLevelEffect getBiLevelArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBiLevelEffect cTBiLevelEffect = null;
      cTBiLevelEffect = (CTBiLevelEffect)get_store().find_element_user(BILEVEL$14, paramInt);
      if (cTBiLevelEffect == null)
        throw new IndexOutOfBoundsException(); 
      return cTBiLevelEffect;
    } 
  }
  
  public int sizeOfBiLevelArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BILEVEL$14);
    } 
  }
  
  public void setBiLevelArray(CTBiLevelEffect[] paramArrayOfCTBiLevelEffect) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBiLevelEffect, BILEVEL$14);
    } 
  }
  
  public void setBiLevelArray(int paramInt, CTBiLevelEffect paramCTBiLevelEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTBiLevelEffect cTBiLevelEffect = null;
      cTBiLevelEffect = (CTBiLevelEffect)get_store().find_element_user(BILEVEL$14, paramInt);
      if (cTBiLevelEffect == null)
        throw new IndexOutOfBoundsException(); 
      cTBiLevelEffect.set((XmlObject)paramCTBiLevelEffect);
    } 
  }
  
  public CTBiLevelEffect insertNewBiLevel(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBiLevelEffect cTBiLevelEffect = null;
      cTBiLevelEffect = (CTBiLevelEffect)get_store().insert_element_user(BILEVEL$14, paramInt);
      return cTBiLevelEffect;
    } 
  }
  
  public CTBiLevelEffect addNewBiLevel() {
    synchronized (monitor()) {
      check_orphaned();
      CTBiLevelEffect cTBiLevelEffect = null;
      cTBiLevelEffect = (CTBiLevelEffect)get_store().add_element_user(BILEVEL$14);
      return cTBiLevelEffect;
    } 
  }
  
  public void removeBiLevel(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BILEVEL$14, paramInt);
    } 
  }
  
  public List<CTBlurEffect> getBlurList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBlurEffect>)new BlurList(this);
    } 
  }
  
  public CTBlurEffect[] getBlurArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BLUR$16, arrayList);
      CTBlurEffect[] arrayOfCTBlurEffect = new CTBlurEffect[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBlurEffect);
      return arrayOfCTBlurEffect;
    } 
  }
  
  public CTBlurEffect getBlurArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBlurEffect cTBlurEffect = null;
      cTBlurEffect = (CTBlurEffect)get_store().find_element_user(BLUR$16, paramInt);
      if (cTBlurEffect == null)
        throw new IndexOutOfBoundsException(); 
      return cTBlurEffect;
    } 
  }
  
  public int sizeOfBlurArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BLUR$16);
    } 
  }
  
  public void setBlurArray(CTBlurEffect[] paramArrayOfCTBlurEffect) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBlurEffect, BLUR$16);
    } 
  }
  
  public void setBlurArray(int paramInt, CTBlurEffect paramCTBlurEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTBlurEffect cTBlurEffect = null;
      cTBlurEffect = (CTBlurEffect)get_store().find_element_user(BLUR$16, paramInt);
      if (cTBlurEffect == null)
        throw new IndexOutOfBoundsException(); 
      cTBlurEffect.set((XmlObject)paramCTBlurEffect);
    } 
  }
  
  public CTBlurEffect insertNewBlur(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBlurEffect cTBlurEffect = null;
      cTBlurEffect = (CTBlurEffect)get_store().insert_element_user(BLUR$16, paramInt);
      return cTBlurEffect;
    } 
  }
  
  public CTBlurEffect addNewBlur() {
    synchronized (monitor()) {
      check_orphaned();
      CTBlurEffect cTBlurEffect = null;
      cTBlurEffect = (CTBlurEffect)get_store().add_element_user(BLUR$16);
      return cTBlurEffect;
    } 
  }
  
  public void removeBlur(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BLUR$16, paramInt);
    } 
  }
  
  public List<CTColorChangeEffect> getClrChangeList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTColorChangeEffect>)new ClrChangeList(this);
    } 
  }
  
  public CTColorChangeEffect[] getClrChangeArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CLRCHANGE$18, arrayList);
      CTColorChangeEffect[] arrayOfCTColorChangeEffect = new CTColorChangeEffect[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTColorChangeEffect);
      return arrayOfCTColorChangeEffect;
    } 
  }
  
  public CTColorChangeEffect getClrChangeArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTColorChangeEffect cTColorChangeEffect = null;
      cTColorChangeEffect = (CTColorChangeEffect)get_store().find_element_user(CLRCHANGE$18, paramInt);
      if (cTColorChangeEffect == null)
        throw new IndexOutOfBoundsException(); 
      return cTColorChangeEffect;
    } 
  }
  
  public int sizeOfClrChangeArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CLRCHANGE$18);
    } 
  }
  
  public void setClrChangeArray(CTColorChangeEffect[] paramArrayOfCTColorChangeEffect) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTColorChangeEffect, CLRCHANGE$18);
    } 
  }
  
  public void setClrChangeArray(int paramInt, CTColorChangeEffect paramCTColorChangeEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTColorChangeEffect cTColorChangeEffect = null;
      cTColorChangeEffect = (CTColorChangeEffect)get_store().find_element_user(CLRCHANGE$18, paramInt);
      if (cTColorChangeEffect == null)
        throw new IndexOutOfBoundsException(); 
      cTColorChangeEffect.set((XmlObject)paramCTColorChangeEffect);
    } 
  }
  
  public CTColorChangeEffect insertNewClrChange(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTColorChangeEffect cTColorChangeEffect = null;
      cTColorChangeEffect = (CTColorChangeEffect)get_store().insert_element_user(CLRCHANGE$18, paramInt);
      return cTColorChangeEffect;
    } 
  }
  
  public CTColorChangeEffect addNewClrChange() {
    synchronized (monitor()) {
      check_orphaned();
      CTColorChangeEffect cTColorChangeEffect = null;
      cTColorChangeEffect = (CTColorChangeEffect)get_store().add_element_user(CLRCHANGE$18);
      return cTColorChangeEffect;
    } 
  }
  
  public void removeClrChange(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CLRCHANGE$18, paramInt);
    } 
  }
  
  public List<CTColorReplaceEffect> getClrReplList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTColorReplaceEffect>)new ClrReplList(this);
    } 
  }
  
  public CTColorReplaceEffect[] getClrReplArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CLRREPL$20, arrayList);
      CTColorReplaceEffect[] arrayOfCTColorReplaceEffect = new CTColorReplaceEffect[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTColorReplaceEffect);
      return arrayOfCTColorReplaceEffect;
    } 
  }
  
  public CTColorReplaceEffect getClrReplArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTColorReplaceEffect cTColorReplaceEffect = null;
      cTColorReplaceEffect = (CTColorReplaceEffect)get_store().find_element_user(CLRREPL$20, paramInt);
      if (cTColorReplaceEffect == null)
        throw new IndexOutOfBoundsException(); 
      return cTColorReplaceEffect;
    } 
  }
  
  public int sizeOfClrReplArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CLRREPL$20);
    } 
  }
  
  public void setClrReplArray(CTColorReplaceEffect[] paramArrayOfCTColorReplaceEffect) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTColorReplaceEffect, CLRREPL$20);
    } 
  }
  
  public void setClrReplArray(int paramInt, CTColorReplaceEffect paramCTColorReplaceEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTColorReplaceEffect cTColorReplaceEffect = null;
      cTColorReplaceEffect = (CTColorReplaceEffect)get_store().find_element_user(CLRREPL$20, paramInt);
      if (cTColorReplaceEffect == null)
        throw new IndexOutOfBoundsException(); 
      cTColorReplaceEffect.set((XmlObject)paramCTColorReplaceEffect);
    } 
  }
  
  public CTColorReplaceEffect insertNewClrRepl(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTColorReplaceEffect cTColorReplaceEffect = null;
      cTColorReplaceEffect = (CTColorReplaceEffect)get_store().insert_element_user(CLRREPL$20, paramInt);
      return cTColorReplaceEffect;
    } 
  }
  
  public CTColorReplaceEffect addNewClrRepl() {
    synchronized (monitor()) {
      check_orphaned();
      CTColorReplaceEffect cTColorReplaceEffect = null;
      cTColorReplaceEffect = (CTColorReplaceEffect)get_store().add_element_user(CLRREPL$20);
      return cTColorReplaceEffect;
    } 
  }
  
  public void removeClrRepl(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CLRREPL$20, paramInt);
    } 
  }
  
  public List<CTDuotoneEffect> getDuotoneList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTDuotoneEffect>)new DuotoneList(this);
    } 
  }
  
  public CTDuotoneEffect[] getDuotoneArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DUOTONE$22, arrayList);
      CTDuotoneEffect[] arrayOfCTDuotoneEffect = new CTDuotoneEffect[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTDuotoneEffect);
      return arrayOfCTDuotoneEffect;
    } 
  }
  
  public CTDuotoneEffect getDuotoneArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDuotoneEffect cTDuotoneEffect = null;
      cTDuotoneEffect = (CTDuotoneEffect)get_store().find_element_user(DUOTONE$22, paramInt);
      if (cTDuotoneEffect == null)
        throw new IndexOutOfBoundsException(); 
      return cTDuotoneEffect;
    } 
  }
  
  public int sizeOfDuotoneArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DUOTONE$22);
    } 
  }
  
  public void setDuotoneArray(CTDuotoneEffect[] paramArrayOfCTDuotoneEffect) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTDuotoneEffect, DUOTONE$22);
    } 
  }
  
  public void setDuotoneArray(int paramInt, CTDuotoneEffect paramCTDuotoneEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTDuotoneEffect cTDuotoneEffect = null;
      cTDuotoneEffect = (CTDuotoneEffect)get_store().find_element_user(DUOTONE$22, paramInt);
      if (cTDuotoneEffect == null)
        throw new IndexOutOfBoundsException(); 
      cTDuotoneEffect.set((XmlObject)paramCTDuotoneEffect);
    } 
  }
  
  public CTDuotoneEffect insertNewDuotone(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDuotoneEffect cTDuotoneEffect = null;
      cTDuotoneEffect = (CTDuotoneEffect)get_store().insert_element_user(DUOTONE$22, paramInt);
      return cTDuotoneEffect;
    } 
  }
  
  public CTDuotoneEffect addNewDuotone() {
    synchronized (monitor()) {
      check_orphaned();
      CTDuotoneEffect cTDuotoneEffect = null;
      cTDuotoneEffect = (CTDuotoneEffect)get_store().add_element_user(DUOTONE$22);
      return cTDuotoneEffect;
    } 
  }
  
  public void removeDuotone(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DUOTONE$22, paramInt);
    } 
  }
  
  public List<CTFillOverlayEffect> getFillOverlayList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTFillOverlayEffect>)new FillOverlayList(this);
    } 
  }
  
  public CTFillOverlayEffect[] getFillOverlayArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FILLOVERLAY$24, arrayList);
      CTFillOverlayEffect[] arrayOfCTFillOverlayEffect = new CTFillOverlayEffect[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTFillOverlayEffect);
      return arrayOfCTFillOverlayEffect;
    } 
  }
  
  public CTFillOverlayEffect getFillOverlayArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFillOverlayEffect cTFillOverlayEffect = null;
      cTFillOverlayEffect = (CTFillOverlayEffect)get_store().find_element_user(FILLOVERLAY$24, paramInt);
      if (cTFillOverlayEffect == null)
        throw new IndexOutOfBoundsException(); 
      return cTFillOverlayEffect;
    } 
  }
  
  public int sizeOfFillOverlayArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FILLOVERLAY$24);
    } 
  }
  
  public void setFillOverlayArray(CTFillOverlayEffect[] paramArrayOfCTFillOverlayEffect) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTFillOverlayEffect, FILLOVERLAY$24);
    } 
  }
  
  public void setFillOverlayArray(int paramInt, CTFillOverlayEffect paramCTFillOverlayEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTFillOverlayEffect cTFillOverlayEffect = null;
      cTFillOverlayEffect = (CTFillOverlayEffect)get_store().find_element_user(FILLOVERLAY$24, paramInt);
      if (cTFillOverlayEffect == null)
        throw new IndexOutOfBoundsException(); 
      cTFillOverlayEffect.set((XmlObject)paramCTFillOverlayEffect);
    } 
  }
  
  public CTFillOverlayEffect insertNewFillOverlay(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFillOverlayEffect cTFillOverlayEffect = null;
      cTFillOverlayEffect = (CTFillOverlayEffect)get_store().insert_element_user(FILLOVERLAY$24, paramInt);
      return cTFillOverlayEffect;
    } 
  }
  
  public CTFillOverlayEffect addNewFillOverlay() {
    synchronized (monitor()) {
      check_orphaned();
      CTFillOverlayEffect cTFillOverlayEffect = null;
      cTFillOverlayEffect = (CTFillOverlayEffect)get_store().add_element_user(FILLOVERLAY$24);
      return cTFillOverlayEffect;
    } 
  }
  
  public void removeFillOverlay(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FILLOVERLAY$24, paramInt);
    } 
  }
  
  public List<CTGrayscaleEffect> getGraysclList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTGrayscaleEffect>)new GraysclList(this);
    } 
  }
  
  public CTGrayscaleEffect[] getGraysclArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(GRAYSCL$26, arrayList);
      CTGrayscaleEffect[] arrayOfCTGrayscaleEffect = new CTGrayscaleEffect[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTGrayscaleEffect);
      return arrayOfCTGrayscaleEffect;
    } 
  }
  
  public CTGrayscaleEffect getGraysclArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTGrayscaleEffect cTGrayscaleEffect = null;
      cTGrayscaleEffect = (CTGrayscaleEffect)get_store().find_element_user(GRAYSCL$26, paramInt);
      if (cTGrayscaleEffect == null)
        throw new IndexOutOfBoundsException(); 
      return cTGrayscaleEffect;
    } 
  }
  
  public int sizeOfGraysclArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(GRAYSCL$26);
    } 
  }
  
  public void setGraysclArray(CTGrayscaleEffect[] paramArrayOfCTGrayscaleEffect) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTGrayscaleEffect, GRAYSCL$26);
    } 
  }
  
  public void setGraysclArray(int paramInt, CTGrayscaleEffect paramCTGrayscaleEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTGrayscaleEffect cTGrayscaleEffect = null;
      cTGrayscaleEffect = (CTGrayscaleEffect)get_store().find_element_user(GRAYSCL$26, paramInt);
      if (cTGrayscaleEffect == null)
        throw new IndexOutOfBoundsException(); 
      cTGrayscaleEffect.set((XmlObject)paramCTGrayscaleEffect);
    } 
  }
  
  public CTGrayscaleEffect insertNewGrayscl(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTGrayscaleEffect cTGrayscaleEffect = null;
      cTGrayscaleEffect = (CTGrayscaleEffect)get_store().insert_element_user(GRAYSCL$26, paramInt);
      return cTGrayscaleEffect;
    } 
  }
  
  public CTGrayscaleEffect addNewGrayscl() {
    synchronized (monitor()) {
      check_orphaned();
      CTGrayscaleEffect cTGrayscaleEffect = null;
      cTGrayscaleEffect = (CTGrayscaleEffect)get_store().add_element_user(GRAYSCL$26);
      return cTGrayscaleEffect;
    } 
  }
  
  public void removeGrayscl(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRAYSCL$26, paramInt);
    } 
  }
  
  public List<CTHSLEffect> getHslList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTHSLEffect>)new HslList(this);
    } 
  }
  
  public CTHSLEffect[] getHslArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(HSL$28, arrayList);
      CTHSLEffect[] arrayOfCTHSLEffect = new CTHSLEffect[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTHSLEffect);
      return arrayOfCTHSLEffect;
    } 
  }
  
  public CTHSLEffect getHslArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTHSLEffect cTHSLEffect = null;
      cTHSLEffect = (CTHSLEffect)get_store().find_element_user(HSL$28, paramInt);
      if (cTHSLEffect == null)
        throw new IndexOutOfBoundsException(); 
      return cTHSLEffect;
    } 
  }
  
  public int sizeOfHslArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(HSL$28);
    } 
  }
  
  public void setHslArray(CTHSLEffect[] paramArrayOfCTHSLEffect) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTHSLEffect, HSL$28);
    } 
  }
  
  public void setHslArray(int paramInt, CTHSLEffect paramCTHSLEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTHSLEffect cTHSLEffect = null;
      cTHSLEffect = (CTHSLEffect)get_store().find_element_user(HSL$28, paramInt);
      if (cTHSLEffect == null)
        throw new IndexOutOfBoundsException(); 
      cTHSLEffect.set((XmlObject)paramCTHSLEffect);
    } 
  }
  
  public CTHSLEffect insertNewHsl(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTHSLEffect cTHSLEffect = null;
      cTHSLEffect = (CTHSLEffect)get_store().insert_element_user(HSL$28, paramInt);
      return cTHSLEffect;
    } 
  }
  
  public CTHSLEffect addNewHsl() {
    synchronized (monitor()) {
      check_orphaned();
      CTHSLEffect cTHSLEffect = null;
      cTHSLEffect = (CTHSLEffect)get_store().add_element_user(HSL$28);
      return cTHSLEffect;
    } 
  }
  
  public void removeHsl(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HSL$28, paramInt);
    } 
  }
  
  public List<CTLuminanceEffect> getLumList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTLuminanceEffect>)new LumList(this);
    } 
  }
  
  public CTLuminanceEffect[] getLumArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LUM$30, arrayList);
      CTLuminanceEffect[] arrayOfCTLuminanceEffect = new CTLuminanceEffect[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTLuminanceEffect);
      return arrayOfCTLuminanceEffect;
    } 
  }
  
  public CTLuminanceEffect getLumArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLuminanceEffect cTLuminanceEffect = null;
      cTLuminanceEffect = (CTLuminanceEffect)get_store().find_element_user(LUM$30, paramInt);
      if (cTLuminanceEffect == null)
        throw new IndexOutOfBoundsException(); 
      return cTLuminanceEffect;
    } 
  }
  
  public int sizeOfLumArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LUM$30);
    } 
  }
  
  public void setLumArray(CTLuminanceEffect[] paramArrayOfCTLuminanceEffect) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTLuminanceEffect, LUM$30);
    } 
  }
  
  public void setLumArray(int paramInt, CTLuminanceEffect paramCTLuminanceEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTLuminanceEffect cTLuminanceEffect = null;
      cTLuminanceEffect = (CTLuminanceEffect)get_store().find_element_user(LUM$30, paramInt);
      if (cTLuminanceEffect == null)
        throw new IndexOutOfBoundsException(); 
      cTLuminanceEffect.set((XmlObject)paramCTLuminanceEffect);
    } 
  }
  
  public CTLuminanceEffect insertNewLum(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLuminanceEffect cTLuminanceEffect = null;
      cTLuminanceEffect = (CTLuminanceEffect)get_store().insert_element_user(LUM$30, paramInt);
      return cTLuminanceEffect;
    } 
  }
  
  public CTLuminanceEffect addNewLum() {
    synchronized (monitor()) {
      check_orphaned();
      CTLuminanceEffect cTLuminanceEffect = null;
      cTLuminanceEffect = (CTLuminanceEffect)get_store().add_element_user(LUM$30);
      return cTLuminanceEffect;
    } 
  }
  
  public void removeLum(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LUM$30, paramInt);
    } 
  }
  
  public List<CTTintEffect> getTintList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTintEffect>)new TintList(this);
    } 
  }
  
  public CTTintEffect[] getTintArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TINT$32, arrayList);
      CTTintEffect[] arrayOfCTTintEffect = new CTTintEffect[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTintEffect);
      return arrayOfCTTintEffect;
    } 
  }
  
  public CTTintEffect getTintArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTintEffect cTTintEffect = null;
      cTTintEffect = (CTTintEffect)get_store().find_element_user(TINT$32, paramInt);
      if (cTTintEffect == null)
        throw new IndexOutOfBoundsException(); 
      return cTTintEffect;
    } 
  }
  
  public int sizeOfTintArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TINT$32);
    } 
  }
  
  public void setTintArray(CTTintEffect[] paramArrayOfCTTintEffect) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTintEffect, TINT$32);
    } 
  }
  
  public void setTintArray(int paramInt, CTTintEffect paramCTTintEffect) {
    synchronized (monitor()) {
      check_orphaned();
      CTTintEffect cTTintEffect = null;
      cTTintEffect = (CTTintEffect)get_store().find_element_user(TINT$32, paramInt);
      if (cTTintEffect == null)
        throw new IndexOutOfBoundsException(); 
      cTTintEffect.set((XmlObject)paramCTTintEffect);
    } 
  }
  
  public CTTintEffect insertNewTint(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTintEffect cTTintEffect = null;
      cTTintEffect = (CTTintEffect)get_store().insert_element_user(TINT$32, paramInt);
      return cTTintEffect;
    } 
  }
  
  public CTTintEffect addNewTint() {
    synchronized (monitor()) {
      check_orphaned();
      CTTintEffect cTTintEffect = null;
      cTTintEffect = (CTTintEffect)get_store().add_element_user(TINT$32);
      return cTTintEffect;
    } 
  }
  
  public void removeTint(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TINT$32, paramInt);
    } 
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$34, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$34) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$34, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$34); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$34);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$34, 0);
    } 
  }
  
  public String getEmbed() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EMBED$36);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(EMBED$36); 
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STRelationshipId xgetEmbed() {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(EMBED$36);
      if (sTRelationshipId == null)
        sTRelationshipId = (STRelationshipId)get_default_attribute_value(EMBED$36); 
      return sTRelationshipId;
    } 
  }
  
  public boolean isSetEmbed() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(EMBED$36) != null);
    } 
  }
  
  public void setEmbed(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EMBED$36);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(EMBED$36); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetEmbed(STRelationshipId paramSTRelationshipId) {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(EMBED$36);
      if (sTRelationshipId == null)
        sTRelationshipId = (STRelationshipId)get_store().add_attribute_user(EMBED$36); 
      sTRelationshipId.set((XmlObject)paramSTRelationshipId);
    } 
  }
  
  public void unsetEmbed() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(EMBED$36);
    } 
  }
  
  public String getLink() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LINK$38);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(LINK$38); 
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STRelationshipId xgetLink() {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(LINK$38);
      if (sTRelationshipId == null)
        sTRelationshipId = (STRelationshipId)get_default_attribute_value(LINK$38); 
      return sTRelationshipId;
    } 
  }
  
  public boolean isSetLink() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LINK$38) != null);
    } 
  }
  
  public void setLink(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LINK$38);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LINK$38); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetLink(STRelationshipId paramSTRelationshipId) {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(LINK$38);
      if (sTRelationshipId == null)
        sTRelationshipId = (STRelationshipId)get_store().add_attribute_user(LINK$38); 
      sTRelationshipId.set((XmlObject)paramSTRelationshipId);
    } 
  }
  
  public void unsetLink() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LINK$38);
    } 
  }
  
  public STBlipCompression.Enum getCstate() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CSTATE$40);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CSTATE$40); 
      if (simpleValue == null)
        return null; 
      return (STBlipCompression.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STBlipCompression xgetCstate() {
    synchronized (monitor()) {
      check_orphaned();
      STBlipCompression sTBlipCompression = null;
      sTBlipCompression = (STBlipCompression)get_store().find_attribute_user(CSTATE$40);
      if (sTBlipCompression == null)
        sTBlipCompression = (STBlipCompression)get_default_attribute_value(CSTATE$40); 
      return sTBlipCompression;
    } 
  }
  
  public boolean isSetCstate() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CSTATE$40) != null);
    } 
  }
  
  public void setCstate(STBlipCompression.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CSTATE$40);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CSTATE$40); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetCstate(STBlipCompression paramSTBlipCompression) {
    synchronized (monitor()) {
      check_orphaned();
      STBlipCompression sTBlipCompression = null;
      sTBlipCompression = (STBlipCompression)get_store().find_attribute_user(CSTATE$40);
      if (sTBlipCompression == null)
        sTBlipCompression = (STBlipCompression)get_store().add_attribute_user(CSTATE$40); 
      sTBlipCompression.set((XmlObject)paramSTBlipCompression);
    } 
  }
  
  public void unsetCstate() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CSTATE$40);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTBlipImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */