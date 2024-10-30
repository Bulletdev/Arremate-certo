/*     */ package com.sun.jna.platform.win32.COM;
/*     */ 
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.platform.win32.Guid;
/*     */ import com.sun.jna.platform.win32.Ole32;
/*     */ import com.sun.jna.platform.win32.WTypes;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import com.sun.jna.ptr.PointerByReference;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Moniker
/*     */   extends Unknown
/*     */   implements IMoniker
/*     */ {
/*     */   static final int vTableIdStart = 7;
/*     */   
/*     */   public static class ByReference
/*     */     extends Moniker
/*     */     implements Structure.ByReference {}
/*     */   
/*     */   public Moniker() {}
/*     */   
/*     */   public Moniker(Pointer paramPointer) {
/*  43 */     super(paramPointer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void BindToObject() {
/*  51 */     byte b = 8;
/*     */     
/*  53 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void BindToStorage() {
/*  58 */     byte b = 9;
/*     */     
/*  60 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void Reduce() {
/*  65 */     byte b = 10;
/*     */     
/*  67 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void ComposeWith() {
/*  72 */     byte b = 11;
/*     */     
/*  74 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void Enum() {
/*  79 */     byte b = 12;
/*     */     
/*  81 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void IsEqual() {
/*  86 */     byte b = 13;
/*     */     
/*  88 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void Hash() {
/*  93 */     byte b = 14;
/*     */     
/*  95 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void IsRunning() {
/* 100 */     byte b = 15;
/*     */     
/* 102 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void GetTimeOfLastChange() {
/* 107 */     byte b = 16;
/*     */     
/* 109 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void Inverse() {
/* 114 */     byte b = 17;
/*     */     
/* 116 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void CommonPrefixWith() {
/* 121 */     byte b = 18;
/*     */     
/* 123 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void RelativePathTo() {
/* 128 */     byte b = 19;
/*     */     
/* 130 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public String GetDisplayName(Pointer paramPointer1, Pointer paramPointer2) {
/* 135 */     byte b = 20;
/*     */     
/* 137 */     PointerByReference pointerByReference = new PointerByReference();
/*     */     
/* 139 */     WinNT.HRESULT hRESULT = (WinNT.HRESULT)_invokeNativeObject(20, new Object[] { getPointer(), paramPointer1, paramPointer2, pointerByReference }, WinNT.HRESULT.class);
/*     */ 
/*     */     
/* 142 */     COMUtils.checkRC(hRESULT);
/*     */     
/* 144 */     Pointer pointer = pointerByReference.getValue();
/* 145 */     if (pointer == null) {
/* 146 */       return null;
/*     */     }
/*     */     
/* 149 */     WTypes.LPOLESTR lPOLESTR = new WTypes.LPOLESTR(pointer);
/* 150 */     String str = lPOLESTR.getValue();
/* 151 */     Ole32.INSTANCE.CoTaskMemFree(pointer);
/*     */     
/* 153 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public void ParseDisplayName() {
/* 158 */     byte b = 21;
/*     */     
/* 160 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void IsSystemMoniker() {
/* 165 */     byte b = 22;
/*     */     
/* 167 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean IsDirty() {
/* 173 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void Load(IStream paramIStream) {
/* 178 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void Save(IStream paramIStream) {
/* 183 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void GetSizeMax() {
/* 188 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Guid.CLSID GetClassID() {
/* 193 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\Moniker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */