/*     */ package org.apache.xmlbeans.impl.common;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.xml.namespace.b;
/*     */ import javax.xml.stream.Location;
/*     */ import org.apache.xmlbeans.SchemaIdentityConstraint;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlError;
/*     */ import org.apache.xmlbeans.XmlID;
/*     */ import org.apache.xmlbeans.XmlIDREF;
/*     */ import org.apache.xmlbeans.XmlIDREFS;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IdentityConstraint
/*     */ {
/*     */   private ConstraintState _constraintStack;
/*     */   private ElementState _elementStack;
/*     */   private Collection _errorListener;
/*     */   private boolean _invalid;
/*     */   private boolean _trackIdrefs;
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   public IdentityConstraint(Collection paramCollection, boolean paramBoolean) {
/*  38 */     this._errorListener = paramCollection;
/*  39 */     this._trackIdrefs = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void element(ValidatorListener.Event paramEvent, SchemaType paramSchemaType, SchemaIdentityConstraint[] paramArrayOfSchemaIdentityConstraint) {
/*  45 */     newState();
/*     */ 
/*     */     
/*  48 */     for (ConstraintState constraintState = this._constraintStack; constraintState != null; constraintState = constraintState._next) {
/*  49 */       constraintState.element(paramEvent, paramSchemaType);
/*     */     }
/*     */ 
/*     */     
/*  53 */     for (byte b = 0; paramArrayOfSchemaIdentityConstraint != null && b < paramArrayOfSchemaIdentityConstraint.length; b++) {
/*  54 */       newConstraintState(paramArrayOfSchemaIdentityConstraint[b], paramEvent, paramSchemaType);
/*     */     }
/*     */   }
/*     */   
/*     */   public void endElement(ValidatorListener.Event paramEvent) {
/*  59 */     if (this._elementStack._hasConstraints) {
/*     */       
/*  61 */       for (ConstraintState constraintState1 = this._constraintStack; constraintState1 != null && constraintState1 != this._elementStack._savePoint; constraintState1 = constraintState1._next) {
/*  62 */         constraintState1.remove(paramEvent);
/*     */       }
/*  64 */       this._constraintStack = this._elementStack._savePoint;
/*     */     } 
/*     */     
/*  67 */     this._elementStack = this._elementStack._next;
/*     */ 
/*     */     
/*  70 */     for (ConstraintState constraintState = this._constraintStack; constraintState != null; constraintState = constraintState._next) {
/*  71 */       constraintState.endElement(paramEvent);
/*     */     }
/*     */   }
/*     */   
/*     */   public void attr(ValidatorListener.Event paramEvent, b paramb, SchemaType paramSchemaType, String paramString) {
/*  76 */     for (ConstraintState constraintState = this._constraintStack; constraintState != null; constraintState = constraintState._next)
/*  77 */       constraintState.attr(paramEvent, paramb, paramSchemaType, paramString); 
/*     */   }
/*     */   
/*     */   public void text(ValidatorListener.Event paramEvent, SchemaType paramSchemaType, String paramString, boolean paramBoolean) {
/*  81 */     for (ConstraintState constraintState = this._constraintStack; constraintState != null; constraintState = constraintState._next)
/*  82 */       constraintState.text(paramEvent, paramSchemaType, paramString, paramBoolean); 
/*     */   }
/*     */   
/*     */   public boolean isValid() {
/*  86 */     return !this._invalid;
/*     */   }
/*     */ 
/*     */   
/*     */   private void newConstraintState(SchemaIdentityConstraint paramSchemaIdentityConstraint, ValidatorListener.Event paramEvent, SchemaType paramSchemaType) {
/*  91 */     if (paramSchemaIdentityConstraint.getConstraintCategory() == 2) {
/*  92 */       new KeyrefState(paramSchemaIdentityConstraint, paramEvent, paramSchemaType);
/*     */     } else {
/*  94 */       new SelectorState(paramSchemaIdentityConstraint, paramEvent, paramSchemaType);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void buildIdStates() {
/* 100 */     IdState idState = new IdState();
/* 101 */     if (this._trackIdrefs)
/* 102 */       new IdRefState(idState); 
/*     */   }
/*     */   
/*     */   private void newState() {
/* 106 */     boolean bool = (this._elementStack == null) ? true : false;
/*     */     
/* 108 */     ElementState elementState = new ElementState();
/* 109 */     elementState._next = this._elementStack;
/* 110 */     this._elementStack = elementState;
/*     */     
/* 112 */     if (bool) {
/* 113 */       buildIdStates();
/*     */     }
/*     */   }
/*     */   
/*     */   private void emitError(ValidatorListener.Event paramEvent, String paramString, Object[] paramArrayOfObject) {
/* 118 */     this._invalid = true;
/*     */     
/* 120 */     if (this._errorListener != null) {
/*     */       
/* 122 */       assert paramEvent != null;
/*     */       
/* 124 */       this._errorListener.add(errorForEvent(paramString, paramArrayOfObject, 0, paramEvent));
/*     */     } 
/*     */   }
/*     */   
/*     */   public static XmlError errorForEvent(String paramString, Object[] paramArrayOfObject, int paramInt, ValidatorListener.Event paramEvent) {
/*     */     XmlError xmlError;
/* 130 */     XmlCursor xmlCursor = paramEvent.getLocationAsCursor();
/*     */     
/* 132 */     if (xmlCursor != null) {
/* 133 */       xmlError = XmlError.forCursor(paramString, paramArrayOfObject, paramInt, xmlCursor);
/*     */     } else {
/*     */       
/* 136 */       Location location = paramEvent.getLocation();
/* 137 */       if (location != null) {
/*     */         
/* 139 */         xmlError = XmlError.forLocation(paramString, paramArrayOfObject, paramInt, location.getSystemId(), location.getLineNumber(), location.getColumnNumber(), location.getCharacterOffset());
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */         
/* 145 */         xmlError = XmlError.forMessage(paramString, paramArrayOfObject, paramInt);
/*     */       } 
/*     */     } 
/* 148 */     return xmlError;
/*     */   }
/*     */ 
/*     */   
/*     */   private void emitError(ValidatorListener.Event paramEvent, String paramString) {
/* 153 */     this._invalid = true;
/*     */     
/* 155 */     if (this._errorListener != null) {
/*     */       
/* 157 */       assert paramEvent != null;
/*     */       
/* 159 */       this._errorListener.add(errorForEvent(paramString, 0, paramEvent));
/*     */     } 
/*     */   }
/*     */   
/*     */   public static XmlError errorForEvent(String paramString, int paramInt, ValidatorListener.Event paramEvent) {
/*     */     XmlError xmlError;
/* 165 */     XmlCursor xmlCursor = paramEvent.getLocationAsCursor();
/*     */     
/* 167 */     if (xmlCursor != null) {
/* 168 */       xmlError = XmlError.forCursor(paramString, paramInt, xmlCursor);
/*     */     } else {
/*     */       
/* 171 */       Location location = paramEvent.getLocation();
/* 172 */       if (location != null) {
/*     */         
/* 174 */         xmlError = XmlError.forLocation(paramString, paramInt, location.getSystemId(), location.getLineNumber(), location.getColumnNumber(), location.getCharacterOffset());
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */         
/* 180 */         xmlError = XmlError.forMessage(paramString, paramInt);
/*     */       } 
/*     */     } 
/* 183 */     return xmlError;
/*     */   }
/*     */ 
/*     */   
/*     */   private void setSavePoint(ConstraintState paramConstraintState) {
/* 188 */     if (!this._elementStack._hasConstraints) {
/* 189 */       this._elementStack._savePoint = paramConstraintState;
/*     */     }
/* 191 */     this._elementStack._hasConstraints = true;
/*     */   }
/*     */ 
/*     */   
/*     */   private static XmlObject newValue(SchemaType paramSchemaType, String paramString) {
/*     */     try {
/* 197 */       return (XmlObject)paramSchemaType.newValue(paramString);
/*     */     }
/* 199 */     catch (IllegalArgumentException illegalArgumentException) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 205 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static SchemaType getSimpleType(SchemaType paramSchemaType) {
/* 217 */     assert paramSchemaType.isSimpleType() || paramSchemaType.getContentType() == 2 : paramSchemaType + " does not have simple content.";
/*     */     
/* 219 */     while (!paramSchemaType.isSimpleType()) {
/* 220 */       paramSchemaType = paramSchemaType.getBaseType();
/*     */     }
/* 222 */     return paramSchemaType;
/*     */   }
/*     */ 
/*     */   
/*     */   static boolean hasSimpleContent(SchemaType paramSchemaType) {
/* 227 */     return (paramSchemaType.isSimpleType() || paramSchemaType.getContentType() == 2);
/*     */   }
/*     */   
/*     */   public abstract class ConstraintState {
/*     */     ConstraintState _next;
/*     */     private final IdentityConstraint this$0;
/*     */     
/*     */     ConstraintState() {
/* 235 */       IdentityConstraint.this.setSavePoint(IdentityConstraint.this._constraintStack);
/* 236 */       this._next = IdentityConstraint.this._constraintStack;
/* 237 */       IdentityConstraint.this._constraintStack = this;
/*     */     }
/*     */     
/*     */     abstract void element(ValidatorListener.Event param1Event, SchemaType param1SchemaType);
/*     */     
/*     */     abstract void endElement(ValidatorListener.Event param1Event);
/*     */     
/*     */     abstract void attr(ValidatorListener.Event param1Event, b param1b, SchemaType param1SchemaType, String param1String);
/*     */     
/*     */     abstract void text(ValidatorListener.Event param1Event, SchemaType param1SchemaType, String param1String, boolean param1Boolean);
/*     */     
/*     */     abstract void remove(ValidatorListener.Event param1Event); }
/*     */   
/* 250 */   public class SelectorState extends ConstraintState { Set _values = new LinkedHashSet(); SchemaIdentityConstraint _constraint; XPath.ExecutionContext _context;
/*     */     private final IdentityConstraint this$0;
/*     */     
/*     */     SelectorState(SchemaIdentityConstraint param1SchemaIdentityConstraint, ValidatorListener.Event param1Event, SchemaType param1SchemaType) {
/* 254 */       this._constraint = param1SchemaIdentityConstraint;
/* 255 */       this._context = new XPath.ExecutionContext();
/* 256 */       this._context.init((XPath)this._constraint.getSelectorPath());
/*     */       
/* 258 */       if ((this._context.start() & 0x1) != 0) {
/* 259 */         createFieldState(param1Event, param1SchemaType);
/*     */       }
/*     */     }
/*     */     
/*     */     void addFields(XmlObjectList param1XmlObjectList, ValidatorListener.Event param1Event) {
/* 264 */       if (this._constraint.getConstraintCategory() == 2) {
/* 265 */         this._values.add(param1XmlObjectList);
/* 266 */       } else if (this._values.contains(param1XmlObjectList)) {
/*     */         
/* 268 */         if (this._constraint.getConstraintCategory() == 3) {
/* 269 */           IdentityConstraint.this.emitError(param1Event, "cvc-identity-constraint.4.1", new Object[] { param1XmlObjectList, QNameHelper.pretty(this._constraint.getName()) });
/*     */         } else {
/*     */           
/* 272 */           IdentityConstraint.this.emitError(param1Event, "cvc-identity-constraint.4.2.2", new Object[] { param1XmlObjectList, QNameHelper.pretty(this._constraint.getName()) });
/*     */         } 
/*     */       } else {
/*     */         
/* 276 */         this._values.add(param1XmlObjectList);
/*     */       } 
/*     */     }
/*     */     
/*     */     void element(ValidatorListener.Event param1Event, SchemaType param1SchemaType) {
/* 281 */       if ((this._context.element(param1Event.getName()) & 0x1) != 0) {
/* 282 */         createFieldState(param1Event, param1SchemaType);
/*     */       }
/*     */     }
/*     */     
/*     */     void endElement(ValidatorListener.Event param1Event) {
/* 287 */       this._context.end();
/*     */     }
/*     */     
/*     */     void createFieldState(ValidatorListener.Event param1Event, SchemaType param1SchemaType) {
/* 291 */       new IdentityConstraint.FieldState(this, param1Event, param1SchemaType);
/*     */     }
/*     */ 
/*     */     
/*     */     void remove(ValidatorListener.Event param1Event) {
/* 296 */       for (IdentityConstraint.ConstraintState constraintState = this._next; constraintState != null; constraintState = constraintState._next) {
/*     */         
/* 298 */         if (constraintState instanceof IdentityConstraint.KeyrefState) {
/*     */           
/* 300 */           IdentityConstraint.KeyrefState keyrefState = (IdentityConstraint.KeyrefState)constraintState;
/* 301 */           if (keyrefState._constraint.getReferencedKey() == this._constraint)
/* 302 */             keyrefState.addKeyValues(this._values, true); 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     void attr(ValidatorListener.Event param1Event, b param1b, SchemaType param1SchemaType, String param1String) {}
/*     */     
/*     */     void text(ValidatorListener.Event param1Event, SchemaType param1SchemaType, String param1String, boolean param1Boolean) {} }
/*     */   
/*     */   public class KeyrefState extends SelectorState {
/* 312 */     Map _keyValues = new HashMap();
/* 313 */     private Object CHILD_ADDED = new Object();
/* 314 */     private Object CHILD_REMOVED = new Object();
/* 315 */     private Object SELF_ADDED = new Object(); private final IdentityConstraint this$0;
/*     */     
/*     */     KeyrefState(SchemaIdentityConstraint param1SchemaIdentityConstraint, ValidatorListener.Event param1Event, SchemaType param1SchemaType) {
/* 318 */       super(param1SchemaIdentityConstraint, param1Event, param1SchemaType);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void addKeyValues(Set param1Set, boolean param1Boolean) {
/* 327 */       for (Object object : param1Set) {
/*     */ 
/*     */         
/* 330 */         Object object1 = this._keyValues.get(object);
/* 331 */         if (object1 == null) {
/* 332 */           this._keyValues.put(object, param1Boolean ? this.CHILD_ADDED : this.SELF_ADDED); continue;
/* 333 */         }  if (object1 == this.CHILD_ADDED) {
/*     */           
/* 335 */           if (param1Boolean) {
/* 336 */             this._keyValues.put(object, this.CHILD_REMOVED); continue;
/*     */           } 
/* 338 */           this._keyValues.put(object, this.SELF_ADDED); continue;
/*     */         } 
/* 340 */         if (object1 == this.CHILD_REMOVED)
/*     */         {
/* 342 */           if (!param1Boolean) {
/* 343 */             this._keyValues.put(object, this.SELF_ADDED);
/*     */           }
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*     */     private boolean hasKeyValue(Object param1Object) {
/* 350 */       Object object = this._keyValues.get(param1Object);
/* 351 */       return (object != null && object != this.CHILD_REMOVED);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void remove(ValidatorListener.Event param1Event) {
/* 357 */       for (IdentityConstraint.ConstraintState constraintState = this._next; constraintState != null && constraintState != IdentityConstraint.this._elementStack._savePoint; constraintState = constraintState._next) {
/*     */         
/* 359 */         if (constraintState instanceof IdentityConstraint.SelectorState) {
/*     */           
/* 361 */           IdentityConstraint.SelectorState selectorState = (IdentityConstraint.SelectorState)constraintState;
/* 362 */           if (selectorState._constraint == this._constraint.getReferencedKey()) {
/* 363 */             addKeyValues(selectorState._values, false);
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 369 */       for (XmlObjectList xmlObjectList : this._values) {
/*     */ 
/*     */ 
/*     */         
/* 373 */         if (xmlObjectList.unfilled() < 0 && !hasKeyValue(xmlObjectList)) {
/*     */ 
/*     */           
/* 376 */           IdentityConstraint.this.emitError(param1Event, "cvc-identity-constraint.4.3", new Object[] { xmlObjectList, QNameHelper.pretty(this._constraint.getName()) });
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public class FieldState
/*     */     extends ConstraintState
/*     */   {
/*     */     IdentityConstraint.SelectorState _selector;
/*     */     XPath.ExecutionContext[] _contexts;
/*     */     boolean[] _needsValue;
/*     */     XmlObjectList _value;
/*     */     private final IdentityConstraint this$0;
/*     */     
/*     */     FieldState(IdentityConstraint.SelectorState param1SelectorState, ValidatorListener.Event param1Event, SchemaType param1SchemaType) {
/* 394 */       this._selector = param1SelectorState;
/* 395 */       SchemaIdentityConstraint schemaIdentityConstraint = param1SelectorState._constraint;
/*     */       
/* 397 */       int i = (schemaIdentityConstraint.getFields()).length;
/* 398 */       this._contexts = new XPath.ExecutionContext[i];
/* 399 */       this._needsValue = new boolean[i];
/* 400 */       this._value = new XmlObjectList(i);
/*     */       
/* 402 */       for (byte b = 0; b < i; b++) {
/*     */         
/* 404 */         this._contexts[b] = new XPath.ExecutionContext();
/* 405 */         this._contexts[b].init((XPath)schemaIdentityConstraint.getFieldPath(b));
/* 406 */         if ((this._contexts[b].start() & 0x1) != 0)
/*     */         {
/*     */ 
/*     */           
/* 410 */           if (!IdentityConstraint.hasSimpleContent(param1SchemaType)) {
/*     */             
/* 412 */             IdentityConstraint.this.emitError(param1Event, "Identity constraint field must have simple content");
/*     */           } else {
/* 414 */             this._needsValue[b] = true;
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*     */     void element(ValidatorListener.Event param1Event, SchemaType param1SchemaType) {
/*     */       byte b;
/* 422 */       for (b = 0; b < this._contexts.length; b++) {
/* 423 */         if (this._needsValue[b]) {
/*     */ 
/*     */           
/* 426 */           IdentityConstraint.this.emitError(param1Event, "Identity constraint field must have simple content");
/* 427 */           this._needsValue[b] = false;
/*     */         } 
/*     */       } 
/*     */       
/* 431 */       for (b = 0; b < this._contexts.length; b++) {
/* 432 */         if ((this._contexts[b].element(param1Event.getName()) & 0x1) != 0)
/*     */         {
/* 434 */           if (!IdentityConstraint.hasSimpleContent(param1SchemaType)) {
/*     */             
/* 436 */             IdentityConstraint.this.emitError(param1Event, "Identity constraint field must have simple content");
/*     */           } else {
/* 438 */             this._needsValue[b] = true;
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     void attr(ValidatorListener.Event param1Event, b param1b, SchemaType param1SchemaType, String param1String) {
/* 446 */       if (param1String == null)
/*     */         return; 
/* 448 */       for (byte b1 = 0; b1 < this._contexts.length; b1++) {
/* 449 */         if (this._contexts[b1].attr(param1b)) {
/* 450 */           XmlObject xmlObject = IdentityConstraint.newValue(param1SchemaType, param1String);
/*     */ 
/*     */           
/* 453 */           if (xmlObject == null)
/*     */             return; 
/* 455 */           boolean bool = this._value.set(xmlObject, b1);
/*     */ 
/*     */           
/* 458 */           if (!bool) {
/* 459 */             IdentityConstraint.this.emitError(param1Event, "Multiple instances of field with xpath: '" + this._selector._constraint.getFields()[b1] + "' for a selector");
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void text(ValidatorListener.Event param1Event, SchemaType param1SchemaType, String param1String, boolean param1Boolean) {
/* 470 */       if (param1String == null && !param1Boolean)
/*     */         return; 
/* 472 */       for (byte b = 0; b < this._contexts.length; b++) {
/* 473 */         if (this._needsValue[b]) {
/*     */           
/* 475 */           if (param1Boolean || !IdentityConstraint.hasSimpleContent(param1SchemaType)) {
/*     */ 
/*     */             
/* 478 */             IdentityConstraint.this.emitError(param1Event, "Identity constraint field must have simple content");
/*     */             
/*     */             return;
/*     */           } 
/* 482 */           SchemaType schemaType = IdentityConstraint.getSimpleType(param1SchemaType);
/* 483 */           XmlObject xmlObject = IdentityConstraint.newValue(schemaType, param1String);
/*     */ 
/*     */           
/* 486 */           if (xmlObject == null)
/*     */             return; 
/* 488 */           boolean bool = this._value.set(xmlObject, b);
/*     */ 
/*     */           
/* 491 */           if (!bool) {
/* 492 */             IdentityConstraint.this.emitError(param1Event, "Multiple instances of field with xpath: '" + this._selector._constraint.getFields()[b] + "' for a selector");
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void endElement(ValidatorListener.Event param1Event) {
/* 502 */       for (byte b = 0; b < this._needsValue.length; b++) {
/*     */         
/* 504 */         this._contexts[b].end();
/* 505 */         this._needsValue[b] = false;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void remove(ValidatorListener.Event param1Event) {
/* 513 */       if (this._selector._constraint.getConstraintCategory() == 1 && this._value.unfilled() >= 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 518 */         IdentityConstraint.this.emitError(param1Event, "Key " + QNameHelper.pretty(this._selector._constraint.getName()) + " is missing field with xpath: '" + this._selector._constraint.getFields()[this._value.unfilled()] + "'");
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 523 */         this._selector.addFields(this._value, param1Event);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public class IdState
/*     */     extends ConstraintState
/*     */   {
/* 531 */     Set _values = new LinkedHashSet();
/*     */     
/*     */     private final IdentityConstraint this$0;
/*     */ 
/*     */     
/*     */     void attr(ValidatorListener.Event param1Event, b param1b, SchemaType param1SchemaType, String param1String) {
/* 537 */       handleValue(param1Event, param1SchemaType, param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     void text(ValidatorListener.Event param1Event, SchemaType param1SchemaType, String param1String, boolean param1Boolean) {
/* 542 */       if (param1Boolean) {
/*     */         return;
/*     */       }
/* 545 */       handleValue(param1Event, param1SchemaType, param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void handleValue(ValidatorListener.Event param1Event, SchemaType param1SchemaType, String param1String) {
/* 552 */       if (param1String == null)
/*     */         return; 
/* 554 */       if (param1SchemaType == null || param1SchemaType.isNoType()) {
/*     */         return;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 560 */       if (XmlID.type.isAssignableFrom(param1SchemaType)) {
/*     */         
/* 562 */         XmlObjectList xmlObjectList = new XmlObjectList(1);
/* 563 */         XmlObject xmlObject = IdentityConstraint.newValue(XmlID.type, param1String);
/*     */ 
/*     */         
/* 566 */         if (xmlObject == null)
/*     */           return; 
/* 568 */         xmlObjectList.set(xmlObject, 0);
/*     */         
/* 570 */         if (this._values.contains(xmlObjectList)) {
/* 571 */           IdentityConstraint.this.emitError(param1Event, "cvc-id.2", new Object[] { param1String });
/*     */         } else {
/* 573 */           this._values.add(xmlObjectList);
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     void element(ValidatorListener.Event param1Event, SchemaType param1SchemaType) {}
/*     */     
/*     */     void endElement(ValidatorListener.Event param1Event) {}
/*     */     
/*     */     void remove(ValidatorListener.Event param1Event) {} }
/*     */   
/*     */   public class IdRefState extends ConstraintState {
/*     */     IdentityConstraint.IdState _ids;
/*     */     List _values;
/*     */     private final IdentityConstraint this$0;
/*     */     
/*     */     IdRefState(IdentityConstraint.IdState param1IdState) {
/* 590 */       this._ids = param1IdState;
/* 591 */       this._values = new ArrayList();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void handleValue(ValidatorListener.Event param1Event, SchemaType param1SchemaType, String param1String) {
/* 597 */       if (param1String == null)
/*     */         return; 
/* 599 */       if (param1SchemaType == null || param1SchemaType.isNoType()) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 604 */       if (XmlIDREFS.type.isAssignableFrom(param1SchemaType)) {
/*     */         
/* 606 */         XmlIDREFS xmlIDREFS = (XmlIDREFS)IdentityConstraint.newValue(XmlIDREFS.type, param1String);
/*     */ 
/*     */         
/* 609 */         if (xmlIDREFS == null)
/*     */           return; 
/* 611 */         List list = xmlIDREFS.xgetListValue();
/*     */ 
/*     */         
/* 614 */         for (byte b = 0; b < list.size(); b++)
/*     */         {
/* 616 */           XmlObjectList xmlObjectList = new XmlObjectList(1);
/* 617 */           XmlIDREF xmlIDREF = list.get(b);
/* 618 */           xmlObjectList.set((XmlObject)xmlIDREF, 0);
/* 619 */           this._values.add(xmlObjectList);
/*     */         }
/*     */       
/* 622 */       } else if (XmlIDREF.type.isAssignableFrom(param1SchemaType)) {
/*     */         
/* 624 */         XmlObjectList xmlObjectList = new XmlObjectList(1);
/* 625 */         XmlIDREF xmlIDREF = (XmlIDREF)param1SchemaType.newValue(param1String);
/*     */ 
/*     */         
/* 628 */         if (xmlIDREF == null)
/*     */           return; 
/* 630 */         xmlObjectList.set((XmlObject)xmlIDREF, 0);
/* 631 */         this._values.add(xmlObjectList);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     void attr(ValidatorListener.Event param1Event, b param1b, SchemaType param1SchemaType, String param1String) {
/* 637 */       handleValue(param1Event, param1SchemaType, param1String);
/*     */     }
/*     */     
/*     */     void text(ValidatorListener.Event param1Event, SchemaType param1SchemaType, String param1String, boolean param1Boolean) {
/* 641 */       if (param1Boolean) {
/*     */         return;
/*     */       }
/* 644 */       handleValue(param1Event, param1SchemaType, param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     void remove(ValidatorListener.Event param1Event) {
/* 649 */       for (String str : this._values) {
/*     */ 
/*     */         
/* 652 */         if (!this._ids._values.contains(str))
/*     */         {
/*     */           
/* 655 */           IdentityConstraint.this.emitError(param1Event, "ID not found for IDRef value '" + str + "'");
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*     */     void element(ValidatorListener.Event param1Event, SchemaType param1SchemaType) {}
/*     */     
/*     */     void endElement(ValidatorListener.Event param1Event) {}
/*     */   }
/*     */   
/*     */   private static class ElementState {
/*     */     ElementState _next;
/*     */     boolean _hasConstraints;
/*     */     IdentityConstraint.ConstraintState _savePoint;
/*     */     
/*     */     private ElementState() {}
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\IdentityConstraint.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */