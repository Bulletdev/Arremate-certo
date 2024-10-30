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
/*     */ public interface ReducedDerivationControl extends DerivationControl {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$ReducedDerivationControl == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$ReducedDerivationControl = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.ReducedDerivationControl")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$ReducedDerivationControl).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("reducedderivationcontrole1cbtype");
/*     */ 
/*     */   
/*  21 */   public static final DerivationControl.Enum EXTENSION = DerivationControl.EXTENSION;
/*  22 */   public static final DerivationControl.Enum RESTRICTION = DerivationControl.RESTRICTION;
/*     */ 
/*     */   
/*     */   public static final int INT_EXTENSION = 2;
/*     */ 
/*     */   
/*     */   public static final int INT_RESTRICTION = 3;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static ReducedDerivationControl newValue(Object param1Object) {
/*  35 */       return (ReducedDerivationControl)ReducedDerivationControl.type.newValue(param1Object);
/*     */     }
/*     */     public static ReducedDerivationControl newInstance() {
/*  38 */       return (ReducedDerivationControl)XmlBeans.getContextTypeLoader().newInstance(ReducedDerivationControl.type, null);
/*     */     }
/*     */     public static ReducedDerivationControl newInstance(XmlOptions param1XmlOptions) {
/*  41 */       return (ReducedDerivationControl)XmlBeans.getContextTypeLoader().newInstance(ReducedDerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ReducedDerivationControl parse(String param1String) throws XmlException {
/*  45 */       return (ReducedDerivationControl)XmlBeans.getContextTypeLoader().parse(param1String, ReducedDerivationControl.type, null);
/*     */     }
/*     */     public static ReducedDerivationControl parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  48 */       return (ReducedDerivationControl)XmlBeans.getContextTypeLoader().parse(param1String, ReducedDerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ReducedDerivationControl parse(File param1File) throws XmlException, IOException {
/*  52 */       return (ReducedDerivationControl)XmlBeans.getContextTypeLoader().parse(param1File, ReducedDerivationControl.type, null);
/*     */     }
/*     */     public static ReducedDerivationControl parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  55 */       return (ReducedDerivationControl)XmlBeans.getContextTypeLoader().parse(param1File, ReducedDerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     public static ReducedDerivationControl parse(URL param1URL) throws XmlException, IOException {
/*  58 */       return (ReducedDerivationControl)XmlBeans.getContextTypeLoader().parse(param1URL, ReducedDerivationControl.type, null);
/*     */     }
/*     */     public static ReducedDerivationControl parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  61 */       return (ReducedDerivationControl)XmlBeans.getContextTypeLoader().parse(param1URL, ReducedDerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     public static ReducedDerivationControl parse(InputStream param1InputStream) throws XmlException, IOException {
/*  64 */       return (ReducedDerivationControl)XmlBeans.getContextTypeLoader().parse(param1InputStream, ReducedDerivationControl.type, null);
/*     */     }
/*     */     public static ReducedDerivationControl parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  67 */       return (ReducedDerivationControl)XmlBeans.getContextTypeLoader().parse(param1InputStream, ReducedDerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     public static ReducedDerivationControl parse(Reader param1Reader) throws XmlException, IOException {
/*  70 */       return (ReducedDerivationControl)XmlBeans.getContextTypeLoader().parse(param1Reader, ReducedDerivationControl.type, null);
/*     */     }
/*     */     public static ReducedDerivationControl parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/*  73 */       return (ReducedDerivationControl)XmlBeans.getContextTypeLoader().parse(param1Reader, ReducedDerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     public static ReducedDerivationControl parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/*  76 */       return (ReducedDerivationControl)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ReducedDerivationControl.type, null);
/*     */     }
/*     */     public static ReducedDerivationControl parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/*  79 */       return (ReducedDerivationControl)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, ReducedDerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     public static ReducedDerivationControl parse(Node param1Node) throws XmlException {
/*  82 */       return (ReducedDerivationControl)XmlBeans.getContextTypeLoader().parse(param1Node, ReducedDerivationControl.type, null);
/*     */     }
/*     */     public static ReducedDerivationControl parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/*  85 */       return (ReducedDerivationControl)XmlBeans.getContextTypeLoader().parse(param1Node, ReducedDerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static ReducedDerivationControl parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  89 */       return (ReducedDerivationControl)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ReducedDerivationControl.type, null);
/*     */     }
/*     */     
/*     */     public static ReducedDerivationControl parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/*  93 */       return (ReducedDerivationControl)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, ReducedDerivationControl.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/*  97 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ReducedDerivationControl.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 101 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, ReducedDerivationControl.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\ReducedDerivationControl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */