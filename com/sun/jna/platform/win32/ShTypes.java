/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.Structure;
/*    */ import com.sun.jna.Structure.FieldOrder;
/*    */ import com.sun.jna.Union;
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
/*    */ public interface ShTypes
/*    */ {
/*    */   @FieldOrder({"uType", "u"})
/*    */   public static class STRRET
/*    */     extends Structure
/*    */   {
/*    */     public static final int TYPE_WSTR = 0;
/*    */     public static final int TYPE_OFFSET = 1;
/*    */     public static final int TYPE_CSTR = 2;
/*    */     public int uType;
/*    */     public UNION u;
/*    */     
/*    */     public static class UNION
/*    */       extends Union
/*    */     {
/*    */       public WTypes.LPWSTR pOleStr;
/*    */       public int uOffset;
/*    */       
/*    */       public static class ByReference
/*    */         extends UNION
/*    */         implements Structure.ByReference {}
/*    */       
/* 52 */       public byte[] cStr = new byte[260];
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public STRRET() {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public STRRET(Pointer param1Pointer) {
/* 72 */       super(param1Pointer);
/* 73 */       read();
/*    */     }
/*    */ 
/*    */     
/*    */     public void read() {
/* 78 */       super.read();
/* 79 */       switch (this.uType) {
/*    */         
/*    */         default:
/* 82 */           this.u.setType("pOleStr");
/*    */           break;
/*    */         case 1:
/* 85 */           this.u.setType("uOffset");
/*    */           break;
/*    */         case 2:
/* 88 */           this.u.setType("cStr");
/*    */           break;
/*    */       } 
/* 91 */       this.u.read();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\ShTypes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */