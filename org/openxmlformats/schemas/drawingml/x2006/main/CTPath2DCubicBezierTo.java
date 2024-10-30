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

public interface CTPath2DCubicBezierTo extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPath2DCubicBezierTo.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpath2dcubicbezierto5a1etype");
  
  List<CTAdjPoint2D> getPtList();
  
  CTAdjPoint2D[] getPtArray();
  
  CTAdjPoint2D getPtArray(int paramInt);
  
  int sizeOfPtArray();
  
  void setPtArray(CTAdjPoint2D[] paramArrayOfCTAdjPoint2D);
  
  void setPtArray(int paramInt, CTAdjPoint2D paramCTAdjPoint2D);
  
  CTAdjPoint2D insertNewPt(int paramInt);
  
  CTAdjPoint2D addNewPt();
  
  void removePt(int paramInt);
  
  public static final class Factory {
    public static CTPath2DCubicBezierTo newInstance() {
      return (CTPath2DCubicBezierTo)POIXMLTypeLoader.newInstance(CTPath2DCubicBezierTo.type, null);
    }
    
    public static CTPath2DCubicBezierTo newInstance(XmlOptions param1XmlOptions) {
      return (CTPath2DCubicBezierTo)POIXMLTypeLoader.newInstance(CTPath2DCubicBezierTo.type, param1XmlOptions);
    }
    
    public static CTPath2DCubicBezierTo parse(String param1String) throws XmlException {
      return (CTPath2DCubicBezierTo)POIXMLTypeLoader.parse(param1String, CTPath2DCubicBezierTo.type, null);
    }
    
    public static CTPath2DCubicBezierTo parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPath2DCubicBezierTo)POIXMLTypeLoader.parse(param1String, CTPath2DCubicBezierTo.type, param1XmlOptions);
    }
    
    public static CTPath2DCubicBezierTo parse(File param1File) throws XmlException, IOException {
      return (CTPath2DCubicBezierTo)POIXMLTypeLoader.parse(param1File, CTPath2DCubicBezierTo.type, null);
    }
    
    public static CTPath2DCubicBezierTo parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPath2DCubicBezierTo)POIXMLTypeLoader.parse(param1File, CTPath2DCubicBezierTo.type, param1XmlOptions);
    }
    
    public static CTPath2DCubicBezierTo parse(URL param1URL) throws XmlException, IOException {
      return (CTPath2DCubicBezierTo)POIXMLTypeLoader.parse(param1URL, CTPath2DCubicBezierTo.type, null);
    }
    
    public static CTPath2DCubicBezierTo parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPath2DCubicBezierTo)POIXMLTypeLoader.parse(param1URL, CTPath2DCubicBezierTo.type, param1XmlOptions);
    }
    
    public static CTPath2DCubicBezierTo parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPath2DCubicBezierTo)POIXMLTypeLoader.parse(param1InputStream, CTPath2DCubicBezierTo.type, null);
    }
    
    public static CTPath2DCubicBezierTo parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPath2DCubicBezierTo)POIXMLTypeLoader.parse(param1InputStream, CTPath2DCubicBezierTo.type, param1XmlOptions);
    }
    
    public static CTPath2DCubicBezierTo parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPath2DCubicBezierTo)POIXMLTypeLoader.parse(param1Reader, CTPath2DCubicBezierTo.type, null);
    }
    
    public static CTPath2DCubicBezierTo parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPath2DCubicBezierTo)POIXMLTypeLoader.parse(param1Reader, CTPath2DCubicBezierTo.type, param1XmlOptions);
    }
    
    public static CTPath2DCubicBezierTo parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPath2DCubicBezierTo)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPath2DCubicBezierTo.type, null);
    }
    
    public static CTPath2DCubicBezierTo parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPath2DCubicBezierTo)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPath2DCubicBezierTo.type, param1XmlOptions);
    }
    
    public static CTPath2DCubicBezierTo parse(Node param1Node) throws XmlException {
      return (CTPath2DCubicBezierTo)POIXMLTypeLoader.parse(param1Node, CTPath2DCubicBezierTo.type, null);
    }
    
    public static CTPath2DCubicBezierTo parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPath2DCubicBezierTo)POIXMLTypeLoader.parse(param1Node, CTPath2DCubicBezierTo.type, param1XmlOptions);
    }
    
    public static CTPath2DCubicBezierTo parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPath2DCubicBezierTo)POIXMLTypeLoader.parse(param1XMLInputStream, CTPath2DCubicBezierTo.type, null);
    }
    
    public static CTPath2DCubicBezierTo parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPath2DCubicBezierTo)POIXMLTypeLoader.parse(param1XMLInputStream, CTPath2DCubicBezierTo.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPath2DCubicBezierTo.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPath2DCubicBezierTo.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTPath2DCubicBezierTo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */