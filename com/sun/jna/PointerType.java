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
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class PointerType
/*     */   implements NativeMapped
/*     */ {
/*     */   private Pointer pointer;
/*     */   
/*     */   protected PointerType() {
/*  38 */     this.pointer = Pointer.NULL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected PointerType(Pointer paramPointer) {
/*  45 */     this.pointer = paramPointer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> nativeType() {
/*  51 */     return Pointer.class;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object toNative() {
/*  57 */     return getPointer();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Pointer getPointer() {
/*  64 */     return this.pointer;
/*     */   }
/*     */   
/*     */   public void setPointer(Pointer paramPointer) {
/*  68 */     this.pointer = paramPointer;
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
/*     */   public Object fromNative(Object paramObject, FromNativeContext paramFromNativeContext) {
/*  80 */     if (paramObject == null) {
/*  81 */       return null;
/*     */     }
/*  83 */     PointerType pointerType = (PointerType)Klass.newInstance(getClass());
/*  84 */     pointerType.pointer = (Pointer)paramObject;
/*  85 */     return pointerType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  93 */     return (this.pointer != null) ? this.pointer.hashCode() : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 101 */     if (paramObject == this) {
/* 102 */       return true;
/*     */     }
/* 104 */     if (paramObject instanceof PointerType) {
/* 105 */       Pointer pointer = ((PointerType)paramObject).getPointer();
/* 106 */       if (this.pointer == null) {
/* 107 */         return (pointer == null);
/*     */       }
/* 109 */       return this.pointer.equals(pointer);
/*     */     } 
/* 111 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 116 */     return (this.pointer == null) ? "NULL" : (this.pointer.toString() + " (" + super.toString() + ")");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\PointerType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */