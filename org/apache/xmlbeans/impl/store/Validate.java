/*     */ package org.apache.xmlbeans.impl.store;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import javax.xml.stream.Location;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.impl.common.ValidatorListener;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Validate
/*     */   implements ValidatorListener.Event
/*     */ {
/*     */   private ValidatorListener _sink;
/*     */   private Cur _cur;
/*     */   private boolean _hasText;
/*     */   private boolean _oneChunk;
/*     */   private Cur _textCur;
/*     */   private StringBuffer _textSb;
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   Validate(Cur paramCur, ValidatorListener paramValidatorListener) {
/*  27 */     if (!paramCur.isUserNode()) {
/*  28 */       throw new IllegalStateException("Inappropriate location to validate");
/*     */     }
/*  30 */     this._sink = paramValidatorListener;
/*  31 */     this._cur = paramCur;
/*  32 */     this._textCur = paramCur.tempCur();
/*  33 */     this._hasText = false;
/*     */     
/*  35 */     this._cur.push();
/*     */ 
/*     */     
/*     */     try {
/*  39 */       process();
/*     */     }
/*     */     finally {
/*     */       
/*  43 */       this._cur.pop();
/*  44 */       this._cur = null;
/*     */       
/*  46 */       this._sink = null;
/*     */       
/*  48 */       this._textCur.release();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void process() {
/*  54 */     emitEvent(1);
/*     */     
/*  56 */     if (this._cur.isAttr()) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  61 */       this._cur.next();
/*     */       
/*  63 */       if (this._cur.isText()) {
/*  64 */         emitText();
/*     */       }
/*     */     } else {
/*     */       
/*  68 */       assert this._cur.isContainer();
/*     */ 
/*     */ 
/*     */       
/*  72 */       doAttrs();
/*     */       
/*  74 */       this._cur.next(); for (; !this._cur.isAtEndOfLastPush(); this._cur.next()) {
/*     */         
/*  76 */         switch (this._cur.kind()) {
/*     */           
/*     */           case 2:
/*  79 */             emitEvent(1);
/*  80 */             doAttrs();
/*     */             break;
/*     */           
/*     */           case -2:
/*  84 */             emitEvent(2);
/*     */             break;
/*     */           
/*     */           case 0:
/*  88 */             emitText();
/*     */             break;
/*     */           
/*     */           case 4:
/*     */           case 5:
/*  93 */             this._cur.toEnd();
/*     */             break;
/*     */           
/*     */           default:
/*  97 */             throw new RuntimeException("Unexpected kind: " + this._cur.kind());
/*     */         } 
/*     */       
/*     */       } 
/*     */     } 
/* 102 */     emitEvent(2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void doAttrs() {
/* 110 */     assert !this._hasText;
/*     */     
/* 112 */     if (this._cur.toFirstAttr()) {
/*     */       
/*     */       do
/*     */       {
/* 116 */         if (!this._cur.isNormalAttr() || this._cur.getUri().equals("http://www.w3.org/2001/XMLSchema-instance"))
/* 117 */           continue;  this._sink.nextEvent(4, this);
/*     */       }
/* 119 */       while (this._cur.toNextAttr());
/*     */       
/* 121 */       this._cur.toParent();
/*     */     } 
/*     */     
/* 124 */     this._sink.nextEvent(5, this);
/*     */   }
/*     */ 
/*     */   
/*     */   private void emitText() {
/* 129 */     assert this._cur.isText();
/*     */     
/* 131 */     if (this._hasText) {
/*     */       
/* 133 */       if (this._oneChunk) {
/*     */         
/* 135 */         if (this._textSb == null) {
/* 136 */           this._textSb = new StringBuffer();
/*     */         } else {
/* 138 */           this._textSb.delete(0, this._textSb.length());
/*     */         } 
/* 140 */         assert this._textCur.isText();
/*     */         
/* 142 */         CharUtil.getString(this._textSb, this._textCur.getChars(-1), this._textCur._offSrc, this._textCur._cchSrc);
/*     */ 
/*     */         
/* 145 */         this._oneChunk = false;
/*     */       } 
/*     */       
/* 148 */       assert this._textSb != null && this._textSb.length() > 0;
/*     */       
/* 150 */       CharUtil.getString(this._textSb, this._cur.getChars(-1), this._cur._offSrc, this._cur._cchSrc);
/*     */     }
/*     */     else {
/*     */       
/* 154 */       this._hasText = true;
/* 155 */       this._oneChunk = true;
/* 156 */       this._textCur.moveToCur(this._cur);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void emitEvent(int paramInt) {
/* 162 */     assert paramInt != 3;
/* 163 */     assert paramInt != 4 || !this._hasText;
/* 164 */     assert paramInt != 5 || !this._hasText;
/*     */     
/* 166 */     if (this._hasText) {
/*     */       
/* 168 */       this._sink.nextEvent(3, this);
/* 169 */       this._hasText = false;
/*     */     } 
/*     */     
/* 172 */     this._sink.nextEvent(paramInt, this);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getText() {
/* 177 */     if (this._cur.isAttr()) {
/* 178 */       return this._cur.getValueAsString();
/*     */     }
/* 180 */     assert this._hasText;
/* 181 */     assert this._oneChunk || (this._textSb != null && this._textSb.length() > 0);
/* 182 */     assert !this._oneChunk || this._textCur.isText();
/*     */     
/* 184 */     return this._oneChunk ? this._textCur.getCharsAsString(-1) : this._textSb.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getText(int paramInt) {
/* 189 */     if (this._cur.isAttr()) {
/* 190 */       return this._cur.getValueAsString(paramInt);
/*     */     }
/* 192 */     assert this._hasText;
/* 193 */     assert this._oneChunk || (this._textSb != null && this._textSb.length() > 0);
/* 194 */     assert !this._oneChunk || this._textCur.isText();
/*     */     
/* 196 */     if (this._oneChunk) {
/* 197 */       return this._textCur.getCharsAsString(-1, paramInt);
/*     */     }
/* 199 */     return Locale.applyWhiteSpaceRule(this._textSb.toString(), paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean textIsWhitespace() {
/* 204 */     if (this._cur.isAttr())
/*     */     {
/* 206 */       return this._cur._locale.getCharUtil().isWhiteSpace(this._cur.getFirstChars(), this._cur._offSrc, this._cur._cchSrc);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 211 */     assert this._hasText;
/*     */     
/* 213 */     if (this._oneChunk)
/*     */     {
/* 215 */       return this._cur._locale.getCharUtil().isWhiteSpace(this._textCur.getChars(-1), this._textCur._offSrc, this._textCur._cchSrc);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 220 */     String str = this._textSb.toString();
/*     */     
/* 222 */     return this._cur._locale.getCharUtil().isWhiteSpace(str, 0, str.length());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getNamespaceForPrefix(String paramString) {
/* 227 */     return this._cur.namespaceForPrefix(paramString, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlCursor getLocationAsCursor() {
/* 232 */     return new Cursor(this._cur);
/*     */   }
/*     */ 
/*     */   
/*     */   public Location getLocation() {
/* 237 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getXsiType() {
/* 242 */     return this._cur.getAttrValue(Locale._xsiType);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getXsiNil() {
/* 247 */     return this._cur.getAttrValue(Locale._xsiNil);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getXsiLoc() {
/* 252 */     return this._cur.getAttrValue(Locale._xsiLoc);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getXsiNoLoc() {
/* 257 */     return this._cur.getAttrValue(Locale._xsiNoLoc);
/*     */   }
/*     */ 
/*     */   
/*     */   public b getName() {
/* 262 */     return this._cur.isAtLastPush() ? null : this._cur.getName();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\store\Validate.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */