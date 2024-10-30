/*     */ package org.apache.xmlbeans.impl.xb.ltgfmt;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URL;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.StringEnumAbstractBase;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.XmlToken;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public interface FileDesc extends XmlObject {
/*  18 */   public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((null.class$org$apache$xmlbeans$impl$xb$ltgfmt$FileDesc == null) ? (null.class$org$apache$xmlbeans$impl$xb$ltgfmt$FileDesc = null.class$("org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc")) : null.class$org$apache$xmlbeans$impl$xb$ltgfmt$FileDesc).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("filedesc9392type");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Code getCode();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetCode();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setCode(Code paramCode);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Code addNewCode();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetCode();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getTsDir();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlToken xgetTsDir();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetTsDir();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setTsDir(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetTsDir(XmlToken paramXmlToken);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetTsDir();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getFolder();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlToken xgetFolder();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetFolder();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setFolder(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetFolder(XmlToken paramXmlToken);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetFolder();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getFileName();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlToken xgetFileName();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetFileName();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setFileName(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetFileName(XmlToken paramXmlToken);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetFileName();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Role.Enum getRole();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Role xgetRole();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetRole();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setRole(Role.Enum paramEnum);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetRole(Role paramRole);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetRole();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean getValidity();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XmlBoolean xgetValidity();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSetValidity();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setValidity(boolean paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void xsetValidity(XmlBoolean paramXmlBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unsetValidity();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Role
/*     */     extends XmlToken
/*     */   {
/* 203 */     public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(((FileDesc.null.class$org$apache$xmlbeans$impl$xb$ltgfmt$FileDesc$Role == null) ? (FileDesc.null.class$org$apache$xmlbeans$impl$xb$ltgfmt$FileDesc$Role = FileDesc.null.class$("org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc$Role")) : FileDesc.null.class$org$apache$xmlbeans$impl$xb$ltgfmt$FileDesc$Role).getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("role21a8attrtype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 209 */     public static final Enum SCHEMA = Enum.forString("schema");
/* 210 */     public static final Enum INSTANCE = Enum.forString("instance");
/* 211 */     public static final Enum RESOURCE = Enum.forString("resource");
/*     */ 
/*     */     
/*     */     public static final int INT_SCHEMA = 1;
/*     */     
/*     */     public static final int INT_INSTANCE = 2;
/*     */     
/*     */     public static final int INT_RESOURCE = 3;
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
/*     */       static final int INT_SCHEMA = 1;
/*     */       
/*     */       static final int INT_INSTANCE = 2;
/*     */       
/*     */       static final int INT_RESOURCE = 3;
/*     */ 
/*     */       
/*     */       public static Enum forString(String param2String) {
/* 238 */         return (Enum)table.forString(param2String);
/*     */       }
/*     */ 
/*     */       
/*     */       public static Enum forInt(int param2Int) {
/* 243 */         return (Enum)table.forInt(param2Int);
/*     */       }
/*     */       private Enum(String param2String, int param2Int) {
/* 246 */         super(param2String, param2Int);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 252 */       public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("schema", 1), new Enum("instance", 2), new Enum("resource", 3) });
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
/* 263 */         return forInt(intValue());
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final class Factory
/*     */     {
/*     */       public static FileDesc.Role newValue(Object param2Object) {
/* 274 */         return (FileDesc.Role)FileDesc.Role.type.newValue(param2Object);
/*     */       }
/*     */       public static FileDesc.Role newInstance() {
/* 277 */         return (FileDesc.Role)XmlBeans.getContextTypeLoader().newInstance(FileDesc.Role.type, null);
/*     */       }
/*     */       public static FileDesc.Role newInstance(XmlOptions param2XmlOptions) {
/* 280 */         return (FileDesc.Role)XmlBeans.getContextTypeLoader().newInstance(FileDesc.Role.type, param2XmlOptions);
/*     */       } }
/*     */   } public static final class Enum extends StringEnumAbstractBase { static final int INT_SCHEMA = 1; static final int INT_INSTANCE = 2; static final int INT_RESOURCE = 3; public static Enum forString(String param1String) {
/*     */       return (Enum)table.forString(param1String);
/*     */     } public static Enum forInt(int param1Int) {
/*     */       return (Enum)table.forInt(param1Int);
/*     */     } private Enum(String param1String, int param1Int) {
/*     */       super(param1String, param1Int);
/*     */     }
/*     */     public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("schema", 1), new Enum("instance", 2), new Enum("resource", 3) }); private static final long serialVersionUID = 1L;
/*     */     private Object readResolve() {
/*     */       return forInt(intValue());
/*     */     } }
/*     */   public static final class Factory { public static FileDesc newInstance() {
/* 294 */       return (FileDesc)XmlBeans.getContextTypeLoader().newInstance(FileDesc.type, null);
/*     */     }
/*     */     public static FileDesc newInstance(XmlOptions param1XmlOptions) {
/* 297 */       return (FileDesc)XmlBeans.getContextTypeLoader().newInstance(FileDesc.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static FileDesc parse(String param1String) throws XmlException {
/* 301 */       return (FileDesc)XmlBeans.getContextTypeLoader().parse(param1String, FileDesc.type, null);
/*     */     }
/*     */     public static FileDesc parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
/* 304 */       return (FileDesc)XmlBeans.getContextTypeLoader().parse(param1String, FileDesc.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static FileDesc parse(File param1File) throws XmlException, IOException {
/* 308 */       return (FileDesc)XmlBeans.getContextTypeLoader().parse(param1File, FileDesc.type, null);
/*     */     }
/*     */     public static FileDesc parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 311 */       return (FileDesc)XmlBeans.getContextTypeLoader().parse(param1File, FileDesc.type, param1XmlOptions);
/*     */     }
/*     */     public static FileDesc parse(URL param1URL) throws XmlException, IOException {
/* 314 */       return (FileDesc)XmlBeans.getContextTypeLoader().parse(param1URL, FileDesc.type, null);
/*     */     }
/*     */     public static FileDesc parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 317 */       return (FileDesc)XmlBeans.getContextTypeLoader().parse(param1URL, FileDesc.type, param1XmlOptions);
/*     */     }
/*     */     public static FileDesc parse(InputStream param1InputStream) throws XmlException, IOException {
/* 320 */       return (FileDesc)XmlBeans.getContextTypeLoader().parse(param1InputStream, FileDesc.type, null);
/*     */     }
/*     */     public static FileDesc parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 323 */       return (FileDesc)XmlBeans.getContextTypeLoader().parse(param1InputStream, FileDesc.type, param1XmlOptions);
/*     */     }
/*     */     public static FileDesc parse(Reader param1Reader) throws XmlException, IOException {
/* 326 */       return (FileDesc)XmlBeans.getContextTypeLoader().parse(param1Reader, FileDesc.type, null);
/*     */     }
/*     */     public static FileDesc parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
/* 329 */       return (FileDesc)XmlBeans.getContextTypeLoader().parse(param1Reader, FileDesc.type, param1XmlOptions);
/*     */     }
/*     */     public static FileDesc parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
/* 332 */       return (FileDesc)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, FileDesc.type, null);
/*     */     }
/*     */     public static FileDesc parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
/* 335 */       return (FileDesc)XmlBeans.getContextTypeLoader().parse(param1XMLStreamReader, FileDesc.type, param1XmlOptions);
/*     */     }
/*     */     public static FileDesc parse(Node param1Node) throws XmlException {
/* 338 */       return (FileDesc)XmlBeans.getContextTypeLoader().parse(param1Node, FileDesc.type, null);
/*     */     }
/*     */     public static FileDesc parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
/* 341 */       return (FileDesc)XmlBeans.getContextTypeLoader().parse(param1Node, FileDesc.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static FileDesc parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 345 */       return (FileDesc)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, FileDesc.type, null);
/*     */     }
/*     */     
/*     */     public static FileDesc parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 349 */       return (FileDesc)XmlBeans.getContextTypeLoader().parse(param1XMLInputStream, FileDesc.type, param1XmlOptions);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
/* 353 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, FileDesc.type, null);
/*     */     }
/*     */     
/*     */     public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
/* 357 */       return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(param1XMLInputStream, FileDesc.type, param1XmlOptions);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\ltgfmt\FileDesc.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */