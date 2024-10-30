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

public interface CTFontScheme extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTFontScheme.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctfontscheme232ftype");
  
  CTFontCollection getMajorFont();
  
  void setMajorFont(CTFontCollection paramCTFontCollection);
  
  CTFontCollection addNewMajorFont();
  
  CTFontCollection getMinorFont();
  
  void setMinorFont(CTFontCollection paramCTFontCollection);
  
  CTFontCollection addNewMinorFont();
  
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
    public static CTFontScheme newInstance() {
      return (CTFontScheme)POIXMLTypeLoader.newInstance(CTFontScheme.type, null);
    }
    
    public static CTFontScheme newInstance(XmlOptions param1XmlOptions) {
      return (CTFontScheme)POIXMLTypeLoader.newInstance(CTFontScheme.type, param1XmlOptions);
    }
    
    public static CTFontScheme parse(String param1String) throws XmlException {
      return (CTFontScheme)POIXMLTypeLoader.parse(param1String, CTFontScheme.type, null);
    }
    
    public static CTFontScheme parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFontScheme)POIXMLTypeLoader.parse(param1String, CTFontScheme.type, param1XmlOptions);
    }
    
    public static CTFontScheme parse(File param1File) throws XmlException, IOException {
      return (CTFontScheme)POIXMLTypeLoader.parse(param1File, CTFontScheme.type, null);
    }
    
    public static CTFontScheme parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFontScheme)POIXMLTypeLoader.parse(param1File, CTFontScheme.type, param1XmlOptions);
    }
    
    public static CTFontScheme parse(URL param1URL) throws XmlException, IOException {
      return (CTFontScheme)POIXMLTypeLoader.parse(param1URL, CTFontScheme.type, null);
    }
    
    public static CTFontScheme parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFontScheme)POIXMLTypeLoader.parse(param1URL, CTFontScheme.type, param1XmlOptions);
    }
    
    public static CTFontScheme parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTFontScheme)POIXMLTypeLoader.parse(param1InputStream, CTFontScheme.type, null);
    }
    
    public static CTFontScheme parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFontScheme)POIXMLTypeLoader.parse(param1InputStream, CTFontScheme.type, param1XmlOptions);
    }
    
    public static CTFontScheme parse(Reader param1Reader) throws XmlException, IOException {
      return (CTFontScheme)POIXMLTypeLoader.parse(param1Reader, CTFontScheme.type, null);
    }
    
    public static CTFontScheme parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFontScheme)POIXMLTypeLoader.parse(param1Reader, CTFontScheme.type, param1XmlOptions);
    }
    
    public static CTFontScheme parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTFontScheme)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFontScheme.type, null);
    }
    
    public static CTFontScheme parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFontScheme)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFontScheme.type, param1XmlOptions);
    }
    
    public static CTFontScheme parse(Node param1Node) throws XmlException {
      return (CTFontScheme)POIXMLTypeLoader.parse(param1Node, CTFontScheme.type, null);
    }
    
    public static CTFontScheme parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFontScheme)POIXMLTypeLoader.parse(param1Node, CTFontScheme.type, param1XmlOptions);
    }
    
    public static CTFontScheme parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTFontScheme)POIXMLTypeLoader.parse(param1XMLInputStream, CTFontScheme.type, null);
    }
    
    public static CTFontScheme parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTFontScheme)POIXMLTypeLoader.parse(param1XMLInputStream, CTFontScheme.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFontScheme.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFontScheme.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTFontScheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */