package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingShapeProps;
import org.w3c.dom.Node;

public interface CTShapeNonVisual extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTShapeNonVisual.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctshapenonvisualb619type");
  
  CTNonVisualDrawingProps getCNvPr();
  
  void setCNvPr(CTNonVisualDrawingProps paramCTNonVisualDrawingProps);
  
  CTNonVisualDrawingProps addNewCNvPr();
  
  CTNonVisualDrawingShapeProps getCNvSpPr();
  
  void setCNvSpPr(CTNonVisualDrawingShapeProps paramCTNonVisualDrawingShapeProps);
  
  CTNonVisualDrawingShapeProps addNewCNvSpPr();
  
  CTApplicationNonVisualDrawingProps getNvPr();
  
  void setNvPr(CTApplicationNonVisualDrawingProps paramCTApplicationNonVisualDrawingProps);
  
  CTApplicationNonVisualDrawingProps addNewNvPr();
  
  public static final class Factory {
    public static CTShapeNonVisual newInstance() {
      return (CTShapeNonVisual)POIXMLTypeLoader.newInstance(CTShapeNonVisual.type, null);
    }
    
    public static CTShapeNonVisual newInstance(XmlOptions param1XmlOptions) {
      return (CTShapeNonVisual)POIXMLTypeLoader.newInstance(CTShapeNonVisual.type, param1XmlOptions);
    }
    
    public static CTShapeNonVisual parse(String param1String) throws XmlException {
      return (CTShapeNonVisual)POIXMLTypeLoader.parse(param1String, CTShapeNonVisual.type, null);
    }
    
    public static CTShapeNonVisual parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShapeNonVisual)POIXMLTypeLoader.parse(param1String, CTShapeNonVisual.type, param1XmlOptions);
    }
    
    public static CTShapeNonVisual parse(File param1File) throws XmlException, IOException {
      return (CTShapeNonVisual)POIXMLTypeLoader.parse(param1File, CTShapeNonVisual.type, null);
    }
    
    public static CTShapeNonVisual parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShapeNonVisual)POIXMLTypeLoader.parse(param1File, CTShapeNonVisual.type, param1XmlOptions);
    }
    
    public static CTShapeNonVisual parse(URL param1URL) throws XmlException, IOException {
      return (CTShapeNonVisual)POIXMLTypeLoader.parse(param1URL, CTShapeNonVisual.type, null);
    }
    
    public static CTShapeNonVisual parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShapeNonVisual)POIXMLTypeLoader.parse(param1URL, CTShapeNonVisual.type, param1XmlOptions);
    }
    
    public static CTShapeNonVisual parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTShapeNonVisual)POIXMLTypeLoader.parse(param1InputStream, CTShapeNonVisual.type, null);
    }
    
    public static CTShapeNonVisual parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShapeNonVisual)POIXMLTypeLoader.parse(param1InputStream, CTShapeNonVisual.type, param1XmlOptions);
    }
    
    public static CTShapeNonVisual parse(Reader param1Reader) throws XmlException, IOException {
      return (CTShapeNonVisual)POIXMLTypeLoader.parse(param1Reader, CTShapeNonVisual.type, null);
    }
    
    public static CTShapeNonVisual parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShapeNonVisual)POIXMLTypeLoader.parse(param1Reader, CTShapeNonVisual.type, param1XmlOptions);
    }
    
    public static CTShapeNonVisual parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTShapeNonVisual)POIXMLTypeLoader.parse(param1XMLStreamReader, CTShapeNonVisual.type, null);
    }
    
    public static CTShapeNonVisual parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShapeNonVisual)POIXMLTypeLoader.parse(param1XMLStreamReader, CTShapeNonVisual.type, param1XmlOptions);
    }
    
    public static CTShapeNonVisual parse(Node param1Node) throws XmlException {
      return (CTShapeNonVisual)POIXMLTypeLoader.parse(param1Node, CTShapeNonVisual.type, null);
    }
    
    public static CTShapeNonVisual parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShapeNonVisual)POIXMLTypeLoader.parse(param1Node, CTShapeNonVisual.type, param1XmlOptions);
    }
    
    public static CTShapeNonVisual parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTShapeNonVisual)POIXMLTypeLoader.parse(param1XMLInputStream, CTShapeNonVisual.type, null);
    }
    
    public static CTShapeNonVisual parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTShapeNonVisual)POIXMLTypeLoader.parse(param1XMLInputStream, CTShapeNonVisual.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTShapeNonVisual.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTShapeNonVisual.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTShapeNonVisual.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */