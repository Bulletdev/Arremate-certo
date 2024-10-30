/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.xml.namespace.b;
/*     */ import org.xml.sax.EntityResolver;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XmlOptionsBean
/*     */   extends XmlOptions
/*     */ {
/*     */   public XmlOptionsBean() {}
/*     */   
/*     */   public XmlOptionsBean(XmlOptions paramXmlOptions) {
/*  25 */     super(paramXmlOptions);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSaveNamespacesFirst(boolean paramBoolean) {
/*  31 */     if (paramBoolean) {
/*  32 */       setSaveNamespacesFirst();
/*     */     } else {
/*  34 */       remove("SAVE_NAMESPACES_FIRST");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isSaveNamespacesFirst() {
/*  39 */     return hasOption("SAVE_NAMESPACES_FIRST");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSavePrettyPrint(boolean paramBoolean) {
/*  44 */     if (paramBoolean) {
/*  45 */       setSavePrettyPrint();
/*     */     } else {
/*  47 */       remove("SAVE_PRETTY_PRINT");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isSavePrettyPrint() {
/*  52 */     return hasOption("SAVE_PRETTY_PRINT");
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getSavePrettyPrintIndent() {
/*  57 */     return (Integer)get("SAVE_PRETTY_PRINT_INDENT");
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getSavePrettyPrintOffset() {
/*  62 */     return (Integer)get("SAVE_PRETTY_PRINT_OFFSET");
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCharacterEncoding() {
/*  67 */     return (String)get("CHARACTER_ENCODING");
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaType getDocumentType() {
/*  72 */     return (SchemaType)get("DOCUMENT_TYPE");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSaveAggressiveNamespaces(boolean paramBoolean) {
/*  77 */     if (paramBoolean) {
/*  78 */       setSaveAggressiveNamespaces();
/*     */     } else {
/*  80 */       remove("SAVE_AGGRESSIVE_NAMESPACES");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isSaveAggressiveNamespaces() {
/*  85 */     return hasOption("SAVE_AGGRESSIVE_NAMESPACES");
/*     */   }
/*     */ 
/*     */   
/*     */   public b getSaveSyntheticDocumentElement() {
/*  90 */     return (b)get("SAVE_SYNTHETIC_DOCUMENT_ELEMENT");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUseDefaultNamespace(boolean paramBoolean) {
/*  95 */     if (paramBoolean) {
/*  96 */       setUseDefaultNamespace();
/*     */     } else {
/*  98 */       remove("SAVE_USE_DEFAULT_NAMESPACE");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isUseDefaultNamespace() {
/* 103 */     return hasOption("SAVE_USE_DEFAULT_NAMESPACE");
/*     */   }
/*     */ 
/*     */   
/*     */   public Map getSaveImplicitNamespaces() {
/* 108 */     return (Map)get("SAVE_IMPLICIT_NAMESPACES");
/*     */   }
/*     */ 
/*     */   
/*     */   public Map getSaveSuggestedPrefixes() {
/* 113 */     return (Map)get("SAVE_SUGGESTED_PREFIXES");
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSaveFilterProcinst() {
/* 118 */     return (String)get("SAVE_FILTER_PROCINST");
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlOptionCharEscapeMap getSaveSubstituteCharacters() {
/* 123 */     return (XmlOptionCharEscapeMap)get("SAVE_SUBSTITUTE_CHARACTERS");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSaveUseOpenFrag(boolean paramBoolean) {
/* 128 */     if (paramBoolean) {
/* 129 */       setSaveUseOpenFrag();
/*     */     } else {
/* 131 */       remove("SAVE_USE_OPEN_FRAGMENT");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isSaveUseOpenFrag() {
/* 136 */     return hasOption("SAVE_USE_OPEN_FRAGMENT");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSaveOuter(boolean paramBoolean) {
/* 141 */     if (paramBoolean) {
/* 142 */       setSaveOuter();
/*     */     } else {
/* 144 */       remove("SAVE_OUTER");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isSaveOuter() {
/* 149 */     return hasOption("SAVE_OUTER");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSaveInner(boolean paramBoolean) {
/* 154 */     if (paramBoolean) {
/* 155 */       setSaveInner();
/*     */     } else {
/* 157 */       remove("SAVE_INNER");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isSaveInner() {
/* 162 */     return hasOption("SAVE_INNER");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSaveNoXmlDecl(boolean paramBoolean) {
/* 167 */     if (paramBoolean) {
/* 168 */       setSaveNoXmlDecl();
/*     */     } else {
/* 170 */       remove("SAVE_NO_XML_DECL");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isSaveNoXmlDecl() {
/* 175 */     return hasOption("SAVE_NO_XML_DECL");
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getSaveCDataLengthThreshold() {
/* 180 */     return (Integer)get("SAVE_CDATA_LENGTH_THRESHOLD");
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getSaveCDataEntityCountThreshold() {
/* 185 */     return (Integer)get("SAVE_CDATA_ENTITY_COUNT_THRESHOLD");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSaveSaxNoNSDeclsInAttributes(boolean paramBoolean) {
/* 190 */     if (paramBoolean) {
/* 191 */       setSaveSaxNoNSDeclsInAttributes();
/*     */     } else {
/* 193 */       remove("SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isSaveSaxNoNSDeclsInAttributes() {
/* 198 */     return hasOption("SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES");
/*     */   }
/*     */ 
/*     */   
/*     */   public b getLoadReplaceDocumentElement() {
/* 203 */     return (b)get("LOAD_REPLACE_DOCUMENT_ELEMENT");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLoadStripWhitespace(boolean paramBoolean) {
/* 208 */     if (paramBoolean) {
/* 209 */       setLoadStripWhitespace();
/*     */     } else {
/* 211 */       remove("LOAD_STRIP_WHITESPACE");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isSetLoadStripWhitespace() {
/* 216 */     return hasOption("LOAD_STRIP_WHITESPACE");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLoadStripComments(boolean paramBoolean) {
/* 221 */     if (paramBoolean) {
/* 222 */       setLoadStripComments();
/*     */     } else {
/* 224 */       remove("LOAD_STRIP_COMMENTS");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isLoadStripComments() {
/* 229 */     return hasOption("LOAD_STRIP_COMMENTS");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLoadStripProcinsts(boolean paramBoolean) {
/* 234 */     if (paramBoolean) {
/* 235 */       setLoadStripProcinsts();
/*     */     } else {
/* 237 */       remove("LOAD_STRIP_PROCINSTS");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isLoadStripProcinsts() {
/* 242 */     return hasOption("LOAD_STRIP_PROCINSTS");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLoadLineNumbers(boolean paramBoolean) {
/* 247 */     if (paramBoolean) {
/* 248 */       setLoadLineNumbers();
/*     */     } else {
/* 250 */       remove("LOAD_LINE_NUMBERS");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isLoadLineNumbers() {
/* 255 */     return hasOption("LOAD_LINE_NUMBERS");
/*     */   }
/*     */ 
/*     */   
/*     */   public Map getLoadSubstituteNamespaces() {
/* 260 */     return (Map)get("LOAD_SUBSTITUTE_NAMESPACES");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLoadTrimTextBuffer(boolean paramBoolean) {
/* 265 */     if (paramBoolean) {
/* 266 */       setLoadTrimTextBuffer();
/*     */     } else {
/* 268 */       remove("LOAD_TRIM_TEXT_BUFFER");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isLoadTrimTextBuffer() {
/* 273 */     return hasOption("LOAD_TRIM_TEXT_BUFFER");
/*     */   }
/*     */ 
/*     */   
/*     */   public Map getLoadAdditionalNamespaces() {
/* 278 */     return (Map)get("LOAD_ADDITIONAL_NAMESPACES");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLoadMessageDigest(boolean paramBoolean) {
/* 283 */     if (paramBoolean) {
/* 284 */       setLoadMessageDigest();
/*     */     } else {
/* 286 */       remove("LOAD_MESSAGE_DIGEST");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isLoadMessageDigest() {
/* 291 */     return hasOption("LOAD_MESSAGE_DIGEST");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLoadUseDefaultResolver(boolean paramBoolean) {
/* 296 */     if (paramBoolean) {
/* 297 */       setLoadUseDefaultResolver();
/*     */     } else {
/* 299 */       remove("LOAD_USE_DEFAULT_RESOLVER");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isLoadUseDefaultResolver() {
/* 304 */     return hasOption("LOAD_USE_DEFAULT_RESOLVER");
/*     */   }
/*     */ 
/*     */   
/*     */   public String getXqueryCurrentNodeVar() {
/* 309 */     return (String)get("XQUERY_CURRENT_NODE_VAR");
/*     */   }
/*     */ 
/*     */   
/*     */   public Map getXqueryVariables() {
/* 314 */     return (Map)get("XQUERY_VARIABLE_MAP");
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDocumentSourceName() {
/* 319 */     return (String)get("DOCUMENT_SOURCE_NAME");
/*     */   }
/*     */ 
/*     */   
/*     */   public Map getCompileSubstituteNames() {
/* 324 */     return (Map)get("COMPILE_SUBSTITUTE_NAMES");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCompileNoUpaRule(boolean paramBoolean) {
/* 329 */     if (paramBoolean) {
/* 330 */       setCompileNoUpaRule();
/*     */     } else {
/* 332 */       remove("COMPILE_NO_UPA_RULE");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isCompileNoUpaRule() {
/* 337 */     return hasOption("COMPILE_NO_UPA_RULE");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCompileNoPvrRule(boolean paramBoolean) {
/* 342 */     if (paramBoolean) {
/* 343 */       setCompileNoPvrRule();
/*     */     } else {
/* 345 */       remove("COMPILE_NO_PVR_RULE");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isCompileNoPvrRule() {
/* 350 */     return hasOption("COMPILE_NO_PVR_RULE");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCompileNoAnnotations(boolean paramBoolean) {
/* 355 */     if (paramBoolean) {
/* 356 */       setCompileNoAnnotations();
/*     */     } else {
/* 358 */       remove("COMPILE_NO_ANNOTATIONS");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isCompileNoAnnotations() {
/* 363 */     return hasOption("COMPILE_NO_ANNOTATIONS");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCompileDownloadUrls(boolean paramBoolean) {
/* 368 */     if (paramBoolean) {
/* 369 */       setCompileDownloadUrls();
/*     */     } else {
/* 371 */       remove("COMPILE_DOWNLOAD_URLS");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isCompileDownloadUrls() {
/* 376 */     return hasOption("COMPILE_DOWNLOAD_URLS");
/*     */   }
/*     */ 
/*     */   
/*     */   public Set getCompileMdefNamespaces() {
/* 381 */     return (Set)get("COMPILE_MDEF_NAMESPACES");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValidateOnSet(boolean paramBoolean) {
/* 386 */     if (paramBoolean) {
/* 387 */       setValidateOnSet();
/*     */     } else {
/* 389 */       remove("VALIDATE_ON_SET");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isValidateOnSet() {
/* 394 */     return hasOption("VALIDATE_ON_SET");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValidateTreatLaxAsSkip(boolean paramBoolean) {
/* 399 */     if (paramBoolean) {
/* 400 */       setValidateTreatLaxAsSkip();
/*     */     } else {
/* 402 */       remove("VALIDATE_TREAT_LAX_AS_SKIP");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isValidateTreatLaxAsSkip() {
/* 407 */     return hasOption("VALIDATE_TREAT_LAX_AS_SKIP");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValidateStrict(boolean paramBoolean) {
/* 412 */     if (paramBoolean) {
/* 413 */       setValidateStrict();
/*     */     } else {
/* 415 */       remove("VALIDATE_STRICT");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isValidateStrict() {
/* 420 */     return hasOption("VALIDATE_STRICT");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUnsynchronized(boolean paramBoolean) {
/* 425 */     if (paramBoolean) {
/* 426 */       setUnsynchronized();
/*     */     } else {
/* 428 */       remove("UNSYNCHRONIZED");
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isUnsynchronized() {
/* 433 */     return hasOption("UNSYNCHRONIZED");
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityResolver getEntityResolver() {
/* 438 */     return (EntityResolver)get("ENTITY_RESOLVER");
/*     */   }
/*     */ 
/*     */   
/*     */   public String getGenerateJavaVersion() {
/* 443 */     return (String)get("GENERATE_JAVA_VERSION");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlOptionsBean.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */