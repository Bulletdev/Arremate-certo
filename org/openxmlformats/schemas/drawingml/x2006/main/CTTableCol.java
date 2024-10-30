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

public interface CTTableCol extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTableCol.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablecol19edtype");
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  long getW();
  
  STCoordinate xgetW();
  
  void setW(long paramLong);
  
  void xsetW(STCoordinate paramSTCoordinate);
  
  public static final class Factory {
    public static CTTableCol newInstance() {
      return (CTTableCol)POIXMLTypeLoader.newInstance(CTTableCol.type, null);
    }
    
    public static CTTableCol newInstance(XmlOptions param1XmlOptions) {
      return (CTTableCol)POIXMLTypeLoader.newInstance(CTTableCol.type, param1XmlOptions);
    }
    
    public static CTTableCol parse(String param1String) throws XmlException {
      return (CTTableCol)POIXMLTypeLoader.parse(param1String, CTTableCol.type, null);
    }
    
    public static CTTableCol parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableCol)POIXMLTypeLoader.parse(param1String, CTTableCol.type, param1XmlOptions);
    }
    
    public static CTTableCol parse(File param1File) throws XmlException, IOException {
      return (CTTableCol)POIXMLTypeLoader.parse(param1File, CTTableCol.type, null);
    }
    
    public static CTTableCol parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableCol)POIXMLTypeLoader.parse(param1File, CTTableCol.type, param1XmlOptions);
    }
    
    public static CTTableCol parse(URL param1URL) throws XmlException, IOException {
      return (CTTableCol)POIXMLTypeLoader.parse(param1URL, CTTableCol.type, null);
    }
    
    public static CTTableCol parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableCol)POIXMLTypeLoader.parse(param1URL, CTTableCol.type, param1XmlOptions);
    }
    
    public static CTTableCol parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTableCol)POIXMLTypeLoader.parse(param1InputStream, CTTableCol.type, null);
    }
    
    public static CTTableCol parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableCol)POIXMLTypeLoader.parse(param1InputStream, CTTableCol.type, param1XmlOptions);
    }
    
    public static CTTableCol parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTableCol)POIXMLTypeLoader.parse(param1Reader, CTTableCol.type, null);
    }
    
    public static CTTableCol parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableCol)POIXMLTypeLoader.parse(param1Reader, CTTableCol.type, param1XmlOptions);
    }
    
    public static CTTableCol parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTableCol)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableCol.type, null);
    }
    
    public static CTTableCol parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableCol)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableCol.type, param1XmlOptions);
    }
    
    public static CTTableCol parse(Node param1Node) throws XmlException {
      return (CTTableCol)POIXMLTypeLoader.parse(param1Node, CTTableCol.type, null);
    }
    
    public static CTTableCol parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableCol)POIXMLTypeLoader.parse(param1Node, CTTableCol.type, param1XmlOptions);
    }
    
    public static CTTableCol parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTableCol)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableCol.type, null);
    }
    
    public static CTTableCol parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTableCol)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableCol.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableCol.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableCol.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTableCol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */