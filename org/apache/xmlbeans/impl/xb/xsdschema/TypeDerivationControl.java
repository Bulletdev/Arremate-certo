/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface TypeDerivationControl extends DerivationControl {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$TypeDerivationControl == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$TypeDerivationControl = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.TypeDerivationControl")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$TypeDerivationControl).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("typederivationcontrol3239type");
/*     */ 
/*     */   
/*  21 */   public static final DerivationControl.Enum EXTENSION = DerivationControl.EXTENSION;
/*  22 */   public static final DerivationControl.Enum RESTRICTION = DerivationControl.RESTRICTION;
/*  23 */   public static final DerivationControl.Enum LIST = DerivationControl.LIST;
/*  24 */   public static final DerivationControl.Enum UNION = DerivationControl.UNION;
/*     */ 
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
/*     */   public static final class Factory
/*     */   {
/*     */     public static TypeDerivationControl newValue(Object param1Object) {
/*  39 */       return (TypeDerivationControl)TypeDerivationControl.type.newValue(param1Object);
/*     */     }
/*     */     public static TypeDerivationControl newInstance() {
/*  42 */       return (TypeDerivationControl)XmlBeans.getContextTypeLoader().newInstance(TypeDerivationControl.type, null);
/*     */     }
/*     */     public static TypeDerivationControl newInstance(XmlOptions param1XmlOptions) {
/*  45 */       return (TypeDerivationControl)XmlBeans.getContextTypeLoader().newInstance(TypeDerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TypeDerivationControl parse(String param1String) throws XmlException {
/*  49 */       return (TypeDerivationControl)XmlBeans.getContextTypeLoader().parse(param1String, TypeDerivationControl.type, null);
/*     */     }
/*     */     public static TypeDerivationControl parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  52 */       return (TypeDerivationControl)XmlBeans.getContextTypeLoader().parse(param1String, TypeDerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TypeDerivationControl parse(File param1File) throws XmlException, IOException {
/*  56 */       return (TypeDerivationControl)XmlBeans.getContextTypeLoader().parse(param1File, TypeDerivationControl.type, null);
/*     */     }
/*     */     public static TypeDerivationControl parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  59 */       return (TypeDerivationControl)XmlBeans.getContextTypeLoader().parse(param1File, TypeDerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     public static TypeDerivationControl parse(URL param1URL) throws XmlException, IOException {
/*  62 */       return (TypeDerivationControl)XmlBeans.getContextTypeLoader().parse(param1URL, TypeDerivationControl.type, null);
/*     */     }
/*     */     public static TypeDerivationControl parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  65 */       return (TypeDerivationControl)XmlBeans.getContextTypeLoader().parse(param1URL, TypeDerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     public static TypeDerivationControl parse(InputStream param1InputStream) throws XmlException, IOException {
/*  68 */       return (TypeDerivationControl)XmlBeans.getContextTypeLoader().parse(param1InputStream, TypeDerivationControl.type, null);
/*     */     }
/*     */     public static TypeDerivationControl parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  71 */       return (TypeDerivationControl)XmlBeans.getContextTypeLoader().parse(param1InputStream, TypeDerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     public static TypeDerivationControl parse(Reader param1Reader) throws XmlException, IOException {
/*  74 */       return (TypeDerivationControl)XmlBeans.getContextTypeLoader().parse(param1Reader, TypeDerivationControl.type, null);
/*     */     }
/*     */     public static TypeDerivationControl parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  77 */       return (TypeDerivationControl)XmlBeans.getContextTypeLoader().parse(param1Reader, TypeDerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     public static TypeDerivationControl parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  80 */       return (TypeDerivationControl)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, TypeDerivationControl.type, null);
/*     */     }
/*     */     public static TypeDerivationControl parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  83 */       return (TypeDerivationControl)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, TypeDerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     public static TypeDerivationControl parse(Node param1Node) throws XmlException {
/*  86 */       return (TypeDerivationControl)XmlBeans.getContextTypeLoader().parse(param1Node, TypeDerivationControl.type, null);
/*     */     }
/*     */     public static TypeDerivationControl parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  89 */       return (TypeDerivationControl)XmlBeans.getContextTypeLoader().parse(param1Node, TypeDerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static TypeDerivationControl parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  93 */       return (TypeDerivationControl)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, TypeDerivationControl.type, null);
/*     */     }
/*     */     
/*     */     public static TypeDerivationControl parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/*  97 */       return (TypeDerivationControl)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, TypeDerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 101 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, TypeDerivationControl.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 105 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, TypeDerivationControl.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\TypeDerivationControl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */