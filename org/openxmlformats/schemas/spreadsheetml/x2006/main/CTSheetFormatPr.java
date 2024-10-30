package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTSheetFormatPr extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSheetFormatPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsheetformatprdef7type");
  
  long getBaseColWidth();
  
  XmlUnsignedInt xgetBaseColWidth();
  
  boolean isSetBaseColWidth();
  
  void setBaseColWidth(long paramLong);
  
  void xsetBaseColWidth(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetBaseColWidth();
  
  double getDefaultColWidth();
  
  XmlDouble xgetDefaultColWidth();
  
  boolean isSetDefaultColWidth();
  
  void setDefaultColWidth(double paramDouble);
  
  void xsetDefaultColWidth(XmlDouble paramXmlDouble);
  
  void unsetDefaultColWidth();
  
  double getDefaultRowHeight();
  
  XmlDouble xgetDefaultRowHeight();
  
  void setDefaultRowHeight(double paramDouble);
  
  void xsetDefaultRowHeight(XmlDouble paramXmlDouble);
  
  boolean getCustomHeight();
  
  XmlBoolean xgetCustomHeight();
  
  boolean isSetCustomHeight();
  
  void setCustomHeight(boolean paramBoolean);
  
  void xsetCustomHeight(XmlBoolean paramXmlBoolean);
  
  void unsetCustomHeight();
  
  boolean getZeroHeight();
  
  XmlBoolean xgetZeroHeight();
  
  boolean isSetZeroHeight();
  
  void setZeroHeight(boolean paramBoolean);
  
  void xsetZeroHeight(XmlBoolean paramXmlBoolean);
  
  void unsetZeroHeight();
  
  boolean getThickTop();
  
  XmlBoolean xgetThickTop();
  
  boolean isSetThickTop();
  
  void setThickTop(boolean paramBoolean);
  
  void xsetThickTop(XmlBoolean paramXmlBoolean);
  
  void unsetThickTop();
  
  boolean getThickBottom();
  
  XmlBoolean xgetThickBottom();
  
  boolean isSetThickBottom();
  
  void setThickBottom(boolean paramBoolean);
  
  void xsetThickBottom(XmlBoolean paramXmlBoolean);
  
  void unsetThickBottom();
  
  short getOutlineLevelRow();
  
  XmlUnsignedByte xgetOutlineLevelRow();
  
  boolean isSetOutlineLevelRow();
  
  void setOutlineLevelRow(short paramShort);
  
  void xsetOutlineLevelRow(XmlUnsignedByte paramXmlUnsignedByte);
  
  void unsetOutlineLevelRow();
  
  short getOutlineLevelCol();
  
  XmlUnsignedByte xgetOutlineLevelCol();
  
  boolean isSetOutlineLevelCol();
  
  void setOutlineLevelCol(short paramShort);
  
  void xsetOutlineLevelCol(XmlUnsignedByte paramXmlUnsignedByte);
  
  void unsetOutlineLevelCol();
  
  public static final class Factory {
    public static CTSheetFormatPr newInstance() {
      return (CTSheetFormatPr)POIXMLTypeLoader.newInstance(CTSheetFormatPr.type, null);
    }
    
    public static CTSheetFormatPr newInstance(XmlOptions param1XmlOptions) {
      return (CTSheetFormatPr)POIXMLTypeLoader.newInstance(CTSheetFormatPr.type, param1XmlOptions);
    }
    
    public static CTSheetFormatPr parse(String param1String) throws XmlException {
      return (CTSheetFormatPr)POIXMLTypeLoader.parse(param1String, CTSheetFormatPr.type, null);
    }
    
    public static CTSheetFormatPr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheetFormatPr)POIXMLTypeLoader.parse(param1String, CTSheetFormatPr.type, param1XmlOptions);
    }
    
    public static CTSheetFormatPr parse(File param1File) throws XmlException, IOException {
      return (CTSheetFormatPr)POIXMLTypeLoader.parse(param1File, CTSheetFormatPr.type, null);
    }
    
    public static CTSheetFormatPr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetFormatPr)POIXMLTypeLoader.parse(param1File, CTSheetFormatPr.type, param1XmlOptions);
    }
    
    public static CTSheetFormatPr parse(URL param1URL) throws XmlException, IOException {
      return (CTSheetFormatPr)POIXMLTypeLoader.parse(param1URL, CTSheetFormatPr.type, null);
    }
    
    public static CTSheetFormatPr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetFormatPr)POIXMLTypeLoader.parse(param1URL, CTSheetFormatPr.type, param1XmlOptions);
    }
    
    public static CTSheetFormatPr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSheetFormatPr)POIXMLTypeLoader.parse(param1InputStream, CTSheetFormatPr.type, null);
    }
    
    public static CTSheetFormatPr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetFormatPr)POIXMLTypeLoader.parse(param1InputStream, CTSheetFormatPr.type, param1XmlOptions);
    }
    
    public static CTSheetFormatPr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSheetFormatPr)POIXMLTypeLoader.parse(param1Reader, CTSheetFormatPr.type, null);
    }
    
    public static CTSheetFormatPr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetFormatPr)POIXMLTypeLoader.parse(param1Reader, CTSheetFormatPr.type, param1XmlOptions);
    }
    
    public static CTSheetFormatPr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSheetFormatPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSheetFormatPr.type, null);
    }
    
    public static CTSheetFormatPr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheetFormatPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSheetFormatPr.type, param1XmlOptions);
    }
    
    public static CTSheetFormatPr parse(Node param1Node) throws XmlException {
      return (CTSheetFormatPr)POIXMLTypeLoader.parse(param1Node, CTSheetFormatPr.type, null);
    }
    
    public static CTSheetFormatPr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheetFormatPr)POIXMLTypeLoader.parse(param1Node, CTSheetFormatPr.type, param1XmlOptions);
    }
    
    public static CTSheetFormatPr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSheetFormatPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTSheetFormatPr.type, null);
    }
    
    public static CTSheetFormatPr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSheetFormatPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTSheetFormatPr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSheetFormatPr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSheetFormatPr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTSheetFormatPr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */