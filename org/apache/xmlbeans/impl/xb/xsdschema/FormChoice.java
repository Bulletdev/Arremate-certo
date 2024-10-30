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
/*     */ public interface FormChoice extends XmlNMTOKEN {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$FormChoice == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$FormChoice = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.FormChoice")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$FormChoice).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("formchoicef2aetype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  24 */   public static final Enum QUALIFIED = Enum.forString("qualified");
/*  25 */   public static final Enum UNQUALIFIED = Enum.forString("unqualified");
/*     */ 
/*     */   
/*     */   public static final int INT_QUALIFIED = 1;
/*     */ 
/*     */   
/*     */   public static final int INT_UNQUALIFIED = 2;
/*     */ 
/*     */ 
/*     */   
/*     */   StringEnumAbstractBase enumValue();
/*     */ 
/*     */ 
/*     */   
/*     */   void set(StringEnumAbstractBase paramStringEnumAbstractBase);
/*     */ 
/*     */   
/*     */   public static final class Enum
/*     */     extends StringEnumAbstractBase
/*     */   {
/*     */     static final int INT_QUALIFIED = 1;
/*     */     
/*     */     static final int INT_UNQUALIFIED = 2;
/*     */ 
/*     */     
/*     */     public static Enum forString(String param1String) {
/*  51 */       return (Enum)table.forString(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public static Enum forInt(int param1Int) {
/*  56 */       return (Enum)table.forInt(param1Int);
/*     */     }
/*     */     private Enum(String param1String, int param1Int) {
/*  59 */       super(param1String, param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  64 */     public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("qualified", 1), new Enum("unqualified", 2) });
/*     */ 
/*     */ 
/*     */     
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Object readResolve() {
/*  74 */       return forInt(intValue());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static FormChoice newValue(Object param1Object) {
/*  85 */       return (FormChoice)FormChoice.type.newValue(param1Object);
/*     */     }
/*     */     public static FormChoice newInstance() {
/*  88 */       return (FormChoice)XmlBeans.getContextTypeLoader().newInstance(FormChoice.type, null);
/*     */     }
/*     */     public static FormChoice newInstance(XmlOptions param1XmlOptions) {
/*  91 */       return (FormChoice)XmlBeans.getContextTypeLoader().newInstance(FormChoice.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static FormChoice parse(String param1String) throws XmlException {
/*  95 */       return (FormChoice)XmlBeans.getContextTypeLoader().parse(param1String, FormChoice.type, null);
/*     */     }
/*     */     public static FormChoice parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/*  98 */       return (FormChoice)XmlBeans.getContextTypeLoader().parse(param1String, FormChoice.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static FormChoice parse(File param1File) throws XmlException, IOException {
/* 102 */       return (FormChoice)XmlBeans.getContextTypeLoader().parse(param1File, FormChoice.type, null);
/*     */     }
/*     */     public static FormChoice parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 105 */       return (FormChoice)XmlBeans.getContextTypeLoader().parse(param1File, FormChoice.type, param1XmlOptions);
/*     */     }
/*     */     public static FormChoice parse(URL param1URL) throws XmlException, IOException {
/* 108 */       return (FormChoice)XmlBeans.getContextTypeLoader().parse(param1URL, FormChoice.type, null);
/*     */     }
/*     */     public static FormChoice parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 111 */       return (FormChoice)XmlBeans.getContextTypeLoader().parse(param1URL, FormChoice.type, param1XmlOptions);
/*     */     }
/*     */     public static FormChoice parse(InputStream param1InputStream) throws XmlException, IOException {
/* 114 */       return (FormChoice)XmlBeans.getContextTypeLoader().parse(param1InputStream, FormChoice.type, null);
/*     */     }
/*     */     public static FormChoice parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 117 */       return (FormChoice)XmlBeans.getContextTypeLoader().parse(param1InputStream, FormChoice.type, param1XmlOptions);
/*     */     }
/*     */     public static FormChoice parse(Reader param1Reader) throws XmlException, IOException {
/* 120 */       return (FormChoice)XmlBeans.getContextTypeLoader().parse(param1Reader, FormChoice.type, null);
/*     */     }
/*     */     public static FormChoice parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 123 */       return (FormChoice)XmlBeans.getContextTypeLoader().parse(param1Reader, FormChoice.type, param1XmlOptions);
/*     */     }
/*     */     public static FormChoice parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 126 */       return (FormChoice)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, FormChoice.type, null);
/*     */     }
/*     */     public static FormChoice parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 129 */       return (FormChoice)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, FormChoice.type, param1XmlOptions);
/*     */     }
/*     */     public static FormChoice parse(Node param1Node) throws XmlException {
/* 132 */       return (FormChoice)XmlBeans.getContextTypeLoader().parse(param1Node, FormChoice.type, null);
/*     */     }
/*     */     public static FormChoice parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 135 */       return (FormChoice)XmlBeans.getContextTypeLoader().parse(param1Node, FormChoice.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static FormChoice parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 139 */       return (FormChoice)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, FormChoice.type, null);
/*     */     }
/*     */     
/*     */     public static FormChoice parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 143 */       return (FormChoice)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, FormChoice.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 147 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, FormChoice.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 151 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, FormChoice.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\FormChoice.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */