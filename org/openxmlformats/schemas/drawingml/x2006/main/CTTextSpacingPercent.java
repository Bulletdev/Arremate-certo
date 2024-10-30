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

public interface CTTextSpacingPercent extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextSpacingPercent.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextspacingpercent322atype");
  
  int getVal();
  
  STTextSpacingPercent xgetVal();
  
  void setVal(int paramInt);
  
  void xsetVal(STTextSpacingPercent paramSTTextSpacingPercent);
  
  public static final class Factory {
    public static CTTextSpacingPercent newInstance() {
      return (CTTextSpacingPercent)POIXMLTypeLoader.newInstance(CTTextSpacingPercent.type, null);
    }
    
    public static CTTextSpacingPercent newInstance(XmlOptions param1XmlOptions) {
      return (CTTextSpacingPercent)POIXMLTypeLoader.newInstance(CTTextSpacingPercent.type, param1XmlOptions);
    }
    
    public static CTTextSpacingPercent parse(String param1String) throws XmlException {
      return (CTTextSpacingPercent)POIXMLTypeLoader.parse(param1String, CTTextSpacingPercent.type, null);
    }
    
    public static CTTextSpacingPercent parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextSpacingPercent)POIXMLTypeLoader.parse(param1String, CTTextSpacingPercent.type, param1XmlOptions);
    }
    
    public static CTTextSpacingPercent parse(File param1File) throws XmlException, IOException {
      return (CTTextSpacingPercent)POIXMLTypeLoader.parse(param1File, CTTextSpacingPercent.type, null);
    }
    
    public static CTTextSpacingPercent parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextSpacingPercent)POIXMLTypeLoader.parse(param1File, CTTextSpacingPercent.type, param1XmlOptions);
    }
    
    public static CTTextSpacingPercent parse(URL param1URL) throws XmlException, IOException {
      return (CTTextSpacingPercent)POIXMLTypeLoader.parse(param1URL, CTTextSpacingPercent.type, null);
    }
    
    public static CTTextSpacingPercent parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextSpacingPercent)POIXMLTypeLoader.parse(param1URL, CTTextSpacingPercent.type, param1XmlOptions);
    }
    
    public static CTTextSpacingPercent parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextSpacingPercent)POIXMLTypeLoader.parse(param1InputStream, CTTextSpacingPercent.type, null);
    }
    
    public static CTTextSpacingPercent parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextSpacingPercent)POIXMLTypeLoader.parse(param1InputStream, CTTextSpacingPercent.type, param1XmlOptions);
    }
    
    public static CTTextSpacingPercent parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextSpacingPercent)POIXMLTypeLoader.parse(param1Reader, CTTextSpacingPercent.type, null);
    }
    
    public static CTTextSpacingPercent parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextSpacingPercent)POIXMLTypeLoader.parse(param1Reader, CTTextSpacingPercent.type, param1XmlOptions);
    }
    
    public static CTTextSpacingPercent parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextSpacingPercent)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextSpacingPercent.type, null);
    }
    
    public static CTTextSpacingPercent parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextSpacingPercent)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextSpacingPercent.type, param1XmlOptions);
    }
    
    public static CTTextSpacingPercent parse(Node param1Node) throws XmlException {
      return (CTTextSpacingPercent)POIXMLTypeLoader.parse(param1Node, CTTextSpacingPercent.type, null);
    }
    
    public static CTTextSpacingPercent parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextSpacingPercent)POIXMLTypeLoader.parse(param1Node, CTTextSpacingPercent.type, param1XmlOptions);
    }
    
    public static CTTextSpacingPercent parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextSpacingPercent)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextSpacingPercent.type, null);
    }
    
    public static CTTextSpacingPercent parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextSpacingPercent)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextSpacingPercent.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextSpacingPercent.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextSpacingPercent.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTextSpacingPercent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */