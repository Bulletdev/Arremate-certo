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

public interface CTShapeStyle extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTShapeStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctshapestyle81ebtype");
  
  CTStyleMatrixReference getLnRef();
  
  void setLnRef(CTStyleMatrixReference paramCTStyleMatrixReference);
  
  CTStyleMatrixReference addNewLnRef();
  
  CTStyleMatrixReference getFillRef();
  
  void setFillRef(CTStyleMatrixReference paramCTStyleMatrixReference);
  
  CTStyleMatrixReference addNewFillRef();
  
  CTStyleMatrixReference getEffectRef();
  
  void setEffectRef(CTStyleMatrixReference paramCTStyleMatrixReference);
  
  CTStyleMatrixReference addNewEffectRef();
  
  CTFontReference getFontRef();
  
  void setFontRef(CTFontReference paramCTFontReference);
  
  CTFontReference addNewFontRef();
  
  public static final class Factory {
    public static CTShapeStyle newInstance() {
      return (CTShapeStyle)POIXMLTypeLoader.newInstance(CTShapeStyle.type, null);
    }
    
    public static CTShapeStyle newInstance(XmlOptions param1XmlOptions) {
      return (CTShapeStyle)POIXMLTypeLoader.newInstance(CTShapeStyle.type, param1XmlOptions);
    }
    
    public static CTShapeStyle parse(String param1String) throws XmlException {
      return (CTShapeStyle)POIXMLTypeLoader.parse(param1String, CTShapeStyle.type, null);
    }
    
    public static CTShapeStyle parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShapeStyle)POIXMLTypeLoader.parse(param1String, CTShapeStyle.type, param1XmlOptions);
    }
    
    public static CTShapeStyle parse(File param1File) throws XmlException, IOException {
      return (CTShapeStyle)POIXMLTypeLoader.parse(param1File, CTShapeStyle.type, null);
    }
    
    public static CTShapeStyle parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShapeStyle)POIXMLTypeLoader.parse(param1File, CTShapeStyle.type, param1XmlOptions);
    }
    
    public static CTShapeStyle parse(URL param1URL) throws XmlException, IOException {
      return (CTShapeStyle)POIXMLTypeLoader.parse(param1URL, CTShapeStyle.type, null);
    }
    
    public static CTShapeStyle parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShapeStyle)POIXMLTypeLoader.parse(param1URL, CTShapeStyle.type, param1XmlOptions);
    }
    
    public static CTShapeStyle parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTShapeStyle)POIXMLTypeLoader.parse(param1InputStream, CTShapeStyle.type, null);
    }
    
    public static CTShapeStyle parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShapeStyle)POIXMLTypeLoader.parse(param1InputStream, CTShapeStyle.type, param1XmlOptions);
    }
    
    public static CTShapeStyle parse(Reader param1Reader) throws XmlException, IOException {
      return (CTShapeStyle)POIXMLTypeLoader.parse(param1Reader, CTShapeStyle.type, null);
    }
    
    public static CTShapeStyle parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShapeStyle)POIXMLTypeLoader.parse(param1Reader, CTShapeStyle.type, param1XmlOptions);
    }
    
    public static CTShapeStyle parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTShapeStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, CTShapeStyle.type, null);
    }
    
    public static CTShapeStyle parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShapeStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, CTShapeStyle.type, param1XmlOptions);
    }
    
    public static CTShapeStyle parse(Node param1Node) throws XmlException {
      return (CTShapeStyle)POIXMLTypeLoader.parse(param1Node, CTShapeStyle.type, null);
    }
    
    public static CTShapeStyle parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShapeStyle)POIXMLTypeLoader.parse(param1Node, CTShapeStyle.type, param1XmlOptions);
    }
    
    public static CTShapeStyle parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTShapeStyle)POIXMLTypeLoader.parse(param1XMLInputStream, CTShapeStyle.type, null);
    }
    
    public static CTShapeStyle parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTShapeStyle)POIXMLTypeLoader.parse(param1XMLInputStream, CTShapeStyle.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTShapeStyle.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTShapeStyle.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTShapeStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */