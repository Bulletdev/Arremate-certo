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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTNumRef extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTNumRef.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnumref062ftype");
  
  String getF();
  
  XmlString xgetF();
  
  void setF(String paramString);
  
  void xsetF(XmlString paramXmlString);
  
  CTNumData getNumCache();
  
  boolean isSetNumCache();
  
  void setNumCache(CTNumData paramCTNumData);
  
  CTNumData addNewNumCache();
  
  void unsetNumCache();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTNumRef newInstance() {
      return (CTNumRef)POIXMLTypeLoader.newInstance(CTNumRef.type, null);
    }
    
    public static CTNumRef newInstance(XmlOptions param1XmlOptions) {
      return (CTNumRef)POIXMLTypeLoader.newInstance(CTNumRef.type, param1XmlOptions);
    }
    
    public static CTNumRef parse(String param1String) throws XmlException {
      return (CTNumRef)POIXMLTypeLoader.parse(param1String, CTNumRef.type, null);
    }
    
    public static CTNumRef parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumRef)POIXMLTypeLoader.parse(param1String, CTNumRef.type, param1XmlOptions);
    }
    
    public static CTNumRef parse(File param1File) throws XmlException, IOException {
      return (CTNumRef)POIXMLTypeLoader.parse(param1File, CTNumRef.type, null);
    }
    
    public static CTNumRef parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumRef)POIXMLTypeLoader.parse(param1File, CTNumRef.type, param1XmlOptions);
    }
    
    public static CTNumRef parse(URL param1URL) throws XmlException, IOException {
      return (CTNumRef)POIXMLTypeLoader.parse(param1URL, CTNumRef.type, null);
    }
    
    public static CTNumRef parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumRef)POIXMLTypeLoader.parse(param1URL, CTNumRef.type, param1XmlOptions);
    }
    
    public static CTNumRef parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTNumRef)POIXMLTypeLoader.parse(param1InputStream, CTNumRef.type, null);
    }
    
    public static CTNumRef parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumRef)POIXMLTypeLoader.parse(param1InputStream, CTNumRef.type, param1XmlOptions);
    }
    
    public static CTNumRef parse(Reader param1Reader) throws XmlException, IOException {
      return (CTNumRef)POIXMLTypeLoader.parse(param1Reader, CTNumRef.type, null);
    }
    
    public static CTNumRef parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumRef)POIXMLTypeLoader.parse(param1Reader, CTNumRef.type, param1XmlOptions);
    }
    
    public static CTNumRef parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTNumRef)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNumRef.type, null);
    }
    
    public static CTNumRef parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumRef)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNumRef.type, param1XmlOptions);
    }
    
    public static CTNumRef parse(Node param1Node) throws XmlException {
      return (CTNumRef)POIXMLTypeLoader.parse(param1Node, CTNumRef.type, null);
    }
    
    public static CTNumRef parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumRef)POIXMLTypeLoader.parse(param1Node, CTNumRef.type, param1XmlOptions);
    }
    
    public static CTNumRef parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTNumRef)POIXMLTypeLoader.parse(param1XMLInputStream, CTNumRef.type, null);
    }
    
    public static CTNumRef parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTNumRef)POIXMLTypeLoader.parse(param1XMLInputStream, CTNumRef.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNumRef.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNumRef.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTNumRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */