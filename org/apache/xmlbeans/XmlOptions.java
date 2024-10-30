/*      */ package org.apache.xmlbeans;
/*      */ 
/*      */ import java.io.Serializable;
/*      */ import java.net.URI;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import javax.xml.namespace.b;
/*      */ import org.xml.sax.EntityResolver;
/*      */ import org.xml.sax.XMLReader;
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
/*      */ public class XmlOptions
/*      */   implements Serializable
/*      */ {
/*      */   private static final long serialVersionUID = 1L;
/*      */   public static final String GENERATE_JAVA_14 = "1.4";
/*      */   public static final String GENERATE_JAVA_15 = "1.5";
/*      */   public static final String SAVE_NAMESPACES_FIRST = "SAVE_NAMESPACES_FIRST";
/*      */   public static final String SAVE_SYNTHETIC_DOCUMENT_ELEMENT = "SAVE_SYNTHETIC_DOCUMENT_ELEMENT";
/*      */   public static final String SAVE_PRETTY_PRINT = "SAVE_PRETTY_PRINT";
/*      */   public static final String SAVE_PRETTY_PRINT_INDENT = "SAVE_PRETTY_PRINT_INDENT";
/*      */   public static final String SAVE_PRETTY_PRINT_OFFSET = "SAVE_PRETTY_PRINT_OFFSET";
/*      */   public static final String SAVE_AGGRESSIVE_NAMESPACES = "SAVE_AGGRESSIVE_NAMESPACES";
/*      */   public static final String SAVE_USE_DEFAULT_NAMESPACE = "SAVE_USE_DEFAULT_NAMESPACE";
/*      */   public static final String SAVE_IMPLICIT_NAMESPACES = "SAVE_IMPLICIT_NAMESPACES";
/*      */   public static final String SAVE_SUGGESTED_PREFIXES = "SAVE_SUGGESTED_PREFIXES";
/*      */   public static final String SAVE_FILTER_PROCINST = "SAVE_FILTER_PROCINST";
/*      */   public static final String SAVE_USE_OPEN_FRAGMENT = "SAVE_USE_OPEN_FRAGMENT";
/*      */   public static final String SAVE_OUTER = "SAVE_OUTER";
/*      */   public static final String SAVE_INNER = "SAVE_INNER";
/*      */   public static final String SAVE_NO_XML_DECL = "SAVE_NO_XML_DECL";
/*      */   public static final String SAVE_SUBSTITUTE_CHARACTERS = "SAVE_SUBSTITUTE_CHARACTERS";
/*      */   public static final String SAVE_OPTIMIZE_FOR_SPEED = "SAVE_OPTIMIZE_FOR_SPEED";
/*      */   public static final String SAVE_CDATA_LENGTH_THRESHOLD = "SAVE_CDATA_LENGTH_THRESHOLD";
/*      */   public static final String SAVE_CDATA_ENTITY_COUNT_THRESHOLD = "SAVE_CDATA_ENTITY_COUNT_THRESHOLD";
/*      */   public static final String SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES = "SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES";
/*      */   public static final String LOAD_REPLACE_DOCUMENT_ELEMENT = "LOAD_REPLACE_DOCUMENT_ELEMENT";
/*   90 */   private Map _map = new HashMap(); public static final String LOAD_STRIP_WHITESPACE = "LOAD_STRIP_WHITESPACE"; public static final String LOAD_STRIP_COMMENTS = "LOAD_STRIP_COMMENTS"; public static final String LOAD_STRIP_PROCINSTS = "LOAD_STRIP_PROCINSTS"; public static final String LOAD_LINE_NUMBERS = "LOAD_LINE_NUMBERS"; public static final String LOAD_LINE_NUMBERS_END_ELEMENT = "LOAD_LINE_NUMBERS_END_ELEMENT";
/*      */   public static final String LOAD_SAVE_CDATA_BOOKMARKS = "LOAD_SAVE_CDATA_BOOKMARKS";
/*      */   public static final String LOAD_SUBSTITUTE_NAMESPACES = "LOAD_SUBSTITUTE_NAMESPACES";
/*      */   public static final String LOAD_TRIM_TEXT_BUFFER = "LOAD_TRIM_TEXT_BUFFER";
/*      */   public static final String LOAD_ADDITIONAL_NAMESPACES = "LOAD_ADDITIONAL_NAMESPACES";
/*      */   public static final String LOAD_MESSAGE_DIGEST = "LOAD_MESSAGE_DIGEST";
/*      */   public static final String LOAD_USE_DEFAULT_RESOLVER = "LOAD_USE_DEFAULT_RESOLVER";
/*      */   public static final String LOAD_USE_XMLREADER = "LOAD_USE_XMLREADER";
/*      */   public static final String XQUERY_CURRENT_NODE_VAR = "XQUERY_CURRENT_NODE_VAR";
/*      */   public static final String XQUERY_VARIABLE_MAP = "XQUERY_VARIABLE_MAP";
/*      */   
/*      */   public XmlOptions(XmlOptions paramXmlOptions) {
/*  102 */     if (paramXmlOptions != null) this._map.putAll(paramXmlOptions._map);
/*      */   
/*      */   }
/*      */ 
/*      */   
/*      */   public static final String CHARACTER_ENCODING = "CHARACTER_ENCODING";
/*      */   public static final String ERROR_LISTENER = "ERROR_LISTENER";
/*      */   public static final String DOCUMENT_TYPE = "DOCUMENT_TYPE";
/*      */   public static final String DOCUMENT_SOURCE_NAME = "DOCUMENT_SOURCE_NAME";
/*      */   public static final String COMPILE_SUBSTITUTE_NAMES = "COMPILE_SUBSTITUTE_NAMES";
/*      */   public static final String COMPILE_NO_VALIDATION = "COMPILE_NO_VALIDATION";
/*      */   public static final String COMPILE_NO_UPA_RULE = "COMPILE_NO_UPA_RULE";
/*      */   
/*      */   public XmlOptions setSaveNamespacesFirst() {
/*  116 */     return set("SAVE_NAMESPACES_FIRST");
/*      */   }
/*      */   public static final String COMPILE_NO_PVR_RULE = "COMPILE_NO_PVR_RULE"; public static final String COMPILE_NO_ANNOTATIONS = "COMPILE_NO_ANNOTATIONS"; public static final String COMPILE_DOWNLOAD_URLS = "COMPILE_DOWNLOAD_URLS";
/*      */   public static final String COMPILE_MDEF_NAMESPACES = "COMPILE_MDEF_NAMESPACES";
/*      */   public static final String VALIDATE_ON_SET = "VALIDATE_ON_SET";
/*      */   public static final String VALIDATE_TREAT_LAX_AS_SKIP = "VALIDATE_TREAT_LAX_AS_SKIP";
/*      */   public static final String VALIDATE_STRICT = "VALIDATE_STRICT";
/*      */   
/*      */   public XmlOptions setSavePrettyPrint() {
/*  125 */     return set("SAVE_PRETTY_PRINT");
/*      */   }
/*      */   
/*      */   public static final String VALIDATE_TEXT_ONLY = "VALIDATE_TEXT_ONLY";
/*      */   public static final String UNSYNCHRONIZED = "UNSYNCHRONIZED";
/*      */   public static final String ENTITY_RESOLVER = "ENTITY_RESOLVER";
/*      */   public static final String BASE_URI = "BASE_URI";
/*      */   public static final String SCHEMA_CODE_PRINTER = "SCHEMA_CODE_PRINTER";
/*      */   public static final String GENERATE_JAVA_VERSION = "GENERATE_JAVA_VERSION";
/*      */   public static final String COPY_USE_NEW_SYNC_DOMAIN = "COPY_USE_NEW_LOCALE";
/*      */   public static final String LOAD_ENTITY_BYTES_LIMIT = "LOAD_ENTITY_BYTES_LIMIT";
/*      */   
/*      */   public XmlOptions setSavePrettyPrintIndent(int paramInt) {
/*  138 */     return set("SAVE_PRETTY_PRINT_INDENT", paramInt);
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
/*      */   public XmlOptions setSavePrettyPrintOffset(int paramInt) {
/*  151 */     return set("SAVE_PRETTY_PRINT_OFFSET", paramInt);
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
/*      */   public XmlOptions setCharacterEncoding(String paramString) {
/*  163 */     return set("CHARACTER_ENCODING", paramString);
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
/*      */   public XmlOptions setDocumentType(SchemaType paramSchemaType) {
/*  175 */     return set("DOCUMENT_TYPE", paramSchemaType);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setErrorListener(Collection paramCollection) {
/*  223 */     return set("ERROR_LISTENER", paramCollection);
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
/*      */   public XmlOptions setSaveAggressiveNamespaces() {
/*  237 */     return set("SAVE_AGGRESSIVE_NAMESPACES");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setSaveAggresiveNamespaces() {
/*  244 */     return setSaveAggressiveNamespaces();
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
/*      */   public XmlOptions setSaveSyntheticDocumentElement(b paramb) {
/*  257 */     return set("SAVE_SYNTHETIC_DOCUMENT_ELEMENT", paramb);
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
/*      */   public XmlOptions setUseDefaultNamespace() {
/*  269 */     return set("SAVE_USE_DEFAULT_NAMESPACE");
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
/*      */   public XmlOptions setSaveImplicitNamespaces(Map paramMap) {
/*  284 */     return set("SAVE_IMPLICIT_NAMESPACES", paramMap);
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
/*      */   public XmlOptions setSaveSuggestedPrefixes(Map paramMap) {
/*  297 */     return set("SAVE_SUGGESTED_PREFIXES", paramMap);
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
/*      */   public XmlOptions setSaveFilterProcinst(String paramString) {
/*  311 */     return set("SAVE_FILTER_PROCINST", paramString);
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
/*      */   
/*      */   public XmlOptions setSaveSubstituteCharacters(XmlOptionCharEscapeMap paramXmlOptionCharEscapeMap) {
/*  328 */     return set("SAVE_SUBSTITUTE_CHARACTERS", paramXmlOptionCharEscapeMap);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setSaveUseOpenFrag() {
/*  339 */     return set("SAVE_USE_OPEN_FRAGMENT");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setSaveOuter() {
/*  349 */     return set("SAVE_OUTER");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setSaveInner() {
/*  359 */     return set("SAVE_INNER");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setSaveNoXmlDecl() {
/*  370 */     return set("SAVE_NO_XML_DECL");
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setSaveCDataLengthThreshold(int paramInt) {
/*  391 */     return set("SAVE_CDATA_LENGTH_THRESHOLD", paramInt);
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
/*      */   public XmlOptions setSaveCDataEntityCountThreshold(int paramInt) {
/*  403 */     return set("SAVE_CDATA_ENTITY_COUNT_THRESHOLD", paramInt);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setUseCDataBookmarks() {
/*  454 */     return set("LOAD_SAVE_CDATA_BOOKMARKS");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setSaveSaxNoNSDeclsInAttributes() {
/*  463 */     return set("SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setLoadReplaceDocumentElement(b paramb) {
/*  474 */     return set("LOAD_REPLACE_DOCUMENT_ELEMENT", paramb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setLoadStripWhitespace() {
/*  485 */     return set("LOAD_STRIP_WHITESPACE");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setLoadStripComments() {
/*  495 */     return set("LOAD_STRIP_COMMENTS");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setLoadStripProcinsts() {
/*  505 */     return set("LOAD_STRIP_PROCINSTS");
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
/*      */   
/*      */   public XmlOptions setLoadLineNumbers() {
/*  522 */     return set("LOAD_LINE_NUMBERS");
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
/*      */   public XmlOptions setLoadLineNumbers(String paramString) {
/*  536 */     XmlOptions xmlOptions = setLoadLineNumbers();
/*  537 */     xmlOptions = xmlOptions.set(paramString);
/*  538 */     return xmlOptions;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setLoadSubstituteNamespaces(Map paramMap) {
/*  562 */     return set("LOAD_SUBSTITUTE_NAMESPACES", paramMap);
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
/*      */   public XmlOptions setLoadTrimTextBuffer() {
/*  574 */     return set("LOAD_TRIM_TEXT_BUFFER");
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
/*      */   public XmlOptions setLoadAdditionalNamespaces(Map paramMap) {
/*  586 */     return set("LOAD_ADDITIONAL_NAMESPACES", paramMap);
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
/*      */   public XmlOptions setLoadMessageDigest() {
/*  601 */     return set("LOAD_MESSAGE_DIGEST");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setLoadUseDefaultResolver() {
/*  612 */     return set("LOAD_USE_DEFAULT_RESOLVER");
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
/*      */   public XmlOptions setLoadUseXMLReader(XMLReader paramXMLReader) {
/*  624 */     return set("LOAD_USE_XMLREADER", paramXMLReader);
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
/*      */   public XmlOptions setXqueryCurrentNodeVar(String paramString) {
/*  637 */     return set("XQUERY_CURRENT_NODE_VAR", paramString);
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
/*      */   
/*      */   public XmlOptions setXqueryVariables(Map paramMap) {
/*  654 */     return set("XQUERY_VARIABLE_MAP", paramMap);
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
/*      */   public XmlOptions setDocumentSourceName(String paramString) {
/*  667 */     return set("DOCUMENT_SOURCE_NAME", paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setCompileSubstituteNames(Map paramMap) {
/*  678 */     return set("COMPILE_SUBSTITUTE_NAMES", paramMap);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setCompileNoValidation() {
/*  688 */     return set("COMPILE_NO_VALIDATION");
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
/*      */   public XmlOptions setCompileNoUpaRule() {
/*  700 */     return set("COMPILE_NO_UPA_RULE");
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
/*      */   public XmlOptions setCompileNoPvrRule() {
/*  712 */     return set("COMPILE_NO_PVR_RULE");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setCompileNoAnnotations() {
/*  722 */     return set("COMPILE_NO_ANNOTATIONS");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setCompileDownloadUrls() {
/*  732 */     return set("COMPILE_DOWNLOAD_URLS");
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
/*      */   public XmlOptions setCompileMdefNamespaces(Set paramSet) {
/*  748 */     return set("COMPILE_MDEF_NAMESPACES", paramSet);
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
/*      */   public XmlOptions setValidateOnSet() {
/*  763 */     return set("VALIDATE_ON_SET");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setValidateTreatLaxAsSkip() {
/*  773 */     return set("VALIDATE_TREAT_LAX_AS_SKIP");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setValidateStrict() {
/*  781 */     return set("VALIDATE_STRICT");
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
/*      */   public XmlOptions setUnsynchronized() {
/*  793 */     return set("UNSYNCHRONIZED");
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
/*      */   public XmlOptions setEntityResolver(EntityResolver paramEntityResolver) {
/*  808 */     return set("ENTITY_RESOLVER", paramEntityResolver);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setBaseURI(URI paramURI) {
/*  819 */     return set("BASE_URI", paramURI);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setSchemaCodePrinter(SchemaCodePrinter paramSchemaCodePrinter) {
/*  830 */     return set("SCHEMA_CODE_PRINTER", paramSchemaCodePrinter);
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
/*      */   public XmlOptions setGenerateJavaVersion(String paramString) {
/*  846 */     return set("GENERATE_JAVA_VERSION", paramString);
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
/*      */   public XmlOptions setCopyUseNewSynchronizationDomain(boolean paramBoolean) {
/*  861 */     return set("COPY_USE_NEW_LOCALE", paramBoolean ? Boolean.TRUE : Boolean.FALSE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlOptions setLoadEntityBytesLimit(int paramInt) {
/*  872 */     return set("LOAD_ENTITY_BYTES_LIMIT", paramInt);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1002 */   private static final XmlOptions EMPTY_OPTIONS = new XmlOptions(); static {
/* 1003 */     EMPTY_OPTIONS._map = Collections.unmodifiableMap(EMPTY_OPTIONS._map);
/*      */   }
/*      */ 
/*      */   
/*      */   public static XmlOptions maskNull(XmlOptions paramXmlOptions) {
/* 1008 */     return (paramXmlOptions == null) ? EMPTY_OPTIONS : paramXmlOptions;
/*      */   }
/*      */ 
/*      */   
/*      */   public void put(Object paramObject) {
/* 1013 */     put(paramObject, (Object)null);
/*      */   } public void put(Object paramObject1, Object paramObject2) {
/* 1015 */     this._map.put(paramObject1, paramObject2);
/*      */   } public void put(Object paramObject, int paramInt) {
/* 1017 */     put(paramObject, new Integer(paramInt));
/*      */   }
/* 1019 */   private XmlOptions set(Object paramObject) { return set(paramObject, (Object)null); }
/* 1020 */   private XmlOptions set(Object paramObject1, Object paramObject2) { this._map.put(paramObject1, paramObject2); return this; } private XmlOptions set(Object paramObject, int paramInt) {
/* 1021 */     return set(paramObject, new Integer(paramInt));
/*      */   }
/*      */   
/* 1024 */   public boolean hasOption(Object paramObject) { return this._map.containsKey(paramObject); } public static boolean hasOption(XmlOptions paramXmlOptions, Object paramObject) {
/* 1025 */     return (paramXmlOptions == null) ? false : paramXmlOptions.hasOption(paramObject);
/*      */   }
/*      */   
/* 1028 */   public Object get(Object paramObject) { return this._map.get(paramObject); } public void remove(Object paramObject) {
/* 1029 */     this._map.remove(paramObject);
/*      */   }
/*      */   
/*      */   public static Object safeGet(XmlOptions paramXmlOptions, Object paramObject) {
/* 1033 */     return (paramXmlOptions == null) ? null : paramXmlOptions.get(paramObject);
/*      */   }
/*      */   
/*      */   public XmlOptions() {}
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlOptions.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */