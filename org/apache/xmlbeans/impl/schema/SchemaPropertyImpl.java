/*     */ package org.apache.xmlbeans.impl.schema;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import java.util.Set;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.QNameSet;
/*     */ import org.apache.xmlbeans.SchemaProperty;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlAnySimpleType;
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
/*     */ public class SchemaPropertyImpl
/*     */   implements SchemaProperty
/*     */ {
/*     */   private b _name;
/*     */   private SchemaType.Ref _typeref;
/*     */   private boolean _isAttribute;
/*     */   private SchemaType.Ref _containerTypeRef;
/*     */   private String _javaPropertyName;
/*     */   private BigInteger _minOccurs;
/*     */   private BigInteger _maxOccurs;
/*     */   private int _hasNillable;
/*     */   private int _hasDefault;
/*     */   private int _hasFixed;
/*     */   private String _defaultText;
/*     */   private boolean _isImmutable;
/*     */   private SchemaType.Ref _javaBasedOnTypeRef;
/*     */   private boolean _extendsSingleton;
/*     */   private boolean _extendsArray;
/*     */   private boolean _extendsOption;
/*     */   private int _javaTypeCode;
/*     */   private QNameSet _javaSetterDelimiter;
/*     */   private XmlValueRef _defaultValue;
/*     */   private Set _acceptedNames;
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   private void mutate() {
/*  59 */     if (this._isImmutable) throw new IllegalStateException(); 
/*     */   }
/*     */   public void setImmutable() {
/*  62 */     mutate(); this._isImmutable = true;
/*     */   }
/*     */   public SchemaType getContainerType() {
/*  65 */     return this._containerTypeRef.get();
/*     */   }
/*     */   public void setContainerTypeRef(SchemaType.Ref paramRef) {
/*  68 */     mutate(); this._containerTypeRef = paramRef;
/*     */   }
/*     */   public b getName() {
/*  71 */     return this._name;
/*     */   }
/*     */   public void setName(b paramb) {
/*  74 */     mutate(); this._name = paramb;
/*     */   }
/*     */   public String getJavaPropertyName() {
/*  77 */     return this._javaPropertyName;
/*     */   }
/*     */   public void setJavaPropertyName(String paramString) {
/*  80 */     mutate(); this._javaPropertyName = paramString;
/*     */   }
/*     */   public boolean isAttribute() {
/*  83 */     return this._isAttribute;
/*     */   }
/*     */   public void setAttribute(boolean paramBoolean) {
/*  86 */     mutate(); this._isAttribute = paramBoolean;
/*     */   }
/*     */   public boolean isReadOnly() {
/*  89 */     return false;
/*     */   }
/*     */   public SchemaType getType() {
/*  92 */     return this._typeref.get();
/*     */   }
/*     */   public void setTypeRef(SchemaType.Ref paramRef) {
/*  95 */     mutate(); this._typeref = paramRef;
/*     */   }
/*     */   public SchemaType javaBasedOnType() {
/*  98 */     return (this._javaBasedOnTypeRef == null) ? null : this._javaBasedOnTypeRef.get();
/*     */   }
/*     */   public boolean extendsJavaSingleton() {
/* 101 */     return this._extendsSingleton;
/*     */   }
/*     */   public boolean extendsJavaArray() {
/* 104 */     return this._extendsArray;
/*     */   }
/*     */   public boolean extendsJavaOption() {
/* 107 */     return this._extendsOption;
/*     */   }
/*     */   
/*     */   public void setExtendsJava(SchemaType.Ref paramRef, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 111 */     mutate();
/* 112 */     this._javaBasedOnTypeRef = paramRef;
/* 113 */     this._extendsSingleton = paramBoolean1;
/* 114 */     this._extendsOption = paramBoolean2;
/* 115 */     this._extendsArray = paramBoolean3;
/*     */   }
/*     */ 
/*     */   
/*     */   public QNameSet getJavaSetterDelimiter() {
/* 120 */     if (this._isAttribute)
/* 121 */       return QNameSet.EMPTY; 
/* 122 */     if (this._javaSetterDelimiter == null)
/* 123 */       ((SchemaTypeImpl)getContainerType()).assignJavaElementSetterModel(); 
/* 124 */     assert this._javaSetterDelimiter != null;
/* 125 */     return this._javaSetterDelimiter;
/*     */   }
/*     */   
/*     */   void setJavaSetterDelimiter(QNameSet paramQNameSet) {
/* 129 */     this._javaSetterDelimiter = paramQNameSet;
/*     */   }
/*     */   
/*     */   public b[] acceptedNames() {
/* 133 */     if (this._acceptedNames == null) {
/* 134 */       return new b[] { this._name };
/*     */     }
/* 136 */     return (b[])this._acceptedNames.toArray((Object[])new b[this._acceptedNames.size()]);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAcceptedNames(Set paramSet) {
/* 141 */     mutate();
/* 142 */     this._acceptedNames = paramSet;
/*     */   }
/*     */   
/*     */   public void setAcceptedNames(QNameSet paramQNameSet) {
/* 146 */     mutate();
/* 147 */     this._acceptedNames = paramQNameSet.includedQNamesInExcludedURIs();
/*     */   }
/*     */   
/*     */   public BigInteger getMinOccurs() {
/* 151 */     return this._minOccurs;
/*     */   }
/*     */   public void setMinOccurs(BigInteger paramBigInteger) {
/* 154 */     mutate(); this._minOccurs = paramBigInteger;
/*     */   }
/*     */   public BigInteger getMaxOccurs() {
/* 157 */     return this._maxOccurs;
/*     */   }
/*     */   public void setMaxOccurs(BigInteger paramBigInteger) {
/* 160 */     mutate(); this._maxOccurs = paramBigInteger;
/*     */   }
/*     */   public int hasNillable() {
/* 163 */     return this._hasNillable;
/*     */   }
/*     */   public void setNillable(int paramInt) {
/* 166 */     mutate(); this._hasNillable = paramInt;
/*     */   }
/*     */   public int hasDefault() {
/* 169 */     return this._hasDefault;
/*     */   }
/*     */   public void setDefault(int paramInt) {
/* 172 */     mutate(); this._hasDefault = paramInt;
/*     */   }
/*     */   public int hasFixed() {
/* 175 */     return this._hasFixed;
/*     */   }
/*     */   public void setFixed(int paramInt) {
/* 178 */     mutate(); this._hasFixed = paramInt;
/*     */   }
/*     */   public String getDefaultText() {
/* 181 */     return this._defaultText;
/*     */   }
/*     */   public void setDefaultText(String paramString) {
/* 184 */     mutate(); this._defaultText = paramString;
/*     */   }
/*     */   
/*     */   public XmlAnySimpleType getDefaultValue() {
/* 188 */     if (this._defaultValue != null)
/* 189 */       return this._defaultValue.get(); 
/* 190 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDefaultValue(XmlValueRef paramXmlValueRef) {
/* 195 */     mutate();
/* 196 */     this._defaultValue = paramXmlValueRef;
/*     */   }
/*     */   
/*     */   public int getJavaTypeCode() {
/* 200 */     return this._javaTypeCode;
/*     */   }
/*     */   public void setJavaTypeCode(int paramInt) {
/* 203 */     mutate(); this._javaTypeCode = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\SchemaPropertyImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */