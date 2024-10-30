/*    */ package com.sun.jna.platform.win32.COM.util;
/*    */ 
/*    */ import com.sun.jna.platform.win32.COM.COMException;
/*    */ import com.sun.jna.platform.win32.COM.COMUtils;
/*    */ import com.sun.jna.platform.win32.COM.EnumMoniker;
/*    */ import com.sun.jna.platform.win32.COM.IEnumMoniker;
/*    */ import com.sun.jna.platform.win32.COM.IRunningObjectTable;
/*    */ import com.sun.jna.platform.win32.WinNT;
/*    */ import com.sun.jna.ptr.PointerByReference;
/*    */ import java.util.ArrayList;
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
/*    */ public class RunningObjectTable
/*    */   implements IRunningObjectTable
/*    */ {
/*    */   ObjectFactory factory;
/*    */   com.sun.jna.platform.win32.COM.RunningObjectTable raw;
/*    */   
/*    */   protected RunningObjectTable(com.sun.jna.platform.win32.COM.RunningObjectTable paramRunningObjectTable, ObjectFactory paramObjectFactory) {
/* 37 */     this.raw = paramRunningObjectTable;
/* 38 */     this.factory = paramObjectFactory;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Iterable<IDispatch> enumRunning() {
/* 46 */     assert COMUtils.comIsInitialized() : "COM not initialized";
/*    */     
/* 48 */     PointerByReference pointerByReference = new PointerByReference();
/*    */     
/* 50 */     WinNT.HRESULT hRESULT = this.raw.EnumRunning(pointerByReference);
/*    */     
/* 52 */     COMUtils.checkRC(hRESULT);
/*    */     
/* 54 */     EnumMoniker enumMoniker = new EnumMoniker(pointerByReference.getValue());
/*    */     
/* 56 */     return new EnumMoniker((IEnumMoniker)enumMoniker, (IRunningObjectTable)this.raw, this.factory);
/*    */   }
/*    */ 
/*    */   
/*    */   public <T> List<T> getActiveObjectsByInterface(Class<T> paramClass) {
/* 61 */     assert COMUtils.comIsInitialized() : "COM not initialized";
/*    */     
/* 63 */     ArrayList<T> arrayList = new ArrayList();
/*    */     
/* 65 */     for (IDispatch iDispatch : enumRunning()) {
/*    */       try {
/* 67 */         Object object = iDispatch.queryInterface((Class)paramClass);
/*    */         
/* 69 */         arrayList.add(object);
/* 70 */       } catch (COMException cOMException) {}
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 75 */     return arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\CO\\util\RunningObjectTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */