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
/*      */ public class BuiltinSchemaTypeSystem
/*      */   extends SchemaTypeLoaderBase
/*      */   implements SchemaTypeSystem
/*      */ {
/*      */   public static SchemaTypeSystem get() {
/*   51 */     return _global;
/*      */   }
/*      */   
/*   54 */   private static final SchemaType[] EMPTY_SCHEMATYPE_ARRAY = new SchemaType[0];
/*   55 */   private static final SchemaType.Ref[] EMPTY_SCHEMATYPEREF_ARRAY = new SchemaType.Ref[0];
/*   56 */   private static final SchemaGlobalElement[] EMPTY_SCHEMAELEMENT_ARRAY = new SchemaGlobalElement[0];
/*   57 */   private static final SchemaGlobalAttribute[] EMPTY_SCHEMAATTRIBUTE_ARRAY = new SchemaGlobalAttribute[0];
/*   58 */   private static final SchemaModelGroup[] EMPTY_SCHEMAMODELGROUP_ARRAY = new SchemaModelGroup[0];
/*   59 */   private static final SchemaAttributeGroup[] EMPTY_SCHEMAATTRIBUTEGROUP_ARRAY = new SchemaAttributeGroup[0];
/*   60 */   private static final SchemaAnnotation[] EMPTY_SCHEMAANNOTATION_ARRAY = new SchemaAnnotation[0];
/*      */   
/*   62 */   private static BuiltinSchemaTypeSystem _global = new BuiltinSchemaTypeSystem();
/*      */ 
/*      */   
/*   65 */   public static final SchemaTypeImpl ST_ANY_TYPE = _global.getBuiltinType(1);
/*   66 */   public static final SchemaTypeImpl ST_ANY_SIMPLE = _global.getBuiltinType(2);
/*      */ 
/*      */   
/*   69 */   public static final SchemaTypeImpl ST_BOOLEAN = _global.getBuiltinType(3);
/*   70 */   public static final SchemaTypeImpl ST_BASE_64_BINARY = _global.getBuiltinType(4);
/*   71 */   public static final SchemaTypeImpl ST_HEX_BINARY = _global.getBuiltinType(5);
/*   72 */   public static final SchemaTypeImpl ST_ANY_URI = _global.getBuiltinType(6);
/*   73 */   public static final SchemaTypeImpl ST_QNAME = _global.getBuiltinType(7);
/*   74 */   public static final SchemaTypeImpl ST_NOTATION = _global.getBuiltinType(8);
/*   75 */   public static final SchemaTypeImpl ST_FLOAT = _global.getBuiltinType(9);
/*   76 */   public static final SchemaTypeImpl ST_DOUBLE = _global.getBuiltinType(10);
/*   77 */   public static final SchemaTypeImpl ST_DECIMAL = _global.getBuiltinType(11);
/*   78 */   public static final SchemaTypeImpl ST_STRING = _global.getBuiltinType(12);
/*      */   
/*   80 */   public static final SchemaTypeImpl ST_DURATION = _global.getBuiltinType(13);
/*   81 */   public static final SchemaTypeImpl ST_DATE_TIME = _global.getBuiltinType(14);
/*   82 */   public static final SchemaTypeImpl ST_TIME = _global.getBuiltinType(15);
/*   83 */   public static final SchemaTypeImpl ST_DATE = _global.getBuiltinType(16);
/*   84 */   public static final SchemaTypeImpl ST_G_YEAR_MONTH = _global.getBuiltinType(17);
/*   85 */   public static final SchemaTypeImpl ST_G_YEAR = _global.getBuiltinType(18);
/*   86 */   public static final SchemaTypeImpl ST_G_MONTH_DAY = _global.getBuiltinType(19);
/*   87 */   public static final SchemaTypeImpl ST_G_DAY = _global.getBuiltinType(20);
/*   88 */   public static final SchemaTypeImpl ST_G_MONTH = _global.getBuiltinType(21);
/*      */ 
/*      */   
/*   91 */   public static final SchemaTypeImpl ST_INTEGER = _global.getBuiltinType(22);
/*   92 */   public static final SchemaTypeImpl ST_LONG = _global.getBuiltinType(23);
/*   93 */   public static final SchemaTypeImpl ST_INT = _global.getBuiltinType(24);
/*   94 */   public static final SchemaTypeImpl ST_SHORT = _global.getBuiltinType(25);
/*   95 */   public static final SchemaTypeImpl ST_BYTE = _global.getBuiltinType(26);
/*   96 */   public static final SchemaTypeImpl ST_NON_POSITIVE_INTEGER = _global.getBuiltinType(27);
/*   97 */   public static final SchemaTypeImpl ST_NEGATIVE_INTEGER = _global.getBuiltinType(28);
/*   98 */   public static final SchemaTypeImpl ST_NON_NEGATIVE_INTEGER = _global.getBuiltinType(29);
/*   99 */   public static final SchemaTypeImpl ST_POSITIVE_INTEGER = _global.getBuiltinType(30);
/*  100 */   public static final SchemaTypeImpl ST_UNSIGNED_LONG = _global.getBuiltinType(31);
/*  101 */   public static final SchemaTypeImpl ST_UNSIGNED_INT = _global.getBuiltinType(32);
/*  102 */   public static final SchemaTypeImpl ST_UNSIGNED_SHORT = _global.getBuiltinType(33);
/*  103 */   public static final SchemaTypeImpl ST_UNSIGNED_BYTE = _global.getBuiltinType(34);
/*      */ 
/*      */   
/*  106 */   public static final SchemaTypeImpl ST_NORMALIZED_STRING = _global.getBuiltinType(35);
/*  107 */   public static final SchemaTypeImpl ST_TOKEN = _global.getBuiltinType(36);
/*  108 */   public static final SchemaTypeImpl ST_NAME = _global.getBuiltinType(37);
/*  109 */   public static final SchemaTypeImpl ST_NCNAME = _global.getBuiltinType(38);
/*  110 */   public static final SchemaTypeImpl ST_LANGUAGE = _global.getBuiltinType(39);
/*  111 */   public static final SchemaTypeImpl ST_ID = _global.getBuiltinType(40);
/*  112 */   public static final SchemaTypeImpl ST_IDREF = _global.getBuiltinType(41);
/*  113 */   public static final SchemaTypeImpl ST_IDREFS = _global.getBuiltinType(42);
/*  114 */   public static final SchemaTypeImpl ST_ENTITY = _global.getBuiltinType(43);
/*  115 */   public static final SchemaTypeImpl ST_ENTITIES = _global.getBuiltinType(44);
/*  116 */   public static final SchemaTypeImpl ST_NMTOKEN = _global.getBuiltinType(45);
/*  117 */   public static final SchemaTypeImpl ST_NMTOKENS = _global.getBuiltinType(46);
/*      */ 
/*      */   
/*  120 */   public static final SchemaTypeImpl ST_NO_TYPE = _global.getBuiltinType(0);
/*      */   
/*  122 */   private static final XmlValueRef XMLSTR_PRESERVE = buildString("preserve");
/*  123 */   private static final XmlValueRef XMLSTR_REPLACE = buildString("preserve");
/*  124 */   private static final XmlValueRef XMLSTR_COLLAPSE = buildString("preserve");
/*      */   
/*  126 */   private static final XmlValueRef[] FACETS_NONE = new XmlValueRef[] { null, null, null, null, null, null, null, null, null, null, null, null };
/*      */ 
/*      */ 
/*      */   
/*  130 */   private static final boolean[] FIXED_FACETS_NONE = new boolean[] { 
/*      */       false, false, false, false, false, false, false, false, false, false, 
/*      */       false, false };
/*      */   
/*  134 */   private static final XmlValueRef[] FACETS_WS_COLLAPSE = new XmlValueRef[] { null, null, null, null, null, null, null, null, null, build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  138 */   private static final XmlValueRef[] FACETS_WS_REPLACE = new XmlValueRef[] { null, null, null, null, null, null, null, null, null, build_wsstring(2), null, null };
/*      */ 
/*      */ 
/*      */   
/*  142 */   private static final XmlValueRef[] FACETS_WS_PRESERVE = new XmlValueRef[] { null, null, null, null, null, null, null, null, null, build_wsstring(1), null, null };
/*      */ 
/*      */ 
/*      */   
/*  146 */   private static final XmlValueRef[] FACETS_INTEGER = new XmlValueRef[] { null, null, null, null, null, null, null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  150 */   private static final XmlValueRef[] FACETS_LONG = new XmlValueRef[] { null, null, null, null, buildInteger(BigInteger.valueOf(Long.MIN_VALUE)), buildInteger(BigInteger.valueOf(Long.MAX_VALUE)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  154 */   private static final XmlValueRef[] FACETS_INT = new XmlValueRef[] { null, null, null, null, buildInteger(BigInteger.valueOf(-2147483648L)), buildInteger(BigInteger.valueOf(2147483647L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  158 */   private static final XmlValueRef[] FACETS_SHORT = new XmlValueRef[] { null, null, null, null, buildInteger(BigInteger.valueOf(-32768L)), buildInteger(BigInteger.valueOf(32767L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  162 */   private static final XmlValueRef[] FACETS_BYTE = new XmlValueRef[] { null, null, null, null, buildInteger(BigInteger.valueOf(-128L)), buildInteger(BigInteger.valueOf(127L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  166 */   private static final XmlValueRef[] FACETS_NONNEGATIVE = new XmlValueRef[] { null, null, null, null, buildInteger(BigInteger.ZERO), null, null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  170 */   private static final XmlValueRef[] FACETS_POSITIVE = new XmlValueRef[] { null, null, null, null, buildInteger(BigInteger.ONE), null, null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  174 */   private static final XmlValueRef[] FACETS_NONPOSITIVE = new XmlValueRef[] { null, null, null, null, null, buildInteger(BigInteger.ZERO), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  178 */   private static final XmlValueRef[] FACETS_NEGATIVE = new XmlValueRef[] { null, null, null, null, null, buildInteger(BigInteger.ONE.negate()), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  182 */   private static final XmlValueRef[] FACETS_UNSIGNED_LONG = new XmlValueRef[] { null, null, null, null, buildInteger(BigInteger.ZERO), buildInteger(new BigInteger("18446744073709551615")), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  186 */   private static final XmlValueRef[] FACETS_UNSIGNED_INT = new XmlValueRef[] { null, null, null, null, buildInteger(BigInteger.ZERO), buildInteger(BigInteger.valueOf(4294967295L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  190 */   private static final XmlValueRef[] FACETS_UNSIGNED_SHORT = new XmlValueRef[] { null, null, null, null, buildInteger(BigInteger.ZERO), buildInteger(BigInteger.valueOf(65535L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  194 */   private static final XmlValueRef[] FACETS_UNSIGNED_BYTE = new XmlValueRef[] { null, null, null, null, buildInteger(BigInteger.ZERO), buildInteger(BigInteger.valueOf(255L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  198 */   private static final XmlValueRef[] FACETS_BUILTIN_LIST = new XmlValueRef[] { null, buildNnInteger(BigInteger.ONE), null, null, null, null, null, null, null, build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/*  202 */   private static final boolean[] FIXED_FACETS_WS = new boolean[] { 
/*      */       false, false, false, false, false, false, false, false, false, true, 
/*      */       false, false };
/*      */   
/*  206 */   private static final boolean[] FIXED_FACETS_INTEGER = new boolean[] { 
/*      */       false, false, false, false, false, false, false, false, true, true, 
/*      */       false, false };
/*      */   
/*  210 */   static final XmlValueRef[] FACETS_UNION = FACETS_NONE;
/*  211 */   static final boolean[] FIXED_FACETS_UNION = FIXED_FACETS_NONE;
/*      */   
/*  213 */   static final XmlValueRef[] FACETS_LIST = FACETS_WS_COLLAPSE;
/*  214 */   static final boolean[] FIXED_FACETS_LIST = FIXED_FACETS_WS;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/*  221 */     for (byte b = 0; b <= 46; b++)
/*      */     {
/*  223 */       _global.fillInType(b);
/*      */     }
/*      */   }
/*      */   
/*  227 */   private Map _typeMap = new HashMap();
/*  228 */   private SchemaTypeImpl[] _typeArray = new SchemaTypeImpl[47];
/*  229 */   private Map _handlesToObjects = new HashMap();
/*  230 */   private Map _objectsToHandles = new HashMap();
/*  231 */   private Map _typesByClassname = new HashMap();
/*  232 */   private SchemaContainer _container = new SchemaContainer("http://www.w3.org/2001/XMLSchema");
/*      */   static final boolean $assertionsDisabled;
/*      */   
/*      */   private SchemaTypeImpl getBuiltinType(int paramInt) {
/*  236 */     return this._typeArray[paramInt];
/*      */   }
/*      */ 
/*      */   
/*      */   private BuiltinSchemaTypeSystem() {
/*  241 */     this._container.setTypeSystem(this);
/*      */     
/*  243 */     setupBuiltin(1, "anyType", "org.apache.xmlbeans.XmlObject");
/*  244 */     setupBuiltin(2, "anySimpleType", "org.apache.xmlbeans.XmlAnySimpleType");
/*      */ 
/*      */     
/*  247 */     setupBuiltin(3, "boolean", "org.apache.xmlbeans.XmlBoolean");
/*  248 */     setupBuiltin(4, "base64Binary", "org.apache.xmlbeans.XmlBase64Binary");
/*  249 */     setupBuiltin(5, "hexBinary", "org.apache.xmlbeans.XmlHexBinary");
/*  250 */     setupBuiltin(6, "anyURI", "org.apache.xmlbeans.XmlAnyURI");
/*  251 */     setupBuiltin(7, "QName", "org.apache.xmlbeans.XmlQName");
/*  252 */     setupBuiltin(8, "NOTATION", "org.apache.xmlbeans.XmlNOTATION");
/*  253 */     setupBuiltin(9, "float", "org.apache.xmlbeans.XmlFloat");
/*  254 */     setupBuiltin(10, "double", "org.apache.xmlbeans.XmlDouble");
/*  255 */     setupBuiltin(11, "decimal", "org.apache.xmlbeans.XmlDecimal");
/*  256 */     setupBuiltin(12, "string", "org.apache.xmlbeans.XmlString");
/*      */     
/*  258 */     setupBuiltin(13, "duration", "org.apache.xmlbeans.XmlDuration");
/*  259 */     setupBuiltin(14, "dateTime", "org.apache.xmlbeans.XmlDateTime");
/*  260 */     setupBuiltin(15, "time", "org.apache.xmlbeans.XmlTime");
/*  261 */     setupBuiltin(16, "date", "org.apache.xmlbeans.XmlDate");
/*  262 */     setupBuiltin(17, "gYearMonth", "org.apache.xmlbeans.XmlGYearMonth");
/*  263 */     setupBuiltin(18, "gYear", "org.apache.xmlbeans.XmlGYear");
/*  264 */     setupBuiltin(19, "gMonthDay", "org.apache.xmlbeans.XmlGMonthDay");
/*  265 */     setupBuiltin(20, "gDay", "org.apache.xmlbeans.XmlGDay");
/*  266 */     setupBuiltin(21, "gMonth", "org.apache.xmlbeans.XmlGMonth");
/*      */ 
/*      */     
/*  269 */     setupBuiltin(22, "integer", "org.apache.xmlbeans.XmlInteger");
/*  270 */     setupBuiltin(23, "long", "org.apache.xmlbeans.XmlLong");
/*  271 */     setupBuiltin(24, "int", "org.apache.xmlbeans.XmlInt");
/*  272 */     setupBuiltin(25, "short", "org.apache.xmlbeans.XmlShort");
/*  273 */     setupBuiltin(26, "byte", "org.apache.xmlbeans.XmlByte");
/*  274 */     setupBuiltin(27, "nonPositiveInteger", "org.apache.xmlbeans.XmlNonPositiveInteger");
/*  275 */     setupBuiltin(28, "negativeInteger", "org.apache.xmlbeans.XmlNegativeInteger");
/*  276 */     setupBuiltin(29, "nonNegativeInteger", "org.apache.xmlbeans.XmlNonNegativeInteger");
/*  277 */     setupBuiltin(30, "positiveInteger", "org.apache.xmlbeans.XmlPositiveInteger");
/*  278 */     setupBuiltin(31, "unsignedLong", "org.apache.xmlbeans.XmlUnsignedLong");
/*  279 */     setupBuiltin(32, "unsignedInt", "org.apache.xmlbeans.XmlUnsignedInt");
/*  280 */     setupBuiltin(33, "unsignedShort", "org.apache.xmlbeans.XmlUnsignedShort");
/*  281 */     setupBuiltin(34, "unsignedByte", "org.apache.xmlbeans.XmlUnsignedByte");
/*      */ 
/*      */     
/*  284 */     setupBuiltin(35, "normalizedString", "org.apache.xmlbeans.XmlNormalizedString");
/*  285 */     setupBuiltin(36, "token", "org.apache.xmlbeans.XmlToken");
/*  286 */     setupBuiltin(37, "Name", "org.apache.xmlbeans.XmlName");
/*  287 */     setupBuiltin(38, "NCName", "org.apache.xmlbeans.XmlNCName");
/*  288 */     setupBuiltin(39, "language", "org.apache.xmlbeans.XmlLanguage");
/*  289 */     setupBuiltin(40, "ID", "org.apache.xmlbeans.XmlID");
/*  290 */     setupBuiltin(41, "IDREF", "org.apache.xmlbeans.XmlIDREF");
/*  291 */     setupBuiltin(42, "IDREFS", "org.apache.xmlbeans.XmlIDREFS");
/*  292 */     setupBuiltin(43, "ENTITY", "org.apache.xmlbeans.XmlENTITY");
/*  293 */     setupBuiltin(44, "ENTITIES", "org.apache.xmlbeans.XmlENTITIES");
/*  294 */     setupBuiltin(45, "NMTOKEN", "org.apache.xmlbeans.XmlNMTOKEN");
/*  295 */     setupBuiltin(46, "NMTOKENS", "org.apache.xmlbeans.XmlNMTOKENS");
/*      */ 
/*      */     
/*  298 */     setupBuiltin(0, null, null);
/*  299 */     this._container.setImmutable();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getName() {
/*  308 */     return "schema.typesystem.builtin";
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isNamespaceDefined(String paramString) {
/*  313 */     return paramString.equals("http://www.w3.org/2001/XMLSchema");
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaType findType(b paramb) {
/*  318 */     return (SchemaType)this._typeMap.get(paramb);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaType findDocumentType(b paramb) {
/*  324 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaType findAttributeType(b paramb) {
/*  329 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaGlobalElement findElement(b paramb) {
/*  334 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaGlobalAttribute findAttribute(b paramb) {
/*  339 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaType.Ref findTypeRef(b paramb) {
/*  344 */     SchemaType schemaType = findType(paramb);
/*  345 */     return (schemaType == null) ? null : schemaType.getRef();
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaType.Ref findDocumentTypeRef(b paramb) {
/*  350 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaType.Ref findAttributeTypeRef(b paramb) {
/*  355 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaGlobalElement.Ref findElementRef(b paramb) {
/*  360 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaGlobalAttribute.Ref findAttributeRef(b paramb) {
/*  365 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaModelGroup.Ref findModelGroupRef(b paramb) {
/*  370 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaAttributeGroup.Ref findAttributeGroupRef(b paramb) {
/*  375 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaIdentityConstraint.Ref findIdentityConstraintRef(b paramb) {
/*  380 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaType typeForClassname(String paramString) {
/*  385 */     return (SchemaType)this._typesByClassname.get(paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   public InputStream getSourceAsStream(String paramString) {
/*  390 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaType[] globalTypes() {
/*  398 */     SchemaType[] arrayOfSchemaType = new SchemaType[this._typeArray.length - 1];
/*  399 */     System.arraycopy(this._typeArray, 1, arrayOfSchemaType, 0, arrayOfSchemaType.length);
/*  400 */     return arrayOfSchemaType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaType[] documentTypes() {
/*  408 */     return EMPTY_SCHEMATYPE_ARRAY;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaType[] attributeTypes() {
/*  416 */     return EMPTY_SCHEMATYPE_ARRAY;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaGlobalElement[] globalElements() {
/*  424 */     return EMPTY_SCHEMAELEMENT_ARRAY;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaGlobalAttribute[] globalAttributes() {
/*  432 */     return EMPTY_SCHEMAATTRIBUTE_ARRAY;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaModelGroup[] modelGroups() {
/*  440 */     return EMPTY_SCHEMAMODELGROUP_ARRAY;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaAttributeGroup[] attributeGroups() {
/*  448 */     return EMPTY_SCHEMAATTRIBUTEGROUP_ARRAY;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaAnnotation[] annotations() {
/*  456 */     return EMPTY_SCHEMAANNOTATION_ARRAY;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String handleForType(SchemaType paramSchemaType) {
/*  464 */     return (String)this._objectsToHandles.get(paramSchemaType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassLoader getClassLoader() {
/*  472 */     return BuiltinSchemaTypeSystem.class.getClassLoader();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void saveToDirectory(File paramFile) {
/*  480 */     throw new UnsupportedOperationException("The builtin schema type system cannot be saved.");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void save(Filer paramFiler) {
/*  488 */     throw new UnsupportedOperationException("The builtin schema type system cannot be saved.");
/*      */   }
/*      */ 
/*      */   
/*      */   private static XmlValueRef build_wsstring(int paramInt) {
/*  493 */     switch (paramInt) {
/*      */       
/*      */       case 1:
/*  496 */         return XMLSTR_PRESERVE;
/*      */       case 2:
/*  498 */         return XMLSTR_REPLACE;
/*      */       case 3:
/*  500 */         return XMLSTR_COLLAPSE;
/*      */     } 
/*  502 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private static XmlValueRef buildNnInteger(BigInteger paramBigInteger) {
/*  507 */     if (paramBigInteger == null)
/*  508 */       return null; 
/*  509 */     if (paramBigInteger.signum() < 0) {
/*  510 */       return null;
/*      */     }
/*      */     try {
/*  513 */       XmlIntegerImpl xmlIntegerImpl = new XmlIntegerImpl();
/*  514 */       xmlIntegerImpl.set(paramBigInteger);
/*  515 */       xmlIntegerImpl.setImmutable();
/*  516 */       return new XmlValueRef((XmlAnySimpleType)xmlIntegerImpl);
/*      */     }
/*  518 */     catch (XmlValueOutOfRangeException xmlValueOutOfRangeException) {
/*      */       
/*  520 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static XmlValueRef buildInteger(BigInteger paramBigInteger) {
/*  526 */     if (paramBigInteger == null) {
/*  527 */       return null;
/*      */     }
/*      */     try {
/*  530 */       XmlIntegerImpl xmlIntegerImpl = new XmlIntegerImpl();
/*  531 */       xmlIntegerImpl.set(paramBigInteger);
/*  532 */       xmlIntegerImpl.setImmutable();
/*  533 */       return new XmlValueRef((XmlAnySimpleType)xmlIntegerImpl);
/*      */     }
/*  535 */     catch (XmlValueOutOfRangeException xmlValueOutOfRangeException) {
/*      */       
/*  537 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static XmlValueRef buildString(String paramString) {
/*  543 */     if (paramString == null) {
/*  544 */       return null;
/*      */     }
/*      */     
/*      */     try {
/*  548 */       XmlStringImpl xmlStringImpl = new XmlStringImpl();
/*  549 */       xmlStringImpl.set(paramString);
/*  550 */       xmlStringImpl.setImmutable();
/*  551 */       return new XmlValueRef((XmlAnySimpleType)xmlStringImpl);
/*      */     }
/*  553 */     catch (XmlValueOutOfRangeException xmlValueOutOfRangeException) {
/*      */       
/*  555 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void setupBuiltin(int paramInt, String paramString1, String paramString2) {
/*  561 */     SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(this._container, true);
/*  562 */     this._container.addGlobalType(schemaTypeImpl.getRef());
/*  563 */     b b = (paramString1 == null) ? null : QNameHelper.forLNS(paramString1, "http://www.w3.org/2001/XMLSchema");
/*  564 */     String str = "_BI_" + ((paramString1 == null) ? "NO_TYPE" : paramString1);
/*  565 */     schemaTypeImpl.setName(b);
/*  566 */     schemaTypeImpl.setBuiltinTypeCode(paramInt);
/*  567 */     if (paramString2 != null) {
/*  568 */       schemaTypeImpl.setFullJavaName(paramString2);
/*      */     }
/*  570 */     this._typeArray[paramInt] = schemaTypeImpl;
/*  571 */     this._typeMap.put(b, schemaTypeImpl);
/*  572 */     this._handlesToObjects.put(str, schemaTypeImpl);
/*  573 */     this._objectsToHandles.put(schemaTypeImpl, str);
/*  574 */     if (paramString2 != null) {
/*  575 */       this._typesByClassname.put(paramString2, schemaTypeImpl);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void resolve() {}
/*      */ 
/*      */   
/*      */   public SchemaType typeForHandle(String paramString) {
/*  585 */     return (SchemaType)this._handlesToObjects.get(paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaComponent resolveHandle(String paramString) {
/*  590 */     return (SchemaComponent)this._handlesToObjects.get(paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   public void fillInType(int paramInt) {
/*      */     SchemaTypeImpl schemaTypeImpl2;
/*      */     XmlValueRef[] arrayOfXmlValueRef;
/*      */     boolean[] arrayOfBoolean;
/*  598 */     SchemaTypeImpl schemaTypeImpl1 = getBuiltinType(paramInt);
/*      */     
/*  600 */     SchemaTypeImpl schemaTypeImpl3 = null;
/*  601 */     byte b1 = 1;
/*  602 */     boolean bool1 = true;
/*      */     
/*  604 */     switch (paramInt) {
/*      */       
/*      */       case 0:
/*  607 */         b1 = 0;
/*  608 */         schemaTypeImpl2 = ST_ANY_TYPE;
/*      */         break;
/*      */       
/*      */       case 1:
/*  612 */         b1 = 0;
/*  613 */         schemaTypeImpl2 = null;
/*  614 */         bool1 = true;
/*      */         break;
/*      */       
/*      */       default:
/*      */         assert false;
/*      */       
/*      */       case 2:
/*  621 */         schemaTypeImpl2 = ST_ANY_TYPE;
/*      */         break;
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
/*  642 */         schemaTypeImpl2 = ST_ANY_SIMPLE;
/*      */         break;
/*      */       
/*      */       case 22:
/*  646 */         schemaTypeImpl2 = ST_DECIMAL;
/*      */         break;
/*      */       case 23:
/*  649 */         schemaTypeImpl2 = ST_INTEGER;
/*      */         break;
/*      */       case 24:
/*  652 */         schemaTypeImpl2 = ST_LONG;
/*      */         break;
/*      */       case 25:
/*  655 */         schemaTypeImpl2 = ST_INT;
/*      */         break;
/*      */       case 26:
/*  658 */         schemaTypeImpl2 = ST_SHORT;
/*      */         break;
/*      */       case 27:
/*  661 */         schemaTypeImpl2 = ST_INTEGER;
/*      */         break;
/*      */       case 28:
/*  664 */         schemaTypeImpl2 = ST_NON_POSITIVE_INTEGER;
/*      */         break;
/*      */       case 29:
/*  667 */         schemaTypeImpl2 = ST_INTEGER;
/*      */         break;
/*      */       case 30:
/*  670 */         schemaTypeImpl2 = ST_NON_NEGATIVE_INTEGER;
/*      */         break;
/*      */       case 31:
/*  673 */         schemaTypeImpl2 = ST_NON_NEGATIVE_INTEGER;
/*      */         break;
/*      */       case 32:
/*  676 */         schemaTypeImpl2 = ST_UNSIGNED_LONG;
/*      */         break;
/*      */       case 33:
/*  679 */         schemaTypeImpl2 = ST_UNSIGNED_INT;
/*      */         break;
/*      */       case 34:
/*  682 */         schemaTypeImpl2 = ST_UNSIGNED_SHORT;
/*      */         break;
/*      */       
/*      */       case 35:
/*  686 */         schemaTypeImpl2 = ST_STRING;
/*      */         break;
/*      */       case 36:
/*  689 */         schemaTypeImpl2 = ST_NORMALIZED_STRING;
/*      */         break;
/*      */       case 37:
/*  692 */         schemaTypeImpl2 = ST_TOKEN;
/*      */         break;
/*      */       case 38:
/*  695 */         schemaTypeImpl2 = ST_NAME;
/*      */         break;
/*      */       case 40:
/*      */       case 41:
/*      */       case 43:
/*  700 */         schemaTypeImpl2 = ST_NCNAME;
/*      */         break;
/*      */       case 39:
/*      */       case 45:
/*  704 */         schemaTypeImpl2 = ST_TOKEN;
/*      */         break;
/*      */       case 42:
/*      */       case 44:
/*      */       case 46:
/*  709 */         b1 = 3;
/*  710 */         schemaTypeImpl2 = ST_ANY_SIMPLE;
/*  711 */         if (paramInt == 42) {
/*  712 */           schemaTypeImpl3 = ST_IDREF; break;
/*  713 */         }  if (paramInt == 44) {
/*  714 */           schemaTypeImpl3 = ST_ENTITY; break;
/*      */         } 
/*  716 */         schemaTypeImpl3 = ST_NMTOKEN;
/*      */         break;
/*      */     } 
/*      */     
/*  720 */     schemaTypeImpl1.setDerivationType(bool1);
/*  721 */     schemaTypeImpl1.setSimpleTypeVariety(b1);
/*  722 */     if (b1 != 0) {
/*      */       
/*  724 */       schemaTypeImpl1.setSimpleType(true);
/*      */     }
/*      */     else {
/*      */       
/*  728 */       assert paramInt == 1 || paramInt == 0;
/*      */     } 
/*  730 */     schemaTypeImpl1.setBaseTypeRef((schemaTypeImpl2 == null) ? null : schemaTypeImpl2.getRef());
/*  731 */     schemaTypeImpl1.setBaseDepth((schemaTypeImpl2 == null) ? 0 : (schemaTypeImpl2.getBaseDepth() + 1));
/*  732 */     schemaTypeImpl1.setListItemTypeRef((schemaTypeImpl3 == null) ? null : schemaTypeImpl3.getRef());
/*  733 */     if (paramInt >= 2 && paramInt <= 21) {
/*  734 */       schemaTypeImpl1.setPrimitiveTypeRef(schemaTypeImpl1.getRef());
/*  735 */     } else if (b1 == 1) {
/*      */       
/*  737 */       if (schemaTypeImpl2 == null)
/*  738 */         throw new IllegalStateException("Base was null for " + paramInt); 
/*  739 */       if (schemaTypeImpl2.getPrimitiveType() == null)
/*  740 */         throw new IllegalStateException("Base.gpt was null for " + paramInt); 
/*  741 */       schemaTypeImpl1.setPrimitiveTypeRef(schemaTypeImpl2.getPrimitiveType().getRef());
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  746 */     byte b2 = 3;
/*  747 */     int i = 0;
/*      */ 
/*      */     
/*  750 */     switch (paramInt) {
/*      */       default:
/*      */         assert false;
/*      */ 
/*      */       
/*      */       case 0:
/*      */       case 1:
/*      */       case 2:
/*  758 */         arrayOfXmlValueRef = FACETS_NONE;
/*  759 */         arrayOfBoolean = FIXED_FACETS_NONE;
/*  760 */         b2 = 0;
/*      */         break;
/*      */       
/*      */       case 12:
/*  764 */         arrayOfXmlValueRef = FACETS_WS_PRESERVE;
/*  765 */         arrayOfBoolean = FIXED_FACETS_NONE;
/*  766 */         b2 = 1;
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
/*  786 */         arrayOfXmlValueRef = FACETS_WS_COLLAPSE;
/*  787 */         arrayOfBoolean = FIXED_FACETS_WS;
/*      */         break;
/*      */       
/*      */       case 11:
/*  791 */         arrayOfXmlValueRef = FACETS_WS_COLLAPSE;
/*  792 */         arrayOfBoolean = FIXED_FACETS_WS;
/*  793 */         i = 1000001;
/*      */         break;
/*      */ 
/*      */       
/*      */       case 22:
/*  798 */         arrayOfXmlValueRef = FACETS_INTEGER;
/*  799 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  800 */         i = 1000000;
/*      */         break;
/*      */       
/*      */       case 23:
/*  804 */         arrayOfXmlValueRef = FACETS_LONG;
/*  805 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  806 */         i = 64;
/*      */         break;
/*      */       
/*      */       case 24:
/*  810 */         arrayOfXmlValueRef = FACETS_INT;
/*  811 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  812 */         i = 32;
/*      */         break;
/*      */       
/*      */       case 25:
/*  816 */         arrayOfXmlValueRef = FACETS_SHORT;
/*  817 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  818 */         i = 16;
/*      */         break;
/*      */       
/*      */       case 26:
/*  822 */         arrayOfXmlValueRef = FACETS_BYTE;
/*  823 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  824 */         i = 8;
/*      */         break;
/*      */       
/*      */       case 27:
/*  828 */         arrayOfXmlValueRef = FACETS_NONPOSITIVE;
/*  829 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  830 */         i = 1000000;
/*      */         break;
/*      */       
/*      */       case 28:
/*  834 */         arrayOfXmlValueRef = FACETS_NEGATIVE;
/*  835 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  836 */         i = 1000000;
/*      */         break;
/*      */       
/*      */       case 29:
/*  840 */         arrayOfXmlValueRef = FACETS_NONNEGATIVE;
/*  841 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  842 */         i = 1000000;
/*      */         break;
/*      */       
/*      */       case 30:
/*  846 */         arrayOfXmlValueRef = FACETS_POSITIVE;
/*  847 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  848 */         i = 1000000;
/*      */         break;
/*      */       
/*      */       case 31:
/*  852 */         arrayOfXmlValueRef = FACETS_UNSIGNED_LONG;
/*  853 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  854 */         i = 1000000;
/*      */         break;
/*      */       
/*      */       case 32:
/*  858 */         arrayOfXmlValueRef = FACETS_UNSIGNED_INT;
/*  859 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  860 */         i = 64;
/*      */         break;
/*      */       
/*      */       case 33:
/*  864 */         arrayOfXmlValueRef = FACETS_UNSIGNED_SHORT;
/*  865 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  866 */         i = 32;
/*      */         break;
/*      */       
/*      */       case 34:
/*  870 */         arrayOfXmlValueRef = FACETS_UNSIGNED_BYTE;
/*  871 */         arrayOfBoolean = FIXED_FACETS_INTEGER;
/*  872 */         i = 16;
/*      */         break;
/*      */ 
/*      */ 
/*      */       
/*      */       case 35:
/*  878 */         arrayOfXmlValueRef = FACETS_WS_REPLACE;
/*  879 */         arrayOfBoolean = FIXED_FACETS_NONE;
/*  880 */         b2 = 2;
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
/*  892 */         arrayOfXmlValueRef = FACETS_WS_COLLAPSE;
/*  893 */         arrayOfBoolean = FIXED_FACETS_NONE;
/*  894 */         b2 = 3;
/*      */         break;
/*      */       
/*      */       case 44:
/*      */       case 46:
/*  899 */         arrayOfXmlValueRef = FACETS_BUILTIN_LIST;
/*  900 */         arrayOfBoolean = FIXED_FACETS_NONE;
/*  901 */         b2 = 0;
/*      */         break;
/*      */     } 
/*      */ 
/*      */     
/*  906 */     byte b3 = 0;
/*  907 */     boolean bool2 = false;
/*  908 */     boolean bool3 = false;
/*  909 */     boolean bool4 = false;
/*      */     
/*  911 */     switch (paramInt) {
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
/*      */         break;
/*      */       
/*      */       case 3:
/*  940 */         bool3 = true;
/*      */         break;
/*      */ 
/*      */       
/*      */       case 9:
/*      */       case 10:
/*      */       case 11:
/*      */       case 22:
/*  948 */         bool2 = true;
/*  949 */         b3 = 2;
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
/*  961 */         b3 = 1;
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
/*  976 */         bool2 = true;
/*  977 */         b3 = 2;
/*  978 */         bool3 = true;
/*  979 */         bool4 = true;
/*      */         break;
/*      */     } 
/*      */     
/*  983 */     schemaTypeImpl1.setBasicFacets(arrayOfXmlValueRef, arrayOfBoolean);
/*  984 */     schemaTypeImpl1.setWhiteSpaceRule(b2);
/*  985 */     schemaTypeImpl1.setOrdered(b3);
/*  986 */     schemaTypeImpl1.setBounded(bool4);
/*  987 */     schemaTypeImpl1.setNumeric(bool2);
/*  988 */     schemaTypeImpl1.setFinite(bool3);
/*  989 */     schemaTypeImpl1.setDecimalSize(i);
/*  990 */     schemaTypeImpl1.setAnonymousTypeRefs(EMPTY_SCHEMATYPEREF_ARRAY);
/*      */     
/*  992 */     String str = null;
/*  993 */     boolean bool5 = false;
/*      */     
/*  995 */     switch (paramInt) {
/*      */       
/*      */       case 39:
/*  998 */         str = "[a-zA-Z]{1,8}(-[a-zA-Z0-9]{1,8})*";
/*  999 */         bool5 = true;
/*      */         break;
/*      */       case 45:
/* 1002 */         str = "\\c+";
/* 1003 */         bool5 = true;
/*      */         break;
/*      */       case 37:
/* 1006 */         str = "\\i\\c*";
/* 1007 */         bool5 = true;
/*      */         break;
/*      */       case 38:
/* 1010 */         str = "[\\i-[:]][\\c-[:]]*";
/* 1011 */         bool5 = true;
/*      */         break;
/*      */ 
/*      */       
/*      */       case 40:
/*      */       case 41:
/*      */       case 43:
/* 1018 */         bool5 = true;
/*      */         break;
/*      */     } 
/*      */     
/* 1022 */     if (str != null) {
/*      */       
/* 1024 */       RegularExpression regularExpression = null; 
/* 1025 */       try { regularExpression = SchemaRegularExpression.forPattern(str); }
/*      */       catch (ParseException parseException) { assert false; }
/* 1027 */        schemaTypeImpl1.setPatterns(new RegularExpression[] { regularExpression });
/*      */     } 
/* 1029 */     schemaTypeImpl1.setPatternFacet(bool5);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1034 */     if (paramInt == 1) {
/*      */       
/* 1036 */       SchemaParticleImpl schemaParticleImpl = new SchemaParticleImpl();
/* 1037 */       schemaParticleImpl.setParticleType(5);
/* 1038 */       schemaParticleImpl.setWildcardSet(QNameSet.ALL);
/* 1039 */       schemaParticleImpl.setWildcardProcess(2);
/* 1040 */       schemaParticleImpl.setMinOccurs(BigInteger.ZERO);
/* 1041 */       schemaParticleImpl.setMaxOccurs(null);
/* 1042 */       schemaParticleImpl.setTransitionRules(QNameSet.ALL, true);
/* 1043 */       schemaParticleImpl.setTransitionNotes(QNameSet.ALL, true);
/*      */       
/* 1045 */       SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
/* 1046 */       schemaAttributeModelImpl.setWildcardProcess(2);
/* 1047 */       schemaAttributeModelImpl.setWildcardSet(QNameSet.ALL);
/*      */       
/* 1049 */       schemaTypeImpl1.setComplexTypeVariety(4);
/* 1050 */       schemaTypeImpl1.setContentModel(schemaParticleImpl, schemaAttributeModelImpl, Collections.EMPTY_MAP, Collections.EMPTY_MAP, false);
/* 1051 */       schemaTypeImpl1.setAnonymousTypeRefs(EMPTY_SCHEMATYPEREF_ARRAY);
/* 1052 */       schemaTypeImpl1.setWildcardSummary(QNameSet.ALL, true, QNameSet.ALL, true);
/*      */     }
/* 1054 */     else if (paramInt == 0) {
/*      */ 
/*      */       
/* 1057 */       SchemaParticle schemaParticle = null;
/* 1058 */       SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
/* 1059 */       schemaTypeImpl1.setComplexTypeVariety(1);
/* 1060 */       schemaTypeImpl1.setContentModel(schemaParticle, schemaAttributeModelImpl, Collections.EMPTY_MAP, Collections.EMPTY_MAP, false);
/* 1061 */       schemaTypeImpl1.setAnonymousTypeRefs(EMPTY_SCHEMATYPEREF_ARRAY);
/* 1062 */       schemaTypeImpl1.setWildcardSummary(QNameSet.EMPTY, false, QNameSet.EMPTY, false);
/*      */     } 
/*      */     
/* 1065 */     schemaTypeImpl1.setOrderSensitive(false);
/*      */   }
/*      */ 
/*      */   
/*      */   public static SchemaType getNoType() {
/* 1070 */     return ST_NO_TYPE;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\BuiltinSchemaTypeSystem.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */