/*     */ package org.apache.xmlbeans.impl.xb.xsdschema;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.StringEnumAbstractBase;
/*     */ import org.apache.xmlbeans.XmlAnySimpleType;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlNMTOKEN;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface AllNNI extends XmlAnySimpleType {
/*     */   Object getObjectValue();
/*     */   
/*     */   void setObjectValue(Object paramObject);
/*     */   
/*     */   Object objectValue();
/*     */   
/*  27 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$AllNNI == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$AllNNI = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.AllNNI")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$AllNNI).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("allnni78cbtype");
/*     */ 
/*     */   
/*     */   void objectSet(Object paramObject);
/*     */   
/*     */   SchemaType instanceType();
/*     */   
/*     */   public static interface Member
/*     */     extends XmlNMTOKEN
/*     */   {
/*  37 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((AllNNI.null.class$org$apache$xmlbeans$impl$xb$xsdschema$AllNNI$Member == null) ? (AllNNI.null.class$org$apache$xmlbeans$impl$xb$xsdschema$AllNNI$Member = AllNNI.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.AllNNI$Member")) : AllNNI.null.class$org$apache$xmlbeans$impl$xb$xsdschema$AllNNI$Member).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("anon0330type");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  43 */     public static final Enum UNBOUNDED = Enum.forString("unbounded");
/*     */ 
/*     */ 
/*     */     
/*     */     public static final int INT_UNBOUNDED = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     StringEnumAbstractBase enumValue();
/*     */ 
/*     */ 
/*     */     
/*     */     void set(StringEnumAbstractBase param1StringEnumAbstractBase);
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Enum
/*     */       extends StringEnumAbstractBase
/*     */     {
/*     */       static final int INT_UNBOUNDED = 1;
/*     */ 
/*     */ 
/*     */       
/*     */       public static Enum forString(String param2String) {
/*  68 */         return (Enum)table.forString(param2String);
/*     */       }
/*     */ 
/*     */       
/*     */       public static Enum forInt(int param2Int) {
/*  73 */         return (Enum)table.forInt(param2Int);
/*     */       }
/*     */       private Enum(String param2String, int param2Int) {
/*  76 */         super(param2String, param2Int);
/*     */       }
/*     */ 
/*     */       
/*  80 */       public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("unbounded", 1) });
/*     */ 
/*     */ 
/*     */       
/*     */       private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */       
/*     */       private Object readResolve() {
/*  89 */         return forInt(intValue());
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static AllNNI.Member newValue(Object param2Object) {
/* 100 */         return (AllNNI.Member)AllNNI.Member.type.newValue(param2Object);
/*     */       }
/*     */       public static AllNNI.Member newInstance() {
/* 103 */         return (AllNNI.Member)XmlBeans.getContextTypeLoader().newInstance(AllNNI.Member.type, null);
/*     */       }
/*     */       public static AllNNI.Member newInstance(XmlOptions param2XmlOptions) {
/* 106 */         return (AllNNI.Member)XmlBeans.getContextTypeLoader().newInstance(AllNNI.Member.type, param2XmlOptions);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static AllNNI newValue(Object param1Object) {
/* 120 */       return (AllNNI)AllNNI.type.newValue(param1Object);
/*     */     }
/*     */     public static AllNNI newInstance() {
/* 123 */       return (AllNNI)XmlBeans.getContextTypeLoader().newInstance(AllNNI.type, null);
/*     */     }
/*     */     public static AllNNI newInstance(XmlOptions param1XmlOptions) {
/* 126 */       return (AllNNI)XmlBeans.getContextTypeLoader().newInstance(AllNNI.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AllNNI parse(String param1String) throws XmlException {
/* 130 */       return (AllNNI)XmlBeans.getContextTypeLoader().parse(param1String, AllNNI.type, null);
/*     */     }
/*     */     public static AllNNI parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 133 */       return (AllNNI)XmlBeans.getContextTypeLoader().parse(param1String, AllNNI.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AllNNI parse(File param1File) throws XmlException, IOException {
/* 137 */       return (AllNNI)XmlBeans.getContextTypeLoader().parse(param1File, AllNNI.type, null);
/*     */     }
/*     */     public static AllNNI parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 140 */       return (AllNNI)XmlBeans.getContextTypeLoader().parse(param1File, AllNNI.type, param1XmlOptions);
/*     */     }
/*     */     public static AllNNI parse(URL param1URL) throws XmlException, IOException {
/* 143 */       return (AllNNI)XmlBeans.getContextTypeLoader().parse(param1URL, AllNNI.type, null);
/*     */     }
/*     */     public static AllNNI parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 146 */       return (AllNNI)XmlBeans.getContextTypeLoader().parse(param1URL, AllNNI.type, param1XmlOptions);
/*     */     }
/*     */     public static AllNNI parse(InputStream param1InputStream) throws XmlException, IOException {
/* 149 */       return (AllNNI)XmlBeans.getContextTypeLoader().parse(param1InputStream, AllNNI.type, null);
/*     */     }
/*     */     public static AllNNI parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 152 */       return (AllNNI)XmlBeans.getContextTypeLoader().parse(param1InputStream, AllNNI.type, param1XmlOptions);
/*     */     }
/*     */     public static AllNNI parse(Reader param1Reader) throws XmlException, IOException {
/* 155 */       return (AllNNI)XmlBeans.getContextTypeLoader().parse(param1Reader, AllNNI.type, null);
/*     */     }
/*     */     public static AllNNI parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 158 */       return (AllNNI)XmlBeans.getContextTypeLoader().parse(param1Reader, AllNNI.type, param1XmlOptions);
/*     */     }
/*     */     public static AllNNI parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 161 */       return (AllNNI)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, AllNNI.type, null);
/*     */     }
/*     */     public static AllNNI parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 164 */       return (AllNNI)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, AllNNI.type, param1XmlOptions);
/*     */     }
/*     */     public static AllNNI parse(Node param1Node) throws XmlException {
/* 167 */       return (AllNNI)XmlBeans.getContextTypeLoader().parse(param1Node, AllNNI.type, null);
/*     */     }
/*     */     public static AllNNI parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 170 */       return (AllNNI)XmlBeans.getContextTypeLoader().parse(param1Node, AllNNI.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static AllNNI parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 174 */       return (AllNNI)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, AllNNI.type, null);
/*     */     }
/*     */     
/*     */     public static AllNNI parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 178 */       return (AllNNI)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, AllNNI.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 182 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, AllNNI.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 186 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, AllNNI.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\AllNNI.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */