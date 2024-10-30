package org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTDigSigBlob;
import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties;
import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTVectorLpstr;
import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTVectorVariant;

public class CTPropertiesImpl extends XmlComplexContentImpl implements CTProperties {
  private static final b TEMPLATE$0 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "Template");
  
  private static final b MANAGER$2 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "Manager");
  
  private static final b COMPANY$4 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "Company");
  
  private static final b PAGES$6 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "Pages");
  
  private static final b WORDS$8 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "Words");
  
  private static final b CHARACTERS$10 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "Characters");
  
  private static final b PRESENTATIONFORMAT$12 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "PresentationFormat");
  
  private static final b LINES$14 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "Lines");
  
  private static final b PARAGRAPHS$16 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "Paragraphs");
  
  private static final b SLIDES$18 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "Slides");
  
  private static final b NOTES$20 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "Notes");
  
  private static final b TOTALTIME$22 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "TotalTime");
  
  private static final b HIDDENSLIDES$24 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "HiddenSlides");
  
  private static final b MMCLIPS$26 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "MMClips");
  
  private static final b SCALECROP$28 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "ScaleCrop");
  
  private static final b HEADINGPAIRS$30 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "HeadingPairs");
  
  private static final b TITLESOFPARTS$32 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "TitlesOfParts");
  
  private static final b LINKSUPTODATE$34 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "LinksUpToDate");
  
  private static final b CHARACTERSWITHSPACES$36 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "CharactersWithSpaces");
  
  private static final b SHAREDDOC$38 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "SharedDoc");
  
  private static final b HYPERLINKBASE$40 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "HyperlinkBase");
  
  private static final b HLINKS$42 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "HLinks");
  
  private static final b HYPERLINKSCHANGED$44 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "HyperlinksChanged");
  
  private static final b DIGSIG$46 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "DigSig");
  
  private static final b APPLICATION$48 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "Application");
  
  private static final b APPVERSION$50 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "AppVersion");
  
  private static final b DOCSECURITY$52 = new b("http://schemas.openxmlformats.org/officeDocument/2006/extended-properties", "DocSecurity");
  
  public CTPropertiesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getTemplate() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(TEMPLATE$0, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetTemplate() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(TEMPLATE$0, 0);
      return xmlString;
    } 
  }
  
  public boolean isSetTemplate() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TEMPLATE$0) != 0);
    } 
  }
  
  public void setTemplate(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(TEMPLATE$0, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(TEMPLATE$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTemplate(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(TEMPLATE$0, 0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_element_user(TEMPLATE$0); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetTemplate() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TEMPLATE$0, 0);
    } 
  }
  
  public String getManager() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(MANAGER$2, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetManager() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(MANAGER$2, 0);
      return xmlString;
    } 
  }
  
  public boolean isSetManager() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MANAGER$2) != 0);
    } 
  }
  
  public void setManager(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(MANAGER$2, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(MANAGER$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetManager(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(MANAGER$2, 0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_element_user(MANAGER$2); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetManager() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MANAGER$2, 0);
    } 
  }
  
  public String getCompany() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(COMPANY$4, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetCompany() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(COMPANY$4, 0);
      return xmlString;
    } 
  }
  
  public boolean isSetCompany() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(COMPANY$4) != 0);
    } 
  }
  
  public void setCompany(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(COMPANY$4, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(COMPANY$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetCompany(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(COMPANY$4, 0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_element_user(COMPANY$4); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetCompany() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COMPANY$4, 0);
    } 
  }
  
  public int getPages() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(PAGES$6, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetPages() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(PAGES$6, 0);
      return xmlInt;
    } 
  }
  
  public boolean isSetPages() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PAGES$6) != 0);
    } 
  }
  
  public void setPages(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(PAGES$6, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(PAGES$6); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetPages(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(PAGES$6, 0);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_element_user(PAGES$6); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetPages() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PAGES$6, 0);
    } 
  }
  
  public int getWords() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(WORDS$8, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetWords() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(WORDS$8, 0);
      return xmlInt;
    } 
  }
  
  public boolean isSetWords() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(WORDS$8) != 0);
    } 
  }
  
  public void setWords(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(WORDS$8, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(WORDS$8); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetWords(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(WORDS$8, 0);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_element_user(WORDS$8); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetWords() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WORDS$8, 0);
    } 
  }
  
  public int getCharacters() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(CHARACTERS$10, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetCharacters() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(CHARACTERS$10, 0);
      return xmlInt;
    } 
  }
  
  public boolean isSetCharacters() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CHARACTERS$10) != 0);
    } 
  }
  
  public void setCharacters(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(CHARACTERS$10, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(CHARACTERS$10); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetCharacters(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(CHARACTERS$10, 0);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_element_user(CHARACTERS$10); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetCharacters() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CHARACTERS$10, 0);
    } 
  }
  
  public String getPresentationFormat() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(PRESENTATIONFORMAT$12, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetPresentationFormat() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(PRESENTATIONFORMAT$12, 0);
      return xmlString;
    } 
  }
  
  public boolean isSetPresentationFormat() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PRESENTATIONFORMAT$12) != 0);
    } 
  }
  
  public void setPresentationFormat(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(PRESENTATIONFORMAT$12, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(PRESENTATIONFORMAT$12); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetPresentationFormat(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(PRESENTATIONFORMAT$12, 0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_element_user(PRESENTATIONFORMAT$12); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetPresentationFormat() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PRESENTATIONFORMAT$12, 0);
    } 
  }
  
  public int getLines() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(LINES$14, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetLines() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(LINES$14, 0);
      return xmlInt;
    } 
  }
  
  public boolean isSetLines() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LINES$14) != 0);
    } 
  }
  
  public void setLines(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(LINES$14, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(LINES$14); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetLines(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(LINES$14, 0);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_element_user(LINES$14); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetLines() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LINES$14, 0);
    } 
  }
  
  public int getParagraphs() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(PARAGRAPHS$16, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetParagraphs() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(PARAGRAPHS$16, 0);
      return xmlInt;
    } 
  }
  
  public boolean isSetParagraphs() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PARAGRAPHS$16) != 0);
    } 
  }
  
  public void setParagraphs(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(PARAGRAPHS$16, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(PARAGRAPHS$16); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetParagraphs(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(PARAGRAPHS$16, 0);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_element_user(PARAGRAPHS$16); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetParagraphs() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PARAGRAPHS$16, 0);
    } 
  }
  
  public int getSlides() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SLIDES$18, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetSlides() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(SLIDES$18, 0);
      return xmlInt;
    } 
  }
  
  public boolean isSetSlides() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SLIDES$18) != 0);
    } 
  }
  
  public void setSlides(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SLIDES$18, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(SLIDES$18); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetSlides(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(SLIDES$18, 0);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_element_user(SLIDES$18); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetSlides() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SLIDES$18, 0);
    } 
  }
  
  public int getNotes() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(NOTES$20, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetNotes() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(NOTES$20, 0);
      return xmlInt;
    } 
  }
  
  public boolean isSetNotes() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NOTES$20) != 0);
    } 
  }
  
  public void setNotes(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(NOTES$20, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(NOTES$20); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetNotes(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(NOTES$20, 0);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_element_user(NOTES$20); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetNotes() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NOTES$20, 0);
    } 
  }
  
  public int getTotalTime() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(TOTALTIME$22, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetTotalTime() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(TOTALTIME$22, 0);
      return xmlInt;
    } 
  }
  
  public boolean isSetTotalTime() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TOTALTIME$22) != 0);
    } 
  }
  
  public void setTotalTime(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(TOTALTIME$22, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(TOTALTIME$22); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetTotalTime(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(TOTALTIME$22, 0);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_element_user(TOTALTIME$22); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetTotalTime() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TOTALTIME$22, 0);
    } 
  }
  
  public int getHiddenSlides() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(HIDDENSLIDES$24, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetHiddenSlides() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(HIDDENSLIDES$24, 0);
      return xmlInt;
    } 
  }
  
  public boolean isSetHiddenSlides() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HIDDENSLIDES$24) != 0);
    } 
  }
  
  public void setHiddenSlides(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(HIDDENSLIDES$24, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(HIDDENSLIDES$24); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetHiddenSlides(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(HIDDENSLIDES$24, 0);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_element_user(HIDDENSLIDES$24); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetHiddenSlides() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HIDDENSLIDES$24, 0);
    } 
  }
  
  public int getMMClips() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(MMCLIPS$26, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetMMClips() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(MMCLIPS$26, 0);
      return xmlInt;
    } 
  }
  
  public boolean isSetMMClips() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MMCLIPS$26) != 0);
    } 
  }
  
  public void setMMClips(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(MMCLIPS$26, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(MMCLIPS$26); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetMMClips(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(MMCLIPS$26, 0);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_element_user(MMCLIPS$26); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetMMClips() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MMCLIPS$26, 0);
    } 
  }
  
  public boolean getScaleCrop() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SCALECROP$28, 0);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetScaleCrop() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_element_user(SCALECROP$28, 0);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetScaleCrop() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SCALECROP$28) != 0);
    } 
  }
  
  public void setScaleCrop(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SCALECROP$28, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(SCALECROP$28); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetScaleCrop(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_element_user(SCALECROP$28, 0);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_element_user(SCALECROP$28); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetScaleCrop() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SCALECROP$28, 0);
    } 
  }
  
  public CTVectorVariant getHeadingPairs() {
    synchronized (monitor()) {
      check_orphaned();
      CTVectorVariant cTVectorVariant = null;
      cTVectorVariant = (CTVectorVariant)get_store().find_element_user(HEADINGPAIRS$30, 0);
      if (cTVectorVariant == null)
        return null; 
      return cTVectorVariant;
    } 
  }
  
  public boolean isSetHeadingPairs() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HEADINGPAIRS$30) != 0);
    } 
  }
  
  public void setHeadingPairs(CTVectorVariant paramCTVectorVariant) {
    synchronized (monitor()) {
      check_orphaned();
      CTVectorVariant cTVectorVariant = null;
      cTVectorVariant = (CTVectorVariant)get_store().find_element_user(HEADINGPAIRS$30, 0);
      if (cTVectorVariant == null)
        cTVectorVariant = (CTVectorVariant)get_store().add_element_user(HEADINGPAIRS$30); 
      cTVectorVariant.set((XmlObject)paramCTVectorVariant);
    } 
  }
  
  public CTVectorVariant addNewHeadingPairs() {
    synchronized (monitor()) {
      check_orphaned();
      CTVectorVariant cTVectorVariant = null;
      cTVectorVariant = (CTVectorVariant)get_store().add_element_user(HEADINGPAIRS$30);
      return cTVectorVariant;
    } 
  }
  
  public void unsetHeadingPairs() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HEADINGPAIRS$30, 0);
    } 
  }
  
  public CTVectorLpstr getTitlesOfParts() {
    synchronized (monitor()) {
      check_orphaned();
      CTVectorLpstr cTVectorLpstr = null;
      cTVectorLpstr = (CTVectorLpstr)get_store().find_element_user(TITLESOFPARTS$32, 0);
      if (cTVectorLpstr == null)
        return null; 
      return cTVectorLpstr;
    } 
  }
  
  public boolean isSetTitlesOfParts() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TITLESOFPARTS$32) != 0);
    } 
  }
  
  public void setTitlesOfParts(CTVectorLpstr paramCTVectorLpstr) {
    synchronized (monitor()) {
      check_orphaned();
      CTVectorLpstr cTVectorLpstr = null;
      cTVectorLpstr = (CTVectorLpstr)get_store().find_element_user(TITLESOFPARTS$32, 0);
      if (cTVectorLpstr == null)
        cTVectorLpstr = (CTVectorLpstr)get_store().add_element_user(TITLESOFPARTS$32); 
      cTVectorLpstr.set((XmlObject)paramCTVectorLpstr);
    } 
  }
  
  public CTVectorLpstr addNewTitlesOfParts() {
    synchronized (monitor()) {
      check_orphaned();
      CTVectorLpstr cTVectorLpstr = null;
      cTVectorLpstr = (CTVectorLpstr)get_store().add_element_user(TITLESOFPARTS$32);
      return cTVectorLpstr;
    } 
  }
  
  public void unsetTitlesOfParts() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TITLESOFPARTS$32, 0);
    } 
  }
  
  public boolean getLinksUpToDate() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(LINKSUPTODATE$34, 0);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetLinksUpToDate() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_element_user(LINKSUPTODATE$34, 0);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetLinksUpToDate() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LINKSUPTODATE$34) != 0);
    } 
  }
  
  public void setLinksUpToDate(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(LINKSUPTODATE$34, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(LINKSUPTODATE$34); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetLinksUpToDate(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_element_user(LINKSUPTODATE$34, 0);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_element_user(LINKSUPTODATE$34); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetLinksUpToDate() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LINKSUPTODATE$34, 0);
    } 
  }
  
  public int getCharactersWithSpaces() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(CHARACTERSWITHSPACES$36, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetCharactersWithSpaces() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(CHARACTERSWITHSPACES$36, 0);
      return xmlInt;
    } 
  }
  
  public boolean isSetCharactersWithSpaces() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CHARACTERSWITHSPACES$36) != 0);
    } 
  }
  
  public void setCharactersWithSpaces(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(CHARACTERSWITHSPACES$36, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(CHARACTERSWITHSPACES$36); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetCharactersWithSpaces(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(CHARACTERSWITHSPACES$36, 0);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_element_user(CHARACTERSWITHSPACES$36); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetCharactersWithSpaces() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CHARACTERSWITHSPACES$36, 0);
    } 
  }
  
  public boolean getSharedDoc() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SHAREDDOC$38, 0);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetSharedDoc() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_element_user(SHAREDDOC$38, 0);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetSharedDoc() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHAREDDOC$38) != 0);
    } 
  }
  
  public void setSharedDoc(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SHAREDDOC$38, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(SHAREDDOC$38); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetSharedDoc(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_element_user(SHAREDDOC$38, 0);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_element_user(SHAREDDOC$38); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetSharedDoc() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHAREDDOC$38, 0);
    } 
  }
  
  public String getHyperlinkBase() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(HYPERLINKBASE$40, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetHyperlinkBase() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(HYPERLINKBASE$40, 0);
      return xmlString;
    } 
  }
  
  public boolean isSetHyperlinkBase() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HYPERLINKBASE$40) != 0);
    } 
  }
  
  public void setHyperlinkBase(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(HYPERLINKBASE$40, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(HYPERLINKBASE$40); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetHyperlinkBase(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(HYPERLINKBASE$40, 0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_element_user(HYPERLINKBASE$40); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetHyperlinkBase() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HYPERLINKBASE$40, 0);
    } 
  }
  
  public CTVectorVariant getHLinks() {
    synchronized (monitor()) {
      check_orphaned();
      CTVectorVariant cTVectorVariant = null;
      cTVectorVariant = (CTVectorVariant)get_store().find_element_user(HLINKS$42, 0);
      if (cTVectorVariant == null)
        return null; 
      return cTVectorVariant;
    } 
  }
  
  public boolean isSetHLinks() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HLINKS$42) != 0);
    } 
  }
  
  public void setHLinks(CTVectorVariant paramCTVectorVariant) {
    synchronized (monitor()) {
      check_orphaned();
      CTVectorVariant cTVectorVariant = null;
      cTVectorVariant = (CTVectorVariant)get_store().find_element_user(HLINKS$42, 0);
      if (cTVectorVariant == null)
        cTVectorVariant = (CTVectorVariant)get_store().add_element_user(HLINKS$42); 
      cTVectorVariant.set((XmlObject)paramCTVectorVariant);
    } 
  }
  
  public CTVectorVariant addNewHLinks() {
    synchronized (monitor()) {
      check_orphaned();
      CTVectorVariant cTVectorVariant = null;
      cTVectorVariant = (CTVectorVariant)get_store().add_element_user(HLINKS$42);
      return cTVectorVariant;
    } 
  }
  
  public void unsetHLinks() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HLINKS$42, 0);
    } 
  }
  
  public boolean getHyperlinksChanged() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(HYPERLINKSCHANGED$44, 0);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetHyperlinksChanged() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_element_user(HYPERLINKSCHANGED$44, 0);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetHyperlinksChanged() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HYPERLINKSCHANGED$44) != 0);
    } 
  }
  
  public void setHyperlinksChanged(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(HYPERLINKSCHANGED$44, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(HYPERLINKSCHANGED$44); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetHyperlinksChanged(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_element_user(HYPERLINKSCHANGED$44, 0);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_element_user(HYPERLINKSCHANGED$44); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetHyperlinksChanged() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HYPERLINKSCHANGED$44, 0);
    } 
  }
  
  public CTDigSigBlob getDigSig() {
    synchronized (monitor()) {
      check_orphaned();
      CTDigSigBlob cTDigSigBlob = null;
      cTDigSigBlob = (CTDigSigBlob)get_store().find_element_user(DIGSIG$46, 0);
      if (cTDigSigBlob == null)
        return null; 
      return cTDigSigBlob;
    } 
  }
  
  public boolean isSetDigSig() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DIGSIG$46) != 0);
    } 
  }
  
  public void setDigSig(CTDigSigBlob paramCTDigSigBlob) {
    synchronized (monitor()) {
      check_orphaned();
      CTDigSigBlob cTDigSigBlob = null;
      cTDigSigBlob = (CTDigSigBlob)get_store().find_element_user(DIGSIG$46, 0);
      if (cTDigSigBlob == null)
        cTDigSigBlob = (CTDigSigBlob)get_store().add_element_user(DIGSIG$46); 
      cTDigSigBlob.set((XmlObject)paramCTDigSigBlob);
    } 
  }
  
  public CTDigSigBlob addNewDigSig() {
    synchronized (monitor()) {
      check_orphaned();
      CTDigSigBlob cTDigSigBlob = null;
      cTDigSigBlob = (CTDigSigBlob)get_store().add_element_user(DIGSIG$46);
      return cTDigSigBlob;
    } 
  }
  
  public void unsetDigSig() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DIGSIG$46, 0);
    } 
  }
  
  public String getApplication() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(APPLICATION$48, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetApplication() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(APPLICATION$48, 0);
      return xmlString;
    } 
  }
  
  public boolean isSetApplication() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(APPLICATION$48) != 0);
    } 
  }
  
  public void setApplication(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(APPLICATION$48, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(APPLICATION$48); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetApplication(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(APPLICATION$48, 0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_element_user(APPLICATION$48); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetApplication() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(APPLICATION$48, 0);
    } 
  }
  
  public String getAppVersion() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(APPVERSION$50, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetAppVersion() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(APPVERSION$50, 0);
      return xmlString;
    } 
  }
  
  public boolean isSetAppVersion() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(APPVERSION$50) != 0);
    } 
  }
  
  public void setAppVersion(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(APPVERSION$50, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(APPVERSION$50); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetAppVersion(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(APPVERSION$50, 0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_element_user(APPVERSION$50); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetAppVersion() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(APPVERSION$50, 0);
    } 
  }
  
  public int getDocSecurity() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DOCSECURITY$52, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetDocSecurity() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(DOCSECURITY$52, 0);
      return xmlInt;
    } 
  }
  
  public boolean isSetDocSecurity() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DOCSECURITY$52) != 0);
    } 
  }
  
  public void setDocSecurity(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DOCSECURITY$52, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(DOCSECURITY$52); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetDocSecurity(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(DOCSECURITY$52, 0);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_element_user(DOCSECURITY$52); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetDocSecurity() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DOCSECURITY$52, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\officeDocument\x2006\extendedProperties\impl\CTPropertiesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */