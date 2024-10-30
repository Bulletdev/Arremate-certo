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

public interface CTTableStyle extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTableStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablestyled59etype");
  
  CTTableBackgroundStyle getTblBg();
  
  boolean isSetTblBg();
  
  void setTblBg(CTTableBackgroundStyle paramCTTableBackgroundStyle);
  
  CTTableBackgroundStyle addNewTblBg();
  
  void unsetTblBg();
  
  CTTablePartStyle getWholeTbl();
  
  boolean isSetWholeTbl();
  
  void setWholeTbl(CTTablePartStyle paramCTTablePartStyle);
  
  CTTablePartStyle addNewWholeTbl();
  
  void unsetWholeTbl();
  
  CTTablePartStyle getBand1H();
  
  boolean isSetBand1H();
  
  void setBand1H(CTTablePartStyle paramCTTablePartStyle);
  
  CTTablePartStyle addNewBand1H();
  
  void unsetBand1H();
  
  CTTablePartStyle getBand2H();
  
  boolean isSetBand2H();
  
  void setBand2H(CTTablePartStyle paramCTTablePartStyle);
  
  CTTablePartStyle addNewBand2H();
  
  void unsetBand2H();
  
  CTTablePartStyle getBand1V();
  
  boolean isSetBand1V();
  
  void setBand1V(CTTablePartStyle paramCTTablePartStyle);
  
  CTTablePartStyle addNewBand1V();
  
  void unsetBand1V();
  
  CTTablePartStyle getBand2V();
  
  boolean isSetBand2V();
  
  void setBand2V(CTTablePartStyle paramCTTablePartStyle);
  
  CTTablePartStyle addNewBand2V();
  
  void unsetBand2V();
  
  CTTablePartStyle getLastCol();
  
  boolean isSetLastCol();
  
  void setLastCol(CTTablePartStyle paramCTTablePartStyle);
  
  CTTablePartStyle addNewLastCol();
  
  void unsetLastCol();
  
  CTTablePartStyle getFirstCol();
  
  boolean isSetFirstCol();
  
  void setFirstCol(CTTablePartStyle paramCTTablePartStyle);
  
  CTTablePartStyle addNewFirstCol();
  
  void unsetFirstCol();
  
  CTTablePartStyle getLastRow();
  
  boolean isSetLastRow();
  
  void setLastRow(CTTablePartStyle paramCTTablePartStyle);
  
  CTTablePartStyle addNewLastRow();
  
  void unsetLastRow();
  
  CTTablePartStyle getSeCell();
  
  boolean isSetSeCell();
  
  void setSeCell(CTTablePartStyle paramCTTablePartStyle);
  
  CTTablePartStyle addNewSeCell();
  
  void unsetSeCell();
  
  CTTablePartStyle getSwCell();
  
  boolean isSetSwCell();
  
  void setSwCell(CTTablePartStyle paramCTTablePartStyle);
  
  CTTablePartStyle addNewSwCell();
  
  void unsetSwCell();
  
  CTTablePartStyle getFirstRow();
  
  boolean isSetFirstRow();
  
  void setFirstRow(CTTablePartStyle paramCTTablePartStyle);
  
  CTTablePartStyle addNewFirstRow();
  
  void unsetFirstRow();
  
  CTTablePartStyle getNeCell();
  
  boolean isSetNeCell();
  
  void setNeCell(CTTablePartStyle paramCTTablePartStyle);
  
  CTTablePartStyle addNewNeCell();
  
  void unsetNeCell();
  
  CTTablePartStyle getNwCell();
  
  boolean isSetNwCell();
  
  void setNwCell(CTTablePartStyle paramCTTablePartStyle);
  
  CTTablePartStyle addNewNwCell();
  
  void unsetNwCell();
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  String getStyleId();
  
  STGuid xgetStyleId();
  
  void setStyleId(String paramString);
  
  void xsetStyleId(STGuid paramSTGuid);
  
  String getStyleName();
  
  XmlString xgetStyleName();
  
  void setStyleName(String paramString);
  
  void xsetStyleName(XmlString paramXmlString);
  
  public static final class Factory {
    public static CTTableStyle newInstance() {
      return (CTTableStyle)POIXMLTypeLoader.newInstance(CTTableStyle.type, null);
    }
    
    public static CTTableStyle newInstance(XmlOptions param1XmlOptions) {
      return (CTTableStyle)POIXMLTypeLoader.newInstance(CTTableStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyle parse(String param1String) throws XmlException {
      return (CTTableStyle)POIXMLTypeLoader.parse(param1String, CTTableStyle.type, null);
    }
    
    public static CTTableStyle parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableStyle)POIXMLTypeLoader.parse(param1String, CTTableStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyle parse(File param1File) throws XmlException, IOException {
      return (CTTableStyle)POIXMLTypeLoader.parse(param1File, CTTableStyle.type, null);
    }
    
    public static CTTableStyle parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableStyle)POIXMLTypeLoader.parse(param1File, CTTableStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyle parse(URL param1URL) throws XmlException, IOException {
      return (CTTableStyle)POIXMLTypeLoader.parse(param1URL, CTTableStyle.type, null);
    }
    
    public static CTTableStyle parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableStyle)POIXMLTypeLoader.parse(param1URL, CTTableStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyle parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTableStyle)POIXMLTypeLoader.parse(param1InputStream, CTTableStyle.type, null);
    }
    
    public static CTTableStyle parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableStyle)POIXMLTypeLoader.parse(param1InputStream, CTTableStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyle parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTableStyle)POIXMLTypeLoader.parse(param1Reader, CTTableStyle.type, null);
    }
    
    public static CTTableStyle parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableStyle)POIXMLTypeLoader.parse(param1Reader, CTTableStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyle parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTableStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableStyle.type, null);
    }
    
    public static CTTableStyle parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyle parse(Node param1Node) throws XmlException {
      return (CTTableStyle)POIXMLTypeLoader.parse(param1Node, CTTableStyle.type, null);
    }
    
    public static CTTableStyle parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableStyle)POIXMLTypeLoader.parse(param1Node, CTTableStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyle parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTableStyle)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableStyle.type, null);
    }
    
    public static CTTableStyle parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTableStyle)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableStyle.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableStyle.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableStyle.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTableStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */