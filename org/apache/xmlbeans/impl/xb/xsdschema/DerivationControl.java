/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.StringEnumAbstractBase;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface DerivationControl extends XmlNMTOKEN {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationControl == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationControl = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.DerivationControl")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationControl).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("derivationcontrola5dftype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  24 */   public static final Enum SUBSTITUTION = Enum.forString("substitution");
/*  25 */   public static final Enum EXTENSION = Enum.forString("extension");
/*  26 */   public static final Enum RESTRICTION = Enum.forString("restriction");
/*  27 */   public static final Enum LIST = Enum.forString("list");
/*  28 */   public static final Enum UNION = Enum.forString("union");
/*     */   
/*     */   public static final int INT_SUBSTITUTION = 1;
/*     */   
/*     */   public static final int INT_EXTENSION = 2;
/*     */   
/*     */   public static final int INT_RESTRICTION = 3;
/*     */   
/*     */   public static final int INT_LIST = 4;
/*     */   
/*     */   public static final int INT_UNION = 5;
/*     */ 
/*     */   
/*     */   StringEnumAbstractBase enumValue();
/*     */ 
/*     */   
/*     */   void set(StringEnumAbstractBase paramStringEnumAbstractBase);
/*     */ 
/*     */   
/*     */   public static final class Enum
/*     */     extends StringEnumAbstractBase
/*     */   {
/*     */     static final int INT_SUBSTITUTION = 1;
/*     */     static final int INT_EXTENSION = 2;
/*     */     static final int INT_RESTRICTION = 3;
/*     */     static final int INT_LIST = 4;
/*     */     static final int INT_UNION = 5;
/*     */     
/*     */     public static Enum forString(String param1String) {
/*  57 */       return (Enum)table.forString(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public static Enum forInt(int param1Int) {
/*  62 */       return (Enum)table.forInt(param1Int);
/*     */     }
/*     */     private Enum(String param1String, int param1Int) {
/*  65 */       super(param1String, param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  73 */     public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("substitution", 1), new Enum("extension", 2), new Enum("restriction", 3), new Enum("list", 4), new Enum("union", 5) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Object readResolve() {
/*  86 */       return forInt(intValue());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static DerivationControl newValue(Object param1Object) {
/*  97 */       return (DerivationControl)DerivationControl.type.newValue(param1Object);
/*     */     }
/*     */     public static DerivationControl newInstance() {
/* 100 */       return (DerivationControl)XmlBeans.getContextTypeLoader().newInstance(DerivationControl.type, null);
/*     */     }
/*     */     public static DerivationControl newInstance(XmlOptions param1XmlOptions) {
/* 103 */       return (DerivationControl)XmlBeans.getContextTypeLoader().newInstance(DerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static DerivationControl parse(String param1String) throws XmlException {
/* 107 */       return (DerivationControl)XmlBeans.getContextTypeLoader().parse(param1String, DerivationControl.type, null);
/*     */     }
/*     */     public static DerivationControl parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 110 */       return (DerivationControl)XmlBeans.getContextTypeLoader().parse(param1String, DerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static DerivationControl parse(File param1File) throws XmlException, IOException {
/* 114 */       return (DerivationControl)XmlBeans.getContextTypeLoader().parse(param1File, DerivationControl.type, null);
/*     */     }
/*     */     public static DerivationControl parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 117 */       return (DerivationControl)XmlBeans.getContextTypeLoader().parse(param1File, DerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     public static DerivationControl parse(URL param1URL) throws XmlException, IOException {
/* 120 */       return (DerivationControl)XmlBeans.getContextTypeLoader().parse(param1URL, DerivationControl.type, null);
/*     */     }
/*     */     public static DerivationControl parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 123 */       return (DerivationControl)XmlBeans.getContextTypeLoader().parse(param1URL, DerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     public static DerivationControl parse(InputStream param1InputStream) throws XmlException, IOException {
/* 126 */       return (DerivationControl)XmlBeans.getContextTypeLoader().parse(param1InputStream, DerivationControl.type, null);
/*     */     }
/*     */     public static DerivationControl parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 129 */       return (DerivationControl)XmlBeans.getContextTypeLoader().parse(param1InputStream, DerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     public static DerivationControl parse(Reader param1Reader) throws XmlException, IOException {
/* 132 */       return (DerivationControl)XmlBeans.getContextTypeLoader().parse(param1Reader, DerivationControl.type, null);
/*     */     }
/*     */     public static DerivationControl parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 135 */       return (DerivationControl)XmlBeans.getContextTypeLoader().parse(param1Reader, DerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     public static DerivationControl parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 138 */       return (DerivationControl)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, DerivationControl.type, null);
/*     */     }
/*     */     public static DerivationControl parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 141 */       return (DerivationControl)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, DerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     public static DerivationControl parse(Node param1Node) throws XmlException {
/* 144 */       return (DerivationControl)XmlBeans.getContextTypeLoader().parse(param1Node, DerivationControl.type, null);
/*     */     }
/*     */     public static DerivationControl parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 147 */       return (DerivationControl)XmlBeans.getContextTypeLoader().parse(param1Node, DerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static DerivationControl parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 151 */       return (DerivationControl)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, DerivationControl.type, null);
/*     */     }
/*     */     
/*     */     public static DerivationControl parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 155 */       return (DerivationControl)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, DerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 159 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, DerivationControl.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 163 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, DerivationControl.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\DerivationControl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */