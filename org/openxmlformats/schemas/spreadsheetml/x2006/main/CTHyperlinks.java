package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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

public interface CTHyperlinks extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTHyperlinks.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cthyperlinks6416type");
  
  List<CTHyperlink> getHyperlinkList();
  
  CTHyperlink[] getHyperlinkArray();
  
  CTHyperlink getHyperlinkArray(int paramInt);
  
  int sizeOfHyperlinkArray();
  
  void setHyperlinkArray(CTHyperlink[] paramArrayOfCTHyperlink);
  
  void setHyperlinkArray(int paramInt, CTHyperlink paramCTHyperlink);
  
  CTHyperlink insertNewHyperlink(int paramInt);
  
  CTHyperlink addNewHyperlink();
  
  void removeHyperlink(int paramInt);
  
  public static final class Factory {
    public static CTHyperlinks newInstance() {
      return (CTHyperlinks)POIXMLTypeLoader.newInstance(CTHyperlinks.type, null);
    }
    
    public static CTHyperlinks newInstance(XmlOptions param1XmlOptions) {
      return (CTHyperlinks)POIXMLTypeLoader.newInstance(CTHyperlinks.type, param1XmlOptions);
    }
    
    public static CTHyperlinks parse(String param1String) throws XmlException {
      return (CTHyperlinks)POIXMLTypeLoader.parse(param1String, CTHyperlinks.type, null);
    }
    
    public static CTHyperlinks parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHyperlinks)POIXMLTypeLoader.parse(param1String, CTHyperlinks.type, param1XmlOptions);
    }
    
    public static CTHyperlinks parse(File param1File) throws XmlException, IOException {
      return (CTHyperlinks)POIXMLTypeLoader.parse(param1File, CTHyperlinks.type, null);
    }
    
    public static CTHyperlinks parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHyperlinks)POIXMLTypeLoader.parse(param1File, CTHyperlinks.type, param1XmlOptions);
    }
    
    public static CTHyperlinks parse(URL param1URL) throws XmlException, IOException {
      return (CTHyperlinks)POIXMLTypeLoader.parse(param1URL, CTHyperlinks.type, null);
    }
    
    public static CTHyperlinks parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHyperlinks)POIXMLTypeLoader.parse(param1URL, CTHyperlinks.type, param1XmlOptions);
    }
    
    public static CTHyperlinks parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTHyperlinks)POIXMLTypeLoader.parse(param1InputStream, CTHyperlinks.type, null);
    }
    
    public static CTHyperlinks parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHyperlinks)POIXMLTypeLoader.parse(param1InputStream, CTHyperlinks.type, param1XmlOptions);
    }
    
    public static CTHyperlinks parse(Reader param1Reader) throws XmlException, IOException {
      return (CTHyperlinks)POIXMLTypeLoader.parse(param1Reader, CTHyperlinks.type, null);
    }
    
    public static CTHyperlinks parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHyperlinks)POIXMLTypeLoader.parse(param1Reader, CTHyperlinks.type, param1XmlOptions);
    }
    
    public static CTHyperlinks parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTHyperlinks)POIXMLTypeLoader.parse(param1XMLStreamReader, CTHyperlinks.type, null);
    }
    
    public static CTHyperlinks parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHyperlinks)POIXMLTypeLoader.parse(param1XMLStreamReader, CTHyperlinks.type, param1XmlOptions);
    }
    
    public static CTHyperlinks parse(Node param1Node) throws XmlException {
      return (CTHyperlinks)POIXMLTypeLoader.parse(param1Node, CTHyperlinks.type, null);
    }
    
    public static CTHyperlinks parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHyperlinks)POIXMLTypeLoader.parse(param1Node, CTHyperlinks.type, param1XmlOptions);
    }
    
    public static CTHyperlinks parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTHyperlinks)POIXMLTypeLoader.parse(param1XMLInputStream, CTHyperlinks.type, null);
    }
    
    public static CTHyperlinks parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTHyperlinks)POIXMLTypeLoader.parse(param1XMLInputStream, CTHyperlinks.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTHyperlinks.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTHyperlinks.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTHyperlinks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */