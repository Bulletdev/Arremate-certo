/*     */ package com.sun.jna.platform.win32.COM;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.util.IDispatch;
/*     */ import com.sun.jna.platform.win32.OaIdl;
/*     */ import com.sun.jna.platform.win32.Variant;
/*     */ import com.sun.jna.ptr.PointerByReference;
/*     */ import java.io.Closeable;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IComEnumVariantIterator
/*     */   implements Closeable, Iterable<Variant.VARIANT>, Iterator<Variant.VARIANT>
/*     */ {
/*     */   private Variant.VARIANT nextValue;
/*     */   private EnumVariant backingIteration;
/*     */   
/*     */   public static IComEnumVariantIterator wrap(IDispatch paramIDispatch) {
/*  62 */     PointerByReference pointerByReference = new PointerByReference();
/*  63 */     IUnknown iUnknown = (IUnknown)paramIDispatch.getProperty(IUnknown.class, OaIdl.DISPID_NEWENUM, new Object[0]);
/*  64 */     iUnknown.QueryInterface(EnumVariant.REFIID, pointerByReference);
/*     */     
/*  66 */     iUnknown.Release();
/*  67 */     EnumVariant enumVariant = new EnumVariant(pointerByReference.getValue());
/*  68 */     return new IComEnumVariantIterator(enumVariant);
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
/*     */   public IComEnumVariantIterator(EnumVariant paramEnumVariant) {
/*  84 */     this.backingIteration = paramEnumVariant;
/*  85 */     retrieveNext();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/*  90 */     return (this.nextValue != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public Variant.VARIANT next() {
/*  95 */     Variant.VARIANT vARIANT = this.nextValue;
/*  96 */     retrieveNext();
/*  97 */     return vARIANT;
/*     */   }
/*     */   
/*     */   private void retrieveNext() {
/* 101 */     if (this.backingIteration == null) {
/*     */       return;
/*     */     }
/* 104 */     Variant.VARIANT[] arrayOfVARIANT = this.backingIteration.Next(1);
/* 105 */     if (arrayOfVARIANT.length == 0) {
/* 106 */       close();
/*     */     } else {
/* 108 */       this.nextValue = arrayOfVARIANT[0];
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 114 */     if (this.backingIteration != null) {
/* 115 */       this.nextValue = null;
/* 116 */       this.backingIteration.Release();
/* 117 */       this.backingIteration = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void finalize() throws Throwable {
/* 123 */     close();
/* 124 */     super.finalize();
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<Variant.VARIANT> iterator() {
/* 129 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove() {
/* 134 */     throw new UnsupportedOperationException("remove");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\IComEnumVariantIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */