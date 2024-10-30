package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayoutIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTransition;

public class CTSlideMasterImpl extends XmlComplexContentImpl implements CTSlideMaster {
  private static final b CSLD$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "cSld");
  
  private static final b CLRMAP$2 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "clrMap");
  
  private static final b SLDLAYOUTIDLST$4 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "sldLayoutIdLst");
  
  private static final b TRANSITION$6 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "transition");
  
  private static final b TIMING$8 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "timing");
  
  private static final b HF$10 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "hf");
  
  private static final b TXSTYLES$12 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "txStyles");
  
  private static final b EXTLST$14 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
  
  private static final b PRESERVE$16 = new b("", "preserve");
  
  public CTSlideMasterImpl(SchemaType paramSchemaType) {
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
  
  public CTColorMapping getClrMap() {
    synchronized (monitor()) {
      check_orphaned();
      CTColorMapping cTColorMapping = null;
      cTColorMapping = (CTColorMapping)get_store().find_element_user(CLRMAP$2, 0);
      if (cTColorMapping == null)
        return null; 
      return cTColorMapping;
    } 
  }
  
  public void setClrMap(CTColorMapping paramCTColorMapping) {
    synchronized (monitor()) {
      check_orphaned();
      CTColorMapping cTColorMapping = null;
      cTColorMapping = (CTColorMapping)get_store().find_element_user(CLRMAP$2, 0);
      if (cTColorMapping == null)
        cTColorMapping = (CTColorMapping)get_store().add_element_user(CLRMAP$2); 
      cTColorMapping.set((XmlObject)paramCTColorMapping);
    } 
  }
  
  public CTColorMapping addNewClrMap() {
    synchronized (monitor()) {
      check_orphaned();
      CTColorMapping cTColorMapping = null;
      cTColorMapping = (CTColorMapping)get_store().add_element_user(CLRMAP$2);
      return cTColorMapping;
    } 
  }
  
  public CTSlideLayoutIdList getSldLayoutIdLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideLayoutIdList cTSlideLayoutIdList = null;
      cTSlideLayoutIdList = (CTSlideLayoutIdList)get_store().find_element_user(SLDLAYOUTIDLST$4, 0);
      if (cTSlideLayoutIdList == null)
        return null; 
      return cTSlideLayoutIdList;
    } 
  }
  
  public boolean isSetSldLayoutIdLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SLDLAYOUTIDLST$4) != 0);
    } 
  }
  
  public void setSldLayoutIdLst(CTSlideLayoutIdList paramCTSlideLayoutIdList) {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideLayoutIdList cTSlideLayoutIdList = null;
      cTSlideLayoutIdList = (CTSlideLayoutIdList)get_store().find_element_user(SLDLAYOUTIDLST$4, 0);
      if (cTSlideLayoutIdList == null)
        cTSlideLayoutIdList = (CTSlideLayoutIdList)get_store().add_element_user(SLDLAYOUTIDLST$4); 
      cTSlideLayoutIdList.set((XmlObject)paramCTSlideLayoutIdList);
    } 
  }
  
  public CTSlideLayoutIdList addNewSldLayoutIdLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideLayoutIdList cTSlideLayoutIdList = null;
      cTSlideLayoutIdList = (CTSlideLayoutIdList)get_store().add_element_user(SLDLAYOUTIDLST$4);
      return cTSlideLayoutIdList;
    } 
  }
  
  public void unsetSldLayoutIdLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SLDLAYOUTIDLST$4, 0);
    } 
  }
  
  public CTSlideTransition getTransition() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideTransition cTSlideTransition = null;
      cTSlideTransition = (CTSlideTransition)get_store().find_element_user(TRANSITION$6, 0);
      if (cTSlideTransition == null)
        return null; 
      return cTSlideTransition;
    } 
  }
  
  public boolean isSetTransition() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TRANSITION$6) != 0);
    } 
  }
  
  public void setTransition(CTSlideTransition paramCTSlideTransition) {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideTransition cTSlideTransition = null;
      cTSlideTransition = (CTSlideTransition)get_store().find_element_user(TRANSITION$6, 0);
      if (cTSlideTransition == null)
        cTSlideTransition = (CTSlideTransition)get_store().add_element_user(TRANSITION$6); 
      cTSlideTransition.set((XmlObject)paramCTSlideTransition);
    } 
  }
  
  public CTSlideTransition addNewTransition() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideTransition cTSlideTransition = null;
      cTSlideTransition = (CTSlideTransition)get_store().add_element_user(TRANSITION$6);
      return cTSlideTransition;
    } 
  }
  
  public void unsetTransition() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TRANSITION$6, 0);
    } 
  }
  
  public CTSlideTiming getTiming() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideTiming cTSlideTiming = null;
      cTSlideTiming = (CTSlideTiming)get_store().find_element_user(TIMING$8, 0);
      if (cTSlideTiming == null)
        return null; 
      return cTSlideTiming;
    } 
  }
  
  public boolean isSetTiming() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TIMING$8) != 0);
    } 
  }
  
  public void setTiming(CTSlideTiming paramCTSlideTiming) {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideTiming cTSlideTiming = null;
      cTSlideTiming = (CTSlideTiming)get_store().find_element_user(TIMING$8, 0);
      if (cTSlideTiming == null)
        cTSlideTiming = (CTSlideTiming)get_store().add_element_user(TIMING$8); 
      cTSlideTiming.set((XmlObject)paramCTSlideTiming);
    } 
  }
  
  public CTSlideTiming addNewTiming() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideTiming cTSlideTiming = null;
      cTSlideTiming = (CTSlideTiming)get_store().add_element_user(TIMING$8);
      return cTSlideTiming;
    } 
  }
  
  public void unsetTiming() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TIMING$8, 0);
    } 
  }
  
  public CTHeaderFooter getHf() {
    synchronized (monitor()) {
      check_orphaned();
      CTHeaderFooter cTHeaderFooter = null;
      cTHeaderFooter = (CTHeaderFooter)get_store().find_element_user(HF$10, 0);
      if (cTHeaderFooter == null)
        return null; 
      return cTHeaderFooter;
    } 
  }
  
  public boolean isSetHf() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HF$10) != 0);
    } 
  }
  
  public void setHf(CTHeaderFooter paramCTHeaderFooter) {
    synchronized (monitor()) {
      check_orphaned();
      CTHeaderFooter cTHeaderFooter = null;
      cTHeaderFooter = (CTHeaderFooter)get_store().find_element_user(HF$10, 0);
      if (cTHeaderFooter == null)
        cTHeaderFooter = (CTHeaderFooter)get_store().add_element_user(HF$10); 
      cTHeaderFooter.set((XmlObject)paramCTHeaderFooter);
    } 
  }
  
  public CTHeaderFooter addNewHf() {
    synchronized (monitor()) {
      check_orphaned();
      CTHeaderFooter cTHeaderFooter = null;
      cTHeaderFooter = (CTHeaderFooter)get_store().add_element_user(HF$10);
      return cTHeaderFooter;
    } 
  }
  
  public void unsetHf() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HF$10, 0);
    } 
  }
  
  public CTSlideMasterTextStyles getTxStyles() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideMasterTextStyles cTSlideMasterTextStyles = null;
      cTSlideMasterTextStyles = (CTSlideMasterTextStyles)get_store().find_element_user(TXSTYLES$12, 0);
      if (cTSlideMasterTextStyles == null)
        return null; 
      return cTSlideMasterTextStyles;
    } 
  }
  
  public boolean isSetTxStyles() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TXSTYLES$12) != 0);
    } 
  }
  
  public void setTxStyles(CTSlideMasterTextStyles paramCTSlideMasterTextStyles) {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideMasterTextStyles cTSlideMasterTextStyles = null;
      cTSlideMasterTextStyles = (CTSlideMasterTextStyles)get_store().find_element_user(TXSTYLES$12, 0);
      if (cTSlideMasterTextStyles == null)
        cTSlideMasterTextStyles = (CTSlideMasterTextStyles)get_store().add_element_user(TXSTYLES$12); 
      cTSlideMasterTextStyles.set((XmlObject)paramCTSlideMasterTextStyles);
    } 
  }
  
  public CTSlideMasterTextStyles addNewTxStyles() {
    synchronized (monitor()) {
      check_orphaned();
      CTSlideMasterTextStyles cTSlideMasterTextStyles = null;
      cTSlideMasterTextStyles = (CTSlideMasterTextStyles)get_store().add_element_user(TXSTYLES$12);
      return cTSlideMasterTextStyles;
    } 
  }
  
  public void unsetTxStyles() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TXSTYLES$12, 0);
    } 
  }
  
  public CTExtensionListModify getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().find_element_user(EXTLST$14, 0);
      if (cTExtensionListModify == null)
        return null; 
      return cTExtensionListModify;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$14) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionListModify paramCTExtensionListModify) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().find_element_user(EXTLST$14, 0);
      if (cTExtensionListModify == null)
        cTExtensionListModify = (CTExtensionListModify)get_store().add_element_user(EXTLST$14); 
      cTExtensionListModify.set((XmlObject)paramCTExtensionListModify);
    } 
  }
  
  public CTExtensionListModify addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionListModify cTExtensionListModify = null;
      cTExtensionListModify = (CTExtensionListModify)get_store().add_element_user(EXTLST$14);
      return cTExtensionListModify;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$14, 0);
    } 
  }
  
  public boolean getPreserve() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PRESERVE$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PRESERVE$16); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetPreserve() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PRESERVE$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(PRESERVE$16); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetPreserve() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PRESERVE$16) != null);
    } 
  }
  
  public void setPreserve(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PRESERVE$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PRESERVE$16); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetPreserve(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PRESERVE$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PRESERVE$16); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetPreserve() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PRESERVE$16);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTSlideMasterImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */