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
/*     */ public interface Wildcard extends Annotated {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$xsdschema$Wildcard == null) ? (null.class$org$apache$xmlbeans$impl$xb$xsdschema$Wildcard = null.class$("org.apache.xmlbeans.impl.xb.xsdschema.Wildcard")) : null.class$org$apache$xmlbeans$impl$xb$xsdschema$Wildcard).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("wildcarde0b9type");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Object getNamespace();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NamespaceList xgetNamespace();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetNamespace();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setNamespace(Object paramObject);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetNamespace(NamespaceList paramNamespaceList);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetNamespace();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ProcessContents.Enum getProcessContents();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ProcessContents xgetProcessContents();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetProcessContents();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setProcessContents(ProcessContents.Enum paramEnum);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetProcessContents(ProcessContents paramProcessContents);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetProcessContents();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface ProcessContents
/*     */     extends XmlNMTOKEN
/*     */   {
/*  88 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((Wildcard.null.class$org$apache$xmlbeans$impl$xb$xsdschema$Wildcard$ProcessContents == null) ? (Wildcard.null.class$org$apache$xmlbeans$impl$xb$xsdschema$Wildcard$ProcessContents = Wildcard.null.class$("org.apache.xmlbeans.impl.xb.xsdschema.Wildcard$ProcessContents")) : Wildcard.null.class$org$apache$xmlbeans$impl$xb$xsdschema$Wildcard$ProcessContents).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("processcontents864aattrtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  94 */     public static final Enum SKIP = Enum.forString("skip");
/*  95 */     public static final Enum LAX = Enum.forString("lax");
/*  96 */     public static final Enum STRICT = Enum.forString("strict");
/*     */ 
/*     */     
/*     */     public static final int INT_SKIP = 1;
/*     */     
/*     */     public static final int INT_LAX = 2;
/*     */     
/*     */     public static final int INT_STRICT = 3;
/*     */ 
/*     */     
/*     */     StringEnumAbstractBase enumValue();
/*     */ 
/*     */     
/*     */     void set(StringEnumAbstractBase param1StringEnumAbstractBase);
/*     */ 
/*     */     
/*     */     public static final class Enum
/*     */       extends StringEnumAbstractBase
/*     */     {
/*     */       static final int INT_SKIP = 1;
/*     */       
/*     */       static final int INT_LAX = 2;
/*     */       
/*     */       static final int INT_STRICT = 3;
/*     */ 
/*     */       
/*     */       public static Enum forString(String param2String) {
/* 123 */         return (Enum)table.forString(param2String);
/*     */       }
/*     */ 
/*     */       
/*     */       public static Enum forInt(int param2Int) {
/* 128 */         return (Enum)table.forInt(param2Int);
/*     */       }
/*     */       private Enum(String param2String, int param2Int) {
/* 131 */         super(param2String, param2Int);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 137 */       public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("skip", 1), new Enum("lax", 2), new Enum("strict", 3) });
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private Object readResolve() {
/* 148 */         return forInt(intValue());
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static Wildcard.ProcessContents newValue(Object param2Object) {
/* 159 */         return (Wildcard.ProcessContents)Wildcard.ProcessContents.type.newValue(param2Object);
/*     */       }
/*     */       public static Wildcard.ProcessContents newInstance() {
/* 162 */         return (Wildcard.ProcessContents)XmlBeans.getContextTypeLoader().newInstance(Wildcard.ProcessContents.type, null);
/*     */       }
/*     */       public static Wildcard.ProcessContents newInstance(XmlOptions param2XmlOptions) {
/* 165 */         return (Wildcard.ProcessContents)XmlBeans.getContextTypeLoader().newInstance(Wildcard.ProcessContents.type, param2XmlOptions);
/*     */       } }
/*     */   } public static final class Enum extends StringEnumAbstractBase { static final int INT_SKIP = 1; static final int INT_LAX = 2; static final int INT_STRICT = 3; public static Enum forString(String param1String) {
/*     */       return (Enum)table.forString(param1String);
/*     */     } public static Enum forInt(int param1Int) {
/*     */       return (Enum)table.forInt(param1Int);
/*     */     } private Enum(String param1String, int param1Int) {
/*     */       super(param1String, param1Int);
/*     */     }
/*     */     public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("skip", 1), new Enum("lax", 2), new Enum("strict", 3) }); private static final long serialVersionUID = 1L;
/*     */     private Object readResolve() {
/*     */       return forInt(intValue());
/*     */     } }
/*     */   public static final class Factory { public static Wildcard newInstance() {
/* 179 */       return (Wildcard)XmlBeans.getContextTypeLoader().newInstance(Wildcard.type, null);
/*     */     }
/*     */     public static Wildcard newInstance(XmlOptions param1XmlOptions) {
/* 182 */       return (Wildcard)XmlBeans.getContextTypeLoader().newInstance(Wildcard.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Wildcard parse(String param1String) throws XmlException {
/* 186 */       return (Wildcard)XmlBeans.getContextTypeLoader().parse(param1String, Wildcard.type, null);
/*     */     }
/*     */     public static Wildcard parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 189 */       return (Wildcard)XmlBeans.getContextTypeLoader().parse(param1String, Wildcard.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Wildcard parse(File param1File) throws XmlException, IOException {
/* 193 */       return (Wildcard)XmlBeans.getContextTypeLoader().parse(param1File, Wildcard.type, null);
/*     */     }
/*     */     public static Wildcard parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 196 */       return (Wildcard)XmlBeans.getContextTypeLoader().parse(param1File, Wildcard.type, param1XmlOptions);
/*     */     }
/*     */     public static Wildcard parse(URL param1URL) throws XmlException, IOException {
/* 199 */       return (Wildcard)XmlBeans.getContextTypeLoader().parse(param1URL, Wildcard.type, null);
/*     */     }
/*     */     public static Wildcard parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 202 */       return (Wildcard)XmlBeans.getContextTypeLoader().parse(param1URL, Wildcard.type, param1XmlOptions);
/*     */     }
/*     */     public static Wildcard parse(InputStream param1InputStream) throws XmlException, IOException {
/* 205 */       return (Wildcard)XmlBeans.getContextTypeLoader().parse(param1InputStream, Wildcard.type, null);
/*     */     }
/*     */     public static Wildcard parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 208 */       return (Wildcard)XmlBeans.getContextTypeLoader().parse(param1InputStream, Wildcard.type, param1XmlOptions);
/*     */     }
/*     */     public static Wildcard parse(Reader param1Reader) throws XmlException, IOException {
/* 211 */       return (Wildcard)XmlBeans.getContextTypeLoader().parse(param1Reader, Wildcard.type, null);
/*     */     }
/*     */     public static Wildcard parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 214 */       return (Wildcard)XmlBeans.getContextTypeLoader().parse(param1Reader, Wildcard.type, param1XmlOptions);
/*     */     }
/*     */     public static Wildcard parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 217 */       return (Wildcard)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Wildcard.type, null);
/*     */     }
/*     */     public static Wildcard parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 220 */       return (Wildcard)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, Wildcard.type, param1XmlOptions);
/*     */     }
/*     */     public static Wildcard parse(Node param1Node) throws XmlException {
/* 223 */       return (Wildcard)XmlBeans.getContextTypeLoader().parse(param1Node, Wildcard.type, null);
/*     */     }
/*     */     public static Wildcard parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 226 */       return (Wildcard)XmlBeans.getContextTypeLoader().parse(param1Node, Wildcard.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static Wildcard parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 230 */       return (Wildcard)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Wildcard.type, null);
/*     */     }
/*     */     
/*     */     public static Wildcard parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 234 */       return (Wildcard)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, Wildcard.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 238 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Wildcard.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 242 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, Wildcard.type, param1XmlOptions);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\Wildcard.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */