/*      */ package org.apache.xmlbeans.impl.validator;
/*      */ 
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.xmlbeans.GDate;
/*      */ import org.apache.xmlbeans.GDateSpecification;
/*      */ import org.apache.xmlbeans.GDuration;
/*      */ import org.apache.xmlbeans.GDurationSpecification;
/*      */ import org.apache.xmlbeans.QNameSet;
/*      */ import org.apache.xmlbeans.SchemaAttributeModel;
/*      */ import org.apache.xmlbeans.SchemaField;
/*      */ import org.apache.xmlbeans.SchemaGlobalAttribute;
/*      */ import org.apache.xmlbeans.SchemaGlobalElement;
/*      */ import org.apache.xmlbeans.SchemaLocalAttribute;
/*      */ import org.apache.xmlbeans.SchemaLocalElement;
/*      */ import org.apache.xmlbeans.SchemaParticle;
/*      */ import org.apache.xmlbeans.SchemaProperty;
/*      */ import org.apache.xmlbeans.SchemaType;
/*      */ import org.apache.xmlbeans.SchemaTypeLoader;
/*      */ import org.apache.xmlbeans.SimpleValue;
/*      */ import org.apache.xmlbeans.XmlAnySimpleType;
/*      */ import org.apache.xmlbeans.XmlCursor;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.XmlOptions;
/*      */ import org.apache.xmlbeans.XmlQName;
/*      */ import org.apache.xmlbeans.XmlString;
/*      */ import org.apache.xmlbeans.XmlValidationError;
/*      */ import org.apache.xmlbeans.impl.common.IdentityConstraint;
/*      */ import org.apache.xmlbeans.impl.common.InvalidLexicalValueException;
/*      */ import org.apache.xmlbeans.impl.common.PrefixResolver;
/*      */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*      */ import org.apache.xmlbeans.impl.common.ValidationContext;
/*      */ import org.apache.xmlbeans.impl.common.ValidatorListener;
/*      */ import org.apache.xmlbeans.impl.common.XmlWhitespace;
/*      */ import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;
/*      */ import org.apache.xmlbeans.impl.schema.SchemaTypeVisitorImpl;
/*      */ import org.apache.xmlbeans.impl.util.XsTypeConverter;
/*      */ import org.apache.xmlbeans.impl.values.JavaBase64HolderEx;
/*      */ import org.apache.xmlbeans.impl.values.JavaBooleanHolder;
/*      */ import org.apache.xmlbeans.impl.values.JavaBooleanHolderEx;
/*      */ import org.apache.xmlbeans.impl.values.JavaDecimalHolderEx;
/*      */ import org.apache.xmlbeans.impl.values.JavaDoubleHolderEx;
/*      */ import org.apache.xmlbeans.impl.values.JavaFloatHolderEx;
/*      */ import org.apache.xmlbeans.impl.values.JavaHexBinaryHolderEx;
/*      */ import org.apache.xmlbeans.impl.values.JavaNotationHolderEx;
/*      */ import org.apache.xmlbeans.impl.values.JavaQNameHolderEx;
/*      */ import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
/*      */ import org.apache.xmlbeans.impl.values.JavaUriHolderEx;
/*      */ import org.apache.xmlbeans.impl.values.NamespaceContext;
/*      */ import org.apache.xmlbeans.impl.values.XmlDateImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlDurationImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlListImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlQNameImpl;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class Validator
/*      */   implements ValidatorListener
/*      */ {
/*      */   private LinkedList _visitorPool;
/*      */   private boolean _invalid;
/*      */   private SchemaType _rootType;
/*      */   private SchemaField _rootField;
/*      */   private SchemaTypeLoader _globalTypes;
/*      */   private State _stateStack;
/*      */   private int _errorState;
/*      */   private Collection _errorListener;
/*      */   private boolean _treatLaxAsSkip;
/*      */   private boolean _strict;
/*      */   private ValidatorVC _vc;
/*      */   private int _suspendErrors;
/*      */   private IdentityConstraint _constraintEngine;
/*      */   private int _eatContent;
/*      */   private SchemaLocalElement _localElement;
/*      */   private SchemaParticle _wildcardElement;
/*      */   private SchemaLocalAttribute _localAttribute;
/*      */   private SchemaAttributeModel _wildcardAttribute;
/*      */   private SchemaType _unionType;
/*      */   private String _stringValue;
/*      */   private BigDecimal _decimalValue;
/*      */   private boolean _booleanValue;
/*      */   private float _floatValue;
/*      */   private double _doubleValue;
/*      */   private b _qnameValue;
/*      */   private GDate _gdateValue;
/*      */   private GDuration _gdurationValue;
/*      */   private byte[] _byteArrayValue;
/*      */   private List _listValue;
/*      */   private List _listTypes;
/*      */   static final boolean $assertionsDisabled;
/*      */   
/*      */   private class ValidatorVC
/*      */     implements ValidationContext
/*      */   {
/*      */     ValidatorListener.Event _event;
/*      */     private final Validator this$0;
/*      */     
/*      */     private ValidatorVC() {}
/*      */     
/*      */     public void invalid(String param1String) {
/*      */       Validator.this.emitError(this._event, param1String, null, null, null, 1001, null);
/*      */     }
/*      */     
/*      */     public void invalid(String param1String, Object[] param1ArrayOfObject) {
/*      */       Validator.this.emitError(this._event, param1String, param1ArrayOfObject, null, null, null, 1001, null);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean isValid() {
/*      */     return (!this._invalid && this._constraintEngine.isValid());
/*      */   }
/*      */   
/*      */   private void emitError(ValidatorListener.Event paramEvent, String paramString, b paramb, SchemaType paramSchemaType1, List paramList, int paramInt, SchemaType paramSchemaType2) {
/*      */     emitError(paramEvent, paramString, null, null, 0, null, paramb, paramSchemaType1, paramList, paramInt, paramSchemaType2);
/*      */   }
/*      */   
/*      */   private void emitError(ValidatorListener.Event paramEvent, String paramString, Object[] paramArrayOfObject, b paramb, SchemaType paramSchemaType1, List paramList, int paramInt, SchemaType paramSchemaType2) {
/*      */     emitError(paramEvent, null, paramString, paramArrayOfObject, 0, null, paramb, paramSchemaType1, paramList, paramInt, paramSchemaType2);
/*      */   }
/*      */   
/*      */   private void emitError(ValidatorListener.Event paramEvent, String paramString1, String paramString2, Object[] paramArrayOfObject, int paramInt1, b paramb1, b paramb2, SchemaType paramSchemaType1, List paramList, int paramInt2, SchemaType paramSchemaType2) {
/*      */     this._errorState++;
/*      */     if (this._suspendErrors == 0) {
/*      */       if (paramInt1 == 0)
/*      */         this._invalid = true; 
/*      */       if (this._errorListener != null) {
/*      */         XmlValidationError xmlValidationError;
/*      */         assert paramEvent != null;
/*      */         XmlCursor xmlCursor = paramEvent.getLocationAsCursor();
/*      */         if (xmlCursor != null) {
/*      */           xmlValidationError = XmlValidationError.forCursorWithDetails(paramString1, paramString2, paramArrayOfObject, paramInt1, xmlCursor, paramb1, paramb2, paramSchemaType1, paramList, paramInt2, paramSchemaType2);
/*      */         } else {
/*      */           xmlValidationError = XmlValidationError.forLocationWithDetails(paramString1, paramString2, paramArrayOfObject, paramInt1, paramEvent.getLocation(), paramb1, paramb2, paramSchemaType1, paramList, paramInt2, paramSchemaType2);
/*      */         } 
/*      */         this._errorListener.add(xmlValidationError);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void emitFieldError(ValidatorListener.Event paramEvent, String paramString, Object[] paramArrayOfObject, b paramb, SchemaType paramSchemaType1, List paramList, int paramInt, SchemaType paramSchemaType2) {
/*      */     emitFieldError(paramEvent, null, paramString, paramArrayOfObject, 0, paramb, paramSchemaType1, paramList, paramInt, paramSchemaType2);
/*      */   }
/*      */   
/*      */   private void emitFieldError(ValidatorListener.Event paramEvent, String paramString1, String paramString2, Object[] paramArrayOfObject, int paramInt1, b paramb, SchemaType paramSchemaType1, List paramList, int paramInt2, SchemaType paramSchemaType2) {
/*      */     b b1 = null;
/*      */     if (this._stateStack != null && this._stateStack._field != null)
/*      */       b1 = this._stateStack._field.getName(); 
/*      */     emitError(paramEvent, paramString1, paramString2, paramArrayOfObject, paramInt1, b1, paramb, paramSchemaType1, paramList, paramInt2, paramSchemaType2);
/*      */   }
/*      */   
/*      */   public void nextEvent(int paramInt, ValidatorListener.Event paramEvent) {
/*      */     resetValues();
/*      */     if (this._eatContent > 0) {
/*      */       switch (paramInt) {
/*      */         case 2:
/*      */           this._eatContent--;
/*      */           break;
/*      */         case 1:
/*      */           this._eatContent++;
/*      */           break;
/*      */       } 
/*      */     } else {
/*      */       assert paramInt == 1 || paramInt == 4 || paramInt == 2 || paramInt == 3 || paramInt == 5;
/*      */       switch (paramInt) {
/*      */         case 1:
/*      */           beginEvent(paramEvent);
/*      */           break;
/*      */         case 4:
/*      */           attrEvent(paramEvent);
/*      */           break;
/*      */         case 5:
/*      */           endAttrsEvent(paramEvent);
/*      */           break;
/*      */         case 3:
/*      */           textEvent(paramEvent);
/*      */           break;
/*      */         case 2:
/*      */           endEvent(paramEvent);
/*      */           break;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void beginEvent(ValidatorListener.Event paramEvent) {
/*      */     this._localElement = null;
/*      */     this._wildcardElement = null;
/*      */     State state = topState();
/*      */     SchemaType schemaType1 = null;
/*      */     SchemaField schemaField = null;
/*      */     if (state == null) {
/*      */       schemaType1 = this._rootType;
/*      */       schemaField = this._rootField;
/*      */     } else {
/*      */       b b1 = paramEvent.getName();
/*      */       assert b1 != null;
/*      */       state._isEmpty = false;
/*      */       if (state._isNil) {
/*      */         emitFieldError(paramEvent, "cvc-elt.3.2.1", null, state._field.getName(), state._type, null, 4, state._type);
/*      */         this._eatContent = 1;
/*      */         return;
/*      */       } 
/*      */       if (!state._isNil && state._field != null && state._field.isFixed())
/*      */         emitFieldError(paramEvent, "cvc-elt.5.2.2.1", new Object[] { QNameHelper.pretty(state._field.getName()) }, state._field.getName(), state._type, null, 2, state._type); 
/*      */       if (!state.visit(b1)) {
/*      */         findDetailedErrorBegin(paramEvent, state, b1);
/*      */         this._eatContent = 1;
/*      */         return;
/*      */       } 
/*      */       SchemaParticle schemaParticle = state.currentParticle();
/*      */       this._wildcardElement = schemaParticle;
/*      */       if (schemaParticle.getParticleType() == 5) {
/*      */         QNameSet qNameSet = schemaParticle.getWildcardSet();
/*      */         if (!qNameSet.contains(b1)) {
/*      */           emitFieldError(paramEvent, "cvc-particle.1.3", new Object[] { QNameHelper.pretty(b1) }, b1, null, null, 2, state._type);
/*      */           this._eatContent = 1;
/*      */           return;
/*      */         } 
/*      */         int i = schemaParticle.getWildcardProcess();
/*      */         if (i == 3 || (i == 2 && this._treatLaxAsSkip)) {
/*      */           this._eatContent = 1;
/*      */           return;
/*      */         } 
/*      */         this._localElement = (SchemaLocalElement)this._globalTypes.findElement(b1);
/*      */         SchemaLocalElement schemaLocalElement = this._localElement;
/*      */         if (schemaLocalElement == null) {
/*      */           if (i == 1)
/*      */             emitFieldError(paramEvent, "cvc-assess-elt.1.1.1.3.2", new Object[] { QNameHelper.pretty(b1) }, b1, state._type, null, 2, state._type); 
/*      */           this._eatContent = 1;
/*      */           return;
/*      */         } 
/*      */       } else {
/*      */         assert schemaParticle.getParticleType() == 4;
/*      */         if (!schemaParticle.getName().equals(b1)) {
/*      */           if (((SchemaLocalElement)schemaParticle).blockSubstitution()) {
/*      */             emitFieldError(paramEvent, "cvc-particle.2.3.3a", new Object[] { QNameHelper.pretty(b1) }, b1, state._type, null, 2, state._type);
/*      */             this._eatContent = 1;
/*      */             return;
/*      */           } 
/*      */           SchemaGlobalElement schemaGlobalElement = this._globalTypes.findElement(b1);
/*      */           assert schemaGlobalElement != null;
/*      */           if (schemaGlobalElement != null) {
/*      */             SchemaGlobalElement schemaGlobalElement1 = schemaGlobalElement;
/*      */             this._localElement = (SchemaLocalElement)schemaGlobalElement;
/*      */           } 
/*      */         } else {
/*      */           schemaField = (SchemaField)schemaParticle;
/*      */         } 
/*      */       } 
/*      */       schemaType1 = schemaField.getType();
/*      */     } 
/*      */     assert schemaType1 != null;
/*      */     if (schemaType1.isNoType()) {
/*      */       emitFieldError(paramEvent, "cvc-elt.1", null, paramEvent.getName(), null, null, 3, null);
/*      */       this._eatContent = 1;
/*      */     } 
/*      */     SchemaType schemaType2 = null;
/*      */     String str1 = paramEvent.getXsiType();
/*      */     if (str1 != null) {
/*      */       int i = this._errorState;
/*      */       this._suspendErrors++;
/*      */       try {
/*      */         this._vc._event = null;
/*      */         schemaType2 = this._globalTypes.findType(XmlQNameImpl.validateLexical(str1, this._vc, (PrefixResolver)paramEvent));
/*      */       } catch (Throwable throwable) {
/*      */         this._errorState++;
/*      */       } finally {
/*      */         this._suspendErrors--;
/*      */       } 
/*      */       if (i != this._errorState) {
/*      */         emitFieldError(paramEvent, "cvc-elt.4.1", new Object[] { str1 }, paramEvent.getName(), schemaType2, null, 3, state._type);
/*      */         this._eatContent = 1;
/*      */         return;
/*      */       } 
/*      */       if (schemaType2 == null) {
/*      */         emitFieldError(paramEvent, "cvc-elt.4.2", new Object[] { str1 }, paramEvent.getName(), null, null, 3, null);
/*      */         this._eatContent = 1;
/*      */         return;
/*      */       } 
/*      */     } 
/*      */     if (schemaType2 != null && !schemaType2.equals(schemaType1)) {
/*      */       if (!schemaType1.isAssignableFrom(schemaType2)) {
/*      */         emitFieldError(paramEvent, "cvc-elt.4.3a", new Object[] { schemaType2, schemaType1 }, paramEvent.getName(), schemaType1, null, 3, (state == null) ? null : state._type);
/*      */         this._eatContent = 1;
/*      */         return;
/*      */       } 
/*      */       if (schemaType1.blockExtension())
/*      */         for (SchemaType schemaType = schemaType2; !schemaType.equals(schemaType1); schemaType = schemaType.getBaseType()) {
/*      */           if (schemaType.getDerivationType() == 2) {
/*      */             emitFieldError(paramEvent, "cvc-elt.4.3b", new Object[] { schemaType2, schemaType1 }, paramEvent.getName(), schemaType1, null, 3, (state == null) ? null : state._type);
/*      */             this._eatContent = 1;
/*      */             return;
/*      */           } 
/*      */         }  
/*      */       if (schemaType1.blockRestriction())
/*      */         for (SchemaType schemaType = schemaType2; !schemaType.equals(schemaType1); schemaType = schemaType.getBaseType()) {
/*      */           if (schemaType.getDerivationType() == 1) {
/*      */             emitFieldError(paramEvent, "cvc-elt.4.3c", new Object[] { schemaType2, schemaType1 }, paramEvent.getName(), schemaType1, null, 3, (state == null) ? null : state._type);
/*      */             this._eatContent = 1;
/*      */             return;
/*      */           } 
/*      */         }  
/*      */       if (schemaField instanceof SchemaLocalElement) {
/*      */         SchemaLocalElement schemaLocalElement = (SchemaLocalElement)schemaField;
/*      */         this._localElement = schemaLocalElement;
/*      */         if (schemaLocalElement.blockExtension() || schemaLocalElement.blockRestriction())
/*      */           for (SchemaType schemaType = schemaType2; !schemaType.equals(schemaType1); schemaType = schemaType.getBaseType()) {
/*      */             if ((schemaType.getDerivationType() == 1 && schemaLocalElement.blockRestriction()) || (schemaType.getDerivationType() == 2 && schemaLocalElement.blockExtension())) {
/*      */               emitFieldError(paramEvent, "cvc-elt.4.3d", new Object[] { schemaType2, QNameHelper.pretty(schemaLocalElement.getName()) }, schemaLocalElement.getName(), null, null, 3, null);
/*      */               this._eatContent = 1;
/*      */               return;
/*      */             } 
/*      */           }  
/*      */       } 
/*      */       schemaType1 = schemaType2;
/*      */     } 
/*      */     if (schemaField instanceof SchemaLocalElement) {
/*      */       SchemaLocalElement schemaLocalElement = (SchemaLocalElement)schemaField;
/*      */       this._localElement = schemaLocalElement;
/*      */       if (schemaLocalElement.isAbstract()) {
/*      */         emitError(paramEvent, "cvc-elt.2", new Object[] { QNameHelper.pretty(schemaLocalElement.getName()) }, schemaLocalElement.getName(), null, null, 3, null);
/*      */         this._eatContent = 1;
/*      */         return;
/*      */       } 
/*      */     } 
/*      */     if (schemaType1 != null && schemaType1.isAbstract()) {
/*      */       emitError(paramEvent, "cvc-elt.2", new Object[] { schemaType1 }, paramEvent.getName(), schemaType1, null, 3, (state == null) ? null : state._type);
/*      */       this._eatContent = 1;
/*      */       return;
/*      */     } 
/*      */     boolean bool = false;
/*      */     boolean bool1 = false;
/*      */     String str2 = paramEvent.getXsiNil();
/*      */     if (str2 != null) {
/*      */       this._vc._event = paramEvent;
/*      */       bool = JavaBooleanHolder.validateLexical(str2, this._vc);
/*      */       bool1 = true;
/*      */     } 
/*      */     if (bool1 && (schemaField == null || !schemaField.isNillable())) {
/*      */       emitFieldError(paramEvent, "cvc-elt.3.1", null, (schemaField == null) ? null : schemaField.getName(), schemaType1, null, 3, (state == null) ? null : state._type);
/*      */       this._eatContent = 1;
/*      */       return;
/*      */     } 
/*      */     if (bool && schemaField != null && schemaField.isFixed())
/*      */       emitFieldError(paramEvent, "cvc-elt.3.2.2", null, (schemaField == null) ? null : schemaField.getName(), schemaType1, null, 3, (state == null) ? null : state._type); 
/*      */     newState(schemaType1, schemaField, bool);
/*      */     this._constraintEngine.element(paramEvent, schemaType1, (schemaField instanceof SchemaLocalElement) ? ((SchemaLocalElement)schemaField).getIdentityConstraints() : null);
/*      */   }
/*      */   
/*      */   public Validator(SchemaType paramSchemaType, SchemaField paramSchemaField, SchemaTypeLoader paramSchemaTypeLoader, XmlOptions paramXmlOptions, Collection paramCollection) {
/* 1105 */     this._visitorPool = new LinkedList(); paramXmlOptions = XmlOptions.maskNull(paramXmlOptions); this._errorListener = (Collection)paramXmlOptions.get("ERROR_LISTENER"); this._treatLaxAsSkip = paramXmlOptions.hasOption("VALIDATE_TREAT_LAX_AS_SKIP"); this._strict = paramXmlOptions.hasOption("VALIDATE_STRICT"); if (this._errorListener == null) this._errorListener = paramCollection;  this._constraintEngine = new IdentityConstraint(this._errorListener, paramSchemaType.isDocumentType()); this._globalTypes = paramSchemaTypeLoader; this._rootType = paramSchemaType; this._rootField = paramSchemaField; this._vc = new ValidatorVC();
/*      */   }
/*      */   private void attrEvent(ValidatorListener.Event paramEvent) { b b1 = paramEvent.getName(); State state = topState(); if (state._attrs == null) state._attrs = new HashSet();  if (state._attrs.contains(b1)) { emitFieldError(paramEvent, "uniqattspec", new Object[] { QNameHelper.pretty(b1) }, b1, null, null, 1000, state._type); return; }  state._attrs.add(b1); if (!state._canHaveAttrs) { emitFieldError(paramEvent, "cvc-complex-type.3.2.1", new Object[] { QNameHelper.pretty(b1) }, b1, null, null, 1000, state._type); return; }  SchemaLocalAttribute schemaLocalAttribute = (state._attrModel == null) ? null : state._attrModel.getAttribute(b1); if (schemaLocalAttribute != null) { this._localAttribute = schemaLocalAttribute; if (schemaLocalAttribute.getUse() == 1) { emitFieldError(paramEvent, "cvc-complex-type.prohibited-attribute", new Object[] { QNameHelper.pretty(b1) }, b1, null, null, 1000, state._type); return; }  String str1 = validateSimpleType(schemaLocalAttribute.getType(), (SchemaField)schemaLocalAttribute, paramEvent, false, false); this._constraintEngine.attr(paramEvent, b1, schemaLocalAttribute.getType(), str1); return; }  int i = state._attrModel.getWildcardProcess(); this._wildcardAttribute = state._attrModel; if (i == 0) { emitFieldError(paramEvent, "cvc-complex-type.3.2.1", new Object[] { QNameHelper.pretty(b1) }, b1, null, null, 1000, state._type); return; }  QNameSet qNameSet = state._attrModel.getWildcardSet(); if (!qNameSet.contains(b1)) { emitFieldError(paramEvent, "cvc-complex-type.3.2.2", new Object[] { QNameHelper.pretty(b1) }, b1, null, null, 1000, state._type); return; }  if (i == 3 || (i == 2 && this._treatLaxAsSkip)) return;  SchemaGlobalAttribute schemaGlobalAttribute = this._globalTypes.findAttribute(b1); this._localAttribute = (SchemaLocalAttribute)schemaGlobalAttribute; if (schemaGlobalAttribute == null) { if (i == 2) return;  assert i == 1; emitFieldError(paramEvent, "cvc-assess-attr.1.2", new Object[] { QNameHelper.pretty(b1) }, b1, null, null, 1000, state._type); return; }  String str = validateSimpleType(schemaGlobalAttribute.getType(), (SchemaField)schemaGlobalAttribute, paramEvent, false, false); this._constraintEngine.attr(paramEvent, b1, schemaGlobalAttribute.getType(), str); }
/*      */   private void endAttrsEvent(ValidatorListener.Event paramEvent) { State state = topState(); if (state._attrModel != null) { SchemaLocalAttribute[] arrayOfSchemaLocalAttribute = state._attrModel.getAttributes(); for (byte b1 = 0; b1 < arrayOfSchemaLocalAttribute.length; b1++) { SchemaLocalAttribute schemaLocalAttribute = arrayOfSchemaLocalAttribute[b1]; if (state._attrs == null || !state._attrs.contains(schemaLocalAttribute.getName())) if (schemaLocalAttribute.getUse() == 3) { emitFieldError(paramEvent, "cvc-complex-type.4", new Object[] { QNameHelper.pretty(schemaLocalAttribute.getName()) }, schemaLocalAttribute.getName(), null, null, 1000, state._type); } else if (schemaLocalAttribute.isDefault() || schemaLocalAttribute.isFixed()) { this._constraintEngine.attr(paramEvent, schemaLocalAttribute.getName(), schemaLocalAttribute.getType(), schemaLocalAttribute.getDefaultText()); }   }  }  }
/* 1109 */   private void endEvent(ValidatorListener.Event paramEvent) { this._localElement = null; this._wildcardElement = null; State state = topState(); if (!state._isNil) { if (!state.end()) findDetailedErrorEnd(paramEvent, state);  if (state._isEmpty) handleText(paramEvent, true, state._field);  }  popState(paramEvent); this._constraintEngine.endElement(paramEvent); } private void textEvent(ValidatorListener.Event paramEvent) { State state = topState(); if (state._isNil) { emitFieldError(paramEvent, "cvc-elt.3.2.1", null, state._field.getName(), state._type, null, 4, state._type); } else { handleText(paramEvent, false, state._field); }  state._isEmpty = false; } private void poolVisitor(SchemaTypeVisitorImpl paramSchemaTypeVisitorImpl) { this._visitorPool.add(paramSchemaTypeVisitorImpl); }
/*      */   private void handleText(ValidatorListener.Event paramEvent, boolean paramBoolean, SchemaField paramSchemaField) { State state = topState(); if (!state._sawText) if (state._hasSimpleContent) { String str = validateSimpleType(state._type, paramSchemaField, paramEvent, paramBoolean, true); this._constraintEngine.text(paramEvent, state._type, str, false); } else if (state._canHaveMixedContent) { String str = validateSimpleType(XmlString.type, paramSchemaField, paramEvent, paramBoolean, true); this._constraintEngine.text(paramEvent, XmlString.type, str, false); } else if (paramBoolean) { this._constraintEngine.text(paramEvent, state._type, null, true); } else { this._constraintEngine.text(paramEvent, state._type, "", false); }   if (!paramBoolean && !state._canHaveMixedContent && !paramEvent.textIsWhitespace() && !state._hasSimpleContent) if (paramSchemaField instanceof SchemaLocalElement) { SchemaLocalElement schemaLocalElement = (SchemaLocalElement)paramSchemaField; assert state._type.getContentType() == 1 || state._type.getContentType() == 3; String str = (state._type.getContentType() == 1) ? "cvc-complex-type.2.1" : "cvc-complex-type.2.3"; emitError(paramEvent, str, new Object[] { QNameHelper.pretty(schemaLocalElement.getName()) }, schemaLocalElement.getName(), paramSchemaField.getType(), null, 3, null); } else { emitError(paramEvent, "Can't have mixed content", paramEvent.getName(), state._type, null, 3, null); }   if (!paramBoolean)
/*      */       state._sawText = true;  }
/*      */   private void findDetailedErrorBegin(ValidatorListener.Event paramEvent, State paramState, b paramb) { ArrayList arrayList1 = new ArrayList(); ArrayList arrayList2 = new ArrayList(); SchemaProperty[] arrayOfSchemaProperty = paramState._type.getElementProperties(); for (byte b1 = 0; b1 < arrayOfSchemaProperty.length; b1++) { SchemaProperty schemaProperty = arrayOfSchemaProperty[b1]; if (paramState.test(schemaProperty.getName()))
/*      */         if (0 == BigInteger.ZERO.compareTo(schemaProperty.getMinOccurs())) { arrayList2.add(schemaProperty.getName()); } else { arrayList1.add(schemaProperty.getName()); }   }  ArrayList arrayList3 = (arrayList1.size() > 0) ? arrayList1 : arrayList2; if (arrayList3.size() > 0) { StringBuffer stringBuffer = new StringBuffer(); for (Iterator iterator = arrayList3.iterator(); iterator.hasNext(); ) { b b2 = iterator.next(); stringBuffer.append(QNameHelper.pretty(b2)); if (iterator.hasNext())
/* 1114 */           stringBuffer.append(" ");  }  emitFieldError(paramEvent, "cvc-complex-type.2.4a", new Object[] { new Integer(arrayList3.size()), stringBuffer.toString(), QNameHelper.pretty(paramb) }, paramb, null, arrayList3, 1, paramState._type); } else { emitFieldError(paramEvent, "cvc-complex-type.2.4b", new Object[] { QNameHelper.pretty(paramb) }, paramb, null, null, 1, paramState._type); }  } private SchemaTypeVisitorImpl initVisitor(SchemaParticle paramSchemaParticle) { if (this._visitorPool.isEmpty()) {
/* 1115 */       return new SchemaTypeVisitorImpl(paramSchemaParticle);
/*      */     }
/* 1117 */     SchemaTypeVisitorImpl schemaTypeVisitorImpl = this._visitorPool.removeLast();
/*      */ 
/*      */     
/* 1120 */     schemaTypeVisitorImpl.init(paramSchemaParticle);
/*      */     
/* 1122 */     return schemaTypeVisitorImpl; } private void findDetailedErrorEnd(ValidatorListener.Event paramEvent, State paramState) { SchemaProperty[] arrayOfSchemaProperty = paramState._type.getElementProperties(); ArrayList arrayList1 = new ArrayList(); ArrayList arrayList2 = new ArrayList(); for (byte b1 = 0; b1 < arrayOfSchemaProperty.length; b1++) { SchemaProperty schemaProperty = arrayOfSchemaProperty[b1]; if (paramState.test(schemaProperty.getName())) if (0 == BigInteger.ZERO.compareTo(schemaProperty.getMinOccurs())) { arrayList2.add(schemaProperty.getName()); } else { arrayList1.add(schemaProperty.getName()); }   }  ArrayList arrayList3 = (arrayList1.size() > 0) ? arrayList1 : arrayList2; if (arrayList3.size() > 0) { StringBuffer stringBuffer = new StringBuffer(); for (Iterator iterator = arrayList3.iterator(); iterator.hasNext(); ) { b b2 = iterator.next(); stringBuffer.append(QNameHelper.pretty(b2)); if (iterator.hasNext()) stringBuffer.append(" ");  }  emitFieldError(paramEvent, "cvc-complex-type.2.4c", new Object[] { new Integer(arrayList3.size()), stringBuffer.toString() }, null, null, arrayList3, 1, paramState._type); } else { emitFieldError(paramEvent, "cvc-complex-type.2.4d", null, null, null, null, 2, paramState._type); }  } private final class State {
/*      */     SchemaType _type; SchemaField _field; boolean _canHaveAttrs; boolean _canHaveMixedContent; boolean _hasSimpleContent; boolean _sawText; boolean _isEmpty; boolean _isNil; SchemaTypeVisitorImpl _visitor; boolean _canHaveElements; SchemaAttributeModel _attrModel; HashSet _attrs; State _next; static final boolean $assertionsDisabled; private final Validator this$0; private State() {} boolean visit(b param1b) { return (this._canHaveElements && this._visitor.visit(param1b)); } boolean test(b param1b) { return (this._canHaveElements && this._visitor.testValid(param1b)); }
/*      */     boolean end() { return (!this._canHaveElements || this._visitor.visit(null)); }
/*      */     SchemaParticle currentParticle() { assert this._visitor != null; return this._visitor.currentParticle(); } }
/*      */   private boolean derivedFromInteger(SchemaType paramSchemaType) { int i = paramSchemaType.getBuiltinTypeCode(); while (i == 0) { paramSchemaType = paramSchemaType.getBaseType(); i = paramSchemaType.getBuiltinTypeCode(); }  return (i >= 22 && i <= 34); }
/* 1127 */   private State topState() { return this._stateStack; } private void newState(SchemaType paramSchemaType, SchemaField paramSchemaField, boolean paramBoolean) { State state = new State(); state._type = paramSchemaType; state._field = paramSchemaField; state._isEmpty = true; state._isNil = paramBoolean; if (paramSchemaType.isSimpleType()) { state._hasSimpleContent = true; } else { SchemaParticle schemaParticle; state._canHaveAttrs = true; state._attrModel = paramSchemaType.getAttributeModel(); switch (paramSchemaType.getContentType()) { case 1:
/*      */           break;
/*      */         case 2:
/*      */           state._hasSimpleContent = true; break;
/*      */         case 4:
/*      */           state._canHaveMixedContent = true;
/*      */         case 3:
/*      */           schemaParticle = paramSchemaType.getContentModel(); state._canHaveElements = (schemaParticle != null); if (state._canHaveElements)
/*      */             state._visitor = initVisitor(schemaParticle);  break;
/*      */         default:
/*      */           throw new RuntimeException("Unexpected content type"); }  }
/*      */      pushState(state); }
/*      */   private void popState(ValidatorListener.Event paramEvent) { if (this._stateStack._visitor != null) { poolVisitor(this._stateStack._visitor); this._stateStack._visitor = null; }
/*      */      this._stateStack = this._stateStack._next; }
/*      */   private void pushState(State paramState) { paramState._next = this._stateStack; this._stateStack = paramState; }
/* 1142 */   private String validateSimpleType(SchemaType paramSchemaType, SchemaField paramSchemaField, ValidatorListener.Event paramEvent, boolean paramBoolean1, boolean paramBoolean2) { if (!paramSchemaType.isSimpleType() && paramSchemaType.getContentType() != 2) {
/*      */       assert false;
/*      */ 
/*      */ 
/*      */       
/* 1147 */       return null;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1154 */     if (paramSchemaType.isNoType()) {
/*      */       
/* 1156 */       emitError(paramEvent, paramSchemaField.isAttribute() ? "cvc-attribute.1" : "cvc-elt.1", null, paramSchemaField.getName(), paramSchemaType, null, 3, null);
/*      */ 
/*      */       
/* 1159 */       return null;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1165 */     String str = "";
/*      */     
/* 1167 */     if (!paramBoolean1) {
/*      */       
/* 1169 */       int i = paramSchemaType.getWhiteSpaceRule();
/* 1170 */       str = (i == 1) ? paramEvent.getText() : paramEvent.getText(i);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1175 */     if (str.length() == 0 && paramBoolean2 && paramSchemaField != null && (paramSchemaField.isDefault() || paramSchemaField.isFixed())) {
/*      */ 
/*      */       
/* 1178 */       if (XmlQName.type.isAssignableFrom(paramSchemaType)) {
/*      */ 
/*      */         
/* 1181 */         emitError(paramEvent, "Default QName values are unsupported for " + QNameHelper.readable(paramSchemaType) + " - ignoring.", null, null, 2, paramSchemaField.getName(), null, paramSchemaType, null, 3, null);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1186 */         return null;
/*      */       } 
/*      */       
/* 1189 */       String str1 = XmlWhitespace.collapse(paramSchemaField.getDefaultText(), paramSchemaType.getWhiteSpaceRule());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1195 */       return validateSimpleType(paramSchemaType, str1, paramEvent) ? str1 : null;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1202 */     if (!validateSimpleType(paramSchemaType, str, paramEvent)) {
/* 1203 */       return null;
/*      */     }
/* 1205 */     if (paramSchemaField != null && paramSchemaField.isFixed()) {
/*      */ 
/*      */       
/* 1208 */       String str1 = XmlWhitespace.collapse(paramSchemaField.getDefaultText(), paramSchemaType.getWhiteSpaceRule());
/*      */ 
/*      */ 
/*      */       
/* 1212 */       if (!validateSimpleType(paramSchemaType, str1, paramEvent)) {
/* 1213 */         return null;
/*      */       }
/* 1215 */       XmlAnySimpleType xmlAnySimpleType1 = paramSchemaType.newValue(str);
/* 1216 */       XmlAnySimpleType xmlAnySimpleType2 = paramSchemaType.newValue(str1);
/*      */       
/* 1218 */       if (!xmlAnySimpleType1.valueEquals((XmlObject)xmlAnySimpleType2)) {
/*      */ 
/*      */         
/* 1221 */         if (paramSchemaField.isAttribute()) {
/*      */ 
/*      */           
/* 1224 */           emitError(paramEvent, "cvc-attribute.4", new Object[] { str, str1, QNameHelper.pretty(paramEvent.getName()) }, null, paramSchemaField.getType(), null, 3, null);
/*      */         
/*      */         }
/*      */         else {
/*      */ 
/*      */           
/* 1230 */           String str2 = null;
/*      */ 
/*      */           
/* 1233 */           if (paramSchemaField.getType().getContentType() == 4) {
/* 1234 */             str2 = "cvc-elt.5.2.2.2.1";
/* 1235 */           } else if (paramSchemaType.isSimpleType()) {
/* 1236 */             str2 = "cvc-elt.5.2.2.2.2";
/*      */           } else {
/* 1238 */             assert false : "Element with fixed may not be EMPTY or ELEMENT_ONLY";
/*      */           } 
/* 1240 */           emitError(paramEvent, str2, new Object[] { str, str1 }, paramSchemaField.getName(), paramSchemaField.getType(), null, 3, null);
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/* 1245 */         return null;
/*      */       } 
/*      */     } 
/*      */     
/* 1249 */     return str; }
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean validateSimpleType(SchemaType paramSchemaType, String paramString, ValidatorListener.Event paramEvent)
/*      */   {
/* 1255 */     if (!paramSchemaType.isSimpleType() && paramSchemaType.getContentType() != 2) {
/*      */       assert false;
/*      */ 
/*      */       
/* 1259 */       throw new RuntimeException("Not a simple type");
/*      */     } 
/*      */     
/* 1262 */     int i = this._errorState;
/*      */     
/* 1264 */     switch (paramSchemaType.getSimpleVariety()) {
/*      */       case 1:
/* 1266 */         validateAtomicType(paramSchemaType, paramString, paramEvent); break;
/* 1267 */       case 2: validateUnionType(paramSchemaType, paramString, paramEvent); break;
/* 1268 */       case 3: validateListType(paramSchemaType, paramString, paramEvent); break;
/*      */       default:
/* 1270 */         throw new RuntimeException("Unexpected simple variety");
/*      */     } 
/*      */     
/* 1273 */     return (i == this._errorState); } private void validateAtomicType(SchemaType paramSchemaType, String paramString, ValidatorListener.Event paramEvent) {
/*      */     float f;
/*      */     double d;
/*      */     b b2;
/*      */     GDate gDate;
/*      */     GDuration gDuration;
/*      */     byte[] arrayOfByte;
/*      */     b b1;
/* 1281 */     assert paramSchemaType.getSimpleVariety() == 1;
/*      */ 
/*      */     
/* 1284 */     int i = this._errorState;
/* 1285 */     this._vc._event = paramEvent;
/*      */     
/* 1287 */     switch (paramSchemaType.getPrimitiveType().getBuiltinTypeCode()) {
/*      */ 
/*      */ 
/*      */       
/*      */       case 2:
/* 1292 */         this._stringValue = paramString;
/*      */         return;
/*      */ 
/*      */       
/*      */       case 12:
/* 1297 */         JavaStringEnumerationHolderEx.validateLexical(paramString, paramSchemaType, this._vc);
/* 1298 */         this._stringValue = paramString;
/*      */         return;
/*      */ 
/*      */       
/*      */       case 11:
/* 1303 */         JavaDecimalHolderEx.validateLexical(paramString, paramSchemaType, this._vc);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1308 */         if (derivedFromInteger(paramSchemaType) && paramString.lastIndexOf('.') >= 0)
/*      */         {
/* 1310 */           this._vc.invalid("integer", new Object[] { paramString });
/*      */         }
/*      */         
/* 1313 */         if (i == this._errorState) {
/*      */           
/* 1315 */           this._decimalValue = new BigDecimal(paramString);
/* 1316 */           JavaDecimalHolderEx.validateValue(this._decimalValue, paramSchemaType, this._vc);
/*      */         } 
/*      */         return;
/*      */ 
/*      */ 
/*      */       
/*      */       case 3:
/* 1323 */         this._booleanValue = JavaBooleanHolderEx.validateLexical(paramString, paramSchemaType, this._vc);
/*      */         return;
/*      */ 
/*      */       
/*      */       case 9:
/* 1328 */         f = JavaFloatHolderEx.validateLexical(paramString, paramSchemaType, this._vc);
/*      */ 
/*      */         
/* 1331 */         if (i == this._errorState) {
/* 1332 */           JavaFloatHolderEx.validateValue(f, paramSchemaType, this._vc);
/*      */         }
/* 1334 */         this._floatValue = f;
/*      */         return;
/*      */ 
/*      */       
/*      */       case 10:
/* 1339 */         d = JavaDoubleHolderEx.validateLexical(paramString, paramSchemaType, this._vc);
/*      */ 
/*      */         
/* 1342 */         if (i == this._errorState) {
/* 1343 */           JavaDoubleHolderEx.validateValue(d, paramSchemaType, this._vc);
/*      */         }
/* 1345 */         this._doubleValue = d;
/*      */         return;
/*      */ 
/*      */       
/*      */       case 7:
/* 1350 */         b2 = JavaQNameHolderEx.validateLexical(paramString, paramSchemaType, this._vc, (PrefixResolver)paramEvent);
/*      */ 
/*      */ 
/*      */         
/* 1354 */         if (i == this._errorState) {
/* 1355 */           JavaQNameHolderEx.validateValue(b2, paramSchemaType, this._vc);
/*      */         }
/* 1357 */         this._qnameValue = b2;
/*      */         return;
/*      */ 
/*      */       
/*      */       case 6:
/* 1362 */         JavaUriHolderEx.validateLexical(paramString, paramSchemaType, this._vc);
/*      */         
/* 1364 */         if (this._strict) {
/*      */           
/*      */           try {
/*      */             
/* 1368 */             XsTypeConverter.lexAnyURI(paramString);
/*      */           }
/* 1370 */           catch (InvalidLexicalValueException invalidLexicalValueException) {
/*      */             
/* 1372 */             this._vc.invalid("anyURI", new Object[] { paramString });
/*      */           } 
/*      */         }
/* 1375 */         this._stringValue = paramString;
/*      */         return;
/*      */ 
/*      */ 
/*      */       
/*      */       case 21:
/* 1381 */         if (this._strict && paramString.length() == 6 && paramString.charAt(4) == '-' && paramString.charAt(5) == '-')
/*      */         {
/* 1383 */           this._vc.invalid("date", new Object[] { paramString });
/*      */         }
/*      */ 
/*      */       
/*      */       case 14:
/*      */       case 15:
/*      */       case 16:
/*      */       case 17:
/*      */       case 18:
/*      */       case 19:
/*      */       case 20:
/* 1394 */         gDate = XmlDateImpl.validateLexical(paramString, paramSchemaType, this._vc);
/*      */         
/* 1396 */         if (gDate != null) {
/* 1397 */           XmlDateImpl.validateValue((GDateSpecification)gDate, paramSchemaType, this._vc);
/*      */         }
/* 1399 */         this._gdateValue = gDate;
/*      */         return;
/*      */ 
/*      */       
/*      */       case 13:
/* 1404 */         gDuration = XmlDurationImpl.validateLexical(paramString, paramSchemaType, this._vc);
/*      */         
/* 1406 */         if (gDuration != null) {
/* 1407 */           XmlDurationImpl.validateValue((GDurationSpecification)gDuration, paramSchemaType, this._vc);
/*      */         }
/* 1409 */         this._gdurationValue = gDuration;
/*      */         return;
/*      */ 
/*      */       
/*      */       case 4:
/* 1414 */         arrayOfByte = JavaBase64HolderEx.validateLexical(paramString, paramSchemaType, this._vc);
/*      */ 
/*      */         
/* 1417 */         if (arrayOfByte != null) {
/* 1418 */           JavaBase64HolderEx.validateValue(arrayOfByte, paramSchemaType, this._vc);
/*      */         }
/* 1420 */         this._byteArrayValue = arrayOfByte;
/*      */         return;
/*      */ 
/*      */       
/*      */       case 5:
/* 1425 */         arrayOfByte = JavaHexBinaryHolderEx.validateLexical(paramString, paramSchemaType, this._vc);
/*      */ 
/*      */         
/* 1428 */         if (arrayOfByte != null) {
/* 1429 */           JavaHexBinaryHolderEx.validateValue(arrayOfByte, paramSchemaType, this._vc);
/*      */         }
/* 1431 */         this._byteArrayValue = arrayOfByte;
/*      */         return;
/*      */ 
/*      */       
/*      */       case 8:
/* 1436 */         b1 = JavaNotationHolderEx.validateLexical(paramString, paramSchemaType, this._vc, (PrefixResolver)paramEvent);
/*      */ 
/*      */ 
/*      */         
/* 1440 */         if (i == this._errorState) {
/* 1441 */           JavaNotationHolderEx.validateValue(b1, paramSchemaType, this._vc);
/*      */         }
/* 1443 */         this._qnameValue = b1;
/*      */         return;
/*      */     } 
/*      */ 
/*      */     
/* 1448 */     throw new RuntimeException("Unexpected primitive type code");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void validateListType(SchemaType paramSchemaType, String paramString, ValidatorListener.Event paramEvent) {
/* 1455 */     int i = this._errorState;
/*      */     
/* 1457 */     if (!paramSchemaType.matchPatternFacet(paramString))
/*      */     {
/* 1459 */       emitError(paramEvent, "cvc-datatype-valid.1.1", new Object[] { "list", paramString, QNameHelper.readable(paramSchemaType) }, null, paramSchemaType, null, 2000, null);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1464 */     String[] arrayOfString = XmlListImpl.split_list(paramString);
/*      */ 
/*      */     
/*      */     XmlAnySimpleType xmlAnySimpleType;
/*      */     
/* 1469 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(0)) != null) {
/*      */       int j;
/* 1471 */       if ((j = ((SimpleValue)xmlAnySimpleType).getIntValue()) != arrayOfString.length)
/*      */       {
/*      */         
/* 1474 */         emitError(paramEvent, "cvc-length-valid.2", new Object[] { paramString, new Integer(arrayOfString.length), new Integer(j), QNameHelper.readable(paramSchemaType) }, null, paramSchemaType, null, 2000, null);
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1480 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(1)) != null) {
/*      */       int j;
/* 1482 */       if ((j = ((SimpleValue)xmlAnySimpleType).getIntValue()) > arrayOfString.length)
/*      */       {
/*      */         
/* 1485 */         emitError(paramEvent, "cvc-length-valid.2", new Object[] { paramString, new Integer(arrayOfString.length), new Integer(j), QNameHelper.readable(paramSchemaType) }, null, paramSchemaType, null, 2000, null);
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1491 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(2)) != null) {
/*      */       int j;
/* 1493 */       if ((j = ((SimpleValue)xmlAnySimpleType).getIntValue()) < arrayOfString.length)
/*      */       {
/*      */         
/* 1496 */         emitError(paramEvent, "cvc-length-valid.2", new Object[] { paramString, new Integer(arrayOfString.length), new Integer(j), QNameHelper.readable(paramSchemaType) }, null, paramSchemaType, null, 2000, null);
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1502 */     SchemaType schemaType = paramSchemaType.getListItemType();
/* 1503 */     this._listValue = new ArrayList();
/* 1504 */     this._listTypes = new ArrayList();
/*      */     
/* 1506 */     for (byte b1 = 0; b1 < arrayOfString.length; b1++) {
/*      */       
/* 1508 */       validateSimpleType(schemaType, arrayOfString[b1], paramEvent);
/*      */       
/* 1510 */       addToList(schemaType);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1516 */     if (i == this._errorState)
/*      */     {
/* 1518 */       if (paramSchemaType.getEnumerationValues() != null) {
/*      */ 
/*      */ 
/*      */         
/* 1522 */         NamespaceContext.push(new NamespaceContext((PrefixResolver)paramEvent));
/*      */ 
/*      */ 
/*      */         
/*      */         try {
/* 1527 */           XmlAnySimpleType xmlAnySimpleType1 = ((SchemaTypeImpl)paramSchemaType).newValidatingValue(paramString);
/*      */         }
/* 1529 */         catch (XmlValueOutOfRangeException xmlValueOutOfRangeException) {
/*      */ 
/*      */           
/* 1532 */           emitError(paramEvent, "cvc-enumeration-valid", new Object[] { "list", paramString, QNameHelper.readable(paramSchemaType) }, null, paramSchemaType, null, 2000, null);
/*      */         
/*      */         }
/*      */         finally {
/*      */ 
/*      */           
/* 1538 */           NamespaceContext.pop();
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void validateUnionType(SchemaType paramSchemaType, String paramString, ValidatorListener.Event paramEvent) {
/* 1550 */     if (!paramSchemaType.matchPatternFacet(paramString))
/*      */     {
/*      */       
/* 1553 */       emitError(paramEvent, "cvc-datatype-valid.1.1", new Object[] { "union", paramString, QNameHelper.readable(paramSchemaType) }, null, paramSchemaType, null, 3000, null);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1558 */     int i = 1;
/* 1559 */     String str = paramString;
/*      */     
/* 1561 */     SchemaType[] arrayOfSchemaType = paramSchemaType.getUnionMemberTypes();
/*      */     
/* 1563 */     int j = this._errorState;
/*      */     
/*      */     byte b1;
/* 1566 */     for (b1 = 0; b1 < arrayOfSchemaType.length; b1++) {
/*      */       
/* 1568 */       int k = arrayOfSchemaType[b1].getWhiteSpaceRule();
/*      */       
/* 1570 */       if (k == 0) {
/* 1571 */         k = 1;
/*      */       }
/* 1573 */       if (k != i) {
/*      */         
/* 1575 */         i = k;
/* 1576 */         str = XmlWhitespace.collapse(paramString, i);
/*      */       } 
/*      */       
/* 1579 */       int m = this._errorState;
/*      */       
/* 1581 */       this._suspendErrors++;
/*      */ 
/*      */       
/*      */       try {
/* 1585 */         validateSimpleType(arrayOfSchemaType[b1], str, paramEvent);
/*      */       }
/*      */       finally {
/*      */         
/* 1589 */         this._suspendErrors--;
/*      */       } 
/*      */       
/* 1592 */       if (m == this._errorState) {
/*      */         
/* 1594 */         this._unionType = arrayOfSchemaType[b1];
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/* 1599 */     this._errorState = j;
/*      */     
/* 1601 */     if (b1 >= arrayOfSchemaType.length) {
/*      */ 
/*      */       
/* 1604 */       emitError(paramEvent, "cvc-datatype-valid.1.2.3", new Object[] { paramString, QNameHelper.readable(paramSchemaType) }, null, paramSchemaType, null, 3000, null);
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */       
/* 1610 */       XmlAnySimpleType[] arrayOfXmlAnySimpleType = paramSchemaType.getEnumerationValues();
/*      */       
/* 1612 */       if (arrayOfXmlAnySimpleType != null) {
/*      */ 
/*      */ 
/*      */         
/* 1616 */         NamespaceContext.push(new NamespaceContext((PrefixResolver)paramEvent));
/*      */ 
/*      */         
/*      */         try {
/* 1620 */           XmlAnySimpleType xmlAnySimpleType = paramSchemaType.newValue(paramString);
/*      */           
/* 1622 */           for (b1 = 0; b1 < arrayOfXmlAnySimpleType.length; b1++) {
/*      */             
/* 1624 */             if (xmlAnySimpleType.valueEquals((XmlObject)arrayOfXmlAnySimpleType[b1])) {
/*      */               break;
/*      */             }
/*      */           } 
/* 1628 */           if (b1 >= arrayOfXmlAnySimpleType.length)
/*      */           {
/*      */             
/* 1631 */             emitError(paramEvent, "cvc-enumeration-valid", new Object[] { "union", paramString, QNameHelper.readable(paramSchemaType) }, null, paramSchemaType, null, 3000, null);
/*      */           
/*      */           }
/*      */         
/*      */         }
/* 1636 */         catch (XmlValueOutOfRangeException xmlValueOutOfRangeException) {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1641 */           emitError(paramEvent, "cvc-enumeration-valid", new Object[] { "union", paramString, QNameHelper.readable(paramSchemaType) }, null, paramSchemaType, null, 3000, null);
/*      */         
/*      */         }
/*      */         finally {
/*      */ 
/*      */           
/* 1647 */           NamespaceContext.pop();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void addToList(SchemaType paramSchemaType) {
/* 1655 */     if (paramSchemaType.getSimpleVariety() != 1 && paramSchemaType.getSimpleVariety() != 2) {
/*      */       return;
/*      */     }
/*      */     
/* 1659 */     if ((paramSchemaType.getUnionMemberTypes()).length > 0 && getUnionType() != null) {
/*      */       
/* 1661 */       paramSchemaType = getUnionType();
/* 1662 */       this._unionType = null;
/*      */     } 
/*      */     
/* 1665 */     this._listTypes.add(paramSchemaType);
/*      */     
/* 1667 */     if (paramSchemaType.getPrimitiveType() == null) {
/*      */ 
/*      */ 
/*      */       
/* 1671 */       this._listValue.add(null);
/*      */       
/*      */       return;
/*      */     } 
/* 1675 */     switch (paramSchemaType.getPrimitiveType().getBuiltinTypeCode()) {
/*      */ 
/*      */       
/*      */       case 2:
/* 1679 */         this._listValue.add(this._stringValue);
/*      */         return;
/*      */ 
/*      */       
/*      */       case 12:
/* 1684 */         this._listValue.add(this._stringValue);
/* 1685 */         this._stringValue = null;
/*      */         return;
/*      */ 
/*      */       
/*      */       case 11:
/* 1690 */         this._listValue.add(this._decimalValue);
/* 1691 */         this._decimalValue = null;
/*      */         return;
/*      */ 
/*      */       
/*      */       case 3:
/* 1696 */         this._listValue.add(this._booleanValue ? Boolean.TRUE : Boolean.FALSE);
/* 1697 */         this._booleanValue = false;
/*      */         return;
/*      */ 
/*      */       
/*      */       case 9:
/* 1702 */         this._listValue.add(new Float(this._floatValue));
/* 1703 */         this._floatValue = 0.0F;
/*      */         return;
/*      */ 
/*      */       
/*      */       case 10:
/* 1708 */         this._listValue.add(new Double(this._doubleValue));
/* 1709 */         this._doubleValue = 0.0D;
/*      */         return;
/*      */ 
/*      */       
/*      */       case 7:
/* 1714 */         this._listValue.add(this._qnameValue);
/* 1715 */         this._qnameValue = null;
/*      */         return;
/*      */ 
/*      */       
/*      */       case 6:
/* 1720 */         this._listTypes.add(this._stringValue);
/*      */         return;
/*      */ 
/*      */       
/*      */       case 14:
/*      */       case 15:
/*      */       case 16:
/*      */       case 17:
/*      */       case 18:
/*      */       case 19:
/*      */       case 20:
/*      */       case 21:
/* 1732 */         this._listValue.add(this._gdateValue);
/* 1733 */         this._gdateValue = null;
/*      */         return;
/*      */ 
/*      */       
/*      */       case 13:
/* 1738 */         this._listValue.add(this._gdurationValue);
/* 1739 */         this._gdurationValue = null;
/*      */         return;
/*      */ 
/*      */       
/*      */       case 4:
/* 1744 */         this._listValue.add(this._byteArrayValue);
/* 1745 */         this._byteArrayValue = null;
/*      */         return;
/*      */ 
/*      */       
/*      */       case 5:
/* 1750 */         this._listValue.add(this._byteArrayValue);
/* 1751 */         this._byteArrayValue = null;
/*      */         return;
/*      */ 
/*      */       
/*      */       case 8:
/* 1756 */         this._listValue.add(this._qnameValue);
/* 1757 */         this._qnameValue = null;
/*      */         return;
/*      */     } 
/*      */ 
/*      */     
/* 1762 */     throw new RuntimeException("Unexpected primitive type code");
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
/*      */   private void resetValues() {
/* 1805 */     this._localAttribute = null;
/* 1806 */     this._wildcardAttribute = null;
/* 1807 */     this._stringValue = null;
/* 1808 */     this._decimalValue = null;
/* 1809 */     this._booleanValue = false;
/* 1810 */     this._floatValue = 0.0F;
/* 1811 */     this._doubleValue = 0.0D;
/* 1812 */     this._qnameValue = null;
/* 1813 */     this._gdateValue = null;
/* 1814 */     this._gdurationValue = null;
/* 1815 */     this._byteArrayValue = null;
/* 1816 */     this._listValue = null;
/* 1817 */     this._listTypes = null;
/* 1818 */     this._unionType = null;
/* 1819 */     this._localAttribute = null;
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
/*      */   public SchemaType getCurrentElementSchemaType() {
/* 1833 */     State state = topState();
/* 1834 */     if (state != null) {
/* 1835 */       return state._type;
/*      */     }
/* 1837 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaLocalElement getCurrentElement() {
/* 1845 */     if (this._localElement != null) {
/* 1846 */       return this._localElement;
/*      */     }
/*      */ 
/*      */     
/* 1850 */     if (this._eatContent > 0) {
/* 1851 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 1855 */     if (this._stateStack != null && this._stateStack._field instanceof SchemaLocalElement) {
/* 1856 */       return (SchemaLocalElement)this._stateStack._field;
/*      */     }
/* 1858 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaParticle getCurrentWildcardElement() {
/* 1867 */     return this._wildcardElement;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaLocalAttribute getCurrentAttribute() {
/* 1876 */     return this._localAttribute;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaAttributeModel getCurrentWildcardAttribute() {
/* 1884 */     return this._wildcardAttribute;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getStringValue() {
/* 1889 */     return this._stringValue;
/*      */   }
/*      */ 
/*      */   
/*      */   public BigDecimal getDecimalValue() {
/* 1894 */     return this._decimalValue;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean getBooleanValue() {
/* 1899 */     return this._booleanValue;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getFloatValue() {
/* 1904 */     return this._floatValue;
/*      */   }
/*      */ 
/*      */   
/*      */   public double getDoubleValue() {
/* 1909 */     return this._doubleValue;
/*      */   }
/*      */ 
/*      */   
/*      */   public b getQNameValue() {
/* 1914 */     return this._qnameValue;
/*      */   }
/*      */ 
/*      */   
/*      */   public GDate getGDateValue() {
/* 1919 */     return this._gdateValue;
/*      */   }
/*      */ 
/*      */   
/*      */   public GDuration getGDurationValue() {
/* 1924 */     return this._gdurationValue;
/*      */   }
/*      */ 
/*      */   
/*      */   public byte[] getByteArrayValue() {
/* 1929 */     return this._byteArrayValue;
/*      */   }
/*      */ 
/*      */   
/*      */   public List getListValue() {
/* 1934 */     return this._listValue;
/*      */   }
/*      */ 
/*      */   
/*      */   public List getListTypes() {
/* 1939 */     return this._listTypes;
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaType getUnionType() {
/* 1944 */     return this._unionType;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\validator\Validator.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */