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

public interface CTTextSpacing extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextSpacing.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextspacingef87type");
  
  CTTextSpacingPercent getSpcPct();
  
  boolean isSetSpcPct();
  
  void setSpcPct(CTTextSpacingPercent paramCTTextSpacingPercent);
  
  CTTextSpacingPercent addNewSpcPct();
  
  void unsetSpcPct();
  
  CTTextSpacingPoint getSpcPts();
  
  boolean isSetSpcPts();
  
  void setSpcPts(CTTextSpacingPoint paramCTTextSpacingPoint);
  
  CTTextSpacingPoint addNewSpcPts();
  
  void unsetSpcPts();
  
  public static final class Factory {
    public static CTTextSpacing newInstance() {
      return (CTTextSpacing)POIXMLTypeLoader.newInstance(CTTextSpacing.type, null);
    }
    
    public static CTTextSpacing newInstance(XmlOptions param1XmlOptions) {
      return (CTTextSpacing)POIXMLTypeLoader.newInstance(CTTextSpacing.type, param1XmlOptions);
    }
    
    public static CTTextSpacing parse(String param1String) throws XmlException {
      return (CTTextSpacing)POIXMLTypeLoader.parse(param1String, CTTextSpacing.type, null);
    }
    
    public static CTTextSpacing parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextSpacing)POIXMLTypeLoader.parse(param1String, CTTextSpacing.type, param1XmlOptions);
    }
    
    public static CTTextSpacing parse(File param1File) throws XmlException, IOException {
      return (CTTextSpacing)POIXMLTypeLoader.parse(param1File, CTTextSpacing.type, null);
    }
    
    public static CTTextSpacing parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextSpacing)POIXMLTypeLoader.parse(param1File, CTTextSpacing.type, param1XmlOptions);
    }
    
    public static CTTextSpacing parse(URL param1URL) throws XmlException, IOException {
      return (CTTextSpacing)POIXMLTypeLoader.parse(param1URL, CTTextSpacing.type, null);
    }
    
    public static CTTextSpacing parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextSpacing)POIXMLTypeLoader.parse(param1URL, CTTextSpacing.type, param1XmlOptions);
    }
    
    public static CTTextSpacing parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextSpacing)POIXMLTypeLoader.parse(param1InputStream, CTTextSpacing.type, null);
    }
    
    public static CTTextSpacing parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextSpacing)POIXMLTypeLoader.parse(param1InputStream, CTTextSpacing.type, param1XmlOptions);
    }
    
    public static CTTextSpacing parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextSpacing)POIXMLTypeLoader.parse(param1Reader, CTTextSpacing.type, null);
    }
    
    public static CTTextSpacing parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextSpacing)POIXMLTypeLoader.parse(param1Reader, CTTextSpacing.type, param1XmlOptions);
    }
    
    public static CTTextSpacing parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextSpacing)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextSpacing.type, null);
    }
    
    public static CTTextSpacing parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextSpacing)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextSpacing.type, param1XmlOptions);
    }
    
    public static CTTextSpacing parse(Node param1Node) throws XmlException {
      return (CTTextSpacing)POIXMLTypeLoader.parse(param1Node, CTTextSpacing.type, null);
    }
    
    public static CTTextSpacing parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextSpacing)POIXMLTypeLoader.parse(param1Node, CTTextSpacing.type, param1XmlOptions);
    }
    
    public static CTTextSpacing parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextSpacing)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextSpacing.type, null);
    }
    
    public static CTTextSpacing parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextSpacing)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextSpacing.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextSpacing.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextSpacing.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTextSpacing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */