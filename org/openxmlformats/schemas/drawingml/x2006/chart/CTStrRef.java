package org.openxmlformats.schemas.drawingml.x2006.chart;

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

public interface CTStrRef extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTStrRef.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctstrref5d1atype");
  
  String getF();
  
  XmlString xgetF();
  
  void setF(String paramString);
  
  void xsetF(XmlString paramXmlString);
  
  CTStrData getStrCache();
  
  boolean isSetStrCache();
  
  void setStrCache(CTStrData paramCTStrData);
  
  CTStrData addNewStrCache();
  
  void unsetStrCache();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTStrRef newInstance() {
      return (CTStrRef)POIXMLTypeLoader.newInstance(CTStrRef.type, null);
    }
    
    public static CTStrRef newInstance(XmlOptions param1XmlOptions) {
      return (CTStrRef)POIXMLTypeLoader.newInstance(CTStrRef.type, param1XmlOptions);
    }
    
    public static CTStrRef parse(String param1String) throws XmlException {
      return (CTStrRef)POIXMLTypeLoader.parse(param1String, CTStrRef.type, null);
    }
    
    public static CTStrRef parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStrRef)POIXMLTypeLoader.parse(param1String, CTStrRef.type, param1XmlOptions);
    }
    
    public static CTStrRef parse(File param1File) throws XmlException, IOException {
      return (CTStrRef)POIXMLTypeLoader.parse(param1File, CTStrRef.type, null);
    }
    
    public static CTStrRef parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStrRef)POIXMLTypeLoader.parse(param1File, CTStrRef.type, param1XmlOptions);
    }
    
    public static CTStrRef parse(URL param1URL) throws XmlException, IOException {
      return (CTStrRef)POIXMLTypeLoader.parse(param1URL, CTStrRef.type, null);
    }
    
    public static CTStrRef parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStrRef)POIXMLTypeLoader.parse(param1URL, CTStrRef.type, param1XmlOptions);
    }
    
    public static CTStrRef parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTStrRef)POIXMLTypeLoader.parse(param1InputStream, CTStrRef.type, null);
    }
    
    public static CTStrRef parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStrRef)POIXMLTypeLoader.parse(param1InputStream, CTStrRef.type, param1XmlOptions);
    }
    
    public static CTStrRef parse(Reader param1Reader) throws XmlException, IOException {
      return (CTStrRef)POIXMLTypeLoader.parse(param1Reader, CTStrRef.type, null);
    }
    
    public static CTStrRef parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStrRef)POIXMLTypeLoader.parse(param1Reader, CTStrRef.type, param1XmlOptions);
    }
    
    public static CTStrRef parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTStrRef)POIXMLTypeLoader.parse(param1XMLStreamReader, CTStrRef.type, null);
    }
    
    public static CTStrRef parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStrRef)POIXMLTypeLoader.parse(param1XMLStreamReader, CTStrRef.type, param1XmlOptions);
    }
    
    public static CTStrRef parse(Node param1Node) throws XmlException {
      return (CTStrRef)POIXMLTypeLoader.parse(param1Node, CTStrRef.type, null);
    }
    
    public static CTStrRef parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStrRef)POIXMLTypeLoader.parse(param1Node, CTStrRef.type, param1XmlOptions);
    }
    
    public static CTStrRef parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTStrRef)POIXMLTypeLoader.parse(param1XMLInputStream, CTStrRef.type, null);
    }
    
    public static CTStrRef parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTStrRef)POIXMLTypeLoader.parse(param1XMLInputStream, CTStrRef.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTStrRef.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTStrRef.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTStrRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */