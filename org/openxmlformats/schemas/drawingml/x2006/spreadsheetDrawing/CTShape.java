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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.w3c.dom.Node;

public interface CTShape extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTShape.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctshapee40btype");
  
  CTShapeNonVisual getNvSpPr();
  
  void setNvSpPr(CTShapeNonVisual paramCTShapeNonVisual);
  
  CTShapeNonVisual addNewNvSpPr();
  
  CTShapeProperties getSpPr();
  
  void setSpPr(CTShapeProperties paramCTShapeProperties);
  
  CTShapeProperties addNewSpPr();
  
  CTShapeStyle getStyle();
  
  boolean isSetStyle();
  
  void setStyle(CTShapeStyle paramCTShapeStyle);
  
  CTShapeStyle addNewStyle();
  
  void unsetStyle();
  
  CTTextBody getTxBody();
  
  boolean isSetTxBody();
  
  void setTxBody(CTTextBody paramCTTextBody);
  
  CTTextBody addNewTxBody();
  
  void unsetTxBody();
  
  String getMacro();
  
  XmlString xgetMacro();
  
  boolean isSetMacro();
  
  void setMacro(String paramString);
  
  void xsetMacro(XmlString paramXmlString);
  
  void unsetMacro();
  
  String getTextlink();
  
  XmlString xgetTextlink();
  
  boolean isSetTextlink();
  
  void setTextlink(String paramString);
  
  void xsetTextlink(XmlString paramXmlString);
  
  void unsetTextlink();
  
  boolean getFLocksText();
  
  XmlBoolean xgetFLocksText();
  
  boolean isSetFLocksText();
  
  void setFLocksText(boolean paramBoolean);
  
  void xsetFLocksText(XmlBoolean paramXmlBoolean);
  
  void unsetFLocksText();
  
  boolean getFPublished();
  
  XmlBoolean xgetFPublished();
  
  boolean isSetFPublished();
  
  void setFPublished(boolean paramBoolean);
  
  void xsetFPublished(XmlBoolean paramXmlBoolean);
  
  void unsetFPublished();
  
  public static final class Factory {
    public static CTShape newInstance() {
      return (CTShape)POIXMLTypeLoader.newInstance(CTShape.type, null);
    }
    
    public static CTShape newInstance(XmlOptions param1XmlOptions) {
      return (CTShape)POIXMLTypeLoader.newInstance(CTShape.type, param1XmlOptions);
    }
    
    public static CTShape parse(String param1String) throws XmlException {
      return (CTShape)POIXMLTypeLoader.parse(param1String, CTShape.type, null);
    }
    
    public static CTShape parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShape)POIXMLTypeLoader.parse(param1String, CTShape.type, param1XmlOptions);
    }
    
    public static CTShape parse(File param1File) throws XmlException, IOException {
      return (CTShape)POIXMLTypeLoader.parse(param1File, CTShape.type, null);
    }
    
    public static CTShape parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShape)POIXMLTypeLoader.parse(param1File, CTShape.type, param1XmlOptions);
    }
    
    public static CTShape parse(URL param1URL) throws XmlException, IOException {
      return (CTShape)POIXMLTypeLoader.parse(param1URL, CTShape.type, null);
    }
    
    public static CTShape parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShape)POIXMLTypeLoader.parse(param1URL, CTShape.type, param1XmlOptions);
    }
    
    public static CTShape parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTShape)POIXMLTypeLoader.parse(param1InputStream, CTShape.type, null);
    }
    
    public static CTShape parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShape)POIXMLTypeLoader.parse(param1InputStream, CTShape.type, param1XmlOptions);
    }
    
    public static CTShape parse(Reader param1Reader) throws XmlException, IOException {
      return (CTShape)POIXMLTypeLoader.parse(param1Reader, CTShape.type, null);
    }
    
    public static CTShape parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShape)POIXMLTypeLoader.parse(param1Reader, CTShape.type, param1XmlOptions);
    }
    
    public static CTShape parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTShape)POIXMLTypeLoader.parse(param1XMLStreamReader, CTShape.type, null);
    }
    
    public static CTShape parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShape)POIXMLTypeLoader.parse(param1XMLStreamReader, CTShape.type, param1XmlOptions);
    }
    
    public static CTShape parse(Node param1Node) throws XmlException {
      return (CTShape)POIXMLTypeLoader.parse(param1Node, CTShape.type, null);
    }
    
    public static CTShape parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShape)POIXMLTypeLoader.parse(param1Node, CTShape.type, param1XmlOptions);
    }
    
    public static CTShape parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTShape)POIXMLTypeLoader.parse(param1XMLInputStream, CTShape.type, null);
    }
    
    public static CTShape parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTShape)POIXMLTypeLoader.parse(param1XMLInputStream, CTShape.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTShape.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTShape.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\spreadsheetDrawing\CTShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */