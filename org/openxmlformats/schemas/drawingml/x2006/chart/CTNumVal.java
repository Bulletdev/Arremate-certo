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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTNumVal extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTNumVal.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnumval2fe1type");
  
  String getV();
  
  STXstring xgetV();
  
  void setV(String paramString);
  
  void xsetV(STXstring paramSTXstring);
  
  long getIdx();
  
  XmlUnsignedInt xgetIdx();
  
  void setIdx(long paramLong);
  
  void xsetIdx(XmlUnsignedInt paramXmlUnsignedInt);
  
  String getFormatCode();
  
  STXstring xgetFormatCode();
  
  boolean isSetFormatCode();
  
  void setFormatCode(String paramString);
  
  void xsetFormatCode(STXstring paramSTXstring);
  
  void unsetFormatCode();
  
  public static final class Factory {
    public static CTNumVal newInstance() {
      return (CTNumVal)POIXMLTypeLoader.newInstance(CTNumVal.type, null);
    }
    
    public static CTNumVal newInstance(XmlOptions param1XmlOptions) {
      return (CTNumVal)POIXMLTypeLoader.newInstance(CTNumVal.type, param1XmlOptions);
    }
    
    public static CTNumVal parse(String param1String) throws XmlException {
      return (CTNumVal)POIXMLTypeLoader.parse(param1String, CTNumVal.type, null);
    }
    
    public static CTNumVal parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumVal)POIXMLTypeLoader.parse(param1String, CTNumVal.type, param1XmlOptions);
    }
    
    public static CTNumVal parse(File param1File) throws XmlException, IOException {
      return (CTNumVal)POIXMLTypeLoader.parse(param1File, CTNumVal.type, null);
    }
    
    public static CTNumVal parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumVal)POIXMLTypeLoader.parse(param1File, CTNumVal.type, param1XmlOptions);
    }
    
    public static CTNumVal parse(URL param1URL) throws XmlException, IOException {
      return (CTNumVal)POIXMLTypeLoader.parse(param1URL, CTNumVal.type, null);
    }
    
    public static CTNumVal parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumVal)POIXMLTypeLoader.parse(param1URL, CTNumVal.type, param1XmlOptions);
    }
    
    public static CTNumVal parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTNumVal)POIXMLTypeLoader.parse(param1InputStream, CTNumVal.type, null);
    }
    
    public static CTNumVal parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumVal)POIXMLTypeLoader.parse(param1InputStream, CTNumVal.type, param1XmlOptions);
    }
    
    public static CTNumVal parse(Reader param1Reader) throws XmlException, IOException {
      return (CTNumVal)POIXMLTypeLoader.parse(param1Reader, CTNumVal.type, null);
    }
    
    public static CTNumVal parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumVal)POIXMLTypeLoader.parse(param1Reader, CTNumVal.type, param1XmlOptions);
    }
    
    public static CTNumVal parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTNumVal)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNumVal.type, null);
    }
    
    public static CTNumVal parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumVal)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNumVal.type, param1XmlOptions);
    }
    
    public static CTNumVal parse(Node param1Node) throws XmlException {
      return (CTNumVal)POIXMLTypeLoader.parse(param1Node, CTNumVal.type, null);
    }
    
    public static CTNumVal parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumVal)POIXMLTypeLoader.parse(param1Node, CTNumVal.type, param1XmlOptions);
    }
    
    public static CTNumVal parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTNumVal)POIXMLTypeLoader.parse(param1XMLInputStream, CTNumVal.type, null);
    }
    
    public static CTNumVal parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTNumVal)POIXMLTypeLoader.parse(param1XMLInputStream, CTNumVal.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNumVal.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNumVal.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTNumVal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */