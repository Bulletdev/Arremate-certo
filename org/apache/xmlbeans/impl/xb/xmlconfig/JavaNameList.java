/*     */ package org.apache.xmlbeans.impl.xb.xmlconfig;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import java.util.List;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.StringEnumAbstractBase;
/*     */ import org.apache.xmlbeans.XmlAnySimpleType;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.XmlToken;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ 
/*     */ public interface JavaNameList
/*     */   extends XmlAnySimpleType
/*     */ {
/*     */   Object getObjectValue();
/*     */   
/*  27 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xmlconfig$JavaNameList == null) ? (null.class$org$apache$xmlbeans$impl$xb$xmlconfig$JavaNameList = null.class$("org.apache.xmlbeans.impl.xb.xmlconfig.JavaNameList")) : null.class$org$apache$xmlbeans$impl$xb$xmlconfig$JavaNameList).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("javanamelistbcfetype");
/*     */   
/*     */   void setObjectValue(Object paramObject);
/*     */   
/*     */   Object objectValue();
/*     */   
/*     */   void objectSet(Object paramObject);
/*     */   
/*     */   SchemaType instanceType();
/*     */   
/*  37 */   public static interface Member extends XmlToken { public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((JavaNameList.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$JavaNameList$Member == null) ? (JavaNameList.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$JavaNameList$Member = JavaNameList.null.class$("org.apache.xmlbeans.impl.xb.xmlconfig.JavaNameList$Member")) : JavaNameList.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$JavaNameList$Member).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("anon3e39type");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  43 */     public static final Enum X = Enum.forString("*");
/*     */ 
/*     */ 
/*     */     
/*     */     public static final int INT_X = 1;
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
/*     */       static final int INT_X = 1;
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
/*  80 */       public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("*", 1) });
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
/*     */       public static JavaNameList.Member newValue(Object param2Object) {
/* 100 */         return (JavaNameList.Member)JavaNameList.Member.type.newValue(param2Object);
/*     */       }
/*     */       public static JavaNameList.Member newInstance() {
/* 103 */         return (JavaNameList.Member)XmlBeans.getContextTypeLoader().newInstance(JavaNameList.Member.type, null);
/*     */       }
/*     */       public static JavaNameList.Member newInstance(XmlOptions param2XmlOptions) {
/* 106 */         return (JavaNameList.Member)XmlBeans.getContextTypeLoader().newInstance(JavaNameList.Member.type, param2XmlOptions);
/*     */       }
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Member2
/*     */     extends XmlAnySimpleType
/*     */   {
/*     */     List getListValue();
/*     */ 
/*     */ 
/*     */     
/*     */     List xgetListValue();
/*     */ 
/*     */ 
/*     */     
/*     */     void setListValue(List param1List);
/*     */ 
/*     */ 
/*     */     
/* 128 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((JavaNameList.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$JavaNameList$Member2 == null) ? (JavaNameList.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$JavaNameList$Member2 = JavaNameList.null.class$("org.apache.xmlbeans.impl.xb.xmlconfig.JavaNameList$Member2")) : JavaNameList.null.class$org$apache$xmlbeans$impl$xb$xmlconfig$JavaNameList$Member2).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("anon3a98type");
/*     */     
/*     */     List listValue();
/*     */     
/*     */     List xlistValue();
/*     */     
/*     */     void set(List param1List);
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static JavaNameList.Member2 newValue(Object param2Object) {
/* 139 */         return (JavaNameList.Member2)JavaNameList.Member2.type.newValue(param2Object);
/*     */       }
/*     */       public static JavaNameList.Member2 newInstance() {
/* 142 */         return (JavaNameList.Member2)XmlBeans.getContextTypeLoader().newInstance(JavaNameList.Member2.type, null);
/*     */       }
/*     */       public static JavaNameList.Member2 newInstance(XmlOptions param2XmlOptions) {
/* 145 */         return (JavaNameList.Member2)XmlBeans.getContextTypeLoader().newInstance(JavaNameList.Member2.type, param2XmlOptions);
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
/*     */     public static JavaNameList newValue(Object param1Object) {
/* 159 */       return (JavaNameList)JavaNameList.type.newValue(param1Object);
/*     */     }
/*     */     public static JavaNameList newInstance() {
/* 162 */       return (JavaNameList)XmlBeans.getContextTypeLoader().newInstance(JavaNameList.type, null);
/*     */     }
/*     */     public static JavaNameList newInstance(XmlOptions param1XmlOptions) {
/* 165 */       return (JavaNameList)XmlBeans.getContextTypeLoader().newInstance(JavaNameList.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static JavaNameList parse(String param1String) throws XmlException {
/* 169 */       return (JavaNameList)XmlBeans.getContextTypeLoader().parse(param1String, JavaNameList.type, null);
/*     */     }
/*     */     public static JavaNameList parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 172 */       return (JavaNameList)XmlBeans.getContextTypeLoader().parse(param1String, JavaNameList.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static JavaNameList parse(File param1File) throws XmlException, IOException {
/* 176 */       return (JavaNameList)XmlBeans.getContextTypeLoader().parse(param1File, JavaNameList.type, null);
/*     */     }
/*     */     public static JavaNameList parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 179 */       return (JavaNameList)XmlBeans.getContextTypeLoader().parse(param1File, JavaNameList.type, param1XmlOptions);
/*     */     }
/*     */     public static JavaNameList parse(URL param1URL) throws XmlException, IOException {
/* 182 */       return (JavaNameList)XmlBeans.getContextTypeLoader().parse(param1URL, JavaNameList.type, null);
/*     */     }
/*     */     public static JavaNameList parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 185 */       return (JavaNameList)XmlBeans.getContextTypeLoader().parse(param1URL, JavaNameList.type, param1XmlOptions);
/*     */     }
/*     */     public static JavaNameList parse(InputStream param1InputStream) throws XmlException, IOException {
/* 188 */       return (JavaNameList)XmlBeans.getContextTypeLoader().parse(param1InputStream, JavaNameList.type, null);
/*     */     }
/*     */     public static JavaNameList parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 191 */       return (JavaNameList)XmlBeans.getContextTypeLoader().parse(param1InputStream, JavaNameList.type, param1XmlOptions);
/*     */     }
/*     */     public static JavaNameList parse(Reader param1Reader) throws XmlException, IOException {
/* 194 */       return (JavaNameList)XmlBeans.getContextTypeLoader().parse(param1Reader, JavaNameList.type, null);
/*     */     }
/*     */     public static JavaNameList parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 197 */       return (JavaNameList)XmlBeans.getContextTypeLoader().parse(param1Reader, JavaNameList.type, param1XmlOptions);
/*     */     }
/*     */     public static JavaNameList parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 200 */       return (JavaNameList)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, JavaNameList.type, null);
/*     */     }
/*     */     public static JavaNameList parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 203 */       return (JavaNameList)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, JavaNameList.type, param1XmlOptions);
/*     */     }
/*     */     public static JavaNameList parse(Node param1Node) throws XmlException {
/* 206 */       return (JavaNameList)XmlBeans.getContextTypeLoader().parse(param1Node, JavaNameList.type, null);
/*     */     }
/*     */     public static JavaNameList parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 209 */       return (JavaNameList)XmlBeans.getContextTypeLoader().parse(param1Node, JavaNameList.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static JavaNameList parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 213 */       return (JavaNameList)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, JavaNameList.type, null);
/*     */     }
/*     */     
/*     */     public static JavaNameList parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 217 */       return (JavaNameList)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, JavaNameList.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 221 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, JavaNameList.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 225 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, JavaNameList.type, param1XmlOptions);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xmlconfig\JavaNameList.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */