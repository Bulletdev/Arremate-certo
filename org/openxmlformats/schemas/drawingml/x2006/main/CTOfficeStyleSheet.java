package org.openxmlformats.schemas.drawingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTOfficeStyleSheet extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTOfficeStyleSheet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctofficestylesheetce25type");
  
  CTBaseStyles getThemeElements();
  
  void setThemeElements(CTBaseStyles paramCTBaseStyles);
  
  CTBaseStyles addNewThemeElements();
  
  CTObjectStyleDefaults getObjectDefaults();
  
  boolean isSetObjectDefaults();
  
  void setObjectDefaults(CTObjectStyleDefaults paramCTObjectStyleDefaults);
  
  CTObjectStyleDefaults addNewObjectDefaults();
  
  void unsetObjectDefaults();
  
  CTColorSchemeList getExtraClrSchemeLst();
  
  boolean isSetExtraClrSchemeLst();
  
  void setExtraClrSchemeLst(CTColorSchemeList paramCTColorSchemeList);
  
  CTColorSchemeList addNewExtraClrSchemeLst();
  
  void unsetExtraClrSchemeLst();
  
  CTCustomColorList getCustClrLst();
  
  boolean isSetCustClrLst();
  
  void setCustClrLst(CTCustomColorList paramCTCustomColorList);
  
  CTCustomColorList addNewCustClrLst();
  
  void unsetCustClrLst();
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  String getName();
  
  XmlString xgetName();
  
  boolean isSetName();
  
  void setName(String paramString);
  
  void xsetName(XmlString paramXmlString);
  
  void unsetName();
  
  public static final class Factory {
    public static CTOfficeStyleSheet newInstance() {
      return (CTOfficeStyleSheet)POIXMLTypeLoader.newInstance(CTOfficeStyleSheet.type, null);
    }
    
    public static CTOfficeStyleSheet newInstance(XmlOptions param1XmlOptions) {
      return (CTOfficeStyleSheet)POIXMLTypeLoader.newInstance(CTOfficeStyleSheet.type, param1XmlOptions);
    }
    
    public static CTOfficeStyleSheet parse(String param1String) throws XmlException {
      return (CTOfficeStyleSheet)POIXMLTypeLoader.parse(param1String, CTOfficeStyleSheet.type, null);
    }
    
    public static CTOfficeStyleSheet parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOfficeStyleSheet)POIXMLTypeLoader.parse(param1String, CTOfficeStyleSheet.type, param1XmlOptions);
    }
    
    public static CTOfficeStyleSheet parse(File param1File) throws XmlException, IOException {
      return (CTOfficeStyleSheet)POIXMLTypeLoader.parse(param1File, CTOfficeStyleSheet.type, null);
    }
    
    public static CTOfficeStyleSheet parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOfficeStyleSheet)POIXMLTypeLoader.parse(param1File, CTOfficeStyleSheet.type, param1XmlOptions);
    }
    
    public static CTOfficeStyleSheet parse(URL param1URL) throws XmlException, IOException {
      return (CTOfficeStyleSheet)POIXMLTypeLoader.parse(param1URL, CTOfficeStyleSheet.type, null);
    }
    
    public static CTOfficeStyleSheet parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOfficeStyleSheet)POIXMLTypeLoader.parse(param1URL, CTOfficeStyleSheet.type, param1XmlOptions);
    }
    
    public static CTOfficeStyleSheet parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTOfficeStyleSheet)POIXMLTypeLoader.parse(param1InputStream, CTOfficeStyleSheet.type, null);
    }
    
    public static CTOfficeStyleSheet parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOfficeStyleSheet)POIXMLTypeLoader.parse(param1InputStream, CTOfficeStyleSheet.type, param1XmlOptions);
    }
    
    public static CTOfficeStyleSheet parse(Reader param1Reader) throws XmlException, IOException {
      return (CTOfficeStyleSheet)POIXMLTypeLoader.parse(param1Reader, CTOfficeStyleSheet.type, null);
    }
    
    public static CTOfficeStyleSheet parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOfficeStyleSheet)POIXMLTypeLoader.parse(param1Reader, CTOfficeStyleSheet.type, param1XmlOptions);
    }
    
    public static CTOfficeStyleSheet parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTOfficeStyleSheet)POIXMLTypeLoader.parse(param1XMLStreamReader, CTOfficeStyleSheet.type, null);
    }
    
    public static CTOfficeStyleSheet parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOfficeStyleSheet)POIXMLTypeLoader.parse(param1XMLStreamReader, CTOfficeStyleSheet.type, param1XmlOptions);
    }
    
    public static CTOfficeStyleSheet parse(Node param1Node) throws XmlException {
      return (CTOfficeStyleSheet)POIXMLTypeLoader.parse(param1Node, CTOfficeStyleSheet.type, null);
    }
    
    public static CTOfficeStyleSheet parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOfficeStyleSheet)POIXMLTypeLoader.parse(param1Node, CTOfficeStyleSheet.type, param1XmlOptions);
    }
    
    public static CTOfficeStyleSheet parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTOfficeStyleSheet)POIXMLTypeLoader.parse(param1XMLInputStream, CTOfficeStyleSheet.type, null);
    }
    
    public static CTOfficeStyleSheet parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTOfficeStyleSheet)POIXMLTypeLoader.parse(param1XMLInputStream, CTOfficeStyleSheet.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTOfficeStyleSheet.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTOfficeStyleSheet.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTOfficeStyleSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */