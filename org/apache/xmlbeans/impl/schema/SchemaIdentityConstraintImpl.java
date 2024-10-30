/*     */ package org.apache.xmlbeans.impl.schema;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaAnnotation;
/*     */ import org.apache.xmlbeans.SchemaComponent;
/*     */ import org.apache.xmlbeans.SchemaIdentityConstraint;
/*     */ import org.apache.xmlbeans.SchemaTypeSystem;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.common.XPath;
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
/*     */ public class SchemaIdentityConstraintImpl
/*     */   implements SchemaIdentityConstraint
/*     */ {
/*     */   private SchemaContainer _container;
/*     */   private String _selector;
/*     */   private String[] _fields;
/*     */   private SchemaIdentityConstraint.Ref _key;
/*     */   private b _name;
/*     */   private int _type;
/*     */   private XmlObject _parse;
/*     */   private Object _userData;
/*     */   private SchemaAnnotation _annotation;
/*  39 */   private Map _nsMap = Collections.EMPTY_MAP;
/*     */   
/*     */   private String _parseTNS;
/*     */   
/*     */   private boolean _chameleon;
/*     */   
/*     */   private String _filename;
/*     */   
/*     */   private volatile XPath _selectorPath;
/*     */   private volatile XPath[] _fieldPaths;
/*     */   private SchemaIdentityConstraint.Ref _selfref;
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   public void setFilename(String paramString) {
/*  53 */     this._filename = paramString;
/*     */   }
/*     */   public String getSourceName() {
/*  56 */     return this._filename;
/*     */   }
/*     */   
/*     */   public String getSelector() {
/*  60 */     return this._selector;
/*     */   }
/*     */   
/*     */   public Object getSelectorPath() {
/*  64 */     XPath xPath = this._selectorPath;
/*  65 */     if (xPath == null) {
/*     */       try {
/*  67 */         buildPaths();
/*  68 */         xPath = this._selectorPath;
/*     */       }
/*  70 */       catch (org.apache.xmlbeans.impl.common.XPath.XPathCompileException xPathCompileException) {
/*  71 */         assert false : "Failed to compile xpath. Should be caught by compiler " + xPathCompileException;
/*  72 */         return null;
/*     */       } 
/*     */     }
/*  75 */     return xPath;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAnnotation(SchemaAnnotation paramSchemaAnnotation) {
/*  80 */     this._annotation = paramSchemaAnnotation;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaAnnotation getAnnotation() {
/*  85 */     return this._annotation;
/*     */   }
/*     */   
/*     */   public void setNSMap(Map paramMap) {
/*  89 */     this._nsMap = paramMap;
/*     */   }
/*     */   
/*     */   public Map getNSMap() {
/*  93 */     return Collections.unmodifiableMap(this._nsMap);
/*     */   }
/*     */   
/*     */   public void setSelector(String paramString) {
/*  97 */     assert paramString != null;
/*  98 */     this._selector = paramString;
/*     */   }
/*     */   
/*     */   public void setFields(String[] paramArrayOfString) {
/* 102 */     assert paramArrayOfString != null && paramArrayOfString.length > 0;
/* 103 */     this._fields = paramArrayOfString;
/*     */   }
/*     */   
/*     */   public String[] getFields() {
/* 107 */     String[] arrayOfString = new String[this._fields.length];
/* 108 */     System.arraycopy(this._fields, 0, arrayOfString, 0, arrayOfString.length);
/* 109 */     return arrayOfString;
/*     */   }
/*     */   
/*     */   public Object getFieldPath(int paramInt) {
/* 113 */     XPath[] arrayOfXPath = this._fieldPaths;
/* 114 */     if (arrayOfXPath == null) {
/*     */       try {
/* 116 */         buildPaths();
/* 117 */         arrayOfXPath = this._fieldPaths;
/*     */       }
/* 119 */       catch (org.apache.xmlbeans.impl.common.XPath.XPathCompileException xPathCompileException) {
/* 120 */         assert false : "Failed to compile xpath. Should be caught by compiler " + xPathCompileException;
/* 121 */         return null;
/*     */       } 
/*     */     }
/* 124 */     return arrayOfXPath[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public void buildPaths() throws XPath.XPathCompileException {
/* 129 */     this._selectorPath = XPath.compileXPath(this._selector, this._nsMap);
/*     */     
/* 131 */     this._fieldPaths = new XPath[this._fields.length];
/* 132 */     for (byte b1 = 0; b1 < this._fieldPaths.length; b1++)
/* 133 */       this._fieldPaths[b1] = XPath.compileXPath(this._fields[b1], this._nsMap); 
/*     */   }
/*     */   
/*     */   public void setReferencedKey(SchemaIdentityConstraint.Ref paramRef) {
/* 137 */     this._key = paramRef;
/*     */   }
/*     */   
/*     */   public SchemaIdentityConstraint getReferencedKey() {
/* 141 */     return this._key.get();
/*     */   }
/*     */   
/*     */   public void setConstraintCategory(int paramInt) {
/* 145 */     assert paramInt >= 1 && paramInt <= 3;
/* 146 */     this._type = paramInt;
/*     */   }
/*     */   
/*     */   public int getConstraintCategory() {
/* 150 */     return this._type;
/*     */   }
/*     */   
/*     */   public void setName(b paramb) {
/* 154 */     assert paramb != null;
/* 155 */     this._name = paramb;
/*     */   }
/*     */   
/*     */   public b getName() {
/* 159 */     return this._name;
/*     */   }
/*     */   
/*     */   public int getComponentType() {
/* 163 */     return 5;
/*     */   }
/*     */   
/*     */   public SchemaTypeSystem getTypeSystem() {
/* 167 */     return this._container.getTypeSystem();
/*     */   }
/*     */   
/*     */   SchemaContainer getContainer() {
/* 171 */     return this._container;
/*     */   }
/*     */   
/*     */   public void setParseContext(XmlObject paramXmlObject, String paramString, boolean paramBoolean) {
/* 175 */     this._parse = paramXmlObject;
/* 176 */     this._parseTNS = paramString;
/* 177 */     this._chameleon = paramBoolean;
/*     */   }
/*     */   
/*     */   public XmlObject getParseObject() {
/* 181 */     return this._parse;
/*     */   }
/*     */   
/*     */   public String getTargetNamespace() {
/* 185 */     return this._parseTNS;
/*     */   }
/*     */   
/*     */   public String getChameleonNamespace() {
/* 189 */     return this._chameleon ? this._parseTNS : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isResolved() {
/* 197 */     return (getConstraintCategory() != 2 || this._key != null);
/*     */   }
/*     */   public SchemaIdentityConstraintImpl(SchemaContainer paramSchemaContainer) {
/* 200 */     this._selfref = new SchemaIdentityConstraint.Ref(this);
/*     */     this._container = paramSchemaContainer;
/*     */   } public SchemaIdentityConstraint.Ref getRef() {
/* 203 */     return this._selfref;
/*     */   }
/*     */   public SchemaComponent.Ref getComponentRef() {
/* 206 */     return (SchemaComponent.Ref)getRef();
/*     */   }
/*     */   public Object getUserData() {
/* 209 */     return this._userData;
/*     */   }
/*     */   public void setUserData(Object paramObject) {
/* 212 */     this._userData = paramObject;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\SchemaIdentityConstraintImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */