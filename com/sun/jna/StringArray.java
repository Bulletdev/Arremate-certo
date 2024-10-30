/*    */ package com.sun.jna;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StringArray
/*    */   extends Memory
/*    */   implements Function.PostCallRead
/*    */ {
/*    */   private String encoding;
/* 37 */   private List<NativeString> natives = new ArrayList<NativeString>();
/*    */   private Object[] original;
/*    */   
/*    */   public StringArray(String[] paramArrayOfString) {
/* 41 */     this(paramArrayOfString, false);
/*    */   }
/*    */   
/*    */   public StringArray(String[] paramArrayOfString, boolean paramBoolean) {
/* 45 */     this((Object[])paramArrayOfString, paramBoolean ? "--WIDE-STRING--" : Native.getDefaultStringEncoding());
/*    */   }
/*    */   
/*    */   public StringArray(String[] paramArrayOfString, String paramString) {
/* 49 */     this((Object[])paramArrayOfString, paramString);
/*    */   }
/*    */   
/*    */   public StringArray(WString[] paramArrayOfWString) {
/* 53 */     this((Object[])paramArrayOfWString, "--WIDE-STRING--");
/*    */   }
/*    */   private StringArray(Object[] paramArrayOfObject, String paramString) {
/* 56 */     super(((paramArrayOfObject.length + 1) * Native.POINTER_SIZE));
/* 57 */     this.original = paramArrayOfObject;
/* 58 */     this.encoding = paramString;
/* 59 */     for (byte b = 0; b < paramArrayOfObject.length; b++) {
/* 60 */       Pointer pointer = null;
/* 61 */       if (paramArrayOfObject[b] != null) {
/* 62 */         NativeString nativeString = new NativeString(paramArrayOfObject[b].toString(), paramString);
/* 63 */         this.natives.add(nativeString);
/* 64 */         pointer = nativeString.getPointer();
/*    */       } 
/* 66 */       setPointer((Native.POINTER_SIZE * b), pointer);
/*    */     } 
/* 68 */     setPointer((Native.POINTER_SIZE * paramArrayOfObject.length), null);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read() {
/* 73 */     boolean bool1 = this.original instanceof WString[];
/* 74 */     boolean bool2 = "--WIDE-STRING--".equals(this.encoding);
/* 75 */     for (byte b = 0; b < this.original.length; b++) {
/* 76 */       WString wString; Pointer pointer = getPointer((b * Native.POINTER_SIZE));
/* 77 */       String str = null;
/* 78 */       if (pointer != null) {
/* 79 */         str = bool2 ? pointer.getWideString(0L) : pointer.getString(0L, this.encoding);
/* 80 */         if (bool1) wString = new WString(str); 
/*    */       } 
/* 82 */       this.original[b] = wString;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 88 */     boolean bool = "--WIDE-STRING--".equals(this.encoding);
/* 89 */     String str = bool ? "const wchar_t*[]" : "const char*[]";
/* 90 */     str = str + Arrays.<Object>asList(this.original);
/* 91 */     return str;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\StringArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */