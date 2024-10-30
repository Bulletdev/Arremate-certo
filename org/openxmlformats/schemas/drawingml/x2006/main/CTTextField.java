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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTTextField extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextField.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextfield187etype");
  
  CTTextCharacterProperties getRPr();
  
  boolean isSetRPr();
  
  void setRPr(CTTextCharacterProperties paramCTTextCharacterProperties);
  
  CTTextCharacterProperties addNewRPr();
  
  void unsetRPr();
  
  CTTextParagraphProperties getPPr();
  
  boolean isSetPPr();
  
  void setPPr(CTTextParagraphProperties paramCTTextParagraphProperties);
  
  CTTextParagraphProperties addNewPPr();
  
  void unsetPPr();
  
  String getT();
  
  XmlString xgetT();
  
  boolean isSetT();
  
  void setT(String paramString);
  
  void xsetT(XmlString paramXmlString);
  
  void unsetT();
  
  String getId();
  
  STGuid xgetId();
  
  void setId(String paramString);
  
  void xsetId(STGuid paramSTGuid);
  
  String getType();
  
  XmlString xgetType();
  
  boolean isSetType();
  
  void setType(String paramString);
  
  void xsetType(XmlString paramXmlString);
  
  void unsetType();
  
  public static final class Factory {
    public static CTTextField newInstance() {
      return (CTTextField)POIXMLTypeLoader.newInstance(CTTextField.type, null);
    }
    
    public static CTTextField newInstance(XmlOptions param1XmlOptions) {
      return (CTTextField)POIXMLTypeLoader.newInstance(CTTextField.type, param1XmlOptions);
    }
    
    public static CTTextField parse(String param1String) throws XmlException {
      return (CTTextField)POIXMLTypeLoader.parse(param1String, CTTextField.type, null);
    }
    
    public static CTTextField parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextField)POIXMLTypeLoader.parse(param1String, CTTextField.type, param1XmlOptions);
    }
    
    public static CTTextField parse(File param1File) throws XmlException, IOException {
      return (CTTextField)POIXMLTypeLoader.parse(param1File, CTTextField.type, null);
    }
    
    public static CTTextField parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextField)POIXMLTypeLoader.parse(param1File, CTTextField.type, param1XmlOptions);
    }
    
    public static CTTextField parse(URL param1URL) throws XmlException, IOException {
      return (CTTextField)POIXMLTypeLoader.parse(param1URL, CTTextField.type, null);
    }
    
    public static CTTextField parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextField)POIXMLTypeLoader.parse(param1URL, CTTextField.type, param1XmlOptions);
    }
    
    public static CTTextField parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextField)POIXMLTypeLoader.parse(param1InputStream, CTTextField.type, null);
    }
    
    public static CTTextField parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextField)POIXMLTypeLoader.parse(param1InputStream, CTTextField.type, param1XmlOptions);
    }
    
    public static CTTextField parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextField)POIXMLTypeLoader.parse(param1Reader, CTTextField.type, null);
    }
    
    public static CTTextField parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextField)POIXMLTypeLoader.parse(param1Reader, CTTextField.type, param1XmlOptions);
    }
    
    public static CTTextField parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextField)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextField.type, null);
    }
    
    public static CTTextField parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextField)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextField.type, param1XmlOptions);
    }
    
    public static CTTextField parse(Node param1Node) throws XmlException {
      return (CTTextField)POIXMLTypeLoader.parse(param1Node, CTTextField.type, null);
    }
    
    public static CTTextField parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextField)POIXMLTypeLoader.parse(param1Node, CTTextField.type, param1XmlOptions);
    }
    
    public static CTTextField parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextField)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextField.type, null);
    }
    
    public static CTTextField parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextField)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextField.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextField.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextField.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTextField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */