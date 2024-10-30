/*      */ package org.apache.xmlbeans.impl.schema;
/*      */ 
/*      */ import java.io.File;
/*      */ import java.io.InputStream;
/*      */ import java.math.BigInteger;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.xmlbeans.Filer;
/*      */ import org.apache.xmlbeans.QNameSet;
/*      */ import org.apache.xmlbeans.SchemaAnnotation;
/*      */ import org.apache.xmlbeans.SchemaAttributeGroup;
/*      */ import org.apache.xmlbeans.SchemaComponent;
/*      */ import org.apache.xmlbeans.SchemaGlobalAttribute;
/*      */ import org.apache.xmlbeans.SchemaGlobalElement;
/*      */ import org.apache.xmlbeans.SchemaIdentityConstraint;
/*      */ import org.apache.xmlbeans.SchemaModelGroup;
/*      */ import org.apache.xmlbeans.SchemaParticle;
/*      */ import org.apache.xmlbeans.SchemaType;
/*      */ import org.apache.xmlbeans.SchemaTypeSystem;
/*      */ import org.apache.xmlbeans.XmlAnySimpleType;
/*      */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*      */ import org.apache.xmlbeans.impl.regex.ParseException;
/*      */ import org.apache.xmlbeans.impl.regex.RegularExpression;
/*      */ import org.apache.xmlbeans.impl.regex.SchemaRegularExpression;
/*      */ import org.apache.xmlbeans.impl.values.XmlIntegerImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlStringImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class XQuerySchemaTypeSystem
/*      */   extends SchemaTypeLoaderBase
/*      */   implements SchemaTypeSystem
/*      */ {
/*      */   public static final int BTC_FIRST_XQUERY = 52;
/*      */   public static final int BTC_ANY_ATOMIC = 52;
/*      */   public static final int BTC_DAY_TIME_DURATION = 53;
/*      */   public static final int BTC_YEAR_MONTH_DURATION = 54;
/*      */   public static final int BTC_LAST_XQUERY = 54;
/*      */   
/*      */   public static SchemaTypeSystem get() {
/*   58 */     return _global;
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
/*   69 */   private static final SchemaType[] EMPTY_SCHEMATYPE_ARRAY = new SchemaType[0];
/*   70 */   private static final SchemaType.Ref[] EMPTY_SCHEMATYPEREF_ARRAY = new SchemaType.Ref[0];
/*   71 */   private static final SchemaGlobalElement[] EMPTY_SCHEMAELEMENT_ARRAY = new SchemaGlobalElement[0];
/*   72 */   private static final SchemaGlobalAttribute[] EMPTY_SCHEMAATTRIBUTE_ARRAY = new SchemaGlobalAttribute[0];
/*   73 */   private static final SchemaModelGroup[] EMPTY_SCHEMAMODELGROUP_ARRAY = new SchemaModelGroup[0];
/*   74 */   private static final SchemaAttributeGroup[] EMPTY_SCHEMAATTRIBUTEGROUP_ARRAY = new SchemaAttributeGroup[0];
/*   75 */   private static final SchemaAnnotation[] EMPTY_SCHEMAANNOTATION_ARRAY = new SchemaAnnotation[0];
/*      */   
/*   77 */   private static XQuerySchemaTypeSystem _global = new XQuerySchemaTypeSystem();
/*      */ 
/*      */   
/*   80 */   public static final SchemaTypeImpl ST_ANY_TYPE = _global.getBuiltinType(1);
/*   81 */   public static final SchemaTypeImpl ST_ANY_SIMPLE = _global.getBuiltinType(2);
/*   82 */   public static final SchemaTypeImpl ST_ANY_ATOMIC = _global.getBuiltinType(52);
/*      */ 
/*      */   
/*   85 */   public static final SchemaTypeImpl ST_BOOLEAN = _global.getBuiltinType(3);
/*   86 */   public static final SchemaTypeImpl ST_BASE_64_BINARY = _global.getBuiltinType(4);
/*   87 */   public static final SchemaTypeImpl ST_HEX_BINARY = _global.getBuiltinType(5);
/*   88 */   public static final SchemaTypeImpl ST_ANY_URI = _global.getBuiltinType(6);
/*   89 */   public static final SchemaTypeImpl ST_QNAME = _global.getBuiltinType(7);
/*   90 */   public static final SchemaTypeImpl ST_NOTATION = _global.getBuiltinType(8);
/*   91 */   public static final SchemaTypeImpl ST_FLOAT = _global.getBuiltinType(9);
/*   92 */   public static final SchemaTypeImpl ST_DOUBLE = _global.getBuiltinType(10);
/*   93 */   public static final SchemaTypeImpl ST_DECIMAL = _global.getBuiltinType(11);
/*   94 */   public static final SchemaTypeImpl ST_STRING = _global.getBuiltinType(12);
/*      */   
/*   96 */   public static final SchemaTypeImpl ST_DURATION = _global.getBuiltinType(13);
/*   97 */   public static final SchemaTypeImpl ST_DATE_TIME = _global.getBuiltinType(14);
/*   98 */   public static final SchemaTypeImpl ST_TIME = _global.getBuiltinType(15);
/*   99 */   public static final SchemaTypeImpl ST_DATE = _global.getBuiltinType(16);
/*  100 */   public static final SchemaTypeImpl ST_G_YEAR_MONTH = _global.getBuiltinType(17);
/*  101 */   public static final SchemaTypeImpl ST_G_YEAR = _global.getBuiltinType(18);
/*  102 */   public static final SchemaTypeImpl ST_G_MONTH_DAY = _global.getBuiltinType(19);
/*  103 */   public static final SchemaTypeImpl ST_G_DAY = _global.getBuiltinType(20);
/*  104 */   public static final SchemaTypeImpl ST_G_MONTH = _global.getBuiltinType(21);
/*      */ 
/*      */   
/*  107 */   public static final SchemaTypeImpl ST_INTEGER = _global.getBuiltinType(22);
/*  108 */   public static final SchemaTypeImpl ST_LONG = _global.getBuiltinType(23);
/*  109 */   public static final SchemaTypeImpl ST_INT = _global.getBuiltinType(24);
/*  110 */   public static final SchemaTypeImpl ST_SHORT = _global.getBuiltinType(25);
/*  111 */   public static final SchemaTypeImpl ST_BYTE = _global.getBuiltinType(26);
/*  112 */   public static final SchemaTypeImpl ST_NON_POSITIVE_INTEGER = _global.getBuiltinType(27);
/*  113 */   public static final SchemaTypeImpl ST_NEGATIVE_INTEGER = _global.getBuiltinType(28);
/*  114 */   public static final SchemaTypeImpl ST_NON_NEGATIVE_INTEGER = _global.getBuiltinType(29);
/*  115 */   public static final SchemaTypeImpl ST_POSITIVE_INTEGER = _global.getBuiltinType(30);
/*  116 */   public static final SchemaTypeImpl ST_UNSIGNED_LONG = _global.getBuiltinType(31);
/*  117 */   public static final SchemaTypeImpl ST_UNSIGNED_INT = _global.getBuiltinType(32);
/*  118 */   public static final SchemaTypeImpl ST_UNSIGNED_SHORT = _global.getBuiltinType(33);
/*  119 */   public static final SchemaTypeImpl ST_UNSIGNED_BYTE = _global.getBuiltinType(34);
/*      */ 
/*      */   
/*  122 */   public static final SchemaTypeImpl ST_NORMALIZED_STRING = _global.getBuiltinType(35);
/*  123 */   public static final SchemaTypeImpl ST_TOKEN = _global.getBuiltinType(36);
/*  124 */   public static final SchemaTypeImpl ST_NAME = _global.getBuiltinType(37);
/*  125 */   public static final SchemaTypeImpl ST_NCNAME = _global.getBuiltinType(38);
/*  126 */   public static final SchemaTypeImpl ST_LANGUAGE = _global.getBuiltinType(39);
/*  127 */   public static final SchemaTypeImpl ST_ID = _global.getBuiltinType(40);
/*  128 */   public static final SchemaTypeImpl ST_IDREF = _global.getBuiltinType(41);
/*  129 */   public static final SchemaTypeImpl ST_IDREFS = _global.getBuiltinType(42);
/*  130 */   public static final SchemaTypeImpl ST_ENTITY = _global.getBuiltinType(43);
/*  131 */   public static final SchemaTypeImpl ST_ENTITIES = _global.getBuiltinType(44);
/*  132 */   public static final SchemaTypeImpl ST_NMTOKEN = _global.getBuiltinType(45);
/*  133 */   public static final SchemaTypeImpl ST_NMTOKENS = _global.getBuiltinType(46);
/*      */ 
/*      */   
/*  136 */   public static final SchemaTypeImpl ST_DAY_TIME_DURATION = _global.getBuiltinType(53);
/*  137 */   public static final SchemaTypeImpl ST_YEAR_MONTH_DURATION = _global.getBuiltinType(54);
/*      */ 
/*      */   
/*  140 */   public static final SchemaTypeImpl ST_NO_TYPE = _global.getBuiltinType(0);
/*      */   
/*  142 */   private static final XmlValueRef XMLSTR_PRESERVE = buildString("preserve");
/*  143 */   private static final XmlValueRef XMLSTR_REPLACE = buildString("preserve");
/*  144 */   private static final XmlValueRef XMLSTR_COLLAPSE = buildString("preserve");
/*      */   
/*  146 */   private static final XmlValueRef[] FACETS_NONE = new XmlValueRef[] { null, null, null, null, null, null, null, null, null, null, null, null };
/*      */ 
/*      */ 
/*      */   
/*  150 */   private static final boolean[] FIXED_FACETS_NONE = new boolean[] { 
/*      */       false, false, false, false, false, false, false, false, false, false, 
/*      */       false, false };
/*      */   
/*  154 */   private static final XmlValueRef[] FACETS_WS_COLLAPSE = new XmlValueRef[] { null, null, null, null, null, null, null, null, null, build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  158 */   private static final XmlValueRef[] FACETS_WS_REPLACE = new XmlValueRef[] { null, null, null, null, null, null, null, null, null, build_wsstring(2), null, null };
/*      */ 
/*      */ 
/*      */   
/*  162 */   private static final XmlValueRef[] FACETS_WS_PRESERVE = new XmlValueRef[] { null, null, null, null, null, null, null, null, null, build_wsstring(1), null, null };
/*      */ 
/*      */ 
/*      */   
/*  166 */   private static final XmlValueRef[] FACETS_INTEGER = new XmlValueRef[] { null, null, null, null, null, null, null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  170 */   private static final XmlValueRef[] FACETS_LONG = new XmlValueRef[] { null, null, null, null, buildInteger(BigInteger.valueOf(Long.MIN_VALUE)), buildInteger(BigInteger.valueOf(Long.MAX_VALUE)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  174 */   private static final XmlValueRef[] FACETS_INT = new XmlValueRef[] { null, null, null, null, buildInteger(BigInteger.valueOf(-2147483648L)), buildInteger(BigInteger.valueOf(2147483647L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  178 */   private static final XmlValueRef[] FACETS_SHORT = new XmlValueRef[] { null, null, null, null, buildInteger(BigInteger.valueOf(-32768L)), buildInteger(BigInteger.valueOf(32767L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  182 */   private static final XmlValueRef[] FACETS_BYTE = new XmlValueRef[] { null, null, null, null, buildInteger(BigInteger.valueOf(-128L)), buildInteger(BigInteger.valueOf(127L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  186 */   private static final XmlValueRef[] FACETS_NONNEGATIVE = new XmlValueRef[] { null, null, null, null, buildInteger(BigInteger.ZERO), null, null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  190 */   private static final XmlValueRef[] FACETS_POSITIVE = new XmlValueRef[] { null, null, null, null, buildInteger(BigInteger.ONE), null, null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  194 */   private static final XmlValueRef[] FACETS_NONPOSITIVE = new XmlValueRef[] { null, null, null, null, null, buildInteger(BigInteger.ZERO), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  198 */   private static final XmlValueRef[] FACETS_NEGATIVE = new XmlValueRef[] { null, null, null, null, null, buildInteger(BigInteger.ONE.negate()), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  202 */   private static final XmlValueRef[] FACETS_UNSIGNED_LONG = new XmlValueRef[] { null, null, null, null, buildInteger(BigInteger.ZERO), buildInteger(new BigInteger("18446744073709551615")), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  206 */   private static final XmlValueRef[] FACETS_UNSIGNED_INT = new XmlValueRef[] { null, null, null, null, buildInteger(BigInteger.ZERO), buildInteger(BigInteger.valueOf(4294967295L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  210 */   private static final XmlValueRef[] FACETS_UNSIGNED_SHORT = new XmlValueRef[] { null, null, null, null, buildInteger(BigInteger.ZERO), buildInteger(BigInteger.valueOf(65535L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  214 */   private static final XmlValueRef[] FACETS_UNSIGNED_BYTE = new XmlValueRef[] { null, null, null, null, buildInteger(BigInteger.ZERO), buildInteger(BigInteger.valueOf(255L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  218 */   private static final XmlValueRef[] FACETS_BUILTIN_LIST = new XmlValueRef[] { null, buildNnInteger(BigInteger.ONE), null, null, null, null, null, null, null, build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  222 */   private static final boolean[] FIXED_FACETS_WS = new boolean[] { 
/*      */       false, false, false, false, false, false, false, false, false, true, 
/*      */       false, false };
/*      */   
/*  226 */   private static final boolean[] FIXED_FACETS_INTEGER = new boolean[] { 
/*      */       false, false, false, false, false, false, false, false, true, true, 
/*      */       false, false };
/*      */   
/*  230 */   static final XmlValueRef[] FACETS_UNION = FACETS_NONE;
/*  231 */   static final boolean[] FIXED_FACETS_UNION = FIXED_FACETS_NONE;
/*      */   
/*  233 */   static final XmlValueRef[] FACETS_LIST = FACETS_WS_COLLAPSE;
/*  234 */   static final boolean[] FIXED_FACETS_LIST = FIXED_FACETS_WS;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/*      */     byte b;
/*  241 */     for (b = 0; b <= 46; b++)
/*      */     {
/*  243 */       _global.fillInType(b);
/*      */     }
/*  245 */     for (b = 52; b <= 54; b++)
/*      */     {
/*  247 */       _global.fillInType(b);
/*      */     }
/*      */   }
/*      */   
/*  251 */   private Map _typeMap = new HashMap();
/*  252 */   private SchemaTypeImpl[] _typeArray = new SchemaTypeImpl[50];
/*      */   
/*  254 */   private Map _handlesToObjects = new HashMap();
/*  255 */   private Map _objectsToHandles = new HashMap();
/*  256 */   private Map _typesByClassname = new HashMap();
/*  257 */   private SchemaContainer _container = new SchemaContainer("http://www.w3.org/2001/XMLSchema");
/*      */   static final boolean $assertionsDisabled;
/*      */   
/*      */   private SchemaTypeImpl getBuiltinType(int paramInt) {
/*  261 */     return this._typeArray[arrayIndexForBtc(paramInt)];
/*      */   }
/*      */ 
/*      */   
/*      */   private XQuerySchemaTypeSystem() {
/*  266 */     this._container.setTypeSystem(this);
/*      */     
/*  268 */     setupType(1, "anyType", "org.apache.xmlbeans.XmlObject");
/*  269 */     setupType(2, "anySimpleType", "org.apache.xmlbeans.XmlAnySimpleType");
/*  270 */     setupType(52, "anyAtomicType", null);
/*      */ 
/*      */     
/*  273 */     setupType(3, "boolean", "org.apache.xmlbeans.XmlBoolean");
/*  274 */     setupType(4, "base64Binary", "org.apache.xmlbeans.XmlBase64Binary");
/*  275 */     setupType(5, "hexBinary", "org.apache.xmlbeans.XmlHexBinary");
/*  276 */     setupType(6, "anyURI", "org.apache.xmlbeans.XmlAnyURI");
/*  277 */     setupType(7, "QName", "org.apache.xmlbeans.XmlQName");
/*  278 */     setupType(8, "NOTATION", "org.apache.xmlbeans.XmlNOTATION");
/*  279 */     setupType(9, "float", "org.apache.xmlbeans.XmlFloat");
/*  280 */     setupType(10, "double", "org.apache.xmlbeans.XmlDouble");
/*  281 */     setupType(11, "decimal", "org.apache.xmlbeans.XmlDecimal");
/*  282 */     setupType(12, "string", "org.apache.xmlbeans.XmlString");
/*      */     
/*  284 */     setupType(13, "duration", "org.apache.xmlbeans.XmlDuration");
/*  285 */     setupType(14, "dateTime", "org.apache.xmlbeans.XmlDateTime");
/*  286 */     setupType(15, "time", "org.apache.xmlbeans.XmlTime");
/*  287 */     setupType(16, "date", "org.apache.xmlbeans.XmlDate");
/*  288 */     setupType(17, "gYearMonth", "org.apache.xmlbeans.XmlGYearMonth");
/*  289 */     setupType(18, "gYear", "org.apache.xmlbeans.XmlGYear");
/*  290 */     setupType(19, "gMonthDay", "org.apache.xmlbeans.XmlGMonthDay");
/*  291 */     setupType(20, "gDay", "org.apache.xmlbeans.XmlGDay");
/*  292 */     setupType(21, "gMonth", "org.apache.xmlbeans.XmlGMonth");
/*      */ 
/*      */     
/*  295 */     setupType(22, "integer", "org.apache.xmlbeans.XmlInteger");
/*  296 */     setupType(23, "long", "org.apache.xmlbeans.XmlLong");
/*  297 */     setupType(24, "int", "org.apache.xmlbeans.XmlInt");
/*  298 */     setupType(25, "short", "org.apache.xmlbeans.XmlShort");
/*  299 */     setupType(26, "byte", "org.apache.xmlbeans.XmlByte");
/*  300 */     setupType(27, "nonPositiveInteger", "org.apache.xmlbeans.XmlNonPositiveInteger");
/*  301 */     setupType(28, "negativeInteger", "org.apache.xmlbeans.XmlNegativeInteger");
/*  302 */     setupType(29, "nonNegativeInteger", "org.apache.xmlbeans.XmlNonNegativeInteger");
/*  303 */     setupType(30, "positiveInteger", "org.apache.xmlbeans.XmlPositiveInteger");
/*  304 */     setupType(31, "unsignedLong", "org.apache.xmlbeans.XmlUnsignedLong");
/*  305 */     setupType(32, "unsignedInt", "org.apache.xmlbeans.XmlUnsignedInt");
/*  306 */     setupType(33, "unsignedShort", "org.apache.xmlbeans.XmlUnsignedShort");
/*  307 */     setupType(34, "unsignedByte", "org.apache.xmlbeans.XmlUnsignedByte");
/*      */ 
/*      */     
/*  310 */     setupType(35, "normalizedString", "org.apache.xmlbeans.XmlNormalizedString");
/*  311 */     setupType(36, "token", "org.apache.xmlbeans.XmlToken");
/*  312 */     setupType(37, "Name", "org.apache.xmlbeans.XmlName");
/*  313 */     setupType(38, "NCName", "org.apache.xmlbeans.XmlNCName");
/*  314 */     setupType(39, "language", "org.apache.xmlbeans.XmlLanguage");
/*  315 */     setupType(40, "ID", "org.apache.xmlbeans.XmlID");
/*  316 */     setupType(41, "IDREF", "org.apache.xmlbeans.XmlIDREF");
/*  317 */     setupType(42, "IDREFS", "org.apache.xmlbeans.XmlIDREFS");
/*  318 */     setupType(43, "ENTITY", "org.apache.xmlbeans.XmlENTITY");
/*  319 */     setupType(44, "ENTITIES", "org.apache.xmlbeans.XmlENTITIES");
/*  320 */     setupType(45, "NMTOKEN", "org.apache.xmlbeans.XmlNMTOKEN");
/*  321 */     setupType(46, "NMTOKENS", "org.apache.xmlbeans.XmlNMTOKENS");
/*      */ 
/*      */     
/*  324 */     setupType(53, "dayTimeDuration", null);
/*  325 */     setupType(54, "yearMonthDuration", null);
/*      */ 
/*      */     
/*  328 */     setupType(0, null, null);
/*  329 */     this._container.setImmutable();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getName() {
/*  338 */     return "xquery.typesystem.builtin";
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isNamespaceDefined(String paramString) {
/*  343 */     return paramString.equals("http://www.w3.org/2001/XMLSchema");
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaType findType(b paramb) {
/*  348 */     return (SchemaType)this._typeMap.get(paramb);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaType findDocumentType(b paramb) {
/*  354 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaType findAttributeType(b paramb) {
/*  359 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaGlobalElement findElement(b paramb) {
/*  364 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaGlobalAttribute findAttribute(b paramb) {
/*  369 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaType.Ref findTypeRef(b paramb) {
/*  374 */     SchemaType schemaType = findType(paramb);
/*  375 */     return (schemaType == null) ? null : schemaType.getRef();
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaType.Ref findDocumentTypeRef(b paramb) {
/*  380 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaType.Ref findAttributeTypeRef(b paramb) {
/*  385 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaGlobalElement.Ref findElementRef(b paramb) {
/*  390 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaGlobalAttribute.Ref findAttributeRef(b paramb) {
/*  395 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaModelGroup.Ref findModelGroupRef(b paramb) {
/*  400 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaAttributeGroup.Ref findAttributeGroupRef(b paramb) {
/*  405 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaIdentityConstraint.Ref findIdentityConstraintRef(b paramb) {
/*  410 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaType typeForClassname(String paramString) {
/*  415 */     return (SchemaType)this._typesByClassname.get(paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   public InputStream getSourceAsStream(String paramString) {
/*  420 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaType[] globalTypes() {
/*  428 */     SchemaType[] arrayOfSchemaType = new SchemaType[this._typeArray.length - 1];
/*  429 */     System.arraycopy(this._typeArray, 1, arrayOfSchemaType, 0, arrayOfSchemaType.length);
/*  430 */     return arrayOfSchemaType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaType[] documentTypes() {
/*  438 */     return EMPTY_SCHEMATYPE_ARRAY;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaType[] attributeTypes() {
/*  446 */     return EMPTY_SCHEMATYPE_ARRAY;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaGlobalElement[] globalElements() {
/*  454 */     return EMPTY_SCHEMAELEMENT_ARRAY;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaGlobalAttribute[] globalAttributes() {
/*  462 */     return EMPTY_SCHEMAATTRIBUTE_ARRAY;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaModelGroup[] modelGroups() {
/*  470 */     return EMPTY_SCHEMAMODELGROUP_ARRAY;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaAttributeGroup[] attributeGroups() {
/*  478 */     return EMPTY_SCHEMAATTRIBUTEGROUP_ARRAY;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaAnnotation[] annotations() {
/*  486 */     return EMPTY_SCHEMAANNOTATION_ARRAY;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String handleForType(SchemaType paramSchemaType) {
/*  494 */     return (String)this._objectsToHandles.get(paramSchemaType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassLoader getClassLoader() {
/*  502 */     return BuiltinSchemaTypeSystem.class.getClassLoader();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void saveToDirectory(File paramFile) {
/*  510 */     throw new UnsupportedOperationException("The builtin schema type system cannot be saved.");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void save(Filer paramFiler) {
/*  518 */     throw new UnsupportedOperationException("The builtin schema type system cannot be saved.");
/*      */   }
/*      */ 
/*      */   
/*      */   private int arrayIndexForBtc(int paramInt) {
/*  523 */     return (paramInt > 46) ? (paramInt - 52 + 46 + 1) : paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static XmlValueRef build_wsstring(int paramInt) {
/*  529 */     switch (paramInt) {
/*      */       
/*      */       case 1:
/*  532 */         return XMLSTR_PRESERVE;
/*      */       case 2:
/*  534 */         return XMLSTR_REPLACE;
/*      */       case 3:
/*  536 */         return XMLSTR_COLLAPSE;
/*      */     } 
/*  538 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private static XmlValueRef buildNnInteger(BigInteger paramBigInteger) {
/*  543 */     if (paramBigInteger == null)
/*  544 */       return null; 
/*  545 */     if (paramBigInteger.signum() < 0) {
/*  546 */       return null;
/*      */     }
/*      */     try {
/*  549 */       XmlIntegerImpl xmlIntegerImpl = new XmlIntegerImpl();
/*  550 */       xmlIntegerImpl.setBigIntegerValue(paramBigInteger);
/*  551 */       xmlIntegerImpl.setImmutable();
/*  552 */       return new XmlValueRef((XmlAnySimpleType)xmlIntegerImpl);
/*      */     }
/*  554 */     catch (XmlValueOutOfRangeException xmlValueOutOfRangeException) {
/*      */       
/*  556 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static XmlValueRef buildInteger(BigInteger paramBigInteger) {
/*  562 */     if (paramBigInteger == null) {
/*  563 */       return null;
/*      */     }
/*      */     try {
/*  566 */       XmlIntegerImpl xmlIntegerImpl = new XmlIntegerImpl();
/*  567 */       xmlIntegerImpl.setBigIntegerValue(paramBigInteger);
/*  568 */       xmlIntegerImpl.setImmutable();
/*  569 */       return new XmlValueRef((XmlAnySimpleType)xmlIntegerImpl);
/*      */     }
/*  571 */     catch (XmlValueOutOfRangeException xmlValueOutOfRangeException) {
/*      */       
/*  573 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static XmlValueRef buildString(String paramString) {
/*  579 */     if (paramString == null) {
/*  580 */       return null;
/*      */     }
/*      */     
/*      */     try {
/*  584 */       XmlStringImpl xmlStringImpl = new XmlStringImpl();
/*  585 */       xmlStringImpl.setStringValue(paramString);
/*  586 */       xmlStringImpl.setImmutable();
/*  587 */       return new XmlValueRef((XmlAnySimpleType)xmlStringImpl);
/*      */     }
/*  589 */     catch (XmlValueOutOfRangeException xmlValueOutOfRangeException) {
/*      */       
/*  591 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void setupType(int paramInt, String paramString1, String paramString2) {
/*  597 */     SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(this._container, true);
/*  598 */     this._container.addGlobalType(schemaTypeImpl.getRef());
/*  599 */     b b = (paramString1 == null) ? null : QNameHelper.forLNS(paramString1, "http://www.w3.org/2001/XMLSchema");
/*  600 */     String str = "_BI_" + ((paramString1 == null) ? "NO_TYPE" : paramString1);
/*  601 */     schemaTypeImpl.setName(b);
/*  602 */     schemaTypeImpl.setBuiltinTypeCode(paramInt);
/*  603 */     if (paramString2 != null) {
/*  604 */       schemaTypeImpl.setFullJavaName(paramString2);
/*      */     }
/*  606 */     this._typeArray[arrayIndexForBtc(paramInt)] = schemaTypeImpl;
/*  607 */     this._typeMap.put(b, schemaTypeImpl);
/*  608 */     this._handlesToObjects.put(str, schemaTypeImpl);
/*  609 */     this._objectsToHandles.put(schemaTypeImpl, str);
/*  610 */     if (paramString2 != null) {
/*  611 */       this._typesByClassname.put(paramString2, schemaTypeImpl);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void resolve() {}
/*      */ 
/*      */   
/*      */   public SchemaType typeForHandle(String paramString) {
/*  621 */     return (SchemaType)this._handlesToObjects.get(paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaComponent resolveHandle(String paramString) {
/*  626 */     return (SchemaComponent)this._handlesToObjects.get(paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   public void fillInType(int paramInt) {
/*      */     SchemaTypeImpl schemaTypeImpl2;
/*      */     XmlValueRef[] arrayOfXmlValueRef;
/*      */     boolean[] arrayOfBoolean;
/*  634 */     SchemaTypeImpl schemaTypeImpl1 = getBuiltinType(paramInt);
/*      */     
/*  636 */     SchemaTypeImpl schemaTypeImpl3 = null;
/*  637 */     byte b1 = 1;
/*  638 */     boolean bool1 = true;
/*      */     
/*  640 */     switch (paramInt) {
/*      */       
/*      */       case 0:
/*  643 */         b1 = 0;
/*  644 */         schemaTypeImpl2 = ST_ANY_TYPE;
/*      */         break;
/*      */       
/*      */       case 1:
/*  648 */         b1 = 0;
/*  649 */         schemaTypeImpl2 = null;
/*  650 */         bool1 = true;
/*      */         break;
/*      */       
/*      */       default:
/*      */         assert false;
/*      */       
/*      */       case 2:
/*  657 */         schemaTypeImpl2 = ST_ANY_TYPE;
/*      */         break;
/*      */       case 52:
/*  660 */         schemaTypeImpl2 = ST_ANY_SIMPLE;
/*      */       
/*      */       case 3:
/*      */       case 4:
/*      */       case 5:
/*      */       case 6:
/*      */       case 7:
/*      */       case 8:
/*      */       case 9:
/*      */       case 10:
/*      */       case 11:
/*      */       case 12:
/*      */       case 13:
/*      */       case 14:
/*      */       case 15:
/*      */       case 16:
/*      */       case 17:
/*      */       case 18:
/*      */       case 19:
/*      */       case 20:
/*      */       case 21:
/*  681 */         schemaTypeImpl2 = ST_ANY_ATOMIC;
/*      */         break;
/*      */       
/*      */       case 22:
/*  685 */         schemaTypeImpl2 = ST_DECIMAL;
/*      */         break;
/*      */       case 23:
/*  688 */         schemaTypeImpl2 = ST_INTEGER;
/*      */         break;
/*      */       case 24:
/*  691 */         schemaTypeImpl2 = ST_LONG;
/*      */         break;
/*      */       case 25:
/*  694 */         schemaTypeImpl2 = ST_INT;
/*      */         break;
/*      */       case 26:
/*  697 */         schemaTypeImpl2 = ST_SHORT;
/*      */         break;
/*      */       case 27:
/*  700 */         schemaTypeImpl2 = ST_INTEGER;
/*      */         break;
/*      */       case 28:
/*  703 */         schemaTypeImpl2 = ST_NON_POSITIVE_INTEGER;
/*      */         break;
/*      */       case 29:
/*  706 */         schemaTypeImpl2 = ST_INTEGER;
/*      */         break;
/*      */       case 30:
/*  709 */         schemaTypeImpl2 = ST_NON_NEGATIVE_INTEGER;
/*      */         break;
/*      */       case 31:
/*  712 */         schemaTypeImpl2 = ST_NON_NEGATIVE_INTEGER;
/*      */         break;
/*      */       case 32:
/*  715 */         schemaTypeImpl2 = ST_UNSIGNED_LONG;
/*      */         break;
/*      */       case 33:
/*  718 */         schemaTypeImpl2 = ST_UNSIGNED_INT;
/*      */         break;
/*      */       case 34:
/*  721 */         schemaTypeImpl2 = ST_UNSIGNED_SHORT;
/*      */         break;
/*      */       
/*      */       case 35:
/*  725 */         schemaTypeImpl2 = ST_STRING;
/*      */         break;
/*      */       case 36:
/*  728 */         schemaTypeImpl2 = ST_NORMALIZED_STRING;
/*      */         break;
/*      */       case 37:
/*  731 */         schemaTypeImpl2 = ST_TOKEN;
/*      */         break;
/*      */       case 38:
/*  734 */         schemaTypeImpl2 = ST_NAME;
/*      */         break;
/*      */       case 40:
/*      */       case 41:
/*      */       case 43:
/*  739 */         schemaTypeImpl2 = ST_NCNAME;
/*      */         break;
/*      */       case 39:
/*      */       case 45:
/*  743 */         schemaTypeImpl2 = ST_TOKEN;
/*      */         break;
/*      */       case 42:
/*      */       case 44:
/*      */       case 46:
/*  748 */         b1 = 3;
/*  749 */         schemaTypeImpl2 = ST_ANY_SIMPLE;
/*  750 */         if (paramInt == 42) {
/*  751 */           schemaTypeImpl3 = ST_IDREF; break;
/*  752 */         }  if (paramInt == 44) {
/*  753 */           schemaTypeImpl3 = ST_ENTITY; break;
/*      */         } 
/*  755 */         schemaTypeImpl3 = ST_NMTOKEN;
/*      */         break;
/*      */ 
/*      */       
/*      */       case 53:
/*      */       case 54:
/*  761 */         schemaTypeImpl2 = ST_DURATION;
/*      */         break;
/*      */     } 
/*      */ 
/*      */     
/*  766 */     schemaTypeImpl1.setDerivationType(bool1);
/*  767 */     schemaTypeImpl1.setSimpleTypeVariety(b1);
/*  768 */     if (b1 != 0) {
/*      */       
/*  770 */       schemaTypeImpl1.setSimpleType(true);
/*      */     }
/*      */     else {
/*      */       
/*  774 */       assert paramInt == 1 || paramInt == 0;
/*      */     } 
/*  776 */     schemaTypeImpl1.setBaseTypeRef((schemaTypeImpl2 == null) ? null : schemaTypeImpl2.getRef());
/*  777 */     schemaTypeImpl1.setBaseDepth((schemaTypeImpl2 == null) ? 0 : (schemaTypeImpl2.getBaseDepth() + 1));
/*  778 */     schemaTypeImpl1.setListItemTypeRef((schemaTypeImpl3 == null) ? null : schemaTypeImpl3.getRef());
/*  779 */     if ((paramInt >= 2 && paramInt <= 21) || paramInt == 52) {
/*      */       
/*  781 */       schemaTypeImpl1.setPrimitiveTypeRef(schemaTypeImpl1.getRef());
/*  782 */     } else if (b1 == 1) {
/*      */       
/*  784 */       if (schemaTypeImpl2 == null)
/*  785 */         throw new IllegalStateException("Base was null for " + paramInt); 
/*  786 */       if (schemaTypeImpl2.getPrimitiveType() == null)
/*  787 */         throw new IllegalStateException("Base.gpt was null for " + paramInt); 
/*  788 */       schemaTypeImpl1.setPrimitiveTypeRef(schemaTypeImpl2.getPrimitiveType().getRef());
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  793 */     byte b2 = 3;
/*  794 */     int i = 0;
/*      */ 
/*      */     
/*  797 */     switch (paramInt) {
/*      */       default:
/*      */         assert false;
/*      */ 
/*      */       
/*      */       case 0:
/*      */       case 1:
/*      */       case 2:
/*      */       case 52:
/*  806 */         arrayOfXmlValueRef = FACETS_NONE;
/*  807 */         arrayOfBoolean = FIXED_FACETS_NONE;
/*  808 */         b2 = 0;
/*      */         break;
/*      */       
/*      */       case 12:
/*  812 */         arrayOfXmlValueRef = FACETS_WS_PRESERVE;
/*  813 */         arrayOfBoolean = FIXED_FACETS_NONE;
/*  814 */         b2 = 1;
/*      */         break;
/*      */       
/*      */       case 3:
/*      */       case 4:
/*      */       case 5:
/*      */       case 6:
/*      */       case 7:
/*      */       case 8:
/*      */       case 9:
/*      */       case 10:
/*      */       case 13:
/*      */       case 14:
/*      */       case 15:
/*      */       case 16:
/*      */       case 17:
/*      */       case 18:
/*      */       case 19:
/*      */       case 20:
/*      */       case 21:
/*  834 */         arrayOfXmlValueRef = FACETS_WS_COLLAPSE;
/*  835 */         arrayOfBoolean = FIXED_FACETS_WS;
/*      */         break;
/*      */       
/*      */       case 11:
/*  839 */         arrayOfXmlValueRef = FACETS_WS_COLLAPSE;
/*  840 */         arrayOfBoolean = FIXED_FACETS_WS;
/*  841 */         i = 1000001;
/*      */         break;
/*      */ 
/*      */       
/*      */       case 22:
/*  846 */         arrayOfXmlValueRef = FACETS_INTEGER;
/*  847 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  848 */         i = 1000000;
/*      */         break;
/*      */       
/*      */       case 23:
/*  852 */         arrayOfXmlValueRef = FACETS_LONG;
/*  853 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  854 */         i = 64;
/*      */         break;
/*      */       
/*      */       case 24:
/*  858 */         arrayOfXmlValueRef = FACETS_INT;
/*  859 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  860 */         i = 32;
/*      */         break;
/*      */       
/*      */       case 25:
/*  864 */         arrayOfXmlValueRef = FACETS_SHORT;
/*  865 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  866 */         i = 16;
/*      */         break;
/*      */       
/*      */       case 26:
/*  870 */         arrayOfXmlValueRef = FACETS_BYTE;
/*  871 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  872 */         i = 8;
/*      */         break;
/*      */       
/*      */       case 27:
/*  876 */         arrayOfXmlValueRef = FACETS_NONPOSITIVE;
/*  877 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  878 */         i = 1000000;
/*      */         break;
/*      */       
/*      */       case 28:
/*  882 */         arrayOfXmlValueRef = FACETS_NEGATIVE;
/*  883 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  884 */         i = 1000000;
/*      */         break;
/*      */       
/*      */       case 29:
/*  888 */         arrayOfXmlValueRef = FACETS_NONNEGATIVE;
/*  889 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  890 */         i = 1000000;
/*      */         break;
/*      */       
/*      */       case 30:
/*  894 */         arrayOfXmlValueRef = FACETS_POSITIVE;
/*  895 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  896 */         i = 1000000;
/*      */         break;
/*      */       
/*      */       case 31:
/*  900 */         arrayOfXmlValueRef = FACETS_UNSIGNED_LONG;
/*  901 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  902 */         i = 1000000;
/*      */         break;
/*      */       
/*      */       case 32:
/*  906 */         arrayOfXmlValueRef = FACETS_UNSIGNED_INT;
/*  907 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  908 */         i = 64;
/*      */         break;
/*      */       
/*      */       case 33:
/*  912 */         arrayOfXmlValueRef = FACETS_UNSIGNED_SHORT;
/*  913 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  914 */         i = 32;
/*      */         break;
/*      */       
/*      */       case 34:
/*  918 */         arrayOfXmlValueRef = FACETS_UNSIGNED_BYTE;
/*  919 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  920 */         i = 16;
/*      */         break;
/*      */ 
/*      */ 
/*      */       
/*      */       case 35:
/*  926 */         arrayOfXmlValueRef = FACETS_WS_REPLACE;
/*  927 */         arrayOfBoolean = FIXED_FACETS_NONE;
/*  928 */         b2 = 2;
/*      */         break;
/*      */       
/*      */       case 36:
/*      */       case 37:
/*      */       case 38:
/*      */       case 39:
/*      */       case 40:
/*      */       case 41:
/*      */       case 42:
/*      */       case 43:
/*      */       case 45:
/*  940 */         arrayOfXmlValueRef = FACETS_WS_COLLAPSE;
/*  941 */         arrayOfBoolean = FIXED_FACETS_NONE;
/*  942 */         b2 = 3;
/*      */         break;
/*      */       
/*      */       case 44:
/*      */       case 46:
/*  947 */         arrayOfXmlValueRef = FACETS_BUILTIN_LIST;
/*  948 */         arrayOfBoolean = FIXED_FACETS_NONE;
/*  949 */         b2 = 0;
/*      */         break;
/*      */       
/*      */       case 53:
/*      */       case 54:
/*  954 */         arrayOfXmlValueRef = FACETS_WS_COLLAPSE;
/*  955 */         arrayOfBoolean = FIXED_FACETS_WS;
/*  956 */         b2 = 3;
/*      */         break;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  962 */     byte b3 = 0;
/*  963 */     boolean bool2 = false;
/*  964 */     boolean bool3 = false;
/*  965 */     boolean bool4 = false;
/*      */     
/*  967 */     switch (paramInt) {
/*      */       default:
/*      */         assert false;
/*      */         break;
/*      */       
/*      */       case 0:
/*      */       case 1:
/*      */       case 2:
/*      */       case 4:
/*      */       case 5:
/*      */       case 6:
/*      */       case 7:
/*      */       case 8:
/*      */       case 12:
/*      */       case 35:
/*      */       case 36:
/*      */       case 37:
/*      */       case 38:
/*      */       case 39:
/*      */       case 40:
/*      */       case 41:
/*      */       case 42:
/*      */       case 43:
/*      */       case 44:
/*      */       case 45:
/*      */       case 46:
/*      */       case 52:
/*      */         break;
/*      */       
/*      */       case 3:
/*  997 */         bool3 = true;
/*      */         break;
/*      */ 
/*      */       
/*      */       case 9:
/*      */       case 10:
/*      */       case 11:
/*      */       case 22:
/* 1005 */         bool2 = true;
/* 1006 */         b3 = 2;
/*      */         break;
/*      */       
/*      */       case 13:
/*      */       case 14:
/*      */       case 15:
/*      */       case 16:
/*      */       case 17:
/*      */       case 18:
/*      */       case 19:
/*      */       case 20:
/*      */       case 21:
/*      */       case 53:
/*      */       case 54:
/* 1020 */         b3 = 1;
/*      */         break;
/*      */       
/*      */       case 23:
/*      */       case 24:
/*      */       case 25:
/*      */       case 26:
/*      */       case 27:
/*      */       case 28:
/*      */       case 29:
/*      */       case 30:
/*      */       case 31:
/*      */       case 32:
/*      */       case 33:
/*      */       case 34:
/* 1035 */         bool2 = true;
/* 1036 */         b3 = 2;
/* 1037 */         bool3 = true;
/* 1038 */         bool4 = true;
/*      */         break;
/*      */     } 
/*      */     
/* 1042 */     schemaTypeImpl1.setBasicFacets(arrayOfXmlValueRef, arrayOfBoolean);
/* 1043 */     schemaTypeImpl1.setWhiteSpaceRule(b2);
/* 1044 */     schemaTypeImpl1.setOrdered(b3);
/* 1045 */     schemaTypeImpl1.setBounded(bool4);
/* 1046 */     schemaTypeImpl1.setNumeric(bool2);
/* 1047 */     schemaTypeImpl1.setFinite(bool3);
/* 1048 */     schemaTypeImpl1.setDecimalSize(i);
/* 1049 */     schemaTypeImpl1.setAnonymousTypeRefs(EMPTY_SCHEMATYPEREF_ARRAY);
/*      */     
/* 1051 */     String str = null;
/* 1052 */     boolean bool5 = false;
/*      */     
/* 1054 */     switch (paramInt) {
/*      */       
/*      */       case 39:
/* 1057 */         str = "[a-zA-Z]{1,8}(-[a-zA-Z0-9]{1,8})*";
/* 1058 */         bool5 = true;
/*      */         break;
/*      */       case 45:
/* 1061 */         str = "\\c+";
/* 1062 */         bool5 = true;
/*      */         break;
/*      */       case 37:
/* 1065 */         str = "\\i\\c*";
/* 1066 */         bool5 = true;
/*      */         break;
/*      */       case 38:
/* 1069 */         str = "[\\i-[:]][\\c-[:]]*";
/* 1070 */         bool5 = true;
/*      */         break;
/*      */       case 53:
/* 1073 */         str = "[^YM]*[DT].*";
/* 1074 */         bool5 = true;
/*      */         break;
/*      */       case 54:
/* 1077 */         str = "[^DT]*";
/* 1078 */         bool5 = true;
/*      */         break;
/*      */ 
/*      */       
/*      */       case 40:
/*      */       case 41:
/*      */       case 43:
/* 1085 */         bool5 = true;
/*      */         break;
/*      */     } 
/*      */     
/* 1089 */     if (str != null) {
/*      */       
/* 1091 */       RegularExpression regularExpression = null; 
/* 1092 */       try { regularExpression = SchemaRegularExpression.forPattern(str); }
/*      */       catch (ParseException parseException) { assert false; }
/* 1094 */        schemaTypeImpl1.setPatterns(new RegularExpression[] { regularExpression });
/*      */     } 
/* 1096 */     schemaTypeImpl1.setPatternFacet(bool5);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1101 */     if (paramInt == 1) {
/*      */       
/* 1103 */       SchemaParticleImpl schemaParticleImpl = new SchemaParticleImpl();
/* 1104 */       schemaParticleImpl.setParticleType(5);
/* 1105 */       schemaParticleImpl.setWildcardSet(QNameSet.ALL);
/* 1106 */       schemaParticleImpl.setWildcardProcess(2);
/* 1107 */       schemaParticleImpl.setMinOccurs(BigInteger.ZERO);
/* 1108 */       schemaParticleImpl.setMaxOccurs(null);
/* 1109 */       schemaParticleImpl.setTransitionRules(QNameSet.ALL, true);
/* 1110 */       schemaParticleImpl.setTransitionNotes(QNameSet.ALL, true);
/*      */       
/* 1112 */       SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
/* 1113 */       schemaAttributeModelImpl.setWildcardProcess(2);
/* 1114 */       schemaAttributeModelImpl.setWildcardSet(QNameSet.ALL);
/*      */       
/* 1116 */       schemaTypeImpl1.setComplexTypeVariety(4);
/* 1117 */       schemaTypeImpl1.setContentModel(schemaParticleImpl, schemaAttributeModelImpl, Collections.EMPTY_MAP, Collections.EMPTY_MAP, false);
/* 1118 */       schemaTypeImpl1.setAnonymousTypeRefs(EMPTY_SCHEMATYPEREF_ARRAY);
/* 1119 */       schemaTypeImpl1.setWildcardSummary(QNameSet.ALL, true, QNameSet.ALL, true);
/*      */     }
/* 1121 */     else if (paramInt == 0) {
/*      */ 
/*      */       
/* 1124 */       SchemaParticle schemaParticle = null;
/* 1125 */       SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
/* 1126 */       schemaTypeImpl1.setComplexTypeVariety(1);
/* 1127 */       schemaTypeImpl1.setContentModel(schemaParticle, schemaAttributeModelImpl, Collections.EMPTY_MAP, Collections.EMPTY_MAP, false);
/* 1128 */       schemaTypeImpl1.setAnonymousTypeRefs(EMPTY_SCHEMATYPEREF_ARRAY);
/* 1129 */       schemaTypeImpl1.setWildcardSummary(QNameSet.EMPTY, false, QNameSet.EMPTY, false);
/*      */     } 
/*      */     
/* 1132 */     schemaTypeImpl1.setOrderSensitive(false);
/*      */   }
/*      */ 
/*      */   
/*      */   public static SchemaType getNoType() {
/* 1137 */     return ST_NO_TYPE;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\XQuerySchemaTypeSystem.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */