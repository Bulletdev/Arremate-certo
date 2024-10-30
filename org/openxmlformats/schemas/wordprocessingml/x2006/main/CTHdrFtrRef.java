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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTHdrFtrRef extends CTRel {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTHdrFtrRef.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cthdrftrref224dtype");
  
  STHdrFtr.Enum getType();
  
  STHdrFtr xgetType();
  
  void setType(STHdrFtr.Enum paramEnum);
  
  void xsetType(STHdrFtr paramSTHdrFtr);
  
  public static final class Factory {
    public static CTHdrFtrRef newInstance() {
      return (CTHdrFtrRef)POIXMLTypeLoader.newInstance(CTHdrFtrRef.type, null);
    }
    
    public static CTHdrFtrRef newInstance(XmlOptions param1XmlOptions) {
      return (CTHdrFtrRef)POIXMLTypeLoader.newInstance(CTHdrFtrRef.type, param1XmlOptions);
    }
    
    public static CTHdrFtrRef parse(String param1String) throws XmlException {
      return (CTHdrFtrRef)POIXMLTypeLoader.parse(param1String, CTHdrFtrRef.type, null);
    }
    
    public static CTHdrFtrRef parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHdrFtrRef)POIXMLTypeLoader.parse(param1String, CTHdrFtrRef.type, param1XmlOptions);
    }
    
    public static CTHdrFtrRef parse(File param1File) throws XmlException, IOException {
      return (CTHdrFtrRef)POIXMLTypeLoader.parse(param1File, CTHdrFtrRef.type, null);
    }
    
    public static CTHdrFtrRef parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHdrFtrRef)POIXMLTypeLoader.parse(param1File, CTHdrFtrRef.type, param1XmlOptions);
    }
    
    public static CTHdrFtrRef parse(URL param1URL) throws XmlException, IOException {
      return (CTHdrFtrRef)POIXMLTypeLoader.parse(param1URL, CTHdrFtrRef.type, null);
    }
    
    public static CTHdrFtrRef parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHdrFtrRef)POIXMLTypeLoader.parse(param1URL, CTHdrFtrRef.type, param1XmlOptions);
    }
    
    public static CTHdrFtrRef parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTHdrFtrRef)POIXMLTypeLoader.parse(param1InputStream, CTHdrFtrRef.type, null);
    }
    
    public static CTHdrFtrRef parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHdrFtrRef)POIXMLTypeLoader.parse(param1InputStream, CTHdrFtrRef.type, param1XmlOptions);
    }
    
    public static CTHdrFtrRef parse(Reader param1Reader) throws XmlException, IOException {
      return (CTHdrFtrRef)POIXMLTypeLoader.parse(param1Reader, CTHdrFtrRef.type, null);
    }
    
    public static CTHdrFtrRef parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHdrFtrRef)POIXMLTypeLoader.parse(param1Reader, CTHdrFtrRef.type, param1XmlOptions);
    }
    
    public static CTHdrFtrRef parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTHdrFtrRef)POIXMLTypeLoader.parse(param1XMLStreamReader, CTHdrFtrRef.type, null);
    }
    
    public static CTHdrFtrRef parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHdrFtrRef)POIXMLTypeLoader.parse(param1XMLStreamReader, CTHdrFtrRef.type, param1XmlOptions);
    }
    
    public static CTHdrFtrRef parse(Node param1Node) throws XmlException {
      return (CTHdrFtrRef)POIXMLTypeLoader.parse(param1Node, CTHdrFtrRef.type, null);
    }
    
    public static CTHdrFtrRef parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHdrFtrRef)POIXMLTypeLoader.parse(param1Node, CTHdrFtrRef.type, param1XmlOptions);
    }
    
    public static CTHdrFtrRef parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTHdrFtrRef)POIXMLTypeLoader.parse(param1XMLInputStream, CTHdrFtrRef.type, null);
    }
    
    public static CTHdrFtrRef parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTHdrFtrRef)POIXMLTypeLoader.parse(param1XMLInputStream, CTHdrFtrRef.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTHdrFtrRef.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTHdrFtrRef.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTHdrFtrRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */