package com.microsoft.schemas.vml.impl;

import com.microsoft.schemas.office.excel.CTClientData;
import com.microsoft.schemas.office.office.CTCallout;
import com.microsoft.schemas.office.office.CTClipPath;
import com.microsoft.schemas.office.office.CTExtrusion;
import com.microsoft.schemas.office.office.CTInk;
import com.microsoft.schemas.office.office.CTLock;
import com.microsoft.schemas.office.office.CTSignatureLine;
import com.microsoft.schemas.office.office.CTSkew;
import com.microsoft.schemas.office.office.STBWMode;
import com.microsoft.schemas.office.office.STConnectorType;
import com.microsoft.schemas.office.office.STHrAlign;
import com.microsoft.schemas.office.office.STInsetMode;
import com.microsoft.schemas.office.office.STTrueFalse;
import com.microsoft.schemas.office.office.STTrueFalseBlank;
import com.microsoft.schemas.office.powerpoint.CTEmpty;
import com.microsoft.schemas.office.powerpoint.CTRel;
import com.microsoft.schemas.office.word.CTAnchorLock;
import com.microsoft.schemas.office.word.CTBorder;
import com.microsoft.schemas.office.word.CTWrap;
import com.microsoft.schemas.vml.CTFill;
import com.microsoft.schemas.vml.CTFormulas;
import com.microsoft.schemas.vml.CTHandles;
import com.microsoft.schemas.vml.CTImageData;
import com.microsoft.schemas.vml.CTPath;
import com.microsoft.schemas.vml.CTShadow;
import com.microsoft.schemas.vml.CTShape;
import com.microsoft.schemas.vml.CTStroke;
import com.microsoft.schemas.vml.CTTextPath;
import com.microsoft.schemas.vml.CTTextbox;
import com.microsoft.schemas.vml.STColorType;
import com.microsoft.schemas.vml.STTrueFalse;
import java.math.BigInteger;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class CTShapeImpl extends XmlComplexContentImpl implements CTShape {
  private static final b PATH$0 = new b("urn:schemas-microsoft-com:vml", "path");
  
  private static final b FORMULAS$2 = new b("urn:schemas-microsoft-com:vml", "formulas");
  
  private static final b HANDLES$4 = new b("urn:schemas-microsoft-com:vml", "handles");
  
  private static final b FILL$6 = new b("urn:schemas-microsoft-com:vml", "fill");
  
  private static final b STROKE$8 = new b("urn:schemas-microsoft-com:vml", "stroke");
  
  private static final b SHADOW$10 = new b("urn:schemas-microsoft-com:vml", "shadow");
  
  private static final b TEXTBOX$12 = new b("urn:schemas-microsoft-com:vml", "textbox");
  
  private static final b TEXTPATH$14 = new b("urn:schemas-microsoft-com:vml", "textpath");
  
  private static final b IMAGEDATA$16 = new b("urn:schemas-microsoft-com:vml", "imagedata");
  
  private static final b SKEW$18 = new b("urn:schemas-microsoft-com:office:office", "skew");
  
  private static final b EXTRUSION$20 = new b("urn:schemas-microsoft-com:office:office", "extrusion");
  
  private static final b CALLOUT$22 = new b("urn:schemas-microsoft-com:office:office", "callout");
  
  private static final b LOCK$24 = new b("urn:schemas-microsoft-com:office:office", "lock");
  
  private static final b CLIPPATH$26 = new b("urn:schemas-microsoft-com:office:office", "clippath");
  
  private static final b SIGNATURELINE$28 = new b("urn:schemas-microsoft-com:office:office", "signatureline");
  
  private static final b WRAP$30 = new b("urn:schemas-microsoft-com:office:word", "wrap");
  
  private static final b ANCHORLOCK$32 = new b("urn:schemas-microsoft-com:office:word", "anchorlock");
  
  private static final b BORDERTOP$34 = new b("urn:schemas-microsoft-com:office:word", "bordertop");
  
  private static final b BORDERBOTTOM$36 = new b("urn:schemas-microsoft-com:office:word", "borderbottom");
  
  private static final b BORDERLEFT$38 = new b("urn:schemas-microsoft-com:office:word", "borderleft");
  
  private static final b BORDERRIGHT$40 = new b("urn:schemas-microsoft-com:office:word", "borderright");
  
  private static final b CLIENTDATA$42 = new b("urn:schemas-microsoft-com:office:excel", "ClientData");
  
  private static final b TEXTDATA$44 = new b("urn:schemas-microsoft-com:office:powerpoint", "textdata");
  
  private static final b INK$46 = new b("urn:schemas-microsoft-com:office:office", "ink");
  
  private static final b ISCOMMENT$48 = new b("urn:schemas-microsoft-com:office:powerpoint", "iscomment");
  
  private static final b ID$50 = new b("", "id");
  
  private static final b STYLE$52 = new b("", "style");
  
  private static final b HREF$54 = new b("", "href");
  
  private static final b TARGET$56 = new b("", "target");
  
  private static final b CLASS1$58 = new b("", "class");
  
  private static final b TITLE$60 = new b("", "title");
  
  private static final b ALT$62 = new b("", "alt");
  
  private static final b COORDSIZE$64 = new b("", "coordsize");
  
  private static final b COORDORIGIN$66 = new b("", "coordorigin");
  
  private static final b WRAPCOORDS$68 = new b("", "wrapcoords");
  
  private static final b PRINT$70 = new b("", "print");
  
  private static final b SPID$72 = new b("urn:schemas-microsoft-com:office:office", "spid");
  
  private static final b ONED$74 = new b("urn:schemas-microsoft-com:office:office", "oned");
  
  private static final b REGROUPID$76 = new b("urn:schemas-microsoft-com:office:office", "regroupid");
  
  private static final b DOUBLECLICKNOTIFY$78 = new b("urn:schemas-microsoft-com:office:office", "doubleclicknotify");
  
  private static final b BUTTON$80 = new b("urn:schemas-microsoft-com:office:office", "button");
  
  private static final b USERHIDDEN$82 = new b("urn:schemas-microsoft-com:office:office", "userhidden");
  
  private static final b BULLET$84 = new b("urn:schemas-microsoft-com:office:office", "bullet");
  
  private static final b HR$86 = new b("urn:schemas-microsoft-com:office:office", "hr");
  
  private static final b HRSTD$88 = new b("urn:schemas-microsoft-com:office:office", "hrstd");
  
  private static final b HRNOSHADE$90 = new b("urn:schemas-microsoft-com:office:office", "hrnoshade");
  
  private static final b HRPCT$92 = new b("urn:schemas-microsoft-com:office:office", "hrpct");
  
  private static final b HRALIGN$94 = new b("urn:schemas-microsoft-com:office:office", "hralign");
  
  private static final b ALLOWINCELL$96 = new b("urn:schemas-microsoft-com:office:office", "allowincell");
  
  private static final b ALLOWOVERLAP$98 = new b("urn:schemas-microsoft-com:office:office", "allowoverlap");
  
  private static final b USERDRAWN$100 = new b("urn:schemas-microsoft-com:office:office", "userdrawn");
  
  private static final b BORDERTOPCOLOR$102 = new b("urn:schemas-microsoft-com:office:office", "bordertopcolor");
  
  private static final b BORDERLEFTCOLOR$104 = new b("urn:schemas-microsoft-com:office:office", "borderleftcolor");
  
  private static final b BORDERBOTTOMCOLOR$106 = new b("urn:schemas-microsoft-com:office:office", "borderbottomcolor");
  
  private static final b BORDERRIGHTCOLOR$108 = new b("urn:schemas-microsoft-com:office:office", "borderrightcolor");
  
  private static final b DGMLAYOUT$110 = new b("urn:schemas-microsoft-com:office:office", "dgmlayout");
  
  private static final b DGMNODEKIND$112 = new b("urn:schemas-microsoft-com:office:office", "dgmnodekind");
  
  private static final b DGMLAYOUTMRU$114 = new b("urn:schemas-microsoft-com:office:office", "dgmlayoutmru");
  
  private static final b INSETMODE$116 = new b("urn:schemas-microsoft-com:office:office", "insetmode");
  
  private static final b CHROMAKEY$118 = new b("", "chromakey");
  
  private static final b FILLED$120 = new b("", "filled");
  
  private static final b FILLCOLOR$122 = new b("", "fillcolor");
  
  private static final b OPACITY$124 = new b("", "opacity");
  
  private static final b STROKED$126 = new b("", "stroked");
  
  private static final b STROKECOLOR$128 = new b("", "strokecolor");
  
  private static final b STROKEWEIGHT$130 = new b("", "strokeweight");
  
  private static final b INSETPEN$132 = new b("", "insetpen");
  
  private static final b SPT$134 = new b("urn:schemas-microsoft-com:office:office", "spt");
  
  private static final b CONNECTORTYPE$136 = new b("urn:schemas-microsoft-com:office:office", "connectortype");
  
  private static final b BWMODE$138 = new b("urn:schemas-microsoft-com:office:office", "bwmode");
  
  private static final b BWPURE$140 = new b("urn:schemas-microsoft-com:office:office", "bwpure");
  
  private static final b BWNORMAL$142 = new b("urn:schemas-microsoft-com:office:office", "bwnormal");
  
  private static final b FORCEDASH$144 = new b("urn:schemas-microsoft-com:office:office", "forcedash");
  
  private static final b OLEICON$146 = new b("urn:schemas-microsoft-com:office:office", "oleicon");
  
  private static final b OLE$148 = new b("urn:schemas-microsoft-com:office:office", "ole");
  
  private static final b PREFERRELATIVE$150 = new b("urn:schemas-microsoft-com:office:office", "preferrelative");
  
  private static final b CLIPTOWRAP$152 = new b("urn:schemas-microsoft-com:office:office", "cliptowrap");
  
  private static final b CLIP$154 = new b("urn:schemas-microsoft-com:office:office", "clip");
  
  private static final b TYPE$156 = new b("", "type");
  
  private static final b ADJ$158 = new b("", "adj");
  
  private static final b PATH2$160 = new b("", "path");
  
  private static final b GFXDATA$162 = new b("urn:schemas-microsoft-com:office:office", "gfxdata");
  
  private static final b EQUATIONXML$164 = new b("", "equationxml");
  
  public CTShapeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTPath> getPathList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPath>)new PathList(this);
    } 
  }
  
  public CTPath[] getPathArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PATH$0, arrayList);
      CTPath[] arrayOfCTPath = new CTPath[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPath);
      return arrayOfCTPath;
    } 
  }
  
  public CTPath getPathArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath cTPath = null;
      cTPath = (CTPath)get_store().find_element_user(PATH$0, paramInt);
      if (cTPath == null)
        throw new IndexOutOfBoundsException(); 
      return cTPath;
    } 
  }
  
  public int sizeOfPathArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PATH$0);
    } 
  }
  
  public void setPathArray(CTPath[] paramArrayOfCTPath) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPath, PATH$0);
    } 
  }
  
  public void setPathArray(int paramInt, CTPath paramCTPath) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath cTPath = null;
      cTPath = (CTPath)get_store().find_element_user(PATH$0, paramInt);
      if (cTPath == null)
        throw new IndexOutOfBoundsException(); 
      cTPath.set((XmlObject)paramCTPath);
    } 
  }
  
  public CTPath insertNewPath(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPath cTPath = null;
      cTPath = (CTPath)get_store().insert_element_user(PATH$0, paramInt);
      return cTPath;
    } 
  }
  
  public CTPath addNewPath() {
    synchronized (monitor()) {
      check_orphaned();
      CTPath cTPath = null;
      cTPath = (CTPath)get_store().add_element_user(PATH$0);
      return cTPath;
    } 
  }
  
  public void removePath(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PATH$0, paramInt);
    } 
  }
  
  public List<CTFormulas> getFormulasList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTFormulas>)new FormulasList(this);
    } 
  }
  
  public CTFormulas[] getFormulasArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FORMULAS$2, arrayList);
      CTFormulas[] arrayOfCTFormulas = new CTFormulas[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTFormulas);
      return arrayOfCTFormulas;
    } 
  }
  
  public CTFormulas getFormulasArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFormulas cTFormulas = null;
      cTFormulas = (CTFormulas)get_store().find_element_user(FORMULAS$2, paramInt);
      if (cTFormulas == null)
        throw new IndexOutOfBoundsException(); 
      return cTFormulas;
    } 
  }
  
  public int sizeOfFormulasArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FORMULAS$2);
    } 
  }
  
  public void setFormulasArray(CTFormulas[] paramArrayOfCTFormulas) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTFormulas, FORMULAS$2);
    } 
  }
  
  public void setFormulasArray(int paramInt, CTFormulas paramCTFormulas) {
    synchronized (monitor()) {
      check_orphaned();
      CTFormulas cTFormulas = null;
      cTFormulas = (CTFormulas)get_store().find_element_user(FORMULAS$2, paramInt);
      if (cTFormulas == null)
        throw new IndexOutOfBoundsException(); 
      cTFormulas.set((XmlObject)paramCTFormulas);
    } 
  }
  
  public CTFormulas insertNewFormulas(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFormulas cTFormulas = null;
      cTFormulas = (CTFormulas)get_store().insert_element_user(FORMULAS$2, paramInt);
      return cTFormulas;
    } 
  }
  
  public CTFormulas addNewFormulas() {
    synchronized (monitor()) {
      check_orphaned();
      CTFormulas cTFormulas = null;
      cTFormulas = (CTFormulas)get_store().add_element_user(FORMULAS$2);
      return cTFormulas;
    } 
  }
  
  public void removeFormulas(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FORMULAS$2, paramInt);
    } 
  }
  
  public List<CTHandles> getHandlesList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTHandles>)new HandlesList(this);
    } 
  }
  
  public CTHandles[] getHandlesArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(HANDLES$4, arrayList);
      CTHandles[] arrayOfCTHandles = new CTHandles[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTHandles);
      return arrayOfCTHandles;
    } 
  }
  
  public CTHandles getHandlesArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTHandles cTHandles = null;
      cTHandles = (CTHandles)get_store().find_element_user(HANDLES$4, paramInt);
      if (cTHandles == null)
        throw new IndexOutOfBoundsException(); 
      return cTHandles;
    } 
  }
  
  public int sizeOfHandlesArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(HANDLES$4);
    } 
  }
  
  public void setHandlesArray(CTHandles[] paramArrayOfCTHandles) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTHandles, HANDLES$4);
    } 
  }
  
  public void setHandlesArray(int paramInt, CTHandles paramCTHandles) {
    synchronized (monitor()) {
      check_orphaned();
      CTHandles cTHandles = null;
      cTHandles = (CTHandles)get_store().find_element_user(HANDLES$4, paramInt);
      if (cTHandles == null)
        throw new IndexOutOfBoundsException(); 
      cTHandles.set((XmlObject)paramCTHandles);
    } 
  }
  
  public CTHandles insertNewHandles(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTHandles cTHandles = null;
      cTHandles = (CTHandles)get_store().insert_element_user(HANDLES$4, paramInt);
      return cTHandles;
    } 
  }
  
  public CTHandles addNewHandles() {
    synchronized (monitor()) {
      check_orphaned();
      CTHandles cTHandles = null;
      cTHandles = (CTHandles)get_store().add_element_user(HANDLES$4);
      return cTHandles;
    } 
  }
  
  public void removeHandles(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HANDLES$4, paramInt);
    } 
  }
  
  public List<CTFill> getFillList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTFill>)new FillList(this);
    } 
  }
  
  public CTFill[] getFillArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FILL$6, arrayList);
      CTFill[] arrayOfCTFill = new CTFill[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTFill);
      return arrayOfCTFill;
    } 
  }
  
  public CTFill getFillArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFill cTFill = null;
      cTFill = (CTFill)get_store().find_element_user(FILL$6, paramInt);
      if (cTFill == null)
        throw new IndexOutOfBoundsException(); 
      return cTFill;
    } 
  }
  
  public int sizeOfFillArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FILL$6);
    } 
  }
  
  public void setFillArray(CTFill[] paramArrayOfCTFill) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTFill, FILL$6);
    } 
  }
  
  public void setFillArray(int paramInt, CTFill paramCTFill) {
    synchronized (monitor()) {
      check_orphaned();
      CTFill cTFill = null;
      cTFill = (CTFill)get_store().find_element_user(FILL$6, paramInt);
      if (cTFill == null)
        throw new IndexOutOfBoundsException(); 
      cTFill.set((XmlObject)paramCTFill);
    } 
  }
  
  public CTFill insertNewFill(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFill cTFill = null;
      cTFill = (CTFill)get_store().insert_element_user(FILL$6, paramInt);
      return cTFill;
    } 
  }
  
  public CTFill addNewFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTFill cTFill = null;
      cTFill = (CTFill)get_store().add_element_user(FILL$6);
      return cTFill;
    } 
  }
  
  public void removeFill(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FILL$6, paramInt);
    } 
  }
  
  public List<CTStroke> getStrokeList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTStroke>)new StrokeList(this);
    } 
  }
  
  public CTStroke[] getStrokeArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(STROKE$8, arrayList);
      CTStroke[] arrayOfCTStroke = new CTStroke[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTStroke);
      return arrayOfCTStroke;
    } 
  }
  
  public CTStroke getStrokeArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTStroke cTStroke = null;
      cTStroke = (CTStroke)get_store().find_element_user(STROKE$8, paramInt);
      if (cTStroke == null)
        throw new IndexOutOfBoundsException(); 
      return cTStroke;
    } 
  }
  
  public int sizeOfStrokeArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(STROKE$8);
    } 
  }
  
  public void setStrokeArray(CTStroke[] paramArrayOfCTStroke) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTStroke, STROKE$8);
    } 
  }
  
  public void setStrokeArray(int paramInt, CTStroke paramCTStroke) {
    synchronized (monitor()) {
      check_orphaned();
      CTStroke cTStroke = null;
      cTStroke = (CTStroke)get_store().find_element_user(STROKE$8, paramInt);
      if (cTStroke == null)
        throw new IndexOutOfBoundsException(); 
      cTStroke.set((XmlObject)paramCTStroke);
    } 
  }
  
  public CTStroke insertNewStroke(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTStroke cTStroke = null;
      cTStroke = (CTStroke)get_store().insert_element_user(STROKE$8, paramInt);
      return cTStroke;
    } 
  }
  
  public CTStroke addNewStroke() {
    synchronized (monitor()) {
      check_orphaned();
      CTStroke cTStroke = null;
      cTStroke = (CTStroke)get_store().add_element_user(STROKE$8);
      return cTStroke;
    } 
  }
  
  public void removeStroke(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STROKE$8, paramInt);
    } 
  }
  
  public List<CTShadow> getShadowList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTShadow>)new ShadowList(this);
    } 
  }
  
  public CTShadow[] getShadowArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SHADOW$10, arrayList);
      CTShadow[] arrayOfCTShadow = new CTShadow[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTShadow);
      return arrayOfCTShadow;
    } 
  }
  
  public CTShadow getShadowArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTShadow cTShadow = null;
      cTShadow = (CTShadow)get_store().find_element_user(SHADOW$10, paramInt);
      if (cTShadow == null)
        throw new IndexOutOfBoundsException(); 
      return cTShadow;
    } 
  }
  
  public int sizeOfShadowArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SHADOW$10);
    } 
  }
  
  public void setShadowArray(CTShadow[] paramArrayOfCTShadow) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTShadow, SHADOW$10);
    } 
  }
  
  public void setShadowArray(int paramInt, CTShadow paramCTShadow) {
    synchronized (monitor()) {
      check_orphaned();
      CTShadow cTShadow = null;
      cTShadow = (CTShadow)get_store().find_element_user(SHADOW$10, paramInt);
      if (cTShadow == null)
        throw new IndexOutOfBoundsException(); 
      cTShadow.set((XmlObject)paramCTShadow);
    } 
  }
  
  public CTShadow insertNewShadow(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTShadow cTShadow = null;
      cTShadow = (CTShadow)get_store().insert_element_user(SHADOW$10, paramInt);
      return cTShadow;
    } 
  }
  
  public CTShadow addNewShadow() {
    synchronized (monitor()) {
      check_orphaned();
      CTShadow cTShadow = null;
      cTShadow = (CTShadow)get_store().add_element_user(SHADOW$10);
      return cTShadow;
    } 
  }
  
  public void removeShadow(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHADOW$10, paramInt);
    } 
  }
  
  public List<CTTextbox> getTextboxList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTextbox>)new TextboxList(this);
    } 
  }
  
  public CTTextbox[] getTextboxArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TEXTBOX$12, arrayList);
      CTTextbox[] arrayOfCTTextbox = new CTTextbox[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTextbox);
      return arrayOfCTTextbox;
    } 
  }
  
  public CTTextbox getTextboxArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextbox cTTextbox = null;
      cTTextbox = (CTTextbox)get_store().find_element_user(TEXTBOX$12, paramInt);
      if (cTTextbox == null)
        throw new IndexOutOfBoundsException(); 
      return cTTextbox;
    } 
  }
  
  public int sizeOfTextboxArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TEXTBOX$12);
    } 
  }
  
  public void setTextboxArray(CTTextbox[] paramArrayOfCTTextbox) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTextbox, TEXTBOX$12);
    } 
  }
  
  public void setTextboxArray(int paramInt, CTTextbox paramCTTextbox) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextbox cTTextbox = null;
      cTTextbox = (CTTextbox)get_store().find_element_user(TEXTBOX$12, paramInt);
      if (cTTextbox == null)
        throw new IndexOutOfBoundsException(); 
      cTTextbox.set((XmlObject)paramCTTextbox);
    } 
  }
  
  public CTTextbox insertNewTextbox(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextbox cTTextbox = null;
      cTTextbox = (CTTextbox)get_store().insert_element_user(TEXTBOX$12, paramInt);
      return cTTextbox;
    } 
  }
  
  public CTTextbox addNewTextbox() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextbox cTTextbox = null;
      cTTextbox = (CTTextbox)get_store().add_element_user(TEXTBOX$12);
      return cTTextbox;
    } 
  }
  
  public void removeTextbox(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TEXTBOX$12, paramInt);
    } 
  }
  
  public List<CTTextPath> getTextpathList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTextPath>)new TextpathList(this);
    } 
  }
  
  public CTTextPath[] getTextpathArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TEXTPATH$14, arrayList);
      CTTextPath[] arrayOfCTTextPath = new CTTextPath[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTextPath);
      return arrayOfCTTextPath;
    } 
  }
  
  public CTTextPath getTextpathArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextPath cTTextPath = null;
      cTTextPath = (CTTextPath)get_store().find_element_user(TEXTPATH$14, paramInt);
      if (cTTextPath == null)
        throw new IndexOutOfBoundsException(); 
      return cTTextPath;
    } 
  }
  
  public int sizeOfTextpathArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TEXTPATH$14);
    } 
  }
  
  public void setTextpathArray(CTTextPath[] paramArrayOfCTTextPath) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTextPath, TEXTPATH$14);
    } 
  }
  
  public void setTextpathArray(int paramInt, CTTextPath paramCTTextPath) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextPath cTTextPath = null;
      cTTextPath = (CTTextPath)get_store().find_element_user(TEXTPATH$14, paramInt);
      if (cTTextPath == null)
        throw new IndexOutOfBoundsException(); 
      cTTextPath.set((XmlObject)paramCTTextPath);
    } 
  }
  
  public CTTextPath insertNewTextpath(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextPath cTTextPath = null;
      cTTextPath = (CTTextPath)get_store().insert_element_user(TEXTPATH$14, paramInt);
      return cTTextPath;
    } 
  }
  
  public CTTextPath addNewTextpath() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextPath cTTextPath = null;
      cTTextPath = (CTTextPath)get_store().add_element_user(TEXTPATH$14);
      return cTTextPath;
    } 
  }
  
  public void removeTextpath(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TEXTPATH$14, paramInt);
    } 
  }
  
  public List<CTImageData> getImagedataList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTImageData>)new ImagedataList(this);
    } 
  }
  
  public CTImageData[] getImagedataArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(IMAGEDATA$16, arrayList);
      CTImageData[] arrayOfCTImageData = new CTImageData[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTImageData);
      return arrayOfCTImageData;
    } 
  }
  
  public CTImageData getImagedataArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTImageData cTImageData = null;
      cTImageData = (CTImageData)get_store().find_element_user(IMAGEDATA$16, paramInt);
      if (cTImageData == null)
        throw new IndexOutOfBoundsException(); 
      return cTImageData;
    } 
  }
  
  public int sizeOfImagedataArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(IMAGEDATA$16);
    } 
  }
  
  public void setImagedataArray(CTImageData[] paramArrayOfCTImageData) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTImageData, IMAGEDATA$16);
    } 
  }
  
  public void setImagedataArray(int paramInt, CTImageData paramCTImageData) {
    synchronized (monitor()) {
      check_orphaned();
      CTImageData cTImageData = null;
      cTImageData = (CTImageData)get_store().find_element_user(IMAGEDATA$16, paramInt);
      if (cTImageData == null)
        throw new IndexOutOfBoundsException(); 
      cTImageData.set((XmlObject)paramCTImageData);
    } 
  }
  
  public CTImageData insertNewImagedata(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTImageData cTImageData = null;
      cTImageData = (CTImageData)get_store().insert_element_user(IMAGEDATA$16, paramInt);
      return cTImageData;
    } 
  }
  
  public CTImageData addNewImagedata() {
    synchronized (monitor()) {
      check_orphaned();
      CTImageData cTImageData = null;
      cTImageData = (CTImageData)get_store().add_element_user(IMAGEDATA$16);
      return cTImageData;
    } 
  }
  
  public void removeImagedata(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(IMAGEDATA$16, paramInt);
    } 
  }
  
  public List<CTSkew> getSkewList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSkew>)new SkewList(this);
    } 
  }
  
  public CTSkew[] getSkewArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SKEW$18, arrayList);
      CTSkew[] arrayOfCTSkew = new CTSkew[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSkew);
      return arrayOfCTSkew;
    } 
  }
  
  public CTSkew getSkewArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSkew cTSkew = null;
      cTSkew = (CTSkew)get_store().find_element_user(SKEW$18, paramInt);
      if (cTSkew == null)
        throw new IndexOutOfBoundsException(); 
      return cTSkew;
    } 
  }
  
  public int sizeOfSkewArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SKEW$18);
    } 
  }
  
  public void setSkewArray(CTSkew[] paramArrayOfCTSkew) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSkew, SKEW$18);
    } 
  }
  
  public void setSkewArray(int paramInt, CTSkew paramCTSkew) {
    synchronized (monitor()) {
      check_orphaned();
      CTSkew cTSkew = null;
      cTSkew = (CTSkew)get_store().find_element_user(SKEW$18, paramInt);
      if (cTSkew == null)
        throw new IndexOutOfBoundsException(); 
      cTSkew.set((XmlObject)paramCTSkew);
    } 
  }
  
  public CTSkew insertNewSkew(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSkew cTSkew = null;
      cTSkew = (CTSkew)get_store().insert_element_user(SKEW$18, paramInt);
      return cTSkew;
    } 
  }
  
  public CTSkew addNewSkew() {
    synchronized (monitor()) {
      check_orphaned();
      CTSkew cTSkew = null;
      cTSkew = (CTSkew)get_store().add_element_user(SKEW$18);
      return cTSkew;
    } 
  }
  
  public void removeSkew(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SKEW$18, paramInt);
    } 
  }
  
  public List<CTExtrusion> getExtrusionList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTExtrusion>)new ExtrusionList(this);
    } 
  }
  
  public CTExtrusion[] getExtrusionArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(EXTRUSION$20, arrayList);
      CTExtrusion[] arrayOfCTExtrusion = new CTExtrusion[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTExtrusion);
      return arrayOfCTExtrusion;
    } 
  }
  
  public CTExtrusion getExtrusionArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtrusion cTExtrusion = null;
      cTExtrusion = (CTExtrusion)get_store().find_element_user(EXTRUSION$20, paramInt);
      if (cTExtrusion == null)
        throw new IndexOutOfBoundsException(); 
      return cTExtrusion;
    } 
  }
  
  public int sizeOfExtrusionArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(EXTRUSION$20);
    } 
  }
  
  public void setExtrusionArray(CTExtrusion[] paramArrayOfCTExtrusion) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTExtrusion, EXTRUSION$20);
    } 
  }
  
  public void setExtrusionArray(int paramInt, CTExtrusion paramCTExtrusion) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtrusion cTExtrusion = null;
      cTExtrusion = (CTExtrusion)get_store().find_element_user(EXTRUSION$20, paramInt);
      if (cTExtrusion == null)
        throw new IndexOutOfBoundsException(); 
      cTExtrusion.set((XmlObject)paramCTExtrusion);
    } 
  }
  
  public CTExtrusion insertNewExtrusion(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtrusion cTExtrusion = null;
      cTExtrusion = (CTExtrusion)get_store().insert_element_user(EXTRUSION$20, paramInt);
      return cTExtrusion;
    } 
  }
  
  public CTExtrusion addNewExtrusion() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtrusion cTExtrusion = null;
      cTExtrusion = (CTExtrusion)get_store().add_element_user(EXTRUSION$20);
      return cTExtrusion;
    } 
  }
  
  public void removeExtrusion(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTRUSION$20, paramInt);
    } 
  }
  
  public List<CTCallout> getCalloutList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTCallout>)new CalloutList(this);
    } 
  }
  
  public CTCallout[] getCalloutArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CALLOUT$22, arrayList);
      CTCallout[] arrayOfCTCallout = new CTCallout[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTCallout);
      return arrayOfCTCallout;
    } 
  }
  
  public CTCallout getCalloutArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCallout cTCallout = null;
      cTCallout = (CTCallout)get_store().find_element_user(CALLOUT$22, paramInt);
      if (cTCallout == null)
        throw new IndexOutOfBoundsException(); 
      return cTCallout;
    } 
  }
  
  public int sizeOfCalloutArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CALLOUT$22);
    } 
  }
  
  public void setCalloutArray(CTCallout[] paramArrayOfCTCallout) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTCallout, CALLOUT$22);
    } 
  }
  
  public void setCalloutArray(int paramInt, CTCallout paramCTCallout) {
    synchronized (monitor()) {
      check_orphaned();
      CTCallout cTCallout = null;
      cTCallout = (CTCallout)get_store().find_element_user(CALLOUT$22, paramInt);
      if (cTCallout == null)
        throw new IndexOutOfBoundsException(); 
      cTCallout.set((XmlObject)paramCTCallout);
    } 
  }
  
  public CTCallout insertNewCallout(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCallout cTCallout = null;
      cTCallout = (CTCallout)get_store().insert_element_user(CALLOUT$22, paramInt);
      return cTCallout;
    } 
  }
  
  public CTCallout addNewCallout() {
    synchronized (monitor()) {
      check_orphaned();
      CTCallout cTCallout = null;
      cTCallout = (CTCallout)get_store().add_element_user(CALLOUT$22);
      return cTCallout;
    } 
  }
  
  public void removeCallout(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CALLOUT$22, paramInt);
    } 
  }
  
  public List<CTLock> getLockList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTLock>)new LockList(this);
    } 
  }
  
  public CTLock[] getLockArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LOCK$24, arrayList);
      CTLock[] arrayOfCTLock = new CTLock[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTLock);
      return arrayOfCTLock;
    } 
  }
  
  public CTLock getLockArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLock cTLock = null;
      cTLock = (CTLock)get_store().find_element_user(LOCK$24, paramInt);
      if (cTLock == null)
        throw new IndexOutOfBoundsException(); 
      return cTLock;
    } 
  }
  
  public int sizeOfLockArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LOCK$24);
    } 
  }
  
  public void setLockArray(CTLock[] paramArrayOfCTLock) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTLock, LOCK$24);
    } 
  }
  
  public void setLockArray(int paramInt, CTLock paramCTLock) {
    synchronized (monitor()) {
      check_orphaned();
      CTLock cTLock = null;
      cTLock = (CTLock)get_store().find_element_user(LOCK$24, paramInt);
      if (cTLock == null)
        throw new IndexOutOfBoundsException(); 
      cTLock.set((XmlObject)paramCTLock);
    } 
  }
  
  public CTLock insertNewLock(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLock cTLock = null;
      cTLock = (CTLock)get_store().insert_element_user(LOCK$24, paramInt);
      return cTLock;
    } 
  }
  
  public CTLock addNewLock() {
    synchronized (monitor()) {
      check_orphaned();
      CTLock cTLock = null;
      cTLock = (CTLock)get_store().add_element_user(LOCK$24);
      return cTLock;
    } 
  }
  
  public void removeLock(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LOCK$24, paramInt);
    } 
  }
  
  public List<CTClipPath> getClippathList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTClipPath>)new ClippathList(this);
    } 
  }
  
  public CTClipPath[] getClippathArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CLIPPATH$26, arrayList);
      CTClipPath[] arrayOfCTClipPath = new CTClipPath[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTClipPath);
      return arrayOfCTClipPath;
    } 
  }
  
  public CTClipPath getClippathArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTClipPath cTClipPath = null;
      cTClipPath = (CTClipPath)get_store().find_element_user(CLIPPATH$26, paramInt);
      if (cTClipPath == null)
        throw new IndexOutOfBoundsException(); 
      return cTClipPath;
    } 
  }
  
  public int sizeOfClippathArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CLIPPATH$26);
    } 
  }
  
  public void setClippathArray(CTClipPath[] paramArrayOfCTClipPath) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTClipPath, CLIPPATH$26);
    } 
  }
  
  public void setClippathArray(int paramInt, CTClipPath paramCTClipPath) {
    synchronized (monitor()) {
      check_orphaned();
      CTClipPath cTClipPath = null;
      cTClipPath = (CTClipPath)get_store().find_element_user(CLIPPATH$26, paramInt);
      if (cTClipPath == null)
        throw new IndexOutOfBoundsException(); 
      cTClipPath.set((XmlObject)paramCTClipPath);
    } 
  }
  
  public CTClipPath insertNewClippath(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTClipPath cTClipPath = null;
      cTClipPath = (CTClipPath)get_store().insert_element_user(CLIPPATH$26, paramInt);
      return cTClipPath;
    } 
  }
  
  public CTClipPath addNewClippath() {
    synchronized (monitor()) {
      check_orphaned();
      CTClipPath cTClipPath = null;
      cTClipPath = (CTClipPath)get_store().add_element_user(CLIPPATH$26);
      return cTClipPath;
    } 
  }
  
  public void removeClippath(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CLIPPATH$26, paramInt);
    } 
  }
  
  public List<CTSignatureLine> getSignaturelineList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTSignatureLine>)new SignaturelineList(this);
    } 
  }
  
  public CTSignatureLine[] getSignaturelineArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SIGNATURELINE$28, arrayList);
      CTSignatureLine[] arrayOfCTSignatureLine = new CTSignatureLine[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTSignatureLine);
      return arrayOfCTSignatureLine;
    } 
  }
  
  public CTSignatureLine getSignaturelineArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSignatureLine cTSignatureLine = null;
      cTSignatureLine = (CTSignatureLine)get_store().find_element_user(SIGNATURELINE$28, paramInt);
      if (cTSignatureLine == null)
        throw new IndexOutOfBoundsException(); 
      return cTSignatureLine;
    } 
  }
  
  public int sizeOfSignaturelineArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SIGNATURELINE$28);
    } 
  }
  
  public void setSignaturelineArray(CTSignatureLine[] paramArrayOfCTSignatureLine) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTSignatureLine, SIGNATURELINE$28);
    } 
  }
  
  public void setSignaturelineArray(int paramInt, CTSignatureLine paramCTSignatureLine) {
    synchronized (monitor()) {
      check_orphaned();
      CTSignatureLine cTSignatureLine = null;
      cTSignatureLine = (CTSignatureLine)get_store().find_element_user(SIGNATURELINE$28, paramInt);
      if (cTSignatureLine == null)
        throw new IndexOutOfBoundsException(); 
      cTSignatureLine.set((XmlObject)paramCTSignatureLine);
    } 
  }
  
  public CTSignatureLine insertNewSignatureline(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTSignatureLine cTSignatureLine = null;
      cTSignatureLine = (CTSignatureLine)get_store().insert_element_user(SIGNATURELINE$28, paramInt);
      return cTSignatureLine;
    } 
  }
  
  public CTSignatureLine addNewSignatureline() {
    synchronized (monitor()) {
      check_orphaned();
      CTSignatureLine cTSignatureLine = null;
      cTSignatureLine = (CTSignatureLine)get_store().add_element_user(SIGNATURELINE$28);
      return cTSignatureLine;
    } 
  }
  
  public void removeSignatureline(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SIGNATURELINE$28, paramInt);
    } 
  }
  
  public List<CTWrap> getWrapList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTWrap>)new WrapList(this);
    } 
  }
  
  public CTWrap[] getWrapArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(WRAP$30, arrayList);
      CTWrap[] arrayOfCTWrap = new CTWrap[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTWrap);
      return arrayOfCTWrap;
    } 
  }
  
  public CTWrap getWrapArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTWrap cTWrap = null;
      cTWrap = (CTWrap)get_store().find_element_user(WRAP$30, paramInt);
      if (cTWrap == null)
        throw new IndexOutOfBoundsException(); 
      return cTWrap;
    } 
  }
  
  public int sizeOfWrapArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(WRAP$30);
    } 
  }
  
  public void setWrapArray(CTWrap[] paramArrayOfCTWrap) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTWrap, WRAP$30);
    } 
  }
  
  public void setWrapArray(int paramInt, CTWrap paramCTWrap) {
    synchronized (monitor()) {
      check_orphaned();
      CTWrap cTWrap = null;
      cTWrap = (CTWrap)get_store().find_element_user(WRAP$30, paramInt);
      if (cTWrap == null)
        throw new IndexOutOfBoundsException(); 
      cTWrap.set((XmlObject)paramCTWrap);
    } 
  }
  
  public CTWrap insertNewWrap(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTWrap cTWrap = null;
      cTWrap = (CTWrap)get_store().insert_element_user(WRAP$30, paramInt);
      return cTWrap;
    } 
  }
  
  public CTWrap addNewWrap() {
    synchronized (monitor()) {
      check_orphaned();
      CTWrap cTWrap = null;
      cTWrap = (CTWrap)get_store().add_element_user(WRAP$30);
      return cTWrap;
    } 
  }
  
  public void removeWrap(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WRAP$30, paramInt);
    } 
  }
  
  public List<CTAnchorLock> getAnchorlockList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTAnchorLock>)new AnchorlockList(this);
    } 
  }
  
  public CTAnchorLock[] getAnchorlockArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ANCHORLOCK$32, arrayList);
      CTAnchorLock[] arrayOfCTAnchorLock = new CTAnchorLock[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTAnchorLock);
      return arrayOfCTAnchorLock;
    } 
  }
  
  public CTAnchorLock getAnchorlockArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAnchorLock cTAnchorLock = null;
      cTAnchorLock = (CTAnchorLock)get_store().find_element_user(ANCHORLOCK$32, paramInt);
      if (cTAnchorLock == null)
        throw new IndexOutOfBoundsException(); 
      return cTAnchorLock;
    } 
  }
  
  public int sizeOfAnchorlockArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ANCHORLOCK$32);
    } 
  }
  
  public void setAnchorlockArray(CTAnchorLock[] paramArrayOfCTAnchorLock) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTAnchorLock, ANCHORLOCK$32);
    } 
  }
  
  public void setAnchorlockArray(int paramInt, CTAnchorLock paramCTAnchorLock) {
    synchronized (monitor()) {
      check_orphaned();
      CTAnchorLock cTAnchorLock = null;
      cTAnchorLock = (CTAnchorLock)get_store().find_element_user(ANCHORLOCK$32, paramInt);
      if (cTAnchorLock == null)
        throw new IndexOutOfBoundsException(); 
      cTAnchorLock.set((XmlObject)paramCTAnchorLock);
    } 
  }
  
  public CTAnchorLock insertNewAnchorlock(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTAnchorLock cTAnchorLock = null;
      cTAnchorLock = (CTAnchorLock)get_store().insert_element_user(ANCHORLOCK$32, paramInt);
      return cTAnchorLock;
    } 
  }
  
  public CTAnchorLock addNewAnchorlock() {
    synchronized (monitor()) {
      check_orphaned();
      CTAnchorLock cTAnchorLock = null;
      cTAnchorLock = (CTAnchorLock)get_store().add_element_user(ANCHORLOCK$32);
      return cTAnchorLock;
    } 
  }
  
  public void removeAnchorlock(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ANCHORLOCK$32, paramInt);
    } 
  }
  
  public List<CTBorder> getBordertopList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBorder>)new BordertopList(this);
    } 
  }
  
  public CTBorder[] getBordertopArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BORDERTOP$34, arrayList);
      CTBorder[] arrayOfCTBorder = new CTBorder[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBorder);
      return arrayOfCTBorder;
    } 
  }
  
  public CTBorder getBordertopArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(BORDERTOP$34, paramInt);
      if (cTBorder == null)
        throw new IndexOutOfBoundsException(); 
      return cTBorder;
    } 
  }
  
  public int sizeOfBordertopArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BORDERTOP$34);
    } 
  }
  
  public void setBordertopArray(CTBorder[] paramArrayOfCTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBorder, BORDERTOP$34);
    } 
  }
  
  public void setBordertopArray(int paramInt, CTBorder paramCTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(BORDERTOP$34, paramInt);
      if (cTBorder == null)
        throw new IndexOutOfBoundsException(); 
      cTBorder.set((XmlObject)paramCTBorder);
    } 
  }
  
  public CTBorder insertNewBordertop(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().insert_element_user(BORDERTOP$34, paramInt);
      return cTBorder;
    } 
  }
  
  public CTBorder addNewBordertop() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().add_element_user(BORDERTOP$34);
      return cTBorder;
    } 
  }
  
  public void removeBordertop(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BORDERTOP$34, paramInt);
    } 
  }
  
  public List<CTBorder> getBorderbottomList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBorder>)new BorderbottomList(this);
    } 
  }
  
  public CTBorder[] getBorderbottomArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BORDERBOTTOM$36, arrayList);
      CTBorder[] arrayOfCTBorder = new CTBorder[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBorder);
      return arrayOfCTBorder;
    } 
  }
  
  public CTBorder getBorderbottomArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(BORDERBOTTOM$36, paramInt);
      if (cTBorder == null)
        throw new IndexOutOfBoundsException(); 
      return cTBorder;
    } 
  }
  
  public int sizeOfBorderbottomArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BORDERBOTTOM$36);
    } 
  }
  
  public void setBorderbottomArray(CTBorder[] paramArrayOfCTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBorder, BORDERBOTTOM$36);
    } 
  }
  
  public void setBorderbottomArray(int paramInt, CTBorder paramCTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(BORDERBOTTOM$36, paramInt);
      if (cTBorder == null)
        throw new IndexOutOfBoundsException(); 
      cTBorder.set((XmlObject)paramCTBorder);
    } 
  }
  
  public CTBorder insertNewBorderbottom(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().insert_element_user(BORDERBOTTOM$36, paramInt);
      return cTBorder;
    } 
  }
  
  public CTBorder addNewBorderbottom() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().add_element_user(BORDERBOTTOM$36);
      return cTBorder;
    } 
  }
  
  public void removeBorderbottom(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BORDERBOTTOM$36, paramInt);
    } 
  }
  
  public List<CTBorder> getBorderleftList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBorder>)new BorderleftList(this);
    } 
  }
  
  public CTBorder[] getBorderleftArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BORDERLEFT$38, arrayList);
      CTBorder[] arrayOfCTBorder = new CTBorder[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBorder);
      return arrayOfCTBorder;
    } 
  }
  
  public CTBorder getBorderleftArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(BORDERLEFT$38, paramInt);
      if (cTBorder == null)
        throw new IndexOutOfBoundsException(); 
      return cTBorder;
    } 
  }
  
  public int sizeOfBorderleftArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BORDERLEFT$38);
    } 
  }
  
  public void setBorderleftArray(CTBorder[] paramArrayOfCTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBorder, BORDERLEFT$38);
    } 
  }
  
  public void setBorderleftArray(int paramInt, CTBorder paramCTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(BORDERLEFT$38, paramInt);
      if (cTBorder == null)
        throw new IndexOutOfBoundsException(); 
      cTBorder.set((XmlObject)paramCTBorder);
    } 
  }
  
  public CTBorder insertNewBorderleft(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().insert_element_user(BORDERLEFT$38, paramInt);
      return cTBorder;
    } 
  }
  
  public CTBorder addNewBorderleft() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().add_element_user(BORDERLEFT$38);
      return cTBorder;
    } 
  }
  
  public void removeBorderleft(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BORDERLEFT$38, paramInt);
    } 
  }
  
  public List<CTBorder> getBorderrightList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTBorder>)new BorderrightList(this);
    } 
  }
  
  public CTBorder[] getBorderrightArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(BORDERRIGHT$40, arrayList);
      CTBorder[] arrayOfCTBorder = new CTBorder[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTBorder);
      return arrayOfCTBorder;
    } 
  }
  
  public CTBorder getBorderrightArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(BORDERRIGHT$40, paramInt);
      if (cTBorder == null)
        throw new IndexOutOfBoundsException(); 
      return cTBorder;
    } 
  }
  
  public int sizeOfBorderrightArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(BORDERRIGHT$40);
    } 
  }
  
  public void setBorderrightArray(CTBorder[] paramArrayOfCTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTBorder, BORDERRIGHT$40);
    } 
  }
  
  public void setBorderrightArray(int paramInt, CTBorder paramCTBorder) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().find_element_user(BORDERRIGHT$40, paramInt);
      if (cTBorder == null)
        throw new IndexOutOfBoundsException(); 
      cTBorder.set((XmlObject)paramCTBorder);
    } 
  }
  
  public CTBorder insertNewBorderright(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().insert_element_user(BORDERRIGHT$40, paramInt);
      return cTBorder;
    } 
  }
  
  public CTBorder addNewBorderright() {
    synchronized (monitor()) {
      check_orphaned();
      CTBorder cTBorder = null;
      cTBorder = (CTBorder)get_store().add_element_user(BORDERRIGHT$40);
      return cTBorder;
    } 
  }
  
  public void removeBorderright(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BORDERRIGHT$40, paramInt);
    } 
  }
  
  public List<CTClientData> getClientDataList() {
    synchronized (monitor()) {
      check_orphaned();
      final class ClientDataList extends AbstractList<CTClientData> {
        public CTClientData get(int param1Int) {
          return CTShapeImpl.this.getClientDataArray(param1Int);
        }
        
        public CTClientData set(int param1Int, CTClientData param1CTClientData) {
          CTClientData cTClientData = CTShapeImpl.this.getClientDataArray(param1Int);
          CTShapeImpl.this.setClientDataArray(param1Int, param1CTClientData);
          return cTClientData;
        }
        
        public void add(int param1Int, CTClientData param1CTClientData) {
          CTShapeImpl.this.insertNewClientData(param1Int).set((XmlObject)param1CTClientData);
        }
        
        public CTClientData remove(int param1Int) {
          CTClientData cTClientData = CTShapeImpl.this.getClientDataArray(param1Int);
          CTShapeImpl.this.removeClientData(param1Int);
          return cTClientData;
        }
        
        public int size() {
          return CTShapeImpl.this.sizeOfClientDataArray();
        }
      };
      return new ClientDataList();
    } 
  }
  
  public CTClientData[] getClientDataArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CLIENTDATA$42, arrayList);
      CTClientData[] arrayOfCTClientData = new CTClientData[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTClientData);
      return arrayOfCTClientData;
    } 
  }
  
  public CTClientData getClientDataArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTClientData cTClientData = null;
      cTClientData = (CTClientData)get_store().find_element_user(CLIENTDATA$42, paramInt);
      if (cTClientData == null)
        throw new IndexOutOfBoundsException(); 
      return cTClientData;
    } 
  }
  
  public int sizeOfClientDataArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CLIENTDATA$42);
    } 
  }
  
  public void setClientDataArray(CTClientData[] paramArrayOfCTClientData) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTClientData, CLIENTDATA$42);
    } 
  }
  
  public void setClientDataArray(int paramInt, CTClientData paramCTClientData) {
    synchronized (monitor()) {
      check_orphaned();
      CTClientData cTClientData = null;
      cTClientData = (CTClientData)get_store().find_element_user(CLIENTDATA$42, paramInt);
      if (cTClientData == null)
        throw new IndexOutOfBoundsException(); 
      cTClientData.set((XmlObject)paramCTClientData);
    } 
  }
  
  public CTClientData insertNewClientData(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTClientData cTClientData = null;
      cTClientData = (CTClientData)get_store().insert_element_user(CLIENTDATA$42, paramInt);
      return cTClientData;
    } 
  }
  
  public CTClientData addNewClientData() {
    synchronized (monitor()) {
      check_orphaned();
      CTClientData cTClientData = null;
      cTClientData = (CTClientData)get_store().add_element_user(CLIENTDATA$42);
      return cTClientData;
    } 
  }
  
  public void removeClientData(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CLIENTDATA$42, paramInt);
    } 
  }
  
  public List<CTRel> getTextdataList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTRel>)new TextdataList(this);
    } 
  }
  
  public CTRel[] getTextdataArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TEXTDATA$44, arrayList);
      CTRel[] arrayOfCTRel = new CTRel[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTRel);
      return arrayOfCTRel;
    } 
  }
  
  public CTRel getTextdataArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRel cTRel = null;
      cTRel = (CTRel)get_store().find_element_user(TEXTDATA$44, paramInt);
      if (cTRel == null)
        throw new IndexOutOfBoundsException(); 
      return cTRel;
    } 
  }
  
  public int sizeOfTextdataArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TEXTDATA$44);
    } 
  }
  
  public void setTextdataArray(CTRel[] paramArrayOfCTRel) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTRel, TEXTDATA$44);
    } 
  }
  
  public void setTextdataArray(int paramInt, CTRel paramCTRel) {
    synchronized (monitor()) {
      check_orphaned();
      CTRel cTRel = null;
      cTRel = (CTRel)get_store().find_element_user(TEXTDATA$44, paramInt);
      if (cTRel == null)
        throw new IndexOutOfBoundsException(); 
      cTRel.set((XmlObject)paramCTRel);
    } 
  }
  
  public CTRel insertNewTextdata(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRel cTRel = null;
      cTRel = (CTRel)get_store().insert_element_user(TEXTDATA$44, paramInt);
      return cTRel;
    } 
  }
  
  public CTRel addNewTextdata() {
    synchronized (monitor()) {
      check_orphaned();
      CTRel cTRel = null;
      cTRel = (CTRel)get_store().add_element_user(TEXTDATA$44);
      return cTRel;
    } 
  }
  
  public void removeTextdata(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TEXTDATA$44, paramInt);
    } 
  }
  
  public List<CTInk> getInkList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTInk>)new InkList(this);
    } 
  }
  
  public CTInk[] getInkArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(INK$46, arrayList);
      CTInk[] arrayOfCTInk = new CTInk[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTInk);
      return arrayOfCTInk;
    } 
  }
  
  public CTInk getInkArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTInk cTInk = null;
      cTInk = (CTInk)get_store().find_element_user(INK$46, paramInt);
      if (cTInk == null)
        throw new IndexOutOfBoundsException(); 
      return cTInk;
    } 
  }
  
  public int sizeOfInkArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(INK$46);
    } 
  }
  
  public void setInkArray(CTInk[] paramArrayOfCTInk) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTInk, INK$46);
    } 
  }
  
  public void setInkArray(int paramInt, CTInk paramCTInk) {
    synchronized (monitor()) {
      check_orphaned();
      CTInk cTInk = null;
      cTInk = (CTInk)get_store().find_element_user(INK$46, paramInt);
      if (cTInk == null)
        throw new IndexOutOfBoundsException(); 
      cTInk.set((XmlObject)paramCTInk);
    } 
  }
  
  public CTInk insertNewInk(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTInk cTInk = null;
      cTInk = (CTInk)get_store().insert_element_user(INK$46, paramInt);
      return cTInk;
    } 
  }
  
  public CTInk addNewInk() {
    synchronized (monitor()) {
      check_orphaned();
      CTInk cTInk = null;
      cTInk = (CTInk)get_store().add_element_user(INK$46);
      return cTInk;
    } 
  }
  
  public void removeInk(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(INK$46, paramInt);
    } 
  }
  
  public List<CTEmpty> getIscommentList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTEmpty>)new IscommentList(this);
    } 
  }
  
  public CTEmpty[] getIscommentArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ISCOMMENT$48, arrayList);
      CTEmpty[] arrayOfCTEmpty = new CTEmpty[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTEmpty);
      return arrayOfCTEmpty;
    } 
  }
  
  public CTEmpty getIscommentArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(ISCOMMENT$48, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      return cTEmpty;
    } 
  }
  
  public int sizeOfIscommentArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ISCOMMENT$48);
    } 
  }
  
  public void setIscommentArray(CTEmpty[] paramArrayOfCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTEmpty, ISCOMMENT$48);
    } 
  }
  
  public void setIscommentArray(int paramInt, CTEmpty paramCTEmpty) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().find_element_user(ISCOMMENT$48, paramInt);
      if (cTEmpty == null)
        throw new IndexOutOfBoundsException(); 
      cTEmpty.set((XmlObject)paramCTEmpty);
    } 
  }
  
  public CTEmpty insertNewIscomment(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().insert_element_user(ISCOMMENT$48, paramInt);
      return cTEmpty;
    } 
  }
  
  public CTEmpty addNewIscomment() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmpty cTEmpty = null;
      cTEmpty = (CTEmpty)get_store().add_element_user(ISCOMMENT$48);
      return cTEmpty;
    } 
  }
  
  public void removeIscomment(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ISCOMMENT$48, paramInt);
    } 
  }
  
  public String getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$50);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ID$50);
      return xmlString;
    } 
  }
  
  public boolean isSetId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ID$50) != null);
    } 
  }
  
  public void setId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$50);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$50); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetId(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ID$50);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(ID$50); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ID$50);
    } 
  }
  
  public String getStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STYLE$52);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(STYLE$52);
      return xmlString;
    } 
  }
  
  public boolean isSetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STYLE$52) != null);
    } 
  }
  
  public void setStyle(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STYLE$52);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STYLE$52); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetStyle(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(STYLE$52);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(STYLE$52); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STYLE$52);
    } 
  }
  
  public String getHref() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HREF$54);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetHref() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(HREF$54);
      return xmlString;
    } 
  }
  
  public boolean isSetHref() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HREF$54) != null);
    } 
  }
  
  public void setHref(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HREF$54);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HREF$54); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetHref(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(HREF$54);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(HREF$54); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetHref() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HREF$54);
    } 
  }
  
  public String getTarget() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TARGET$56);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetTarget() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TARGET$56);
      return xmlString;
    } 
  }
  
  public boolean isSetTarget() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TARGET$56) != null);
    } 
  }
  
  public void setTarget(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TARGET$56);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TARGET$56); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTarget(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TARGET$56);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(TARGET$56); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetTarget() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TARGET$56);
    } 
  }
  
  public String getClass1() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CLASS1$58);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetClass1() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(CLASS1$58);
      return xmlString;
    } 
  }
  
  public boolean isSetClass1() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CLASS1$58) != null);
    } 
  }
  
  public void setClass1(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CLASS1$58);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CLASS1$58); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetClass1(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(CLASS1$58);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(CLASS1$58); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetClass1() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CLASS1$58);
    } 
  }
  
  public String getTitle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TITLE$60);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetTitle() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TITLE$60);
      return xmlString;
    } 
  }
  
  public boolean isSetTitle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TITLE$60) != null);
    } 
  }
  
  public void setTitle(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TITLE$60);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TITLE$60); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTitle(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TITLE$60);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(TITLE$60); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetTitle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TITLE$60);
    } 
  }
  
  public String getAlt() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALT$62);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetAlt() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ALT$62);
      return xmlString;
    } 
  }
  
  public boolean isSetAlt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ALT$62) != null);
    } 
  }
  
  public void setAlt(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALT$62);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALT$62); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetAlt(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ALT$62);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(ALT$62); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetAlt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ALT$62);
    } 
  }
  
  public String getCoordsize() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COORDSIZE$64);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetCoordsize() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(COORDSIZE$64);
      return xmlString;
    } 
  }
  
  public boolean isSetCoordsize() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COORDSIZE$64) != null);
    } 
  }
  
  public void setCoordsize(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COORDSIZE$64);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COORDSIZE$64); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetCoordsize(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(COORDSIZE$64);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(COORDSIZE$64); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetCoordsize() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COORDSIZE$64);
    } 
  }
  
  public String getCoordorigin() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COORDORIGIN$66);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetCoordorigin() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(COORDORIGIN$66);
      return xmlString;
    } 
  }
  
  public boolean isSetCoordorigin() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COORDORIGIN$66) != null);
    } 
  }
  
  public void setCoordorigin(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COORDORIGIN$66);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COORDORIGIN$66); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetCoordorigin(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(COORDORIGIN$66);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(COORDORIGIN$66); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetCoordorigin() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COORDORIGIN$66);
    } 
  }
  
  public String getWrapcoords() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WRAPCOORDS$68);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetWrapcoords() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(WRAPCOORDS$68);
      return xmlString;
    } 
  }
  
  public boolean isSetWrapcoords() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(WRAPCOORDS$68) != null);
    } 
  }
  
  public void setWrapcoords(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WRAPCOORDS$68);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(WRAPCOORDS$68); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetWrapcoords(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(WRAPCOORDS$68);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(WRAPCOORDS$68); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetWrapcoords() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(WRAPCOORDS$68);
    } 
  }
  
  public STTrueFalse.Enum getPrint() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PRINT$70);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetPrint() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(PRINT$70);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetPrint() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PRINT$70) != null);
    } 
  }
  
  public void setPrint(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PRINT$70);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PRINT$70); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetPrint(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(PRINT$70);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(PRINT$70); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetPrint() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PRINT$70);
    } 
  }
  
  public String getSpid() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SPID$72);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetSpid() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(SPID$72);
      return xmlString;
    } 
  }
  
  public boolean isSetSpid() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SPID$72) != null);
    } 
  }
  
  public void setSpid(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SPID$72);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SPID$72); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetSpid(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(SPID$72);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(SPID$72); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetSpid() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SPID$72);
    } 
  }
  
  public STTrueFalse.Enum getOned() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ONED$74);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetOned() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ONED$74);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetOned() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ONED$74) != null);
    } 
  }
  
  public void setOned(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ONED$74);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ONED$74); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetOned(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ONED$74);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(ONED$74); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetOned() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ONED$74);
    } 
  }
  
  public BigInteger getRegroupid() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REGROUPID$76);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public XmlInteger xgetRegroupid() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_attribute_user(REGROUPID$76);
      return xmlInteger;
    } 
  }
  
  public boolean isSetRegroupid() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(REGROUPID$76) != null);
    } 
  }
  
  public void setRegroupid(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REGROUPID$76);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(REGROUPID$76); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetRegroupid(XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_attribute_user(REGROUPID$76);
      if (xmlInteger == null)
        xmlInteger = (XmlInteger)get_store().add_attribute_user(REGROUPID$76); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void unsetRegroupid() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(REGROUPID$76);
    } 
  }
  
  public STTrueFalse.Enum getDoubleclicknotify() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DOUBLECLICKNOTIFY$78);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetDoubleclicknotify() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(DOUBLECLICKNOTIFY$78);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetDoubleclicknotify() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DOUBLECLICKNOTIFY$78) != null);
    } 
  }
  
  public void setDoubleclicknotify(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DOUBLECLICKNOTIFY$78);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DOUBLECLICKNOTIFY$78); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetDoubleclicknotify(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(DOUBLECLICKNOTIFY$78);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(DOUBLECLICKNOTIFY$78); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetDoubleclicknotify() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DOUBLECLICKNOTIFY$78);
    } 
  }
  
  public STTrueFalse.Enum getButton() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BUTTON$80);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetButton() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(BUTTON$80);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetButton() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BUTTON$80) != null);
    } 
  }
  
  public void setButton(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BUTTON$80);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BUTTON$80); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetButton(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(BUTTON$80);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(BUTTON$80); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetButton() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BUTTON$80);
    } 
  }
  
  public STTrueFalse.Enum getUserhidden() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(USERHIDDEN$82);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetUserhidden() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(USERHIDDEN$82);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetUserhidden() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(USERHIDDEN$82) != null);
    } 
  }
  
  public void setUserhidden(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(USERHIDDEN$82);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(USERHIDDEN$82); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetUserhidden(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(USERHIDDEN$82);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(USERHIDDEN$82); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetUserhidden() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(USERHIDDEN$82);
    } 
  }
  
  public STTrueFalse.Enum getBullet() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BULLET$84);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetBullet() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(BULLET$84);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetBullet() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BULLET$84) != null);
    } 
  }
  
  public void setBullet(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BULLET$84);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BULLET$84); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetBullet(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(BULLET$84);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(BULLET$84); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetBullet() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BULLET$84);
    } 
  }
  
  public STTrueFalse.Enum getHr() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HR$86);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetHr() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(HR$86);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetHr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HR$86) != null);
    } 
  }
  
  public void setHr(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HR$86);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HR$86); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetHr(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(HR$86);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(HR$86); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetHr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HR$86);
    } 
  }
  
  public STTrueFalse.Enum getHrstd() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HRSTD$88);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetHrstd() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(HRSTD$88);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetHrstd() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HRSTD$88) != null);
    } 
  }
  
  public void setHrstd(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HRSTD$88);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HRSTD$88); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetHrstd(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(HRSTD$88);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(HRSTD$88); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetHrstd() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HRSTD$88);
    } 
  }
  
  public STTrueFalse.Enum getHrnoshade() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HRNOSHADE$90);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetHrnoshade() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(HRNOSHADE$90);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetHrnoshade() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HRNOSHADE$90) != null);
    } 
  }
  
  public void setHrnoshade(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HRNOSHADE$90);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HRNOSHADE$90); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetHrnoshade(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(HRNOSHADE$90);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(HRNOSHADE$90); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetHrnoshade() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HRNOSHADE$90);
    } 
  }
  
  public float getHrpct() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HRPCT$92);
      if (simpleValue == null)
        return 0.0F; 
      return simpleValue.getFloatValue();
    } 
  }
  
  public XmlFloat xgetHrpct() {
    synchronized (monitor()) {
      check_orphaned();
      XmlFloat xmlFloat = null;
      xmlFloat = (XmlFloat)get_store().find_attribute_user(HRPCT$92);
      return xmlFloat;
    } 
  }
  
  public boolean isSetHrpct() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HRPCT$92) != null);
    } 
  }
  
  public void setHrpct(float paramFloat) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HRPCT$92);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HRPCT$92); 
      simpleValue.setFloatValue(paramFloat);
    } 
  }
  
  public void xsetHrpct(XmlFloat paramXmlFloat) {
    synchronized (monitor()) {
      check_orphaned();
      XmlFloat xmlFloat = null;
      xmlFloat = (XmlFloat)get_store().find_attribute_user(HRPCT$92);
      if (xmlFloat == null)
        xmlFloat = (XmlFloat)get_store().add_attribute_user(HRPCT$92); 
      xmlFloat.set((XmlObject)paramXmlFloat);
    } 
  }
  
  public void unsetHrpct() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HRPCT$92);
    } 
  }
  
  public STHrAlign.Enum getHralign() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HRALIGN$94);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(HRALIGN$94); 
      if (simpleValue == null)
        return null; 
      return (STHrAlign.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STHrAlign xgetHralign() {
    synchronized (monitor()) {
      check_orphaned();
      STHrAlign sTHrAlign = null;
      sTHrAlign = (STHrAlign)get_store().find_attribute_user(HRALIGN$94);
      if (sTHrAlign == null)
        sTHrAlign = (STHrAlign)get_default_attribute_value(HRALIGN$94); 
      return sTHrAlign;
    } 
  }
  
  public boolean isSetHralign() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HRALIGN$94) != null);
    } 
  }
  
  public void setHralign(STHrAlign.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HRALIGN$94);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HRALIGN$94); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetHralign(STHrAlign paramSTHrAlign) {
    synchronized (monitor()) {
      check_orphaned();
      STHrAlign sTHrAlign = null;
      sTHrAlign = (STHrAlign)get_store().find_attribute_user(HRALIGN$94);
      if (sTHrAlign == null)
        sTHrAlign = (STHrAlign)get_store().add_attribute_user(HRALIGN$94); 
      sTHrAlign.set((XmlObject)paramSTHrAlign);
    } 
  }
  
  public void unsetHralign() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HRALIGN$94);
    } 
  }
  
  public STTrueFalse.Enum getAllowincell() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALLOWINCELL$96);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetAllowincell() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ALLOWINCELL$96);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetAllowincell() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ALLOWINCELL$96) != null);
    } 
  }
  
  public void setAllowincell(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALLOWINCELL$96);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALLOWINCELL$96); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAllowincell(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ALLOWINCELL$96);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(ALLOWINCELL$96); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetAllowincell() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ALLOWINCELL$96);
    } 
  }
  
  public STTrueFalse.Enum getAllowoverlap() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALLOWOVERLAP$98);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetAllowoverlap() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ALLOWOVERLAP$98);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetAllowoverlap() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ALLOWOVERLAP$98) != null);
    } 
  }
  
  public void setAllowoverlap(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALLOWOVERLAP$98);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALLOWOVERLAP$98); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAllowoverlap(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ALLOWOVERLAP$98);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(ALLOWOVERLAP$98); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetAllowoverlap() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ALLOWOVERLAP$98);
    } 
  }
  
  public STTrueFalse.Enum getUserdrawn() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(USERDRAWN$100);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetUserdrawn() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(USERDRAWN$100);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetUserdrawn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(USERDRAWN$100) != null);
    } 
  }
  
  public void setUserdrawn(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(USERDRAWN$100);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(USERDRAWN$100); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetUserdrawn(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(USERDRAWN$100);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(USERDRAWN$100); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetUserdrawn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(USERDRAWN$100);
    } 
  }
  
  public String getBordertopcolor() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BORDERTOPCOLOR$102);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetBordertopcolor() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(BORDERTOPCOLOR$102);
      return xmlString;
    } 
  }
  
  public boolean isSetBordertopcolor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BORDERTOPCOLOR$102) != null);
    } 
  }
  
  public void setBordertopcolor(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BORDERTOPCOLOR$102);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BORDERTOPCOLOR$102); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetBordertopcolor(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(BORDERTOPCOLOR$102);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(BORDERTOPCOLOR$102); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetBordertopcolor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BORDERTOPCOLOR$102);
    } 
  }
  
  public String getBorderleftcolor() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BORDERLEFTCOLOR$104);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetBorderleftcolor() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(BORDERLEFTCOLOR$104);
      return xmlString;
    } 
  }
  
  public boolean isSetBorderleftcolor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BORDERLEFTCOLOR$104) != null);
    } 
  }
  
  public void setBorderleftcolor(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BORDERLEFTCOLOR$104);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BORDERLEFTCOLOR$104); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetBorderleftcolor(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(BORDERLEFTCOLOR$104);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(BORDERLEFTCOLOR$104); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetBorderleftcolor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BORDERLEFTCOLOR$104);
    } 
  }
  
  public String getBorderbottomcolor() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BORDERBOTTOMCOLOR$106);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetBorderbottomcolor() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(BORDERBOTTOMCOLOR$106);
      return xmlString;
    } 
  }
  
  public boolean isSetBorderbottomcolor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BORDERBOTTOMCOLOR$106) != null);
    } 
  }
  
  public void setBorderbottomcolor(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BORDERBOTTOMCOLOR$106);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BORDERBOTTOMCOLOR$106); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetBorderbottomcolor(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(BORDERBOTTOMCOLOR$106);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(BORDERBOTTOMCOLOR$106); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetBorderbottomcolor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BORDERBOTTOMCOLOR$106);
    } 
  }
  
  public String getBorderrightcolor() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BORDERRIGHTCOLOR$108);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetBorderrightcolor() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(BORDERRIGHTCOLOR$108);
      return xmlString;
    } 
  }
  
  public boolean isSetBorderrightcolor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BORDERRIGHTCOLOR$108) != null);
    } 
  }
  
  public void setBorderrightcolor(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BORDERRIGHTCOLOR$108);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BORDERRIGHTCOLOR$108); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetBorderrightcolor(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(BORDERRIGHTCOLOR$108);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(BORDERRIGHTCOLOR$108); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetBorderrightcolor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BORDERRIGHTCOLOR$108);
    } 
  }
  
  public BigInteger getDgmlayout() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DGMLAYOUT$110);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public XmlInteger xgetDgmlayout() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_attribute_user(DGMLAYOUT$110);
      return xmlInteger;
    } 
  }
  
  public boolean isSetDgmlayout() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DGMLAYOUT$110) != null);
    } 
  }
  
  public void setDgmlayout(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DGMLAYOUT$110);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DGMLAYOUT$110); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetDgmlayout(XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_attribute_user(DGMLAYOUT$110);
      if (xmlInteger == null)
        xmlInteger = (XmlInteger)get_store().add_attribute_user(DGMLAYOUT$110); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void unsetDgmlayout() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DGMLAYOUT$110);
    } 
  }
  
  public BigInteger getDgmnodekind() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DGMNODEKIND$112);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public XmlInteger xgetDgmnodekind() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_attribute_user(DGMNODEKIND$112);
      return xmlInteger;
    } 
  }
  
  public boolean isSetDgmnodekind() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DGMNODEKIND$112) != null);
    } 
  }
  
  public void setDgmnodekind(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DGMNODEKIND$112);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DGMNODEKIND$112); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetDgmnodekind(XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_attribute_user(DGMNODEKIND$112);
      if (xmlInteger == null)
        xmlInteger = (XmlInteger)get_store().add_attribute_user(DGMNODEKIND$112); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void unsetDgmnodekind() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DGMNODEKIND$112);
    } 
  }
  
  public BigInteger getDgmlayoutmru() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DGMLAYOUTMRU$114);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public XmlInteger xgetDgmlayoutmru() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_attribute_user(DGMLAYOUTMRU$114);
      return xmlInteger;
    } 
  }
  
  public boolean isSetDgmlayoutmru() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DGMLAYOUTMRU$114) != null);
    } 
  }
  
  public void setDgmlayoutmru(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DGMLAYOUTMRU$114);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DGMLAYOUTMRU$114); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetDgmlayoutmru(XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_attribute_user(DGMLAYOUTMRU$114);
      if (xmlInteger == null)
        xmlInteger = (XmlInteger)get_store().add_attribute_user(DGMLAYOUTMRU$114); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void unsetDgmlayoutmru() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DGMLAYOUTMRU$114);
    } 
  }
  
  public STInsetMode.Enum getInsetmode() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSETMODE$116);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(INSETMODE$116); 
      if (simpleValue == null)
        return null; 
      return (STInsetMode.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STInsetMode xgetInsetmode() {
    synchronized (monitor()) {
      check_orphaned();
      STInsetMode sTInsetMode = null;
      sTInsetMode = (STInsetMode)get_store().find_attribute_user(INSETMODE$116);
      if (sTInsetMode == null)
        sTInsetMode = (STInsetMode)get_default_attribute_value(INSETMODE$116); 
      return sTInsetMode;
    } 
  }
  
  public boolean isSetInsetmode() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(INSETMODE$116) != null);
    } 
  }
  
  public void setInsetmode(STInsetMode.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSETMODE$116);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INSETMODE$116); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetInsetmode(STInsetMode paramSTInsetMode) {
    synchronized (monitor()) {
      check_orphaned();
      STInsetMode sTInsetMode = null;
      sTInsetMode = (STInsetMode)get_store().find_attribute_user(INSETMODE$116);
      if (sTInsetMode == null)
        sTInsetMode = (STInsetMode)get_store().add_attribute_user(INSETMODE$116); 
      sTInsetMode.set((XmlObject)paramSTInsetMode);
    } 
  }
  
  public void unsetInsetmode() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(INSETMODE$116);
    } 
  }
  
  public String getChromakey() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CHROMAKEY$118);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STColorType xgetChromakey() {
    synchronized (monitor()) {
      check_orphaned();
      STColorType sTColorType = null;
      sTColorType = (STColorType)get_store().find_attribute_user(CHROMAKEY$118);
      return sTColorType;
    } 
  }
  
  public boolean isSetChromakey() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CHROMAKEY$118) != null);
    } 
  }
  
  public void setChromakey(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CHROMAKEY$118);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CHROMAKEY$118); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetChromakey(STColorType paramSTColorType) {
    synchronized (monitor()) {
      check_orphaned();
      STColorType sTColorType = null;
      sTColorType = (STColorType)get_store().find_attribute_user(CHROMAKEY$118);
      if (sTColorType == null)
        sTColorType = (STColorType)get_store().add_attribute_user(CHROMAKEY$118); 
      sTColorType.set((XmlObject)paramSTColorType);
    } 
  }
  
  public void unsetChromakey() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CHROMAKEY$118);
    } 
  }
  
  public STTrueFalse.Enum getFilled() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILLED$120);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetFilled() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(FILLED$120);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetFilled() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FILLED$120) != null);
    } 
  }
  
  public void setFilled(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILLED$120);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FILLED$120); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetFilled(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(FILLED$120);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(FILLED$120); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetFilled() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FILLED$120);
    } 
  }
  
  public String getFillcolor() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILLCOLOR$122);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STColorType xgetFillcolor() {
    synchronized (monitor()) {
      check_orphaned();
      STColorType sTColorType = null;
      sTColorType = (STColorType)get_store().find_attribute_user(FILLCOLOR$122);
      return sTColorType;
    } 
  }
  
  public boolean isSetFillcolor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FILLCOLOR$122) != null);
    } 
  }
  
  public void setFillcolor(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILLCOLOR$122);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FILLCOLOR$122); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetFillcolor(STColorType paramSTColorType) {
    synchronized (monitor()) {
      check_orphaned();
      STColorType sTColorType = null;
      sTColorType = (STColorType)get_store().find_attribute_user(FILLCOLOR$122);
      if (sTColorType == null)
        sTColorType = (STColorType)get_store().add_attribute_user(FILLCOLOR$122); 
      sTColorType.set((XmlObject)paramSTColorType);
    } 
  }
  
  public void unsetFillcolor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FILLCOLOR$122);
    } 
  }
  
  public String getOpacity() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OPACITY$124);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetOpacity() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(OPACITY$124);
      return xmlString;
    } 
  }
  
  public boolean isSetOpacity() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(OPACITY$124) != null);
    } 
  }
  
  public void setOpacity(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OPACITY$124);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(OPACITY$124); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetOpacity(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(OPACITY$124);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(OPACITY$124); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetOpacity() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(OPACITY$124);
    } 
  }
  
  public STTrueFalse.Enum getStroked() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STROKED$126);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetStroked() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(STROKED$126);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetStroked() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STROKED$126) != null);
    } 
  }
  
  public void setStroked(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STROKED$126);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STROKED$126); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetStroked(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(STROKED$126);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(STROKED$126); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetStroked() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STROKED$126);
    } 
  }
  
  public String getStrokecolor() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STROKECOLOR$128);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STColorType xgetStrokecolor() {
    synchronized (monitor()) {
      check_orphaned();
      STColorType sTColorType = null;
      sTColorType = (STColorType)get_store().find_attribute_user(STROKECOLOR$128);
      return sTColorType;
    } 
  }
  
  public boolean isSetStrokecolor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STROKECOLOR$128) != null);
    } 
  }
  
  public void setStrokecolor(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STROKECOLOR$128);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STROKECOLOR$128); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetStrokecolor(STColorType paramSTColorType) {
    synchronized (monitor()) {
      check_orphaned();
      STColorType sTColorType = null;
      sTColorType = (STColorType)get_store().find_attribute_user(STROKECOLOR$128);
      if (sTColorType == null)
        sTColorType = (STColorType)get_store().add_attribute_user(STROKECOLOR$128); 
      sTColorType.set((XmlObject)paramSTColorType);
    } 
  }
  
  public void unsetStrokecolor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STROKECOLOR$128);
    } 
  }
  
  public String getStrokeweight() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STROKEWEIGHT$130);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetStrokeweight() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(STROKEWEIGHT$130);
      return xmlString;
    } 
  }
  
  public boolean isSetStrokeweight() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STROKEWEIGHT$130) != null);
    } 
  }
  
  public void setStrokeweight(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STROKEWEIGHT$130);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STROKEWEIGHT$130); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetStrokeweight(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(STROKEWEIGHT$130);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(STROKEWEIGHT$130); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetStrokeweight() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STROKEWEIGHT$130);
    } 
  }
  
  public STTrueFalse.Enum getInsetpen() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSETPEN$132);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetInsetpen() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(INSETPEN$132);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetInsetpen() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(INSETPEN$132) != null);
    } 
  }
  
  public void setInsetpen(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSETPEN$132);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INSETPEN$132); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetInsetpen(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(INSETPEN$132);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(INSETPEN$132); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetInsetpen() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(INSETPEN$132);
    } 
  }
  
  public float getSpt() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SPT$134);
      if (simpleValue == null)
        return 0.0F; 
      return simpleValue.getFloatValue();
    } 
  }
  
  public XmlFloat xgetSpt() {
    synchronized (monitor()) {
      check_orphaned();
      XmlFloat xmlFloat = null;
      xmlFloat = (XmlFloat)get_store().find_attribute_user(SPT$134);
      return xmlFloat;
    } 
  }
  
  public boolean isSetSpt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SPT$134) != null);
    } 
  }
  
  public void setSpt(float paramFloat) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SPT$134);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SPT$134); 
      simpleValue.setFloatValue(paramFloat);
    } 
  }
  
  public void xsetSpt(XmlFloat paramXmlFloat) {
    synchronized (monitor()) {
      check_orphaned();
      XmlFloat xmlFloat = null;
      xmlFloat = (XmlFloat)get_store().find_attribute_user(SPT$134);
      if (xmlFloat == null)
        xmlFloat = (XmlFloat)get_store().add_attribute_user(SPT$134); 
      xmlFloat.set((XmlObject)paramXmlFloat);
    } 
  }
  
  public void unsetSpt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SPT$134);
    } 
  }
  
  public STConnectorType.Enum getConnectortype() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONNECTORTYPE$136);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CONNECTORTYPE$136); 
      if (simpleValue == null)
        return null; 
      return (STConnectorType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STConnectorType xgetConnectortype() {
    synchronized (monitor()) {
      check_orphaned();
      STConnectorType sTConnectorType = null;
      sTConnectorType = (STConnectorType)get_store().find_attribute_user(CONNECTORTYPE$136);
      if (sTConnectorType == null)
        sTConnectorType = (STConnectorType)get_default_attribute_value(CONNECTORTYPE$136); 
      return sTConnectorType;
    } 
  }
  
  public boolean isSetConnectortype() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CONNECTORTYPE$136) != null);
    } 
  }
  
  public void setConnectortype(STConnectorType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONNECTORTYPE$136);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CONNECTORTYPE$136); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetConnectortype(STConnectorType paramSTConnectorType) {
    synchronized (monitor()) {
      check_orphaned();
      STConnectorType sTConnectorType = null;
      sTConnectorType = (STConnectorType)get_store().find_attribute_user(CONNECTORTYPE$136);
      if (sTConnectorType == null)
        sTConnectorType = (STConnectorType)get_store().add_attribute_user(CONNECTORTYPE$136); 
      sTConnectorType.set((XmlObject)paramSTConnectorType);
    } 
  }
  
  public void unsetConnectortype() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CONNECTORTYPE$136);
    } 
  }
  
  public STBWMode.Enum getBwmode() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BWMODE$138);
      if (simpleValue == null)
        return null; 
      return (STBWMode.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STBWMode xgetBwmode() {
    synchronized (monitor()) {
      check_orphaned();
      STBWMode sTBWMode = null;
      sTBWMode = (STBWMode)get_store().find_attribute_user(BWMODE$138);
      return sTBWMode;
    } 
  }
  
  public boolean isSetBwmode() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BWMODE$138) != null);
    } 
  }
  
  public void setBwmode(STBWMode.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BWMODE$138);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BWMODE$138); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetBwmode(STBWMode paramSTBWMode) {
    synchronized (monitor()) {
      check_orphaned();
      STBWMode sTBWMode = null;
      sTBWMode = (STBWMode)get_store().find_attribute_user(BWMODE$138);
      if (sTBWMode == null)
        sTBWMode = (STBWMode)get_store().add_attribute_user(BWMODE$138); 
      sTBWMode.set((XmlObject)paramSTBWMode);
    } 
  }
  
  public void unsetBwmode() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BWMODE$138);
    } 
  }
  
  public STBWMode.Enum getBwpure() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BWPURE$140);
      if (simpleValue == null)
        return null; 
      return (STBWMode.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STBWMode xgetBwpure() {
    synchronized (monitor()) {
      check_orphaned();
      STBWMode sTBWMode = null;
      sTBWMode = (STBWMode)get_store().find_attribute_user(BWPURE$140);
      return sTBWMode;
    } 
  }
  
  public boolean isSetBwpure() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BWPURE$140) != null);
    } 
  }
  
  public void setBwpure(STBWMode.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BWPURE$140);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BWPURE$140); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetBwpure(STBWMode paramSTBWMode) {
    synchronized (monitor()) {
      check_orphaned();
      STBWMode sTBWMode = null;
      sTBWMode = (STBWMode)get_store().find_attribute_user(BWPURE$140);
      if (sTBWMode == null)
        sTBWMode = (STBWMode)get_store().add_attribute_user(BWPURE$140); 
      sTBWMode.set((XmlObject)paramSTBWMode);
    } 
  }
  
  public void unsetBwpure() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BWPURE$140);
    } 
  }
  
  public STBWMode.Enum getBwnormal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BWNORMAL$142);
      if (simpleValue == null)
        return null; 
      return (STBWMode.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STBWMode xgetBwnormal() {
    synchronized (monitor()) {
      check_orphaned();
      STBWMode sTBWMode = null;
      sTBWMode = (STBWMode)get_store().find_attribute_user(BWNORMAL$142);
      return sTBWMode;
    } 
  }
  
  public boolean isSetBwnormal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BWNORMAL$142) != null);
    } 
  }
  
  public void setBwnormal(STBWMode.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BWNORMAL$142);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BWNORMAL$142); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetBwnormal(STBWMode paramSTBWMode) {
    synchronized (monitor()) {
      check_orphaned();
      STBWMode sTBWMode = null;
      sTBWMode = (STBWMode)get_store().find_attribute_user(BWNORMAL$142);
      if (sTBWMode == null)
        sTBWMode = (STBWMode)get_store().add_attribute_user(BWNORMAL$142); 
      sTBWMode.set((XmlObject)paramSTBWMode);
    } 
  }
  
  public void unsetBwnormal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BWNORMAL$142);
    } 
  }
  
  public STTrueFalse.Enum getForcedash() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORCEDASH$144);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetForcedash() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(FORCEDASH$144);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetForcedash() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FORCEDASH$144) != null);
    } 
  }
  
  public void setForcedash(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORCEDASH$144);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FORCEDASH$144); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetForcedash(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(FORCEDASH$144);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(FORCEDASH$144); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetForcedash() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FORCEDASH$144);
    } 
  }
  
  public STTrueFalse.Enum getOleicon() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OLEICON$146);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetOleicon() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(OLEICON$146);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetOleicon() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(OLEICON$146) != null);
    } 
  }
  
  public void setOleicon(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OLEICON$146);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(OLEICON$146); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetOleicon(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(OLEICON$146);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(OLEICON$146); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetOleicon() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(OLEICON$146);
    } 
  }
  
  public STTrueFalseBlank.Enum getOle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OLE$148);
      if (simpleValue == null)
        return null; 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalseBlank xgetOle() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_attribute_user(OLE$148);
      return sTTrueFalseBlank;
    } 
  }
  
  public boolean isSetOle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(OLE$148) != null);
    } 
  }
  
  public void setOle(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OLE$148);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(OLE$148); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetOle(STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_attribute_user(OLE$148);
      if (sTTrueFalseBlank == null)
        sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_attribute_user(OLE$148); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void unsetOle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(OLE$148);
    } 
  }
  
  public STTrueFalse.Enum getPreferrelative() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PREFERRELATIVE$150);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetPreferrelative() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(PREFERRELATIVE$150);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetPreferrelative() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PREFERRELATIVE$150) != null);
    } 
  }
  
  public void setPreferrelative(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PREFERRELATIVE$150);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PREFERRELATIVE$150); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetPreferrelative(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(PREFERRELATIVE$150);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(PREFERRELATIVE$150); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetPreferrelative() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PREFERRELATIVE$150);
    } 
  }
  
  public STTrueFalse.Enum getCliptowrap() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CLIPTOWRAP$152);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetCliptowrap() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(CLIPTOWRAP$152);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetCliptowrap() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CLIPTOWRAP$152) != null);
    } 
  }
  
  public void setCliptowrap(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CLIPTOWRAP$152);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CLIPTOWRAP$152); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetCliptowrap(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(CLIPTOWRAP$152);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(CLIPTOWRAP$152); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetCliptowrap() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CLIPTOWRAP$152);
    } 
  }
  
  public STTrueFalse.Enum getClip() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CLIP$154);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetClip() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(CLIP$154);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetClip() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CLIP$154) != null);
    } 
  }
  
  public void setClip(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CLIP$154);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CLIP$154); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetClip(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(CLIP$154);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(CLIP$154); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetClip() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CLIP$154);
    } 
  }
  
  public String getType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$156);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetType() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TYPE$156);
      return xmlString;
    } 
  }
  
  public boolean isSetType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TYPE$156) != null);
    } 
  }
  
  public void setType(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$156);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TYPE$156); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetType(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TYPE$156);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(TYPE$156); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TYPE$156);
    } 
  }
  
  public String getAdj() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ADJ$158);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetAdj() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ADJ$158);
      return xmlString;
    } 
  }
  
  public boolean isSetAdj() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ADJ$158) != null);
    } 
  }
  
  public void setAdj(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ADJ$158);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ADJ$158); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetAdj(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ADJ$158);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(ADJ$158); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetAdj() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ADJ$158);
    } 
  }
  
  public String getPath2() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PATH2$160);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetPath2() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(PATH2$160);
      return xmlString;
    } 
  }
  
  public boolean isSetPath2() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PATH2$160) != null);
    } 
  }
  
  public void setPath2(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PATH2$160);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PATH2$160); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetPath2(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(PATH2$160);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(PATH2$160); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetPath2() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PATH2$160);
    } 
  }
  
  public byte[] getGfxdata() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(GFXDATA$162);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public XmlBase64Binary xgetGfxdata() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_attribute_user(GFXDATA$162);
      return xmlBase64Binary;
    } 
  }
  
  public boolean isSetGfxdata() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(GFXDATA$162) != null);
    } 
  }
  
  public void setGfxdata(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(GFXDATA$162);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(GFXDATA$162); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetGfxdata(XmlBase64Binary paramXmlBase64Binary) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_attribute_user(GFXDATA$162);
      if (xmlBase64Binary == null)
        xmlBase64Binary = (XmlBase64Binary)get_store().add_attribute_user(GFXDATA$162); 
      xmlBase64Binary.set((XmlObject)paramXmlBase64Binary);
    } 
  }
  
  public void unsetGfxdata() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(GFXDATA$162);
    } 
  }
  
  public String getEquationxml() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EQUATIONXML$164);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetEquationxml() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(EQUATIONXML$164);
      return xmlString;
    } 
  }
  
  public boolean isSetEquationxml() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(EQUATIONXML$164) != null);
    } 
  }
  
  public void setEquationxml(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EQUATIONXML$164);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(EQUATIONXML$164); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetEquationxml(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(EQUATIONXML$164);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(EQUATIONXML$164); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetEquationxml() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(EQUATIONXML$164);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\impl\CTShapeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */