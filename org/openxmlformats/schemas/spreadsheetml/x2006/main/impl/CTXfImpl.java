package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellAlignment;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STBorderId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellStyleXfId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFillId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFontId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STNumFmtId;

public class CTXfImpl extends XmlComplexContentImpl implements CTXf {
  private static final b ALIGNMENT$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "alignment");
  
  private static final b PROTECTION$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "protection");
  
  private static final b EXTLST$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  private static final b NUMFMTID$6 = new b("", "numFmtId");
  
  private static final b FONTID$8 = new b("", "fontId");
  
  private static final b FILLID$10 = new b("", "fillId");
  
  private static final b BORDERID$12 = new b("", "borderId");
  
  private static final b XFID$14 = new b("", "xfId");
  
  private static final b QUOTEPREFIX$16 = new b("", "quotePrefix");
  
  private static final b PIVOTBUTTON$18 = new b("", "pivotButton");
  
  private static final b APPLYNUMBERFORMAT$20 = new b("", "applyNumberFormat");
  
  private static final b APPLYFONT$22 = new b("", "applyFont");
  
  private static final b APPLYFILL$24 = new b("", "applyFill");
  
  private static final b APPLYBORDER$26 = new b("", "applyBorder");
  
  private static final b APPLYALIGNMENT$28 = new b("", "applyAlignment");
  
  private static final b APPLYPROTECTION$30 = new b("", "applyProtection");
  
  public CTXfImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTCellAlignment getAlignment() {
    synchronized (monitor()) {
      check_orphaned();
      CTCellAlignment cTCellAlignment = null;
      cTCellAlignment = (CTCellAlignment)get_store().find_element_user(ALIGNMENT$0, 0);
      if (cTCellAlignment == null)
        return null; 
      return cTCellAlignment;
    } 
  }
  
  public boolean isSetAlignment() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ALIGNMENT$0) != 0);
    } 
  }
  
  public void setAlignment(CTCellAlignment paramCTCellAlignment) {
    synchronized (monitor()) {
      check_orphaned();
      CTCellAlignment cTCellAlignment = null;
      cTCellAlignment = (CTCellAlignment)get_store().find_element_user(ALIGNMENT$0, 0);
      if (cTCellAlignment == null)
        cTCellAlignment = (CTCellAlignment)get_store().add_element_user(ALIGNMENT$0); 
      cTCellAlignment.set((XmlObject)paramCTCellAlignment);
    } 
  }
  
  public CTCellAlignment addNewAlignment() {
    synchronized (monitor()) {
      check_orphaned();
      CTCellAlignment cTCellAlignment = null;
      cTCellAlignment = (CTCellAlignment)get_store().add_element_user(ALIGNMENT$0);
      return cTCellAlignment;
    } 
  }
  
  public void unsetAlignment() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ALIGNMENT$0, 0);
    } 
  }
  
  public CTCellProtection getProtection() {
    synchronized (monitor()) {
      check_orphaned();
      CTCellProtection cTCellProtection = null;
      cTCellProtection = (CTCellProtection)get_store().find_element_user(PROTECTION$2, 0);
      if (cTCellProtection == null)
        return null; 
      return cTCellProtection;
    } 
  }
  
  public boolean isSetProtection() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PROTECTION$2) != 0);
    } 
  }
  
  public void setProtection(CTCellProtection paramCTCellProtection) {
    synchronized (monitor()) {
      check_orphaned();
      CTCellProtection cTCellProtection = null;
      cTCellProtection = (CTCellProtection)get_store().find_element_user(PROTECTION$2, 0);
      if (cTCellProtection == null)
        cTCellProtection = (CTCellProtection)get_store().add_element_user(PROTECTION$2); 
      cTCellProtection.set((XmlObject)paramCTCellProtection);
    } 
  }
  
  public CTCellProtection addNewProtection() {
    synchronized (monitor()) {
      check_orphaned();
      CTCellProtection cTCellProtection = null;
      cTCellProtection = (CTCellProtection)get_store().add_element_user(PROTECTION$2);
      return cTCellProtection;
    } 
  }
  
  public void unsetProtection() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PROTECTION$2, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$4, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$4) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$4, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$4); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$4);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$4, 0);
    } 
  }
  
  public long getNumFmtId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NUMFMTID$6);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STNumFmtId xgetNumFmtId() {
    synchronized (monitor()) {
      check_orphaned();
      STNumFmtId sTNumFmtId = null;
      sTNumFmtId = (STNumFmtId)get_store().find_attribute_user(NUMFMTID$6);
      return sTNumFmtId;
    } 
  }
  
  public boolean isSetNumFmtId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NUMFMTID$6) != null);
    } 
  }
  
  public void setNumFmtId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NUMFMTID$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NUMFMTID$6); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetNumFmtId(STNumFmtId paramSTNumFmtId) {
    synchronized (monitor()) {
      check_orphaned();
      STNumFmtId sTNumFmtId = null;
      sTNumFmtId = (STNumFmtId)get_store().find_attribute_user(NUMFMTID$6);
      if (sTNumFmtId == null)
        sTNumFmtId = (STNumFmtId)get_store().add_attribute_user(NUMFMTID$6); 
      sTNumFmtId.set((XmlObject)paramSTNumFmtId);
    } 
  }
  
  public void unsetNumFmtId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NUMFMTID$6);
    } 
  }
  
  public long getFontId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FONTID$8);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STFontId xgetFontId() {
    synchronized (monitor()) {
      check_orphaned();
      STFontId sTFontId = null;
      sTFontId = (STFontId)get_store().find_attribute_user(FONTID$8);
      return sTFontId;
    } 
  }
  
  public boolean isSetFontId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FONTID$8) != null);
    } 
  }
  
  public void setFontId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FONTID$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FONTID$8); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetFontId(STFontId paramSTFontId) {
    synchronized (monitor()) {
      check_orphaned();
      STFontId sTFontId = null;
      sTFontId = (STFontId)get_store().find_attribute_user(FONTID$8);
      if (sTFontId == null)
        sTFontId = (STFontId)get_store().add_attribute_user(FONTID$8); 
      sTFontId.set((XmlObject)paramSTFontId);
    } 
  }
  
  public void unsetFontId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FONTID$8);
    } 
  }
  
  public long getFillId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILLID$10);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STFillId xgetFillId() {
    synchronized (monitor()) {
      check_orphaned();
      STFillId sTFillId = null;
      sTFillId = (STFillId)get_store().find_attribute_user(FILLID$10);
      return sTFillId;
    } 
  }
  
  public boolean isSetFillId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FILLID$10) != null);
    } 
  }
  
  public void setFillId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILLID$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FILLID$10); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetFillId(STFillId paramSTFillId) {
    synchronized (monitor()) {
      check_orphaned();
      STFillId sTFillId = null;
      sTFillId = (STFillId)get_store().find_attribute_user(FILLID$10);
      if (sTFillId == null)
        sTFillId = (STFillId)get_store().add_attribute_user(FILLID$10); 
      sTFillId.set((XmlObject)paramSTFillId);
    } 
  }
  
  public void unsetFillId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FILLID$10);
    } 
  }
  
  public long getBorderId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BORDERID$12);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STBorderId xgetBorderId() {
    synchronized (monitor()) {
      check_orphaned();
      STBorderId sTBorderId = null;
      sTBorderId = (STBorderId)get_store().find_attribute_user(BORDERID$12);
      return sTBorderId;
    } 
  }
  
  public boolean isSetBorderId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BORDERID$12) != null);
    } 
  }
  
  public void setBorderId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BORDERID$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BORDERID$12); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetBorderId(STBorderId paramSTBorderId) {
    synchronized (monitor()) {
      check_orphaned();
      STBorderId sTBorderId = null;
      sTBorderId = (STBorderId)get_store().find_attribute_user(BORDERID$12);
      if (sTBorderId == null)
        sTBorderId = (STBorderId)get_store().add_attribute_user(BORDERID$12); 
      sTBorderId.set((XmlObject)paramSTBorderId);
    } 
  }
  
  public void unsetBorderId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BORDERID$12);
    } 
  }
  
  public long getXfId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(XFID$14);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STCellStyleXfId xgetXfId() {
    synchronized (monitor()) {
      check_orphaned();
      STCellStyleXfId sTCellStyleXfId = null;
      sTCellStyleXfId = (STCellStyleXfId)get_store().find_attribute_user(XFID$14);
      return sTCellStyleXfId;
    } 
  }
  
  public boolean isSetXfId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(XFID$14) != null);
    } 
  }
  
  public void setXfId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(XFID$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(XFID$14); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetXfId(STCellStyleXfId paramSTCellStyleXfId) {
    synchronized (monitor()) {
      check_orphaned();
      STCellStyleXfId sTCellStyleXfId = null;
      sTCellStyleXfId = (STCellStyleXfId)get_store().find_attribute_user(XFID$14);
      if (sTCellStyleXfId == null)
        sTCellStyleXfId = (STCellStyleXfId)get_store().add_attribute_user(XFID$14); 
      sTCellStyleXfId.set((XmlObject)paramSTCellStyleXfId);
    } 
  }
  
  public void unsetXfId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(XFID$14);
    } 
  }
  
  public boolean getQuotePrefix() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(QUOTEPREFIX$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(QUOTEPREFIX$16); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetQuotePrefix() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(QUOTEPREFIX$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(QUOTEPREFIX$16); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetQuotePrefix() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(QUOTEPREFIX$16) != null);
    } 
  }
  
  public void setQuotePrefix(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(QUOTEPREFIX$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(QUOTEPREFIX$16); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetQuotePrefix(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(QUOTEPREFIX$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(QUOTEPREFIX$16); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetQuotePrefix() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(QUOTEPREFIX$16);
    } 
  }
  
  public boolean getPivotButton() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PIVOTBUTTON$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PIVOTBUTTON$18); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetPivotButton() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PIVOTBUTTON$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(PIVOTBUTTON$18); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetPivotButton() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PIVOTBUTTON$18) != null);
    } 
  }
  
  public void setPivotButton(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PIVOTBUTTON$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PIVOTBUTTON$18); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetPivotButton(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PIVOTBUTTON$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PIVOTBUTTON$18); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetPivotButton() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PIVOTBUTTON$18);
    } 
  }
  
  public boolean getApplyNumberFormat() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYNUMBERFORMAT$20);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetApplyNumberFormat() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYNUMBERFORMAT$20);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetApplyNumberFormat() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(APPLYNUMBERFORMAT$20) != null);
    } 
  }
  
  public void setApplyNumberFormat(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYNUMBERFORMAT$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(APPLYNUMBERFORMAT$20); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetApplyNumberFormat(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYNUMBERFORMAT$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(APPLYNUMBERFORMAT$20); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetApplyNumberFormat() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(APPLYNUMBERFORMAT$20);
    } 
  }
  
  public boolean getApplyFont() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYFONT$22);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetApplyFont() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYFONT$22);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetApplyFont() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(APPLYFONT$22) != null);
    } 
  }
  
  public void setApplyFont(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYFONT$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(APPLYFONT$22); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetApplyFont(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYFONT$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(APPLYFONT$22); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetApplyFont() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(APPLYFONT$22);
    } 
  }
  
  public boolean getApplyFill() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYFILL$24);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetApplyFill() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYFILL$24);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetApplyFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(APPLYFILL$24) != null);
    } 
  }
  
  public void setApplyFill(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYFILL$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(APPLYFILL$24); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetApplyFill(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYFILL$24);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(APPLYFILL$24); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetApplyFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(APPLYFILL$24);
    } 
  }
  
  public boolean getApplyBorder() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYBORDER$26);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetApplyBorder() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYBORDER$26);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetApplyBorder() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(APPLYBORDER$26) != null);
    } 
  }
  
  public void setApplyBorder(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYBORDER$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(APPLYBORDER$26); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetApplyBorder(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYBORDER$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(APPLYBORDER$26); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetApplyBorder() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(APPLYBORDER$26);
    } 
  }
  
  public boolean getApplyAlignment() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYALIGNMENT$28);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetApplyAlignment() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYALIGNMENT$28);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetApplyAlignment() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(APPLYALIGNMENT$28) != null);
    } 
  }
  
  public void setApplyAlignment(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYALIGNMENT$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(APPLYALIGNMENT$28); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetApplyAlignment(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYALIGNMENT$28);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(APPLYALIGNMENT$28); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetApplyAlignment() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(APPLYALIGNMENT$28);
    } 
  }
  
  public boolean getApplyProtection() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYPROTECTION$30);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetApplyProtection() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYPROTECTION$30);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetApplyProtection() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(APPLYPROTECTION$30) != null);
    } 
  }
  
  public void setApplyProtection(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(APPLYPROTECTION$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(APPLYPROTECTION$30); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetApplyProtection(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(APPLYPROTECTION$30);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(APPLYPROTECTION$30); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetApplyProtection() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(APPLYPROTECTION$30);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTXfImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */