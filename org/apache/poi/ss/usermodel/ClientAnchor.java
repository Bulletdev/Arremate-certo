/*     */ package org.apache.poi.ss.usermodel;
/*     */ 
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.Removal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface ClientAnchor
/*     */ {
/*     */   @Removal(version = "3.17")
/*  40 */   public static final AnchorType MOVE_AND_RESIZE = AnchorType.MOVE_AND_RESIZE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Removal(version = "3.17")
/*  56 */   public static final AnchorType MOVE_DONT_RESIZE = AnchorType.MOVE_DONT_RESIZE;
/*     */   short getCol1();
/*     */   void setCol1(int paramInt);
/*     */   short getCol2();
/*     */   void setCol2(int paramInt);
/*     */   int getRow1();
/*     */   void setRow1(int paramInt);
/*     */   int getRow2();
/*     */   void setRow2(int paramInt);
/*     */   int getDx1();
/*     */   void setDx1(int paramInt);
/*     */   int getDy1();
/*     */   void setDy1(int paramInt);
/*     */   int getDy2();
/*     */   void setDy2(int paramInt);
/*     */   int getDx2();
/*     */   @Removal(version = "3.17")
/*  73 */   public static final AnchorType DONT_MOVE_AND_RESIZE = AnchorType.DONT_MOVE_AND_RESIZE;
/*     */ 
/*     */   
/*     */   void setDx2(int paramInt);
/*     */   
/*     */   void setAnchorType(AnchorType paramAnchorType);
/*     */   
/*     */   @Removal(version = "3.17")
/*     */   void setAnchorType(int paramInt);
/*     */   
/*     */   AnchorType getAnchorType();
/*     */   
/*     */   public enum AnchorType
/*     */   {
/*  87 */     MOVE_AND_RESIZE(0),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  97 */     DONT_MOVE_DO_RESIZE(1),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 111 */     MOVE_DONT_RESIZE(2),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 126 */     DONT_MOVE_AND_RESIZE(3);
/*     */     
/*     */     public final short value;
/*     */ 
/*     */     
/*     */     AnchorType(int param1Int1) {
/* 132 */       this.value = (short)param1Int1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Internal
/*     */     public static AnchorType byId(int param1Int) {
/* 143 */       return values()[param1Int];
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\ClientAnchor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */