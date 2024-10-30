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

public interface CTRegularTextRun extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTRegularTextRun.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctregulartextrun7e3dtype");
  
  CTTextCharacterProperties getRPr();
  
  boolean isSetRPr();
  
  void setRPr(CTTextCharacterProperties paramCTTextCharacterProperties);
  
  CTTextCharacterProperties addNewRPr();
  
  void unsetRPr();
  
  String getT();
  
  XmlString xgetT();
  
  void setT(String paramString);
  
  void xsetT(XmlString paramXmlString);
  
  public static final class Factory {
    public static CTRegularTextRun newInstance() {
      return (CTRegularTextRun)POIXMLTypeLoader.newInstance(CTRegularTextRun.type, null);
    }
    
    public static CTRegularTextRun newInstance(XmlOptions param1XmlOptions) {
      return (CTRegularTextRun)POIXMLTypeLoader.newInstance(CTRegularTextRun.type, param1XmlOptions);
    }
    
    public static CTRegularTextRun parse(String param1String) throws XmlException {
      return (CTRegularTextRun)POIXMLTypeLoader.parse(param1String, CTRegularTextRun.type, null);
    }
    
    public static CTRegularTextRun parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRegularTextRun)POIXMLTypeLoader.parse(param1String, CTRegularTextRun.type, param1XmlOptions);
    }
    
    public static CTRegularTextRun parse(File param1File) throws XmlException, IOException {
      return (CTRegularTextRun)POIXMLTypeLoader.parse(param1File, CTRegularTextRun.type, null);
    }
    
    public static CTRegularTextRun parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRegularTextRun)POIXMLTypeLoader.parse(param1File, CTRegularTextRun.type, param1XmlOptions);
    }
    
    public static CTRegularTextRun parse(URL param1URL) throws XmlException, IOException {
      return (CTRegularTextRun)POIXMLTypeLoader.parse(param1URL, CTRegularTextRun.type, null);
    }
    
    public static CTRegularTextRun parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRegularTextRun)POIXMLTypeLoader.parse(param1URL, CTRegularTextRun.type, param1XmlOptions);
    }
    
    public static CTRegularTextRun parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTRegularTextRun)POIXMLTypeLoader.parse(param1InputStream, CTRegularTextRun.type, null);
    }
    
    public static CTRegularTextRun parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRegularTextRun)POIXMLTypeLoader.parse(param1InputStream, CTRegularTextRun.type, param1XmlOptions);
    }
    
    public static CTRegularTextRun parse(Reader param1Reader) throws XmlException, IOException {
      return (CTRegularTextRun)POIXMLTypeLoader.parse(param1Reader, CTRegularTextRun.type, null);
    }
    
    public static CTRegularTextRun parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRegularTextRun)POIXMLTypeLoader.parse(param1Reader, CTRegularTextRun.type, param1XmlOptions);
    }
    
    public static CTRegularTextRun parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTRegularTextRun)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRegularTextRun.type, null);
    }
    
    public static CTRegularTextRun parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRegularTextRun)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRegularTextRun.type, param1XmlOptions);
    }
    
    public static CTRegularTextRun parse(Node param1Node) throws XmlException {
      return (CTRegularTextRun)POIXMLTypeLoader.parse(param1Node, CTRegularTextRun.type, null);
    }
    
    public static CTRegularTextRun parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRegularTextRun)POIXMLTypeLoader.parse(param1Node, CTRegularTextRun.type, param1XmlOptions);
    }
    
    public static CTRegularTextRun parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTRegularTextRun)POIXMLTypeLoader.parse(param1XMLInputStream, CTRegularTextRun.type, null);
    }
    
    public static CTRegularTextRun parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTRegularTextRun)POIXMLTypeLoader.parse(param1XMLInputStream, CTRegularTextRun.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRegularTextRun.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRegularTextRun.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTRegularTextRun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */