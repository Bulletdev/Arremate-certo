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

public interface CTBorderPr extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTBorderPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctborderpre497type");
  
  CTColor getColor();
  
  boolean isSetColor();
  
  void setColor(CTColor paramCTColor);
  
  CTColor addNewColor();
  
  void unsetColor();
  
  STBorderStyle.Enum getStyle();
  
  STBorderStyle xgetStyle();
  
  boolean isSetStyle();
  
  void setStyle(STBorderStyle.Enum paramEnum);
  
  void xsetStyle(STBorderStyle paramSTBorderStyle);
  
  void unsetStyle();
  
  public static final class Factory {
    public static CTBorderPr newInstance() {
      return (CTBorderPr)POIXMLTypeLoader.newInstance(CTBorderPr.type, null);
    }
    
    public static CTBorderPr newInstance(XmlOptions param1XmlOptions) {
      return (CTBorderPr)POIXMLTypeLoader.newInstance(CTBorderPr.type, param1XmlOptions);
    }
    
    public static CTBorderPr parse(String param1String) throws XmlException {
      return (CTBorderPr)POIXMLTypeLoader.parse(param1String, CTBorderPr.type, null);
    }
    
    public static CTBorderPr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBorderPr)POIXMLTypeLoader.parse(param1String, CTBorderPr.type, param1XmlOptions);
    }
    
    public static CTBorderPr parse(File param1File) throws XmlException, IOException {
      return (CTBorderPr)POIXMLTypeLoader.parse(param1File, CTBorderPr.type, null);
    }
    
    public static CTBorderPr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBorderPr)POIXMLTypeLoader.parse(param1File, CTBorderPr.type, param1XmlOptions);
    }
    
    public static CTBorderPr parse(URL param1URL) throws XmlException, IOException {
      return (CTBorderPr)POIXMLTypeLoader.parse(param1URL, CTBorderPr.type, null);
    }
    
    public static CTBorderPr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBorderPr)POIXMLTypeLoader.parse(param1URL, CTBorderPr.type, param1XmlOptions);
    }
    
    public static CTBorderPr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTBorderPr)POIXMLTypeLoader.parse(param1InputStream, CTBorderPr.type, null);
    }
    
    public static CTBorderPr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBorderPr)POIXMLTypeLoader.parse(param1InputStream, CTBorderPr.type, param1XmlOptions);
    }
    
    public static CTBorderPr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTBorderPr)POIXMLTypeLoader.parse(param1Reader, CTBorderPr.type, null);
    }
    
    public static CTBorderPr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBorderPr)POIXMLTypeLoader.parse(param1Reader, CTBorderPr.type, param1XmlOptions);
    }
    
    public static CTBorderPr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTBorderPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBorderPr.type, null);
    }
    
    public static CTBorderPr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBorderPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBorderPr.type, param1XmlOptions);
    }
    
    public static CTBorderPr parse(Node param1Node) throws XmlException {
      return (CTBorderPr)POIXMLTypeLoader.parse(param1Node, CTBorderPr.type, null);
    }
    
    public static CTBorderPr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBorderPr)POIXMLTypeLoader.parse(param1Node, CTBorderPr.type, param1XmlOptions);
    }
    
    public static CTBorderPr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTBorderPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTBorderPr.type, null);
    }
    
    public static CTBorderPr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTBorderPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTBorderPr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBorderPr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBorderPr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTBorderPr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */