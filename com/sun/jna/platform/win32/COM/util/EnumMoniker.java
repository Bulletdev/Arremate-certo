/*     */ package com.sun.jna.platform.win32.COM.util;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.COMUtils;
/*     */ import com.sun.jna.platform.win32.COM.Dispatch;
/*     */ import com.sun.jna.platform.win32.COM.IDispatch;
/*     */ import com.sun.jna.platform.win32.COM.IEnumMoniker;
/*     */ import com.sun.jna.platform.win32.COM.IRunningObjectTable;
/*     */ import com.sun.jna.platform.win32.COM.Moniker;
/*     */ import com.sun.jna.platform.win32.WinDef;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import com.sun.jna.ptr.PointerByReference;
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
/*     */ public class EnumMoniker
/*     */   implements Iterable<IDispatch>
/*     */ {
/*     */   ObjectFactory factory;
/*     */   IRunningObjectTable rawRot;
/*     */   IEnumMoniker raw;
/*     */   Moniker rawNext;
/*     */   
/*     */   protected EnumMoniker(IEnumMoniker paramIEnumMoniker, IRunningObjectTable paramIRunningObjectTable, ObjectFactory paramObjectFactory) {
/*  49 */     assert COMUtils.comIsInitialized() : "COM not initialized";
/*     */     
/*  51 */     this.rawRot = paramIRunningObjectTable;
/*  52 */     this.raw = paramIEnumMoniker;
/*  53 */     this.factory = paramObjectFactory;
/*     */     
/*  55 */     WinNT.HRESULT hRESULT = paramIEnumMoniker.Reset();
/*  56 */     COMUtils.checkRC(hRESULT);
/*     */     
/*  58 */     cacheNext();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void cacheNext() {
/*  67 */     assert COMUtils.comIsInitialized() : "COM not initialized";
/*  68 */     PointerByReference pointerByReference = new PointerByReference();
/*  69 */     WinDef.ULONGByReference uLONGByReference = new WinDef.ULONGByReference();
/*     */     
/*  71 */     WinNT.HRESULT hRESULT = this.raw.Next(new WinDef.ULONG(1L), pointerByReference, uLONGByReference);
/*     */     
/*  73 */     if (WinNT.S_OK.equals(hRESULT) && uLONGByReference.getValue().intValue() > 0) {
/*  74 */       this.rawNext = new Moniker(pointerByReference.getValue());
/*     */     } else {
/*  76 */       if (!WinNT.S_FALSE.equals(hRESULT)) {
/*  77 */         COMUtils.checkRC(hRESULT);
/*     */       }
/*  79 */       this.rawNext = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<IDispatch> iterator() {
/*  85 */     return new Iterator<IDispatch>()
/*     */       {
/*     */         public boolean hasNext()
/*     */         {
/*  89 */           return (null != EnumMoniker.this.rawNext);
/*     */         }
/*     */ 
/*     */         
/*     */         public IDispatch next() {
/*  94 */           assert COMUtils.comIsInitialized() : "COM not initialized";
/*     */           
/*  96 */           Moniker moniker = EnumMoniker.this.rawNext;
/*  97 */           PointerByReference pointerByReference = new PointerByReference();
/*  98 */           WinNT.HRESULT hRESULT = EnumMoniker.this.rawRot.GetObject(moniker.getPointer(), pointerByReference);
/*  99 */           COMUtils.checkRC(hRESULT);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 117 */           Dispatch dispatch = new Dispatch(pointerByReference.getValue());
/* 118 */           EnumMoniker.this.cacheNext();
/* 119 */           IDispatch iDispatch = EnumMoniker.this.factory.<IDispatch>createProxy(IDispatch.class, (IDispatch)dispatch);
/*     */           
/* 121 */           int i = dispatch.Release();
/* 122 */           return iDispatch;
/*     */         }
/*     */ 
/*     */         
/*     */         public void remove() {
/* 127 */           throw new UnsupportedOperationException("remove");
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\CO\\util\EnumMoniker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */