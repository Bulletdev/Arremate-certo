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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTSheetView extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSheetView.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsheetview0f43type");
  
  CTPane getPane();
  
  boolean isSetPane();
  
  void setPane(CTPane paramCTPane);
  
  CTPane addNewPane();
  
  void unsetPane();
  
  List<CTSelection> getSelectionList();
  
  CTSelection[] getSelectionArray();
  
  CTSelection getSelectionArray(int paramInt);
  
  int sizeOfSelectionArray();
  
  void setSelectionArray(CTSelection[] paramArrayOfCTSelection);
  
  void setSelectionArray(int paramInt, CTSelection paramCTSelection);
  
  CTSelection insertNewSelection(int paramInt);
  
  CTSelection addNewSelection();
  
  void removeSelection(int paramInt);
  
  List<CTPivotSelection> getPivotSelectionList();
  
  CTPivotSelection[] getPivotSelectionArray();
  
  CTPivotSelection getPivotSelectionArray(int paramInt);
  
  int sizeOfPivotSelectionArray();
  
  void setPivotSelectionArray(CTPivotSelection[] paramArrayOfCTPivotSelection);
  
  void setPivotSelectionArray(int paramInt, CTPivotSelection paramCTPivotSelection);
  
  CTPivotSelection insertNewPivotSelection(int paramInt);
  
  CTPivotSelection addNewPivotSelection();
  
  void removePivotSelection(int paramInt);
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  boolean getWindowProtection();
  
  XmlBoolean xgetWindowProtection();
  
  boolean isSetWindowProtection();
  
  void setWindowProtection(boolean paramBoolean);
  
  void xsetWindowProtection(XmlBoolean paramXmlBoolean);
  
  void unsetWindowProtection();
  
  boolean getShowFormulas();
  
  XmlBoolean xgetShowFormulas();
  
  boolean isSetShowFormulas();
  
  void setShowFormulas(boolean paramBoolean);
  
  void xsetShowFormulas(XmlBoolean paramXmlBoolean);
  
  void unsetShowFormulas();
  
  boolean getShowGridLines();
  
  XmlBoolean xgetShowGridLines();
  
  boolean isSetShowGridLines();
  
  void setShowGridLines(boolean paramBoolean);
  
  void xsetShowGridLines(XmlBoolean paramXmlBoolean);
  
  void unsetShowGridLines();
  
  boolean getShowRowColHeaders();
  
  XmlBoolean xgetShowRowColHeaders();
  
  boolean isSetShowRowColHeaders();
  
  void setShowRowColHeaders(boolean paramBoolean);
  
  void xsetShowRowColHeaders(XmlBoolean paramXmlBoolean);
  
  void unsetShowRowColHeaders();
  
  boolean getShowZeros();
  
  XmlBoolean xgetShowZeros();
  
  boolean isSetShowZeros();
  
  void setShowZeros(boolean paramBoolean);
  
  void xsetShowZeros(XmlBoolean paramXmlBoolean);
  
  void unsetShowZeros();
  
  boolean getRightToLeft();
  
  XmlBoolean xgetRightToLeft();
  
  boolean isSetRightToLeft();
  
  void setRightToLeft(boolean paramBoolean);
  
  void xsetRightToLeft(XmlBoolean paramXmlBoolean);
  
  void unsetRightToLeft();
  
  boolean getTabSelected();
  
  XmlBoolean xgetTabSelected();
  
  boolean isSetTabSelected();
  
  void setTabSelected(boolean paramBoolean);
  
  void xsetTabSelected(XmlBoolean paramXmlBoolean);
  
  void unsetTabSelected();
  
  boolean getShowRuler();
  
  XmlBoolean xgetShowRuler();
  
  boolean isSetShowRuler();
  
  void setShowRuler(boolean paramBoolean);
  
  void xsetShowRuler(XmlBoolean paramXmlBoolean);
  
  void unsetShowRuler();
  
  boolean getShowOutlineSymbols();
  
  XmlBoolean xgetShowOutlineSymbols();
  
  boolean isSetShowOutlineSymbols();
  
  void setShowOutlineSymbols(boolean paramBoolean);
  
  void xsetShowOutlineSymbols(XmlBoolean paramXmlBoolean);
  
  void unsetShowOutlineSymbols();
  
  boolean getDefaultGridColor();
  
  XmlBoolean xgetDefaultGridColor();
  
  boolean isSetDefaultGridColor();
  
  void setDefaultGridColor(boolean paramBoolean);
  
  void xsetDefaultGridColor(XmlBoolean paramXmlBoolean);
  
  void unsetDefaultGridColor();
  
  boolean getShowWhiteSpace();
  
  XmlBoolean xgetShowWhiteSpace();
  
  boolean isSetShowWhiteSpace();
  
  void setShowWhiteSpace(boolean paramBoolean);
  
  void xsetShowWhiteSpace(XmlBoolean paramXmlBoolean);
  
  void unsetShowWhiteSpace();
  
  STSheetViewType$Enum getView();
  
  STSheetViewType xgetView();
  
  boolean isSetView();
  
  void setView(STSheetViewType$Enum paramSTSheetViewType$Enum);
  
  void xsetView(STSheetViewType paramSTSheetViewType);
  
  void unsetView();
  
  String getTopLeftCell();
  
  STCellRef xgetTopLeftCell();
  
  boolean isSetTopLeftCell();
  
  void setTopLeftCell(String paramString);
  
  void xsetTopLeftCell(STCellRef paramSTCellRef);
  
  void unsetTopLeftCell();
  
  long getColorId();
  
  XmlUnsignedInt xgetColorId();
  
  boolean isSetColorId();
  
  void setColorId(long paramLong);
  
  void xsetColorId(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetColorId();
  
  long getZoomScale();
  
  XmlUnsignedInt xgetZoomScale();
  
  boolean isSetZoomScale();
  
  void setZoomScale(long paramLong);
  
  void xsetZoomScale(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetZoomScale();
  
  long getZoomScaleNormal();
  
  XmlUnsignedInt xgetZoomScaleNormal();
  
  boolean isSetZoomScaleNormal();
  
  void setZoomScaleNormal(long paramLong);
  
  void xsetZoomScaleNormal(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetZoomScaleNormal();
  
  long getZoomScaleSheetLayoutView();
  
  XmlUnsignedInt xgetZoomScaleSheetLayoutView();
  
  boolean isSetZoomScaleSheetLayoutView();
  
  void setZoomScaleSheetLayoutView(long paramLong);
  
  void xsetZoomScaleSheetLayoutView(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetZoomScaleSheetLayoutView();
  
  long getZoomScalePageLayoutView();
  
  XmlUnsignedInt xgetZoomScalePageLayoutView();
  
  boolean isSetZoomScalePageLayoutView();
  
  void setZoomScalePageLayoutView(long paramLong);
  
  void xsetZoomScalePageLayoutView(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetZoomScalePageLayoutView();
  
  long getWorkbookViewId();
  
  XmlUnsignedInt xgetWorkbookViewId();
  
  void setWorkbookViewId(long paramLong);
  
  void xsetWorkbookViewId(XmlUnsignedInt paramXmlUnsignedInt);
  
  public static final class Factory {
    public static CTSheetView newInstance() {
      return (CTSheetView)POIXMLTypeLoader.newInstance(CTSheetView.type, null);
    }
    
    public static CTSheetView newInstance(XmlOptions param1XmlOptions) {
      return (CTSheetView)POIXMLTypeLoader.newInstance(CTSheetView.type, param1XmlOptions);
    }
    
    public static CTSheetView parse(String param1String) throws XmlException {
      return (CTSheetView)POIXMLTypeLoader.parse(param1String, CTSheetView.type, null);
    }
    
    public static CTSheetView parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheetView)POIXMLTypeLoader.parse(param1String, CTSheetView.type, param1XmlOptions);
    }
    
    public static CTSheetView parse(File param1File) throws XmlException, IOException {
      return (CTSheetView)POIXMLTypeLoader.parse(param1File, CTSheetView.type, null);
    }
    
    public static CTSheetView parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetView)POIXMLTypeLoader.parse(param1File, CTSheetView.type, param1XmlOptions);
    }
    
    public static CTSheetView parse(URL param1URL) throws XmlException, IOException {
      return (CTSheetView)POIXMLTypeLoader.parse(param1URL, CTSheetView.type, null);
    }
    
    public static CTSheetView parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetView)POIXMLTypeLoader.parse(param1URL, CTSheetView.type, param1XmlOptions);
    }
    
    public static CTSheetView parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSheetView)POIXMLTypeLoader.parse(param1InputStream, CTSheetView.type, null);
    }
    
    public static CTSheetView parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetView)POIXMLTypeLoader.parse(param1InputStream, CTSheetView.type, param1XmlOptions);
    }
    
    public static CTSheetView parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSheetView)POIXMLTypeLoader.parse(param1Reader, CTSheetView.type, null);
    }
    
    public static CTSheetView parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetView)POIXMLTypeLoader.parse(param1Reader, CTSheetView.type, param1XmlOptions);
    }
    
    public static CTSheetView parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSheetView)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSheetView.type, null);
    }
    
    public static CTSheetView parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheetView)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSheetView.type, param1XmlOptions);
    }
    
    public static CTSheetView parse(Node param1Node) throws XmlException {
      return (CTSheetView)POIXMLTypeLoader.parse(param1Node, CTSheetView.type, null);
    }
    
    public static CTSheetView parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheetView)POIXMLTypeLoader.parse(param1Node, CTSheetView.type, param1XmlOptions);
    }
    
    public static CTSheetView parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSheetView)POIXMLTypeLoader.parse(param1XMLInputStream, CTSheetView.type, null);
    }
    
    public static CTSheetView parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSheetView)POIXMLTypeLoader.parse(param1XMLInputStream, CTSheetView.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSheetView.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSheetView.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTSheetView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */