/*     */ package org.apache.xmlbeans.impl.xb.xmlconfig;
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
/*     */ public interface Qnametargetenum extends XmlToken {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Qnametargetenum == null) ? (null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Qnametargetenum = null.class$("org.apache.xmlbeans.impl.xb.xmlconfig.Qnametargetenum")) : null.class$org$apache$xmlbeans$impl$xb$xmlconfig$Qnametargetenum).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("qnametargetenum9f8ftype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  24 */   public static final Enum TYPE = Enum.forString("type");
/*  25 */   public static final Enum DOCUMENT_TYPE = Enum.forString("document-type");
/*  26 */   public static final Enum ACCESSOR_ELEMENT = Enum.forString("accessor-element");
/*  27 */   public static final Enum ACCESSOR_ATTRIBUTE = Enum.forString("accessor-attribute");
/*     */   
/*     */   public static final int INT_TYPE = 1;
/*     */   
/*     */   public static final int INT_DOCUMENT_TYPE = 2;
/*     */   
/*     */   public static final int INT_ACCESSOR_ELEMENT = 3;
/*     */   
/*     */   public static final int INT_ACCESSOR_ATTRIBUTE = 4;
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
/*     */     static final int INT_TYPE = 1;
/*     */     
/*     */     static final int INT_DOCUMENT_TYPE = 2;
/*     */     
/*     */     static final int INT_ACCESSOR_ELEMENT = 3;
/*     */     static final int INT_ACCESSOR_ATTRIBUTE = 4;
/*     */     
/*     */     public static Enum forString(String param1String) {
/*  55 */       return (Enum)table.forString(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public static Enum forInt(int param1Int) {
/*  60 */       return (Enum)table.forInt(param1Int);
/*     */     }
/*     */     private Enum(String param1String, int param1Int) {
/*  63 */       super(param1String, param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  70 */     public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("type", 1), new Enum("document-type", 2), new Enum("accessor-element", 3), new Enum("accessor-attribute", 4) });
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
/*  82 */       return forInt(intValue());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static Qnametargetenum newValue(Object param1Object) {
/*  93 */       return (Qnametargetenum)Qnametargetenum.type.newValue(param1Object);
/*     */     }
/*     */     public static Qnametargetenum newInstance() {
/*  96 */       return (Qnametargetenum)XmlBeans.getContextTypeLoader().newInstance(Qnametargetenum.type, null);
/*     */     }
/*     */     public static Qnametargetenum newInstance(XmlOptions param1XmlOptions) {
/*  99 */       return (Qnametargetenum)XmlBeans.getContextTypeLoader().newInstance(Qnametargetenum.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Qnametargetenum parse(String param1String) throws XmlException {
/* 103 */       return (Qnametargetenum)XmlBeans.getContextTypeLoader().parse(param1String, Qnametargetenum.type, null);
/*     */     }
/*     */     public static Qnametargetenum parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 106 */       return (Qnametargetenum)XmlBeans.getContextTypeLoader().parse(param1String, Qnametargetenum.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Qnametargetenum parse(File param1File) throws XmlException, IOException {
/* 110 */       return (Qnametargetenum)XmlBeans.getContextTypeLoader().parse(param1File, Qnametargetenum.type, null);
/*     */     }
/*     */     public static Qnametargetenum parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 113 */       return (Qnametargetenum)XmlBeans.getContextTypeLoader().parse(param1File, Qnametargetenum.type, param1XmlOptions);
/*     */     }
/*     */     public static Qnametargetenum parse(URL param1URL) throws XmlException, IOException {
/* 116 */       return (Qnametargetenum)XmlBeans.getContextTypeLoader().parse(param1URL, Qnametargetenum.type, null);
/*     */     }
/*     */     public static Qnametargetenum parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 119 */       return (Qnametargetenum)XmlBeans.getContextTypeLoader().parse(param1URL, Qnametargetenum.type, param1XmlOptions);
/*     */     }
/*     */     public static Qnametargetenum parse(InputStream param1InputStream) throws XmlException, IOException {
/* 122 */       return (Qnametargetenum)XmlBeans.getContextTypeLoader().parse(param1InputStream, Qnametargetenum.type, null);
/*     */     }
/*     */     public static Qnametargetenum parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 125 */       return (Qnametargetenum)XmlBeans.getContextTypeLoader().parse(param1InputStream, Qnametargetenum.type, param1XmlOptions);
/*     */     }
/*     */     public static Qnametargetenum parse(Reader param1Reader) throws XmlException, IOException {
/* 128 */       return (Qnametargetenum)XmlBeans.getContextTypeLoader().parse(param1Reader, Qnametargetenum.type, null);
/*     */     }
/*     */     public static Qnametargetenum parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 131 */       return (Qnametargetenum)XmlBeans.getContextTypeLoader().parse(param1Reader, Qnametargetenum.type, param1XmlOptions);
/*     */     }
/*     */     public static Qnametargetenum parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 134 */       return (Qnametargetenum)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Qnametargetenum.type, null);
/*     */     }
/*     */     public static Qnametargetenum parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 137 */       return (Qnametargetenum)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Qnametargetenum.type, param1XmlOptions);
/*     */     }
/*     */     public static Qnametargetenum parse(Node param1Node) throws XmlException {
/* 140 */       return (Qnametargetenum)XmlBeans.getContextTypeLoader().parse(param1Node, Qnametargetenum.type, null);
/*     */     }
/*     */     public static Qnametargetenum parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 143 */       return (Qnametargetenum)XmlBeans.getContextTypeLoader().parse(param1Node, Qnametargetenum.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Qnametargetenum parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 147 */       return (Qnametargetenum)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Qnametargetenum.type, null);
/*     */     }
/*     */     
/*     */     public static Qnametargetenum parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 151 */       return (Qnametargetenum)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Qnametargetenum.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 155 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Qnametargetenum.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 159 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Qnametargetenum.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xmlconfig\Qnametargetenum.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */