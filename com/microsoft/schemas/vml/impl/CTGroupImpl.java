package com.microsoft.schemas.vml.impl;

import com.microsoft.schemas.office.excel.CTClientData;
import com.microsoft.schemas.office.office.CTCallout;
import com.microsoft.schemas.office.office.CTClipPath;
import com.microsoft.schemas.office.office.CTDiagram;
import com.microsoft.schemas.office.office.CTExtrusion;
import com.microsoft.schemas.office.office.CTLock;
import com.microsoft.schemas.office.office.CTSignatureLine;
import com.microsoft.schemas.office.office.CTSkew;
import com.microsoft.schemas.office.office.STHrAlign;
import com.microsoft.schemas.office.office.STInsetMode;
import com.microsoft.schemas.office.office.STTrueFalse;
import com.microsoft.schemas.office.powerpoint.CTRel;
import com.microsoft.schemas.office.word.CTAnchorLock;
import com.microsoft.schemas.office.word.CTBorder;
import com.microsoft.schemas.office.word.CTWrap;
import com.microsoft.schemas.vml.CTArc;
import com.microsoft.schemas.vml.CTCurve;
import com.microsoft.schemas.vml.CTFill;
import com.microsoft.schemas.vml.CTFormulas;
import com.microsoft.schemas.vml.CTGroup;
import com.microsoft.schemas.vml.CTHandles;
import com.microsoft.schemas.vml.CTImage;
import com.microsoft.schemas.vml.CTImageData;
import com.microsoft.schemas.vml.CTLine;
import com.microsoft.schemas.vml.CTOval;
import com.microsoft.schemas.vml.CTPath;
import com.microsoft.schemas.vml.CTPolyLine;
import com.microsoft.schemas.vml.CTRect;
import com.microsoft.schemas.vml.CTRoundRect;
import com.microsoft.schemas.vml.CTShadow;
import com.microsoft.schemas.vml.CTShape;
import com.microsoft.schemas.vml.CTShapetype;
import com.microsoft.schemas.vml.CTStroke;
import com.microsoft.schemas.vml.CTTextPath;
import com.microsoft.schemas.vml.CTTextbox;
import com.microsoft.schemas.vml.STColorType;
import com.microsoft.schemas.vml.STEditAs;
import com.microsoft.schemas.vml.STTrueFalse;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class CTGroupImpl extends XmlComplexContentImpl implements CTGroup {
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
  
  private static final b GROUP$46 = new b("urn:schemas-microsoft-com:vml", "group");
  
  private static final b SHAPE$48 = new b("urn:schemas-microsoft-com:vml", "shape");
  
  private static final b SHAPETYPE$50 = new b("urn:schemas-microsoft-com:vml", "shapetype");
  
  private static final b ARC$52 = new b("urn:schemas-microsoft-com:vml", "arc");
  
  private static final b CURVE$54 = new b("urn:schemas-microsoft-com:vml", "curve");
  
  private static final b IMAGE$56 = new b("urn:schemas-microsoft-com:vml", "image");
  
  private static final b LINE$58 = new b("urn:schemas-microsoft-com:vml", "line");
  
  private static final b OVAL$60 = new b("urn:schemas-microsoft-com:vml", "oval");
  
  private static final b POLYLINE$62 = new b("urn:schemas-microsoft-com:vml", "polyline");
  
  private static final b RECT$64 = new b("urn:schemas-microsoft-com:vml", "rect");
  
  private static final b ROUNDRECT$66 = new b("urn:schemas-microsoft-com:vml", "roundrect");
  
  private static final b DIAGRAM$68 = new b("urn:schemas-microsoft-com:office:office", "diagram");
  
  private static final b ID$70 = new b("", "id");
  
  private static final b STYLE$72 = new b("", "style");
  
  private static final b HREF$74 = new b("", "href");
  
  private static final b TARGET$76 = new b("", "target");
  
  private static final b CLASS1$78 = new b("", "class");
  
  private static final b TITLE$80 = new b("", "title");
  
  private static final b ALT$82 = new b("", "alt");
  
  private static final b COORDSIZE$84 = new b("", "coordsize");
  
  private static final b COORDORIGIN$86 = new b("", "coordorigin");
  
  private static final b WRAPCOORDS$88 = new b("", "wrapcoords");
  
  private static final b PRINT$90 = new b("", "print");
  
  private static final b SPID$92 = new b("urn:schemas-microsoft-com:office:office", "spid");
  
  private static final b ONED$94 = new b("urn:schemas-microsoft-com:office:office", "oned");
  
  private static final b REGROUPID$96 = new b("urn:schemas-microsoft-com:office:office", "regroupid");
  
  private static final b DOUBLECLICKNOTIFY$98 = new b("urn:schemas-microsoft-com:office:office", "doubleclicknotify");
  
  private static final b BUTTON$100 = new b("urn:schemas-microsoft-com:office:office", "button");
  
  private static final b USERHIDDEN$102 = new b("urn:schemas-microsoft-com:office:office", "userhidden");
  
  private static final b BULLET$104 = new b("urn:schemas-microsoft-com:office:office", "bullet");
  
  private static final b HR$106 = new b("urn:schemas-microsoft-com:office:office", "hr");
  
  private static final b HRSTD$108 = new b("urn:schemas-microsoft-com:office:office", "hrstd");
  
  private static final b HRNOSHADE$110 = new b("urn:schemas-microsoft-com:office:office", "hrnoshade");
  
  private static final b HRPCT$112 = new b("urn:schemas-microsoft-com:office:office", "hrpct");
  
  private static final b HRALIGN$114 = new b("urn:schemas-microsoft-com:office:office", "hralign");
  
  private static final b ALLOWINCELL$116 = new b("urn:schemas-microsoft-com:office:office", "allowincell");
  
  private static final b ALLOWOVERLAP$118 = new b("urn:schemas-microsoft-com:office:office", "allowoverlap");
  
  private static final b USERDRAWN$120 = new b("urn:schemas-microsoft-com:office:office", "userdrawn");
  
  private static final b BORDERTOPCOLOR$122 = new b("urn:schemas-microsoft-com:office:office", "bordertopcolor");
  
  private static final b BORDERLEFTCOLOR$124 = new b("urn:schemas-microsoft-com:office:office", "borderleftcolor");
  
  private static final b BORDERBOTTOMCOLOR$126 = new b("urn:schemas-microsoft-com:office:office", "borderbottomcolor");
  
  private static final b BORDERRIGHTCOLOR$128 = new b("urn:schemas-microsoft-com:office:office", "borderrightcolor");
  
  private static final b DGMLAYOUT$130 = new b("urn:schemas-microsoft-com:office:office", "dgmlayout");
  
  private static final b DGMNODEKIND$132 = new b("urn:schemas-microsoft-com:office:office", "dgmnodekind");
  
  private static final b DGMLAYOUTMRU$134 = new b("urn:schemas-microsoft-com:office:office", "dgmlayoutmru");
  
  private static final b INSETMODE$136 = new b("urn:schemas-microsoft-com:office:office", "insetmode");
  
  private static final b FILLED$138 = new b("", "filled");
  
  private static final b FILLCOLOR$140 = new b("", "fillcolor");
  
  private static final b EDITAS$142 = new b("", "editas");
  
  private static final b TABLEPROPERTIES$144 = new b("urn:schemas-microsoft-com:office:office", "tableproperties");
  
  private static final b TABLELIMITS$146 = new b("urn:schemas-microsoft-com:office:office", "tablelimits");
  
  public CTGroupImpl(SchemaType paramSchemaType) {
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
      return (List<CTClientData>)new ClientDataList(this);
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
  
  public List<CTGroup> getGroupList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTGroup>)new GroupList(this);
    } 
  }
  
  public CTGroup[] getGroupArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(GROUP$46, arrayList);
      CTGroup[] arrayOfCTGroup = new CTGroup[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTGroup);
      return arrayOfCTGroup;
    } 
  }
  
  public CTGroup getGroupArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroup cTGroup = null;
      cTGroup = (CTGroup)get_store().find_element_user(GROUP$46, paramInt);
      if (cTGroup == null)
        throw new IndexOutOfBoundsException(); 
      return cTGroup;
    } 
  }
  
  public int sizeOfGroupArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(GROUP$46);
    } 
  }
  
  public void setGroupArray(CTGroup[] paramArrayOfCTGroup) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTGroup, GROUP$46);
    } 
  }
  
  public void setGroupArray(int paramInt, CTGroup paramCTGroup) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroup cTGroup = null;
      cTGroup = (CTGroup)get_store().find_element_user(GROUP$46, paramInt);
      if (cTGroup == null)
        throw new IndexOutOfBoundsException(); 
      cTGroup.set((XmlObject)paramCTGroup);
    } 
  }
  
  public CTGroup insertNewGroup(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroup cTGroup = null;
      cTGroup = (CTGroup)get_store().insert_element_user(GROUP$46, paramInt);
      return cTGroup;
    } 
  }
  
  public CTGroup addNewGroup() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroup cTGroup = null;
      cTGroup = (CTGroup)get_store().add_element_user(GROUP$46);
      return cTGroup;
    } 
  }
  
  public void removeGroup(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GROUP$46, paramInt);
    } 
  }
  
  public List<CTShape> getShapeList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTShape>)new ShapeList(this);
    } 
  }
  
  public CTShape[] getShapeArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SHAPE$48, arrayList);
      CTShape[] arrayOfCTShape = new CTShape[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTShape);
      return arrayOfCTShape;
    } 
  }
  
  public CTShape getShapeArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTShape cTShape = null;
      cTShape = (CTShape)get_store().find_element_user(SHAPE$48, paramInt);
      if (cTShape == null)
        throw new IndexOutOfBoundsException(); 
      return cTShape;
    } 
  }
  
  public int sizeOfShapeArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SHAPE$48);
    } 
  }
  
  public void setShapeArray(CTShape[] paramArrayOfCTShape) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTShape, SHAPE$48);
    } 
  }
  
  public void setShapeArray(int paramInt, CTShape paramCTShape) {
    synchronized (monitor()) {
      check_orphaned();
      CTShape cTShape = null;
      cTShape = (CTShape)get_store().find_element_user(SHAPE$48, paramInt);
      if (cTShape == null)
        throw new IndexOutOfBoundsException(); 
      cTShape.set((XmlObject)paramCTShape);
    } 
  }
  
  public CTShape insertNewShape(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTShape cTShape = null;
      cTShape = (CTShape)get_store().insert_element_user(SHAPE$48, paramInt);
      return cTShape;
    } 
  }
  
  public CTShape addNewShape() {
    synchronized (monitor()) {
      check_orphaned();
      CTShape cTShape = null;
      cTShape = (CTShape)get_store().add_element_user(SHAPE$48);
      return cTShape;
    } 
  }
  
  public void removeShape(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHAPE$48, paramInt);
    } 
  }
  
  public List<CTShapetype> getShapetypeList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTShapetype>)new ShapetypeList(this);
    } 
  }
  
  public CTShapetype[] getShapetypeArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SHAPETYPE$50, arrayList);
      CTShapetype[] arrayOfCTShapetype = new CTShapetype[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTShapetype);
      return arrayOfCTShapetype;
    } 
  }
  
  public CTShapetype getShapetypeArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTShapetype cTShapetype = null;
      cTShapetype = (CTShapetype)get_store().find_element_user(SHAPETYPE$50, paramInt);
      if (cTShapetype == null)
        throw new IndexOutOfBoundsException(); 
      return cTShapetype;
    } 
  }
  
  public int sizeOfShapetypeArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SHAPETYPE$50);
    } 
  }
  
  public void setShapetypeArray(CTShapetype[] paramArrayOfCTShapetype) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTShapetype, SHAPETYPE$50);
    } 
  }
  
  public void setShapetypeArray(int paramInt, CTShapetype paramCTShapetype) {
    synchronized (monitor()) {
      check_orphaned();
      CTShapetype cTShapetype = null;
      cTShapetype = (CTShapetype)get_store().find_element_user(SHAPETYPE$50, paramInt);
      if (cTShapetype == null)
        throw new IndexOutOfBoundsException(); 
      cTShapetype.set((XmlObject)paramCTShapetype);
    } 
  }
  
  public CTShapetype insertNewShapetype(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTShapetype cTShapetype = null;
      cTShapetype = (CTShapetype)get_store().insert_element_user(SHAPETYPE$50, paramInt);
      return cTShapetype;
    } 
  }
  
  public CTShapetype addNewShapetype() {
    synchronized (monitor()) {
      check_orphaned();
      CTShapetype cTShapetype = null;
      cTShapetype = (CTShapetype)get_store().add_element_user(SHAPETYPE$50);
      return cTShapetype;
    } 
  }
  
  public void removeShapetype(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHAPETYPE$50, paramInt);
    } 
  }
  
  public List<CTArc> getArcList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTArc>)new ArcList(this);
    } 
  }
  
  public CTArc[] getArcArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ARC$52, arrayList);
      CTArc[] arrayOfCTArc = new CTArc[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTArc);
      return arrayOfCTArc;
    } 
  }
  
  public CTArc getArcArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTArc cTArc = null;
      cTArc = (CTArc)get_store().find_element_user(ARC$52, paramInt);
      if (cTArc == null)
        throw new IndexOutOfBoundsException(); 
      return cTArc;
    } 
  }
  
  public int sizeOfArcArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ARC$52);
    } 
  }
  
  public void setArcArray(CTArc[] paramArrayOfCTArc) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTArc, ARC$52);
    } 
  }
  
  public void setArcArray(int paramInt, CTArc paramCTArc) {
    synchronized (monitor()) {
      check_orphaned();
      CTArc cTArc = null;
      cTArc = (CTArc)get_store().find_element_user(ARC$52, paramInt);
      if (cTArc == null)
        throw new IndexOutOfBoundsException(); 
      cTArc.set((XmlObject)paramCTArc);
    } 
  }
  
  public CTArc insertNewArc(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTArc cTArc = null;
      cTArc = (CTArc)get_store().insert_element_user(ARC$52, paramInt);
      return cTArc;
    } 
  }
  
  public CTArc addNewArc() {
    synchronized (monitor()) {
      check_orphaned();
      CTArc cTArc = null;
      cTArc = (CTArc)get_store().add_element_user(ARC$52);
      return cTArc;
    } 
  }
  
  public void removeArc(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ARC$52, paramInt);
    } 
  }
  
  public List<CTCurve> getCurveList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTCurve>)new CurveList(this);
    } 
  }
  
  public CTCurve[] getCurveArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CURVE$54, arrayList);
      CTCurve[] arrayOfCTCurve = new CTCurve[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTCurve);
      return arrayOfCTCurve;
    } 
  }
  
  public CTCurve getCurveArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCurve cTCurve = null;
      cTCurve = (CTCurve)get_store().find_element_user(CURVE$54, paramInt);
      if (cTCurve == null)
        throw new IndexOutOfBoundsException(); 
      return cTCurve;
    } 
  }
  
  public int sizeOfCurveArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CURVE$54);
    } 
  }
  
  public void setCurveArray(CTCurve[] paramArrayOfCTCurve) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTCurve, CURVE$54);
    } 
  }
  
  public void setCurveArray(int paramInt, CTCurve paramCTCurve) {
    synchronized (monitor()) {
      check_orphaned();
      CTCurve cTCurve = null;
      cTCurve = (CTCurve)get_store().find_element_user(CURVE$54, paramInt);
      if (cTCurve == null)
        throw new IndexOutOfBoundsException(); 
      cTCurve.set((XmlObject)paramCTCurve);
    } 
  }
  
  public CTCurve insertNewCurve(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCurve cTCurve = null;
      cTCurve = (CTCurve)get_store().insert_element_user(CURVE$54, paramInt);
      return cTCurve;
    } 
  }
  
  public CTCurve addNewCurve() {
    synchronized (monitor()) {
      check_orphaned();
      CTCurve cTCurve = null;
      cTCurve = (CTCurve)get_store().add_element_user(CURVE$54);
      return cTCurve;
    } 
  }
  
  public void removeCurve(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CURVE$54, paramInt);
    } 
  }
  
  public List<CTImage> getImageList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTImage>)new ImageList(this);
    } 
  }
  
  public CTImage[] getImageArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(IMAGE$56, arrayList);
      CTImage[] arrayOfCTImage = new CTImage[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTImage);
      return arrayOfCTImage;
    } 
  }
  
  public CTImage getImageArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTImage cTImage = null;
      cTImage = (CTImage)get_store().find_element_user(IMAGE$56, paramInt);
      if (cTImage == null)
        throw new IndexOutOfBoundsException(); 
      return cTImage;
    } 
  }
  
  public int sizeOfImageArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(IMAGE$56);
    } 
  }
  
  public void setImageArray(CTImage[] paramArrayOfCTImage) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTImage, IMAGE$56);
    } 
  }
  
  public void setImageArray(int paramInt, CTImage paramCTImage) {
    synchronized (monitor()) {
      check_orphaned();
      CTImage cTImage = null;
      cTImage = (CTImage)get_store().find_element_user(IMAGE$56, paramInt);
      if (cTImage == null)
        throw new IndexOutOfBoundsException(); 
      cTImage.set((XmlObject)paramCTImage);
    } 
  }
  
  public CTImage insertNewImage(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTImage cTImage = null;
      cTImage = (CTImage)get_store().insert_element_user(IMAGE$56, paramInt);
      return cTImage;
    } 
  }
  
  public CTImage addNewImage() {
    synchronized (monitor()) {
      check_orphaned();
      CTImage cTImage = null;
      cTImage = (CTImage)get_store().add_element_user(IMAGE$56);
      return cTImage;
    } 
  }
  
  public void removeImage(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(IMAGE$56, paramInt);
    } 
  }
  
  public List<CTLine> getLineList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTLine>)new LineList(this);
    } 
  }
  
  public CTLine[] getLineArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LINE$58, arrayList);
      CTLine[] arrayOfCTLine = new CTLine[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTLine);
      return arrayOfCTLine;
    } 
  }
  
  public CTLine getLineArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLine cTLine = null;
      cTLine = (CTLine)get_store().find_element_user(LINE$58, paramInt);
      if (cTLine == null)
        throw new IndexOutOfBoundsException(); 
      return cTLine;
    } 
  }
  
  public int sizeOfLineArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LINE$58);
    } 
  }
  
  public void setLineArray(CTLine[] paramArrayOfCTLine) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTLine, LINE$58);
    } 
  }
  
  public void setLineArray(int paramInt, CTLine paramCTLine) {
    synchronized (monitor()) {
      check_orphaned();
      CTLine cTLine = null;
      cTLine = (CTLine)get_store().find_element_user(LINE$58, paramInt);
      if (cTLine == null)
        throw new IndexOutOfBoundsException(); 
      cTLine.set((XmlObject)paramCTLine);
    } 
  }
  
  public CTLine insertNewLine(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTLine cTLine = null;
      cTLine = (CTLine)get_store().insert_element_user(LINE$58, paramInt);
      return cTLine;
    } 
  }
  
  public CTLine addNewLine() {
    synchronized (monitor()) {
      check_orphaned();
      CTLine cTLine = null;
      cTLine = (CTLine)get_store().add_element_user(LINE$58);
      return cTLine;
    } 
  }
  
  public void removeLine(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LINE$58, paramInt);
    } 
  }
  
  public List<CTOval> getOvalList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTOval>)new OvalList(this);
    } 
  }
  
  public CTOval[] getOvalArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(OVAL$60, arrayList);
      CTOval[] arrayOfCTOval = new CTOval[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTOval);
      return arrayOfCTOval;
    } 
  }
  
  public CTOval getOvalArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOval cTOval = null;
      cTOval = (CTOval)get_store().find_element_user(OVAL$60, paramInt);
      if (cTOval == null)
        throw new IndexOutOfBoundsException(); 
      return cTOval;
    } 
  }
  
  public int sizeOfOvalArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(OVAL$60);
    } 
  }
  
  public void setOvalArray(CTOval[] paramArrayOfCTOval) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTOval, OVAL$60);
    } 
  }
  
  public void setOvalArray(int paramInt, CTOval paramCTOval) {
    synchronized (monitor()) {
      check_orphaned();
      CTOval cTOval = null;
      cTOval = (CTOval)get_store().find_element_user(OVAL$60, paramInt);
      if (cTOval == null)
        throw new IndexOutOfBoundsException(); 
      cTOval.set((XmlObject)paramCTOval);
    } 
  }
  
  public CTOval insertNewOval(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTOval cTOval = null;
      cTOval = (CTOval)get_store().insert_element_user(OVAL$60, paramInt);
      return cTOval;
    } 
  }
  
  public CTOval addNewOval() {
    synchronized (monitor()) {
      check_orphaned();
      CTOval cTOval = null;
      cTOval = (CTOval)get_store().add_element_user(OVAL$60);
      return cTOval;
    } 
  }
  
  public void removeOval(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OVAL$60, paramInt);
    } 
  }
  
  public List<CTPolyLine> getPolylineList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPolyLine>)new PolylineList(this);
    } 
  }
  
  public CTPolyLine[] getPolylineArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(POLYLINE$62, arrayList);
      CTPolyLine[] arrayOfCTPolyLine = new CTPolyLine[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPolyLine);
      return arrayOfCTPolyLine;
    } 
  }
  
  public CTPolyLine getPolylineArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPolyLine cTPolyLine = null;
      cTPolyLine = (CTPolyLine)get_store().find_element_user(POLYLINE$62, paramInt);
      if (cTPolyLine == null)
        throw new IndexOutOfBoundsException(); 
      return cTPolyLine;
    } 
  }
  
  public int sizeOfPolylineArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(POLYLINE$62);
    } 
  }
  
  public void setPolylineArray(CTPolyLine[] paramArrayOfCTPolyLine) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPolyLine, POLYLINE$62);
    } 
  }
  
  public void setPolylineArray(int paramInt, CTPolyLine paramCTPolyLine) {
    synchronized (monitor()) {
      check_orphaned();
      CTPolyLine cTPolyLine = null;
      cTPolyLine = (CTPolyLine)get_store().find_element_user(POLYLINE$62, paramInt);
      if (cTPolyLine == null)
        throw new IndexOutOfBoundsException(); 
      cTPolyLine.set((XmlObject)paramCTPolyLine);
    } 
  }
  
  public CTPolyLine insertNewPolyline(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPolyLine cTPolyLine = null;
      cTPolyLine = (CTPolyLine)get_store().insert_element_user(POLYLINE$62, paramInt);
      return cTPolyLine;
    } 
  }
  
  public CTPolyLine addNewPolyline() {
    synchronized (monitor()) {
      check_orphaned();
      CTPolyLine cTPolyLine = null;
      cTPolyLine = (CTPolyLine)get_store().add_element_user(POLYLINE$62);
      return cTPolyLine;
    } 
  }
  
  public void removePolyline(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(POLYLINE$62, paramInt);
    } 
  }
  
  public List<CTRect> getRectList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTRect>)new RectList(this);
    } 
  }
  
  public CTRect[] getRectArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(RECT$64, arrayList);
      CTRect[] arrayOfCTRect = new CTRect[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTRect);
      return arrayOfCTRect;
    } 
  }
  
  public CTRect getRectArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRect cTRect = null;
      cTRect = (CTRect)get_store().find_element_user(RECT$64, paramInt);
      if (cTRect == null)
        throw new IndexOutOfBoundsException(); 
      return cTRect;
    } 
  }
  
  public int sizeOfRectArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(RECT$64);
    } 
  }
  
  public void setRectArray(CTRect[] paramArrayOfCTRect) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTRect, RECT$64);
    } 
  }
  
  public void setRectArray(int paramInt, CTRect paramCTRect) {
    synchronized (monitor()) {
      check_orphaned();
      CTRect cTRect = null;
      cTRect = (CTRect)get_store().find_element_user(RECT$64, paramInt);
      if (cTRect == null)
        throw new IndexOutOfBoundsException(); 
      cTRect.set((XmlObject)paramCTRect);
    } 
  }
  
  public CTRect insertNewRect(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRect cTRect = null;
      cTRect = (CTRect)get_store().insert_element_user(RECT$64, paramInt);
      return cTRect;
    } 
  }
  
  public CTRect addNewRect() {
    synchronized (monitor()) {
      check_orphaned();
      CTRect cTRect = null;
      cTRect = (CTRect)get_store().add_element_user(RECT$64);
      return cTRect;
    } 
  }
  
  public void removeRect(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RECT$64, paramInt);
    } 
  }
  
  public List<CTRoundRect> getRoundrectList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTRoundRect>)new RoundrectList(this);
    } 
  }
  
  public CTRoundRect[] getRoundrectArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ROUNDRECT$66, arrayList);
      CTRoundRect[] arrayOfCTRoundRect = new CTRoundRect[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTRoundRect);
      return arrayOfCTRoundRect;
    } 
  }
  
  public CTRoundRect getRoundrectArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRoundRect cTRoundRect = null;
      cTRoundRect = (CTRoundRect)get_store().find_element_user(ROUNDRECT$66, paramInt);
      if (cTRoundRect == null)
        throw new IndexOutOfBoundsException(); 
      return cTRoundRect;
    } 
  }
  
  public int sizeOfRoundrectArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ROUNDRECT$66);
    } 
  }
  
  public void setRoundrectArray(CTRoundRect[] paramArrayOfCTRoundRect) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTRoundRect, ROUNDRECT$66);
    } 
  }
  
  public void setRoundrectArray(int paramInt, CTRoundRect paramCTRoundRect) {
    synchronized (monitor()) {
      check_orphaned();
      CTRoundRect cTRoundRect = null;
      cTRoundRect = (CTRoundRect)get_store().find_element_user(ROUNDRECT$66, paramInt);
      if (cTRoundRect == null)
        throw new IndexOutOfBoundsException(); 
      cTRoundRect.set((XmlObject)paramCTRoundRect);
    } 
  }
  
  public CTRoundRect insertNewRoundrect(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTRoundRect cTRoundRect = null;
      cTRoundRect = (CTRoundRect)get_store().insert_element_user(ROUNDRECT$66, paramInt);
      return cTRoundRect;
    } 
  }
  
  public CTRoundRect addNewRoundrect() {
    synchronized (monitor()) {
      check_orphaned();
      CTRoundRect cTRoundRect = null;
      cTRoundRect = (CTRoundRect)get_store().add_element_user(ROUNDRECT$66);
      return cTRoundRect;
    } 
  }
  
  public void removeRoundrect(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ROUNDRECT$66, paramInt);
    } 
  }
  
  public List<CTDiagram> getDiagramList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTDiagram>)new DiagramList(this);
    } 
  }
  
  public CTDiagram[] getDiagramArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DIAGRAM$68, arrayList);
      CTDiagram[] arrayOfCTDiagram = new CTDiagram[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTDiagram);
      return arrayOfCTDiagram;
    } 
  }
  
  public CTDiagram getDiagramArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDiagram cTDiagram = null;
      cTDiagram = (CTDiagram)get_store().find_element_user(DIAGRAM$68, paramInt);
      if (cTDiagram == null)
        throw new IndexOutOfBoundsException(); 
      return cTDiagram;
    } 
  }
  
  public int sizeOfDiagramArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DIAGRAM$68);
    } 
  }
  
  public void setDiagramArray(CTDiagram[] paramArrayOfCTDiagram) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTDiagram, DIAGRAM$68);
    } 
  }
  
  public void setDiagramArray(int paramInt, CTDiagram paramCTDiagram) {
    synchronized (monitor()) {
      check_orphaned();
      CTDiagram cTDiagram = null;
      cTDiagram = (CTDiagram)get_store().find_element_user(DIAGRAM$68, paramInt);
      if (cTDiagram == null)
        throw new IndexOutOfBoundsException(); 
      cTDiagram.set((XmlObject)paramCTDiagram);
    } 
  }
  
  public CTDiagram insertNewDiagram(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTDiagram cTDiagram = null;
      cTDiagram = (CTDiagram)get_store().insert_element_user(DIAGRAM$68, paramInt);
      return cTDiagram;
    } 
  }
  
  public CTDiagram addNewDiagram() {
    synchronized (monitor()) {
      check_orphaned();
      CTDiagram cTDiagram = null;
      cTDiagram = (CTDiagram)get_store().add_element_user(DIAGRAM$68);
      return cTDiagram;
    } 
  }
  
  public void removeDiagram(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DIAGRAM$68, paramInt);
    } 
  }
  
  public String getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$70);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ID$70);
      return xmlString;
    } 
  }
  
  public boolean isSetId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ID$70) != null);
    } 
  }
  
  public void setId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$70);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$70); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetId(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ID$70);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(ID$70); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ID$70);
    } 
  }
  
  public String getStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STYLE$72);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(STYLE$72);
      return xmlString;
    } 
  }
  
  public boolean isSetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STYLE$72) != null);
    } 
  }
  
  public void setStyle(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STYLE$72);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STYLE$72); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetStyle(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(STYLE$72);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(STYLE$72); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STYLE$72);
    } 
  }
  
  public String getHref() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HREF$74);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetHref() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(HREF$74);
      return xmlString;
    } 
  }
  
  public boolean isSetHref() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HREF$74) != null);
    } 
  }
  
  public void setHref(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HREF$74);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HREF$74); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetHref(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(HREF$74);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(HREF$74); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetHref() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HREF$74);
    } 
  }
  
  public String getTarget() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TARGET$76);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetTarget() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TARGET$76);
      return xmlString;
    } 
  }
  
  public boolean isSetTarget() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TARGET$76) != null);
    } 
  }
  
  public void setTarget(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TARGET$76);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TARGET$76); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTarget(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TARGET$76);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(TARGET$76); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetTarget() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TARGET$76);
    } 
  }
  
  public String getClass1() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CLASS1$78);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetClass1() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(CLASS1$78);
      return xmlString;
    } 
  }
  
  public boolean isSetClass1() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CLASS1$78) != null);
    } 
  }
  
  public void setClass1(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CLASS1$78);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CLASS1$78); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetClass1(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(CLASS1$78);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(CLASS1$78); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetClass1() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CLASS1$78);
    } 
  }
  
  public String getTitle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TITLE$80);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetTitle() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TITLE$80);
      return xmlString;
    } 
  }
  
  public boolean isSetTitle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TITLE$80) != null);
    } 
  }
  
  public void setTitle(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TITLE$80);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TITLE$80); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTitle(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TITLE$80);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(TITLE$80); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetTitle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TITLE$80);
    } 
  }
  
  public String getAlt() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALT$82);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetAlt() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ALT$82);
      return xmlString;
    } 
  }
  
  public boolean isSetAlt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ALT$82) != null);
    } 
  }
  
  public void setAlt(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALT$82);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALT$82); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetAlt(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ALT$82);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(ALT$82); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetAlt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ALT$82);
    } 
  }
  
  public String getCoordsize() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COORDSIZE$84);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetCoordsize() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(COORDSIZE$84);
      return xmlString;
    } 
  }
  
  public boolean isSetCoordsize() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COORDSIZE$84) != null);
    } 
  }
  
  public void setCoordsize(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COORDSIZE$84);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COORDSIZE$84); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetCoordsize(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(COORDSIZE$84);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(COORDSIZE$84); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetCoordsize() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COORDSIZE$84);
    } 
  }
  
  public String getCoordorigin() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COORDORIGIN$86);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetCoordorigin() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(COORDORIGIN$86);
      return xmlString;
    } 
  }
  
  public boolean isSetCoordorigin() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COORDORIGIN$86) != null);
    } 
  }
  
  public void setCoordorigin(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COORDORIGIN$86);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COORDORIGIN$86); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetCoordorigin(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(COORDORIGIN$86);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(COORDORIGIN$86); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetCoordorigin() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COORDORIGIN$86);
    } 
  }
  
  public String getWrapcoords() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WRAPCOORDS$88);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetWrapcoords() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(WRAPCOORDS$88);
      return xmlString;
    } 
  }
  
  public boolean isSetWrapcoords() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(WRAPCOORDS$88) != null);
    } 
  }
  
  public void setWrapcoords(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WRAPCOORDS$88);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(WRAPCOORDS$88); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetWrapcoords(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(WRAPCOORDS$88);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(WRAPCOORDS$88); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetWrapcoords() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(WRAPCOORDS$88);
    } 
  }
  
  public STTrueFalse.Enum getPrint() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PRINT$90);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetPrint() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(PRINT$90);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetPrint() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PRINT$90) != null);
    } 
  }
  
  public void setPrint(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PRINT$90);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PRINT$90); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetPrint(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(PRINT$90);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(PRINT$90); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetPrint() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PRINT$90);
    } 
  }
  
  public String getSpid() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SPID$92);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetSpid() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(SPID$92);
      return xmlString;
    } 
  }
  
  public boolean isSetSpid() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SPID$92) != null);
    } 
  }
  
  public void setSpid(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SPID$92);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SPID$92); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetSpid(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(SPID$92);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(SPID$92); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetSpid() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SPID$92);
    } 
  }
  
  public STTrueFalse.Enum getOned() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ONED$94);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetOned() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ONED$94);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetOned() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ONED$94) != null);
    } 
  }
  
  public void setOned(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ONED$94);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ONED$94); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetOned(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ONED$94);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(ONED$94); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetOned() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ONED$94);
    } 
  }
  
  public BigInteger getRegroupid() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REGROUPID$96);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public XmlInteger xgetRegroupid() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_attribute_user(REGROUPID$96);
      return xmlInteger;
    } 
  }
  
  public boolean isSetRegroupid() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(REGROUPID$96) != null);
    } 
  }
  
  public void setRegroupid(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REGROUPID$96);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(REGROUPID$96); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetRegroupid(XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_attribute_user(REGROUPID$96);
      if (xmlInteger == null)
        xmlInteger = (XmlInteger)get_store().add_attribute_user(REGROUPID$96); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void unsetRegroupid() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(REGROUPID$96);
    } 
  }
  
  public STTrueFalse.Enum getDoubleclicknotify() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DOUBLECLICKNOTIFY$98);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetDoubleclicknotify() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(DOUBLECLICKNOTIFY$98);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetDoubleclicknotify() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DOUBLECLICKNOTIFY$98) != null);
    } 
  }
  
  public void setDoubleclicknotify(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DOUBLECLICKNOTIFY$98);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DOUBLECLICKNOTIFY$98); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetDoubleclicknotify(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(DOUBLECLICKNOTIFY$98);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(DOUBLECLICKNOTIFY$98); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetDoubleclicknotify() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DOUBLECLICKNOTIFY$98);
    } 
  }
  
  public STTrueFalse.Enum getButton() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BUTTON$100);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetButton() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(BUTTON$100);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetButton() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BUTTON$100) != null);
    } 
  }
  
  public void setButton(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BUTTON$100);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BUTTON$100); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetButton(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(BUTTON$100);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(BUTTON$100); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetButton() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BUTTON$100);
    } 
  }
  
  public STTrueFalse.Enum getUserhidden() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(USERHIDDEN$102);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetUserhidden() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(USERHIDDEN$102);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetUserhidden() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(USERHIDDEN$102) != null);
    } 
  }
  
  public void setUserhidden(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(USERHIDDEN$102);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(USERHIDDEN$102); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetUserhidden(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(USERHIDDEN$102);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(USERHIDDEN$102); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetUserhidden() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(USERHIDDEN$102);
    } 
  }
  
  public STTrueFalse.Enum getBullet() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BULLET$104);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetBullet() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(BULLET$104);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetBullet() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BULLET$104) != null);
    } 
  }
  
  public void setBullet(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BULLET$104);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BULLET$104); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetBullet(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(BULLET$104);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(BULLET$104); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetBullet() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BULLET$104);
    } 
  }
  
  public STTrueFalse.Enum getHr() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HR$106);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetHr() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(HR$106);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetHr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HR$106) != null);
    } 
  }
  
  public void setHr(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HR$106);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HR$106); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetHr(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(HR$106);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(HR$106); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetHr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HR$106);
    } 
  }
  
  public STTrueFalse.Enum getHrstd() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HRSTD$108);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetHrstd() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(HRSTD$108);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetHrstd() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HRSTD$108) != null);
    } 
  }
  
  public void setHrstd(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HRSTD$108);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HRSTD$108); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetHrstd(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(HRSTD$108);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(HRSTD$108); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetHrstd() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HRSTD$108);
    } 
  }
  
  public STTrueFalse.Enum getHrnoshade() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HRNOSHADE$110);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetHrnoshade() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(HRNOSHADE$110);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetHrnoshade() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HRNOSHADE$110) != null);
    } 
  }
  
  public void setHrnoshade(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HRNOSHADE$110);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HRNOSHADE$110); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetHrnoshade(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(HRNOSHADE$110);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(HRNOSHADE$110); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetHrnoshade() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HRNOSHADE$110);
    } 
  }
  
  public float getHrpct() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HRPCT$112);
      if (simpleValue == null)
        return 0.0F; 
      return simpleValue.getFloatValue();
    } 
  }
  
  public XmlFloat xgetHrpct() {
    synchronized (monitor()) {
      check_orphaned();
      XmlFloat xmlFloat = null;
      xmlFloat = (XmlFloat)get_store().find_attribute_user(HRPCT$112);
      return xmlFloat;
    } 
  }
  
  public boolean isSetHrpct() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HRPCT$112) != null);
    } 
  }
  
  public void setHrpct(float paramFloat) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HRPCT$112);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HRPCT$112); 
      simpleValue.setFloatValue(paramFloat);
    } 
  }
  
  public void xsetHrpct(XmlFloat paramXmlFloat) {
    synchronized (monitor()) {
      check_orphaned();
      XmlFloat xmlFloat = null;
      xmlFloat = (XmlFloat)get_store().find_attribute_user(HRPCT$112);
      if (xmlFloat == null)
        xmlFloat = (XmlFloat)get_store().add_attribute_user(HRPCT$112); 
      xmlFloat.set((XmlObject)paramXmlFloat);
    } 
  }
  
  public void unsetHrpct() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HRPCT$112);
    } 
  }
  
  public STHrAlign.Enum getHralign() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HRALIGN$114);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(HRALIGN$114); 
      if (simpleValue == null)
        return null; 
      return (STHrAlign.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STHrAlign xgetHralign() {
    synchronized (monitor()) {
      check_orphaned();
      STHrAlign sTHrAlign = null;
      sTHrAlign = (STHrAlign)get_store().find_attribute_user(HRALIGN$114);
      if (sTHrAlign == null)
        sTHrAlign = (STHrAlign)get_default_attribute_value(HRALIGN$114); 
      return sTHrAlign;
    } 
  }
  
  public boolean isSetHralign() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HRALIGN$114) != null);
    } 
  }
  
  public void setHralign(STHrAlign.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HRALIGN$114);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HRALIGN$114); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetHralign(STHrAlign paramSTHrAlign) {
    synchronized (monitor()) {
      check_orphaned();
      STHrAlign sTHrAlign = null;
      sTHrAlign = (STHrAlign)get_store().find_attribute_user(HRALIGN$114);
      if (sTHrAlign == null)
        sTHrAlign = (STHrAlign)get_store().add_attribute_user(HRALIGN$114); 
      sTHrAlign.set((XmlObject)paramSTHrAlign);
    } 
  }
  
  public void unsetHralign() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HRALIGN$114);
    } 
  }
  
  public STTrueFalse.Enum getAllowincell() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALLOWINCELL$116);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetAllowincell() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ALLOWINCELL$116);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetAllowincell() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ALLOWINCELL$116) != null);
    } 
  }
  
  public void setAllowincell(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALLOWINCELL$116);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALLOWINCELL$116); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAllowincell(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ALLOWINCELL$116);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(ALLOWINCELL$116); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetAllowincell() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ALLOWINCELL$116);
    } 
  }
  
  public STTrueFalse.Enum getAllowoverlap() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALLOWOVERLAP$118);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetAllowoverlap() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ALLOWOVERLAP$118);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetAllowoverlap() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ALLOWOVERLAP$118) != null);
    } 
  }
  
  public void setAllowoverlap(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALLOWOVERLAP$118);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALLOWOVERLAP$118); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAllowoverlap(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ALLOWOVERLAP$118);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(ALLOWOVERLAP$118); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetAllowoverlap() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ALLOWOVERLAP$118);
    } 
  }
  
  public STTrueFalse.Enum getUserdrawn() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(USERDRAWN$120);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetUserdrawn() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(USERDRAWN$120);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetUserdrawn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(USERDRAWN$120) != null);
    } 
  }
  
  public void setUserdrawn(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(USERDRAWN$120);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(USERDRAWN$120); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetUserdrawn(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(USERDRAWN$120);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(USERDRAWN$120); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetUserdrawn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(USERDRAWN$120);
    } 
  }
  
  public String getBordertopcolor() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BORDERTOPCOLOR$122);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetBordertopcolor() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(BORDERTOPCOLOR$122);
      return xmlString;
    } 
  }
  
  public boolean isSetBordertopcolor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BORDERTOPCOLOR$122) != null);
    } 
  }
  
  public void setBordertopcolor(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BORDERTOPCOLOR$122);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BORDERTOPCOLOR$122); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetBordertopcolor(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(BORDERTOPCOLOR$122);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(BORDERTOPCOLOR$122); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetBordertopcolor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BORDERTOPCOLOR$122);
    } 
  }
  
  public String getBorderleftcolor() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BORDERLEFTCOLOR$124);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetBorderleftcolor() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(BORDERLEFTCOLOR$124);
      return xmlString;
    } 
  }
  
  public boolean isSetBorderleftcolor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BORDERLEFTCOLOR$124) != null);
    } 
  }
  
  public void setBorderleftcolor(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BORDERLEFTCOLOR$124);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BORDERLEFTCOLOR$124); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetBorderleftcolor(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(BORDERLEFTCOLOR$124);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(BORDERLEFTCOLOR$124); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetBorderleftcolor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BORDERLEFTCOLOR$124);
    } 
  }
  
  public String getBorderbottomcolor() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BORDERBOTTOMCOLOR$126);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetBorderbottomcolor() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(BORDERBOTTOMCOLOR$126);
      return xmlString;
    } 
  }
  
  public boolean isSetBorderbottomcolor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BORDERBOTTOMCOLOR$126) != null);
    } 
  }
  
  public void setBorderbottomcolor(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BORDERBOTTOMCOLOR$126);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BORDERBOTTOMCOLOR$126); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetBorderbottomcolor(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(BORDERBOTTOMCOLOR$126);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(BORDERBOTTOMCOLOR$126); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetBorderbottomcolor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BORDERBOTTOMCOLOR$126);
    } 
  }
  
  public String getBorderrightcolor() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BORDERRIGHTCOLOR$128);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetBorderrightcolor() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(BORDERRIGHTCOLOR$128);
      return xmlString;
    } 
  }
  
  public boolean isSetBorderrightcolor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BORDERRIGHTCOLOR$128) != null);
    } 
  }
  
  public void setBorderrightcolor(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BORDERRIGHTCOLOR$128);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BORDERRIGHTCOLOR$128); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetBorderrightcolor(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(BORDERRIGHTCOLOR$128);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(BORDERRIGHTCOLOR$128); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetBorderrightcolor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BORDERRIGHTCOLOR$128);
    } 
  }
  
  public BigInteger getDgmlayout() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DGMLAYOUT$130);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public XmlInteger xgetDgmlayout() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_attribute_user(DGMLAYOUT$130);
      return xmlInteger;
    } 
  }
  
  public boolean isSetDgmlayout() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DGMLAYOUT$130) != null);
    } 
  }
  
  public void setDgmlayout(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DGMLAYOUT$130);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DGMLAYOUT$130); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetDgmlayout(XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_attribute_user(DGMLAYOUT$130);
      if (xmlInteger == null)
        xmlInteger = (XmlInteger)get_store().add_attribute_user(DGMLAYOUT$130); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void unsetDgmlayout() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DGMLAYOUT$130);
    } 
  }
  
  public BigInteger getDgmnodekind() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DGMNODEKIND$132);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public XmlInteger xgetDgmnodekind() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_attribute_user(DGMNODEKIND$132);
      return xmlInteger;
    } 
  }
  
  public boolean isSetDgmnodekind() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DGMNODEKIND$132) != null);
    } 
  }
  
  public void setDgmnodekind(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DGMNODEKIND$132);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DGMNODEKIND$132); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetDgmnodekind(XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_attribute_user(DGMNODEKIND$132);
      if (xmlInteger == null)
        xmlInteger = (XmlInteger)get_store().add_attribute_user(DGMNODEKIND$132); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void unsetDgmnodekind() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DGMNODEKIND$132);
    } 
  }
  
  public BigInteger getDgmlayoutmru() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DGMLAYOUTMRU$134);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public XmlInteger xgetDgmlayoutmru() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_attribute_user(DGMLAYOUTMRU$134);
      return xmlInteger;
    } 
  }
  
  public boolean isSetDgmlayoutmru() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DGMLAYOUTMRU$134) != null);
    } 
  }
  
  public void setDgmlayoutmru(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DGMLAYOUTMRU$134);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DGMLAYOUTMRU$134); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetDgmlayoutmru(XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_attribute_user(DGMLAYOUTMRU$134);
      if (xmlInteger == null)
        xmlInteger = (XmlInteger)get_store().add_attribute_user(DGMLAYOUTMRU$134); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void unsetDgmlayoutmru() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DGMLAYOUTMRU$134);
    } 
  }
  
  public STInsetMode.Enum getInsetmode() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSETMODE$136);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(INSETMODE$136); 
      if (simpleValue == null)
        return null; 
      return (STInsetMode.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STInsetMode xgetInsetmode() {
    synchronized (monitor()) {
      check_orphaned();
      STInsetMode sTInsetMode = null;
      sTInsetMode = (STInsetMode)get_store().find_attribute_user(INSETMODE$136);
      if (sTInsetMode == null)
        sTInsetMode = (STInsetMode)get_default_attribute_value(INSETMODE$136); 
      return sTInsetMode;
    } 
  }
  
  public boolean isSetInsetmode() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(INSETMODE$136) != null);
    } 
  }
  
  public void setInsetmode(STInsetMode.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INSETMODE$136);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INSETMODE$136); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetInsetmode(STInsetMode paramSTInsetMode) {
    synchronized (monitor()) {
      check_orphaned();
      STInsetMode sTInsetMode = null;
      sTInsetMode = (STInsetMode)get_store().find_attribute_user(INSETMODE$136);
      if (sTInsetMode == null)
        sTInsetMode = (STInsetMode)get_store().add_attribute_user(INSETMODE$136); 
      sTInsetMode.set((XmlObject)paramSTInsetMode);
    } 
  }
  
  public void unsetInsetmode() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(INSETMODE$136);
    } 
  }
  
  public STTrueFalse.Enum getFilled() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILLED$138);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetFilled() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(FILLED$138);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetFilled() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FILLED$138) != null);
    } 
  }
  
  public void setFilled(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILLED$138);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FILLED$138); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetFilled(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(FILLED$138);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(FILLED$138); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetFilled() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FILLED$138);
    } 
  }
  
  public String getFillcolor() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILLCOLOR$140);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STColorType xgetFillcolor() {
    synchronized (monitor()) {
      check_orphaned();
      STColorType sTColorType = null;
      sTColorType = (STColorType)get_store().find_attribute_user(FILLCOLOR$140);
      return sTColorType;
    } 
  }
  
  public boolean isSetFillcolor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FILLCOLOR$140) != null);
    } 
  }
  
  public void setFillcolor(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILLCOLOR$140);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FILLCOLOR$140); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetFillcolor(STColorType paramSTColorType) {
    synchronized (monitor()) {
      check_orphaned();
      STColorType sTColorType = null;
      sTColorType = (STColorType)get_store().find_attribute_user(FILLCOLOR$140);
      if (sTColorType == null)
        sTColorType = (STColorType)get_store().add_attribute_user(FILLCOLOR$140); 
      sTColorType.set((XmlObject)paramSTColorType);
    } 
  }
  
  public void unsetFillcolor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FILLCOLOR$140);
    } 
  }
  
  public STEditAs.Enum getEditas() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EDITAS$142);
      if (simpleValue == null)
        return null; 
      return (STEditAs.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STEditAs xgetEditas() {
    synchronized (monitor()) {
      check_orphaned();
      STEditAs sTEditAs = null;
      sTEditAs = (STEditAs)get_store().find_attribute_user(EDITAS$142);
      return sTEditAs;
    } 
  }
  
  public boolean isSetEditas() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(EDITAS$142) != null);
    } 
  }
  
  public void setEditas(STEditAs.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EDITAS$142);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(EDITAS$142); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetEditas(STEditAs paramSTEditAs) {
    synchronized (monitor()) {
      check_orphaned();
      STEditAs sTEditAs = null;
      sTEditAs = (STEditAs)get_store().find_attribute_user(EDITAS$142);
      if (sTEditAs == null)
        sTEditAs = (STEditAs)get_store().add_attribute_user(EDITAS$142); 
      sTEditAs.set((XmlObject)paramSTEditAs);
    } 
  }
  
  public void unsetEditas() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(EDITAS$142);
    } 
  }
  
  public String getTableproperties() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TABLEPROPERTIES$144);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetTableproperties() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TABLEPROPERTIES$144);
      return xmlString;
    } 
  }
  
  public boolean isSetTableproperties() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TABLEPROPERTIES$144) != null);
    } 
  }
  
  public void setTableproperties(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TABLEPROPERTIES$144);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TABLEPROPERTIES$144); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTableproperties(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TABLEPROPERTIES$144);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(TABLEPROPERTIES$144); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetTableproperties() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TABLEPROPERTIES$144);
    } 
  }
  
  public String getTablelimits() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TABLELIMITS$146);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetTablelimits() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TABLELIMITS$146);
      return xmlString;
    } 
  }
  
  public boolean isSetTablelimits() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TABLELIMITS$146) != null);
    } 
  }
  
  public void setTablelimits(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TABLELIMITS$146);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TABLELIMITS$146); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTablelimits(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TABLELIMITS$146);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(TABLELIMITS$146); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetTablelimits() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TABLELIMITS$146);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\impl\CTGroupImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */