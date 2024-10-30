package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTPath2D extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPath2D.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpath2d73d2type");
  
  List<CTPath2DClose> getCloseList();
  
  CTPath2DClose[] getCloseArray();
  
  CTPath2DClose getCloseArray(int paramInt);
  
  int sizeOfCloseArray();
  
  void setCloseArray(CTPath2DClose[] paramArrayOfCTPath2DClose);
  
  void setCloseArray(int paramInt, CTPath2DClose paramCTPath2DClose);
  
  CTPath2DClose insertNewClose(int paramInt);
  
  CTPath2DClose addNewClose();
  
  void removeClose(int paramInt);
  
  List<CTPath2DMoveTo> getMoveToList();
  
  CTPath2DMoveTo[] getMoveToArray();
  
  CTPath2DMoveTo getMoveToArray(int paramInt);
  
  int sizeOfMoveToArray();
  
  void setMoveToArray(CTPath2DMoveTo[] paramArrayOfCTPath2DMoveTo);
  
  void setMoveToArray(int paramInt, CTPath2DMoveTo paramCTPath2DMoveTo);
  
  CTPath2DMoveTo insertNewMoveTo(int paramInt);
  
  CTPath2DMoveTo addNewMoveTo();
  
  void removeMoveTo(int paramInt);
  
  List<CTPath2DLineTo> getLnToList();
  
  CTPath2DLineTo[] getLnToArray();
  
  CTPath2DLineTo getLnToArray(int paramInt);
  
  int sizeOfLnToArray();
  
  void setLnToArray(CTPath2DLineTo[] paramArrayOfCTPath2DLineTo);
  
  void setLnToArray(int paramInt, CTPath2DLineTo paramCTPath2DLineTo);
  
  CTPath2DLineTo insertNewLnTo(int paramInt);
  
  CTPath2DLineTo addNewLnTo();
  
  void removeLnTo(int paramInt);
  
  List<CTPath2DArcTo> getArcToList();
  
  CTPath2DArcTo[] getArcToArray();
  
  CTPath2DArcTo getArcToArray(int paramInt);
  
  int sizeOfArcToArray();
  
  void setArcToArray(CTPath2DArcTo[] paramArrayOfCTPath2DArcTo);
  
  void setArcToArray(int paramInt, CTPath2DArcTo paramCTPath2DArcTo);
  
  CTPath2DArcTo insertNewArcTo(int paramInt);
  
  CTPath2DArcTo addNewArcTo();
  
  void removeArcTo(int paramInt);
  
  List<CTPath2DQuadBezierTo> getQuadBezToList();
  
  CTPath2DQuadBezierTo[] getQuadBezToArray();
  
  CTPath2DQuadBezierTo getQuadBezToArray(int paramInt);
  
  int sizeOfQuadBezToArray();
  
  void setQuadBezToArray(CTPath2DQuadBezierTo[] paramArrayOfCTPath2DQuadBezierTo);
  
  void setQuadBezToArray(int paramInt, CTPath2DQuadBezierTo paramCTPath2DQuadBezierTo);
  
  CTPath2DQuadBezierTo insertNewQuadBezTo(int paramInt);
  
  CTPath2DQuadBezierTo addNewQuadBezTo();
  
  void removeQuadBezTo(int paramInt);
  
  List<CTPath2DCubicBezierTo> getCubicBezToList();
  
  CTPath2DCubicBezierTo[] getCubicBezToArray();
  
  CTPath2DCubicBezierTo getCubicBezToArray(int paramInt);
  
  int sizeOfCubicBezToArray();
  
  void setCubicBezToArray(CTPath2DCubicBezierTo[] paramArrayOfCTPath2DCubicBezierTo);
  
  void setCubicBezToArray(int paramInt, CTPath2DCubicBezierTo paramCTPath2DCubicBezierTo);
  
  CTPath2DCubicBezierTo insertNewCubicBezTo(int paramInt);
  
  CTPath2DCubicBezierTo addNewCubicBezTo();
  
  void removeCubicBezTo(int paramInt);
  
  long getW();
  
  STPositiveCoordinate xgetW();
  
  boolean isSetW();
  
  void setW(long paramLong);
  
  void xsetW(STPositiveCoordinate paramSTPositiveCoordinate);
  
  void unsetW();
  
  long getH();
  
  STPositiveCoordinate xgetH();
  
  boolean isSetH();
  
  void setH(long paramLong);
  
  void xsetH(STPositiveCoordinate paramSTPositiveCoordinate);
  
  void unsetH();
  
  STPathFillMode$Enum getFill();
  
  STPathFillMode xgetFill();
  
  boolean isSetFill();
  
  void setFill(STPathFillMode$Enum paramSTPathFillMode$Enum);
  
  void xsetFill(STPathFillMode paramSTPathFillMode);
  
  void unsetFill();
  
  boolean getStroke();
  
  XmlBoolean xgetStroke();
  
  boolean isSetStroke();
  
  void setStroke(boolean paramBoolean);
  
  void xsetStroke(XmlBoolean paramXmlBoolean);
  
  void unsetStroke();
  
  boolean getExtrusionOk();
  
  XmlBoolean xgetExtrusionOk();
  
  boolean isSetExtrusionOk();
  
  void setExtrusionOk(boolean paramBoolean);
  
  void xsetExtrusionOk(XmlBoolean paramXmlBoolean);
  
  void unsetExtrusionOk();
  
  public static final class Factory {
    public static CTPath2D newInstance() {
      return (CTPath2D)POIXMLTypeLoader.newInstance(CTPath2D.type, null);
    }
    
    public static CTPath2D newInstance(XmlOptions param1XmlOptions) {
      return (CTPath2D)POIXMLTypeLoader.newInstance(CTPath2D.type, param1XmlOptions);
    }
    
    public static CTPath2D parse(String param1String) throws XmlException {
      return (CTPath2D)POIXMLTypeLoader.parse(param1String, CTPath2D.type, null);
    }
    
    public static CTPath2D parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPath2D)POIXMLTypeLoader.parse(param1String, CTPath2D.type, param1XmlOptions);
    }
    
    public static CTPath2D parse(File param1File) throws XmlException, IOException {
      return (CTPath2D)POIXMLTypeLoader.parse(param1File, CTPath2D.type, null);
    }
    
    public static CTPath2D parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPath2D)POIXMLTypeLoader.parse(param1File, CTPath2D.type, param1XmlOptions);
    }
    
    public static CTPath2D parse(URL param1URL) throws XmlException, IOException {
      return (CTPath2D)POIXMLTypeLoader.parse(param1URL, CTPath2D.type, null);
    }
    
    public static CTPath2D parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPath2D)POIXMLTypeLoader.parse(param1URL, CTPath2D.type, param1XmlOptions);
    }
    
    public static CTPath2D parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPath2D)POIXMLTypeLoader.parse(param1InputStream, CTPath2D.type, null);
    }
    
    public static CTPath2D parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPath2D)POIXMLTypeLoader.parse(param1InputStream, CTPath2D.type, param1XmlOptions);
    }
    
    public static CTPath2D parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPath2D)POIXMLTypeLoader.parse(param1Reader, CTPath2D.type, null);
    }
    
    public static CTPath2D parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPath2D)POIXMLTypeLoader.parse(param1Reader, CTPath2D.type, param1XmlOptions);
    }
    
    public static CTPath2D parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPath2D)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPath2D.type, null);
    }
    
    public static CTPath2D parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPath2D)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPath2D.type, param1XmlOptions);
    }
    
    public static CTPath2D parse(Node param1Node) throws XmlException {
      return (CTPath2D)POIXMLTypeLoader.parse(param1Node, CTPath2D.type, null);
    }
    
    public static CTPath2D parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPath2D)POIXMLTypeLoader.parse(param1Node, CTPath2D.type, param1XmlOptions);
    }
    
    public static CTPath2D parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPath2D)POIXMLTypeLoader.parse(param1XMLInputStream, CTPath2D.type, null);
    }
    
    public static CTPath2D parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPath2D)POIXMLTypeLoader.parse(param1XMLInputStream, CTPath2D.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPath2D.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPath2D.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTPath2D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */