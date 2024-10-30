package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

public interface CTFFCheckBox extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTFFCheckBox.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctffcheckboxf3a5type");
  
  CTHpsMeasure getSize();
  
  boolean isSetSize();
  
  void setSize(CTHpsMeasure paramCTHpsMeasure);
  
  CTHpsMeasure addNewSize();
  
  void unsetSize();
  
  CTOnOff getSizeAuto();
  
  boolean isSetSizeAuto();
  
  void setSizeAuto(CTOnOff paramCTOnOff);
  
  CTOnOff addNewSizeAuto();
  
  void unsetSizeAuto();
  
  CTOnOff getDefault();
  
  boolean isSetDefault();
  
  void setDefault(CTOnOff paramCTOnOff);
  
  CTOnOff addNewDefault();
  
  void unsetDefault();
  
  CTOnOff getChecked();
  
  boolean isSetChecked();
  
  void setChecked(CTOnOff paramCTOnOff);
  
  CTOnOff addNewChecked();
  
  void unsetChecked();
  
  public static final class Factory {
    public static CTFFCheckBox newInstance() {
      return (CTFFCheckBox)POIXMLTypeLoader.newInstance(CTFFCheckBox.type, null);
    }
    
    public static CTFFCheckBox newInstance(XmlOptions param1XmlOptions) {
      return (CTFFCheckBox)POIXMLTypeLoader.newInstance(CTFFCheckBox.type, param1XmlOptions);
    }
    
    public static CTFFCheckBox parse(String param1String) throws XmlException {
      return (CTFFCheckBox)POIXMLTypeLoader.parse(param1String, CTFFCheckBox.type, null);
    }
    
    public static CTFFCheckBox parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFFCheckBox)POIXMLTypeLoader.parse(param1String, CTFFCheckBox.type, param1XmlOptions);
    }
    
    public static CTFFCheckBox parse(File param1File) throws XmlException, IOException {
      return (CTFFCheckBox)POIXMLTypeLoader.parse(param1File, CTFFCheckBox.type, null);
    }
    
    public static CTFFCheckBox parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFFCheckBox)POIXMLTypeLoader.parse(param1File, CTFFCheckBox.type, param1XmlOptions);
    }
    
    public static CTFFCheckBox parse(URL param1URL) throws XmlException, IOException {
      return (CTFFCheckBox)POIXMLTypeLoader.parse(param1URL, CTFFCheckBox.type, null);
    }
    
    public static CTFFCheckBox parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFFCheckBox)POIXMLTypeLoader.parse(param1URL, CTFFCheckBox.type, param1XmlOptions);
    }
    
    public static CTFFCheckBox parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTFFCheckBox)POIXMLTypeLoader.parse(param1InputStream, CTFFCheckBox.type, null);
    }
    
    public static CTFFCheckBox parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFFCheckBox)POIXMLTypeLoader.parse(param1InputStream, CTFFCheckBox.type, param1XmlOptions);
    }
    
    public static CTFFCheckBox parse(Reader param1Reader) throws XmlException, IOException {
      return (CTFFCheckBox)POIXMLTypeLoader.parse(param1Reader, CTFFCheckBox.type, null);
    }
    
    public static CTFFCheckBox parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFFCheckBox)POIXMLTypeLoader.parse(param1Reader, CTFFCheckBox.type, param1XmlOptions);
    }
    
    public static CTFFCheckBox parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTFFCheckBox)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFFCheckBox.type, null);
    }
    
    public static CTFFCheckBox parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFFCheckBox)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFFCheckBox.type, param1XmlOptions);
    }
    
    public static CTFFCheckBox parse(Node param1Node) throws XmlException {
      return (CTFFCheckBox)POIXMLTypeLoader.parse(param1Node, CTFFCheckBox.type, null);
    }
    
    public static CTFFCheckBox parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFFCheckBox)POIXMLTypeLoader.parse(param1Node, CTFFCheckBox.type, param1XmlOptions);
    }
    
    public static CTFFCheckBox parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTFFCheckBox)POIXMLTypeLoader.parse(param1XMLInputStream, CTFFCheckBox.type, null);
    }
    
    public static CTFFCheckBox parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTFFCheckBox)POIXMLTypeLoader.parse(param1XMLInputStream, CTFFCheckBox.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFFCheckBox.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFFCheckBox.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTFFCheckBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */