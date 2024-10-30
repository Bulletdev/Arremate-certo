package com.microsoft.schemas.vml;

import com.microsoft.schemas.office.office.STInsetMode;
import com.microsoft.schemas.office.office.STTrueFalse;
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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent;
import org.w3c.dom.Node;

public interface CTTextbox extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextbox.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextboxf712type");
  
  CTTxbxContent getTxbxContent();
  
  boolean isSetTxbxContent();
  
  void setTxbxContent(CTTxbxContent paramCTTxbxContent);
  
  CTTxbxContent addNewTxbxContent();
  
  void unsetTxbxContent();
  
  String getId();
  
  XmlString xgetId();
  
  boolean isSetId();
  
  void setId(String paramString);
  
  void xsetId(XmlString paramXmlString);
  
  void unsetId();
  
  String getStyle();
  
  XmlString xgetStyle();
  
  boolean isSetStyle();
  
  void setStyle(String paramString);
  
  void xsetStyle(XmlString paramXmlString);
  
  void unsetStyle();
  
  String getInset();
  
  XmlString xgetInset();
  
  boolean isSetInset();
  
  void setInset(String paramString);
  
  void xsetInset(XmlString paramXmlString);
  
  void unsetInset();
  
  STTrueFalse.Enum getSingleclick();
  
  STTrueFalse xgetSingleclick();
  
  boolean isSetSingleclick();
  
  void setSingleclick(STTrueFalse.Enum paramEnum);
  
  void xsetSingleclick(STTrueFalse paramSTTrueFalse);
  
  void unsetSingleclick();
  
  STInsetMode.Enum getInsetmode();
  
  STInsetMode xgetInsetmode();
  
  boolean isSetInsetmode();
  
  void setInsetmode(STInsetMode.Enum paramEnum);
  
  void xsetInsetmode(STInsetMode paramSTInsetMode);
  
  void unsetInsetmode();
  
  public static final class Factory {
    public static CTTextbox newInstance() {
      return (CTTextbox)POIXMLTypeLoader.newInstance(CTTextbox.type, null);
    }
    
    public static CTTextbox newInstance(XmlOptions param1XmlOptions) {
      return (CTTextbox)POIXMLTypeLoader.newInstance(CTTextbox.type, param1XmlOptions);
    }
    
    public static CTTextbox parse(String param1String) throws XmlException {
      return (CTTextbox)POIXMLTypeLoader.parse(param1String, CTTextbox.type, null);
    }
    
    public static CTTextbox parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextbox)POIXMLTypeLoader.parse(param1String, CTTextbox.type, param1XmlOptions);
    }
    
    public static CTTextbox parse(File param1File) throws XmlException, IOException {
      return (CTTextbox)POIXMLTypeLoader.parse(param1File, CTTextbox.type, null);
    }
    
    public static CTTextbox parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextbox)POIXMLTypeLoader.parse(param1File, CTTextbox.type, param1XmlOptions);
    }
    
    public static CTTextbox parse(URL param1URL) throws XmlException, IOException {
      return (CTTextbox)POIXMLTypeLoader.parse(param1URL, CTTextbox.type, null);
    }
    
    public static CTTextbox parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextbox)POIXMLTypeLoader.parse(param1URL, CTTextbox.type, param1XmlOptions);
    }
    
    public static CTTextbox parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextbox)POIXMLTypeLoader.parse(param1InputStream, CTTextbox.type, null);
    }
    
    public static CTTextbox parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextbox)POIXMLTypeLoader.parse(param1InputStream, CTTextbox.type, param1XmlOptions);
    }
    
    public static CTTextbox parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextbox)POIXMLTypeLoader.parse(param1Reader, CTTextbox.type, null);
    }
    
    public static CTTextbox parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextbox)POIXMLTypeLoader.parse(param1Reader, CTTextbox.type, param1XmlOptions);
    }
    
    public static CTTextbox parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextbox)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextbox.type, null);
    }
    
    public static CTTextbox parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextbox)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextbox.type, param1XmlOptions);
    }
    
    public static CTTextbox parse(Node param1Node) throws XmlException {
      return (CTTextbox)POIXMLTypeLoader.parse(param1Node, CTTextbox.type, null);
    }
    
    public static CTTextbox parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextbox)POIXMLTypeLoader.parse(param1Node, CTTextbox.type, param1XmlOptions);
    }
    
    public static CTTextbox parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextbox)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextbox.type, null);
    }
    
    public static CTTextbox parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextbox)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextbox.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextbox.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextbox.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\CTTextbox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */