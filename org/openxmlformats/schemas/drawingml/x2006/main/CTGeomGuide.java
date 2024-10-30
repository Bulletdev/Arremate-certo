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

public interface CTGeomGuide extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTGeomGuide.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgeomguidef191type");
  
  String getName();
  
  STGeomGuideName xgetName();
  
  void setName(String paramString);
  
  void xsetName(STGeomGuideName paramSTGeomGuideName);
  
  String getFmla();
  
  STGeomGuideFormula xgetFmla();
  
  void setFmla(String paramString);
  
  void xsetFmla(STGeomGuideFormula paramSTGeomGuideFormula);
  
  public static final class Factory {
    public static CTGeomGuide newInstance() {
      return (CTGeomGuide)POIXMLTypeLoader.newInstance(CTGeomGuide.type, null);
    }
    
    public static CTGeomGuide newInstance(XmlOptions param1XmlOptions) {
      return (CTGeomGuide)POIXMLTypeLoader.newInstance(CTGeomGuide.type, param1XmlOptions);
    }
    
    public static CTGeomGuide parse(String param1String) throws XmlException {
      return (CTGeomGuide)POIXMLTypeLoader.parse(param1String, CTGeomGuide.type, null);
    }
    
    public static CTGeomGuide parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGeomGuide)POIXMLTypeLoader.parse(param1String, CTGeomGuide.type, param1XmlOptions);
    }
    
    public static CTGeomGuide parse(File param1File) throws XmlException, IOException {
      return (CTGeomGuide)POIXMLTypeLoader.parse(param1File, CTGeomGuide.type, null);
    }
    
    public static CTGeomGuide parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGeomGuide)POIXMLTypeLoader.parse(param1File, CTGeomGuide.type, param1XmlOptions);
    }
    
    public static CTGeomGuide parse(URL param1URL) throws XmlException, IOException {
      return (CTGeomGuide)POIXMLTypeLoader.parse(param1URL, CTGeomGuide.type, null);
    }
    
    public static CTGeomGuide parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGeomGuide)POIXMLTypeLoader.parse(param1URL, CTGeomGuide.type, param1XmlOptions);
    }
    
    public static CTGeomGuide parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTGeomGuide)POIXMLTypeLoader.parse(param1InputStream, CTGeomGuide.type, null);
    }
    
    public static CTGeomGuide parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGeomGuide)POIXMLTypeLoader.parse(param1InputStream, CTGeomGuide.type, param1XmlOptions);
    }
    
    public static CTGeomGuide parse(Reader param1Reader) throws XmlException, IOException {
      return (CTGeomGuide)POIXMLTypeLoader.parse(param1Reader, CTGeomGuide.type, null);
    }
    
    public static CTGeomGuide parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGeomGuide)POIXMLTypeLoader.parse(param1Reader, CTGeomGuide.type, param1XmlOptions);
    }
    
    public static CTGeomGuide parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTGeomGuide)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGeomGuide.type, null);
    }
    
    public static CTGeomGuide parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGeomGuide)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGeomGuide.type, param1XmlOptions);
    }
    
    public static CTGeomGuide parse(Node param1Node) throws XmlException {
      return (CTGeomGuide)POIXMLTypeLoader.parse(param1Node, CTGeomGuide.type, null);
    }
    
    public static CTGeomGuide parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGeomGuide)POIXMLTypeLoader.parse(param1Node, CTGeomGuide.type, param1XmlOptions);
    }
    
    public static CTGeomGuide parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTGeomGuide)POIXMLTypeLoader.parse(param1XMLInputStream, CTGeomGuide.type, null);
    }
    
    public static CTGeomGuide parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTGeomGuide)POIXMLTypeLoader.parse(param1XMLInputStream, CTGeomGuide.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGeomGuide.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGeomGuide.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTGeomGuide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */