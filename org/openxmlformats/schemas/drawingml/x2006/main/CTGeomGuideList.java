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

public interface CTGeomGuideList extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTGeomGuideList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgeomguidelist364ftype");
  
  List<CTGeomGuide> getGdList();
  
  CTGeomGuide[] getGdArray();
  
  CTGeomGuide getGdArray(int paramInt);
  
  int sizeOfGdArray();
  
  void setGdArray(CTGeomGuide[] paramArrayOfCTGeomGuide);
  
  void setGdArray(int paramInt, CTGeomGuide paramCTGeomGuide);
  
  CTGeomGuide insertNewGd(int paramInt);
  
  CTGeomGuide addNewGd();
  
  void removeGd(int paramInt);
  
  public static final class Factory {
    public static CTGeomGuideList newInstance() {
      return (CTGeomGuideList)POIXMLTypeLoader.newInstance(CTGeomGuideList.type, null);
    }
    
    public static CTGeomGuideList newInstance(XmlOptions param1XmlOptions) {
      return (CTGeomGuideList)POIXMLTypeLoader.newInstance(CTGeomGuideList.type, param1XmlOptions);
    }
    
    public static CTGeomGuideList parse(String param1String) throws XmlException {
      return (CTGeomGuideList)POIXMLTypeLoader.parse(param1String, CTGeomGuideList.type, null);
    }
    
    public static CTGeomGuideList parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGeomGuideList)POIXMLTypeLoader.parse(param1String, CTGeomGuideList.type, param1XmlOptions);
    }
    
    public static CTGeomGuideList parse(File param1File) throws XmlException, IOException {
      return (CTGeomGuideList)POIXMLTypeLoader.parse(param1File, CTGeomGuideList.type, null);
    }
    
    public static CTGeomGuideList parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGeomGuideList)POIXMLTypeLoader.parse(param1File, CTGeomGuideList.type, param1XmlOptions);
    }
    
    public static CTGeomGuideList parse(URL param1URL) throws XmlException, IOException {
      return (CTGeomGuideList)POIXMLTypeLoader.parse(param1URL, CTGeomGuideList.type, null);
    }
    
    public static CTGeomGuideList parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGeomGuideList)POIXMLTypeLoader.parse(param1URL, CTGeomGuideList.type, param1XmlOptions);
    }
    
    public static CTGeomGuideList parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTGeomGuideList)POIXMLTypeLoader.parse(param1InputStream, CTGeomGuideList.type, null);
    }
    
    public static CTGeomGuideList parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGeomGuideList)POIXMLTypeLoader.parse(param1InputStream, CTGeomGuideList.type, param1XmlOptions);
    }
    
    public static CTGeomGuideList parse(Reader param1Reader) throws XmlException, IOException {
      return (CTGeomGuideList)POIXMLTypeLoader.parse(param1Reader, CTGeomGuideList.type, null);
    }
    
    public static CTGeomGuideList parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGeomGuideList)POIXMLTypeLoader.parse(param1Reader, CTGeomGuideList.type, param1XmlOptions);
    }
    
    public static CTGeomGuideList parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTGeomGuideList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGeomGuideList.type, null);
    }
    
    public static CTGeomGuideList parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGeomGuideList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGeomGuideList.type, param1XmlOptions);
    }
    
    public static CTGeomGuideList parse(Node param1Node) throws XmlException {
      return (CTGeomGuideList)POIXMLTypeLoader.parse(param1Node, CTGeomGuideList.type, null);
    }
    
    public static CTGeomGuideList parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGeomGuideList)POIXMLTypeLoader.parse(param1Node, CTGeomGuideList.type, param1XmlOptions);
    }
    
    public static CTGeomGuideList parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTGeomGuideList)POIXMLTypeLoader.parse(param1XMLInputStream, CTGeomGuideList.type, null);
    }
    
    public static CTGeomGuideList parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTGeomGuideList)POIXMLTypeLoader.parse(param1XMLInputStream, CTGeomGuideList.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGeomGuideList.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGeomGuideList.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTGeomGuideList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */