/*     */ package org.apache.xmlbeans.impl.store;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.lang.ref.SoftReference;
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
/*     */ public final class CharUtil
/*     */ {
/*     */   public CharUtil(int paramInt) {
/* 912 */     this._charIter = new CharIterator();
/*     */     this._charBufSize = paramInt;
/*     */   }
/*     */   
/*     */   public CharIterator getCharIterator(Object paramObject, int paramInt1, int paramInt2) {
/*     */     this._charIter.init(paramObject, paramInt1, paramInt2);
/*     */     return this._charIter;
/*     */   }
/*     */   
/*     */   public CharIterator getCharIterator(Object paramObject, int paramInt1, int paramInt2, int paramInt3) {
/*     */     this._charIter.init(paramObject, paramInt1, paramInt2, paramInt3);
/*     */     return this._charIter;
/*     */   }
/*     */   
/*     */   public static CharUtil getThreadLocalCharUtil() {
/*     */     SoftReference softReference = tl_charUtil.get();
/*     */     CharUtil charUtil = softReference.get();
/*     */     if (charUtil == null) {
/*     */       charUtil = new CharUtil(CHARUTIL_INITIAL_BUFSIZE);
/*     */       tl_charUtil.set(new SoftReference(charUtil));
/*     */     } 
/*     */     return charUtil;
/*     */   }
/*     */   
/*     */   public static void getString(StringBuffer paramStringBuffer, Object paramObject, int paramInt1, int paramInt2) {
/*     */     assert isValid(paramObject, paramInt1, paramInt2);
/*     */     if (paramInt2 == 0)
/*     */       return; 
/*     */     if (paramObject instanceof char[]) {
/*     */       paramStringBuffer.append((char[])paramObject, paramInt1, paramInt2);
/*     */     } else if (paramObject instanceof String) {
/*     */       String str = (String)paramObject;
/*     */       if (paramInt1 == 0 && paramInt2 == str.length()) {
/*     */         paramStringBuffer.append((String)paramObject);
/*     */       } else {
/*     */         paramStringBuffer.append(str.substring(paramInt1, paramInt1 + paramInt2));
/*     */       } 
/*     */     } else {
/*     */       ((CharJoin)paramObject).getString(paramStringBuffer, paramInt1, paramInt2);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void getChars(char[] paramArrayOfchar, int paramInt1, Object paramObject, int paramInt2, int paramInt3) {
/*     */     assert isValid(paramObject, paramInt2, paramInt3);
/*     */     assert paramArrayOfchar != null && paramInt1 >= 0 && paramInt1 <= paramArrayOfchar.length;
/*     */     if (paramInt3 == 0)
/*     */       return; 
/*     */     if (paramObject instanceof char[]) {
/*     */       System.arraycopy(paramObject, paramInt2, paramArrayOfchar, paramInt1, paramInt3);
/*     */     } else if (paramObject instanceof String) {
/*     */       ((String)paramObject).getChars(paramInt2, paramInt2 + paramInt3, paramArrayOfchar, paramInt1);
/*     */     } else {
/*     */       ((CharJoin)paramObject).getChars(paramArrayOfchar, paramInt1, paramInt2, paramInt3);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String getString(Object paramObject, int paramInt1, int paramInt2) {
/*     */     assert isValid(paramObject, paramInt1, paramInt2);
/*     */     if (paramInt2 == 0)
/*     */       return ""; 
/*     */     if (paramObject instanceof char[])
/*     */       return new String((char[])paramObject, paramInt1, paramInt2); 
/*     */     if (paramObject instanceof String) {
/*     */       String str = (String)paramObject;
/*     */       if (paramInt1 == 0 && paramInt2 == str.length())
/*     */         return str; 
/*     */       return str.substring(paramInt1, paramInt1 + paramInt2);
/*     */     } 
/*     */     StringBuffer stringBuffer = new StringBuffer();
/*     */     ((CharJoin)paramObject).getString(stringBuffer, paramInt1, paramInt2);
/*     */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public static final boolean isWhiteSpace(char paramChar) {
/*     */     switch (paramChar) {
/*     */       case '\t':
/*     */       case '\n':
/*     */       case '\r':
/*     */       case ' ':
/*     */         return true;
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public final boolean isWhiteSpace(Object paramObject, int paramInt1, int paramInt2) {
/*     */     assert isValid(paramObject, paramInt1, paramInt2);
/*     */     if (paramInt2 <= 0)
/*     */       return true; 
/*     */     if (paramObject instanceof char[]) {
/*     */       for (char[] arrayOfChar = (char[])paramObject; paramInt2 > 0; paramInt2--) {
/*     */         if (!isWhiteSpace(arrayOfChar[paramInt1++]))
/*     */           return false; 
/*     */       } 
/*     */       return true;
/*     */     } 
/*     */     if (paramObject instanceof String) {
/*     */       for (String str = (String)paramObject; paramInt2 > 0; paramInt2--) {
/*     */         if (!isWhiteSpace(str.charAt(paramInt1++)))
/*     */           return false; 
/*     */       } 
/*     */       return true;
/*     */     } 
/*     */     boolean bool = true;
/*     */     this._charIter.init(paramObject, paramInt1, paramInt2);
/*     */     while (this._charIter.hasNext()) {
/*     */       if (!isWhiteSpace(this._charIter.next())) {
/*     */         bool = false;
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     this._charIter.release();
/*     */     return bool;
/*     */   }
/*     */   
/*     */   public Object stripLeft(Object paramObject, int paramInt1, int paramInt2) {
/*     */     assert isValid(paramObject, paramInt1, paramInt2);
/*     */     if (paramInt2 > 0)
/*     */       if (paramObject instanceof char[]) {
/*     */         char[] arrayOfChar = (char[])paramObject;
/*     */         while (paramInt2 > 0 && isWhiteSpace(arrayOfChar[paramInt1])) {
/*     */           paramInt2--;
/*     */           paramInt1++;
/*     */         } 
/*     */       } else if (paramObject instanceof String) {
/*     */         String str = (String)paramObject;
/*     */         while (paramInt2 > 0 && isWhiteSpace(str.charAt(paramInt1))) {
/*     */           paramInt2--;
/*     */           paramInt1++;
/*     */         } 
/*     */       } else {
/*     */         byte b = 0;
/*     */         this._charIter.init(paramObject, paramInt1, paramInt2);
/*     */         for (; this._charIter.hasNext() && isWhiteSpace(this._charIter.next()); b++);
/*     */         this._charIter.release();
/*     */         paramInt1 += b;
/*     */       }  
/*     */     if (paramInt2 == 0) {
/*     */       this._offSrc = 0;
/*     */       this._cchSrc = 0;
/*     */       return null;
/*     */     } 
/*     */     this._offSrc = paramInt1;
/*     */     this._cchSrc = paramInt2;
/*     */     return paramObject;
/*     */   }
/*     */   
/*     */   public Object stripRight(Object paramObject, int paramInt1, int paramInt2) {
/*     */     assert isValid(paramObject, paramInt1, paramInt2);
/*     */     if (paramInt2 > 0) {
/*     */       this._charIter.init(paramObject, paramInt1, paramInt2, paramInt2);
/*     */       for (; this._charIter.hasPrev() && isWhiteSpace(this._charIter.prev()); paramInt2--);
/*     */       this._charIter.release();
/*     */     } 
/*     */     if (paramInt2 == 0) {
/*     */       this._offSrc = 0;
/*     */       this._cchSrc = 0;
/*     */       return null;
/*     */     } 
/*     */     this._offSrc = paramInt1;
/*     */     this._cchSrc = paramInt2;
/*     */     return paramObject;
/*     */   }
/*     */   
/*     */   public Object insertChars(int paramInt1, Object paramObject1, int paramInt2, int paramInt3, Object paramObject2, int paramInt4, int paramInt5) {
/*     */     Object object;
/*     */     assert isValid(paramObject1, paramInt2, paramInt3);
/*     */     assert isValid(paramObject2, paramInt4, paramInt5);
/*     */     assert paramInt1 >= 0 && paramInt1 <= paramInt3;
/*     */     if (paramInt5 == 0) {
/*     */       this._cchSrc = paramInt3;
/*     */       this._offSrc = paramInt2;
/*     */       return paramObject1;
/*     */     } 
/*     */     if (paramInt3 == 0) {
/*     */       this._cchSrc = paramInt5;
/*     */       this._offSrc = paramInt4;
/*     */       return paramObject2;
/*     */     } 
/*     */     this._cchSrc = paramInt3 + paramInt5;
/*     */     if (this._cchSrc <= 64 && canAllocate(this._cchSrc)) {
/*     */       char[] arrayOfChar2 = allocate(this._cchSrc);
/*     */       getChars(arrayOfChar2, this._offSrc, paramObject1, paramInt2, paramInt1);
/*     */       getChars(arrayOfChar2, this._offSrc + paramInt1, paramObject2, paramInt4, paramInt5);
/*     */       getChars(arrayOfChar2, this._offSrc + paramInt1 + paramInt5, paramObject1, paramInt2 + paramInt1, paramInt3 - paramInt1);
/*     */       char[] arrayOfChar1 = arrayOfChar2;
/*     */     } else {
/*     */       CharJoin charJoin;
/*     */       this._offSrc = 0;
/*     */       if (paramInt1 == 0) {
/*     */         charJoin = new CharJoin(paramObject2, paramInt4, paramInt5, paramObject1, paramInt2);
/*     */       } else if (paramInt1 == paramInt3) {
/*     */         charJoin = new CharJoin(paramObject1, paramInt2, paramInt3, paramObject2, paramInt4);
/*     */       } else {
/*     */         CharJoin charJoin1 = new CharJoin(paramObject1, paramInt2, paramInt1, paramObject2, paramInt4);
/*     */         charJoin = new CharJoin(charJoin1, 0, paramInt1 + paramInt5, paramObject1, paramInt2 + paramInt1);
/*     */       } 
/*     */       if (charJoin._depth > 64) {
/*     */         object = saveChars(charJoin, this._offSrc, this._cchSrc);
/*     */       } else {
/*     */         object = charJoin;
/*     */       } 
/*     */     } 
/*     */     assert isValid(object, this._offSrc, this._cchSrc);
/*     */     return object;
/*     */   }
/*     */   
/*     */   public Object removeChars(int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4) {
/*     */     Object object;
/*     */     assert isValid(paramObject, paramInt3, paramInt4);
/*     */     assert paramInt1 >= 0 && paramInt1 <= paramInt4;
/*     */     assert paramInt2 >= 0 && paramInt1 + paramInt2 <= paramInt4;
/*     */     this._cchSrc = paramInt4 - paramInt2;
/*     */     if (this._cchSrc == 0) {
/*     */       object = null;
/*     */       this._offSrc = 0;
/*     */     } else if (paramInt1 == 0) {
/*     */       object = paramObject;
/*     */       this._offSrc = paramInt3 + paramInt2;
/*     */     } else if (paramInt1 + paramInt2 == paramInt4) {
/*     */       object = paramObject;
/*     */       this._offSrc = paramInt3;
/*     */     } else {
/*     */       int i = paramInt4 - paramInt2;
/*     */       if (i <= 64 && canAllocate(i)) {
/*     */         char[] arrayOfChar = allocate(i);
/*     */         getChars(arrayOfChar, this._offSrc, paramObject, paramInt3, paramInt1);
/*     */         getChars(arrayOfChar, this._offSrc + paramInt1, paramObject, paramInt3 + paramInt1 + paramInt2, paramInt4 - paramInt1 - paramInt2);
/*     */         object = arrayOfChar;
/*     */         this._offSrc = this._offSrc;
/*     */       } else {
/*     */         CharJoin charJoin = new CharJoin(paramObject, paramInt3, paramInt1, paramObject, paramInt3 + paramInt1 + paramInt2);
/*     */         if (charJoin._depth > 64) {
/*     */           object = saveChars(charJoin, 0, this._cchSrc);
/*     */         } else {
/*     */           object = charJoin;
/*     */           this._offSrc = 0;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     assert isValid(object, this._offSrc, this._cchSrc);
/*     */     return object;
/*     */   }
/*     */   
/*     */   private static int sizeof(Object paramObject) {
/*     */     assert paramObject == null || paramObject instanceof String || paramObject instanceof char[];
/*     */     if (paramObject instanceof char[])
/*     */       return ((char[])paramObject).length; 
/*     */     return (paramObject == null) ? 0 : ((String)paramObject).length();
/*     */   }
/*     */   
/*     */   private boolean canAllocate(int paramInt) {
/*     */     return (this._currentBuffer == null || this._currentBuffer.length - this._currentOffset >= paramInt);
/*     */   }
/*     */   
/*     */   private char[] allocate(int paramInt) {
/*     */     assert this._currentBuffer == null || this._currentBuffer.length - this._currentOffset > 0;
/*     */     if (this._currentBuffer == null) {
/*     */       this._currentBuffer = new char[Math.max(paramInt, this._charBufSize)];
/*     */       this._currentOffset = 0;
/*     */     } 
/*     */     this._offSrc = this._currentOffset;
/*     */     this._cchSrc = Math.min(this._currentBuffer.length - this._currentOffset, paramInt);
/*     */     char[] arrayOfChar = this._currentBuffer;
/*     */     assert this._currentOffset + this._cchSrc <= this._currentBuffer.length;
/*     */     if ((this._currentOffset += this._cchSrc) == this._currentBuffer.length) {
/*     */       this._currentBuffer = null;
/*     */       this._currentOffset = 0;
/*     */     } 
/*     */     return arrayOfChar;
/*     */   }
/*     */   
/*     */   public Object saveChars(Object paramObject, int paramInt1, int paramInt2) {
/*     */     return saveChars(paramObject, paramInt1, paramInt2, null, 0, 0);
/*     */   }
/*     */   
/*     */   public Object saveChars(Object paramObject1, int paramInt1, int paramInt2, Object paramObject2, int paramInt3, int paramInt4) {
/*     */     Object object;
/*     */     boolean bool;
/*     */     assert isValid(paramObject1, paramInt1, paramInt2);
/*     */     assert isValid(paramObject2, paramInt3, paramInt4);
/*     */     char[] arrayOfChar = allocate(paramInt2);
/*     */     int i = this._offSrc;
/*     */     int j = this._cchSrc;
/*     */     assert j <= paramInt2;
/*     */     getChars(arrayOfChar, i, paramObject1, paramInt1, j);
/*     */     int k = j + paramInt4;
/*     */     if (paramInt4 == 0) {
/*     */       object = arrayOfChar;
/*     */       bool = i;
/*     */     } else if (paramObject2 == arrayOfChar && paramInt3 + paramInt4 == i) {
/*     */       assert paramObject2 instanceof char[];
/*     */       object = paramObject2;
/*     */       bool = paramInt3;
/*     */     } else {
/*     */       CharJoin charJoin;
/*     */       if (paramObject2 instanceof CharJoin && (charJoin = (CharJoin)paramObject2)._srcRight == arrayOfChar && paramInt3 + paramInt4 - charJoin._cchLeft + charJoin._offRight == i) {
/*     */         assert charJoin._srcRight instanceof char[];
/*     */         object = paramObject2;
/*     */         bool = paramInt3;
/*     */       } else {
/*     */         charJoin = new CharJoin(paramObject2, paramInt3, paramInt4, arrayOfChar, i);
/*     */         CharJoin charJoin1 = charJoin;
/*     */         bool = false;
/*     */         object = (charJoin._depth > 64) ? saveChars(charJoin, 0, k) : charJoin;
/*     */       } 
/*     */     } 
/*     */     int m = paramInt2 - j;
/*     */     if (m > 0) {
/*     */       arrayOfChar = allocate(m);
/*     */       i = this._offSrc;
/*     */       j = this._cchSrc;
/*     */       assert j == m;
/*     */       assert i == 0;
/*     */       getChars(arrayOfChar, i, paramObject1, paramInt1 + paramInt2 - m, m);
/*     */       CharJoin charJoin = new CharJoin(object, bool, k, arrayOfChar, i);
/*     */       bool = false;
/*     */       k += m;
/*     */       object = (charJoin._depth > 64) ? saveChars(charJoin, 0, k) : charJoin;
/*     */     } 
/*     */     this._offSrc = bool;
/*     */     this._cchSrc = k;
/*     */     assert isValid(object, this._offSrc, this._cchSrc);
/*     */     return object;
/*     */   }
/*     */   
/*     */   private static void dumpText(PrintStream paramPrintStream, String paramString) {
/*     */     paramPrintStream.print("\"");
/*     */     for (byte b = 0; b < paramString.length(); b++) {
/*     */       char c = paramString.charAt(b);
/*     */       if (b == 36) {
/*     */         paramPrintStream.print("...");
/*     */         break;
/*     */       } 
/*     */       if (c == '\n') {
/*     */         paramPrintStream.print("\\n");
/*     */       } else if (c == '\r') {
/*     */         paramPrintStream.print("\\r");
/*     */       } else if (c == '\t') {
/*     */         paramPrintStream.print("\\t");
/*     */       } else if (c == '\f') {
/*     */         paramPrintStream.print("\\f");
/*     */       } else if (c == '\f') {
/*     */         paramPrintStream.print("\\f");
/*     */       } else if (c == '"') {
/*     */         paramPrintStream.print("\\\"");
/*     */       } else {
/*     */         paramPrintStream.print(c);
/*     */       } 
/*     */     } 
/*     */     paramPrintStream.print("\"");
/*     */   }
/*     */   
/*     */   public static void dump(Object paramObject, int paramInt1, int paramInt2) {
/*     */     dumpChars(System.out, paramObject, paramInt1, paramInt2);
/*     */     System.out.println();
/*     */   }
/*     */   
/*     */   public static void dumpChars(PrintStream paramPrintStream, Object paramObject, int paramInt1, int paramInt2) {
/*     */     paramPrintStream.print("off=" + paramInt1 + ", cch=" + paramInt2 + ", ");
/*     */     if (paramObject == null) {
/*     */       paramPrintStream.print("<null-src>");
/*     */     } else if (paramObject instanceof String) {
/*     */       String str = (String)paramObject;
/*     */       paramPrintStream.print("String");
/*     */       if (paramInt1 != 0 || paramInt2 != str.length())
/*     */         if (paramInt1 < 0 || paramInt1 > str.length() || paramInt1 + paramInt2 < 0 || paramInt1 + paramInt2 > str.length()) {
/*     */           paramPrintStream.print(" (Error)");
/*     */           return;
/*     */         }  
/*     */       dumpText(paramPrintStream, str.substring(paramInt1, paramInt1 + paramInt2));
/*     */     } else if (paramObject instanceof char[]) {
/*     */       char[] arrayOfChar = (char[])paramObject;
/*     */       paramPrintStream.print("char[]");
/*     */       if (paramInt1 != 0 || paramInt2 != arrayOfChar.length)
/*     */         if (paramInt1 < 0 || paramInt1 > arrayOfChar.length || paramInt1 + paramInt2 < 0 || paramInt1 + paramInt2 > arrayOfChar.length) {
/*     */           paramPrintStream.print(" (Error)");
/*     */           return;
/*     */         }  
/*     */       dumpText(paramPrintStream, new String(arrayOfChar, paramInt1, paramInt2));
/*     */     } else if (paramObject instanceof CharJoin) {
/*     */       paramPrintStream.print("CharJoin");
/*     */       ((CharJoin)paramObject).dumpChars(paramPrintStream, paramInt1, paramInt2);
/*     */     } else {
/*     */       paramPrintStream.print("Unknown text source");
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean isValid(Object paramObject, int paramInt1, int paramInt2) {
/*     */     if (paramInt2 < 0 || paramInt1 < 0)
/*     */       return false; 
/*     */     if (paramObject == null)
/*     */       return (paramInt1 == 0 && paramInt2 == 0); 
/*     */     if (paramObject instanceof char[]) {
/*     */       char[] arrayOfChar = (char[])paramObject;
/*     */       return (paramInt1 <= arrayOfChar.length && paramInt1 + paramInt2 <= arrayOfChar.length);
/*     */     } 
/*     */     if (paramObject instanceof String) {
/*     */       String str = (String)paramObject;
/*     */       return (paramInt1 <= str.length() && paramInt1 + paramInt2 <= str.length());
/*     */     } 
/*     */     if (paramObject instanceof CharJoin)
/*     */       return ((CharJoin)paramObject).isValid(paramInt1, paramInt2); 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public static final class CharJoin {
/*     */     public final Object _srcLeft;
/*     */     public final int _offLeft;
/*     */     public final int _cchLeft;
/*     */     public final Object _srcRight;
/*     */     public final int _offRight;
/*     */     public final int _depth;
/*     */     static final int MAX_DEPTH = 64;
/*     */     static final boolean $assertionsDisabled;
/*     */     
/*     */     public CharJoin(Object param1Object1, int param1Int1, int param1Int2, Object param1Object2, int param1Int3) {
/*     */       this._srcLeft = param1Object1;
/*     */       this._offLeft = param1Int1;
/*     */       this._cchLeft = param1Int2;
/*     */       this._srcRight = param1Object2;
/*     */       this._offRight = param1Int3;
/*     */       int i = 0;
/*     */       if (param1Object1 instanceof CharJoin)
/*     */         i = ((CharJoin)param1Object1)._depth; 
/*     */       if (param1Object2 instanceof CharJoin) {
/*     */         int j = ((CharJoin)param1Object2)._depth;
/*     */         if (j > i)
/*     */           i = j; 
/*     */       } 
/*     */       this._depth = i + 1;
/*     */       assert this._depth <= 66;
/*     */     }
/*     */     
/*     */     private int cchRight(int param1Int1, int param1Int2) {
/*     */       return Math.max(0, param1Int2 - this._cchLeft - param1Int1);
/*     */     }
/*     */     
/*     */     public int depth() {
/*     */       int i = 0;
/*     */       if (this._srcLeft instanceof CharJoin)
/*     */         i = ((CharJoin)this._srcLeft).depth(); 
/*     */       if (this._srcRight instanceof CharJoin)
/*     */         i = Math.max(((CharJoin)this._srcRight).depth(), i); 
/*     */       return i + 1;
/*     */     }
/*     */     
/*     */     public boolean isValid(int param1Int1, int param1Int2) {
/*     */       if (this._depth > 2)
/*     */         return true; 
/*     */       assert this._depth == depth();
/*     */       if (param1Int1 < 0 || param1Int2 < 0)
/*     */         return false; 
/*     */       if (!CharUtil.isValid(this._srcLeft, this._offLeft, this._cchLeft))
/*     */         return false; 
/*     */       if (!CharUtil.isValid(this._srcRight, this._offRight, cchRight(param1Int1, param1Int2)))
/*     */         return false; 
/*     */       return true;
/*     */     }
/*     */     
/*     */     private void getString(StringBuffer param1StringBuffer, int param1Int1, int param1Int2) {
/*     */       assert param1Int2 > 0;
/*     */       if (param1Int1 < this._cchLeft) {
/*     */         int i = Math.min(this._cchLeft - param1Int1, param1Int2);
/*     */         CharUtil.getString(param1StringBuffer, this._srcLeft, this._offLeft + param1Int1, i);
/*     */         if (param1Int2 > i)
/*     */           CharUtil.getString(param1StringBuffer, this._srcRight, this._offRight, param1Int2 - i); 
/*     */       } else {
/*     */         CharUtil.getString(param1StringBuffer, this._srcRight, this._offRight + param1Int1 - this._cchLeft, param1Int2);
/*     */       } 
/*     */     }
/*     */     
/*     */     private void getChars(char[] param1ArrayOfchar, int param1Int1, int param1Int2, int param1Int3) {
/*     */       assert param1Int3 > 0;
/*     */       if (param1Int2 < this._cchLeft) {
/*     */         int i = Math.min(this._cchLeft - param1Int2, param1Int3);
/*     */         CharUtil.getChars(param1ArrayOfchar, param1Int1, this._srcLeft, this._offLeft + param1Int2, i);
/*     */         if (param1Int3 > i)
/*     */           CharUtil.getChars(param1ArrayOfchar, param1Int1 + i, this._srcRight, this._offRight, param1Int3 - i); 
/*     */       } else {
/*     */         CharUtil.getChars(param1ArrayOfchar, param1Int1, this._srcRight, this._offRight + param1Int2 - this._cchLeft, param1Int3);
/*     */       } 
/*     */     }
/*     */     
/*     */     private void dumpChars(int param1Int1, int param1Int2) {
/*     */       dumpChars(System.out, param1Int1, param1Int2);
/*     */     }
/*     */     
/*     */     private void dumpChars(PrintStream param1PrintStream, int param1Int1, int param1Int2) {
/*     */       param1PrintStream.print("( ");
/*     */       CharUtil.dumpChars(param1PrintStream, this._srcLeft, this._offLeft, this._cchLeft);
/*     */       param1PrintStream.print(", ");
/*     */       CharUtil.dumpChars(param1PrintStream, this._srcRight, this._offRight, cchRight(param1Int1, param1Int2));
/*     */       param1PrintStream.print(" )");
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class CharIterator {
/*     */     private Object _srcRoot;
/*     */     private int _offRoot;
/*     */     private int _cchRoot;
/*     */     private int _pos;
/*     */     private int _minPos;
/*     */     private int _maxPos;
/*     */     private int _offLeaf;
/*     */     private String _srcLeafString;
/*     */     private char[] _srcLeafChars;
/*     */     static final boolean $assertionsDisabled;
/*     */     
/*     */     public void init(Object param1Object, int param1Int1, int param1Int2) {
/*     */       init(param1Object, param1Int1, param1Int2, 0);
/*     */     }
/*     */     
/*     */     public void init(Object param1Object, int param1Int1, int param1Int2, int param1Int3) {
/*     */       assert CharUtil.isValid(param1Object, param1Int1, param1Int2);
/*     */       release();
/*     */       this._srcRoot = param1Object;
/*     */       this._offRoot = param1Int1;
/*     */       this._cchRoot = param1Int2;
/*     */       this._minPos = this._maxPos = -1;
/*     */       movePos(param1Int3);
/*     */     }
/*     */     
/*     */     public void release() {
/*     */       this._srcRoot = null;
/*     */       this._srcLeafString = null;
/*     */       this._srcLeafChars = null;
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/*     */       return (this._pos < this._cchRoot);
/*     */     }
/*     */     
/*     */     public boolean hasPrev() {
/*     */       return (this._pos > 0);
/*     */     }
/*     */     
/*     */     public char next() {
/*     */       assert hasNext();
/*     */       char c = currentChar();
/*     */       movePos(this._pos + 1);
/*     */       return c;
/*     */     }
/*     */     
/*     */     public char prev() {
/*     */       assert hasPrev();
/*     */       movePos(this._pos - 1);
/*     */       return currentChar();
/*     */     }
/*     */     
/*     */     public void movePos(int param1Int) {
/*     */       assert param1Int >= 0 && param1Int <= this._cchRoot;
/*     */       if (param1Int < this._minPos || param1Int > this._maxPos) {
/*     */         Object object = this._srcRoot;
/*     */         int i = this._offRoot + param1Int;
/*     */         int j = this._cchRoot;
/*     */         for (this._offLeaf = this._offRoot; object instanceof CharUtil.CharJoin; ) {
/*     */           CharUtil.CharJoin charJoin = (CharUtil.CharJoin)object;
/*     */           if (i < charJoin._cchLeft) {
/*     */             object = charJoin._srcLeft;
/*     */             this._offLeaf = charJoin._offLeft;
/*     */             i += charJoin._offLeft;
/*     */             j = charJoin._cchLeft;
/*     */             continue;
/*     */           } 
/*     */           object = charJoin._srcRight;
/*     */           this._offLeaf = charJoin._offRight;
/*     */           i -= charJoin._cchLeft - charJoin._offRight;
/*     */           j -= charJoin._cchLeft;
/*     */         } 
/*     */         this._minPos = param1Int - i - this._offLeaf;
/*     */         this._maxPos = this._minPos + j;
/*     */         if (param1Int < this._cchRoot)
/*     */           this._maxPos--; 
/*     */         this._srcLeafChars = null;
/*     */         this._srcLeafString = null;
/*     */         if (object instanceof char[]) {
/*     */           this._srcLeafChars = (char[])object;
/*     */         } else {
/*     */           this._srcLeafString = (String)object;
/*     */         } 
/*     */         assert param1Int >= this._minPos && param1Int <= this._maxPos;
/*     */       } 
/*     */       this._pos = param1Int;
/*     */     }
/*     */     
/*     */     private char currentChar() {
/*     */       int i = this._offLeaf + this._pos - this._minPos;
/*     */       return (this._srcLeafChars == null) ? this._srcLeafString.charAt(i) : this._srcLeafChars[i];
/*     */     }
/*     */   }
/*     */   private static int CHARUTIL_INITIAL_BUFSIZE = 32768;
/*     */   
/*     */   private static ThreadLocal tl_charUtil = new ThreadLocal() {
/*     */       protected Object initialValue() {
/*     */         return new SoftReference(new CharUtil(CharUtil.CHARUTIL_INITIAL_BUFSIZE));
/*     */       }
/*     */     };
/*     */   
/*     */   private CharIterator _charIter;
/*     */   private static final int MAX_COPY = 64;
/*     */   private int _charBufSize;
/*     */   private int _currentOffset;
/*     */   private char[] _currentBuffer;
/*     */   public int _offSrc;
/*     */   public int _cchSrc;
/*     */   static final boolean $assertionsDisabled;
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\store\CharUtil.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */