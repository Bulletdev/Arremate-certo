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

public interface CTLineStyleList extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTLineStyleList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlinestylelist510ctype");
  
  List<CTLineProperties> getLnList();
  
  CTLineProperties[] getLnArray();
  
  CTLineProperties getLnArray(int paramInt);
  
  int sizeOfLnArray();
  
  void setLnArray(CTLineProperties[] paramArrayOfCTLineProperties);
  
  void setLnArray(int paramInt, CTLineProperties paramCTLineProperties);
  
  CTLineProperties insertNewLn(int paramInt);
  
  CTLineProperties addNewLn();
  
  void removeLn(int paramInt);
  
  public static final class Factory {
    public static CTLineStyleList newInstance() {
      return (CTLineStyleList)POIXMLTypeLoader.newInstance(CTLineStyleList.type, null);
    }
    
    public static CTLineStyleList newInstance(XmlOptions param1XmlOptions) {
      return (CTLineStyleList)POIXMLTypeLoader.newInstance(CTLineStyleList.type, param1XmlOptions);
    }
    
    public static CTLineStyleList parse(String param1String) throws XmlException {
      return (CTLineStyleList)POIXMLTypeLoader.parse(param1String, CTLineStyleList.type, null);
    }
    
    public static CTLineStyleList parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLineStyleList)POIXMLTypeLoader.parse(param1String, CTLineStyleList.type, param1XmlOptions);
    }
    
    public static CTLineStyleList parse(File param1File) throws XmlException, IOException {
      return (CTLineStyleList)POIXMLTypeLoader.parse(param1File, CTLineStyleList.type, null);
    }
    
    public static CTLineStyleList parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineStyleList)POIXMLTypeLoader.parse(param1File, CTLineStyleList.type, param1XmlOptions);
    }
    
    public static CTLineStyleList parse(URL param1URL) throws XmlException, IOException {
      return (CTLineStyleList)POIXMLTypeLoader.parse(param1URL, CTLineStyleList.type, null);
    }
    
    public static CTLineStyleList parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineStyleList)POIXMLTypeLoader.parse(param1URL, CTLineStyleList.type, param1XmlOptions);
    }
    
    public static CTLineStyleList parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTLineStyleList)POIXMLTypeLoader.parse(param1InputStream, CTLineStyleList.type, null);
    }
    
    public static CTLineStyleList parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineStyleList)POIXMLTypeLoader.parse(param1InputStream, CTLineStyleList.type, param1XmlOptions);
    }
    
    public static CTLineStyleList parse(Reader param1Reader) throws XmlException, IOException {
      return (CTLineStyleList)POIXMLTypeLoader.parse(param1Reader, CTLineStyleList.type, null);
    }
    
    public static CTLineStyleList parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineStyleList)POIXMLTypeLoader.parse(param1Reader, CTLineStyleList.type, param1XmlOptions);
    }
    
    public static CTLineStyleList parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTLineStyleList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLineStyleList.type, null);
    }
    
    public static CTLineStyleList parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLineStyleList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLineStyleList.type, param1XmlOptions);
    }
    
    public static CTLineStyleList parse(Node param1Node) throws XmlException {
      return (CTLineStyleList)POIXMLTypeLoader.parse(param1Node, CTLineStyleList.type, null);
    }
    
    public static CTLineStyleList parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLineStyleList)POIXMLTypeLoader.parse(param1Node, CTLineStyleList.type, param1XmlOptions);
    }
    
    public static CTLineStyleList parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTLineStyleList)POIXMLTypeLoader.parse(param1XMLInputStream, CTLineStyleList.type, null);
    }
    
    public static CTLineStyleList parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTLineStyleList)POIXMLTypeLoader.parse(param1XMLInputStream, CTLineStyleList.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLineStyleList.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLineStyleList.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTLineStyleList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */