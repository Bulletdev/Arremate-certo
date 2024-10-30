/*      */ package org.apache.xmlbeans.impl.schema;
/*      */ import java.lang.reflect.Constructor;
/*      */ import java.math.BigInteger;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.xmlbeans.InterfaceExtension;
/*      */ import org.apache.xmlbeans.PrePostExtension;
/*      */ import org.apache.xmlbeans.QNameSet;
/*      */ import org.apache.xmlbeans.QNameSetBuilder;
/*      */ import org.apache.xmlbeans.QNameSetSpecification;
/*      */ import org.apache.xmlbeans.SchemaAnnotation;
/*      */ import org.apache.xmlbeans.SchemaAttributeModel;
/*      */ import org.apache.xmlbeans.SchemaComponent;
/*      */ import org.apache.xmlbeans.SchemaField;
/*      */ import org.apache.xmlbeans.SchemaGlobalAttribute;
/*      */ import org.apache.xmlbeans.SchemaGlobalElement;
/*      */ import org.apache.xmlbeans.SchemaLocalAttribute;
/*      */ import org.apache.xmlbeans.SchemaLocalElement;
/*      */ import org.apache.xmlbeans.SchemaParticle;
/*      */ import org.apache.xmlbeans.SchemaProperty;
/*      */ import org.apache.xmlbeans.SchemaStringEnumEntry;
/*      */ import org.apache.xmlbeans.SchemaType;
/*      */ import org.apache.xmlbeans.SchemaTypeElementSequencer;
/*      */ import org.apache.xmlbeans.SchemaTypeLoader;
/*      */ import org.apache.xmlbeans.SchemaTypeSystem;
/*      */ import org.apache.xmlbeans.StringEnumAbstractBase;
/*      */ import org.apache.xmlbeans.XmlAnySimpleType;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*      */ import org.apache.xmlbeans.impl.regex.RegularExpression;
/*      */ import org.apache.xmlbeans.impl.values.StringEnumValue;
/*      */ import org.apache.xmlbeans.impl.values.TypeStoreUser;
/*      */ import org.apache.xmlbeans.impl.values.TypeStoreUserFactory;
/*      */ import org.apache.xmlbeans.impl.values.XmlAnySimpleTypeRestriction;
/*      */ import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlAnyUriImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlBase64BinaryImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlBase64BinaryRestriction;
/*      */ import org.apache.xmlbeans.impl.values.XmlBooleanImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlByteImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlDateImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlDateTimeImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlDecimalImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlDecimalRestriction;
/*      */ import org.apache.xmlbeans.impl.values.XmlDoubleImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlDurationImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlEntitiesImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlEntityImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlFloatImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlGDayImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlGMonthDayImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlGMonthImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlGYearImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlGYearMonthImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlHexBinaryImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlIdImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlIdRefImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlIdRefsImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlIntImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlIntRestriction;
/*      */ import org.apache.xmlbeans.impl.values.XmlIntegerImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlLanguageImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlListImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlLongRestriction;
/*      */ import org.apache.xmlbeans.impl.values.XmlNCNameImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlNameImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlNegativeIntegerImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlNmTokenImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlNmTokensImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlNonNegativeIntegerImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlNonPositiveIntegerImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlNormalizedStringImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlNotationImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlNotationRestriction;
/*      */ import org.apache.xmlbeans.impl.values.XmlObjectBase;
/*      */ import org.apache.xmlbeans.impl.values.XmlPositiveIntegerImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlQNameRestriction;
/*      */ import org.apache.xmlbeans.impl.values.XmlShortImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlStringEnumeration;
/*      */ import org.apache.xmlbeans.impl.values.XmlStringImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlStringRestriction;
/*      */ import org.apache.xmlbeans.impl.values.XmlTimeImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlTokenImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlUnionImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlUnsignedByteImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlUnsignedIntImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlUnsignedLongImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlUnsignedShortImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
/*      */ 
/*      */ public final class SchemaTypeImpl implements SchemaType, TypeStoreUserFactory {
/*      */   private b _name;
/*      */   private SchemaAnnotation _annotation;
/*      */   private int _resolvePhase;
/*      */   private static final int UNRESOLVED = 0;
/*      */   private static final int RESOLVING_SGS = 1;
/*      */   private static final int RESOLVED_SGS = 2;
/*      */   private static final int RESOLVING = 3;
/*      */   private static final int RESOLVED = 4;
/*  109 */   private final Object[] _ctrArgs = new Object[] { this }; private static final int JAVAIZING = 5; private static final int JAVAIZED = 6; private SchemaType.Ref _outerSchemaTypeRef; private volatile SchemaComponent.Ref _containerFieldRef; private volatile SchemaField _containerField; private volatile int _containerFieldCode; private volatile int _containerFieldIndex; private volatile b[] _groupReferenceContext; private SchemaType.Ref[] _anonymousTyperefs; private boolean _isDocumentType; private boolean _isAttributeType; private boolean _isCompiled; private String _shortJavaName; private String _fullJavaName; private String _shortJavaImplName; private String _fullJavaImplName; private InterfaceExtension[] _interfaces; private PrePostExtension _prepost; private volatile Class _javaClass; private volatile Class _javaEnumClass; private volatile Class _javaImplClass; private volatile Constructor _javaImplConstructor;
/*      */   private volatile Constructor _javaImplConstructor2;
/*      */   private volatile boolean _implNotAvailable;
/*      */   private volatile Class _userTypeClass;
/*      */   private volatile Class _userTypeHandlerClass;
/*      */   private volatile Object _userData;
/*      */   private SchemaContainer _container;
/*      */   private String _filename;
/*      */   private SchemaParticle _contentModel;
/*      */   private volatile SchemaLocalElement[] _localElts;
/*      */   private volatile Map _eltToIndexMap;
/*      */   private volatile Map _attrToIndexMap;
/*      */   private Map _propertyModelByElementName;
/*      */   private Map _propertyModelByAttributeName;
/*      */   private boolean _hasAllContent;
/*      */   private boolean _orderSensitive;
/*      */   private QNameSet _typedWildcardElements;
/*      */   private QNameSet _typedWildcardAttributes;
/*      */   private boolean _hasWildcardElements;
/*      */   private boolean _hasWildcardAttributes;
/*  129 */   private Set _validSubstitutions = Collections.EMPTY_SET;
/*      */   
/*      */   private int _complexTypeVariety;
/*      */   
/*      */   private SchemaAttributeModel _attributeModel;
/*      */   
/*      */   private int _builtinTypeCode;
/*      */   
/*      */   private int _simpleTypeVariety;
/*      */   
/*      */   private boolean _isSimpleType;
/*      */   
/*      */   private SchemaType.Ref _baseTyperef;
/*      */   
/*      */   private int _baseDepth;
/*      */   
/*      */   private int _derivationType;
/*      */   
/*      */   private String _userTypeName;
/*      */   
/*      */   private String _userTypeHandler;
/*      */   
/*      */   private SchemaType.Ref _contentBasedOnTyperef;
/*      */   
/*      */   private XmlValueRef[] _facetArray;
/*      */   
/*      */   private boolean[] _fixedFacetArray;
/*      */   
/*      */   private int _ordered;
/*      */   
/*      */   private boolean _isFinite;
/*      */   
/*      */   private boolean _isBounded;
/*      */   
/*      */   private boolean _isNumeric;
/*      */   
/*      */   private boolean _abs;
/*      */   
/*      */   private boolean _finalExt;
/*      */   
/*      */   private boolean _finalRest;
/*      */   
/*      */   private boolean _finalList;
/*      */   
/*      */   private boolean _finalUnion;
/*      */   
/*      */   private boolean _blockExt;
/*      */   
/*      */   private boolean _blockRest;
/*      */   
/*      */   private int _whiteSpaceRule;
/*      */   
/*      */   private boolean _hasPatterns;
/*      */   
/*      */   private RegularExpression[] _patterns;
/*      */   
/*      */   private XmlValueRef[] _enumerationValues;
/*      */   
/*      */   private SchemaType.Ref _baseEnumTyperef;
/*      */   
/*      */   private boolean _stringEnumEnsured;
/*      */   
/*      */   private volatile Map _lookupStringEnum;
/*      */   
/*      */   private volatile List _listOfStringEnum;
/*      */   
/*      */   private volatile Map _lookupStringEnumEntry;
/*      */   private SchemaStringEnumEntry[] _stringEnumEntries;
/*      */   private SchemaType.Ref _listItemTyperef;
/*      */   private boolean _isUnionOfLists;
/*      */   private SchemaType.Ref[] _unionMemberTyperefs;
/*      */   private int _anonymousUnionMemberOrdinal;
/*      */   private volatile SchemaType[] _unionConstituentTypes;
/*      */   private volatile SchemaType[] _unionSubTypes;
/*      */   private volatile SchemaType _unionCommonBaseType;
/*      */   private SchemaType.Ref _primitiveTypeRef;
/*      */   private int _decimalSize;
/*      */   private volatile boolean _unloaded;
/*      */   private b _sg;
/*  208 */   private List _sgMembers = new ArrayList();
/*      */ 
/*      */   
/*      */   public boolean isUnloaded() {
/*  212 */     return this._unloaded;
/*      */   }
/*      */ 
/*      */   
/*      */   public void finishLoading() {
/*  217 */     this._unloaded = false;
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
/*      */   public boolean isSGResolved() {
/*  236 */     return (this._resolvePhase >= 2);
/*      */   }
/*      */   public boolean isSGResolving() {
/*  239 */     return (this._resolvePhase >= 1);
/*      */   }
/*      */   public boolean isResolved() {
/*  242 */     return (this._resolvePhase >= 4);
/*      */   }
/*      */   public boolean isResolving() {
/*  245 */     return (this._resolvePhase == 3);
/*      */   }
/*      */   public boolean isUnjavaized() {
/*  248 */     return (this._resolvePhase < 6);
/*      */   }
/*      */   public boolean isJavaized() {
/*  251 */     return (this._resolvePhase == 6);
/*      */   }
/*      */   
/*      */   public void startResolvingSGs() {
/*  255 */     if (this._resolvePhase != 0)
/*  256 */       throw new IllegalStateException(); 
/*  257 */     this._resolvePhase = 1;
/*      */   }
/*      */ 
/*      */   
/*      */   public void finishResolvingSGs() {
/*  262 */     if (this._resolvePhase != 1)
/*  263 */       throw new IllegalStateException(); 
/*  264 */     this._resolvePhase = 2;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startResolving() {
/*  269 */     if ((this._isDocumentType && this._resolvePhase != 2) || (!this._isDocumentType && this._resolvePhase != 0))
/*      */     {
/*  271 */       throw new IllegalStateException(); } 
/*  272 */     this._resolvePhase = 3;
/*      */   }
/*      */ 
/*      */   
/*      */   public void finishResolving() {
/*  277 */     if (this._resolvePhase != 3)
/*  278 */       throw new IllegalStateException(); 
/*  279 */     this._resolvePhase = 4;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startJavaizing() {
/*  284 */     if (this._resolvePhase != 4)
/*  285 */       throw new IllegalStateException(); 
/*  286 */     this._resolvePhase = 5;
/*      */   }
/*      */ 
/*      */   
/*      */   public void finishJavaizing() {
/*  291 */     if (this._resolvePhase != 5)
/*  292 */       throw new IllegalStateException(); 
/*  293 */     this._resolvePhase = 6;
/*      */   }
/*      */ 
/*      */   
/*      */   private void finishQuick() {
/*  298 */     this._resolvePhase = 6;
/*      */   }
/*      */ 
/*      */   
/*      */   private void assertUnresolved() {
/*  303 */     if (this._resolvePhase != 0 && !this._unloaded) {
/*  304 */       throw new IllegalStateException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assertSGResolving() {
/*  309 */     if (this._resolvePhase != 1 && !this._unloaded) {
/*  310 */       throw new IllegalStateException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assertSGResolved() {
/*  315 */     if (this._resolvePhase != 2 && !this._unloaded) {
/*  316 */       throw new IllegalStateException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assertResolving() {
/*  321 */     if (this._resolvePhase != 3 && !this._unloaded) {
/*  322 */       throw new IllegalStateException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assertResolved() {
/*  327 */     if (this._resolvePhase != 4 && !this._unloaded) {
/*  328 */       throw new IllegalStateException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assertJavaizing() {
/*  333 */     if (this._resolvePhase != 5 && !this._unloaded)
/*  334 */       throw new IllegalStateException(); 
/*      */   }
/*      */   
/*      */   public b getName() {
/*  338 */     return this._name;
/*      */   }
/*      */   public void setName(b paramb) {
/*  341 */     assertUnresolved(); this._name = paramb;
/*      */   }
/*      */   
/*      */   public String getSourceName() {
/*  345 */     if (this._filename != null)
/*  346 */       return this._filename; 
/*  347 */     if (getOuterType() != null) {
/*  348 */       return getOuterType().getSourceName();
/*      */     }
/*  350 */     SchemaField schemaField = getContainerField();
/*  351 */     if (schemaField != null) {
/*      */       
/*  353 */       if (schemaField instanceof SchemaGlobalElement)
/*  354 */         return ((SchemaGlobalElement)schemaField).getSourceName(); 
/*  355 */       if (schemaField instanceof SchemaGlobalAttribute)
/*  356 */         return ((SchemaGlobalAttribute)schemaField).getSourceName(); 
/*      */     } 
/*  358 */     return null;
/*      */   }
/*      */   
/*      */   public void setFilename(String paramString) {
/*  362 */     assertUnresolved(); this._filename = paramString;
/*      */   }
/*      */   public int getComponentType() {
/*  365 */     return 0;
/*      */   }
/*      */   public boolean isAnonymousType() {
/*  368 */     return (this._name == null);
/*      */   }
/*      */   public boolean isDocumentType() {
/*  371 */     return this._isDocumentType;
/*      */   }
/*      */   public boolean isAttributeType() {
/*  374 */     return this._isAttributeType;
/*      */   }
/*      */   
/*      */   public b getDocumentElementName() {
/*  378 */     if (this._isDocumentType) {
/*      */       
/*  380 */       SchemaParticle schemaParticle = getContentModel();
/*  381 */       if (schemaParticle != null) {
/*  382 */         return schemaParticle.getName();
/*      */       }
/*      */     } 
/*  385 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public b getAttributeTypeAttributeName() {
/*  390 */     if (this._isAttributeType) {
/*      */       
/*  392 */       SchemaAttributeModel schemaAttributeModel = getAttributeModel();
/*  393 */       if (schemaAttributeModel != null) {
/*      */         
/*  395 */         SchemaLocalAttribute[] arrayOfSchemaLocalAttribute = schemaAttributeModel.getAttributes();
/*  396 */         if (arrayOfSchemaLocalAttribute != null && arrayOfSchemaLocalAttribute.length > 0) {
/*      */           
/*  398 */           SchemaLocalAttribute schemaLocalAttribute = arrayOfSchemaLocalAttribute[0];
/*  399 */           return schemaLocalAttribute.getName();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  404 */     return null;
/*      */   }
/*      */   
/*      */   public void setAnnotation(SchemaAnnotation paramSchemaAnnotation) {
/*  408 */     assertUnresolved(); this._annotation = paramSchemaAnnotation;
/*      */   }
/*      */   public SchemaAnnotation getAnnotation() {
/*  411 */     return this._annotation;
/*      */   }
/*      */   public void setDocumentType(boolean paramBoolean) {
/*  414 */     assertUnresolved(); this._isDocumentType = paramBoolean;
/*      */   }
/*      */   public void setAttributeType(boolean paramBoolean) {
/*  417 */     assertUnresolved(); this._isAttributeType = paramBoolean;
/*      */   }
/*      */   public int getContentType() {
/*  420 */     return this._complexTypeVariety;
/*      */   }
/*      */   public void setComplexTypeVariety(int paramInt) {
/*  423 */     assertResolving(); this._complexTypeVariety = paramInt;
/*      */   }
/*      */   
/*      */   public SchemaTypeElementSequencer getElementSequencer() {
/*  427 */     if (this._complexTypeVariety == 0) {
/*  428 */       return new SequencerImpl(null);
/*      */     }
/*  430 */     return new SequencerImpl(new SchemaTypeVisitorImpl(this._contentModel));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setAbstractFinal(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5) {
/*  437 */     assertResolving();
/*  438 */     this._abs = paramBoolean1;
/*  439 */     this._finalExt = paramBoolean2; this._finalRest = paramBoolean3;
/*  440 */     this._finalList = paramBoolean4; this._finalUnion = paramBoolean5;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void setSimpleFinal(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*  446 */     assertResolving(); this._finalRest = paramBoolean1; this._finalList = paramBoolean2; this._finalUnion = paramBoolean3;
/*      */   }
/*      */ 
/*      */   
/*      */   void setBlock(boolean paramBoolean1, boolean paramBoolean2) {
/*  451 */     assertResolving(); this._blockExt = paramBoolean1; this._blockRest = paramBoolean2;
/*      */   }
/*      */   
/*      */   public boolean blockRestriction() {
/*  455 */     return this._blockRest;
/*      */   }
/*      */   public boolean blockExtension() {
/*  458 */     return this._blockExt;
/*      */   }
/*      */   public boolean isAbstract() {
/*  461 */     return this._abs;
/*      */   }
/*      */   public boolean finalExtension() {
/*  464 */     return this._finalExt;
/*      */   }
/*      */   public boolean finalRestriction() {
/*  467 */     return this._finalRest;
/*      */   }
/*      */   public boolean finalList() {
/*  470 */     return this._finalList;
/*      */   }
/*      */   public boolean finalUnion() {
/*  473 */     return this._finalUnion;
/*      */   }
/*      */   
/*      */   public synchronized SchemaField getContainerField() {
/*  477 */     if (this._containerFieldCode != -1) {
/*      */       
/*  479 */       SchemaType schemaType = getOuterType();
/*  480 */       if (this._containerFieldCode == 0) {
/*  481 */         this._containerField = (this._containerFieldRef == null) ? null : (SchemaField)this._containerFieldRef.getComponent();
/*  482 */       } else if (this._containerFieldCode == 1) {
/*  483 */         this._containerField = (SchemaField)schemaType.getAttributeModel().getAttributes()[this._containerFieldIndex];
/*      */       } else {
/*  485 */         this._containerField = (SchemaField)((SchemaTypeImpl)schemaType).getLocalElementByIndex(this._containerFieldIndex);
/*  486 */       }  this._containerFieldCode = -1;
/*      */     } 
/*  488 */     return this._containerField;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setContainerField(SchemaField paramSchemaField) {
/*  493 */     assertUnresolved();
/*  494 */     this._containerField = paramSchemaField;
/*  495 */     this._containerFieldCode = -1;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setContainerFieldRef(SchemaComponent.Ref paramRef) {
/*  500 */     assertUnresolved();
/*  501 */     this._containerFieldRef = paramRef;
/*  502 */     this._containerFieldCode = 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setContainerFieldIndex(short paramShort, int paramInt) {
/*  507 */     assertUnresolved();
/*  508 */     this._containerFieldCode = paramShort;
/*  509 */     this._containerFieldIndex = paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   void setGroupReferenceContext(b[] paramArrayOfb) {
/*  514 */     assertUnresolved();
/*  515 */     this._groupReferenceContext = paramArrayOfb;
/*      */   }
/*      */   
/*      */   b[] getGroupReferenceContext() {
/*  519 */     return this._groupReferenceContext;
/*      */   }
/*      */   public SchemaType getOuterType() {
/*  522 */     return (this._outerSchemaTypeRef == null) ? null : this._outerSchemaTypeRef.get();
/*      */   }
/*      */   public void setOuterSchemaTypeRef(SchemaType.Ref paramRef) {
/*  525 */     assertUnresolved(); this._outerSchemaTypeRef = paramRef;
/*      */   }
/*      */   public boolean isCompiled() {
/*  528 */     return this._isCompiled;
/*      */   }
/*      */   public void setCompiled(boolean paramBoolean) {
/*  531 */     assertJavaizing(); this._isCompiled = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean isSkippedAnonymousType() {
/*  535 */     SchemaType schemaType = getOuterType();
/*  536 */     return (schemaType == null) ? false : ((schemaType.getBaseType() == this || schemaType.getContentBasedOnType() == this));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String getShortJavaName() {
/*  542 */     return this._shortJavaName;
/*      */   }
/*      */   
/*      */   public void setShortJavaName(String paramString) {
/*  546 */     assertResolved();
/*  547 */     this._shortJavaName = paramString;
/*  548 */     SchemaType schemaType = this._outerSchemaTypeRef.get();
/*  549 */     while (schemaType.getFullJavaName() == null) {
/*  550 */       schemaType = schemaType.getOuterType();
/*      */     }
/*  552 */     this._fullJavaName = schemaType.getFullJavaName() + "$" + this._shortJavaName;
/*      */   }
/*      */   
/*      */   public String getFullJavaName() {
/*  556 */     return this._fullJavaName;
/*      */   }
/*      */   
/*      */   public void setFullJavaName(String paramString) {
/*  560 */     assertResolved();
/*  561 */     this._fullJavaName = paramString;
/*  562 */     int i = Math.max(this._fullJavaName.lastIndexOf('$'), this._fullJavaName.lastIndexOf('.')) + 1;
/*      */     
/*  564 */     this._shortJavaName = this._fullJavaName.substring(i);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setShortJavaImplName(String paramString) {
/*  569 */     assertResolved();
/*  570 */     this._shortJavaImplName = paramString;
/*  571 */     SchemaType schemaType = this._outerSchemaTypeRef.get();
/*  572 */     while (schemaType.getFullJavaImplName() == null) {
/*  573 */       schemaType = schemaType.getOuterType();
/*      */     }
/*  575 */     this._fullJavaImplName = schemaType.getFullJavaImplName() + "$" + this._shortJavaImplName;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setFullJavaImplName(String paramString) {
/*  580 */     assertResolved();
/*  581 */     this._fullJavaImplName = paramString;
/*  582 */     int i = Math.max(this._fullJavaImplName.lastIndexOf('$'), this._fullJavaImplName.lastIndexOf('.')) + 1;
/*      */     
/*  584 */     this._shortJavaImplName = this._fullJavaImplName.substring(i);
/*      */   }
/*      */   
/*  587 */   public String getFullJavaImplName() { return this._fullJavaImplName; } public String getShortJavaImplName() {
/*  588 */     return this._shortJavaImplName;
/*      */   }
/*      */   
/*      */   public String getUserTypeName() {
/*  592 */     return this._userTypeName;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setUserTypeName(String paramString) {
/*  597 */     this._userTypeName = paramString;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getUserTypeHandlerName() {
/*  602 */     return this._userTypeHandler;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setUserTypeHandlerName(String paramString) {
/*  607 */     this._userTypeHandler = paramString;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setInterfaceExtensions(InterfaceExtension[] paramArrayOfInterfaceExtension) {
/*  612 */     assertResolved();
/*  613 */     this._interfaces = paramArrayOfInterfaceExtension;
/*      */   }
/*      */ 
/*      */   
/*      */   public InterfaceExtension[] getInterfaceExtensions() {
/*  618 */     return this._interfaces;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPrePostExtension(PrePostExtension paramPrePostExtension) {
/*  623 */     assertResolved();
/*  624 */     this._prepost = paramPrePostExtension;
/*      */   }
/*      */ 
/*      */   
/*      */   public PrePostExtension getPrePostExtension() {
/*  629 */     return this._prepost;
/*      */   }
/*      */   
/*      */   public Object getUserData() {
/*  633 */     return this._userData;
/*      */   }
/*      */   public void setUserData(Object paramObject) {
/*  636 */     this._userData = paramObject;
/*      */   }
/*      */   
/*      */   SchemaContainer getContainer() {
/*  640 */     return this._container;
/*      */   }
/*      */   void setContainer(SchemaContainer paramSchemaContainer) {
/*  643 */     this._container = paramSchemaContainer;
/*      */   }
/*      */   public SchemaTypeSystem getTypeSystem() {
/*  646 */     return this._container.getTypeSystem();
/*      */   }
/*      */   public SchemaParticle getContentModel() {
/*  649 */     return this._contentModel;
/*      */   }
/*      */   private static void buildEltList(List paramList, SchemaParticle paramSchemaParticle) {
/*      */     byte b1;
/*  653 */     if (paramSchemaParticle == null) {
/*      */       return;
/*      */     }
/*  656 */     switch (paramSchemaParticle.getParticleType()) {
/*      */       
/*      */       case 4:
/*  659 */         paramList.add(paramSchemaParticle);
/*      */         return;
/*      */       case 1:
/*      */       case 2:
/*      */       case 3:
/*  664 */         for (b1 = 0; b1 < paramSchemaParticle.countOfParticleChild(); b1++) {
/*  665 */           buildEltList(paramList, paramSchemaParticle.getParticleChild(b1));
/*      */         }
/*      */         return;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void buildLocalElts() {
/*  674 */     ArrayList arrayList = new ArrayList();
/*  675 */     buildEltList(arrayList, this._contentModel);
/*  676 */     this._localElts = (SchemaLocalElement[])arrayList.toArray((Object[])new SchemaLocalElement[arrayList.size()]);
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaLocalElement getLocalElementByIndex(int paramInt) {
/*  681 */     SchemaLocalElement[] arrayOfSchemaLocalElement = this._localElts;
/*  682 */     if (arrayOfSchemaLocalElement == null) {
/*      */       
/*  684 */       buildLocalElts();
/*  685 */       arrayOfSchemaLocalElement = this._localElts;
/*      */     } 
/*  687 */     return arrayOfSchemaLocalElement[paramInt];
/*      */   }
/*      */ 
/*      */   
/*      */   public int getIndexForLocalElement(SchemaLocalElement paramSchemaLocalElement) {
/*  692 */     Map map = this._eltToIndexMap;
/*  693 */     if (map == null) {
/*      */       
/*  695 */       if (this._localElts == null)
/*  696 */         buildLocalElts(); 
/*  697 */       map = new HashMap();
/*  698 */       for (byte b1 = 0; b1 < this._localElts.length; b1++)
/*      */       {
/*  700 */         map.put(this._localElts[b1], new Integer(b1));
/*      */       }
/*  702 */       this._eltToIndexMap = map;
/*      */     } 
/*  704 */     return ((Integer)map.get(paramSchemaLocalElement)).intValue();
/*      */   }
/*      */ 
/*      */   
/*      */   public int getIndexForLocalAttribute(SchemaLocalAttribute paramSchemaLocalAttribute) {
/*  709 */     Map map = this._attrToIndexMap;
/*  710 */     if (map == null) {
/*      */       
/*  712 */       map = new HashMap();
/*  713 */       SchemaLocalAttribute[] arrayOfSchemaLocalAttribute = this._attributeModel.getAttributes();
/*  714 */       for (byte b1 = 0; b1 < arrayOfSchemaLocalAttribute.length; b1++)
/*      */       {
/*  716 */         map.put(arrayOfSchemaLocalAttribute[b1], new Integer(b1));
/*      */       }
/*  718 */       this._attrToIndexMap = map;
/*      */     } 
/*  720 */     return ((Integer)map.get(paramSchemaLocalAttribute)).intValue();
/*      */   }
/*      */   
/*      */   public SchemaAttributeModel getAttributeModel() {
/*  724 */     return this._attributeModel;
/*      */   }
/*      */   
/*      */   public SchemaProperty[] getProperties() {
/*  728 */     if (this._propertyModelByElementName == null) {
/*  729 */       return getAttributeProperties();
/*      */     }
/*  731 */     if (this._propertyModelByAttributeName == null) {
/*  732 */       return getElementProperties();
/*      */     }
/*  734 */     ArrayList arrayList = new ArrayList();
/*  735 */     arrayList.addAll(this._propertyModelByElementName.values());
/*  736 */     arrayList.addAll(this._propertyModelByAttributeName.values());
/*  737 */     return (SchemaProperty[])arrayList.toArray((Object[])new SchemaProperty[arrayList.size()]);
/*      */   }
/*      */   
/*  740 */   private static final SchemaProperty[] NO_PROPERTIES = new SchemaProperty[0]; private XmlObject _parseObject; private String _parseTNS; private String _elemFormDefault; private String _attFormDefault; private boolean _chameleon; private boolean _redefinition; private SchemaType.Ref _selfref;
/*      */   static final boolean $assertionsDisabled;
/*      */   
/*      */   public SchemaProperty[] getDerivedProperties() {
/*  744 */     SchemaType schemaType = getBaseType();
/*  745 */     if (schemaType == null) {
/*  746 */       return getProperties();
/*      */     }
/*  748 */     ArrayList arrayList = new ArrayList();
/*      */     
/*  750 */     if (this._propertyModelByElementName != null) {
/*  751 */       arrayList.addAll(this._propertyModelByElementName.values());
/*      */     }
/*  753 */     if (this._propertyModelByAttributeName != null) {
/*  754 */       arrayList.addAll(this._propertyModelByAttributeName.values());
/*      */     }
/*  756 */     for (Iterator iterator = arrayList.iterator(); iterator.hasNext(); ) {
/*      */       
/*  758 */       SchemaProperty schemaProperty1 = iterator.next();
/*  759 */       SchemaProperty schemaProperty2 = schemaProperty1.isAttribute() ? schemaType.getAttributeProperty(schemaProperty1.getName()) : schemaType.getElementProperty(schemaProperty1.getName());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  768 */       if (schemaProperty2 != null)
/*      */       {
/*  770 */         if (eq(schemaProperty1.getMinOccurs(), schemaProperty2.getMinOccurs()) && eq(schemaProperty1.getMaxOccurs(), schemaProperty2.getMaxOccurs()) && schemaProperty1.hasNillable() == schemaProperty2.hasNillable() && eq(schemaProperty1.getDefaultText(), schemaProperty2.getDefaultText()))
/*      */         {
/*      */ 
/*      */ 
/*      */           
/*  775 */           iterator.remove();
/*      */         }
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  782 */     return (SchemaProperty[])arrayList.toArray((Object[])new SchemaProperty[arrayList.size()]);
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean eq(BigInteger paramBigInteger1, BigInteger paramBigInteger2) {
/*  787 */     if (paramBigInteger1 == null && paramBigInteger2 == null)
/*  788 */       return true; 
/*  789 */     if (paramBigInteger1 == null || paramBigInteger2 == null)
/*  790 */       return false; 
/*  791 */     return paramBigInteger1.equals(paramBigInteger2);
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean eq(String paramString1, String paramString2) {
/*  796 */     if (paramString1 == null && paramString2 == null)
/*  797 */       return true; 
/*  798 */     if (paramString1 == null || paramString2 == null)
/*  799 */       return false; 
/*  800 */     return paramString1.equals(paramString2);
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaProperty[] getElementProperties() {
/*  805 */     if (this._propertyModelByElementName == null) {
/*  806 */       return NO_PROPERTIES;
/*      */     }
/*  808 */     return (SchemaProperty[])this._propertyModelByElementName.values().toArray((Object[])new SchemaProperty[this._propertyModelByElementName.size()]);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaProperty[] getAttributeProperties() {
/*  814 */     if (this._propertyModelByAttributeName == null) {
/*  815 */       return NO_PROPERTIES;
/*      */     }
/*  817 */     return (SchemaProperty[])this._propertyModelByAttributeName.values().toArray((Object[])new SchemaProperty[this._propertyModelByAttributeName.size()]);
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaProperty getElementProperty(b paramb) {
/*  822 */     return (this._propertyModelByElementName == null) ? null : (SchemaProperty)this._propertyModelByElementName.get(paramb);
/*      */   }
/*      */   public SchemaProperty getAttributeProperty(b paramb) {
/*  825 */     return (this._propertyModelByAttributeName == null) ? null : (SchemaProperty)this._propertyModelByAttributeName.get(paramb);
/*      */   }
/*      */   public boolean hasAllContent() {
/*  828 */     return this._hasAllContent;
/*      */   }
/*      */   public boolean isOrderSensitive() {
/*  831 */     return this._orderSensitive;
/*      */   }
/*      */   public void setOrderSensitive(boolean paramBoolean) {
/*  834 */     assertJavaizing(); this._orderSensitive = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setContentModel(SchemaParticle paramSchemaParticle, SchemaAttributeModel paramSchemaAttributeModel, Map paramMap1, Map paramMap2, boolean paramBoolean) {
/*  843 */     assertResolving();
/*  844 */     this._contentModel = paramSchemaParticle;
/*  845 */     this._attributeModel = paramSchemaAttributeModel;
/*  846 */     this._propertyModelByElementName = paramMap1;
/*  847 */     this._propertyModelByAttributeName = paramMap2;
/*  848 */     this._hasAllContent = paramBoolean;
/*      */ 
/*      */ 
/*      */     
/*  852 */     if (this._propertyModelByElementName != null) {
/*      */       
/*  854 */       this._validSubstitutions = new LinkedHashSet();
/*  855 */       Collection collection = this._propertyModelByElementName.values();
/*  856 */       for (SchemaProperty schemaProperty : collection) {
/*      */ 
/*      */         
/*  859 */         b[] arrayOfB = schemaProperty.acceptedNames();
/*  860 */         for (byte b1 = 0; b1 < arrayOfB.length; b1++) {
/*      */           
/*  862 */           if (!this._propertyModelByElementName.containsKey(arrayOfB[b1])) {
/*  863 */             this._validSubstitutions.add(arrayOfB[b1]);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private boolean containsElements() {
/*  871 */     return (getContentType() == 3 || getContentType() == 4);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasAttributeWildcards() {
/*  877 */     return this._hasWildcardAttributes;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean hasElementWildcards() {
/*  882 */     return this._hasWildcardElements;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isValidSubstitution(b paramb) {
/*  887 */     return this._validSubstitutions.contains(paramb);
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaType getElementType(b paramb1, b paramb2, SchemaTypeLoader paramSchemaTypeLoader) {
/*  892 */     if (isSimpleType() || !containsElements() || isNoType()) {
/*  893 */       return BuiltinSchemaTypeSystem.ST_NO_TYPE;
/*      */     }
/*  895 */     SchemaType schemaType = null;
/*  896 */     SchemaProperty schemaProperty = (SchemaProperty)this._propertyModelByElementName.get(paramb1);
/*  897 */     if (schemaProperty != null) {
/*      */       
/*  899 */       schemaType = schemaProperty.getType();
/*      */     }
/*      */     else {
/*      */       
/*  903 */       if (paramSchemaTypeLoader == null) {
/*  904 */         return BuiltinSchemaTypeSystem.ST_NO_TYPE;
/*      */       }
/*  906 */       if (this._typedWildcardElements.contains(paramb1) || this._validSubstitutions.contains(paramb1)) {
/*      */ 
/*      */         
/*  909 */         SchemaGlobalElement schemaGlobalElement = paramSchemaTypeLoader.findElement(paramb1);
/*  910 */         if (schemaGlobalElement == null) {
/*  911 */           return BuiltinSchemaTypeSystem.ST_NO_TYPE;
/*      */         }
/*      */         
/*  914 */         schemaType = schemaGlobalElement.getType();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       }
/*  933 */       else if (schemaType == null) {
/*  934 */         return BuiltinSchemaTypeSystem.ST_NO_TYPE;
/*      */       } 
/*      */     } 
/*      */     
/*  938 */     if (paramb2 != null && paramSchemaTypeLoader != null) {
/*      */       
/*  940 */       SchemaType schemaType1 = paramSchemaTypeLoader.findType(paramb2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  946 */       if (schemaType1 != null && schemaType.isAssignableFrom(schemaType1)) {
/*  947 */         return schemaType1;
/*      */       }
/*      */     } 
/*      */     
/*  951 */     return schemaType;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaType getAttributeType(b paramb, SchemaTypeLoader paramSchemaTypeLoader) {
/*  956 */     if (isSimpleType() || isNoType()) {
/*  957 */       return BuiltinSchemaTypeSystem.ST_NO_TYPE;
/*      */     }
/*  959 */     if (isURType()) {
/*  960 */       return BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
/*      */     }
/*  962 */     SchemaProperty schemaProperty = (SchemaProperty)this._propertyModelByAttributeName.get(paramb);
/*  963 */     if (schemaProperty != null) {
/*  964 */       return schemaProperty.getType();
/*      */     }
/*  966 */     if (!this._typedWildcardAttributes.contains(paramb) || paramSchemaTypeLoader == null) {
/*  967 */       return BuiltinSchemaTypeSystem.ST_NO_TYPE;
/*      */     }
/*      */ 
/*      */     
/*  971 */     SchemaGlobalAttribute schemaGlobalAttribute = paramSchemaTypeLoader.findAttribute(paramb);
/*  972 */     if (schemaGlobalAttribute == null)
/*  973 */       return BuiltinSchemaTypeSystem.ST_NO_TYPE; 
/*  974 */     return schemaGlobalAttribute.getType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlObject createElementType(b paramb1, b paramb2, SchemaTypeLoader paramSchemaTypeLoader) {
/*  984 */     SchemaType schemaType = null;
/*  985 */     SchemaProperty schemaProperty = null;
/*  986 */     if (isSimpleType() || !containsElements() || isNoType()) {
/*      */       
/*  988 */       schemaType = BuiltinSchemaTypeSystem.ST_NO_TYPE;
/*      */     }
/*      */     else {
/*      */       
/*  992 */       schemaProperty = (SchemaProperty)this._propertyModelByElementName.get(paramb1);
/*  993 */       if (schemaProperty != null) {
/*      */         
/*  995 */         SchemaType schemaType1 = schemaProperty.getType();
/*      */       }
/*  997 */       else if (this._typedWildcardElements.contains(paramb1) || this._validSubstitutions.contains(paramb1)) {
/*      */ 
/*      */         
/* 1000 */         SchemaGlobalElement schemaGlobalElement = paramSchemaTypeLoader.findElement(paramb1);
/* 1001 */         if (schemaGlobalElement != null) {
/*      */           
/* 1003 */           SchemaType schemaType1 = schemaGlobalElement.getType();
/* 1004 */           SchemaType schemaType2 = paramSchemaTypeLoader.findDocumentType(paramb1);
/* 1005 */           if (schemaType2 != null) {
/* 1006 */             schemaProperty = schemaType2.getElementProperty(paramb1);
/*      */           }
/*      */         } else {
/* 1009 */           schemaType = BuiltinSchemaTypeSystem.ST_NO_TYPE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       }
/* 1032 */       else if (schemaType == null) {
/* 1033 */         schemaType = BuiltinSchemaTypeSystem.ST_NO_TYPE;
/*      */       } 
/*      */       
/* 1036 */       if (paramb2 != null) {
/*      */         
/* 1038 */         SchemaType schemaType1 = paramSchemaTypeLoader.findType(paramb2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1044 */         if (schemaType1 != null && schemaType.isAssignableFrom(schemaType1)) {
/* 1045 */           schemaType = schemaType1;
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1050 */     if (schemaType != null)
/* 1051 */       return ((SchemaTypeImpl)schemaType).createUnattachedNode(schemaProperty); 
/* 1052 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public XmlObject createAttributeType(b paramb, SchemaTypeLoader paramSchemaTypeLoader) {
/* 1057 */     SchemaTypeImpl schemaTypeImpl = null;
/* 1058 */     SchemaProperty schemaProperty = null;
/* 1059 */     if (isSimpleType() || isNoType()) {
/*      */       
/* 1061 */       schemaTypeImpl = BuiltinSchemaTypeSystem.ST_NO_TYPE;
/*      */     }
/* 1063 */     else if (isURType()) {
/*      */       
/* 1065 */       schemaTypeImpl = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
/*      */     }
/*      */     else {
/*      */       
/* 1069 */       schemaProperty = (SchemaProperty)this._propertyModelByAttributeName.get(paramb);
/* 1070 */       if (schemaProperty != null) {
/*      */         
/* 1072 */         schemaTypeImpl = (SchemaTypeImpl)schemaProperty.getType();
/*      */       }
/* 1074 */       else if (!this._typedWildcardAttributes.contains(paramb)) {
/*      */         
/* 1076 */         schemaTypeImpl = BuiltinSchemaTypeSystem.ST_NO_TYPE;
/*      */       }
/*      */       else {
/*      */         
/* 1080 */         SchemaGlobalAttribute schemaGlobalAttribute = paramSchemaTypeLoader.findAttribute(paramb);
/* 1081 */         if (schemaGlobalAttribute != null) {
/* 1082 */           schemaTypeImpl = (SchemaTypeImpl)schemaGlobalAttribute.getType();
/*      */         } else {
/* 1084 */           schemaTypeImpl = BuiltinSchemaTypeSystem.ST_NO_TYPE;
/*      */         } 
/*      */       } 
/*      */     } 
/* 1088 */     if (schemaTypeImpl != null) {
/* 1089 */       return schemaTypeImpl.createUnattachedNode(schemaProperty);
/*      */     }
/* 1091 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setWildcardSummary(QNameSet paramQNameSet1, boolean paramBoolean1, QNameSet paramQNameSet2, boolean paramBoolean2) {
/* 1096 */     assertResolving(); this._typedWildcardElements = paramQNameSet1; this._hasWildcardElements = paramBoolean1; this._typedWildcardAttributes = paramQNameSet2; this._hasWildcardAttributes = paramBoolean2;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaType[] getAnonymousTypes() {
/* 1101 */     SchemaType[] arrayOfSchemaType = new SchemaType[this._anonymousTyperefs.length];
/* 1102 */     for (byte b1 = 0; b1 < arrayOfSchemaType.length; b1++)
/* 1103 */       arrayOfSchemaType[b1] = this._anonymousTyperefs[b1].get(); 
/* 1104 */     return arrayOfSchemaType;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setAnonymousTypeRefs(SchemaType.Ref[] paramArrayOfRef) {
/* 1109 */     this._anonymousTyperefs = paramArrayOfRef;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static SchemaType[] staCopy(SchemaType[] paramArrayOfSchemaType) {
/* 1115 */     if (paramArrayOfSchemaType == null) {
/* 1116 */       return null;
/*      */     }
/* 1118 */     SchemaType[] arrayOfSchemaType = new SchemaType[paramArrayOfSchemaType.length];
/* 1119 */     System.arraycopy(paramArrayOfSchemaType, 0, arrayOfSchemaType, 0, paramArrayOfSchemaType.length);
/* 1120 */     return arrayOfSchemaType;
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean[] boaCopy(boolean[] paramArrayOfboolean) {
/* 1125 */     if (paramArrayOfboolean == null) {
/* 1126 */       return null;
/*      */     }
/* 1128 */     boolean[] arrayOfBoolean = new boolean[paramArrayOfboolean.length];
/* 1129 */     System.arraycopy(paramArrayOfboolean, 0, arrayOfBoolean, 0, paramArrayOfboolean.length);
/* 1130 */     return arrayOfBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSimpleTypeVariety(int paramInt) {
/* 1136 */     assertResolving(); this._simpleTypeVariety = paramInt;
/*      */   }
/*      */   public int getSimpleVariety() {
/* 1139 */     return this._simpleTypeVariety;
/*      */   }
/*      */   public boolean isURType() {
/* 1142 */     return (this._builtinTypeCode == 1 || this._builtinTypeCode == 2);
/*      */   }
/*      */   public boolean isNoType() {
/* 1145 */     return (this == BuiltinSchemaTypeSystem.ST_NO_TYPE);
/*      */   }
/*      */   public boolean isSimpleType() {
/* 1148 */     return this._isSimpleType;
/*      */   }
/*      */   public void setSimpleType(boolean paramBoolean) {
/* 1151 */     assertUnresolved(); this._isSimpleType = paramBoolean;
/*      */   }
/*      */   public boolean isUnionOfLists() {
/* 1154 */     return this._isUnionOfLists;
/*      */   }
/*      */   public void setUnionOfLists(boolean paramBoolean) {
/* 1157 */     assertResolving(); this._isUnionOfLists = paramBoolean;
/*      */   }
/*      */   public SchemaType getPrimitiveType() {
/* 1160 */     return (this._primitiveTypeRef == null) ? null : this._primitiveTypeRef.get();
/*      */   }
/*      */   public void setPrimitiveTypeRef(SchemaType.Ref paramRef) {
/* 1163 */     assertResolving(); this._primitiveTypeRef = paramRef;
/*      */   }
/*      */   public int getDecimalSize() {
/* 1166 */     return this._decimalSize;
/*      */   }
/*      */   public void setDecimalSize(int paramInt) {
/* 1169 */     assertResolving(); this._decimalSize = paramInt;
/*      */   }
/*      */   public SchemaType getBaseType() {
/* 1172 */     return (this._baseTyperef == null) ? null : this._baseTyperef.get();
/*      */   }
/*      */   public void setBaseTypeRef(SchemaType.Ref paramRef) {
/* 1175 */     assertResolving(); this._baseTyperef = paramRef;
/*      */   }
/*      */   public int getBaseDepth() {
/* 1178 */     return this._baseDepth;
/*      */   }
/*      */   public void setBaseDepth(int paramInt) {
/* 1181 */     assertResolving(); this._baseDepth = paramInt;
/*      */   }
/*      */   public SchemaType getContentBasedOnType() {
/* 1184 */     return (this._contentBasedOnTyperef == null) ? null : this._contentBasedOnTyperef.get();
/*      */   }
/*      */   public void setContentBasedOnTypeRef(SchemaType.Ref paramRef) {
/* 1187 */     assertResolving(); this._contentBasedOnTyperef = paramRef;
/*      */   }
/*      */   public int getDerivationType() {
/* 1190 */     return this._derivationType;
/*      */   }
/*      */   public void setDerivationType(int paramInt) {
/* 1193 */     assertResolving(); this._derivationType = paramInt;
/*      */   }
/*      */   public SchemaType getListItemType() {
/* 1196 */     return (this._listItemTyperef == null) ? null : this._listItemTyperef.get();
/*      */   }
/*      */   public void setListItemTypeRef(SchemaType.Ref paramRef) {
/* 1199 */     assertResolving(); this._listItemTyperef = paramRef;
/*      */   }
/*      */   
/*      */   public SchemaType[] getUnionMemberTypes() {
/* 1203 */     SchemaType[] arrayOfSchemaType = new SchemaType[(this._unionMemberTyperefs == null) ? 0 : this._unionMemberTyperefs.length];
/* 1204 */     for (byte b1 = 0; b1 < arrayOfSchemaType.length; b1++)
/* 1205 */       arrayOfSchemaType[b1] = this._unionMemberTyperefs[b1].get(); 
/* 1206 */     return arrayOfSchemaType;
/*      */   }
/*      */   
/*      */   public void setUnionMemberTypeRefs(SchemaType.Ref[] paramArrayOfRef) {
/* 1210 */     assertResolving(); this._unionMemberTyperefs = paramArrayOfRef;
/*      */   }
/*      */   public int getAnonymousUnionMemberOrdinal() {
/* 1213 */     return this._anonymousUnionMemberOrdinal;
/*      */   }
/*      */   public void setAnonymousUnionMemberOrdinal(int paramInt) {
/* 1216 */     assertUnresolved(); this._anonymousUnionMemberOrdinal = paramInt;
/*      */   }
/*      */   
/*      */   public synchronized SchemaType[] getUnionConstituentTypes() {
/* 1220 */     if (this._unionCommonBaseType == null)
/* 1221 */       computeFlatUnionModel(); 
/* 1222 */     return staCopy(this._unionConstituentTypes);
/*      */   }
/*      */   
/*      */   private void setUnionConstituentTypes(SchemaType[] paramArrayOfSchemaType) {
/* 1226 */     this._unionConstituentTypes = paramArrayOfSchemaType;
/*      */   }
/*      */   
/*      */   public synchronized SchemaType[] getUnionSubTypes() {
/* 1230 */     if (this._unionCommonBaseType == null)
/* 1231 */       computeFlatUnionModel(); 
/* 1232 */     return staCopy(this._unionSubTypes);
/*      */   }
/*      */   
/*      */   private void setUnionSubTypes(SchemaType[] paramArrayOfSchemaType) {
/* 1236 */     this._unionSubTypes = paramArrayOfSchemaType;
/*      */   }
/*      */   
/*      */   public synchronized SchemaType getUnionCommonBaseType() {
/* 1240 */     if (this._unionCommonBaseType == null)
/* 1241 */       computeFlatUnionModel(); 
/* 1242 */     return this._unionCommonBaseType;
/*      */   }
/*      */   
/*      */   private void setUnionCommonBaseType(SchemaType paramSchemaType) {
/* 1246 */     this._unionCommonBaseType = paramSchemaType;
/*      */   }
/*      */   
/*      */   private void computeFlatUnionModel() {
/* 1250 */     if (getSimpleVariety() != 2)
/* 1251 */       throw new IllegalStateException("Operation is only supported on union types"); 
/* 1252 */     LinkedHashSet linkedHashSet1 = new LinkedHashSet();
/* 1253 */     LinkedHashSet linkedHashSet2 = new LinkedHashSet();
/* 1254 */     SchemaType schemaType = null;
/*      */     
/* 1256 */     linkedHashSet2.add(this);
/*      */     
/* 1258 */     for (byte b1 = 0; b1 < this._unionMemberTyperefs.length; b1++) {
/*      */       SchemaType schemaType1;
/* 1260 */       SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl)this._unionMemberTyperefs[b1].get();
/*      */       
/* 1262 */       switch (schemaTypeImpl.getSimpleVariety()) {
/*      */         
/*      */         case 3:
/* 1265 */           linkedHashSet1.add(schemaTypeImpl);
/* 1266 */           linkedHashSet2.add(schemaTypeImpl);
/* 1267 */           schemaType = schemaTypeImpl.getCommonBaseType(schemaType);
/*      */           break;
/*      */         case 2:
/* 1270 */           linkedHashSet1.addAll((Collection)Arrays.asList(schemaTypeImpl.getUnionConstituentTypes()));
/* 1271 */           linkedHashSet2.addAll((Collection)Arrays.asList(schemaTypeImpl.getUnionSubTypes()));
/* 1272 */           schemaType1 = schemaTypeImpl.getUnionCommonBaseType();
/* 1273 */           if (schemaType1 != null)
/* 1274 */             schemaType = schemaType1.getCommonBaseType(schemaType); 
/*      */           break;
/*      */         case 1:
/* 1277 */           linkedHashSet1.add(schemaTypeImpl);
/* 1278 */           linkedHashSet2.add(schemaTypeImpl);
/* 1279 */           schemaType = schemaTypeImpl.getCommonBaseType(schemaType);
/*      */           break;
/*      */         default:
/*      */           assert false;
/*      */           break;
/*      */       } 
/*      */     } 
/* 1286 */     setUnionConstituentTypes(linkedHashSet1.<SchemaType>toArray(StscState.EMPTY_ST_ARRAY));
/*      */     
/* 1288 */     setUnionSubTypes(linkedHashSet2.<SchemaType>toArray(StscState.EMPTY_ST_ARRAY));
/*      */     
/* 1290 */     setUnionCommonBaseType(schemaType);
/*      */   }
/*      */   
/*      */   public b getSubstitutionGroup() {
/* 1294 */     return this._sg;
/*      */   }
/*      */   public void setSubstitutionGroup(b paramb) {
/* 1297 */     assertSGResolving(); this._sg = paramb;
/*      */   }
/*      */   public void addSubstitutionGroupMember(b paramb) {
/* 1300 */     assertSGResolved(); this._sgMembers.add(paramb);
/*      */   }
/*      */   
/*      */   public b[] getSubstitutionGroupMembers() {
/* 1304 */     b[] arrayOfB = new b[this._sgMembers.size()];
/* 1305 */     return (b[])this._sgMembers.toArray((Object[])arrayOfB);
/*      */   }
/*      */   
/*      */   public int getWhiteSpaceRule() {
/* 1309 */     return this._whiteSpaceRule;
/*      */   }
/*      */   public void setWhiteSpaceRule(int paramInt) {
/* 1312 */     assertResolving(); this._whiteSpaceRule = paramInt;
/*      */   }
/*      */   
/*      */   public XmlAnySimpleType getFacet(int paramInt) {
/* 1316 */     if (this._facetArray == null)
/* 1317 */       return null; 
/* 1318 */     XmlValueRef xmlValueRef = this._facetArray[paramInt];
/* 1319 */     if (xmlValueRef == null)
/* 1320 */       return null; 
/* 1321 */     return xmlValueRef.get();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isFacetFixed(int paramInt) {
/* 1326 */     return this._fixedFacetArray[paramInt];
/*      */   }
/*      */ 
/*      */   
/*      */   public XmlAnySimpleType[] getBasicFacets() {
/* 1331 */     XmlAnySimpleType[] arrayOfXmlAnySimpleType = new XmlAnySimpleType[12];
/* 1332 */     for (byte b1 = 0; b1 <= 11; b1++)
/*      */     {
/* 1334 */       arrayOfXmlAnySimpleType[b1] = getFacet(b1);
/*      */     }
/* 1336 */     return arrayOfXmlAnySimpleType;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean[] getFixedFacets() {
/* 1341 */     return boaCopy(this._fixedFacetArray);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setBasicFacets(XmlValueRef[] paramArrayOfXmlValueRef, boolean[] paramArrayOfboolean) {
/* 1346 */     assertResolving();
/* 1347 */     this._facetArray = paramArrayOfXmlValueRef;
/* 1348 */     this._fixedFacetArray = paramArrayOfboolean;
/*      */   }
/*      */   
/*      */   public int ordered() {
/* 1352 */     return this._ordered;
/*      */   }
/*      */   public void setOrdered(int paramInt) {
/* 1355 */     assertResolving(); this._ordered = paramInt;
/*      */   }
/*      */   public boolean isBounded() {
/* 1358 */     return this._isBounded;
/*      */   }
/*      */   public void setBounded(boolean paramBoolean) {
/* 1361 */     assertResolving(); this._isBounded = paramBoolean;
/*      */   }
/*      */   public boolean isFinite() {
/* 1364 */     return this._isFinite;
/*      */   }
/*      */   public void setFinite(boolean paramBoolean) {
/* 1367 */     assertResolving(); this._isFinite = paramBoolean;
/*      */   }
/*      */   public boolean isNumeric() {
/* 1370 */     return this._isNumeric;
/*      */   }
/*      */   public void setNumeric(boolean paramBoolean) {
/* 1373 */     assertResolving(); this._isNumeric = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean hasPatternFacet() {
/* 1377 */     return this._hasPatterns;
/*      */   }
/*      */   public void setPatternFacet(boolean paramBoolean) {
/* 1380 */     assertResolving(); this._hasPatterns = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean matchPatternFacet(String paramString) {
/* 1384 */     if (!this._hasPatterns) {
/* 1385 */       return true;
/*      */     }
/* 1387 */     if (this._patterns != null && this._patterns.length > 0) {
/*      */       byte b1;
/*      */       
/* 1390 */       for (b1 = 0; b1 < this._patterns.length; b1++) {
/*      */         
/* 1392 */         if (this._patterns[b1].matches(paramString))
/*      */           break; 
/*      */       } 
/* 1395 */       if (b1 >= this._patterns.length) {
/* 1396 */         return false;
/*      */       }
/*      */     } 
/* 1399 */     return getBaseType().matchPatternFacet(paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   public String[] getPatterns() {
/* 1404 */     if (this._patterns == null)
/* 1405 */       return new String[0]; 
/* 1406 */     String[] arrayOfString = new String[this._patterns.length];
/* 1407 */     for (byte b1 = 0; b1 < this._patterns.length; b1++)
/* 1408 */       arrayOfString[b1] = this._patterns[b1].getPattern(); 
/* 1409 */     return arrayOfString;
/*      */   }
/*      */ 
/*      */   
/*      */   public RegularExpression[] getPatternExpressions() {
/* 1414 */     if (this._patterns == null)
/* 1415 */       return new RegularExpression[0]; 
/* 1416 */     RegularExpression[] arrayOfRegularExpression = new RegularExpression[this._patterns.length];
/* 1417 */     System.arraycopy(this._patterns, 0, arrayOfRegularExpression, 0, this._patterns.length);
/* 1418 */     return arrayOfRegularExpression;
/*      */   }
/*      */   
/*      */   public void setPatterns(RegularExpression[] paramArrayOfRegularExpression) {
/* 1422 */     assertResolving(); this._patterns = paramArrayOfRegularExpression;
/*      */   }
/*      */   
/*      */   public XmlAnySimpleType[] getEnumerationValues() {
/* 1426 */     if (this._enumerationValues == null)
/* 1427 */       return null; 
/* 1428 */     XmlAnySimpleType[] arrayOfXmlAnySimpleType = new XmlAnySimpleType[this._enumerationValues.length];
/* 1429 */     for (byte b1 = 0; b1 < arrayOfXmlAnySimpleType.length; b1++) {
/*      */       
/* 1431 */       XmlValueRef xmlValueRef = this._enumerationValues[b1];
/* 1432 */       arrayOfXmlAnySimpleType[b1] = (xmlValueRef == null) ? null : xmlValueRef.get();
/*      */     } 
/*      */     
/* 1435 */     return arrayOfXmlAnySimpleType;
/*      */   }
/*      */   
/*      */   public void setEnumerationValues(XmlValueRef[] paramArrayOfXmlValueRef) {
/* 1439 */     assertResolving(); this._enumerationValues = paramArrayOfXmlValueRef;
/*      */   }
/*      */   
/*      */   public StringEnumAbstractBase enumForString(String paramString) {
/* 1443 */     ensureStringEnumInfo();
/* 1444 */     if (this._lookupStringEnum == null)
/* 1445 */       return null; 
/* 1446 */     return (StringEnumAbstractBase)this._lookupStringEnum.get(paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   public StringEnumAbstractBase enumForInt(int paramInt) {
/* 1451 */     ensureStringEnumInfo();
/* 1452 */     if (this._listOfStringEnum == null || paramInt < 0 || paramInt >= this._listOfStringEnum.size())
/* 1453 */       return null; 
/* 1454 */     return this._listOfStringEnum.get(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaStringEnumEntry enumEntryForString(String paramString) {
/* 1459 */     ensureStringEnumInfo();
/* 1460 */     if (this._lookupStringEnumEntry == null)
/* 1461 */       return null; 
/* 1462 */     return (SchemaStringEnumEntry)this._lookupStringEnumEntry.get(paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaType getBaseEnumType() {
/* 1467 */     return (this._baseEnumTyperef == null) ? null : this._baseEnumTyperef.get();
/*      */   }
/*      */ 
/*      */   
/*      */   public void setBaseEnumTypeRef(SchemaType.Ref paramRef) {
/* 1472 */     this._baseEnumTyperef = paramRef;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaStringEnumEntry[] getStringEnumEntries() {
/* 1477 */     if (this._stringEnumEntries == null)
/* 1478 */       return null; 
/* 1479 */     SchemaStringEnumEntry[] arrayOfSchemaStringEnumEntry = new SchemaStringEnumEntry[this._stringEnumEntries.length];
/* 1480 */     System.arraycopy(this._stringEnumEntries, 0, arrayOfSchemaStringEnumEntry, 0, arrayOfSchemaStringEnumEntry.length);
/* 1481 */     return arrayOfSchemaStringEnumEntry;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setStringEnumEntries(SchemaStringEnumEntry[] paramArrayOfSchemaStringEnumEntry) {
/* 1486 */     assertJavaizing();
/* 1487 */     this._stringEnumEntries = paramArrayOfSchemaStringEnumEntry;
/*      */   }
/*      */ 
/*      */   
/*      */   private void ensureStringEnumInfo() {
/* 1492 */     if (this._stringEnumEnsured) {
/*      */       return;
/*      */     }
/* 1495 */     SchemaStringEnumEntry[] arrayOfSchemaStringEnumEntry = this._stringEnumEntries;
/* 1496 */     if (arrayOfSchemaStringEnumEntry == null) {
/*      */       
/* 1498 */       this._stringEnumEnsured = true;
/*      */       
/*      */       return;
/*      */     } 
/* 1502 */     HashMap hashMap1 = new HashMap(arrayOfSchemaStringEnumEntry.length);
/* 1503 */     ArrayList arrayList = new ArrayList(arrayOfSchemaStringEnumEntry.length + 1);
/* 1504 */     HashMap hashMap2 = new HashMap(arrayOfSchemaStringEnumEntry.length);
/*      */     
/* 1506 */     for (byte b1 = 0; b1 < arrayOfSchemaStringEnumEntry.length; b1++)
/*      */     {
/* 1508 */       hashMap2.put(arrayOfSchemaStringEnumEntry[b1].getString(), arrayOfSchemaStringEnumEntry[b1]);
/*      */     }
/*      */     
/* 1511 */     Class clazz = this._baseEnumTyperef.get().getEnumJavaClass();
/* 1512 */     if (clazz != null) {
/*      */       
/*      */       try {
/*      */         
/* 1516 */         StringEnumAbstractBase.Table table = (StringEnumAbstractBase.Table)clazz.getField("table").get(null);
/* 1517 */         for (byte b2 = 0; b2 < arrayOfSchemaStringEnumEntry.length; b2++)
/*      */         {
/* 1519 */           int i = arrayOfSchemaStringEnumEntry[b2].getIntValue();
/* 1520 */           StringEnumAbstractBase stringEnumAbstractBase = table.forInt(i);
/* 1521 */           hashMap1.put(arrayOfSchemaStringEnumEntry[b2].getString(), stringEnumAbstractBase);
/* 1522 */           while (arrayList.size() <= i)
/* 1523 */             arrayList.add(null); 
/* 1524 */           arrayList.set(i, stringEnumAbstractBase);
/*      */         }
/*      */       
/* 1527 */       } catch (Exception exception) {
/*      */         
/* 1529 */         System.err.println("Something wrong: could not locate enum table for " + clazz);
/* 1530 */         clazz = null;
/* 1531 */         hashMap1.clear();
/* 1532 */         arrayList.clear();
/*      */       } 
/*      */     }
/*      */     
/* 1536 */     if (clazz == null)
/*      */     {
/* 1538 */       for (byte b2 = 0; b2 < arrayOfSchemaStringEnumEntry.length; b2++) {
/*      */         
/* 1540 */         int i = arrayOfSchemaStringEnumEntry[b2].getIntValue();
/* 1541 */         String str = arrayOfSchemaStringEnumEntry[b2].getString();
/* 1542 */         StringEnumValue stringEnumValue = new StringEnumValue(str, i);
/* 1543 */         hashMap1.put(str, stringEnumValue);
/* 1544 */         while (arrayList.size() <= i)
/* 1545 */           arrayList.add(null); 
/* 1546 */         arrayList.set(i, stringEnumValue);
/*      */       } 
/*      */     }
/*      */     
/* 1550 */     synchronized (this) {
/*      */       
/* 1552 */       if (!this._stringEnumEnsured) {
/*      */         
/* 1554 */         this._lookupStringEnum = hashMap1;
/* 1555 */         this._listOfStringEnum = arrayList;
/* 1556 */         this._lookupStringEnumEntry = hashMap2;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1561 */     synchronized (this) {
/*      */       
/* 1563 */       this._stringEnumEnsured = true;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean hasStringEnumValues() {
/* 1569 */     return (this._stringEnumEntries != null);
/*      */   }
/*      */ 
/*      */   
/*      */   public void copyEnumerationValues(SchemaTypeImpl paramSchemaTypeImpl) {
/* 1574 */     assertResolving();
/* 1575 */     this._enumerationValues = paramSchemaTypeImpl._enumerationValues;
/* 1576 */     this._baseEnumTyperef = paramSchemaTypeImpl._baseEnumTyperef;
/*      */   }
/*      */   
/*      */   public int getBuiltinTypeCode() {
/* 1580 */     return this._builtinTypeCode;
/*      */   }
/*      */   public void setBuiltinTypeCode(int paramInt) {
/* 1583 */     assertResolving(); this._builtinTypeCode = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   synchronized void assignJavaElementSetterModel() {
/* 1590 */     SchemaProperty[] arrayOfSchemaProperty = getElementProperties();
/* 1591 */     SchemaParticle schemaParticle = getContentModel();
/* 1592 */     HashMap hashMap = new HashMap();
/* 1593 */     QNameSet qNameSet = computeAllContainedElements(schemaParticle, hashMap);
/*      */     
/* 1595 */     for (byte b1 = 0; b1 < arrayOfSchemaProperty.length; b1++) {
/*      */       
/* 1597 */       SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl)arrayOfSchemaProperty[b1];
/* 1598 */       QNameSet qNameSet1 = computeNondelimitingElements(schemaPropertyImpl.getName(), schemaParticle, hashMap);
/* 1599 */       QNameSetBuilder qNameSetBuilder = new QNameSetBuilder((QNameSetSpecification)qNameSet);
/* 1600 */       qNameSetBuilder.removeAll((QNameSetSpecification)qNameSet1);
/* 1601 */       schemaPropertyImpl.setJavaSetterDelimiter(qNameSetBuilder.toQNameSet());
/*      */     } 
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
/*      */   private static QNameSet computeNondelimitingElements(b paramb, SchemaParticle paramSchemaParticle, Map paramMap) {
/* 1615 */     QNameSet qNameSet = computeAllContainedElements(paramSchemaParticle, paramMap);
/* 1616 */     if (!qNameSet.contains(paramb)) {
/* 1617 */       return QNameSet.EMPTY;
/*      */     }
/*      */     
/* 1620 */     if (paramSchemaParticle.getMaxOccurs() == null || paramSchemaParticle.getMaxOccurs().compareTo(BigInteger.ONE) > 0)
/*      */     {
/* 1622 */       return qNameSet;
/*      */     }
/*      */ 
/*      */     
/* 1626 */     switch (paramSchemaParticle.getParticleType()) {
/*      */ 
/*      */ 
/*      */       
/*      */       default:
/* 1631 */         return qNameSet;
/*      */       
/*      */       case 5:
/* 1634 */         return QNameSet.singleton(paramb);
/*      */       
/*      */       case 2:
/* 1637 */         qNameSetBuilder = new QNameSetBuilder();
/* 1638 */         for (b1 = 0; b1 < paramSchemaParticle.countOfParticleChild(); b1++) {
/*      */           
/* 1640 */           QNameSet qNameSet1 = computeAllContainedElements(paramSchemaParticle.getParticleChild(b1), paramMap);
/* 1641 */           if (qNameSet1.contains(paramb))
/* 1642 */             qNameSetBuilder.addAll((QNameSetSpecification)computeNondelimitingElements(paramb, paramSchemaParticle.getParticleChild(b1), paramMap)); 
/*      */         } 
/* 1644 */         return qNameSetBuilder.toQNameSet();
/*      */       case 3:
/*      */         break;
/* 1647 */     }  QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
/* 1648 */     byte b1 = 0;
/* 1649 */     for (int i = paramSchemaParticle.countOfParticleChild(); i > 0; ) {
/*      */       
/* 1651 */       i--;
/* 1652 */       QNameSet qNameSet1 = computeAllContainedElements(paramSchemaParticle.getParticleChild(i), paramMap);
/* 1653 */       if (b1 != 0) {
/*      */         
/* 1655 */         qNameSetBuilder.addAll((QNameSetSpecification)qNameSet1); continue;
/*      */       } 
/* 1657 */       if (qNameSet1.contains(paramb)) {
/*      */         
/* 1659 */         qNameSetBuilder.addAll((QNameSetSpecification)computeNondelimitingElements(paramb, paramSchemaParticle.getParticleChild(i), paramMap));
/* 1660 */         b1 = 1;
/*      */       } 
/*      */     } 
/* 1663 */     return qNameSetBuilder.toQNameSet();
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
/*      */   private static QNameSet computeAllContainedElements(SchemaParticle paramSchemaParticle, Map paramMap) {
/*      */     QNameSetBuilder qNameSetBuilder;
/*      */     byte b1;
/* 1678 */     QNameSet qNameSet = (QNameSet)paramMap.get(paramSchemaParticle);
/* 1679 */     if (qNameSet != null) {
/* 1680 */       return qNameSet;
/*      */     }
/*      */ 
/*      */     
/* 1684 */     switch (paramSchemaParticle.getParticleType())
/*      */     
/*      */     { 
/*      */ 
/*      */       
/*      */       default:
/* 1690 */         qNameSetBuilder = new QNameSetBuilder();
/* 1691 */         for (b1 = 0; b1 < paramSchemaParticle.countOfParticleChild(); b1++)
/*      */         {
/* 1693 */           qNameSetBuilder.addAll((QNameSetSpecification)computeAllContainedElements(paramSchemaParticle.getParticleChild(b1), paramMap));
/*      */         }
/* 1695 */         qNameSet = qNameSetBuilder.toQNameSet();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1707 */         paramMap.put(paramSchemaParticle, qNameSet);
/* 1708 */         return qNameSet;case 5: qNameSet = paramSchemaParticle.getWildcardSet(); paramMap.put(paramSchemaParticle, qNameSet); return qNameSet;case 4: break; }  qNameSet = ((SchemaLocalElementImpl)paramSchemaParticle).acceptedStartNames(); paramMap.put(paramSchemaParticle, qNameSet); return qNameSet;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Class getJavaClass() {
/* 1714 */     if (this._javaClass == null && getFullJavaName() != null) {
/*      */       
/*      */       try {
/* 1717 */         this._javaClass = Class.forName(getFullJavaName(), false, getTypeSystem().getClassLoader());
/* 1718 */       } catch (ClassNotFoundException classNotFoundException) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1724 */         this._javaClass = null;
/*      */       } 
/*      */     }
/*      */     
/* 1728 */     return this._javaClass;
/*      */   }
/*      */   
/*      */   public Class getJavaImplClass() {
/* 1732 */     if (this._implNotAvailable) {
/* 1733 */       return null;
/*      */     }
/* 1735 */     if (this._javaImplClass == null) {
/*      */       
/*      */       try {
/* 1738 */         if (getFullJavaImplName() != null) {
/* 1739 */           this._javaImplClass = Class.forName(getFullJavaImplName(), false, getTypeSystem().getClassLoader());
/*      */         } else {
/* 1741 */           this._implNotAvailable = true;
/*      */         } 
/* 1743 */       } catch (ClassNotFoundException classNotFoundException) {
/* 1744 */         this._implNotAvailable = true;
/*      */       } 
/*      */     }
/*      */     
/* 1748 */     return this._javaImplClass;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Class getUserTypeClass() {
/* 1754 */     if (this._userTypeClass == null && getUserTypeName() != null) {
/*      */       
/*      */       try {
/*      */         
/* 1758 */         this._userTypeClass = Class.forName(this._userTypeName, false, getTypeSystem().getClassLoader());
/*      */       
/*      */       }
/* 1761 */       catch (ClassNotFoundException classNotFoundException) {
/*      */         
/* 1763 */         this._userTypeClass = null;
/*      */       } 
/*      */     }
/*      */     
/* 1767 */     return this._userTypeClass;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Class getUserTypeHandlerClass() {
/* 1773 */     if (this._userTypeHandlerClass == null && getUserTypeHandlerName() != null) {
/*      */       
/*      */       try {
/*      */         
/* 1777 */         this._userTypeHandlerClass = Class.forName(this._userTypeHandler, false, getTypeSystem().getClassLoader());
/*      */       
/*      */       }
/* 1780 */       catch (ClassNotFoundException classNotFoundException) {
/*      */         
/* 1782 */         this._userTypeHandlerClass = null;
/*      */       } 
/*      */     }
/*      */     
/* 1786 */     return this._userTypeHandlerClass;
/*      */   }
/*      */ 
/*      */   
/*      */   public Constructor getJavaImplConstructor() {
/* 1791 */     if (this._javaImplConstructor == null && !this._implNotAvailable) {
/*      */       
/* 1793 */       Class clazz = getJavaImplClass();
/* 1794 */       if (clazz == null) return null;
/*      */       
/*      */       try {
/* 1797 */         this._javaImplConstructor = clazz.getConstructor(new Class[] { SchemaType.class });
/*      */       }
/* 1799 */       catch (NoSuchMethodException noSuchMethodException) {
/*      */         
/* 1801 */         noSuchMethodException.printStackTrace();
/*      */       } 
/*      */     } 
/*      */     
/* 1805 */     return this._javaImplConstructor;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Constructor getJavaImplConstructor2() {
/* 1811 */     if (this._javaImplConstructor2 == null && !this._implNotAvailable) {
/*      */       
/* 1813 */       Class clazz = getJavaImplClass();
/* 1814 */       if (clazz == null) return null;
/*      */       
/*      */       try {
/* 1817 */         this._javaImplConstructor2 = clazz.getDeclaredConstructor(new Class[] { SchemaType.class, boolean.class });
/*      */       }
/* 1819 */       catch (NoSuchMethodException noSuchMethodException) {
/*      */         
/* 1821 */         noSuchMethodException.printStackTrace();
/*      */       } 
/*      */     } 
/*      */     
/* 1825 */     return this._javaImplConstructor2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Class getEnumJavaClass() {
/* 1832 */     if (this._javaEnumClass == null)
/*      */     {
/* 1834 */       if (getBaseEnumType() != null) {
/*      */         
/*      */         try {
/*      */           
/* 1838 */           this._javaEnumClass = Class.forName(getBaseEnumType().getFullJavaName() + "$Enum", false, getTypeSystem().getClassLoader());
/*      */         }
/* 1840 */         catch (ClassNotFoundException classNotFoundException) {
/*      */           
/* 1842 */           this._javaEnumClass = null;
/*      */         } 
/*      */       }
/*      */     }
/*      */     
/* 1847 */     return this._javaEnumClass;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setJavaClass(Class paramClass) {
/* 1852 */     assertResolved();
/* 1853 */     this._javaClass = paramClass;
/* 1854 */     setFullJavaName(paramClass.getName());
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isPrimitiveType() {
/* 1859 */     return (getBuiltinTypeCode() >= 2 && getBuiltinTypeCode() <= 21);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isBuiltinType() {
/* 1865 */     return (getBuiltinTypeCode() != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlObject createUnwrappedNode() {
/* 1871 */     return createUnattachedNode(null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TypeStoreUser createTypeStoreUser() {
/* 1880 */     return (TypeStoreUser)createUnattachedNode(null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlAnySimpleType newValidatingValue(Object paramObject) {
/* 1886 */     return newValue(paramObject, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlAnySimpleType newValue(Object paramObject) {
/* 1893 */     return newValue(paramObject, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public XmlAnySimpleType newValue(Object paramObject, boolean paramBoolean) {
/* 1898 */     if (!isSimpleType() && getContentType() != 2) {
/* 1899 */       throw new XmlValueOutOfRangeException();
/*      */     }
/* 1901 */     XmlObjectBase xmlObjectBase = (XmlObjectBase)createUnattachedNode(null);
/* 1902 */     if (paramBoolean) {
/* 1903 */       xmlObjectBase.setValidateOnSet();
/*      */     }
/*      */ 
/*      */     
/* 1907 */     if (paramObject instanceof XmlObject) {
/* 1908 */       xmlObjectBase.set_newValue((XmlObject)paramObject);
/*      */     } else {
/* 1910 */       xmlObjectBase.objectSet(paramObject);
/*      */     } 
/* 1912 */     xmlObjectBase.check_dated();
/* 1913 */     xmlObjectBase.setImmutable();
/*      */     
/* 1915 */     return (XmlAnySimpleType)xmlObjectBase;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private XmlObject createUnattachedNode(SchemaProperty paramSchemaProperty) {
/* 1923 */     XmlObject xmlObject = null;
/*      */     
/* 1925 */     if (!isBuiltinType() && !isNoType()) {
/*      */ 
/*      */       
/* 1928 */       Constructor constructor = getJavaImplConstructor();
/* 1929 */       if (constructor != null) {
/*      */         try
/*      */         {
/*      */ 
/*      */           
/* 1934 */           return constructor.newInstance(this._ctrArgs);
/*      */         }
/* 1936 */         catch (Exception exception)
/*      */         {
/* 1938 */           System.out.println("Exception trying to instantiate impl class.");
/* 1939 */           exception.printStackTrace();
/*      */         }
/*      */       
/*      */       }
/*      */     } else {
/*      */       
/* 1945 */       xmlObject = createBuiltinInstance();
/*      */     } 
/*      */ 
/*      */     
/* 1949 */     for (SchemaTypeImpl schemaTypeImpl = this; xmlObject == null; schemaType = schemaTypeImpl.getBaseType()) {
/* 1950 */       SchemaType schemaType; xmlObject = schemaTypeImpl.createUnattachedSubclass(this);
/*      */     } 
/* 1952 */     ((XmlObjectBase)xmlObject).init_flags(paramSchemaProperty);
/* 1953 */     return xmlObject;
/*      */   }
/*      */ 
/*      */   
/*      */   private XmlObject createUnattachedSubclass(SchemaType paramSchemaType) {
/* 1958 */     if (!isBuiltinType() && !isNoType()) {
/*      */ 
/*      */       
/* 1961 */       Constructor constructor = getJavaImplConstructor2();
/* 1962 */       if (constructor != null) {
/*      */         
/* 1964 */         boolean bool = constructor.isAccessible();
/*      */         
/*      */         try {
/* 1967 */           constructor.setAccessible(true);
/*      */ 
/*      */           
/*      */           try {
/* 1971 */             return constructor.newInstance(new Object[] { paramSchemaType, paramSchemaType.isSimpleType() ? Boolean.FALSE : Boolean.TRUE });
/*      */           }
/* 1973 */           catch (Exception exception) {
/*      */             
/* 1975 */             System.out.println("Exception trying to instantiate impl class.");
/* 1976 */             exception.printStackTrace();
/*      */           } finally {
/*      */ 
/*      */             
/*      */             try {
/*      */               
/* 1982 */               constructor.setAccessible(bool);
/* 1983 */             } catch (SecurityException securityException) {}
/*      */           }
/*      */         
/*      */         }
/* 1987 */         catch (Exception exception) {
/*      */           
/* 1989 */           System.out.println("Exception trying to instantiate impl class.");
/* 1990 */           exception.printStackTrace();
/*      */         } 
/*      */       } 
/* 1993 */       return null;
/*      */     } 
/*      */ 
/*      */     
/* 1997 */     return createBuiltinSubclass(paramSchemaType);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private XmlObject createBuiltinInstance() {
/* 2003 */     switch (getBuiltinTypeCode()) {
/*      */       
/*      */       case 0:
/* 2006 */         return (XmlObject)new XmlAnyTypeImpl(BuiltinSchemaTypeSystem.ST_NO_TYPE);
/*      */       case 1:
/* 2008 */         return (XmlObject)new XmlAnyTypeImpl();
/*      */       case 2:
/* 2010 */         return (XmlObject)new XmlAnySimpleTypeImpl();
/*      */       case 3:
/* 2012 */         return (XmlObject)new XmlBooleanImpl();
/*      */       case 4:
/* 2014 */         return (XmlObject)new XmlBase64BinaryImpl();
/*      */       case 5:
/* 2016 */         return (XmlObject)new XmlHexBinaryImpl();
/*      */       case 6:
/* 2018 */         return (XmlObject)new XmlAnyUriImpl();
/*      */       case 7:
/* 2020 */         return (XmlObject)new XmlQNameImpl();
/*      */       case 8:
/* 2022 */         return (XmlObject)new XmlNotationImpl();
/*      */       case 9:
/* 2024 */         return (XmlObject)new XmlFloatImpl();
/*      */       case 10:
/* 2026 */         return (XmlObject)new XmlDoubleImpl();
/*      */       case 11:
/* 2028 */         return (XmlObject)new XmlDecimalImpl();
/*      */       case 12:
/* 2030 */         return (XmlObject)new XmlStringImpl();
/*      */       case 13:
/* 2032 */         return (XmlObject)new XmlDurationImpl();
/*      */       case 14:
/* 2034 */         return (XmlObject)new XmlDateTimeImpl();
/*      */       case 15:
/* 2036 */         return (XmlObject)new XmlTimeImpl();
/*      */       case 16:
/* 2038 */         return (XmlObject)new XmlDateImpl();
/*      */       case 17:
/* 2040 */         return (XmlObject)new XmlGYearMonthImpl();
/*      */       case 18:
/* 2042 */         return (XmlObject)new XmlGYearImpl();
/*      */       case 19:
/* 2044 */         return (XmlObject)new XmlGMonthDayImpl();
/*      */       case 20:
/* 2046 */         return (XmlObject)new XmlGDayImpl();
/*      */       case 21:
/* 2048 */         return (XmlObject)new XmlGMonthImpl();
/*      */       case 22:
/* 2050 */         return (XmlObject)new XmlIntegerImpl();
/*      */       case 23:
/* 2052 */         return (XmlObject)new XmlLongImpl();
/*      */       case 24:
/* 2054 */         return (XmlObject)new XmlIntImpl();
/*      */       case 25:
/* 2056 */         return (XmlObject)new XmlShortImpl();
/*      */       case 26:
/* 2058 */         return (XmlObject)new XmlByteImpl();
/*      */       case 27:
/* 2060 */         return (XmlObject)new XmlNonPositiveIntegerImpl();
/*      */       case 28:
/* 2062 */         return (XmlObject)new XmlNegativeIntegerImpl();
/*      */       case 29:
/* 2064 */         return (XmlObject)new XmlNonNegativeIntegerImpl();
/*      */       case 30:
/* 2066 */         return (XmlObject)new XmlPositiveIntegerImpl();
/*      */       case 31:
/* 2068 */         return (XmlObject)new XmlUnsignedLongImpl();
/*      */       case 32:
/* 2070 */         return (XmlObject)new XmlUnsignedIntImpl();
/*      */       case 33:
/* 2072 */         return (XmlObject)new XmlUnsignedShortImpl();
/*      */       case 34:
/* 2074 */         return (XmlObject)new XmlUnsignedByteImpl();
/*      */       case 35:
/* 2076 */         return (XmlObject)new XmlNormalizedStringImpl();
/*      */       case 36:
/* 2078 */         return (XmlObject)new XmlTokenImpl();
/*      */       case 37:
/* 2080 */         return (XmlObject)new XmlNameImpl();
/*      */       case 38:
/* 2082 */         return (XmlObject)new XmlNCNameImpl();
/*      */       case 39:
/* 2084 */         return (XmlObject)new XmlLanguageImpl();
/*      */       case 40:
/* 2086 */         return (XmlObject)new XmlIdImpl();
/*      */       case 41:
/* 2088 */         return (XmlObject)new XmlIdRefImpl();
/*      */       case 42:
/* 2090 */         return (XmlObject)new XmlIdRefsImpl();
/*      */       case 43:
/* 2092 */         return (XmlObject)new XmlEntityImpl();
/*      */       case 44:
/* 2094 */         return (XmlObject)new XmlEntitiesImpl();
/*      */       case 45:
/* 2096 */         return (XmlObject)new XmlNmTokenImpl();
/*      */       case 46:
/* 2098 */         return (XmlObject)new XmlNmTokensImpl();
/*      */     } 
/* 2100 */     throw new IllegalStateException("Unrecognized builtin type: " + getBuiltinTypeCode());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private XmlObject createBuiltinSubclass(SchemaType paramSchemaType) {
/* 2106 */     boolean bool = !paramSchemaType.isSimpleType() ? true : false;
/* 2107 */     switch (getBuiltinTypeCode()) {
/*      */       
/*      */       case 0:
/* 2110 */         return (XmlObject)new XmlAnyTypeImpl(BuiltinSchemaTypeSystem.ST_NO_TYPE);
/*      */       case 1:
/*      */       case 2:
/* 2113 */         switch (paramSchemaType.getSimpleVariety()) {
/*      */           
/*      */           case 0:
/* 2116 */             return (XmlObject)new XmlComplexContentImpl(paramSchemaType);
/*      */           case 1:
/* 2118 */             return (XmlObject)new XmlAnySimpleTypeRestriction(paramSchemaType, bool);
/*      */           case 3:
/* 2120 */             return (XmlObject)new XmlListImpl(paramSchemaType, bool);
/*      */           case 2:
/* 2122 */             return (XmlObject)new XmlUnionImpl(paramSchemaType, bool);
/*      */         } 
/* 2124 */         throw new IllegalStateException();
/*      */       
/*      */       case 3:
/* 2127 */         return (XmlObject)new XmlBooleanRestriction(paramSchemaType, bool);
/*      */       case 4:
/* 2129 */         return (XmlObject)new XmlBase64BinaryRestriction(paramSchemaType, bool);
/*      */       case 5:
/* 2131 */         return (XmlObject)new XmlHexBinaryRestriction(paramSchemaType, bool);
/*      */       case 6:
/* 2133 */         return (XmlObject)new XmlAnyUriRestriction(paramSchemaType, bool);
/*      */       case 7:
/* 2135 */         return (XmlObject)new XmlQNameRestriction(paramSchemaType, bool);
/*      */       case 8:
/* 2137 */         return (XmlObject)new XmlNotationRestriction(paramSchemaType, bool);
/*      */       case 9:
/* 2139 */         return (XmlObject)new XmlFloatRestriction(paramSchemaType, bool);
/*      */       case 10:
/* 2141 */         return (XmlObject)new XmlDoubleRestriction(paramSchemaType, bool);
/*      */       case 11:
/* 2143 */         return (XmlObject)new XmlDecimalRestriction(paramSchemaType, bool);
/*      */       case 12:
/* 2145 */         if (paramSchemaType.hasStringEnumValues()) {
/* 2146 */           return (XmlObject)new XmlStringEnumeration(paramSchemaType, bool);
/*      */         }
/* 2148 */         return (XmlObject)new XmlStringRestriction(paramSchemaType, bool);
/*      */       case 13:
/* 2150 */         return (XmlObject)new XmlDurationImpl(paramSchemaType, bool);
/*      */       case 14:
/* 2152 */         return (XmlObject)new XmlDateTimeImpl(paramSchemaType, bool);
/*      */       case 15:
/* 2154 */         return (XmlObject)new XmlTimeImpl(paramSchemaType, bool);
/*      */       case 16:
/* 2156 */         return (XmlObject)new XmlDateImpl(paramSchemaType, bool);
/*      */       case 17:
/* 2158 */         return (XmlObject)new XmlGYearMonthImpl(paramSchemaType, bool);
/*      */       case 18:
/* 2160 */         return (XmlObject)new XmlGYearImpl(paramSchemaType, bool);
/*      */       case 19:
/* 2162 */         return (XmlObject)new XmlGMonthDayImpl(paramSchemaType, bool);
/*      */       case 20:
/* 2164 */         return (XmlObject)new XmlGDayImpl(paramSchemaType, bool);
/*      */       case 21:
/* 2166 */         return (XmlObject)new XmlGMonthImpl(paramSchemaType, bool);
/*      */       case 22:
/* 2168 */         return (XmlObject)new XmlIntegerRestriction(paramSchemaType, bool);
/*      */       case 23:
/* 2170 */         return (XmlObject)new XmlLongRestriction(paramSchemaType, bool);
/*      */       case 24:
/* 2172 */         return (XmlObject)new XmlIntRestriction(paramSchemaType, bool);
/*      */       case 25:
/* 2174 */         return (XmlObject)new XmlShortImpl(paramSchemaType, bool);
/*      */       case 26:
/* 2176 */         return (XmlObject)new XmlByteImpl(paramSchemaType, bool);
/*      */       case 27:
/* 2178 */         return (XmlObject)new XmlNonPositiveIntegerImpl(paramSchemaType, bool);
/*      */       case 28:
/* 2180 */         return (XmlObject)new XmlNegativeIntegerImpl(paramSchemaType, bool);
/*      */       case 29:
/* 2182 */         return (XmlObject)new XmlNonNegativeIntegerImpl(paramSchemaType, bool);
/*      */       case 30:
/* 2184 */         return (XmlObject)new XmlPositiveIntegerImpl(paramSchemaType, bool);
/*      */       case 31:
/* 2186 */         return (XmlObject)new XmlUnsignedLongImpl(paramSchemaType, bool);
/*      */       case 32:
/* 2188 */         return (XmlObject)new XmlUnsignedIntImpl(paramSchemaType, bool);
/*      */       case 33:
/* 2190 */         return (XmlObject)new XmlUnsignedShortImpl(paramSchemaType, bool);
/*      */       case 34:
/* 2192 */         return (XmlObject)new XmlUnsignedByteImpl(paramSchemaType, bool);
/*      */       case 35:
/* 2194 */         return (XmlObject)new XmlNormalizedStringImpl(paramSchemaType, bool);
/*      */       case 36:
/* 2196 */         return (XmlObject)new XmlTokenImpl(paramSchemaType, bool);
/*      */       case 37:
/* 2198 */         return (XmlObject)new XmlNameImpl(paramSchemaType, bool);
/*      */       case 38:
/* 2200 */         return (XmlObject)new XmlNCNameImpl(paramSchemaType, bool);
/*      */       case 39:
/* 2202 */         return (XmlObject)new XmlLanguageImpl(paramSchemaType, bool);
/*      */       case 40:
/* 2204 */         return (XmlObject)new XmlIdImpl(paramSchemaType, bool);
/*      */       case 41:
/* 2206 */         return (XmlObject)new XmlIdRefImpl(paramSchemaType, bool);
/*      */       case 42:
/* 2208 */         return (XmlObject)new XmlIdRefsImpl(paramSchemaType, bool);
/*      */       case 43:
/* 2210 */         return (XmlObject)new XmlEntityImpl(paramSchemaType, bool);
/*      */       case 44:
/* 2212 */         return (XmlObject)new XmlEntitiesImpl(paramSchemaType, bool);
/*      */       case 45:
/* 2214 */         return (XmlObject)new XmlNmTokenImpl(paramSchemaType, bool);
/*      */       case 46:
/* 2216 */         return (XmlObject)new XmlNmTokensImpl(paramSchemaType, bool);
/*      */     } 
/* 2218 */     throw new IllegalStateException("Unrecognized builtin type: " + getBuiltinTypeCode());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaType getCommonBaseType(SchemaType paramSchemaType) {
/* 2225 */     if (this == BuiltinSchemaTypeSystem.ST_ANY_TYPE || paramSchemaType == null || paramSchemaType.isNoType()) {
/* 2226 */       return this;
/*      */     }
/*      */     
/* 2229 */     if (paramSchemaType == BuiltinSchemaTypeSystem.ST_ANY_TYPE || isNoType()) {
/* 2230 */       return paramSchemaType;
/*      */     }
/*      */     
/* 2233 */     SchemaTypeImpl schemaTypeImpl1 = (SchemaTypeImpl)paramSchemaType;
/* 2234 */     while (schemaTypeImpl1.getBaseDepth() > getBaseDepth())
/* 2235 */       schemaTypeImpl1 = (SchemaTypeImpl)schemaTypeImpl1.getBaseType(); 
/* 2236 */     SchemaTypeImpl schemaTypeImpl2 = this;
/* 2237 */     while (schemaTypeImpl2.getBaseDepth() > schemaTypeImpl1.getBaseDepth()) {
/* 2238 */       schemaTypeImpl2 = (SchemaTypeImpl)schemaTypeImpl2.getBaseType();
/*      */     }
/*      */     
/* 2241 */     while (!schemaTypeImpl1.equals(schemaTypeImpl2)) {
/*      */       
/* 2243 */       schemaTypeImpl1 = (SchemaTypeImpl)schemaTypeImpl1.getBaseType();
/* 2244 */       schemaTypeImpl2 = (SchemaTypeImpl)schemaTypeImpl2.getBaseType();
/* 2245 */       assert schemaTypeImpl1 != null && schemaTypeImpl2 != null;
/*      */     } 
/* 2247 */     return schemaTypeImpl1;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isAssignableFrom(SchemaType paramSchemaType) {
/* 2252 */     if (paramSchemaType == null || paramSchemaType.isNoType()) {
/* 2253 */       return true;
/*      */     }
/* 2255 */     if (isNoType()) {
/* 2256 */       return false;
/*      */     }
/* 2258 */     if (getSimpleVariety() == 2) {
/*      */       
/* 2260 */       SchemaType[] arrayOfSchemaType = getUnionMemberTypes();
/* 2261 */       for (byte b1 = 0; b1 < arrayOfSchemaType.length; b1++) {
/* 2262 */         if (arrayOfSchemaType[b1].isAssignableFrom(paramSchemaType))
/* 2263 */           return true; 
/*      */       } 
/*      */     } 
/* 2266 */     int i = ((SchemaTypeImpl)paramSchemaType).getBaseDepth() - getBaseDepth();
/* 2267 */     if (i < 0)
/* 2268 */       return false; 
/* 2269 */     while (i > 0) {
/*      */       
/* 2271 */       paramSchemaType = paramSchemaType.getBaseType();
/* 2272 */       i--;
/*      */     } 
/* 2274 */     return paramSchemaType.equals(this);
/*      */   }
/*      */ 
/*      */   
/*      */   public String toString() {
/*      */     String str;
/* 2280 */     if (getName() != null) {
/* 2281 */       return "T=" + QNameHelper.pretty(getName());
/*      */     }
/* 2283 */     if (isDocumentType()) {
/* 2284 */       return "D=" + QNameHelper.pretty(getDocumentElementName());
/*      */     }
/* 2286 */     if (isAttributeType()) {
/* 2287 */       return "R=" + QNameHelper.pretty(getAttributeTypeAttributeName());
/*      */     }
/*      */ 
/*      */     
/* 2291 */     if (getContainerField() != null) {
/*      */       
/* 2293 */       str = ((getContainerField().getName().getNamespaceURI().length() > 0) ? (getContainerField().isAttribute() ? "Q=" : "E=") : (getContainerField().isAttribute() ? "A=" : "U=")) + getContainerField().getName().dT();
/*      */ 
/*      */ 
/*      */       
/* 2297 */       if (getOuterType() == null)
/* 2298 */         return str + "@" + getContainerField().getName().getNamespaceURI(); 
/*      */     } else {
/* 2300 */       if (isNoType())
/* 2301 */         return "N="; 
/* 2302 */       if (getOuterType() == null)
/* 2303 */         return "noouter"; 
/* 2304 */       if (getOuterType().getBaseType() == this) {
/* 2305 */         str = "B=";
/* 2306 */       } else if (getOuterType().getContentBasedOnType() == this) {
/* 2307 */         str = "S=";
/* 2308 */       } else if (getOuterType().getSimpleVariety() == 3) {
/* 2309 */         str = "I=";
/* 2310 */       } else if (getOuterType().getSimpleVariety() == 2) {
/* 2311 */         str = "M=" + getAnonymousUnionMemberOrdinal();
/*      */       } else {
/* 2313 */         str = "strange=";
/*      */       } 
/* 2315 */     }  return str + "|" + getOuterType().toString();
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
/*      */   public void setParseContext(XmlObject paramXmlObject, String paramString1, boolean paramBoolean1, String paramString2, String paramString3, boolean paramBoolean2) {
/* 2327 */     this._parseObject = paramXmlObject;
/* 2328 */     this._parseTNS = paramString1;
/* 2329 */     this._chameleon = paramBoolean1;
/* 2330 */     this._elemFormDefault = paramString2;
/* 2331 */     this._attFormDefault = paramString3;
/* 2332 */     this._redefinition = paramBoolean2;
/*      */   }
/*      */   
/*      */   public XmlObject getParseObject() {
/* 2336 */     return this._parseObject;
/*      */   }
/*      */   public String getTargetNamespace() {
/* 2339 */     return this._parseTNS;
/*      */   }
/*      */   public boolean isChameleon() {
/* 2342 */     return this._chameleon;
/*      */   }
/*      */   public String getElemFormDefault() {
/* 2345 */     return this._elemFormDefault;
/*      */   }
/*      */   public String getAttFormDefault() {
/* 2348 */     return this._attFormDefault;
/*      */   }
/*      */   public String getChameleonNamespace() {
/* 2351 */     return this._chameleon ? this._parseTNS : null;
/*      */   }
/*      */   public boolean isRedefinition() {
/* 2354 */     return this._redefinition;
/*      */   }
/* 2356 */   SchemaTypeImpl(SchemaContainer paramSchemaContainer) { this._selfref = new SchemaType.Ref(this); this._container = paramSchemaContainer; } SchemaTypeImpl(SchemaContainer paramSchemaContainer, boolean paramBoolean) { this._selfref = new SchemaType.Ref(this); this._container = paramSchemaContainer;
/*      */     this._unloaded = paramBoolean;
/*      */     if (paramBoolean)
/* 2359 */       finishQuick();  } public SchemaType.Ref getRef() { return this._selfref; }
/*      */   
/*      */   public SchemaComponent.Ref getComponentRef() {
/* 2362 */     return (SchemaComponent.Ref)getRef();
/*      */   }
/*      */ 
/*      */   
/*      */   private static class SequencerImpl
/*      */     implements SchemaTypeElementSequencer
/*      */   {
/*      */     private SchemaTypeVisitorImpl _visitor;
/*      */ 
/*      */     
/*      */     private SequencerImpl(SchemaTypeVisitorImpl param1SchemaTypeVisitorImpl) {
/* 2373 */       this._visitor = param1SchemaTypeVisitorImpl;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean next(b param1b) {
/* 2378 */       if (this._visitor == null) {
/* 2379 */         return false;
/*      */       }
/* 2381 */       return this._visitor.visit(param1b);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean peek(b param1b) {
/* 2386 */       if (this._visitor == null) {
/* 2387 */         return false;
/*      */       }
/* 2389 */       return this._visitor.testValid(param1b);
/*      */     }
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
/*      */   public QNameSet qnameSetForWildcardElements() {
/* 2408 */     SchemaParticle schemaParticle = getContentModel();
/* 2409 */     QNameSetBuilder qNameSetBuilder1 = new QNameSetBuilder();
/* 2410 */     computeWildcardSet(schemaParticle, qNameSetBuilder1);
/*      */     
/* 2412 */     QNameSetBuilder qNameSetBuilder2 = new QNameSetBuilder((QNameSetSpecification)qNameSetBuilder1);
/* 2413 */     SchemaProperty[] arrayOfSchemaProperty = getElementProperties();
/*      */     
/* 2415 */     for (byte b1 = 0; b1 < arrayOfSchemaProperty.length; b1++) {
/*      */       
/* 2417 */       SchemaProperty schemaProperty = arrayOfSchemaProperty[b1];
/* 2418 */       qNameSetBuilder2.remove(schemaProperty.getName());
/*      */     } 
/*      */     
/* 2421 */     return qNameSetBuilder2.toQNameSet();
/*      */   }
/*      */ 
/*      */   
/*      */   private static void computeWildcardSet(SchemaParticle paramSchemaParticle, QNameSetBuilder paramQNameSetBuilder) {
/* 2426 */     if (paramSchemaParticle.getParticleType() == 5) {
/*      */       
/* 2428 */       QNameSet qNameSet = paramSchemaParticle.getWildcardSet();
/* 2429 */       paramQNameSetBuilder.addAll((QNameSetSpecification)qNameSet);
/*      */       return;
/*      */     } 
/* 2432 */     for (byte b1 = 0; b1 < paramSchemaParticle.countOfParticleChild(); b1++) {
/*      */       
/* 2434 */       SchemaParticle schemaParticle = paramSchemaParticle.getParticleChild(b1);
/* 2435 */       computeWildcardSet(schemaParticle, paramQNameSetBuilder);
/*      */     } 
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
/*      */   public QNameSet qnameSetForWildcardAttributes() {
/* 2453 */     SchemaAttributeModel schemaAttributeModel = getAttributeModel();
/* 2454 */     QNameSet qNameSet = schemaAttributeModel.getWildcardSet();
/*      */     
/* 2456 */     if (qNameSet == null) {
/* 2457 */       return QNameSet.EMPTY;
/*      */     }
/* 2459 */     QNameSetBuilder qNameSetBuilder = new QNameSetBuilder((QNameSetSpecification)qNameSet);
/*      */     
/* 2461 */     SchemaProperty[] arrayOfSchemaProperty = getAttributeProperties();
/*      */     
/* 2463 */     for (byte b1 = 0; b1 < arrayOfSchemaProperty.length; b1++) {
/*      */       
/* 2465 */       SchemaProperty schemaProperty = arrayOfSchemaProperty[b1];
/* 2466 */       qNameSetBuilder.remove(schemaProperty.getName());
/*      */     } 
/*      */     
/* 2469 */     return qNameSetBuilder.toQNameSet();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\SchemaTypeImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */