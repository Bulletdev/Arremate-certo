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

public interface CTColorScheme extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTColorScheme.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcolorscheme0e99type");
  
  CTColor getDk1();
  
  void setDk1(CTColor paramCTColor);
  
  CTColor addNewDk1();
  
  CTColor getLt1();
  
  void setLt1(CTColor paramCTColor);
  
  CTColor addNewLt1();
  
  CTColor getDk2();
  
  void setDk2(CTColor paramCTColor);
  
  CTColor addNewDk2();
  
  CTColor getLt2();
  
  void setLt2(CTColor paramCTColor);
  
  CTColor addNewLt2();
  
  CTColor getAccent1();
  
  void setAccent1(CTColor paramCTColor);
  
  CTColor addNewAccent1();
  
  CTColor getAccent2();
  
  void setAccent2(CTColor paramCTColor);
  
  CTColor addNewAccent2();
  
  CTColor getAccent3();
  
  void setAccent3(CTColor paramCTColor);
  
  CTColor addNewAccent3();
  
  CTColor getAccent4();
  
  void setAccent4(CTColor paramCTColor);
  
  CTColor addNewAccent4();
  
  CTColor getAccent5();
  
  void setAccent5(CTColor paramCTColor);
  
  CTColor addNewAccent5();
  
  CTColor getAccent6();
  
  void setAccent6(CTColor paramCTColor);
  
  CTColor addNewAccent6();
  
  CTColor getHlink();
  
  void setHlink(CTColor paramCTColor);
  
  CTColor addNewHlink();
  
  CTColor getFolHlink();
  
  void setFolHlink(CTColor paramCTColor);
  
  CTColor addNewFolHlink();
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  String getName();
  
  XmlString xgetName();
  
  void setName(String paramString);
  
  void xsetName(XmlString paramXmlString);
  
  public static final class Factory {
    public static CTColorScheme newInstance() {
      return (CTColorScheme)POIXMLTypeLoader.newInstance(CTColorScheme.type, null);
    }
    
    public static CTColorScheme newInstance(XmlOptions param1XmlOptions) {
      return (CTColorScheme)POIXMLTypeLoader.newInstance(CTColorScheme.type, param1XmlOptions);
    }
    
    public static CTColorScheme parse(String param1String) throws XmlException {
      return (CTColorScheme)POIXMLTypeLoader.parse(param1String, CTColorScheme.type, null);
    }
    
    public static CTColorScheme parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTColorScheme)POIXMLTypeLoader.parse(param1String, CTColorScheme.type, param1XmlOptions);
    }
    
    public static CTColorScheme parse(File param1File) throws XmlException, IOException {
      return (CTColorScheme)POIXMLTypeLoader.parse(param1File, CTColorScheme.type, null);
    }
    
    public static CTColorScheme parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColorScheme)POIXMLTypeLoader.parse(param1File, CTColorScheme.type, param1XmlOptions);
    }
    
    public static CTColorScheme parse(URL param1URL) throws XmlException, IOException {
      return (CTColorScheme)POIXMLTypeLoader.parse(param1URL, CTColorScheme.type, null);
    }
    
    public static CTColorScheme parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColorScheme)POIXMLTypeLoader.parse(param1URL, CTColorScheme.type, param1XmlOptions);
    }
    
    public static CTColorScheme parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTColorScheme)POIXMLTypeLoader.parse(param1InputStream, CTColorScheme.type, null);
    }
    
    public static CTColorScheme parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColorScheme)POIXMLTypeLoader.parse(param1InputStream, CTColorScheme.type, param1XmlOptions);
    }
    
    public static CTColorScheme parse(Reader param1Reader) throws XmlException, IOException {
      return (CTColorScheme)POIXMLTypeLoader.parse(param1Reader, CTColorScheme.type, null);
    }
    
    public static CTColorScheme parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTColorScheme)POIXMLTypeLoader.parse(param1Reader, CTColorScheme.type, param1XmlOptions);
    }
    
    public static CTColorScheme parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTColorScheme)POIXMLTypeLoader.parse(param1XMLStreamReader, CTColorScheme.type, null);
    }
    
    public static CTColorScheme parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTColorScheme)POIXMLTypeLoader.parse(param1XMLStreamReader, CTColorScheme.type, param1XmlOptions);
    }
    
    public static CTColorScheme parse(Node param1Node) throws XmlException {
      return (CTColorScheme)POIXMLTypeLoader.parse(param1Node, CTColorScheme.type, null);
    }
    
    public static CTColorScheme parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTColorScheme)POIXMLTypeLoader.parse(param1Node, CTColorScheme.type, param1XmlOptions);
    }
    
    public static CTColorScheme parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTColorScheme)POIXMLTypeLoader.parse(param1XMLInputStream, CTColorScheme.type, null);
    }
    
    public static CTColorScheme parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTColorScheme)POIXMLTypeLoader.parse(param1XMLInputStream, CTColorScheme.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTColorScheme.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTColorScheme.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTColorScheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */