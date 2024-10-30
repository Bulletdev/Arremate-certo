package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTSdtDocPart extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSdtDocPart.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsdtdocpartcea0type");
  
  CTString getDocPartGallery();
  
  boolean isSetDocPartGallery();
  
  void setDocPartGallery(CTString paramCTString);
  
  CTString addNewDocPartGallery();
  
  void unsetDocPartGallery();
  
  CTString getDocPartCategory();
  
  boolean isSetDocPartCategory();
  
  void setDocPartCategory(CTString paramCTString);
  
  CTString addNewDocPartCategory();
  
  void unsetDocPartCategory();
  
  CTOnOff getDocPartUnique();
  
  boolean isSetDocPartUnique();
  
  void setDocPartUnique(CTOnOff paramCTOnOff);
  
  CTOnOff addNewDocPartUnique();
  
  void unsetDocPartUnique();
  
  public static final class Factory {
    public static CTSdtDocPart newInstance() {
      return (CTSdtDocPart)POIXMLTypeLoader.newInstance(CTSdtDocPart.type, null);
    }
    
    public static CTSdtDocPart newInstance(XmlOptions param1XmlOptions) {
      return (CTSdtDocPart)POIXMLTypeLoader.newInstance(CTSdtDocPart.type, param1XmlOptions);
    }
    
    public static CTSdtDocPart parse(String param1String) throws XmlException {
      return (CTSdtDocPart)POIXMLTypeLoader.parse(param1String, CTSdtDocPart.type, null);
    }
    
    public static CTSdtDocPart parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSdtDocPart)POIXMLTypeLoader.parse(param1String, CTSdtDocPart.type, param1XmlOptions);
    }
    
    public static CTSdtDocPart parse(File param1File) throws XmlException, IOException {
      return (CTSdtDocPart)POIXMLTypeLoader.parse(param1File, CTSdtDocPart.type, null);
    }
    
    public static CTSdtDocPart parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtDocPart)POIXMLTypeLoader.parse(param1File, CTSdtDocPart.type, param1XmlOptions);
    }
    
    public static CTSdtDocPart parse(URL param1URL) throws XmlException, IOException {
      return (CTSdtDocPart)POIXMLTypeLoader.parse(param1URL, CTSdtDocPart.type, null);
    }
    
    public static CTSdtDocPart parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtDocPart)POIXMLTypeLoader.parse(param1URL, CTSdtDocPart.type, param1XmlOptions);
    }
    
    public static CTSdtDocPart parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSdtDocPart)POIXMLTypeLoader.parse(param1InputStream, CTSdtDocPart.type, null);
    }
    
    public static CTSdtDocPart parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtDocPart)POIXMLTypeLoader.parse(param1InputStream, CTSdtDocPart.type, param1XmlOptions);
    }
    
    public static CTSdtDocPart parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSdtDocPart)POIXMLTypeLoader.parse(param1Reader, CTSdtDocPart.type, null);
    }
    
    public static CTSdtDocPart parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtDocPart)POIXMLTypeLoader.parse(param1Reader, CTSdtDocPart.type, param1XmlOptions);
    }
    
    public static CTSdtDocPart parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSdtDocPart)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSdtDocPart.type, null);
    }
    
    public static CTSdtDocPart parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSdtDocPart)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSdtDocPart.type, param1XmlOptions);
    }
    
    public static CTSdtDocPart parse(Node param1Node) throws XmlException {
      return (CTSdtDocPart)POIXMLTypeLoader.parse(param1Node, CTSdtDocPart.type, null);
    }
    
    public static CTSdtDocPart parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSdtDocPart)POIXMLTypeLoader.parse(param1Node, CTSdtDocPart.type, param1XmlOptions);
    }
    
    public static CTSdtDocPart parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSdtDocPart)POIXMLTypeLoader.parse(param1XMLInputStream, CTSdtDocPart.type, null);
    }
    
    public static CTSdtDocPart parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSdtDocPart)POIXMLTypeLoader.parse(param1XMLInputStream, CTSdtDocPart.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSdtDocPart.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSdtDocPart.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTSdtDocPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */