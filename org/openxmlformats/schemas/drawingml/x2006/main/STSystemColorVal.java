package org.openxmlformats.schemas.drawingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STSystemColorVal extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STSystemColorVal.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stsystemcolorvalf938type");
  
  public static final Enum SCROLL_BAR = Enum.forString("scrollBar");
  
  public static final Enum BACKGROUND = Enum.forString("background");
  
  public static final Enum ACTIVE_CAPTION = Enum.forString("activeCaption");
  
  public static final Enum INACTIVE_CAPTION = Enum.forString("inactiveCaption");
  
  public static final Enum MENU = Enum.forString("menu");
  
  public static final Enum WINDOW = Enum.forString("window");
  
  public static final Enum WINDOW_FRAME = Enum.forString("windowFrame");
  
  public static final Enum MENU_TEXT = Enum.forString("menuText");
  
  public static final Enum WINDOW_TEXT = Enum.forString("windowText");
  
  public static final Enum CAPTION_TEXT = Enum.forString("captionText");
  
  public static final Enum ACTIVE_BORDER = Enum.forString("activeBorder");
  
  public static final Enum INACTIVE_BORDER = Enum.forString("inactiveBorder");
  
  public static final Enum APP_WORKSPACE = Enum.forString("appWorkspace");
  
  public static final Enum HIGHLIGHT = Enum.forString("highlight");
  
  public static final Enum HIGHLIGHT_TEXT = Enum.forString("highlightText");
  
  public static final Enum BTN_FACE = Enum.forString("btnFace");
  
  public static final Enum BTN_SHADOW = Enum.forString("btnShadow");
  
  public static final Enum GRAY_TEXT = Enum.forString("grayText");
  
  public static final Enum BTN_TEXT = Enum.forString("btnText");
  
  public static final Enum INACTIVE_CAPTION_TEXT = Enum.forString("inactiveCaptionText");
  
  public static final Enum BTN_HIGHLIGHT = Enum.forString("btnHighlight");
  
  public static final Enum X_3_D_DK_SHADOW = Enum.forString("3dDkShadow");
  
  public static final Enum X_3_D_LIGHT = Enum.forString("3dLight");
  
  public static final Enum INFO_TEXT = Enum.forString("infoText");
  
  public static final Enum INFO_BK = Enum.forString("infoBk");
  
  public static final Enum HOT_LIGHT = Enum.forString("hotLight");
  
  public static final Enum GRADIENT_ACTIVE_CAPTION = Enum.forString("gradientActiveCaption");
  
  public static final Enum GRADIENT_INACTIVE_CAPTION = Enum.forString("gradientInactiveCaption");
  
  public static final Enum MENU_HIGHLIGHT = Enum.forString("menuHighlight");
  
  public static final Enum MENU_BAR = Enum.forString("menuBar");
  
  public static final int INT_SCROLL_BAR = 1;
  
  public static final int INT_BACKGROUND = 2;
  
  public static final int INT_ACTIVE_CAPTION = 3;
  
  public static final int INT_INACTIVE_CAPTION = 4;
  
  public static final int INT_MENU = 5;
  
  public static final int INT_WINDOW = 6;
  
  public static final int INT_WINDOW_FRAME = 7;
  
  public static final int INT_MENU_TEXT = 8;
  
  public static final int INT_WINDOW_TEXT = 9;
  
  public static final int INT_CAPTION_TEXT = 10;
  
  public static final int INT_ACTIVE_BORDER = 11;
  
  public static final int INT_INACTIVE_BORDER = 12;
  
  public static final int INT_APP_WORKSPACE = 13;
  
  public static final int INT_HIGHLIGHT = 14;
  
  public static final int INT_HIGHLIGHT_TEXT = 15;
  
  public static final int INT_BTN_FACE = 16;
  
  public static final int INT_BTN_SHADOW = 17;
  
  public static final int INT_GRAY_TEXT = 18;
  
  public static final int INT_BTN_TEXT = 19;
  
  public static final int INT_INACTIVE_CAPTION_TEXT = 20;
  
  public static final int INT_BTN_HIGHLIGHT = 21;
  
  public static final int INT_X_3_D_DK_SHADOW = 22;
  
  public static final int INT_X_3_D_LIGHT = 23;
  
  public static final int INT_INFO_TEXT = 24;
  
  public static final int INT_INFO_BK = 25;
  
  public static final int INT_HOT_LIGHT = 26;
  
  public static final int INT_GRADIENT_ACTIVE_CAPTION = 27;
  
  public static final int INT_GRADIENT_INACTIVE_CAPTION = 28;
  
  public static final int INT_MENU_HIGHLIGHT = 29;
  
  public static final int INT_MENU_BAR = 30;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STSystemColorVal newValue(Object param1Object) {
      return (STSystemColorVal)STSystemColorVal.type.newValue(param1Object);
    }
    
    public static STSystemColorVal newInstance() {
      return (STSystemColorVal)POIXMLTypeLoader.newInstance(STSystemColorVal.type, null);
    }
    
    public static STSystemColorVal newInstance(XmlOptions param1XmlOptions) {
      return (STSystemColorVal)POIXMLTypeLoader.newInstance(STSystemColorVal.type, param1XmlOptions);
    }
    
    public static STSystemColorVal parse(String param1String) throws XmlException {
      return (STSystemColorVal)POIXMLTypeLoader.parse(param1String, STSystemColorVal.type, null);
    }
    
    public static STSystemColorVal parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STSystemColorVal)POIXMLTypeLoader.parse(param1String, STSystemColorVal.type, param1XmlOptions);
    }
    
    public static STSystemColorVal parse(File param1File) throws XmlException, IOException {
      return (STSystemColorVal)POIXMLTypeLoader.parse(param1File, STSystemColorVal.type, null);
    }
    
    public static STSystemColorVal parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSystemColorVal)POIXMLTypeLoader.parse(param1File, STSystemColorVal.type, param1XmlOptions);
    }
    
    public static STSystemColorVal parse(URL param1URL) throws XmlException, IOException {
      return (STSystemColorVal)POIXMLTypeLoader.parse(param1URL, STSystemColorVal.type, null);
    }
    
    public static STSystemColorVal parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSystemColorVal)POIXMLTypeLoader.parse(param1URL, STSystemColorVal.type, param1XmlOptions);
    }
    
    public static STSystemColorVal parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STSystemColorVal)POIXMLTypeLoader.parse(param1InputStream, STSystemColorVal.type, null);
    }
    
    public static STSystemColorVal parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSystemColorVal)POIXMLTypeLoader.parse(param1InputStream, STSystemColorVal.type, param1XmlOptions);
    }
    
    public static STSystemColorVal parse(Reader param1Reader) throws XmlException, IOException {
      return (STSystemColorVal)POIXMLTypeLoader.parse(param1Reader, STSystemColorVal.type, null);
    }
    
    public static STSystemColorVal parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSystemColorVal)POIXMLTypeLoader.parse(param1Reader, STSystemColorVal.type, param1XmlOptions);
    }
    
    public static STSystemColorVal parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STSystemColorVal)POIXMLTypeLoader.parse(param1XMLStreamReader, STSystemColorVal.type, null);
    }
    
    public static STSystemColorVal parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STSystemColorVal)POIXMLTypeLoader.parse(param1XMLStreamReader, STSystemColorVal.type, param1XmlOptions);
    }
    
    public static STSystemColorVal parse(Node param1Node) throws XmlException {
      return (STSystemColorVal)POIXMLTypeLoader.parse(param1Node, STSystemColorVal.type, null);
    }
    
    public static STSystemColorVal parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STSystemColorVal)POIXMLTypeLoader.parse(param1Node, STSystemColorVal.type, param1XmlOptions);
    }
    
    public static STSystemColorVal parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STSystemColorVal)POIXMLTypeLoader.parse(param1XMLInputStream, STSystemColorVal.type, null);
    }
    
    public static STSystemColorVal parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STSystemColorVal)POIXMLTypeLoader.parse(param1XMLInputStream, STSystemColorVal.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSystemColorVal.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSystemColorVal.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_SCROLL_BAR = 1;
    
    static final int INT_BACKGROUND = 2;
    
    static final int INT_ACTIVE_CAPTION = 3;
    
    static final int INT_INACTIVE_CAPTION = 4;
    
    static final int INT_MENU = 5;
    
    static final int INT_WINDOW = 6;
    
    static final int INT_WINDOW_FRAME = 7;
    
    static final int INT_MENU_TEXT = 8;
    
    static final int INT_WINDOW_TEXT = 9;
    
    static final int INT_CAPTION_TEXT = 10;
    
    static final int INT_ACTIVE_BORDER = 11;
    
    static final int INT_INACTIVE_BORDER = 12;
    
    static final int INT_APP_WORKSPACE = 13;
    
    static final int INT_HIGHLIGHT = 14;
    
    static final int INT_HIGHLIGHT_TEXT = 15;
    
    static final int INT_BTN_FACE = 16;
    
    static final int INT_BTN_SHADOW = 17;
    
    static final int INT_GRAY_TEXT = 18;
    
    static final int INT_BTN_TEXT = 19;
    
    static final int INT_INACTIVE_CAPTION_TEXT = 20;
    
    static final int INT_BTN_HIGHLIGHT = 21;
    
    static final int INT_X_3_D_DK_SHADOW = 22;
    
    static final int INT_X_3_D_LIGHT = 23;
    
    static final int INT_INFO_TEXT = 24;
    
    static final int INT_INFO_BK = 25;
    
    static final int INT_HOT_LIGHT = 26;
    
    static final int INT_GRADIENT_ACTIVE_CAPTION = 27;
    
    static final int INT_GRADIENT_INACTIVE_CAPTION = 28;
    
    static final int INT_MENU_HIGHLIGHT = 29;
    
    static final int INT_MENU_BAR = 30;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { 
          new Enum("scrollBar", 1), new Enum("background", 2), new Enum("activeCaption", 3), new Enum("inactiveCaption", 4), new Enum("menu", 5), new Enum("window", 6), new Enum("windowFrame", 7), new Enum("menuText", 8), new Enum("windowText", 9), new Enum("captionText", 10), 
          new Enum("activeBorder", 11), new Enum("inactiveBorder", 12), new Enum("appWorkspace", 13), new Enum("highlight", 14), new Enum("highlightText", 15), new Enum("btnFace", 16), new Enum("btnShadow", 17), new Enum("grayText", 18), new Enum("btnText", 19), new Enum("inactiveCaptionText", 20), 
          new Enum("btnHighlight", 21), new Enum("3dDkShadow", 22), new Enum("3dLight", 23), new Enum("infoText", 24), new Enum("infoBk", 25), new Enum("hotLight", 26), new Enum("gradientActiveCaption", 27), new Enum("gradientInactiveCaption", 28), new Enum("menuHighlight", 29), new Enum("menuBar", 30) });
    
    private static final long serialVersionUID = 1L;
    
    public static Enum forString(String param1String) {
      return (Enum)table.forString(param1String);
    }
    
    public static Enum forInt(int param1Int) {
      return (Enum)table.forInt(param1Int);
    }
    
    private Enum(String param1String, int param1Int) {
      super(param1String, param1Int);
    }
    
    private Object readResolve() {
      return forInt(intValue());
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STSystemColorVal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */