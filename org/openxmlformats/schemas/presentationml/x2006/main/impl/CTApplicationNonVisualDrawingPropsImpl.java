package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAudioCD;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAudioFile;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEmbeddedWAVAudioFile;
import org.openxmlformats.schemas.drawingml.x2006.main.CTQuickTimeFile;
import org.openxmlformats.schemas.drawingml.x2006.main.CTVideoFile;
import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;

public class CTApplicationNonVisualDrawingPropsImpl extends XmlComplexContentImpl implements CTApplicationNonVisualDrawingProps {
  private static final b PH$0 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "ph");
  
  private static final b AUDIOCD$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "audioCd");
  
  private static final b WAVAUDIOFILE$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "wavAudioFile");
  
  private static final b AUDIOFILE$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "audioFile");
  
  private static final b VIDEOFILE$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "videoFile");
  
  private static final b QUICKTIMEFILE$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "quickTimeFile");
  
  private static final b CUSTDATALST$12 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "custDataLst");
  
  private static final b EXTLST$14 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
  
  private static final b ISPHOTO$16 = new b("", "isPhoto");
  
  private static final b USERDRAWN$18 = new b("", "userDrawn");
  
  public CTApplicationNonVisualDrawingPropsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTPlaceholder getPh() {
    synchronized (monitor()) {
      check_orphaned();
      CTPlaceholder cTPlaceholder = null;
      cTPlaceholder = (CTPlaceholder)get_store().find_element_user(PH$0, 0);
      if (cTPlaceholder == null)
        return null; 
      return cTPlaceholder;
    } 
  }
  
  public boolean isSetPh() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PH$0) != 0);
    } 
  }
  
  public void setPh(CTPlaceholder paramCTPlaceholder) {
    synchronized (monitor()) {
      check_orphaned();
      CTPlaceholder cTPlaceholder = null;
      cTPlaceholder = (CTPlaceholder)get_store().find_element_user(PH$0, 0);
      if (cTPlaceholder == null)
        cTPlaceholder = (CTPlaceholder)get_store().add_element_user(PH$0); 
      cTPlaceholder.set((XmlObject)paramCTPlaceholder);
    } 
  }
  
  public CTPlaceholder addNewPh() {
    synchronized (monitor()) {
      check_orphaned();
      CTPlaceholder cTPlaceholder = null;
      cTPlaceholder = (CTPlaceholder)get_store().add_element_user(PH$0);
      return cTPlaceholder;
    } 
  }
  
  public void unsetPh() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PH$0, 0);
    } 
  }
  
  public CTAudioCD getAudioCd() {
    synchronized (monitor()) {
      check_orphaned();
      CTAudioCD cTAudioCD = null;
      cTAudioCD = (CTAudioCD)get_store().find_element_user(AUDIOCD$2, 0);
      if (cTAudioCD == null)
        return null; 
      return cTAudioCD;
    } 
  }
  
  public boolean isSetAudioCd() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(AUDIOCD$2) != 0);
    } 
  }
  
  public void setAudioCd(CTAudioCD paramCTAudioCD) {
    synchronized (monitor()) {
      check_orphaned();
      CTAudioCD cTAudioCD = null;
      cTAudioCD = (CTAudioCD)get_store().find_element_user(AUDIOCD$2, 0);
      if (cTAudioCD == null)
        cTAudioCD = (CTAudioCD)get_store().add_element_user(AUDIOCD$2); 
      cTAudioCD.set((XmlObject)paramCTAudioCD);
    } 
  }
  
  public CTAudioCD addNewAudioCd() {
    synchronized (monitor()) {
      check_orphaned();
      CTAudioCD cTAudioCD = null;
      cTAudioCD = (CTAudioCD)get_store().add_element_user(AUDIOCD$2);
      return cTAudioCD;
    } 
  }
  
  public void unsetAudioCd() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AUDIOCD$2, 0);
    } 
  }
  
  public CTEmbeddedWAVAudioFile getWavAudioFile() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFile = null;
      cTEmbeddedWAVAudioFile = (CTEmbeddedWAVAudioFile)get_store().find_element_user(WAVAUDIOFILE$4, 0);
      if (cTEmbeddedWAVAudioFile == null)
        return null; 
      return cTEmbeddedWAVAudioFile;
    } 
  }
  
  public boolean isSetWavAudioFile() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(WAVAUDIOFILE$4) != 0);
    } 
  }
  
  public void setWavAudioFile(CTEmbeddedWAVAudioFile paramCTEmbeddedWAVAudioFile) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFile = null;
      cTEmbeddedWAVAudioFile = (CTEmbeddedWAVAudioFile)get_store().find_element_user(WAVAUDIOFILE$4, 0);
      if (cTEmbeddedWAVAudioFile == null)
        cTEmbeddedWAVAudioFile = (CTEmbeddedWAVAudioFile)get_store().add_element_user(WAVAUDIOFILE$4); 
      cTEmbeddedWAVAudioFile.set((XmlObject)paramCTEmbeddedWAVAudioFile);
    } 
  }
  
  public CTEmbeddedWAVAudioFile addNewWavAudioFile() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFile = null;
      cTEmbeddedWAVAudioFile = (CTEmbeddedWAVAudioFile)get_store().add_element_user(WAVAUDIOFILE$4);
      return cTEmbeddedWAVAudioFile;
    } 
  }
  
  public void unsetWavAudioFile() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WAVAUDIOFILE$4, 0);
    } 
  }
  
  public CTAudioFile getAudioFile() {
    synchronized (monitor()) {
      check_orphaned();
      CTAudioFile cTAudioFile = null;
      cTAudioFile = (CTAudioFile)get_store().find_element_user(AUDIOFILE$6, 0);
      if (cTAudioFile == null)
        return null; 
      return cTAudioFile;
    } 
  }
  
  public boolean isSetAudioFile() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(AUDIOFILE$6) != 0);
    } 
  }
  
  public void setAudioFile(CTAudioFile paramCTAudioFile) {
    synchronized (monitor()) {
      check_orphaned();
      CTAudioFile cTAudioFile = null;
      cTAudioFile = (CTAudioFile)get_store().find_element_user(AUDIOFILE$6, 0);
      if (cTAudioFile == null)
        cTAudioFile = (CTAudioFile)get_store().add_element_user(AUDIOFILE$6); 
      cTAudioFile.set((XmlObject)paramCTAudioFile);
    } 
  }
  
  public CTAudioFile addNewAudioFile() {
    synchronized (monitor()) {
      check_orphaned();
      CTAudioFile cTAudioFile = null;
      cTAudioFile = (CTAudioFile)get_store().add_element_user(AUDIOFILE$6);
      return cTAudioFile;
    } 
  }
  
  public void unsetAudioFile() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AUDIOFILE$6, 0);
    } 
  }
  
  public CTVideoFile getVideoFile() {
    synchronized (monitor()) {
      check_orphaned();
      CTVideoFile cTVideoFile = null;
      cTVideoFile = (CTVideoFile)get_store().find_element_user(VIDEOFILE$8, 0);
      if (cTVideoFile == null)
        return null; 
      return cTVideoFile;
    } 
  }
  
  public boolean isSetVideoFile() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(VIDEOFILE$8) != 0);
    } 
  }
  
  public void setVideoFile(CTVideoFile paramCTVideoFile) {
    synchronized (monitor()) {
      check_orphaned();
      CTVideoFile cTVideoFile = null;
      cTVideoFile = (CTVideoFile)get_store().find_element_user(VIDEOFILE$8, 0);
      if (cTVideoFile == null)
        cTVideoFile = (CTVideoFile)get_store().add_element_user(VIDEOFILE$8); 
      cTVideoFile.set((XmlObject)paramCTVideoFile);
    } 
  }
  
  public CTVideoFile addNewVideoFile() {
    synchronized (monitor()) {
      check_orphaned();
      CTVideoFile cTVideoFile = null;
      cTVideoFile = (CTVideoFile)get_store().add_element_user(VIDEOFILE$8);
      return cTVideoFile;
    } 
  }
  
  public void unsetVideoFile() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VIDEOFILE$8, 0);
    } 
  }
  
  public CTQuickTimeFile getQuickTimeFile() {
    synchronized (monitor()) {
      check_orphaned();
      CTQuickTimeFile cTQuickTimeFile = null;
      cTQuickTimeFile = (CTQuickTimeFile)get_store().find_element_user(QUICKTIMEFILE$10, 0);
      if (cTQuickTimeFile == null)
        return null; 
      return cTQuickTimeFile;
    } 
  }
  
  public boolean isSetQuickTimeFile() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(QUICKTIMEFILE$10) != 0);
    } 
  }
  
  public void setQuickTimeFile(CTQuickTimeFile paramCTQuickTimeFile) {
    synchronized (monitor()) {
      check_orphaned();
      CTQuickTimeFile cTQuickTimeFile = null;
      cTQuickTimeFile = (CTQuickTimeFile)get_store().find_element_user(QUICKTIMEFILE$10, 0);
      if (cTQuickTimeFile == null)
        cTQuickTimeFile = (CTQuickTimeFile)get_store().add_element_user(QUICKTIMEFILE$10); 
      cTQuickTimeFile.set((XmlObject)paramCTQuickTimeFile);
    } 
  }
  
  public CTQuickTimeFile addNewQuickTimeFile() {
    synchronized (monitor()) {
      check_orphaned();
      CTQuickTimeFile cTQuickTimeFile = null;
      cTQuickTimeFile = (CTQuickTimeFile)get_store().add_element_user(QUICKTIMEFILE$10);
      return cTQuickTimeFile;
    } 
  }
  
  public void unsetQuickTimeFile() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(QUICKTIMEFILE$10, 0);
    } 
  }
  
  public CTCustomerDataList getCustDataLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomerDataList cTCustomerDataList = null;
      cTCustomerDataList = (CTCustomerDataList)get_store().find_element_user(CUSTDATALST$12, 0);
      if (cTCustomerDataList == null)
        return null; 
      return cTCustomerDataList;
    } 
  }
  
  public boolean isSetCustDataLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CUSTDATALST$12) != 0);
    } 
  }
  
  public void setCustDataLst(CTCustomerDataList paramCTCustomerDataList) {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomerDataList cTCustomerDataList = null;
      cTCustomerDataList = (CTCustomerDataList)get_store().find_element_user(CUSTDATALST$12, 0);
      if (cTCustomerDataList == null)
        cTCustomerDataList = (CTCustomerDataList)get_store().add_element_user(CUSTDATALST$12); 
      cTCustomerDataList.set((XmlObject)paramCTCustomerDataList);
    } 
  }
  
  public CTCustomerDataList addNewCustDataLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomerDataList cTCustomerDataList = null;
      cTCustomerDataList = (CTCustomerDataList)get_store().add_element_user(CUSTDATALST$12);
      return cTCustomerDataList;
    } 
  }
  
  public void unsetCustDataLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTDATALST$12, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$14, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$14) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$14, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$14); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$14);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$14, 0);
    } 
  }
  
  public boolean getIsPhoto() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ISPHOTO$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ISPHOTO$16); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetIsPhoto() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ISPHOTO$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(ISPHOTO$16); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetIsPhoto() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ISPHOTO$16) != null);
    } 
  }
  
  public void setIsPhoto(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ISPHOTO$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ISPHOTO$16); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetIsPhoto(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ISPHOTO$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ISPHOTO$16); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetIsPhoto() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ISPHOTO$16);
    } 
  }
  
  public boolean getUserDrawn() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(USERDRAWN$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(USERDRAWN$18); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetUserDrawn() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(USERDRAWN$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(USERDRAWN$18); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetUserDrawn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(USERDRAWN$18) != null);
    } 
  }
  
  public void setUserDrawn(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(USERDRAWN$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(USERDRAWN$18); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetUserDrawn(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(USERDRAWN$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(USERDRAWN$18); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetUserDrawn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(USERDRAWN$18);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTApplicationNonVisualDrawingPropsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */