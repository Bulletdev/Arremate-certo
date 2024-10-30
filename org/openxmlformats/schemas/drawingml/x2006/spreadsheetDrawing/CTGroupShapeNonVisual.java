package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps;
import org.w3c.dom.Node;

public interface CTGroupShapeNonVisual extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTGroupShapeNonVisual.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgroupshapenonvisual5a55type");
  
  CTNonVisualDrawingProps getCNvPr();
  
  void setCNvPr(CTNonVisualDrawingProps paramCTNonVisualDrawingProps);
  
  CTNonVisualDrawingProps addNewCNvPr();
  
  CTNonVisualGroupDrawingShapeProps getCNvGrpSpPr();
  
  void setCNvGrpSpPr(CTNonVisualGroupDrawingShapeProps paramCTNonVisualGroupDrawingShapeProps);
  
  CTNonVisualGroupDrawingShapeProps addNewCNvGrpSpPr();
  
  public static final class Factory {
    public static CTGroupShapeNonVisual newInstance() {
      return (CTGroupShapeNonVisual)POIXMLTypeLoader.newInstance(CTGroupShapeNonVisual.type, null);
    }
    
    public static CTGroupShapeNonVisual newInstance(XmlOptions param1XmlOptions) {
      return (CTGroupShapeNonVisual)POIXMLTypeLoader.newInstance(CTGroupShapeNonVisual.type, param1XmlOptions);
    }
    
    public static CTGroupShapeNonVisual parse(String param1String) throws XmlException {
      return (CTGroupShapeNonVisual)POIXMLTypeLoader.parse(param1String, CTGroupShapeNonVisual.type, null);
    }
    
    public static CTGroupShapeNonVisual parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGroupShapeNonVisual)POIXMLTypeLoader.parse(param1String, CTGroupShapeNonVisual.type, param1XmlOptions);
    }
    
    public static CTGroupShapeNonVisual parse(File param1File) throws XmlException, IOException {
      return (CTGroupShapeNonVisual)POIXMLTypeLoader.parse(param1File, CTGroupShapeNonVisual.type, null);
    }
    
    public static CTGroupShapeNonVisual parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGroupShapeNonVisual)POIXMLTypeLoader.parse(param1File, CTGroupShapeNonVisual.type, param1XmlOptions);
    }
    
    public static CTGroupShapeNonVisual parse(URL param1URL) throws XmlException, IOException {
      return (CTGroupShapeNonVisual)POIXMLTypeLoader.parse(param1URL, CTGroupShapeNonVisual.type, null);
    }
    
    public static CTGroupShapeNonVisual parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGroupShapeNonVisual)POIXMLTypeLoader.parse(param1URL, CTGroupShapeNonVisual.type, param1XmlOptions);
    }
    
    public static CTGroupShapeNonVisual parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTGroupShapeNonVisual)POIXMLTypeLoader.parse(param1InputStream, CTGroupShapeNonVisual.type, null);
    }
    
    public static CTGroupShapeNonVisual parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGroupShapeNonVisual)POIXMLTypeLoader.parse(param1InputStream, CTGroupShapeNonVisual.type, param1XmlOptions);
    }
    
    public static CTGroupShapeNonVisual parse(Reader param1Reader) throws XmlException, IOException {
      return (CTGroupShapeNonVisual)POIXMLTypeLoader.parse(param1Reader, CTGroupShapeNonVisual.type, null);
    }
    
    public static CTGroupShapeNonVisual parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGroupShapeNonVisual)POIXMLTypeLoader.parse(param1Reader, CTGroupShapeNonVisual.type, param1XmlOptions);
    }
    
    public static CTGroupShapeNonVisual parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTGroupShapeNonVisual)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGroupShapeNonVisual.type, null);
    }
    
    public static CTGroupShapeNonVisual parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGroupShapeNonVisual)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGroupShapeNonVisual.type, param1XmlOptions);
    }
    
    public static CTGroupShapeNonVisual parse(Node param1Node) throws XmlException {
      return (CTGroupShapeNonVisual)POIXMLTypeLoader.parse(param1Node, CTGroupShapeNonVisual.type, null);
    }
    
    public static CTGroupShapeNonVisual parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGroupShapeNonVisual)POIXMLTypeLoader.parse(param1Node, CTGroupShapeNonVisual.type, param1XmlOptions);
    }
    
    public static CTGroupShapeNonVisual parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTGroupShapeNonVisual)POIXMLTypeLoader.parse(param1XMLInputStream, CTGroupShapeNonVisual.type, null);
    }
    
    public static CTGroupShapeNonVisual parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTGroupShapeNonVisual)POIXMLTypeLoader.parse(param1XMLInputStream, CTGroupShapeNonVisual.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGroupShapeNonVisual.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGroupShapeNonVisual.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\spreadsheetDrawing\CTGroupShapeNonVisual.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */