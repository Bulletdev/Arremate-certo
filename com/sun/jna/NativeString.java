/*     */ package com.sun.jna;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class NativeString
/*     */   implements CharSequence, Comparable
/*     */ {
/*     */   static final String WIDE_STRING = "--WIDE-STRING--";
/*     */   private Pointer pointer;
/*     */   private String encoding;
/*     */   
/*     */   private class StringMemory
/*     */     extends Memory
/*     */   {
/*     */     public StringMemory(long param1Long) {
/*  40 */       super(param1Long);
/*     */     }
/*     */     public String toString() {
/*  43 */       return NativeString.this.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NativeString(String paramString) {
/*  51 */     this(paramString, Native.getDefaultStringEncoding());
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
/*     */   public NativeString(String paramString, boolean paramBoolean) {
/*  63 */     this(paramString, paramBoolean ? "--WIDE-STRING--" : Native.getDefaultStringEncoding());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NativeString(WString paramWString) {
/*  70 */     this(paramWString.toString(), "--WIDE-STRING--");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NativeString(String paramString1, String paramString2) {
/*  77 */     if (paramString1 == null) {
/*  78 */       throw new NullPointerException("String must not be null");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  83 */     this.encoding = paramString2;
/*  84 */     if ("--WIDE-STRING--".equals(this.encoding)) {
/*  85 */       int i = (paramString1.length() + 1) * Native.WCHAR_SIZE;
/*  86 */       this.pointer = new StringMemory(i);
/*  87 */       this.pointer.setWideString(0L, paramString1);
/*     */     } else {
/*  89 */       byte[] arrayOfByte = Native.getBytes(paramString1, paramString2);
/*  90 */       this.pointer = new StringMemory((arrayOfByte.length + 1));
/*  91 */       this.pointer.write(0L, arrayOfByte, 0, arrayOfByte.length);
/*  92 */       this.pointer.setByte(arrayOfByte.length, (byte)0);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  98 */     return toString().hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 103 */     if (paramObject instanceof CharSequence) {
/* 104 */       return (compareTo(paramObject) == 0);
/*     */     }
/* 106 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 111 */     boolean bool = "--WIDE-STRING--".equals(this.encoding);
/* 112 */     return bool ? this.pointer.getWideString(0L) : this.pointer.getString(0L, this.encoding);
/*     */   }
/*     */   
/*     */   public Pointer getPointer() {
/* 116 */     return this.pointer;
/*     */   }
/*     */ 
/*     */   
/*     */   public char charAt(int paramInt) {
/* 121 */     return toString().charAt(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int length() {
/* 126 */     return toString().length();
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence subSequence(int paramInt1, int paramInt2) {
/* 131 */     return toString().subSequence(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(Object paramObject) {
/* 136 */     if (paramObject == null) {
/* 137 */       return 1;
/*     */     }
/* 139 */     return toString().compareTo(paramObject.toString());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\NativeString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */