/*     */ package org.apache.xmlbeans.impl.schema;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaField;
/*     */ import org.apache.xmlbeans.SchemaLocalElement;
/*     */ import org.apache.xmlbeans.SchemaParticle;
/*     */ import org.apache.xmlbeans.impl.values.TypeStoreVisitor;
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
/*     */ public class SchemaTypeVisitorImpl
/*     */   implements TypeStoreVisitor
/*     */ {
/*     */   static final boolean PROBE_VALIDITY = true;
/*     */   static final boolean CHECK_VALIDITY = false;
/*     */   private VisitorState[] _stack;
/*     */   private VisitorState[] _rollback;
/*     */   int _stackSize;
/*     */   int _rollbackSize;
/*     */   private boolean _isValid;
/*     */   private SchemaParticle _matchedParticle;
/*     */   private VisitorState _top;
/*     */   private int _rollbackIndex;
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   public SchemaTypeVisitorImpl(SchemaParticle paramSchemaParticle) {
/*  38 */     init(paramSchemaParticle);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SchemaTypeVisitorImpl() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(SchemaParticle paramSchemaParticle) {
/*  48 */     if (this._stack == null)
/*     */     {
/*  50 */       this._stack = expand(null);
/*     */     }
/*  52 */     if (this._rollback == null)
/*     */     {
/*  54 */       this._rollback = expand(null);
/*     */     }
/*     */     
/*  57 */     this._stackSize = 0;
/*  58 */     this._rollbackSize = 0;
/*     */     
/*  60 */     if (paramSchemaParticle != null) {
/*     */       
/*  62 */       push(paramSchemaParticle);
/*  63 */       this._rollbackIndex = 1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public VisitorState[] expand(VisitorState[] paramArrayOfVisitorState) {
/*  69 */     byte b1 = (paramArrayOfVisitorState == null) ? 4 : (paramArrayOfVisitorState.length * 2);
/*  70 */     VisitorState[] arrayOfVisitorState = new VisitorState[b1];
/*  71 */     if (paramArrayOfVisitorState != null)
/*  72 */       System.arraycopy(paramArrayOfVisitorState, 0, arrayOfVisitorState, 0, paramArrayOfVisitorState.length); 
/*  73 */     for (byte b2 = (paramArrayOfVisitorState == null) ? 0 : paramArrayOfVisitorState.length; b2 < b1; b2++)
/*     */     {
/*  75 */       arrayOfVisitorState[b2] = new VisitorState();
/*     */     }
/*  77 */     return arrayOfVisitorState;
/*     */   }
/*     */ 
/*     */   
/*     */   private static class VisitorState
/*     */   {
/*     */     SchemaParticle _curPart;
/*     */     
/*     */     int _curCount;
/*     */     
/*     */     int _curMax;
/*     */     
/*     */     int _curMin;
/*     */     int _processedChildCount;
/*     */     int _childCount;
/*     */     boolean[] _seen;
/*     */     
/*     */     private VisitorState() {}
/*     */     
/*     */     public void copy(VisitorState param1VisitorState) {
/*  97 */       this._curPart = param1VisitorState._curPart;
/*  98 */       this._curCount = param1VisitorState._curCount;
/*  99 */       this._curMin = param1VisitorState._curMin;
/* 100 */       this._curMax = param1VisitorState._curMax;
/* 101 */       this._processedChildCount = param1VisitorState._processedChildCount;
/* 102 */       this._childCount = param1VisitorState._childCount;
/* 103 */       if (param1VisitorState._seen != null) {
/*     */         
/* 105 */         this._seen = new boolean[param1VisitorState._seen.length];
/* 106 */         System.arraycopy(param1VisitorState._seen, 0, this._seen, 0, param1VisitorState._seen.length);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void init(SchemaParticle param1SchemaParticle) {
/* 112 */       this._curPart = param1SchemaParticle;
/* 113 */       this._curMin = param1SchemaParticle.getIntMinOccurs();
/* 114 */       this._curMax = param1SchemaParticle.getIntMaxOccurs();
/* 115 */       this._curCount = 0;
/* 116 */       this._processedChildCount = 0;
/* 117 */       this._childCount = param1SchemaParticle.countOfParticleChild();
/* 118 */       this._seen = (param1SchemaParticle.getParticleType() == 1) ? new boolean[this._childCount] : null;
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
/*     */ 
/*     */ 
/*     */   
/*     */   VisitorState topRef() {
/* 133 */     return this._stack[this._stackSize - 1];
/*     */   }
/*     */ 
/*     */   
/*     */   void saveCopy(VisitorState paramVisitorState) {
/* 138 */     if (this._rollback.length == this._rollbackSize) {
/* 139 */       this._rollback = expand(this._rollback);
/*     */     }
/* 141 */     this._rollback[this._rollbackSize].copy(paramVisitorState);
/* 142 */     this._rollbackSize++;
/*     */   }
/*     */ 
/*     */   
/*     */   void addParticle(SchemaParticle paramSchemaParticle) {
/* 147 */     if (this._stack.length == this._stackSize)
/* 148 */       this._stack = expand(this._stack); 
/* 149 */     this._stack[this._stackSize].init(paramSchemaParticle);
/* 150 */     this._stackSize++;
/*     */   }
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
/*     */   boolean prepare() {
/* 166 */     if (this._rollbackIndex == 0) {
/*     */       
/* 168 */       this._top = null;
/* 169 */       return false;
/*     */     } 
/*     */     
/* 172 */     this._top = topRef();
/* 173 */     saveCopy(this._top);
/* 174 */     this._rollbackIndex = this._stackSize - 1;
/* 175 */     return true;
/*     */   }
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
/*     */   void push(SchemaParticle paramSchemaParticle) {
/* 191 */     addParticle(paramSchemaParticle);
/* 192 */     this._top = topRef();
/*     */   }
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
/*     */   boolean pop() {
/* 208 */     this._stackSize--;
/* 209 */     if (this._stackSize <= this._rollbackIndex)
/* 210 */       return prepare(); 
/* 211 */     this._top = topRef();
/* 212 */     return true;
/*     */   }
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
/*     */   void commit() {
/* 228 */     this._top = null;
/* 229 */     this._rollbackIndex = this._stackSize;
/* 230 */     this._rollbackSize = 0;
/*     */   }
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
/*     */   void rollback() {
/* 246 */     while (this._rollbackSize > 0) {
/*     */       
/* 248 */       this._rollbackSize--;
/* 249 */       VisitorState visitorState = this._stack[this._rollbackIndex];
/* 250 */       this._stack[this._rollbackIndex] = this._rollback[this._rollbackSize];
/* 251 */       this._rollback[this._rollbackSize] = visitorState;
/* 252 */       this._rollbackIndex++;
/*     */     } 
/* 254 */     this._stackSize = this._rollbackIndex;
/* 255 */     this._top = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean notValid() {
/* 266 */     this._isValid = false;
/* 267 */     this._matchedParticle = null;
/* 268 */     rollback();
/* 269 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean ok(SchemaParticle paramSchemaParticle, boolean paramBoolean) {
/* 279 */     if (!paramBoolean) {
/*     */       
/* 281 */       this._matchedParticle = paramSchemaParticle;
/* 282 */       commit();
/*     */     }
/*     */     else {
/*     */       
/* 286 */       rollback();
/*     */     } 
/* 288 */     return true;
/*     */   }
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
/*     */   public boolean visit(b paramb) {
/* 304 */     return visit(paramb, false);
/*     */   }
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
/*     */   public boolean visit(b paramb, boolean paramBoolean) {
/* 321 */     if (!prepare()) {
/* 322 */       return notValid();
/*     */     }
/*     */     
/* 325 */     int i = -2;
/* 326 */     int j = -2;
/*     */     
/*     */     label78: while (true)
/*     */     { int k;
/*     */       
/*     */       byte b1;
/* 332 */       if (this._top._curCount > this._top._curMin && i == this._top._processedChildCount && j == this._stackSize)
/*     */       {
/*     */ 
/*     */         
/* 336 */         this._top._curCount = this._top._curMax;
/*     */       }
/*     */ 
/*     */       
/* 340 */       i = this._top._processedChildCount;
/* 341 */       j = this._stackSize;
/*     */       
/* 343 */       while (this._top._curCount >= this._top._curMax)
/*     */       
/* 345 */       { if (!pop())
/*     */         
/*     */         { 
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
/*     */ 
/*     */ 
/*     */           
/* 451 */           if (paramb == null) {
/* 452 */             return ok(null, paramBoolean);
/*     */           }
/*     */           
/* 455 */           return notValid(); }  }  switch (this._top._curPart.getParticleType()) { default: assert false;case 5: if (!this._top._curPart.canStartWithElement(paramb)) { if (this._top._curCount < this._top._curMin) return notValid();  break; }  this._top._curCount++; return ok(this._top._curPart, paramBoolean);case 4: if (!this._top._curPart.canStartWithElement(paramb)) { if (this._top._curCount < this._top._curMin) return notValid();  break; }  this._top._curCount++; return ok(this._top._curPart, paramBoolean);case 3: for (k = this._top._processedChildCount; k < this._top._childCount; k++) { SchemaParticle schemaParticle = this._top._curPart.getParticleChild(k); if (schemaParticle.canStartWithElement(paramb)) { this._top._processedChildCount = k + 1; push(schemaParticle); continue label78; }  if (!schemaParticle.isSkippable()) { if (this._top._processedChildCount != 0 || this._top._curCount < this._top._curMin) return notValid();  continue label78; }  }  this._top._curCount++; this._top._processedChildCount = 0; continue;case 2: for (k = 0; k < this._top._childCount; k++) { SchemaParticle schemaParticle = this._top._curPart.getParticleChild(k); if (schemaParticle.canStartWithElement(paramb)) { this._top._curCount++; push(schemaParticle); continue label78; }  }  if (this._top._curCount < this._top._curMin && !this._top._curPart.isSkippable()) return notValid();  break;case 1: k = this._top._processedChildCount; for (b1 = 0; b1 < this._top._childCount; b1++) { if (!this._top._seen[b1]) { SchemaParticle schemaParticle = this._top._curPart.getParticleChild(b1); if (schemaParticle.canStartWithElement(paramb)) { this._top._processedChildCount++; this._top._seen[b1] = true; push(schemaParticle); continue label78; }  if (schemaParticle.isSkippable()) k++;  }  }  if (k < this._top._childCount) { if (this._top._curCount < this._top._curMin) return notValid();  break; }  this._top._curCount++; this._top._processedChildCount = 0; Arrays.fill(this._top._seen, false); continue; }  if (!pop()) break;  }  if (paramb == null) return ok(null, paramBoolean);  return notValid();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean testValid(b paramb) {
/* 460 */     return visit(paramb, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int get_elementflags() {
/* 468 */     if (currentParticle() == null || currentParticle().getParticleType() != 4) {
/* 469 */       return 0;
/*     */     }
/* 471 */     SchemaLocalElement schemaLocalElement = (SchemaLocalElement)currentParticle();
/*     */     
/* 473 */     return (schemaLocalElement.isNillable() ? 1 : 0) | (schemaLocalElement.isDefault() ? 2 : 0) | (schemaLocalElement.isFixed() ? 4 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String get_default_text() {
/* 483 */     if (currentParticle() == null || currentParticle().getParticleType() != 4) {
/* 484 */       return null;
/*     */     }
/* 486 */     return ((SchemaLocalElement)currentParticle()).getDefaultText();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SchemaField get_schema_field() {
/* 493 */     if (currentParticle() instanceof SchemaField) {
/* 494 */       return (SchemaField)currentParticle();
/*     */     }
/* 496 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SchemaParticle currentParticle() {
/* 504 */     return this._matchedParticle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAllValid() {
/* 512 */     return this._isValid;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\SchemaTypeVisitorImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */