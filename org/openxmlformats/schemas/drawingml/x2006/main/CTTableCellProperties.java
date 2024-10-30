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

public interface CTTableCellProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTableCellProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablecellproperties1614type");
  
  CTLineProperties getLnL();
  
  boolean isSetLnL();
  
  void setLnL(CTLineProperties paramCTLineProperties);
  
  CTLineProperties addNewLnL();
  
  void unsetLnL();
  
  CTLineProperties getLnR();
  
  boolean isSetLnR();
  
  void setLnR(CTLineProperties paramCTLineProperties);
  
  CTLineProperties addNewLnR();
  
  void unsetLnR();
  
  CTLineProperties getLnT();
  
  boolean isSetLnT();
  
  void setLnT(CTLineProperties paramCTLineProperties);
  
  CTLineProperties addNewLnT();
  
  void unsetLnT();
  
  CTLineProperties getLnB();
  
  boolean isSetLnB();
  
  void setLnB(CTLineProperties paramCTLineProperties);
  
  CTLineProperties addNewLnB();
  
  void unsetLnB();
  
  CTLineProperties getLnTlToBr();
  
  boolean isSetLnTlToBr();
  
  void setLnTlToBr(CTLineProperties paramCTLineProperties);
  
  CTLineProperties addNewLnTlToBr();
  
  void unsetLnTlToBr();
  
  CTLineProperties getLnBlToTr();
  
  boolean isSetLnBlToTr();
  
  void setLnBlToTr(CTLineProperties paramCTLineProperties);
  
  CTLineProperties addNewLnBlToTr();
  
  void unsetLnBlToTr();
  
  CTCell3D getCell3D();
  
  boolean isSetCell3D();
  
  void setCell3D(CTCell3D paramCTCell3D);
  
  CTCell3D addNewCell3D();
  
  void unsetCell3D();
  
  CTNoFillProperties getNoFill();
  
  boolean isSetNoFill();
  
  void setNoFill(CTNoFillProperties paramCTNoFillProperties);
  
  CTNoFillProperties addNewNoFill();
  
  void unsetNoFill();
  
  CTSolidColorFillProperties getSolidFill();
  
  boolean isSetSolidFill();
  
  void setSolidFill(CTSolidColorFillProperties paramCTSolidColorFillProperties);
  
  CTSolidColorFillProperties addNewSolidFill();
  
  void unsetSolidFill();
  
  CTGradientFillProperties getGradFill();
  
  boolean isSetGradFill();
  
  void setGradFill(CTGradientFillProperties paramCTGradientFillProperties);
  
  CTGradientFillProperties addNewGradFill();
  
  void unsetGradFill();
  
  CTBlipFillProperties getBlipFill();
  
  boolean isSetBlipFill();
  
  void setBlipFill(CTBlipFillProperties paramCTBlipFillProperties);
  
  CTBlipFillProperties addNewBlipFill();
  
  void unsetBlipFill();
  
  CTPatternFillProperties getPattFill();
  
  boolean isSetPattFill();
  
  void setPattFill(CTPatternFillProperties paramCTPatternFillProperties);
  
  CTPatternFillProperties addNewPattFill();
  
  void unsetPattFill();
  
  CTGroupFillProperties getGrpFill();
  
  boolean isSetGrpFill();
  
  void setGrpFill(CTGroupFillProperties paramCTGroupFillProperties);
  
  CTGroupFillProperties addNewGrpFill();
  
  void unsetGrpFill();
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  int getMarL();
  
  STCoordinate32 xgetMarL();
  
  boolean isSetMarL();
  
  void setMarL(int paramInt);
  
  void xsetMarL(STCoordinate32 paramSTCoordinate32);
  
  void unsetMarL();
  
  int getMarR();
  
  STCoordinate32 xgetMarR();
  
  boolean isSetMarR();
  
  void setMarR(int paramInt);
  
  void xsetMarR(STCoordinate32 paramSTCoordinate32);
  
  void unsetMarR();
  
  int getMarT();
  
  STCoordinate32 xgetMarT();
  
  boolean isSetMarT();
  
  void setMarT(int paramInt);
  
  void xsetMarT(STCoordinate32 paramSTCoordinate32);
  
  void unsetMarT();
  
  int getMarB();
  
  STCoordinate32 xgetMarB();
  
  boolean isSetMarB();
  
  void setMarB(int paramInt);
  
  void xsetMarB(STCoordinate32 paramSTCoordinate32);
  
  void unsetMarB();
  
  STTextVerticalType.Enum getVert();
  
  STTextVerticalType xgetVert();
  
  boolean isSetVert();
  
  void setVert(STTextVerticalType.Enum paramEnum);
  
  void xsetVert(STTextVerticalType paramSTTextVerticalType);
  
  void unsetVert();
  
  STTextAnchoringType.Enum getAnchor();
  
  STTextAnchoringType xgetAnchor();
  
  boolean isSetAnchor();
  
  void setAnchor(STTextAnchoringType.Enum paramEnum);
  
  void xsetAnchor(STTextAnchoringType paramSTTextAnchoringType);
  
  void unsetAnchor();
  
  boolean getAnchorCtr();
  
  XmlBoolean xgetAnchorCtr();
  
  boolean isSetAnchorCtr();
  
  void setAnchorCtr(boolean paramBoolean);
  
  void xsetAnchorCtr(XmlBoolean paramXmlBoolean);
  
  void unsetAnchorCtr();
  
  STTextHorzOverflowType.Enum getHorzOverflow();
  
  STTextHorzOverflowType xgetHorzOverflow();
  
  boolean isSetHorzOverflow();
  
  void setHorzOverflow(STTextHorzOverflowType.Enum paramEnum);
  
  void xsetHorzOverflow(STTextHorzOverflowType paramSTTextHorzOverflowType);
  
  void unsetHorzOverflow();
  
  public static final class Factory {
    public static CTTableCellProperties newInstance() {
      return (CTTableCellProperties)POIXMLTypeLoader.newInstance(CTTableCellProperties.type, null);
    }
    
    public static CTTableCellProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTTableCellProperties)POIXMLTypeLoader.newInstance(CTTableCellProperties.type, param1XmlOptions);
    }
    
    public static CTTableCellProperties parse(String param1String) throws XmlException {
      return (CTTableCellProperties)POIXMLTypeLoader.parse(param1String, CTTableCellProperties.type, null);
    }
    
    public static CTTableCellProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableCellProperties)POIXMLTypeLoader.parse(param1String, CTTableCellProperties.type, param1XmlOptions);
    }
    
    public static CTTableCellProperties parse(File param1File) throws XmlException, IOException {
      return (CTTableCellProperties)POIXMLTypeLoader.parse(param1File, CTTableCellProperties.type, null);
    }
    
    public static CTTableCellProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableCellProperties)POIXMLTypeLoader.parse(param1File, CTTableCellProperties.type, param1XmlOptions);
    }
    
    public static CTTableCellProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTTableCellProperties)POIXMLTypeLoader.parse(param1URL, CTTableCellProperties.type, null);
    }
    
    public static CTTableCellProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableCellProperties)POIXMLTypeLoader.parse(param1URL, CTTableCellProperties.type, param1XmlOptions);
    }
    
    public static CTTableCellProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTableCellProperties)POIXMLTypeLoader.parse(param1InputStream, CTTableCellProperties.type, null);
    }
    
    public static CTTableCellProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableCellProperties)POIXMLTypeLoader.parse(param1InputStream, CTTableCellProperties.type, param1XmlOptions);
    }
    
    public static CTTableCellProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTableCellProperties)POIXMLTypeLoader.parse(param1Reader, CTTableCellProperties.type, null);
    }
    
    public static CTTableCellProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableCellProperties)POIXMLTypeLoader.parse(param1Reader, CTTableCellProperties.type, param1XmlOptions);
    }
    
    public static CTTableCellProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTableCellProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableCellProperties.type, null);
    }
    
    public static CTTableCellProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableCellProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableCellProperties.type, param1XmlOptions);
    }
    
    public static CTTableCellProperties parse(Node param1Node) throws XmlException {
      return (CTTableCellProperties)POIXMLTypeLoader.parse(param1Node, CTTableCellProperties.type, null);
    }
    
    public static CTTableCellProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableCellProperties)POIXMLTypeLoader.parse(param1Node, CTTableCellProperties.type, param1XmlOptions);
    }
    
    public static CTTableCellProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTableCellProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableCellProperties.type, null);
    }
    
    public static CTTableCellProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTableCellProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableCellProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableCellProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableCellProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTableCellProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */