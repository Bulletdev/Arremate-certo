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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTCell extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCell.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcell842btype");
  
  CTCellFormula getF();
  
  boolean isSetF();
  
  void setF(CTCellFormula paramCTCellFormula);
  
  CTCellFormula addNewF();
  
  void unsetF();
  
  String getV();
  
  STXstring xgetV();
  
  boolean isSetV();
  
  void setV(String paramString);
  
  void xsetV(STXstring paramSTXstring);
  
  void unsetV();
  
  CTRst getIs();
  
  boolean isSetIs();
  
  void setIs(CTRst paramCTRst);
  
  CTRst addNewIs();
  
  void unsetIs();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  String getR();
  
  STCellRef xgetR();
  
  boolean isSetR();
  
  void setR(String paramString);
  
  void xsetR(STCellRef paramSTCellRef);
  
  void unsetR();
  
  long getS();
  
  XmlUnsignedInt xgetS();
  
  boolean isSetS();
  
  void setS(long paramLong);
  
  void xsetS(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetS();
  
  STCellType.Enum getT();
  
  STCellType xgetT();
  
  boolean isSetT();
  
  void setT(STCellType.Enum paramEnum);
  
  void xsetT(STCellType paramSTCellType);
  
  void unsetT();
  
  long getCm();
  
  XmlUnsignedInt xgetCm();
  
  boolean isSetCm();
  
  void setCm(long paramLong);
  
  void xsetCm(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetCm();
  
  long getVm();
  
  XmlUnsignedInt xgetVm();
  
  boolean isSetVm();
  
  void setVm(long paramLong);
  
  void xsetVm(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetVm();
  
  boolean getPh();
  
  XmlBoolean xgetPh();
  
  boolean isSetPh();
  
  void setPh(boolean paramBoolean);
  
  void xsetPh(XmlBoolean paramXmlBoolean);
  
  void unsetPh();
  
  public static final class Factory {
    public static CTCell newInstance() {
      return (CTCell)POIXMLTypeLoader.newInstance(CTCell.type, null);
    }
    
    public static CTCell newInstance(XmlOptions param1XmlOptions) {
      return (CTCell)POIXMLTypeLoader.newInstance(CTCell.type, param1XmlOptions);
    }
    
    public static CTCell parse(String param1String) throws XmlException {
      return (CTCell)POIXMLTypeLoader.parse(param1String, CTCell.type, null);
    }
    
    public static CTCell parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCell)POIXMLTypeLoader.parse(param1String, CTCell.type, param1XmlOptions);
    }
    
    public static CTCell parse(File param1File) throws XmlException, IOException {
      return (CTCell)POIXMLTypeLoader.parse(param1File, CTCell.type, null);
    }
    
    public static CTCell parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCell)POIXMLTypeLoader.parse(param1File, CTCell.type, param1XmlOptions);
    }
    
    public static CTCell parse(URL param1URL) throws XmlException, IOException {
      return (CTCell)POIXMLTypeLoader.parse(param1URL, CTCell.type, null);
    }
    
    public static CTCell parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCell)POIXMLTypeLoader.parse(param1URL, CTCell.type, param1XmlOptions);
    }
    
    public static CTCell parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCell)POIXMLTypeLoader.parse(param1InputStream, CTCell.type, null);
    }
    
    public static CTCell parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCell)POIXMLTypeLoader.parse(param1InputStream, CTCell.type, param1XmlOptions);
    }
    
    public static CTCell parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCell)POIXMLTypeLoader.parse(param1Reader, CTCell.type, null);
    }
    
    public static CTCell parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCell)POIXMLTypeLoader.parse(param1Reader, CTCell.type, param1XmlOptions);
    }
    
    public static CTCell parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCell)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCell.type, null);
    }
    
    public static CTCell parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCell)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCell.type, param1XmlOptions);
    }
    
    public static CTCell parse(Node param1Node) throws XmlException {
      return (CTCell)POIXMLTypeLoader.parse(param1Node, CTCell.type, null);
    }
    
    public static CTCell parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCell)POIXMLTypeLoader.parse(param1Node, CTCell.type, param1XmlOptions);
    }
    
    public static CTCell parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCell)POIXMLTypeLoader.parse(param1XMLInputStream, CTCell.type, null);
    }
    
    public static CTCell parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCell)POIXMLTypeLoader.parse(param1XMLInputStream, CTCell.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCell.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCell.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */