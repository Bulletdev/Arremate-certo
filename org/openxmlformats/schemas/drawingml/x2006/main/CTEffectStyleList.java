package org.openxmlformats.schemas.drawingml.x2006.main;

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

public interface CTEffectStyleList extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTEffectStyleList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cteffectstylelistc50ftype");
  
  List<CTEffectStyleItem> getEffectStyleList();
  
  CTEffectStyleItem[] getEffectStyleArray();
  
  CTEffectStyleItem getEffectStyleArray(int paramInt);
  
  int sizeOfEffectStyleArray();
  
  void setEffectStyleArray(CTEffectStyleItem[] paramArrayOfCTEffectStyleItem);
  
  void setEffectStyleArray(int paramInt, CTEffectStyleItem paramCTEffectStyleItem);
  
  CTEffectStyleItem insertNewEffectStyle(int paramInt);
  
  CTEffectStyleItem addNewEffectStyle();
  
  void removeEffectStyle(int paramInt);
  
  public static final class Factory {
    public static CTEffectStyleList newInstance() {
      return (CTEffectStyleList)POIXMLTypeLoader.newInstance(CTEffectStyleList.type, null);
    }
    
    public static CTEffectStyleList newInstance(XmlOptions param1XmlOptions) {
      return (CTEffectStyleList)POIXMLTypeLoader.newInstance(CTEffectStyleList.type, param1XmlOptions);
    }
    
    public static CTEffectStyleList parse(String param1String) throws XmlException {
      return (CTEffectStyleList)POIXMLTypeLoader.parse(param1String, CTEffectStyleList.type, null);
    }
    
    public static CTEffectStyleList parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTEffectStyleList)POIXMLTypeLoader.parse(param1String, CTEffectStyleList.type, param1XmlOptions);
    }
    
    public static CTEffectStyleList parse(File param1File) throws XmlException, IOException {
      return (CTEffectStyleList)POIXMLTypeLoader.parse(param1File, CTEffectStyleList.type, null);
    }
    
    public static CTEffectStyleList parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEffectStyleList)POIXMLTypeLoader.parse(param1File, CTEffectStyleList.type, param1XmlOptions);
    }
    
    public static CTEffectStyleList parse(URL param1URL) throws XmlException, IOException {
      return (CTEffectStyleList)POIXMLTypeLoader.parse(param1URL, CTEffectStyleList.type, null);
    }
    
    public static CTEffectStyleList parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEffectStyleList)POIXMLTypeLoader.parse(param1URL, CTEffectStyleList.type, param1XmlOptions);
    }
    
    public static CTEffectStyleList parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTEffectStyleList)POIXMLTypeLoader.parse(param1InputStream, CTEffectStyleList.type, null);
    }
    
    public static CTEffectStyleList parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEffectStyleList)POIXMLTypeLoader.parse(param1InputStream, CTEffectStyleList.type, param1XmlOptions);
    }
    
    public static CTEffectStyleList parse(Reader param1Reader) throws XmlException, IOException {
      return (CTEffectStyleList)POIXMLTypeLoader.parse(param1Reader, CTEffectStyleList.type, null);
    }
    
    public static CTEffectStyleList parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEffectStyleList)POIXMLTypeLoader.parse(param1Reader, CTEffectStyleList.type, param1XmlOptions);
    }
    
    public static CTEffectStyleList parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTEffectStyleList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTEffectStyleList.type, null);
    }
    
    public static CTEffectStyleList parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTEffectStyleList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTEffectStyleList.type, param1XmlOptions);
    }
    
    public static CTEffectStyleList parse(Node param1Node) throws XmlException {
      return (CTEffectStyleList)POIXMLTypeLoader.parse(param1Node, CTEffectStyleList.type, null);
    }
    
    public static CTEffectStyleList parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTEffectStyleList)POIXMLTypeLoader.parse(param1Node, CTEffectStyleList.type, param1XmlOptions);
    }
    
    public static CTEffectStyleList parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTEffectStyleList)POIXMLTypeLoader.parse(param1XMLInputStream, CTEffectStyleList.type, null);
    }
    
    public static CTEffectStyleList parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTEffectStyleList)POIXMLTypeLoader.parse(param1XMLInputStream, CTEffectStyleList.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTEffectStyleList.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTEffectStyleList.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTEffectStyleList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */