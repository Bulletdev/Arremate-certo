/*     */ package org.apache.xmlbeans.impl.schema;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.InputStream;
/*     */ import java.math.BigInteger;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.Filer;
/*     */ import org.apache.xmlbeans.QNameSet;
/*     */ import org.apache.xmlbeans.SchemaAnnotation;
/*     */ import org.apache.xmlbeans.SchemaAttributeGroup;
/*     */ import org.apache.xmlbeans.SchemaComponent;
/*     */ import org.apache.xmlbeans.SchemaGlobalAttribute;
/*     */ import org.apache.xmlbeans.SchemaGlobalElement;
/*     */ import org.apache.xmlbeans.SchemaIdentityConstraint;
/*     */ import org.apache.xmlbeans.SchemaModelGroup;
/*     */ import org.apache.xmlbeans.SchemaParticle;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SchemaTypeSystem;
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
/*     */ 
/*     */ public class SoapEncSchemaTypeSystem
/*     */   extends SchemaTypeLoaderBase
/*     */   implements SchemaTypeSystem
/*     */ {
/*     */   public static final String SOAPENC = "http://schemas.xmlsoap.org/soap/encoding/";
/*     */   public static final String SOAP_ARRAY = "Array";
/*     */   public static final String ARRAY_TYPE = "arrayType";
/*     */   private static final String ATTR_ID = "id";
/*     */   private static final String ATTR_HREF = "href";
/*     */   private static final String ATTR_OFFSET = "offset";
/*  58 */   private static final SchemaType[] EMPTY_SCHEMATYPE_ARRAY = new SchemaType[0];
/*  59 */   private static final SchemaGlobalElement[] EMPTY_SCHEMAELEMENT_ARRAY = new SchemaGlobalElement[0];
/*  60 */   private static final SchemaModelGroup[] EMPTY_SCHEMAMODELGROUP_ARRAY = new SchemaModelGroup[0];
/*  61 */   private static final SchemaAttributeGroup[] EMPTY_SCHEMAATTRIBUTEGROUP_ARRAY = new SchemaAttributeGroup[0];
/*  62 */   private static final SchemaAnnotation[] EMPTY_SCHEMAANNOTATION_ARRAY = new SchemaAnnotation[0];
/*     */ 
/*     */   
/*     */   public static SchemaTypeSystem get() {
/*  66 */     return _global;
/*     */   }
/*  68 */   private static SoapEncSchemaTypeSystem _global = new SoapEncSchemaTypeSystem();
/*     */   
/*     */   private SchemaTypeImpl soapArray;
/*     */   private SchemaGlobalAttributeImpl arrayType;
/*  72 */   private Map _handlesToObjects = new HashMap();
/*     */   private String soapArrayHandle;
/*  74 */   private SchemaContainer _container = new SchemaContainer("http://schemas.xmlsoap.org/soap/encoding/");
/*     */ 
/*     */ 
/*     */   
/*     */   private SoapEncSchemaTypeSystem() {
/*  79 */     this._container.setTypeSystem(this);
/*  80 */     this.soapArray = new SchemaTypeImpl(this._container, true);
/*  81 */     this._container.addGlobalType(this.soapArray.getRef());
/*  82 */     this.soapArray.setName(new b("http://schemas.xmlsoap.org/soap/encoding/", "Array"));
/*  83 */     this.soapArrayHandle = "Array".toLowerCase() + "type";
/*  84 */     this.soapArray.setComplexTypeVariety(3);
/*  85 */     this.soapArray.setBaseTypeRef(BuiltinSchemaTypeSystem.ST_ANY_TYPE.getRef());
/*  86 */     this.soapArray.setBaseDepth(1);
/*  87 */     this.soapArray.setDerivationType(2);
/*  88 */     this.soapArray.setSimpleTypeVariety(0);
/*  89 */     SchemaParticleImpl schemaParticleImpl1 = new SchemaParticleImpl();
/*  90 */     schemaParticleImpl1.setParticleType(3);
/*  91 */     schemaParticleImpl1.setMinOccurs(BigInteger.ZERO);
/*  92 */     schemaParticleImpl1.setMaxOccurs(BigInteger.ONE);
/*  93 */     schemaParticleImpl1.setTransitionRules(QNameSet.ALL, true);
/*  94 */     SchemaParticleImpl[] arrayOfSchemaParticleImpl = new SchemaParticleImpl[1];
/*  95 */     schemaParticleImpl1.setParticleChildren((SchemaParticle[])arrayOfSchemaParticleImpl);
/*  96 */     SchemaParticleImpl schemaParticleImpl2 = new SchemaParticleImpl();
/*  97 */     schemaParticleImpl2.setParticleType(5);
/*  98 */     schemaParticleImpl2.setWildcardSet(QNameSet.ALL);
/*  99 */     schemaParticleImpl2.setWildcardProcess(2);
/* 100 */     schemaParticleImpl2.setMinOccurs(BigInteger.ZERO);
/* 101 */     schemaParticleImpl2.setMaxOccurs(null);
/* 102 */     schemaParticleImpl2.setTransitionRules(QNameSet.ALL, true);
/* 103 */     arrayOfSchemaParticleImpl[0] = schemaParticleImpl2;
/*     */     
/* 105 */     SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
/* 106 */     schemaAttributeModelImpl.setWildcardProcess(2);
/* 107 */     HashSet hashSet = new HashSet();
/* 108 */     hashSet.add("http://schemas.xmlsoap.org/soap/encoding/");
/* 109 */     schemaAttributeModelImpl.setWildcardSet(QNameSet.forSets(hashSet, null, Collections.EMPTY_SET, Collections.EMPTY_SET));
/*     */     
/* 111 */     SchemaLocalAttributeImpl schemaLocalAttributeImpl = new SchemaLocalAttributeImpl();
/* 112 */     schemaLocalAttributeImpl.init(new b("", "id"), BuiltinSchemaTypeSystem.ST_ID.getRef(), 2, null, null, null, false, null, null, null);
/*     */     
/* 114 */     schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImpl);
/* 115 */     schemaLocalAttributeImpl = new SchemaLocalAttributeImpl();
/* 116 */     schemaLocalAttributeImpl.init(new b("", "href"), BuiltinSchemaTypeSystem.ST_ANY_URI.getRef(), 2, null, null, null, false, null, null, null);
/*     */     
/* 118 */     schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImpl);
/* 119 */     schemaLocalAttributeImpl = new SchemaLocalAttributeImpl();
/* 120 */     schemaLocalAttributeImpl.init(new b("http://schemas.xmlsoap.org/soap/encoding/", "arrayType"), BuiltinSchemaTypeSystem.ST_STRING.getRef(), 2, null, null, null, false, null, null, null);
/*     */     
/* 122 */     schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImpl);
/* 123 */     schemaLocalAttributeImpl = new SchemaLocalAttributeImpl();
/* 124 */     schemaLocalAttributeImpl.init(new b("http://schemas.xmlsoap.org/soap/encoding/", "offset"), BuiltinSchemaTypeSystem.ST_STRING.getRef(), 2, null, null, null, false, null, null, null);
/*     */     
/* 126 */     schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImpl);
/* 127 */     this.soapArray.setContentModel(schemaParticleImpl1, schemaAttributeModelImpl, Collections.EMPTY_MAP, Collections.EMPTY_MAP, false);
/*     */ 
/*     */     
/* 130 */     this.arrayType = new SchemaGlobalAttributeImpl(this._container);
/* 131 */     this._container.addGlobalAttribute(this.arrayType.getRef());
/* 132 */     this.arrayType.init(new b("http://schemas.xmlsoap.org/soap/encoding/", "arrayType"), BuiltinSchemaTypeSystem.ST_STRING.getRef(), 2, null, null, null, false, null, null, null);
/*     */     
/* 134 */     this._handlesToObjects.put(this.soapArrayHandle, this.soapArray);
/* 135 */     this._handlesToObjects.put("arrayType".toLowerCase() + "attribute", this.arrayType);
/* 136 */     this._container.setImmutable();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 144 */     return "schema.typesystem.soapenc.builtin";
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaType findType(b paramb) {
/* 149 */     if ("http://schemas.xmlsoap.org/soap/encoding/".equals(paramb.getNamespaceURI()) && "Array".equals(paramb.dT()))
/*     */     {
/* 151 */       return this.soapArray;
/*     */     }
/* 153 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaType findDocumentType(b paramb) {
/* 158 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaType findAttributeType(b paramb) {
/* 163 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaGlobalElement findElement(b paramb) {
/* 168 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaGlobalAttribute findAttribute(b paramb) {
/* 173 */     if ("http://schemas.xmlsoap.org/soap/encoding/".equals(paramb.getNamespaceURI()) && "arrayType".equals(paramb.dT()))
/*     */     {
/* 175 */       return this.arrayType;
/*     */     }
/* 177 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaModelGroup findModelGroup(b paramb) {
/* 182 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaAttributeGroup findAttributeGroup(b paramb) {
/* 187 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isNamespaceDefined(String paramString) {
/* 192 */     return "http://schemas.xmlsoap.org/soap/encoding/".equals(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaType.Ref findTypeRef(b paramb) {
/* 197 */     SchemaType schemaType = findType(paramb);
/* 198 */     return (schemaType == null) ? null : schemaType.getRef();
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaType.Ref findDocumentTypeRef(b paramb) {
/* 203 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaType.Ref findAttributeTypeRef(b paramb) {
/* 208 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaGlobalElement.Ref findElementRef(b paramb) {
/* 213 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaGlobalAttribute.Ref findAttributeRef(b paramb) {
/* 218 */     SchemaGlobalAttribute schemaGlobalAttribute = findAttribute(paramb);
/* 219 */     return (schemaGlobalAttribute == null) ? null : schemaGlobalAttribute.getRef();
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaModelGroup.Ref findModelGroupRef(b paramb) {
/* 224 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaAttributeGroup.Ref findAttributeGroupRef(b paramb) {
/* 229 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaIdentityConstraint.Ref findIdentityConstraintRef(b paramb) {
/* 234 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaType typeForClassname(String paramString) {
/* 239 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getSourceAsStream(String paramString) {
/* 244 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassLoader getClassLoader() {
/* 252 */     return SoapEncSchemaTypeSystem.class.getClassLoader();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resolve() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SchemaType[] globalTypes() {
/* 269 */     return new SchemaType[] { this.soapArray };
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaType[] documentTypes() {
/* 274 */     return EMPTY_SCHEMATYPE_ARRAY;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaType[] attributeTypes() {
/* 279 */     return EMPTY_SCHEMATYPE_ARRAY;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaGlobalElement[] globalElements() {
/* 284 */     return EMPTY_SCHEMAELEMENT_ARRAY;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaGlobalAttribute[] globalAttributes() {
/* 289 */     return new SchemaGlobalAttribute[] { this.arrayType };
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaModelGroup[] modelGroups() {
/* 294 */     return EMPTY_SCHEMAMODELGROUP_ARRAY;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaAttributeGroup[] attributeGroups() {
/* 299 */     return EMPTY_SCHEMAATTRIBUTEGROUP_ARRAY;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaAnnotation[] annotations() {
/* 304 */     return EMPTY_SCHEMAANNOTATION_ARRAY;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String handleForType(SchemaType paramSchemaType) {
/* 312 */     if (this.soapArray.equals(paramSchemaType)) {
/* 313 */       return this.soapArrayHandle;
/*     */     }
/* 315 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SchemaComponent resolveHandle(String paramString) {
/* 323 */     return (SchemaComponent)this._handlesToObjects.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SchemaType typeForHandle(String paramString) {
/* 331 */     return (SchemaType)this._handlesToObjects.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveToDirectory(File paramFile) {
/* 341 */     throw new UnsupportedOperationException("The builtin soap encoding schema type system cannot be saved.");
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(Filer paramFiler) {
/* 346 */     throw new UnsupportedOperationException("The builtin soap encoding schema type system cannot be saved.");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\SoapEncSchemaTypeSystem.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */