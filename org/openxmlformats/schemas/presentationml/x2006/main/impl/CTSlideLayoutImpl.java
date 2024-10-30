package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTransition;
import org.openxmlformats.schemas.presentationml.x2006.main.STSlideLayoutType;

public class CTSlideLayoutImpl extends XmlComplexContentImpl implements CTSlideLayout {
  private static final b CSLD$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "cSld");
  
  private static final b CLRMAPOVR$2 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "clrMapOvr");
  
  private static final b TRANSITION$4 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "transition");
  
  private static final b TIMING$6 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "timing");
  
  private static final b HF$8 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "hf");
  
  private static final b EXTLST$10 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
  
  private static final b SHOWMASTERSP$12 = new b("", "showMasterSp");
  
  private static final b SHOWMASTERPHANIM$14 = new b("", "showMasterPhAnim");
  
  private static final b MATCHINGNAME$16 = new b("", "matchingName");
  
  private static final b TYPE$18 = new b("", "type");
  
  private static final b PRESERVE$20 = new b("", "preserve");
  
  private static final b USERDRAWN$22 = new b("", "userDrawn");
  
  public CTSlideLayoutImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTCommonSlideData getCSld() {
    synchronized (monitor()) {
      check_orphaned();
      CTCommonSlideData cTCommonSlideData = null;
      cTCommonSlideData = (CTCommonSlideData)get_store().find_element_user(CSLD$0, 0);
      if (cTCommonSlideData == null)
        return null; 
      return cTCommonSlideData;
    } 
  }
  
  public void setCSld(CTCommonSlideData paramCTCommonSlideData) {
    synchronized (monitor()) {
      check_orphaned();
      CTCommonSlideData cTCommonSlideData = null;
      cTCommonSlideData = (CTCommonSlideData)get_store().find_element_user(CSLD$0, 0);
      if (cTCommonSlideData == null)
        cTCommonSlideData = (CTCommonSlideData)get_store().add_element_user(CSLD$0); 
      cTCommonSlideData.set((XmlObject)paramCTCommonSlideData);
    } 
  }
  
  public CTCommonSlideData addNewCSld() {
    synchronized (monitor()) {
      check_orphaned();
      CTCommonSlideData cTCommonSlideData = null;
      cTCommonSlideData = (CTCommonSlideData)get_store().add_element_user(CSLD$0);
      return cTCommonSlideData;
    } 
  }
  
  public CTColorMappingOverride getClrMapOvr() {
    synchronized (monitor()) {
      check_orphaned();
      CTColorMappingOverride cTColorMappingOverride = null;
      cTColorMappingOverride = (CTColorMappingOverride)get_store().find_element_user(CLRMAPOVR$2, 0);
      if (cTColorMappingOverride == null)
        return null; 
      return cTColorMappingOverride;
    } 
  }
  
  public boolean isSetClrMapOvr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CLRMAPOVR$2) != 0);
    } 
  }
  
  public void setClrMapOvr(CTColorMappingOverride paramCTColorMappingOverride) {
    synchronized (monitor()) {
      check_orphaned();
      CTColorMappingOverride cTColorMappingOverride = null;
      cTColorMappingOverride = (CTColorMappingOverride)get_store().find_element_user(CLRMAPOVR$2, 0);
      if (cTColorMappingOverride == null)
        cTColorMappingOverride = (CTColorMappingOverride)get_store().add_element_user(CLRMAPOVR$2); 
      cTColorMappingOverride.set((XmlObject)paramCTColorMappingOverride);
    } 
  }
  
  public CTColorMappingOverride addNewClrMapOvr() {
    synchronized (monitor()) {
      check_orphaned();
      CTColorMappingOverride cTColorMappingOverride = null;
      cTColorMappingOverride = (CTColorMappingOverride)get_store().add_element_user(CLRMAPOVR$2);
      return cTColorMappingOverride;
    } 
  }
  
  public void unsetClrMapOvr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CLRMAPOVR$2, 0);
    } 
  }
  
  public CTSlideTransition getTransition() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideTransition cTSlideTransition = null;
      cTSlideTransition = (CTSlideTransition)get_store().find_element_user(TRANSITION$4, 0);
      if (cTSlideTransition == null)
        return null; 
      return cTSlideTransition;
    } 
  }
  
  public boolean isSetTransition() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TRANSITION$4) != 0);
    } 
  }
  
  public void setTransition(CTSlideTransition paramCTSlideTransition) {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideTransition cTSlideTransition = null;
      cTSlideTransition = (CTSlideTransition)get_store().find_element_user(TRANSITION$4, 0);
      if (cTSlideTransition == null)
        cTSlideTransition = (CTSlideTransition)get_store().add_element_user(TRANSITION$4); 
      cTSlideTransition.set((XmlObject)paramCTSlideTransition);
    } 
  }
  
  public CTSlideTransition addNewTransition() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideTransition cTSlideTransition = null;
      cTSlideTransition = (CTSlideTransition)get_store().add_element_user(TRANSITION$4);
      return cTSlideTransition;
    } 
  }
  
  public void unsetTransition() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TRANSITION$4, 0);
    } 
  }
  
  public CTSlideTiming getTiming() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideTiming cTSlideTiming = null;
      cTSlideTiming = (CTSlideTiming)get_store().find_element_user(TIMING$6, 0);
      if (cTSlideTiming == null)
        return null; 
      return cTSlideTiming;
    } 
  }
  
  public boolean isSetTiming() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TIMING$6) != 0);
    } 
  }
  
  public void setTiming(CTSlideTiming paramCTSlideTiming) {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideTiming cTSlideTiming = null;
      cTSlideTiming = (CTSlideTiming)get_store().find_element_user(TIMING$6, 0);
      if (cTSlideTiming == null)
        cTSlideTiming = (CTSlideTiming)get_store().add_element_user(TIMING$6); 
      cTSlideTiming.set((XmlObject)paramCTSlideTiming);
    } 
  }
  
  public CTSlideTiming addNewTiming() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideTiming cTSlideTiming = null;
      cTSlideTiming = (CTSlideTiming)get_store().add_element_user(TIMING$6);
      return cTSlideTiming;
    } 
  }
  
  public void unsetTiming() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TIMING$6, 0);
    } 
  }
  
  public CTHeaderFooter getHf() {
    synchronized (monitor()) {
      check_orphaned();
      CTHeaderFooter cTHeaderFooter = null;
      cTHeaderFooter = (CTHeaderFooter)get_store().find_element_user(HF$8, 0);
      if (cTHeaderFooter == null)
        return null; 
      return cTHeaderFooter;
    } 
  }
  
  public boolean isSetHf() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HF$8) != 0);
    } 
  }
  
  public void setHf(CTHeaderFooter paramCTHeaderFooter) {
    synchronized (monitor()) {
      check_orphaned();
      CTHeaderFooter cTHeaderFooter = null;
      cTHeaderFooter = (CTHeaderFooter)get_store().find_element_user(HF$8, 0);
      if (cTHeaderFooter == null)
        cTHeaderFooter = (CTHeaderFooter)get_store().add_element_user(HF$8); 
      cTHeaderFooter.set((XmlObject)paramCTHeaderFooter);
    } 
  }
  
  public CTHeaderFooter addNewHf() {
    synchronized (monitor()) {
      check_orphaned();
      CTHeaderFooter cTHeaderFooter = null;
      cTHeaderFooter = (CTHeaderFooter)get_store().add_element_user(HF$8);
      return cTHeaderFooter;
    } 
  }
  
  public void unsetHf() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HF$8, 0);
    } 
  }
  
  public CTExtensionListModify getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().find_element_user(EXTLST$10, 0);
      if (cTExtensionListModify == null)
        return null; 
      return cTExtensionListModify;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$10) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionListModify paramCTExtensionListModify) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().find_element_user(EXTLST$10, 0);
      if (cTExtensionListModify == null)
        cTExtensionListModify = (CTExtensionListModify)get_store().add_element_user(EXTLST$10); 
      cTExtensionListModify.set((XmlObject)paramCTExtensionListModify);
    } 
  }
  
  public CTExtensionListModify addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().add_element_user(EXTLST$10);
      return cTExtensionListModify;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$10, 0);
    } 
  }
  
  public boolean getShowMasterSp() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWMASTERSP$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWMASTERSP$12); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowMasterSp() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWMASTERSP$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWMASTERSP$12); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowMasterSp() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWMASTERSP$12) != null);
    } 
  }
  
  public void setShowMasterSp(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWMASTERSP$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWMASTERSP$12); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowMasterSp(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWMASTERSP$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWMASTERSP$12); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowMasterSp() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWMASTERSP$12);
    } 
  }
  
  public boolean getShowMasterPhAnim() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWMASTERPHANIM$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWMASTERPHANIM$14); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowMasterPhAnim() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWMASTERPHANIM$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWMASTERPHANIM$14); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowMasterPhAnim() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWMASTERPHANIM$14) != null);
    } 
  }
  
  public void setShowMasterPhAnim(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWMASTERPHANIM$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWMASTERPHANIM$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowMasterPhAnim(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWMASTERPHANIM$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWMASTERPHANIM$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowMasterPhAnim() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWMASTERPHANIM$14);
    } 
  }
  
  public String getMatchingName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MATCHINGNAME$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(MATCHINGNAME$16); 
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetMatchingName() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(MATCHINGNAME$16);
      if (xmlString == null)
        xmlString = (XmlString)get_default_attribute_value(MATCHINGNAME$16); 
      return xmlString;
    } 
  }
  
  public boolean isSetMatchingName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MATCHINGNAME$16) != null);
    } 
  }
  
  public void setMatchingName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MATCHINGNAME$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MATCHINGNAME$16); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetMatchingName(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(MATCHINGNAME$16);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(MATCHINGNAME$16); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetMatchingName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MATCHINGNAME$16);
    } 
  }
  
  public STSlideLayoutType.Enum getType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(TYPE$18); 
      if (simpleValue == null)
        return null; 
      return (STSlideLayoutType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STSlideLayoutType xgetType() {
    synchronized (monitor()) {
      check_orphaned();
      STSlideLayoutType sTSlideLayoutType = null;
      sTSlideLayoutType = (STSlideLayoutType)get_store().find_attribute_user(TYPE$18);
      if (sTSlideLayoutType == null)
        sTSlideLayoutType = (STSlideLayoutType)get_default_attribute_value(TYPE$18); 
      return sTSlideLayoutType;
    } 
  }
  
  public boolean isSetType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TYPE$18) != null);
    } 
  }
  
  public void setType(STSlideLayoutType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TYPE$18); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetType(STSlideLayoutType paramSTSlideLayoutType) {
    synchronized (monitor()) {
      check_orphaned();
      STSlideLayoutType sTSlideLayoutType = null;
      sTSlideLayoutType = (STSlideLayoutType)get_store().find_attribute_user(TYPE$18);
      if (sTSlideLayoutType == null)
        sTSlideLayoutType = (STSlideLayoutType)get_store().add_attribute_user(TYPE$18); 
      sTSlideLayoutType.set((XmlObject)paramSTSlideLayoutType);
    } 
  }
  
  public void unsetType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TYPE$18);
    } 
  }
  
  public boolean getPreserve() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PRESERVE$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PRESERVE$20); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetPreserve() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PRESERVE$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(PRESERVE$20); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetPreserve() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PRESERVE$20) != null);
    } 
  }
  
  public void setPreserve(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PRESERVE$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PRESERVE$20); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetPreserve(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PRESERVE$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PRESERVE$20); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetPreserve() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PRESERVE$20);
    } 
  }
  
  public boolean getUserDrawn() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(USERDRAWN$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(USERDRAWN$22); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetUserDrawn() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(USERDRAWN$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(USERDRAWN$22); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetUserDrawn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(USERDRAWN$22) != null);
    } 
  }
  
  public void setUserDrawn(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(USERDRAWN$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(USERDRAWN$22); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetUserDrawn(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(USERDRAWN$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(USERDRAWN$22); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetUserDrawn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(USERDRAWN$22);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTSlideLayoutImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */