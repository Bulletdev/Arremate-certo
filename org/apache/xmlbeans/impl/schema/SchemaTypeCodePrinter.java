/*      */ package org.apache.xmlbeans.impl.schema;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.Writer;
/*      */ import java.nio.charset.CharacterCodingException;
/*      */ import java.nio.charset.Charset;
/*      */ import java.nio.charset.CharsetEncoder;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.Map;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.xmlbeans.InterfaceExtension;
/*      */ import org.apache.xmlbeans.PrePostExtension;
/*      */ import org.apache.xmlbeans.SchemaCodePrinter;
/*      */ import org.apache.xmlbeans.SchemaProperty;
/*      */ import org.apache.xmlbeans.SchemaStringEnumEntry;
/*      */ import org.apache.xmlbeans.SchemaType;
/*      */ import org.apache.xmlbeans.SchemaTypeSystem;
/*      */ import org.apache.xmlbeans.SystemProperties;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.XmlOptions;
/*      */ import org.apache.xmlbeans.impl.common.NameUtil;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class SchemaTypeCodePrinter
/*      */   implements SchemaCodePrinter
/*      */ {
/*      */   Writer _writer;
/*      */   int _indent;
/*      */   boolean _useJava15;
/*   53 */   static final String LINE_SEPARATOR = (SystemProperties.getProperty("line.separator") == null) ? "\n" : SystemProperties.getProperty("line.separator");
/*      */   
/*      */   static final String MAX_SPACES = "                                        ";
/*      */   
/*      */   static final int INDENT_INCREMENT = 4;
/*      */   
/*      */   public static final String INDEX_CLASSNAME = "TypeSystemHolder";
/*      */   
/*      */   private static final int NOTHING = 1;
/*      */   private static final int ADD_NEW_VALUE = 3;
/*      */   private static final int THROW_EXCEPTION = 4;
/*      */   static final boolean $assertionsDisabled;
/*      */   
/*      */   public static void printTypeImpl(Writer paramWriter, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws IOException {
/*   67 */     getPrinter(paramXmlOptions).printTypeImpl(paramWriter, paramSchemaType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void printType(Writer paramWriter, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws IOException {
/*   74 */     getPrinter(paramXmlOptions).printType(paramWriter, paramSchemaType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void printLoader(Writer paramWriter, SchemaTypeSystem paramSchemaTypeSystem, XmlOptions paramXmlOptions) throws IOException {
/*   82 */     getPrinter(paramXmlOptions).printLoader(paramWriter, paramSchemaTypeSystem);
/*      */   }
/*      */ 
/*      */   
/*      */   private static SchemaCodePrinter getPrinter(XmlOptions paramXmlOptions) {
/*   87 */     Object object = XmlOptions.safeGet(paramXmlOptions, "SCHEMA_CODE_PRINTER");
/*      */     
/*   89 */     if (object == null || !(object instanceof SchemaCodePrinter))
/*      */     {
/*   91 */       object = new SchemaTypeCodePrinter(paramXmlOptions);
/*      */     }
/*   93 */     return (SchemaCodePrinter)object;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaTypeCodePrinter(XmlOptions paramXmlOptions) {
/*   98 */     this._indent = 0;
/*      */     
/*  100 */     String str = null;
/*      */     
/*  102 */     if (paramXmlOptions != null && XmlOptions.hasOption(paramXmlOptions, "GENERATE_JAVA_VERSION")) {
/*  103 */       str = (String)paramXmlOptions.get("GENERATE_JAVA_VERSION");
/*      */     }
/*  105 */     if (str == null) {
/*  106 */       str = "1.4";
/*      */     }
/*  108 */     this._useJava15 = "1.5".equals(str);
/*      */   }
/*      */ 
/*      */   
/*      */   void indent() {
/*  113 */     this._indent += 4;
/*      */   }
/*      */ 
/*      */   
/*      */   void outdent() {
/*  118 */     this._indent -= 4;
/*      */   }
/*      */ 
/*      */   
/*      */   String encodeString(String paramString) {
/*  123 */     StringBuffer stringBuffer = new StringBuffer();
/*      */     
/*  125 */     stringBuffer.append('"');
/*      */     
/*  127 */     for (byte b = 0; b < paramString.length(); b++) {
/*      */       
/*  129 */       char c = paramString.charAt(b);
/*      */       
/*  131 */       if (c == '"') {
/*      */         
/*  133 */         stringBuffer.append('\\');
/*  134 */         stringBuffer.append('"');
/*      */       }
/*  136 */       else if (c == '\\') {
/*      */         
/*  138 */         stringBuffer.append('\\');
/*  139 */         stringBuffer.append('\\');
/*      */       }
/*  141 */       else if (c == '\r') {
/*      */         
/*  143 */         stringBuffer.append('\\');
/*  144 */         stringBuffer.append('r');
/*      */       }
/*  146 */       else if (c == '\n') {
/*      */         
/*  148 */         stringBuffer.append('\\');
/*  149 */         stringBuffer.append('n');
/*      */       }
/*  151 */       else if (c == '\t') {
/*      */         
/*  153 */         stringBuffer.append('\\');
/*  154 */         stringBuffer.append('t');
/*      */       } else {
/*      */         
/*  157 */         stringBuffer.append(c);
/*      */       } 
/*      */     } 
/*  160 */     stringBuffer.append('"');
/*      */     
/*  162 */     return stringBuffer.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   void emit(String paramString) throws IOException {
/*  167 */     int i = this._indent;
/*      */     
/*  169 */     if (i > "                                        ".length() / 2) {
/*  170 */       i = "                                        ".length() / 4 + i / 2;
/*      */     }
/*  172 */     if (i > "                                        ".length()) {
/*  173 */       i = "                                        ".length();
/*      */     }
/*  175 */     this._writer.write("                                        ".substring(0, i));
/*      */     
/*      */     try {
/*  178 */       this._writer.write(paramString);
/*      */     }
/*  180 */     catch (CharacterCodingException characterCodingException) {
/*      */       
/*  182 */       this._writer.write(makeSafe(paramString));
/*      */     } 
/*  184 */     this._writer.write(LINE_SEPARATOR);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String makeSafe(String paramString) {
/*  192 */     Charset charset = Charset.forName(System.getProperty("file.encoding"));
/*  193 */     if (charset == null)
/*  194 */       throw new IllegalStateException("Default character set is null!"); 
/*  195 */     CharsetEncoder charsetEncoder = charset.newEncoder();
/*  196 */     StringBuffer stringBuffer = new StringBuffer();
/*      */     byte b;
/*  198 */     for (b = 0; b < paramString.length(); b++) {
/*      */       
/*  200 */       char c = paramString.charAt(b);
/*  201 */       if (!charsetEncoder.canEncode(c))
/*      */         break; 
/*      */     } 
/*  204 */     for (; b < paramString.length(); b++) {
/*      */       
/*  206 */       char c = paramString.charAt(b);
/*  207 */       if (charsetEncoder.canEncode(c)) {
/*  208 */         stringBuffer.append(c);
/*      */       } else {
/*      */         
/*  211 */         String str = Integer.toHexString(c);
/*  212 */         switch (str.length()) {
/*      */           
/*      */           case 1:
/*  215 */             stringBuffer.append("\\u000").append(str); break;
/*      */           case 2:
/*  217 */             stringBuffer.append("\\u00").append(str); break;
/*      */           case 3:
/*  219 */             stringBuffer.append("\\u0").append(str); break;
/*      */           case 4:
/*  221 */             stringBuffer.append("\\u").append(str); break;
/*      */           default:
/*  223 */             throw new IllegalStateException();
/*      */         } 
/*      */       } 
/*      */     } 
/*  227 */     return stringBuffer.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   public void printType(Writer paramWriter, SchemaType paramSchemaType) throws IOException {
/*  232 */     this._writer = paramWriter;
/*  233 */     printTopComment(paramSchemaType);
/*  234 */     printPackage(paramSchemaType, true);
/*  235 */     emit("");
/*  236 */     printInnerType(paramSchemaType, paramSchemaType.getTypeSystem());
/*  237 */     this._writer.flush();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void printTypeImpl(Writer paramWriter, SchemaType paramSchemaType) throws IOException {
/*  243 */     this._writer = paramWriter;
/*  244 */     printTopComment(paramSchemaType);
/*  245 */     printPackage(paramSchemaType, false);
/*  246 */     printInnerTypeImpl(paramSchemaType, paramSchemaType.getTypeSystem(), false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   String findJavaType(SchemaType paramSchemaType) {
/*  255 */     while (paramSchemaType.getFullJavaName() == null) {
/*  256 */       paramSchemaType = paramSchemaType.getBaseType();
/*      */     }
/*  258 */     return paramSchemaType.getFullJavaName();
/*      */   }
/*      */ 
/*      */   
/*      */   static String prettyQName(b paramb) {
/*  263 */     String str = paramb.dT();
/*  264 */     if (paramb.getNamespaceURI() != null)
/*  265 */       str = str + "(@" + paramb.getNamespaceURI() + ")"; 
/*  266 */     return str;
/*      */   }
/*      */   void printInnerTypeJavaDoc(SchemaType paramSchemaType) throws IOException {
/*      */     SchemaType[] arrayOfSchemaType;
/*      */     byte b1;
/*  271 */     b b = paramSchemaType.getName();
/*  272 */     if (b == null)
/*      */     {
/*  274 */       if (paramSchemaType.isDocumentType()) {
/*  275 */         b = paramSchemaType.getDocumentElementName();
/*  276 */       } else if (paramSchemaType.isAttributeType()) {
/*  277 */         b = paramSchemaType.getAttributeTypeAttributeName();
/*  278 */       } else if (paramSchemaType.getContainerField() != null) {
/*  279 */         b = paramSchemaType.getContainerField().getName();
/*      */       } 
/*      */     }
/*  282 */     emit("/**");
/*  283 */     if (paramSchemaType.isDocumentType()) {
/*  284 */       emit(" * A document containing one " + prettyQName(b) + " element.");
/*  285 */     } else if (paramSchemaType.isAttributeType()) {
/*  286 */       emit(" * A document containing one " + prettyQName(b) + " attribute.");
/*  287 */     } else if (b != null) {
/*  288 */       emit(" * An XML " + prettyQName(b) + ".");
/*      */     } else {
/*  290 */       emit(" * An anonymous inner XML type.");
/*  291 */     }  emit(" *");
/*  292 */     switch (paramSchemaType.getSimpleVariety()) {
/*      */       
/*      */       case 0:
/*  295 */         emit(" * This is a complex type.");
/*      */         break;
/*      */       case 1:
/*  298 */         emit(" * This is an atomic type that is a restriction of " + getFullJavaName(paramSchemaType) + ".");
/*      */         break;
/*      */       case 3:
/*  301 */         emit(" * This is a list type whose items are " + paramSchemaType.getListItemType().getFullJavaName() + ".");
/*      */         break;
/*      */       case 2:
/*  304 */         emit(" * This is a union type. Instances are of one of the following types:");
/*  305 */         arrayOfSchemaType = paramSchemaType.getUnionConstituentTypes();
/*  306 */         for (b1 = 0; b1 < arrayOfSchemaType.length; b1++)
/*  307 */           emit(" *     " + arrayOfSchemaType[b1].getFullJavaName()); 
/*      */         break;
/*      */     } 
/*  310 */     emit(" */");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private String getFullJavaName(SchemaType paramSchemaType) {
/*  316 */     SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl)paramSchemaType;
/*  317 */     String str = schemaTypeImpl.getFullJavaName();
/*      */     
/*  319 */     while (schemaTypeImpl.isRedefinition()) {
/*      */       
/*  321 */       str = schemaTypeImpl.getFullJavaName();
/*  322 */       schemaTypeImpl = (SchemaTypeImpl)schemaTypeImpl.getBaseType();
/*      */     } 
/*  324 */     return str;
/*      */   }
/*      */ 
/*      */   
/*      */   private String getUserTypeStaticHandlerMethod(boolean paramBoolean, SchemaTypeImpl paramSchemaTypeImpl) {
/*  329 */     String str = paramSchemaTypeImpl.getName().dT();
/*  330 */     if (str.length() < 2) {
/*  331 */       str = str.toUpperCase();
/*      */     } else {
/*  333 */       str = str.substring(0, 1).toUpperCase() + str.substring(1);
/*      */     } 
/*  335 */     if (paramBoolean) {
/*  336 */       return paramSchemaTypeImpl.getUserTypeHandlerName() + ".encode" + str;
/*      */     }
/*  338 */     return paramSchemaTypeImpl.getUserTypeHandlerName() + ".decode" + str;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String indexClassForSystem(SchemaTypeSystem paramSchemaTypeSystem) {
/*  344 */     String str = paramSchemaTypeSystem.getName();
/*  345 */     return str + "." + "TypeSystemHolder";
/*      */   }
/*      */ 
/*      */   
/*      */   static String shortIndexClassForSystem(SchemaTypeSystem paramSchemaTypeSystem) {
/*  350 */     return "TypeSystemHolder";
/*      */   }
/*      */ 
/*      */   
/*      */   void printStaticTypeDeclaration(SchemaType paramSchemaType, SchemaTypeSystem paramSchemaTypeSystem) throws IOException {
/*  355 */     String str = paramSchemaType.getShortJavaName();
/*  356 */     emit("public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)");
/*  357 */     indent();
/*  358 */     emit("org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(" + str + ".class.getClassLoader(), \"" + paramSchemaTypeSystem.getName() + "\")" + ".resolveHandle(\"" + ((SchemaTypeSystemImpl)paramSchemaTypeSystem).handleForType(paramSchemaType) + "\");");
/*      */ 
/*      */ 
/*      */     
/*  362 */     outdent();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void printLoader(Writer paramWriter, SchemaTypeSystem paramSchemaTypeSystem) throws IOException {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void printInnerType(SchemaType paramSchemaType, SchemaTypeSystem paramSchemaTypeSystem) throws IOException {
/*  374 */     emit("");
/*      */     
/*  376 */     printInnerTypeJavaDoc(paramSchemaType);
/*      */     
/*  378 */     startInterface(paramSchemaType);
/*      */     
/*  380 */     printStaticTypeDeclaration(paramSchemaType, paramSchemaTypeSystem);
/*      */     
/*  382 */     if (paramSchemaType.isSimpleType()) {
/*      */       
/*  384 */       if (paramSchemaType.hasStringEnumValues()) {
/*  385 */         printStringEnumeration(paramSchemaType);
/*      */       }
/*      */     } else {
/*      */       
/*  389 */       if (paramSchemaType.getContentType() == 2 && paramSchemaType.hasStringEnumValues()) {
/*  390 */         printStringEnumeration(paramSchemaType);
/*      */       }
/*  392 */       SchemaProperty[] arrayOfSchemaProperty = getDerivedProperties(paramSchemaType);
/*      */       
/*  394 */       for (byte b = 0; b < arrayOfSchemaProperty.length; b++) {
/*      */         
/*  396 */         SchemaProperty schemaProperty = arrayOfSchemaProperty[b];
/*      */         
/*  398 */         printPropertyGetters(schemaProperty.getName(), schemaProperty.isAttribute(), schemaProperty.getJavaPropertyName(), schemaProperty.getJavaTypeCode(), javaTypeForProperty(schemaProperty), xmlTypeForProperty(schemaProperty), (schemaProperty.hasNillable() != 0), schemaProperty.extendsJavaOption(), schemaProperty.extendsJavaArray(), schemaProperty.extendsJavaSingleton());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  411 */         if (!schemaProperty.isReadOnly())
/*      */         {
/*  413 */           printPropertySetters(schemaProperty.getName(), schemaProperty.isAttribute(), schemaProperty.getJavaPropertyName(), schemaProperty.getJavaTypeCode(), javaTypeForProperty(schemaProperty), xmlTypeForProperty(schemaProperty), (schemaProperty.hasNillable() != 0), schemaProperty.extendsJavaOption(), schemaProperty.extendsJavaArray(), schemaProperty.extendsJavaSingleton());
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  430 */     printNestedInnerTypes(paramSchemaType, paramSchemaTypeSystem);
/*      */     
/*  432 */     printFactory(paramSchemaType);
/*      */     
/*  434 */     endBlock();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void printFactory(SchemaType paramSchemaType) throws IOException {
/*  440 */     boolean bool = true;
/*  441 */     if (paramSchemaType.isAnonymousType() && !paramSchemaType.isDocumentType() && !paramSchemaType.isAttributeType()) {
/*  442 */       bool = false;
/*      */     }
/*  444 */     String str = paramSchemaType.getFullJavaName().replace('$', '.');
/*      */     
/*  446 */     emit("");
/*  447 */     emit("/**");
/*  448 */     emit(" * A factory class with static methods for creating instances");
/*  449 */     emit(" * of this type.");
/*  450 */     emit(" */");
/*  451 */     emit("");
/*      */ 
/*      */     
/*  454 */     emit("public static final class Factory");
/*  455 */     emit("{");
/*  456 */     indent();
/*      */     
/*  458 */     if (paramSchemaType.isSimpleType()) {
/*      */       
/*  460 */       emit("public static " + str + " newValue(java.lang.Object obj) {");
/*  461 */       emit("  return (" + str + ") type.newValue( obj ); }");
/*  462 */       emit("");
/*      */     } 
/*      */ 
/*      */     
/*  466 */     if (paramSchemaType.isAbstract()) {
/*  467 */       emit("/** @deprecated No need to be able to create instances of abstract types */");
/*  468 */       if (this._useJava15)
/*  469 */         emit("@Deprecated"); 
/*      */     } 
/*  471 */     emit("public static " + str + " newInstance() {");
/*  472 */     emit("  return (" + str + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }");
/*  473 */     emit("");
/*      */ 
/*      */     
/*  476 */     if (paramSchemaType.isAbstract()) {
/*  477 */       emit("/** @deprecated No need to be able to create instances of abstract types */");
/*  478 */       if (this._useJava15)
/*  479 */         emit("@Deprecated"); 
/*      */     } 
/*  481 */     emit("public static " + str + " newInstance(org.apache.xmlbeans.XmlOptions options) {");
/*  482 */     emit("  return (" + str + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }");
/*  483 */     emit("");
/*      */     
/*  485 */     if (bool) {
/*      */       
/*  487 */       emit("/** @param xmlAsString the string value to parse */");
/*  488 */       emit("public static " + str + " parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {");
/*  489 */       emit("  return (" + str + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }");
/*  490 */       emit("");
/*      */       
/*  492 */       emit("public static " + str + " parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {");
/*  493 */       emit("  return (" + str + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }");
/*  494 */       emit("");
/*      */       
/*  496 */       emit("/** @param file the file from which to load an xml document */");
/*  497 */       emit("public static " + str + " parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {");
/*  498 */       emit("  return (" + str + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }");
/*  499 */       emit("");
/*      */       
/*  501 */       emit("public static " + str + " parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {");
/*  502 */       emit("  return (" + str + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }");
/*  503 */       emit("");
/*      */       
/*  505 */       emit("public static " + str + " parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {");
/*  506 */       emit("  return (" + str + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }");
/*  507 */       emit("");
/*      */       
/*  509 */       emit("public static " + str + " parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {");
/*  510 */       emit("  return (" + str + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }");
/*  511 */       emit("");
/*      */       
/*  513 */       emit("public static " + str + " parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {");
/*  514 */       emit("  return (" + str + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }");
/*  515 */       emit("");
/*      */       
/*  517 */       emit("public static " + str + " parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {");
/*  518 */       emit("  return (" + str + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }");
/*  519 */       emit("");
/*      */       
/*  521 */       emit("public static " + str + " parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {");
/*  522 */       emit("  return (" + str + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }");
/*  523 */       emit("");
/*      */       
/*  525 */       emit("public static " + str + " parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {");
/*  526 */       emit("  return (" + str + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }");
/*  527 */       emit("");
/*      */       
/*  529 */       emit("public static " + str + " parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {");
/*  530 */       emit("  return (" + str + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }");
/*  531 */       emit("");
/*      */       
/*  533 */       emit("public static " + str + " parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {");
/*  534 */       emit("  return (" + str + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }");
/*  535 */       emit("");
/*      */       
/*  537 */       emit("public static " + str + " parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {");
/*  538 */       emit("  return (" + str + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }");
/*  539 */       emit("");
/*      */       
/*  541 */       emit("public static " + str + " parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {");
/*  542 */       emit("  return (" + str + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }");
/*  543 */       emit("");
/*      */       
/*  545 */       emit("/** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */");
/*  546 */       if (this._useJava15)
/*  547 */         emit("@Deprecated"); 
/*  548 */       emit("public static " + str + " parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {");
/*  549 */       emit("  return (" + str + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }");
/*  550 */       emit("");
/*      */       
/*  552 */       emit("/** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */");
/*  553 */       if (this._useJava15)
/*  554 */         emit("@Deprecated"); 
/*  555 */       emit("public static " + str + " parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {");
/*  556 */       emit("  return (" + str + ") org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }");
/*  557 */       emit("");
/*      */ 
/*      */       
/*  560 */       emit("/** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */");
/*  561 */       if (this._useJava15)
/*  562 */         emit("@Deprecated"); 
/*  563 */       emit("public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {");
/*  564 */       emit("  return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }");
/*  565 */       emit("");
/*      */ 
/*      */       
/*  568 */       emit("/** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */");
/*  569 */       if (this._useJava15)
/*  570 */         emit("@Deprecated"); 
/*  571 */       emit("public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {");
/*  572 */       emit("  return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }");
/*  573 */       emit("");
/*      */     } 
/*      */     
/*  576 */     emit("private Factory() { } // No instance of this class allowed");
/*  577 */     outdent();
/*  578 */     emit("}");
/*      */   }
/*      */ 
/*      */   
/*      */   void printNestedInnerTypes(SchemaType paramSchemaType, SchemaTypeSystem paramSchemaTypeSystem) throws IOException {
/*  583 */     boolean bool = (paramSchemaType.getName() != null && paramSchemaType.getName().equals(paramSchemaType.getBaseType().getName())) ? true : false;
/*      */     
/*  585 */     while (paramSchemaType != null) {
/*      */       
/*  587 */       SchemaType[] arrayOfSchemaType = paramSchemaType.getAnonymousTypes();
/*  588 */       for (byte b = 0; b < arrayOfSchemaType.length; b++) {
/*      */         
/*  590 */         if (arrayOfSchemaType[b].isSkippedAnonymousType()) {
/*  591 */           printNestedInnerTypes(arrayOfSchemaType[b], paramSchemaTypeSystem);
/*      */         } else {
/*  593 */           printInnerType(arrayOfSchemaType[b], paramSchemaTypeSystem);
/*      */         } 
/*      */       } 
/*      */       
/*  597 */       if (!bool || (paramSchemaType.getDerivationType() != 2 && !paramSchemaType.isSimpleType())) {
/*      */         break;
/*      */       }
/*  600 */       paramSchemaType = paramSchemaType.getBaseType();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   void printTopComment(SchemaType paramSchemaType) throws IOException {
/*  606 */     emit("/*");
/*  607 */     if (paramSchemaType.getName() != null) {
/*      */       
/*  609 */       emit(" * XML Type:  " + paramSchemaType.getName().dT());
/*  610 */       emit(" * Namespace: " + paramSchemaType.getName().getNamespaceURI());
/*      */     }
/*      */     else {
/*      */       
/*  614 */       b b = null;
/*      */       
/*  616 */       if (paramSchemaType.isDocumentType()) {
/*      */         
/*  618 */         b = paramSchemaType.getDocumentElementName();
/*  619 */         emit(" * An XML document type.");
/*      */       }
/*  621 */       else if (paramSchemaType.isAttributeType()) {
/*      */         
/*  623 */         b = paramSchemaType.getAttributeTypeAttributeName();
/*  624 */         emit(" * An XML attribute type.");
/*      */       } else {
/*      */         assert false;
/*      */       } 
/*      */       
/*  629 */       assert b != null;
/*      */       
/*  631 */       emit(" * Localname: " + b.dT());
/*  632 */       emit(" * Namespace: " + b.getNamespaceURI());
/*      */     } 
/*  634 */     emit(" * Java type: " + paramSchemaType.getFullJavaName());
/*  635 */     emit(" *");
/*  636 */     emit(" * Automatically generated - do not modify.");
/*  637 */     emit(" */");
/*      */   }
/*      */ 
/*      */   
/*      */   void printPackage(SchemaType paramSchemaType, boolean paramBoolean) throws IOException {
/*      */     String str1;
/*  643 */     if (paramBoolean) {
/*  644 */       str1 = paramSchemaType.getFullJavaName();
/*      */     } else {
/*  646 */       str1 = paramSchemaType.getFullJavaImplName();
/*      */     } 
/*  648 */     int i = str1.lastIndexOf('.');
/*  649 */     if (i < 0)
/*      */       return; 
/*  651 */     String str2 = str1.substring(0, i);
/*  652 */     emit("package " + str2 + ";");
/*      */   }
/*      */ 
/*      */   
/*      */   void startInterface(SchemaType paramSchemaType) throws IOException {
/*  657 */     String str1 = paramSchemaType.getShortJavaName();
/*      */     
/*  659 */     String str2 = findJavaType(paramSchemaType.getBaseType());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  687 */     emit("public interface " + str1 + " extends " + str2 + getExtensionInterfaces(paramSchemaType));
/*  688 */     emit("{");
/*  689 */     indent();
/*  690 */     emitSpecializedAccessors(paramSchemaType);
/*      */   }
/*      */ 
/*      */   
/*      */   private static String getExtensionInterfaces(SchemaType paramSchemaType) {
/*  695 */     SchemaTypeImpl schemaTypeImpl = getImpl(paramSchemaType);
/*  696 */     if (schemaTypeImpl == null) {
/*  697 */       return "";
/*      */     }
/*  699 */     StringBuffer stringBuffer = new StringBuffer();
/*      */     
/*  701 */     InterfaceExtension[] arrayOfInterfaceExtension = schemaTypeImpl.getInterfaceExtensions();
/*  702 */     if (arrayOfInterfaceExtension != null) for (byte b = 0; b < arrayOfInterfaceExtension.length; b++) {
/*  703 */         stringBuffer.append(", " + arrayOfInterfaceExtension[b].getInterface());
/*      */       } 
/*  705 */     return stringBuffer.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   private static SchemaTypeImpl getImpl(SchemaType paramSchemaType) {
/*  710 */     if (paramSchemaType instanceof SchemaTypeImpl) {
/*  711 */       return (SchemaTypeImpl)paramSchemaType;
/*      */     }
/*  713 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private void emitSpecializedAccessors(SchemaType paramSchemaType) throws IOException {
/*  718 */     if (paramSchemaType.getSimpleVariety() == 1 && paramSchemaType.getPrimitiveType().getBuiltinTypeCode() == 11) {
/*      */ 
/*      */       
/*  721 */       int i = paramSchemaType.getDecimalSize();
/*  722 */       int j = paramSchemaType.getBaseType().getDecimalSize();
/*  723 */       if (i != j || paramSchemaType.getBaseType().getFullJavaName() == null)
/*      */       {
/*  725 */         if (i == 1000000) {
/*      */           
/*  727 */           emit("java.math.BigInteger getBigIntegerValue();");
/*  728 */           emit("void setBigIntegerValue(java.math.BigInteger bi);");
/*  729 */           emit("/** @deprecated */");
/*  730 */           if (this._useJava15)
/*  731 */             emit("@Deprecated"); 
/*  732 */           emit("java.math.BigInteger bigIntegerValue();");
/*  733 */           emit("/** @deprecated */");
/*  734 */           if (this._useJava15)
/*  735 */             emit("@Deprecated"); 
/*  736 */           emit("void set(java.math.BigInteger bi);");
/*      */         }
/*  738 */         else if (i == 64) {
/*      */           
/*  740 */           emit("long getLongValue();");
/*  741 */           emit("void setLongValue(long l);");
/*  742 */           emit("/** @deprecated */");
/*  743 */           if (this._useJava15)
/*  744 */             emit("@Deprecated"); 
/*  745 */           emit("long longValue();");
/*  746 */           emit("/** @deprecated */");
/*  747 */           if (this._useJava15)
/*  748 */             emit("@Deprecated"); 
/*  749 */           emit("void set(long l);");
/*      */         }
/*  751 */         else if (i == 32) {
/*      */           
/*  753 */           emit("int getIntValue();");
/*  754 */           emit("void setIntValue(int i);");
/*  755 */           emit("/** @deprecated */");
/*  756 */           if (this._useJava15)
/*  757 */             emit("@Deprecated"); 
/*  758 */           emit("int intValue();");
/*  759 */           emit("/** @deprecated */");
/*  760 */           if (this._useJava15)
/*  761 */             emit("@Deprecated"); 
/*  762 */           emit("void set(int i);");
/*      */         }
/*  764 */         else if (i == 16) {
/*      */           
/*  766 */           emit("short getShortValue();");
/*  767 */           emit("void setShortValue(short s);");
/*  768 */           emit("/** @deprecated */");
/*  769 */           if (this._useJava15)
/*  770 */             emit("@Deprecated"); 
/*  771 */           emit("short shortValue();");
/*  772 */           emit("/** @deprecated */");
/*  773 */           if (this._useJava15)
/*  774 */             emit("@Deprecated"); 
/*  775 */           emit("void set(short s);");
/*      */         }
/*  777 */         else if (i == 8) {
/*      */           
/*  779 */           emit("byte getByteValue();");
/*  780 */           emit("void setByteValue(byte b);");
/*  781 */           emit("/** @deprecated */");
/*  782 */           if (this._useJava15)
/*  783 */             emit("@Deprecated"); 
/*  784 */           emit("byte byteValue();");
/*  785 */           emit("/** @deprecated */");
/*  786 */           if (this._useJava15)
/*  787 */             emit("@Deprecated"); 
/*  788 */           emit("void set(byte b);");
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/*  793 */     if (paramSchemaType.getSimpleVariety() == 2) {
/*      */       
/*  795 */       emit("java.lang.Object getObjectValue();");
/*  796 */       emit("void setObjectValue(java.lang.Object val);");
/*  797 */       emit("/** @deprecated */");
/*  798 */       if (this._useJava15)
/*  799 */         emit("@Deprecated"); 
/*  800 */       emit("java.lang.Object objectValue();");
/*  801 */       emit("/** @deprecated */");
/*  802 */       if (this._useJava15)
/*  803 */         emit("@Deprecated"); 
/*  804 */       emit("void objectSet(java.lang.Object val);");
/*  805 */       emit("org.apache.xmlbeans.SchemaType instanceType();");
/*  806 */       SchemaType schemaType = paramSchemaType.getUnionCommonBaseType();
/*  807 */       if (schemaType == null || schemaType.getSimpleVariety() != 2);
/*  808 */       emitSpecializedAccessors(schemaType);
/*      */     } 
/*      */     
/*  811 */     if (paramSchemaType.getSimpleVariety() == 3) {
/*      */       
/*  813 */       emit("java.util.List getListValue();");
/*  814 */       emit("java.util.List xgetListValue();");
/*  815 */       emit("void setListValue(java.util.List list);");
/*  816 */       emit("/** @deprecated */");
/*  817 */       if (this._useJava15)
/*  818 */         emit("@Deprecated"); 
/*  819 */       emit("java.util.List listValue();");
/*  820 */       emit("/** @deprecated */");
/*  821 */       if (this._useJava15)
/*  822 */         emit("@Deprecated"); 
/*  823 */       emit("java.util.List xlistValue();");
/*  824 */       emit("/** @deprecated */");
/*  825 */       if (this._useJava15)
/*  826 */         emit("@Deprecated"); 
/*  827 */       emit("void set(java.util.List list);");
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   void startBlock() throws IOException {
/*  833 */     emit("{");
/*  834 */     indent();
/*      */   }
/*      */   
/*      */   void endBlock() throws IOException {
/*  838 */     outdent();
/*  839 */     emit("}");
/*      */   }
/*      */ 
/*      */   
/*      */   void printJavaDoc(String paramString) throws IOException {
/*  844 */     emit("");
/*  845 */     emit("/**");
/*  846 */     emit(" * " + paramString);
/*  847 */     emit(" */");
/*      */   }
/*      */ 
/*      */   
/*      */   void printShortJavaDoc(String paramString) throws IOException {
/*  852 */     emit("/** " + paramString + " */");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String javaStringEscape(String paramString) {
/*  859 */     for (byte b = 0; b < paramString.length(); ) {
/*      */       
/*  861 */       switch (paramString.charAt(b)) {
/*      */         case '\n':
/*      */         case '\r':
/*      */         case '"':
/*      */         case '\\':
/*      */           break;
/*      */         
/*      */         default:
/*      */           b++;
/*      */           continue;
/*      */       } 
/*  872 */       StringBuffer stringBuffer = new StringBuffer();
/*  873 */       for (byte b1 = 0; b1 < paramString.length(); b1++) {
/*      */         
/*  875 */         char c = paramString.charAt(b1);
/*  876 */         switch (c) {
/*      */           
/*      */           default:
/*  879 */             stringBuffer.append(c);
/*      */             break;
/*      */           case '\n':
/*  882 */             stringBuffer.append("\\n");
/*      */             break;
/*      */           case '\r':
/*  885 */             stringBuffer.append("\\r");
/*      */             break;
/*      */           case '"':
/*  888 */             stringBuffer.append("\\\"");
/*      */             break;
/*      */           case '\\':
/*  891 */             stringBuffer.append("\\\\");
/*      */             break;
/*      */         } 
/*      */       } 
/*  895 */       return stringBuffer.toString();
/*      */     } 
/*      */     return paramString;
/*      */   }
/*      */   void printStringEnumeration(SchemaType paramSchemaType) throws IOException {
/*  900 */     SchemaType schemaType = paramSchemaType.getBaseEnumType();
/*  901 */     String str = schemaType.getFullJavaName();
/*  902 */     boolean bool = hasBase(paramSchemaType);
/*      */     
/*  904 */     if (!bool) {
/*      */       
/*  906 */       emit("");
/*  907 */       emit("org.apache.xmlbeans.StringEnumAbstractBase enumValue();");
/*  908 */       emit("void set(org.apache.xmlbeans.StringEnumAbstractBase e);");
/*      */     } 
/*      */     
/*  911 */     emit("");
/*  912 */     SchemaStringEnumEntry[] arrayOfSchemaStringEnumEntry = paramSchemaType.getStringEnumEntries();
/*  913 */     HashSet hashSet1 = new HashSet();
/*  914 */     HashSet hashSet2 = new HashSet(); byte b;
/*  915 */     for (b = 0; b < arrayOfSchemaStringEnumEntry.length; b++) {
/*      */       
/*  917 */       String str1 = arrayOfSchemaStringEnumEntry[b].getString();
/*  918 */       if (hashSet1.contains(str1)) {
/*      */         
/*  920 */         hashSet2.add(str1);
/*      */       }
/*      */       else {
/*      */         
/*  924 */         hashSet1.add(str1);
/*  925 */         String str2 = arrayOfSchemaStringEnumEntry[b].getEnumName();
/*  926 */         if (bool)
/*  927 */         { emit("static final " + str + ".Enum " + str2 + " = " + str + "." + str2 + ";"); }
/*      */         else
/*  929 */         { emit("static final Enum " + str2 + " = Enum.forString(\"" + javaStringEscape(str1) + "\");"); } 
/*      */       } 
/*  931 */     }  emit("");
/*  932 */     for (b = 0; b < arrayOfSchemaStringEnumEntry.length; b++) {
/*      */       
/*  934 */       if (!hashSet2.contains(arrayOfSchemaStringEnumEntry[b].getString())) {
/*      */         
/*  936 */         String str1 = "INT_" + arrayOfSchemaStringEnumEntry[b].getEnumName();
/*  937 */         if (bool)
/*  938 */         { emit("static final int " + str1 + " = " + str + "." + str1 + ";"); }
/*      */         else
/*  940 */         { emit("static final int " + str1 + " = Enum." + str1 + ";"); } 
/*      */       } 
/*  942 */     }  if (!bool) {
/*      */       
/*  944 */       emit("");
/*  945 */       emit("/**");
/*  946 */       emit(" * Enumeration value class for " + str + ".");
/*  947 */       emit(" * These enum values can be used as follows:");
/*  948 */       emit(" * <pre>");
/*  949 */       emit(" * enum.toString(); // returns the string value of the enum");
/*  950 */       emit(" * enum.intValue(); // returns an int value, useful for switches");
/*  951 */       if (arrayOfSchemaStringEnumEntry.length > 0)
/*  952 */         emit(" * // e.g., case Enum.INT_" + arrayOfSchemaStringEnumEntry[0].getEnumName()); 
/*  953 */       emit(" * Enum.forString(s); // returns the enum value for a string");
/*  954 */       emit(" * Enum.forInt(i); // returns the enum value for an int");
/*  955 */       emit(" * </pre>");
/*  956 */       emit(" * Enumeration objects are immutable singleton objects that");
/*  957 */       emit(" * can be compared using == object equality. They have no");
/*  958 */       emit(" * public constructor. See the constants defined within this");
/*  959 */       emit(" * class for all the valid values.");
/*  960 */       emit(" */");
/*  961 */       emit("static final class Enum extends org.apache.xmlbeans.StringEnumAbstractBase");
/*  962 */       emit("{");
/*  963 */       indent();
/*  964 */       emit("/**");
/*  965 */       emit(" * Returns the enum value for a string, or null if none.");
/*  966 */       emit(" */");
/*  967 */       emit("public static Enum forString(java.lang.String s)");
/*  968 */       emit("    { return (Enum)table.forString(s); }");
/*  969 */       emit("/**");
/*  970 */       emit(" * Returns the enum value corresponding to an int, or null if none.");
/*  971 */       emit(" */");
/*  972 */       emit("public static Enum forInt(int i)");
/*  973 */       emit("    { return (Enum)table.forInt(i); }");
/*  974 */       emit("");
/*  975 */       emit("private Enum(java.lang.String s, int i)");
/*  976 */       emit("    { super(s, i); }");
/*  977 */       emit("");
/*  978 */       for (b = 0; b < arrayOfSchemaStringEnumEntry.length; b++) {
/*      */         
/*  980 */         String str1 = "INT_" + arrayOfSchemaStringEnumEntry[b].getEnumName();
/*  981 */         int i = arrayOfSchemaStringEnumEntry[b].getIntValue();
/*  982 */         emit("static final int " + str1 + " = " + i + ";");
/*      */       } 
/*  984 */       emit("");
/*  985 */       emit("public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =");
/*  986 */       emit("    new org.apache.xmlbeans.StringEnumAbstractBase.Table");
/*  987 */       emit("(");
/*  988 */       indent();
/*  989 */       emit("new Enum[]");
/*  990 */       emit("{");
/*  991 */       indent();
/*  992 */       for (b = 0; b < arrayOfSchemaStringEnumEntry.length; b++) {
/*      */         
/*  994 */         String str1 = arrayOfSchemaStringEnumEntry[b].getString();
/*  995 */         String str2 = "INT_" + arrayOfSchemaStringEnumEntry[b].getEnumName();
/*  996 */         emit("new Enum(\"" + javaStringEscape(str1) + "\", " + str2 + "),");
/*      */       } 
/*  998 */       outdent();
/*  999 */       emit("}");
/* 1000 */       outdent();
/* 1001 */       emit(");");
/* 1002 */       emit("private static final long serialVersionUID = 1L;");
/* 1003 */       emit("private java.lang.Object readResolve() { return forInt(intValue()); } ");
/* 1004 */       outdent();
/* 1005 */       emit("}");
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean hasBase(SchemaType paramSchemaType) {
/*      */     boolean bool;
/* 1012 */     SchemaType schemaType = paramSchemaType.getBaseEnumType();
/* 1013 */     if (schemaType.isAnonymousType() && schemaType.isSkippedAnonymousType()) {
/*      */       
/* 1015 */       if (paramSchemaType.getContentBasedOnType() != null) {
/* 1016 */         bool = (paramSchemaType.getContentBasedOnType().getBaseType() != schemaType) ? true : false;
/*      */       } else {
/* 1018 */         bool = (paramSchemaType.getBaseType() != schemaType) ? true : false;
/*      */       } 
/*      */     } else {
/* 1021 */       bool = (schemaType != paramSchemaType) ? true : false;
/* 1022 */     }  return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   String xmlTypeForProperty(SchemaProperty paramSchemaProperty) {
/* 1027 */     SchemaType schemaType = paramSchemaProperty.javaBasedOnType();
/* 1028 */     return findJavaType(schemaType).replace('$', '.');
/*      */   }
/*      */ 
/*      */   
/*      */   static boolean xmlTypeForPropertyIsUnion(SchemaProperty paramSchemaProperty) {
/* 1033 */     SchemaType schemaType = paramSchemaProperty.javaBasedOnType();
/* 1034 */     return (schemaType.isSimpleType() && schemaType.getSimpleVariety() == 2);
/*      */   }
/*      */ 
/*      */   
/*      */   static boolean isJavaPrimitive(int paramInt) {
/* 1039 */     return (paramInt < 1) ? false : (!(paramInt > 7));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static String javaWrappedType(int paramInt) {
/* 1046 */     switch (paramInt) {
/*      */       
/*      */       case 1:
/* 1049 */         return "java.lang.Boolean";
/*      */       case 2:
/* 1051 */         return "java.lang.Float";
/*      */       case 3:
/* 1053 */         return "java.lang.Double";
/*      */       case 4:
/* 1055 */         return "java.lang.Byte";
/*      */       case 5:
/* 1057 */         return "java.lang.Short";
/*      */       case 6:
/* 1059 */         return "java.lang.Integer";
/*      */       case 7:
/* 1061 */         return "java.lang.Long";
/*      */     } 
/*      */ 
/*      */     
/*      */     assert false;
/* 1066 */     throw new IllegalStateException();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   String javaTypeForProperty(SchemaProperty paramSchemaProperty) {
/*      */     SchemaType schemaType;
/* 1073 */     if (paramSchemaProperty.getJavaTypeCode() == 0) {
/*      */       
/* 1075 */       SchemaType schemaType1 = paramSchemaProperty.javaBasedOnType();
/* 1076 */       return findJavaType(schemaType1).replace('$', '.');
/*      */     } 
/*      */     
/* 1079 */     if (paramSchemaProperty.getJavaTypeCode() == 20)
/*      */     {
/* 1081 */       return ((SchemaTypeImpl)paramSchemaProperty.getType()).getUserTypeName();
/*      */     }
/*      */     
/* 1084 */     switch (paramSchemaProperty.getJavaTypeCode()) {
/*      */       
/*      */       case 1:
/* 1087 */         return "boolean";
/*      */       case 2:
/* 1089 */         return "float";
/*      */       case 3:
/* 1091 */         return "double";
/*      */       case 4:
/* 1093 */         return "byte";
/*      */       case 5:
/* 1095 */         return "short";
/*      */       case 6:
/* 1097 */         return "int";
/*      */       case 7:
/* 1099 */         return "long";
/*      */       
/*      */       case 8:
/* 1102 */         return "java.math.BigDecimal";
/*      */       case 9:
/* 1104 */         return "java.math.BigInteger";
/*      */       case 10:
/* 1106 */         return "java.lang.String";
/*      */       case 11:
/* 1108 */         return "byte[]";
/*      */       case 12:
/* 1110 */         return "org.apache.xmlbeans.GDate";
/*      */       case 13:
/* 1112 */         return "org.apache.xmlbeans.GDuration";
/*      */       case 14:
/* 1114 */         return "java.util.Date";
/*      */       case 15:
/* 1116 */         return "javax.xml.namespace.QName";
/*      */       case 16:
/* 1118 */         return "java.util.List";
/*      */       case 17:
/* 1120 */         return "java.util.Calendar";
/*      */       
/*      */       case 18:
/* 1123 */         schemaType = paramSchemaProperty.javaBasedOnType();
/* 1124 */         if (schemaType.getSimpleVariety() == 2)
/* 1125 */           schemaType = schemaType.getUnionCommonBaseType(); 
/* 1126 */         assert schemaType.getBaseEnumType() != null;
/* 1127 */         if (hasBase(schemaType)) {
/* 1128 */           return findJavaType(schemaType.getBaseEnumType()).replace('$', '.') + ".Enum";
/*      */         }
/* 1130 */         return findJavaType(schemaType).replace('$', '.') + ".Enum";
/*      */       
/*      */       case 19:
/* 1133 */         return "java.lang.Object";
/*      */     } 
/*      */     
/*      */     assert false;
/* 1137 */     throw new IllegalStateException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void printPropertyGetters(b paramb, boolean paramBoolean1, String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5) throws IOException {
/* 1148 */     String str = "\"" + paramb.dT() + "\"" + (paramBoolean1 ? " attribute" : " element");
/* 1149 */     boolean bool = (paramInt == 0) ? true : false;
/*      */     
/* 1151 */     if (paramBoolean5) {
/*      */       
/* 1153 */       printJavaDoc((paramBoolean4 ? "Gets first " : "Gets the ") + str);
/* 1154 */       emit(paramString2 + " get" + paramString1 + "();");
/*      */       
/* 1156 */       if (!bool) {
/*      */         
/* 1158 */         printJavaDoc((paramBoolean4 ? "Gets (as xml) first " : "Gets (as xml) the ") + str);
/* 1159 */         emit(paramString3 + " xget" + paramString1 + "();");
/*      */       } 
/*      */       
/* 1162 */       if (paramBoolean2) {
/*      */         
/* 1164 */         printJavaDoc((paramBoolean4 ? "Tests for nil first " : "Tests for nil ") + str);
/* 1165 */         emit("boolean isNil" + paramString1 + "();");
/*      */       } 
/*      */     } 
/*      */     
/* 1169 */     if (paramBoolean3) {
/*      */       
/* 1171 */       printJavaDoc((paramBoolean4 ? "True if has at least one " : "True if has ") + str);
/* 1172 */       emit("boolean isSet" + paramString1 + "();");
/*      */     } 
/*      */     
/* 1175 */     if (paramBoolean4) {
/*      */       
/* 1177 */       String str1 = paramString1 + "Array";
/*      */       
/* 1179 */       if (this._useJava15) {
/*      */         
/* 1181 */         String str2 = paramString2;
/* 1182 */         if (isJavaPrimitive(paramInt)) {
/* 1183 */           str2 = javaWrappedType(paramInt);
/*      */         }
/* 1185 */         printJavaDoc("Gets a List of " + str + "s");
/* 1186 */         emit("java.util.List<" + str2 + "> get" + paramString1 + "List();");
/*      */       } 
/*      */       
/* 1189 */       if (this._useJava15) {
/*      */         
/* 1191 */         emit("");
/* 1192 */         emit("/**");
/* 1193 */         emit(" * Gets array of all " + str + "s");
/* 1194 */         emit(" * @deprecated");
/* 1195 */         emit(" */");
/* 1196 */         emit("@Deprecated");
/*      */       } else {
/*      */         
/* 1199 */         printJavaDoc("Gets array of all " + str + "s");
/* 1200 */       }  emit(paramString2 + "[] get" + str1 + "();");
/*      */       
/* 1202 */       printJavaDoc("Gets ith " + str);
/* 1203 */       emit(paramString2 + " get" + str1 + "(int i);");
/*      */       
/* 1205 */       if (!bool) {
/*      */         
/* 1207 */         if (this._useJava15) {
/*      */           
/* 1209 */           printJavaDoc("Gets (as xml) a List of " + str + "s");
/* 1210 */           emit("java.util.List<" + paramString3 + "> xget" + paramString1 + "List();");
/*      */         } 
/*      */         
/* 1213 */         if (this._useJava15) {
/*      */           
/* 1215 */           emit("");
/* 1216 */           emit("/**");
/* 1217 */           emit(" * Gets (as xml) array of all " + str + "s");
/* 1218 */           emit(" * @deprecated");
/* 1219 */           emit(" */");
/* 1220 */           emit("@Deprecated");
/*      */         } else {
/*      */           
/* 1223 */           printJavaDoc("Gets (as xml) array of all " + str + "s");
/* 1224 */         }  emit(paramString3 + "[] xget" + str1 + "();");
/*      */         
/* 1226 */         printJavaDoc("Gets (as xml) ith " + str);
/* 1227 */         emit(paramString3 + " xget" + str1 + "(int i);");
/*      */       } 
/*      */       
/* 1230 */       if (paramBoolean2) {
/*      */         
/* 1232 */         printJavaDoc("Tests for nil ith " + str);
/* 1233 */         emit("boolean isNil" + str1 + "(int i);");
/*      */       } 
/*      */       
/* 1236 */       printJavaDoc("Returns number of " + str);
/* 1237 */       emit("int sizeOf" + str1 + "();");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void printPropertySetters(b paramb, boolean paramBoolean1, String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5) throws IOException {
/* 1247 */     String str1 = NameUtil.nonJavaKeyword(NameUtil.lowerCamelCase(paramString1));
/* 1248 */     if (str1.equals("i"))
/* 1249 */       str1 = "iValue"; 
/* 1250 */     boolean bool = (paramInt == 0) ? true : false;
/*      */     
/* 1252 */     String str2 = "\"" + paramb.dT() + "\"" + (paramBoolean1 ? " attribute" : " element");
/*      */     
/* 1254 */     if (paramBoolean5) {
/*      */       
/* 1256 */       printJavaDoc((paramBoolean4 ? "Sets first " : "Sets the ") + str2);
/* 1257 */       emit("void set" + paramString1 + "(" + paramString2 + " " + str1 + ");");
/*      */       
/* 1259 */       if (!bool) {
/*      */         
/* 1261 */         printJavaDoc((paramBoolean4 ? "Sets (as xml) first " : "Sets (as xml) the ") + str2);
/* 1262 */         emit("void xset" + paramString1 + "(" + paramString3 + " " + str1 + ");");
/*      */       } 
/*      */       
/* 1265 */       if (bool && !paramBoolean4) {
/*      */         
/* 1267 */         printJavaDoc("Appends and returns a new empty " + str2);
/* 1268 */         emit(paramString3 + " addNew" + paramString1 + "();");
/*      */       } 
/*      */       
/* 1271 */       if (paramBoolean2) {
/*      */         
/* 1273 */         printJavaDoc((paramBoolean4 ? "Nils the first " : "Nils the ") + str2);
/* 1274 */         emit("void setNil" + paramString1 + "();");
/*      */       } 
/*      */     } 
/*      */     
/* 1278 */     if (paramBoolean3) {
/*      */       
/* 1280 */       printJavaDoc((paramBoolean4 ? "Removes first " : "Unsets the ") + str2);
/* 1281 */       emit("void unset" + paramString1 + "();");
/*      */     } 
/*      */     
/* 1284 */     if (paramBoolean4) {
/*      */       
/* 1286 */       String str = paramString1 + "Array";
/*      */       
/* 1288 */       printJavaDoc("Sets array of all " + str2);
/* 1289 */       emit("void set" + str + "(" + paramString2 + "[] " + str1 + "Array);");
/*      */       
/* 1291 */       printJavaDoc("Sets ith " + str2);
/* 1292 */       emit("void set" + str + "(int i, " + paramString2 + " " + str1 + ");");
/*      */       
/* 1294 */       if (!bool) {
/*      */         
/* 1296 */         printJavaDoc("Sets (as xml) array of all " + str2);
/* 1297 */         emit("void xset" + str + "(" + paramString3 + "[] " + str1 + "Array);");
/*      */         
/* 1299 */         printJavaDoc("Sets (as xml) ith " + str2);
/* 1300 */         emit("void xset" + str + "(int i, " + paramString3 + " " + str1 + ");");
/*      */       } 
/*      */       
/* 1303 */       if (paramBoolean2) {
/*      */         
/* 1305 */         printJavaDoc("Nils the ith " + str2);
/* 1306 */         emit("void setNil" + str + "(int i);");
/*      */       } 
/*      */       
/* 1309 */       if (!bool) {
/*      */         
/* 1311 */         printJavaDoc("Inserts the value as the ith " + str2);
/* 1312 */         emit("void insert" + paramString1 + "(int i, " + paramString2 + " " + str1 + ");");
/*      */         
/* 1314 */         printJavaDoc("Appends the value as the last " + str2);
/* 1315 */         emit("void add" + paramString1 + "(" + paramString2 + " " + str1 + ");");
/*      */       } 
/*      */       
/* 1318 */       printJavaDoc("Inserts and returns a new empty value (as xml) as the ith " + str2);
/* 1319 */       emit(paramString3 + " insertNew" + paramString1 + "(int i);");
/*      */       
/* 1321 */       printJavaDoc("Appends and returns a new empty value (as xml) as the last " + str2);
/* 1322 */       emit(paramString3 + " addNew" + paramString1 + "();");
/*      */       
/* 1324 */       printJavaDoc("Removes the ith " + str2);
/* 1325 */       emit("void remove" + paramString1 + "(int i);");
/*      */     } 
/*      */   }
/*      */   
/*      */   String getAtomicRestrictionType(SchemaType paramSchemaType) {
/* 1330 */     SchemaType schemaType = paramSchemaType.getPrimitiveType();
/* 1331 */     switch (schemaType.getBuiltinTypeCode()) {
/*      */       
/*      */       case 2:
/* 1334 */         return "org.apache.xmlbeans.impl.values.XmlAnySimpleTypeImpl";
/*      */       case 3:
/* 1336 */         return "org.apache.xmlbeans.impl.values.JavaBooleanHolderEx";
/*      */       case 4:
/* 1338 */         return "org.apache.xmlbeans.impl.values.JavaBase64HolderEx";
/*      */       case 5:
/* 1340 */         return "org.apache.xmlbeans.impl.values.JavaHexBinaryHolderEx";
/*      */       case 6:
/* 1342 */         return "org.apache.xmlbeans.impl.values.JavaUriHolderEx";
/*      */       case 7:
/* 1344 */         return "org.apache.xmlbeans.impl.values.JavaQNameHolderEx";
/*      */       case 8:
/* 1346 */         return "org.apache.xmlbeans.impl.values.JavaNotationHolderEx";
/*      */       case 9:
/* 1348 */         return "org.apache.xmlbeans.impl.values.JavaFloatHolderEx";
/*      */       case 10:
/* 1350 */         return "org.apache.xmlbeans.impl.values.JavaDoubleHolderEx";
/*      */       case 11:
/* 1352 */         switch (paramSchemaType.getDecimalSize())
/*      */         { default:
/*      */             assert false;
/*      */           
/*      */           case 1000001:
/* 1357 */             return "org.apache.xmlbeans.impl.values.JavaDecimalHolderEx";
/*      */           case 1000000:
/* 1359 */             return "org.apache.xmlbeans.impl.values.JavaIntegerHolderEx";
/*      */           case 64:
/* 1361 */             return "org.apache.xmlbeans.impl.values.JavaLongHolderEx";
/*      */           case 8:
/*      */           case 16:
/*      */           case 32:
/* 1365 */             break; }  return "org.apache.xmlbeans.impl.values.JavaIntHolderEx";
/*      */       
/*      */       case 12:
/* 1368 */         if (paramSchemaType.hasStringEnumValues()) {
/* 1369 */           return "org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx";
/*      */         }
/* 1371 */         return "org.apache.xmlbeans.impl.values.JavaStringHolderEx";
/*      */       
/*      */       case 14:
/*      */       case 15:
/*      */       case 16:
/*      */       case 17:
/*      */       case 18:
/*      */       case 19:
/*      */       case 20:
/*      */       case 21:
/* 1381 */         return "org.apache.xmlbeans.impl.values.JavaGDateHolderEx";
/*      */       
/*      */       case 13:
/* 1384 */         return "org.apache.xmlbeans.impl.values.JavaGDurationHolderEx";
/*      */     } 
/* 1386 */     assert false : "unrecognized primitive type";
/* 1387 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static SchemaType findBaseType(SchemaType paramSchemaType) {
/* 1393 */     while (paramSchemaType.getFullJavaName() == null)
/* 1394 */       paramSchemaType = paramSchemaType.getBaseType(); 
/* 1395 */     return paramSchemaType;
/*      */   }
/*      */   
/*      */   String getBaseClass(SchemaType paramSchemaType) {
/* 1399 */     SchemaType schemaType = findBaseType(paramSchemaType.getBaseType());
/*      */     
/* 1401 */     switch (paramSchemaType.getSimpleVariety()) {
/*      */ 
/*      */       
/*      */       case 0:
/* 1405 */         if (!XmlObject.type.equals(schemaType))
/* 1406 */           return schemaType.getFullJavaImplName(); 
/* 1407 */         return "org.apache.xmlbeans.impl.values.XmlComplexContentImpl";
/*      */ 
/*      */       
/*      */       case 1:
/* 1411 */         assert !paramSchemaType.isBuiltinType();
/* 1412 */         return getAtomicRestrictionType(paramSchemaType);
/*      */       
/*      */       case 3:
/* 1415 */         return "org.apache.xmlbeans.impl.values.XmlListImpl";
/*      */       
/*      */       case 2:
/* 1418 */         return "org.apache.xmlbeans.impl.values.XmlUnionImpl";
/*      */     } 
/*      */     
/* 1421 */     throw new IllegalStateException();
/*      */   }
/*      */ 
/*      */   
/*      */   void printConstructor(SchemaType paramSchemaType, String paramString) throws IOException {
/* 1426 */     emit("");
/* 1427 */     emit("public " + paramString + "(org.apache.xmlbeans.SchemaType sType)");
/* 1428 */     startBlock();
/* 1429 */     emit("super(sType" + ((paramSchemaType.getSimpleVariety() == 0) ? "" : (", " + (!paramSchemaType.isSimpleType() ? 1 : 0))) + ");");
/*      */ 
/*      */ 
/*      */     
/* 1433 */     endBlock();
/*      */     
/* 1435 */     if (paramSchemaType.getSimpleVariety() != 0) {
/*      */       
/* 1437 */       emit("");
/* 1438 */       emit("protected " + paramString + "(org.apache.xmlbeans.SchemaType sType, boolean b)");
/* 1439 */       startBlock();
/* 1440 */       emit("super(sType, b);");
/* 1441 */       endBlock();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   void startClass(SchemaType paramSchemaType, boolean paramBoolean) throws IOException {
/* 1447 */     String str1 = paramSchemaType.getShortJavaImplName();
/* 1448 */     String str2 = getBaseClass(paramSchemaType);
/* 1449 */     StringBuffer stringBuffer = new StringBuffer();
/* 1450 */     stringBuffer.append(paramSchemaType.getFullJavaName().replace('$', '.'));
/*      */     
/* 1452 */     if (paramSchemaType.getSimpleVariety() == 2) {
/* 1453 */       SchemaType[] arrayOfSchemaType = paramSchemaType.getUnionMemberTypes();
/* 1454 */       for (byte b = 0; b < arrayOfSchemaType.length; b++) {
/* 1455 */         stringBuffer.append(", " + arrayOfSchemaType[b].getFullJavaName().replace('$', '.'));
/*      */       }
/*      */     } 
/* 1458 */     emit("public " + (paramBoolean ? "static " : "") + "class " + str1 + " extends " + str2 + " implements " + stringBuffer.toString());
/*      */ 
/*      */     
/* 1461 */     startBlock();
/*      */     
/* 1463 */     emit("private static final long serialVersionUID = 1L;");
/*      */   }
/*      */ 
/*      */   
/*      */   void makeAttributeDefaultValue(String paramString1, SchemaProperty paramSchemaProperty, String paramString2) throws IOException {
/* 1468 */     String str = paramString1;
/* 1469 */     if (str == null) {
/* 1470 */       str = paramSchemaProperty.javaBasedOnType().getFullJavaName().replace('$', '.');
/*      */     }
/* 1472 */     emit("target = (" + str + ")get_default_attribute_value(" + paramString2 + ");");
/*      */   }
/*      */ 
/*      */   
/*      */   void makeMissingValue(int paramInt) throws IOException {
/* 1477 */     switch (paramInt) {
/*      */       
/*      */       case 1:
/* 1480 */         emit("return false;");
/*      */         return;
/*      */       case 2:
/* 1483 */         emit("return 0.0f;");
/*      */         return;
/*      */       case 3:
/* 1486 */         emit("return 0.0;");
/*      */         return;
/*      */       case 4:
/*      */       case 5:
/*      */       case 6:
/* 1491 */         emit("return 0;");
/*      */         return;
/*      */       case 7:
/* 1494 */         emit("return 0L;");
/*      */         return;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1510 */     emit("return null;");
/*      */   }
/*      */ 
/*      */   
/*      */   void printJGetArrayValue(int paramInt, String paramString, SchemaTypeImpl paramSchemaTypeImpl) throws IOException {
/* 1515 */     switch (paramInt) {
/*      */       
/*      */       case 0:
/* 1518 */         emit(paramString + "[] result = new " + paramString + "[targetList.size()];");
/* 1519 */         emit("targetList.toArray(result);");
/*      */         break;
/*      */       
/*      */       case 18:
/* 1523 */         emit(paramString + "[] result = new " + paramString + "[targetList.size()];");
/* 1524 */         emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
/* 1525 */         emit("    result[i] = (" + paramString + ")((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getEnumValue();");
/*      */         break;
/*      */       
/*      */       case 1:
/* 1529 */         emit("boolean[] result = new boolean[targetList.size()];");
/* 1530 */         emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
/* 1531 */         emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getBooleanValue();");
/*      */         break;
/*      */       
/*      */       case 2:
/* 1535 */         emit("float[] result = new float[targetList.size()];");
/* 1536 */         emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
/* 1537 */         emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getFloatValue();");
/*      */         break;
/*      */       
/*      */       case 3:
/* 1541 */         emit("double[] result = new double[targetList.size()];");
/* 1542 */         emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
/* 1543 */         emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getDoubleValue();");
/*      */         break;
/*      */       
/*      */       case 4:
/* 1547 */         emit("byte[] result = new byte[targetList.size()];");
/* 1548 */         emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
/* 1549 */         emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getByteValue();");
/*      */         break;
/*      */       
/*      */       case 5:
/* 1553 */         emit("short[] result = new short[targetList.size()];");
/* 1554 */         emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
/* 1555 */         emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getShortValue();");
/*      */         break;
/*      */       
/*      */       case 6:
/* 1559 */         emit("int[] result = new int[targetList.size()];");
/* 1560 */         emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
/* 1561 */         emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getIntValue();");
/*      */         break;
/*      */       
/*      */       case 7:
/* 1565 */         emit("long[] result = new long[targetList.size()];");
/* 1566 */         emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
/* 1567 */         emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getLongValue();");
/*      */         break;
/*      */       
/*      */       case 8:
/* 1571 */         emit("java.math.BigDecimal[] result = new java.math.BigDecimal[targetList.size()];");
/* 1572 */         emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
/* 1573 */         emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getBigDecimalValue();");
/*      */         break;
/*      */       
/*      */       case 9:
/* 1577 */         emit("java.math.BigInteger[] result = new java.math.BigInteger[targetList.size()];");
/* 1578 */         emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
/* 1579 */         emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getBigIntegerValue();");
/*      */         break;
/*      */       
/*      */       case 10:
/* 1583 */         emit("java.lang.String[] result = new java.lang.String[targetList.size()];");
/* 1584 */         emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
/* 1585 */         emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();");
/*      */         break;
/*      */       
/*      */       case 11:
/* 1589 */         emit("byte[][] result = new byte[targetList.size()][];");
/* 1590 */         emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
/* 1591 */         emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getByteArrayValue();");
/*      */         break;
/*      */       
/*      */       case 17:
/* 1595 */         emit("java.util.Calendar[] result = new java.util.Calendar[targetList.size()];");
/* 1596 */         emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
/* 1597 */         emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getCalendarValue();");
/*      */         break;
/*      */       
/*      */       case 14:
/* 1601 */         emit("java.util.Date[] result = new java.util.Date[targetList.size()];");
/* 1602 */         emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
/* 1603 */         emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getDateValue();");
/*      */         break;
/*      */       
/*      */       case 12:
/* 1607 */         emit("org.apache.xmlbeans.GDate[] result = new org.apache.xmlbeans.GDate[targetList.size()];");
/* 1608 */         emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
/* 1609 */         emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getGDateValue();");
/*      */         break;
/*      */       
/*      */       case 13:
/* 1613 */         emit("org.apache.xmlbeans.GDuration[] result = new org.apache.xmlbeans.GDuration[targetList.size()];");
/* 1614 */         emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
/* 1615 */         emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getGDurationValue();");
/*      */         break;
/*      */       
/*      */       case 15:
/* 1619 */         emit("javax.xml.namespace.QName[] result = new javax.xml.namespace.QName[targetList.size()];");
/* 1620 */         emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
/* 1621 */         emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getQNameValue();");
/*      */         break;
/*      */       
/*      */       case 16:
/* 1625 */         emit("java.util.List[] result = new java.util.List[targetList.size()];");
/* 1626 */         emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
/* 1627 */         emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getListValue();");
/*      */         break;
/*      */       
/*      */       case 19:
/* 1631 */         emit("java.lang.Object[] result = new java.lang.Object[targetList.size()];");
/* 1632 */         emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
/* 1633 */         emit("    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getObjectValue();");
/*      */         break;
/*      */       
/*      */       case 20:
/* 1637 */         emit(paramSchemaTypeImpl.getUserTypeName() + "[] result = new " + paramSchemaTypeImpl.getUserTypeName() + "[targetList.size()];");
/* 1638 */         emit("for (int i = 0, len = targetList.size() ; i < len ; i++)");
/* 1639 */         emit("    result[i] = " + getUserTypeStaticHandlerMethod(false, paramSchemaTypeImpl) + "((org.apache.xmlbeans.SimpleValue)targetList.get(i));");
/*      */         break;
/*      */ 
/*      */       
/*      */       default:
/* 1644 */         throw new IllegalStateException();
/*      */     } 
/* 1646 */     emit("return result;");
/*      */   }
/*      */   void printJGetValue(int paramInt, String paramString, SchemaTypeImpl paramSchemaTypeImpl) throws IOException {
/* 1649 */     switch (paramInt) {
/*      */       
/*      */       case 0:
/* 1652 */         emit("return target;");
/*      */         return;
/*      */       case 1:
/* 1655 */         emit("return target.getBooleanValue();");
/*      */         return;
/*      */       case 2:
/* 1658 */         emit("return target.getFloatValue();");
/*      */         return;
/*      */       case 3:
/* 1661 */         emit("return target.getDoubleValue();");
/*      */         return;
/*      */       case 4:
/* 1664 */         emit("return target.getByteValue();");
/*      */         return;
/*      */       case 5:
/* 1667 */         emit("return target.getShortValue();");
/*      */         return;
/*      */       case 6:
/* 1670 */         emit("return target.getIntValue();");
/*      */         return;
/*      */       case 7:
/* 1673 */         emit("return target.getLongValue();");
/*      */         return;
/*      */       case 8:
/* 1676 */         emit("return target.getBigDecimalValue();");
/*      */         return;
/*      */       case 9:
/* 1679 */         emit("return target.getBigIntegerValue();");
/*      */         return;
/*      */       case 10:
/* 1682 */         emit("return target.getStringValue();");
/*      */         return;
/*      */       case 11:
/* 1685 */         emit("return target.getByteArrayValue();");
/*      */         return;
/*      */       case 12:
/* 1688 */         emit("return target.getGDateValue();");
/*      */         return;
/*      */       case 13:
/* 1691 */         emit("return target.getGDurationValue();");
/*      */         return;
/*      */       case 17:
/* 1694 */         emit("return target.getCalendarValue();");
/*      */         return;
/*      */       case 14:
/* 1697 */         emit("return target.getDateValue();");
/*      */         return;
/*      */       case 15:
/* 1700 */         emit("return target.getQNameValue();");
/*      */         return;
/*      */       case 16:
/* 1703 */         emit("return target.getListValue();");
/*      */         return;
/*      */       case 18:
/* 1706 */         emit("return (" + paramString + ")target.getEnumValue();");
/*      */         return;
/*      */       case 19:
/* 1709 */         emit("return target.getObjectValue();");
/*      */         return;
/*      */       case 20:
/* 1712 */         emit("return " + getUserTypeStaticHandlerMethod(false, paramSchemaTypeImpl) + "(target);");
/*      */         return;
/*      */     } 
/*      */ 
/*      */     
/* 1717 */     throw new IllegalStateException();
/*      */   }
/*      */   
/*      */   void printJSetValue(int paramInt, String paramString, SchemaTypeImpl paramSchemaTypeImpl) throws IOException {
/* 1721 */     switch (paramInt) {
/*      */       
/*      */       case 0:
/* 1724 */         emit("target.set(" + paramString + ");");
/*      */         return;
/*      */       case 1:
/* 1727 */         emit("target.setBooleanValue(" + paramString + ");");
/*      */         return;
/*      */       case 2:
/* 1730 */         emit("target.setFloatValue(" + paramString + ");");
/*      */         return;
/*      */       case 3:
/* 1733 */         emit("target.setDoubleValue(" + paramString + ");");
/*      */         return;
/*      */       case 4:
/* 1736 */         emit("target.setByteValue(" + paramString + ");");
/*      */         return;
/*      */       case 5:
/* 1739 */         emit("target.setShortValue(" + paramString + ");");
/*      */         return;
/*      */       case 6:
/* 1742 */         emit("target.setIntValue(" + paramString + ");");
/*      */         return;
/*      */       case 7:
/* 1745 */         emit("target.setLongValue(" + paramString + ");");
/*      */         return;
/*      */       case 8:
/* 1748 */         emit("target.setBigDecimalValue(" + paramString + ");");
/*      */         return;
/*      */       case 9:
/* 1751 */         emit("target.setBigIntegerValue(" + paramString + ");");
/*      */         return;
/*      */       case 10:
/* 1754 */         emit("target.setStringValue(" + paramString + ");");
/*      */         return;
/*      */       case 11:
/* 1757 */         emit("target.setByteArrayValue(" + paramString + ");");
/*      */         return;
/*      */       case 12:
/* 1760 */         emit("target.setGDateValue(" + paramString + ");");
/*      */         return;
/*      */       case 13:
/* 1763 */         emit("target.setGDurationValue(" + paramString + ");");
/*      */         return;
/*      */       case 17:
/* 1766 */         emit("target.setCalendarValue(" + paramString + ");");
/*      */         return;
/*      */       case 14:
/* 1769 */         emit("target.setDateValue(" + paramString + ");");
/*      */         return;
/*      */       case 15:
/* 1772 */         emit("target.setQNameValue(" + paramString + ");");
/*      */         return;
/*      */       case 16:
/* 1775 */         emit("target.setListValue(" + paramString + ");");
/*      */         return;
/*      */       case 18:
/* 1778 */         emit("target.setEnumValue(" + paramString + ");");
/*      */         return;
/*      */       case 19:
/* 1781 */         emit("target.setObjectValue(" + paramString + ");");
/*      */         return;
/*      */       case 20:
/* 1784 */         emit(getUserTypeStaticHandlerMethod(true, paramSchemaTypeImpl) + "(" + paramString + ", target);");
/*      */         return;
/*      */     } 
/*      */ 
/*      */     
/* 1789 */     throw new IllegalStateException();
/*      */   }
/*      */ 
/*      */   
/*      */   String getIdentifier(Map paramMap, b paramb) {
/* 1794 */     return ((String[])paramMap.get(paramb))[0];
/*      */   }
/*      */   
/*      */   String getSetIdentifier(Map paramMap, b paramb) {
/* 1798 */     String[] arrayOfString = (String[])paramMap.get(paramb);
/* 1799 */     return (arrayOfString[1] == null) ? arrayOfString[0] : arrayOfString[1];
/*      */   }
/*      */   
/*      */   Map printStaticFields(SchemaProperty[] paramArrayOfSchemaProperty) throws IOException {
/* 1803 */     HashMap hashMap = new HashMap();
/*      */     
/* 1805 */     emit("");
/* 1806 */     for (byte b = 0; b < paramArrayOfSchemaProperty.length; b++) {
/*      */       
/* 1808 */       String[] arrayOfString = new String[2];
/* 1809 */       SchemaProperty schemaProperty = paramArrayOfSchemaProperty[b];
/* 1810 */       b b1 = schemaProperty.getName();
/* 1811 */       hashMap.put(b1, arrayOfString);
/* 1812 */       String str1 = schemaProperty.getJavaPropertyName();
/* 1813 */       arrayOfString[0] = (str1 + "$" + (b * 2)).toUpperCase();
/* 1814 */       String str2 = "\"" + b1.getNamespaceURI() + "\"";
/*      */       
/* 1816 */       emit("private static final javax.xml.namespace.QName " + arrayOfString[0] + " = ");
/*      */       
/* 1818 */       indent();
/* 1819 */       emit("new javax.xml.namespace.QName(" + str2 + ", \"" + b1.dT() + "\");");
/*      */       
/* 1821 */       outdent();
/*      */       
/* 1823 */       if (paramArrayOfSchemaProperty[b].acceptedNames() != null) {
/*      */         
/* 1825 */         b[] arrayOfB = paramArrayOfSchemaProperty[b].acceptedNames();
/*      */         
/* 1827 */         if (arrayOfB.length > 1) {
/*      */           
/* 1829 */           arrayOfString[1] = (str1 + "$" + (b * 2 + 1)).toUpperCase();
/*      */           
/* 1831 */           emit("private static final org.apache.xmlbeans.QNameSet " + arrayOfString[1] + " = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { ");
/*      */           
/* 1833 */           indent();
/* 1834 */           for (byte b2 = 0; b2 < arrayOfB.length; b2++)
/*      */           {
/* 1836 */             emit("new javax.xml.namespace.QName(\"" + arrayOfB[b2].getNamespaceURI() + "\", \"" + arrayOfB[b2].dT() + "\"),");
/*      */           }
/*      */ 
/*      */           
/* 1840 */           outdent();
/*      */           
/* 1842 */           emit("});");
/*      */         } 
/*      */       } 
/*      */     } 
/* 1846 */     emit("");
/* 1847 */     return hashMap;
/*      */   }
/*      */ 
/*      */   
/*      */   void emitImplementationPreamble() throws IOException {
/* 1852 */     emit("synchronized (monitor())");
/* 1853 */     emit("{");
/* 1854 */     indent();
/* 1855 */     emit("check_orphaned();");
/*      */   }
/*      */ 
/*      */   
/*      */   void emitImplementationPostamble() throws IOException {
/* 1860 */     outdent();
/* 1861 */     emit("}");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void emitDeclareTarget(boolean paramBoolean, String paramString) throws IOException {
/* 1867 */     if (paramBoolean) {
/* 1868 */       emit(paramString + " target = null;");
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   void emitAddTarget(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2) throws IOException {
/* 1874 */     if (paramBoolean1) {
/* 1875 */       emit("target = (" + paramString2 + ")get_store().add_attribute_user(" + paramString1 + ");");
/*      */     } else {
/* 1877 */       emit("target = (" + paramString2 + ")get_store().add_element_user(" + paramString1 + ");");
/*      */     } 
/*      */   }
/*      */   
/*      */   void emitPre(SchemaType paramSchemaType, int paramInt, String paramString, boolean paramBoolean) throws IOException {
/* 1882 */     emitPre(paramSchemaType, paramInt, paramString, paramBoolean, "-1");
/*      */   }
/*      */ 
/*      */   
/*      */   void emitPre(SchemaType paramSchemaType, int paramInt, String paramString1, boolean paramBoolean, String paramString2) throws IOException {
/* 1887 */     SchemaTypeImpl schemaTypeImpl = getImpl(paramSchemaType);
/* 1888 */     if (schemaTypeImpl == null) {
/*      */       return;
/*      */     }
/* 1891 */     PrePostExtension prePostExtension = schemaTypeImpl.getPrePostExtension();
/* 1892 */     if (prePostExtension != null)
/*      */     {
/* 1894 */       if (prePostExtension.hasPreCall()) {
/*      */         
/* 1896 */         emit("if ( " + prePostExtension.getStaticHandler() + ".preSet(" + prePostOpString(paramInt) + ", this, " + paramString1 + ", " + paramBoolean + ", " + paramString2 + "))");
/* 1897 */         startBlock();
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   void emitPost(SchemaType paramSchemaType, int paramInt, String paramString, boolean paramBoolean) throws IOException {
/* 1904 */     emitPost(paramSchemaType, paramInt, paramString, paramBoolean, "-1");
/*      */   }
/*      */ 
/*      */   
/*      */   void emitPost(SchemaType paramSchemaType, int paramInt, String paramString1, boolean paramBoolean, String paramString2) throws IOException {
/* 1909 */     SchemaTypeImpl schemaTypeImpl = getImpl(paramSchemaType);
/* 1910 */     if (schemaTypeImpl == null) {
/*      */       return;
/*      */     }
/* 1913 */     PrePostExtension prePostExtension = schemaTypeImpl.getPrePostExtension();
/* 1914 */     if (prePostExtension != null) {
/*      */       
/* 1916 */       if (prePostExtension.hasPreCall())
/*      */       {
/* 1918 */         endBlock();
/*      */       }
/*      */       
/* 1921 */       if (prePostExtension.hasPostCall()) {
/* 1922 */         emit(prePostExtension.getStaticHandler() + ".postSet(" + prePostOpString(paramInt) + ", this, " + paramString1 + ", " + paramBoolean + ", " + paramString2 + ");");
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   String prePostOpString(int paramInt) {
/* 1928 */     switch (paramInt) {
/*      */       default:
/*      */         assert false;
/*      */ 
/*      */       
/*      */       case 1:
/* 1934 */         return "org.apache.xmlbeans.PrePostExtension.OPERATION_SET";
/*      */       
/*      */       case 2:
/* 1937 */         return "org.apache.xmlbeans.PrePostExtension.OPERATION_INSERT";
/*      */       case 3:
/*      */         break;
/* 1940 */     }  return "org.apache.xmlbeans.PrePostExtension.OPERATION_REMOVE";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void emitGetTarget(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt, String paramString4) throws IOException {
/* 1956 */     assert paramString1 != null && paramString2 != null;
/*      */     
/* 1958 */     emit(paramString4 + " target = null;");
/*      */     
/* 1960 */     if (paramBoolean) {
/* 1961 */       emit("target = (" + paramString4 + ")get_store().find_attribute_user(" + paramString2 + ");");
/*      */     } else {
/* 1963 */       emit("target = (" + paramString4 + ")get_store().find_element_user(" + paramString1 + ", " + paramString3 + ");");
/*      */     } 
/* 1965 */     if (paramInt == 1) {
/*      */       return;
/*      */     }
/* 1968 */     emit("if (target == null)");
/*      */     
/* 1970 */     startBlock();
/*      */     
/* 1972 */     switch (paramInt) {
/*      */ 
/*      */       
/*      */       case 3:
/* 1976 */         emitAddTarget(paramString2, paramBoolean, false, paramString4);
/*      */         break;
/*      */       
/*      */       case 4:
/* 1980 */         emit("throw new IndexOutOfBoundsException();");
/*      */         break;
/*      */       
/*      */       case 1:
/*      */         break;
/*      */       
/*      */       default:
/* 1987 */         assert false : "Bad behaviour type: " + paramInt;
/*      */         break;
/*      */     } 
/* 1990 */     endBlock();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void printListGetter15Impl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean1, boolean paramBoolean2) throws IOException {
/* 1999 */     String str1 = paramString3 + "Array";
/* 2000 */     String str2 = paramString3 + "List";
/* 2001 */     String str3 = paramString1 + ".this.";
/*      */     
/* 2003 */     String str4 = (paramBoolean2 ? "x" : "") + "get";
/* 2004 */     String str5 = (paramBoolean2 ? "x" : "") + "set";
/*      */     
/* 2006 */     printJavaDoc("Gets " + (paramBoolean2 ? "(as xml) " : "") + "a List of " + paramString2 + "s");
/*      */     
/* 2008 */     emit("public java.util.List<" + paramString4 + "> " + str4 + str2 + "()");
/* 2009 */     startBlock();
/*      */     
/* 2011 */     emit("final class " + str2 + " extends java.util.AbstractList<" + paramString4 + ">");
/* 2012 */     startBlock();
/*      */ 
/*      */     
/* 2015 */     if (this._useJava15)
/* 2016 */       emit("@Override"); 
/* 2017 */     emit("public " + paramString4 + " get(int i)");
/* 2018 */     emit("    { return " + str3 + str4 + str1 + "(i); }");
/* 2019 */     emit("");
/*      */ 
/*      */     
/* 2022 */     if (this._useJava15)
/* 2023 */       emit("@Override"); 
/* 2024 */     emit("public " + paramString4 + " set(int i, " + paramString4 + " o)");
/* 2025 */     startBlock();
/* 2026 */     emit(paramString4 + " old = " + str3 + str4 + str1 + "(i);");
/* 2027 */     emit(str3 + str5 + str1 + "(i, o);");
/* 2028 */     emit("return old;");
/* 2029 */     endBlock();
/* 2030 */     emit("");
/*      */ 
/*      */     
/* 2033 */     if (this._useJava15)
/* 2034 */       emit("@Override"); 
/* 2035 */     emit("public void add(int i, " + paramString4 + " o)");
/* 2036 */     if (paramBoolean1 || paramBoolean2) {
/* 2037 */       emit("    { " + str3 + "insertNew" + paramString3 + "(i).set(o); }");
/*      */     } else {
/* 2039 */       emit("    { " + str3 + "insert" + paramString3 + "(i, o); }");
/* 2040 */     }  emit("");
/*      */ 
/*      */     
/* 2043 */     if (this._useJava15)
/* 2044 */       emit("@Override"); 
/* 2045 */     emit("public " + paramString4 + " remove(int i)");
/* 2046 */     startBlock();
/* 2047 */     emit(paramString4 + " old = " + str3 + str4 + str1 + "(i);");
/* 2048 */     emit(str3 + "remove" + paramString3 + "(i);");
/* 2049 */     emit("return old;");
/* 2050 */     endBlock();
/* 2051 */     emit("");
/*      */ 
/*      */     
/* 2054 */     if (this._useJava15)
/* 2055 */       emit("@Override"); 
/* 2056 */     emit("public int size()");
/* 2057 */     emit("    { return " + str3 + "sizeOf" + str1 + "(); }");
/* 2058 */     emit("");
/*      */     
/* 2060 */     endBlock();
/*      */     
/* 2062 */     emit("");
/*      */     
/* 2064 */     emitImplementationPreamble();
/*      */     
/* 2066 */     emit("return new " + str2 + "();");
/*      */     
/* 2068 */     emitImplementationPostamble();
/* 2069 */     endBlock();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void printGetterImpls(String paramString1, SchemaProperty paramSchemaProperty, b paramb, boolean paramBoolean1, String paramString2, int paramInt, String paramString3, String paramString4, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, String paramString5, String paramString6) throws IOException {
/* 2080 */     String str1 = "\"" + paramb.dT() + "\"" + (paramBoolean1 ? " attribute" : " element");
/* 2081 */     boolean bool = (paramInt == 0) ? true : false;
/* 2082 */     String str2 = (paramBoolean6 || !bool) ? "org.apache.xmlbeans.SimpleValue" : paramString4;
/*      */     
/* 2084 */     if (paramBoolean5) {
/*      */ 
/*      */       
/* 2087 */       printJavaDoc((paramBoolean4 ? "Gets first " : "Gets the ") + str1);
/* 2088 */       emit("public " + paramString3 + " get" + paramString2 + "()");
/* 2089 */       startBlock();
/* 2090 */       emitImplementationPreamble();
/*      */       
/* 2092 */       emitGetTarget(paramString6, paramString5, paramBoolean1, "0", 1, str2);
/*      */       
/* 2094 */       if (paramBoolean1 && (paramSchemaProperty.hasDefault() == 2 || paramSchemaProperty.hasFixed() == 2)) {
/*      */ 
/*      */         
/* 2097 */         emit("if (target == null)");
/* 2098 */         startBlock();
/* 2099 */         makeAttributeDefaultValue(str2, paramSchemaProperty, paramString5);
/* 2100 */         endBlock();
/*      */       } 
/* 2102 */       emit("if (target == null)");
/* 2103 */       startBlock();
/* 2104 */       makeMissingValue(paramInt);
/* 2105 */       endBlock();
/*      */ 
/*      */       
/* 2108 */       printJGetValue(paramInt, paramString3, (SchemaTypeImpl)paramSchemaProperty.getType());
/*      */ 
/*      */       
/* 2111 */       emitImplementationPostamble();
/*      */       
/* 2113 */       endBlock();
/*      */       
/* 2115 */       if (!bool) {
/*      */ 
/*      */         
/* 2118 */         printJavaDoc((paramBoolean4 ? "Gets (as xml) first " : "Gets (as xml) the ") + str1);
/* 2119 */         emit("public " + paramString4 + " xget" + paramString2 + "()");
/* 2120 */         startBlock();
/* 2121 */         emitImplementationPreamble();
/* 2122 */         emitGetTarget(paramString6, paramString5, paramBoolean1, "0", 1, paramString4);
/*      */         
/* 2124 */         if (paramBoolean1 && (paramSchemaProperty.hasDefault() == 2 || paramSchemaProperty.hasFixed() == 2)) {
/*      */ 
/*      */           
/* 2127 */           emit("if (target == null)");
/* 2128 */           startBlock();
/* 2129 */           makeAttributeDefaultValue(paramString4, paramSchemaProperty, paramString5);
/* 2130 */           endBlock();
/*      */         } 
/*      */         
/* 2133 */         emit("return target;");
/* 2134 */         emitImplementationPostamble();
/* 2135 */         endBlock();
/*      */       } 
/*      */       
/* 2138 */       if (paramBoolean2) {
/*      */ 
/*      */         
/* 2141 */         printJavaDoc((paramBoolean4 ? "Tests for nil first " : "Tests for nil ") + str1);
/* 2142 */         emit("public boolean isNil" + paramString2 + "()");
/* 2143 */         startBlock();
/* 2144 */         emitImplementationPreamble();
/* 2145 */         emitGetTarget(paramString6, paramString5, paramBoolean1, "0", 1, paramString4);
/*      */         
/* 2147 */         emit("if (target == null) return false;");
/* 2148 */         emit("return target.isNil();");
/* 2149 */         emitImplementationPostamble();
/* 2150 */         endBlock();
/*      */       } 
/*      */     } 
/*      */     
/* 2154 */     if (paramBoolean3) {
/*      */ 
/*      */       
/* 2157 */       printJavaDoc((paramBoolean4 ? "True if has at least one " : "True if has ") + str1);
/* 2158 */       emit("public boolean isSet" + paramString2 + "()");
/*      */       
/* 2160 */       startBlock();
/* 2161 */       emitImplementationPreamble();
/*      */       
/* 2163 */       if (paramBoolean1) {
/* 2164 */         emit("return get_store().find_attribute_user(" + paramString5 + ") != null;");
/*      */       } else {
/* 2166 */         emit("return get_store().count_elements(" + paramString6 + ") != 0;");
/*      */       } 
/* 2168 */       emitImplementationPostamble();
/* 2169 */       endBlock();
/*      */     } 
/*      */     
/* 2172 */     if (paramBoolean4) {
/*      */       
/* 2174 */       String str = paramString2 + "Array";
/*      */       
/* 2176 */       if (this._useJava15) {
/*      */ 
/*      */ 
/*      */         
/* 2180 */         String str3 = paramString3;
/* 2181 */         if (isJavaPrimitive(paramInt)) {
/* 2182 */           str3 = javaWrappedType(paramInt);
/*      */         }
/* 2184 */         printListGetter15Impl(paramString1, str1, paramString2, str3, paramString4, bool, false);
/*      */       } 
/*      */ 
/*      */       
/* 2188 */       if (this._useJava15) {
/*      */         
/* 2190 */         emit("");
/* 2191 */         emit("/**");
/* 2192 */         emit(" * Gets array of all " + str1 + "s");
/* 2193 */         emit(" * @deprecated");
/* 2194 */         emit(" */");
/* 2195 */         emit("@Deprecated");
/*      */       } else {
/*      */         
/* 2198 */         printJavaDoc("Gets array of all " + str1 + "s");
/* 2199 */       }  emit("public " + paramString3 + "[] get" + str + "()");
/* 2200 */       startBlock();
/* 2201 */       emitImplementationPreamble();
/*      */       
/* 2203 */       if (this._useJava15) {
/* 2204 */         emit("java.util.List<" + paramString4 + "> targetList = new java.util.ArrayList<" + paramString4 + ">();");
/*      */       } else {
/* 2206 */         emit("java.util.List targetList = new java.util.ArrayList();");
/* 2207 */       }  emit("get_store().find_all_element_users(" + paramString6 + ", targetList);");
/*      */       
/* 2209 */       printJGetArrayValue(paramInt, paramString3, (SchemaTypeImpl)paramSchemaProperty.getType());
/*      */       
/* 2211 */       emitImplementationPostamble();
/* 2212 */       endBlock();
/*      */ 
/*      */       
/* 2215 */       printJavaDoc("Gets ith " + str1);
/* 2216 */       emit("public " + paramString3 + " get" + str + "(int i)");
/* 2217 */       startBlock();
/* 2218 */       emitImplementationPreamble();
/*      */       
/* 2220 */       emitGetTarget(paramString6, paramString5, paramBoolean1, "i", 4, str2);
/* 2221 */       printJGetValue(paramInt, paramString3, (SchemaTypeImpl)paramSchemaProperty.getType());
/*      */       
/* 2223 */       emitImplementationPostamble();
/* 2224 */       endBlock();
/*      */       
/* 2226 */       if (!bool) {
/*      */         
/* 2228 */         if (this._useJava15)
/*      */         {
/* 2230 */           printListGetter15Impl(paramString1, str1, paramString2, paramString4, paramString4, bool, true);
/*      */         }
/*      */ 
/*      */         
/* 2234 */         if (this._useJava15) {
/*      */           
/* 2236 */           emit("");
/* 2237 */           emit("/**");
/* 2238 */           emit(" * Gets array of all " + str1 + "s");
/* 2239 */           emit(" * @deprecated");
/* 2240 */           emit(" */");
/* 2241 */           emit("@Deprecated");
/*      */         } else {
/*      */           
/* 2244 */           printJavaDoc("Gets (as xml) array of all " + str1 + "s");
/* 2245 */         }  emit("public " + paramString4 + "[] xget" + str + "()");
/* 2246 */         startBlock();
/* 2247 */         emitImplementationPreamble();
/* 2248 */         if (this._useJava15) {
/* 2249 */           emit("java.util.List<" + paramString4 + "> targetList = new java.util.ArrayList<" + paramString4 + ">();");
/*      */         } else {
/* 2251 */           emit("java.util.List targetList = new java.util.ArrayList();");
/* 2252 */         }  emit("get_store().find_all_element_users(" + paramString6 + ", targetList);");
/* 2253 */         emit(paramString4 + "[] result = new " + paramString4 + "[targetList.size()];");
/* 2254 */         emit("targetList.toArray(result);");
/* 2255 */         emit("return result;");
/* 2256 */         emitImplementationPostamble();
/* 2257 */         endBlock();
/*      */ 
/*      */         
/* 2260 */         printJavaDoc("Gets (as xml) ith " + str1);
/* 2261 */         emit("public " + paramString4 + " xget" + str + "(int i)");
/* 2262 */         startBlock();
/* 2263 */         emitImplementationPreamble();
/* 2264 */         emitGetTarget(paramString6, paramString5, paramBoolean1, "i", 4, paramString4);
/* 2265 */         emit("return target;");
/* 2266 */         emitImplementationPostamble();
/* 2267 */         endBlock();
/*      */       } 
/*      */ 
/*      */       
/* 2271 */       if (paramBoolean2) {
/*      */ 
/*      */         
/* 2274 */         printJavaDoc("Tests for nil ith " + str1);
/* 2275 */         emit("public boolean isNil" + str + "(int i)");
/* 2276 */         startBlock();
/* 2277 */         emitImplementationPreamble();
/* 2278 */         emitGetTarget(paramString6, paramString5, paramBoolean1, "i", 4, paramString4);
/* 2279 */         emit("return target.isNil();");
/* 2280 */         emitImplementationPostamble();
/* 2281 */         endBlock();
/*      */       } 
/*      */ 
/*      */       
/* 2285 */       printJavaDoc("Returns number of " + str1);
/* 2286 */       emit("public int sizeOf" + str + "()");
/* 2287 */       startBlock();
/* 2288 */       emitImplementationPreamble();
/* 2289 */       emit("return get_store().count_elements(" + paramString6 + ");");
/* 2290 */       emitImplementationPostamble();
/* 2291 */       endBlock();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void printSetterImpls(b paramb, SchemaProperty paramSchemaProperty, boolean paramBoolean1, String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, String paramString4, String paramString5, SchemaType paramSchemaType) throws IOException {
/* 2301 */     String str1 = NameUtil.nonJavaKeyword(NameUtil.lowerCamelCase(paramString1));
/* 2302 */     str1 = NameUtil.nonExtraKeyword(str1);
/*      */     
/* 2304 */     boolean bool1 = (paramInt == 0) ? true : false;
/* 2305 */     boolean bool2 = (paramInt == 19) ? true : false;
/* 2306 */     boolean bool3 = (paramString4 != paramString5) ? true : false;
/* 2307 */     String str2 = (paramBoolean6 || !bool1) ? "org.apache.xmlbeans.SimpleValue" : paramString3;
/*      */     
/* 2309 */     String str3 = "\"" + paramb.dT() + "\"" + (paramBoolean1 ? " attribute" : " element");
/*      */     
/* 2311 */     if (paramBoolean5) {
/*      */ 
/*      */       
/* 2314 */       printJavaDoc((paramBoolean4 ? "Sets first " : "Sets the ") + str3);
/* 2315 */       emit("public void set" + paramString1 + "(" + paramString2 + " " + str1 + ")");
/* 2316 */       startBlock();
/* 2317 */       if (bool1 && !bool3) {
/*      */         
/* 2319 */         emitPre(paramSchemaType, 1, paramString4, paramBoolean1, paramBoolean4 ? "0" : "-1");
/* 2320 */         emit("generatedSetterHelperImpl(" + str1 + ", " + paramString5 + ", 0, " + "org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);");
/*      */         
/* 2322 */         emitPost(paramSchemaType, 1, paramString4, paramBoolean1, paramBoolean4 ? "0" : "-1");
/*      */       }
/*      */       else {
/*      */         
/* 2326 */         emitImplementationPreamble();
/* 2327 */         emitPre(paramSchemaType, 1, paramString4, paramBoolean1, paramBoolean4 ? "0" : "-1");
/* 2328 */         emitGetTarget(paramString5, paramString4, paramBoolean1, "0", 3, str2);
/* 2329 */         printJSetValue(paramInt, str1, (SchemaTypeImpl)paramSchemaProperty.getType());
/* 2330 */         emitPost(paramSchemaType, 1, paramString4, paramBoolean1, paramBoolean4 ? "0" : "-1");
/* 2331 */         emitImplementationPostamble();
/*      */       } 
/* 2333 */       endBlock();
/*      */       
/* 2335 */       if (!bool1) {
/*      */ 
/*      */         
/* 2338 */         printJavaDoc((paramBoolean4 ? "Sets (as xml) first " : "Sets (as xml) the ") + str3);
/* 2339 */         emit("public void xset" + paramString1 + "(" + paramString3 + " " + str1 + ")");
/* 2340 */         startBlock();
/* 2341 */         emitImplementationPreamble();
/* 2342 */         emitPre(paramSchemaType, 1, paramString4, paramBoolean1, paramBoolean4 ? "0" : "-1");
/* 2343 */         emitGetTarget(paramString5, paramString4, paramBoolean1, "0", 3, paramString3);
/* 2344 */         emit("target.set(" + str1 + ");");
/* 2345 */         emitPost(paramSchemaType, 1, paramString4, paramBoolean1, paramBoolean4 ? "0" : "-1");
/* 2346 */         emitImplementationPostamble();
/* 2347 */         endBlock();
/*      */       } 
/*      */ 
/*      */       
/* 2351 */       if (bool1 && !paramBoolean4) {
/*      */ 
/*      */         
/* 2354 */         printJavaDoc("Appends and returns a new empty " + str3);
/* 2355 */         emit("public " + paramString3 + " addNew" + paramString1 + "()");
/* 2356 */         startBlock();
/* 2357 */         emitImplementationPreamble();
/* 2358 */         emitDeclareTarget(true, paramString3);
/* 2359 */         emitPre(paramSchemaType, 2, paramString4, paramBoolean1);
/* 2360 */         emitAddTarget(paramString4, paramBoolean1, true, paramString3);
/* 2361 */         emitPost(paramSchemaType, 2, paramString4, paramBoolean1);
/* 2362 */         emit("return target;");
/* 2363 */         emitImplementationPostamble();
/* 2364 */         endBlock();
/*      */       } 
/*      */       
/* 2367 */       if (paramBoolean2) {
/*      */         
/* 2369 */         printJavaDoc((paramBoolean4 ? "Nils the first " : "Nils the ") + str3);
/* 2370 */         emit("public void setNil" + paramString1 + "()");
/* 2371 */         startBlock();
/* 2372 */         emitImplementationPreamble();
/* 2373 */         emitPre(paramSchemaType, 1, paramString4, paramBoolean1, paramBoolean4 ? "0" : "-1");
/* 2374 */         emitGetTarget(paramString5, paramString4, paramBoolean1, "0", 3, paramString3);
/* 2375 */         emit("target.setNil();");
/* 2376 */         emitPost(paramSchemaType, 1, paramString4, paramBoolean1, paramBoolean4 ? "0" : "-1");
/* 2377 */         emitImplementationPostamble();
/* 2378 */         endBlock();
/*      */       } 
/*      */     } 
/*      */     
/* 2382 */     if (paramBoolean3) {
/*      */       
/* 2384 */       printJavaDoc((paramBoolean4 ? "Removes first " : "Unsets the ") + str3);
/* 2385 */       emit("public void unset" + paramString1 + "()");
/* 2386 */       startBlock();
/* 2387 */       emitImplementationPreamble();
/* 2388 */       emitPre(paramSchemaType, 3, paramString4, paramBoolean1, paramBoolean4 ? "0" : "-1");
/* 2389 */       if (paramBoolean1) {
/* 2390 */         emit("get_store().remove_attribute(" + paramString4 + ");");
/*      */       } else {
/* 2392 */         emit("get_store().remove_element(" + paramString5 + ", 0);");
/* 2393 */       }  emitPost(paramSchemaType, 3, paramString4, paramBoolean1, paramBoolean4 ? "0" : "-1");
/* 2394 */       emitImplementationPostamble();
/* 2395 */       endBlock();
/*      */     } 
/*      */     
/* 2398 */     if (paramBoolean4) {
/*      */       
/* 2400 */       String str = paramString1 + "Array";
/*      */       
/* 2402 */       if (bool1) {
/*      */         
/* 2404 */         printJavaDoc("Sets array of all " + str3 + "  WARNING: This method is not atomicaly synchronized.");
/* 2405 */         emit("public void set" + str + "(" + paramString2 + "[] " + str1 + "Array)");
/* 2406 */         startBlock();
/*      */ 
/*      */         
/* 2409 */         emit("check_orphaned();");
/* 2410 */         emitPre(paramSchemaType, 1, paramString4, paramBoolean1);
/*      */         
/* 2412 */         if (bool2) {
/*      */           
/* 2414 */           if (!bool3) {
/* 2415 */             emit("unionArraySetterHelper(" + str1 + "Array" + ", " + paramString4 + ");");
/*      */           } else {
/* 2417 */             emit("unionArraySetterHelper(" + str1 + "Array" + ", " + paramString4 + ", " + paramString5 + ");");
/*      */           }
/*      */         
/*      */         }
/* 2421 */         else if (!bool3) {
/* 2422 */           emit("arraySetterHelper(" + str1 + "Array" + ", " + paramString4 + ");");
/*      */         } else {
/* 2424 */           emit("arraySetterHelper(" + str1 + "Array" + ", " + paramString4 + ", " + paramString5 + ");");
/*      */         } 
/*      */         
/* 2427 */         emitPost(paramSchemaType, 1, paramString4, paramBoolean1);
/*      */         
/* 2429 */         endBlock();
/*      */       }
/*      */       else {
/*      */         
/* 2433 */         printJavaDoc("Sets array of all " + str3);
/* 2434 */         emit("public void set" + str + "(" + paramString2 + "[] " + str1 + "Array)");
/* 2435 */         startBlock();
/* 2436 */         emitImplementationPreamble();
/* 2437 */         emitPre(paramSchemaType, 1, paramString4, paramBoolean1);
/*      */         
/* 2439 */         if (bool2) {
/*      */           
/* 2441 */           if (!bool3) {
/* 2442 */             emit("unionArraySetterHelper(" + str1 + "Array" + ", " + paramString4 + ");");
/*      */           } else {
/* 2444 */             emit("unionArraySetterHelper(" + str1 + "Array" + ", " + paramString4 + ", " + paramString5 + ");");
/*      */           } 
/* 2446 */         } else if (paramSchemaProperty.getJavaTypeCode() == 20) {
/*      */           
/* 2448 */           if (!bool3)
/*      */           {
/* 2450 */             emit("org.apache.xmlbeans.SimpleValue[] dests = arraySetterHelper(" + str1 + "Array.length" + ", " + paramString4 + ");");
/* 2451 */             emit("for ( int i = 0 ; i < dests.length ; i++ ) {");
/* 2452 */             emit("    " + getUserTypeStaticHandlerMethod(true, (SchemaTypeImpl)paramSchemaProperty.getType()) + "(" + str1 + "Array[i], dests[i]);");
/*      */             
/* 2454 */             emit("}");
/*      */           }
/*      */           else
/*      */           {
/* 2458 */             emit("org.apache.xmlbeans.SimpleValue[] dests = arraySetterHelper(" + str1 + "Array.length" + ", " + paramString4 + ", " + paramString5 + ");");
/* 2459 */             emit("for ( int i = 0 ; i < dests.length ; i++ ) {");
/* 2460 */             emit("    " + getUserTypeStaticHandlerMethod(true, (SchemaTypeImpl)paramSchemaProperty.getType()) + "(" + str1 + "Array[i], dests[i]);");
/*      */             
/* 2462 */             emit("}");
/*      */           
/*      */           }
/*      */         
/*      */         }
/* 2467 */         else if (!bool3) {
/* 2468 */           emit("arraySetterHelper(" + str1 + "Array" + ", " + paramString4 + ");");
/*      */         } else {
/* 2470 */           emit("arraySetterHelper(" + str1 + "Array" + ", " + paramString4 + ", " + paramString5 + ");");
/*      */         } 
/*      */         
/* 2473 */         emitPost(paramSchemaType, 1, paramString4, paramBoolean1);
/* 2474 */         emitImplementationPostamble();
/* 2475 */         endBlock();
/*      */       } 
/*      */       
/* 2478 */       printJavaDoc("Sets ith " + str3);
/* 2479 */       emit("public void set" + str + "(int i, " + paramString2 + " " + str1 + ")");
/* 2480 */       startBlock();
/* 2481 */       if (bool1 && !bool3) {
/*      */         
/* 2483 */         emitPre(paramSchemaType, 1, paramString4, paramBoolean1, "i");
/* 2484 */         emit("generatedSetterHelperImpl(" + str1 + ", " + paramString5 + ", i, " + "org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_ARRAYITEM);");
/*      */         
/* 2486 */         emitPost(paramSchemaType, 1, paramString4, paramBoolean1, "i");
/*      */       }
/*      */       else {
/*      */         
/* 2490 */         emitImplementationPreamble();
/* 2491 */         emitPre(paramSchemaType, 1, paramString4, paramBoolean1, "i");
/* 2492 */         emitGetTarget(paramString5, paramString4, paramBoolean1, "i", 4, str2);
/* 2493 */         printJSetValue(paramInt, str1, (SchemaTypeImpl)paramSchemaProperty.getType());
/* 2494 */         emitPost(paramSchemaType, 1, paramString4, paramBoolean1, "i");
/* 2495 */         emitImplementationPostamble();
/*      */       } 
/* 2497 */       endBlock();
/*      */       
/* 2499 */       if (!bool1) {
/*      */         
/* 2501 */         printJavaDoc("Sets (as xml) array of all " + str3);
/* 2502 */         emit("public void xset" + str + "(" + paramString3 + "[]" + str1 + "Array)");
/* 2503 */         startBlock();
/* 2504 */         emitImplementationPreamble();
/* 2505 */         emitPre(paramSchemaType, 1, paramString4, paramBoolean1);
/* 2506 */         emit("arraySetterHelper(" + str1 + "Array" + ", " + paramString4 + ");");
/* 2507 */         emitPost(paramSchemaType, 1, paramString4, paramBoolean1);
/* 2508 */         emitImplementationPostamble();
/* 2509 */         endBlock();
/*      */         
/* 2511 */         printJavaDoc("Sets (as xml) ith " + str3);
/* 2512 */         emit("public void xset" + str + "(int i, " + paramString3 + " " + str1 + ")");
/* 2513 */         startBlock();
/* 2514 */         emitImplementationPreamble();
/* 2515 */         emitPre(paramSchemaType, 1, paramString4, paramBoolean1, "i");
/* 2516 */         emitGetTarget(paramString5, paramString4, paramBoolean1, "i", 4, paramString3);
/* 2517 */         emit("target.set(" + str1 + ");");
/* 2518 */         emitPost(paramSchemaType, 1, paramString4, paramBoolean1, "i");
/* 2519 */         emitImplementationPostamble();
/* 2520 */         endBlock();
/*      */       } 
/*      */       
/* 2523 */       if (paramBoolean2) {
/*      */         
/* 2525 */         printJavaDoc("Nils the ith " + str3);
/* 2526 */         emit("public void setNil" + str + "(int i)");
/* 2527 */         startBlock();
/* 2528 */         emitImplementationPreamble();
/* 2529 */         emitPre(paramSchemaType, 1, paramString4, paramBoolean1, "i");
/* 2530 */         emitGetTarget(paramString5, paramString4, paramBoolean1, "i", 4, paramString3);
/* 2531 */         emit("target.setNil();");
/* 2532 */         emitPost(paramSchemaType, 1, paramString4, paramBoolean1, "i");
/* 2533 */         emitImplementationPostamble();
/* 2534 */         endBlock();
/*      */       } 
/*      */       
/* 2537 */       if (!bool1) {
/*      */         
/* 2539 */         printJavaDoc("Inserts the value as the ith " + str3);
/* 2540 */         emit("public void insert" + paramString1 + "(int i, " + paramString2 + " " + str1 + ")");
/* 2541 */         startBlock();
/* 2542 */         emitImplementationPreamble();
/* 2543 */         emitPre(paramSchemaType, 2, paramString4, paramBoolean1, "i");
/* 2544 */         emit(str2 + " target = ");
/* 2545 */         indent();
/* 2546 */         if (!bool3) {
/* 2547 */           emit("(" + str2 + ")get_store().insert_element_user(" + paramString4 + ", i);");
/*      */         } else {
/* 2549 */           emit("(" + str2 + ")get_store().insert_element_user(" + paramString5 + ", " + paramString4 + ", i);");
/*      */         } 
/* 2551 */         outdent();
/* 2552 */         printJSetValue(paramInt, str1, (SchemaTypeImpl)paramSchemaProperty.getType());
/* 2553 */         emitPost(paramSchemaType, 2, paramString4, paramBoolean1, "i");
/* 2554 */         emitImplementationPostamble();
/* 2555 */         endBlock();
/*      */         
/* 2557 */         printJavaDoc("Appends the value as the last " + str3);
/* 2558 */         emit("public void add" + paramString1 + "(" + paramString2 + " " + str1 + ")");
/* 2559 */         startBlock();
/* 2560 */         emitImplementationPreamble();
/* 2561 */         emitDeclareTarget(true, str2);
/* 2562 */         emitPre(paramSchemaType, 2, paramString4, paramBoolean1);
/* 2563 */         emitAddTarget(paramString4, paramBoolean1, true, str2);
/* 2564 */         printJSetValue(paramInt, str1, (SchemaTypeImpl)paramSchemaProperty.getType());
/* 2565 */         emitPost(paramSchemaType, 2, paramString4, paramBoolean1);
/* 2566 */         emitImplementationPostamble();
/* 2567 */         endBlock();
/*      */       } 
/*      */       
/* 2570 */       printJavaDoc("Inserts and returns a new empty value (as xml) as the ith " + str3);
/* 2571 */       emit("public " + paramString3 + " insertNew" + paramString1 + "(int i)");
/* 2572 */       startBlock();
/* 2573 */       emitImplementationPreamble();
/* 2574 */       emitDeclareTarget(true, paramString3);
/* 2575 */       emitPre(paramSchemaType, 2, paramString4, paramBoolean1, "i");
/* 2576 */       if (!bool3) {
/*      */         
/* 2578 */         emit("target = (" + paramString3 + ")get_store().insert_element_user(" + paramString4 + ", i);");
/*      */       }
/*      */       else {
/*      */         
/* 2582 */         emit("target = (" + paramString3 + ")get_store().insert_element_user(" + paramString5 + ", " + paramString4 + ", i);");
/*      */       } 
/*      */       
/* 2585 */       emitPost(paramSchemaType, 2, paramString4, paramBoolean1, "i");
/* 2586 */       emit("return target;");
/* 2587 */       emitImplementationPostamble();
/* 2588 */       endBlock();
/*      */       
/* 2590 */       printJavaDoc("Appends and returns a new empty value (as xml) as the last " + str3);
/* 2591 */       emit("public " + paramString3 + " addNew" + paramString1 + "()");
/* 2592 */       startBlock();
/* 2593 */       emitImplementationPreamble();
/* 2594 */       emitDeclareTarget(true, paramString3);
/* 2595 */       emitPre(paramSchemaType, 2, paramString4, paramBoolean1);
/* 2596 */       emitAddTarget(paramString4, paramBoolean1, true, paramString3);
/* 2597 */       emitPost(paramSchemaType, 2, paramString4, paramBoolean1);
/* 2598 */       emit("return target;");
/* 2599 */       emitImplementationPostamble();
/* 2600 */       endBlock();
/*      */       
/* 2602 */       printJavaDoc("Removes the ith " + str3);
/* 2603 */       emit("public void remove" + paramString1 + "(int i)");
/* 2604 */       startBlock();
/* 2605 */       emitImplementationPreamble();
/* 2606 */       emitPre(paramSchemaType, 3, paramString4, paramBoolean1, "i");
/* 2607 */       emit("get_store().remove_element(" + paramString5 + ", i);");
/* 2608 */       emitPost(paramSchemaType, 3, paramString4, paramBoolean1, "i");
/* 2609 */       emitImplementationPostamble();
/* 2610 */       endBlock();
/*      */     } 
/*      */   }
/*      */   
/*      */   static void getTypeName(Class paramClass, StringBuffer paramStringBuffer) {
/* 2615 */     byte b1 = 0;
/* 2616 */     while (paramClass.isArray()) {
/* 2617 */       paramClass = paramClass.getComponentType();
/* 2618 */       b1++;
/*      */     } 
/*      */     
/* 2621 */     paramStringBuffer.append(paramClass.getName());
/*      */     
/* 2623 */     for (byte b2 = 0; b2 < b1; b2++) {
/* 2624 */       paramStringBuffer.append("[]");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void printInnerTypeImpl(SchemaType paramSchemaType, SchemaTypeSystem paramSchemaTypeSystem, boolean paramBoolean) throws IOException {
/* 2631 */     String str = paramSchemaType.getShortJavaImplName();
/*      */     
/* 2633 */     printInnerTypeJavaDoc(paramSchemaType);
/*      */     
/* 2635 */     startClass(paramSchemaType, paramBoolean);
/*      */     
/* 2637 */     printConstructor(paramSchemaType, str);
/*      */     
/* 2639 */     printExtensionImplMethods(paramSchemaType);
/*      */     
/* 2641 */     if (!paramSchemaType.isSimpleType()) {
/*      */       SchemaProperty[] arrayOfSchemaProperty;
/*      */ 
/*      */       
/* 2645 */       if (paramSchemaType.getContentType() == 2) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2654 */         SchemaType schemaType = paramSchemaType.getBaseType();
/* 2655 */         ArrayList arrayList = null;
/* 2656 */         while (!schemaType.isSimpleType() && !schemaType.isBuiltinType()) {
/*      */           
/* 2658 */           SchemaProperty[] arrayOfSchemaProperty1 = schemaType.getDerivedProperties();
/* 2659 */           for (byte b1 = 0; b1 < arrayOfSchemaProperty1.length; b1++) {
/* 2660 */             if (!arrayOfSchemaProperty1[b1].isAttribute() || paramSchemaType.getAttributeProperty(arrayOfSchemaProperty1[b1].getName()) == null) {
/*      */ 
/*      */               
/* 2663 */               if (arrayList == null)
/* 2664 */                 arrayList = new ArrayList(); 
/* 2665 */               arrayList.add(arrayOfSchemaProperty1[b1]);
/*      */             } 
/* 2667 */           }  schemaType = schemaType.getBaseType();
/*      */         } 
/*      */         
/* 2670 */         arrayOfSchemaProperty = paramSchemaType.getProperties();
/* 2671 */         if (arrayList != null)
/*      */         {
/* 2673 */           for (byte b1 = 0; b1 < arrayOfSchemaProperty.length; b1++)
/* 2674 */             arrayList.add(arrayOfSchemaProperty[b1]); 
/* 2675 */           arrayOfSchemaProperty = arrayList.<SchemaProperty>toArray(new SchemaProperty[arrayList.size()]);
/*      */         
/*      */         }
/*      */ 
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */         
/* 2684 */         arrayOfSchemaProperty = getDerivedProperties(paramSchemaType);
/*      */       } 
/*      */       
/* 2687 */       Map map = printStaticFields(arrayOfSchemaProperty);
/*      */       
/* 2689 */       for (byte b = 0; b < arrayOfSchemaProperty.length; b++) {
/*      */         
/* 2691 */         SchemaProperty schemaProperty = arrayOfSchemaProperty[b];
/*      */         
/* 2693 */         b b1 = schemaProperty.getName();
/* 2694 */         String str1 = xmlTypeForProperty(schemaProperty);
/*      */         
/* 2696 */         printGetterImpls(str, schemaProperty, b1, schemaProperty.isAttribute(), schemaProperty.getJavaPropertyName(), schemaProperty.getJavaTypeCode(), javaTypeForProperty(schemaProperty), str1, (schemaProperty.hasNillable() != 0), schemaProperty.extendsJavaOption(), schemaProperty.extendsJavaArray(), schemaProperty.extendsJavaSingleton(), xmlTypeForPropertyIsUnion(schemaProperty), getIdentifier(map, b1), getSetIdentifier(map, b1));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2714 */         if (!schemaProperty.isReadOnly())
/*      */         {
/* 2716 */           printSetterImpls(b1, schemaProperty, schemaProperty.isAttribute(), schemaProperty.getJavaPropertyName(), schemaProperty.getJavaTypeCode(), javaTypeForProperty(schemaProperty), str1, (schemaProperty.hasNillable() != 0), schemaProperty.extendsJavaOption(), schemaProperty.extendsJavaArray(), schemaProperty.extendsJavaSingleton(), xmlTypeForPropertyIsUnion(schemaProperty), getIdentifier(map, b1), getSetIdentifier(map, b1), paramSchemaType);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2737 */     printNestedTypeImpls(paramSchemaType, paramSchemaTypeSystem);
/*      */     
/* 2739 */     endBlock();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private SchemaProperty[] getDerivedProperties(SchemaType paramSchemaType) {
/* 2746 */     b b = paramSchemaType.getName();
/* 2747 */     if (b != null && b.equals(paramSchemaType.getBaseType().getName())) {
/*      */       
/* 2749 */       SchemaType schemaType = paramSchemaType.getBaseType();
/*      */ 
/*      */ 
/*      */       
/* 2753 */       SchemaProperty[] arrayOfSchemaProperty = paramSchemaType.getDerivedProperties();
/* 2754 */       LinkedHashMap linkedHashMap = new LinkedHashMap(); byte b1;
/* 2755 */       for (b1 = 0; b1 < arrayOfSchemaProperty.length; b1++)
/* 2756 */         linkedHashMap.put(arrayOfSchemaProperty[b1].getName(), arrayOfSchemaProperty[b1]); 
/* 2757 */       while (schemaType != null && b.equals(schemaType.getName())) {
/*      */         
/* 2759 */         arrayOfSchemaProperty = schemaType.getDerivedProperties();
/* 2760 */         for (b1 = 0; b1 < arrayOfSchemaProperty.length; b1++) {
/* 2761 */           if (!linkedHashMap.containsKey(arrayOfSchemaProperty[b1].getName()))
/* 2762 */             linkedHashMap.put(arrayOfSchemaProperty[b1].getName(), arrayOfSchemaProperty[b1]); 
/* 2763 */         }  schemaType = schemaType.getBaseType();
/*      */       } 
/* 2765 */       return (SchemaProperty[])linkedHashMap.values().toArray((Object[])new SchemaProperty[0]);
/*      */     } 
/*      */     
/* 2768 */     return paramSchemaType.getDerivedProperties();
/*      */   }
/*      */ 
/*      */   
/*      */   private void printExtensionImplMethods(SchemaType paramSchemaType) throws IOException {
/* 2773 */     SchemaTypeImpl schemaTypeImpl = getImpl(paramSchemaType);
/* 2774 */     if (schemaTypeImpl == null) {
/*      */       return;
/*      */     }
/* 2777 */     InterfaceExtension[] arrayOfInterfaceExtension = schemaTypeImpl.getInterfaceExtensions();
/* 2778 */     if (arrayOfInterfaceExtension != null) for (byte b = 0; b < arrayOfInterfaceExtension.length; b++) {
/*      */         
/* 2780 */         InterfaceExtension.MethodSignature[] arrayOfMethodSignature = arrayOfInterfaceExtension[b].getMethods();
/* 2781 */         if (arrayOfMethodSignature != null)
/*      */         {
/* 2783 */           for (byte b1 = 0; b1 < arrayOfMethodSignature.length; b1++) {
/*      */             
/* 2785 */             printJavaDoc("Implementation method for interface " + arrayOfInterfaceExtension[b].getStaticHandler());
/* 2786 */             printInterfaceMethodDecl(arrayOfMethodSignature[b1]);
/* 2787 */             startBlock();
/* 2788 */             printInterfaceMethodImpl(arrayOfInterfaceExtension[b].getStaticHandler(), arrayOfMethodSignature[b1]);
/* 2789 */             endBlock();
/*      */           } 
/*      */         }
/*      */       } 
/*      */   
/*      */   }
/*      */   
/*      */   void printInterfaceMethodDecl(InterfaceExtension.MethodSignature paramMethodSignature) throws IOException {
/* 2797 */     StringBuffer stringBuffer = new StringBuffer(60);
/*      */     
/* 2799 */     stringBuffer.append("public ").append(paramMethodSignature.getReturnType());
/* 2800 */     stringBuffer.append(" ").append(paramMethodSignature.getName()).append("(");
/*      */     
/* 2802 */     String[] arrayOfString1 = paramMethodSignature.getParameterTypes();
/* 2803 */     for (byte b1 = 0; b1 < arrayOfString1.length; b1++) {
/*      */       
/* 2805 */       if (b1 != 0)
/* 2806 */         stringBuffer.append(", "); 
/* 2807 */       stringBuffer.append(arrayOfString1[b1]).append(" p").append(b1);
/*      */     } 
/*      */     
/* 2810 */     stringBuffer.append(")");
/*      */     
/* 2812 */     String[] arrayOfString2 = paramMethodSignature.getExceptionTypes();
/* 2813 */     for (byte b2 = 0; b2 < arrayOfString2.length; b2++) {
/* 2814 */       stringBuffer.append(((b2 == 0) ? " throws " : ", ") + arrayOfString2[b2]);
/*      */     }
/* 2816 */     emit(stringBuffer.toString());
/*      */   }
/*      */ 
/*      */   
/*      */   void printInterfaceMethodImpl(String paramString, InterfaceExtension.MethodSignature paramMethodSignature) throws IOException {
/* 2821 */     StringBuffer stringBuffer = new StringBuffer(60);
/*      */     
/* 2823 */     if (!paramMethodSignature.getReturnType().equals("void")) {
/* 2824 */       stringBuffer.append("return ");
/*      */     }
/* 2826 */     stringBuffer.append(paramString).append(".").append(paramMethodSignature.getName()).append("(this");
/*      */     
/* 2828 */     String[] arrayOfString = paramMethodSignature.getParameterTypes();
/* 2829 */     for (byte b = 0; b < arrayOfString.length; b++) {
/* 2830 */       stringBuffer.append(", p" + b);
/*      */     }
/* 2832 */     stringBuffer.append(");");
/*      */     
/* 2834 */     emit(stringBuffer.toString());
/*      */   }
/*      */ 
/*      */   
/*      */   void printNestedTypeImpls(SchemaType paramSchemaType, SchemaTypeSystem paramSchemaTypeSystem) throws IOException {
/* 2839 */     boolean bool = (paramSchemaType.getName() != null && paramSchemaType.getName().equals(paramSchemaType.getBaseType().getName())) ? true : false;
/*      */     
/* 2841 */     while (paramSchemaType != null) {
/*      */       
/* 2843 */       SchemaType[] arrayOfSchemaType = paramSchemaType.getAnonymousTypes();
/* 2844 */       for (byte b = 0; b < arrayOfSchemaType.length; b++) {
/*      */         
/* 2846 */         if (arrayOfSchemaType[b].isSkippedAnonymousType()) {
/* 2847 */           printNestedTypeImpls(arrayOfSchemaType[b], paramSchemaTypeSystem);
/*      */         } else {
/* 2849 */           printInnerTypeImpl(arrayOfSchemaType[b], paramSchemaTypeSystem, true);
/*      */         } 
/*      */       } 
/*      */       
/* 2853 */       if (!bool || (paramSchemaType.getDerivationType() != 2 && !paramSchemaType.isSimpleType())) {
/*      */         break;
/*      */       }
/* 2856 */       paramSchemaType = paramSchemaType.getBaseType();
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\SchemaTypeCodePrinter.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */