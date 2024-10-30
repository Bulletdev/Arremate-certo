package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFlatText;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetTextShape;
import org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextNoAutofit;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextShapeAutofit;
import org.openxmlformats.schemas.drawingml.x2006.main.STAngle;
import org.openxmlformats.schemas.drawingml.x2006.main.STCoordinate32;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveCoordinate32;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAnchoringType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextColumnCount;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextHorzOverflowType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextVertOverflowType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextVerticalType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextWrappingType;

public class CTTextBodyPropertiesImpl extends XmlComplexContentImpl implements CTTextBodyProperties {
  private static final b PRSTTXWARP$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "prstTxWarp");
  
  private static final b NOAUTOFIT$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "noAutofit");
  
  private static final b NORMAUTOFIT$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "normAutofit");
  
  private static final b SPAUTOFIT$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "spAutoFit");
  
  private static final b SCENE3D$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "scene3d");
  
  private static final b SP3D$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "sp3d");
  
  private static final b FLATTX$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "flatTx");
  
  private static final b EXTLST$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  private static final b ROT$16 = new b("", "rot");
  
  private static final b SPCFIRSTLASTPARA$18 = new b("", "spcFirstLastPara");
  
  private static final b VERTOVERFLOW$20 = new b("", "vertOverflow");
  
  private static final b HORZOVERFLOW$22 = new b("", "horzOverflow");
  
  private static final b VERT$24 = new b("", "vert");
  
  private static final b WRAP$26 = new b("", "wrap");
  
  private static final b LINS$28 = new b("", "lIns");
  
  private static final b TINS$30 = new b("", "tIns");
  
  private static final b RINS$32 = new b("", "rIns");
  
  private static final b BINS$34 = new b("", "bIns");
  
  private static final b NUMCOL$36 = new b("", "numCol");
  
  private static final b SPCCOL$38 = new b("", "spcCol");
  
  private static final b RTLCOL$40 = new b("", "rtlCol");
  
  private static final b FROMWORDART$42 = new b("", "fromWordArt");
  
  private static final b ANCHOR$44 = new b("", "anchor");
  
  private static final b ANCHORCTR$46 = new b("", "anchorCtr");
  
  private static final b FORCEAA$48 = new b("", "forceAA");
  
  private static final b UPRIGHT$50 = new b("", "upright");
  
  private static final b COMPATLNSPC$52 = new b("", "compatLnSpc");
  
  public CTTextBodyPropertiesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTPresetTextShape getPrstTxWarp() {
    synchronized (monitor()) {
      check_orphaned();
      CTPresetTextShape cTPresetTextShape = null;
      cTPresetTextShape = (CTPresetTextShape)get_store().find_element_user(PRSTTXWARP$0, 0);
      if (cTPresetTextShape == null)
        return null; 
      return cTPresetTextShape;
    } 
  }
  
  public boolean isSetPrstTxWarp() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PRSTTXWARP$0) != 0);
    } 
  }
  
  public void setPrstTxWarp(CTPresetTextShape paramCTPresetTextShape) {
    synchronized (monitor()) {
      check_orphaned();
      CTPresetTextShape cTPresetTextShape = null;
      cTPresetTextShape = (CTPresetTextShape)get_store().find_element_user(PRSTTXWARP$0, 0);
      if (cTPresetTextShape == null)
        cTPresetTextShape = (CTPresetTextShape)get_store().add_element_user(PRSTTXWARP$0); 
      cTPresetTextShape.set((XmlObject)paramCTPresetTextShape);
    } 
  }
  
  public CTPresetTextShape addNewPrstTxWarp() {
    synchronized (monitor()) {
      check_orphaned();
      CTPresetTextShape cTPresetTextShape = null;
      cTPresetTextShape = (CTPresetTextShape)get_store().add_element_user(PRSTTXWARP$0);
      return cTPresetTextShape;
    } 
  }
  
  public void unsetPrstTxWarp() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PRSTTXWARP$0, 0);
    } 
  }
  
  public CTTextNoAutofit getNoAutofit() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextNoAutofit cTTextNoAutofit = null;
      cTTextNoAutofit = (CTTextNoAutofit)get_store().find_element_user(NOAUTOFIT$2, 0);
      if (cTTextNoAutofit == null)
        return null; 
      return cTTextNoAutofit;
    } 
  }
  
  public boolean isSetNoAutofit() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NOAUTOFIT$2) != 0);
    } 
  }
  
  public void setNoAutofit(CTTextNoAutofit paramCTTextNoAutofit) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextNoAutofit cTTextNoAutofit = null;
      cTTextNoAutofit = (CTTextNoAutofit)get_store().find_element_user(NOAUTOFIT$2, 0);
      if (cTTextNoAutofit == null)
        cTTextNoAutofit = (CTTextNoAutofit)get_store().add_element_user(NOAUTOFIT$2); 
      cTTextNoAutofit.set((XmlObject)paramCTTextNoAutofit);
    } 
  }
  
  public CTTextNoAutofit addNewNoAutofit() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextNoAutofit cTTextNoAutofit = null;
      cTTextNoAutofit = (CTTextNoAutofit)get_store().add_element_user(NOAUTOFIT$2);
      return cTTextNoAutofit;
    } 
  }
  
  public void unsetNoAutofit() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NOAUTOFIT$2, 0);
    } 
  }
  
  public CTTextNormalAutofit getNormAutofit() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextNormalAutofit cTTextNormalAutofit = null;
      cTTextNormalAutofit = (CTTextNormalAutofit)get_store().find_element_user(NORMAUTOFIT$4, 0);
      if (cTTextNormalAutofit == null)
        return null; 
      return cTTextNormalAutofit;
    } 
  }
  
  public boolean isSetNormAutofit() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NORMAUTOFIT$4) != 0);
    } 
  }
  
  public void setNormAutofit(CTTextNormalAutofit paramCTTextNormalAutofit) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextNormalAutofit cTTextNormalAutofit = null;
      cTTextNormalAutofit = (CTTextNormalAutofit)get_store().find_element_user(NORMAUTOFIT$4, 0);
      if (cTTextNormalAutofit == null)
        cTTextNormalAutofit = (CTTextNormalAutofit)get_store().add_element_user(NORMAUTOFIT$4); 
      cTTextNormalAutofit.set((XmlObject)paramCTTextNormalAutofit);
    } 
  }
  
  public CTTextNormalAutofit addNewNormAutofit() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextNormalAutofit cTTextNormalAutofit = null;
      cTTextNormalAutofit = (CTTextNormalAutofit)get_store().add_element_user(NORMAUTOFIT$4);
      return cTTextNormalAutofit;
    } 
  }
  
  public void unsetNormAutofit() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NORMAUTOFIT$4, 0);
    } 
  }
  
  public CTTextShapeAutofit getSpAutoFit() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextShapeAutofit cTTextShapeAutofit = null;
      cTTextShapeAutofit = (CTTextShapeAutofit)get_store().find_element_user(SPAUTOFIT$6, 0);
      if (cTTextShapeAutofit == null)
        return null; 
      return cTTextShapeAutofit;
    } 
  }
  
  public boolean isSetSpAutoFit() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SPAUTOFIT$6) != 0);
    } 
  }
  
  public void setSpAutoFit(CTTextShapeAutofit paramCTTextShapeAutofit) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextShapeAutofit cTTextShapeAutofit = null;
      cTTextShapeAutofit = (CTTextShapeAutofit)get_store().find_element_user(SPAUTOFIT$6, 0);
      if (cTTextShapeAutofit == null)
        cTTextShapeAutofit = (CTTextShapeAutofit)get_store().add_element_user(SPAUTOFIT$6); 
      cTTextShapeAutofit.set((XmlObject)paramCTTextShapeAutofit);
    } 
  }
  
  public CTTextShapeAutofit addNewSpAutoFit() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextShapeAutofit cTTextShapeAutofit = null;
      cTTextShapeAutofit = (CTTextShapeAutofit)get_store().add_element_user(SPAUTOFIT$6);
      return cTTextShapeAutofit;
    } 
  }
  
  public void unsetSpAutoFit() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SPAUTOFIT$6, 0);
    } 
  }
  
  public CTScene3D getScene3D() {
    synchronized (monitor()) {
      check_orphaned();
      CTScene3D cTScene3D = null;
      cTScene3D = (CTScene3D)get_store().find_element_user(SCENE3D$8, 0);
      if (cTScene3D == null)
        return null; 
      return cTScene3D;
    } 
  }
  
  public boolean isSetScene3D() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SCENE3D$8) != 0);
    } 
  }
  
  public void setScene3D(CTScene3D paramCTScene3D) {
    synchronized (monitor()) {
      check_orphaned();
      CTScene3D cTScene3D = null;
      cTScene3D = (CTScene3D)get_store().find_element_user(SCENE3D$8, 0);
      if (cTScene3D == null)
        cTScene3D = (CTScene3D)get_store().add_element_user(SCENE3D$8); 
      cTScene3D.set((XmlObject)paramCTScene3D);
    } 
  }
  
  public CTScene3D addNewScene3D() {
    synchronized (monitor()) {
      check_orphaned();
      CTScene3D cTScene3D = null;
      cTScene3D = (CTScene3D)get_store().add_element_user(SCENE3D$8);
      return cTScene3D;
    } 
  }
  
  public void unsetScene3D() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SCENE3D$8, 0);
    } 
  }
  
  public CTShape3D getSp3D() {
    synchronized (monitor()) {
      check_orphaned();
      CTShape3D cTShape3D = null;
      cTShape3D = (CTShape3D)get_store().find_element_user(SP3D$10, 0);
      if (cTShape3D == null)
        return null; 
      return cTShape3D;
    } 
  }
  
  public boolean isSetSp3D() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SP3D$10) != 0);
    } 
  }
  
  public void setSp3D(CTShape3D paramCTShape3D) {
    synchronized (monitor()) {
      check_orphaned();
      CTShape3D cTShape3D = null;
      cTShape3D = (CTShape3D)get_store().find_element_user(SP3D$10, 0);
      if (cTShape3D == null)
        cTShape3D = (CTShape3D)get_store().add_element_user(SP3D$10); 
      cTShape3D.set((XmlObject)paramCTShape3D);
    } 
  }
  
  public CTShape3D addNewSp3D() {
    synchronized (monitor()) {
      check_orphaned();
      CTShape3D cTShape3D = null;
      cTShape3D = (CTShape3D)get_store().add_element_user(SP3D$10);
      return cTShape3D;
    } 
  }
  
  public void unsetSp3D() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SP3D$10, 0);
    } 
  }
  
  public CTFlatText getFlatTx() {
    synchronized (monitor()) {
      check_orphaned();
      CTFlatText cTFlatText = null;
      cTFlatText = (CTFlatText)get_store().find_element_user(FLATTX$12, 0);
      if (cTFlatText == null)
        return null; 
      return cTFlatText;
    } 
  }
  
  public boolean isSetFlatTx() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FLATTX$12) != 0);
    } 
  }
  
  public void setFlatTx(CTFlatText paramCTFlatText) {
    synchronized (monitor()) {
      check_orphaned();
      CTFlatText cTFlatText = null;
      cTFlatText = (CTFlatText)get_store().find_element_user(FLATTX$12, 0);
      if (cTFlatText == null)
        cTFlatText = (CTFlatText)get_store().add_element_user(FLATTX$12); 
      cTFlatText.set((XmlObject)paramCTFlatText);
    } 
  }
  
  public CTFlatText addNewFlatTx() {
    synchronized (monitor()) {
      check_orphaned();
      CTFlatText cTFlatText = null;
      cTFlatText = (CTFlatText)get_store().add_element_user(FLATTX$12);
      return cTFlatText;
    } 
  }
  
  public void unsetFlatTx() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FLATTX$12, 0);
    } 
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$14, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$14) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$14, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$14); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$14);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$14, 0);
    } 
  }
  
  public int getRot() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ROT$16);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STAngle xgetRot() {
    synchronized (monitor()) {
      check_orphaned();
      STAngle sTAngle = null;
      sTAngle = (STAngle)get_store().find_attribute_user(ROT$16);
      return sTAngle;
    } 
  }
  
  public boolean isSetRot() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ROT$16) != null);
    } 
  }
  
  public void setRot(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ROT$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ROT$16); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetRot(STAngle paramSTAngle) {
    synchronized (monitor()) {
      check_orphaned();
      STAngle sTAngle = null;
      sTAngle = (STAngle)get_store().find_attribute_user(ROT$16);
      if (sTAngle == null)
        sTAngle = (STAngle)get_store().add_attribute_user(ROT$16); 
      sTAngle.set((XmlObject)paramSTAngle);
    } 
  }
  
  public void unsetRot() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ROT$16);
    } 
  }
  
  public boolean getSpcFirstLastPara() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SPCFIRSTLASTPARA$18);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetSpcFirstLastPara() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SPCFIRSTLASTPARA$18);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetSpcFirstLastPara() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SPCFIRSTLASTPARA$18) != null);
    } 
  }
  
  public void setSpcFirstLastPara(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SPCFIRSTLASTPARA$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SPCFIRSTLASTPARA$18); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetSpcFirstLastPara(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SPCFIRSTLASTPARA$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SPCFIRSTLASTPARA$18); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetSpcFirstLastPara() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SPCFIRSTLASTPARA$18);
    } 
  }
  
  public STTextVertOverflowType.Enum getVertOverflow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VERTOVERFLOW$20);
      if (simpleValue == null)
        return null; 
      return (STTextVertOverflowType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTextVertOverflowType xgetVertOverflow() {
    synchronized (monitor()) {
      check_orphaned();
      STTextVertOverflowType sTTextVertOverflowType = null;
      sTTextVertOverflowType = (STTextVertOverflowType)get_store().find_attribute_user(VERTOVERFLOW$20);
      return sTTextVertOverflowType;
    } 
  }
  
  public boolean isSetVertOverflow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VERTOVERFLOW$20) != null);
    } 
  }
  
  public void setVertOverflow(STTextVertOverflowType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VERTOVERFLOW$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VERTOVERFLOW$20); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVertOverflow(STTextVertOverflowType paramSTTextVertOverflowType) {
    synchronized (monitor()) {
      check_orphaned();
      STTextVertOverflowType sTTextVertOverflowType = null;
      sTTextVertOverflowType = (STTextVertOverflowType)get_store().find_attribute_user(VERTOVERFLOW$20);
      if (sTTextVertOverflowType == null)
        sTTextVertOverflowType = (STTextVertOverflowType)get_store().add_attribute_user(VERTOVERFLOW$20); 
      sTTextVertOverflowType.set((XmlObject)paramSTTextVertOverflowType);
    } 
  }
  
  public void unsetVertOverflow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VERTOVERFLOW$20);
    } 
  }
  
  public STTextHorzOverflowType.Enum getHorzOverflow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HORZOVERFLOW$22);
      if (simpleValue == null)
        return null; 
      return (STTextHorzOverflowType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTextHorzOverflowType xgetHorzOverflow() {
    synchronized (monitor()) {
      check_orphaned();
      STTextHorzOverflowType sTTextHorzOverflowType = null;
      sTTextHorzOverflowType = (STTextHorzOverflowType)get_store().find_attribute_user(HORZOVERFLOW$22);
      return sTTextHorzOverflowType;
    } 
  }
  
  public boolean isSetHorzOverflow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HORZOVERFLOW$22) != null);
    } 
  }
  
  public void setHorzOverflow(STTextHorzOverflowType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HORZOVERFLOW$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HORZOVERFLOW$22); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetHorzOverflow(STTextHorzOverflowType paramSTTextHorzOverflowType) {
    synchronized (monitor()) {
      check_orphaned();
      STTextHorzOverflowType sTTextHorzOverflowType = null;
      sTTextHorzOverflowType = (STTextHorzOverflowType)get_store().find_attribute_user(HORZOVERFLOW$22);
      if (sTTextHorzOverflowType == null)
        sTTextHorzOverflowType = (STTextHorzOverflowType)get_store().add_attribute_user(HORZOVERFLOW$22); 
      sTTextHorzOverflowType.set((XmlObject)paramSTTextHorzOverflowType);
    } 
  }
  
  public void unsetHorzOverflow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HORZOVERFLOW$22);
    } 
  }
  
  public STTextVerticalType.Enum getVert() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VERT$24);
      if (simpleValue == null)
        return null; 
      return (STTextVerticalType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTextVerticalType xgetVert() {
    synchronized (monitor()) {
      check_orphaned();
      STTextVerticalType sTTextVerticalType = null;
      sTTextVerticalType = (STTextVerticalType)get_store().find_attribute_user(VERT$24);
      return sTTextVerticalType;
    } 
  }
  
  public boolean isSetVert() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VERT$24) != null);
    } 
  }
  
  public void setVert(STTextVerticalType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VERT$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VERT$24); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVert(STTextVerticalType paramSTTextVerticalType) {
    synchronized (monitor()) {
      check_orphaned();
      STTextVerticalType sTTextVerticalType = null;
      sTTextVerticalType = (STTextVerticalType)get_store().find_attribute_user(VERT$24);
      if (sTTextVerticalType == null)
        sTTextVerticalType = (STTextVerticalType)get_store().add_attribute_user(VERT$24); 
      sTTextVerticalType.set((XmlObject)paramSTTextVerticalType);
    } 
  }
  
  public void unsetVert() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VERT$24);
    } 
  }
  
  public STTextWrappingType.Enum getWrap() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WRAP$26);
      if (simpleValue == null)
        return null; 
      return (STTextWrappingType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTextWrappingType xgetWrap() {
    synchronized (monitor()) {
      check_orphaned();
      STTextWrappingType sTTextWrappingType = null;
      sTTextWrappingType = (STTextWrappingType)get_store().find_attribute_user(WRAP$26);
      return sTTextWrappingType;
    } 
  }
  
  public boolean isSetWrap() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(WRAP$26) != null);
    } 
  }
  
  public void setWrap(STTextWrappingType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WRAP$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(WRAP$26); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetWrap(STTextWrappingType paramSTTextWrappingType) {
    synchronized (monitor()) {
      check_orphaned();
      STTextWrappingType sTTextWrappingType = null;
      sTTextWrappingType = (STTextWrappingType)get_store().find_attribute_user(WRAP$26);
      if (sTTextWrappingType == null)
        sTTextWrappingType = (STTextWrappingType)get_store().add_attribute_user(WRAP$26); 
      sTTextWrappingType.set((XmlObject)paramSTTextWrappingType);
    } 
  }
  
  public void unsetWrap() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(WRAP$26);
    } 
  }
  
  public int getLIns() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LINS$28);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STCoordinate32 xgetLIns() {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate32 sTCoordinate32 = null;
      sTCoordinate32 = (STCoordinate32)get_store().find_attribute_user(LINS$28);
      return sTCoordinate32;
    } 
  }
  
  public boolean isSetLIns() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LINS$28) != null);
    } 
  }
  
  public void setLIns(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LINS$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LINS$28); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetLIns(STCoordinate32 paramSTCoordinate32) {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate32 sTCoordinate32 = null;
      sTCoordinate32 = (STCoordinate32)get_store().find_attribute_user(LINS$28);
      if (sTCoordinate32 == null)
        sTCoordinate32 = (STCoordinate32)get_store().add_attribute_user(LINS$28); 
      sTCoordinate32.set((XmlObject)paramSTCoordinate32);
    } 
  }
  
  public void unsetLIns() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LINS$28);
    } 
  }
  
  public int getTIns() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TINS$30);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STCoordinate32 xgetTIns() {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate32 sTCoordinate32 = null;
      sTCoordinate32 = (STCoordinate32)get_store().find_attribute_user(TINS$30);
      return sTCoordinate32;
    } 
  }
  
  public boolean isSetTIns() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TINS$30) != null);
    } 
  }
  
  public void setTIns(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TINS$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TINS$30); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetTIns(STCoordinate32 paramSTCoordinate32) {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate32 sTCoordinate32 = null;
      sTCoordinate32 = (STCoordinate32)get_store().find_attribute_user(TINS$30);
      if (sTCoordinate32 == null)
        sTCoordinate32 = (STCoordinate32)get_store().add_attribute_user(TINS$30); 
      sTCoordinate32.set((XmlObject)paramSTCoordinate32);
    } 
  }
  
  public void unsetTIns() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TINS$30);
    } 
  }
  
  public int getRIns() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RINS$32);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STCoordinate32 xgetRIns() {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate32 sTCoordinate32 = null;
      sTCoordinate32 = (STCoordinate32)get_store().find_attribute_user(RINS$32);
      return sTCoordinate32;
    } 
  }
  
  public boolean isSetRIns() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RINS$32) != null);
    } 
  }
  
  public void setRIns(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RINS$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RINS$32); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetRIns(STCoordinate32 paramSTCoordinate32) {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate32 sTCoordinate32 = null;
      sTCoordinate32 = (STCoordinate32)get_store().find_attribute_user(RINS$32);
      if (sTCoordinate32 == null)
        sTCoordinate32 = (STCoordinate32)get_store().add_attribute_user(RINS$32); 
      sTCoordinate32.set((XmlObject)paramSTCoordinate32);
    } 
  }
  
  public void unsetRIns() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RINS$32);
    } 
  }
  
  public int getBIns() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BINS$34);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STCoordinate32 xgetBIns() {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate32 sTCoordinate32 = null;
      sTCoordinate32 = (STCoordinate32)get_store().find_attribute_user(BINS$34);
      return sTCoordinate32;
    } 
  }
  
  public boolean isSetBIns() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BINS$34) != null);
    } 
  }
  
  public void setBIns(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BINS$34);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BINS$34); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetBIns(STCoordinate32 paramSTCoordinate32) {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate32 sTCoordinate32 = null;
      sTCoordinate32 = (STCoordinate32)get_store().find_attribute_user(BINS$34);
      if (sTCoordinate32 == null)
        sTCoordinate32 = (STCoordinate32)get_store().add_attribute_user(BINS$34); 
      sTCoordinate32.set((XmlObject)paramSTCoordinate32);
    } 
  }
  
  public void unsetBIns() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BINS$34);
    } 
  }
  
  public int getNumCol() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NUMCOL$36);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STTextColumnCount xgetNumCol() {
    synchronized (monitor()) {
      check_orphaned();
      STTextColumnCount sTTextColumnCount = null;
      sTTextColumnCount = (STTextColumnCount)get_store().find_attribute_user(NUMCOL$36);
      return sTTextColumnCount;
    } 
  }
  
  public boolean isSetNumCol() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NUMCOL$36) != null);
    } 
  }
  
  public void setNumCol(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NUMCOL$36);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NUMCOL$36); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetNumCol(STTextColumnCount paramSTTextColumnCount) {
    synchronized (monitor()) {
      check_orphaned();
      STTextColumnCount sTTextColumnCount = null;
      sTTextColumnCount = (STTextColumnCount)get_store().find_attribute_user(NUMCOL$36);
      if (sTTextColumnCount == null)
        sTTextColumnCount = (STTextColumnCount)get_store().add_attribute_user(NUMCOL$36); 
      sTTextColumnCount.set((XmlObject)paramSTTextColumnCount);
    } 
  }
  
  public void unsetNumCol() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NUMCOL$36);
    } 
  }
  
  public int getSpcCol() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SPCCOL$38);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STPositiveCoordinate32 xgetSpcCol() {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveCoordinate32 sTPositiveCoordinate32 = null;
      sTPositiveCoordinate32 = (STPositiveCoordinate32)get_store().find_attribute_user(SPCCOL$38);
      return sTPositiveCoordinate32;
    } 
  }
  
  public boolean isSetSpcCol() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SPCCOL$38) != null);
    } 
  }
  
  public void setSpcCol(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SPCCOL$38);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SPCCOL$38); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetSpcCol(STPositiveCoordinate32 paramSTPositiveCoordinate32) {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveCoordinate32 sTPositiveCoordinate32 = null;
      sTPositiveCoordinate32 = (STPositiveCoordinate32)get_store().find_attribute_user(SPCCOL$38);
      if (sTPositiveCoordinate32 == null)
        sTPositiveCoordinate32 = (STPositiveCoordinate32)get_store().add_attribute_user(SPCCOL$38); 
      sTPositiveCoordinate32.set((XmlObject)paramSTPositiveCoordinate32);
    } 
  }
  
  public void unsetSpcCol() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SPCCOL$38);
    } 
  }
  
  public boolean getRtlCol() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RTLCOL$40);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetRtlCol() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(RTLCOL$40);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetRtlCol() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RTLCOL$40) != null);
    } 
  }
  
  public void setRtlCol(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RTLCOL$40);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RTLCOL$40); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetRtlCol(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(RTLCOL$40);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(RTLCOL$40); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetRtlCol() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RTLCOL$40);
    } 
  }
  
  public boolean getFromWordArt() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FROMWORDART$42);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFromWordArt() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FROMWORDART$42);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFromWordArt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FROMWORDART$42) != null);
    } 
  }
  
  public void setFromWordArt(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FROMWORDART$42);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FROMWORDART$42); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFromWordArt(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FROMWORDART$42);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FROMWORDART$42); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFromWordArt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FROMWORDART$42);
    } 
  }
  
  public STTextAnchoringType.Enum getAnchor() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ANCHOR$44);
      if (simpleValue == null)
        return null; 
      return (STTextAnchoringType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTextAnchoringType xgetAnchor() {
    synchronized (monitor()) {
      check_orphaned();
      STTextAnchoringType sTTextAnchoringType = null;
      sTTextAnchoringType = (STTextAnchoringType)get_store().find_attribute_user(ANCHOR$44);
      return sTTextAnchoringType;
    } 
  }
  
  public boolean isSetAnchor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ANCHOR$44) != null);
    } 
  }
  
  public void setAnchor(STTextAnchoringType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ANCHOR$44);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ANCHOR$44); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAnchor(STTextAnchoringType paramSTTextAnchoringType) {
    synchronized (monitor()) {
      check_orphaned();
      STTextAnchoringType sTTextAnchoringType = null;
      sTTextAnchoringType = (STTextAnchoringType)get_store().find_attribute_user(ANCHOR$44);
      if (sTTextAnchoringType == null)
        sTTextAnchoringType = (STTextAnchoringType)get_store().add_attribute_user(ANCHOR$44); 
      sTTextAnchoringType.set((XmlObject)paramSTTextAnchoringType);
    } 
  }
  
  public void unsetAnchor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ANCHOR$44);
    } 
  }
  
  public boolean getAnchorCtr() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ANCHORCTR$46);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetAnchorCtr() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ANCHORCTR$46);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetAnchorCtr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ANCHORCTR$46) != null);
    } 
  }
  
  public void setAnchorCtr(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ANCHORCTR$46);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ANCHORCTR$46); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetAnchorCtr(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ANCHORCTR$46);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ANCHORCTR$46); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetAnchorCtr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ANCHORCTR$46);
    } 
  }
  
  public boolean getForceAA() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORCEAA$48);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetForceAA() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FORCEAA$48);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetForceAA() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FORCEAA$48) != null);
    } 
  }
  
  public void setForceAA(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORCEAA$48);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FORCEAA$48); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetForceAA(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FORCEAA$48);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FORCEAA$48); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetForceAA() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FORCEAA$48);
    } 
  }
  
  public boolean getUpright() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UPRIGHT$50);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(UPRIGHT$50); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetUpright() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(UPRIGHT$50);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(UPRIGHT$50); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetUpright() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(UPRIGHT$50) != null);
    } 
  }
  
  public void setUpright(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UPRIGHT$50);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(UPRIGHT$50); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetUpright(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(UPRIGHT$50);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(UPRIGHT$50); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetUpright() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(UPRIGHT$50);
    } 
  }
  
  public boolean getCompatLnSpc() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COMPATLNSPC$52);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetCompatLnSpc() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(COMPATLNSPC$52);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetCompatLnSpc() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COMPATLNSPC$52) != null);
    } 
  }
  
  public void setCompatLnSpc(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COMPATLNSPC$52);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COMPATLNSPC$52); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetCompatLnSpc(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(COMPATLNSPC$52);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(COMPATLNSPC$52); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetCompatLnSpc() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COMPATLNSPC$52);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTextBodyPropertiesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */