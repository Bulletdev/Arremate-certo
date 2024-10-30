package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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

public interface CTSmartTagPr extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSmartTagPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsmarttagprf715type");
  
  List<CTAttr> getAttrList();
  
  CTAttr[] getAttrArray();
  
  CTAttr getAttrArray(int paramInt);
  
  int sizeOfAttrArray();
  
  void setAttrArray(CTAttr[] paramArrayOfCTAttr);
  
  void setAttrArray(int paramInt, CTAttr paramCTAttr);
  
  CTAttr insertNewAttr(int paramInt);
  
  CTAttr addNewAttr();
  
  void removeAttr(int paramInt);
  
  public static final class Factory {
    public static CTSmartTagPr newInstance() {
      return (CTSmartTagPr)POIXMLTypeLoader.newInstance(CTSmartTagPr.type, null);
    }
    
    public static CTSmartTagPr newInstance(XmlOptions param1XmlOptions) {
      return (CTSmartTagPr)POIXMLTypeLoader.newInstance(CTSmartTagPr.type, param1XmlOptions);
    }
    
    public static CTSmartTagPr parse(String param1String) throws XmlException {
      return (CTSmartTagPr)POIXMLTypeLoader.parse(param1String, CTSmartTagPr.type, null);
    }
    
    public static CTSmartTagPr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSmartTagPr)POIXMLTypeLoader.parse(param1String, CTSmartTagPr.type, param1XmlOptions);
    }
    
    public static CTSmartTagPr parse(File param1File) throws XmlException, IOException {
      return (CTSmartTagPr)POIXMLTypeLoader.parse(param1File, CTSmartTagPr.type, null);
    }
    
    public static CTSmartTagPr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSmartTagPr)POIXMLTypeLoader.parse(param1File, CTSmartTagPr.type, param1XmlOptions);
    }
    
    public static CTSmartTagPr parse(URL param1URL) throws XmlException, IOException {
      return (CTSmartTagPr)POIXMLTypeLoader.parse(param1URL, CTSmartTagPr.type, null);
    }
    
    public static CTSmartTagPr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSmartTagPr)POIXMLTypeLoader.parse(param1URL, CTSmartTagPr.type, param1XmlOptions);
    }
    
    public static CTSmartTagPr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSmartTagPr)POIXMLTypeLoader.parse(param1InputStream, CTSmartTagPr.type, null);
    }
    
    public static CTSmartTagPr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSmartTagPr)POIXMLTypeLoader.parse(param1InputStream, CTSmartTagPr.type, param1XmlOptions);
    }
    
    public static CTSmartTagPr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSmartTagPr)POIXMLTypeLoader.parse(param1Reader, CTSmartTagPr.type, null);
    }
    
    public static CTSmartTagPr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSmartTagPr)POIXMLTypeLoader.parse(param1Reader, CTSmartTagPr.type, param1XmlOptions);
    }
    
    public static CTSmartTagPr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSmartTagPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSmartTagPr.type, null);
    }
    
    public static CTSmartTagPr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSmartTagPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSmartTagPr.type, param1XmlOptions);
    }
    
    public static CTSmartTagPr parse(Node param1Node) throws XmlException {
      return (CTSmartTagPr)POIXMLTypeLoader.parse(param1Node, CTSmartTagPr.type, null);
    }
    
    public static CTSmartTagPr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSmartTagPr)POIXMLTypeLoader.parse(param1Node, CTSmartTagPr.type, param1XmlOptions);
    }
    
    public static CTSmartTagPr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSmartTagPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTSmartTagPr.type, null);
    }
    
    public static CTSmartTagPr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSmartTagPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTSmartTagPr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSmartTagPr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSmartTagPr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTSmartTagPr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */