package com.microsoft.schemas.office.visio.x2012.main;

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

public interface ShapesType extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(ShapesType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("shapestypef507type");
  
  List<ShapeSheetType> getShapeList();
  
  ShapeSheetType[] getShapeArray();
  
  ShapeSheetType getShapeArray(int paramInt);
  
  int sizeOfShapeArray();
  
  void setShapeArray(ShapeSheetType[] paramArrayOfShapeSheetType);
  
  void setShapeArray(int paramInt, ShapeSheetType paramShapeSheetType);
  
  ShapeSheetType insertNewShape(int paramInt);
  
  ShapeSheetType addNewShape();
  
  void removeShape(int paramInt);
  
  public static final class Factory {
    public static ShapesType newInstance() {
      return (ShapesType)POIXMLTypeLoader.newInstance(ShapesType.type, null);
    }
    
    public static ShapesType newInstance(XmlOptions param1XmlOptions) {
      return (ShapesType)POIXMLTypeLoader.newInstance(ShapesType.type, param1XmlOptions);
    }
    
    public static ShapesType parse(String param1String) throws XmlException {
      return (ShapesType)POIXMLTypeLoader.parse(param1String, ShapesType.type, null);
    }
    
    public static ShapesType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (ShapesType)POIXMLTypeLoader.parse(param1String, ShapesType.type, param1XmlOptions);
    }
    
    public static ShapesType parse(File param1File) throws XmlException, IOException {
      return (ShapesType)POIXMLTypeLoader.parse(param1File, ShapesType.type, null);
    }
    
    public static ShapesType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ShapesType)POIXMLTypeLoader.parse(param1File, ShapesType.type, param1XmlOptions);
    }
    
    public static ShapesType parse(URL param1URL) throws XmlException, IOException {
      return (ShapesType)POIXMLTypeLoader.parse(param1URL, ShapesType.type, null);
    }
    
    public static ShapesType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ShapesType)POIXMLTypeLoader.parse(param1URL, ShapesType.type, param1XmlOptions);
    }
    
    public static ShapesType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (ShapesType)POIXMLTypeLoader.parse(param1InputStream, ShapesType.type, null);
    }
    
    public static ShapesType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ShapesType)POIXMLTypeLoader.parse(param1InputStream, ShapesType.type, param1XmlOptions);
    }
    
    public static ShapesType parse(Reader param1Reader) throws XmlException, IOException {
      return (ShapesType)POIXMLTypeLoader.parse(param1Reader, ShapesType.type, null);
    }
    
    public static ShapesType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ShapesType)POIXMLTypeLoader.parse(param1Reader, ShapesType.type, param1XmlOptions);
    }
    
    public static ShapesType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (ShapesType)POIXMLTypeLoader.parse(param1XMLStreamReader, ShapesType.type, null);
    }
    
    public static ShapesType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (ShapesType)POIXMLTypeLoader.parse(param1XMLStreamReader, ShapesType.type, param1XmlOptions);
    }
    
    public static ShapesType parse(Node param1Node) throws XmlException {
      return (ShapesType)POIXMLTypeLoader.parse(param1Node, ShapesType.type, null);
    }
    
    public static ShapesType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (ShapesType)POIXMLTypeLoader.parse(param1Node, ShapesType.type, param1XmlOptions);
    }
    
    public static ShapesType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (ShapesType)POIXMLTypeLoader.parse(param1XMLInputStream, ShapesType.type, null);
    }
    
    public static ShapesType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (ShapesType)POIXMLTypeLoader.parse(param1XMLInputStream, ShapesType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, ShapesType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, ShapesType.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\ShapesType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */