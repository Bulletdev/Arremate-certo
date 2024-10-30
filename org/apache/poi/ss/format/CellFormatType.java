/*    */ package org.apache.poi.ss.format;
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
/*    */ public enum CellFormatType
/*    */ {
/* 28 */   GENERAL {
/*    */     CellFormatter formatter(String param1String) {
/* 30 */       return new CellGeneralFormatter();
/*    */     }
/*    */     boolean isSpecial(char param1Char) {
/* 33 */       return false;
/*    */     }
/*    */   },
/*    */   
/* 37 */   NUMBER {
/*    */     boolean isSpecial(char param1Char) {
/* 39 */       return false;
/*    */     }
/*    */     CellFormatter formatter(String param1String) {
/* 42 */       return new CellNumberFormatter(param1String);
/*    */     }
/*    */   },
/*    */   
/* 46 */   DATE {
/*    */     boolean isSpecial(char param1Char) {
/* 48 */       return (param1Char == '\'' || (param1Char <= '' && Character.isLetter(param1Char)));
/*    */     }
/*    */     CellFormatter formatter(String param1String) {
/* 51 */       return new CellDateFormatter(param1String);
/*    */     }
/*    */   },
/*    */   
/* 55 */   ELAPSED {
/*    */     boolean isSpecial(char param1Char) {
/* 57 */       return false;
/*    */     }
/*    */     CellFormatter formatter(String param1String) {
/* 60 */       return new CellElapsedFormatter(param1String);
/*    */     }
/*    */   },
/*    */   
/* 64 */   TEXT {
/*    */     boolean isSpecial(char param1Char) {
/* 66 */       return false;
/*    */     }
/*    */     CellFormatter formatter(String param1String) {
/* 69 */       return new CellTextFormatter(param1String);
/*    */     }
/*    */   };
/*    */   
/*    */   abstract boolean isSpecial(char paramChar);
/*    */   
/*    */   abstract CellFormatter formatter(String paramString);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\format\CellFormatType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */