package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEmbeddedWAVAudioFile;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;

public class CTHyperlinkImpl extends XmlComplexContentImpl implements CTHyperlink {
  private static final b SND$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "snd");
  
  private static final b EXTLST$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  private static final b ID$4 = new b("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "id");
  
  private static final b INVALIDURL$6 = new b("", "invalidUrl");
  
  private static final b ACTION$8 = new b("", "action");
  
  private static final b TGTFRAME$10 = new b("", "tgtFrame");
  
  private static final b TOOLTIP$12 = new b("", "tooltip");
  
  private static final b HISTORY$14 = new b("", "history");
  
  private static final b HIGHLIGHTCLICK$16 = new b("", "highlightClick");
  
  private static final b ENDSND$18 = new b("", "endSnd");
  
  public CTHyperlinkImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTEmbeddedWAVAudioFile getSnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFile = null;
      cTEmbeddedWAVAudioFile = (CTEmbeddedWAVAudioFile)get_store().find_element_user(SND$0, 0);
      if (cTEmbeddedWAVAudioFile == null)
        return null; 
      return cTEmbeddedWAVAudioFile;
    } 
  }
  
  public boolean isSetSnd() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SND$0) != 0);
    } 
  }
  
  public void setSnd(CTEmbeddedWAVAudioFile paramCTEmbeddedWAVAudioFile) {
    synchronized (monitor()) {
      check_orphaned();
      CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFile = null;
      cTEmbeddedWAVAudioFile = (CTEmbeddedWAVAudioFile)get_store().find_element_user(SND$0, 0);
      if (cTEmbeddedWAVAudioFile == null)
        cTEmbeddedWAVAudioFile = (CTEmbeddedWAVAudioFile)get_store().add_element_user(SND$0); 
      cTEmbeddedWAVAudioFile.set((XmlObject)paramCTEmbeddedWAVAudioFile);
    } 
  }
  
  public CTEmbeddedWAVAudioFile addNewSnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFile = null;
      cTEmbeddedWAVAudioFile = (CTEmbeddedWAVAudioFile)get_store().add_element_user(SND$0);
      return cTEmbeddedWAVAudioFile;
    } 
  }
  
  public void unsetSnd() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SND$0, 0);
    } 
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$2, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$2) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$2, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$2); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$2);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$2, 0);
    } 
  }
  
  public String getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STRelationshipId xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(ID$4);
      return sTRelationshipId;
    } 
  }
  
  public boolean isSetId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ID$4) != null);
    } 
  }
  
  public void setId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetId(STRelationshipId paramSTRelationshipId) {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(ID$4);
      if (sTRelationshipId == null)
        sTRelationshipId = (STRelationshipId)get_store().add_attribute_user(ID$4); 
      sTRelationshipId.set((XmlObject)paramSTRelationshipId);
    } 
  }
  
  public void unsetId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ID$4);
    } 
  }
  
  public String getInvalidUrl() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INVALIDURL$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(INVALIDURL$6); 
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetInvalidUrl() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(INVALIDURL$6);
      if (xmlString == null)
        xmlString = (XmlString)get_default_attribute_value(INVALIDURL$6); 
      return xmlString;
    } 
  }
  
  public boolean isSetInvalidUrl() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(INVALIDURL$6) != null);
    } 
  }
  
  public void setInvalidUrl(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INVALIDURL$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INVALIDURL$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetInvalidUrl(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(INVALIDURL$6);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(INVALIDURL$6); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetInvalidUrl() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(INVALIDURL$6);
    } 
  }
  
  public String getAction() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACTION$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ACTION$8); 
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetAction() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ACTION$8);
      if (xmlString == null)
        xmlString = (XmlString)get_default_attribute_value(ACTION$8); 
      return xmlString;
    } 
  }
  
  public boolean isSetAction() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ACTION$8) != null);
    } 
  }
  
  public void setAction(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACTION$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ACTION$8); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetAction(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(ACTION$8);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(ACTION$8); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetAction() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ACTION$8);
    } 
  }
  
  public String getTgtFrame() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TGTFRAME$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(TGTFRAME$10); 
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetTgtFrame() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TGTFRAME$10);
      if (xmlString == null)
        xmlString = (XmlString)get_default_attribute_value(TGTFRAME$10); 
      return xmlString;
    } 
  }
  
  public boolean isSetTgtFrame() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TGTFRAME$10) != null);
    } 
  }
  
  public void setTgtFrame(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TGTFRAME$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TGTFRAME$10); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTgtFrame(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TGTFRAME$10);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(TGTFRAME$10); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetTgtFrame() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TGTFRAME$10);
    } 
  }
  
  public String getTooltip() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOOLTIP$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(TOOLTIP$12); 
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetTooltip() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TOOLTIP$12);
      if (xmlString == null)
        xmlString = (XmlString)get_default_attribute_value(TOOLTIP$12); 
      return xmlString;
    } 
  }
  
  public boolean isSetTooltip() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TOOLTIP$12) != null);
    } 
  }
  
  public void setTooltip(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOOLTIP$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TOOLTIP$12); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTooltip(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(TOOLTIP$12);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(TOOLTIP$12); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetTooltip() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TOOLTIP$12);
    } 
  }
  
  public boolean getHistory() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HISTORY$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(HISTORY$14); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetHistory() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HISTORY$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(HISTORY$14); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetHistory() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HISTORY$14) != null);
    } 
  }
  
  public void setHistory(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HISTORY$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HISTORY$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetHistory(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HISTORY$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(HISTORY$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetHistory() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HISTORY$14);
    } 
  }
  
  public boolean getHighlightClick() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIGHLIGHTCLICK$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(HIGHLIGHTCLICK$16); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetHighlightClick() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HIGHLIGHTCLICK$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(HIGHLIGHTCLICK$16); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetHighlightClick() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HIGHLIGHTCLICK$16) != null);
    } 
  }
  
  public void setHighlightClick(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIGHLIGHTCLICK$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HIGHLIGHTCLICK$16); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetHighlightClick(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HIGHLIGHTCLICK$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(HIGHLIGHTCLICK$16); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetHighlightClick() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HIGHLIGHTCLICK$16);
    } 
  }
  
  public boolean getEndSnd() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENDSND$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ENDSND$18); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetEndSnd() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ENDSND$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(ENDSND$18); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetEndSnd() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ENDSND$18) != null);
    } 
  }
  
  public void setEndSnd(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENDSND$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ENDSND$18); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetEndSnd(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ENDSND$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ENDSND$18); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetEndSnd() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ENDSND$18);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTHyperlinkImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */