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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTNonVisualDrawingShapeProps extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTNonVisualDrawingShapeProps.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnonvisualdrawingshapepropsf17btype");
  
  CTShapeLocking getSpLocks();
  
  boolean isSetSpLocks();
  
  void setSpLocks(CTShapeLocking paramCTShapeLocking);
  
  CTShapeLocking addNewSpLocks();
  
  void unsetSpLocks();
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  boolean getTxBox();
  
  XmlBoolean xgetTxBox();
  
  boolean isSetTxBox();
  
  void setTxBox(boolean paramBoolean);
  
  void xsetTxBox(XmlBoolean paramXmlBoolean);
  
  void unsetTxBox();
  
  public static final class Factory {
    public static CTNonVisualDrawingShapeProps newInstance() {
      return (CTNonVisualDrawingShapeProps)POIXMLTypeLoader.newInstance(CTNonVisualDrawingShapeProps.type, null);
    }
    
    public static CTNonVisualDrawingShapeProps newInstance(XmlOptions param1XmlOptions) {
      return (CTNonVisualDrawingShapeProps)POIXMLTypeLoader.newInstance(CTNonVisualDrawingShapeProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualDrawingShapeProps parse(String param1String) throws XmlException {
      return (CTNonVisualDrawingShapeProps)POIXMLTypeLoader.parse(param1String, CTNonVisualDrawingShapeProps.type, null);
    }
    
    public static CTNonVisualDrawingShapeProps parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNonVisualDrawingShapeProps)POIXMLTypeLoader.parse(param1String, CTNonVisualDrawingShapeProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualDrawingShapeProps parse(File param1File) throws XmlException, IOException {
      return (CTNonVisualDrawingShapeProps)POIXMLTypeLoader.parse(param1File, CTNonVisualDrawingShapeProps.type, null);
    }
    
    public static CTNonVisualDrawingShapeProps parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNonVisualDrawingShapeProps)POIXMLTypeLoader.parse(param1File, CTNonVisualDrawingShapeProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualDrawingShapeProps parse(URL param1URL) throws XmlException, IOException {
      return (CTNonVisualDrawingShapeProps)POIXMLTypeLoader.parse(param1URL, CTNonVisualDrawingShapeProps.type, null);
    }
    
    public static CTNonVisualDrawingShapeProps parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNonVisualDrawingShapeProps)POIXMLTypeLoader.parse(param1URL, CTNonVisualDrawingShapeProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualDrawingShapeProps parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTNonVisualDrawingShapeProps)POIXMLTypeLoader.parse(param1InputStream, CTNonVisualDrawingShapeProps.type, null);
    }
    
    public static CTNonVisualDrawingShapeProps parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNonVisualDrawingShapeProps)POIXMLTypeLoader.parse(param1InputStream, CTNonVisualDrawingShapeProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualDrawingShapeProps parse(Reader param1Reader) throws XmlException, IOException {
      return (CTNonVisualDrawingShapeProps)POIXMLTypeLoader.parse(param1Reader, CTNonVisualDrawingShapeProps.type, null);
    }
    
    public static CTNonVisualDrawingShapeProps parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNonVisualDrawingShapeProps)POIXMLTypeLoader.parse(param1Reader, CTNonVisualDrawingShapeProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualDrawingShapeProps parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTNonVisualDrawingShapeProps)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNonVisualDrawingShapeProps.type, null);
    }
    
    public static CTNonVisualDrawingShapeProps parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNonVisualDrawingShapeProps)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNonVisualDrawingShapeProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualDrawingShapeProps parse(Node param1Node) throws XmlException {
      return (CTNonVisualDrawingShapeProps)POIXMLTypeLoader.parse(param1Node, CTNonVisualDrawingShapeProps.type, null);
    }
    
    public static CTNonVisualDrawingShapeProps parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNonVisualDrawingShapeProps)POIXMLTypeLoader.parse(param1Node, CTNonVisualDrawingShapeProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualDrawingShapeProps parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTNonVisualDrawingShapeProps)POIXMLTypeLoader.parse(param1XMLInputStream, CTNonVisualDrawingShapeProps.type, null);
    }
    
    public static CTNonVisualDrawingShapeProps parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTNonVisualDrawingShapeProps)POIXMLTypeLoader.parse(param1XMLInputStream, CTNonVisualDrawingShapeProps.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNonVisualDrawingShapeProps.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNonVisualDrawingShapeProps.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTNonVisualDrawingShapeProps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */