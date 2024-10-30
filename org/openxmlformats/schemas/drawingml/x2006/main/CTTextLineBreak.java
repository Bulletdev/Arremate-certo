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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTTextLineBreak extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextLineBreak.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextlinebreak932ftype");
  
  CTTextCharacterProperties getRPr();
  
  boolean isSetRPr();
  
  void setRPr(CTTextCharacterProperties paramCTTextCharacterProperties);
  
  CTTextCharacterProperties addNewRPr();
  
  void unsetRPr();
  
  public static final class Factory {
    public static CTTextLineBreak newInstance() {
      return (CTTextLineBreak)POIXMLTypeLoader.newInstance(CTTextLineBreak.type, null);
    }
    
    public static CTTextLineBreak newInstance(XmlOptions param1XmlOptions) {
      return (CTTextLineBreak)POIXMLTypeLoader.newInstance(CTTextLineBreak.type, param1XmlOptions);
    }
    
    public static CTTextLineBreak parse(String param1String) throws XmlException {
      return (CTTextLineBreak)POIXMLTypeLoader.parse(param1String, CTTextLineBreak.type, null);
    }
    
    public static CTTextLineBreak parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextLineBreak)POIXMLTypeLoader.parse(param1String, CTTextLineBreak.type, param1XmlOptions);
    }
    
    public static CTTextLineBreak parse(File param1File) throws XmlException, IOException {
      return (CTTextLineBreak)POIXMLTypeLoader.parse(param1File, CTTextLineBreak.type, null);
    }
    
    public static CTTextLineBreak parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextLineBreak)POIXMLTypeLoader.parse(param1File, CTTextLineBreak.type, param1XmlOptions);
    }
    
    public static CTTextLineBreak parse(URL param1URL) throws XmlException, IOException {
      return (CTTextLineBreak)POIXMLTypeLoader.parse(param1URL, CTTextLineBreak.type, null);
    }
    
    public static CTTextLineBreak parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextLineBreak)POIXMLTypeLoader.parse(param1URL, CTTextLineBreak.type, param1XmlOptions);
    }
    
    public static CTTextLineBreak parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextLineBreak)POIXMLTypeLoader.parse(param1InputStream, CTTextLineBreak.type, null);
    }
    
    public static CTTextLineBreak parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextLineBreak)POIXMLTypeLoader.parse(param1InputStream, CTTextLineBreak.type, param1XmlOptions);
    }
    
    public static CTTextLineBreak parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextLineBreak)POIXMLTypeLoader.parse(param1Reader, CTTextLineBreak.type, null);
    }
    
    public static CTTextLineBreak parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextLineBreak)POIXMLTypeLoader.parse(param1Reader, CTTextLineBreak.type, param1XmlOptions);
    }
    
    public static CTTextLineBreak parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextLineBreak)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextLineBreak.type, null);
    }
    
    public static CTTextLineBreak parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextLineBreak)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextLineBreak.type, param1XmlOptions);
    }
    
    public static CTTextLineBreak parse(Node param1Node) throws XmlException {
      return (CTTextLineBreak)POIXMLTypeLoader.parse(param1Node, CTTextLineBreak.type, null);
    }
    
    public static CTTextLineBreak parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextLineBreak)POIXMLTypeLoader.parse(param1Node, CTTextLineBreak.type, param1XmlOptions);
    }
    
    public static CTTextLineBreak parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextLineBreak)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextLineBreak.type, null);
    }
    
    public static CTTextLineBreak parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextLineBreak)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextLineBreak.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextLineBreak.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextLineBreak.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTextLineBreak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */