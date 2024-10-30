package org.openxmlformats.schemas.officeDocument.x2006.extendedProperties;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctproperties3f10type");
  
  String getTemplate();
  
  XmlString xgetTemplate();
  
  boolean isSetTemplate();
  
  void setTemplate(String paramString);
  
  void xsetTemplate(XmlString paramXmlString);
  
  void unsetTemplate();
  
  String getManager();
  
  XmlString xgetManager();
  
  boolean isSetManager();
  
  void setManager(String paramString);
  
  void xsetManager(XmlString paramXmlString);
  
  void unsetManager();
  
  String getCompany();
  
  XmlString xgetCompany();
  
  boolean isSetCompany();
  
  void setCompany(String paramString);
  
  void xsetCompany(XmlString paramXmlString);
  
  void unsetCompany();
  
  int getPages();
  
  XmlInt xgetPages();
  
  boolean isSetPages();
  
  void setPages(int paramInt);
  
  void xsetPages(XmlInt paramXmlInt);
  
  void unsetPages();
  
  int getWords();
  
  XmlInt xgetWords();
  
  boolean isSetWords();
  
  void setWords(int paramInt);
  
  void xsetWords(XmlInt paramXmlInt);
  
  void unsetWords();
  
  int getCharacters();
  
  XmlInt xgetCharacters();
  
  boolean isSetCharacters();
  
  void setCharacters(int paramInt);
  
  void xsetCharacters(XmlInt paramXmlInt);
  
  void unsetCharacters();
  
  String getPresentationFormat();
  
  XmlString xgetPresentationFormat();
  
  boolean isSetPresentationFormat();
  
  void setPresentationFormat(String paramString);
  
  void xsetPresentationFormat(XmlString paramXmlString);
  
  void unsetPresentationFormat();
  
  int getLines();
  
  XmlInt xgetLines();
  
  boolean isSetLines();
  
  void setLines(int paramInt);
  
  void xsetLines(XmlInt paramXmlInt);
  
  void unsetLines();
  
  int getParagraphs();
  
  XmlInt xgetParagraphs();
  
  boolean isSetParagraphs();
  
  void setParagraphs(int paramInt);
  
  void xsetParagraphs(XmlInt paramXmlInt);
  
  void unsetParagraphs();
  
  int getSlides();
  
  XmlInt xgetSlides();
  
  boolean isSetSlides();
  
  void setSlides(int paramInt);
  
  void xsetSlides(XmlInt paramXmlInt);
  
  void unsetSlides();
  
  int getNotes();
  
  XmlInt xgetNotes();
  
  boolean isSetNotes();
  
  void setNotes(int paramInt);
  
  void xsetNotes(XmlInt paramXmlInt);
  
  void unsetNotes();
  
  int getTotalTime();
  
  XmlInt xgetTotalTime();
  
  boolean isSetTotalTime();
  
  void setTotalTime(int paramInt);
  
  void xsetTotalTime(XmlInt paramXmlInt);
  
  void unsetTotalTime();
  
  int getHiddenSlides();
  
  XmlInt xgetHiddenSlides();
  
  boolean isSetHiddenSlides();
  
  void setHiddenSlides(int paramInt);
  
  void xsetHiddenSlides(XmlInt paramXmlInt);
  
  void unsetHiddenSlides();
  
  int getMMClips();
  
  XmlInt xgetMMClips();
  
  boolean isSetMMClips();
  
  void setMMClips(int paramInt);
  
  void xsetMMClips(XmlInt paramXmlInt);
  
  void unsetMMClips();
  
  boolean getScaleCrop();
  
  XmlBoolean xgetScaleCrop();
  
  boolean isSetScaleCrop();
  
  void setScaleCrop(boolean paramBoolean);
  
  void xsetScaleCrop(XmlBoolean paramXmlBoolean);
  
  void unsetScaleCrop();
  
  CTVectorVariant getHeadingPairs();
  
  boolean isSetHeadingPairs();
  
  void setHeadingPairs(CTVectorVariant paramCTVectorVariant);
  
  CTVectorVariant addNewHeadingPairs();
  
  void unsetHeadingPairs();
  
  CTVectorLpstr getTitlesOfParts();
  
  boolean isSetTitlesOfParts();
  
  void setTitlesOfParts(CTVectorLpstr paramCTVectorLpstr);
  
  CTVectorLpstr addNewTitlesOfParts();
  
  void unsetTitlesOfParts();
  
  boolean getLinksUpToDate();
  
  XmlBoolean xgetLinksUpToDate();
  
  boolean isSetLinksUpToDate();
  
  void setLinksUpToDate(boolean paramBoolean);
  
  void xsetLinksUpToDate(XmlBoolean paramXmlBoolean);
  
  void unsetLinksUpToDate();
  
  int getCharactersWithSpaces();
  
  XmlInt xgetCharactersWithSpaces();
  
  boolean isSetCharactersWithSpaces();
  
  void setCharactersWithSpaces(int paramInt);
  
  void xsetCharactersWithSpaces(XmlInt paramXmlInt);
  
  void unsetCharactersWithSpaces();
  
  boolean getSharedDoc();
  
  XmlBoolean xgetSharedDoc();
  
  boolean isSetSharedDoc();
  
  void setSharedDoc(boolean paramBoolean);
  
  void xsetSharedDoc(XmlBoolean paramXmlBoolean);
  
  void unsetSharedDoc();
  
  String getHyperlinkBase();
  
  XmlString xgetHyperlinkBase();
  
  boolean isSetHyperlinkBase();
  
  void setHyperlinkBase(String paramString);
  
  void xsetHyperlinkBase(XmlString paramXmlString);
  
  void unsetHyperlinkBase();
  
  CTVectorVariant getHLinks();
  
  boolean isSetHLinks();
  
  void setHLinks(CTVectorVariant paramCTVectorVariant);
  
  CTVectorVariant addNewHLinks();
  
  void unsetHLinks();
  
  boolean getHyperlinksChanged();
  
  XmlBoolean xgetHyperlinksChanged();
  
  boolean isSetHyperlinksChanged();
  
  void setHyperlinksChanged(boolean paramBoolean);
  
  void xsetHyperlinksChanged(XmlBoolean paramXmlBoolean);
  
  void unsetHyperlinksChanged();
  
  CTDigSigBlob getDigSig();
  
  boolean isSetDigSig();
  
  void setDigSig(CTDigSigBlob paramCTDigSigBlob);
  
  CTDigSigBlob addNewDigSig();
  
  void unsetDigSig();
  
  String getApplication();
  
  XmlString xgetApplication();
  
  boolean isSetApplication();
  
  void setApplication(String paramString);
  
  void xsetApplication(XmlString paramXmlString);
  
  void unsetApplication();
  
  String getAppVersion();
  
  XmlString xgetAppVersion();
  
  boolean isSetAppVersion();
  
  void setAppVersion(String paramString);
  
  void xsetAppVersion(XmlString paramXmlString);
  
  void unsetAppVersion();
  
  int getDocSecurity();
  
  XmlInt xgetDocSecurity();
  
  boolean isSetDocSecurity();
  
  void setDocSecurity(int paramInt);
  
  void xsetDocSecurity(XmlInt paramXmlInt);
  
  void unsetDocSecurity();
  
  public static final class Factory {
    public static CTProperties newInstance() {
      return (CTProperties)POIXMLTypeLoader.newInstance(CTProperties.type, null);
    }
    
    public static CTProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTProperties)POIXMLTypeLoader.newInstance(CTProperties.type, param1XmlOptions);
    }
    
    public static CTProperties parse(String param1String) throws XmlException {
      return (CTProperties)POIXMLTypeLoader.parse(param1String, CTProperties.type, null);
    }
    
    public static CTProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTProperties)POIXMLTypeLoader.parse(param1String, CTProperties.type, param1XmlOptions);
    }
    
    public static CTProperties parse(File param1File) throws XmlException, IOException {
      return (CTProperties)POIXMLTypeLoader.parse(param1File, CTProperties.type, null);
    }
    
    public static CTProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTProperties)POIXMLTypeLoader.parse(param1File, CTProperties.type, param1XmlOptions);
    }
    
    public static CTProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTProperties)POIXMLTypeLoader.parse(param1URL, CTProperties.type, null);
    }
    
    public static CTProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTProperties)POIXMLTypeLoader.parse(param1URL, CTProperties.type, param1XmlOptions);
    }
    
    public static CTProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTProperties)POIXMLTypeLoader.parse(param1InputStream, CTProperties.type, null);
    }
    
    public static CTProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTProperties)POIXMLTypeLoader.parse(param1InputStream, CTProperties.type, param1XmlOptions);
    }
    
    public static CTProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTProperties)POIXMLTypeLoader.parse(param1Reader, CTProperties.type, null);
    }
    
    public static CTProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTProperties)POIXMLTypeLoader.parse(param1Reader, CTProperties.type, param1XmlOptions);
    }
    
    public static CTProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTProperties.type, null);
    }
    
    public static CTProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTProperties.type, param1XmlOptions);
    }
    
    public static CTProperties parse(Node param1Node) throws XmlException {
      return (CTProperties)POIXMLTypeLoader.parse(param1Node, CTProperties.type, null);
    }
    
    public static CTProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTProperties)POIXMLTypeLoader.parse(param1Node, CTProperties.type, param1XmlOptions);
    }
    
    public static CTProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTProperties.type, null);
    }
    
    public static CTProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\officeDocument\x2006\extendedProperties\CTProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */