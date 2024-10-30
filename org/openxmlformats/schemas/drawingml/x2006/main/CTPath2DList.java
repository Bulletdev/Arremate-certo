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

public interface CTPath2DList extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPath2DList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpath2dlistb010type");
  
  List<CTPath2D> getPathList();
  
  CTPath2D[] getPathArray();
  
  CTPath2D getPathArray(int paramInt);
  
  int sizeOfPathArray();
  
  void setPathArray(CTPath2D[] paramArrayOfCTPath2D);
  
  void setPathArray(int paramInt, CTPath2D paramCTPath2D);
  
  CTPath2D insertNewPath(int paramInt);
  
  CTPath2D addNewPath();
  
  void removePath(int paramInt);
  
  public static final class Factory {
    public static CTPath2DList newInstance() {
      return (CTPath2DList)POIXMLTypeLoader.newInstance(CTPath2DList.type, null);
    }
    
    public static CTPath2DList newInstance(XmlOptions param1XmlOptions) {
      return (CTPath2DList)POIXMLTypeLoader.newInstance(CTPath2DList.type, param1XmlOptions);
    }
    
    public static CTPath2DList parse(String param1String) throws XmlException {
      return (CTPath2DList)POIXMLTypeLoader.parse(param1String, CTPath2DList.type, null);
    }
    
    public static CTPath2DList parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPath2DList)POIXMLTypeLoader.parse(param1String, CTPath2DList.type, param1XmlOptions);
    }
    
    public static CTPath2DList parse(File param1File) throws XmlException, IOException {
      return (CTPath2DList)POIXMLTypeLoader.parse(param1File, CTPath2DList.type, null);
    }
    
    public static CTPath2DList parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPath2DList)POIXMLTypeLoader.parse(param1File, CTPath2DList.type, param1XmlOptions);
    }
    
    public static CTPath2DList parse(URL param1URL) throws XmlException, IOException {
      return (CTPath2DList)POIXMLTypeLoader.parse(param1URL, CTPath2DList.type, null);
    }
    
    public static CTPath2DList parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPath2DList)POIXMLTypeLoader.parse(param1URL, CTPath2DList.type, param1XmlOptions);
    }
    
    public static CTPath2DList parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPath2DList)POIXMLTypeLoader.parse(param1InputStream, CTPath2DList.type, null);
    }
    
    public static CTPath2DList parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPath2DList)POIXMLTypeLoader.parse(param1InputStream, CTPath2DList.type, param1XmlOptions);
    }
    
    public static CTPath2DList parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPath2DList)POIXMLTypeLoader.parse(param1Reader, CTPath2DList.type, null);
    }
    
    public static CTPath2DList parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPath2DList)POIXMLTypeLoader.parse(param1Reader, CTPath2DList.type, param1XmlOptions);
    }
    
    public static CTPath2DList parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPath2DList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPath2DList.type, null);
    }
    
    public static CTPath2DList parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPath2DList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPath2DList.type, param1XmlOptions);
    }
    
    public static CTPath2DList parse(Node param1Node) throws XmlException {
      return (CTPath2DList)POIXMLTypeLoader.parse(param1Node, CTPath2DList.type, null);
    }
    
    public static CTPath2DList parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPath2DList)POIXMLTypeLoader.parse(param1Node, CTPath2DList.type, param1XmlOptions);
    }
    
    public static CTPath2DList parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPath2DList)POIXMLTypeLoader.parse(param1XMLInputStream, CTPath2DList.type, null);
    }
    
    public static CTPath2DList parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPath2DList)POIXMLTypeLoader.parse(param1XMLInputStream, CTPath2DList.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPath2DList.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPath2DList.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTPath2DList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */