package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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

public interface SstDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(SstDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sstf81fdoctype");
  
  CTSst getSst();
  
  void setSst(CTSst paramCTSst);
  
  CTSst addNewSst();
  
  public static final class Factory {
    public static SstDocument newInstance() {
      return (SstDocument)POIXMLTypeLoader.newInstance(SstDocument.type, null);
    }
    
    public static SstDocument newInstance(XmlOptions param1XmlOptions) {
      return (SstDocument)POIXMLTypeLoader.newInstance(SstDocument.type, param1XmlOptions);
    }
    
    public static SstDocument parse(String param1String) throws XmlException {
      return (SstDocument)POIXMLTypeLoader.parse(param1String, SstDocument.type, null);
    }
    
    public static SstDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (SstDocument)POIXMLTypeLoader.parse(param1String, SstDocument.type, param1XmlOptions);
    }
    
    public static SstDocument parse(File param1File) throws XmlException, IOException {
      return (SstDocument)POIXMLTypeLoader.parse(param1File, SstDocument.type, null);
    }
    
    public static SstDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SstDocument)POIXMLTypeLoader.parse(param1File, SstDocument.type, param1XmlOptions);
    }
    
    public static SstDocument parse(URL param1URL) throws XmlException, IOException {
      return (SstDocument)POIXMLTypeLoader.parse(param1URL, SstDocument.type, null);
    }
    
    public static SstDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SstDocument)POIXMLTypeLoader.parse(param1URL, SstDocument.type, param1XmlOptions);
    }
    
    public static SstDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (SstDocument)POIXMLTypeLoader.parse(param1InputStream, SstDocument.type, null);
    }
    
    public static SstDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SstDocument)POIXMLTypeLoader.parse(param1InputStream, SstDocument.type, param1XmlOptions);
    }
    
    public static SstDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (SstDocument)POIXMLTypeLoader.parse(param1Reader, SstDocument.type, null);
    }
    
    public static SstDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SstDocument)POIXMLTypeLoader.parse(param1Reader, SstDocument.type, param1XmlOptions);
    }
    
    public static SstDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (SstDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, SstDocument.type, null);
    }
    
    public static SstDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (SstDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, SstDocument.type, param1XmlOptions);
    }
    
    public static SstDocument parse(Node param1Node) throws XmlException {
      return (SstDocument)POIXMLTypeLoader.parse(param1Node, SstDocument.type, null);
    }
    
    public static SstDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (SstDocument)POIXMLTypeLoader.parse(param1Node, SstDocument.type, param1XmlOptions);
    }
    
    public static SstDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (SstDocument)POIXMLTypeLoader.parse(param1XMLInputStream, SstDocument.type, null);
    }
    
    public static SstDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (SstDocument)POIXMLTypeLoader.parse(param1XMLInputStream, SstDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, SstDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, SstDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\SstDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */