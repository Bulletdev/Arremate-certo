/*    */ package org.apache.poi.ss.usermodel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IconMultiStateFormatting
/*    */ {
/*    */   IconSet getIconSet();
/*    */   
/*    */   void setIconSet(IconSet paramIconSet);
/*    */   
/*    */   boolean isIconOnly();
/*    */   
/*    */   void setIconOnly(boolean paramBoolean);
/*    */   
/*    */   boolean isReversed();
/*    */   
/*    */   void setReversed(boolean paramBoolean);
/*    */   
/*    */   ConditionalFormattingThreshold[] getThresholds();
/*    */   
/*    */   void setThresholds(ConditionalFormattingThreshold[] paramArrayOfConditionalFormattingThreshold);
/*    */   
/*    */   ConditionalFormattingThreshold createThreshold();
/*    */   
/*    */   public enum IconSet
/*    */   {
/* 29 */     GYR_3_ARROW(0, 3, "3Arrows"),
/*    */     
/* 31 */     GREY_3_ARROWS(1, 3, "3ArrowsGray"),
/*    */     
/* 33 */     GYR_3_FLAGS(2, 3, "3Flags"),
/*    */     
/* 35 */     GYR_3_TRAFFIC_LIGHTS(3, 3, "3TrafficLights1"),
/*    */ 
/*    */     
/* 38 */     GYR_3_TRAFFIC_LIGHTS_BOX(4, 3, "3TrafficLights2"),
/*    */ 
/*    */     
/* 41 */     GYR_3_SHAPES(5, 3, "3Signs"),
/*    */     
/* 43 */     GYR_3_SYMBOLS_CIRCLE(6, 3, "3Symbols"),
/*    */     
/* 45 */     GYR_3_SYMBOLS(7, 3, "3Symbols2"),
/*    */     
/* 47 */     GYR_4_ARROWS(8, 4, "4Arrows"),
/*    */     
/* 49 */     GREY_4_ARROWS(9, 4, "4ArrowsGray"),
/*    */     
/* 51 */     RB_4_TRAFFIC_LIGHTS(10, 4, "4RedToBlack"),
/* 52 */     RATINGS_4(11, 4, "4Rating"),
/*    */     
/* 54 */     GYRB_4_TRAFFIC_LIGHTS(12, 4, "4TrafficLights"),
/* 55 */     GYYYR_5_ARROWS(13, 5, "5Arrows"),
/* 56 */     GREY_5_ARROWS(14, 5, "5ArrowsGray"),
/* 57 */     RATINGS_5(15, 5, "5Rating"),
/* 58 */     QUARTERS_5(16, 5, "5Quarters");
/*    */     
/* 60 */     protected static final IconSet DEFAULT_ICONSET = GYR_3_TRAFFIC_LIGHTS;
/*    */     public final int id;
/*    */     public final int num;
/*    */     public final String name;
/*    */     
/*    */     static {
/*    */     
/*    */     }
/*    */     
/*    */     public String toString() {
/* 70 */       return this.id + " - " + this.name;
/*    */     }
/*    */     
/*    */     public static IconSet byId(int param1Int) {
/* 74 */       return values()[param1Int];
/*    */     }
/*    */     public static IconSet byName(String param1String) {
/* 77 */       for (IconSet iconSet : values()) {
/* 78 */         if (iconSet.name.equals(param1String)) return iconSet; 
/*    */       } 
/* 80 */       return null;
/*    */     }
/*    */     
/*    */     IconSet(int param1Int1, int param1Int2, String param1String1) {
/* 84 */       this.id = param1Int1; this.num = param1Int2; this.name = param1String1;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\IconMultiStateFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */