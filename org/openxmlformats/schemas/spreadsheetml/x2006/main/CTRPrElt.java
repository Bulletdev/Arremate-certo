package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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

public interface CTRPrElt extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTRPrElt.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctrpreltecc2type");
  
  List<CTFontName> getRFontList();
  
  CTFontName[] getRFontArray();
  
  CTFontName getRFontArray(int paramInt);
  
  int sizeOfRFontArray();
  
  void setRFontArray(CTFontName[] paramArrayOfCTFontName);
  
  void setRFontArray(int paramInt, CTFontName paramCTFontName);
  
  CTFontName insertNewRFont(int paramInt);
  
  CTFontName addNewRFont();
  
  void removeRFont(int paramInt);
  
  List<CTIntProperty> getCharsetList();
  
  CTIntProperty[] getCharsetArray();
  
  CTIntProperty getCharsetArray(int paramInt);
  
  int sizeOfCharsetArray();
  
  void setCharsetArray(CTIntProperty[] paramArrayOfCTIntProperty);
  
  void setCharsetArray(int paramInt, CTIntProperty paramCTIntProperty);
  
  CTIntProperty insertNewCharset(int paramInt);
  
  CTIntProperty addNewCharset();
  
  void removeCharset(int paramInt);
  
  List<CTIntProperty> getFamilyList();
  
  CTIntProperty[] getFamilyArray();
  
  CTIntProperty getFamilyArray(int paramInt);
  
  int sizeOfFamilyArray();
  
  void setFamilyArray(CTIntProperty[] paramArrayOfCTIntProperty);
  
  void setFamilyArray(int paramInt, CTIntProperty paramCTIntProperty);
  
  CTIntProperty insertNewFamily(int paramInt);
  
  CTIntProperty addNewFamily();
  
  void removeFamily(int paramInt);
  
  List<CTBooleanProperty> getBList();
  
  CTBooleanProperty[] getBArray();
  
  CTBooleanProperty getBArray(int paramInt);
  
  int sizeOfBArray();
  
  void setBArray(CTBooleanProperty[] paramArrayOfCTBooleanProperty);
  
  void setBArray(int paramInt, CTBooleanProperty paramCTBooleanProperty);
  
  CTBooleanProperty insertNewB(int paramInt);
  
  CTBooleanProperty addNewB();
  
  void removeB(int paramInt);
  
  List<CTBooleanProperty> getIList();
  
  CTBooleanProperty[] getIArray();
  
  CTBooleanProperty getIArray(int paramInt);
  
  int sizeOfIArray();
  
  void setIArray(CTBooleanProperty[] paramArrayOfCTBooleanProperty);
  
  void setIArray(int paramInt, CTBooleanProperty paramCTBooleanProperty);
  
  CTBooleanProperty insertNewI(int paramInt);
  
  CTBooleanProperty addNewI();
  
  void removeI(int paramInt);
  
  List<CTBooleanProperty> getStrikeList();
  
  CTBooleanProperty[] getStrikeArray();
  
  CTBooleanProperty getStrikeArray(int paramInt);
  
  int sizeOfStrikeArray();
  
  void setStrikeArray(CTBooleanProperty[] paramArrayOfCTBooleanProperty);
  
  void setStrikeArray(int paramInt, CTBooleanProperty paramCTBooleanProperty);
  
  CTBooleanProperty insertNewStrike(int paramInt);
  
  CTBooleanProperty addNewStrike();
  
  void removeStrike(int paramInt);
  
  List<CTBooleanProperty> getOutlineList();
  
  CTBooleanProperty[] getOutlineArray();
  
  CTBooleanProperty getOutlineArray(int paramInt);
  
  int sizeOfOutlineArray();
  
  void setOutlineArray(CTBooleanProperty[] paramArrayOfCTBooleanProperty);
  
  void setOutlineArray(int paramInt, CTBooleanProperty paramCTBooleanProperty);
  
  CTBooleanProperty insertNewOutline(int paramInt);
  
  CTBooleanProperty addNewOutline();
  
  void removeOutline(int paramInt);
  
  List<CTBooleanProperty> getShadowList();
  
  CTBooleanProperty[] getShadowArray();
  
  CTBooleanProperty getShadowArray(int paramInt);
  
  int sizeOfShadowArray();
  
  void setShadowArray(CTBooleanProperty[] paramArrayOfCTBooleanProperty);
  
  void setShadowArray(int paramInt, CTBooleanProperty paramCTBooleanProperty);
  
  CTBooleanProperty insertNewShadow(int paramInt);
  
  CTBooleanProperty addNewShadow();
  
  void removeShadow(int paramInt);
  
  List<CTBooleanProperty> getCondenseList();
  
  CTBooleanProperty[] getCondenseArray();
  
  CTBooleanProperty getCondenseArray(int paramInt);
  
  int sizeOfCondenseArray();
  
  void setCondenseArray(CTBooleanProperty[] paramArrayOfCTBooleanProperty);
  
  void setCondenseArray(int paramInt, CTBooleanProperty paramCTBooleanProperty);
  
  CTBooleanProperty insertNewCondense(int paramInt);
  
  CTBooleanProperty addNewCondense();
  
  void removeCondense(int paramInt);
  
  List<CTBooleanProperty> getExtendList();
  
  CTBooleanProperty[] getExtendArray();
  
  CTBooleanProperty getExtendArray(int paramInt);
  
  int sizeOfExtendArray();
  
  void setExtendArray(CTBooleanProperty[] paramArrayOfCTBooleanProperty);
  
  void setExtendArray(int paramInt, CTBooleanProperty paramCTBooleanProperty);
  
  CTBooleanProperty insertNewExtend(int paramInt);
  
  CTBooleanProperty addNewExtend();
  
  void removeExtend(int paramInt);
  
  List<CTColor> getColorList();
  
  CTColor[] getColorArray();
  
  CTColor getColorArray(int paramInt);
  
  int sizeOfColorArray();
  
  void setColorArray(CTColor[] paramArrayOfCTColor);
  
  void setColorArray(int paramInt, CTColor paramCTColor);
  
  CTColor insertNewColor(int paramInt);
  
  CTColor addNewColor();
  
  void removeColor(int paramInt);
  
  List<CTFontSize> getSzList();
  
  CTFontSize[] getSzArray();
  
  CTFontSize getSzArray(int paramInt);
  
  int sizeOfSzArray();
  
  void setSzArray(CTFontSize[] paramArrayOfCTFontSize);
  
  void setSzArray(int paramInt, CTFontSize paramCTFontSize);
  
  CTFontSize insertNewSz(int paramInt);
  
  CTFontSize addNewSz();
  
  void removeSz(int paramInt);
  
  List<CTUnderlineProperty> getUList();
  
  CTUnderlineProperty[] getUArray();
  
  CTUnderlineProperty getUArray(int paramInt);
  
  int sizeOfUArray();
  
  void setUArray(CTUnderlineProperty[] paramArrayOfCTUnderlineProperty);
  
  void setUArray(int paramInt, CTUnderlineProperty paramCTUnderlineProperty);
  
  CTUnderlineProperty insertNewU(int paramInt);
  
  CTUnderlineProperty addNewU();
  
  void removeU(int paramInt);
  
  List<CTVerticalAlignFontProperty> getVertAlignList();
  
  CTVerticalAlignFontProperty[] getVertAlignArray();
  
  CTVerticalAlignFontProperty getVertAlignArray(int paramInt);
  
  int sizeOfVertAlignArray();
  
  void setVertAlignArray(CTVerticalAlignFontProperty[] paramArrayOfCTVerticalAlignFontProperty);
  
  void setVertAlignArray(int paramInt, CTVerticalAlignFontProperty paramCTVerticalAlignFontProperty);
  
  CTVerticalAlignFontProperty insertNewVertAlign(int paramInt);
  
  CTVerticalAlignFontProperty addNewVertAlign();
  
  void removeVertAlign(int paramInt);
  
  List<CTFontScheme> getSchemeList();
  
  CTFontScheme[] getSchemeArray();
  
  CTFontScheme getSchemeArray(int paramInt);
  
  int sizeOfSchemeArray();
  
  void setSchemeArray(CTFontScheme[] paramArrayOfCTFontScheme);
  
  void setSchemeArray(int paramInt, CTFontScheme paramCTFontScheme);
  
  CTFontScheme insertNewScheme(int paramInt);
  
  CTFontScheme addNewScheme();
  
  void removeScheme(int paramInt);
  
  public static final class Factory {
    public static CTRPrElt newInstance() {
      return (CTRPrElt)POIXMLTypeLoader.newInstance(CTRPrElt.type, null);
    }
    
    public static CTRPrElt newInstance(XmlOptions param1XmlOptions) {
      return (CTRPrElt)POIXMLTypeLoader.newInstance(CTRPrElt.type, param1XmlOptions);
    }
    
    public static CTRPrElt parse(String param1String) throws XmlException {
      return (CTRPrElt)POIXMLTypeLoader.parse(param1String, CTRPrElt.type, null);
    }
    
    public static CTRPrElt parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRPrElt)POIXMLTypeLoader.parse(param1String, CTRPrElt.type, param1XmlOptions);
    }
    
    public static CTRPrElt parse(File param1File) throws XmlException, IOException {
      return (CTRPrElt)POIXMLTypeLoader.parse(param1File, CTRPrElt.type, null);
    }
    
    public static CTRPrElt parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRPrElt)POIXMLTypeLoader.parse(param1File, CTRPrElt.type, param1XmlOptions);
    }
    
    public static CTRPrElt parse(URL param1URL) throws XmlException, IOException {
      return (CTRPrElt)POIXMLTypeLoader.parse(param1URL, CTRPrElt.type, null);
    }
    
    public static CTRPrElt parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRPrElt)POIXMLTypeLoader.parse(param1URL, CTRPrElt.type, param1XmlOptions);
    }
    
    public static CTRPrElt parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTRPrElt)POIXMLTypeLoader.parse(param1InputStream, CTRPrElt.type, null);
    }
    
    public static CTRPrElt parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRPrElt)POIXMLTypeLoader.parse(param1InputStream, CTRPrElt.type, param1XmlOptions);
    }
    
    public static CTRPrElt parse(Reader param1Reader) throws XmlException, IOException {
      return (CTRPrElt)POIXMLTypeLoader.parse(param1Reader, CTRPrElt.type, null);
    }
    
    public static CTRPrElt parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRPrElt)POIXMLTypeLoader.parse(param1Reader, CTRPrElt.type, param1XmlOptions);
    }
    
    public static CTRPrElt parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTRPrElt)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRPrElt.type, null);
    }
    
    public static CTRPrElt parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRPrElt)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRPrElt.type, param1XmlOptions);
    }
    
    public static CTRPrElt parse(Node param1Node) throws XmlException {
      return (CTRPrElt)POIXMLTypeLoader.parse(param1Node, CTRPrElt.type, null);
    }
    
    public static CTRPrElt parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRPrElt)POIXMLTypeLoader.parse(param1Node, CTRPrElt.type, param1XmlOptions);
    }
    
    public static CTRPrElt parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTRPrElt)POIXMLTypeLoader.parse(param1XMLInputStream, CTRPrElt.type, null);
    }
    
    public static CTRPrElt parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTRPrElt)POIXMLTypeLoader.parse(param1XMLInputStream, CTRPrElt.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRPrElt.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRPrElt.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTRPrElt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */