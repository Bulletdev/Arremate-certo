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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTStylesheet extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTStylesheet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctstylesheet4257type");
  
  CTNumFmts getNumFmts();
  
  boolean isSetNumFmts();
  
  void setNumFmts(CTNumFmts paramCTNumFmts);
  
  CTNumFmts addNewNumFmts();
  
  void unsetNumFmts();
  
  CTFonts getFonts();
  
  boolean isSetFonts();
  
  void setFonts(CTFonts paramCTFonts);
  
  CTFonts addNewFonts();
  
  void unsetFonts();
  
  CTFills getFills();
  
  boolean isSetFills();
  
  void setFills(CTFills paramCTFills);
  
  CTFills addNewFills();
  
  void unsetFills();
  
  CTBorders getBorders();
  
  boolean isSetBorders();
  
  void setBorders(CTBorders paramCTBorders);
  
  CTBorders addNewBorders();
  
  void unsetBorders();
  
  CTCellStyleXfs getCellStyleXfs();
  
  boolean isSetCellStyleXfs();
  
  void setCellStyleXfs(CTCellStyleXfs paramCTCellStyleXfs);
  
  CTCellStyleXfs addNewCellStyleXfs();
  
  void unsetCellStyleXfs();
  
  CTCellXfs getCellXfs();
  
  boolean isSetCellXfs();
  
  void setCellXfs(CTCellXfs paramCTCellXfs);
  
  CTCellXfs addNewCellXfs();
  
  void unsetCellXfs();
  
  CTCellStyles getCellStyles();
  
  boolean isSetCellStyles();
  
  void setCellStyles(CTCellStyles paramCTCellStyles);
  
  CTCellStyles addNewCellStyles();
  
  void unsetCellStyles();
  
  CTDxfs getDxfs();
  
  boolean isSetDxfs();
  
  void setDxfs(CTDxfs paramCTDxfs);
  
  CTDxfs addNewDxfs();
  
  void unsetDxfs();
  
  CTTableStyles getTableStyles();
  
  boolean isSetTableStyles();
  
  void setTableStyles(CTTableStyles paramCTTableStyles);
  
  CTTableStyles addNewTableStyles();
  
  void unsetTableStyles();
  
  CTColors getColors();
  
  boolean isSetColors();
  
  void setColors(CTColors paramCTColors);
  
  CTColors addNewColors();
  
  void unsetColors();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTStylesheet newInstance() {
      return (CTStylesheet)POIXMLTypeLoader.newInstance(CTStylesheet.type, null);
    }
    
    public static CTStylesheet newInstance(XmlOptions param1XmlOptions) {
      return (CTStylesheet)POIXMLTypeLoader.newInstance(CTStylesheet.type, param1XmlOptions);
    }
    
    public static CTStylesheet parse(String param1String) throws XmlException {
      return (CTStylesheet)POIXMLTypeLoader.parse(param1String, CTStylesheet.type, null);
    }
    
    public static CTStylesheet parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStylesheet)POIXMLTypeLoader.parse(param1String, CTStylesheet.type, param1XmlOptions);
    }
    
    public static CTStylesheet parse(File param1File) throws XmlException, IOException {
      return (CTStylesheet)POIXMLTypeLoader.parse(param1File, CTStylesheet.type, null);
    }
    
    public static CTStylesheet parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStylesheet)POIXMLTypeLoader.parse(param1File, CTStylesheet.type, param1XmlOptions);
    }
    
    public static CTStylesheet parse(URL param1URL) throws XmlException, IOException {
      return (CTStylesheet)POIXMLTypeLoader.parse(param1URL, CTStylesheet.type, null);
    }
    
    public static CTStylesheet parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStylesheet)POIXMLTypeLoader.parse(param1URL, CTStylesheet.type, param1XmlOptions);
    }
    
    public static CTStylesheet parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTStylesheet)POIXMLTypeLoader.parse(param1InputStream, CTStylesheet.type, null);
    }
    
    public static CTStylesheet parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStylesheet)POIXMLTypeLoader.parse(param1InputStream, CTStylesheet.type, param1XmlOptions);
    }
    
    public static CTStylesheet parse(Reader param1Reader) throws XmlException, IOException {
      return (CTStylesheet)POIXMLTypeLoader.parse(param1Reader, CTStylesheet.type, null);
    }
    
    public static CTStylesheet parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStylesheet)POIXMLTypeLoader.parse(param1Reader, CTStylesheet.type, param1XmlOptions);
    }
    
    public static CTStylesheet parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTStylesheet)POIXMLTypeLoader.parse(param1XMLStreamReader, CTStylesheet.type, null);
    }
    
    public static CTStylesheet parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStylesheet)POIXMLTypeLoader.parse(param1XMLStreamReader, CTStylesheet.type, param1XmlOptions);
    }
    
    public static CTStylesheet parse(Node param1Node) throws XmlException {
      return (CTStylesheet)POIXMLTypeLoader.parse(param1Node, CTStylesheet.type, null);
    }
    
    public static CTStylesheet parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStylesheet)POIXMLTypeLoader.parse(param1Node, CTStylesheet.type, param1XmlOptions);
    }
    
    public static CTStylesheet parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTStylesheet)POIXMLTypeLoader.parse(param1XMLInputStream, CTStylesheet.type, null);
    }
    
    public static CTStylesheet parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTStylesheet)POIXMLTypeLoader.parse(param1XMLInputStream, CTStylesheet.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTStylesheet.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTStylesheet.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTStylesheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */